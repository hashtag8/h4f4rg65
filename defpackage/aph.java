package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bfrx.Device;
import com.harman.hkconnect.R;
import defpackage.api;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aph extends aoj implements View.OnClickListener {
    private View a;
    private TextView b;
    private TextView c;
    private api.a d;
    private long e = 0;

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

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().c(a(R.string.kChooseProduct));
        an().d("");
        an().f(4);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.a = layoutInflater.inflate(R.layout.select_adapt_channel_layout, (ViewGroup) null);
        am();
        return this.a;
    }

    private void am() {
        m(true);
        this.b = (TextView) this.a.findViewById(R.id.exist_speakers);
        this.c = (TextView) this.a.findViewById(R.id.wireless_51_surround_speakers);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.e >= 1000) {
            this.e = SystemClock.elapsedRealtime();
            List<adx> listA = aoz.a(aof.a().f());
            Bundle bundleL = l();
            if (view.getId() == R.id.exist_speakers) {
                List<adx> listI = aoz.i(aoz.a(aof.a().f()));
                if (listI.size() > 1) {
                    bundleL.putBoolean("selectMultipleBarOrAdapt", true);
                }
                this.d.c(6);
                an().n().a((byte) 5);
                bundleL.putBoolean("isExistSpeakers", true);
                bundleL.putBoolean("setup 51adapt+", true);
                bundleL.putBoolean("is_from_room_management", l().getBoolean("is_from_room_management"));
                if (l().getBoolean("is_from_room_management")) {
                    an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                    return;
                }
                if (listI.size() == 1) {
                    an().n().b(new adx(new Device(listI.get(0).R())));
                }
                if (listI != null && listI.size() > 1) {
                    an().a(aoi.WIFI_SETUP_LIST, bundleL);
                    return;
                } else if (an().n().n() != null) {
                    an().n().w();
                    an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    return;
                } else {
                    an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                    return;
                }
            }
            if (view.getId() == R.id.wireless_51_surround_speakers) {
                List<adx> listA2 = aoz.a(aoz.a(aof.a().f()), (byte) 7);
                if (listA2.size() > 1) {
                    bundleL.putBoolean("selectMultipleBarOrAdapt", true);
                }
                this.d.c(5);
                an().n().a((byte) 2);
                if (l().getBoolean("is_from_room_management")) {
                    an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                    return;
                }
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
                    bundleL.putBoolean("setup 51adapt+", true);
                    an().a(aoi.ADAPT_51_Intro, bundleL);
                }
            }
        }
    }

    @Override // defpackage.aoj
    public void al() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_NEXT_BUTTON", false);
        an().a(aoi.RETRY_WIFI_SETUP, bundle);
    }
}
