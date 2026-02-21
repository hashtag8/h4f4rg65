package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class bqj extends bpz {
    public bqj(Activity activity, int i) {
        super(activity, i);
    }

    @Override // defpackage.bpz, net.simonvt.menudrawer.MenuDrawer
    protected void a(Context context, AttributeSet attributeSet, int i) {
        super.a(context, attributeSet, i);
        super.addView(this.C, -1, new ViewGroup.LayoutParams(-1, -1));
        super.addView(this.D, -1, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(boolean z) {
        int i;
        switch (getPosition()) {
            case LEFT:
            case TOP:
                i = this.E;
                break;
            case RIGHT:
            case BOTTOM:
                i = -this.E;
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
                case TOP:
                case BOTTOM:
                    this.D.setTranslationY(i);
                    break;
                case RIGHT:
                default:
                    this.D.setTranslationX(i);
                    break;
            }
        } else {
            switch (getPosition()) {
                case TOP:
                case BOTTOM:
                    this.D.offsetTopAndBottom(i - this.D.getTop());
                    break;
                case RIGHT:
                default:
                    this.D.offsetLeftAndRight(i - this.D.getLeft());
                    break;
            }
        }
        c(i);
        invalidate();
    }

    @Override // defpackage.bpz
    protected void h() {
        switch (getPosition()) {
            case RIGHT:
            case BOTTOM:
                this.j.a(0, 0, (-this.E) / 3, 0, 5000);
                break;
            default:
                this.j.a(0, 0, this.E / 3, 0, 5000);
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
    public void a(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i = (int) this.W;
        float fAbs = Math.abs(this.W) / this.E;
        switch (getPosition()) {
            case LEFT:
                this.t.setBounds(0, 0, i, height);
                break;
            case TOP:
                this.t.setBounds(0, 0, width, i);
                break;
            case RIGHT:
                this.t.setBounds(i + width, 0, width, height);
                break;
            case BOTTOM:
                this.t.setBounds(0, i + height, width, height);
                break;
        }
        this.t.setAlpha((int) (185.0f * (1.0f - fAbs)));
        this.t.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (q) {
            this.D.layout(0, 0, i5, i6);
        } else {
            int i7 = (int) this.W;
            if (getPosition() == bqe.LEFT || getPosition() == bqe.RIGHT) {
                this.D.layout(i7, 0, i5 + i7, i6);
            } else {
                this.D.layout(0, i7, i5, i6 + i7);
            }
        }
        switch (getPosition()) {
            case LEFT:
                this.C.layout(0, 0, this.E, i6);
                break;
            case TOP:
                this.C.layout(0, 0, i5, this.E);
                break;
            case RIGHT:
                this.C.layout(i5 - this.E, 0, i5, i6);
                break;
            case BOTTOM:
                this.C.layout(0, i6 - this.E, i5, i6);
                break;
        }
    }

    private void c(int i) {
        if (this.m && this.E != 0) {
            int width = getWidth();
            int height = getHeight();
            int i2 = this.E;
            int iAbs = (int) (((int) (this.W / Math.abs(this.W))) * (1.0f - (Math.abs(this.W) / i2)) * i2 * (-0.25f));
            switch (getPosition()) {
                case LEFT:
                    if (q) {
                        if (i > 0) {
                            this.C.setTranslationX(iAbs);
                        } else {
                            this.C.setTranslationX(-i2);
                        }
                    } else {
                        this.C.offsetLeftAndRight(iAbs - this.C.getLeft());
                        this.C.setVisibility(i != 0 ? 0 : 4);
                    }
                    break;
                case TOP:
                    if (q) {
                        if (i > 0) {
                            this.C.setTranslationY(iAbs);
                        } else {
                            this.C.setTranslationY(-i2);
                        }
                    } else {
                        this.C.offsetTopAndBottom(iAbs - this.C.getTop());
                        this.C.setVisibility(i != 0 ? 0 : 4);
                    }
                    break;
                case RIGHT:
                    if (q) {
                        if (i != 0) {
                            this.C.setTranslationX(iAbs);
                        } else {
                            this.C.setTranslationX(i2);
                        }
                    } else {
                        this.C.offsetLeftAndRight(iAbs - (this.C.getRight() - width));
                        this.C.setVisibility(i != 0 ? 0 : 4);
                    }
                    break;
                case BOTTOM:
                    if (q) {
                        if (i != 0) {
                            this.C.setTranslationY(iAbs);
                        } else {
                            this.C.setTranslationY(i2);
                        }
                    } else {
                        this.C.offsetTopAndBottom(iAbs - (this.C.getBottom() - height));
                        this.C.setVisibility(i != 0 ? 0 : 4);
                    }
                    break;
            }
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
            case TOP:
            case BOTTOM:
                childMeasureSpec = getChildMeasureSpec(i, 0, size);
                childMeasureSpec2 = getChildMeasureSpec(i2, 0, this.E);
                break;
            case RIGHT:
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
            case LEFT:
                return bqm.a(this.D) < i;
            case TOP:
                return bqm.b(this.D) < i2;
            case RIGHT:
                return bqm.c(this.D) > i;
            case BOTTOM:
                return bqm.d(this.D) > i2;
            default:
                return false;
        }
    }

    protected boolean b(int i, int i2) {
        switch (getPosition()) {
            case LEFT:
                if ((!this.F && this.e <= this.I) || (this.F && this.e >= this.W)) {
                    break;
                }
                break;
            case TOP:
                if ((!this.F && this.f <= this.I) || (this.F && this.f >= this.W)) {
                    break;
                }
                break;
            case RIGHT:
                int width = getWidth();
                int i3 = (int) this.e;
                if ((!this.F && i3 >= width - this.I) || (this.F && i3 <= width + this.W)) {
                    break;
                }
                break;
            case BOTTOM:
                int height = getHeight();
                if ((!this.F && this.f >= height - this.I) || (this.F && this.f <= height + this.W)) {
                    break;
                }
                break;
        }
        return false;
    }

    protected boolean a(int i, int i2, float f, float f2) {
        switch (getPosition()) {
            case LEFT:
                if ((!this.F && this.e <= this.I && f > 0.0f) || (this.F && i >= this.W)) {
                    break;
                }
                break;
            case TOP:
                if ((!this.F && this.f <= this.I && f2 > 0.0f) || (this.F && i2 >= this.W)) {
                    break;
                }
                break;
            case RIGHT:
                int width = getWidth();
                if ((!this.F && this.e >= width - this.I && f < 0.0f) || (this.F && i <= width + this.W)) {
                    break;
                }
                break;
            case BOTTOM:
                int height = getHeight();
                if ((!this.F && this.f >= height - this.I && f2 < 0.0f) || (this.F && i2 <= height + this.W)) {
                    break;
                }
                break;
        }
        return false;
    }

    protected void a(float f, float f2) {
        switch (getPosition()) {
            case LEFT:
                setOffsetPixels(Math.min(Math.max(this.W + f, 0.0f), this.E));
                break;
            case TOP:
                setOffsetPixels(Math.min(Math.max(this.W + f2, 0.0f), this.E));
                break;
            case RIGHT:
                setOffsetPixels(Math.max(Math.min(this.W + f, 0.0f), -this.E));
                break;
            case BOTTOM:
                setOffsetPixels(Math.max(Math.min(this.W + f2, 0.0f), -this.E));
                break;
        }
    }

    protected void c(int i, int i2) {
        int i3 = (int) this.W;
        switch (getPosition()) {
            case LEFT:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iA = (int) a(this.k);
                    this.g = i;
                    a(iA > 0 ? this.E : 0, iA, true);
                    break;
                } else if (this.F && i > i3) {
                    n();
                    break;
                }
                break;
            case TOP:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iB = (int) b(this.k);
                    this.h = i2;
                    a(iB > 0 ? this.E : 0, iB, true);
                    break;
                } else if (this.F && i2 > i3) {
                    n();
                    break;
                }
                break;
            case RIGHT:
                int width = getWidth();
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iA2 = (int) a(this.k);
                    this.g = i;
                    a(iA2 <= 0 ? -this.E : 0, iA2, true);
                    break;
                } else if (this.F && i < width + i3) {
                    n();
                    break;
                }
                break;
            case BOTTOM:
                if (this.c) {
                    this.k.computeCurrentVelocity(1000, this.l);
                    int iB2 = (int) b(this.k);
                    this.h = i2;
                    a(iB2 < 0 ? -this.E : 0, iB2, true);
                    break;
                } else if (this.F && i2 < getHeight() + i3) {
                    n();
                    break;
                }
                break;
        }
    }

    protected boolean b(float f, float f2) {
        switch (getPosition()) {
            case TOP:
            case BOTTOM:
                if (Math.abs(f2) <= this.a || Math.abs(f2) <= Math.abs(f)) {
                }
                break;
            case RIGHT:
            default:
                if (Math.abs(f) <= this.a || Math.abs(f) <= Math.abs(f2)) {
                }
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
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
                    if (b(f, f2)) {
                        if (this.Q != null && ((this.J == 2 || this.F) && a((int) f, (int) f2, (int) x2, (int) y2))) {
                            d();
                            requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                        if (a((int) x2, (int) y2, f, f2)) {
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
                    b();
                }
                break;
            case 1:
            case 3:
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
