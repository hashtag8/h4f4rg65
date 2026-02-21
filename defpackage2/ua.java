package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ua extends ud {
    protected String a;
    protected String b;
    protected boolean c;
    protected int d;
    protected boolean e;
    protected int f;
    protected boolean g;
    protected boolean h;

    public ua(uf ufVar) {
        super(ufVar);
    }

    private static int a(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    @Override // defpackage.ud
    protected void a() {
        j();
    }

    void a(tp tpVar) {
        int iA;
        b("Loading global XML config values");
        if (tpVar.a()) {
            String strB = tpVar.b();
            this.b = strB;
            b("XML config - app name", strB);
        }
        if (tpVar.c()) {
            String strD = tpVar.d();
            this.a = strD;
            b("XML config - app version", strD);
        }
        if (tpVar.e() && (iA = a(tpVar.f())) >= 0) {
            this.d = iA;
            a("XML config - log level", Integer.valueOf(iA));
        }
        if (tpVar.g()) {
            int iH = tpVar.h();
            this.f = iH;
            this.e = true;
            b("XML config - dispatch period (sec)", Integer.valueOf(iH));
        }
        if (tpVar.i()) {
            boolean zJ = tpVar.j();
            this.h = zJ;
            this.g = true;
            b("XML config - dry run", Boolean.valueOf(zJ));
        }
    }

    public String b() {
        D();
        return this.a;
    }

    public String c() {
        D();
        return this.b;
    }

    public boolean d() {
        D();
        return this.c;
    }

    public int e() {
        D();
        return this.d;
    }

    public boolean f() {
        D();
        return this.e;
    }

    public int g() {
        D();
        return this.f;
    }

    public boolean h() {
        D();
        return this.g;
    }

    public boolean i() {
        D();
        return this.h;
    }

    protected void j() {
        ApplicationInfo applicationInfo;
        int i;
        tp tpVarA;
        Context contextO = o();
        try {
            applicationInfo = contextO.getPackageManager().getApplicationInfo(contextO.getPackageName(), 129);
        } catch (PackageManager.NameNotFoundException e) {
            d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            e("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (tpVarA = new uz(k()).a(i)) == null) {
            return;
        }
        a(tpVarA);
    }
}
