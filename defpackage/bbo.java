package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbo {
    bbj a = new bbj();

    public ArrayList<JSONObject> a(String str) {
        try {
            ArrayList<JSONObject> arrayList = new ArrayList<>();
            if (str.startsWith("[") && str.endsWith("]")) {
                aby abyVarM = new acf().a(str).m();
                for (int i = 0; i < abyVarM.a(); i++) {
                    arrayList.add(new JSONObject(abyVarM.a(i).l().toString()));
                }
            } else if (str.startsWith("{") && str.endsWith("}")) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("kind") && jSONObject.getString("kind").equals("playlist")) {
                    if (jSONObject.getInt("track_count") > 0) {
                        if (jSONObject.has("tracks") && jSONObject.getJSONArray("tracks").length() > 0) {
                            arrayList = a(jSONObject.getJSONArray("tracks"));
                        }
                    } else {
                        return arrayList;
                    }
                } else {
                    arrayList.add(jSONObject);
                }
            }
            ArrayList<JSONObject> arrayListA = a(arrayList);
            arrayListA.removeAll(Collections.singleton(null));
            return arrayListA;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<JSONObject> a(ArrayList<JSONObject> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            new JSONObject();
            if (!arrayList.isEmpty()) {
                int length = arrayList.get(0).getJSONArray("collection").length();
                for (int i = 0; i < length; i++) {
                    if (arrayList.get(0).getJSONArray("collection").get(i) instanceof JSONObject) {
                        jSONArray.put(jSONArray.length(), arrayList.get(0).getJSONArray("collection").get(i));
                    }
                }
                JSONObject jSONObjectRemove = arrayList.remove(0);
                jSONObjectRemove.put("collection", jSONArray);
                arrayList.add(jSONObjectRemove);
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public ArrayList<JSONObject> a(JSONArray jSONArray) {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArray.length()) {
                try {
                    if (jSONArray.get(i2) != null) {
                        arrayList.add((JSONObject) jSONArray.get(i2));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
