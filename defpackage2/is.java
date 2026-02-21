package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class is {
    private final View a;
    private kq d;
    private kq e;
    private kq f;
    private int c = -1;
    private final ix b = ix.a();

    is(View view) {
        this.a = view;
    }

    void a(AttributeSet attributeSet, int i) {
        ks ksVarA = ks.a(this.a.getContext(), attributeSet, ha.j.ViewBackgroundHelper, i, 0);
        try {
            if (ksVarA.g(ha.j.ViewBackgroundHelper_android_background)) {
                this.c = ksVarA.g(ha.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListB = this.b.b(this.a.getContext(), this.c);
                if (colorStateListB != null) {
                    b(colorStateListB);
                }
            }
            if (ksVarA.g(ha.j.ViewBackgroundHelper_backgroundTint)) {
                fb.a(this.a, ksVarA.e(ha.j.ViewBackgroundHelper_backgroundTint));
            }
            if (ksVarA.g(ha.j.ViewBackgroundHelper_backgroundTintMode)) {
                fb.a(this.a, js.a(ksVarA.a(ha.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            ksVarA.a();
        }
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new kq();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    ColorStateList a() {
        if (this.e != null) {
            return this.e.a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new kq();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.b;
        }
        return null;
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (!d() || !b(background)) {
                if (this.e != null) {
                    ix.a(background, this.e, this.a.getDrawableState());
                } else if (this.d != null) {
                    ix.a(background, this.d, this.a.getDrawableState());
                }
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new kq();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new kq();
        }
        kq kqVar = this.f;
        kqVar.a();
        ColorStateList colorStateListR = fb.r(this.a);
        if (colorStateListR != null) {
            kqVar.d = true;
            kqVar.a = colorStateListR;
        }
        PorterDuff.Mode modeS = fb.s(this.a);
        if (modeS != null) {
            kqVar.c = true;
            kqVar.b = modeS;
        }
        if (!kqVar.d && !kqVar.c) {
            return false;
        }
        ix.a(drawable, kqVar, this.a.getDrawableState());
        return true;
    }
}
