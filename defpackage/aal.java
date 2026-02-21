package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class aal {
    public static boolean a() {
        return a(11);
    }

    private static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static boolean b() {
        return a(13);
    }

    public static boolean c() {
        return a(14);
    }

    public static boolean d() {
        return a(16);
    }

    public static boolean e() {
        return a(17);
    }

    public static boolean f() {
        return a(19);
    }

    public static boolean g() {
        return a(20);
    }

    @Deprecated
    public static boolean h() {
        return i();
    }

    public static boolean i() {
        return a(21);
    }
}
