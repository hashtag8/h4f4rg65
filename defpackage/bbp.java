package defpackage;

import com.musicservice.soundcloud.api.Stream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbp {
    protected long a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected boolean h;
    protected String i;
    protected String j;
    protected JSONArray k;
    protected String l;
    protected String m;
    protected String n;
    protected String o;
    protected String p;
    protected String q;
    protected Stream r = new Stream();
    protected ArrayList<String> s;

    public bbp(JSONObject jSONObject, String str) {
        JSONObject jSONObjectC = null;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.i = "";
        this.j = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        try {
            if (str.equals("Track")) {
                if (jSONObject.has("kind") && jSONObject.getString("kind").startsWith("track")) {
                    jSONObjectC = jSONObject;
                } else if (jSONObject.has("type") && jSONObject.getString("type").startsWith("track")) {
                    jSONObjectC = c(jSONObject, "track");
                }
                if (jSONObjectC != null) {
                    JSONObject jSONObjectC2 = c(jSONObjectC, "user");
                    this.a = b(jSONObjectC, "id");
                    this.b = a(jSONObjectC2, "username");
                    this.c = a(jSONObjectC2, "avatar_url");
                    int iB = b(jSONObjectC, "duration");
                    this.d = String.format("%d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(iB)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(iB) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(iB))));
                    this.e = a(jSONObjectC, null, this.c);
                    if (jSONObjectC.has("playback_count") && !jSONObjectC.isNull("playback_count")) {
                        this.f = NumberFormat.getInstance(Locale.US).format(b(jSONObjectC, "playback_count"));
                    } else {
                        this.f = "";
                    }
                    this.h = jSONObjectC.getBoolean("streamable");
                    if (this.h) {
                        this.g = a(jSONObjectC, "stream_url") + "?client_id=80d6d387aea9db3c540751ab3133876b";
                    }
                    this.i = a(jSONObjectC, "title");
                    this.j = a(jSONObjectC, "kind");
                }
                this.r.songId = this.a;
                this.r.b = this.g;
                this.r.artist = this.b;
                this.r.musicName = this.i;
                this.r.album_art = this.e;
                this.r.album = "Unknown";
                return;
            }
            if (str.equals("Playlist")) {
                jSONObject = (jSONObject.has("kind") && jSONObject.getString("kind").startsWith("playlist")) ? jSONObject : (jSONObject.has("type") && jSONObject.getString("type").startsWith("playlist")) ? c(jSONObject, "playlist") : null;
                if (jSONObject != null) {
                    JSONObject jSONObjectC3 = c(jSONObject, "user");
                    this.o = a(jSONObjectC3, "username");
                    this.p = a(jSONObjectC3, "avatar_url");
                    if (jSONObject.has("tracks")) {
                        this.k = jSONObject.getJSONArray("tracks");
                    }
                    this.l = String.valueOf(b(jSONObject, "track_count"));
                    this.m = a(jSONObject, "title");
                    this.n = a(jSONObject, this.k, this.p);
                    this.q = a(jSONObject, "uri");
                    return;
                }
                return;
            }
            if (str.equals("Genres")) {
                this.s = new ArrayList<>();
                JSONArray jSONArray = new JSONArray((Collection) d(jSONObject, "music"));
                JSONArray jSONArray2 = new JSONArray((Collection) d(jSONObject, "audio"));
                this.s.add("Music");
                for (int i = 1; i < jSONArray.length(); i++) {
                    this.s.add(jSONArray.getString(i).replace("%26", "&").replace("+", " "));
                }
                this.s.add("Audio");
                for (int i2 = 1; i2 < jSONArray2.length(); i2++) {
                    this.s.add(jSONArray2.getString(i2).replace("%26", "&").replace("+", " "));
                }
            }
        } catch (Exception e) {
        }
    }

    public String a(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return "";
            }
            return jSONObject.getString(str);
        } catch (JSONException e) {
            return "";
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

    public JSONObject c(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has(str) && !jSONObject.isNull(str)) {
                return jSONObject.getJSONObject(str);
            }
            return jSONObject2;
        } catch (JSONException e) {
            return jSONObject2;
        }
    }

    public ArrayList<String> d(JSONObject jSONObject, String str) {
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

    public String a(JSONObject jSONObject, JSONArray jSONArray, String str) {
        String strReplace = "";
        try {
            if (jSONObject.has("artwork_url")) {
                if (!jSONObject.getString("artwork_url").equals("null")) {
                    strReplace = jSONObject.getString("artwork_url");
                } else if (jSONArray == null || jSONArray.length() == 0 || !jSONArray.getJSONObject(0).has("artwork_url")) {
                    strReplace = str;
                } else if (!jSONArray.getJSONObject(0).getString("artwork_url").equals("null")) {
                    strReplace = jSONArray.getJSONObject(0).getString("artwork_url");
                } else if (jSONArray.getJSONObject(0).has("user")) {
                    strReplace = jSONArray.getJSONObject(0).getJSONObject("user").getString("avatar_url");
                }
            }
            if (strReplace.toLowerCase().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                strReplace = strReplace.toLowerCase().replace("-large", "-t500x500");
                return strReplace;
            }
            return strReplace;
        } catch (Exception e) {
            return strReplace;
        }
    }
}
