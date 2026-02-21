package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class ahh {
    private static boolean a = true;

    public static boolean a(Context context) {
        NetworkInfo.State state = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState();
        mm.b("checkForWifi wifi state " + state, new Object[0]);
        return state == NetworkInfo.State.CONNECTED;
    }

    public static boolean b(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static void c(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        System.out.println("Build.MODEL.toUpperCase() = " + Build.MODEL.toUpperCase());
        if (a()) {
            context.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else {
            wifiManager.setWifiEnabled(true);
        }
    }

    public static String d(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static boolean a() {
        for (String str : ain.V) {
            if (Build.MODEL.toUpperCase().contains(str)) {
                return true;
            }
        }
        return false;
    }
}
