package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yd {
    private final zp a;
    private final boolean b;
    private final String c;

    public yd(zp zpVar, Map<String, String> map) {
        this.a = zpVar;
        this.c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.b = true;
        }
    }

    public void a() {
        if (this.a == null) {
            su.e("AdWebView is null");
        } else {
            this.a.setRequestedOrientation("portrait".equalsIgnoreCase(this.c) ? sy.e().b() : "landscape".equalsIgnoreCase(this.c) ? sy.e().a() : this.b ? -1 : sy.e().c());
        }
    }
}
