package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ahm {
    private Activity a;
    private BroadcastReceiver b;
    private are c;
    private boolean d = false;

    public ahm(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.a = activity;
        this.b = broadcastReceiver;
    }

    public void a(IntentFilter intentFilter) {
        if (this.b != null) {
            c(intentFilter);
            this.c = new are(this.a) { // from class: ahm.1
                @Override // defpackage.are
                public void a() {
                    ahm.this.a();
                }
            };
            HarmanApplication.a().registerActivityLifecycleCallbacks(this.c);
        }
    }

    public void b(final IntentFilter intentFilter) {
        if (this.b != null) {
            c(intentFilter);
            this.c = new are(this.a) { // from class: ahm.2
                @Override // defpackage.are
                public void b() {
                    if (ahm.this.b != null) {
                        ahm.this.c(intentFilter);
                    }
                }

                @Override // defpackage.are
                public void c() {
                    try {
                        ahm.this.c();
                    } catch (RuntimeException e) {
                    }
                }

                @Override // defpackage.are
                public void a() {
                    ahm.this.a();
                }
            };
            HarmanApplication.a().registerActivityLifecycleCallbacks(this.c);
        }
    }

    public void a() {
        try {
            c();
        } catch (RuntimeException e) {
        }
        HarmanApplication.a().unregisterActivityLifecycleCallbacks(this.c);
        this.b = null;
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void c() {
        if (b()) {
            this.a.unregisterReceiver(this.b);
            a(false);
        }
    }

    public void c(IntentFilter intentFilter) {
        if (!b()) {
            this.a.registerReceiver(this.b, intentFilter);
            a(true);
        }
    }
}
