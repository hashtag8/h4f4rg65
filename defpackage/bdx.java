package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.aih;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdx extends bdn implements bdi.b {
    private View e;
    private aih<bdd> f;
    private AnimationGridView h;
    private ArrayList<bdd> g = new ArrayList<>();
    private final int i = 100;
    private int ah = 1;
    ArrayList<bdg> a = new ArrayList<>();
    final int b = 0;
    final int c = 1;
    int d = 0;
    private ajn ai = new ajn() { // from class: bdx.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(bdx.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                bdh.a().a(bdh.a.GenreTracks, bdx.this, ((bdd) obj).c, "tracks");
            }
        }
    };
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: bdx.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdr bdrVar = new bdr();
            Bundle bundle = new Bundle();
            bundle.putSerializable("genre", (Serializable) bdx.this.g.get(i));
            bdrVar.g(bundle);
            if (!ahn.a()) {
                bdx.this.ae.q().a(bdrVar, (arc) null);
            } else {
                bdx.this.ae.q().a(bdrVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.GenreTracks) {
            this.a = bcv.a(jSONObject);
            b(this.a);
        }
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
        if (aVar == bdh.a.PlaylistGenres) {
            this.g.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    bdd bddVar = new bdd();
                    bddVar.a = jSONObject.getString("name");
                    bddVar.c = jSONObject.getString("path");
                    bddVar.b = jSONObject.getString("image").replace("-", "/");
                    this.g.add(bddVar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f.a(this.g);
            mm.b("TIDAL", "" + this.f.getCount());
            this.f.notifyDataSetChanged();
            this.h.setAdapter((ListAdapter) this.f);
        }
        am();
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        am();
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.tidal_grid_playlist_moods, (ViewGroup) null);
        this.h = (AnimationGridView) this.e.findViewById(R.id.group_gridview);
        this.h.setNeedAddFooter(false);
        this.f = new aih<>(this.ae, new a(), 100, R.layout.tidal_gridview_playlist_genre_item, R.layout.harman_list_loading);
        this.h.setAdapter((ListAdapter) this.f);
        this.h.setOnItemChosenListener(this.ai);
        b(q().getString(R.string.TidalGenres));
        return this.e;
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        b(q().getString(R.string.TidalGenres));
        bdh.a().a(bdh.a.PlaylistGenres, this, "", "", 0, 100);
        this.h.setOnItemClickListener(this.aj);
        this.h.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.h.setAdapter((ListAdapter) this.f);
    }

    class a implements aih.a<bdd> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, bdd bddVar) {
            mm.b("GENRES", "Creating playlist for " + i);
            C0121a c0121a = (C0121a) view.getTag();
            if (c0121a == null) {
                mm.b("GENRES", "new viewholder " + i);
                C0121a c0121a2 = new C0121a();
                c0121a2.a = (ImageView) view.findViewById(R.id.iv);
                c0121a2.b = (TextView) view.findViewById(R.id.tv);
                c0121a2.b.setTypeface(bcw.a(bdx.this.ae));
                c0121a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0121a2);
                c0121a = c0121a2;
            } else {
                mm.b("GENRES", "reusing existing " + i);
            }
            c0121a.b.setText(bddVar.a);
            mm.b("TIDAL", "http://resources.wimpmusic.com/images/" + bddVar.b + "/220x146.jpg");
            bif.a((Context) bdx.this.ae).a(c0121a.a);
            String str = "/220x146.jpg";
            if (ahn.a()) {
                str = "/400x266.jpg";
            }
            bif.a((Context) bdx.this.ae).a("http://resources.wimpmusic.com/images/" + bddVar.b + str).f().a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0121a.a);
            return view;
        }

        /* JADX INFO: renamed from: bdx$a$a, reason: collision with other inner class name */
        class C0121a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0121a() {
            }
        }
    }
}
