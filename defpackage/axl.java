package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.juke.TabPageIndicator;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class axl extends axk {
    private View aj;
    private TabPageIndicator ak;
    boolean a = false;
    private int al = 0;
    private int am = 1;
    private int an = 0;
    TabPageIndicator.a b = new TabPageIndicator.a() { // from class: axl.1
        @Override // com.musicservice.juke.TabPageIndicator.a
        public void a(int i) {
            axl.this.d(i);
        }
    };

    @Override // defpackage.axk, android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // defpackage.axk
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = layoutInflater.inflate(R.layout.juke_chart_fragment, (ViewGroup) null);
        this.ak = (TabPageIndicator) this.aj.findViewById(R.id.indicator);
        this.ak.setTitles(new CharSequence[]{this.ae.getString(R.string.JukeTracks), this.ae.getString(R.string.JukeAlbums)});
        this.ak.setOnTabReselectedListener(this.b);
        this.aj.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.aj;
    }

    protected void d(int i) {
        this.a = false;
        switch (i) {
            case 0:
                ap();
                this.an = this.al;
                break;
            case 1:
                ao();
                this.an = this.am;
                break;
            default:
                ap();
                this.an = this.al;
                break;
        }
        this.ak.b(i);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        o(l());
    }

    @Override // defpackage.axk
    void c() {
    }

    private void o(Bundle bundle) {
        if (z()) {
            awp.a = 3;
        }
        if (bundle != null) {
            this.g = bundle.getBoolean("DISCOVER_PARENT", false);
        }
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
        } else if (bundle != null && bundle.getInt("tab") == 1) {
            d(this.am);
            this.a = true;
        } else {
            d(this.an);
        }
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeCharts).c();
    }

    public void ao() {
        axf axfVar = new axf();
        axfVar.g(aq());
        this.ae.q().a(s(), axfVar, (Bundle) null, R.id.fragment_content);
    }

    public void ap() {
        axg axgVar = new axg();
        axgVar.g(aq());
        this.ae.q().a(s(), axgVar, (Bundle) null, R.id.fragment_content);
    }

    private Bundle aq() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("DISCOVER_PARENT", this.g);
        return bundle;
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
    }
}
