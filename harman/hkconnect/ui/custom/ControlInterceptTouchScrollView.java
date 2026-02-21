package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class ControlInterceptTouchScrollView extends ScrollView {
    private boolean a;

    public ControlInterceptTouchScrollView(Context context) {
        super(context);
        this.a = true;
    }

    public ControlInterceptTouchScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public ControlInterceptTouchScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }

    public ControlInterceptTouchScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = true;
    }

    public void a() {
        this.a = false;
    }

    public void b() {
        this.a = true;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
