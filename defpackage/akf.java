package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class akf extends aoj implements View.OnClickListener {
    private View a;
    private aei ae;
    private byte[] af;
    private int ag;
    private int ah;
    private int ai;
    private int aj;
    private TextView ak;
    private adx al;
    private boolean am;
    private boolean an;
    private CheckBox ao;
    private RelativeLayout ap;
    private RelativeLayout aq;
    private RelativeLayout ar;
    private RelativeLayout as;
    private CheckBox at;
    private CheckBox au;
    private CheckBox av;
    private CheckBox b;
    private CheckBox c;
    private CheckBox d;
    private CheckBox e;
    private RelativeLayout f;
    private RelativeLayout g;
    private RelativeLayout h;
    private RelativeLayout i;

    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.al = an().n().n();
        if (this.al != null) {
            adw.a().g(this.al);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.manage_room_source_setup_fragment, (ViewGroup) null);
        this.ak = (TextView) this.a.findViewById(R.id.source_setup_guide);
        if (an().n().e() == 2 || an().n().e() == 5) {
            this.ak.setText(q().getString(R.string.OptoimizeYourListeningAdapt_Str));
        }
        this.b = (CheckBox) this.a.findViewById(R.id.cb_optical_watch_movie);
        this.c = (CheckBox) this.a.findViewById(R.id.cb_optical_listen_to_music);
        this.d = (CheckBox) this.a.findViewById(R.id.cb_aux_watch_movie);
        this.e = (CheckBox) this.a.findViewById(R.id.cb_aux_listen_to_music);
        this.f = (RelativeLayout) this.a.findViewById(R.id.rl_optical_watch_movie);
        this.g = (RelativeLayout) this.a.findViewById(R.id.rl_optical_listen_to_music);
        this.aq = (RelativeLayout) this.a.findViewById(R.id.rl_optical_unused);
        this.ar = (RelativeLayout) this.a.findViewById(R.id.rl_hdmi_unused);
        this.as = (RelativeLayout) this.a.findViewById(R.id.rl_aux_unused);
        this.at = (CheckBox) this.a.findViewById(R.id.cb_hdmi_unused);
        this.au = (CheckBox) this.a.findViewById(R.id.cb_optical_unused);
        this.av = (CheckBox) this.a.findViewById(R.id.cb_aux_unused);
        this.h = (RelativeLayout) this.a.findViewById(R.id.rl_aux_watch_movie);
        this.i = (RelativeLayout) this.a.findViewById(R.id.rl_aux_listen_to_music);
        this.ao = (CheckBox) this.a.findViewById(R.id.cb_hdmi_watch_movie);
        this.ap = (RelativeLayout) this.a.findViewById(R.id.rl_hdmi_watch_movie);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.aq.setOnClickListener(this);
        this.ar.setOnClickListener(this);
        this.as.setOnClickListener(this);
        this.ap.setOnClickListener(this);
        this.a.findViewById(R.id.hdmi_input_ll).setVisibility((an().n().e() == 3 || an().n().e() == 4) ? 0 : 8);
        am();
        return this.a;
    }

    private void am() {
        if (this.al != null) {
            this.am = this.al.Y();
            this.an = this.al.Z();
        }
        if (ar() == aoi.ROOM_MANAGEMENT) {
            if (this.am) {
                this.e.setChecked(true);
            } else {
                this.d.setChecked(true);
            }
            if (this.an) {
                this.c.setChecked(true);
            } else {
                this.b.setChecked(true);
            }
        } else {
            this.b.setChecked(true);
            this.e.setChecked(true);
        }
        this.ao.setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aoj
    public void d() {
        super.d();
        e();
    }

    @Override // defpackage.aoj
    public void e() {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        ady adyVarO;
        this.af = an().n().n().ak();
        byte[] bArr = new byte[12];
        if (this.af == null || this.af.length < 12) {
            an().a(aoi.SETUP_ROOM_RESULT, (Bundle) null);
            mm.b("content is null or content is not ok", new Object[0]);
            return;
        }
        System.arraycopy(this.af, 8, bArr, 0, 11);
        this.ag = 1;
        this.ah = 1;
        if ((this.b.isChecked() || this.au.isChecked()) && (this.e.isChecked() || this.av.isChecked())) {
            this.ai = 0;
            this.aj = 1;
        } else if ((this.b.isChecked() || this.au.isChecked()) && this.d.isChecked()) {
            this.ai = 1;
            this.aj = 1;
        } else if (this.c.isChecked() && (this.av.isChecked() || this.e.isChecked())) {
            this.ai = 0;
            this.aj = 0;
        } else {
            this.ai = 1;
            this.aj = 0;
        }
        if (this.ag == 1) {
            b = (byte) (bArr[0] | (this.ag << 3));
            bArr[0] = b;
        } else {
            b = (byte) (bArr[0] & (((this.ag ^ (-1)) << 3) ^ (-1)));
            bArr[0] = b;
        }
        this.ag = b;
        if (this.ah == 1) {
            b2 = (byte) (bArr[0] | (this.ah << 4));
            bArr[0] = b2;
        } else {
            b2 = (byte) (bArr[0] & (((this.ah ^ (-1)) << 4) ^ (-1)));
            bArr[0] = b2;
        }
        this.ah = b2;
        if (this.ai == 1) {
            b3 = (byte) (bArr[6] | (this.ai << 3));
            bArr[6] = b3;
        } else {
            b3 = (byte) (bArr[6] & (((this.ai ^ (-1)) << 3) ^ (-1)));
            bArr[6] = b3;
        }
        this.ai = b3;
        if (this.aj == 1) {
            b4 = (byte) (bArr[6] | (this.aj << 4));
            bArr[6] = b4;
        } else {
            b4 = (byte) (bArr[6] & (((this.aj ^ (-1)) << 4) ^ (-1)));
            bArr[6] = b4;
        }
        this.aj = b4;
        mm.b("5.1 source", ((int) bArr[0]) + "   " + ((int) bArr[6]));
        bArr[7] = -1;
        bArr[8] = -1;
        mm.b("5.1 source is HDMI 1-8 Movie mode 111111 or Audio mode 0000000 ? is   " + Integer.toBinaryString((bArr[7] & 255) + 256).substring(1), new Object[0]);
        mm.b("5.1 source is HDMI ARC 1-8 Movie mode 111111 or Audio mode 0000000 ? is   " + Integer.toBinaryString((bArr[8] & 255) + 256).substring(1), new Object[0]);
        if (an().n().n() != null) {
            this.ae = new aei(new byte[]{7, 41}, bArr);
            adw.a().a(an().n().n(), this.ae);
        }
        if (an().m() != null && (an().m().d() == 4 || an().m().d() == 2)) {
            if (an().m().f() == 4 && this.b.isChecked()) {
                at();
            } else if ((an().m().f() == 3 && this.d.isChecked()) || an().m().f() == 16) {
                at();
            }
        }
        if (ar() == aoi.ROOM_MANAGEMENT && an().m() != null && (adyVarO = aof.a().o()) != null && adyVarO.f().contains(an().m())) {
            mm.b("stop playback", new Object[0]);
            HarmanApplication.a().sendBroadcast(new Intent("EditRoomPauseUi"));
        }
        an().a(aoi.SETUP_ROOM_RESULT, (Bundle) null);
    }

    private void at() {
        for (ady adyVar : aof.a().e()) {
            if (adyVar.o().contains(this.al)) {
                List<adz> listG = adyVar.g();
                listG.remove(an().m());
                aof.a().a(adyVar, listG);
            }
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().d(q().getString(R.string.kRoomSourceSetupMean_Str));
        an().f(0);
        an().d(true);
        an().e(false);
        a(true);
        an().c(a(R.string.kSetupRoomManagement_SourceSetup_Str));
        an().g(17);
        an().b(a(R.string.Next_Str));
        if (l().getBoolean("isSourceSetupSelect")) {
            an().e(true);
        } else {
            an().e(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_hdmi_watch_movie /* 2131690600 */:
                if (this.ao.isChecked()) {
                    this.ao.setChecked(false);
                    this.at.setChecked(true);
                } else {
                    this.ao.setChecked(true);
                    this.at.setChecked(false);
                }
                break;
            case R.id.rl_hdmi_unused /* 2131690602 */:
                this.ao.setChecked(false);
                this.at.setChecked(true);
                break;
            case R.id.rl_optical_watch_movie /* 2131690604 */:
                if (!this.b.isChecked()) {
                    this.b.setChecked(true);
                    this.c.setChecked(false);
                    this.au.setChecked(false);
                }
                break;
            case R.id.rl_optical_listen_to_music /* 2131690607 */:
                if (!this.c.isChecked()) {
                    this.b.setChecked(false);
                    this.c.setChecked(true);
                    this.au.setChecked(false);
                }
                break;
            case R.id.rl_optical_unused /* 2131690609 */:
                this.b.setChecked(false);
                this.c.setChecked(false);
                this.au.setChecked(true);
                break;
            case R.id.rl_aux_watch_movie /* 2131690612 */:
                if (!this.d.isChecked()) {
                    this.d.setChecked(true);
                    this.e.setChecked(false);
                    this.av.setChecked(false);
                }
                break;
            case R.id.rl_aux_listen_to_music /* 2131690615 */:
                if (!this.e.isChecked()) {
                    this.d.setChecked(false);
                    this.e.setChecked(true);
                    this.av.setChecked(false);
                }
                break;
            case R.id.rl_aux_unused /* 2131690617 */:
                this.d.setChecked(false);
                this.e.setChecked(false);
                this.av.setChecked(true);
                break;
        }
    }

    @Override // defpackage.aoj
    public void al() {
        an().a(aoi.SOURCE_SETUP_EXPLANATION, (Bundle) null);
    }
}
