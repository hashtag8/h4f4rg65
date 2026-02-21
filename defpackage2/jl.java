package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class jl extends jk {
    private kq b;
    private kq c;

    jl(TextView textView) {
        super(textView);
    }

    @Override // defpackage.jk
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        ix ixVarA = ix.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha.j.AppCompatTextHelper, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTextHelper_android_drawableStart)) {
            this.b = a(context, ixVarA, typedArrayObtainStyledAttributes.getResourceId(ha.j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTextHelper_android_drawableEnd)) {
            this.c = a(context, ixVarA, typedArrayObtainStyledAttributes.getResourceId(ha.j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // defpackage.jk
    void a() {
        super.a();
        if (this.b != null || this.c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.b);
            a(compoundDrawablesRelative[2], this.c);
        }
    }
}
