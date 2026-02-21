package com.harman.hkconnect.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.aib;
import defpackage.ep;
import defpackage.fb;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class RippleTextView extends TypefaceTextView {
    private int a;
    private int b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private boolean m;
    private final int n;
    private final int o;
    private float p;
    private final Rect q;
    private boolean r;
    private boolean s;
    private boolean t;
    private Paint u;
    private Rect v;

    public RippleTextView(Context context) {
        this(context, null);
    }

    public RippleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 255;
        this.l = false;
        this.n = HttpStatus.SC_MULTIPLE_CHOICES;
        this.o = 30;
        this.q = new Rect();
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = new Paint(1);
        a(context, attributeSet);
    }

    public RippleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 255;
        this.l = false;
        this.n = HttpStatus.SC_MULTIPLE_CHOICES;
        this.o = 30;
        this.q = new Rect();
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = new Paint(1);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.RippleTextView);
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.default_ripple_transparency));
        typedArrayObtainStyledAttributes.recycle();
        this.u.setColor(color);
        this.k = this.u.getAlpha();
        this.j = this.k / 25;
        this.p = 10.0f;
        this.p = getResources().getDisplayMetrics().density * this.p;
        this.m = true;
        this.l = false;
    }

    @Override // com.harman.hkconnect.ui.custom.TypefaceTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.m) {
            super.onDraw(canvas);
            return;
        }
        canvas.drawColor(0);
        super.onDraw(canvas);
        if (this.f != 0.0f) {
            this.i += this.f;
            this.c += this.g;
            this.d += this.h;
            if (this.i > this.e) {
                this.i = 0.0f;
                canvas.drawCircle(this.q.width() / 2, this.q.height() / 2, this.e, this.u);
                this.m = true;
                if (this.r) {
                    invalidate();
                    return;
                }
                return;
            }
            canvas.drawCircle(this.c, this.d, this.i, this.u);
            fb.d(this);
        }
    }

    @Override // com.harman.hkconnect.ui.custom.TypefaceTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.q.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    private void a() {
        this.e = (float) Math.sqrt((((this.q.width() / 2) * this.q.width()) / 2) + (((this.q.height() / 2) * this.q.height()) / 2));
        this.e += 0.0f;
        this.f = this.e / this.p;
        this.g = ((this.q.width() / 2) - this.a) / this.p;
        this.h = ((this.q.height() / 2) - this.b) / this.p;
        this.c = this.a;
        this.d = this.b;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (ep.a(motionEvent)) {
            case 0:
                this.r = false;
                this.m = false;
                this.t = false;
                int iB = ep.b(motionEvent);
                if (ep.b(motionEvent, iB) != -1) {
                    this.a = (int) ep.c(motionEvent, iB);
                    this.b = (int) ep.d(motionEvent, iB);
                    a();
                    invalidate();
                }
                this.v = new Rect(getLeft(), getTop(), getRight(), getBottom());
                break;
            case 2:
                if (!this.v.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY()))) {
                }
            case 1:
            case 3:
            case 4:
                if (!this.r) {
                    this.f = (int) (this.f * 3.0f);
                    this.g = (int) (this.g * 3.0f);
                    this.h = (int) (this.h * 3.0f);
                    this.r = true;
                    invalidate();
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        postDelayed(new Runnable() { // from class: com.harman.hkconnect.ui.RippleTextView.1
            @Override // java.lang.Runnable
            public void run() {
                RippleTextView.super.performClick();
            }
        }, 150L);
        return true;
    }
}
