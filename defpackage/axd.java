package defpackage;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axd {
    private static int a = 5;
    private static int b = 1000;

    public interface a {
        void a(String str, String str2);

        void a(boolean z, int i);
    }

    public interface b {
        void a(String str, String str2);

        void a(String str, JSONArray jSONArray);

        void a(String str, JSONObject jSONObject, String str2);
    }

    public static void a(String str, String str2, String str3, aus ausVar, aug augVar, boolean z) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        if (z) {
            aueVarA.a("Authorization", "Bearer " + axc.a().h);
            mm.b("Authorization", "Bearer " + axc.a().h);
        }
        aueVarA.a(a(str, str2, str3), ausVar, augVar);
    }

    public static String a(String str, String str2, String str3) {
        String strReplace = (str2.compareTo("") == 0 || str3.compareTo("") == 0) ? str : str.replace(str2, str3);
        if (strReplace == null) {
            strReplace = "";
        }
        mm.b("URLSTRING", strReplace);
        return strReplace;
    }
}
