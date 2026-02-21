package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class atg extends atm {
    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_fota_updated_by_someone, (ViewGroup) null);
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        e().d(true);
    }
}
