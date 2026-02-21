package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@yx
public class rs {
    public boolean a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, sc scVar) {
        int i;
        if (adLauncherIntentInfoParcel == null) {
            su.e("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.c)) {
            su.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.d)) {
            intent.setData(Uri.parse(adLauncherIntentInfoParcel.c));
        } else {
            intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.c), adLauncherIntentInfoParcel.d);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.e)) {
            intent.setPackage(adLauncherIntentInfoParcel.e);
        }
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f)) {
            String[] strArrSplit = adLauncherIntentInfoParcel.f.split("/", 2);
            if (strArrSplit.length < 2) {
                su.e("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f);
                return false;
            }
            intent.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str = adLauncherIntentInfoParcel.g;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                su.e("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        try {
            su.d("Launching an intent: " + intent.toURI());
            context.startActivity(intent);
            if (scVar != null) {
                scVar.a();
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            su.e(e2.getMessage());
            return false;
        }
    }
}
