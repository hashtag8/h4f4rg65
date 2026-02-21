package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.reginald.swiperefresh.CustomSwipeRefreshLayout;
import com.stc.upnp.services.DlnaService;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class avw extends avv implements awa, bja {
    public static boolean a = false;
    private static boolean ao;
    private static long ap;
    private static boolean ar;
    public static boolean b;
    public static int d;
    private awg ah;
    private Dialog ai;
    private ArrayList<bjn> ak;
    private avk al;
    private Handler am;
    private Handler an;
    private ImageView as;
    private boolean at;
    private a e;
    private Activity f;
    private CustomSwipeRefreshLayout g;
    private ListView h;
    private LinearLayout i;
    private boolean aj = false;
    private Timer aq = new Timer();
    private MenuItem.OnMenuItemClickListener au = new MenuItem.OnMenuItemClickListener() { // from class: avw.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            avw.a = false;
            avw.this.aD();
            return true;
        }
    };
    private MenuItem.OnMenuItemClickListener av = new MenuItem.OnMenuItemClickListener() { // from class: avw.4
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (avw.this.aq != null) {
                avw.this.aq.cancel();
                avw.this.aq = null;
            }
            avw.this.aC();
            return true;
        }
    };

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        bkj.a().a(this);
        this.am = new Handler();
        this.an = new Handler();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(bundle);
        View viewA = a(layoutInflater);
        this.ai = c(p());
        if (this.ai != null) {
            this.ai.setCancelable(true);
        }
        viewA.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.e = new a();
        this.f.registerReceiver(this.e, new IntentFilter("dlna.player.NEW_DEVICES_FOUND"));
        return viewA;
    }

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        a((avx) this);
    }

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        aD();
        if (p() != null && ((DashboardActivity) p()).n() != null) {
            ((DashboardActivity) p()).n().e();
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            d();
        }
    }

    public awg c() {
        return this.ah;
    }

    public void a(boolean z, awg awgVar) {
        if (z) {
            awgVar.b();
            this.h.setVisibility(0);
        } else {
            awgVar.c();
            this.h.setVisibility(8);
        }
        if (this.ae == null || this.ae.p() == null || (this.ae.q().a() instanceof avw)) {
            if (z) {
                ajv ajvVarC = new ajv.a().a(this.ae.getResources().getString(R.string.DLNA_SearchingForServersScreenTitle)).c(true).e(this.ae.getResources().getColor(R.color.blue_bg)).k(R.drawable.search_close_button).l(this.ae.getResources().getColor(R.color.gray_2)).a(this.av).f(this.ae.getResources().getColor(R.color.blue_bg)).b(false).c();
                if (!aw() && !w() && !A()) {
                    this.ae.l().a(ajvVarC);
                    return;
                }
                return;
            }
            ajv ajvVarC2 = new ajv.a().a(this.ae.getResources().getString(R.string.DLNA_MediaServersScreenTitle)).c(true).e(this.ae.getResources().getColor(R.color.software_textColor_selected)).k(R.drawable.refresh_icon).a(this.au).f(this.ae.getResources().getColor(R.color.white)).b(false).c();
            if (!aw() && !w() && !A()) {
                this.ae.l().a(ajvVarC2);
            }
        }
    }

    public void a(ArrayList<bjn> arrayList) {
        this.g.a();
        this.ak = arrayList;
        if (!this.aj && arrayList.size() != 0) {
            if (this.i.getVisibility() == 0) {
                this.i.setVisibility(8);
                this.h.setVisibility(0);
                this.h.setEmptyView(null);
                this.as.setVisibility(8);
            }
            if (this.h.getAdapter() == null) {
                this.al = new avk(this.f, arrayList);
                this.h.setAdapter((ListAdapter) this.al);
            } else {
                this.al.a(arrayList);
                this.al.notifyDataSetChanged();
            }
            al();
        }
    }

    private void aF() {
        this.am.postDelayed(new Runnable() { // from class: avw.5
            @Override // java.lang.Runnable
            public void run() {
                avw.b = false;
            }
        }, 500L);
    }

    @Override // defpackage.bja
    public void a(bjn bjnVar) {
        try {
            DashboardActivity dashboardActivity = (DashboardActivity) p();
            if (dashboardActivity.p() == null || (dashboardActivity.p() != null && (dashboardActivity.q().a() instanceof avw))) {
                aG();
            }
        } catch (Exception e) {
        }
    }

    @Override // defpackage.bja
    public void b(bjn bjnVar) {
        if (this.al != null && this.h != null) {
            this.al = new avk(this.f, bkj.a().c());
            this.h.setAdapter((ListAdapter) this.al);
        }
        if (this.al == null || this.h == null || this.al.getCount() != 0) {
            return;
        }
        if (this.ah == null || !this.ah.d()) {
            d = 0;
            a = false;
            aD();
            l(true);
        }
    }

    public void a(bjq bjqVar, bjn bjnVar) {
        bkj.a().d(bjnVar);
        b(this.ae, bjnVar.c());
        a(bjqVar.f("Browse"), "0", bjnVar.a(), this.ak, true);
    }

    public void a(List<bjp> list, bjl bjlVar, bjn bjnVar, bjq bjqVar) {
        bkj.a().d(bjnVar);
        b(this.ae, bjnVar.c());
        a(list, bjnVar.a(), this.ak, bjqVar);
    }

    public void d() {
        if (this.ae != null) {
            if (awh.a(this.ae)) {
                if (ao) {
                    aG();
                    return;
                } else {
                    aD();
                    return;
                }
            }
            aB();
        }
    }

    private void aG() {
        if (this.h.getAdapter() != null) {
            this.al = new avk(this.f, bkj.a().c());
            this.h.setAdapter((ListAdapter) this.al);
            if (this.h.getAdapter().getCount() == 0) {
                l(true);
                if (this.ah != null) {
                    this.ah.c();
                }
            }
        }
        if (ao) {
            ao = false;
            b(false);
            long jCurrentTimeMillis = System.currentTimeMillis() - ap;
            if (jCurrentTimeMillis < 20000) {
                long j = 20000 - jCurrentTimeMillis;
                if (this.ah != null && !this.ah.d()) {
                    a(true, this.ah);
                }
                new Handler().postDelayed(new Runnable() { // from class: avw.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<bjn> arrayListC = bkj.a().c();
                        if (avw.this.al != null) {
                            avw.this.al.a(arrayListC);
                            avw.this.al.notifyDataSetChanged();
                        } else {
                            avw.this.al = new avk(avw.this.f, arrayListC);
                            avw.this.h.setAdapter((ListAdapter) avw.this.al);
                        }
                        avw.this.a(false, avw.this.ah);
                        if (avw.this.al != null && avw.this.al.getCount() == 1) {
                            if (avw.this.aq != null) {
                                avw.this.aq.cancel();
                                avw.this.aq = null;
                            }
                            final bjn bjnVar = ((avk) avw.this.h.getAdapter()).a.get(0);
                            avw.this.p().runOnUiThread(new Runnable() { // from class: avw.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    avw.this.c(bjnVar);
                                }
                            });
                        }
                    }
                }, j);
                return;
            }
            return;
        }
        if (this.ah != null && !this.ah.d()) {
            a(false, this.ah);
        }
    }

    public void c(final bjn bjnVar) {
        ao = false;
        ap = 0L;
        if (b) {
            aF();
            return;
        }
        b = true;
        if ((this.ae.q().a() instanceof avw) && p() != null) {
            a(this.ai, this.ae);
            ArrayList<bjq> arrayListF = bjnVar.f();
            int size = arrayListF.size();
            for (int i = 0; i < size; i++) {
                if (arrayListF.get(i).a().contains("urn:schemas-upnp-org:service:ContentDirectory")) {
                    final bjq bjqVar = arrayListF.get(i);
                    final bjl bjlVarF = bjqVar.f("Search");
                    if (bjlVarF == null) {
                        b(this.ai, this.ae);
                        a(bjqVar, bjnVar);
                        return;
                    } else {
                        bky.a("0", bjlVarF, new bjb() { // from class: avw.7
                            @Override // defpackage.bjb
                            public void a(List<bjp> list, int i2, int i3) {
                                if (avw.this.p() != null) {
                                    avw.this.p().runOnUiThread(new Runnable() { // from class: avw.7.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            avw.this.b(avw.this.ai, avw.this.ae);
                                        }
                                    });
                                    if (list != null) {
                                        if (list.size() == 0) {
                                            avw.this.a(bjqVar, bjnVar);
                                        } else {
                                            avw.this.a(list, bjlVarF, bjnVar, bjqVar);
                                        }
                                    }
                                }
                            }

                            @Override // defpackage.bjb
                            public void a(String str) {
                                if (avw.this.p() != null) {
                                    avw.this.p().runOnUiThread(new Runnable() { // from class: avw.7.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            avw.this.b(avw.this.ai, avw.this.ae);
                                            avw.b = false;
                                            avw.this.a((Context) avw.this.p(), "Error in accessing content", "Connection error | Server connection failed", false);
                                        }
                                    });
                                }
                            }
                        }, 0, 100, DlnaService.e, true);
                        return;
                    }
                }
            }
        }
    }

    public void al() {
        this.h.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: avw.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                avw.this.c((bjn) adapterView.getItemAtPosition(i));
            }
        });
    }

    public void a(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // defpackage.awa
    public void a(boolean z, long j) {
        ao = z;
        ap = j;
    }

    public void am() {
        avk avkVar;
        a(true);
        a(false, this.ah);
        if (this.h.getHeaderViewsCount() > 0) {
            avkVar = (avk) ((HeaderViewListAdapter) this.h.getAdapter()).getWrappedAdapter();
        } else {
            avkVar = (avk) this.h.getAdapter();
        }
        if (avkVar != null && avkVar.getCount() == 1) {
            if (this.aq != null) {
                this.aq.cancel();
                this.aq = null;
            }
            c(((avk) this.h.getAdapter()).a.get(0));
            return;
        }
        if (avkVar == null || (avkVar != null && avkVar.getCount() == 0)) {
            this.g.setEnabled(false);
            this.i.setVisibility(0);
            this.h.setEmptyView(null);
            this.as.setVisibility(8);
            return;
        }
        this.i.setVisibility(8);
        this.h.setEmptyView(this.as);
    }

    public void aA() {
        this.f.startService(new Intent(this.f, (Class<?>) DlnaService.class));
    }

    public View a(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dlna_server_search, (ViewGroup) null);
        this.h = (ListView) viewInflate.findViewById(R.id.listview_server);
        this.g = (CustomSwipeRefreshLayout) viewInflate.findViewById(R.id.swipelayout);
        this.as = (ImageView) viewInflate.findViewById(R.id.dlna_empty_listview);
        this.h.setEmptyView(this.as);
        a(false);
        this.g.setOnRefreshListener(new CustomSwipeRefreshLayout.b() { // from class: avw.9
            @Override // com.reginald.swiperefresh.CustomSwipeRefreshLayout.b
            public void a() {
                avw.this.g.a();
                avw.d = 0;
                avw.a = false;
                avw.this.aD();
            }
        });
        this.i = (LinearLayout) viewInflate.findViewById(R.id.layout_no_serverFound);
        this.f = p();
        this.af = new Handler();
        this.ah = new awg(this.ae, viewInflate);
        ((Button) viewInflate.findViewById(R.id.playMusicButtonId)).setOnClickListener(new View.OnClickListener() { // from class: avw.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                awe.a(avw.this.ae);
            }
        });
        return viewInflate;
    }

    @Override // defpackage.avv, defpackage.avx
    public void ay() {
        super.ay();
        b = false;
    }

    public void aB() {
        a = false;
        bkj.a().b();
        this.h.setAdapter((ListAdapter) null);
        l(true);
        if (this.ah != null) {
            this.ah.c();
        }
        a(false, this.ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        if (z) {
            this.i.setVisibility(0);
            this.h.setEmptyView(null);
            this.as.setVisibility(8);
        } else {
            this.i.setVisibility(8);
            this.h.setEmptyView(this.as);
        }
    }

    public void aC() {
        this.aj = true;
        this.af.removeCallbacksAndMessages(null);
        a(false, this.ah);
        am();
    }

    @Override // defpackage.avv, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.ae.getResources().getString(R.string.DLNA_SearchingForServersScreenTitle)).e(this.ae.getResources().getColor(R.color.blue)).k(R.drawable.close_buttons).a(this.au).b(false).f(this.ae.getResources().getColor(R.color.blue_bg)).c();
    }

    public void aD() {
        d = 0;
        ar = false;
        if (this.aq != null) {
            this.aq.cancel();
            this.aq = null;
        }
        awe.a = true;
        this.aj = false;
        this.h.setAdapter((ListAdapter) null);
        bkj.a().b();
        this.af.removeCallbacksAndMessages(null);
        if (this.an != null) {
            this.an.removeCallbacksAndMessages(null);
        }
        if (!awh.a(this.ae)) {
            awe.a(this.ae, this.ae.getString(R.string.WifiNotReachableTip_Str));
            l(true);
            a(false, this.ah);
            return;
        }
        l(false);
        a(true, this.ah);
        aJ();
        if (!a) {
            aA();
            a = true;
        }
        b(true);
    }

    public void b(final boolean z) {
        a(false);
        this.af.postDelayed(new Runnable() { // from class: avw.11
            @Override // java.lang.Runnable
            public void run() {
                avw.this.at = avw.this.aI();
                if (avw.this.at) {
                    avw.a = false;
                    avw.b = false;
                    avw.this.c(bkj.a().e());
                } else if (z) {
                    avw.this.aH();
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        if (this.aq == null) {
            this.aq = new Timer();
            ar = false;
        }
        try {
            this.aq.schedule(new TimerTask() { // from class: avw.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (avw.d == 0) {
                        avw.this.aA();
                    }
                    if (avw.this.ae != null) {
                        avw.this.ae.runOnUiThread(new Runnable() { // from class: avw.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (avw.this.ae.q().a() instanceof avw) {
                                    avw.this.a(false);
                                    if (avw.ar && avw.d == 0) {
                                        avw.this.l(true);
                                        avw.this.a(false, avw.this.ah);
                                    }
                                }
                            }
                        });
                        if (avw.d > 0 && avw.this.ae != null) {
                            avw.this.ae.runOnUiThread(new Runnable() { // from class: avw.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    avw.this.am();
                                    if (avw.this.aq != null) {
                                        avw.this.aq.cancel();
                                    }
                                    avw.this.aq = null;
                                }
                            });
                        }
                    }
                }
            }, 15000L, 15000L);
        } catch (Exception e) {
            bkx.a(Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aI() {
        boolean z;
        boolean z2 = false;
        int size = bkj.a().c().size();
        bjn bjnVarE = bkj.a().e();
        String strB = b(this.ae);
        ArrayList<bjn> arrayListC = bkj.a().c();
        if (bjnVarE == null && strB == null) {
            return false;
        }
        int i = 0;
        while (i < size) {
            if (bjnVarE == null) {
                if (strB != null && arrayListC.get(i).c().equalsIgnoreCase(strB)) {
                    bkj.a().d(arrayListC.get(i));
                    return true;
                }
            } else {
                if (arrayListC.get(i).c().equalsIgnoreCase(bjnVarE.c())) {
                    z = true;
                }
                i++;
                z2 = z;
            }
            z = z2;
            i++;
            z2 = z;
        }
        return z2;
    }

    private void aJ() {
        this.an.postDelayed(new Runnable() { // from class: avw.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<bjn> arrayListC;
                boolean unused = avw.ar = true;
                if (!avw.this.at && (arrayListC = bkj.a().c()) != null && arrayListC.size() > 0) {
                    avw.this.c(arrayListC.get(0));
                }
            }
        }, 20000L);
    }

    @Override // android.support.v4.app.Fragment
    public void f(boolean z) {
        super.f(z);
    }

    @Override // defpackage.avv, defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        bkj.a().b(this);
        aho.e("deviceNumber");
        if (this.aq != null) {
            this.aq.cancel();
            this.aq = null;
        }
        if (this.e != null) {
            p().unregisterReceiver(this.e);
        }
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("dlna.player.NEW_DEVICES_FOUND".equals(intent.getAction())) {
                avw.d = bkj.a().c().size();
                if (aho.c("deviceNumber") < avw.d) {
                    aho.a("deviceNumber", avw.d);
                }
                avw.this.a(bkj.a().c());
            }
        }
    }
}
