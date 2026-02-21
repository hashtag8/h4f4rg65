package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sg {
    Object a;
    private final Context b;

    public sg(Context context) {
        this.b = context;
    }

    public Bundle a(String str, String str2, String str3) {
        try {
            Class<?> clsLoadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) clsLoadClass.getDeclaredMethod("getBuyIntent", Integer.TYPE, String.class, String.class, String.class, String.class).invoke(clsLoadClass.cast(this.a), 3, str, str2, "inapp", str3);
        } catch (Exception e) {
            su.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public void a() {
        this.a = null;
    }

    public void a(IBinder iBinder) {
        try {
            this.a = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
        } catch (Exception e) {
            su.e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}
