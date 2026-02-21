package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bfrx.Device;
import com.harman.hkconnect.R;
import defpackage.api;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apj extends aoj implements View.OnClickListener {
    private TextView a;
    private TextView b;
    private View c;
    private api.a d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        try {
            this.d = (api.a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(p() + " must implement SelectChannelListener");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.c = layoutInflater.inflate(R.layout.select_soundbar_channel_layout, (ViewGroup) null);
        am();
        return this.c;
    }

    public void am() {
        m(true);
        this.a = (TextView) this.c.findViewById(R.id.soundbar_channel_31);
        this.b = (TextView) this.c.findViewById(R.id.soundbar_channel_51);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<adx> listA = aoz.a(aof.a().c().d());
        aoz.b(aof.a().c().d());
        List<adx> listA2 = aoz.a(aoz.a(aof.a().f()), (byte) 8);
        Bundle bundleL = l();
        if (listA2.size() > 1) {
            bundleL.putBoolean("selectMultipleBarOrAdapt", true);
        }
        if (view.getId() == R.id.soundbar_channel_31) {
            if (listA2.size() == 1) {
                an().n().b(new adx(new Device(listA2.get(0).R())));
            }
            this.d.c(3);
            an().n().a((byte) 3);
            if (an().n().u().b(listA) && an().n().n() != null) {
                an().n().w();
                an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                return;
            } else if (listA2.size() > 1) {
                an().a(aoi.WIFI_SETUP_LIST, l());
                return;
            } else {
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                return;
            }
        }
        if (view.getId() == R.id.soundbar_channel_51) {
            this.d.c(4);
            an().n().a((byte) 4);
            if (listA2 != null && listA2.size() > 1) {
                an().a(aoi.WIFI_SETUP_LIST, bundleL);
                return;
            }
            if (listA2 != null && listA2.size() == 1 && an().n().u().b(listA)) {
                an().n().b(new adx(new Device(listA2.get(0).R())));
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                return;
            }
            if (listA2 != null && listA2.size() == 1) {
                an().n().b(new adx(new Device(listA2.get(0).R())));
                Bundle bundleL2 = l();
                bundleL2.putBoolean("AdaptBarFirstTimeSetup", true);
                l().putBoolean("isShowingAdaptBarReady", true);
                an().a(aoi.ONLINE_PROGRESS, bundleL2);
                return;
            }
            if (listA2.size() == 0) {
                l().putBoolean("setup 51bar+", true);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
            }
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        an().c(a(R.string.kChooseProduct));
        an().d("");
        an().f(4);
    }

    @Override // defpackage.aoj
    public void al() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_NEXT_BUTTON", false);
        an().a(aoi.RETRY_WIFI_SETUP, bundle);
    }
}
