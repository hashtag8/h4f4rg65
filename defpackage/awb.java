package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.LinearLayoutManager;
import defpackage.ajv;
import defpackage.aqu;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class awb extends avv implements ajr, ajt, avy {
    private static int b = 1;
    public static String d;
    private avy a;
    private avu ah;
    private avt ai;
    private avo aj;
    private avp ak;
    private avs al;
    private TextView am;
    private View ao;
    private LayoutInflater ap;
    public View e;
    public String f;
    public LinearLayout g;
    protected MenuItem.OnMenuItemClickListener h = new MenuItem.OnMenuItemClickListener() { // from class: awb.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            awb.this.ae.l().a(new ajv.a().d(true).n(awb.this.q().getColor(R.color.black)).a(awb.this.ao()).a((ajt) awb.this).a((ajr) awb.this).m(awb.this.q().getColor(R.color.white)).e(true).f(true).a(true).c(true).b(8).k(R.drawable.search_close_button).a(awb.this.aq).f(awb.this.ae.getResources().getColor(R.color.white)).c());
            awb.this.ae.l().a(8);
            return true;
        }
    };
    private View an = null;
    ArrayList<String> i = new ArrayList<>();
    private MenuItem.OnMenuItemClickListener aq = new MenuItem.OnMenuItemClickListener() { // from class: awb.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (avv.ap() != null) {
                avv.ap().a();
            }
            awb.this.ae.l().a(new ajv.a().d(false).b(0).a(awb.this.ao()).a((ajt) awb.this).m(awb.this.q().getColor(R.color.white)).a(awb.this.q().getColor(R.color.black)).c(true).k(R.drawable.local_search_icon).a(awb.this.h).f(awb.this.ae.getResources().getColor(R.color.white)).c());
            awb.this.ae.l().a(0);
            awb.this.aH();
            return true;
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ao = layoutInflater.inflate(R.layout.search, (ViewGroup) null);
        this.ap = layoutInflater;
        b(l().getString("name"));
        d(0);
        aB();
        a(this.e, (String) null);
        aF();
        return this.ao;
    }

    public void aA() {
        this.g = (LinearLayout) this.ao.findViewById(R.id.navigation);
    }

    public void aB() {
        this.i.add(q().getString(R.string.LibNav_Artist_Str));
        this.i.add(q().getString(R.string.LibNav_Album_Str));
        this.i.add(q().getString(R.string.LibNav_Song_Str));
        this.i.add(q().getString(R.string.LibNav_Playlist_Str));
        this.i.add(q().getString(R.string.LibNav_Genre_Str));
        this.e = LayoutInflater.from(p()).inflate(R.layout.grid_control_head, (ViewGroup) null);
        final RecyclerView recyclerView = (RecyclerView) this.e.findViewById(R.id.navigation_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        final aqu aquVar = new aqu(this.i, this.ap);
        recyclerView.setAdapter(aquVar);
        aquVar.a(new aqu.a() { // from class: awb.3
            @Override // aqu.a
            public void a(View view, int i) {
                aqu.b bVar;
                int unused = awb.b = 1;
                if (awb.this.am != view.findViewById(R.id.navigation_item)) {
                    aquVar.f(i);
                    if (awb.this.am == null && (bVar = (aqu.b) recyclerView.b(0)) != null) {
                        awb.this.am = bVar.n;
                    }
                    switch (i) {
                        case 0:
                            awb.this.aF();
                            break;
                        case 1:
                            awb.this.aE();
                            break;
                        case 2:
                            awb.this.aC();
                            break;
                        case 3:
                            awb.this.aD();
                            break;
                        case 4:
                            awb.this.aG();
                            break;
                    }
                    awb.this.a(awb.this.am, (TextView) view.findViewById(R.id.navigation_item));
                    awb.this.am = (TextView) view.findViewById(R.id.navigation_item);
                }
            }
        });
        aA();
    }

    public void a(View view, String str) {
        this.f = str;
        this.g.removeAllViews();
        this.g.addView(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, TextView textView2) {
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#9A9A9A"));
            textView.setTypeface(ahu.a(this.ae));
        }
        textView2.setTextColor(Color.parseColor("#000000"));
        textView2.setTypeface(ahu.b(this.ae));
    }

    @Override // defpackage.avy
    public void a_(avv avvVar) {
        avvVar.b(ao());
        avvVar.d(0);
    }

    @Override // defpackage.avy
    public void a(String str, MusicData musicData) {
        b(str, musicData);
    }

    public void b(String str, MusicData musicData) {
        aI();
        avm avmVar = new avm();
        a(avmVar, (String) null, (String) null, str, musicData.getTitle());
        avmVar.a((avy) this);
        this.ae.q().a(avmVar, (arc) null);
    }

    protected void aC() {
        Bundle bundleA = null;
        if (this.ah == null) {
            this.ah = new avu();
            bundleA = a(this.ah, (String) null, (String) null, (String) null, (String) null);
            this.ah.a((avy) this);
        }
        this.ae.q().a(s(), this.ah, bundleA, R.id.middle_panel_search);
        d = "TAG_SONG";
    }

    public void aD() {
        Bundle bundleA = null;
        d = "TAG_PLAYLIST";
        if (this.ai == null) {
            this.ai = new avt();
            bundleA = a(this.ai, (String) null, (String) null, (String) null, (String) null);
            this.ai.a((avy) this);
        }
        this.ae.q().a(s(), this.ai, bundleA, R.id.middle_panel_search);
    }

    public void aE() {
        Bundle bundleA = null;
        d = "TAG_ALBUM";
        if (this.aj == null) {
            this.aj = new avo();
            bundleA = a(this.aj, (String) null, (String) null, (String) null, (String) null);
            this.aj.a((avy) this);
        }
        this.ae.q().a(s(), this.aj, bundleA, R.id.middle_panel_search);
    }

    public Bundle a(String str, String str2, avr avrVar) {
        Bundle bundleA = a(avrVar, d, str, "0", (String) null);
        avrVar.a((avy) this);
        return bundleA;
    }

    public void aF() {
        Bundle bundleA = null;
        d = "TAG_ARTIST";
        if (this.ak == null) {
            this.ak = new avp();
            bundleA = a(this.ak, (String) null, (String) null, (String) null, (String) null);
            this.ak.a((avy) this);
        }
        this.ae.q().a(s(), this.ak, bundleA, R.id.middle_panel_search);
    }

    public void aG() {
        Bundle bundleA = null;
        d = "TAG_GENRE";
        if (this.al == null) {
            this.al = new avs();
            bundleA = a(this.al, (String) null, (String) null, (String) null, (String) null);
            this.al.a((avy) this);
        }
        this.ae.q().a(s(), this.al, bundleA, R.id.middle_panel_search);
    }

    private Bundle a(avq avqVar, String str, String str2, String str3, String str4) {
        Bundle bundleL = l();
        Bundle bundle = new Bundle();
        bundle.putSerializable("service", bundleL.getSerializable("service"));
        bundle.putString("id", "0");
        bundle.putString("filter", bundleL.getString("filter"));
        bundle.putString("conatinerid", bundleL.getString("conatinerid"));
        bundle.putString("filter", str);
        bundle.putString("search", str2);
        bundle.putString("conatinerid", str3);
        bundle.putString("name", str4);
        bundle.putString("server_name", bundleL.getString("name"));
        if (avqVar != null && !avqVar.z()) {
            avqVar.g(bundle);
        }
        return bundle;
    }

    public void aH() {
        if (this instanceof avm) {
            avm avmVar = (avm) this;
            if (avmVar.a) {
                avmVar.b(false);
                avmVar.c(false);
                return;
            }
            return;
        }
        if (this instanceof avr) {
            this.ae.onBackPressed();
        }
    }

    @Override // defpackage.avv, defpackage.ajj
    public ajv b() {
        if (this.ae.l().a() != null && this.ae.l().e()) {
            return new ajv.a().d(true).a((ajr) this).n(q().getColor(R.color.black)).m(q().getColor(R.color.white)).e(true).a(true).c(true).f(false).k(R.drawable.search_close_button).b(this.ae.l().d()).a(this.aq).f(this.ae.getResources().getColor(R.color.white)).c();
        }
        this.ae.l().a(true);
        return new ajv.a().d(false).a(ao()).a((ajt) this).a(q().getColor(R.color.black)).c(true).k(R.drawable.local_search_icon).a(this.h).f(this.ae.getResources().getColor(R.color.white)).c();
    }

    @Override // defpackage.ajt
    public void a(View view) {
        if (p() != null && (p() instanceof DashboardActivity) && an() == 0) {
            ((DashboardActivity) p()).n().a(view);
        }
    }

    @Override // defpackage.ajt
    public void a(TextView textView) {
        if (p() != null) {
            ((DashboardActivity) p()).n().a(textView, this, an());
        }
    }

    public void aI() {
        if (ap() != null) {
            ap().a();
        }
        if (ao() != null && this.ae != null) {
            this.ae.l().a(new ajv.a().d(false).a(ao()).a((ajt) this).a(q().getColor(R.color.black)).c(true).k(R.drawable.local_search_icon).a(this.h).f(this.ae.getResources().getColor(R.color.white)).c());
        }
    }

    @Override // defpackage.avv, defpackage.avx
    public void ay() {
        super.ay();
        aI();
    }

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        a((avx) this);
    }

    @Override // defpackage.ajk
    public String av() {
        return l() != null ? l().getString("name") + "_" + super.av() : super.av();
    }

    public avy aJ() {
        return this.a;
    }

    public void a(avy avyVar) {
        this.a = avyVar;
    }

    @Override // defpackage.ajr
    public void a(String str, Boolean bool) {
        if (ap() != null) {
            ap().a(str);
            ap().a();
        }
        if (ap() != null) {
            ap().a();
        }
        awd.b = false;
        if (this instanceof avm) {
            avm avmVar = (avm) this;
            avmVar.b(true);
            avmVar.a(str, true, (Bundle) null);
        } else {
            if (this instanceof avr) {
                avr avrVar = (avr) this;
                avrVar.a(str, false, a(str, "0", avrVar));
                avrVar.b(str);
                avrVar.d(-1);
                return;
            }
            avr avrVar2 = new avr();
            a(str, "0", avrVar2);
            this.ae.q().a(avrVar2, (arc) null);
            avrVar2.b(str);
            avrVar2.d(-1);
        }
    }
}
