package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.harman.hkconnect.R;
import defpackage.agu;
import defpackage.ahn;
import defpackage.aib;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceAutoCompleteTextView extends AutoCompleteTextView {
    private boolean a;

    public TypefaceAutoCompleteTextView(Context context) {
        super(context);
        this.a = false;
    }

    public TypefaceAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        a(context, attributeSet);
    }

    public TypefaceAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (ahn.a()) {
            setDropDownWidth((ahn.a(context).a() * 2) / 3);
        }
        if (attributeSet != null) {
            b(context, attributeSet);
        }
    }

    public void setIsAutoCompleteEnabled(boolean z) {
        this.a = z;
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        if (this.a) {
            return true;
        }
        return super.enoughToFilter();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && getAdapter() != null && this.a) {
            performFiltering(getText(), 0);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    protected void replaceText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(getContext().getString(R.string.PlayListClearAll_Str))) {
            super.replaceText(charSequence);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.TypefaceTextView);
        setTypeface(agu.a(context, typedArrayObtainStyledAttributes.getInt(1, 0), attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0)));
        typedArrayObtainStyledAttributes.recycle();
    }
}
