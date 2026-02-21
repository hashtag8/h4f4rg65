package defpackage;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.RippleTextView;
import com.harman.hkconnect.ui.custom.ClearEditText;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.arw;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class akb extends aoj implements View.OnClickListener {
    private RippleTextView a;
    private TextView ae;
    private RelativeLayout af;
    private aey ag;
    private TypefaceTextView ah;
    private RippleTextView ai;
    private RippleTextView b;
    private RippleTextView c;
    private RippleTextView d;
    private TextView e;
    private ImageView f;
    private View g;
    private arw h = null;
    private ClearEditText i;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.manage_room_item_layout, (ViewGroup) null);
        this.i = (ClearEditText) viewInflate.findViewById(R.id.manage_room_item_name);
        this.ae = (TextView) viewInflate.findViewById(R.id.another_room_type_text);
        ake akeVar = new ake(an(), true);
        this.i.setOnEditorActionListener(akeVar);
        this.i.setOnFocusChangeListener(akeVar);
        this.e = (TextView) viewInflate.findViewById(R.id.manage_room_item_version);
        this.f = (ImageView) viewInflate.findViewById(R.id.manage_room_item_icon);
        this.a = (RippleTextView) viewInflate.findViewById(R.id.edit_room);
        this.b = (RippleTextView) viewInflate.findViewById(R.id.ungroup_speakers);
        this.c = (RippleTextView) viewInflate.findViewById(R.id.setup_multichannel);
        this.d = (RippleTextView) viewInflate.findViewById(R.id.room_setting);
        this.ai = (RippleTextView) viewInflate.findViewById(R.id.source_setup);
        this.af = (RelativeLayout) viewInflate.findViewById(R.id.setup_multichannel_layout);
        this.g = viewInflate.findViewById(R.id.setup_multichannel_view_divider);
        this.ah = (TypefaceTextView) viewInflate.findViewById(R.id.setup_room);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.ai.setOnClickListener(this);
        this.ag = new aez() { // from class: akb.1
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                akb.this.am();
            }
        };
        return viewInflate;
    }

    @Override // defpackage.aoj
    public void b() {
        super.b();
        an().n().a(false);
        an().c(a(R.string.kSetupRoomManagement_Title_Str));
        am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        if (an().m() != null) {
            adz adzVarA = aof.a().a(an().m().s());
            if (adzVarA != null) {
                RoomItem roomItemN = an().n();
                if (roomItemN == null) {
                    roomItemN = new RoomItem();
                }
                roomItemN.a(adzVarA);
            }
            if (an().n() != null) {
                at();
            }
        }
    }

    private void at() {
        this.i.setText(an().n().h());
        this.f.setImageResource(an().n().k());
        int i = ain.y[an().n().j()];
        mm.b("TEST_EDIT_ROOM", "roomItem.color=" + an().n().j());
        int iRgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        this.f.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
        this.i.setTextColor(iRgb);
        this.e.setText(an().m().w());
        if (an().m().d() == 1 || an().m().d() == 0) {
            this.ai.setVisibility(8);
        }
        if (an().m().d() == 1 || an().m().d() == 4 || an().m().d() == 2 || an().m().h().q() == 3 || an().n().n().q() == 12) {
            this.af.setVisibility(8);
            this.g.setVisibility(8);
            return;
        }
        this.af.setVisibility(0);
        this.g.setVisibility(0);
        if (an().m().d() == 3 || an().m().d() == 5) {
            this.ah.setText(a(R.string.kSetupRoomManagement_Setup_MultiChannel_Str));
            this.ae.setText(a(R.string.kOmni));
        } else if (an().n().m() != null) {
            this.ae.setText(an().n().m().x());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        an().n().n();
        an().m().j();
        aof.a().p();
    }

    private arw ay() {
        arw.a aVar = new arw.a(p());
        if (aof.a().d().size() > 1) {
            aVar.b(a(R.string.Ungroup_Alert_Title_Str));
            aVar.a(a(R.string.Ungroup_Alert_Message_Str));
        } else {
            aVar.b(a(R.string.kUngroup_Last_Speaker_Alert_Title_Str));
            aVar.a(a(R.string.kUngroup_Last_Speaker_Alert_Message_Str));
        }
        this.h = aVar.a(a(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: akb.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (aof.a().d().size() <= 1) {
                    akb.this.az();
                } else if (!akb.this.aw()) {
                    akb.this.p().onBackPressed();
                }
                akb.this.h.dismiss();
                adx adxVarN = akb.this.an().n().n();
                akb.this.ax();
                if ((adxVarN != null && adxVarN.I()) || adxVarN.q() == 7) {
                    mm.b("5.1 source", "set main device to audio mode while ungroup speaker");
                    aoz.a(adxVarN);
                }
                if (!akb.this.aw()) {
                    akb.this.an().a(akb.this.as(), aoi.ROOM_MANAGEMENT, false);
                }
            }
        }).b(a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: akb.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                akb.this.h.dismiss();
            }
        }).d(false).b();
        if (!this.h.isShowing() && !p().isFinishing()) {
            new asc(this.h).a(p());
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        final asa asaVar = new asa(p());
        final aez aezVar = new aez() { // from class: akb.4
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                if (!aof.a().d().isEmpty()) {
                    new asd(asaVar).a();
                }
            }
        };
        aof.a().c().a(aezVar);
        asaVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: akb.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aof.a().c().b(aezVar);
                if (!akb.this.aw()) {
                    akb.this.p().onBackPressed();
                }
            }
        });
        asaVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_room /* 2131690549 */:
                an().a(aoi.CHOOSE_ROOM_TYPE, (Bundle) null);
                break;
            case R.id.setup_multichannel /* 2131690552 */:
                RoomItem roomItemN = an().n();
                if (an().m().d() == 0) {
                    an().n().a(true);
                    an().n().a((byte) 1);
                    if (((apv) roomItemN.u()).a(aoz.b(aof.a().f()), roomItemN.m())) {
                        an().n().b(true);
                        an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                    } else {
                        an().n().b(false);
                        an().a(aoi.SETUP_MULTICHANNEL_TUTORIAL, (Bundle) null);
                    }
                } else if (an().m().d() == 3) {
                    mm.b("Check for wifi channel Soundbar:: %s %s ", an().n().n(), Boolean.valueOf(a(an().n().n().g())));
                    if (an().n().n() != null && a(an().n().n().g())) {
                        an().a(aoi.SETUP_MULTICHANNEL_5G_ISSUE, l());
                    } else {
                        l().putBoolean("setup 51bar+", false);
                        l().putBoolean("isFirstTime", false);
                        an().n().a(true);
                        an().n().a((byte) 4);
                        if (((apr) roomItemN.u()).b(aoz.a(aof.a().c().d()))) {
                            an().n().b(true);
                            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                        } else {
                            an().n().b(false);
                            an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                        }
                    }
                } else if (an().m().d() == 5) {
                    mm.b("Check for wifi channel Adapt:: %s %s ", an().n().n(), Boolean.valueOf(a(an().n().n().g())));
                    if (an().n().n() != null && a(an().n().n().g())) {
                        an().a(aoi.SETUP_MULTICHANNEL_5G_ISSUE, l());
                    } else {
                        l().putBoolean("setup 51adapt+", false);
                        l().putBoolean("isFirstTime", false);
                        an().n().a(true);
                        an().n().a((byte) 2);
                        if (((ape) roomItemN.u()).b(aoz.a(aof.a().c().d()))) {
                            an().n().b(true);
                            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                        } else {
                            an().n().b(false);
                            an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                        }
                    }
                } else {
                    mm.b("device channel type not right ------", new Object[0]);
                }
                break;
            case R.id.source_setup /* 2131690555 */:
                l().putBoolean("isSourceSetupSelect", true);
                an().a(aoi.SOURCE_SETUP, l());
                break;
            case R.id.room_setting /* 2131690556 */:
                an().a(aoi.ROOM_SETTING, (Bundle) null);
                break;
            case R.id.ungroup_speakers /* 2131690557 */:
                ay();
                break;
        }
    }

    private boolean a(short s) {
        return s >= 1 && s <= 14;
    }
}
