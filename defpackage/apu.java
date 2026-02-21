package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import defpackage.ary;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apu extends aoj {
    RelativeLayout a;
    private ahx b;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (RelativeLayout) layoutInflater.inflate(R.layout.stereo_introduction_layout, viewGroup, false);
        this.b = ahx.a();
        return this.a;
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(true);
        an().c(a(R.string.kSetupStereoIntroOverview_Str));
        an().c(true);
        an().b(a(R.string.Start_Str));
        this.a.requestLayout();
    }

    @Override // defpackage.aoj
    public void c() {
        an().b(a(R.string.Next_Str));
    }

    @Override // defpackage.aoj
    public void e() {
        if (ar() == aoi.ROOM_MANAGEMENT && an().m() != null) {
            if (aim.e) {
                aim.i();
                an().a(aoi.SETUP_MULTICHANNEL_TUTORIAL, (Bundle) null);
                return;
            }
            return;
        }
        am();
    }

    private void am() {
        final List<adx> listA = aoz.a(aof.a().f());
        if (!listA.isEmpty() && an().n().u().b(listA)) {
            if (this.b != null && !TextUtils.isEmpty(this.b.b()) && this.b.b().replace("\"", "").trim().toLowerCase().contains("_setup_")) {
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, (Bundle) null);
                return;
            }
            if (an().n().e() == 2) {
                final List<adx> listA2 = aoz.a(listA, (byte) 7);
                if (listA2.size() != 0) {
                    an().n().b(listA2.get(0));
                    if (listA2.size() > 1) {
                        ary.a(aoz.a(listA, (byte) 7), p().getString(R.string.SpeakerSetupSoundBarMore_Str, new Object[]{"\"" + a(R.string.SpeakerSetupAdaptFirstNotice_Str) + "\""}), new ary.c() { // from class: apu.1
                            @Override // ary.c
                            public void a(int i) {
                                apu.this.an().n().b((adx) listA2.get(i));
                                apu.this.a((List<adx>) listA);
                            }
                        }).a(p().f(), (String) null);
                        return;
                    }
                } else {
                    return;
                }
            }
            a(listA);
            return;
        }
        an().a(aoi.CHANNEL_SETUP_TUTORIAL, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<adx> list) {
        an().n().c(false);
        if (an().n().u().a(list)) {
            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
            return;
        }
        an().n().a(list);
        an().n().w();
        an().a(aoi.SETUP_ROOM_RESULT, (Bundle) null);
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.STEREO_INTRO;
    }
}
