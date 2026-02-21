package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public final class bej extends ViewGroup {
    private static final Interpolator a = beh.a();
    private final Paint b;
    private final RectF c;
    private int d;
    private int e;
    private int f;
    private int g;
    private ViewGroup h;
    private Rect i;

    public interface a {
        void setState(int i);
    }

    public bej(Context context) {
        super(context);
        this.b = new Paint();
        this.c = new RectF();
        this.i = new Rect();
        this.d = -1291845632;
        this.e = Integer.MIN_VALUE;
        this.f = 1291845632;
        this.g = 436207616;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void a() {
        a(new bek(getContext()));
    }

    public void a(int i) {
        if (this.h instanceof a) {
            ((a) this.h).setState(i);
        }
    }

    public bej a(ViewGroup viewGroup) {
        if (!(viewGroup instanceof a)) {
            throw new IllegalStateException("ViewGroup must implements CustomSwipeRefreshHeadLayout interface!");
        }
        this.h = viewGroup;
        this.h.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.h);
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iWidth = this.i.width();
        int iHeight = this.i.height();
        int iSave = canvas.save();
        canvas.clipRect(this.i);
        Rect rect = new Rect();
        rect.set(0, 0, iWidth, iHeight);
        this.h.setBackgroundColor(0);
        this.h.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
        this.h.layout(0, 0, rect.width(), rect.height());
        canvas.translate(rect.left, rect.top);
        this.h.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void a(int i, int i2, boolean z) {
        this.i.bottom = i;
        if (z) {
            b();
            return;
        }
        if (this.i.bottom > i2) {
            a(1);
        } else {
            a(0);
        }
        b();
    }

    protected void b() {
        if (getParent() != null && (getParent() instanceof View)) {
            ((View) getParent()).postInvalidate();
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i.left = i;
        this.i.top = i2;
        this.i.right = i3;
        this.i.bottom = i4;
    }
}
