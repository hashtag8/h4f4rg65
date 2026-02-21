package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class qj implements qi {
    private static final String a = qr.a().b();
    private static final String b = qr.a().c();
    private String c;
    private String d;
    private long e;
    private String f;
    private String g;
    private String h;

    public qj(Context context, String str) {
        this.c = null;
        this.d = null;
        this.e = 0L;
        this.g = "2.0";
        if (str == null) {
            throw new IllegalArgumentException("Valid apiKey and appId are needed to connect to Deezer services. Please register yourself as a Deezer dev at http://www.deezer.com/fr/developers/myapps");
        }
        this.f = str;
        if (context != null) {
            this.h = qt.b(context);
            try {
                this.d = qt.b(context.getPackageName());
            } catch (UnsupportedEncodingException e) {
                this.d = null;
            } catch (NoSuchAlgorithmException e2) {
                this.d = null;
            }
        }
    }

    public qj(String str) {
        this(null, str);
    }

    @Override // defpackage.qi
    public String a(ql qlVar) throws qk {
        Bundle bundleB = qlVar.b();
        if (bundleB.getString("output") == null) {
            bundleB.putString("output", "json");
        }
        if (bundleB.getString("imei") == null && this.h != null) {
            bundleB.putString("imei", this.h);
        }
        if (a()) {
            bundleB.putString("access_token", b());
        } else {
            bundleB.putString("radio_token", d());
        }
        String strA = qt.a(b + this.g + "/" + qlVar.a(), qlVar.c(), bundleB);
        if ("json".equals(bundleB.getString("output"))) {
            qt.a(strA);
        }
        return strA;
    }

    @Override // defpackage.qi
    public void a(long j) {
        this.e = j;
    }

    @Override // defpackage.qi
    public void a(Activity activity) {
        qt.a(activity);
        this.c = null;
        a(0L);
    }

    @Override // defpackage.qi
    public void a(Context context, String str) {
        this.h = qt.b(context);
        this.c = str;
    }

    @Override // defpackage.qi
    public boolean a() {
        return b() != null && (c() == 0 || System.currentTimeMillis() < c());
    }

    @Override // defpackage.qi
    public String b() {
        return this.c;
    }

    @Override // defpackage.qi
    public long c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }
}
