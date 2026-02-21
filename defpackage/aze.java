package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aze extends azi {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        this.c = a(jSONObject, "title");
        if (this.c == null || this.c.isEmpty()) {
            this.c = "TODO";
        }
        try {
            if (jSONObject.has("image") && !jSONObject.isNull("image")) {
                this.a = a(jSONObject.getJSONObject("image"), "url");
            }
        } catch (JSONException e) {
        }
        this.e = a(jSONObject, "key");
        this.b = a(jSONObject, "surl");
        this.g = b(jSONObject, "duration");
        this.f = a(jSONObject, "impressionUrl");
        this.d = this.e;
    }

    @Override // defpackage.azi
    public String a() {
        return this.a;
    }
}
