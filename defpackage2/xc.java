package defpackage;

import android.os.Process;
import defpackage.wl;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class xc extends Thread {
    private static final boolean a = abk.b;
    private final BlockingQueue<aac<?>> b;
    private final BlockingQueue<aac<?>> c;
    private final wl d;
    private final aao e;
    private volatile boolean f = false;

    public xc(BlockingQueue<aac<?>> blockingQueue, BlockingQueue<aac<?>> blockingQueue2, wl wlVar, aao aaoVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = wlVar;
        this.e = aaoVar;
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (a) {
            abk.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                final aac<?> aacVarTake = this.b.take();
                aacVarTake.b("cache-queue-take");
                if (aacVarTake.g()) {
                    aacVarTake.c("cache-discard-canceled");
                } else {
                    wl.a aVarA = this.d.a(aacVarTake.e());
                    if (aVarA == null) {
                        aacVarTake.b("cache-miss");
                        this.c.put(aacVarTake);
                    } else if (aVarA.a()) {
                        aacVarTake.b("cache-hit-expired");
                        aacVarTake.a(aVarA);
                        this.c.put(aacVarTake);
                    } else {
                        aacVarTake.b("cache-hit");
                        aan<?> aanVarA = aacVarTake.a(new zo(aVarA.a, aVarA.g));
                        aacVarTake.b("cache-hit-parsed");
                        if (aVarA.b()) {
                            aacVarTake.b("cache-hit-refresh-needed");
                            aacVarTake.a(aVarA);
                            aanVarA.d = true;
                            this.e.a(aacVarTake, aanVarA, new Runnable() { // from class: xc.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        xc.this.c.put(aacVarTake);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.e.a(aacVarTake, aanVarA);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f) {
                    return;
                }
            }
        }
    }
}
