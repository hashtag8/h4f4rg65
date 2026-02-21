package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class bbg extends Drawable {
    private final float a;
    private final BitmapShader d;
    private final int f;
    private final RectF b = new RectF();
    private final Rect c = new Rect();
    private final Paint e = new Paint();

    public bbg(Bitmap bitmap, float f, int i) {
        this.a = f;
        this.d = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.e.setAntiAlias(true);
        this.e.setShader(this.d);
        this.f = i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b.set(this.f, this.f, rect.width() - this.f, rect.height() - this.f);
        this.c.set(this.f, (rect.height() - this.f) / 2, rect.width() - this.f, rect.height() - this.f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.b, this.a, this.a, this.e);
        canvas.drawRect(this.c, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }
}
