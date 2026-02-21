package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.harman.hkconnect.R;
import defpackage.aoj;

/* JADX INFO: loaded from: classes.dex */
public class apy extends aoj {
    private ath a;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.update_devices_container, viewGroup, false);
        this.a = new ath();
        this.a.g(l());
        s().a().a(R.id.updateDevicesContainer_parent, this.a).d();
        return frameLayout;
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
    }

    @Override // defpackage.aoj
    public void b(boolean z) {
        an().e(z);
    }

    @Override // defpackage.aoj
    public void a(boolean z) {
        super.a(z);
    }

    @Override // defpackage.aoj
    public aoj.b an() {
        return super.an();
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.UPDATE_DEVICES;
    }
}
