package defpackage;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class nr extends blw implements bno {
    private final String b;

    public nr(bln blnVar, String str, String str2, bnw bnwVar, String str3) {
        super(blnVar, str, str2, bnwVar, bnu.POST);
        this.b = str3;
    }

    @Override // defpackage.bno
    public boolean a(List<File> list) throws Throwable {
        bnv bnvVarA = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", this.b);
        int i = 0;
        for (File file : list) {
            bnvVarA.a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        blh.h().a("Answers", "Sending " + list.size() + " analytics files to " + a());
        int iB = bnvVarA.b();
        blh.h().a("Answers", "Response code for analytics file send is " + iB);
        return bmo.a(iB) == 0;
    }
}
