package com.harman.hkconnect.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqb;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class SpeakerAotuUpdateSettingActivity extends aqb {
    private aju m;
    private Switch n;
    private TextView o;
    private TextView p;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_software_update_setting);
        k();
        l();
    }

    private void k() {
        this.o = (TextView) findViewById(R.id.aotu_device_update_time_item_tv);
        this.p = (TextView) findViewById(R.id.aotu_device_update_time_tv);
        this.n = (Switch) findViewById(R.id.aotu_upgrade_device_swith);
        b(this.n.isChecked());
        findViewById(R.id.aotu_update_time_layout).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.SpeakerAotuUpdateSettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpeakerAotuUpdateSettingActivity.this.startActivity(new Intent(SpeakerAotuUpdateSettingActivity.this, (Class<?>) SpeakerAotuUpdateTimeSettingActivity.class));
            }
        });
        this.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.harman.hkconnect.settings.SpeakerAotuUpdateSettingActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SpeakerAotuUpdateSettingActivity.this.b(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        mm.a(Boolean.valueOf(z));
        if (z) {
        }
    }

    private void l() {
        this.m = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.device_update_layout), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.m.a(true);
        this.m.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).a("Software update settings").j(R.color.transparent).c());
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
