package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.musicservice.musicserver.deezer.DeezerStationMusicData;
import defpackage.als;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alr {
    private String b;
    private als.a c;
    private aum d = new aum() { // from class: alr.2
        @Override // defpackage.aum
        public void a(int i, Header[] headerArr, final JSONObject jSONObject) {
            MusicData musicDataA;
            mm.b(alr.this.b, new Object[0]);
            mm.b(jSONObject, new Object[0]);
            List<akm> listA = new qv(akm.class).a(jSONObject.toString());
            if (listA == null || listA.isEmpty()) {
                if (alr.this.c != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: alr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            alr.this.c.a(jSONObject);
                        }
                    });
                    return;
                }
                return;
            }
            for (akm akmVar : listA) {
                if (akmVar.f() && (musicDataA = als.a(akmVar)) != null) {
                    musicDataA.type = 14;
                    alr.this.a.a(musicDataA);
                }
            }
            MusicPlaylistManager.a().a(alr.this.a);
            if (alr.this.c != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: alr.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        alr.this.c.a();
                    }
                });
            }
        }

        @Override // defpackage.aum
        public void a(int i, Header[] headerArr, Throwable th, final JSONObject jSONObject) {
            if (alr.this.c != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: alr.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        alr.this.c.a(jSONObject);
                    }
                });
            }
        }
    };
    private DeezerStationMusicData a = new DeezerStationMusicData(new Runnable() { // from class: alr.1
        @Override // java.lang.Runnable
        public void run() {
            alr.this.a();
        }
    });

    public alr(als.a aVar, String str) {
        this.c = aVar;
        this.b = str;
    }

    public void a() {
        agv.a(true).a(this.b, this.d);
    }
}
