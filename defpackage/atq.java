package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.LinearLayoutManager;
import com.harman.hkconnect.upgrade.FotaUpdateMasterActivity;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atq extends atm {
    private RecyclerView a;
    private aey b;
    private a c;
    private boolean d = false;
    private boolean e = false;
    private View f;
    private View g;
    private TextView h;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_product_infos, (ViewGroup) null);
        this.a = (RecyclerView) viewInflate.findViewById(R.id.product_lv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(1);
        this.a.setLayoutManager(linearLayoutManager);
        al();
        this.f = viewInflate.findViewById(R.id.software_update_srtting);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: atq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                atq.this.e().a(atl.SOFTWARE_UPDATE_SETTINGS_PAGE, null);
            }
        });
        this.h = (TextView) viewInflate.findViewById(R.id.no_product_tv);
        this.g = viewInflate.findViewById(R.id.update_setting_divider);
        return viewInflate;
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        aof.a().c().a(this.b);
        e().b(q().getString(R.string.kSettings_ProductTitle_Str));
        e().c(true);
        this.e = true;
        am();
        a(aof.a().f());
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
        aof.a().c().b(this.b);
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<adx> list) {
        if (this.f != null) {
            if (b(list)) {
                this.f.setVisibility(list.size() > 0 ? 0 : 8);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    protected void al() {
        this.b = new aez() { // from class: atq.2
            @Override // defpackage.aez, defpackage.aey
            public void a(final List<adx> list) {
                mo.a.post(new Runnable() { // from class: atq.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        atq.this.a((List<adx>) list);
                        mm.b("TEST_UPDATE_VERSION", "size=" + list.size());
                        if (list.size() == 0) {
                            atq.this.b(true);
                            return;
                        }
                        atq.this.b(false);
                        if (atq.this.c == null) {
                            atq.this.c = new a();
                            atq.this.c.a(list);
                            atq.this.a.setAdapter(atq.this.c);
                        }
                        atq.this.c((List<adx>) list);
                        atq.this.c.a(list);
                        atq.this.c.c();
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
        this.a.setVisibility(z ? 8 : 0);
        this.g.setVisibility(z ? 8 : 0);
    }

    private boolean b(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().O()) {
                return true;
            }
        }
        return false;
    }

    private void am() {
        mq.a("CYCLE_QUERY_WIFIRSSI").a(new Runnable() { // from class: atq.3
            @Override // java.lang.Runnable
            public void run() {
                while (atq.this.e) {
                    try {
                        Iterator<adx> it = aof.a().f().iterator();
                        while (it.hasNext()) {
                            adw.a().queryWifi(it.next());
                        }
                        Thread.sleep(500L);
                        mo.a.a(new Runnable() { // from class: atq.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (atq.this.c != null) {
                                    atq.this.c.c();
                                }
                            }
                        });
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final List<adx> list) {
        mq.b().b(new Runnable() { // from class: atq.4
            @Override // java.lang.Runnable
            public void run() {
                for (adx adxVar : list) {
                    if (adxVar.O() && adxVar.h() != null && adxVar.h().a == 0 && !atq.this.d) {
                        adxVar.a((aea) null);
                        atq.this.d = true;
                    }
                }
            }
        });
    }

    class a extends RecyclerView.a<C0058a> {
        private List<adx> b;

        private a() {
        }

        public void a(List<adx> list) {
            this.b = list;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0058a a(ViewGroup viewGroup, int i) {
            return new C0058a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(C0058a c0058a, int i) {
            adz adzVarA;
            final adx adxVar = this.b.get(i);
            if (adxVar != null) {
                c0058a.n.setImageResource(adxVar.A());
                c0058a.n.setOnClickListener(new View.OnClickListener() { // from class: atq.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        adw.a().a(adxVar);
                    }
                });
                if (aho.b("KEY_SHOW_ORIGINAL_CODE", false)) {
                    c0058a.x.setText("Region Code : " + adxVar.c());
                } else {
                    c0058a.x.setVisibility(8);
                }
                c0058a.q.setText(adxVar.x());
                if (adxVar.s() == 0) {
                    c0058a.r.setVisibility(8);
                }
                c0058a.u.setText(atq.this.q().getString(R.string.kSettings_MACAddress) + " : " + adxVar.d());
                c0058a.v.setText(atq.this.q().getString(R.string.kSettings_IPAddress) + " : " + adxVar.z());
                c0058a.r.setText(adxVar.w());
                if (aho.a("KEY_SHOW_ROOM_TYPE_IN_ROOM_NAME") && (adzVarA = aof.a().a(adxVar)) != null) {
                    c0058a.r.setText(adxVar.w() + "  " + adzVarA.w());
                }
                c0058a.s.setText(ahv.a(adxVar.n()));
                if (!TextUtils.isEmpty(adxVar.ah())) {
                    c0058a.w.setText(atq.this.q().getString(R.string.SettingGoogleCastService_Str) + " : " + adxVar.ah());
                }
                c0058a.t.setVisibility(8);
                short sF = adxVar.f();
                mm.b("TEST_WIFI_STRENGTH device mac = %s ,level = %s", adxVar.d(), Short.valueOf(adxVar.f()));
                c0058a.p.setVisibility(0);
                if (sF >= 0) {
                    c0058a.p.setImageResource(R.drawable.setupspeaker_wifisignal5);
                } else {
                    c0058a.p.setImageResource(atq.this.d(sF));
                }
                if (aof.a().b(adxVar) > 0) {
                    c0058a.t.setVisibility(0);
                }
                if ("".equals(c0058a.q.getText().toString().trim())) {
                    c0058a.q.setVisibility(4);
                } else {
                    c0058a.q.setVisibility(0);
                }
                if ("".equals(c0058a.r.getText().toString().trim())) {
                    c0058a.r.setVisibility(4);
                } else {
                    c0058a.r.setVisibility(0);
                }
                if ("".equals(c0058a.u.getText().toString().trim())) {
                    c0058a.u.setVisibility(4);
                } else {
                    c0058a.u.setVisibility(0);
                }
                if ("".equals(c0058a.v.getText().toString().trim())) {
                    c0058a.v.setVisibility(4);
                } else {
                    c0058a.v.setVisibility(0);
                }
                if ("".equals(c0058a.w.getText().toString().trim())) {
                    c0058a.w.setVisibility(8);
                } else {
                    c0058a.w.setVisibility(0);
                }
            }
            c0058a.t.setOnClickListener(new View.OnClickListener() { // from class: atq.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(atq.this.p(), (Class<?>) FotaUpdateMasterActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(FotaUpdateMasterActivity.n, adxVar);
                    bundle.putInt(FotaUpdateMasterActivity.m, 1);
                    intent.putExtras(bundle);
                    atq.this.p().startActivity(intent);
                }
            });
            c0058a.y.setOnClickListener(new View.OnClickListener() { // from class: atq.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    adxVar.Q();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return this.b.size();
        }

        /* JADX INFO: renamed from: atq$a$a, reason: collision with other inner class name */
        class C0058a extends RecyclerView.v {
            private View A;
            public ImageView n;
            public ImageView o;
            public ImageView p;
            public TextView q;
            public TextView r;
            public TextView s;
            public TextView t;
            public TextView u;
            public TextView v;
            public TextView w;
            public TextView x;
            public TextView y;

            public C0058a(View view) {
                super(view);
                this.A = view;
                this.p = (ImageView) view.findViewById(R.id.rssi);
                this.n = (ImageView) view.findViewById(R.id.product_icon);
                this.o = (ImageView) view.findViewById(R.id.product_update_iv);
                this.t = (TextView) view.findViewById(R.id.product_update_tv);
                this.y = (TextView) view.findViewById(R.id.product_reset_tv);
                if (aho.a("KEY_SHOW_DEVICE_RESET")) {
                    this.y.setVisibility(0);
                }
                this.s = (TextView) view.findViewById(R.id.product_version);
                this.q = (TextView) view.findViewById(R.id.product_name);
                this.r = (TextView) view.findViewById(R.id.product_info);
                this.u = (TextView) view.findViewById(R.id.mac_address);
                this.v = (TextView) view.findViewById(R.id.speaker_address);
                this.w = (TextView) view.findViewById(R.id.googlecast_version);
                this.x = (TextView) view.findViewById(R.id.original_code);
            }
        }
    }

    public int d(int i) {
        mm.b("TEST_WIFI_STRENGTH device mac = %s ,level = %s", 0, Integer.valueOf(i));
        if (i <= -75) {
            return R.drawable.setupspeaker_wifisignal4;
        }
        if (i <= -65 && i > -75) {
            return R.drawable.setupspeaker_wifisignal3;
        }
        if (i <= -55 && i > -65) {
            return R.drawable.setupspeaker_wifisignal2;
        }
        return R.drawable.setupspeaker_wifisignal1;
    }
}
