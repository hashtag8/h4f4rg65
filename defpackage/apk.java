package defpackage;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apk extends aoj implements View.OnClickListener {
    private static int al = 0;
    private static int am = 1;
    private TextView a;
    private ImageView ae;
    private ImageView af;
    private ImageView ag;
    private ImageView ah;
    private int ai = 0;
    private View aj;
    private Dialog ak;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private ImageView i;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        a(true);
        this.aj = layoutInflater.inflate(R.layout.setup_channel_master_layout, (ViewGroup) null);
        this.a = (TextView) this.aj.findViewById(R.id.master_left_tv);
        this.b = (TextView) this.aj.findViewById(R.id.master_right_tv);
        this.c = (TextView) this.aj.findViewById(R.id.left_device_tv);
        this.d = (TextView) this.aj.findViewById(R.id.right_device_tv);
        this.e = (LinearLayout) this.aj.findViewById(R.id.left);
        this.f = (LinearLayout) this.aj.findViewById(R.id.right);
        this.g = (LinearLayout) this.aj.findViewById(R.id.left_layout);
        this.h = (LinearLayout) this.aj.findViewById(R.id.right_layout);
        this.ae = (ImageView) this.aj.findViewById(R.id.left_device);
        this.af = (ImageView) this.aj.findViewById(R.id.right_device);
        this.ag = (ImageView) this.aj.findViewById(R.id.left_checkbox_state);
        this.ah = (ImageView) this.aj.findViewById(R.id.right_checkbox_state);
        this.i = (ImageView) this.aj.findViewById(R.id.fly_view);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.ak = b(p());
        return this.aj;
    }

    private void am() {
        if (an().n() != null && !an().n().v().isEmpty()) {
            if (an().n().v().get(0) != null) {
                this.c.setText(an().n().v().get(0).x());
                this.ae.setImageResource(an().n().v().get(0).A());
            }
            if (an().n().v().get(1) != null) {
                this.d.setText(an().n().v().get(1).x());
                this.af.setImageResource(an().n().v().get(1).A());
            }
        }
    }

    private void at() {
        if (this.ai == am) {
            a(this.b, this.ah);
            b(this.a, this.ag);
            if (an().n().v().get(1) != null) {
                an().n().v().get(al).f(1);
                an().n().v().get(am).f(0);
                an().n().a(an().n().v().get(am).P());
                return;
            }
            return;
        }
        a(this.a, this.ag);
        b(this.b, this.ah);
        if (an().n().v().get(0) != null) {
            an().n().v().get(al).f(0);
            an().n().v().get(am).f(1);
            an().n().a(an().n().v().get(al).P());
        }
    }

    private void a(TextView textView, ImageView imageView) {
        textView.setTextColor(q().getColor(R.color.blue_bg));
        imageView.setImageResource(R.drawable.checkbox_active);
    }

    private void b(TextView textView, ImageView imageView) {
        textView.setTextColor(q().getColor(R.color.gray_1));
        imageView.setImageResource(R.drawable.checkbox_inactive);
    }

    private void ax() {
        float f;
        float f2 = 0.0f;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.e.getLocationOnScreen(iArr);
        this.f.getLocationOnScreen(iArr2);
        if (this.ai == 0) {
            f = iArr2[0] - iArr[0];
        } else {
            float f3 = iArr2[0] - iArr[0];
            f = 0.0f;
            f2 = f3;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.i, "translationX", f, f2);
        at();
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().b(a(R.string.Done_Str));
        an().c(a(R.string.kSetupConfigureSpeakers_Str));
        am();
        adw.a().a(an().n().v().get(al));
        at();
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
        an().b(a(R.string.Next_Str));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_layout /* 2131690903 */:
                adw.a().a(an().n().v().get(al));
                if (this.ai == am) {
                    this.ai = al;
                    ax();
                }
                break;
            case R.id.right_layout /* 2131690909 */:
                adw.a().a(an().n().v().get(am));
                if (this.ai == al) {
                    this.ai = am;
                    ax();
                }
                break;
        }
    }

    @Override // defpackage.aoj
    public void e() {
        super.e();
        adw.a().d(an().n().v().get(al), 23);
        adw.a().d(an().n().v().get(am), 23);
        an().n().w();
        a(this.ak, p());
        b(a(an().n().v()));
    }

    private List<adx> a(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            if (adxVar != null) {
                arrayList.add(aof.a().a(adxVar.P()));
            }
        }
        return arrayList;
    }

    private void b(final List<adx> list) {
        mq.b().b(new Runnable() { // from class: apk.1
            @Override // java.lang.Runnable
            public void run() {
                final boolean z = false;
                for (int i = 0; i < 25; i++) {
                    mm.c("Wait for device to come online ------ WAITING", Integer.valueOf(i));
                    boolean z2 = (list == null || list.isEmpty()) ? false : true;
                    Iterator it = list.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        adx adxVar = (adx) it.next();
                        z2 = (!z || adxVar == null || adxVar.s() == 0) ? false : true;
                        mm.c("Wait for device to come online ------ isConnected---- " + z2, new Object[0]);
                    }
                    if (z) {
                        break;
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                apk.this.a(new Runnable() { // from class: apk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        apk.this.b(apk.this.ak, apk.this.p());
                        if (z) {
                            mm.c("Wait for device to come online ------ SETUP SUCCESS---- ", new Object[0]);
                            apk.this.an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                        } else {
                            mm.c("Wait for device to come online ------ SETUP FAILED---- ", new Object[0]);
                            apk.this.an().a(aoi.SETUP_FAIL, (Bundle) null);
                        }
                    }
                });
            }
        });
    }
}
