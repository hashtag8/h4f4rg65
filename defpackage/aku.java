package defpackage;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aku extends auz {
    public aku(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        String strTrim = aho.d("qobuz_user_auth_token").trim();
        return ("".equals(strTrim) || strTrim == null) ? false : true;
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("user_auth_token");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("user");
        String strConcat = "".concat(jSONObjectOptJSONObject.optString("country")).concat("&" + jSONObjectOptJSONObject.optString("login"));
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("credential");
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("device");
        aho.a("qobuz_user_info", strConcat.concat("&" + jSONObjectOptJSONObject2.optString("description")).concat("&" + jSONObjectOptJSONObject.optInt("id")));
        aho.a("user_id", jSONObjectOptJSONObject.optString("id"));
        aho.a("device_id", jSONObjectOptJSONObject3.optString("id"));
        aho.a("credential_id", jSONObjectOptJSONObject2.optString("id"));
        aho.a("qobuz_user_auth_token", strOptString);
        aho.a("format_id", "5");
    }

    @Override // defpackage.auz
    public void b() {
        aho.a("qobuz_user_auth_token", "");
        d();
    }
}
