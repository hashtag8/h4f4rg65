package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class apl extends aoj implements View.OnClickListener {
    private TextView a;
    private TextView b;
    private View c;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.fragment_setup_fail, (ViewGroup) null);
        this.a = (TextView) this.c.findViewById(R.id.retry);
        this.b = (TextView) this.c.findViewById(R.id.ethernet_setup);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        if (an().n().e() == 2 || an().n().e() == 4) {
            this.b.setVisibility(8);
        }
        b(false);
        an().c(false);
        return this.c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.retry /* 2131690394 */:
                an().a(aoi.RETRY_WIFI_SETUP, l());
                break;
            case R.id.ethernet_setup /* 2131690395 */:
                an().a(aoi.WPS_ETHERNET, (Bundle) null);
                break;
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        a(false);
        an().c(false);
    }
}
