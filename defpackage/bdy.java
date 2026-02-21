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
public class bdy extends bdn implements bdi.b {
    private View d;
    private aih<bdd> e;
    private AnimationGridView g;
    private ArrayList<bdd> f = new ArrayList<>();
    private final int h = 100;
    private int i = 0;
    final int a = 0;
    final int b = 1;
    int c = 0;
    private AdapterView.OnItemClickListener ah = new AdapterView.OnItemClickListener() { // from class: bdy.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdz bdzVar = new bdz();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mood", (Serializable) bdy.this.f.get(i));
            bdzVar.g(bundle);
            if (!ahn.a()) {
                bdy.this.ae.q().a(bdzVar, (arc) null);
            } else {
                bdy.this.ae.q().a(bdzVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.PlaylistMoods) {
            this.f.clear();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    bdd bddVar = new bdd();
                    bddVar.a = jSONObject2.getString("name");
                    bddVar.c = jSONObject2.getString("path");
                    bddVar.b = jSONObject2.getString("image").replace("-", "/");
                    this.f.add(bddVar);
                }
                this.e.a(this.f);
                mm.b("TIDAL", "" + this.e.getCount());
                this.e.notifyDataSetChanged();
                this.g.setAdapter((ListAdapter) this.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        am();
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
        if (aVar == bdh.a.PlaylistMoods) {
            this.f.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    bdd bddVar = new bdd();
                    bddVar.a = jSONObject.getString("name");
                    bddVar.c = jSONObject.getString("path");
                    bddVar.b = jSONObject.getString("image").replace("-", "/");
                    this.f.add(bddVar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.e.a(this.f);
            mm.b("TIDAL", "" + this.e.getCount());
            this.e.notifyDataSetChanged();
            this.g.setAdapter((ListAdapter) this.e);
        }
        am();
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        am();
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(R.layout.tidal_grid_playlist_moods, (ViewGroup) null);
        this.g = (AnimationGridView) this.d.findViewById(R.id.group_gridview);
        this.e = new aih<>(this.ae, new a(), 100, R.layout.tidal_gridview_playlist_mood_item, R.layout.harman_list_loading);
        this.g.setAllowDrag(false);
        this.g.setNeedAddFooter(false);
        this.g.setAdapter((ListAdapter) this.e);
        b(q().getString(R.string.TidalPlaylists));
        return this.d;
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        b(q().getString(R.string.TidalPlaylists));
        bdh.a().a(bdh.a.PlaylistMoods, this, "", "", 0, 100);
        this.g.setOnItemClickListener(this.ah);
        this.g.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.g.setAdapter((ListAdapter) this.e);
    }

    class a implements aih.a<bdd> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, bdd bddVar) {
            C0122a c0122a = (C0122a) view.getTag();
            if (c0122a == null) {
                C0122a c0122a2 = new C0122a();
                c0122a2.a = (ImageView) view.findViewById(R.id.iv);
                c0122a2.b = (TextView) view.findViewById(R.id.tv);
                c0122a2.c = (TextView) view.findViewById(R.id.tv_alt);
                c0122a2.d = (ImageView) view.findViewById(R.id.mood_icon);
                view.setTag(c0122a2);
                c0122a = c0122a2;
            }
            c0122a.b.setText(bddVar.a);
            mm.b("TIDAL", "http://resources.wimpmusic.com/images/" + bddVar.b + "/320x320.jpg");
            bif.a((Context) bdy.this.ae).a("http://resources.wimpmusic.com/images/" + bddVar.b + "/320x320.jpg").a(R.drawable.tidal_placeholder_342x342).a("tidal").a(c0122a.a);
            int identifier = bdy.this.ae.getResources().getIdentifier("tidal_mood_" + bddVar.c, "drawable", bdy.this.ae.getPackageName());
            if (identifier != 0) {
                bif.a((Context) bdy.this.ae).a(identifier).b(R.drawable.tidal_mood_charts).a(c0122a.d);
            }
            return view;
        }

        /* JADX INFO: renamed from: bdy$a$a, reason: collision with other inner class name */
        class C0122a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;

            C0122a() {
            }
        }
    }
}
