package defpackage;

import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class avc extends avb {
    private auz b;

    public abstract void c_();

    public avc(DashboardActivity dashboardActivity, int i, auz auzVar) {
        super(dashboardActivity, i);
        this.b = auzVar;
    }

    @Override // defpackage.avb
    public boolean a() {
        super.a();
        return this.b.a();
    }

    public auz i() {
        return this.b;
    }
}
