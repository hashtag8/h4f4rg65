package defpackage;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class ahi {
    public static boolean a() {
        return a("android.permission.READ_EXTERNAL_STORAGE", ain.J);
    }

    public static boolean b() {
        return a("android.permission.READ_PHONE_STATE", ain.J);
    }

    public static void a(int i) {
        a("android.permission.READ_PHONE_STATE", ain.J, i);
    }

    private static boolean a(String str, Activity activity) {
        return Build.VERSION.SDK_INT < 23 || ci.a(activity, str) == 0;
    }

    private static void a(String str, Activity activity, int i) {
        if (!a(str, activity)) {
            if (at.a(activity, str)) {
                at.a(activity, new String[]{str}, i);
            } else {
                at.a(activity, new String[]{str}, i);
            }
        }
    }
}
