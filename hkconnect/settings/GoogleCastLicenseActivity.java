package com.harman.hkconnect.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ahm;
import defpackage.ain;
import defpackage.aqb;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class GoogleCastLicenseActivity extends aqb implements View.OnClickListener {
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView s;
    private TextView t;
    private final BroadcastReceiver u = new BroadcastReceiver() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ACTION_MK_SPEAKER_CHANGED")) {
                mm.b("have a check if has MKII speaks in the speaker list" + ain.o, new Object[0]);
                GoogleCastLicenseActivity.this.k();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        setContentView(R.layout.activity_googlecast_license);
        findViewById(R.id.googlecast_ok).setOnClickListener(this);
        this.m = (TextView) findViewById(R.id.googlecast_license_terms);
        this.n = (TextView) findViewById(R.id.googlecast_license_privacy);
        this.p = (TextView) findViewById(R.id.googlecast_open_source_licence);
        this.s = (TextView) findViewById(R.id.google_analytics);
        this.t = (TextView) findViewById(R.id.harman_privacy_policy);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoogleCastLicenseActivity.this.a("http://www.google.com/policies/privacy/");
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoogleCastLicenseActivity.this.a("http://www.google.com/policies/terms/");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoogleCastLicenseActivity.this.a("https://support.google.com/googlecast/answer/6121012");
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoogleCastLicenseActivity.this.a("https://www.google.com/policies/privacy/partners/");
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.GoogleCastLicenseActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoogleCastLicenseActivity.this.a("http://www.harman.com/privacy-policy");
            }
        });
        this.o = (TextView) findViewById(R.id.ToS_and_privacy_policy_approval);
        if (getResources().getConfiguration().locale.getLanguage().endsWith("de")) {
            this.o.setText(R.string.ToS_de);
        } else {
            this.o.setText(R.string.ToS_other_language);
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!ain.o) {
            this.p.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return;
        }
        this.p.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
    }

    private void l() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MK_SPEAKER_CHANGED");
        new ahm(this, this.u).b(intentFilter);
    }

    @Override // defpackage.aqb
    protected void a(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(Intent.createChooser(intent, "please select a browser"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.googlecast_ok) {
            onBackPressed();
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        finish();
    }
}
