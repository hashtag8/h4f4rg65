package defpackage;

import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
public class aia implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;

    public aia(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Throwable th2 = th;
        while (th2 != null) {
            mm.b(th2.toString(), new Object[0]);
            StackTraceElement[] stackTrace = th2.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                mm.e("%s: %s (%s.%s) line %s", Integer.valueOf(i), stackTraceElement.getFileName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
            }
            Throwable cause = th2.getCause();
            if (cause != null) {
                mm.e("Caused by", new Object[0]);
            }
            th2 = cause;
        }
        if (this.a != null) {
            this.a.uncaughtException(thread, th);
        }
    }
}
