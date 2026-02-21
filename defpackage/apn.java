package defpackage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.RippleTextView;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class apn extends aoj {
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private RippleTextView d;
    private View e;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.setup_multichannel_introduction, (ViewGroup) null);
        this.a = (ImageView) this.e.findViewById(R.id.sample_icon);
        this.b = (ImageView) this.e.findViewById(R.id.slash_link_icon_glow);
        this.c = (ImageView) this.e.findViewById(R.id.slash_link_icon_no_glow);
        Color.rgb(Color.red(-65536), Color.green(-65536), Color.blue(-65536));
        this.c.setVisibility(0);
        this.c.setAlpha(0.3f);
        this.d = (RippleTextView) this.e.findViewById(R.id.wps_ethernet_bt);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: apn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("lastDevice", (Serializable) aof.a().f());
                apn.this.an().a(aoi.WPS_ETHERNET, bundle2);
            }
        });
        a(true);
        m(true);
        b(true);
        return this.e;
    }

    public void am() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(700L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        this.b.startAnimation(alphaAnimation);
    }

    @Override // defpackage.aoj
    public void b() {
        am();
        if (an().n().e() == 0 || an().n().e() == 1) {
            an().c(a(R.string.kRoomSetupTutorialPower_Str));
        } else {
            an().c(a(R.string.wifisetup_apspeaker_detect_title));
        }
        an().b(a(R.string.Next_Str));
        int i = an().n().j() != -1 ? ain.y[an().n().j()] : -1;
        Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        switch (an().n().e()) {
            case 0:
                this.a.setImageResource(R.drawable.omni_10);
                break;
            case 1:
                this.a.setImageResource(R.drawable.stereo_pair);
                break;
            case 2:
                this.a.setImageResource(R.drawable.adapt_icon);
                break;
            case 3:
                this.a.setImageResource(R.drawable.soundbar_31);
                break;
            case 4:
                this.a.setImageResource(R.drawable.soundbar_51);
                break;
        }
    }

    @Override // defpackage.aoj
    public void e() {
        RoomItem roomItemN = an().n();
        if (roomItemN.m() != null && (roomItemN.u() instanceof apv)) {
            if (((apv) roomItemN.u()).a(aoz.b(aof.a().f()), roomItemN.m())) {
                an().n().b(true);
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                return;
            } else {
                an().n().b(false);
                an().a(aoi.WIFI_SETUP_LIST, (Bundle) null);
                return;
            }
        }
        if (roomItemN.m() != null && (roomItemN.u() instanceof apr)) {
            if (((apr) roomItemN.u()).b(aoz.a(aof.a().f()))) {
                an().n().b(true);
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                return;
            } else {
                an().n().b(false);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                return;
            }
        }
        if (roomItemN.m() != null && (roomItemN.u() instanceof ape)) {
            ape apeVar = (ape) roomItemN.u();
            an().n().b(roomItemN.n());
            if (apeVar.b(aoz.a(aof.a().f()))) {
                an().n().b(true);
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                return;
            } else {
                an().n().b(false);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                return;
            }
        }
        if (an().n().u().b(aof.a().c().d())) {
            an().n().b(true);
            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
        } else {
            an().n().b(false);
            an().a(aoi.WIFI_SETUP_LIST, (Bundle) null);
        }
    }

    @Override // defpackage.aoj
    public void al() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_NEXT_BUTTON", false);
        an().a(aoi.RETRY_WIFI_SETUP, bundle);
    }
}
