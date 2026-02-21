package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class ayl extends ayi {
    private View f;

    @Override // defpackage.ayi
    boolean al() {
        return false;
    }

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(R.layout.mixradio_ftu_layout, (ViewGroup) null);
        ((Button) this.f.findViewById(R.id.mixradio_ftu_not_now_button)).setOnClickListener(new ahl(this) { // from class: ayl.1
            @Override // defpackage.ahl
            public void a(View view) {
                ayl.this.ae.T();
            }
        });
        ((Button) this.f.findViewById(R.id.mixradio_ftu_ok_button)).setOnClickListener(new ahl(this) { // from class: ayl.2
            @Override // defpackage.ahl
            public void a(View view) {
                ayl.this.ae.p().a(0);
            }
        });
        return this.f;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }
}
