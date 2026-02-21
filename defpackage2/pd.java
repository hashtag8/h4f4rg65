package defpackage;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class pd extends blw implements pb {
    public pd(bln blnVar, String str, String str2, bnw bnwVar) {
        super(blnVar, str, str2, bnwVar, bnu.POST);
    }

    @Override // defpackage.pb
    public boolean a(pa paVar) throws Throwable {
        bnv bnvVarA = a(a(b(), paVar), paVar.b);
        blh.h().a("CrashlyticsCore", "Sending report to: " + a());
        int iB = bnvVarA.b();
        blh.h().a("CrashlyticsCore", "Create report request ID: " + bnvVarA.b("X-REQUEST-ID"));
        blh.h().a("CrashlyticsCore", "Result was: " + iB);
        return bmo.a(iB) == 0;
    }

    private bnv a(bnv bnvVar, pa paVar) {
        bnv bnvVarA = bnvVar.a("X-CRASHLYTICS-API-KEY", paVar.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        Iterator<Map.Entry<String, String>> it = paVar.b.e().entrySet().iterator();
        while (true) {
            bnv bnvVar2 = bnvVarA;
            if (it.hasNext()) {
                bnvVarA = bnvVar2.a(it.next());
            } else {
                return bnvVar2;
            }
        }
    }

    private bnv a(bnv bnvVar, pw pwVar) throws Throwable {
        bnvVar.e("report[identifier]", pwVar.b());
        if (pwVar.d().length == 1) {
            blh.h().a("CrashlyticsCore", "Adding single file " + pwVar.a() + " to report " + pwVar.b());
            return bnvVar.a("report[file]", pwVar.a(), "application/octet-stream", pwVar.c());
        }
        int i = 0;
        for (File file : pwVar.d()) {
            blh.h().a("CrashlyticsCore", "Adding file " + file.getName() + " to report " + pwVar.b());
            bnvVar.a("report[file" + i + "]", file.getName(), "application/octet-stream", file);
            i++;
        }
        return bnvVar;
    }
}
