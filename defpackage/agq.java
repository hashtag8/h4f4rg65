package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import defpackage.lf;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class agq {
    public static lr a(Context context, me meVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (meVar == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                meVar = new mf();
            } else {
                meVar = new mc(AndroidHttpClient.newInstance(str));
            }
        }
        lr lrVar = new lr(new a(file, 15728640), new lz(meVar));
        lrVar.a();
        return lrVar;
    }

    static class a extends mb {
        public a(File file, int i) {
            super(file, i);
        }

        @Override // defpackage.mb, defpackage.lf
        public synchronized void a() {
            try {
                super.a();
            } catch (Throwable th) {
                mm.b("Could not initialize, retrying after clear", th);
                b();
                super.a();
            }
        }

        @Override // defpackage.mb, defpackage.lf
        public lf.a a(String str) {
            String str2;
            lf.a aVarA = super.a(str);
            if (aVarA != null) {
                if (aVarA.a()) {
                    str2 = " (expired)";
                } else {
                    str2 = aVarA.b() ? " (refresh needed)" : "";
                }
                mm.b("Returning cache%s, %s bytes for %s", str2, Integer.valueOf(aVarA.a != null ? aVarA.a.length : 0), str);
            }
            return aVarA;
        }
    }
}
