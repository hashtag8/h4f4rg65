package defpackage;

import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class mq {
    private static mp c;
    private static ScheduledExecutorService d;
    private ExecutorService a = Executors.newFixedThreadPool(1);
    private static final mq b = new mq();
    private static Map<String, mo> e = new HashMap();

    private mq() {
    }

    public static mq a() {
        return b;
    }

    public static synchronized mp b() {
        if (c == null) {
            c = new mp(2, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: mq.1
                ThreadFactory a = Executors.defaultThreadFactory();

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    mm.b("Creating new thread for %s", mq.c);
                    return this.a.newThread(runnable);
                }
            });
        }
        return c;
    }

    public static synchronized mo a(String str) {
        mo moVar;
        moVar = e.get(str);
        if (moVar == null) {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            moVar = new mo(handlerThread.getLooper());
            e.put(str, moVar);
        }
        return moVar;
    }

    public static synchronized ScheduledExecutorService c() {
        if (d == null) {
            d = new ScheduledThreadPoolExecutor(1) { // from class: mq.2
                @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
                public ScheduledFuture<?> schedule(final Runnable runnable, long j, TimeUnit timeUnit) {
                    return super.schedule(new Runnable() { // from class: mq.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mq.b().execute(runnable);
                        }
                    }, j, timeUnit);
                }
            };
        }
        return d;
    }

    public void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
