package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class any {
    public static ArrayList<PlayListInfo> a(JSONObject jSONObject) {
        ArrayList<PlayListInfo> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("playlists").optJSONArray("items");
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            PlayListInfo playListInfo = new PlayListInfo();
            playListInfo.a = jSONObjectOptJSONObject.optString("id");
            playListInfo.b = jSONObjectOptJSONObject.optString("name");
            playListInfo.c = jSONObjectOptJSONObject.optInt("tracks_count");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("owner");
            if (jSONObjectOptJSONObject2 != null) {
                playListInfo.e = jSONObjectOptJSONObject2.optString("name");
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("images150");
            if (jSONArrayOptJSONArray2 != null) {
                playListInfo.g = jSONArrayOptJSONArray2.optString(0);
                playListInfo.h = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    playListInfo.h.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            playListInfo.f = jSONObjectOptJSONObject.optLong("duration");
            arrayList.add(playListInfo);
        }
        return arrayList;
    }

    public static ArrayList<QobuzMusicData> b(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        Long lValueOf = null;
        ArrayList<QobuzMusicData> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("tracks").optJSONArray("items");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("image");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("artist");
        boolean z = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null) ? false : true;
        if (z) {
            strOptString3 = jSONObject.optString("title");
            strOptString2 = jSONObjectOptJSONObject.optString("large");
            strOptString = jSONObjectOptJSONObject2.optString("name");
            lValueOf = Long.valueOf(jSONObjectOptJSONObject2.optLong("id"));
        } else {
            strOptString = null;
            strOptString2 = null;
            strOptString3 = null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
            QobuzMusicData qobuzMusicData = new QobuzMusicData();
            qobuzMusicData.songId = jSONObjectOptJSONObject3.optInt("id");
            qobuzMusicData.musicName = jSONObjectOptJSONObject3.optString("title");
            qobuzMusicData.a = jSONObjectOptJSONObject3.optInt("duration");
            qobuzMusicData.duration = jSONObjectOptJSONObject3.optInt("duration") * 1000;
            qobuzMusicData.b = jSONObjectOptJSONObject3.optInt("track_number");
            qobuzMusicData.f = jSONObjectOptJSONObject3.optBoolean("hires");
            qobuzMusicData.a(jSONObjectOptJSONObject3.optBoolean("streamable"));
            qobuzMusicData.isLegal = qobuzMusicData.a();
            qobuzMusicData.g = jSONObjectOptJSONObject3.optString("maximum_sampling_rate");
            qobuzMusicData.h = jSONObjectOptJSONObject3.optInt("maximum_bit_depth");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("album");
            if (jSONObjectOptJSONObject4 != null) {
                qobuzMusicData.album = jSONObjectOptJSONObject4.optString("title");
                qobuzMusicData.album_art = jSONObjectOptJSONObject4.optJSONObject("image").optString("large");
                qobuzMusicData.artist = jSONObjectOptJSONObject4.optJSONObject("artist").optString("name");
                qobuzMusicData.artist_id = jSONObjectOptJSONObject4.optJSONObject("artist").optLong("id");
                qobuzMusicData.e = jSONObjectOptJSONObject4.optJSONObject("genre").optString("name");
            } else if (z) {
                qobuzMusicData.album = strOptString3;
                qobuzMusicData.album_art = strOptString2;
                qobuzMusicData.artist = strOptString;
                qobuzMusicData.artist_id = lValueOf.longValue();
            }
            arrayList.add(qobuzMusicData);
        }
        return arrayList;
    }

    public static ArrayList<MusicData> c(JSONObject jSONObject) {
        ArrayList<MusicData> arrayList = new ArrayList<>();
        arrayList.addAll(b(jSONObject));
        return arrayList;
    }

    public static ArrayList<AlbumsInfo> d(JSONObject jSONObject) {
        ArrayList<AlbumsInfo> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            AlbumsInfo albumsInfo = new AlbumsInfo();
            albumsInfo.a = jSONObjectOptJSONObject.optString("id");
            albumsInfo.f = jSONObjectOptJSONObject.optInt("tracks_count");
            albumsInfo.g = jSONObjectOptJSONObject.optInt("media_count");
            albumsInfo.b = jSONObjectOptJSONObject.optString("title");
            albumsInfo.d = jSONObjectOptJSONObject.optLong("released_at");
            albumsInfo.i = jSONObjectOptJSONObject.optJSONObject("genre").optString("name");
            albumsInfo.e = jSONObjectOptJSONObject.optJSONObject("image").optString("large");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("artist");
            if (jSONObjectOptJSONObject2.optString("name") != null) {
                albumsInfo.c = jSONObjectOptJSONObject2.optString("name");
                if ("null".compareTo(albumsInfo.c) == 0) {
                    albumsInfo.c = "";
                }
            }
            if (jSONObjectOptJSONObject.optJSONArray("awards") != null) {
                albumsInfo.k = jSONObjectOptJSONObject.optJSONArray("awards").optJSONObject(0).optString("name");
            }
            albumsInfo.j = jSONObjectOptJSONObject.optBoolean("hires");
            albumsInfo.h = jSONObjectOptJSONObject.optInt("duration");
            arrayList.add(albumsInfo);
        }
        return arrayList;
    }

    public static ArrayList<String> e(JSONObject jSONObject) {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optJSONObject(i).optString("id"));
            }
        }
        return arrayList;
    }
}
