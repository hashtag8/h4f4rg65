package com.harman.hkconnect.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import defpackage.aib;
import defpackage.ep;
import defpackage.fb;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class RippleImageView extends ImageView {
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
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private final int p;
    private final int q;
    private float r;
    private final Rect s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Paint w;

    public RippleImageView(Context context) {
        this(context, null);
    }

    public RippleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 255;
        this.m = false;
        this.o = false;
        this.p = HttpStatus.SC_MULTIPLE_CHOICES;
        this.q = 30;
        this.s = new Rect();
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = new Paint(1);
        a(context, attributeSet);
    }

    public RippleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 255;
        this.m = false;
        this.o = false;
        this.p = HttpStatus.SC_MULTIPLE_CHOICES;
        this.q = 30;
        this.s = new Rect();
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = new Paint(1);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.RippleImageView);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.o = typedArrayObtainStyledAttributes.getBoolean(3, false);
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.default_ripple_transparency));
        typedArrayObtainStyledAttributes.recycle();
        this.w.setColor(color);
        this.l = this.w.getAlpha();
        this.j = this.l / 25;
        this.r = 10.0f;
        this.r = getResources().getDisplayMetrics().density * this.r;
        this.n = true;
        this.m = false;
    }

    public void a() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.n || this.m) {
            if (!this.m && this.u && !this.v) {
                a(canvas);
                super.onDraw(canvas);
                return;
            }
            this.m = false;
            this.v = true;
            this.u = false;
            this.n = true;
            this.w.setAlpha(this.l);
            super.onDraw(canvas);
            return;
        }
        canvas.drawColor(0);
        super.onDraw(canvas);
        if (this.f != 0.0f) {
            this.i += this.f;
            this.c += this.g;
            this.d += this.h;
            if (this.u) {
                b();
            }
            if (this.i > this.e) {
                this.i = 0.0f;
                canvas.drawCircle(this.s.width() / 2, this.s.height() / 2, this.e, this.w);
                this.n = true;
                if (this.t || this.u) {
                    invalidate();
                    return;
                }
                return;
            }
            canvas.drawCircle(this.c, this.d, this.i, this.w);
            fb.d(this);
        }
    }

    protected void b() {
        int alpha = this.w.getAlpha() - ((int) this.j);
        if (alpha < 0) {
            alpha = 0;
        }
        this.w.setAlpha(alpha);
    }

    protected void a(Canvas canvas) {
        int alpha = this.w.getAlpha() - ((int) this.j);
        if (alpha < 0) {
            alpha = 0;
        }
        this.w.setAlpha(alpha);
        canvas.drawCircle(this.s.width() / 2, this.s.height() / 2, this.e, this.w);
        if (alpha == 0) {
            this.v = true;
            this.u = false;
        }
        fb.d(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.s.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    private void c() {
        this.e = (float) Math.sqrt((((this.s.width() / 2) * this.s.width()) / 2) + (((this.s.height() / 2) * this.s.height()) / 2));
        this.e += this.k;
        this.f = this.e / this.r;
        this.g = ((this.s.width() / 2) - this.a) / this.r;
        this.h = ((this.s.height() / 2) - this.b) / this.r;
        this.c = this.a;
        this.d = this.b;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (ep.a(motionEvent)) {
            case 0:
                this.t = false;
                this.n = false;
                this.v = false;
                int iB = ep.b(motionEvent);
                if (ep.b(motionEvent, iB) != -1) {
                    this.a = (int) ep.c(motionEvent, iB);
                    this.b = (int) ep.d(motionEvent, iB);
                    c();
                    invalidate();
                }
                break;
            case 1:
            case 3:
                this.f = (int) (this.f * 4.0f);
                this.g = (int) (this.g * 4.0f);
                this.h = (int) (this.h * 4.0f);
                this.t = true;
                this.u = true;
                invalidate();
                break;
            case 2:
                if (this.o) {
                    this.f = (int) (((double) this.f) * 1.1d);
                    this.g = (int) (((double) this.g) * 1.1d);
                    this.h = (int) (((double) this.h) * 1.1d);
                    if (!this.u && !this.v) {
                        this.u = true;
                        invalidate();
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        postDelayed(new Runnable() { // from class: com.harman.hkconnect.ui.RippleImageView.1
            @Override // java.lang.Runnable
            public void run() {
                RippleImageView.super.performClick();
            }
        }, 150L);
        return true;
    }
}
