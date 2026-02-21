package defpackage;

import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.tidal.view.TidalLoginActivity;

/* JADX INFO: loaded from: classes.dex */
public class bcy extends avd {
    public bcy(DashboardActivity dashboardActivity) {
        super(dashboardActivity, 5, new ava().a(5, dashboardActivity));
    }

    @Override // defpackage.avd
    protected void b() {
        bcw.a = 1;
        g().q().a(new bcu(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    protected void a(boolean z) {
        super.a(z);
        g().q().a(new bcl(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    protected void c() {
        a(TidalLoginActivity.class);
    }

    @Override // defpackage.avd, defpackage.avc
    public void c_() {
        bcw.a = 1;
        super.c_();
    }
}
