package com.harman.hkconnect.musicservice.musicserver.qobuz;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes.dex */
public class WrapContentGridView extends GridView {
    public WrapContentGridView(Context context) {
        super(context);
    }

    public WrapContentGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapContentGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
