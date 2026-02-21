package com.harman.hkconnect.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.aqc;

/* JADX INFO: loaded from: classes.dex */
public class SpotifyMoreInfoActivity extends aqc {
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_spotify_connect_more_info);
        findViewById(R.id.learn_more_tv).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.SpotifyMoreInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Uri uri = Uri.parse("https://spotify.com/connect");
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                SpotifyMoreInfoActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.right_button).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.SpotifyMoreInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpotifyMoreInfoActivity.this.finish();
            }
        });
    }
}
