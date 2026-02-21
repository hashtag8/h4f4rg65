package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aps extends aoj {
    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().e(true);
        an().f(true);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_source_setup_explanation, viewGroup, false);
    }
}
