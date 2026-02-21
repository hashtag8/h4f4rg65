package defpackage;

import com.harman.commom.music.player.service.MusicData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aml {
    public static MusicData a(JSONObject jSONObject, String str) {
        MusicData musicData = new MusicData();
        musicData.type = 2;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("links");
            if (jSONArray.length() > 0) {
                musicData.path = (String) ((JSONObject) jSONArray.get(0)).get("href");
            }
            musicData.songId = jSONObject.getLong("id");
            musicData.musicName = jSONObject.getString("name");
            JSONObject jSONObject2 = jSONObject.getJSONObject("creators");
            if (jSONObject2.has("performers")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("performers");
                String str2 = "";
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                    if (i == 0) {
                        musicData.artist_id = jSONObject3.getLong("id");
                    }
                    str2 = str2 + jSONObject3.getString("name");
                    if (i == jSONArray2.length() - 2) {
                        str2 = str2 + " & ";
                    } else if (i != jSONArray2.length() - 1) {
                        str2 = str2 + ", ";
                    }
                }
                musicData.artist = str2;
            }
            if (jSONObject.has("takenfrom")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("takenfrom");
                musicData.album = jSONObject4.getString("name");
                musicData.album_id = jSONObject4.getLong("id");
            }
            if (jSONObject.has("thumbnails")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("thumbnails");
                if (jSONObject5.has("200x200")) {
                    musicData.album_art = jSONObject5.getString("200x200");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return musicData;
    }
}
