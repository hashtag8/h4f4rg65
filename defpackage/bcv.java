package defpackage;

import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bcv {
    public static ArrayList<bdg> a(JSONObject jSONObject) {
        ArrayList<bdg> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                bdg bdgVar = new bdg();
                bdgVar.c = "" + jSONObject2.getInt("id");
                bdgVar.d = jSONObject2.getString("title");
                bdgVar.e = jSONObject2.getString("url");
                bdgVar.f = jSONObject2.getInt("duration");
                bdgVar.j = jSONObject2.getBoolean("allowStreaming");
                bdgVar.k = jSONObject2.getBoolean("streamReady");
                bdgVar.l = jSONObject2.getString("streamStartDate");
                if (jSONObject2.has("artist")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("artist");
                    bdgVar.a = jSONObject3.getString("name");
                    bdgVar.b = "" + jSONObject3.getInt("id");
                }
                if (jSONObject2.has("album")) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("album");
                    bdgVar.h = jSONObject4.getString("title");
                    bdgVar.g = "" + jSONObject4.getInt("id");
                    bdgVar.i = jSONObject4.getString("cover");
                }
                arrayList.add(bdgVar);
            }
        } catch (JSONException e) {
            new ml().a("Could not parse " + bru.b(String.valueOf(jSONObject), HttpStatus.SC_INTERNAL_SERVER_ERROR), e);
        }
        return arrayList;
    }
}
