package defpackage;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class oz implements Thread.UncaughtExceptionHandler {
    private final a a;
    private final b b;
    private final boolean c;
    private final Thread.UncaughtExceptionHandler d;
    private final AtomicBoolean e = new AtomicBoolean(false);

    interface a {
        void a(b bVar, Thread thread, Throwable th, boolean z);
    }

    interface b {
        boy a();
    }

    public oz(a aVar, b bVar, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = aVar;
        this.b = bVar;
        this.c = z;
        this.d = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.e.set(true);
        try {
            this.a.a(this.b, thread, th, this.c);
        } catch (Exception e) {
            blh.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } finally {
            blh.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.d.uncaughtException(thread, th);
            this.e.set(false);
        }
    }

    boolean a() {
        return this.e.get();
    }
}
