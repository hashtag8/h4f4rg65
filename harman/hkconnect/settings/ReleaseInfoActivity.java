package com.harman.hkconnect.settings;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqc;
import defpackage.asw;

/* JADX INFO: loaded from: classes.dex */
public class ReleaseInfoActivity extends aqc implements View.OnClickListener {
    private aju m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_releaseinfo);
        l();
        m();
    }

    private void l() {
        TextView textView = (TextView) findViewById(R.id.release_name);
        TextView textView2 = (TextView) findViewById(R.id.release_configlink);
        TextView textView3 = (TextView) findViewById(R.id.config_date_info);
        textView.setText("Version : " + asw.a().b());
        textView2.setText("Config link : " + asw.a().c());
        textView3.setText("Config data : " + asw.a().d());
    }

    private void m() {
        this.m = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.releaseinfo_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.m.a(true);
        this.m.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).a("Release").j(R.color.black).c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
