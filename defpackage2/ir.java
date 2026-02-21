package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class ir extends AutoCompleteTextView implements ez {
    private static final int[] a = {R.attr.popupBackground};
    private final is b;
    private final jk c;

    public ir(Context context) {
        this(context, null);
    }

    public ir(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ha.a.autoCompleteTextViewStyle);
    }

    public ir(Context context, AttributeSet attributeSet, int i) {
        super(kp.a(context), attributeSet, i);
        ks ksVarA = ks.a(getContext(), attributeSet, a, i, 0);
        if (ksVarA.g(0)) {
            setDropDownBackgroundDrawable(ksVarA.a(0));
        }
        ksVarA.a();
        this.b = new is(this);
        this.b.a(attributeSet, i);
        this.c = jk.a(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(hc.b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    @Override // defpackage.ez
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Override // defpackage.ez
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    @Override // defpackage.ez
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    @Override // defpackage.ez
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }
}
