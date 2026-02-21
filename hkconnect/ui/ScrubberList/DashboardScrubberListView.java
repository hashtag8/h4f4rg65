package com.harman.hkconnect.ui.ScrubberList;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.aqw;
import defpackage.ml;

/* JADX INFO: loaded from: classes.dex */
public class DashboardScrubberListView extends ListView {
    private boolean a;
    private aqw b;
    private GestureDetector c;
    private boolean d;
    private DashboardActivity e;

    public DashboardScrubberListView(Context context) {
        this(context, null);
    }

    public DashboardScrubberListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = false;
        try {
            this.e = (DashboardActivity) context;
        } catch (ClassCastException e) {
            new ml().a("DashboardScrubber does not have DashboardActivity as its context.", e);
        }
    }

    public DashboardScrubberListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = false;
        try {
            this.e = (DashboardActivity) context;
        } catch (ClassCastException e) {
            new ml().a("DashboardScrubber does not have DashboardActivity as its context.", e);
        }
    }

    @Override // android.widget.AbsListView
    public boolean isFastScrollEnabled() {
        return this.a;
    }

    public void setIndexScrollerListener(aqw.a aVar) {
        this.b.a(aVar);
    }

    public void a() {
        if (getAdapter() != null) {
            throw new RuntimeException("Cannot disable now, Adapter has already been set");
        }
        this.d = true;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        if (this.d) {
            super.setFastScrollEnabled(z);
            return;
        }
        this.a = z;
        if (this.a) {
            if (this.b == null) {
                this.b = new aqw(getContext(), this);
            }
        } else if (this.b != null) {
            this.b.b();
            this.b = null;
        }
    }

    public void b() {
        this.d = true;
    }

    public void c() {
        this.d = false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.d && this.b != null) {
            this.b.a(canvas);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.e != null) {
            this.e.O();
        }
        if (this.b != null && this.b.a(motionEvent)) {
            if (this.e == null) {
                return true;
            }
            this.e.N();
            return true;
        }
        if (this.c == null) {
            this.c = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent2, MotionEvent motionEvent3, float f, float f2) {
                    if (DashboardScrubberListView.this.b != null) {
                        DashboardScrubberListView.this.b.a();
                    }
                    return super.onFling(motionEvent2, motionEvent3, f, f2);
                }
            });
        }
        this.c.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.b.a(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.b != null) {
            this.b.a(listAdapter);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.d && this.b != null) {
            this.b.a(i, i2, i3, i4);
        }
    }
}
