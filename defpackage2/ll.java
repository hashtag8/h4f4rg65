package defpackage;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class ll extends Thread {
    private final BlockingQueue<lq<?>> a;
    private final lk b;
    private final lf c;
    private final lt d;
    private volatile boolean e = false;

    public ll(BlockingQueue<lq<?>> blockingQueue, lk lkVar, lf lfVar, lt ltVar) {
        this.a = blockingQueue;
        this.b = lkVar;
        this.c = lfVar;
        this.d = ltVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    @TargetApi(14)
    private void a(lq<?> lqVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(lqVar.b());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                lq<?> lqVarTake = this.a.take();
                try {
                    lqVarTake.a("network-queue-take");
                    if (lqVarTake.h()) {
                        lqVarTake.b("network-discard-cancelled");
                    } else {
                        a(lqVarTake);
                        ln lnVarA = this.b.a(lqVarTake);
                        lqVarTake.a("network-http-complete");
                        if (lnVarA.d && lqVarTake.w()) {
                            lqVarTake.b("not-modified");
                        } else {
                            ls<?> lsVarA = lqVarTake.a(lnVarA);
                            lqVarTake.a("network-parse-complete");
                            if (lqVarTake.r() && lsVarA.b != null) {
                                this.c.a(lqVarTake.f(), lsVarA.b);
                                lqVarTake.a("network-cache-written");
                            }
                            lqVarTake.v();
                            this.d.a(lqVarTake, lsVarA);
                        }
                    }
                } catch (lx e) {
                    e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    a(lqVarTake, e);
                } catch (Exception e2) {
                    ly.a(e2, "Unhandled exception %s", e2.toString());
                    lx lxVar = new lx(e2);
                    lxVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.d.a(lqVarTake, lxVar);
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
        }
    }

    private void a(lq<?> lqVar, lx lxVar) {
        this.d.a(lqVar, lqVar.a(lxVar));
    }
}
