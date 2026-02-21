package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import defpackage.bml;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class oa extends bln<Boolean> implements bmi {
    private final blt<String> a = new blt<>();
    private final of b = new of();
    private oh c;

    @Override // defpackage.bln
    @TargetApi(14)
    protected boolean b_() {
        this.c = a(Build.VERSION.SDK_INT, (Application) r().getApplicationContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bln
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() throws Throwable {
        blh.h().a("Beta", "Beta kit initializing...");
        Context contextR = r();
        bml bmlVarQ = q();
        if (TextUtils.isEmpty(a(contextR, bmlVarQ.i()))) {
            blh.h().a("Beta", "A Beta device token was not found for this app");
            return false;
        }
        blh.h().a("Beta", "Beta device token is present, checking for app updates.");
        bok bokVarH = h();
        ob obVarA = a(contextR);
        if (a(bokVarH, obVarA)) {
            this.c.a(contextR, this, bmlVarQ, bokVarH, obVarA, new boe(this), new bmp(), new bnt(blh.h()));
        }
        return true;
    }

    @TargetApi(14)
    oh a(int i, Application application) {
        return i >= 14 ? new nz(s().e(), s().f()) : new og();
    }

    @Override // defpackage.bmi
    public Map<bml.a, String> e() {
        String strA = a(r(), q().i());
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strA)) {
            map.put(bml.a.FONT_TOKEN, strA);
        }
        return map;
    }

    @Override // defpackage.bln
    public String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    @Override // defpackage.bln
    public String a() {
        return "1.2.7.19";
    }

    boolean a(bok bokVar, ob obVar) {
        return (bokVar == null || TextUtils.isEmpty(bokVar.a) || obVar == null) ? false : true;
    }

    private String a(Context context, String str) {
        String strA;
        try {
            strA = this.a.a(context, this.b);
            if ("".equals(strA)) {
                strA = null;
            }
        } catch (Exception e) {
            blh.h().e("Beta", "Failed to load the Beta device token", e);
            strA = null;
        }
        blh.h().a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(strA)));
        return strA;
    }

    private bok h() {
        boy boyVarB = bov.a().b();
        if (boyVarB != null) {
            return boyVarB.f;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private defpackage.ob a(android.content.Context r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            android.content.res.AssetManager r0 = r8.getAssets()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L84
            java.lang.String r2 = "crashlytics-build.properties"
            java.io.InputStream r2 = r0.open(r2)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L84
            if (r2 == 0) goto La5
            ob r1 = defpackage.ob.a(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            blq r0 = defpackage.blh.h()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r3 = "Beta"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r4.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.d     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = " build properties: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = " ("
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.a     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = ") - "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0.a(r3, r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0 = r1
        L4e:
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.io.IOException -> L54
        L53:
            return r0
        L54:
            r1 = move-exception
            blq r2 = defpackage.blh.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L53
        L61:
            r0 = move-exception
            r2 = r1
            r6 = r1
            r1 = r0
            r0 = r6
        L66:
            blq r3 = defpackage.blh.h()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Error reading Beta build properties"
            r3.e(r4, r5, r1)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.io.IOException -> L77
            goto L53
        L77:
            r1 = move-exception
            blq r2 = defpackage.blh.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L53
        L84:
            r0 = move-exception
            r2 = r1
        L86:
            if (r2 == 0) goto L8b
            r2.close()     // Catch: java.io.IOException -> L8c
        L8b:
            throw r0
        L8c:
            r1 = move-exception
            blq r2 = defpackage.blh.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L8b
        L99:
            r0 = move-exception
            goto L86
        L9b:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L66
        La0:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L66
        La5:
            r0 = r1
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oa.a(android.content.Context):ob");
    }

    String g() {
        return bme.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
