package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class ajj extends ajk implements GestureDetector.OnGestureListener {
    private GestureDetector a;
    protected DashboardActivity ae;
    protected Handler af;
    protected boolean ag = false;
    private DashboardActivity.c b;

    public abstract ajv b();

    public void ar() {
    }

    public void e() {
    }

    public void as() {
        this.af.removeCallbacksAndMessages(null);
    }

    @Override // android.support.v4.app.Fragment
    public void C() {
        super.C();
        new Handler().postDelayed(new Runnable() { // from class: ajj.1
            @Override // java.lang.Runnable
            public void run() {
                ajj.this.ae.getWindow().getDecorView().postInvalidate();
            }
        }, 100L);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ag = true;
        mm.b("Creating fragment %s", this);
        this.a = new GestureDetector(this.ae, this);
        this.b = new DashboardActivity.c() { // from class: ajj.2
            @Override // com.harman.hkconnect.ui.DashboardActivity.c
            public boolean a(MotionEvent motionEvent) {
                return ajj.this.a.onTouchEvent(motionEvent);
            }
        };
        this.ae.a(this.b);
        this.af = new Handler();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.ae = (DashboardActivity) activity;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        this.ae.ab();
        if (z) {
            e();
            return;
        }
        ar();
        at();
        ajk ajkVarA = this.ae.q().a();
        if (ajkVarA instanceof avw) {
            avw.a = false;
            ((avw) ajkVarA).d();
            if (avv.ap() != null) {
                avv.ap().b().dismiss();
            }
        }
    }

    public void at() {
        this.ae.l().a(this.ae.q().d());
        this.ae.l().a(b());
    }

    public void a(Class<?>... clsArr) {
        this.ae.a(clsArr);
    }
}
