package defpackage;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class oe {
    oe() {
    }

    public od a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new od(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
