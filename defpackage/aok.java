package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Parcelable;
import com.harman.hkconnect.R;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
public class aok {
    private Context m;
    private Dialog o;
    private final String a = "wifi_watchdog_poor_network_test_enabled";
    private final String b = "wifi_watchdog_on";
    private final String c = "android.net.wifi.WifiWatchdogStateMachine";
    private final String d = "DEFAULT_POOR_NETWORK_AVOIDANCE_ENABLED";
    private final int e = -1;
    private final int f = 1;
    private final int g = Build.VERSION.SDK_INT;
    private final int h = 17;
    private final int i = 15;
    private final String j = "samsung";
    private final String k = "HTC";
    private final String l = Build.MANUFACTURER;
    private BroadcastReceiver n = new BroadcastReceiver() { // from class: aok.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                aok.this.a((NetworkInfo) parcelableExtra);
            }
        }
    };

    public aok(Context context) {
        this.m = context;
        c();
    }

    private void c() {
        this.o = new arw.a(this.m).a(this.m.getResources().getString(R.string.Smart_Switch_Warning_Str)).a(this.m.getResources().getString(R.string.Open_Wifi_Settings_Str), new DialogInterface.OnClickListener() { // from class: aok.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                aok.this.m.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }
        }).b("Cancel", new DialogInterface.OnClickListener() { // from class: aok.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).d(false).b(false).a(false).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkInfo networkInfo) {
        this.o.hide();
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        new ahm((Activity) this.m, this.n).b(intentFilter);
    }

    public void b() {
        try {
            this.m.unregisterReceiver(this.n);
        } catch (RuntimeException e) {
        }
    }
}
