package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class MarqueeTypefaceTextView extends TypefaceTextView {
    public MarqueeTypefaceTextView(Context context) {
        super(context);
    }

    public MarqueeTypefaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTypefaceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }
}
