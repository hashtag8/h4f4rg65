package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class brs {
    public static final a a = new a();

    public static <T> T a(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
        }
        return null;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean b(Object obj, Object obj2) {
        return !a(obj, obj2);
    }

    public static void a(StringBuffer stringBuffer, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        stringBuffer.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static <T extends Comparable<? super T>> int a(T t, T t2) {
        return a(t, t2, false);
    }

    public static <T extends Comparable<? super T>> int a(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return !z ? -1 : 1;
        }
        if (t2 == null) {
            return z ? -1 : 1;
        }
        return t.compareTo(t2);
    }

    public static class a implements Serializable {
        a() {
        }
    }
}
