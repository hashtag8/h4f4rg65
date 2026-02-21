package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ly {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable(a, 2);

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.v(a, d(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, d(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(a, d(str, objArr), th);
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
            if (stackTrace[i].getClass().equals(ly.class)) {
                i++;
            } else {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    static class a {
        public static final boolean a = ly.b;
        private final List<C0152a> b = new ArrayList();
        private boolean c = false;

        a() {
        }

        /* JADX INFO: renamed from: ly$a$a, reason: collision with other inner class name */
        static class C0152a {
            public final String a;
            public final long b;
            public final long c;

            public C0152a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new C0152a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long jA = a();
            if (jA > 0) {
                long j = this.b.get(0).c;
                ly.b("(%-4d ms) %s", Long.valueOf(jA), str);
                long j2 = j;
                for (C0152a c0152a : this.b) {
                    long j3 = c0152a.c;
                    ly.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0152a.b), c0152a.a);
                    j2 = j3;
                }
            }
        }

        protected void finalize() {
            if (!this.c) {
                a("Request on the loose");
                ly.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            return this.b.get(this.b.size() - 1).c - this.b.get(0).c;
        }
    }
}
