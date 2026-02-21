package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public final class te extends Service {
    private static Boolean b;
    private final Handler a = new Handler();

    private void a() {
        try {
            synchronized (td.a) {
                PowerManager.WakeLock wakeLock = td.b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean a(Context context) {
        vq.a(context);
        if (b != null) {
            return b.booleanValue();
        }
        boolean zA = tz.a(context, (Class<? extends Service>) te.class);
        b = Boolean.valueOf(zA);
        return zA;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        uf ufVarA = uf.a(this);
        tu tuVarF = ufVarA.f();
        if (ufVarA.e().a()) {
            tuVarF.b("Device AnalyticsService is starting up");
        } else {
            tuVarF.b("Local AnalyticsService is starting up");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        uf ufVarA = uf.a(this);
        tu tuVarF = ufVarA.f();
        if (ufVarA.e().a()) {
            tuVarF.b("Device AnalyticsService is shutting down");
        } else {
            tuVarF.b("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        a();
        final uf ufVarA = uf.a(this);
        final tu tuVarF = ufVarA.f();
        String action = intent.getAction();
        if (ufVarA.e().a()) {
            tuVarF.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            tuVarF.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            ufVarA.i().a(new uw() { // from class: te.1
                @Override // defpackage.uw
                public void a(Throwable th) {
                    te.this.a.post(new Runnable() { // from class: te.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (te.this.stopSelfResult(i2)) {
                                if (ufVarA.e().a()) {
                                    tuVarF.b("Device AnalyticsService processed last dispatch request");
                                } else {
                                    tuVarF.b("Local AnalyticsService processed last dispatch request");
                                }
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
