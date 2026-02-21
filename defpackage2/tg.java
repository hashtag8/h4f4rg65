package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class tg extends Service {
    private static Boolean b;
    private Handler a;

    private void a() {
        try {
            synchronized (tf.a) {
                PowerManager.WakeLock wakeLock = tf.b;
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
        boolean zA = tz.a(context, (Class<? extends Service>) tg.class);
        b = Boolean.valueOf(zA);
        return zA;
    }

    private Handler b() {
        Handler handler = this.a;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.a = handler2;
        return handler2;
    }

    protected void a(final tu tuVar, Handler handler, final int i) {
        handler.post(new Runnable() { // from class: tg.3
            @Override // java.lang.Runnable
            public void run() {
                boolean zStopSelfResult = tg.this.stopSelfResult(i);
                if (zStopSelfResult) {
                    tuVar.a("Install campaign broadcast processed", Boolean.valueOf(zStopSelfResult));
                }
            }
        });
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        uf.a(this).f().b("CampaignTrackingService is starting up");
    }

    @Override // android.app.Service
    public void onDestroy() {
        uf.a(this).f().b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        a();
        uf ufVarA = uf.a(this);
        final tu tuVarF = ufVarA.f();
        String stringExtra = null;
        if (ufVarA.e().a()) {
            tuVarF.f("Unexpected installation campaign (package side)");
        } else {
            stringExtra = intent.getStringExtra("referrer");
        }
        final Handler handlerB = b();
        if (TextUtils.isEmpty(stringExtra)) {
            if (!ufVarA.e().a()) {
                tuVarF.e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            ufVarA.h().a(new Runnable() { // from class: tg.1
                @Override // java.lang.Runnable
                public void run() {
                    tg.this.a(tuVarF, handlerB, i2);
                }
            });
        } else {
            int iE = ufVarA.e().e();
            if (stringExtra.length() > iE) {
                tuVarF.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(iE));
                stringExtra = stringExtra.substring(0, iE);
            }
            tuVarF.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), stringExtra);
            ufVarA.i().a(stringExtra, new Runnable() { // from class: tg.2
                @Override // java.lang.Runnable
                public void run() {
                    tg.this.a(tuVarF, handlerB, i2);
                }
            });
        }
        return 2;
    }
}
