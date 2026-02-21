package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class oc extends blw {
    private final oe b;

    static String a(String str) {
        return "3:" + str;
    }

    public oc(bln blnVar, String str, String str2, bnw bnwVar, oe oeVar) {
        super(blnVar, str, str2, bnwVar, bnu.GET);
        this.b = oeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00f5 -> B:27:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00f7 -> B:27:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.od a(java.lang.String r8, java.lang.String r9, defpackage.ob r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oc.a(java.lang.String, java.lang.String, ob):od");
    }

    private bnv a(bnv bnvVar, String str, String str2) {
        return bnvVar.a("Accept", "application/json").a(HTTP.USER_AGENT, "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", str).a("X-CRASHLYTICS-BETA-TOKEN", a(str2));
    }

    private Map<String, String> a(ob obVar) {
        HashMap map = new HashMap();
        map.put("build_version", obVar.a);
        map.put("display_version", obVar.b);
        map.put("instance", obVar.c);
        map.put("source", "3");
        return map;
    }
}
