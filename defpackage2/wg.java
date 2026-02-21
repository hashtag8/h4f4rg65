package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class wg {
    public static aaf a(Context context) {
        return a(context, null);
    }

    public static aaf a(Context context, abq abqVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (abqVar == null) {
            abqVar = Build.VERSION.SDK_INT >= 9 ? new abr() : new abo(AndroidHttpClient.newInstance(str));
        }
        aaf aafVar = new aaf(new abn(file), new abl(abqVar));
        aafVar.a();
        return aafVar;
    }
}
