package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public final class bei {
    private static final Interpolator a = beh.a();
    private float d;
    private long e;
    private long f;
    private boolean g;
    private View l;
    private final Paint b = new Paint();
    private final RectF c = new RectF();
    private Rect m = new Rect();
    private int h = -1291845632;
    private int i = Integer.MIN_VALUE;
    private int j = 1291845632;
    private int k = 436207616;

    public bei(View view) {
        this.l = view;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public void a(float f) {
        this.d = f;
        this.e = 0L;
        fb.d(this.l);
    }

    public void a() {
        if (!this.g) {
            this.d = 0.0f;
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.g = true;
            this.l.postInvalidate();
        }
    }

    public void b() {
        if (this.g) {
            this.d = 0.0f;
            this.f = AnimationUtils.currentAnimationTimeMillis();
            this.g = false;
            this.l.postInvalidate();
        }
    }

    public void a(Canvas canvas) {
        boolean z;
        int iSave;
        int iWidth = this.m.width();
        int iHeight = this.m.height();
        int i = iWidth / 2;
        int i2 = iHeight / 2;
        int iSave2 = canvas.save();
        canvas.clipRect(this.m);
        if (this.g || this.f > 0) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = (jCurrentAnimationTimeMillis - this.e) % 2000;
            long j2 = (jCurrentAnimationTimeMillis - this.e) / 2000;
            float f = j / 20.0f;
            if (this.g) {
                z = false;
            } else {
                if (jCurrentAnimationTimeMillis - this.f >= 1000) {
                    this.f = 0L;
                    canvas.restoreToCount(iSave2);
                    return;
                }
                float interpolation = a.getInterpolation((((jCurrentAnimationTimeMillis - this.f) % 1000) / 10.0f) / 100.0f) * (iWidth / 2);
                this.c.set(i - interpolation, 0.0f, interpolation + i, iHeight);
                canvas.saveLayerAlpha(this.c, 0, 0);
                z = true;
            }
            if (j2 == 0) {
                canvas.drawColor(this.h);
            } else if (f >= 0.0f && f < 25.0f) {
                canvas.drawColor(this.k);
            } else if (f >= 25.0f && f < 50.0f) {
                canvas.drawColor(this.h);
            } else if (f >= 50.0f && f < 75.0f) {
                canvas.drawColor(this.i);
            } else {
                canvas.drawColor(this.j);
            }
            if (f >= 0.0f && f <= 25.0f) {
                a(canvas, i, i2, this.h, ((25.0f + f) * 2.0f) / 100.0f);
            }
            if (f >= 0.0f && f <= 50.0f) {
                a(canvas, i, i2, this.i, (2.0f * f) / 100.0f);
            }
            if (f >= 25.0f && f <= 75.0f) {
                a(canvas, i, i2, this.j, ((f - 25.0f) * 2.0f) / 100.0f);
            }
            if (f >= 50.0f && f <= 100.0f) {
                a(canvas, i, i2, this.k, ((f - 50.0f) * 2.0f) / 100.0f);
            }
            if (f >= 75.0f && f <= 100.0f) {
                a(canvas, i, i2, this.h, ((f - 75.0f) * 2.0f) / 100.0f);
            }
            if (this.d <= 0.0f || !z) {
                iSave = iSave2;
            } else {
                canvas.restoreToCount(iSave2);
                iSave = canvas.save();
                canvas.clipRect(this.m);
                a(canvas, i, i2);
            }
            fb.d(this.l);
            iSave2 = iSave;
        } else if (this.d > 0.0f && this.d <= 1.0d) {
            a(canvas, i, i2);
        }
        canvas.restoreToCount(iSave2);
    }

    private void a(Canvas canvas, int i, int i2) {
        this.b.setColor(this.h);
        canvas.drawCircle(i, i2, i * this.d, this.b);
    }

    private void a(Canvas canvas, float f, float f2, int i, float f3) {
        this.b.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        float interpolation = a.getInterpolation(f3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, f, this.b);
        canvas.restore();
    }

    public void b(int i, int i2, int i3, int i4) {
        this.m.left = i;
        this.m.top = i2;
        this.m.right = i3;
        this.m.bottom = i4;
    }
}
