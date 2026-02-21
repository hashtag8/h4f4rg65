package defpackage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jo {
    final b a;
    final a b = new a();
    final List<View> c = new ArrayList();

    public interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        RecyclerView.v b(View view);

        View b(int i);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    public jo(b bVar) {
        this.a = bVar;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.d(view);
        return true;
    }

    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    public void a(View view, int i, boolean z) {
        int iF;
        if (i < 0) {
            iF = this.a.a();
        } else {
            iF = f(i);
        }
        this.b.a(iF, z);
        if (z) {
            g(view);
        }
        this.a.a(view, iF);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int iA = this.a.a();
        int i2 = i;
        while (i2 < iA) {
            int iE = i - (i2 - this.b.e(i2));
            if (iE == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iE;
        }
        return -1;
    }

    public void a(View view) {
        int iA = this.a.a(view);
        if (iA >= 0) {
            if (this.b.d(iA)) {
                h(view);
            }
            this.a.a(iA);
        }
    }

    public void a(int i) {
        int iF = f(i);
        View viewB = this.a.b(iF);
        if (viewB != null) {
            if (this.b.d(iF)) {
                h(viewB);
            }
            this.a.a(iF);
        }
    }

    public View b(int i) {
        return this.a.b(f(i));
    }

    public void a() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.a.b();
    }

    public View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.v vVarB = this.a.b(view);
            if (vVarB.e() == i && !vVarB.o() && !vVarB.r()) {
                return view;
            }
        }
        return null;
    }

    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iF;
        if (i < 0) {
            iF = this.a.a();
        } else {
            iF = f(i);
        }
        this.b.a(iF, z);
        if (z) {
            g(view);
        }
        this.a.a(view, iF, layoutParams);
    }

    public int b() {
        return this.a.a() - this.c.size();
    }

    public int c() {
        return this.a.a();
    }

    public View d(int i) {
        return this.a.b(i);
    }

    public void e(int i) {
        int iF = f(i);
        this.b.d(iF);
        this.a.c(iF);
    }

    public int b(View view) {
        int iA = this.a.a(view);
        if (iA == -1 || this.b.c(iA)) {
            return -1;
        }
        return iA - this.b.e(iA);
    }

    public boolean c(View view) {
        return this.c.contains(view);
    }

    public void d(View view) {
        int iA = this.a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(iA);
        g(view);
    }

    public void e(View view) {
        int iA = this.a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.b.c(iA)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.b.b(iA);
        h(view);
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }

    public boolean f(View view) {
        int iA = this.a.a(view);
        if (iA == -1) {
            if (h(view)) {
            }
            return true;
        }
        if (this.b.c(iA)) {
            this.b.d(iA);
            if (!h(view)) {
            }
            this.a.a(iA);
            return true;
        }
        return false;
    }

    static class a {
        long a = 0;
        a b;

        a() {
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.b.a(i - 64);
            } else {
                this.a |= 1 << i;
            }
        }

        private void b() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void b(int i) {
            if (i >= 64) {
                if (this.b != null) {
                    this.b.b(i - 64);
                    return;
                }
                return;
            }
            this.a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            b();
            return this.b.c(i - 64);
        }

        void a() {
            this.a = 0L;
            if (this.b != null) {
                this.b.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.a = (((j ^ (-1)) & this.a) << 1) | (this.a & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.b != null) {
                b();
                this.b.a(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            this.a &= j ^ (-1);
            long j2 = j - 1;
            this.a = Long.rotateRight((j2 ^ (-1)) & this.a, 1) | (this.a & j2);
            if (this.b != null) {
                if (this.b.c(0)) {
                    a(63);
                }
                this.b.d(0);
                return z;
            }
            return z;
        }

        int e(int i) {
            if (this.b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.a & ((1 << i) - 1));
            }
            return this.b.e(i - 64) + Long.bitCount(this.a);
        }

        public String toString() {
            return this.b == null ? Long.toBinaryString(this.a) : this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }
}
