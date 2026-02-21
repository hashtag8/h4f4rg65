package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;
import defpackage.agu;
import defpackage.aib;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCheckBox extends CheckBox {
    public TypefaceCheckBox(Context context) {
        super(context);
    }

    public TypefaceCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            a(context, attributeSet);
        }
    }

    public TypefaceCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            a(context, attributeSet);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.TypefaceTextView);
        setTypeface(agu.a(context, typedArrayObtainStyledAttributes.getInt(1, 0), attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0)));
        typedArrayObtainStyledAttributes.recycle();
    }
}
