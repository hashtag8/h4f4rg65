package defpackage;

import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import defpackage.azb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayw {
    private static ayw e = null;
    private static HashMap<String, Class<? extends azi>> f = new HashMap<String, Class<? extends azi>>() { // from class: ayw.1
        {
            put("a", azf.class);
            put("t", azm.class);
            put("p", azj.class);
            put("r", azg.class);
            put("ad", aze.class);
            put("rr", azk.class);
            put("ar", azk.class);
            put("ar", azk.class);
            put("ap", azk.class);
            put("gr", azk.class);
            put("h", azk.class);
            put("e", azk.class);
            put("lr", azk.class);
            put("pr", azk.class);
            put("sr", azk.class);
            put("tp", azk.class);
            put("c", azk.class);
        }
    };
    String a = "TODO";
    String b = "TODO";
    String c = "TODO";
    Boolean d = false;

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public Boolean b() {
        return this.d;
    }

    public void a(Boolean bool) {
        this.d = bool;
    }

    private ayw() {
    }

    public static ayw c() {
        if (e == null) {
            e = new ayw();
        }
        return e;
    }

    public boolean d() {
        return azs.ak;
    }

    public Map<String, String> e() {
        HashMap map = new HashMap();
        if (!d()) {
            return null;
        }
        map.put("extras", "[{\"field\":\"isSubscriber\"}]");
        map.put("method", "currentUser");
        return map;
    }

    public Map<String, String> f() {
        HashMap map = new HashMap();
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"rectangleImageUrl\",\"extras\":[\"*.WEB\",\"*.WEB\"]},{\"field\":\"contentTypes\",\"extras\":[\"*.WEB\",\"*.WEB\"]},{\"field\":\"contents\",\"count\":4,\"extras\":[{\"field\":\"*.WEB\"},{\"field\":\"*.WEB\"},{\"field\":\"*\",\"exclude\":true},{\"field\":\"content\",\"extras\":[{\"field\":\"*.WEB\"},{\"field\":\"*.WEB\"},{\"field\":\"*\",\"exclude\":true},{\"field\":\"url\",\"extras\":[\"*.WEB\",\"*.WEB\"]},{\"field\":\"name\",\"extras\":[\"*.WEB\",\"*.WEB\"]}]}]}]");
        map.put("method", "getTopics");
        return map;
    }

    public Map<String, String> a(aza azaVar, String str, int i, int i2) {
        HashMap map = new HashMap();
        map.put("query", str);
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"location\",\"extras\":[\"*.WEB\"]},{\"field\":\"username\",\"extras\":[\"*.WEB\"]},{\"field\":\"stations\",\"extras\":[\"*.WEB\"]},{\"field\":\"description\",\"extras\":[\"*.WEB\"]},{\"field\":\"icon250x375\",\"extras\":[\"*.WEB\"]},{\"field\":\"icon500x750\",\"extras\":[\"*.WEB\"]},{\"field\":\"icon250x333\",\"extras\":[\"*.WEB\"]},{\"field\":\"icon500x667\",\"extras\":[\"*.WEB\"]},{\"field\":\"series\",\"extras\":[\"*.WEB\",\"-*\",\"url\",\"name\"]},{\"field\":\"Artist.albumCount\",\"extras\":[\"*.WEB\"]},{\"field\":\"Artist.length\",\"extras\":[\"*.WEB\"]},{\"field\":\"Artist.avatarIcon\",\"extras\":[\"*.WEB\"]}, {\"field\":\"albumCount\"},  {\"field\":\"trackKeys\"}]");
        map.put("types", azaVar.a());
        map.put("method", "search");
        return map;
    }

    public Map<String, String> a(ayx ayxVar, ayy ayyVar, int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("type", ayxVar.a());
        switch (ayxVar) {
            case EContentTypeArtist:
                map.put("extras", "[{\"field\":\"albumCount\"}, {\"field\":\"*.WEB\"}]");
                break;
            case EContentTypePlaylist:
                map.put("extras", "[{\"field\":\"trackKeys\"}]");
                break;
            case EContentTypeStation:
                map.put("extras", "[{\"field\":\"artists\",\"extras\":[\"-*\",\"name\"]},{\"field\":\"description\"}]");
                break;
        }
        if (ayyVar == ayy.EFollowTypeUser) {
            map.put("user", this.a);
            map.put("friends", "true");
        }
        map.put("method", "getHeavyRotation");
        return map;
    }

    public Map<String, String> a(int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"trackKeys\"},{\"field\":\"albumCount\"},{\"field\":\"length\"},{\"field\":\"artists\",\"extras\":[\"*.WEB\",\"-*\",\"name\",\"url\"]}]");
        map.put("user", this.a);
        map.put("method", "getFavorites");
        return map;
    }

    public Map<String, String> b(int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"trackKeys\"},{\"field\":\"artists\",\"extras\":[\"*.WEB\",\"-*\",\"name\",\"url\"]}]");
        map.put("user", this.a);
        map.put("method", "getPlaylists");
        return map;
    }

    public Map<String, String> a(ayz ayzVar, int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"artists\",\"extras\":[\"*.WEB\",\"-*\",\"name\",\"url\"]}]");
        map.put("time", ayzVar.a());
        map.put("user", this.a);
        map.put("method", "getNewReleases");
        return map;
    }

    public Map<String, String> a(String str, int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("artist", str);
        map.put("user", this.a);
        map.put("method", "getAlbumsForArtist");
        return map;
    }

    public Map<String, String> a(ArrayList<String> arrayList, int i, int i2) {
        if (arrayList.size() - i <= i2) {
            i2 = arrayList.size() - i;
        }
        return a(new ArrayList<>(arrayList.subList(i, i + i2)));
    }

    public Map<String, String> a(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arrayList.get(0));
        arrayList.remove(0);
        for (String str : arrayList) {
            sb.append(", ");
            sb.append(str);
        }
        HashMap map = new HashMap();
        map.put("keys", sb.toString());
        map.put("user", this.a);
        map.put("method", "get");
        return map;
    }

    public Map<String, String> b(String str) {
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("extras", "[{\"field\":\"*.WEB\"},{\"field\":\"contents\",\"extras\":[{\"field\":\"*.WEB\"},{\"field\":\"content\",\"extras\":[{\"field\":\"*.WEB\"},{\"field\":\"artists\",\"extras\":[\"*.WEB\",\"-*\",\"name\",\"url\"]},{\"field\":\"tracks\",\"exclude\":true},{\"field\":\"length\",\"exclude\":true},{\"field\":\"count\",\"exclude\":true}]}]}]");
        map.put("user", this.a);
        map.put("method", "getObjectFromUrl");
        return map;
    }

    public Map<String, String> b(String str, int i, int i2) {
        HashMap map = new HashMap();
        map.put("count", "" + i2);
        map.put("start", "" + i);
        map.put("extras", "[{\"field\":\"artists\",\"extras\":[\"-*\",\"name\"]},{\"field\":\"description\"},{\"field\":\"trackKeys\"}, {\"field\":\"tracks\"}]");
        map.put("station_key", str);
        map.put("user", this.a);
        map.put("method", "generateStation");
        return map;
    }

    public Map<String, String> a(String str, RdioMusicData rdioMusicData) {
        HashMap map = new HashMap();
        map.put("key", str);
        map.put("manualPlay", "true");
        map.put("playerName", this.b);
        map.put("requiresUnlimited", "true");
        map.put("finishedAd", "false");
        map.put("user", this.a);
        map.put("sourceKey", rdioMusicData.b());
        map.put("type", "aac-high,mp3-high");
        map.put("method", "getPlaybackInfo");
        map.put("client_id", "wvr7o7tSFkQf6zNgw2D56Q");
        map.put("v", "20141119");
        return map;
    }

    public Map<String, String> a(RdioMusicData rdioMusicData) {
        HashMap map = new HashMap();
        map.put("key", rdioMusicData.a());
        map.put("source", rdioMusicData.b());
        map.put("method", "addStartEvent");
        return map;
    }

    public Map<String, String> b(RdioMusicData rdioMusicData) {
        HashMap map = new HashMap();
        map.put("time", "30");
        map.put("txid", rdioMusicData.c());
        map.put("method", "addTimedPlayInformation");
        return map;
    }

    public Map<String, String> a(RdioMusicData rdioMusicData, long j) {
        HashMap map = new HashMap();
        map.put("time", "" + j);
        map.put("txid", rdioMusicData.c());
        map.put("method", "addPauseEvent");
        return map;
    }

    public Map<String, String> b(RdioMusicData rdioMusicData, long j) {
        HashMap map = new HashMap();
        map.put("time", "" + j);
        map.put("txid", rdioMusicData.c());
        map.put("method", "addResumeEvent");
        return map;
    }

    public Map<String, String> c(RdioMusicData rdioMusicData, long j) {
        HashMap map = new HashMap();
        map.put("time", "" + j);
        map.put("txid", rdioMusicData.c());
        map.put("method", "addSongSkippedTime");
        return map;
    }

    public Map<String, String> c(RdioMusicData rdioMusicData) {
        HashMap map = new HashMap();
        map.put("txid", rdioMusicData.c());
        map.put("method", "addFinishEvent");
        return map;
    }

    public void a(Map<String, String> map, azb.a aVar) {
        mm.b("params %s", map);
        azb azbVar = new azb();
        map.put("v", "20141119");
        azbVar.a(map);
        azbVar.a(aVar);
        azbVar.execute("/api/1");
    }

    public static JSONObject c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                return jSONObject.getJSONObject("result");
            } catch (JSONException e2) {
                return jSONObject;
            }
        } catch (JSONException e3) {
            return null;
        }
    }

    public static ArrayList<azi> a(JSONArray jSONArray, String str) {
        azi aziVarNewInstance;
        Class<? extends azi> cls;
        ArrayList<azi> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.has("type") || jSONObject.isNull("type") || (cls = f.get(jSONObject.getString("type"))) == null) {
                    aziVarNewInstance = null;
                } else {
                    aziVarNewInstance = cls.newInstance();
                    aziVarNewInstance.a(jSONObject);
                    if ((aziVarNewInstance instanceof azm) && str != "") {
                        ((azm) aziVarNewInstance).a(str);
                    }
                }
                if (aziVarNewInstance != null) {
                    arrayList.add(aziVarNewInstance);
                }
            } catch (Exception e2) {
                mm.b("RdioClient", "Whelp.");
            }
        }
        return arrayList;
    }

    public static ArrayList<azi> a(JSONArray jSONArray) {
        return a(jSONArray, "");
    }

    public static ArrayList<azh> b(JSONArray jSONArray) {
        ArrayList<azh> arrayList = new ArrayList<>();
        if (arrayList == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                azh azhVar = new azh();
                azhVar.a(jSONObject);
                arrayList.add(azhVar);
            } catch (Exception e2) {
            }
        }
        return arrayList;
    }
}
