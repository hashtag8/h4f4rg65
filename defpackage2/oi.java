package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
class oi {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static oi a(Context context, bml bmlVar, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strI = bmlVar.i();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new oi(str, str2, strI, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    oi(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }
}
