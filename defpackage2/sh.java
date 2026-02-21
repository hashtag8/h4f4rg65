package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import defpackage.yp;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sh extends yp.a implements ServiceConnection {
    sj a;
    private final Activity b;
    private Context c;
    private yn d;
    private sg e;
    private si f;
    private sl g;
    private sm h;
    private String i = null;

    public sh(Activity activity) {
        this.b = activity;
        this.a = sj.a(this.b.getApplicationContext());
    }

    @Override // defpackage.yp
    public void a() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelA = GInAppPurchaseManagerInfoParcel.a(this.b.getIntent());
        this.g = gInAppPurchaseManagerInfoParcelA.e;
        this.h = gInAppPurchaseManagerInfoParcelA.b;
        this.d = gInAppPurchaseManagerInfoParcelA.c;
        this.e = new sg(this.b.getApplicationContext());
        this.c = gInAppPurchaseManagerInfoParcelA.d;
        if (this.b.getResources().getConfiguration().orientation == 2) {
            this.b.setRequestedOrientation(sy.e().a());
        } else {
            this.b.setRequestedOrientation(sy.e().b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.b.bindService(intent, this, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: RemoteException -> 0x003f, all -> 0x004d, Merged into TryCatch #1 {all -> 0x004d, RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:12:0x0021, B:15:0x0037, B:18:0x0040), top: B:23:0x0006 }, TRY_ENTER, TRY_LEAVE] */
    @Override // defpackage.yp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r4 = 0
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r6 != r0) goto L36
            r0 = 0
            sk r1 = defpackage.sy.j()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            int r1 = r1.a(r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2 = -1
            if (r7 != r2) goto L37
            defpackage.sy.j()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            if (r1 != 0) goto L37
            sm r2 = r5.h     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            java.lang.String r3 = r5.i     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            boolean r2 = r2.a(r3, r7, r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            if (r2 == 0) goto L21
            r0 = 1
        L21:
            yn r2 = r5.d     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2.b(r1)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            android.app.Activity r1 = r5.b     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r1.finish()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            yn r1 = r5.d     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            java.lang.String r1 = r1.a()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r5.a(r1, r0, r7, r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r5.i = r4
        L36:
            return
        L37:
            sj r2 = r5.a     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            si r3 = r5.f     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2.a(r3)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            goto L21
        L3f:
            r0 = move-exception
            java.lang.String r0 = "Fail to process purchase result."
            defpackage.su.e(r0)     // Catch: java.lang.Throwable -> L4d
            android.app.Activity r0 = r5.b     // Catch: java.lang.Throwable -> L4d
            r0.finish()     // Catch: java.lang.Throwable -> L4d
            r5.i = r4
            goto L36
        L4d:
            r0 = move-exception
            r5.i = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh.a(int, int, android.content.Intent):void");
    }

    protected void a(String str, boolean z, int i, Intent intent) {
        if (this.g != null) {
            this.g.a(str, z, i, intent, this.f);
        }
    }

    @Override // defpackage.yp
    public void b() {
        this.b.unbindService(this);
        this.e.a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.e.a(iBinder);
        try {
            this.i = this.h.a();
            Bundle bundleA = this.e.a(this.b.getPackageName(), this.d.a(), this.i);
            PendingIntent pendingIntent = (PendingIntent) bundleA.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int iA = sy.j().a(bundleA);
                this.d.b(iA);
                a(this.d.a(), false, iA, null);
                this.b.finish();
            } else {
                this.f = new si(this.d.a(), this.i);
                this.a.b(this.f);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            su.c("Error when connecting in-app billing service", e);
            this.b.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        su.c("In-app billing service disconnected.");
        this.e.a();
    }
}
