package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.RippleTextView;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apa extends aoj {
    private ImageView a;
    private ImageView ae;
    private View af;
    private View ag;
    private TypefaceTextView ah;
    private TypefaceTextView ai;
    private TypefaceTextView aj;
    private TypefaceTextView ak;
    private RelativeLayout al;
    private View am;
    private ImageView b;
    private ImageView c;
    private RippleTextView d;
    private View e;
    private TextView f;
    private View g;
    private ImageView h;
    private ImageView i;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.activity_channel_introduction, (ViewGroup) null);
        this.a = (ImageView) this.e.findViewById(R.id.sample_icon);
        this.b = (ImageView) this.e.findViewById(R.id.slash_link_icon_glow);
        this.c = (ImageView) this.e.findViewById(R.id.slash_link_icon_no_glow);
        this.f = (TextView) this.e.findViewById(R.id.soundbar_channel_51_speaker_guide);
        this.h = (ImageView) this.e.findViewById(R.id.introducation_icon_1);
        this.i = (ImageView) this.e.findViewById(R.id.introducation_icon_2);
        this.ae = (ImageView) this.e.findViewById(R.id.introducation_icon_3);
        this.al = (RelativeLayout) this.e.findViewById(R.id.introducation_icon_4);
        this.af = this.e.findViewById(R.id.introducation_line_1);
        this.am = this.e.findViewById(R.id.introducation_line_2);
        this.ag = this.e.findViewById(R.id.introducation_line_3);
        this.ah = (TypefaceTextView) this.e.findViewById(R.id.tv_introducation1);
        this.ai = (TypefaceTextView) this.e.findViewById(R.id.tv_introducation2);
        this.aj = (TypefaceTextView) this.e.findViewById(R.id.tv_introducation3);
        this.ak = (TypefaceTextView) this.e.findViewById(R.id.tv_introducation4);
        this.c.setVisibility(0);
        this.c.setAlpha(0.3f);
        a(true);
        m(false);
        b(true);
        this.d = (RippleTextView) this.e.findViewById(R.id.wps_ethernet_bt);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: apa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("lastDevice", (Serializable) aof.a().f());
                apa.this.an().a(aoi.WPS_ETHERNET, bundle2);
            }
        });
        this.g = this.e.findViewById(R.id.channelIntro_troubleshootButton);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: apa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                apa.this.al();
            }
        });
        at();
        return this.e;
    }

    private void am() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setInterpolator(new Interpolator() { // from class: apa.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return Math.min(Math.max(f * f * 5.0f, f), 1.0f);
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: apa.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                animation.setStartOffset(2400L);
                apa.this.b.startAnimation(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                animation.setStartOffset(0L);
            }
        });
        this.b.startAnimation(alphaAnimation);
    }

    private void at() {
        if (an().n() != null) {
            am();
            switch (an().n().e()) {
                case 0:
                    this.a.setImageResource(R.drawable.omni_10_illustration);
                    break;
                case 1:
                    this.a.setImageResource(R.drawable.omni_10_pair_illustration);
                    break;
                case 2:
                    if (an().n().e() == 2) {
                        this.f.setVisibility(0);
                    }
                    if (l().getBoolean("setup 51adapt+")) {
                        this.a.setImageResource(R.drawable.adapt_illustration);
                        this.h.setVisibility(0);
                        this.af.setVisibility(0);
                        this.aj.setVisibility(0);
                        this.ah.setText(a(R.string.kRoomSetupTutorialAUX_Str));
                        this.ai.setText(a(R.string.kPlugPowerConnectorOnAdapt));
                        this.aj.setText(a(R.string.kAdaptPowerOnLinkButton));
                    } else {
                        this.a.setImageResource(R.drawable.omni_10_5pair_illustration);
                        this.f.setText(a(R.string.kRoomSetupTutorialPrepareFiveSpeaker_Str));
                        this.ah.setText(a(R.string.kPlugAllSpeakers));
                        this.ai.setText(a(R.string.kRoomSetupTutorialLinkFlash_Str));
                    }
                    if (an().n().e() == 2) {
                        this.g.setVisibility(8);
                        this.d.setVisibility(8);
                    }
                    break;
                case 3:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, ahn.a(p(), 15.0f));
                        this.a.setLayoutParams(layoutParams);
                    }
                    this.a.setImageResource(R.drawable.soundbar_31_illustration);
                    this.ae.setVisibility(0);
                    this.ag.setVisibility(0);
                    this.aj.setVisibility(0);
                    this.ah.setText(a(R.string.kPlugInPowerBar));
                    this.ai.setText(a(R.string.kPairBarWithSubwoofer));
                    this.aj.setText(a(R.string.kRoomSetupTutorialLinkFlash_Str));
                    break;
                case 4:
                    this.f.setVisibility(0);
                    if (l().getBoolean("setup 51bar+")) {
                        this.a.setImageResource(R.drawable.soundbar_51_illustration);
                        this.f.setText(a(R.string.kPoweronSoundbarSure5GNetwork_Str));
                        this.ae.setVisibility(0);
                        this.ag.setVisibility(0);
                        this.aj.setVisibility(0);
                        this.ah.setText(a(R.string.kPlugInPowerBar));
                        this.ai.setText(a(R.string.kPairBarWithSubwoofer));
                        this.aj.setText(a(R.string.kRoomSetupTutorialLinkFlash_Str));
                    } else {
                        this.f.setText(a(R.string.kRoomSetupTutorialPrepareTwoSpeaker_Str));
                        this.a.setImageResource(R.drawable.omni_10_pair_illustration);
                        this.ah.setText(a(R.string.kPlugAllSpeakers));
                        this.ai.setText(a(R.string.kRoomSetupTutorialLinkFlash_Str));
                    }
                    this.g.setVisibility(ar() == aoi.ROOM_MANAGEMENT ? 0 : 8);
                    this.d.setVisibility(8);
                    break;
                case 5:
                    if (l().getBoolean("setup 51adapt+")) {
                        this.a.setImageResource(R.drawable.adapt_illustration);
                        this.h.setVisibility(0);
                        this.af.setVisibility(0);
                        this.aj.setVisibility(0);
                        this.ah.setText(a(R.string.kRoomSetupTutorialAUX_amp_Str));
                        this.ai.setText(a(R.string.kPlugPowerConnectorOnAdaptAmp));
                        this.aj.setText(a(R.string.kAdaptPowerOnLinkButtonAmp));
                    } else {
                        this.a.setImageResource(R.drawable.omni_10_5pair_illustration);
                        this.f.setText(a(R.string.kRoomSetupTutorialPrepareFiveSpeaker_Str));
                        this.ah.setText(a(R.string.kPlugAllSpeakers));
                        this.ai.setText(a(R.string.kRoomSetupTutorialLinkFlash_Str));
                    }
                    break;
            }
        }
    }

    @Override // defpackage.aoj
    public void e() {
        if (l().getBoolean("is_from_room_management")) {
            an().a(aoi.WIFI_SETUP_LIST, l());
            return;
        }
        List<adx> listA = aoz.a(aoz.a(aof.a().f()), (byte) 8);
        if (an().n().e() == 5 && an().n().n() != null) {
            mm.b("get main device= " + an().n().n(), new Object[0]);
            an().n().w();
            an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
            return;
        }
        if (an().n().e() == 4) {
            if (listA.size() == 1 && l().getBoolean("isFirstTime", true)) {
                an().n().b(listA.get(0));
                an().a(aoi.WIFI_SETUP_LIST, l());
                return;
            }
        } else if (an().n().e() == 3 && listA.size() == 1) {
            an().n().b(listA.get(0));
            an().n().w();
            an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
            return;
        }
        an().a(aoi.WIFI_SETUP_LIST, l());
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        if (an().n().e() == 0 || an().n().e() == 1) {
            an().c(a(R.string.kRoomSetupTutorialPower_Str));
        } else {
            an().c(a(R.string.wifisetup_apspeaker_detect_title));
        }
        an().b(a(R.string.Next_Str));
        a(true);
    }

    @Override // defpackage.aoj
    public void al() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_NEXT_BUTTON", false);
        an().a(aoi.RETRY_WIFI_SETUP, bundle);
    }
}
