package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class boq extends blw implements bpc {
    public boq(bln blnVar, String str, String str2, bnw bnwVar) {
        this(blnVar, str, str2, bnwVar, bnu.GET);
    }

    boq(bln blnVar, String str, String str2, bnw bnwVar, bnu bnuVar) {
        super(blnVar, str, str2, bnwVar, bnuVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a9  */
    @Override // defpackage.bpc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(defpackage.bpb r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.boq.a(bpb):org.json.JSONObject");
    }

    JSONObject a(bnv bnvVar) {
        int iB = bnvVar.b();
        blh.h().a("Fabric", "Settings result was: " + iB);
        if (a(iB)) {
            return a(bnvVar.e());
        }
        blh.h().e("Fabric", "Failed to retrieve settings from " + a());
        return null;
    }

    boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            blh.h().a("Fabric", "Failed to parse settings JSON from " + a(), e);
            blh.h().a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> b(bpb bpbVar) {
        HashMap map = new HashMap();
        map.put("build_version", bpbVar.j);
        map.put("display_version", bpbVar.i);
        map.put("source", Integer.toString(bpbVar.k));
        if (bpbVar.l != null) {
            map.put("icon_hash", bpbVar.l);
        }
        String str = bpbVar.h;
        if (!bme.d(str)) {
            map.put("instance", str);
        }
        return map;
    }

    private bnv a(bnv bnvVar, bpb bpbVar) {
        a(bnvVar, "X-CRASHLYTICS-API-KEY", bpbVar.a);
        a(bnvVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(bnvVar, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        a(bnvVar, "Accept", "application/json");
        a(bnvVar, "X-CRASHLYTICS-DEVICE-MODEL", bpbVar.b);
        a(bnvVar, "X-CRASHLYTICS-OS-BUILD-VERSION", bpbVar.c);
        a(bnvVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", bpbVar.d);
        a(bnvVar, "X-CRASHLYTICS-INSTALLATION-ID", bpbVar.f);
        if (TextUtils.isEmpty(bpbVar.e)) {
            a(bnvVar, "X-CRASHLYTICS-ANDROID-ID", bpbVar.g);
        } else {
            a(bnvVar, "X-CRASHLYTICS-ADVERTISING-TOKEN", bpbVar.e);
        }
        return bnvVar;
    }

    private void a(bnv bnvVar, String str, String str2) {
        if (str2 != null) {
            bnvVar.a(str, str2);
        }
    }
}
