package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class tk extends ud {
    private boolean a;
    private final Map<String, String> b;
    private final Map<String, String> c;
    private final ts d;
    private final a e;

    class a extends ud {
        private long b;
        private boolean c;

        protected a(uf ufVar) {
            super(ufVar);
            this.b = -1L;
        }

        @Override // defpackage.ud
        protected void a() {
        }

        public synchronized boolean b() {
            boolean z;
            z = this.c;
            this.c = false;
            return z;
        }
    }

    tk(uf ufVar, String str, ts tsVar) {
        super(ufVar);
        this.b = new HashMap();
        this.c = new HashMap();
        if (str != null) {
            this.b.put("&tid", str);
        }
        this.b.put("useSecure", "1");
        this.b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (tsVar == null) {
            this.d = new ts("tracking");
        } else {
            this.d = tsVar;
        }
        this.e = new a(ufVar);
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        vq.a(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strB = b(entry);
            if (strB != null) {
                map2.put(strB, entry.getValue());
            }
        }
    }

    private static boolean a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    private static String b(Map.Entry<String, String> entry) {
        if (a(entry)) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    private static void b(Map<String, String> map, Map<String, String> map2) {
        vq.a(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strB = b(entry);
            if (strB != null && !map2.containsKey(strB)) {
                map2.put(strB, entry.getValue());
            }
        }
    }

    @Override // defpackage.ud
    protected void a() {
        this.e.E();
        String strC = v().c();
        if (strC != null) {
            a("&an", strC);
        }
        String strB = v().b();
        if (strB != null) {
            a("&av", strB);
        }
    }

    public void a(String str) {
        a("&cd", str);
    }

    public void a(String str, String str2) {
        vq.a(str, (Object) "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, str2);
    }

    public void a(Map<String, String> map) {
        final long jA = n().a();
        if (s().f()) {
            c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean zE = s().e();
        final HashMap map2 = new HashMap();
        a(this.b, map2);
        a(map, map2);
        final boolean zA = tz.a(this.b.get("useSecure"), true);
        b(this.c, map2);
        this.c.clear();
        final String str = map2.get("t");
        if (TextUtils.isEmpty(str)) {
            p().a(map2, "Missing hit type parameter");
            return;
        }
        final String str2 = map2.get("tid");
        if (TextUtils.isEmpty(str2)) {
            p().a(map2, "Missing tracking id parameter");
            return;
        }
        final boolean zB = b();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int i = Integer.parseInt(this.b.get("&a")) + 1;
                if (i >= Integer.MAX_VALUE) {
                    i = 1;
                }
                this.b.put("&a", Integer.toString(i));
            }
        }
        r().a(new Runnable() { // from class: tk.1
            @Override // java.lang.Runnable
            public void run() {
                if (tk.this.e.b()) {
                    map2.put("sc", "start");
                }
                tz.b(map2, "cid", tk.this.s().h());
                String str3 = (String) map2.get("sf");
                if (str3 != null) {
                    double dA = tz.a(str3, 100.0d);
                    if (tz.a(dA, (String) map2.get("cid"))) {
                        tk.this.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(dA));
                        return;
                    }
                }
                to toVarY = tk.this.y();
                if (zB) {
                    tz.a((Map<String, String>) map2, "ate", toVarY.b());
                    tz.a((Map<String, String>) map2, "adid", toVarY.c());
                } else {
                    map2.remove("ate");
                    map2.remove("adid");
                }
                aax aaxVarC = tk.this.z().c();
                tz.a((Map<String, String>) map2, "an", aaxVarC.a());
                tz.a((Map<String, String>) map2, "av", aaxVarC.b());
                tz.a((Map<String, String>) map2, "aid", aaxVarC.c());
                tz.a((Map<String, String>) map2, "aiid", aaxVarC.d());
                map2.put("v", "1");
                map2.put("_v", ue.b);
                tz.a((Map<String, String>) map2, "ul", tk.this.A().b().f());
                tz.a((Map<String, String>) map2, "sr", tk.this.A().c());
                if (!(str.equals("transaction") || str.equals("item")) && !tk.this.d.a()) {
                    tk.this.p().a(map2, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long jA2 = tz.a((String) map2.get("ht"));
                if (jA2 == 0) {
                    jA2 = jA;
                }
                if (zE) {
                    tk.this.p().c("Dry run enabled. Would have sent hit", new tq(tk.this, map2, jA2, zA));
                    return;
                }
                String str4 = (String) map2.get("cid");
                HashMap map3 = new HashMap();
                tz.a(map3, "uid", (Map<String, String>) map2);
                tz.a(map3, "an", (Map<String, String>) map2);
                tz.a(map3, "aid", (Map<String, String>) map2);
                tz.a(map3, "av", (Map<String, String>) map2);
                tz.a(map3, "aiid", (Map<String, String>) map2);
                map2.put("_s", String.valueOf(tk.this.t().a(new uh(0L, str4, str2, TextUtils.isEmpty((CharSequence) map2.get("adid")) ? false : true, 0L, map3))));
                tk.this.t().a(new tq(tk.this, map2, jA2, zA));
            }
        });
    }

    boolean b() {
        return this.a;
    }
}
