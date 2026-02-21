package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class abk {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable(a, 2);

    static class a {
        public static final boolean a = abk.b;
        private final List<C0000a> b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: renamed from: abk$a$a, reason: collision with other inner class name */
        static class C0000a {
            public final String a;
            public final long b;
            public final long c;

            public C0000a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        a() {
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            return this.b.get(this.b.size() - 1).c - this.b.get(0).c;
        }

        public synchronized void a(String str) {
            this.c = true;
            long jA = a();
            if (jA > 0) {
                long j = this.b.get(0).c;
                abk.b("(%-4d ms) %s", Long.valueOf(jA), str);
                long j2 = j;
                for (C0000a c0000a : this.b) {
                    long j3 = c0000a.c;
                    abk.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0000a.b), c0000a.a);
                    j2 = j3;
                }
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new C0000a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            abk.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.v(a, d(str, objArr));
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(a, d(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClass().equals(abk.class)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
