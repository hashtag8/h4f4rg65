package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public class uv extends ud {
    private boolean a;
    private boolean b;
    private AlarmManager c;

    protected uv(uf ufVar) {
        super(ufVar);
        this.c = (AlarmManager) o().getSystemService("alarm");
    }

    private PendingIntent f() {
        Intent intent = new Intent(o(), (Class<?>) td.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(o(), 0, intent, 0);
    }

    @Override // defpackage.ud
    protected void a() {
        ActivityInfo receiverInfo;
        try {
            this.c.cancel(f());
            if (q().j() <= 0 || (receiverInfo = o().getPackageManager().getReceiverInfo(new ComponentName(o(), (Class<?>) td.class), 2)) == null || !receiverInfo.enabled) {
                return;
            }
            b("Receiver registered. Using alarm for local dispatch.");
            this.a = true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public void d() {
        D();
        vq.a(b(), "Receiver not registered");
        long j = q().j();
        if (j > 0) {
            e();
            long jB = n().b() + j;
            this.b = true;
            this.c.setInexactRepeating(2, jB, 0L, f());
        }
    }

    public void e() {
        D();
        this.b = false;
        this.c.cancel(f());
    }
}
