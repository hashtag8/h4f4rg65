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
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class axj extends ajj {
    private ArrayList<String> a;
    private ArrayList<String> b;
    public RelativeLayout c;
    public View d = null;
    public ArrayList<adz> e = null;
    public final int f = 0;
    protected boolean g = false;
    private arc h = new arc().c(R.id.menu_container);

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = (RelativeLayout) ((DashboardActivity) p()).findViewById(R.id.parent);
        this.g = l().getBoolean("DISCOVER_PARENT", false);
        if (ahh.e(this.ae)) {
            return super.a(layoutInflater, viewGroup, bundle);
        }
        Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
        return super.a(layoutInflater, viewGroup, bundle);
    }

    protected void a(axj axjVar) {
        this.ae.q().a(axjVar, ahn.a() ? this.h : null);
    }

    public JukeMusicDataLocal a(axb axbVar) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return null;
        }
        aff.b = 2004;
        return awp.a(axbVar);
    }

    public void a(List<axb> list, axe axeVar, int i) {
        if (p() != null) {
            p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            List<MusicData> listA = awp.a(list);
            MusicPlaylistManager.a().g();
            MusicPlaylistManager.a().a(listA, i, axeVar);
        }
    }

    public void a(JukeMusicDataLocal jukeMusicDataLocal) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        aff.b = 2004;
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().a(jukeMusicDataLocal);
    }

    public void a(List<MusicData> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().a(list);
    }

    public void b(JukeMusicDataLocal jukeMusicDataLocal) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().c(jukeMusicDataLocal);
    }

    public void c(JukeMusicDataLocal jukeMusicDataLocal) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().d(jukeMusicDataLocal);
    }

    public void b(List<MusicData> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().c(list);
    }

    public void c(List<MusicData> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().e(list);
    }

    public void a(List<MusicData> list, int i) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().a(list, i);
    }

    public void d(List<MusicData> list) {
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().d(list);
    }

    public void d(JukeMusicDataLocal jukeMusicDataLocal) {
        MusicPlaylistManager.a().g();
        c(jukeMusicDataLocal);
    }

    public void e(List<MusicData> list) {
        MusicPlaylistManager.a().g();
        p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
        MusicPlaylistManager.a().b(list);
    }

    public boolean b(axb axbVar) {
        if (this.a == null) {
            abw abwVar = new abw();
            aho.d("juke_fav_tracks");
            this.a = (ArrayList) abwVar.a(aho.d("juke_fav_tracks"), new adp<ArrayList<String>>() { // from class: axj.1
            }.b());
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
        }
        return this.a.contains(axbVar.a);
    }

    public void c(axb axbVar) {
        if (this.a == null) {
            abw abwVar = new abw();
            aho.d("juke_fav_tracks");
            this.a = (ArrayList) abwVar.a(aho.d("juke_fav_tracks"), new adp<ArrayList<String>>() { // from class: axj.2
            }.b());
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
        }
        if (!this.a.contains(axbVar.a)) {
            this.a.add(axbVar.a);
            a(this.a);
        }
    }

    public void d(axb axbVar) {
        if (this.a == null) {
            this.a = (ArrayList) new abw().a(aho.d("juke_fav_tracks"), new adp<ArrayList<String>>() { // from class: axj.3
            }.b());
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
        }
        if (this.a.contains(axbVar.a)) {
            this.a.remove(axbVar.a);
            a(this.a);
        } else {
            mm.b("FAV TRACK", "Couldn't remove " + axbVar.a);
        }
    }

    public void a(ArrayList<String> arrayList) {
        this.a = arrayList;
        aho.a("juke_fav_tracks", new abw().a(this.a));
    }

    public boolean a(aww awwVar) {
        if (this.b == null) {
            abw abwVar = new abw();
            aho.d("juke_fav_albums");
            this.b = (ArrayList) abwVar.a(aho.d("juke_fav_albums"), new adp<ArrayList<String>>() { // from class: axj.4
            }.b());
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
        }
        return this.b.contains(awwVar.a);
    }

    public void b(aww awwVar) {
        if (this.b == null) {
            abw abwVar = new abw();
            aho.d("juke_fav_albums");
            this.b = (ArrayList) abwVar.a(aho.d("juke_fav_albums"), new adp<ArrayList<String>>() { // from class: axj.5
            }.b());
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
        }
        if (!this.b.contains(awwVar.a)) {
            this.b.add(awwVar.a);
            b(this.b);
        }
    }

    public void c(aww awwVar) {
        if (this.b == null) {
            this.b = (ArrayList) new abw().a(aho.d("juke_fav_albums"), new adp<ArrayList<String>>() { // from class: axj.6
            }.b());
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
        }
        if (this.b.contains(awwVar.a)) {
            this.b.remove(awwVar.a);
            b(this.b);
        }
    }

    public void b(ArrayList<String> arrayList) {
        this.b = arrayList;
        aho.a("juke_fav_albums", new abw().a(this.b));
    }

    @Override // defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(-16777216).j(R.color.logoview_bg);
        if (!ahn.a()) {
            aVar.h(R.drawable.juke_nav_logo);
            return aVar.c();
        }
        ajj ajjVar = (ajj) u();
        if (ajjVar == null || this.g) {
            return aVar.c();
        }
        return aVar.c(true).k(R.drawable.search).a(ajjVar.b().p()).c();
    }
}
