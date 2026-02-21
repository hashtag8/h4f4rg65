package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class asv {
    private static final Interpolator v = new Interpolator() { // from class: asv.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int a;
    private int b;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private gd q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private int c = -1;
    private final Runnable w = new Runnable() { // from class: asv.2
        @Override // java.lang.Runnable
        public void run() {
            asv.this.a(0);
        }
    };

    public static abstract class a {
        public abstract boolean a(View view, int i);

        public void a(int i) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
        }

        public void b(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void a(int i, int i2) {
        }

        public boolean b(int i) {
            return false;
        }

        public void b(int i, int i2) {
        }

        public int c(int i) {
            return i;
        }

        public int b(View view) {
            return 0;
        }

        public int a(View view) {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public int a(View view, int i, int i2) {
            return 0;
        }
    }

    public static asv a(ViewGroup viewGroup, a aVar) {
        return new asv(viewGroup.getContext(), viewGroup, aVar);
    }

    public static asv a(ViewGroup viewGroup, float f, a aVar) {
        asv asvVarA = a(viewGroup, aVar);
        asvVarA.b = (int) (asvVarA.b * (1.0f / f));
        return asvVarA;
    }

    private asv(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = gd.a(context, v);
    }

    public void a(float f) {
        this.n = f;
    }

    public int a() {
        return this.a;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.c = i;
        this.r.b(view, i);
        a(1);
    }

    public int b() {
        return this.b;
    }

    public void c() {
        this.c = -1;
        e();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public void d() {
        c();
        if (this.a == 2) {
            int iB = this.q.b();
            int iC = this.q.c();
            this.q.g();
            int iB2 = this.q.b();
            int iC2 = this.q.c();
            this.r.a(this.s, iB2, iC2, iB2 - iB, iC2 - iC);
        }
        a(0);
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.c = -1;
        return a(i, i2, 0, 0);
    }

    public boolean a(int i, int i2) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return a(i, i2, (int) fa.a(this.l, this.c), (int) fa.b(this.l, this.c));
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.g();
            a(0);
            return false;
        }
        this.q.a(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        a(2);
        return true;
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int iB = b(i3, (int) this.n, (int) this.m);
        int iB2 = b(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iB);
        int iAbs4 = Math.abs(iB2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        return (int) (((iB2 != 0 ? iAbs4 / i5 : iAbs2 / i6) * a(i2, iB2, this.r.a(view))) + ((iB != 0 ? iAbs3 / i5 : iAbs / i6) * a(i, iB, this.r.b(view))));
    }

    private int a(int i, int i2, int i3) {
        int iAbs;
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float fB = (b(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fB / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(iAbs, 600);
    }

    private int b(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private float a(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private float b(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    public boolean a(boolean z) {
        boolean zA;
        if (this.s == null) {
            return false;
        }
        if (this.a == 2) {
            boolean zF = this.q.f();
            int iB = this.q.b();
            int iC = this.q.c();
            int left = iB - this.s.getLeft();
            int top = iC - this.s.getTop();
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.r.a(this.s, iB, iC, left, top);
            }
            if (zF && iB == this.q.d() && iC == this.q.e()) {
                this.q.g();
                zA = this.q.a();
            } else {
                zA = zF;
            }
            if (!zA) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    a(0);
                }
            }
        }
        return this.a == 2;
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            a(0);
        }
    }

    private void e() {
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    private void b(int i) {
        if (this.d != null) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k &= (1 << i) ^ (-1);
        }
    }

    private void c(int i) {
        if (this.d == null || this.d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.d != null) {
                System.arraycopy(this.d, 0, fArr, 0, this.d.length);
                System.arraycopy(this.e, 0, fArr2, 0, this.e.length);
                System.arraycopy(this.f, 0, fArr3, 0, this.f.length);
                System.arraycopy(this.g, 0, fArr4, 0, this.g.length);
                System.arraycopy(this.h, 0, iArr, 0, this.h.length);
                System.arraycopy(this.i, 0, iArr2, 0, this.i.length);
                System.arraycopy(this.j, 0, iArr3, 0, this.j.length);
            }
            this.d = fArr;
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void a(float f, float f2, int i) {
        c(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = d((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void c(MotionEvent motionEvent) {
        int iC = ep.c(motionEvent);
        for (int i = 0; i < iC; i++) {
            int iB = ep.b(motionEvent, i);
            float fC = ep.c(motionEvent, i);
            float fD = ep.d(motionEvent, i);
            if (this.f != null && this.g != null) {
                this.f[iB] = fC;
                this.g[iB] = fD;
            }
        }
    }

    void a(int i) {
        if (this.a != i) {
            this.a = i;
            this.r.a(i);
            if (i == 0) {
                this.s = null;
            }
        }
    }

    boolean b(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view != null && this.r.a(view, i)) {
            this.c = i;
            a(view, i);
            return true;
        }
        return false;
    }

    public boolean a(MotionEvent motionEvent) {
        View viewC;
        View viewC2;
        int iA = ep.a(motionEvent);
        int iB = ep.b(motionEvent);
        if (iA == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (iA) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iB2 = ep.b(motionEvent, 0);
                a(x, y, iB2);
                View viewC3 = c((int) x, (int) y);
                if (viewC3 == this.s && this.a == 2) {
                    b(viewC3, iB2);
                }
                int i = this.h[iB2];
                if ((this.p & i) != 0) {
                    this.r.a(i & this.p, iB2);
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                int iC = ep.c(motionEvent);
                for (int i2 = 0; i2 < iC && this.d != null && this.e != null; i2++) {
                    int iB3 = ep.b(motionEvent, i2);
                    if (iB3 < this.d.length && iB3 < this.e.length) {
                        float fC = ep.c(motionEvent, i2);
                        float fD = ep.d(motionEvent, i2);
                        float f = fC - this.d[iB3];
                        float f2 = fD - this.e[iB3];
                        b(f, f2, iB3);
                        if (this.a == 1 || ((viewC = c((int) this.d[iB3], (int) this.e[iB3])) != null && a(viewC, f, f2) && b(viewC, iB3))) {
                            c(motionEvent);
                            break;
                        }
                    }
                }
                c(motionEvent);
                break;
            case 5:
                int iB4 = ep.b(motionEvent, iB);
                float fC2 = ep.c(motionEvent, iB);
                float fD2 = ep.d(motionEvent, iB);
                a(fC2, fD2, iB4);
                if (this.a == 0) {
                    int i3 = this.h[iB4];
                    if ((this.p & i3) != 0) {
                        this.r.a(i3 & this.p, iB4);
                    }
                } else if (this.a == 2 && (viewC2 = c((int) fC2, (int) fD2)) == this.s) {
                    b(viewC2, iB4);
                }
                break;
            case 6:
                b(ep.b(motionEvent, iB));
                break;
        }
        return this.a == 1;
    }

    public void b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int iA = ep.a(motionEvent);
        int iB = ep.b(motionEvent);
        if (iA == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (iA) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iB2 = ep.b(motionEvent, 0);
                View viewC = c((int) x, (int) y);
                a(x, y, iB2);
                b(viewC, iB2);
                int i3 = this.h[iB2];
                if ((this.p & i3) != 0) {
                    this.r.a(i3 & this.p, iB2);
                }
                break;
            case 1:
                if (this.a == 1) {
                    f();
                }
                c();
                break;
            case 2:
                if (this.a == 1) {
                    int iA2 = ep.a(motionEvent, this.c);
                    float fC = ep.c(motionEvent, iA2);
                    float fD = ep.d(motionEvent, iA2);
                    int i4 = (int) (fC - this.f[this.c]);
                    int i5 = (int) (fD - this.g[this.c]);
                    b(this.s.getLeft() + i4, this.s.getTop() + i5, i4, i5);
                    c(motionEvent);
                } else {
                    int iC = ep.c(motionEvent);
                    while (i2 < iC) {
                        int iB3 = ep.b(motionEvent, i2);
                        float fC2 = ep.c(motionEvent, i2);
                        float fD2 = ep.d(motionEvent, i2);
                        float f = fC2 - this.d[iB3];
                        float f2 = fD2 - this.e[iB3];
                        b(f, f2, iB3);
                        if (this.a != 1) {
                            View viewC2 = c((int) fC2, (int) fD2);
                            if (!a(viewC2, f, f2) || !b(viewC2, iB3)) {
                                i2++;
                            }
                        }
                        c(motionEvent);
                        break;
                    }
                    c(motionEvent);
                }
                break;
            case 3:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                c();
                break;
            case 5:
                int iB4 = ep.b(motionEvent, iB);
                float fC3 = ep.c(motionEvent, iB);
                float fD3 = ep.d(motionEvent, iB);
                a(fC3, fD3, iB4);
                if (this.a == 0) {
                    b(c((int) fC3, (int) fD3), iB4);
                    int i6 = this.h[iB4];
                    if ((this.p & i6) != 0) {
                        this.r.a(i6 & this.p, iB4);
                    }
                } else if (b((int) fC3, (int) fD3)) {
                    b(this.s, iB4);
                }
                break;
            case 6:
                int iB5 = ep.b(motionEvent, iB);
                if (this.a == 1 && iB5 == this.c) {
                    int iC2 = ep.c(motionEvent);
                    while (true) {
                        if (i2 >= iC2) {
                            i = -1;
                        } else {
                            int iB6 = ep.b(motionEvent, i2);
                            if (iB6 != this.c) {
                                if (c((int) ep.c(motionEvent, i2), (int) ep.d(motionEvent, i2)) == this.s && b(this.s, iB6)) {
                                    i = this.c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        f();
                    }
                }
                b(iB5);
                break;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = a(f, f2, i, 1) ? 1 : 0;
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        if (fAbs <= this.b && fAbs2 <= this.b) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.b(i2)) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.b(view) > 0;
        boolean z2 = this.r.a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
    }

    private void f() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(fa.a(this.l, this.c), this.n, this.m), a(fa.b(this.l, this.c), this.n, this.m));
    }

    private void b(int i, int i2, int i3, int i4) {
        int iB;
        int iA;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            iB = this.r.b(this.s, i, i3);
            this.s.offsetLeftAndRight(iB - left);
        } else {
            iB = i;
        }
        if (i4 != 0) {
            iA = this.r.a(this.s, i2, i4);
            this.s.offsetTopAndBottom(iA - top);
        } else {
            iA = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.r.a(this.s, iB, iA, iB - left, iA - top);
        }
    }

    public boolean b(int i, int i2) {
        return b(this.s, i, i2);
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View c(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int d(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }
}
