package defpackage;

import defpackage.bmr;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class bmw<Params, Progress, Result> extends bmr<Params, Progress, Result> implements bms<bnc>, bmz, bnc {
    private final bna a = new bna();

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), paramsArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return bmv.a(this, obj);
    }

    @Override // defpackage.bms
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(bnc bncVar) {
        if (j_() != bmr.d.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((bms) ((bmz) g())).c(bncVar);
    }

    @Override // defpackage.bms
    public Collection<bnc> c() {
        return ((bms) ((bmz) g())).c();
    }

    @Override // defpackage.bms
    public boolean d() {
        return ((bms) ((bmz) g())).d();
    }

    public bmv b() {
        return ((bmz) g()).b();
    }

    @Override // defpackage.bnc
    public void b(boolean z) {
        ((bnc) ((bmz) g())).b(z);
    }

    @Override // defpackage.bnc
    public boolean f() {
        return ((bnc) ((bmz) g())).f();
    }

    @Override // defpackage.bnc
    public void a(Throwable th) {
        ((bnc) ((bmz) g())).a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lbms<Lbnc;>;:Lbmz;:Lbnc;>()TT; */
    public bms g() {
        return this.a;
    }

    static class a<Result> implements Executor {
        private final Executor a;
        private final bmw b;

        public a(Executor executor, bmw bmwVar) {
            this.a = executor;
            this.b = bmwVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(new bmy<Result>(runnable, null) { // from class: bmw.a.1
                /* JADX WARN: Incorrect return type in method signature: <T::Lbms<Lbnc;>;:Lbmz;:Lbnc;>()TT; */
                @Override // defpackage.bmy
                public bms a() {
                    return a.this.b;
                }
            });
        }
    }
}
