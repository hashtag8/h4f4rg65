package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;
import defpackage.ajo;

/* JADX INFO: loaded from: classes.dex */
public class ajp extends ajo {
    boolean l;
    boolean m;
    private GestureDetector.OnGestureListener n;

    public ajp(DashboardActivity dashboardActivity, ControlInterceptTouchScrollView controlInterceptTouchScrollView) {
        super(dashboardActivity, controlInterceptTouchScrollView, controlInterceptTouchScrollView);
        this.l = false;
        this.m = false;
        this.n = new GestureDetector.OnGestureListener() { // from class: ajp.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                View.OnClickListener onClickListener;
                if (ajp.this.h == null) {
                    ajp.this.h = new ajo.a(motionEvent);
                }
                if (ajp.this.l && !ajp.this.h.a() && (onClickListener = (View.OnClickListener) ajp.this.f.getTag(R.id.view_tag_clicklistener)) != null) {
                    onClickListener.onClick(ajp.this.f);
                }
                ajp.this.d.removeCallbacks(ajp.this.h);
                ajp.this.m = false;
                ajp.this.l = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (ajp.this.l) {
                    if (ajp.this.h == null) {
                        ajp.this.h = new ajo.a(motionEvent);
                    }
                    if (ajp.this.g) {
                        ajp.this.d.postDelayed(ajp.this.h, 250L);
                    }
                    ajp.this.m = true;
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (ajo.c && ajp.this.e != null) {
                    ajp.this.a((int) motionEvent2.getX(), (int) motionEvent2.getY(), motionEvent2);
                    return true;
                }
                ajp.this.d.removeCallbacks(ajp.this.h);
                ajp.this.l = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }
        };
        this.a = new GestureDetector(this.b, this.n);
        this.a.setIsLongpressEnabled(false);
    }

    @Override // defpackage.ajo, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != this.i) {
            this.f = view;
            this.l = true;
            return false;
        }
        this.a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && c) {
            a(this.f, motionEvent);
            this.l = false;
            return true;
        }
        return c;
    }

    @Override // defpackage.ajo
    protected View a(MotionEvent motionEvent) {
        return this.f;
    }

    @Override // defpackage.ajo
    protected float a(float f) {
        int left = 0;
        for (View view = this.f; view != this.i; view = (View) view.getParent()) {
            left += view.getLeft();
        }
        return (((f - ahn.a(this.b, 27.0f)) - left) + this.i.getScrollX()) / (this.f.getWidth() - ahn.a(this.b, 55.0f));
    }

    @Override // defpackage.ajo
    protected float b(float f) {
        int top = 0;
        for (View view = this.f; view != this.i; view = (View) view.getParent()) {
            top += view.getTop();
        }
        return (((f - ahn.a(this.b, 27.0f)) - top) + this.i.getScrollY()) / Math.abs(this.f.getHeight() - ahn.a(this.b, 55.0f));
    }

    @Override // defpackage.ajo
    protected int d() {
        return 0;
    }

    @Override // defpackage.ajo
    protected Object b(MotionEvent motionEvent) {
        return null;
    }

    @Override // defpackage.ajo
    protected View e() {
        View viewE = super.e();
        if (viewE == null) {
            return ((ViewGroup) this.f).getChildAt(0);
        }
        return viewE;
    }

    @Override // defpackage.ajo
    protected int c(float f) {
        int top = 0;
        for (View view = this.f; view != this.i; view = (View) view.getParent()) {
            top += view.getTop();
        }
        return (((int) f) - top) + this.i.getScrollY();
    }
}
