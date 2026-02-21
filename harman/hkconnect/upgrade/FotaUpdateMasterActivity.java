package com.harman.hkconnect.upgrade;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.RippleTextView;
import defpackage.adx;
import defpackage.aey;
import defpackage.aez;
import defpackage.ain;
import defpackage.aof;
import defpackage.apw;
import defpackage.aqb;
import defpackage.aqy;
import defpackage.arc;
import defpackage.ard;
import defpackage.atd;
import defpackage.atf;
import defpackage.atg;
import defpackage.ath;
import defpackage.ati;
import defpackage.atk;
import defpackage.atl;
import defpackage.atm;
import defpackage.atn;
import defpackage.ato;
import defpackage.atp;
import defpackage.mm;
import defpackage.mo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FotaUpdateMasterActivity extends aqb implements View.OnClickListener, atm.a {
    public static String m = "TRIGGER_SOURCE_FROM";
    public static String n = "DEVICE_LIST";
    private atf A;
    private aqy o;
    private apw p;
    private ImageView s;
    private ImageView t;
    private TextView u;
    private atm v;
    private Map<atl, String> w = new HashMap();
    private aey x;
    private ArrayList<adx> y;
    private RippleTextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_fota_update_master);
        this.o = new aqy(f(), R.id.setup_container);
        this.p = new apw(this, R.anim.fragment_slide_in_from_right, R.anim.fragment_slide_out_to_left);
        new ard(this, false).a();
        n();
        m();
    }

    private void m() {
        this.x = new aez() { // from class: com.harman.hkconnect.upgrade.FotaUpdateMasterActivity.1
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                mo.a.a(new Runnable() { // from class: com.harman.hkconnect.upgrade.FotaUpdateMasterActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            @Override // defpackage.aez, defpackage.aey
            public void b(adx adxVar) {
                if (FotaUpdateMasterActivity.this.y != null) {
                    FotaUpdateMasterActivity.this.y.remove(adxVar);
                    if (FotaUpdateMasterActivity.this.y.size() == 0 && !(FotaUpdateMasterActivity.this.v instanceof ath)) {
                        FotaUpdateMasterActivity.this.finish();
                    }
                }
            }
        };
        aof.a().c().a(this.x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.gk, defpackage.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aof.a().c().b(this.x);
    }

    private void n() {
        this.s = (ImageView) findViewById(R.id.right_button);
        this.t = (ImageView) findViewById(R.id.go_back);
        this.z = (RippleTextView) findViewById(R.id.product_setup_next);
        this.z.setVisibility(4);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.u = (TextView) findViewById(R.id.product_setup_title);
        Bundle extras = getIntent().getExtras();
        int i = extras.getInt(m);
        if (i == 0) {
            this.y = (ArrayList) extras.getSerializable(n);
        } else {
            this.y = new ArrayList<>();
            this.y.add((adx) extras.getSerializable(n));
        }
        if (b(this.y)) {
            this.v = a(atl.FOTA_UPDATE_PAGE_PROCESS_BY_ANOTHER);
        } else if (i == 0) {
            this.v = a(atl.FOTA_UPDATE_PAGE_REQUIREMENT);
        } else if (d(this.y)) {
            this.v = a(atl.FOTA_UPDATE_PAGE_LOWER_BATTERY);
        } else {
            this.v = a(atl.FOTA_UPDATE_PAGE_SETTING);
            if (!c(this.y)) {
                this.v = a(atl.FOTA_UPDATE_PAGE_PROCESS);
            }
        }
        extras.putSerializable(n, new ArrayList(this.y));
        this.v.g(extras);
        this.w.put(atl.FOTA_UPDATE_PAGE_REQUIREMENT, this.o.a(this.v, 0, (arc) null));
    }

    private atm a(atl atlVar) {
        if (atlVar == atl.FOTA_UPDATE_PAGE_LOWER_BATTERY) {
            this.v = new atk();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_PROCESS) {
            this.v = new ath();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_PROCESS_BY_ANOTHER) {
            this.v = new atg();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_REQUIREMENT) {
            this.v = new ati();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_SETTING) {
            this.v = new atn();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_SETTING_TIME_PICKUP) {
            this.v = new ato();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_SETTING_TIMEZONE_PICKUP) {
            this.v = new atp();
        }
        return this.v;
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        if (this.t.getVisibility() == 0) {
            if (f().e() <= 1) {
                finish();
            } else if (!this.o.a(this)) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        atm atmVar = (atm) this.o.a();
        switch (view.getId()) {
            case R.id.go_back /* 2131689713 */:
                onBackPressed();
                break;
            case R.id.right_button /* 2131689715 */:
                finish();
                ain.b = false;
                break;
            case R.id.product_setup_next /* 2131689717 */:
                if (atmVar != null) {
                    atmVar.d();
                }
                break;
        }
    }

    private boolean b(List<adx> list) {
        for (adx adxVar : list) {
            if (adxVar.O() && adxVar.h().a == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean c(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().O()) {
                return true;
            }
        }
        return false;
    }

    private boolean d(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().q() == 6) {
                return true;
            }
        }
        return false;
    }

    @Override // atm.a
    public void a(atl atlVar, Bundle bundle) {
        if (!isFinishing()) {
            this.v = a(atlVar);
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putSerializable(n, new ArrayList(this.y));
            }
            this.v.g(bundle);
            this.w.put(atlVar, this.o.a(this.v, new arc().d(R.anim.fragment_slide_in_from_right).g(R.anim.fragment_slide_out_to_right)));
        }
    }

    @Override // atm.a
    public void b(boolean z) {
        this.z.setVisibility(z ? 0 : 4);
    }

    @Override // atm.a
    public void b(String str) {
        this.u.setText(str);
    }

    @Override // atm.a
    public void k() {
        this.y = a(aof.a().f());
        if (this.y != null) {
            if (d(this.y)) {
                a(atl.FOTA_UPDATE_PAGE_LOWER_BATTERY, (Bundle) null);
            } else if (c(this.y)) {
                a(atl.FOTA_UPDATE_PAGE_SETTING, (Bundle) null);
            } else {
                a(atl.FOTA_UPDATE_PAGE_PROCESS, (Bundle) null);
            }
        }
    }

    public ArrayList<adx> a(List<adx> list) {
        ArrayList<adx> arrayList = new ArrayList<>();
        for (adx adxVar : list) {
            mm.e("TEST_DEVICE_FOTA_CHANGE update way = %s", Integer.valueOf(aof.a().b(adxVar)));
            if (aof.a().b(adxVar) != 0 && aof.a().b(adxVar) > 0) {
                arrayList.add(adxVar);
            }
        }
        Collections.sort(arrayList, new atd());
        return arrayList;
    }

    @Override // atm.a
    public atf l() {
        return this.A;
    }

    @Override // atm.a
    public void a(atf atfVar) {
        this.A = atfVar;
    }

    @Override // atm.a
    public void c(boolean z) {
        this.t.setVisibility(z ? 0 : 4);
    }

    @Override // atm.a
    public void d(boolean z) {
        this.s.setVisibility(z ? 0 : 4);
    }
}
