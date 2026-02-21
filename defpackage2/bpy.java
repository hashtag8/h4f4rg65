package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class bpy extends Drawable {
    private a a;
    private final Paint b;

    public bpy() {
        this((a) null);
    }

    public bpy(int i) {
        this((a) null);
        a(i);
    }

    private bpy(a aVar) {
        this.b = new Paint();
        this.a = new a(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if ((this.a.b >>> 24) != 0) {
            this.b.setColor(this.a.b);
            canvas.drawRect(getBounds(), this.b);
        }
    }

    public void a(int i) {
        if (this.a.a != i || this.a.b != i) {
            invalidateSelf();
            a aVar = this.a;
            this.a.b = i;
            aVar.a = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.a.b >>> 24;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        int i2 = (((i >> 7) + i) * (this.a.a >>> 24)) >> 8;
        int i3 = this.a.b;
        this.a.b = (i2 << 24) | ((this.a.a << 8) >>> 8);
        if (i3 != this.a.b) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        switch (this.a.b >>> 24) {
            case 0:
                return -2;
            case 255:
                return -1;
            default:
                return -3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.a.c = getChangingConfigurations();
        return this.a;
    }

    static final class a extends Drawable.ConstantState {
        int a;
        int b;
        int c;

        a(a aVar) {
            if (aVar != null) {
                this.a = aVar.a;
                this.b = aVar.b;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new bpy(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new bpy(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.c;
        }
    }
}
