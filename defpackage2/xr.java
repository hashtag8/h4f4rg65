package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class xr implements xl {
    private final Map<zp, Integer> a = new WeakHashMap();

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return rj.a().a(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            su.e("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    @Override // defpackage.xl
    public void a(zp zpVar, Map<String, String> map) {
        rz rzVarB;
        String str = map.get("action");
        if (str == null) {
            su.e("Action missing from video GMSG.");
            return;
        }
        if (su.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            su.a("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                su.e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int color = Color.parseColor(str2);
                ru ruVarE = zpVar.e();
                if (ruVarE == null || (rzVarB = ruVarE.b()) == null) {
                    this.a.put(zpVar, Integer.valueOf(color));
                } else {
                    rzVarB.setBackgroundColor(color);
                }
                return;
            } catch (IllegalArgumentException e) {
                su.e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        ru ruVarE2 = zpVar.e();
        if (ruVarE2 == null) {
            su.e("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean zEquals = "new".equals(str);
        boolean zEquals2 = "position".equals(str);
        if (zEquals || zEquals2) {
            Context context = zpVar.getContext();
            int iA = a(context, map, "x", 0);
            int iA2 = a(context, map, "y", 0);
            int iA3 = a(context, map, "w", -1);
            int iA4 = a(context, map, "h", -1);
            if (!zEquals || ruVarE2.b() != null) {
                ruVarE2.a(iA, iA2, iA3, iA4);
                return;
            }
            ruVarE2.b(iA, iA2, iA3, iA4);
            if (this.a.containsKey(zpVar)) {
                ruVarE2.b().setBackgroundColor(this.a.get(zpVar).intValue());
                return;
            }
            return;
        }
        rz rzVarB2 = ruVarE2.b();
        if (rzVarB2 == null) {
            rz.a(zpVar);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zpVar.getContext();
            int iA5 = a(context2, map, "x", 0);
            int iA6 = a(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iA5, iA6, 0);
            rzVarB2.a(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str3 = map.get("time");
            if (str3 == null) {
                su.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                rzVarB2.a((int) (Float.parseFloat(str3) * 1000.0f));
                return;
            } catch (NumberFormatException e2) {
                su.e("Could not parse time parameter from currentTime video GMSG: " + str3);
                return;
            }
        }
        if ("hide".equals(str)) {
            rzVarB2.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            rzVarB2.f();
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean(map.get("muted"))) {
                rzVarB2.i();
                return;
            } else {
                rzVarB2.j();
                return;
            }
        }
        if ("pause".equals(str)) {
            rzVarB2.g();
            return;
        }
        if ("play".equals(str)) {
            rzVarB2.h();
            return;
        }
        if ("show".equals(str)) {
            rzVarB2.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            rzVarB2.a(map.get("src"));
            return;
        }
        if (!"volume".equals(str)) {
            if ("watermark".equals(str)) {
                rzVarB2.k();
                return;
            } else {
                su.e("Unknown video action: " + str);
                return;
            }
        }
        String str4 = map.get("volume");
        if (str4 == null) {
            su.e("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            rzVarB2.a(Float.parseFloat(str4));
        } catch (NumberFormatException e3) {
            su.e("Could not parse volume parameter from volume video GMSG: " + str4);
        }
    }
}
