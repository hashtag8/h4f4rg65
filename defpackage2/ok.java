package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ok {
    private final Context a;
    private final a b;

    interface a {
        String a(File file);
    }

    ok(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    byte[] a(String str) {
        return a(b(str));
    }

    private JSONArray b(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str2 : b(new JSONObject(str).getJSONArray("maps")).split("\\|")) {
                ps psVarA = pt.a(str2);
                if (psVarA != null && a(psVarA)) {
                    try {
                        try {
                            jSONArray.put(a(this.b.a(c(psVarA.d)), psVarA));
                        } catch (JSONException e) {
                            blh.h().a("CrashlyticsCore", "Could not create a binary image json string", e);
                        }
                    } catch (IOException e2) {
                        blh.h().a("CrashlyticsCore", "Could not generate ID for file " + psVarA.d, e2);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e3) {
            blh.h().d("CrashlyticsCore", "Unable to parse proc maps string", e3);
            return jSONArray;
        }
    }

    private File c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return a(file);
        }
        return file;
    }

    private File a(File file) {
        if (Build.VERSION.SDK_INT >= 9 && file.getAbsolutePath().startsWith("/data")) {
            try {
                return new File(this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 0).nativeLibraryDir, file.getName());
            } catch (PackageManager.NameNotFoundException e) {
                blh.h().e("CrashlyticsCore", "Error getting ApplicationInfo", e);
                return file;
            }
        }
        return file;
    }

    private static byte[] a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e) {
            blh.h().d("CrashlyticsCore", "Binary images string is null", e);
            return new byte[0];
        }
    }

    private static JSONObject a(String str, ps psVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", psVar.a);
        jSONObject.put("size", psVar.b);
        jSONObject.put("name", psVar.d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static String b(JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    private static boolean a(ps psVar) {
        return (psVar.c.indexOf(120) == -1 || psVar.d.indexOf(47) == -1) ? false : true;
    }
}
