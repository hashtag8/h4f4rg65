package defpackage;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.custom.AppPlayerTotalVolumeSeekbar;
import com.harman.hkconnect.ui.custom.LinearLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class akd extends aoh {
    private LinearLayout af;
    private RelativeLayout ag;
    private RelativeLayout ah;
    private View ai;
    private ImageView aj;
    private ImageView ak;
    private ImageView al;
    private ImageView am;
    private ImageView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private TextView as;
    private ImageView at;
    private ImageView au;
    private TextView av;
    private TextView aw;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private View e;
    private RecyclerView f;
    private List<adx> g;
    private List<adz> h;
    private a i;
    private byte ae = 0;
    aez a = new aez() { // from class: akd.1
        @Override // defpackage.aez, defpackage.aey
        public void a(List<adx> list) {
            mo.a.post(new Runnable() { // from class: akd.1.1
                @Override // java.lang.Runnable
                public void run() {
                    akd.this.ay();
                    akd.this.az();
                }
            });
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.e = layoutInflater.inflate(R.layout.manage_room_setting_fragment, (ViewGroup) null);
        at();
        return this.e;
    }

    @Override // android.support.v4.app.Fragment
    public void C() {
        super.C();
        ((aqc) p()).a(new DialogInterface.OnDismissListener() { // from class: akd.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                akd.this.ay();
            }
        });
        aof.a().c().a(this.a);
    }

    @Override // android.support.v4.app.Fragment
    public void D() {
        super.D();
        ((aqc) p()).B();
        aof.a().c().b(this.a);
    }

    @Override // defpackage.aoh, defpackage.aoj
    protected void b() {
        super.b();
        ay();
        az();
    }

    private void at() {
        this.b = (LinearLayout) this.e.findViewById(R.id.balance_layout);
        this.d = (LinearLayout) this.e.findViewById(R.id.settings_balance_layout);
        this.af = (LinearLayout) this.e.findViewById(R.id.settings_level_layout);
        this.ai = this.e.findViewById(R.id.level_lable);
        this.c = (LinearLayout) this.e.findViewById(R.id.settings_volume_layout);
        this.f = (RecyclerView) this.e.findViewById(R.id.product_container);
        this.ag = (RelativeLayout) this.e.findViewById(R.id.bar_51);
        this.ah = (RelativeLayout) this.e.findViewById(R.id.adapt_51);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, q().getDimensionPixelSize(R.dimen.drag_list_view_icon_size) + ahn.a(HarmanApplication.a(), 45.0f));
        layoutParams.topMargin = ahn.a(HarmanApplication.a(), 10.0f);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(0);
        this.f.setLayoutManager(linearLayoutManager);
        this.f.setLayoutParams(layoutParams);
        if (an().n().e() == 4) {
            this.f.setVisibility(8);
            this.ah.setVisibility(8);
            this.ag.setVisibility(0);
        } else if (an().n().e() == 2) {
            this.f.setVisibility(8);
            this.ag.setVisibility(8);
            this.ah.setVisibility(0);
        } else {
            this.f.setVisibility(0);
            this.ag.setVisibility(8);
            this.ah.setVisibility(8);
        }
        if (ahn.a()) {
            this.af.getLayoutParams().width = aff.t;
            this.d.getLayoutParams().width = aff.t;
            this.c.getLayoutParams().width = aff.t;
        }
        if (an().m().d() == 2 || an().m().d() == 4) {
            ax();
        }
    }

    private void ax() {
        boolean z;
        Drawable drawable;
        adz adzVarM = an().m();
        this.aj = (ImageView) this.e.findViewById(R.id.image_center);
        this.ak = (ImageView) this.e.findViewById(R.id.image_front_right_speaker);
        this.al = (ImageView) this.e.findViewById(R.id.image_rear_left_speaker);
        this.am = (ImageView) this.e.findViewById(R.id.image_rear_right_speaker);
        this.an = (ImageView) this.e.findViewById(R.id.image_front_left_speaker);
        this.ao = (TextView) this.e.findViewById(R.id.tv_adapt_front_left);
        this.ap = (TextView) this.e.findViewById(R.id.tv_adapt_center);
        this.aq = (TextView) this.e.findViewById(R.id.tv_adapt_front_right);
        this.ar = (TextView) this.e.findViewById(R.id.tv_adapt_rear_left);
        this.as = (TextView) this.e.findViewById(R.id.tv_adapt_rear_right);
        this.at = (ImageView) this.e.findViewById(R.id.image_left_speaker);
        this.au = (ImageView) this.e.findViewById(R.id.image_right_speaker);
        this.av = (TextView) this.e.findViewById(R.id.left_speaker_tv);
        this.aw = (TextView) this.e.findViewById(R.id.right_speaker_tv);
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        } else {
            z = true;
        }
        Iterator<adx> it = adzVarM.k().iterator();
        while (true) {
            if (!it.hasNext()) {
                drawable = null;
                break;
            }
            adx next = it.next();
            if (next.q() == 4) {
                if (z) {
                    drawable = p().getResources().getDrawable(R.drawable.omni_10, p().getTheme());
                } else {
                    drawable = p().getResources().getDrawable(R.drawable.omni_10);
                }
            } else if (next.q() == 5) {
                if (z) {
                    drawable = p().getResources().getDrawable(R.drawable.omni_20_illustration, p().getTheme());
                } else {
                    drawable = p().getResources().getDrawable(R.drawable.omni_20_illustration);
                }
            } else if (next.q() == 6) {
                if (z) {
                    drawable = p().getResources().getDrawable(R.drawable.omni_50_illustration, p().getTheme());
                } else {
                    drawable = p().getResources().getDrawable(R.drawable.omni_50_illustration);
                }
            }
        }
        if (drawable != null) {
            if (an().m().d() == 2) {
                this.aj.setImageDrawable(drawable);
                this.ak.setImageDrawable(drawable);
                this.al.setImageDrawable(drawable);
                this.am.setImageDrawable(drawable);
                this.an.setImageDrawable(drawable);
                return;
            }
            this.at.setImageDrawable(drawable);
            this.au.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        this.b.setVisibility(8);
        if (this.f.getVisibility() == 0) {
            RecyclerView recyclerView = this.f;
            a aVar = new a();
            this.i = aVar;
            recyclerView.setAdapter(aVar);
        }
        adz adzVarM = an().m();
        if (adzVarM != null) {
            this.ae = adzVarM.d();
            if (!a(this.ae)) {
                this.ae = (byte) 0;
            }
            this.g = adzVarM.k();
            if (adzVarM.d() == 1) {
                this.b.setVisibility(0);
            }
        }
    }

    private boolean a(byte b) {
        return b < 5 && b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        adz adzVarM = an().m();
        this.h = new ArrayList();
        this.h.add(adzVarM);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.c.removeAllViews();
        this.af.removeAllViews();
        this.d.removeAllViews();
        arf arfVar = new arf(p(), d(2));
        arfVar.setMax(12);
        arfVar.setProgress(d(2).D());
        this.d.addView(arfVar, layoutParams);
        ArrayList<adx> arrayList = new ArrayList();
        for (adx adxVar : aof.a().c().d()) {
            if (adxVar.s() == adzVarM.s()) {
                arrayList.add(adxVar);
            }
        }
        mm.b("room name = " + adzVarM.l(), "room device size = " + arrayList.size());
        HashMap map = new HashMap();
        AppPlayerTotalVolumeSeekbar appPlayerTotalVolumeSeekbar = new AppPlayerTotalVolumeSeekbar(p());
        appPlayerTotalVolumeSeekbar.setBackingGroup(aof.a().b(adzVarM.x()));
        if (adzVarM.d() == 4) {
            this.ai.setVisibility(0);
            this.af.setVisibility(0);
            for (adx adxVar2 : arrayList) {
                if (adxVar2.R().getRole() == 12345678) {
                    map.put(0, adxVar2);
                    mm.b("bar 5.1 master", new Object[0]);
                } else if (adxVar2.R().getRole() == 5) {
                    map.put(1, adxVar2);
                    mm.b("bar 5.1 front left", new Object[0]);
                } else if (adxVar2.R().getRole() == 6) {
                    map.put(2, adxVar2);
                    mm.b("bar 5.1 front right", new Object[0]);
                } else if (adxVar2.R().getRole() == 4) {
                    map.put(3, adxVar2);
                    mm.b("bar 5.1 subwoofer", new Object[0]);
                } else {
                    mm.b("bar 5.1 role not right, and the role = " + adxVar2.R().getRole(), new Object[0]);
                }
            }
            int iValueOf = 0;
            while (true) {
                Integer num = iValueOf;
                if (num.intValue() < 4) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (entry.getValue() != null && num.equals(entry.getKey())) {
                            this.af.addView(new arf(p(), (adx) entry.getValue()), layoutParams);
                        }
                    }
                    boolean z = map.get(num) != null;
                    switch (num.intValue()) {
                        case 1:
                            this.at.setVisibility(z ? 0 : 4);
                            this.av.setVisibility(z ? 0 : 4);
                            break;
                        case 2:
                            this.au.setVisibility(z ? 0 : 4);
                            this.aw.setVisibility(z ? 0 : 4);
                            break;
                    }
                    iValueOf = Integer.valueOf(num.intValue() + 1);
                } else {
                    this.c.addView(appPlayerTotalVolumeSeekbar, layoutParams);
                    return;
                }
            }
        } else if (adzVarM.d() == 2) {
            this.ai.setVisibility(0);
            this.af.setVisibility(0);
            for (adx adxVar3 : arrayList) {
                if (adxVar3.R().getRole() == 21) {
                    mm.b("adapt 5.1 master", new Object[0]);
                } else if (adxVar3.R().getRole() == 1) {
                    map.put(0, adxVar3);
                    mm.b("adapt 5.1 front left", new Object[0]);
                } else if (adxVar3.R().getRole() == 2) {
                    map.put(1, adxVar3);
                    mm.b("adapt 5.1 front right", new Object[0]);
                } else if (adxVar3.R().getRole() == 3) {
                    map.put(2, adxVar3);
                    mm.b("adapt 5.1 center", new Object[0]);
                } else if (adxVar3.R().getRole() == 5) {
                    map.put(3, adxVar3);
                    mm.b("adapt 5.1 rear left", new Object[0]);
                } else if (adxVar3.R().getRole() == 6) {
                    map.put(4, adxVar3);
                    mm.b("adapt 5.1 rear left", new Object[0]);
                } else if (adxVar3.R().getRole() == 4) {
                    map.put(5, adxVar3);
                    mm.b("room device size subwoofer", new Object[0]);
                } else {
                    mm.b("adapt 5.1 role not right, and the role = " + adxVar3.R().getRole(), new Object[0]);
                }
            }
            int iValueOf2 = 0;
            while (true) {
                Integer num2 = iValueOf2;
                if (num2.intValue() < 5) {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (num2.equals(entry2.getKey())) {
                            this.af.addView(new arf(p(), (adx) entry2.getValue()), layoutParams);
                        }
                    }
                    boolean z2 = map.get(num2) != null;
                    switch (num2.intValue()) {
                        case 0:
                            this.ak.setVisibility(z2 ? 0 : 4);
                            this.aq.setVisibility(z2 ? 0 : 4);
                            break;
                        case 1:
                            this.an.setVisibility(z2 ? 0 : 4);
                            this.ao.setVisibility(z2 ? 0 : 4);
                            break;
                        case 2:
                            this.aj.setVisibility(z2 ? 0 : 4);
                            this.ap.setVisibility(z2 ? 0 : 4);
                            break;
                        case 3:
                            this.al.setVisibility(z2 ? 0 : 4);
                            this.ar.setVisibility(z2 ? 0 : 4);
                            break;
                        case 4:
                            this.am.setVisibility(z2 ? 0 : 4);
                            this.as.setVisibility(z2 ? 0 : 4);
                            break;
                    }
                    iValueOf2 = Integer.valueOf(num2.intValue() + 1);
                } else {
                    this.c.addView(appPlayerTotalVolumeSeekbar, layoutParams);
                    return;
                }
            }
        } else {
            arv arvVar = new arv(p(), adzVarM, true);
            arvVar.setNameVisible(8);
            this.c.addView(arvVar, layoutParams);
        }
    }

    private adx d(int i) {
        for (adx adxVar : this.g) {
            if (adxVar.R().getRole() == i) {
                return adxVar;
            }
        }
        return this.g.get(0);
    }

    class a extends RecyclerView.a<C0015a> {
        private C0015a b;

        private a() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0015a a(ViewGroup viewGroup, int i) {
            if (akd.this.an().n().e() == 2 || akd.this.an().n().e() == 4) {
                this.b = new C0015a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.room_management_speakers_icon, viewGroup, false));
            } else {
                this.b = new C0015a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.draggable_speakers_icon, viewGroup, false));
            }
            return this.b;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(C0015a c0015a, int i) {
            if (akd.this.ae == 0) {
                c0015a.o.setImageResource(((adx) akd.this.g.get(i)).A());
                c0015a.p.setText(((adx) akd.this.g.get(i)).x());
                return;
            }
            if (akd.this.ae == 1) {
                if (akd.this.g.size() == 2) {
                    c0015a.o.setImageResource(((adx) akd.this.g.get(i)).A());
                    c0015a.p.setText(((adx) akd.this.g.get(i)).x());
                    return;
                }
                if (akd.this.g.size() == 1) {
                    c0015a.o.setImageResource(((adx) akd.this.g.get(0)).A());
                    int role = ((adx) akd.this.g.get(0)).R().getRole();
                    if (role == 21 && i == 0) {
                        c0015a.p.setText(((adx) akd.this.g.get(0)).x());
                        return;
                    } else if (role - 1 == i) {
                        c0015a.p.setText(((adx) akd.this.g.get(0)).x());
                        return;
                    } else {
                        c0015a.p.setText(R.string.kRoomManangementOfflineSpeaker);
                        return;
                    }
                }
                return;
            }
            if (akd.this.ae == 3) {
                c0015a.o.setImageResource(((adx) akd.this.g.get(i)).A());
                c0015a.p.setText(((adx) akd.this.g.get(i)).x());
            } else if (akd.this.ae == 4) {
                c0015a.o.setImageResource(((adx) akd.this.g.get(i)).A());
                c0015a.p.setText(((adx) akd.this.g.get(i)).x());
            } else if (akd.this.ae == 2) {
                c0015a.o.setImageResource(((adx) akd.this.g.get(i)).A());
                c0015a.p.setText(((adx) akd.this.g.get(i)).x());
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return akd.this.g.size();
        }

        /* JADX INFO: renamed from: akd$a$a, reason: collision with other inner class name */
        class C0015a extends RecyclerView.v {
            private ImageView o;
            private TextView p;

            public C0015a(View view) {
                super(view);
                this.o = (ImageView) view.findViewById(R.id.icon);
                this.p = (TextView) view.findViewById(R.id.speaker_drag_name);
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        aob.h().a((ady) null);
        aob.h().a(arh.n);
    }
}
