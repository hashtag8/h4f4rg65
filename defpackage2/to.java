package defpackage;

import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class to extends ud {
    public static boolean a;
    private AdvertisingIdClient.Info b;
    private final ty c;
    private String d;
    private boolean e;
    private Object f;

    to(uf ufVar) {
        super(ufVar);
        this.e = false;
        this.f = new Object();
        this.c = new ty(ufVar.d());
    }

    private static String a(String str) {
        MessageDigest messageDigestB = tz.b("MD5");
        if (messageDigestB == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestB.digest(str.getBytes())));
    }

    private boolean a(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String strC;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String strB = x().b();
        synchronized (this.f) {
            if (!this.e) {
                this.d = e();
                this.e = true;
            } else if (TextUtils.isEmpty(this.d)) {
                String id2 = info != null ? info.getId() : null;
                if (id2 == null) {
                    return g(id + strB);
                }
                this.d = a(id2 + strB);
            }
            String strA = a(id + strB);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            if (strA.equals(this.d)) {
                return true;
            }
            if (TextUtils.isEmpty(this.d)) {
                strC = strB;
            } else {
                b("Resetting the client id because Advertising Id changed.");
                strC = x().c();
                a("New client Id", strC);
            }
            return g(id + strC);
        }
    }

    private synchronized AdvertisingIdClient.Info f() {
        if (this.c.a(1000L)) {
            this.c.a();
            AdvertisingIdClient.Info infoD = d();
            if (a(this.b, infoD)) {
                this.b = infoD;
            } else {
                f("Failed to reset client id on adid change. Not using adid");
                this.b = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.b;
    }

    private boolean g(String str) {
        try {
            String strA = a(str);
            b("Storing hashed adid.");
            FileOutputStream fileOutputStreamOpenFileOutput = o().openFileOutput("gaClientIdData", 0);
            fileOutputStreamOpenFileOutput.write(strA.getBytes());
            fileOutputStreamOpenFileOutput.close();
            this.d = strA;
            return true;
        } catch (IOException e) {
            e("Error creating hash file", e);
            return false;
        }
    }

    @Override // defpackage.ud
    protected void a() {
    }

    public boolean b() {
        D();
        AdvertisingIdClient.Info infoF = f();
        return (infoF == null || infoF.isLimitAdTrackingEnabled()) ? false : true;
    }

    public String c() {
        D();
        AdvertisingIdClient.Info infoF = f();
        String id = infoF != null ? infoF.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    protected AdvertisingIdClient.Info d() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(o());
        } catch (IllegalStateException e) {
            e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (a) {
                return null;
            }
            a = true;
            d("Error getting advertiser id", th);
            return null;
        }
    }

    protected String e() {
        String str = null;
        try {
            FileInputStream fileInputStreamOpenFileInput = o().openFileInput("gaClientIdData");
            byte[] bArr = new byte[Allocation.USAGE_SHARED];
            int i = fileInputStreamOpenFileInput.read(bArr, 0, Allocation.USAGE_SHARED);
            if (fileInputStreamOpenFileInput.available() > 0) {
                e("Hash file seems corrupted, deleting it.");
                fileInputStreamOpenFileInput.close();
                o().deleteFile("gaClientIdData");
            } else if (i <= 0) {
                b("Hash file is empty.");
                fileInputStreamOpenFileInput.close();
            } else {
                String str2 = new String(bArr, 0, i);
                try {
                    fileInputStreamOpenFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    e = e2;
                    d("Error reading Hash file, deleting it", e);
                    o().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            e = e4;
        }
        return str;
    }
}
