package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class ji extends je {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    ji(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.a = seekBar;
    }

    @Override // defpackage.je
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ks ksVarA = ks.a(this.a.getContext(), attributeSet, ha.j.AppCompatSeekBar, i, 0);
        Drawable drawableB = ksVarA.b(ha.j.AppCompatSeekBar_android_thumb);
        if (drawableB != null) {
            this.a.setThumb(drawableB);
        }
        a(ksVarA.a(ha.j.AppCompatSeekBar_tickMark));
        if (ksVarA.g(ha.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = js.a(ksVarA.a(ha.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (ksVarA.g(ha.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = ksVarA.e(ha.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        ksVarA.a();
        d();
    }

    void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.a);
            cw.b(drawable, fb.f(this.a));
            if (drawable.isStateful()) {
                drawable.setState(this.a.getDrawableState());
            }
            d();
        }
        this.a.invalidate();
    }

    private void d() {
        if (this.b != null) {
            if (this.e || this.f) {
                this.b = cw.f(this.b.mutate());
                if (this.e) {
                    cw.a(this.b, this.c);
                }
                if (this.f) {
                    cw.a(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.a.getDrawableState());
                }
            }
        }
    }

    void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable);
        }
    }

    void a(Canvas canvas) {
        int max;
        if (this.b != null && (max = this.a.getMax()) > 1) {
            int intrinsicWidth = this.b.getIntrinsicWidth();
            int intrinsicHeight = this.b.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.b.setBounds(-i, -i2, i, i2);
            float width = ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) / max;
            int iSave = canvas.save();
            canvas.translate(this.a.getPaddingLeft(), this.a.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.b.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(iSave);
        }
    }
}
