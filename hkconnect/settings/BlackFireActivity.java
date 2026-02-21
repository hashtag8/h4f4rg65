package com.harman.hkconnect.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqc;

/* JADX INFO: loaded from: classes.dex */
public class BlackFireActivity extends aqc implements View.OnClickListener {
    private aju m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_blackfire);
        TextView textView = (TextView) findViewById(R.id.blackfire_link);
        textView.setText(Html.fromHtml("<a href=''>WWW.BLACKFIREALLIANCE.COM</a>"));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.settings.BlackFireActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://www.blackfirealliance.com/"));
                BlackFireActivity.this.startActivity(intent);
            }
        });
        l();
    }

    private void l() {
        this.m = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.blackfire_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.m.a(true);
        this.m.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_Blackfire_Str).j(R.color.black).c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
