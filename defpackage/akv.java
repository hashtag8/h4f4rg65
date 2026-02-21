package defpackage;

import com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public class akv extends avd {
    public akv(DashboardActivity dashboardActivity) {
        super(dashboardActivity, 2, new ava().a(2, dashboardActivity));
    }

    @Override // defpackage.avd
    public void b() {
        super.b();
        g().q().a(new anh(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    public void a(boolean z) {
        super.a(z);
        g().q().a(new arq(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    public void c() {
        a(QobuzLoginActivity.class);
    }

    @Override // defpackage.avd, defpackage.avc
    public void c_() {
        super.c_();
    }
}
