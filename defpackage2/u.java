package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
class u extends he {
    static final double a = Math.cos(Math.toRadians(45.0d));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k;
    private final int l;
    private final int m;
    private final int n;
    private boolean o;
    private float p;
    private boolean q;

    private static int c(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    @Override // defpackage.he, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.b.setAlpha(i);
        this.c.setAlpha(i);
    }

    @Override // defpackage.he, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    void a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fC = c(f);
        float fC2 = c(f2);
        if (fC > fC2) {
            if (!this.q) {
                this.q = true;
            }
            fC = fC2;
        }
        if (this.j != fC || this.h != fC2) {
            this.j = fC;
            this.h = fC2;
            this.i = Math.round(fC * 1.5f);
            this.g = fC2;
            this.k = true;
            invalidateSelf();
        }
    }

    @Override // defpackage.he, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(a(this.h, this.e, this.o));
        int iCeil2 = (int) Math.ceil(b(this.h, this.e, this.o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - a) * ((double) f2))) : 1.5f * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - a) * ((double) f2)));
        }
        return f;
    }

    @Override // defpackage.he, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // defpackage.he, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    final void a(float f) {
        if (this.p != f) {
            this.p = f;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(this.p, this.d.centerX(), this.d.centerY());
        float f = (-this.e) - this.i;
        float f2 = this.e;
        boolean z = this.d.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.d.height() - (2.0f * f2) > 0.0f;
        float f3 = this.j - (this.j * 0.25f);
        float f4 = f2 / ((this.j - (this.j * 0.5f)) + f2);
        float f5 = f2 / (f3 + f2);
        float f6 = f2 / (f2 + (this.j - (this.j * 1.0f)));
        int iSave2 = canvas.save();
        canvas.translate(this.d.left + f2, this.d.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.f, this.b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.d.width() - (2.0f * f2), -this.e, this.c);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.d.right - f2, this.d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.d.width() - (2.0f * f2), this.i + (-this.e), this.c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.d.left + f2, this.d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.d.height() - (2.0f * f2), -this.e, this.c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.d.right - f2, this.d.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.d.height() - (2.0f * f2), -this.e, this.c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    private void c() {
        RectF rectF = new RectF(-this.e, -this.e, this.e, this.e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.i, -this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(Path.FillType.EVEN_ODD);
        this.f.moveTo(-this.e, 0.0f);
        this.f.rLineTo(-this.i, 0.0f);
        this.f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.e / f;
            this.b.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.l, this.m, this.n}, new float[]{0.0f, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.l, this.m, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.c.setAntiAlias(false);
    }

    private void a(Rect rect) {
        float f = this.h * 1.5f;
        this.d.set(rect.left + this.h, rect.top + f, rect.right - this.h, rect.bottom - f);
        b().setBounds((int) this.d.left, (int) this.d.top, (int) this.d.right, (int) this.d.bottom);
        c();
    }

    public void b(float f) {
        a(f, this.h);
    }

    public float a() {
        return this.j;
    }
}
