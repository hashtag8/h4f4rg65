package defpackage;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azk extends azi {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private int g = 0;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        int i = 1;
        try {
            if (jSONObject.has("artists") && !jSONObject.isNull("artists") && (jSONObject.get("artists") instanceof JSONObject)) {
                JSONArray jSONArray = jSONObject.getJSONObject("artists").getJSONArray("items");
                StringBuilder sb = new StringBuilder();
                if (jSONArray.length() > 0) {
                    sb.append(jSONArray.getJSONObject(0).getString("name"));
                    while (i < jSONArray.length()) {
                        sb.append(", ").append(jSONArray.getJSONObject(i).getString("name"));
                        i++;
                    }
                }
                this.b = sb.toString();
            } else if (jSONObject.has("artists") && !jSONObject.isNull("artists") && (jSONObject.get("artists") instanceof JSONArray)) {
                JSONArray jSONArray2 = jSONObject.getJSONObject("artists").getJSONArray("name");
                StringBuilder sb2 = new StringBuilder();
                if (jSONArray2.length() > 0) {
                    sb2.append(jSONArray2.get(0));
                    while (i < jSONArray2.length()) {
                        sb2.append(", ").append(jSONArray2.get(i));
                        i++;
                    }
                }
                this.b = sb2.toString();
            } else {
                this.b = a(jSONObject, "owner");
            }
        } catch (JSONException e) {
            Log.wtf("Stations parsing failed", "");
            this.b = "";
        }
        this.c = b(jSONObject, "count");
        this.e = a(jSONObject, "shortUrl");
        this.f = a(jSONObject, "name");
        this.d = a(jSONObject, "icon");
        this.a = a(jSONObject, "key");
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    @Override // defpackage.azi
    public String a() {
        return this.d;
    }

    public String d() {
        return this.f;
    }
}
