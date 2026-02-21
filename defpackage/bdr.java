package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajv;
import defpackage.bdh;

/* JADX INFO: loaded from: classes.dex */
public class bdr extends bdu {
    private bdd aj;
    private ImageView ak;
    private TextView al;
    private ajn ar = new ajn() { // from class: bdr.5
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (view.getTag(R.id.view_tag_callback_item) != null) {
                bdr.this.ai.a(view, i, obj);
            } else if (aof.a().l() && !ain.j) {
                Toast.makeText(bdr.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                bdr.this.b(bdr.this.e);
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
    }

    @Override // defpackage.bdu, defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.tidal_genres, (ViewGroup) null);
        this.ah = layoutInflater;
        super.c(layoutInflater, viewGroup, bundle);
        ((TextView) this.a.findViewById(R.id.more_playlists)).setOnClickListener(new View.OnClickListener() { // from class: bdr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bds bdsVar = new bds();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("genre", bdr.this.aj);
                bdsVar.g(bundle2);
                if (!ahn.a()) {
                    bdr.this.ae.q().a(bdsVar, (arc) null);
                } else {
                    bdr.this.ae.q().a(bdsVar, new arc().c(R.id.menu_container));
                }
            }
        });
        ((TextView) this.a.findViewById(R.id.more_albums)).setOnClickListener(new View.OnClickListener() { // from class: bdr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bdq bdqVar = new bdq();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("genre", bdr.this.aj);
                bdqVar.g(bundle2);
                if (!ahn.a()) {
                    bdr.this.ae.q().a(bdqVar, (arc) null);
                } else {
                    bdr.this.ae.q().a(bdqVar, new arc().c(R.id.menu_container));
                }
            }
        });
        ((TextView) this.a.findViewById(R.id.more_tracks)).setOnClickListener(new View.OnClickListener() { // from class: bdr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bdt bdtVar = new bdt();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("genre", bdr.this.aj);
                bdtVar.g(bundle2);
                if (!ahn.a()) {
                    bdr.this.ae.q().a(bdtVar, (arc) null);
                } else {
                    bdr.this.ae.q().a(bdtVar, new arc().c(R.id.menu_container));
                }
            }
        });
        this.ak = (ImageView) this.a.findViewById(R.id.iv);
        this.ak.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: bdr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(bdr.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else {
                    bdr.this.b(bdr.this.e);
                }
            }
        });
        this.i.a(this.ar);
        this.ak.setOnTouchListener(this.i);
        this.al = (TextView) this.a.findViewById(R.id.cover_title);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.a;
    }

    @Override // defpackage.bdn, defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            try {
                b(q().getString(R.string.TidalGenres));
            } catch (Exception e) {
            }
        }
    }

    @Override // defpackage.bdn
    void c() {
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.aj = (bdd) bundle.getSerializable("genre");
        this.al.setText(this.aj.a);
        this.al.setTypeface(bcw.a(this.ae));
        bif.a((Context) this.ae).a("http://resources.wimpmusic.com/images/" + this.aj.b + "/400x266.jpg").a((bir) new bcs(this.aj.c)).a(R.drawable.tidal_placeholder_300x225).a(this.ak);
        bdh.a().a(bdh.a.GenrePlaylists, this, this.aj.c, "playlists");
        bdh.a().a(bdh.a.GenreTracks, this, this.aj.c, "tracks");
        bdh.a().a(bdh.a.GenreAlbums, this, this.aj.c, "albums");
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.aj.a).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdu
    bdh.a ao() {
        return bdh.a.GenreAlbums;
    }

    @Override // defpackage.bdu
    bdh.a ap() {
        return bdh.a.GenrePlaylists;
    }

    @Override // defpackage.bdu
    bdh.a aq() {
        return bdh.a.GenreTracks;
    }
}
