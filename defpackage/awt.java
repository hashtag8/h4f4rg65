package defpackage;

import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.juke.view.JukeLoginActivity;

/* JADX INFO: loaded from: classes.dex */
public class awt extends avd {
    public awt(DashboardActivity dashboardActivity) {
        super(dashboardActivity, 6, new ava().a(6, dashboardActivity));
    }

    @Override // defpackage.avd
    protected void b() {
        awp.a = 0;
        g().q().a(new awu(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    protected void a(boolean z) {
        super.a(z);
        g().q().a(new awr(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    protected void c() {
        a(JukeLoginActivity.class);
    }
}
