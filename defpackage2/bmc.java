package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class bmc {
    public String a(Context context) {
        String strC = c(context);
        if (TextUtils.isEmpty(strC)) {
            strC = d(context);
        }
        if (TextUtils.isEmpty(strC)) {
            strC = b(context);
        }
        if (TextUtils.isEmpty(strC)) {
            e(context);
        }
        return strC;
    }

    protected String b(Context context) {
        return new bmk().a(context);
    }

    protected String c(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    blh.h().a("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str == null) {
                    blh.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    return bundle.getString("com.crashlytics.ApiKey");
                }
                return str;
            } catch (Exception e) {
                str = string;
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        blh.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        return str;
    }

    protected String d(Context context) {
        int iA = bme.a(context, "io.fabric.ApiKey", "string");
        if (iA == 0) {
            blh.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            iA = bme.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (iA == 0) {
            return null;
        }
        return context.getResources().getString(iA);
    }

    protected void e(Context context) {
        if (blh.i() || bme.i(context)) {
            throw new IllegalArgumentException(a());
        }
        blh.h().e("Fabric", a());
    }

    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
