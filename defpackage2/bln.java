package defpackage;

import android.content.Context;
import java.io.File;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class bln<Result> implements Comparable<bln> {
    blh e;
    Context g;
    blk<Result> h;
    bml i;
    blm<Result> f = new blm<>(this);
    final bmu j = (bmu) getClass().getAnnotation(bmu.class);

    public abstract String a();

    public abstract String b();

    protected abstract Result f();

    void a(Context context, blh blhVar, blk<Result> blkVar, bml bmlVar) {
        this.e = blhVar;
        this.g = new bli(context, b(), t());
        this.h = blkVar;
        this.i = bmlVar;
    }

    final void p() {
        this.f.a(this.e.f(), (Object[]) new Void[]{(Void) null});
    }

    protected boolean b_() {
        return true;
    }

    protected void a(Result result) {
    }

    protected void b(Result result) {
    }

    protected bml q() {
        return this.i;
    }

    public Context r() {
        return this.g;
    }

    public blh s() {
        return this.e;
    }

    public String t() {
        return ".Fabric" + File.separator + b();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(bln blnVar) {
        if (b(blnVar)) {
            return 1;
        }
        if (blnVar.b((bln) this)) {
            return -1;
        }
        if (!u() || blnVar.u()) {
            return (u() || !blnVar.u()) ? 0 : -1;
        }
        return 1;
    }

    boolean b(bln blnVar) {
        if (!u()) {
            return false;
        }
        for (Class<?> cls : this.j.a()) {
            if (cls.isAssignableFrom(blnVar.getClass())) {
                return true;
            }
        }
        return false;
    }

    boolean u() {
        return this.j != null;
    }

    protected Collection<bnc> v() {
        return this.f.c();
    }
}
