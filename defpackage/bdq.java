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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdq extends bdn implements ajn, bdi.b {
    private bdd ai;
    private TabPageIndicator aj;
    private View e;
    private aic<bda> f;
    private AnimationGridView h;
    private ArrayList<bda> g = new ArrayList<>();
    private final int i = 20;
    private int ah = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    private AdapterView.OnItemClickListener ak = new AdapterView.OnItemClickListener() { // from class: bdq.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdq.this.g.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdq.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdq.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int f(bdq bdqVar) {
        int i = bdqVar.ah;
        bdqVar.ah = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.GenreAlbums) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    bda bdaVar = new bda();
                    bdaVar.a = "" + jSONObject2.getInt("id");
                    bdaVar.e = jSONObject2.getString("cover");
                    bdaVar.b = jSONObject2.getString("title");
                    bdaVar.f = jSONObject2.getInt("numberOfTracks");
                    if (jSONObject2.has("artist")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("artist");
                        bdaVar.c = jSONObject3.getString("name");
                        bdaVar.d = "" + jSONObject3.getInt("id");
                    }
                    arrayList.add(bdaVar);
                    i++;
                }
                this.g.addAll(this.g.size(), (ArrayList) arrayList.clone());
                this.f.b(arrayList);
                mm.b("TIDAL", "" + this.f.getCount());
                this.f.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumTracks) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                mm.b("TEST_DRAG_ALBUM, item size = %s", Integer.valueOf(jSONArray2.length()));
                while (i < jSONArray2.length()) {
                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i);
                    bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject4.getInt("id");
                    bdgVar.d = jSONObject4.getString("title");
                    bdgVar.e = jSONObject4.getString("url");
                    bdgVar.f = jSONObject4.getInt("duration");
                    bdgVar.j = jSONObject4.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject4.getBoolean("streamReady");
                    bdgVar.l = jSONObject4.getString("streamStartDate");
                    if (jSONObject4.has("artist")) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("artist");
                        bdgVar.a = jSONObject5.getString("name");
                        bdgVar.b = "" + jSONObject5.getInt("id");
                    }
                    if (jSONObject4.has("album")) {
                        JSONObject jSONObject6 = jSONObject4.getJSONObject("album");
                        bdgVar.h = jSONObject6.getString("title");
                        bdgVar.g = "" + jSONObject6.getInt("id");
                        bdgVar.i = jSONObject6.getString("cover");
                    }
                    arrayList2.add(bdgVar);
                    mm.b("TEST_DRAG_ALBUM", "track_thing=" + bdgVar.toString());
                    i++;
                }
                b((List<bdg>) arrayList2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
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
        this.e = layoutInflater.inflate(R.layout.tidal_grid, (ViewGroup) null);
        this.h = (AnimationGridView) this.e.findViewById(R.id.group_gridview);
        this.h.setNeedAddFooter(false);
        this.aj = (TabPageIndicator) this.e.findViewById(R.id.indicator);
        this.aj.setVisibility(8);
        this.f = new aic<>(this.ae, new a(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.f.a(this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h.setAdapter((ListAdapter) this.f);
        b(q().getString(R.string.TidalGenres));
        return this.e;
    }

    @Override // defpackage.bdn
    public void c() {
        this.h.setAdapter((ListAdapter) this.f);
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ah = 1;
        d();
        this.ai = (bdd) bundle.getSerializable("genre");
        if (this.ai != null) {
            b(this.ai.a);
        }
        this.g.clear();
        try {
            this.f.a(this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f.notifyDataSetChanged();
        this.h.setOnItemChosenListener(this);
        this.h.setOnItemClickListener(this.ak);
        this.h.setOnScrollListener(new bcz(this.ae));
        bdh.a().a(bdh.a.GenreAlbums, this, this.ai.c, "albums", 0, 20);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        bdh.a().a(bdh.a.AlbumTracks, this, this.g.get(i).a, "", 0, 20);
        d();
    }

    class a implements aic.a<bda> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdq.this.d();
            bdh.a().a(bdh.a.GenreAlbums, bdq.this, bdq.this.ai.c, "albums", bdq.this.ah * i2, i2);
            bdq.f(bdq.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            String str;
            if (bdaVar.e != null) {
                str = "http://resources.wimpmusic.com/images/" + bdaVar.e.replace("-", "/") + "/320x320.jpg";
            } else {
                str = "http://images.osl.wimpmusic.com/im/im?w=300&h=300&albumid=" + bdaVar.a;
            }
            C0113a c0113a = (C0113a) view.getTag();
            if (c0113a == null) {
                C0113a c0113a2 = new C0113a();
                c0113a2.a = (ImageView) view.findViewById(R.id.iv);
                c0113a2.b = (TextView) view.findViewById(R.id.tv);
                c0113a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0113a2);
                c0113a = c0113a2;
            }
            c0113a.b.setText(bdaVar.b);
            c0113a.b.setTypeface(bcw.a(bdq.this.ae));
            c0113a.c.setText(bdaVar.c);
            c0113a.c.setTypeface(bcw.b(bdq.this.ae));
            bif.a((Context) bdq.this.ae).a(str).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0113a.a);
            return view;
        }

        /* JADX INFO: renamed from: bdq$a$a, reason: collision with other inner class name */
        class C0113a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0113a() {
            }
        }
    }
}
