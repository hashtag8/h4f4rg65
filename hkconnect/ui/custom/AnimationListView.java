package com.harman.hkconnect.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajn;
import defpackage.ajo;
import defpackage.arp;

/* JADX INFO: loaded from: classes.dex */
public class AnimationListView extends ListView {
    public static boolean a = true;
    public static boolean b = false;
    private ajo c;
    private int d;
    private boolean e;
    private Class<?> f;

    public AnimationListView(Context context) {
        super(context);
        this.e = b;
        b();
    }

    public AnimationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = b;
        b();
    }

    public AnimationListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = b;
        b();
    }

    @TargetApi(21)
    public AnimationListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = b;
        b();
    }

    private void b() {
        this.c = new ajo((DashboardActivity) getContext(), this);
        setOnTouchListener(this.c);
    }

    public void setCallback(ajo.b bVar) {
        this.c.a(bVar);
    }

    public void setOffsetFooterFlag(boolean z) {
        this.e = z;
    }

    public void setExpectedClassType(Class<?> cls) {
        this.f = cls;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (!this.e) {
            new arp(this).a();
            this.e = true;
        }
    }

    public void setAllowDrag(boolean z) {
        this.c.a(z);
    }

    public void setOnItemChosenListener(final ajn ajnVar) {
        this.c.a(ajnVar);
        if (getOnItemClickListener() == null) {
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.ui.custom.AnimationListView.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long j) {
                    final Object itemAtPosition = adapterView.getItemAtPosition(i);
                    if (itemAtPosition != null) {
                        if (AnimationListView.this.f != null && !itemAtPosition.getClass().equals(AnimationListView.this.f)) {
                            ajnVar.a(adapterView, i, itemAtPosition);
                            return;
                        } else {
                            ((DashboardActivity) AnimationListView.this.getContext()).a(new Runnable() { // from class: com.harman.hkconnect.ui.custom.AnimationListView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ajnVar.a(adapterView, i, itemAtPosition);
                                }
                            });
                            return;
                        }
                    }
                    ajnVar.a(adapterView, i, itemAtPosition);
                }
            });
        }
    }

    public void setLeftMargin(int i) {
        this.d = i;
    }

    public int getLeftMargin() {
        return this.d;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        if (getChildCount() > 0) {
            return getFirstVisiblePosition() > 0 || getChildAt(0).getTop() < getPaddingTop();
        }
        return false;
    }
}
