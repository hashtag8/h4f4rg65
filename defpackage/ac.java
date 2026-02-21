package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ac {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public ac(View view) {
        this.a = view;
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        c();
    }

    private void c() {
        fb.d(this.a, this.d - (this.a.getTop() - this.b));
        fb.e(this.a, this.e - (this.a.getLeft() - this.c));
    }

    public boolean a(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        c();
        return true;
    }

    public boolean b(int i) {
        if (this.e == i) {
            return false;
        }
        this.e = i;
        c();
        return true;
    }

    public int b() {
        return this.d;
    }
}
