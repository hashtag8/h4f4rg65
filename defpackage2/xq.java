package defpackage;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class xq implements xl {
    private final xm a;
    private final sw b;
    private final yc c;

    public xq(xm xmVar, sw swVar, yc ycVar) {
        this.a = xmVar;
        this.b = swVar;
        this.c = ycVar;
    }

    private void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return sy.e().b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return sy.e().a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return sy.e().c();
            }
        }
        return -1;
    }

    @Override // defpackage.xl
    public void a(zp zpVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            su.e("Action missing from an open GMSG.");
            return;
        }
        if (this.b != null && !this.b.a()) {
            this.b.a(map.get("u"));
            return;
        }
        zq zqVarH = zpVar.h();
        if ("expand".equalsIgnoreCase(str)) {
            if (zpVar.l()) {
                su.e("Cannot expand WebView that is already expanded.");
                return;
            } else {
                a(false);
                zqVarH.a(a(map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            a(false);
            if (str2 != null) {
                zqVarH.a(a(map), b(map), str2);
                return;
            } else {
                zqVarH.a(a(map), b(map), map.get("html"), map.get("baseurl"));
                return;
            }
        }
        if (!"in_app_purchase".equalsIgnoreCase(str)) {
            a(true);
            zpVar.j();
            String str3 = map.get("u");
            zqVarH.a(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str3) ? sy.c().a(zpVar, str3) : str3, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            return;
        }
        String str4 = map.get("product_id");
        String str5 = map.get("report_urls");
        if (this.a != null) {
            if (str5 == null || str5.isEmpty()) {
                this.a.a(str4, new ArrayList<>());
            } else {
                this.a.a(str4, new ArrayList<>(Arrays.asList(str5.split(" "))));
            }
        }
    }
}
