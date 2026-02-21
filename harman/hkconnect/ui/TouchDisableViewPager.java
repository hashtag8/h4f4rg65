package com.harman.hkconnect.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class TouchDisableViewPager extends ViewPager {
    private boolean d;

    public TouchDisableViewPager(Context context) {
        super(context);
        this.d = true;
    }

    public TouchDisableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
    }

    public void setCanSwipe(boolean z) {
        this.d = z;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
