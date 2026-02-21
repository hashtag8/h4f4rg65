package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdz extends bdn implements bdi.b {
    private bdd aj;
    private ImageView ak;
    private ImageView al;
    private TextView ar;
    private View d;
    private aih<bdc> e;
    private AnimationListView g;
    private View h;
    private View i;
    private ArrayList<bdc> f = new ArrayList<>();
    private final int ah = 50;
    private int ai = 1;
    final int a = 0;
    final int b = 1;
    int c = 0;
    private ajn as = new ajn() { // from class: bdz.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (i != 0) {
                bdz.this.an = new bdj(bdh.a.PlaylistTracks, ((bdc) obj).b);
                bdz.this.an.a(0, 100, bdz.this);
            }
        }
    };
    private AdapterView.OnItemClickListener at = new AdapterView.OnItemClickListener() { // from class: bdz.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != 0) {
                bdw bdwVar = new bdw();
                Bundle bundle = new Bundle();
                bundle.putSerializable("playlist", (Serializable) bdz.this.f.get(i - 1));
                bdwVar.g(bundle);
                bdwVar.g(bundle);
                if (!ahn.a()) {
                    bdz.this.ae.q().a(bdwVar, (arc) null);
                } else {
                    bdz.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
                }
            }
        }
    };

    static /* synthetic */ int g(bdz bdzVar) {
        int i = bdzVar.ai;
        bdzVar.ai = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.Playlists) {
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
                            bdcVar.g = q().getString(R.string.SettingTidal_Str);
                        } else if (("" + i2).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar.g = q().getString(R.string.TidalMe);
                        } else {
                            bdcVar.g = "" + i2;
                        }
                    } else {
                        bdcVar.g = "";
                    }
                    arrayList.add(bdcVar);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.i.setVisibility(4);
            this.f.addAll(this.f.size(), new ArrayList(arrayList));
            this.e.b(arrayList);
            if (arrayList.size() == 0) {
                this.i.setVisibility(0);
            }
            mm.b("TIDAL", "" + this.e.getCount());
            this.e.notifyDataSetChanged();
            this.h.setVisibility(0);
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
        this.d = layoutInflater.inflate(R.layout.tidal_track_list, (ViewGroup) null);
        this.g = (AnimationListView) this.d.findViewById(R.id.list_view);
        this.g.setDivider(new ColorDrawable(q().getColor(R.color.tidal_light_grey)));
        this.h = this.d.findViewById(R.id.list_view_holder);
        this.h.setVisibility(4);
        this.g.setEmptyView(this.d.findViewById(R.id.list_view_empty));
        this.i = this.d.findViewById(R.id.list_view_empty_text);
        View viewInflate = layoutInflater.inflate(R.layout.tidal_playlist_list_header, (ViewGroup) null);
        this.ak = (ImageView) viewInflate.findViewById(R.id.cover_image);
        this.al = (ImageView) viewInflate.findViewById(R.id.cover_icon);
        this.ar = (TextView) viewInflate.findViewById(R.id.cover_title);
        this.g.addHeaderView(viewInflate);
        this.e = new aih<>(this.ae, new a(), 50, R.layout.tidal_playlist_item, R.layout.harman_list_loading, R.color.white);
        this.e.a(this.f);
        this.g.setAdapter((ListAdapter) this.e);
        b(q().getString(R.string.TidalPlaylists));
        return this.d;
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.aj.a).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.h.setVisibility(4);
        this.aj = (bdd) bundle.getSerializable("mood");
        this.ar.setText(this.aj.a);
        String str = "http://resources.wimpmusic.com/images/" + this.aj.b.replace("-", "/") + "/342x342.jpg";
        mm.b("TIDAL", str);
        bif.a((Context) this.ae).a(str).a(R.drawable.tidal_placeholder_342x342).a(bib.NO_STORE, new bib[0]).a().c().a(this.ak);
        int identifier = this.ae.getResources().getIdentifier("tidal_mood_" + this.aj.c, "drawable", this.ae.getPackageName());
        if (identifier != 0) {
            bif.a((Context) this.ae).a(identifier).b(R.drawable.tidal_mood_charts).a(this.al);
        }
        this.f.clear();
        this.ai = 1;
        this.e.a(this.f);
        this.e.notifyDataSetChanged();
        this.i.setVisibility(4);
        bdh.a().a(bdh.a.Playlists, this, "moods", this.aj.c, 0, 50);
        this.g.setOnItemClickListener(this.at);
        this.g.setOnScrollListener(new bcz(this.ae));
        this.g.setOnItemChosenListener(this.as);
    }

    @Override // defpackage.bdn
    public void c() {
        this.g.setAdapter((ListAdapter) this.e);
    }

    class a implements aih.a<bdc> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (bdz.this.e.getCount() - 1 <= bdz.this.ai * i2) {
                bdh.a().a(bdh.a.Playlists, bdz.this, "moods", bdz.this.aj.c, bdz.this.ai * i2, i2);
                bdz.g(bdz.this);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, bdc bdcVar) {
            String str = "http://resources.wimpmusic.com/images/" + bdcVar.h.replace("-", "/") + "/160x107.jpg";
            C0123a c0123a = (C0123a) view.getTag();
            if (c0123a == null) {
                C0123a c0123a2 = new C0123a();
                c0123a2.a = (ImageView) view.findViewById(R.id.iv);
                c0123a2.b = (TextView) view.findViewById(R.id.text1);
                c0123a2.c = (TextView) view.findViewById(R.id.text2);
                c0123a2.d = (TextView) view.findViewById(R.id.text3);
                view.setTag(c0123a2);
                c0123a = c0123a2;
            }
            c0123a.b.setText(bdcVar.a);
            c0123a.b.setTypeface(bcw.a(bdz.this.ae));
            c0123a.c.setText(bdz.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar.f)}));
            c0123a.c.setTypeface(bcw.b(bdz.this.ae));
            c0123a.d.setText(bdz.this.ae.getString(R.string.TidalCreateBy, new Object[]{" " + bdcVar.g}));
            mm.b("TIDAL", str + bdcVar.b);
            c0123a.a.setVisibility(0);
            bif.a((Context) bdz.this.ae).a(bdcVar.h.compareTo("null") == 0 ? "http://images.osl.wimpmusic.com/im/im?w=160&h=107&uuid=" + bdcVar.b : str).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0123a.a);
            return view;
        }

        /* JADX INFO: renamed from: bdz$a$a, reason: collision with other inner class name */
        class C0123a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;

            C0123a() {
            }
        }
    }
}
