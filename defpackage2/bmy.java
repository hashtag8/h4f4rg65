package defpackage;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class bmy<V> extends FutureTask<V> implements bms<bnc>, bmz, bnc {
    final Object b;

    public bmy(Callable<V> callable) {
        super(callable);
        this.b = a(callable);
    }

    public bmy(Runnable runnable, V v) {
        super(runnable, v);
        this.b = a(runnable);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((bmz) a()).compareTo(obj);
    }

    @Override // defpackage.bms
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(bnc bncVar) {
        ((bms) ((bmz) a())).c(bncVar);
    }

    @Override // defpackage.bms
    public Collection<bnc> c() {
        return ((bms) ((bmz) a())).c();
    }

    @Override // defpackage.bms
    public boolean d() {
        return ((bms) ((bmz) a())).d();
    }

    @Override // defpackage.bmz
    public bmv b() {
        return ((bmz) a()).b();
    }

    @Override // defpackage.bnc
    public void b(boolean z) {
        ((bnc) ((bmz) a())).b(z);
    }

    @Override // defpackage.bnc
    public boolean f() {
        return ((bnc) ((bmz) a())).f();
    }

    @Override // defpackage.bnc
    public void a(Throwable th) {
        ((bnc) ((bmz) a())).a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lbms<Lbnc;>;:Lbmz;:Lbnc;>()TT; */
    public bms a() {
        return (bms) this.b;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lbms<Lbnc;>;:Lbmz;:Lbnc;>(Ljava/lang/Object;)TT; */
    protected bms a(Object obj) {
        return bna.a(obj) ? (bms) obj : new bna();
    }
}
