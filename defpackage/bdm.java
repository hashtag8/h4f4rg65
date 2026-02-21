package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import defpackage.age;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdm extends ajj implements age.a {
    private String a;
    public RelativeLayout am;
    protected bdj an;
    private int b;
    private ArrayList<String> c;
    private ArrayList<String> d;
    private ArrayList<String> e;
    private ArrayList<String> f;

    public void b(String str) {
        this.b = -16777216;
        this.a = str;
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.am = (RelativeLayout) p().findViewById(R.id.parent);
        this.b = this.ae.getResources().getColor(R.color.logoview_bg);
        if (ahh.e(this.ae)) {
            return super.a(layoutInflater, viewGroup, bundle);
        }
        Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
        return super.a(layoutInflater, viewGroup, bundle);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        super.c(bundle);
    }

    @Override // defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a().a(this.a).e(-16777216).a(this.b);
        if (!ahn.a()) {
            return aVarA.c();
        }
        ajj ajjVar = (ajj) u();
        if (ajjVar == null) {
            return aVarA.c();
        }
        return aVarA.c(true).k(R.drawable.search).a(ajjVar.b().p()).c();
    }

    public boolean a(bdg bdgVar) {
        if (this.c == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_tracks");
            this.c = (ArrayList) abwVar.a(aho.d("tidal_fav_tracks"), new adp<ArrayList<String>>() { // from class: bdm.1
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        return this.c.contains(bdgVar.c);
    }

    public void b(bdg bdgVar) {
        if (this.c == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_tracks");
            this.c = (ArrayList) abwVar.a(aho.d("tidal_fav_tracks"), new adp<ArrayList<String>>() { // from class: bdm.5
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        if (!this.c.contains(bdgVar.c)) {
            this.c.add(bdgVar.c);
            a(this.c);
        }
    }

    public void c(bdg bdgVar) {
        if (this.c == null) {
            this.c = (ArrayList) new abw().a(aho.d("tidal_fav_tracks"), new adp<ArrayList<String>>() { // from class: bdm.6
            }.b());
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
        }
        if (this.c.contains(bdgVar.c)) {
            this.c.remove(bdgVar.c);
            mm.b("FAV TRACK", "have removed " + bdgVar.c + " " + a(bdgVar));
            a(this.c);
            return;
        }
        mm.b("FAV TRACK", "Couldn't remove " + bdgVar.c);
    }

    public void a(ArrayList<String> arrayList) {
        this.c = arrayList;
        aho.a("tidal_fav_tracks", new abw().a(this.c));
    }

    public boolean a(bda bdaVar) {
        if (this.d == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_albums");
            this.d = (ArrayList) abwVar.a(aho.d("tidal_fav_albums"), new adp<ArrayList<String>>() { // from class: bdm.7
            }.b());
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
        }
        return this.d.contains(bdaVar.a);
    }

    public void b(bda bdaVar) {
        if (this.d == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_albums");
            this.d = (ArrayList) abwVar.a(aho.d("tidal_fav_albums"), new adp<ArrayList<String>>() { // from class: bdm.8
            }.b());
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
        }
        if (!this.d.contains(bdaVar.a)) {
            this.d.add(bdaVar.a);
            b(this.d);
        }
    }

    public void c(bda bdaVar) {
        if (this.d == null) {
            this.d = (ArrayList) new abw().a(aho.d("tidal_fav_albums"), new adp<ArrayList<String>>() { // from class: bdm.9
            }.b());
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
        }
        if (this.d.contains(bdaVar.a)) {
            this.d.remove(bdaVar.a);
            b(this.d);
        }
    }

    public void b(ArrayList<String> arrayList) {
        this.d = arrayList;
        aho.a("tidal_fav_albums", new abw().a(this.d));
    }

    public boolean a(bdb bdbVar) {
        if (this.e == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_artists");
            this.e = (ArrayList) abwVar.a(aho.d("tidal_fav_artists"), new adp<ArrayList<String>>() { // from class: bdm.10
            }.b());
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
        }
        return this.e.contains(bdbVar.b);
    }

    public void b(bdb bdbVar) {
        if (this.e == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_artists");
            this.e = (ArrayList) abwVar.a(aho.d("tidal_fav_artists"), new adp<ArrayList<String>>() { // from class: bdm.11
            }.b());
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
        }
        if (!this.e.contains(bdbVar.b)) {
            this.e.add(bdbVar.b);
            c(this.e);
        }
    }

    public void c(bdb bdbVar) {
        if (this.e == null) {
            this.e = (ArrayList) new abw().a(aho.d("tidal_fav_artists"), new adp<ArrayList<String>>() { // from class: bdm.12
            }.b());
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
        }
        if (this.e.contains(bdbVar.b)) {
            this.e.remove(bdbVar.b);
            c(this.e);
        }
    }

    public void c(ArrayList<String> arrayList) {
        this.e = arrayList;
        aho.a("tidal_fav_artists", new abw().a(this.e));
    }

    public boolean a(bdc bdcVar) {
        if (this.f == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_playlists");
            this.f = (ArrayList) abwVar.a(aho.d("tidal_fav_playlists"), new adp<ArrayList<String>>() { // from class: bdm.2
            }.b());
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
        }
        return this.f.contains(bdcVar.b);
    }

    public void b(bdc bdcVar) {
        if (this.f == null) {
            abw abwVar = new abw();
            aho.d("tidal_fav_playlists");
            this.f = (ArrayList) abwVar.a(aho.d("tidal_fav_playlists"), new adp<ArrayList<String>>() { // from class: bdm.3
            }.b());
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
        }
        if (!this.f.contains(bdcVar.b)) {
            this.f.add(bdcVar.b);
            d(this.f);
        }
    }

    public void c(bdc bdcVar) {
        if (this.f == null) {
            this.f = (ArrayList) new abw().a(aho.d("tidal_fav_playlists"), new adp<ArrayList<String>>() { // from class: bdm.4
            }.b());
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
        }
        if (this.f.contains(bdcVar.b)) {
            this.f.remove(bdcVar.b);
            d(this.f);
        }
    }

    public void d(ArrayList<String> arrayList) {
        this.f = arrayList;
        aho.a("tidal_fav_playlists", new abw().a(this.f));
    }

    public void a(TidalMusicDataLocal tidalMusicDataLocal) {
        if (p() != null) {
            if (!tidalMusicDataLocal.a) {
                Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
            } else if (!tidalMusicDataLocal.b) {
                Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
            } else {
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(tidalMusicDataLocal);
            }
        }
    }

    public void a(List<bdg> list, bdj bdjVar, int i) {
        if (p() != null) {
            p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            List<MusicData> listA = bdh.a(list);
            MusicPlaylistManager.a().h();
            if (i < 0) {
                MusicPlaylistManager.a().a(listA, bdjVar);
            } else {
                MusicPlaylistManager.a().a(listA, i, bdjVar);
            }
        }
    }

    public void b(TidalMusicDataLocal tidalMusicDataLocal) {
        if (!tidalMusicDataLocal.a) {
            Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
        } else if (!tidalMusicDataLocal.b) {
            Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
        } else {
            p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().c(tidalMusicDataLocal);
        }
    }

    public void c(TidalMusicDataLocal tidalMusicDataLocal) {
        if (!tidalMusicDataLocal.a) {
            Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
        } else if (!tidalMusicDataLocal.b) {
            Toast.makeText(p(), q().getString(R.string.TidalTrackUnavailable), 0).show();
        } else {
            p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().d(tidalMusicDataLocal);
        }
    }

    public void d(TidalMusicDataLocal tidalMusicDataLocal) {
        MusicPlaylistManager.a().g();
        c(tidalMusicDataLocal);
    }

    public void a(List<bdg> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().c(bdh.a(list));
    }

    public void b(List<bdg> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().e(bdh.a(list));
    }

    public void c(List<bdg> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().a(bdh.a(list));
    }

    public void a(List<bdg> list, int i) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().a(bdh.a(list), i);
    }

    public void d(List<bdg> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().d(bdh.a(list));
    }

    public void e(List<bdg> list) {
        MusicPlaylistManager.a().g();
        d(list);
    }

    public void a(int i, List<MusicData> list, JSONObject jSONObject) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().a(list, this.an);
    }

    @Override // age.a
    public void a(ErrorInfo errorInfo) {
    }
}
