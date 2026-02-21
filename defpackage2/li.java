package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class li implements lt {
    private final Executor a;

    public li(final Handler handler) {
        this.a = new Executor() { // from class: li.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // defpackage.lt
    public void a(lq<?> lqVar, ls<?> lsVar) {
        a(lqVar, lsVar, null);
    }

    @Override // defpackage.lt
    public void a(lq<?> lqVar, ls<?> lsVar, Runnable runnable) {
        lqVar.v();
        lqVar.a("post-response");
        this.a.execute(new a(lqVar, lsVar, runnable));
    }

    @Override // defpackage.lt
    public void a(lq<?> lqVar, lx lxVar) {
        lqVar.a("post-error");
        this.a.execute(new a(lqVar, ls.a(lxVar), null));
    }

    class a implements Runnable {
        private final lq b;
        private final ls c;
        private final Runnable d;

        public a(lq lqVar, ls lsVar, Runnable runnable) {
            this.b = lqVar;
            this.c = lsVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.h()) {
                this.b.b("canceled-at-delivery");
                return;
            }
            if (this.c.a()) {
                this.b.a(this.c.a);
            } else {
                this.b.b(this.c.c);
            }
            if (this.c.d) {
                this.b.a("intermediate-response");
            } else {
                this.b.b("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }
}
