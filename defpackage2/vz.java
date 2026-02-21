package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import defpackage.vy;

/* JADX INFO: loaded from: classes.dex */
public class vz {
    private static final vz a = new vz();

    private vz() {
    }

    public static vz a() {
        return a;
    }

    private boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        vy.ab abVar = new vy.ab(packageInfo.signatures[0].toByteArray());
        if ((z ? vy.a() : vy.b()).contains(abVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.a(), 0));
        }
        return false;
    }

    public vy.a a(PackageInfo packageInfo, vy.a... aVarArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        vy.ab abVar = new vy.ab(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i].equals(abVar)) {
                return aVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.a(), 0));
        }
        return null;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtil.zzc(packageManager)) {
            return a(packageInfo, true);
        }
        boolean zA = a(packageInfo, false);
        if (zA || !a(packageInfo, true)) {
            return zA;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zA;
    }

    public boolean a(PackageManager packageManager, String str) {
        try {
            return a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }
}
