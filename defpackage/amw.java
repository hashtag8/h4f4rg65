package defpackage;

import android.os.Bundle;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import defpackage.ajv;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amw extends ajj {
    private ArrayList<Long> c;
    private anx b = null;
    protected anv a = new anv(this);

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.b != null) {
            this.b.a(this);
        }
    }

    public void a(anx anxVar) {
        this.b = anxVar;
    }

    @Override // defpackage.ajj
    public ajv b() {
        if (!ahn.a()) {
            return new ajv.a().c();
        }
        return new ajv.a().c(true).a(((ajj) u()).b().p()).c();
    }

    public boolean a(MusicData musicData) {
        if (this.c == null) {
            this.c = (ArrayList) new abw().a(aho.d("qobuz_fav_tracks"), new adp<ArrayList<Long>>() { // from class: amw.1
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        return this.c.contains(Long.valueOf(musicData.songId));
    }

    public void b(MusicData musicData) {
        if (this.c == null) {
            this.c = (ArrayList) new abw().a(aho.d("qobuz_fav_tracks"), new adp<ArrayList<Long>>() { // from class: amw.2
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        if (!this.c.contains(Long.valueOf(musicData.songId))) {
            this.c.add(Long.valueOf(musicData.songId));
            a(this.c);
        }
    }

    public void c(MusicData musicData) {
        if (this.c == null) {
            this.c = (ArrayList) new abw().a(aho.d("qobuz_fav_tracks"), new adp<ArrayList<Long>>() { // from class: amw.3
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        if (this.c.contains(Long.valueOf(musicData.songId))) {
            this.c.remove(Long.valueOf(musicData.songId));
            mm.b("FAV TRACK", "have removed " + musicData.songId + " " + a(musicData));
            a(this.c);
            return;
        }
        mm.b("FAV TRACK", "Couldn't remove " + musicData.songId);
    }

    public void a(ArrayList<Long> arrayList) {
        this.c = arrayList;
        aho.a("qobuz_fav_tracks", new abw().a(this.c));
    }

    protected void d(MusicData musicData) {
        this.a.a("http://www.qobuz.com/api.json/0.2/favorite/create?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&track_ids=" + musicData.songId, new a(musicData, true));
    }

    protected void e(MusicData musicData) {
        this.a.a("http://www.qobuz.com/api.json/0.2/favorite/delete?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&track_ids=" + musicData.songId, new a(musicData, false));
    }

    class a implements anu<JSONObject> {
        MusicData a;
        boolean b;

        public a(MusicData musicData, boolean z) {
            this.a = null;
            this.a = musicData;
            this.b = z;
        }

        @Override // defpackage.anu
        public void a(JSONObject jSONObject) {
            Toast.makeText(amw.this.ae, jSONObject.optString("status"), 1).show();
            if (this.b) {
                amw.this.b(this.a);
            } else {
                amw.this.c(this.a);
            }
        }

        @Override // defpackage.anu
        public void b(String str) {
            Toast.makeText(amw.this.ae, amw.this.a(R.string.kQobuz_RequestError_Str), 1).show();
        }

        @Override // defpackage.anu
        public void c() {
        }
    }
}
