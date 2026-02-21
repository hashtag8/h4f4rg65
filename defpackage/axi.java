package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.juke.TabPageIndicator;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.aih;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axi extends axk implements axd.b {
    awx a;
    private View aA;
    private View aB;
    private View aC;
    private HashMap<String, String> aD;
    private HashMap<String, String> aE;
    private HashMap<String, String> aF;
    private View ak;
    private aih<axb> al;
    private AnimationListView an;
    private AnimationGridView ao;
    private AnimationListView ap;
    private aih<aww> ar;
    private aih<awx> as;
    private TabPageIndicator av;
    private View aw;
    private View ax;
    private View ay;
    private View az;
    private final int aj = 20;
    TabPageIndicator.a b = new TabPageIndicator.a() { // from class: axi.1
        @Override // com.musicservice.juke.TabPageIndicator.a
        public void a(int i) {
            axi.this.d(i);
        }
    };
    private ArrayList<axb> am = new ArrayList<>();
    private int aq = 1;
    private ArrayList<aww> at = new ArrayList<>();
    private ArrayList<awx> au = new ArrayList<>();
    private boolean aG = false;
    private boolean aH = false;
    private boolean aI = false;
    private AdapterView.OnItemClickListener aJ = new AdapterView.OnItemClickListener() { // from class: axi.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axh axhVar = new axh();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) axi.this.at.get(i));
            axhVar.g(bundle);
            axi.this.a((axj) axhVar);
        }
    };
    private AdapterView.OnItemClickListener aK = new AdapterView.OnItemClickListener() { // from class: axi.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axi axiVar = new axi();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Serializable) axi.this.au.get(i));
            axiVar.g(bundle);
            axi.this.a((axj) axiVar);
        }
    };

    static /* synthetic */ int f(axi axiVar) {
        int i = axiVar.aq;
        axiVar.aq = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        JSONArray jSONArray = null;
        if (str.compareTo("catalog:artist-tracks") == 0) {
            this.aG = false;
            mm.b("CATALOG", jSONObject.toString());
            this.aE = awp.a(jSONObject);
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject.optString("id");
                    axbVar.b = jSONObjectOptJSONObject.optString("name");
                    axbVar.c = jSONObjectOptJSONObject.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject.optInt("lengthInSeconds");
                    axbVar.f = jSONObjectOptJSONObject.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject.optString("label");
                    axbVar.h = jSONObjectOptJSONObject.optString("releaseYear");
                    jSONObjectOptJSONObject.optJSONArray("links");
                    axbVar.i = awp.a(jSONObjectOptJSONObject);
                    arrayList.add(axbVar);
                }
            }
            this.am.addAll(this.am.size(), (ArrayList) arrayList.clone());
            this.aB.setVisibility(4);
            if (arrayList.size() == 0) {
                this.aB.setVisibility(0);
            }
            this.al.b(arrayList);
            if (this.ax.getVisibility() == 4) {
                this.ax.setVisibility(0);
            }
            mm.b("Juke", "getcount=" + this.al.getCount());
            al();
            return;
        }
        if (str.compareTo("catalog:artist-albums") == 0) {
            this.aH = false;
            mm.b("CATALOG", jSONObject.toString());
            this.aD = awp.a(jSONObject);
            try {
                jSONArray = jSONObject.getJSONArray("albums");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    aww awwVar = new aww();
                    awwVar.a = jSONObjectOptJSONObject2.optString("id");
                    awwVar.b = jSONObjectOptJSONObject2.optString("name");
                    awwVar.c = jSONObjectOptJSONObject2.optString("artistName");
                    awwVar.f = jSONObjectOptJSONObject2.optInt("trackCount");
                    awwVar.d = jSONObjectOptJSONObject2.optString("lengthInSeconds");
                    awwVar.e = jSONObjectOptJSONObject2.optString("genre");
                    awwVar.g = jSONObjectOptJSONObject2.optString("label");
                    awwVar.h = jSONObjectOptJSONObject2.optString("releaseYear");
                    jSONObjectOptJSONObject2.optJSONArray("links");
                    awwVar.i = awp.a(jSONObjectOptJSONObject2);
                    arrayList2.add(awwVar);
                }
            }
            this.aC.setVisibility(4);
            if (arrayList2.size() == 0) {
                this.aC.setVisibility(0);
            }
            this.at.addAll(this.at.size(), (ArrayList) arrayList2.clone());
            this.ar.b(arrayList2);
            mm.b("Juke", "Albums " + this.ar.getCount());
            if (this.ay.getVisibility() == 4) {
                this.ay.setVisibility(0);
            }
            al();
            return;
        }
        if (str.compareTo("catalog:similar-artists") == 0) {
            this.aI = false;
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("artists");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            this.aF = awp.a(jSONObject);
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject3 != null) {
                    awx awxVar = new awx();
                    awxVar.a = jSONObjectOptJSONObject3.optString("id");
                    awxVar.b = jSONObjectOptJSONObject3.optString("name");
                    awxVar.g = awp.a(jSONObjectOptJSONObject3);
                    arrayList3.add(awxVar);
                }
            }
            this.az.setVisibility(4);
            this.aA.setVisibility(4);
            if (arrayList3.size() == 0) {
                this.az.setVisibility(0);
                this.aA.setVisibility(0);
            }
            this.au.addAll(this.au.size(), (ArrayList) arrayList3.clone());
            this.as.b(arrayList3);
            mm.b("Juke", "" + this.as.getCount());
            al();
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList4 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject4 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject4.optString("id");
                    awzVar.b = jSONObjectOptJSONObject4.optString("name");
                    awzVar.d = jSONObjectOptJSONObject4.optString("description");
                    awzVar.e = jSONObjectOptJSONObject4.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject4.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject4.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject4);
                    arrayList4.add(awzVar);
                }
            }
            al();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("rel", "catalog:track");
                jSONObject2.put("href", str2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList4, jSONArray2, this);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 20, true);
            return;
        }
        if (str.compareTo("catalog:album") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            if (jSONObject != null) {
                aww awwVar2 = new aww();
                awwVar2.a = jSONObject.optString("id");
                awwVar2.b = jSONObject.optString("name");
                awwVar2.c = jSONObject.optString("artistName");
                awwVar2.f = jSONObject.optInt("trackCount");
                awwVar2.d = jSONObject.optString("lengthInSeconds");
                awwVar2.e = jSONObject.optString("genre");
                awwVar2.g = jSONObject.optString("label");
                awwVar2.h = jSONObject.optString("releaseYear");
                awwVar2.i = awp.a(jSONObject);
                axj axhVar = new axh();
                Bundle bundle = new Bundle();
                bundle.putSerializable("album", awwVar2);
                axhVar.g(bundle);
                a(axhVar);
                return;
            }
            return;
        }
        if (str.compareTo("next") == 0) {
            a(str2, jSONObject, "");
        }
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
        if (str.equals("catalog:artist-tracks")) {
            this.aG = false;
        } else if (str.equals("artist-albums")) {
            this.aH = false;
        } else if (str.equals("similar-artists")) {
            this.aI = false;
        }
        al();
        Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.juke_artist, (ViewGroup) null);
        this.an = (AnimationListView) this.ak.findViewById(R.id.tracks_list_view);
        this.ax = this.ak.findViewById(R.id.tracks_list_view_holder);
        this.an.setEmptyView(this.ak.findViewById(R.id.tracks_list_view_empty));
        this.aB = this.ak.findViewById(R.id.tracks_list_view_empty_text);
        this.an.setOffsetFooterFlag(true);
        this.av = (TabPageIndicator) this.ak.findViewById(R.id.indicator);
        this.av.setTitles(new CharSequence[]{this.ae.getString(R.string.JukeTracks), this.ae.getString(R.string.JukeAlbums), this.ae.getString(R.string.JukeSimilar)});
        this.av.setOnTabReselectedListener(this.b);
        this.ao = (AnimationGridView) this.ak.findViewById(R.id.albums_gridview);
        this.ay = this.ak.findViewById(R.id.albums_gridview_holder);
        this.ao.setEmptyView(this.ak.findViewById(R.id.albums_gridview_empty));
        this.aC = this.ak.findViewById(R.id.albums_gridview_empty_text);
        this.ao.setNeedAddFooter(false);
        this.ap = (AnimationListView) this.ak.findViewById(R.id.artists_listview);
        this.aw = this.ak.findViewById(R.id.artists_listview_holder);
        this.ap.setEmptyView(this.ak.findViewById(R.id.artists_listview_empty));
        this.ap.setOffsetFooterFlag(true);
        this.az = this.ak.findViewById(R.id.empty_artist_text);
        this.aA = this.ak.findViewById(R.id.empty_artist);
        this.aB.setVisibility(4);
        this.aC.setVisibility(4);
        this.az.setVisibility(4);
        this.aA.setVisibility(4);
        this.al = new aih<>(this.ae, new c(), 20, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        this.ar = new aih<>(this.ae, new a(), 20, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        this.as = new aih<>(this.ae, new b(), 20, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        this.al.a(this.am);
        this.ar.a(this.at);
        this.as.a(this.au);
        this.an.setAdapter((ListAdapter) this.al);
        this.ao.setAdapter((ListAdapter) this.ar);
        this.ap.setAdapter((ListAdapter) this.as);
        o(l());
        return this.ak;
    }

    protected void d(int i) {
        this.aq = 0;
        switch (i) {
            case 0:
                if (am()) {
                    this.ax.setVisibility(4);
                } else {
                    this.ax.setVisibility(0);
                }
                this.aw.setVisibility(8);
                this.ay.setVisibility(8);
                break;
            case 1:
                this.ax.setVisibility(8);
                this.aw.setVisibility(8);
                if (am()) {
                    this.ay.setVisibility(4);
                } else {
                    this.ay.setVisibility(0);
                }
                break;
            case 2:
                this.ax.setVisibility(8);
                this.aw.setVisibility(0);
                this.ay.setVisibility(8);
                break;
        }
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.ao.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.an.setAdapter((ListAdapter) this.al);
        this.ao.setAdapter((ListAdapter) this.ar);
        this.ap.setAdapter((ListAdapter) this.as);
    }

    private void o(Bundle bundle) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        d();
        this.a = (awx) bundle.getSerializable("artist");
        this.aB.setVisibility(4);
        this.aC.setVisibility(4);
        this.az.setVisibility(4);
        this.aA.setVisibility(4);
        this.am.clear();
        this.al.a(this.am);
        this.al.notifyDataSetChanged();
        this.at.clear();
        this.ar.a(this.at);
        this.ar.notifyDataSetChanged();
        this.au.clear();
        this.as.a(this.au);
        this.as.notifyDataSetChanged();
        axc.a().a(this.a.g, "catalog:artist-albums", this, "", "", 0, 20);
        axc.a().a(this.a.g, "catalog:artist-tracks", this, "", "", 0, 20);
        axc.a().a(this.a.g, "catalog:similar-artists", this, "", "", 0, 20);
        this.an.setOnItemChosenListener(new ajn() { // from class: axi.4
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                JukeMusicDataLocal jukeMusicDataLocalA = axi.this.a((axb) obj);
                if (jukeMusicDataLocalA != null) {
                    axi.this.a(jukeMusicDataLocalA);
                }
            }
        });
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.an.setLeftMargin((int) dimension);
        }
        this.ao.setOnItemChosenListener(new ajn() { // from class: axi.5
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(axi.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else {
                    awp.a((aww) obj);
                }
            }
        });
        this.ap.setOnItemChosenListener(new ajn() { // from class: axi.6
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(axi.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else {
                    awp.a((awx) obj);
                }
            }
        });
        this.ao.setOnItemClickListener(this.aJ);
        this.ap.setOnItemClickListener(this.aK);
        this.av.setCurrentItem(0);
        d(0);
    }

    class c implements aih.a<axb>, View.OnClickListener {
        c() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (!axi.this.aG) {
                if (axi.this.aE.containsKey("next")) {
                    axi.this.d();
                    axc.a().a(axi.this.aE, "next", (axd.b) axi.this, "catalog:artist-tracks", "", axi.this.aq * i2, i2, false);
                }
                axi.f(axi.this);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, axb axbVar) {
            a aVar;
            a aVar2 = (a) view.getTag();
            if (aVar2 == null) {
                aVar = new a();
                aVar.a = (ImageView) view.findViewById(R.id.iv);
                aVar.c = (TextView) view.findViewById(R.id.text1);
                aVar.d = (TextView) view.findViewById(R.id.text2);
                aVar.e = (TextView) view.findViewById(R.id.track_time);
                aVar.f = (LinearLayout) view.findViewById(R.id.more_holder);
                aVar.b = (TextView) view.findViewById(R.id.chart_position);
                view.setTag(aVar);
            } else {
                aVar = aVar2;
            }
            aVar.d.setVisibility(0);
            aVar.f.setVisibility(0);
            aVar.b.setVisibility(8);
            aVar.c.setText(axbVar.b);
            aVar.d.setText(axbVar.c);
            aVar.e.setVisibility(0);
            aVar.e.setText("" + awp.a(axbVar.e));
            bif.a((Context) axi.this.ae).a(axbVar.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a("juke").a(aVar.a);
            aVar.f.setTag(axbVar);
            aVar.f.setOnClickListener(this);
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axi.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axi.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axi.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axi.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axi.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axi.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axi.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axi.this.b(axbVar)) {
                arrayList.add(axi.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axi.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            if (axbVar.i.containsKey("catalog:album") && axbVar.i.get("catalog:album") != null) {
                arrayList.add(axi.this.ae.getString(R.string.JukeGoAlbum));
            }
            arzVar.a(arrayList);
            arzVar.a(axi.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axi.c.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axi.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axi.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axi.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(axbVar.i, "user:favorite-track", axi.this, "");
                                                            axi.this.d(axbVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axi.this.d(jukeMusicDataLocalA);
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:album", axi.this, "", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "catalog:artist", axi.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(axbVar.i, "user:favorite-track", axi.this);
                                        axi.this.c(axbVar);
                                        return;
                                    }
                                    axi.this.d();
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axi.this, axbVar.i.get("catalog:track"), "", -1, -1, true);
                                    return;
                                }
                                axi.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            axi.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        axi.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axi.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            a() {
            }
        }
    }

    class a implements aih.a<aww> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (!axi.this.aH && axi.this.aD.containsKey("next")) {
                axi.this.d();
                axc.a().a(axi.this.aD, "next", (axd.b) axi.this, "catalog:artist-albums", "", axi.this.aq * i2, i2, false);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, aww awwVar) {
            C0074a c0074a;
            C0074a c0074a2 = (C0074a) view.getTag();
            if (c0074a2 == null) {
                c0074a = new C0074a();
                c0074a.a = (ImageView) view.findViewById(R.id.iv);
                c0074a.b = (TextView) view.findViewById(R.id.tv);
                c0074a.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0074a);
            } else {
                c0074a = c0074a2;
            }
            c0074a.b.setText(awwVar.b);
            c0074a.c.setText("(" + awwVar.h + " - " + awwVar.f + " " + axi.this.ae.getString(R.string.JukeTracks) + ")");
            c0074a.a.setVisibility(0);
            bif.a((Context) axi.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0074a.a);
            return view;
        }

        /* JADX INFO: renamed from: axi$a$a, reason: collision with other inner class name */
        class C0074a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0074a() {
            }
        }
    }

    class b implements aih.a<awx> {
        b() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (!axi.this.aI) {
                if (axi.this.aF.containsKey("next")) {
                    axi.this.d();
                    axc.a().a(axi.this.aF, "next", (axd.b) axi.this, "catalog:similar-artists", "", axi.this.aq * i2, i2, false);
                }
                axi.f(axi.this);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, awx awxVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.c = (TextView) view.findViewById(R.id.text1);
                aVar2.d = (TextView) view.findViewById(R.id.text2);
                aVar2.e = (TextView) view.findViewById(R.id.track_time);
                aVar2.f = (LinearLayout) view.findViewById(R.id.more_holder);
                aVar2.b = (TextView) view.findViewById(R.id.chart_position);
                aVar2.d.setVisibility(8);
                aVar2.f.setVisibility(8);
                aVar2.b.setVisibility(8);
                aVar2.e.setVisibility(8);
                aVar2.a.setVisibility(8);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.c.setText(awxVar.b);
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            a() {
            }
        }
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).a(this.a.b).c();
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName() + "#" + System.identityHashCode(this);
    }
}
