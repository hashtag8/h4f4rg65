package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class bqc extends bpz {
    private int ab;
    private Runnable ac;

    public bqc(Activity activity, int i) {
        super(activity, i);
        this.ac = new Runnable() { // from class: bqc.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                bqc.this.f();
                switch (AnonymousClass2.a[bqc.this.getPosition().ordinal()]) {
                    case 1:
                    case 2:
                        i2 = -bqc.this.ab;
                        break;
                    default:
                        i2 = bqc.this.ab;
                        break;
                }
                bqc.this.a(i2, 250);
            }
        };
    }

    @Override // defpackage.bpz, net.simonvt.menudrawer.MenuDrawer
    protected void a(Context context, AttributeSet attributeSet, int i) {
        super.a(context, attributeSet, i);
        super.addView(this.D, -1, new ViewGroup.LayoutParams(-1, -1));
        if (q) {
            this.D.setLayerType(0, null);
        }
        this.D.a(false);
        super.addView(this.C, -1, new ViewGroup.LayoutParams(-1, -1));
        this.ab = a(20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i = (int) this.W;
        float fAbs = Math.abs(this.W) / this.E;
        switch (getPosition()) {
            case RIGHT:
                this.t.setBounds(0, 0, width + i, height);
                break;
            case BOTTOM:
                this.t.setBounds(0, 0, width, height + i);
                break;
            case LEFT:
                this.t.setBounds(i, 0, width, height);
                break;
            case TOP:
                this.t.setBounds(0, i, width, height);
                break;
        }
        this.t.setAlpha((int) (185.0f * fAbs));
        this.t.draw(canvas);
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(boolean z) {
        int i;
        switch (getPosition()) {
            case RIGHT:
            case BOTTOM:
                i = -this.E;
                break;
            case LEFT:
            case TOP:
                i = this.E;
                break;
            default:
                i = 0;
                break;
        }
        a(i, 0, z);
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void b(boolean z) {
        a(0, 0, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void b(int i) {
        if (q) {
            switch (getPosition()) {
                case RIGHT:
                    this.C.setTranslationX(this.E + i);
                    break;
                case BOTTOM:
                    this.C.setTranslationY(this.E + i);
                    break;
                case LEFT:
                    this.C.setTranslationX(i - this.E);
                    break;
                case TOP:
                    this.C.setTranslationY(i - this.E);
                    break;
            }
        } else {
            switch (getPosition()) {
                case RIGHT:
                    this.C.offsetLeftAndRight(i - (this.C.getLeft() - getWidth()));
                    break;
                case BOTTOM:
                    this.C.offsetTopAndBottom(i - (this.C.getTop() - getHeight()));
                    break;
                case LEFT:
                    this.C.offsetLeftAndRight(i - this.C.getRight());
                    break;
                case TOP:
                    this.C.offsetTopAndBottom(i - this.C.getBottom());
                    break;
            }
        }
        invalidate();
    }

    @Override // defpackage.bpz
    protected void h() {
        switch (getPosition()) {
            case RIGHT:
            case BOTTOM:
                this.j.a(0, 0, -this.ab, 0, 5000);
                break;
            default:
                this.j.a(0, 0, this.ab, 0, 5000);
                break;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b((int) this.W);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public GradientDrawable.Orientation getDropShadowOrientation() {
        switch (getPosition()) {
            case RIGHT:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case BOTTOM:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case LEFT:
            default:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case TOP:
                return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void k() {
        int iAbs = (int) ((Math.abs(this.W) / this.E) * this.x);
        switch (getPosition()) {
            case RIGHT:
                this.V.top = 0;
                this.V.bottom = getHeight();
                this.V.right = bqm.a(this.C);
                this.V.left = this.V.right - iAbs;
                break;
            case BOTTOM:
                this.V.left = 0;
                this.V.right = getWidth();
                this.V.bottom = bqm.b(this.C);
                this.V.top = this.V.bottom - iAbs;
                break;
            case LEFT:
                this.V.top = 0;
                this.V.bottom = getHeight();
                this.V.left = bqm.c(this.C);
                this.V.right = iAbs + this.V.left;
                break;
            case TOP:
                this.V.left = 0;
                this.V.right = getWidth();
                this.V.top = bqm.d(this.C);
                this.V.bottom = iAbs + this.V.top;
                break;
        }
    }

    @Override // defpackage.bpz
    protected void b() {
        if (q && this.K && !this.p) {
            this.p = true;
            this.C.setLayerType(2, null);
        }
    }

    @Override // defpackage.bpz
    protected void c() {
        if (this.p) {
            this.p = false;
            this.C.setLayerType(0, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.D.layout(0, 0, i5, i6);
        if (q) {
            switch (getPosition()) {
                case RIGHT:
                    this.C.layout(i5 - this.E, 0, i5, i6);
                    break;
                case BOTTOM:
                    this.C.layout(0, i6 - this.E, i5, i6);
                    break;
                case LEFT:
                    this.C.layout(0, 0, this.E, i6);
                    break;
                case TOP:
                    this.C.layout(0, 0, i5, this.E);
                    break;
            }
        }
        int i7 = (int) this.W;
        int i8 = this.E;
        switch (getPosition()) {
            case RIGHT:
                this.C.layout(i5 + i7, 0, i5 + i8 + i7, i6);
                break;
            case BOTTOM:
                this.C.layout(0, i6 + i7, i5, i6 + i8 + i7);
                break;
            case LEFT:
                this.C.layout((-i8) + i7, 0, i7, i6);
                break;
            case TOP:
                this.C.layout(0, (-i8) + i7, i5, i7);
                break;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("Must measure with an exact size");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.W == -1.0f) {
            a(false);
        }
        switch (getPosition()) {
            case BOTTOM:
            case TOP:
                childMeasureSpec = getChildMeasureSpec(i, 0, size);
                childMeasureSpec2 = getChildMeasureSpec(i2, 0, this.E);
                break;
            case LEFT:
            default:
                childMeasureSpec = getChildMeasureSpec(i, 0, this.E);
                childMeasureSpec2 = getChildMeasureSpec(i, 0, size2);
                break;
        }
        this.C.measure(childMeasureSpec, childMeasureSpec2);
        this.D.measure(getChildMeasureSpec(i, 0, size), getChildMeasureSpec(i, 0, size2));
        setMeasuredDimension(size, size2);
        o();
    }

    private boolean d(int i, int i2) {
        switch (getPosition()) {
            case RIGHT:
                return bqm.a(this.C) > i;
            case BOTTOM:
                return bqm.b(this.C) > i2;
            case LEFT:
                return bqm.c(this.C) < i;
            case TOP:
                return bqm.d(this.C) < i2;
            default:
                return false;
        }
    }

    protected boolean b(int i, int i2) {
        switch (getPosition()) {
            case RIGHT:
                int width = getWidth();
                int i3 = (int) this.e;
                if ((!this.F && i3 >= width - this.I) || (this.F && i3 >= width + this.W)) {
                    break;
                }
                break;
            case BOTTOM:
                int height = getHeight();
                if ((!this.F && this.f >= height - this.I) || (this.F && this.f >= height + this.W)) {
                    break;
                }
                break;
            case LEFT:
                if ((!this.F && this.e <= this.I) || (this.F && this.e <= this.W)) {
                    break;
                }
                break;
            case TOP:
                if ((!this.F && this.f <= this.I) || (this.F && this.f <= this.W)) {
                    break;
                }
                break;
        }
        return false;
    }

    protected boolean a(int i, int i2, float f, float f2) {
        if (this.F && this.J == 2) {
            return true;
        }
        switch (getPosition()) {
            case RIGHT:
                int width = getWidth();
                return (!this.F && this.e >= ((float) (width - this.I)) && f < 0.0f) || (this.F && ((float) i) >= ((float) width) - this.W) || (Math.abs(this.W) <= ((float) this.ab) && this.F);
            case BOTTOM:
                int height = getHeight();
                return (!this.F && this.f >= ((float) (height - this.I)) && f2 < 0.0f) || (this.F && ((float) i) >= ((float) height) - this.W) || (Math.abs(this.W) <= ((float) this.ab) && this.F);
            case LEFT:
                return (!this.F && this.e <= ((float) this.I) && f > 0.0f) || (this.F && ((float) i) <= this.W) || (Math.abs(this.W) <= ((float) this.ab) && this.F);
            case TOP:
                return (!this.F && this.f <= ((float) this.I) && f2 > 0.0f) || (this.F && ((float) i) <= this.W) || (Math.abs(this.W) <= ((float) this.ab) && this.F);
            default:
                return false;
        }
    }

    protected void a(float f, float f2) {
        switch (getPosition()) {
            case RIGHT:
                setOffsetPixels(Math.max(Math.min(this.W + f, 0.0f), -this.E));
                break;
            case BOTTOM:
                setOffsetPixels(Math.max(Math.min(this.W + f2, 0.0f), -this.E));
                break;
            case LEFT:
                setOffsetPixels(Math.min(Math.max(this.W + f, 0.0f), this.E));
                break;
            case TOP:
                setOffsetPixels(Math.min(Math.max(this.W + f2, 0.0f), this.E));
                break;
        }
    }

    protected void c(int i, int i2) {
        switch (getPosition()) {
            case RIGHT:
                getWidth();
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iA = (int) a(this.k);
                    this.g = i;
                    a(iA <= 0 ? -this.E : 0, iA, true);
                } else if (this.F) {
                    n();
                }
                break;
            case BOTTOM:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iB = (int) b(this.k);
                    this.h = i2;
                    a(iB < 0 ? -this.E : 0, iB, true);
                } else if (this.F) {
                    n();
                }
                break;
            case LEFT:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iA2 = (int) a(this.k);
                    this.g = i;
                    a(iA2 > 0 ? this.E : 0, iA2, true);
                } else if (this.F) {
                    n();
                }
                break;
            case TOP:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iB2 = (int) b(this.k);
                    this.h = i2;
                    a(iB2 > 0 ? this.E : 0, iB2, true);
                } else if (this.F) {
                    n();
                }
                break;
        }
    }

    protected boolean b(float f, float f2) {
        switch (getPosition()) {
            case BOTTOM:
            case TOP:
                if (Math.abs(f2) <= this.a || Math.abs(f2) <= Math.abs(f)) {
                }
                break;
            case LEFT:
            default:
                if (Math.abs(f) <= this.a || Math.abs(f) <= Math.abs(f2)) {
                }
                break;
        }
        return true;
    }

    @Override // defpackage.bpz
    protected void e() {
        super.e();
        removeCallbacks(this.ac);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        removeCallbacks(this.ac);
        if (this.o) {
            i();
            a(0, 5000);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            removeCallbacks(this.ac);
            this.d = -1;
            this.c = false;
            if (this.k != null) {
                this.k.recycle();
                this.k = null;
            }
            if (Math.abs(this.W) > this.E / 2) {
                m();
                return false;
            }
            n();
            return false;
        }
        if (action == 0 && this.F && j()) {
            setOffsetPixels(0.0f);
            e();
            i();
            setDrawerState(0);
            this.c = false;
        }
        if (this.F) {
            if (this.d == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(this.d)) == -1) {
                iFindPointerIndex = 0;
            }
            if (d((int) motionEvent.getX(iFindPointerIndex), (int) motionEvent.getY(iFindPointerIndex))) {
                return true;
            }
        }
        if (!this.F && !this.c && this.J == 0) {
            return false;
        }
        if (action != 0 && this.c) {
            return true;
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.e = x;
                this.g = x;
                float y = motionEvent.getY();
                this.f = y;
                this.h = y;
                boolean zB = b((int) this.g, (int) this.h);
                this.d = motionEvent.getPointerId(0);
                if (zB) {
                    setDrawerState(this.F ? 8 : 0);
                    e();
                    i();
                    if (!this.F && this.e <= this.ab) {
                        postDelayed(this.ac, 160L);
                    }
                    this.c = false;
                }
                break;
            case 2:
                int i = this.d;
                if (i != -1) {
                    int iFindPointerIndex2 = motionEvent.findPointerIndex(i);
                    if (iFindPointerIndex2 == -1) {
                        this.c = false;
                        this.d = -1;
                        d();
                        b(true);
                        return false;
                    }
                    float x2 = motionEvent.getX(iFindPointerIndex2);
                    float f = x2 - this.g;
                    float y2 = motionEvent.getY(iFindPointerIndex2);
                    float f2 = y2 - this.h;
                    if (Math.abs(f) >= this.a || Math.abs(f2) >= this.a) {
                        removeCallbacks(this.ac);
                        i();
                    }
                    if (b(f, f2)) {
                        if (this.Q != null && ((this.J == 2 || this.F) && a((int) f, (int) f2, (int) x2, (int) y2))) {
                            d();
                            requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                        if (a((int) x2, (int) y2, f, f2)) {
                            i();
                            e();
                            setDrawerState(2);
                            this.c = true;
                            this.g = x2;
                            this.h = y2;
                        }
                    }
                }
                break;
            case 6:
                a(motionEvent);
                this.g = motionEvent.getX(motionEvent.findPointerIndex(this.d));
                this.h = motionEvent.getY(motionEvent.findPointerIndex(this.d));
                break;
        }
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
        this.k.addMovement(motionEvent);
        return this.c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.F && !this.c && this.J == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
        this.k.addMovement(motionEvent);
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.e = x;
                this.g = x;
                float y = motionEvent.getY();
                this.f = y;
                this.h = y;
                boolean zB = b((int) this.g, (int) this.h);
                this.d = motionEvent.getPointerId(0);
                if (zB) {
                    e();
                    i();
                    if (!this.F && this.g <= this.ab) {
                        postDelayed(this.ac, 160L);
                    }
                    b();
                }
                break;
            case 1:
            case 3:
                removeCallbacks(this.ac);
                int iFindPointerIndex = motionEvent.findPointerIndex(this.d);
                if (iFindPointerIndex == -1) {
                    iFindPointerIndex = 0;
                }
                c((int) motionEvent.getX(iFindPointerIndex), (int) motionEvent.getY(iFindPointerIndex));
                this.d = -1;
                this.c = false;
                break;
            case 2:
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.d);
                if (iFindPointerIndex2 == -1) {
                    this.c = false;
                    this.d = -1;
                    d();
                    b(true);
                    return false;
                }
                if (!this.c) {
                    float x2 = motionEvent.getX(iFindPointerIndex2);
                    float f = x2 - this.g;
                    float y2 = motionEvent.getY(iFindPointerIndex2);
                    float f2 = y2 - this.h;
                    if (b(f, f2)) {
                        if (a((int) x2, (int) y2, f, f2)) {
                            i();
                            e();
                            setDrawerState(2);
                            this.c = true;
                            this.g = x2;
                            this.h = y2;
                        } else {
                            this.e = x2;
                            this.f = y2;
                        }
                    }
                }
                if (this.c) {
                    b();
                    float x3 = motionEvent.getX(iFindPointerIndex2);
                    float f3 = x3 - this.g;
                    float y3 = motionEvent.getY(iFindPointerIndex2);
                    float f4 = y3 - this.h;
                    this.g = x3;
                    this.h = y3;
                    a(f3, f4);
                }
                break;
                break;
            case 5:
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                this.g = motionEvent.getX(action2);
                this.h = motionEvent.getY(action2);
                this.d = motionEvent.getPointerId(action2);
                break;
            case 6:
                a(motionEvent);
                this.g = motionEvent.getX(motionEvent.findPointerIndex(this.d));
                this.h = motionEvent.getY(motionEvent.findPointerIndex(this.d));
                break;
        }
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.d) {
            int i = actionIndex == 0 ? 1 : 0;
            this.g = motionEvent.getX(i);
            this.d = motionEvent.getPointerId(i);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }
}
