package defpackage;

import java.io.File;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class pn extends blw implements pb {
    public pn(bln blnVar, String str, String str2, bnw bnwVar) {
        super(blnVar, str, str2, bnwVar, bnu.POST);
    }

    @Override // defpackage.pb
    public boolean a(pa paVar) throws Throwable {
        bnv bnvVarA = a(a(b(), paVar.a), paVar.b);
        blh.h().a("CrashlyticsCore", "Sending report to: " + a());
        int iB = bnvVarA.b();
        blh.h().a("CrashlyticsCore", "Result was: " + iB);
        return bmo.a(iB) == 0;
    }

    private bnv a(bnv bnvVar, String str) {
        bnvVar.a(HTTP.USER_AGENT, "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", str);
        return bnvVar;
    }

    private bnv a(bnv bnvVar, pw pwVar) throws Throwable {
        bnvVar.e("report_id", pwVar.b());
        for (File file : pwVar.d()) {
            if (file.getName().equals("minidump")) {
                bnvVar.a("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                bnvVar.a("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                bnvVar.a("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                bnvVar.a("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                bnvVar.a("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                bnvVar.a("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                bnvVar.a("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                bnvVar.a("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                bnvVar.a("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                bnvVar.a("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return bnvVar;
    }
}
