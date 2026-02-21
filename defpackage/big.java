package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
final class big extends BitmapDrawable {
    private static final Paint e = new Paint();
    Drawable a;
    long b;
    boolean c;
    int d;
    private final boolean f;
    private final float g;
    private final bif.d h;

    static void a(ImageView imageView, Context context, Bitmap bitmap, bif.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new big(context, bitmap, drawable, dVar, z, z2));
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    big(Context context, Bitmap bitmap, Drawable drawable, bif.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.d = 255;
        this.f = z2;
        this.g = context.getResources().getDisplayMetrics().density;
        this.h = dVar;
        if ((dVar == bif.d.MEMORY || z) ? false : true) {
            this.a = drawable;
            this.c = true;
            this.b = SystemClock.uptimeMillis();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.c) {
            super.draw(canvas);
        } else {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.b) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.c = false;
                this.a = null;
                super.draw(canvas);
            } else {
                if (this.a != null) {
                    this.a.draw(canvas);
                }
                super.setAlpha((int) (fUptimeMillis * this.d));
                super.draw(canvas);
                super.setAlpha(this.d);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d = i;
        if (this.a != null) {
            this.a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void a(Canvas canvas) {
        e.setColor(-1);
        canvas.drawPath(a(new Point(0, 0), (int) (16.0f * this.g)), e);
        e.setColor(this.h.d);
        canvas.drawPath(a(new Point(0, 0), (int) (15.0f * this.g)), e);
    }

    private static Path a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
