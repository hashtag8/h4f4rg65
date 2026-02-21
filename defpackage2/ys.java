package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wc;
import defpackage.yp;
import defpackage.yq;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class ys extends wc<yq> {
    private static final ys a = new ys();

    static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private ys() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static yp a(Activity activity) {
        yp ypVarC;
        try {
            if (b(activity)) {
                su.a("Using AdOverlay from the client jar.");
                ypVarC = new sh(activity);
            } else {
                ypVarC = a.c(activity);
            }
            return ypVarC;
        } catch (a e) {
            su.e(e.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    private yp c(Activity activity) {
        try {
            return yp.a.a(a((Context) activity).a(wb.a(activity)));
        } catch (RemoteException e) {
            su.c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (wc.a e2) {
            su.c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.wc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public yq b(IBinder iBinder) {
        return yq.a.a(iBinder);
    }
}
