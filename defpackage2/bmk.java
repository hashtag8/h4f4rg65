package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class bmk {
    protected String a(Context context) {
        int iA = bme.a(context, "google_app_id", "string");
        if (iA == 0) {
            return null;
        }
        blh.h().a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(iA));
    }

    protected String a(String str) {
        return bme.b(str).substring(0, 40);
    }

    public boolean b(Context context) {
        if (bme.a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        return (bme.a(context, "google_app_id", "string") != 0) && !(!TextUtils.isEmpty(new bmc().c(context)) || !TextUtils.isEmpty(new bmc().d(context)));
    }
}
