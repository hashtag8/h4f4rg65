package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class alq extends ale {
    View.OnClickListener a = new ahl(this) { // from class: alq.1
        @Override // defpackage.ahl
        public void a(View view) {
            DashboardActivity dashboardActivity = alq.this.ae;
            switch (view.getId()) {
                case R.id.settings_app /* 2131689754 */:
                    Toast.makeText(alq.this.ae, R.string.kDeezerNav_UncompleteWarning_Str, 0).show();
                    break;
                case R.id.settings_account /* 2131690190 */:
                    alp alpVar = new alp();
                    if (ahn.a()) {
                        dashboardActivity.q().a(alpVar, new arc().c(R.id.menu_container));
                    } else {
                        dashboardActivity.q().a(alpVar, (arc) null);
                    }
                    break;
                case R.id.settings_about /* 2131690191 */:
                    alo aloVar = new alo();
                    if (ahn.a()) {
                        dashboardActivity.q().a(aloVar, new arc().c(R.id.menu_container));
                    } else {
                        dashboardActivity.q().a(aloVar, (arc) null);
                    }
                    break;
            }
        }
    };
    private View b;
    private View c;
    private View d;
    private View e;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.fragment_deezer_settings, (ViewGroup) null);
        this.c = this.b.findViewById(R.id.settings_app);
        this.d = this.b.findViewById(R.id.settings_account);
        this.e = this.b.findViewById(R.id.settings_about);
        this.c.setOnClickListener(this.a);
        this.d.setOnClickListener(this.a);
        this.e.setOnClickListener(this.a);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.b;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void D() {
        super.D();
        mm.b(this + "onPause", new Object[0]);
    }

    @Override // android.support.v4.app.Fragment
    public void h() {
        super.h();
        mm.b(this + "onStop", new Object[0]);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        mm.b(this + "onDestroy", new Object[0]);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        mm.b(this + "onDetach", new Object[0]);
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(-13487558).g(R.string.kDeezerNav_Settings_Str).c();
    }
}
