package com.harman.hkconnect.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.OpenSourceLicenceActivity;
import com.harman.hkconnect.ui.ToolActivity;
import defpackage.ahm;
import defpackage.ain;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqb;
import defpackage.asn;
import defpackage.asw;
import defpackage.ba;
import defpackage.mm;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes.dex */
public class ProductInfoActivity extends aqb implements View.OnClickListener {
    private View m;
    private View n;
    private View o;
    private View p;
    private View s;
    private TextView t;
    private aju u;
    private final BroadcastReceiver v = new BroadcastReceiver() { // from class: com.harman.hkconnect.settings.ProductInfoActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ACTION_MK_SPEAKER_CHANGED")) {
                mm.b("have a check if has MKII speaks in the speaker list" + ain.o, new Object[0]);
                ProductInfoActivity.this.n();
            }
        }
    };
    private int w = 0;
    private long x = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_productinfo);
        k();
        m();
        l();
    }

    private void k() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MK_SPEAKER_CHANGED");
        new ahm(this, this.v).b(intentFilter);
    }

    private void l() {
        this.u = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.productinfo_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.u.a(true);
        this.u.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_ProductionTitle_Str).j(R.color.transparent).c());
    }

    private void m() {
        this.m = findViewById(R.id.app_version);
        this.n = findViewById(R.id.product_version);
        this.o = findViewById(R.id.blackfire);
        this.p = findViewById(R.id.googlecast);
        this.s = findViewById(R.id.opensource);
        findViewById(R.id.release_info);
        if (!ain.o) {
            this.p.setVisibility(8);
        }
        findViewById(R.id.times_service).setOnClickListener(this);
        findViewById(R.id.privacy_statement).setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t = (TextView) findViewById(R.id.app_version_tv);
        this.t.setText(asw.a().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!ain.o) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.app_version /* 2131689740 */:
                break;
            case R.id.app_version_string /* 2131689741 */:
            case R.id.app_version_tv /* 2131689742 */:
            default:
                return;
            case R.id.product_version /* 2131689743 */:
                o();
                return;
            case R.id.blackfire /* 2131689744 */:
                p();
                return;
            case R.id.googlecast /* 2131689745 */:
                q();
                return;
            case R.id.opensource /* 2131689746 */:
                r();
                return;
            case R.id.times_service /* 2131689747 */:
                asn.a.a((ba) this);
                return;
            case R.id.privacy_statement /* 2131689748 */:
                asn.a.b((ba) this);
                return;
            case R.id.release_info /* 2131689749 */:
                s();
                break;
        }
        if (this.x > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.x;
            System.out.println("------Bright---------->" + jUptimeMillis);
            if (jUptimeMillis < 300) {
                this.w++;
                if (this.w > 10) {
                    this.w = 0;
                    this.x = 0L;
                    startActivity(new Intent().setClass(this, ToolActivity.class));
                    finish();
                }
                this.x = SystemClock.uptimeMillis();
                return;
            }
            this.w = 0;
            this.x = 0L;
            return;
        }
        this.x = SystemClock.uptimeMillis();
    }

    private void o() {
        startActivity(new Intent(this, (Class<?>) ProductInformationsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ba, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case ContentLengthStrategy.IDENTITY /* -1 */:
                n();
                break;
        }
    }

    private void p() {
        startActivity(new Intent(this, (Class<?>) BlackFireActivity.class));
    }

    private void q() {
        startActivity(new Intent(this, (Class<?>) GoogleCastActivity.class));
    }

    private void r() {
        startActivity(new Intent(this, (Class<?>) OpenSourceLicenceActivity.class));
    }

    private void s() {
        startActivity(new Intent(this, (Class<?>) ReleaseInfoActivity.class));
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
