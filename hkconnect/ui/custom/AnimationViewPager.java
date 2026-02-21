package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajn;
import defpackage.ajo;
import defpackage.ajq;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class AnimationViewPager extends ViewPager {
    ajq d;
    private boolean e;

    public interface a {
        View a(int i);

        Object b(int i);
    }

    public AnimationViewPager(Context context) {
        super(context);
        this.e = false;
    }

    public AnimationViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
    }

    public void a(ControlInterceptTouchScrollView controlInterceptTouchScrollView, boolean z) {
        a(controlInterceptTouchScrollView, z, (ajo.b) null);
    }

    public void a(ControlInterceptTouchScrollView controlInterceptTouchScrollView, boolean z, ajo.b bVar) {
        this.d = new ajq((DashboardActivity) getContext(), this, controlInterceptTouchScrollView);
        this.d.a(bVar);
        setOnTouchListener(this.d);
        this.e = z;
    }

    public void setOnItemChosenListener(ajn ajnVar) {
        this.d.a(ajnVar);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.e) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.d.onTouch(this, motionEvent);
        if (!ajo.c) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        mm.b("Intercepting children's touch events.", new Object[0]);
        return true;
    }
}
