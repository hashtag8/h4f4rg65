package defpackage;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class yv extends Thread {
    private final BlockingQueue<aac<?>> a;
    private final ym b;
    private final wl c;
    private final aao d;
    private volatile boolean e = false;

    public yv(BlockingQueue<aac<?>> blockingQueue, ym ymVar, wl wlVar, aao aaoVar) {
        this.a = blockingQueue;
        this.b = ymVar;
        this.c = wlVar;
        this.d = aaoVar;
    }

    private void a(aac<?> aacVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(aacVar.c());
        }
    }

    private void a(aac<?> aacVar, abj abjVar) {
        this.d.a(aacVar, aacVar.a(abjVar));
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                aac<?> aacVarTake = this.a.take();
                try {
                    aacVarTake.b("network-queue-take");
                    if (aacVarTake.g()) {
                        aacVarTake.c("network-discard-cancelled");
                    } else {
                        a(aacVarTake);
                        zo zoVarA = this.b.a(aacVarTake);
                        aacVarTake.b("network-http-complete");
                        if (zoVarA.d && aacVarTake.u()) {
                            aacVarTake.c("not-modified");
                        } else {
                            aan<?> aanVarA = aacVarTake.a(zoVarA);
                            aacVarTake.b("network-parse-complete");
                            if (aacVarTake.p() && aanVarA.b != null) {
                                this.c.a(aacVarTake.e(), aanVarA.b);
                                aacVarTake.b("network-cache-written");
                            }
                            aacVarTake.t();
                            this.d.a(aacVarTake, aanVarA);
                        }
                    }
                } catch (abj e) {
                    e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    a(aacVarTake, e);
                } catch (Exception e2) {
                    abk.a(e2, "Unhandled exception %s", e2.toString());
                    abj abjVar = new abj(e2);
                    abjVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.d.a(aacVarTake, abjVar);
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
