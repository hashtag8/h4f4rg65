package defpackage;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.mixradio.control.DashboardMixRadioPanel;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public abstract class ayi extends ayh {
    DashboardMixRadioPanel d;
    private ProgressDialog f;
    int c = axz.a;
    public boolean e = false;

    abstract boolean al();

    abstract View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void c() {
        if (this.f == null) {
            this.f = new ProgressDialog(p(), 4);
            this.f.setCancelable(false);
            this.f.setMessage(this.ae.getString(R.string.kAndroid_Loading));
        }
        if (!this.f.isShowing()) {
            new asc(this.f).a(p());
        }
    }

    public void d() {
        if (this.f != null && this.f.isShowing()) {
            new asd(this.f).a();
            this.f = null;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (al() || this.e) {
            ViewGroup viewGroup = (ViewGroup) B();
            viewGroup.removeAllViewsInLayout();
            viewGroup.addView(a(p().getLayoutInflater(), viewGroup, l()));
            d(l());
        }
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            d();
        } else {
            this.c = axz.a;
            am();
            super.c(bundle);
        }
    }

    @Override // defpackage.ayh, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DashboardMixRadioPanel.a aVar = new DashboardMixRadioPanel.a() { // from class: ayi.1
            @Override // com.musicservice.mixradio.control.DashboardMixRadioPanel.a
            public void a() {
                ayi.this.ae.q().c();
            }

            @Override // com.musicservice.mixradio.control.DashboardMixRadioPanel.a
            public void b() {
                ayn aynVar = new ayn();
                if (ayi.this.ae.q().d()) {
                    ayi.this.ae.q().c();
                    ayi.this.ae.q().a(ayi.this.ae.f(), aynVar, (Bundle) null, R.id.middle_panel);
                } else {
                    ayi.this.ae.q().a(ayi.this.ae.f(), aynVar, (Bundle) null, R.id.middle_panel);
                }
            }

            @Override // com.musicservice.mixradio.control.DashboardMixRadioPanel.a
            public void c() {
                ayk aykVar = new ayk();
                if (ayi.this.ae.q().d()) {
                    ayi.this.ae.q().c();
                    ayi.this.ae.q().a(ayi.this.ae.f(), aykVar, (Bundle) null, R.id.middle_panel);
                } else {
                    ayi.this.ae.q().a(ayi.this.ae.f(), aykVar, (Bundle) null, R.id.middle_panel);
                }
            }
        };
        if (ahn.a()) {
            View viewInflate = layoutInflater.inflate(R.layout.mixradio_base_with_dialog, (ViewGroup) null);
            this.d = (DashboardMixRadioPanel) viewInflate.findViewById(R.id.left_panel);
            this.d.setOnMixRadioListener(aVar);
            if (!al()) {
                this.d.setVisibility(8);
            }
            ((LinearLayout) viewInflate.findViewById(R.id.container)).addView(c(layoutInflater, viewGroup, bundle));
            viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return viewInflate;
        }
        if (!al()) {
            return c(layoutInflater, viewGroup, bundle);
        }
        View viewInflate2 = layoutInflater.inflate(R.layout.mixradio_base_with_dialog, (ViewGroup) null);
        this.d = (DashboardMixRadioPanel) viewInflate2.findViewById(R.id.left_panel);
        this.d.setOnMixRadioListener(aVar);
        ((LinearLayout) viewInflate2.findViewById(R.id.container)).addView(c(layoutInflater, viewGroup, bundle));
        return viewInflate2;
    }

    @Override // defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.i(R.drawable.hamberger_white_icon);
        return aVar.h(R.drawable.mixradio_nav_logo2x).a(q().getColor(R.color.nokia_pink)).c();
    }

    public void am() {
        if (this.d != null) {
            axz.a = this.c;
            this.d.setSelected(axz.a);
        }
    }
}
