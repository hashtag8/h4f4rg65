package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class vb extends uc implements aaw {
    private static DecimalFormat a;
    private final uf b;
    private final String c;
    private final Uri d;
    private final boolean e;
    private final boolean f;

    public vb(uf ufVar, String str) {
        this(ufVar, str, true, false);
    }

    public vb(uf ufVar, String str, boolean z, boolean z2) {
        super(ufVar);
        vq.a(str);
        this.b = ufVar;
        this.c = str;
        this.e = z;
        this.f = z2;
        this.d = a(this.c);
    }

    static Uri a(String str) {
        vq.a(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String a(double d) {
        if (a == null) {
            a = new DecimalFormat("0.######");
        }
        return a.format(d);
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return a(d.doubleValue());
            }
            return null;
        }
        if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        }
        if (obj != Boolean.FALSE) {
            return "1";
        }
        return null;
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, a(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        map.put(str, i + "x" + i2);
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public static Map<String, String> b(aaq aaqVar) {
        HashMap map = new HashMap();
        zz zzVar = (zz) aaqVar.a(zz.class);
        if (zzVar != null) {
            for (Map.Entry<String, Object> entry : zzVar.a().entrySet()) {
                String strA = a(entry.getValue());
                if (strA != null) {
                    map.put(entry.getKey(), strA);
                }
            }
        }
        aaa aaaVar = (aaa) aaqVar.a(aaa.class);
        if (aaaVar != null) {
            a(map, "t", aaaVar.a());
            a(map, "cid", aaaVar.b());
            a(map, "uid", aaaVar.c());
            a(map, "sc", aaaVar.f());
            a(map, "sf", aaaVar.h());
            a(map, "ni", aaaVar.g());
            a(map, "adid", aaaVar.d());
            a(map, "ate", aaaVar.e());
        }
        abe abeVar = (abe) aaqVar.a(abe.class);
        if (abeVar != null) {
            a(map, "cd", abeVar.b());
            a(map, "a", abeVar.c());
            a(map, "dr", abeVar.d());
        }
        abc abcVar = (abc) aaqVar.a(abc.class);
        if (abcVar != null) {
            a(map, "ec", abcVar.a());
            a(map, "ea", abcVar.b());
            a(map, "el", abcVar.c());
            a(map, "ev", abcVar.d());
        }
        aay aayVar = (aay) aaqVar.a(aay.class);
        if (aayVar != null) {
            a(map, "cn", aayVar.a());
            a(map, "cs", aayVar.b());
            a(map, "cm", aayVar.c());
            a(map, "ck", aayVar.d());
            a(map, "cc", aayVar.e());
            a(map, "ci", aayVar.f());
            a(map, "anid", aayVar.g());
            a(map, "gclid", aayVar.h());
            a(map, "dclid", aayVar.i());
            a(map, "aclid", aayVar.j());
        }
        abd abdVar = (abd) aaqVar.a(abd.class);
        if (abdVar != null) {
            a(map, "exd", abdVar.a());
            a(map, "exf", abdVar.b());
        }
        abf abfVar = (abf) aaqVar.a(abf.class);
        if (abfVar != null) {
            a(map, "sn", abfVar.a());
            a(map, "sa", abfVar.b());
            a(map, "st", abfVar.c());
        }
        abg abgVar = (abg) aaqVar.a(abg.class);
        if (abgVar != null) {
            a(map, "utv", abgVar.a());
            a(map, "utt", abgVar.b());
            a(map, "utc", abgVar.c());
            a(map, "utl", abgVar.d());
        }
        zx zxVar = (zx) aaqVar.a(zx.class);
        if (zxVar != null) {
            for (Map.Entry<Integer, String> entry2 : zxVar.a().entrySet()) {
                String strB = vc.b(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(strB)) {
                    map.put(strB, entry2.getValue());
                }
            }
        }
        zy zyVar = (zy) aaqVar.a(zy.class);
        if (zyVar != null) {
            for (Map.Entry<Integer, Double> entry3 : zyVar.a().entrySet()) {
                String strD = vc.d(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(strD)) {
                    map.put(strD, a(entry3.getValue().doubleValue()));
                }
            }
        }
        abb abbVar = (abb) aaqVar.a(abb.class);
        if (abbVar != null) {
            tm tmVarA = abbVar.a();
            if (tmVarA != null) {
                for (Map.Entry<String, String> entry4 : tmVarA.a().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        map.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        map.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            Iterator<tn> it = abbVar.d().iterator();
            int i = 1;
            while (it.hasNext()) {
                map.putAll(it.next().a(vc.h(i)));
                i++;
            }
            Iterator<tl> it2 = abbVar.b().iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                map.putAll(it2.next().a(vc.f(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<tl>> entry5 : abbVar.c().entrySet()) {
                List<tl> value = entry5.getValue();
                String strK = vc.k(i3);
                Iterator<tl> it3 = value.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    map.putAll(it3.next().a(strK + vc.i(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    map.put(strK + "nm", entry5.getKey());
                }
                i3++;
            }
        }
        aaz aazVar = (aaz) aaqVar.a(aaz.class);
        if (aazVar != null) {
            a(map, "ul", aazVar.f());
            a(map, "sd", aazVar.a());
            a(map, "sr", aazVar.b(), aazVar.c());
            a(map, "vp", aazVar.d(), aazVar.e());
        }
        aax aaxVar = (aax) aaqVar.a(aax.class);
        if (aaxVar != null) {
            a(map, "an", aaxVar.a());
            a(map, "aid", aaxVar.c());
            a(map, "aiid", aaxVar.d());
            a(map, "av", aaxVar.b());
        }
        return map;
    }

    @Override // defpackage.aaw
    public Uri a() {
        return this.d;
    }

    @Override // defpackage.aaw
    public void a(aaq aaqVar) {
        vq.a(aaqVar);
        vq.b(aaqVar.f(), "Can't deliver not submitted measurement");
        vq.c("deliver should be called on worker thread");
        aaq aaqVarA = aaqVar.a();
        aaa aaaVar = (aaa) aaqVarA.b(aaa.class);
        if (TextUtils.isEmpty(aaaVar.a())) {
            p().a(b(aaqVarA), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(aaaVar.b())) {
            p().a(b(aaqVarA), "Ignoring measurement without client id");
            return;
        }
        if (this.b.k().f()) {
            return;
        }
        double dH = aaaVar.h();
        if (tz.a(dH, aaaVar.b())) {
            b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(dH));
            return;
        }
        Map<String, String> mapB = b(aaqVarA);
        mapB.put("v", "1");
        mapB.put("_v", ue.b);
        mapB.put("tid", this.c);
        if (this.b.k().e()) {
            c("Dry run is enabled. GoogleAnalytics would have sent", a(mapB));
            return;
        }
        HashMap map = new HashMap();
        tz.a(map, "uid", aaaVar.c());
        aax aaxVar = (aax) aaqVar.a(aax.class);
        if (aaxVar != null) {
            tz.a(map, "an", aaxVar.a());
            tz.a(map, "aid", aaxVar.c());
            tz.a(map, "av", aaxVar.b());
            tz.a(map, "aiid", aaxVar.d());
        }
        mapB.put("_s", String.valueOf(t().a(new uh(0L, aaaVar.b(), this.c, !TextUtils.isEmpty(aaaVar.d()), 0L, map))));
        t().a(new tq(p(), mapB, aaqVar.d(), true));
    }
}
