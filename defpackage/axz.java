package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioTrackData;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axz {
    public static int a = 0;

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        boolean z = true;
        for (int i = 0; i < length; i++) {
            char cCharAt = sb.charAt(i);
            if (z) {
                if (!Character.isWhitespace(cCharAt)) {
                    sb.setCharAt(i, Character.toTitleCase(cCharAt));
                    z = false;
                }
            } else if (Character.isWhitespace(cCharAt)) {
                z = true;
            } else {
                sb.setCharAt(i, Character.toLowerCase(cCharAt));
            }
        }
        return sb.toString();
    }

    public static MusicData a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null && strOptString.compareTo("vast") == 0) {
            MixRadioAdvertData mixRadioAdvertData = new MixRadioAdvertData();
            mixRadioAdvertData.type = 2;
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ad");
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("inline")) != null) {
                mixRadioAdvertData.musicName = jSONObjectOptJSONObject.optString("adtitle");
                mixRadioAdvertData.artist = jSONObjectOptJSONObject.optString("description");
                mixRadioAdvertData.album_art = "http://assets.mixrad.io/asset/webassets/hk_ad_360.png";
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("creatives");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                    mixRadioAdvertData.songId = jSONObjectOptJSONObject2.optInt("id");
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("linear");
                    if (jSONObjectOptJSONObject4 != null) {
                        try {
                            mixRadioAdvertData.duration = b(jSONObjectOptJSONObject4.optString("duration", "0:0:0"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("trackingevents");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            mixRadioAdvertData.a = new HashMap<>();
                            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i);
                                if (jSONObjectOptJSONObject5 != null) {
                                    mixRadioAdvertData.a.put(jSONObjectOptJSONObject5.optString("event", "event"), jSONObjectOptJSONObject5.optString("value", "value"));
                                }
                            }
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("mediafiles");
                        if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            mixRadioAdvertData.path = jSONArrayOptJSONArray3.optJSONObject(0).optString("value");
                        }
                    }
                }
            }
            return mixRadioAdvertData;
        }
        MixRadioTrackData mixRadioTrackData = new MixRadioTrackData();
        mixRadioTrackData.type = 2;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("links");
            mixRadioTrackData.a = str;
            if (jSONArray.length() > 0) {
                mixRadioTrackData.path = (String) ((JSONObject) jSONArray.get(0)).get("href");
            }
            mixRadioTrackData.songId = jSONObject.getLong("id");
            mixRadioTrackData.musicName = jSONObject.getString("name");
            JSONObject jSONObject2 = jSONObject.getJSONObject("creators");
            if (jSONObject2.has("performers")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("performers");
                String str2 = "";
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (i2 == 0) {
                        mixRadioTrackData.artist_id = jSONObject3.getLong("id");
                    }
                    str2 = str2 + jSONObject3.getString("name");
                    if (i2 == jSONArray2.length() - 2) {
                        str2 = str2 + " & ";
                    } else if (i2 != jSONArray2.length() - 1) {
                        str2 = str2 + ", ";
                    }
                }
                mixRadioTrackData.artist = str2;
            }
            if (jSONObject.has("takenfrom")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("takenfrom");
                mixRadioTrackData.album = jSONObject4.getString("name");
                mixRadioTrackData.album_id = jSONObject4.getLong("id");
            }
            if (jSONObject.has("thumbnails")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("thumbnails");
                if (jSONObject5.has("320x320")) {
                    mixRadioTrackData.album_art = jSONObject5.getString("320x320");
                } else if (jSONObject5.has("200x200")) {
                    mixRadioTrackData.album_art = jSONObject5.getString("200x200");
                } else if (jSONObject5.has("100x100")) {
                    mixRadioTrackData.album_art = jSONObject5.getString("100x100");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return mixRadioTrackData;
    }

    public static long b(String str) {
        String str2 = str.split(":")[0];
        return ((long) (Integer.parseInt(str2) * 60 * 60)) + ((long) Integer.parseInt(str.split(":")[2])) + 0 + ((long) (Integer.parseInt(str.split(":")[1]) * 60));
    }
}
