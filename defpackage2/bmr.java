package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class bmr<Params, Progress, Result> {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int d = a + 1;
    private static final int e = (a * 2) + 1;
    private static final ThreadFactory f = new ThreadFactory() { // from class: bmr.1
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(Allocation.USAGE_SHARED);
    public static final Executor b = new ThreadPoolExecutor(d, e, 1, TimeUnit.SECONDS, g, f);
    public static final Executor c = new c();
    private static final b h = new b();
    private static volatile Executor i = c;
    private volatile d l = d.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();
    private final e<Params, Result> j = new e<Params, Result>() { // from class: bmr.2
        @Override // java.util.concurrent.Callable
        public Result call() {
            bmr.this.n.set(true);
            Process.setThreadPriority(10);
            return (Result) bmr.this.e(bmr.this.a((Object[]) this.b));
        }
    };
    private final FutureTask<Result> k = new FutureTask<Result>(this.j) { // from class: bmr.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                bmr.this.d(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException e3) {
                bmr.this.d(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occured while executing doInBackground()", e4.getCause());
            }
        }
    };

    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result a(Params... paramsArr);

    static class c implements Executor {
        final LinkedList<Runnable> a;
        Runnable b;

        private c() {
            this.a = new LinkedList<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() { // from class: bmr.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable runnablePoll = this.a.poll();
            this.b = runnablePoll;
            if (runnablePoll != null) {
                bmr.b.execute(this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Result result) {
        if (!this.n.get()) {
            e(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result e(Result result) {
        h.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    public final d j_() {
        return this.l;
    }

    protected void a() {
    }

    protected void a(Result result) {
    }

    protected void b(Progress... progressArr) {
    }

    protected void b(Result result) {
        k_();
    }

    protected void k_() {
    }

    public final boolean e() {
        return this.m.get();
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.k.cancel(z);
    }

    public final bmr<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.l != d.PENDING) {
            switch (this.l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.l = d.RUNNING;
        a();
        this.j.b = paramsArr;
        executor.execute(this.k);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Result result) {
        if (e()) {
            b(result);
        } else {
            a(result);
        }
        this.l = d.FINISHED;
    }

    static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.a.f(aVar.b[0]);
                    break;
                case 2:
                    aVar.a.b((Object[]) aVar.b);
                    break;
            }
        }
    }

    static abstract class e<Params, Result> implements Callable<Result> {
        Params[] b;

        private e() {
        }
    }

    static class a<Data> {
        final bmr a;
        final Data[] b;

        a(bmr bmrVar, Data... dataArr) {
            this.a = bmrVar;
            this.b = dataArr;
        }
    }
}
