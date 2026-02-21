package defpackage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class azi {
    public abstract String a();

    public abstract void a(JSONObject jSONObject);

    public String a(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public int b(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return 0;
            }
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            return 0;
        }
    }

    public ArrayList<String> c(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (jSONObject.has(str) && !jSONObject.isNull(str) && (jSONArray = jSONObject.getJSONArray(str)) != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
        }
        return arrayList;
    }
}
