package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationViewPager;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;

/* JADX INFO: loaded from: classes.dex */
public class ajq extends ajo {
    private AnimationViewPager l;

    public ajq(DashboardActivity dashboardActivity, AnimationViewPager animationViewPager, ControlInterceptTouchScrollView controlInterceptTouchScrollView) {
        super(dashboardActivity, animationViewPager, controlInterceptTouchScrollView);
        this.l = animationViewPager;
    }

    @Override // defpackage.ajo, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3) {
            this.d.removeCallbacks(this.h);
        } else if (motionEvent.getAction() == 1 && c) {
            a(view, motionEvent);
            return true;
        }
        return c;
    }

    @Override // defpackage.ajo
    protected View a(MotionEvent motionEvent) {
        View viewA = ((AnimationViewPager.a) this.l.getAdapter()).a(this.l.getCurrentItem());
        if (this.j != null) {
            return this.j.a((ViewGroup) viewA, motionEvent);
        }
        return viewA;
    }

    @Override // defpackage.ajo
    protected float a(float f) {
        int left = this.f.getLeft();
        if (this.f.getParent() == this.l) {
            left -= this.l.getCurrentItem() * this.f.getWidth();
        }
        return ((f - ahn.a(this.b, 27.0f)) - left) / (this.f.getWidth() - ahn.a(this.b, 55.0f));
    }

    @Override // defpackage.ajo
    protected float b(float f) {
        return ((f - ahn.a(this.b, 27.0f)) - this.f.getTop()) / Math.abs(this.f.getHeight() - ahn.a(this.b, 55.0f));
    }

    @Override // defpackage.ajo
    protected int d() {
        return this.l.getCurrentItem();
    }

    @Override // defpackage.ajo
    protected Object b(MotionEvent motionEvent) {
        if (this.j != null) {
            return this.j.a(this.f, this.l, motionEvent);
        }
        return ((AnimationViewPager.a) this.l.getAdapter()).b(this.l.getCurrentItem());
    }
}
