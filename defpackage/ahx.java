package defpackage;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ahx {
    private static ahx c;
    private WifiManager a;
    private WifiInfo b;

    private ahx(Context context) {
        this.a = (WifiManager) context.getSystemService("wifi");
    }

    public static ahx a() {
        if (c == null) {
            c = new ahx(HarmanApplication.a());
        }
        return c;
    }

    public String b() {
        try {
            this.b = this.a.getConnectionInfo();
            if (this.b != null && this.b.getSSID() != null) {
                String ssid = this.b.getSSID();
                if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                    return ssid.substring(1, ssid.length() - 1);
                }
                return ssid;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    public int c() {
        this.b = this.a.getConnectionInfo();
        if (this.b != null) {
            return this.b.getRssi();
        }
        return -1;
    }

    public static boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.replace("\"", "").equalsIgnoreCase(str2.replace("\"", ""));
    }
}
