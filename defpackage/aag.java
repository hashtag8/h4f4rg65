package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class aag {
    public static boolean a() {
        return vl.a && aad.b() && aad.a() == Process.myUid();
    }

    public static boolean a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
