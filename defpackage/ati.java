package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class ati extends atm {
    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_required_updated_devices, (ViewGroup) null);
        viewInflate.findViewById(R.id.fragment_device_update_now_bt).setOnClickListener(new View.OnClickListener() { // from class: ati.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ati.this.e().k();
            }
        });
        viewInflate.findViewById(R.id.fragment_device_update_later_bt).setOnClickListener(new View.OnClickListener() { // from class: ati.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ati.this.p().finish();
                ain.b = false;
            }
        });
        return viewInflate;
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
    }
}
