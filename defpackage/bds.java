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
import com.musicservice.tidal.TabPageIndicator;
import defpackage.aic;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bds extends bdn implements ajn, bdi.b {
    private TabPageIndicator ah;
    private bdd ai;
    private View d;
    private aic<bdc> e;
    private AnimationGridView g;
    private ArrayList<bdc> f = new ArrayList<>();
    private final int h = 20;
    private int i = 1;
    final int a = 0;
    final int b = 1;
    int c = 0;
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: bds.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdw bdwVar = new bdw();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) bds.this.f.get(i));
            bdwVar.g(bundle);
            if (!ahn.a()) {
                bds.this.ae.q().a(bdwVar, (arc) null);
            } else {
                bds.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int f(bds bdsVar) {
        int i = bdsVar.i;
        bdsVar.i = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.GenrePlaylists) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject2.getString("description");
                    bdcVar.d = jSONObject2.getInt("duration");
                    bdcVar.a = jSONObject2.getString("title");
                    bdcVar.e = jSONObject2.getString("url");
                    bdcVar.b = jSONObject2.getString("uuid");
                    bdcVar.f = jSONObject2.getInt("numberOfTracks");
                    bdcVar.h = jSONObject2.getString("image");
                    if (jSONObject2.has("creator")) {
                        int i2 = jSONObject2.getJSONObject("creator").getInt("id");
                        if (i2 == 0) {
                            bdcVar.g = "TIDAL";
                        } else if (("" + i2).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar.g = q().getString(R.string.TidalMe);
                        } else {
                            bdcVar.g = "" + i2;
                        }
                    }
                    arrayList.add(bdcVar);
                }
                this.f.addAll(this.f.size(), (ArrayList) arrayList.clone());
                this.e.b(arrayList);
                mm.b("TIDAL", "adapter count = " + this.e.getCount());
                this.e.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        am();
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        am();
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(R.layout.tidal_grid, (ViewGroup) null);
        this.g = (AnimationGridView) this.d.findViewById(R.id.group_gridview);
        this.g.setNeedAddFooter(false);
        this.ah = (TabPageIndicator) this.d.findViewById(R.id.indicator);
        this.ah.setVisibility(8);
        this.e = new aic<>(this.ae, new a(), 20, R.layout.tidal_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.e.a(this.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g.setAdapter((ListAdapter) this.e);
        b(q().getString(R.string.TidalGenres));
        return this.d;
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.i = 1;
        this.ai = (bdd) bundle.getSerializable("genre");
        if (this.ai != null) {
            b(this.ai.a);
        }
        bdh.a().a(bdh.a.GenrePlaylists, this, this.ai.c, "playlists", 0, 20);
        this.f.clear();
        try {
            this.e.a(this.f);
            this.e.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g.setOnItemChosenListener(this);
        this.g.setOnItemClickListener(this.aj);
        this.g.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.g.setAdapter((ListAdapter) this.e);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        this.an = new bdj(bdh.a.PlaylistTracks, this.f.get(i).b);
        this.an.a(0, 100, this);
        d();
    }

    class a implements aic.a<bdc> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            mm.b("TIDAL", "nextPage called " + bds.this.i + " " + i2);
            bds.this.d();
            bdh.a().a(bdh.a.GenrePlaylists, bds.this, bds.this.ai.c, "playlists", bds.this.i * i2, i2);
            bds.f(bds.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdc bdcVar) {
            C0114a c0114a = (C0114a) view.getTag();
            if (c0114a == null) {
                C0114a c0114a2 = new C0114a();
                c0114a2.a = (ImageView) view.findViewById(R.id.iv);
                c0114a2.b = (TextView) view.findViewById(R.id.tv);
                c0114a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0114a2);
                c0114a = c0114a2;
            }
            c0114a.b.setText(bdcVar.a);
            c0114a.b.setTypeface(bcw.a(bds.this.ae));
            c0114a.c.setText(bds.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar.f)}));
            c0114a.c.setTypeface(bcw.b(bds.this.ae));
            bif.a((Context) bds.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&uuid=" + bdcVar.b).a(R.drawable.tidal_placeholder_300x225).a("tidal").a(c0114a.a);
            return view;
        }

        /* JADX INFO: renamed from: bds$a$a, reason: collision with other inner class name */
        class C0114a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0114a() {
            }
        }
    }
}
