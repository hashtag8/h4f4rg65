package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class nd {
    private final ScheduledExecutorService c;
    private final List<a> d = new ArrayList();
    private volatile boolean e = true;
    final AtomicReference<ScheduledFuture<?>> a = new AtomicReference<>();
    boolean b = true;

    public interface a {
        void a();
    }

    public nd(ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
    }

    public void a(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(a aVar) {
        this.d.add(aVar);
    }

    public void a() {
        this.b = false;
        ScheduledFuture<?> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void b() {
        if (this.e && !this.b) {
            this.b = true;
            try {
                this.a.compareAndSet(null, this.c.schedule(new Runnable() { // from class: nd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nd.this.a.set(null);
                        nd.this.c();
                    }
                }, 5000L, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException e) {
                blh.h().a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
