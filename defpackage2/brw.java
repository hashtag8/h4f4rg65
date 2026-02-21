package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class brw {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static <T> T a(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        return t;
    }

    public static <T extends CharSequence> T a(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (t.length() == 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    public static <T extends CharSequence> T a(T t) {
        return (T) a((CharSequence) t, "The validated character sequence is empty", new Object[0]);
    }
}
