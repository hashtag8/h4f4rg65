package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wc;
import defpackage.yk;
import defpackage.yl;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class yj extends wc<yl> {
    private static final yj a = new yj();

    static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private yj() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static yk a(Activity activity) {
        yk ykVarC;
        try {
            if (b(activity)) {
                su.a("Using AdOverlay from the client jar.");
                ykVarC = new ru(activity);
            } else {
                ykVarC = a.c(activity);
            }
            return ykVarC;
        } catch (a e) {
            su.e(e.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private yk c(Activity activity) {
        try {
            return yk.a.a(a((Context) activity).a(wb.a(activity)));
        } catch (RemoteException e) {
            su.c("Could not create remote AdOverlay.", e);
            return null;
        } catch (wc.a e2) {
            su.c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.wc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public yl b(IBinder iBinder) {
        return yl.a.a(iBinder);
    }
}
