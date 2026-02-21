package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class iw {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    iw(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, ha.j.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(ha.j.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(ha.j.CompoundButton_android_button, 0)) != 0) {
                this.a.setButtonDrawable(hc.b(this.a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(ha.j.CompoundButton_buttonTint)) {
                fu.a(this.a, typedArrayObtainStyledAttributes.getColorStateList(ha.j.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(ha.j.CompoundButton_buttonTintMode)) {
                fu.a(this.a, js.a(typedArrayObtainStyledAttributes.getInt(ha.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    ColorStateList a() {
        return this.b;
    }

    void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    PorterDuff.Mode b() {
        return this.c;
    }

    void c() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            d();
        }
    }

    void d() {
        Drawable drawableA = fu.a(this.a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = cw.f(drawableA).mutate();
                if (this.d) {
                    cw.a(drawableMutate, this.b);
                }
                if (this.e) {
                    cw.a(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int a(int i) {
        Drawable drawableA;
        if (Build.VERSION.SDK_INT < 17 && (drawableA = fu.a(this.a)) != null) {
            return i + drawableA.getIntrinsicWidth();
        }
        return i;
    }
}
