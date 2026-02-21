package defpackage;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class kf {
    protected final RecyclerView.h a;
    final Rect b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private kf(RecyclerView.h hVar) {
        this.c = Integer.MIN_VALUE;
        this.b = new Rect();
        this.a = hVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return f() - this.c;
    }

    public static kf a(RecyclerView.h hVar, int i) {
        switch (i) {
            case 0:
                return a(hVar);
            case 1:
                return b(hVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static kf a(RecyclerView.h hVar) {
        return new kf(hVar) { // from class: kf.1
            @Override // defpackage.kf
            public int d() {
                return this.a.x() - this.a.B();
            }

            @Override // defpackage.kf
            public int e() {
                return this.a.x();
            }

            @Override // defpackage.kf
            public void a(int i) {
                this.a.i(i);
            }

            @Override // defpackage.kf
            public int c() {
                return this.a.z();
            }

            @Override // defpackage.kf
            public int e(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.a.f(view) + iVar.leftMargin;
            }

            @Override // defpackage.kf
            public int f(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.a.g(view) + iVar.topMargin;
            }

            @Override // defpackage.kf
            public int b(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.a.j(view);
            }

            @Override // defpackage.kf
            public int a(View view) {
                return this.a.h(view) - ((RecyclerView.i) view.getLayoutParams()).leftMargin;
            }

            @Override // defpackage.kf
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            @Override // defpackage.kf
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            @Override // defpackage.kf
            public int f() {
                return (this.a.x() - this.a.z()) - this.a.B();
            }

            @Override // defpackage.kf
            public int g() {
                return this.a.B();
            }

            @Override // defpackage.kf
            public int h() {
                return this.a.v();
            }

            @Override // defpackage.kf
            public int i() {
                return this.a.w();
            }
        };
    }

    public static kf b(RecyclerView.h hVar) {
        return new kf(hVar) { // from class: kf.2
            @Override // defpackage.kf
            public int d() {
                return this.a.y() - this.a.C();
            }

            @Override // defpackage.kf
            public int e() {
                return this.a.y();
            }

            @Override // defpackage.kf
            public void a(int i) {
                this.a.j(i);
            }

            @Override // defpackage.kf
            public int c() {
                return this.a.A();
            }

            @Override // defpackage.kf
            public int e(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.a.g(view) + iVar.topMargin;
            }

            @Override // defpackage.kf
            public int f(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.a.f(view) + iVar.leftMargin;
            }

            @Override // defpackage.kf
            public int b(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.a.k(view);
            }

            @Override // defpackage.kf
            public int a(View view) {
                return this.a.i(view) - ((RecyclerView.i) view.getLayoutParams()).topMargin;
            }

            @Override // defpackage.kf
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            @Override // defpackage.kf
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            @Override // defpackage.kf
            public int f() {
                return (this.a.y() - this.a.A()) - this.a.C();
            }

            @Override // defpackage.kf
            public int g() {
                return this.a.C();
            }

            @Override // defpackage.kf
            public int h() {
                return this.a.w();
            }

            @Override // defpackage.kf
            public int i() {
                return this.a.v();
            }
        };
    }
}
