package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class ark extends Drawable {
    private int c;
    private int d;
    private int e;
    private RectF f;
    private Paint g;
    private Path h;
    private float b = -90.0f;
    private float a = 0.0f;

    public ark(int i, int i2, int i3) {
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public void a(float f) {
        this.a = f;
    }

    public int a() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.h == null) {
            this.h = new Path();
        }
        this.h.reset();
        this.h.addArc(b(), this.b, this.a);
        this.h.offset(bounds.left, bounds.top);
        canvas.drawPath(this.h, c());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 1;
    }

    private RectF b() {
        if (this.f == null) {
            int i = this.d / 2;
            this.f = new RectF(i, i, a() - i, a() - i);
        }
        return this.f;
    }

    private Paint c() {
        if (this.g == null) {
            this.g = new Paint();
            this.g.setAntiAlias(true);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeWidth(this.d);
            this.g.setColor(this.e);
        }
        return this.g;
    }
}
