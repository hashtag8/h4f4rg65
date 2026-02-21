package com.harman.hkconnect.settings;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;
import com.harman.hkconnect.R;
import defpackage.adw;
import defpackage.adx;
import defpackage.aho;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aof;
import defpackage.aqb;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GoogleCastActivity extends aqb implements View.OnClickListener {
    private View m;
    private View n;
    private View o;
    private Switch p;
    private View s;
    private View t;
    private aju u;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_googlecast);
        l();
        k();
    }

    private void k() {
        this.u = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.productinfo_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.u.a(true);
        this.u.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.SettingGoogleCast_Str).j(R.color.transparent).c());
    }

    private void l() {
        this.m = findViewById(R.id.learn_cast);
        this.n = findViewById(R.id.cast_ready_app);
        this.o = findViewById(R.id.learn_cast_privacy);
        this.t = findViewById(R.id.google_cast_open_source_licence);
        this.p = (Switch) findViewById(R.id.share_usage_btn);
        this.s = findViewById(R.id.share_usage);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.p.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.ba, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p.setChecked(aho.b("ShareUsage", true));
        c(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.learn_cast /* 2131689720 */:
                a("https://www.google.com/cast/learn/audio/");
                break;
            case R.id.cast_ready_app /* 2131689721 */:
                a("https://www.google.com/cast/apps/#speakers");
                break;
            case R.id.learn_cast_privacy /* 2131689722 */:
                a("https://support.google.com/googlecast/answer/6076570");
                break;
            case R.id.google_cast_open_source_licence /* 2131689723 */:
                a("https://support.google.com/googlecast/answer/6121012");
                break;
            case R.id.share_usage_btn /* 2131689725 */:
                if (this.p.isChecked()) {
                    c(1);
                    aho.a("ShareUsage", true);
                } else {
                    c(0);
                    aho.a("ShareUsage", false);
                }
                break;
        }
    }

    private void c(int i) {
        List<adx> listF = aof.a().f();
        if (listF != null && !listF.isEmpty()) {
            Iterator<adx> it = listF.iterator();
            while (it.hasNext()) {
                adw.a().b(it.next(), i);
            }
        }
    }
}
