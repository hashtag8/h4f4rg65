package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ars extends BroadcastReceiver {
    private DashboardActivity a;

    public ars(Context context) {
        this.a = (DashboardActivity) context;
    }

    public void a(Activity activity) {
        HarmanApplication.a().registerActivityLifecycleCallbacks(new are(activity) { // from class: ars.1
            @Override // defpackage.are
            public void b() {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("START_SHAKE_ANIMATION");
                ars.this.a.registerReceiver(ars.this, intentFilter);
            }

            @Override // defpackage.are
            public void c() {
                try {
                    ars.this.a.unregisterReceiver(ars.this);
                } catch (Exception e) {
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a((Runnable) null);
    }
}
