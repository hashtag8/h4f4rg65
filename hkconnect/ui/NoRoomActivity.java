package com.harman.hkconnect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import defpackage.adx;
import defpackage.aey;
import defpackage.aez;
import defpackage.ahx;
import defpackage.aof;
import defpackage.are;
import defpackage.asc;
import defpackage.asd;
import defpackage.asg;
import defpackage.asj;
import defpackage.ask;
import defpackage.mm;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NoRoomActivity extends Activity {
    private aey a;
    private asg b;
    private are c;
    private ask d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_no_room);
        this.d = new ask(this, new asj() { // from class: com.harman.hkconnect.ui.NoRoomActivity.1
            @Override // defpackage.asj
            public void a(String str) {
                mm.b("Wifi changed to %s", str);
                if (str != null) {
                    NoRoomActivity.this.b();
                }
            }
        });
        a();
    }

    private void a() {
        TextView textView = (TextView) findViewById(R.id.setup_speaker_tv);
        TextView textView2 = (TextView) findViewById(R.id.no_rooms_found);
        TextView textView3 = (TextView) findViewById(R.id.cannot_see_room);
        ((TextView) findViewById(R.id.open_source_licence)).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.NoRoomActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NoRoomActivity.this.startActivity(new Intent(NoRoomActivity.this, (Class<?>) OpenSourceLicenceActivity.class));
            }
        });
        this.a = new aez() { // from class: com.harman.hkconnect.ui.NoRoomActivity.3
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                NoRoomActivity.this.c();
            }
        };
        String strB = ahx.a().b();
        if (strB == null) {
            strB = "\"MyHome\"";
        }
        textView2.setText(getString(R.string.kSetupSearching_Content_Str2, new Object[]{strB}));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.NoRoomActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(NoRoomActivity.this, (Class<?>) ProductSetupMasterActivity.class);
                intent.putExtra("SETUP_TYPE", 0);
                NoRoomActivity.this.startActivity(intent);
                NoRoomActivity.this.d.b();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.NoRoomActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NoRoomActivity.this.d();
            }
        });
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        aof.a().c().a(this.a);
        c();
        this.c = new are(this) { // from class: com.harman.hkconnect.ui.NoRoomActivity.6
            @Override // defpackage.are
            public void b() {
                aof.a().c().a(NoRoomActivity.this.a);
                NoRoomActivity.this.c();
            }

            @Override // defpackage.are
            public void c() {
                aof.a().c().b(NoRoomActivity.this.a);
            }
        };
        HarmanApplication.a().registerActivityLifecycleCallbacks(this.c);
        this.d.a();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        aof.a().c().b(this.a);
        HarmanApplication.a().unregisterActivityLifecycleCallbacks(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            new asd(this.b).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!aof.a().d().isEmpty()) {
            if (this.b != null && this.b.isShowing()) {
                new asd(this.b).a();
            }
            Intent intent = new Intent(this, (Class<?>) DashboardActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b = new asg(this);
        new asc(this.b).a(null);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.d.b();
    }
}
