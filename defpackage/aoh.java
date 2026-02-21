package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public abstract class aoh extends aoj {
    private a a;

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MK_DEVICES_UPDATED");
        this.a = new a();
        p().registerReceiver(this.a, intentFilter);
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
        if (this.a != null) {
            p().unregisterReceiver(this.a);
        }
        this.a = null;
    }

    class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (aoh.this.p() != null && intent.getAction().equals("ACTION_MK_DEVICES_UPDATED")) {
                aoh.this.am();
            }
        }
    }

    protected void am() {
    }
}
