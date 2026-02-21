package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aow extends aoj {
    private RelativeLayout a;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_adapt_conneting, viewGroup, false);
        return this.a;
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(true);
        an().c(a(R.string.kSetupWifiTitle_Str));
        an().c(false);
        this.a.requestLayout();
    }

    @Override // defpackage.aoj
    public void c() {
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.ADAPT_CONNECT_WIFI;
    }
}
