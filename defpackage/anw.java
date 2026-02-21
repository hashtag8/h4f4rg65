package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import defpackage.age;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anw extends age {
    private aue a;
    private List<MusicData> b;
    private String c;
    private boolean d;

    public anw(String str, boolean z) {
        super(str);
        this.b = new ArrayList();
        this.a = agv.a(true);
        this.c = str;
        this.d = z;
    }

    @Override // defpackage.age
    protected void b(final int i, int i2, final age.a aVar) {
        String str;
        String strTrim = aho.d("qobuz_user_auth_token").trim();
        if (this.d) {
            str = "http://www.qobuz.com/api.json/0.2/playlist/get?extra=tracks%2Csubscribers&limit=1000000&offset=0&app_id=394304373&user_auth_token=" + strTrim + "&playlist_id=" + this.c + "&limit=" + i2 + "&offset=" + i;
        } else {
            str = "http://www.qobuz.com/api.json/0.2/playlist/get?app_id=394304373&playlist_id=" + c() + "&extra=tracks&user_auth_token=" + strTrim + "&limit=" + i2 + "&offset=" + i;
        }
        this.a.a(str, new aum() { // from class: anw.1
            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONObject jSONObject) {
                super.a(i3, headerArr, jSONObject);
                ArrayList<MusicData> arrayListC = any.c(jSONObject);
                for (int i4 = 0; i4 < arrayListC.size(); i4++) {
                    anw.this.d().put(Integer.valueOf(i + i4), arrayListC.get(i4));
                }
                anw.this.b.addAll(arrayListC);
                aVar.a(i, arrayListC, jSONObject);
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                super.a(i3, headerArr, th, jSONObject);
                ErrorInfo errorInfoA = null;
                if (jSONObject != null) {
                    errorInfoA = new ErrorInfo.a().a(i3).a(jSONObject.optString("message", "")).a();
                }
                aVar.a(errorInfoA);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i3, Header[] headerArr, String str2, Throwable th) {
                super.a(i3, headerArr, str2, th);
                aVar.a(null);
            }
        });
    }

    public List<MusicData> e() {
        return this.b;
    }
}
