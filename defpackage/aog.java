package defpackage;

import android.content.Context;
import android.os.Build;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class aog {
    public static Context a = HarmanApplication.a();

    public static String a() {
        try {
            return a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        for (adx adxVar : aof.a().f()) {
            sb.append(adxVar.w() + " ");
            sb.append(adxVar.x() + ", ");
            sb.append("v" + ahv.a(adxVar.n()) + ", ");
            if (adxVar.ac() == 1) {
                sb.append("RSSI " + ((int) adxVar.f()) + "dB,");
                sb.append(a(adxVar.g()));
            } else if (adxVar.ac() == 2) {
                sb.append("Ethernet Connected.");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String c() {
        return ahh.d(a);
    }

    public static String d() {
        List<adx> listF = aof.a().f();
        if (listF.size() <= 0) {
            return "";
        }
        short sG = listF.get(0).g();
        return a(sG) + "(" + ((int) sG) + ")";
    }

    public static String a(short s) {
        return (s < 1 || s > 14) ? "5GHz" : "2.4GHz";
    }

    public static String e() {
        return Build.MODEL;
    }

    public static String f() {
        return Build.VERSION.RELEASE + ", " + System.getProperty("os.version");
    }

    public static String g() {
        return a.getString(R.string.kSettings_FeedbackContent) + "Device: " + e() + "\nOS: Android" + f() + "\nApp Version: " + a() + "\nRouter MAC Address: " + c() + "\nRouter Channel: " + d() + "\nSpeakers:\n" + b();
    }

    public static String h() {
        String str = ajx.a.get(Locale.getDefault().getCountry());
        if (str == null || str.equals("")) {
            str = "Default";
        }
        String str2 = ajy.a.get(str);
        if (str2 == null || str2.equals("")) {
            return ajy.a.get("Default");
        }
        return str2;
    }
}
