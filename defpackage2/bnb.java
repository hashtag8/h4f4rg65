package defpackage;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class bnb extends ThreadPoolExecutor {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = a + 1;
    private static final int c = (a * 2) + 1;

    <T extends Runnable & bms & bnc & bmz> bnb(int i, int i2, long j, TimeUnit timeUnit, bmt<T> bmtVar, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, bmtVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & bms & bnc & bmz> bnb a(int i, int i2) {
        return new bnb(i, i2, 1L, TimeUnit.SECONDS, new bmt(), new a(10));
    }

    public static bnb a() {
        return a(b, c);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new bmy(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new bmy(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (bna.a(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        bnc bncVar = (bnc) runnable;
        bncVar.b(true);
        bncVar.a(th);
        getQueue().d();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bmt getQueue() {
        return (bmt) super.getQueue();
    }

    public static final class a implements ThreadFactory {
        private final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.a);
            thread.setName("Queue");
            return thread;
        }
    }
}
