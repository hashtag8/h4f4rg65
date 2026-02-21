package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import defpackage.agu;
import defpackage.aib;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceButton extends Button {
    public TypefaceButton(Context context) {
        super(context);
    }

    public TypefaceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TypefaceButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            b(context, attributeSet);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.TypefaceTextView);
        setTypeface(agu.a(context, typedArrayObtainStyledAttributes.getInt(1, 0), attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0)));
        typedArrayObtainStyledAttributes.recycle();
    }
}
