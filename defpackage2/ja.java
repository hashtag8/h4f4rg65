package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class ja {
    private final ImageView a;
    private kq b;
    private kq c;
    private kq d;

    public ja(ImageView imageView) {
        this.a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int iG;
        ks ksVarA = ks.a(this.a.getContext(), attributeSet, ha.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iG = ksVarA.g(ha.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = hc.b(this.a.getContext(), iG)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                js.a(drawable);
            }
            if (ksVarA.g(ha.j.AppCompatImageView_tint)) {
                fy.a(this.a, ksVarA.e(ha.j.AppCompatImageView_tint));
            }
            if (ksVarA.g(ha.j.AppCompatImageView_tintMode)) {
                fy.a(this.a, js.a(ksVarA.a(ha.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            ksVarA.a();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable drawableB = hc.b(this.a.getContext(), i);
            if (drawableB != null) {
                js.a(drawableB);
            }
            this.a.setImageDrawable(drawableB);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new kq();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    ColorStateList b() {
        if (this.c != null) {
            return this.c.a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new kq();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            js.a(drawable);
        }
        if (drawable != null) {
            if (!e() || !a(drawable)) {
                if (this.c != null) {
                    ix.a(drawable, this.c, this.a.getDrawableState());
                } else if (this.b != null) {
                    ix.a(drawable, this.b, this.a.getDrawableState());
                }
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new kq();
        }
        kq kqVar = this.d;
        kqVar.a();
        ColorStateList colorStateListA = fy.a(this.a);
        if (colorStateListA != null) {
            kqVar.d = true;
            kqVar.a = colorStateListA;
        }
        PorterDuff.Mode modeB = fy.b(this.a);
        if (modeB != null) {
            kqVar.c = true;
            kqVar.b = modeB;
        }
        if (!kqVar.d && !kqVar.c) {
            return false;
        }
        ix.a(drawable, kqVar, this.a.getDrawableState());
        return true;
    }
}
