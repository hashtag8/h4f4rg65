package defpackage;

import android.os.Process;
import defpackage.lf;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class lg extends Thread {
    private static final boolean a = ly.b;
    private final BlockingQueue<lq<?>> b;
    private final BlockingQueue<lq<?>> c;
    private final lf d;
    private final lt e;
    private volatile boolean f = false;

    public lg(BlockingQueue<lq<?>> blockingQueue, BlockingQueue<lq<?>> blockingQueue2, lf lfVar, lt ltVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = lfVar;
        this.e = ltVar;
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (a) {
            ly.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                final lq<?> lqVarTake = this.b.take();
                try {
                    lqVarTake.a("cache-queue-take");
                    if (lqVarTake.h()) {
                        lqVarTake.b("cache-discard-canceled");
                    } else {
                        lf.a aVarA = this.d.a(lqVarTake.f());
                        if (aVarA == null) {
                            lqVarTake.a("cache-miss");
                            this.c.put(lqVarTake);
                        } else if (aVarA.a()) {
                            lqVarTake.a("cache-hit-expired");
                            lqVarTake.a(aVarA);
                            this.c.put(lqVarTake);
                        } else {
                            lqVarTake.a("cache-hit");
                            ls<?> lsVarA = lqVarTake.a(new ln(aVarA.a, aVarA.g));
                            lqVarTake.a("cache-hit-parsed");
                            if (!aVarA.b()) {
                                this.e.a(lqVarTake, lsVarA);
                            } else {
                                lqVarTake.a("cache-hit-refresh-needed");
                                lqVarTake.a(aVarA);
                                lsVarA.d = true;
                                this.e.a(lqVarTake, lsVarA, new Runnable() { // from class: lg.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            lg.this.c.put(lqVarTake);
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {
                    ly.a(e, "Unhandled exception %s", e.toString());
                }
            } catch (InterruptedException e2) {
                if (this.f) {
                    return;
                }
            }
        }
    }
}
