package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xp implements xl {
    static final Map<String, Integer> a = new HashMap();
    private final sw b;
    private final yc c;

    static {
        a.put("resize", 1);
        a.put("playVideo", 2);
        a.put("storePicture", 3);
        a.put("createCalendarEvent", 4);
        a.put("setOrientationProperties", 5);
        a.put("closeResizedAd", 6);
    }

    public xp(sw swVar, yc ycVar) {
        this.b = swVar;
        this.c = ycVar;
    }

    @Override // defpackage.xl
    public void a(zp zpVar, Map<String, String> map) {
        int iIntValue = a.get(map.get("a")).intValue();
        if (iIntValue != 5 && this.b != null && !this.b.a()) {
            this.b.a(null);
        }
        switch (iIntValue) {
            case 1:
                this.c.a(map);
                break;
            case 2:
            default:
                su.c("Unknown MRAID command called.");
                break;
            case 3:
                new ye(zpVar, map).a();
                break;
            case 4:
                new yb(zpVar, map).a();
                break;
            case 5:
                new yd(zpVar, map).a();
                break;
            case 6:
                this.c.a(true);
                break;
        }
    }
}
