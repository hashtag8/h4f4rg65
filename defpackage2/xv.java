package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xv implements xl {
    @Override // defpackage.xl
    public void a(zp zpVar, Map<String, String> map) {
        xt xtVarK = sy.k();
        if (map.containsKey("abort")) {
            if (xtVarK.a(zpVar)) {
                return;
            }
            su.e("Precache abort but no preload task running.");
            return;
        }
        String str = map.get("src");
        if (str == null) {
            su.e("Precache video action is missing the src parameter.");
        } else if (xtVarK.b(zpVar)) {
            su.e("Precache task already running.");
        } else {
            new xs(zpVar, str).b();
        }
    }
}
