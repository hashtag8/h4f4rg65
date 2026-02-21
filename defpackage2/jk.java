package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class jk {
    final TextView a;
    private kq b;
    private kq c;
    private kq d;
    private kq e;
    private final jn f;
    private int g = 0;
    private Typeface h;

    static jk a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new jl(textView) : new jk(textView);
    }

    jk(TextView textView) {
        this.a = textView;
        this.f = new jn(this.a);
    }

    void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListE;
        ColorStateList colorStateListE2;
        boolean z;
        boolean zA;
        ColorStateList colorStateListE3 = null;
        Context context = this.a.getContext();
        ix ixVarA = ix.a();
        ks ksVarA = ks.a(context, attributeSet, ha.j.AppCompatTextHelper, i, 0);
        int iG = ksVarA.g(ha.j.AppCompatTextHelper_android_textAppearance, -1);
        if (ksVarA.g(ha.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, ixVarA, ksVarA.g(ha.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (ksVarA.g(ha.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, ixVarA, ksVarA.g(ha.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (ksVarA.g(ha.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, ixVarA, ksVarA.g(ha.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (ksVarA.g(ha.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, ixVarA, ksVarA.g(ha.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        ksVarA.a();
        boolean z2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iG != -1) {
            ks ksVarA2 = ks.a(context, iG, ha.j.TextAppearance);
            if (z2 || !ksVarA2.g(ha.j.TextAppearance_textAllCaps)) {
                z = false;
                zA = false;
            } else {
                zA = ksVarA2.a(ha.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, ksVarA2);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateListE2 = ksVarA2.g(ha.j.TextAppearance_android_textColor) ? ksVarA2.e(ha.j.TextAppearance_android_textColor) : null;
                colorStateListE = ksVarA2.g(ha.j.TextAppearance_android_textColorHint) ? ksVarA2.e(ha.j.TextAppearance_android_textColorHint) : null;
                if (ksVarA2.g(ha.j.TextAppearance_android_textColorLink)) {
                    colorStateListE3 = ksVarA2.e(ha.j.TextAppearance_android_textColorLink);
                }
            } else {
                colorStateListE = null;
                colorStateListE2 = null;
            }
            ksVarA2.a();
        } else {
            colorStateListE = null;
            colorStateListE2 = null;
            z = false;
            zA = false;
        }
        ks ksVarA3 = ks.a(context, attributeSet, ha.j.TextAppearance, i, 0);
        if (!z2 && ksVarA3.g(ha.j.TextAppearance_textAllCaps)) {
            zA = ksVarA3.a(ha.j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (ksVarA3.g(ha.j.TextAppearance_android_textColor)) {
                colorStateListE2 = ksVarA3.e(ha.j.TextAppearance_android_textColor);
            }
            if (ksVarA3.g(ha.j.TextAppearance_android_textColorHint)) {
                colorStateListE = ksVarA3.e(ha.j.TextAppearance_android_textColorHint);
            }
            if (ksVarA3.g(ha.j.TextAppearance_android_textColorLink)) {
                colorStateListE3 = ksVarA3.e(ha.j.TextAppearance_android_textColorLink);
            }
        }
        a(context, ksVarA3);
        ksVarA3.a();
        if (colorStateListE2 != null) {
            this.a.setTextColor(colorStateListE2);
        }
        if (colorStateListE != null) {
            this.a.setHintTextColor(colorStateListE);
        }
        if (colorStateListE3 != null) {
            this.a.setLinkTextColor(colorStateListE3);
        }
        if (!z2 && z) {
            a(zA);
        }
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
        this.f.a(attributeSet, i);
        if (Build.VERSION.SDK_INT >= 26 && this.f.a() != 0) {
            int[] iArrE = this.f.e();
            if (iArrE.length > 0) {
                if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArrE, 0);
                }
            }
        }
    }

    private void a(Context context, ks ksVar) {
        this.g = ksVar.a(ha.j.TextAppearance_android_textStyle, this.g);
        if (ksVar.g(ha.j.TextAppearance_android_fontFamily) || ksVar.g(ha.j.TextAppearance_fontFamily)) {
            this.h = null;
            int i = ksVar.g(ha.j.TextAppearance_android_fontFamily) ? ha.j.TextAppearance_android_fontFamily : ha.j.TextAppearance_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.h = ksVar.a(i, this.g, this.a);
                } catch (Resources.NotFoundException e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
            if (this.h == null) {
                this.h = Typeface.create(ksVar.d(i), this.g);
            }
        }
    }

    void a(Context context, int i) {
        ColorStateList colorStateListE;
        ks ksVarA = ks.a(context, i, ha.j.TextAppearance);
        if (ksVarA.g(ha.j.TextAppearance_textAllCaps)) {
            a(ksVarA.a(ha.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && ksVarA.g(ha.j.TextAppearance_android_textColor) && (colorStateListE = ksVarA.e(ha.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(colorStateListE);
        }
        a(context, ksVarA);
        ksVarA.a();
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    final void a(Drawable drawable, kq kqVar) {
        if (drawable != null && kqVar != null) {
            ix.a(drawable, kqVar, this.a.getDrawableState());
        }
    }

    protected static kq a(Context context, ix ixVar, int i) {
        ColorStateList colorStateListB = ixVar.b(context, i);
        if (colorStateListB == null) {
            return null;
        }
        kq kqVar = new kq();
        kqVar.d = true;
        kqVar.a = colorStateListB;
        return kqVar;
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT < 26) {
            b();
        }
    }

    void a(int i, float f) {
        if (Build.VERSION.SDK_INT < 26 && !c()) {
            b(i, f);
        }
    }

    void b() {
        this.f.f();
    }

    boolean c() {
        return this.f.g();
    }

    private void b(int i, float f) {
        this.f.a(i, f);
    }

    void a(int i) {
        this.f.a(i);
    }

    void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    void a(int[] iArr, int i) {
        this.f.a(iArr, i);
    }

    int d() {
        return this.f.a();
    }

    int e() {
        return this.f.b();
    }

    int f() {
        return this.f.c();
    }

    int g() {
        return this.f.d();
    }

    int[] h() {
        return this.f.e();
    }
}
