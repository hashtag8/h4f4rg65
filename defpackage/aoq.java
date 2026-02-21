package defpackage;

import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class aoq extends ViewGroup {
    private int a;
    private View b;
    private aor c;
    private int d;
    private int e;
    private ek f;
    private GestureDetector.OnGestureListener g;
    private boolean h;
    private int i;
    private int j;
    private gd k;
    private gd l;
    private int m;
    private int n;
    private Interpolator o;
    private Interpolator p;
    private boolean q;

    public aoq(View view, aor aorVar, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.a = 48;
        this.e = 0;
        this.i = b(15);
        this.j = -b(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.q = false;
        this.o = interpolator;
        this.p = interpolator2;
        this.b = view;
        this.c = aorVar;
        this.c.setLayout(this);
        a();
    }

    public int getPosition() {
        return this.n;
    }

    public void setPosition(int i) {
        this.n = i;
        this.c.setPosition(i);
    }

    public void a() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.g = new GestureDetector.SimpleOnGestureListener() { // from class: aoq.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                aoq.this.h = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getX() - motionEvent2.getX() > aoq.this.i && f < aoq.this.j) {
                    aoq.this.h = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.f = new ek(getContext(), this.g);
        if (this.o != null) {
            this.l = gd.a(getContext(), this.o);
        } else {
            this.l = gd.a(getContext());
        }
        if (this.p != null) {
            this.k = gd.a(getContext(), this.p);
        } else {
            this.k = gd.a(getContext());
        }
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.b.getId() < 1) {
            this.b.setId(1);
        }
        this.c.setId(2);
        this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.b);
        addView(this.c);
    }

    public void setGravity(int i) {
        this.a = i;
    }

    public int getGravity() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.q) {
            return true;
        }
        this.f.a(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.d = (int) motionEvent.getX();
                this.h = false;
                break;
            case 1:
                if (this.h || this.d - motionEvent.getX() > this.c.getWidth() / 2) {
                    d();
                } else {
                    c();
                    return false;
                }
                break;
            case 2:
                int x = (int) (this.d - motionEvent.getX());
                if (this.e == 1) {
                    x += this.c.getWidth();
                }
                a(x);
                break;
        }
        return true;
    }

    public boolean b() {
        return this.e == 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private void a(int i) {
        int width = i > this.c.getWidth() ? this.c.getWidth() : i;
        if (width < 0) {
            width = 0;
        }
        this.b.layout(-width, this.b.getTop(), this.b.getWidth() - width, getMeasuredHeight());
        this.c.layout(this.b.getWidth() - width, this.c.getTop(), (this.b.getWidth() + this.c.getWidth()) - width, this.c.getBottom());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e == 1) {
            if (this.k.f()) {
                a(this.k.b());
                postInvalidate();
                return;
            }
            return;
        }
        if (this.l.f()) {
            a(this.m - this.l.b());
            postInvalidate();
        }
    }

    public void c() {
        this.e = 0;
        this.m = -this.b.getLeft();
        this.l.a(0, 0, this.m, 0, 350);
        postInvalidate();
    }

    public void d() {
        this.e = 1;
        this.k.a(-this.b.getLeft(), 0, this.c.getWidth(), 0, 350);
        postInvalidate();
    }

    public void e() {
        if (this.l.f()) {
            this.l.g();
        }
        if (this.e == 1) {
            this.e = 0;
            a(0);
        }
    }

    public View getContentView() {
        return this.b;
    }

    public void setContentView(View view) {
        this.b = view;
    }

    public aor getMenuView() {
        return this.c;
    }

    public void setMenuView(aor aorVar) {
        this.c = aorVar;
    }

    private int b(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        View childAt = getChildAt(0);
        if (childAt == null) {
            setMeasuredDimension(0, size2);
            return;
        }
        if (childAt.isLayoutRequested()) {
            measureChild(childAt, i, View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (mode == 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height > 0) {
                size = layoutParams.height;
            } else {
                size = childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size2, size);
        this.c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.b.layout(0, 0, getMeasuredWidth(), this.b.getMeasuredHeight());
        this.c.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.c.getMeasuredWidth(), this.b.getMeasuredHeight());
        View childAt = getChildAt(0);
        if (childAt != null) {
            if (this.a == 48) {
                childAt.layout(0, 0, getMeasuredWidth(), childAt.getMeasuredHeight());
            } else {
                childAt.layout(0, getMeasuredHeight() - childAt.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void setMenuHeight(int i) {
        mm.b("byz", "pos = " + this.n + ", height = " + i);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.c.setLayoutParams(this.c.getLayoutParams());
        }
    }

    public void setSwipeEnabled(boolean z) {
        this.q = z;
    }
}
