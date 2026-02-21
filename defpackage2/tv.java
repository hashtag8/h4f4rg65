package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class tv extends BroadcastReceiver {
    static final String a = tv.class.getName();
    private final uf b;
    private boolean c;
    private boolean d;

    tv(uf ufVar) {
        vq.a(ufVar);
        this.b = ufVar;
    }

    private void g() {
        i();
        j();
    }

    private Context h() {
        return this.b.b();
    }

    private tu i() {
        return this.b.f();
    }

    private ub j() {
        return this.b.i();
    }

    public void a() {
        g();
        if (this.c) {
            return;
        }
        Context contextH = h();
        contextH.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(contextH.getPackageName());
        contextH.registerReceiver(this, intentFilter);
        this.d = f();
        this.b.f().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
        this.c = true;
    }

    public void b() {
        if (d()) {
            this.b.f().b("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                h().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                i().e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void c() {
        if (Build.VERSION.SDK_INT <= 10) {
            return;
        }
        Context contextH = h();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(contextH.getPackageName());
        intent.putExtra(a, true);
        contextH.sendOrderedBroadcast(intent, null);
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        if (!this.c) {
            this.b.f().e("Connectivity unknown. Receiver not registered");
        }
        return this.d;
    }

    protected boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) h().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        g();
        String action = intent.getAction();
        this.b.f().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zF = f();
            if (this.d != zF) {
                this.d = zF;
                j().a(zF);
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.b.f().d("NetworkBroadcastReceiver received unknown action", action);
        } else {
            if (intent.hasExtra(a)) {
                return;
            }
            j().e();
        }
    }
}
