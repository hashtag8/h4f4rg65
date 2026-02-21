package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import net.simonvt.menudrawer.MenuDrawer;

/* JADX INFO: loaded from: classes.dex */
public abstract class bpz extends MenuDrawer {
    private static final Interpolator ab = new bqd();
    protected int a;
    private final Runnable ac;
    private Runnable ad;
    private bqg ae;
    protected final Runnable b;
    protected boolean c;
    protected int d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected long i;
    protected bqg j;
    protected VelocityTracker k;
    protected int l;
    protected boolean m;
    protected int n;
    protected boolean o;
    protected boolean p;

    protected abstract void h();

    bpz(Activity activity, int i) {
        super(activity, i);
        this.b = new Runnable() { // from class: bpz.1
            @Override // java.lang.Runnable
            public void run() {
                bpz.this.s();
            }
        };
        this.ac = new Runnable() { // from class: bpz.2
            @Override // java.lang.Runnable
            public void run() {
                bpz.this.r();
            }
        };
        this.d = -1;
        this.g = -1.0f;
        this.h = -1.0f;
        this.m = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Context context, AttributeSet attributeSet, int i) {
        super.a(context, attributeSet, i);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a = viewConfiguration.getScaledTouchSlop();
        this.l = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ae = new bqg(context, MenuDrawer.r);
        this.j = new bqg(context, ab);
        this.n = a(3);
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public boolean a() {
        return this.F;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setMenuSize(int i) {
        this.E = i;
        if (this.G == 8 || this.G == 4) {
            setOffsetPixels(this.E);
        }
        requestLayout();
        invalidate();
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setOffsetMenuEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            requestLayout();
            invalidate();
        }
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public boolean getOffsetMenuEnabled() {
        return this.m;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setHardwareLayerEnabled(boolean z) {
        if (z != this.K) {
            this.K = z;
            this.C.a(z);
            this.D.a(z);
            c();
        }
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public int getTouchMode() {
        return this.J;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setTouchMode(int i) {
        if (this.J != i) {
            this.J = i;
            o();
        }
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setTouchBezelSize(int i) {
        this.H = i;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public int getTouchBezelSize() {
        return this.H;
    }

    protected void b() {
        if (q && this.K && !this.p) {
            this.p = true;
            this.D.setLayerType(2, null);
            this.C.setLayerType(2, null);
        }
    }

    protected void c() {
        if (this.p) {
            this.p = false;
            this.D.setLayerType(0, null);
            this.C.setLayerType(0, null);
        }
    }

    protected void d() {
        this.c = false;
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    protected void e() {
        removeCallbacks(this.ac);
        this.ae.e();
        c();
    }

    private void q() {
        this.ae.e();
        int iC = this.ae.c();
        setOffsetPixels(iC);
        setDrawerState(iC == 0 ? 0 : 8);
        c();
    }

    protected void f() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        this.D.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    protected void a(int i, int i2, boolean z) {
        int iAbs;
        d();
        i();
        int i3 = i - ((int) this.W);
        if (i3 == 0 || !z) {
            setOffsetPixels(i);
            setDrawerState(i == 0 ? 0 : 8);
            c();
        } else {
            int iAbs2 = Math.abs(i2);
            if (iAbs2 > 0) {
                iAbs = Math.round(Math.abs(i3 / iAbs2) * 1000.0f) * 4;
            } else {
                iAbs = (int) (Math.abs(i3 / this.E) * 600.0f);
            }
            a(i, Math.min(iAbs, this.P));
        }
    }

    protected void a(int i, int i2) {
        int i3 = (int) this.W;
        int i4 = i - i3;
        if (i4 > 0) {
            setDrawerState(4);
            this.ae.a(i3, 0, i4, 0, i2);
        } else {
            setDrawerState(1);
            this.ae.a(i3, 0, i4, 0, i2);
        }
        b();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.ae.d()) {
            int i = (int) this.W;
            int iB = this.ae.b();
            if (iB != i) {
                setOffsetPixels(iB);
            }
            if (iB != this.ae.c()) {
                postOnAnimation(this.ac);
                return;
            }
        }
        q();
    }

    protected void g() {
        this.o = true;
        h();
        b();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.j.d()) {
            int i = (int) this.W;
            int iB = this.j.b();
            if (iB != i) {
                setOffsetPixels(iB);
            }
            if (!this.j.a()) {
                postOnAnimation(this.b);
                return;
            } else if (this.i > 0) {
                this.ad = new Runnable() { // from class: bpz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        bpz.this.g();
                    }
                };
                postDelayed(this.ad, this.i);
            }
        }
        t();
    }

    private void t() {
        this.j.e();
        setOffsetPixels(0.0f);
        setDrawerState(0);
        c();
        this.o = false;
    }

    protected void i() {
        removeCallbacks(this.ad);
        removeCallbacks(this.b);
        c();
        this.o = false;
    }

    protected boolean j() {
        return Math.abs(this.W) <= ((float) this.n);
    }

    protected boolean a(int i, int i2, int i3, int i4) {
        switch (getPosition()) {
            case LEFT:
            case RIGHT:
                if (!this.F) {
                    return a(this.D, false, i, i3 - bqm.a(this.D), i4 - bqm.b(this.D));
                }
                return a(this.C, false, i, i3 - bqm.a(this.C), i4 - bqm.b(this.D));
            case TOP:
            case BOTTOM:
                if (!this.F) {
                    return b(this.D, false, i2, i3 - bqm.a(this.D), i4 - bqm.b(this.D));
                }
                return b(this.C, false, i2, i3 - bqm.a(this.C), i4 - bqm.b(this.D));
            default:
                return false;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int left = childAt.getLeft() + c(childAt);
                int right = childAt.getRight() + c(childAt);
                int iB = b(childAt) + childAt.getTop();
                int bottom = childAt.getBottom() + b(childAt);
                if (i2 >= left && i2 < right && i3 >= iB && i3 < bottom && a(childAt, true, i, i2 - left, i3 - iB)) {
                    return true;
                }
            }
        }
        return z && this.Q.a(view, i, i2, i3);
    }

    protected boolean b(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int left = childAt.getLeft() + c(childAt);
                int right = childAt.getRight() + c(childAt);
                int iB = b(childAt) + childAt.getTop();
                int bottom = childAt.getBottom() + b(childAt);
                if (i2 >= left && i2 < right && i3 >= iB && i3 < bottom && b(childAt, true, i, i2 - left, i3 - iB)) {
                    return true;
                }
            }
        }
        return z && this.Q.a(view, i, i2, i3);
    }

    protected float a(VelocityTracker velocityTracker) {
        return Build.VERSION.SDK_INT >= 8 ? velocityTracker.getXVelocity(this.d) : velocityTracker.getXVelocity();
    }

    protected float b(VelocityTracker velocityTracker) {
        return Build.VERSION.SDK_INT >= 8 ? velocityTracker.getYVelocity(this.d) : velocityTracker.getYVelocity();
    }

    private int b(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return (int) view.getTranslationY();
        }
        return 0;
    }

    private int c(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return (int) view.getTranslationX();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Bundle bundle) {
        bundle.putBoolean("net.simonvt.menudrawer.MenuDrawer.menuVisible", this.G == 8 || this.G == 4);
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Parcelable parcelable) {
        super.a(parcelable);
        boolean z = ((Bundle) parcelable).getBoolean("net.simonvt.menudrawer.MenuDrawer.menuVisible");
        if (z) {
            a(false);
        } else {
            setOffsetPixels(0.0f);
        }
        this.G = z ? 8 : 0;
    }
}
