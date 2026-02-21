package defpackage;

import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class mp extends ThreadPoolExecutor {
    public mp(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    public mp(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public boolean a(final Runnable runnable) {
        execute(new FutureTask(new Callable<Void>() { // from class: mp.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        }));
        return true;
    }

    public boolean b(Runnable runnable) {
        if (Looper.myLooper() != null) {
            return a(runnable);
        }
        runnable.run();
        return true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            mm.e("Error running " + runnable, th);
        }
        if (runnable instanceof Future) {
            try {
                ((Future) runnable).get();
            } catch (Exception e) {
                mm.e("Error running thread pool task " + runnable, e);
            }
        }
    }
}
