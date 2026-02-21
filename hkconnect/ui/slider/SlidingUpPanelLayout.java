package com.harman.hkconnect.ui.slider;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.ui.BottomPlayer;
import defpackage.aib;
import defpackage.asv;
import defpackage.beg;
import defpackage.ep;
import defpackage.fb;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpPanelLayout extends ViewGroup {
    private static final String a = SlidingUpPanelLayout.class.getSimpleName();
    private static d b = d.COLLAPSED;
    private static final int[] c = {R.attr.gravity};
    private float A;
    private c B;
    private final asv C;
    private boolean D;
    private final Rect E;
    private int F;
    private BottomPlayer G;
    private int d;
    private int e;
    private final Paint f;
    private final Drawable g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private View n;
    private int o;
    private View p;
    private View q;
    private d r;
    private d s;
    private float t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private float y;
    private float z;

    public interface c {
        void a(View view);

        void a(View view, float f);

        void b(View view);

        void c(View view);

        void d(View view);
    }

    public enum d {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class e implements c {
        @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
        public void a(View view, float f) {
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
        public void a(View view) {
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
        public void b(View view) {
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
        public void c(View view) {
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
        public void d(View view) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = HttpStatus.SC_BAD_REQUEST;
        this.e = -1728053248;
        this.f = new Paint();
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.l = false;
        this.m = true;
        this.o = -1;
        this.r = b;
        this.s = null;
        this.A = 1.0f;
        this.D = true;
        this.E = new Rect();
        if (isInEditMode()) {
            this.g = null;
            this.C = null;
            return;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
            if (typedArrayObtainStyledAttributes != null) {
                setGravity(typedArrayObtainStyledAttributes.getInt(0, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, aib.a.SlidingUpPanelLayout);
            if (typedArrayObtainStyledAttributes2 != null) {
                this.h = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1);
                this.i = typedArrayObtainStyledAttributes2.getDimensionPixelSize(1, -1);
                this.j = typedArrayObtainStyledAttributes2.getDimensionPixelSize(2, -1);
                this.d = typedArrayObtainStyledAttributes2.getInt(4, HttpStatus.SC_BAD_REQUEST);
                this.e = typedArrayObtainStyledAttributes2.getColor(3, -1728053248);
                this.o = typedArrayObtainStyledAttributes2.getResourceId(5, -1);
                this.l = typedArrayObtainStyledAttributes2.getBoolean(6, false);
                this.m = typedArrayObtainStyledAttributes2.getBoolean(7, true);
                this.A = typedArrayObtainStyledAttributes2.getFloat(8, 1.0f);
                this.r = d.values()[typedArrayObtainStyledAttributes2.getInt(9, b.ordinal())];
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        float f = context.getResources().getDisplayMetrics().density;
        if (this.h == -1) {
            this.h = (int) ((68.0f * f) + 0.5f);
        }
        if (this.i == -1) {
            this.i = (int) ((4.0f * f) + 0.5f);
        }
        if (this.j == -1) {
            this.j = (int) (0.0f * f);
        }
        if (this.i > 0) {
            if (this.k) {
                this.g = getResources().getDrawable(com.harman.hkconnect.R.drawable.above_shadow);
            } else {
                this.g = getResources().getDrawable(com.harman.hkconnect.R.drawable.below_shadow);
            }
        } else {
            this.g = null;
        }
        setWillNotDraw(false);
        this.C = asv.a(this, 1.0f, new a());
        this.C.a(f * this.d);
        this.w = true;
    }

    public void setBottomPlayer(BottomPlayer bottomPlayer) {
        this.G = bottomPlayer;
    }

    public void setHasSpeakers(boolean z) {
        this.v = !z;
    }

    public View getSlideableView() {
        return this.p;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.o != -1) {
            setDragView(findViewById(this.o));
        }
    }

    public void setGravity(int i) {
        if (i != 48 && i != 80) {
            throw new IllegalArgumentException("gravity must be set to either top or bottom");
        }
        this.k = i == 80;
        if (!this.D) {
            requestLayout();
        }
    }

    public void setCoveredFadeColor(int i) {
        this.e = i;
        invalidate();
    }

    public int getCoveredFadeColor() {
        return this.e;
    }

    public void setTouchEnabled(boolean z) {
        this.w = z;
    }

    public boolean a() {
        return (!this.w || this.p == null || this.r == d.HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.h = i;
            if (!this.D) {
                requestLayout();
            }
            if (getPanelState() == d.COLLAPSED) {
                b();
                invalidate();
            }
        }
    }

    public void b() {
        a(0.0f, 0);
    }

    public int getShadowHeight() {
        return this.i;
    }

    public void setShadowHeight(int i) {
        this.i = i;
        if (!this.D) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.h;
    }

    public int getCurrentParalaxOffset() {
        int iMax = (int) (this.j * Math.max(this.t, 0.0f));
        return this.k ? -iMax : iMax;
    }

    public void setParalaxOffset(int i) {
        this.j = i;
        if (!this.D) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.d;
    }

    public void setMinFlingVelocity(int i) {
        this.d = i;
    }

    public void setPanelSlideListener(c cVar) {
        this.B = cVar;
    }

    public void setDragView(View view) {
        if (this.n != null) {
            this.n.setOnClickListener(null);
        }
        this.n = view;
        if (this.n != null) {
            this.n.setClickable(true);
            this.n.setFocusable(false);
            this.n.setFocusableInTouchMode(false);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!SlidingUpPanelLayout.this.isEnabled() || !SlidingUpPanelLayout.this.a() || SlidingUpPanelLayout.this.r == d.EXPANDED || SlidingUpPanelLayout.this.r == d.ANCHORED) {
                        return;
                    }
                    if (SlidingUpPanelLayout.this.A < 1.0f) {
                        SlidingUpPanelLayout.this.setPanelState(d.ANCHORED);
                    } else {
                        SlidingUpPanelLayout.this.setPanelState(d.EXPANDED);
                    }
                }
            });
        }
    }

    public void setDragView(int i) {
        this.o = i;
        setDragView(findViewById(i));
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.A = f;
        }
    }

    public float getAnchorPoint() {
        return this.A;
    }

    public void setOverlayed(boolean z) {
        this.l = z;
    }

    public void setClipPanel(boolean z) {
        this.m = z;
    }

    void a(View view) {
        if (this.B != null) {
            this.B.a(view, this.t);
        }
    }

    void b(View view) {
        if (this.B != null) {
            this.B.b(view);
        }
        sendAccessibilityEvent(32);
    }

    void c(View view) {
        if (this.B != null) {
            this.B.a(view);
        }
        sendAccessibilityEvent(32);
    }

    void d(View view) {
        if (this.B != null) {
            this.B.c(view);
        }
        sendAccessibilityEvent(32);
    }

    void e(View view) {
        if (this.B != null) {
            this.B.d(view);
        }
        sendAccessibilityEvent(32);
    }

    void c() {
        int bottom;
        int top;
        int right;
        int left;
        int i = 0;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (this.p == null || !f(this.p)) {
                bottom = 0;
                top = 0;
                right = 0;
                left = 0;
            } else {
                left = this.p.getLeft();
                right = this.p.getRight();
                top = this.p.getTop();
                bottom = this.p.getBottom();
            }
            View childAt = getChildAt(0);
            int iMax = Math.max(paddingLeft, childAt.getLeft());
            int iMax2 = Math.max(paddingTop, childAt.getTop());
            int iMin = Math.min(width, childAt.getRight());
            int iMin2 = Math.min(height, childAt.getBottom());
            if (iMax >= left && iMax2 >= top && iMin <= right && iMin2 <= bottom) {
                i = 4;
            }
            childAt.setVisibility(i);
        }
    }

    void d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean f(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        }
        this.q = getChildAt(0);
        this.q.setLayoutParams(new b(-1, -1));
        this.p = getChildAt(1);
        if (this.n == null) {
            setDragView(this.p);
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            b bVar = (b) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || i5 != 0) {
                if (childAt == this.q) {
                    i4 = (this.l || this.r == d.HIDDEN) ? paddingTop : paddingTop - this.h;
                    i3 = paddingLeft - (bVar.leftMargin + bVar.rightMargin);
                } else if (childAt == this.p) {
                    i4 = paddingTop - bVar.topMargin;
                    i3 = paddingLeft;
                } else {
                    i3 = paddingLeft;
                    i4 = paddingTop;
                }
                if (bVar.width == -2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                } else if (bVar.width == -1) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                } else {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bVar.width, 1073741824);
                }
                if (bVar.height == -2) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else if (bVar.height == -1) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(bVar.height, 1073741824);
                }
                childAt.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                if (childAt == this.p) {
                    this.u = this.p.getMeasuredHeight() - this.h;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.D) {
            switch (this.r) {
                case EXPANDED:
                    this.t = 1.0f;
                    break;
                case ANCHORED:
                    this.t = this.A;
                    break;
                case HIDDEN:
                    this.t = a((this.k ? this.h : -this.h) + b(0.0f));
                    break;
                default:
                    this.t = 0.0f;
                    break;
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            b bVar = (b) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i5 != 0 && !this.D)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int iB = childAt == this.p ? b(this.t) : paddingTop;
                if (!this.k && childAt == this.q && !this.l) {
                    iB = b(this.t) + this.p.getMeasuredHeight();
                }
                int i6 = bVar.leftMargin + paddingLeft;
                childAt.layout(i6, iB, childAt.getMeasuredWidth() + i6, measuredHeight + iB);
            }
        }
        if (this.D) {
            c();
        }
        e();
        this.D = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.D = true;
        }
    }

    public void setEnableDragViewTouchEvents(boolean z) {
        this.x = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iA = ep.a(motionEvent);
        if (!isEnabled() || !a() || (this.v && iA != 0)) {
            this.C.c();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (iA == 3 || iA == 1) {
            this.C.c();
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (iA) {
            case 0:
                if (this.G.a()) {
                    this.v = false;
                } else {
                    this.v = true;
                }
                this.y = x;
                this.z = y;
                break;
            case 2:
                float fAbs = Math.abs(x - this.y);
                float fAbs2 = Math.abs(y - this.z);
                int iB = this.C.b();
                if (this.x && fAbs > iB && fAbs2 < iB) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                if ((fAbs2 > iB && fAbs > fAbs2) || !a((int) this.y, (int) this.z)) {
                    this.C.c();
                    this.v = true;
                    return false;
                }
                break;
        }
        return this.C.a(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !a()) {
            return super.onTouchEvent(motionEvent);
        }
        this.C.b(motionEvent);
        return true;
    }

    private boolean a(int i, int i2) {
        if (this.n == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.n.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        return i3 >= iArr[0] && i3 < iArr[0] + this.n.getWidth() && i4 >= iArr[1] && i4 < iArr[1] + this.n.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(float f) {
        int measuredHeight = this.p != null ? this.p.getMeasuredHeight() : 0;
        int i = (int) (this.u * f);
        if (this.k) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.h) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.h + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(int i) {
        int iB = b(0.0f);
        return this.k ? (iB - i) / this.u : (i - iB) / this.u;
    }

    public d getPanelState() {
        return this.r;
    }

    public void setPanelState(d dVar) {
        if (dVar == null || dVar == d.DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        }
        if (isEnabled()) {
            if ((this.D || this.p != null) && dVar != this.r && this.r != d.DRAGGING) {
                if (this.D) {
                    this.r = dVar;
                    return;
                }
                if (this.r == d.HIDDEN) {
                    this.p.setVisibility(0);
                    requestLayout();
                }
                switch (dVar) {
                    case EXPANDED:
                        a(1.0f, 0);
                        return;
                    case ANCHORED:
                        a(this.A, 0);
                        return;
                    case HIDDEN:
                        a(a((this.k ? this.h : -this.h) + b(0.0f)), 0);
                        return;
                    case COLLAPSED:
                        a(0.0f, 0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void e() {
        if (this.j > 0) {
            int currentParalaxOffset = getCurrentParalaxOffset();
            if (Build.VERSION.SDK_INT >= 11) {
                this.q.setTranslationY(currentParalaxOffset);
            } else {
                beg.a(this.q).a(currentParalaxOffset);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.F = i;
        this.s = this.r;
        this.r = d.DRAGGING;
        this.t = a(i);
        e();
        a(this.p);
        b bVar = (b) this.q.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.h;
        if (this.t <= 0.0f && !this.l) {
            bVar.height = this.k ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.p.getMeasuredHeight()) - i;
            this.q.requestLayout();
        } else if (bVar.height != height && !this.l) {
            bVar.height = height;
            this.q.requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = false;
        int iSave = canvas.save(2);
        if (view != null) {
            if (this.p != view) {
                canvas.getClipBounds(this.E);
                if (!this.l) {
                    if (this.k) {
                        this.E.bottom = Math.min(this.E.bottom, this.p.getTop());
                    } else {
                        this.E.top = Math.max(this.E.top, this.p.getBottom());
                    }
                }
                if (this.m) {
                    canvas.clipRect(this.E);
                }
                try {
                    zDrawChild = super.drawChild(canvas, view, j);
                    if (this.e != 0 && this.t > 0.0f) {
                        this.f.setColor((((int) (((this.e & (-16777216)) >>> 24) * this.t)) << 24) | (this.e & 16777215));
                        canvas.drawRect(this.E, this.f);
                    }
                } catch (NullPointerException e2) {
                }
            } else {
                zDrawChild = super.drawChild(canvas, view, j);
            }
            canvas.restoreToCount(iSave);
        }
        return zDrawChild;
    }

    public int getPanelTop() {
        return this.F;
    }

    public int getCollapsedTop() {
        return b(0.0f);
    }

    public int a(float f) {
        b(0.0f);
        return (((int) (((this.e & (-16777216)) >>> 24) * f)) << 24) | (this.e & 16777215);
    }

    boolean a(float f, int i) {
        if (!isEnabled()) {
            return false;
        }
        if (!this.C.a(this.p, this.p.getLeft(), b(f))) {
            return false;
        }
        d();
        fb.d(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.C != null && this.C.a(true)) {
            if (!isEnabled()) {
                this.C.d();
            } else {
                fb.d(this);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int bottom;
        int bottom2;
        super.draw(canvas);
        if (this.g != null) {
            int right = this.p.getRight();
            if (this.k) {
                bottom = this.p.getTop() - this.i;
                bottom2 = this.p.getTop();
            } else {
                bottom = this.p.getBottom();
                bottom2 = this.p.getBottom() + this.i;
            }
            this.g.setBounds(this.p.getLeft(), bottom, right, bottom2);
            this.g.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.r != d.DRAGGING) {
            savedState.a = this.r;
        } else {
            savedState.a = this.s;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.r = savedState.a;
    }

    class a extends asv.a {
        private a() {
        }

        @Override // asv.a
        public boolean a(View view, int i) {
            return !SlidingUpPanelLayout.this.v && view == SlidingUpPanelLayout.this.p;
        }

        @Override // asv.a
        public void a(int i) {
            if (SlidingUpPanelLayout.this.C.a() == 0) {
                SlidingUpPanelLayout.this.t = SlidingUpPanelLayout.this.a(SlidingUpPanelLayout.this.p.getTop());
                SlidingUpPanelLayout.this.e();
                if (SlidingUpPanelLayout.this.t == 1.0f) {
                    if (SlidingUpPanelLayout.this.r != d.EXPANDED) {
                        SlidingUpPanelLayout.this.c();
                        SlidingUpPanelLayout.this.r = d.EXPANDED;
                        SlidingUpPanelLayout.this.b(SlidingUpPanelLayout.this.p);
                        return;
                    }
                    return;
                }
                if (SlidingUpPanelLayout.this.t == 0.0f) {
                    if (SlidingUpPanelLayout.this.r != d.COLLAPSED) {
                        SlidingUpPanelLayout.this.r = d.COLLAPSED;
                        SlidingUpPanelLayout.this.c(SlidingUpPanelLayout.this.p);
                        return;
                    }
                    return;
                }
                if (SlidingUpPanelLayout.this.t >= 0.0f) {
                    if (SlidingUpPanelLayout.this.r != d.ANCHORED) {
                        SlidingUpPanelLayout.this.c();
                        SlidingUpPanelLayout.this.r = d.ANCHORED;
                        SlidingUpPanelLayout.this.d(SlidingUpPanelLayout.this.p);
                        return;
                    }
                    return;
                }
                SlidingUpPanelLayout.this.r = d.HIDDEN;
                SlidingUpPanelLayout.this.p.setVisibility(4);
                SlidingUpPanelLayout.this.e(SlidingUpPanelLayout.this.p);
            }
        }

        @Override // asv.a
        public void b(View view, int i) {
            SlidingUpPanelLayout.this.d();
        }

        @Override // asv.a
        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.F = i2;
            SlidingUpPanelLayout.this.b(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // asv.a
        public void a(View view, float f, float f2) {
            if (SlidingUpPanelLayout.this.k) {
                f2 = -f2;
            }
            SlidingUpPanelLayout.this.C.a(view.getLeft(), f2 > 0.0f ? ((double) SlidingUpPanelLayout.this.t) < 0.1d ? SlidingUpPanelLayout.this.b(0.0f) : SlidingUpPanelLayout.this.b(1.0f) : f2 < 0.0f ? ((double) SlidingUpPanelLayout.this.t) > 0.9d ? SlidingUpPanelLayout.this.b(1.0f) : SlidingUpPanelLayout.this.b(0.0f) : (SlidingUpPanelLayout.this.A == 1.0f || SlidingUpPanelLayout.this.t < SlidingUpPanelLayout.this.A) ? (SlidingUpPanelLayout.this.A == 1.0f || SlidingUpPanelLayout.this.t < SlidingUpPanelLayout.this.A / 2.0f) ? ((double) SlidingUpPanelLayout.this.t) > 0.75d ? SlidingUpPanelLayout.this.b(1.0f) : SlidingUpPanelLayout.this.b(0.0f) : SlidingUpPanelLayout.this.b(SlidingUpPanelLayout.this.A) : SlidingUpPanelLayout.this.b(SlidingUpPanelLayout.this.A));
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // asv.a
        public int a(View view) {
            return SlidingUpPanelLayout.this.u;
        }

        @Override // asv.a
        public int a(View view, int i, int i2) {
            int iB = SlidingUpPanelLayout.this.b(0.0f);
            int iB2 = SlidingUpPanelLayout.this.b(1.0f);
            return SlidingUpPanelLayout.this.k ? Math.min(Math.max(i, iB2), iB) : Math.min(Math.max(i, iB), iB2);
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        private static final int[] a = {R.attr.layout_weight};

        public b() {
            super(-1, -1);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context.obtainStyledAttributes(attributeSet, a).recycle();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        d a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            try {
                this.a = (d) Enum.valueOf(d.class, parcel.readString());
            } catch (IllegalArgumentException e) {
                this.a = d.COLLAPSED;
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            this.a = d.COLLAPSED;
            parcel.writeString(this.a.toString());
        }
    }
}
