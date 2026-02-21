package defpackage;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class kl extends RecyclerView.e {
    boolean h = true;

    public abstract boolean a(RecyclerView.v vVar);

    public abstract boolean a(RecyclerView.v vVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(RecyclerView.v vVar);

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean h(RecyclerView.v vVar) {
        return !this.h || vVar.o();
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = vVar.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (!vVar.r() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(vVar, i, i2, left, top);
        }
        return a(vVar);
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean b(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        return (cVar == null || (cVar.a == cVar2.a && cVar.b == cVar2.b)) ? b(vVar) : a(vVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean c(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar.a != cVar2.a || cVar.b != cVar2.b) {
            return a(vVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
        }
        j(vVar);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (vVar2.c()) {
            i = cVar.a;
            i2 = cVar.b;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        return a(vVar, vVar2, i3, i4, i, i2);
    }

    public final void i(RecyclerView.v vVar) {
        p(vVar);
        f(vVar);
    }

    public final void j(RecyclerView.v vVar) {
        t(vVar);
        f(vVar);
    }

    public final void k(RecyclerView.v vVar) {
        r(vVar);
        f(vVar);
    }

    public final void a(RecyclerView.v vVar, boolean z) {
        d(vVar, z);
        f(vVar);
    }

    public final void l(RecyclerView.v vVar) {
        o(vVar);
    }

    public final void m(RecyclerView.v vVar) {
        s(vVar);
    }

    public final void n(RecyclerView.v vVar) {
        q(vVar);
    }

    public final void b(RecyclerView.v vVar, boolean z) {
        c(vVar, z);
    }

    public void o(RecyclerView.v vVar) {
    }

    public void p(RecyclerView.v vVar) {
    }

    public void q(RecyclerView.v vVar) {
    }

    public void r(RecyclerView.v vVar) {
    }

    public void s(RecyclerView.v vVar) {
    }

    public void t(RecyclerView.v vVar) {
    }

    public void c(RecyclerView.v vVar, boolean z) {
    }

    public void d(RecyclerView.v vVar, boolean z) {
    }
}
