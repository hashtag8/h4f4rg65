package com.harman.hkconnect.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.TutorialActivity;
import com.harman.hkconnect.ui.custom.HorizontalListView;
import defpackage.aim;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aog;
import defpackage.aqc;
import defpackage.ard;
import defpackage.ave;
import defpackage.mm;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends aqc implements View.OnClickListener {
    private View A;
    private View B;
    private HorizontalListView C;
    private LayoutInflater D;
    private ArrayList<ave> E;
    private a F;
    private aju G;
    private View m;
    private View n;
    private View o;
    private View p;
    private View y;
    private View z;

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.G.a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        m();
        l();
        n();
        this.D = LayoutInflater.from(this);
        new ard(this, true).a();
    }

    private void l() {
        this.G = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.settings_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.G.a(true);
        this.G.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_title_Str).j(R.color.transparent).c());
    }

    private void m() {
        this.m = findViewById(R.id.setup);
        this.n = findViewById(R.id.product_info);
        this.o = findViewById(R.id.tutorial);
        this.p = findViewById(R.id.feedback);
        this.y = findViewById(R.id.service_title);
        this.z = findViewById(R.id.room_management);
        this.A = findViewById(R.id.faq);
        this.B = findViewById(R.id.advanced_control);
        this.C = (HorizontalListView) findViewById(R.id.mslist);
        this.C.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
    }

    private void n() {
        this.E = aim.a().l();
        this.F = new a();
        this.C.setAdapter((ListAdapter) this.F);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.service_title /* 2131689762 */:
            case R.id.mslist /* 2131689763 */:
                startActivity(new Intent(this, (Class<?>) ServiceManagementActivity.class));
                break;
            case R.id.setup /* 2131689764 */:
                p();
                break;
            case R.id.room_management /* 2131689765 */:
                q();
                break;
            case R.id.tutorial /* 2131689766 */:
                s();
                break;
            case R.id.product_info /* 2131689767 */:
                r();
                break;
            case R.id.advanced_control /* 2131689768 */:
                o();
                break;
            case R.id.faq /* 2131689769 */:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.harmankardon.com/omnisupport")));
                break;
            case R.id.feedback /* 2131689770 */:
                C();
                break;
        }
    }

    private void o() {
        startActivity(new Intent(this, (Class<?>) DisableHardwareVolumeActivity.class));
    }

    private void p() {
        mm.b();
        Intent intent = new Intent(this, (Class<?>) ProductSetupMasterActivity.class);
        intent.putExtra("SETUP_TYPE", 0);
        startActivity(intent);
    }

    private void q() {
        mm.b();
        Intent intent = new Intent(this, (Class<?>) ProductSetupMasterActivity.class);
        intent.putExtra("SETUP_TYPE", 1);
        startActivity(intent);
    }

    private void r() {
        mm.b();
        startActivity(new Intent(this, (Class<?>) ProductInfoActivity.class));
    }

    private void s() {
        mm.b();
        Intent intent = new Intent(this, (Class<?>) TutorialActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("PAGE_TYPE", TutorialActivity.a.MUSIC_SERVICES);
        bundle.putBoolean("FIRST_TIME", false);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void C() {
        mm.b();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{aog.h()});
        intent.putExtra("android.intent.extra.SUBJECT", "feedback subject");
        intent.putExtra("android.intent.extra.TEXT", aog.g());
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.JukeEmail)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "There are no email clients installed.", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void k() {
        super.k();
    }

    @Override // defpackage.aqc, defpackage.aqb, defpackage.ba, android.app.Activity
    public void onResume() {
        super.onResume();
        this.E = aim.a().l();
        this.F.notifyDataSetChanged();
    }

    class a extends BaseAdapter {
        private a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SettingsActivity.this.E.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0139a c0139a;
            if (view == null) {
                view = SettingsActivity.this.D.inflate(R.layout.harman_icon, (ViewGroup) null);
                c0139a = new C0139a();
                c0139a.a = (ImageView) view.findViewById(R.id.icon);
                c0139a.b = (ImageView) view.findViewById(R.id.right_icon);
                view.setTag(c0139a);
            } else {
                c0139a = (C0139a) view.getTag();
            }
            c0139a.a.setImageResource(((ave) SettingsActivity.this.E.get(i)).e());
            return view;
        }

        /* JADX INFO: renamed from: com.harman.hkconnect.settings.SettingsActivity$a$a, reason: collision with other inner class name */
        class C0139a {
            ImageView a;
            ImageView b;

            C0139a() {
            }
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
