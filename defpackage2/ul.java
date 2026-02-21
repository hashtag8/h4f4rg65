package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ul extends ud {
    private boolean a;
    private final uj b;
    private final tw c;
    private final tv d;
    private final ui e;
    private long f;
    private final ut g;
    private final ut h;
    private final ty i;
    private long j;
    private boolean k;

    protected ul(uf ufVar, ug ugVar) {
        super(ufVar);
        vq.a(ugVar);
        this.f = Long.MIN_VALUE;
        this.d = ugVar.k(ufVar);
        this.b = ugVar.m(ufVar);
        this.c = ugVar.n(ufVar);
        this.e = ugVar.o(ufVar);
        this.i = new ty(n());
        this.g = new ut(ufVar) { // from class: ul.1
            @Override // defpackage.ut
            public void a() {
                ul.this.J();
            }
        };
        this.h = new ut(ufVar) { // from class: ul.2
            @Override // defpackage.ut
            public void a() {
                ul.this.K();
            }
        };
    }

    private void I() {
        Context contextB = k().b();
        if (!td.a(contextB)) {
            e("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!te.a(contextB)) {
            f("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!tf.a(contextB)) {
            e("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else {
            if (tg.a(contextB)) {
                return;
            }
            e("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        a(new uw() { // from class: ul.4
            @Override // defpackage.uw
            public void a(Throwable th) {
                ul.this.F();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        try {
            this.b.g();
            F();
        } catch (SQLiteException e) {
            d("Failed to delete stale hits", e);
        }
        this.h.a(q().C());
    }

    private boolean L() {
        if (this.k) {
            return false;
        }
        return (!q().a() || q().b()) && G() > 0;
    }

    private void M() {
        uv uvVarU = u();
        if (uvVarU.b() && !uvVarU.c()) {
            long j = j();
            if (j == 0 || Math.abs(n().a() - j) > q().k()) {
                return;
            }
            a("Dispatch alarm scheduled (ms)", Long.valueOf(q().j()));
            uvVarU.d();
        }
    }

    private void N() {
        long jMin;
        M();
        long jG = G();
        long jD = w().d();
        if (jD != 0) {
            jMin = jG - Math.abs(n().a() - jD);
            if (jMin <= 0) {
                jMin = Math.min(q().h(), jG);
            }
        } else {
            jMin = Math.min(q().h(), jG);
        }
        a("Dispatch scheduled (ms)", Long.valueOf(jMin));
        if (!this.g.c()) {
            this.g.a(jMin);
        } else {
            this.g.b(Math.max(1L, jMin + this.g.b()));
        }
    }

    private void O() {
        P();
        Q();
    }

    private void P() {
        if (this.g.c()) {
            b("All hits dispatched or no network/service. Going to power save mode");
        }
        this.g.d();
    }

    private void Q() {
        uv uvVarU = u();
        if (uvVarU.c()) {
            uvVarU.e();
        }
    }

    private void a(uh uhVar, aay aayVar) {
        vq.a(uhVar);
        vq.a(aayVar);
        va vaVar = new va(k());
        vaVar.b(uhVar.c());
        vaVar.b(uhVar.d());
        aaq aaqVarJ = vaVar.j();
        aaa aaaVar = (aaa) aaqVarJ.b(aaa.class);
        aaaVar.a("data");
        aaaVar.b(true);
        aaqVarJ.a(aayVar);
        zz zzVar = (zz) aaqVarJ.b(zz.class);
        aax aaxVar = (aax) aaqVarJ.b(aax.class);
        for (Map.Entry<String, String> entry : uhVar.f().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                aaxVar.a(value);
            } else if ("av".equals(key)) {
                aaxVar.b(value);
            } else if ("aid".equals(key)) {
                aaxVar.c(value);
            } else if ("aiid".equals(key)) {
                aaxVar.d(value);
            } else if ("uid".equals(key)) {
                aaaVar.c(value);
            } else {
                zzVar.a(key, value);
            }
        }
        b("Sending installation campaign to", uhVar.c(), aayVar);
        aaqVarJ.a(w().b());
        aaqVarJ.e();
    }

    private boolean g(String str) {
        return o().checkCallingOrSelfPermission(str) == 0;
    }

    public void F() {
        boolean zE;
        k().s();
        D();
        if (!L()) {
            this.d.b();
            O();
            return;
        }
        if (this.b.f()) {
            this.d.b();
            O();
            return;
        }
        if (uy.J.a().booleanValue()) {
            zE = true;
        } else {
            this.d.a();
            zE = this.d.e();
        }
        if (zE) {
            N();
        } else {
            O();
            M();
        }
    }

    public long G() {
        if (this.f != Long.MIN_VALUE) {
            return this.f;
        }
        return v().f() ? ((long) v().g()) * 1000 : q().i();
    }

    public void H() {
        D();
        m();
        this.k = true;
        this.e.d();
        F();
    }

    public long a(uh uhVar, boolean z) {
        long jA;
        vq.a(uhVar);
        D();
        m();
        try {
            try {
                this.b.b();
                this.b.a(uhVar.a(), uhVar.b());
                jA = this.b.a(uhVar.a(), uhVar.b(), uhVar.c());
                if (z) {
                    uhVar.a(1 + jA);
                } else {
                    uhVar.a(jA);
                }
                this.b.a(uhVar);
                this.b.c();
                try {
                    this.b.d();
                } catch (SQLiteException e) {
                    e("Failed to end transaction", e);
                }
            } catch (SQLiteException e2) {
                e("Failed to update Analytics property", e2);
                jA = -1;
            }
            return jA;
        } finally {
            try {
                this.b.d();
            } catch (SQLiteException e3) {
                e("Failed to end transaction", e3);
            }
        }
    }

    @Override // defpackage.ud
    protected void a() {
        this.b.E();
        this.c.E();
        this.e.E();
    }

    public void a(String str) {
        vq.a(str);
        m();
        l();
        aay aayVarA = tz.a(p(), str);
        if (aayVarA == null) {
            d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String strF = w().f();
        if (str.equals(strF)) {
            e("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(strF)) {
            d("Ignoring multiple install campaigns. original, new", strF, str);
            return;
        }
        w().a(str);
        if (w().c().a(q().F())) {
            d("Campaign received too late, ignoring", aayVarA);
            return;
        }
        b("Received installation campaign", aayVarA);
        Iterator<uh> it = this.b.d(0L).iterator();
        while (it.hasNext()) {
            a(it.next(), aayVarA);
        }
    }

    public void a(tq tqVar) {
        vq.a(tqVar);
        aau.d();
        D();
        if (this.k) {
            c("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            a("Delivering hit", tqVar);
        }
        tq tqVarB = b(tqVar);
        g();
        if (this.e.a(tqVarB)) {
            c("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        if (q().a()) {
            p().a(tqVarB, "Service unavailable on package side");
            return;
        }
        try {
            this.b.a(tqVarB);
            F();
        } catch (SQLiteException e) {
            e("Delivery failed to save hit to a database", e);
            p().a(tqVarB, "deliver: failed to insert hit to database");
        }
    }

    protected void a(uh uhVar) {
        m();
        b("Sending first hit to property", uhVar.c());
        if (w().c().a(q().F())) {
            return;
        }
        String strF = w().f();
        if (TextUtils.isEmpty(strF)) {
            return;
        }
        aay aayVarA = tz.a(p(), strF);
        b("Found relevant installation campaign", aayVarA);
        a(uhVar, aayVarA);
    }

    public void a(uw uwVar) {
        a(uwVar, this.j);
    }

    public void a(final uw uwVar, final long j) {
        aau.d();
        D();
        long jD = w().d();
        b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jD != 0 ? Math.abs(n().a() - jD) : -1L));
        if (!q().a()) {
            g();
        }
        try {
            if (i()) {
                r().a(new Runnable() { // from class: ul.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ul.this.a(uwVar, j);
                    }
                });
                return;
            }
            w().e();
            F();
            if (uwVar != null) {
                uwVar.a(null);
            }
            if (this.j != j) {
                this.d.c();
            }
        } catch (Throwable th) {
            e("Local dispatch failed", th);
            w().e();
            F();
            if (uwVar != null) {
                uwVar.a(th);
            }
        }
    }

    public void a(boolean z) {
        F();
    }

    tq b(tq tqVar) {
        Pair<String, Long> pairA;
        if (!TextUtils.isEmpty(tqVar.h()) || (pairA = w().g().a()) == null) {
            return tqVar;
        }
        String str = ((Long) pairA.second) + ":" + ((String) pairA.first);
        HashMap map = new HashMap(tqVar.b());
        map.put("_m", str);
        return tq.a(this, tqVar, map);
    }

    void b() {
        D();
        vq.a(!this.a, "Analytics backend already started");
        this.a = true;
        if (!q().a()) {
            I();
        }
        r().a(new Runnable() { // from class: ul.3
            @Override // java.lang.Runnable
            public void run() {
                ul.this.c();
            }
        });
    }

    protected void c() {
        D();
        w().b();
        if (!g("android.permission.ACCESS_NETWORK_STATE")) {
            f("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            H();
        }
        if (!g("android.permission.INTERNET")) {
            f("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            H();
        }
        if (te.a(o())) {
            b("AnalyticsService registered in the app manifest and enabled");
        } else if (q().a()) {
            f("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            e("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.k && !q().a() && !this.b.f()) {
            g();
        }
        F();
    }

    void d() {
        m();
        this.j = n().a();
    }

    protected void e() {
        m();
        if (q().a()) {
            return;
        }
        h();
    }

    public void f() {
        aau.d();
        D();
        b("Service disconnected");
    }

    protected void g() {
        if (this.k || !q().c() || this.e.b()) {
            return;
        }
        if (this.i.a(q().x())) {
            this.i.a();
            b("Connecting to service");
            if (this.e.c()) {
                b("Connected to service");
                this.i.b();
                e();
            }
        }
    }

    public void h() {
        aau.d();
        D();
        l();
        if (!q().c()) {
            e("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.e.b()) {
            b("Service not connected");
            return;
        }
        if (this.b.f()) {
            return;
        }
        b("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<tq> listB = this.b.b(q().l());
                if (listB.isEmpty()) {
                    F();
                    return;
                }
                while (!listB.isEmpty()) {
                    tq tqVar = listB.get(0);
                    if (!this.e.a(tqVar)) {
                        F();
                        return;
                    }
                    listB.remove(tqVar);
                    try {
                        this.b.c(tqVar.c());
                    } catch (SQLiteException e) {
                        e("Failed to remove hit that was send for delivery", e);
                        O();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                e("Failed to read hits from store", e2);
                O();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        b("Store is empty, nothing to dispatch");
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        r12.b.c();
        r12.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        e("Failed to commit local dispatch transaction", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        if (r12.e.b() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0103, code lost:
    
        if (q().a() != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0105, code lost:
    
        b("Service connected, sending hits to the service");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010e, code lost:
    
        if (r8.isEmpty() != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0110, code lost:
    
        r0 = r8.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011d, code lost:
    
        if (r12.e.a(r0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011f, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0126, code lost:
    
        if (r12.c.b() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
    
        r9 = r12.c.a(r8);
        r10 = r9.iterator();
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
    
        if (r10.hasNext() == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
    
        r4 = java.lang.Math.max(r4, r10.next().longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0148, code lost:
    
        r4 = java.lang.Math.max(r4, r0.c());
        r8.remove(r0);
        b("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0158, code lost:
    
        r12.b.c(r0.c());
        r3.add(java.lang.Long.valueOf(r0.c()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x016d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016e, code lost:
    
        e("Failed to remove hit that was send for delivery", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0176, code lost:
    
        r12.b.c();
        r12.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0182, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0183, code lost:
    
        e("Failed to commit local dispatch transaction", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x018d, code lost:
    
        r8.removeAll(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0190, code lost:
    
        r12.b.a(r9);
        r3.addAll(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0198, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019d, code lost:
    
        if (r3.isEmpty() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019f, code lost:
    
        r12.b.c();
        r12.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ac, code lost:
    
        e("Failed to commit local dispatch transaction", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b7, code lost:
    
        e("Failed to remove successfully uploaded hits", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01bf, code lost:
    
        r12.b.c();
        r12.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cc, code lost:
    
        e("Failed to commit local dispatch transaction", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d6, code lost:
    
        r12.b.c();
        r12.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e4, code lost:
    
        e("Failed to commit local dispatch transaction", r0);
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0205, code lost:
    
        r0 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean i() {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ul.i():boolean");
    }

    public long j() {
        aau.d();
        D();
        try {
            return this.b.h();
        } catch (SQLiteException e) {
            e("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }
}
