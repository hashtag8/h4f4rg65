package com.harman.hkconnect.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import defpackage.aib;
import defpackage.fb;
import defpackage.fx;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    private boolean A;
    private boolean B;
    private View.OnClickListener C;
    private DataSetObserver D;
    private Runnable E;
    protected Scroller a;
    protected ListAdapter b;
    protected int c;
    protected int d;
    private final a e;
    private GestureDetector f;
    private int g;
    private List<Queue<View>> h;
    private boolean i;
    private Rect j;
    private View k;
    private int l;
    private Drawable m;
    private Integer n;
    private int o;
    private int p;
    private int q;
    private int r;
    private e s;
    private int t;
    private boolean u;
    private d v;
    private d.a w;
    private fx x;
    private fx y;
    private int z;

    public interface d {

        public enum a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void a(a aVar);
    }

    public interface e {
        void a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Scroller(getContext());
        this.e = new a();
        this.h = new ArrayList();
        this.i = false;
        this.j = new Rect();
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = Integer.MAX_VALUE;
        this.s = null;
        this.t = 0;
        this.u = false;
        this.v = null;
        this.w = d.a.SCROLL_STATE_IDLE;
        this.A = false;
        this.B = false;
        this.D = new DataSetObserver() { // from class: com.harman.hkconnect.ui.custom.HorizontalListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                HorizontalListView.this.i = true;
                HorizontalListView.this.u = false;
                HorizontalListView.this.f();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                HorizontalListView.this.u = false;
                HorizontalListView.this.f();
                HorizontalListView.this.c();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.E = new Runnable() { // from class: com.harman.hkconnect.ui.custom.HorizontalListView.3
            @Override // java.lang.Runnable
            public void run() {
                HorizontalListView.this.requestLayout();
            }
        };
        this.x = new fx(context);
        this.y = new fx(context);
        this.f = new GestureDetector(context, this.e);
        a();
        b();
        a(context, attributeSet);
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            b.a(this.a, 0.009f);
        }
    }

    private void a() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.custom.HorizontalListView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListView.this.f.onTouchEvent(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (this.B != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.B = bool.booleanValue();
                    return;
                }
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.HorizontalListView);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setDivider(drawable);
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (dimensionPixelSize != 0) {
                setDividerWidth(dimensionPixelSize);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.c);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.n = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public void setDivider(Drawable drawable) {
        this.m = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i) {
        this.l = i;
        requestLayout();
        invalidate();
    }

    private void b() {
        this.p = -1;
        this.q = -1;
        this.g = 0;
        this.c = 0;
        this.d = 0;
        this.o = Integer.MAX_VALUE;
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        this.r = i;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return g(this.r);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.b != null) {
            this.b.unregisterDataSetObserver(this.D);
        }
        if (listAdapter != null) {
            this.u = false;
            this.b = listAdapter;
            this.b.registerDataSetObserver(this.D);
        }
        a(this.b.getViewTypeCount());
        c();
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.b;
    }

    private void a(int i) {
        this.h.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.h.add(new LinkedList());
        }
    }

    private View b(int i) {
        int itemViewType = this.b.getItemViewType(i);
        if (c(itemViewType)) {
            return this.h.get(itemViewType).poll();
        }
        return null;
    }

    private void a(int i, View view) {
        int itemViewType = this.b.getItemViewType(i);
        if (c(itemViewType)) {
            this.h.get(itemViewType).offer(view);
        }
    }

    private boolean c(int i) {
        return i < this.h.size();
    }

    private void a(View view, int i) {
        addViewInLayout(view, i, b(view), true);
        a(view);
    }

    private void a(View view) {
        int iMakeMeasureSpec;
        ViewGroup.LayoutParams layoutParamsB = b(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getPaddingTop() + getPaddingBottom(), layoutParamsB.height);
        if (layoutParamsB.width > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParamsB.width, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(iMakeMeasureSpec, childMeasureSpec);
    }

    private ViewGroup.LayoutParams b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b != null) {
            invalidate();
            if (this.i) {
                int i5 = this.c;
                b();
                removeAllViewsInLayout();
                this.d = i5;
                this.i = false;
            }
            if (this.n != null) {
                this.d = this.n.intValue();
                this.n = null;
            }
            if (this.a.computeScrollOffset()) {
                this.d = this.a.getCurrX();
            }
            if (this.d < 0) {
                this.d = 0;
                if (this.x.a()) {
                    this.x.a((int) d());
                }
                this.a.forceFinished(true);
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            } else if (this.d > this.o) {
                this.d = this.o;
                if (this.y.a()) {
                    this.y.a((int) d());
                }
                this.a.forceFinished(true);
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            }
            int i6 = this.c - this.d;
            e(i6);
            d(i6);
            f(i6);
            this.c = this.d;
            if (e()) {
                onLayout(z, i, i2, i3, i4);
            } else {
                if (this.a.isFinished()) {
                    if (this.w == d.a.SCROLL_STATE_FLING) {
                        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
                        return;
                    }
                    return;
                }
                fb.a(this, this.E);
            }
        }
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.c == 0) {
            return 0.0f;
        }
        if (this.c < horizontalFadingEdgeLength) {
            return this.c / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.c == this.o) {
            return 0.0f;
        }
        if (this.o - this.c < horizontalFadingEdgeLength) {
            return (this.o - this.c) / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    private float d() {
        if (Build.VERSION.SDK_INT >= 14) {
            return c.a(this.a);
        }
        return 30.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.z = i2;
    }

    private boolean e() {
        View rightmostChild;
        if (!h(this.q) || (rightmostChild = getRightmostChild()) == null) {
            return false;
        }
        int i = this.o;
        this.o = ((rightmostChild.getRight() - getPaddingLeft()) + this.c) - getRenderWidth();
        if (this.o < 0) {
            this.o = 0;
        }
        return this.o != i;
    }

    private void d(int i) {
        View rightmostChild = getRightmostChild();
        a(rightmostChild != null ? rightmostChild.getRight() : 0, i);
        View leftmostChild = getLeftmostChild();
        b(leftmostChild != null ? leftmostChild.getLeft() : 0, i);
    }

    private void e(int i) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i <= 0) {
            this.g = (h(this.p) ? leftmostChild.getMeasuredWidth() : this.l + leftmostChild.getMeasuredWidth()) + this.g;
            a(this.p, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.p++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + i >= getWidth()) {
            a(this.q, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.q--;
            rightmostChild = getRightmostChild();
        }
    }

    private void a(int i, int i2) {
        while (i + i2 + this.l < getWidth() && this.q + 1 < this.b.getCount()) {
            this.q++;
            if (this.p < 0) {
                this.p = this.q;
            }
            View view = this.b.getView(this.q, b(this.q), this);
            a(view, -1);
            i += (this.q == 0 ? 0 : this.l) + view.getMeasuredWidth();
            h();
        }
    }

    private void b(int i, int i2) {
        while ((i + i2) - this.l > 0 && this.p >= 1) {
            this.p--;
            View view = this.b.getView(this.p, b(this.p), this);
            a(view, 0);
            i -= this.p == 0 ? view.getMeasuredWidth() : this.l + view.getMeasuredWidth();
            this.g -= i + i2 == 0 ? view.getMeasuredWidth() : this.l + view.getMeasuredWidth();
        }
    }

    private void f(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            this.g += i;
            int measuredWidth = this.g;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int paddingLeft = getPaddingLeft() + measuredWidth;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                measuredWidth += childAt.getMeasuredWidth() + this.l;
            }
        }
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    private View g(int i) {
        if (i < this.p || i > this.q) {
            return null;
        }
        return getChildAt(i - this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.j);
            if (this.j.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean h(int i) {
        return i == this.b.getCount() + (-1);
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.p;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.q;
    }

    private void a(Canvas canvas) {
        if (this.x != null && !this.x.a() && i()) {
            int iSave = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.x.a(getRenderHeight(), getRenderWidth());
            if (this.x.a(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(iSave);
            return;
        }
        if (this.y != null && !this.y.a() && i()) {
            int iSave2 = canvas.save();
            int width = getWidth();
            canvas.rotate(90.0f, 0.0f, 0.0f);
            canvas.translate(getPaddingTop(), -width);
            this.y.a(getRenderHeight(), getRenderWidth());
            if (this.y.a(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(iSave2);
        }
    }

    private void b(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.j;
        this.j.top = getPaddingTop();
        this.j.bottom = this.j.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !h(this.q)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.l;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.m != null) {
            this.m.setBounds(rect);
            this.m.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.fling(this.d, 0, (int) (-f), 0, 0, this.o, 0, 0);
        setCurrentScrollState(d.a.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    protected boolean a(MotionEvent motionEvent) {
        int iC;
        this.A = !this.a.isFinished();
        this.a.forceFinished(true);
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
        f();
        if (!this.A && (iC = c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            this.k = getChildAt(iC);
            if (this.k != null) {
                this.k.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.k != null) {
            this.k.setPressed(false);
            refreshDrawableState();
            this.k = null;
        }
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.a(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.a(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView.this.a((Boolean) true);
            HorizontalListView.this.setCurrentScrollState(d.a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.f();
            HorizontalListView.this.d += (int) f;
            HorizontalListView.this.i(Math.round(f));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.f();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int iC = HorizontalListView.this.c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iC >= 0 && !HorizontalListView.this.A) {
                View childAt = HorizontalListView.this.getChildAt(iC);
                int i = HorizontalListView.this.p + iC;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListView.this, childAt, i, HorizontalListView.this.b.getItemId(i));
                    return true;
                }
            }
            if (HorizontalListView.this.C != null && !HorizontalListView.this.A) {
                HorizontalListView.this.C.onClick(HorizontalListView.this);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.f();
            int iC = HorizontalListView.this.c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iC >= 0 && !HorizontalListView.this.A) {
                View childAt = HorizontalListView.this.getChildAt(iC);
                AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int i = HorizontalListView.this.p + iC;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListView.this, childAt, i, HorizontalListView.this.b.getItemId(i))) {
                        HorizontalListView.this.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.a == null || this.a.isFinished()) {
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            }
            a((Boolean) false);
            g();
        } else if (motionEvent.getAction() == 3) {
            f();
            g();
            a((Boolean) false);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void g() {
        if (this.x != null) {
            this.x.b();
        }
        if (this.y != null) {
            this.y.b();
        }
    }

    private void h() {
        if (this.s != null && this.b != null && this.b.getCount() - (this.q + 1) < this.t && !this.u) {
            this.u = true;
            this.s.a();
        }
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setOnScrollStateChangedListener(d dVar) {
        this.v = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentScrollState(d.a aVar) {
        if (this.w != aVar && this.v != null) {
            this.v.a(aVar);
        }
        this.w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i) {
        if (this.x != null && this.y != null) {
            int i2 = this.c + i;
            if (this.a == null || this.a.isFinished()) {
                if (i2 < 0) {
                    this.x.a(Math.abs(i) / getRenderWidth());
                    if (!this.y.a()) {
                        this.y.b();
                        return;
                    }
                    return;
                }
                if (i2 > this.o) {
                    this.y.a(Math.abs(i) / getRenderWidth());
                    if (!this.x.a()) {
                        this.x.b();
                    }
                }
            }
        }
    }

    private boolean i() {
        return (this.b == null || this.b.isEmpty() || this.o <= 0) ? false : true;
    }

    static final class b {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller, float f) {
            if (scroller != null) {
                scroller.setFriction(f);
            }
        }
    }

    static final class c {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }
}
