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
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bec extends bdn implements ajn, bdi.b {
    private aic<bda> ah;
    private AnimationGridView aj;
    private aic<bda> ak;
    private AnimationGridView ar;
    private TabPageIndicator au;
    private View f;
    private aic<bda> g;
    private AnimationGridView i;
    private ArrayList<bda> h = new ArrayList<>();
    private ArrayList<bda> ai = new ArrayList<>();
    private ArrayList<bda> al = new ArrayList<>();
    private final int as = 20;
    private int at = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    TabPageIndicator.a e = new TabPageIndicator.a() { // from class: bec.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bec.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener av = new AdapterView.OnItemClickListener() { // from class: bec.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bec.this.h.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bec.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bec.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aw = new AdapterView.OnItemClickListener() { // from class: bec.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bec.this.al.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bec.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bec.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener ax = new AdapterView.OnItemClickListener() { // from class: bec.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bec.this.ai.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bec.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bec.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int k(bec becVar) {
        int i = becVar.at;
        becVar.at = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.WhatsNew) {
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
                if (str.compareTo("new") == 0) {
                    this.h.addAll(this.h.size(), (ArrayList) arrayList.clone());
                    this.g.b(arrayList);
                    mm.b("TIDAL", "" + this.g.getCount());
                    this.g.notifyDataSetChanged();
                } else if (str.compareTo("recommended") == 0) {
                    this.ai.addAll(this.ai.size(), (ArrayList) arrayList.clone());
                    this.ah.b(arrayList);
                    this.ah.notifyDataSetChanged();
                } else if (str.compareTo("top") == 0) {
                    this.al.addAll(this.al.size(), (ArrayList) arrayList.clone());
                    this.ak.b(arrayList);
                    this.ak.notifyDataSetChanged();
                }
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
        this.f = layoutInflater.inflate(R.layout.tidal_grid, (ViewGroup) null);
        this.i = (AnimationGridView) this.f.findViewById(R.id.group_gridview);
        this.aj = (AnimationGridView) this.f.findViewById(R.id.recommended_gridview);
        this.ar = (AnimationGridView) this.f.findViewById(R.id.top20_gridview);
        this.au = (TabPageIndicator) this.f.findViewById(R.id.indicator);
        this.au.setTitles(new CharSequence[]{q().getString(R.string.TidalNew), q().getString(R.string.TidalRecommended), q().getString(R.string.TidalTop20)});
        this.au.setOnTabReselectedListener(this.e);
        this.g = new aic<>(this.ae, new a(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.g.a(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.i.setAdapter((ListAdapter) this.g);
        this.ah = new aic<>(this.ae, new b(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.ah.a(this.ai);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.aj.setAdapter((ListAdapter) this.ah);
        this.ak = new aic<>(this.ae, new c(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview, aic.k);
        try {
            this.ak.a(this.al);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.ar.setAdapter((ListAdapter) this.ak);
        b(q().getString(R.string.TidalWhatsNew));
        return this.f;
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(q().getString(R.string.TidalAlbums)).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.h.clear();
        try {
            this.g.a(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g.notifyDataSetChanged();
        this.i.setOnItemChosenListener(this);
        this.i.setOnItemClickListener(this.av);
        this.i.setOnScrollListener(new bcz(this.ae));
        this.ai.clear();
        try {
            this.ah.a(this.ai);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ah.notifyDataSetChanged();
        this.aj.setOnItemChosenListener(this);
        this.aj.setOnItemClickListener(this.ax);
        this.aj.setOnScrollListener(new bcz(this.ae));
        this.al.clear();
        try {
            this.ak.a(this.al);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.ak.notifyDataSetChanged();
        this.ar.setOnItemChosenListener(this);
        this.ar.setOnItemClickListener(this.aw);
        this.ar.setOnScrollListener(new bcz(this.ae));
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.au.setCurrentItem(this.d);
        d(this.d);
    }

    @Override // defpackage.bdn
    public void c() {
        this.ar.setAdapter((ListAdapter) this.ak);
        this.aj.setAdapter((ListAdapter) this.ah);
        this.i.setAdapter((ListAdapter) this.g);
    }

    protected void d(int i) {
        this.at = 1;
        this.d = i;
        this.au.b(i);
        this.h.clear();
        this.al.clear();
        this.ai.clear();
        switch (i) {
            case 0:
                d();
                bdh.a().a(bdh.a.WhatsNew, this, "new", "albums", 0, 20);
                this.i.setVisibility(0);
                this.aj.setVisibility(8);
                this.ar.setVisibility(8);
                break;
            case 1:
                d();
                bdh.a().a(bdh.a.WhatsNew, this, "recommended", "albums", 0, 20);
                this.i.setVisibility(8);
                this.aj.setVisibility(0);
                this.ar.setVisibility(8);
                break;
            case 2:
                d();
                bdh.a().a(bdh.a.WhatsNew, this, "top", "albums", 0, 20);
                this.i.setVisibility(8);
                this.aj.setVisibility(8);
                this.ar.setVisibility(0);
                break;
        }
        try {
            this.g.a(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g.notifyDataSetChanged();
        try {
            this.ah.a(this.ai);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ah.notifyDataSetChanged();
        try {
            this.ak.a(this.al);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.ak.notifyDataSetChanged();
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        mm.a(view);
        switch (view.getId()) {
            case R.id.group_gridview /* 2131690267 */:
                d(this.h.get(i));
                break;
            case R.id.recommended_gridview /* 2131690498 */:
                d(this.ai.get(i));
                break;
            case R.id.top20_gridview /* 2131691107 */:
                d(this.al.get(i));
                break;
        }
    }

    class a implements aic.a<bda> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bec.this.d();
            bdh.a().a(bdh.a.WhatsNew, bec.this, "new", "albums", bec.this.at * i2, i2);
            bec.k(bec.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            C0127a c0127a = (C0127a) view.getTag();
            if (c0127a == null) {
                C0127a c0127a2 = new C0127a();
                c0127a2.a = (ImageView) view.findViewById(R.id.iv);
                c0127a2.b = (TextView) view.findViewById(R.id.tv);
                c0127a2.b.setTypeface(bcw.a(bec.this.ae));
                c0127a2.c = (TextView) view.findViewById(R.id.tv_alt);
                c0127a2.c.setTypeface(bcw.b(bec.this.ae));
                view.setTag(c0127a2);
                c0127a = c0127a2;
            }
            c0127a.b.setText(bdaVar.b);
            c0127a.c.setText(bdaVar.c);
            bif.a((Context) bec.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0127a.a);
            return view;
        }

        /* JADX INFO: renamed from: bec$a$a, reason: collision with other inner class name */
        class C0127a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0127a() {
            }
        }
    }

    class b implements aic.a<bda> {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bec.this.d();
            bdh.a().a(bdh.a.WhatsNew, bec.this, "recommended", "albums", bec.this.at * i2, i2);
            bec.k(bec.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                aVar2.b.setTypeface(bcw.a(bec.this.ae));
                aVar2.c = (TextView) view.findViewById(R.id.tv_alt);
                aVar2.c.setTypeface(bcw.b(bec.this.ae));
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdaVar.b);
            aVar.c.setText(bdaVar.c);
            bif.a((Context) bec.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;

            a() {
            }
        }
    }

    class c implements aic.a<bda> {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                aVar2.b.setTypeface(bcw.a(bec.this.ae));
                aVar2.c = (TextView) view.findViewById(R.id.tv_alt);
                aVar2.c.setTypeface(bcw.b(bec.this.ae));
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdaVar.b);
            aVar.c.setText(bdaVar.c);
            bif.a((Context) bec.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;

            a() {
            }
        }
    }

    private void d(bda bdaVar) {
        bdh.a().a(bdh.a.AlbumTracks, this, bdaVar.a, "", 0, 20);
        d();
    }
}
