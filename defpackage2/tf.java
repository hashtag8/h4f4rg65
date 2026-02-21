package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class tf extends BroadcastReceiver {
    static Object a = new Object();
    static PowerManager.WakeLock b;
    static Boolean c;

    public static boolean a(Context context) {
        vq.a(context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean zA = tz.a(context, (Class<? extends BroadcastReceiver>) tf.class, true);
        c = Boolean.valueOf(zA);
        return zA;
    }

    protected Class<? extends tg> a() {
        return tg.class;
    }

    protected void a(String str) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        uf ufVarA = uf.a(context);
        tu tuVarF = ufVarA.f();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        tuVarF.a("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            tuVarF.e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean zA = tg.a(context);
        if (!zA) {
            tuVarF.e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        a(stringExtra);
        if (ufVarA.e().a()) {
            tuVarF.f("Received unexpected installation campaign on package side");
            return;
        }
        Class<? extends tg> clsA = a();
        vq.a(clsA);
        Intent intent2 = new Intent(context, clsA);
        intent2.putExtra("referrer", stringExtra);
        synchronized (a) {
            context.startService(intent2);
            if (zA) {
                try {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (b == null) {
                        b = powerManager.newWakeLock(1, "Analytics campaign WakeLock");
                        b.setReferenceCounted(false);
                    }
                    b.acquire(1000L);
                } catch (SecurityException e) {
                    tuVarF.e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
            }
        }
    }
}
