package com.harman.hkconnect.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aqb;
import defpackage.aqy;
import defpackage.arc;
import defpackage.atf;
import defpackage.atl;
import defpackage.atm;
import defpackage.ato;
import defpackage.atp;
import defpackage.atq;
import defpackage.atr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProductInformationsActivity extends aqb implements View.OnClickListener, atm.a {
    private ImageView m;
    private TextView n;
    private aqy o;
    private atm p;
    private Map<atl, String> s = new HashMap();
    private atf t;

    @Override // atm.a
    public void a(atl atlVar, Bundle bundle) {
        if (!isFinishing()) {
            this.p = a(atlVar);
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.p.g(bundle);
            this.s.put(atlVar, this.o.a(this.p, new arc().d(R.anim.fragment_slide_in_from_right).g(R.anim.fragment_slide_out_to_right)));
        }
    }

    @Override // atm.a
    public void b(boolean z) {
    }

    @Override // atm.a
    public void b(String str) {
        this.n.setText(str);
    }

    @Override // atm.a
    public void c(boolean z) {
        this.m.setVisibility(z ? 0 : 4);
    }

    @Override // atm.a
    public void d(boolean z) {
    }

    @Override // atm.a
    public void k() {
    }

    @Override // atm.a
    public atf l() {
        return this.t;
    }

    @Override // atm.a
    public void a(atf atfVar) {
        this.t = atfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_product_update);
        this.o = new aqy(f(), R.id.setup_container);
        m();
    }

    private void m() {
        this.m = (ImageView) findViewById(R.id.go_back);
        this.m.setOnClickListener(this);
        this.n = (TextView) findViewById(R.id.product_setup_title);
        this.p = a(atl.PRODUCT_INFOMATION_PAGE);
        this.s.put(atl.FOTA_UPDATE_PAGE_REQUIREMENT, this.o.a(this.p, 0, (arc) null));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back /* 2131689713 */:
                onBackPressed();
                break;
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        if (this.m.getVisibility() == 0) {
            if (f().e() <= 1) {
                finish();
            } else if (!this.o.a(this)) {
                super.onBackPressed();
            }
        }
    }

    private atm a(atl atlVar) {
        if (atlVar == atl.SOFTWARE_UPDATE_SETTINGS_PAGE) {
            this.p = new atr();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_SETTING_TIME_PICKUP) {
            this.p = new ato();
        } else if (atlVar == atl.FOTA_UPDATE_PAGE_SETTING_TIMEZONE_PICKUP) {
            this.p = new atp();
        } else {
            this.p = new atq();
        }
        return this.p;
    }
}
