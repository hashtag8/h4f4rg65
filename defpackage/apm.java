package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class apm extends aoj {
    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_setup_multichannel_5g_error, viewGroup, false);
    }

    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        String strA;
        super.a(view, bundle);
        if (view != null) {
            byte bE = an().n() != null ? an().n().e() : (byte) 5;
            TextView textView = (TextView) view.findViewById(R.id.introduction2);
            if (bE == 5 || bE == 2) {
                strA = a(R.string.SetupRequire5GDescription_Str);
            } else {
                strA = a(R.string.SetupRequire5GDescriptionBar_Str);
            }
            textView.setText(strA);
        }
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(true);
        an().c(a(R.string.kSetupRoomManagement_Setup_MultiChannel_Str));
        an().c(false);
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.SETUP_MULTICHANNEL_5G_ISSUE;
    }
}
