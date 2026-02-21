package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class su {
    public static void a(String str) {
        if (a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void a(String str, Throwable th) {
        if (a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean a() {
        return xb.R.c().booleanValue();
    }

    public static boolean a(int i) {
        return (i >= 5 || Log.isLoggable("Ads", i)) && (i != 2 || a());
    }

    public static void b(String str) {
        if (a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void b(String str, Throwable th) {
        if (a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void c(String str) {
        if (a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (a(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void d(String str) {
        if (a(2)) {
            Log.v("Ads", str);
        }
    }

    public static void e(String str) {
        if (a(5)) {
            Log.w("Ads", str);
        }
    }
}
