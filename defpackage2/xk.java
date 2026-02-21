package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class xk {
    public static final xl a = new xl() { // from class: xk.1
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
        }
    };
    public static final xl b = new xl() { // from class: xk.2
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                su.e("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zpVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                map2.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) != null));
            }
            zpVar.a("openableURLs", map2);
        }
    };
    public static final xl c = new xl() { // from class: xk.3
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            PackageManager packageManager = zpVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String strOptString = jSONObject2.optString("id");
                            String strOptString2 = jSONObject2.optString("u");
                            String strOptString3 = jSONObject2.optString("i");
                            String strOptString4 = jSONObject2.optString("m");
                            String strOptString5 = jSONObject2.optString("p");
                            String strOptString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                intent.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                intent.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                intent.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                intent.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    intent.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                            try {
                                jSONObject.put(strOptString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e2) {
                                su.b("Error constructing openable urls response.", e2);
                            }
                        } catch (JSONException e3) {
                            su.b("Error parsing the intent data.", e3);
                        }
                    }
                    zpVar.a("openableIntents", jSONObject);
                } catch (JSONException e4) {
                    zpVar.a("openableIntents", new JSONObject());
                }
            } catch (JSONException e5) {
                zpVar.a("openableIntents", new JSONObject());
            }
        }
    };
    public static final xl d = new xl() { // from class: xk.4
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            wi wiVarJ;
            String str = map.get("u");
            if (str == null) {
                su.e("URL missing from click GMSG.");
                return;
            }
            Uri uri = Uri.parse(str);
            try {
                wiVarJ = zpVar.j();
            } catch (wj e2) {
                su.e("Unable to append parameter to URL: " + str);
            }
            Uri uriA = (wiVarJ == null || !wiVarJ.b(uri)) ? uri : wiVarJ.a(uri, zpVar.getContext());
            new zj(zpVar.getContext(), zpVar.k().b, uriA.toString()).b();
        }
    };
    public static final xl e = new xl() { // from class: xk.5
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            ru ruVarE = zpVar.e();
            if (ruVarE != null) {
                ruVarE.a();
                return;
            }
            ru ruVarF = zpVar.f();
            if (ruVarF != null) {
                ruVarF.a();
            } else {
                su.e("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final xl f = new xl() { // from class: xk.6
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            zpVar.b("1".equals(map.get("custom_close")));
        }
    };
    public static final xl g = new xl() { // from class: xk.7
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                su.e("URL missing from httpTrack GMSG.");
            } else {
                new zj(zpVar.getContext(), zpVar.k().b, str).b();
            }
        }
    };
    public static final xl h = new xl() { // from class: xk.8
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            su.c("Received log message: " + map.get("string"));
        }
    };
    public static final xl i = new xl() { // from class: xk.9
        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int i2 = Integer.parseInt(str);
                int i3 = Integer.parseInt(str2);
                int i4 = Integer.parseInt(str3);
                wi wiVarJ = zpVar.j();
                if (wiVarJ != null) {
                    wiVarJ.a().a(i2, i3, i4);
                }
            } catch (NumberFormatException e2) {
                su.e("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final xl j = new xr();
    public static final xl k = new xv();
}
