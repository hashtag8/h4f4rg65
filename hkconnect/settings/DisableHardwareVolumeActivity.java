package com.harman.hkconnect.settings;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.harman.hkconnect.R;
import defpackage.aho;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqc;

/* JADX INFO: loaded from: classes.dex */
public class DisableHardwareVolumeActivity extends aqc {
    private aju m;
    private Switch n;

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.m.a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_disable_hardware_volume);
        m();
        l();
    }

    private void l() {
        this.m = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.settings_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.m.a(true);
        this.m.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_AdvancedControl_Title_Str).j(R.color.transparent).c());
    }

    private void m() {
        this.n = (Switch) findViewById(R.id.disable_switch);
        this.n.setChecked(aho.a("KEY_DISABLE_HARDWARE_VOLUME"));
        this.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.harman.hkconnect.settings.DisableHardwareVolumeActivity.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    aho.a("KEY_DISABLE_HARDWARE_VOLUME", true);
                } else {
                    aho.a("KEY_DISABLE_HARDWARE_VOLUME", false);
                }
            }
        });
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
