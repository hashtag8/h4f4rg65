package defpackage;

import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import defpackage.azb;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayu implements azb.a {
    private static ayu a;
    private String b = "";
    private RdioMusicData c;

    public static ayu a() {
        if (a == null) {
            a = new ayu();
        }
        return a;
    }

    public RdioMusicData b() {
        return this.c;
    }

    public void a(RdioMusicData rdioMusicData) {
        this.c = rdioMusicData;
    }

    @Override // azb.a
    public void a(boolean z, String str) {
        if (z) {
            JSONObject jSONObjectC = ayw.c(str);
            try {
                if (jSONObjectC.has("txid")) {
                    this.b = jSONObjectC.getString("txid");
                    this.c.a(this.b);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
