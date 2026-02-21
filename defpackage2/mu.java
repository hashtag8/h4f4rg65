package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import defpackage.bmf;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class mu extends bln<Boolean> {
    boolean a = false;
    ns b;

    public void a(bmf.a aVar) {
        if (this.b != null) {
            this.b.a(aVar.a(), aVar.b());
        }
    }

    @Override // defpackage.bln
    @SuppressLint({"NewApi"})
    protected boolean b_() {
        long jLastModified;
        boolean z = false;
        try {
            Context contextR = r();
            PackageManager packageManager = contextR.getPackageManager();
            String packageName = contextR.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String string = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                jLastModified = packageInfo.firstInstallTime;
            } else {
                jLastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.b = ns.a(this, contextR, q(), string, str, jLastModified);
            this.b.b();
            this.a = new bmk().b(contextR);
            z = true;
            return true;
        } catch (Exception e) {
            blh.h().e("Answers", "Error retrieving app properties", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bln
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() {
        boolean z;
        try {
            boy boyVarB = bov.a().b();
            if (boyVarB == null) {
                blh.h().e("Answers", "Failed to retrieve settings");
                z = false;
            } else if (boyVarB.d.d) {
                blh.h().a("Answers", "Analytics collection enabled");
                this.b.a(boyVarB.e, e());
                z = true;
            } else {
                blh.h().a("Answers", "Analytics collection disabled");
                this.b.c();
                z = false;
            }
            return z;
        } catch (Exception e) {
            blh.h().e("Answers", "Error dealing with settings", e);
            return false;
        }
    }

    @Override // defpackage.bln
    public String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    @Override // defpackage.bln
    public String a() {
        return "1.4.1.19";
    }

    String e() {
        return bme.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
