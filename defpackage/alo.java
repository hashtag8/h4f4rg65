package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class alo extends ale {
    private View a;
    private TextView b = null;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.fragment_deezer_settings_about, (ViewGroup) null);
        this.b = (TextView) this.a.findViewById(R.id.settings_about_version);
        this.b.setText("0.9.3");
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.a;
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(-13487558).a(q().getString(R.string.kDeezerNav_Settings_Str)).c();
    }
}
