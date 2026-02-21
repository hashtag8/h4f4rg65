package defpackage;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdg implements Serializable {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public String l;

    public String toString() {
        return "TidalTrack{mArtistName='" + this.a + "', mArtistId='" + this.b + "', mTrackId='" + this.c + "', mTitle='" + this.d + "', mUrl='" + this.e + "', mDuration=" + this.f + ", mAlbumId='" + this.g + "', mAlbumTitle='" + this.h + "', mAlbumCover='" + this.i + "', mAllowStreaming=" + this.j + ", mStreamReady=" + this.k + ", mStreamStartDate='" + this.l + "'}";
    }

    public static bdg a(JSONObject jSONObject) {
        bdg bdgVar;
        JSONException e;
        try {
            bdgVar = new bdg();
        } catch (JSONException e2) {
            bdgVar = null;
            e = e2;
        }
        try {
            bdgVar.c = "" + jSONObject.getInt("id");
            bdgVar.d = jSONObject.getString("title");
            bdgVar.e = jSONObject.getString("url");
            bdgVar.f = jSONObject.getInt("duration");
            bdgVar.j = jSONObject.getBoolean("allowStreaming");
            bdgVar.k = jSONObject.getBoolean("streamReady");
            bdgVar.l = jSONObject.getString("streamStartDate");
            if (jSONObject.has("artist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("artist");
                bdgVar.a = jSONObject2.getString("name");
                bdgVar.b = "" + jSONObject2.getInt("id");
            }
            if (jSONObject.has("album")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("album");
                bdgVar.h = jSONObject3.getString("title");
                bdgVar.g = "" + jSONObject3.getInt("id");
                bdgVar.i = jSONObject3.getString("cover");
            }
        } catch (JSONException e3) {
            e = e3;
            new ml().a("Failed to convert JSONObject to TidalTrack", e);
        }
        return bdgVar;
    }
}
