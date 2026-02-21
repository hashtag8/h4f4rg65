package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public final class td extends BroadcastReceiver {
    static Object a = new Object();
    static PowerManager.WakeLock b;
    static Boolean c;

    public static boolean a(Context context) {
        vq.a(context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean zA = tz.a(context, (Class<? extends BroadcastReceiver>) td.class, false);
        c = Boolean.valueOf(zA);
        return zA;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        uf ufVarA = uf.a(context);
        tu tuVarF = ufVarA.f();
        String action = intent.getAction();
        if (ufVarA.e().a()) {
            tuVarF.a("Device AnalyticsReceiver got", action);
        } else {
            tuVarF.a("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zA = te.a(context);
            Intent intent2 = new Intent(context, (Class<?>) te.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (a) {
                context.startService(intent2);
                if (zA) {
                    try {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (b == null) {
                            b = powerManager.newWakeLock(1, "Analytics WakeLock");
                            b.setReferenceCounted(false);
                        }
                        b.acquire(1000L);
                    } catch (SecurityException e) {
                        tuVarF.e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
