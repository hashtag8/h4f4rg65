package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;

/* JADX INFO: loaded from: classes.dex */
public class asl extends BroadcastReceiver {
    private final ash a;

    public asl(ash ashVar) {
        this.a = ashVar;
    }

    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        WifiInfo wifiInfo = null;
        mm.b("second onNetworkChange %s %s", networkInfo, null);
        if (networkInfo.isConnected()) {
            wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
        }
        mm.b("third onNetworkChange %s %s", networkInfo, wifiInfo);
        this.a.a(networkInfo, wifiInfo);
    }
}
