package defpackage;

import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azm extends azi {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        this.c = a(jSONObject, "name");
        this.f = a(jSONObject, "artist");
        this.a = a(jSONObject, "icon");
        this.b = a(jSONObject, "shortUrl");
        this.d = a(jSONObject, "key");
        this.g = a(jSONObject, "album");
        this.h = b(jSONObject, "duration");
        this.e = this.d;
    }

    public void a(String str) {
        this.e = str;
    }

    @Override // defpackage.azi
    public String a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.f;
    }

    public long d() {
        return this.h;
    }

    public RdioMusicData e() {
        RdioMusicData rdioMusicData = new RdioMusicData(this.d, this.e, this.h);
        rdioMusicData.musicName = this.c;
        rdioMusicData.album = this.g;
        rdioMusicData.album_art = this.a;
        rdioMusicData.genre = "";
        rdioMusicData.artist = this.f;
        return rdioMusicData;
    }
}
