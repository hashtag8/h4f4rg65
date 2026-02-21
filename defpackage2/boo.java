package defpackage;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class boo implements box {
    private final bpb a;
    private final bpa b;
    private final bmg c;
    private final bol d;
    private final bpc e;
    private final bln f;
    private final bod g;

    public boo(bln blnVar, bpb bpbVar, bmg bmgVar, bpa bpaVar, bol bolVar, bpc bpcVar) {
        this.f = blnVar;
        this.a = bpbVar;
        this.c = bmgVar;
        this.b = bpaVar;
        this.d = bolVar;
        this.e = bpcVar;
        this.g = new boe(this.f);
    }

    @Override // defpackage.box
    public boy a() {
        return a(bow.USE_CACHE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.box
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.boy a(defpackage.bow r8) {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = defpackage.blh.i()     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L11
            boolean r0 = r7.d()     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L11
            boy r1 = r7.b(r8)     // Catch: java.lang.Exception -> L42
        L11:
            if (r1 != 0) goto L38
            bpc r0 = r7.e     // Catch: java.lang.Exception -> L52
            bpb r2 = r7.a     // Catch: java.lang.Exception -> L52
            org.json.JSONObject r0 = r0.a(r2)     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L38
            bpa r2 = r7.b     // Catch: java.lang.Exception -> L52
            bmg r3 = r7.c     // Catch: java.lang.Exception -> L52
            boy r1 = r2.a(r3, r0)     // Catch: java.lang.Exception -> L52
            bol r2 = r7.d     // Catch: java.lang.Exception -> L52
            long r4 = r1.g     // Catch: java.lang.Exception -> L52
            r2.a(r4, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r2 = "Loaded settings: "
            r7.a(r0, r2)     // Catch: java.lang.Exception -> L52
            java.lang.String r0 = r7.b()     // Catch: java.lang.Exception -> L52
            r7.a(r0)     // Catch: java.lang.Exception -> L52
        L38:
            r0 = r1
            if (r0 != 0) goto L41
            bow r1 = defpackage.bow.IGNORE_CACHE_EXPIRATION     // Catch: java.lang.Exception -> L57
            boy r0 = r7.b(r1)     // Catch: java.lang.Exception -> L57
        L41:
            return r0
        L42:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
        L46:
            blq r2 = defpackage.blh.h()
            java.lang.String r3 = "Fabric"
            java.lang.String r4 = "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved."
            r2.e(r3, r4, r1)
            goto L41
        L52:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L46
        L57:
            r1 = move-exception
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.boo.a(bow):boy");
    }

    private boy b(bow bowVar) {
        boy boyVar = null;
        try {
            if (!bow.SKIP_CACHE_LOOKUP.equals(bowVar)) {
                JSONObject jSONObjectA = this.d.a();
                if (jSONObjectA != null) {
                    boy boyVarA = this.b.a(this.c, jSONObjectA);
                    if (boyVarA != null) {
                        a(jSONObjectA, "Loaded cached settings: ");
                        long jA = this.c.a();
                        if (bow.IGNORE_CACHE_EXPIRATION.equals(bowVar) || !boyVarA.a(jA)) {
                            try {
                                blh.h().a("Fabric", "Returning cached settings.");
                                boyVar = boyVarA;
                            } catch (Exception e) {
                                boyVar = boyVarA;
                                e = e;
                                blh.h().e("Fabric", "Failed to get cached settings", e);
                            }
                        } else {
                            blh.h().a("Fabric", "Cached settings have expired.");
                        }
                    } else {
                        blh.h().e("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    blh.h().a("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return boyVar;
    }

    private void a(JSONObject jSONObject, String str) {
        blh.h().a("Fabric", str + jSONObject.toString());
    }

    String b() {
        return bme.a(bme.m(this.f.r()));
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String str) {
        SharedPreferences.Editor editorB = this.g.b();
        editorB.putString("existing_instance_identifier", str);
        return this.g.a(editorB);
    }

    boolean d() {
        return !c().equals(b());
    }
}
