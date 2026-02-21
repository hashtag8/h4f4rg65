package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class o extends Drawable {
    final Paint a;
    final Rect b;
    final RectF c;
    float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ColorStateList i;
    private int j;
    private boolean k;
    private float l;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            this.a.setShader(a());
            this.k = false;
        }
        float strokeWidth = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iRound = Math.round(this.d);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.j = colorStateList.getColorForState(getState(), this.j);
        }
        this.i = colorStateList;
        this.k = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.d > 0.0f ? -3 : -2;
    }

    final void a(float f) {
        if (f != this.l) {
            this.l = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.i != null && this.i.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.i != null && (colorForState = this.i.getColorForState(iArr, this.j)) != this.j) {
            this.k = true;
            this.j = colorForState;
        }
        if (this.k) {
            invalidateSelf();
        }
        return this.k;
    }

    private Shader a() {
        copyBounds(this.b);
        float fHeight = this.d / r3.height();
        return new LinearGradient(0.0f, r3.top, 0.0f, r3.bottom, new int[]{co.a(this.e, this.j), co.a(this.f, this.j), co.a(co.b(this.f, 0), this.j), co.a(co.b(this.h, 0), this.j), co.a(this.h, this.j), co.a(this.g, this.j)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }
}
