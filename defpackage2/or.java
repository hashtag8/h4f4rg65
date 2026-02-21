package defpackage;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class or {
    private final ExecutorService a;

    public or(ExecutorService executorService) {
        this.a = executorService;
    }

    <T> T a(Callable<T> callable) {
        T t = null;
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                t = this.a.submit(callable).get(4L, TimeUnit.SECONDS);
            } else {
                t = this.a.submit(callable).get();
            }
        } catch (RejectedExecutionException e) {
            blh.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
        } catch (Exception e2) {
            blh.h().e("CrashlyticsCore", "Failed to execute task.", e2);
        }
        return t;
    }

    Future<?> a(final Runnable runnable) {
        try {
            return this.a.submit(new Runnable() { // from class: or.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        blh.h().e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            blh.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> b(final Callable<T> callable) {
        try {
            return this.a.submit(new Callable<T>() { // from class: or.2
                @Override // java.util.concurrent.Callable
                public T call() {
                    try {
                        return (T) callable.call();
                    } catch (Exception e) {
                        blh.h().e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            blh.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
