package defpackage;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azj extends azi {
    private String a;
    private String b;
    private int c;
    private ArrayList<String> d;
    private String e;
    private String f;
    private String g;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("owner") && !jSONObject.isNull("owner")) {
                Object obj = jSONObject.get("owner");
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    this.b = jSONObject2.getString("firstName") + " " + jSONObject2.getString("lastName");
                } else if (obj instanceof String) {
                    this.b = (String) obj;
                }
            }
        } catch (JSONException e) {
            this.b = "";
        }
        this.f = a(jSONObject, "name");
        this.c = b(jSONObject, "length");
        this.g = a(jSONObject, "icon");
        this.a = a(jSONObject, "key");
        this.e = a(jSONObject, "shortUrl");
        this.d = c(jSONObject, "trackKeys");
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public ArrayList<String> e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }

    @Override // defpackage.azi
    public String a() {
        return this.g;
    }
}
