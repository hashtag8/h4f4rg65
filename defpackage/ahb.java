package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public class ahb {
    private aha b;
    public int a = 0;
    private boolean c = false;

    public ahb(aha ahaVar) {
        this.b = ahaVar;
    }

    public void a(final asz aszVar, final Context context) {
        final String strA = aszVar.a();
        if (!TextUtils.isEmpty(strA)) {
            mq.b().execute(new Runnable() { // from class: ahb.1
                @Override // java.lang.Runnable
                public void run() {
                    InputStream inputStream;
                    int i;
                    try {
                        if (TextUtils.isEmpty(aszVar.e())) {
                            InputStream inputStreamOpen = context.getAssets().open(strA);
                            int iAvailable = inputStreamOpen.available();
                            mm.b("TEST_LOACAL_UPGRADE", "length=" + iAvailable);
                            inputStream = inputStreamOpen;
                            i = iAvailable;
                        } else {
                            InputStream inputStreamA = ahb.a(aszVar.e());
                            int iC = ahb.c(aszVar.e());
                            mm.b("TEST_LOACAL_UPGRADE", "length=" + iC);
                            inputStream = inputStreamA;
                            i = iC;
                        }
                        if (inputStream != null) {
                            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(strA, 0);
                            byte[] bArr = new byte[5120];
                            ahb.this.b();
                            int i2 = 0;
                            while (true) {
                                int i3 = inputStream.read(bArr);
                                if (i3 != -1) {
                                    fileOutputStreamOpenFileOutput.write(bArr, 0, i3);
                                    fileOutputStreamOpenFileOutput.flush();
                                    i2 += i3;
                                    ahb.this.a(i, i2);
                                } else {
                                    inputStream.close();
                                    fileOutputStreamOpenFileOutput.close();
                                    ahb.this.a();
                                    return;
                                }
                            }
                        }
                    } catch (IOException e) {
                        mm.b("Could not download file", e);
                        ahb.this.c();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (this.b != null) {
            this.b.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            this.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b != null) {
            ahz ahzVar = new ahz();
            ahzVar.a = this.a;
            this.b.a(ahzVar);
        }
    }

    public static InputStream a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        uRLConnectionOpenConnection.setConnectTimeout(10000);
        uRLConnectionOpenConnection.setReadTimeout(10000);
        return uRLConnectionOpenConnection.getInputStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return new URL(str).openConnection().getContentLength();
    }
}
