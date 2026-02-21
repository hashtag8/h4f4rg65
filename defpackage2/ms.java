package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import com.crashlytics.android.CrashlyticsInitProvider;

/* JADX INFO: loaded from: classes.dex */
public class ms implements CrashlyticsInitProvider.a {
    @Override // com.crashlytics.android.CrashlyticsInitProvider.a
    public boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED).metaData;
            if (bundle != null) {
                return bundle.getBoolean("firebase_crashlytics_collection_enabled", true);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return true;
        }
    }
}
