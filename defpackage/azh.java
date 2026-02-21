package defpackage;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azh extends azi {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        this.b = a(jSONObject, "headline");
        this.c = a(jSONObject, "key");
        this.d = a(jSONObject, "url");
        this.a = 0;
        try {
            if (jSONObject.has("contentTypes") && !jSONObject.isNull("contentTypes")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("contentTypes");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    this.a = jSONObject2.getInt(itKeys.next()) + this.a;
                }
            }
        } catch (JSONException e) {
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (jSONObject.has("contents") && !jSONObject.isNull("contents") && (jSONArray = jSONObject.getJSONObject("contents").getJSONArray("items")) != null && jSONArray.length() > 0) {
                sb.append(jSONArray.getJSONObject(0).getJSONObject("content").getString("name"));
                for (int i = 1; i < jSONArray.length(); i++) {
                    sb.append(", ").append(jSONArray.getJSONObject(i).getJSONObject("content").getString("name"));
                }
            }
        } catch (JSONException e2) {
        }
        this.e = sb.toString();
    }

    @Override // defpackage.azi
    public String a() {
        return null;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
