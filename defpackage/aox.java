package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aox extends aoj {
    private RelativeLayout a;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_ban_24g, viewGroup, false);
        TextView textView = (TextView) this.a.findViewById(R.id.introduce1);
        TextView textView2 = (TextView) this.a.findViewById(R.id.introduce2);
        if (l().getString("DEVICE_TYPE").equals(aoi.ADAPT_BAN_2_4G.toString())) {
            String str = String.format(q().getString(R.string.kRoomSetupTutorialWrongPswDescription24G_Str), a(R.string.kSetupNewRoom_Channel4Btn_Str));
            textView.setText(String.format(q().getString(R.string.kRoomSetupTutorialFailToJoinWifiTitle24G_Str), a(R.string.kSetupNewRoom_Channel4Btn_Str)));
            textView2.setText(str);
        } else {
            String str2 = String.format(q().getString(R.string.kRoomSetupTutorialWrongPswDescription24G_Str), a(R.string.kSetupNewRoom_Channel3Btn_Str));
            textView.setText(String.format(q().getString(R.string.kRoomSetupTutorialFailToJoinWifiTitle24G_Str), a(R.string.kSetupNewRoom_Channel3Btn_Str)));
            textView2.setText(str2);
        }
        return this.a;
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(true);
        an().c(a(R.string.kSetupWifiTitle_Str));
        an().c(true);
        an().b(a(R.string.Retry_Str));
    }

    @Override // defpackage.aoj
    public void e() {
        an().a(aoi.RETRY_WIFI_SETUP, (Bundle) null);
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.ADAPT_CONNECT_WIFI;
    }
}
