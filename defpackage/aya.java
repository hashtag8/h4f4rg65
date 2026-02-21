package defpackage;

import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.mixradio.view.MixRadioLoginActivity;

/* JADX INFO: loaded from: classes.dex */
public class aya extends avd {
    private boolean b;
    private arw c;

    public aya(DashboardActivity dashboardActivity) {
        super(dashboardActivity, 0, new ava().a(0, dashboardActivity));
        this.b = false;
        this.c = null;
    }

    @Override // defpackage.avd
    protected void b() {
        axz.a = 0;
        g().q().a(new ayo(), this.a, (arc) null);
    }

    protected void b(boolean z) {
        String strD = aho.d("mixradio_username");
        String strD2 = aho.d("mixradio_userid");
        if (strD == null) {
        }
        if (strD2 == null) {
            strD2 = "";
        }
        if (!aho.b("mixradio_ftu_" + strD2, false)) {
            g().q().a(new ayr(), this.a, (arc) null);
        } else {
            b();
        }
    }

    @Override // defpackage.avd
    protected void a(boolean z) {
        String strD = aho.d("mixradio_username");
        String strD2 = aho.d("mixradio_userid");
        if (strD == null) {
            strD = "";
        }
        if (strD2 == null) {
            strD2 = "";
        }
        if (strD == null) {
        }
        if (!aho.b("mixradio_ftu_" + strD2, false)) {
            g().q().a(new ayr(), this.a, (arc) null);
        } else {
            axz.a = 0;
            g().q().a(new ayo(), this.a, (arc) null);
        }
    }

    @Override // defpackage.avd
    protected void c() {
        a(MixRadioLoginActivity.class);
    }

    @Override // defpackage.avd, defpackage.avc
    public void c_() {
        this.b = true;
        if (ahn.a()) {
            b(true);
        } else {
            a(true);
        }
    }
}
