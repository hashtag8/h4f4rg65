package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public class aqp {
    private final Context a;

    public aqp(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
            int iC = aho.c("CURRENT_APP_VERSION");
            int i = packageInfo.versionCode;
            if (iC != i) {
                aho.a("LAST_APP_VERSION", iC);
                aho.a("CURRENT_APP_VERSION", i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            new ml().a(e.getMessage(), e);
        }
    }
}
