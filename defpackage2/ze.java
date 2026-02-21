package defpackage;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class ze {
    private static final ExecutorService a = Executors.newFixedThreadPool(10, a("Default"));
    private static final ExecutorService b = Executors.newFixedThreadPool(5, a("Loader"));

    private static ThreadFactory a(final String str) {
        return new ThreadFactory() { // from class: ze.4
            private final AtomicInteger b = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AdWorker(" + str + ") #" + this.b.getAndIncrement());
            }
        };
    }

    public static zm<Void> a(int i, final Runnable runnable) {
        return i == 1 ? a(b, new Callable<Void>() { // from class: ze.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        }) : a(a, new Callable<Void>() { // from class: ze.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    public static zm<Void> a(Runnable runnable) {
        return a(0, runnable);
    }

    public static <T> zm<T> a(ExecutorService executorService, final Callable<T> callable) {
        final zl zlVar = new zl();
        try {
            executorService.submit(new Runnable() { // from class: ze.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        zlVar.b(callable.call());
                    } catch (Exception e) {
                        sy.f().a((Throwable) e, true);
                        zlVar.cancel(true);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            su.c("Thread execution is rejected.", e);
            zlVar.cancel(true);
        }
        return zlVar;
    }
}
