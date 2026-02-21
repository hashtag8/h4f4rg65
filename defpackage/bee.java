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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bee extends bdn implements ajn, bdi.b {
    private TabPageIndicator ai;
    private View e;
    private aic<bdc> f;
    private AnimationGridView h;
    private ArrayList<bdc> g = new ArrayList<>();
    private final int i = 20;
    private int ah = 0;
    final int a = 0;
    final int b = 1;
    int c = 0;
    TabPageIndicator.a d = new TabPageIndicator.a() { // from class: bee.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bee.this.c = i;
            bee.this.c(bee.this.l());
        }
    };
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: bee.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdw bdwVar = new bdw();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) bee.this.g.get(i));
            bdwVar.g(bundle);
            if (!ahn.a()) {
                bee.this.ae.q().a(bdwVar, (arc) null);
            } else {
                bee.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int e(bee beeVar) {
        int i = beeVar.ah;
        beeVar.ah = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.WhatsNew) {
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
                    }
                    arrayList.add(bdcVar);
                }
                if ((str.compareTo("new") == 0 && this.c == 0) || (str.compareTo("recommended") == 0 && this.c == 1)) {
                    this.g.addAll(this.g.size(), (ArrayList) arrayList.clone());
                    this.f.b(arrayList);
                    mm.b("TIDAL", "adapter count = " + this.f.getCount());
                    this.f.notifyDataSetChanged();
                }
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
        this.e = layoutInflater.inflate(R.layout.tidal_grid, (ViewGroup) null);
        this.h = (AnimationGridView) this.e.findViewById(R.id.group_gridview);
        this.ai = (TabPageIndicator) this.e.findViewById(R.id.indicator);
        this.ai.setTitles(new CharSequence[]{q().getString(R.string.TidalNew), q().getString(R.string.TidalRecommended)});
        this.ai.setOnTabReselectedListener(this.d);
        this.f = new aic<>(this.ae, new a(), 20, R.layout.tidal_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.f.a(this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h.setAdapter((ListAdapter) this.f);
        b(q().getString(R.string.TidalWhatsNew));
        return this.e;
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(q().getString(R.string.TidalPlaylists)).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ah = 1;
        d();
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.c = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.ai.b(this.c);
        if (this.c == 0) {
            bdh.a().a(bdh.a.WhatsNew, this, "new", "playlists", 0, 20);
        } else {
            bdh.a().a(bdh.a.WhatsNew, this, "recommended", "playlists", 0, 20);
        }
        this.g.clear();
        try {
            this.f.a(this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f.notifyDataSetChanged();
        this.h.setOnItemChosenListener(this);
        this.h.setOnItemClickListener(this.aj);
        this.h.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.h.setAdapter((ListAdapter) this.f);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        this.an = new bdj(bdh.a.PlaylistTracks, this.g.get(i).b);
        this.an.a(0, 100, this);
        d();
    }

    class a implements aic.a<bdc> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            mm.b("TIDAL", "nextPage called " + bee.this.ah + " " + i2);
            bee.this.d();
            if (bee.this.c == 0) {
                bdh.a().a(bdh.a.WhatsNew, bee.this, "new", "playlists", bee.this.ah * i2, i2);
            } else {
                bdh.a().a(bdh.a.WhatsNew, bee.this, "recommended", "playlists", bee.this.ah * i2, i2);
            }
            bee.e(bee.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdc bdcVar) {
            C0129a c0129a = (C0129a) view.getTag();
            if (c0129a == null) {
                C0129a c0129a2 = new C0129a();
                c0129a2.a = (ImageView) view.findViewById(R.id.iv);
                c0129a2.b = (TextView) view.findViewById(R.id.tv);
                c0129a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0129a2);
                c0129a = c0129a2;
            }
            c0129a.b.setText(bdcVar.a);
            c0129a.b.setTypeface(bcw.a(bee.this.ae));
            c0129a.c.setText(bee.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar.f)}));
            c0129a.c.setTypeface(bcw.b(bee.this.ae));
            bif.a((Context) bee.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&uuid=" + bdcVar.b).a(R.drawable.tidal_placeholder_300x225).a("tidal").a(c0129a.a);
            return view;
        }

        /* JADX INFO: renamed from: bee$a$a, reason: collision with other inner class name */
        class C0129a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0129a() {
            }
        }
    }
}
