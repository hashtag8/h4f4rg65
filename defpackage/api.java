package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class api extends aoj implements View.OnClickListener {
    protected Context a;
    private ahx ae = null;
    private long af = 0;
    private boolean ag;
    public View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private a i;

    public interface a {
        void c(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        try {
            this.i = (a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(p() + " must implement SelectChannelListener");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.b = layoutInflater.inflate(R.layout.select_channel_layout, (ViewGroup) null);
        this.a = p();
        this.ag = l().getBoolean("is_from_room_management", false);
        am();
        return this.b;
    }

    private void at() {
        if (an().n() != null) {
            this.f.setText(an().n().h());
            this.h.setImageResource(an().n().k());
            int i = ain.y[an().n().j()];
            int iRgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
            this.f.setTextColor(iRgb);
            this.h.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
            if (this.ag) {
                int iA = ahk.a();
                an().n().b((adx) null);
                if (an().n().v() != null) {
                    an().n().v().clear();
                }
                an().n().a(iA);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View B() {
        return this.b;
    }

    public void am() {
        this.ae = ahx.a();
        m(false);
        this.c = (TextView) this.b.findViewById(R.id.channel_speaker_one_tv);
        this.d = (TextView) this.b.findViewById(R.id.channel_speaker_20_tv);
        this.e = (TextView) this.b.findViewById(R.id.soundbar_setup);
        this.g = (TextView) this.b.findViewById(R.id.home_theater_setup);
        this.f = (TextView) this.b.findViewById(R.id.channel_setup_room_name);
        this.c.setTypeface(ahu.a(this.a));
        this.d.setTypeface(ahu.a(this.a));
        this.e.setTypeface(ahu.a(this.a));
        this.e.setTypeface(ahu.a(this.a));
        this.h = (ImageView) this.b.findViewById(R.id.room_icon);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        at();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.af >= 1000) {
            this.af = SystemClock.elapsedRealtime();
            if (view.getId() == R.id.channel_speaker_20_tv) {
                this.i.c(2);
                an().n().a((byte) 1);
                List<adx> listA = aoz.a(aof.a().f());
                if (!listA.isEmpty() && an().n().u().b(listA)) {
                    if (this.ae == null || TextUtils.isEmpty(this.ae.b()) || !this.ae.b().replace("\"", "").trim().toLowerCase().contains("_setup_")) {
                        an().n().c(false);
                        an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                        return;
                    } else {
                        an().a(aoi.STEREO_INTRO, (Bundle) null);
                        return;
                    }
                }
                an().a(aoi.STEREO_INTRO, (Bundle) null);
                return;
            }
            if (view.getId() == R.id.channel_speaker_one_tv) {
                this.i.c(1);
                an().n().a((byte) 0);
                ax();
            } else if (view.getId() == R.id.soundbar_setup) {
                an().a(aoi.CHOOSE_SOUNDBAR_CHANNEL_TYPE, l());
            } else if (view.getId() == R.id.home_theater_setup) {
                an().a(aoi.CHOOSE_ADAPT_CHANNEL_TYPE, l());
            }
        }
    }

    private void ax() {
        List<adx> listB = aoz.b(aof.a().f());
        if (!listB.isEmpty() && an().n().u().b(listB)) {
            if (this.ae != null && !TextUtils.isEmpty(this.ae.b()) && this.ae.b().replace("\"", "").trim().toLowerCase().contains("_setup_")) {
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, (Bundle) null);
                return;
            } else {
                a(listB);
                return;
            }
        }
        an().a(aoi.CHANNEL_SETUP_TUTORIAL, (Bundle) null);
    }

    private void a(List<adx> list) {
        an().n().c(false);
        if (an().n().u().a(list)) {
            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
            return;
        }
        an().n().a(list);
        an().n().w();
        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().n().a((adx) null);
        an().d(a(R.string.kRoomSetupTutorialTrouble_Str));
        an().c(a(R.string.kSetupNewRoom_Navigation_SelectRoomType_Str));
    }
}
