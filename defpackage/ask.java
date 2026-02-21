package defpackage;

import android.app.Activity;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ask {
    private static NetworkInfo.State f = NetworkInfo.State.UNKNOWN;
    private final Activity a;
    private final ahm b;
    private final asl c;
    private final are d;
    private String e;

    public ask(Activity activity, final asj asjVar) {
        this.a = activity;
        this.c = new asl(new ash() { // from class: ask.1
            @Override // defpackage.ash
            public void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
                mm.b("checkForWifi--1 Notifying WiFi change from %s to %s, lastWifiState %d, currWifiState %d", ask.this.e, wifiInfo, ask.f, networkInfo.getState());
                String ssid = null;
                if (wifiInfo != null && networkInfo.isConnected()) {
                    ssid = wifiInfo.getSSID();
                }
                if (ahx.a(ask.this.e, ssid)) {
                    if (ask.f == NetworkInfo.State.CONNECTING && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        mm.b("checkForWifi--3 Notifying WiFi change from %s to %s", ask.this.e, wifiInfo);
                        asjVar.a(ssid);
                    }
                } else {
                    mm.b("checkForWifi--2 Notifying WiFi change from %s to %s", ask.this.e, wifiInfo);
                    asjVar.a(ssid);
                }
                NetworkInfo.State unused = ask.f = networkInfo.getState();
            }
        });
        this.b = new ahm(activity, this.c);
        this.d = new are(activity) { // from class: ask.2
            @Override // defpackage.are
            public void c() {
                ask.this.e = ask.this.d();
            }

            @Override // defpackage.are
            public void b() {
                String strD = ask.this.d();
                if (!ahx.a(ask.this.e, strD)) {
                    mm.b("Notifying WiFi change from %s to %s", ask.this.e, strD);
                    asjVar.a(strD);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        if (ahh.a(this.a)) {
            return ahx.a().b();
        }
        return null;
    }

    public void a() {
        this.b.b(this.c.a());
        this.e = d();
        HarmanApplication.a().registerActivityLifecycleCallbacks(this.d);
    }

    public void b() {
        this.b.a();
        HarmanApplication.a().unregisterActivityLifecycleCallbacks(this.d);
    }
}
