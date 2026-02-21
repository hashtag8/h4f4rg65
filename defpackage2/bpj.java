package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bpj {
    private bpj() {
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            a(str);
        }
    }

    private static void a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        throw ((IllegalArgumentException) a(new IllegalArgumentException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, bpj.class.getName());
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return t;
    }
}
