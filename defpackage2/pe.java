package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class pe {
    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context e;
    private boolean h;
    private final BroadcastReceiver g = new BroadcastReceiver() { // from class: pe.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            pe.this.h = true;
        }
    };
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: pe.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            pe.this.h = false;
        }
    };
    private final AtomicBoolean d = new AtomicBoolean(false);

    public pe(Context context) {
        this.e = context;
    }

    public void a() {
        boolean z = true;
        if (!this.d.getAndSet(true)) {
            Intent intentRegisterReceiver = this.e.registerReceiver(null, a);
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
            if (intExtra != 2 && intExtra != 5) {
                z = false;
            }
            this.h = z;
            this.e.registerReceiver(this.g, b);
            this.e.registerReceiver(this.f, c);
        }
    }

    public boolean b() {
        return this.h;
    }

    public void c() {
        if (this.d.getAndSet(false)) {
            this.e.unregisterReceiver(this.g);
            this.e.unregisterReceiver(this.f);
        }
    }
}
