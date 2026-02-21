package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class xw implements aao {
    private final Executor a;

    class a implements Runnable {
        private final aac b;
        private final aan c;
        private final Runnable d;

        public a(aac aacVar, aan aanVar, Runnable runnable) {
            this.b = aacVar;
            this.c = aanVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.g()) {
                this.b.c("canceled-at-delivery");
                return;
            }
            if (this.c.a()) {
                this.b.a(this.c.a);
            } else {
                this.b.b(this.c.c);
            }
            if (this.c.d) {
                this.b.b("intermediate-response");
            } else {
                this.b.c("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }

    public xw(final Handler handler) {
        this.a = new Executor() { // from class: xw.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // defpackage.aao
    public void a(aac<?> aacVar, aan<?> aanVar) {
        a(aacVar, aanVar, null);
    }

    @Override // defpackage.aao
    public void a(aac<?> aacVar, aan<?> aanVar, Runnable runnable) {
        aacVar.t();
        aacVar.b("post-response");
        this.a.execute(new a(aacVar, aanVar, runnable));
    }

    @Override // defpackage.aao
    public void a(aac<?> aacVar, abj abjVar) {
        aacVar.b("post-error");
        this.a.execute(new a(aacVar, aan.a(abjVar), null));
    }
}
