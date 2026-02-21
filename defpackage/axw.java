package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.juke.TabPageIndicator;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axw extends axk implements axd.b {
    private TabPageIndicator aB;
    private String aC;
    private HashMap<String, String> aD;
    private HashMap<String, String> aE;
    private HashMap<String, String> aF;
    private AnimationListView aj;
    private AnimationListView ak;
    private AnimationGridView al;
    private View am;
    private View an;
    private View ao;
    private View ap;
    private View aq;
    private View ar;
    private aic<axb> av;
    private aic<aww> aw;
    private aic<awx> ax;
    private View b;
    private final int as = 20;
    private int at = 1;
    private int au = 0;
    private ArrayList<axb> ay = new ArrayList<>();
    private ArrayList<aww> az = new ArrayList<>();
    private ArrayList<awx> aA = new ArrayList<>();
    TabPageIndicator.a a = new TabPageIndicator.a() { // from class: axw.1
        @Override // com.musicservice.juke.TabPageIndicator.a
        public void a(int i) {
            axw.this.d(i);
        }
    };
    private ajn aG = new ajn() { // from class: axw.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            awp.a((aww) obj);
        }
    };
    private ajn aH = new ajn() { // from class: axw.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            JukeMusicDataLocal jukeMusicDataLocalA = axw.this.a((axb) obj);
            if (jukeMusicDataLocalA != null) {
                axw.this.a(jukeMusicDataLocalA);
            }
        }
    };
    private AdapterView.OnItemClickListener aI = new AdapterView.OnItemClickListener() { // from class: axw.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axi axiVar = new axi();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Serializable) axw.this.aA.get(i));
            axiVar.g(bundle);
            axw.this.a((axj) axiVar);
        }
    };
    private AdapterView.OnItemClickListener aJ = new AdapterView.OnItemClickListener() { // from class: axw.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axh axhVar = new axh();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) axw.this.az.get(i));
            axhVar.g(bundle);
            axw.this.a((axj) axhVar);
        }
    };

    static /* synthetic */ int e(axw axwVar) {
        int i = axwVar.at;
        axwVar.at = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        JSONArray jSONArray = null;
        int i = 0;
        if (str.compareTo("catalog:track-search") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.aE = awp.a(jSONObject);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
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
            this.ap.setVisibility(4);
            if (arrayList.size() == 0) {
                this.ap.setVisibility(0);
            }
            this.ay.addAll(this.ay.size(), (ArrayList) arrayList.clone());
            this.av.b(arrayList);
            mm.b("Juke", "getcount=" + this.av.getCount());
            al();
            return;
        }
        if (str.compareTo("catalog:album-search") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("albums");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.aD = awp.a(jSONObject);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i3);
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
            this.ar.setVisibility(4);
            if (arrayList2.size() == 0) {
                this.ar.setVisibility(0);
            }
            this.az.addAll(this.az.size(), (ArrayList) arrayList2.clone());
            this.aw.b(arrayList2);
            mm.b("Juke", "Albums " + this.aw.getCount());
            al();
            return;
        }
        if (str.compareTo("catalog:artist-search") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("artists");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            this.aF = awp.a(jSONObject);
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject3 != null) {
                    awx awxVar = new awx();
                    awxVar.a = jSONObjectOptJSONObject3.optString("id");
                    awxVar.b = jSONObjectOptJSONObject3.optString("name");
                    awxVar.g = awp.a(jSONObjectOptJSONObject3);
                    arrayList3.add(awxVar);
                }
            }
            this.aq.setVisibility(4);
            if (arrayList3.size() == 0) {
                this.aq.setVisibility(0);
            }
            this.aA.addAll(this.aA.size(), (ArrayList) arrayList3.clone());
            this.ax.b(arrayList3);
            mm.b("Juke", "" + this.ax.getCount());
            al();
            this.an.setVisibility(0);
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList4 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
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
                i++;
            }
            al();
            try {
                jSONArray = new JSONArray(str2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList4, jSONArray, this);
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
                jSONObject.optJSONArray("links");
                awwVar2.i = awp.a(jSONObject);
                if (awwVar2.i.containsKey("self")) {
                    awwVar2.i.put("catalog:album", awwVar2.i.get("self"));
                }
                if (str2.compareTo("view") == 0) {
                    al();
                    axj axhVar = new axh();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("album", awwVar2);
                    axhVar.g(bundle);
                    a(axhVar);
                    return;
                }
            }
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList5 = new ArrayList();
            while (i < jSONArray.length()) {
                JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject5 != null) {
                    axb axbVar2 = new axb();
                    axbVar2.a = jSONObjectOptJSONObject5.optString("id");
                    axbVar2.b = jSONObjectOptJSONObject5.optString("name");
                    axbVar2.c = jSONObjectOptJSONObject5.optString("artistName");
                    axbVar2.d = jSONObjectOptJSONObject5.optString("albumName");
                    axbVar2.e = jSONObjectOptJSONObject5.optInt("lengthInSeconds");
                    axbVar2.f = jSONObjectOptJSONObject5.optString("genre");
                    axbVar2.g = jSONObjectOptJSONObject5.optString("label");
                    axbVar2.h = jSONObjectOptJSONObject5.optString("releaseYear");
                    axbVar2.i = awp.a(jSONObjectOptJSONObject5);
                    JukeMusicDataLocal jukeMusicDataLocalA = a(axbVar2);
                    if (jukeMusicDataLocalA != null) {
                        arrayList5.add(jukeMusicDataLocalA);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("rel", "catalog:track");
                        jSONObject2.put("href", axbVar2.i.get("catalog:track"));
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    jSONArray2.put(jSONObject2);
                }
                i++;
            }
            if (str2.compareTo("play") == 0) {
                a((List<MusicData>) arrayList5);
                return;
            }
            if (str2.compareTo("play_next") == 0) {
                b((List<MusicData>) arrayList5);
                return;
            } else if (str2.compareTo("add") == 0) {
                d(arrayList5);
                return;
            } else {
                if (str2.compareTo("playlist") == 0) {
                    axc.a().a(axc.a().e, "user:playlists", (axd.b) this, jSONArray2.toString(), "", -1, -1, true);
                    return;
                }
                return;
            }
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 20, true);
            return;
        }
        if (str.compareTo("catalog:artist") == 0) {
            if (jSONObject != null) {
                awx awxVar2 = new awx();
                awxVar2.a = jSONObject.optString("id");
                awxVar2.b = jSONObject.optString("name");
                awxVar2.g = awp.a(jSONObject);
                axj axiVar = new axi();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", awxVar2);
                axiVar.g(bundle2);
                a(axiVar);
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
        al();
        Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.juke_search_results, (ViewGroup) null);
        this.aB = (TabPageIndicator) this.b.findViewById(R.id.indicator);
        this.aB.setTitles(new CharSequence[]{this.ae.getString(R.string.JukeArtists), this.ae.getString(R.string.JukeAlbums), this.ae.getString(R.string.JukeTracks)});
        this.aB.setOnTabReselectedListener(this.a);
        this.aj = (AnimationListView) this.b.findViewById(R.id.tracks_list_view);
        this.am = this.b.findViewById(R.id.tracks_list_view_holder);
        this.aj.setEmptyView(this.b.findViewById(R.id.tracks_list_view_empty));
        this.ap = this.b.findViewById(R.id.tracks_list_view_empty_text);
        this.ap.setVisibility(4);
        this.ak = (AnimationListView) this.b.findViewById(R.id.artists_listview);
        this.an = this.b.findViewById(R.id.artists_listview_holder);
        this.ak.setEmptyView(this.b.findViewById(R.id.artists_listview_empty));
        this.aq = this.b.findViewById(R.id.artists_listview_empty_text);
        this.aq.setVisibility(4);
        this.al = (AnimationGridView) this.b.findViewById(R.id.albums_gridview);
        this.ao = this.b.findViewById(R.id.albums_gridview_holder);
        this.al.setEmptyView(this.b.findViewById(R.id.albums_gridview_empty));
        this.ar = this.b.findViewById(R.id.albums_gridview_empty_text);
        this.ar.setVisibility(4);
        this.av = new aic<>(this.ae, new c(), 20, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        this.aw = new aic<>(this.ae, new a(), 20, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        this.ax = new aic<>(this.ae, new b(), 20, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        try {
            this.av.a(this.ay);
            this.aw.a(this.az);
            this.ax.a(this.aA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.aj.setAdapter((ListAdapter) this.av);
        this.ak.setAdapter((ListAdapter) this.ax);
        this.al.setAdapter((ListAdapter) this.aw);
        return this.b;
    }

    protected void d(int i) {
        this.at = 0;
        this.au = i;
        switch (i) {
            case 0:
                this.am.setVisibility(8);
                if (am()) {
                    this.an.setVisibility(4);
                } else {
                    this.an.setVisibility(0);
                }
                this.ao.setVisibility(8);
                this.aq.setVisibility(4);
                this.ap.setVisibility(4);
                this.ar.setVisibility(4);
                break;
            case 1:
                this.am.setVisibility(8);
                this.an.setVisibility(8);
                this.ao.setVisibility(0);
                this.aq.setVisibility(4);
                this.ap.setVisibility(4);
                this.ar.setVisibility(4);
                break;
            case 2:
                this.am.setVisibility(0);
                this.an.setVisibility(8);
                this.ao.setVisibility(8);
                this.aq.setVisibility(4);
                this.ap.setVisibility(4);
                this.ar.setVisibility(4);
                break;
        }
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.al.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.aj.setAdapter((ListAdapter) this.av);
        this.ak.setAdapter((ListAdapter) this.ax);
        this.al.setAdapter((ListAdapter) this.aw);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a().h(0).g(R.string.JukeSearchResults).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.au = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.h = (Bundle) bundle.clone();
        }
        this.aB.setCurrentItem(this.au);
        d(this.au);
        this.aC = bundle.getString("search_term");
        d();
        this.ay.clear();
        this.az.clear();
        this.aA.clear();
        try {
            this.av.a(this.ay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.av.notifyDataSetChanged();
        try {
            this.ax.a(this.aA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ax.notifyDataSetChanged();
        try {
            this.aw.a(this.az);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.aw.notifyDataSetChanged();
        axc.a().a("catalog:track-search", this, "{criterion}", this.aC, 0, 20);
        axc.a().a("catalog:artist-search", this, "{criterion}", this.aC, 0, 20);
        axc.a().a("catalog:album-search", this, "{criterion}", this.aC, 0, 20);
        this.aj.setOnItemChosenListener(this.aH);
        this.aj.setOnScrollListener(new awv(this.ae));
        if (ahn.a()) {
            this.aj.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.al.setOnItemChosenListener(this.aG);
        this.al.setOnItemClickListener(this.aJ);
        this.al.setOnScrollListener(new awv(this.ae));
        this.ak.setOnItemClickListener(this.aI);
        this.ak.setOnScrollListener(new awv(this.ae));
        this.ak.setOnItemChosenListener(new ajn() { // from class: axw.2
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                awp.a((awx) obj);
            }
        });
    }

    class c implements aic.a<axb>, View.OnClickListener {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            mm.b("MCurrPage", "mCurrPage = " + axw.this.at + " and size = " + i2);
            if (axw.this.aE.containsKey("next")) {
                axw.this.d();
                axc.a().a(axw.this.aE, "next", axw.this, "catalog:track-search", "", axw.this.at * i2, i2);
            } else {
                axw.this.al();
            }
            axw.e(axw.this);
        }

        @Override // aic.a
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
            aVar.b.setText("" + (i + 1));
            aVar.c.setText(axbVar.b);
            aVar.d.setText(axbVar.c);
            aVar.e.setVisibility(0);
            aVar.e.setText("" + awp.a(axbVar.e));
            bif.a((Context) axw.this.ae).a(axbVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(aVar.a);
            aVar.f.setTag(axbVar);
            aVar.f.setOnClickListener(this);
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axw.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axw.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axw.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axw.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axw.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axw.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axw.this.b(axbVar)) {
                arrayList.add(axw.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axw.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axw.this.ae.getString(R.string.JukeGoArtist));
            if (axbVar.i.containsKey("catalog:album") && axbVar.i.get("catalog:album") != null) {
                arrayList.add(axw.this.ae.getString(R.string.JukeGoAlbum));
            }
            arzVar.a(arrayList);
            arzVar.a(axw.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axw.c.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axw.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(axbVar.i, "user:favorite-track", axw.this, "");
                                                            axw.this.d(axbVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axw.this.d(awp.a(axbVar));
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:album", axw.this, "view", "", -1, -1);
                                                axw.this.d();
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "catalog:artist", axw.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(axbVar.i, "user:favorite-track", axw.this);
                                        axw.this.c(axbVar);
                                        return;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("rel", "catalog:track");
                                        jSONObject.put("href", axbVar.i.get("catalog:track"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    jSONArray.put(jSONObject);
                                    axw.this.d();
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axw.this, jSONArray.toString(), "", -1, -1, true);
                                    return;
                                }
                                c.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            c.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        c.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axw.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MusicData musicData) {
            axw.this.p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().b(musicData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(MusicData musicData) {
            MusicPlaylistManager.a().c(musicData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(MusicData musicData) {
            MusicPlaylistManager.a().d(musicData);
        }
    }

    class a implements aic.a<aww>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (axw.this.aD.containsKey("next")) {
                axw.this.d();
                axc.a().a(axw.this.aD, "next", axw.this, "catalog:album-search", "", axw.this.at * i2, i2);
            } else {
                axw.this.al();
            }
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, aww awwVar) {
            C0087a c0087a;
            C0087a c0087a2 = (C0087a) view.getTag();
            if (c0087a2 == null) {
                c0087a = new C0087a();
                c0087a.a = (ImageView) view.findViewById(R.id.iv);
                c0087a.b = (TextView) view.findViewById(R.id.tv);
                c0087a.c = (TextView) view.findViewById(R.id.tv_alt);
                c0087a.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                c0087a.e = (TextView) view.findViewById(R.id.tv_details);
                c0087a.f = (ImageView) view.findViewById(R.id.more_holder);
                view.setTag(c0087a);
            } else {
                c0087a = c0087a2;
            }
            c0087a.b.setText(awwVar.b);
            c0087a.c.setText(awwVar.c);
            c0087a.d.setVisibility(0);
            c0087a.e.setText("(" + awwVar.h + " - " + awwVar.f + " " + axw.this.ae.getString(R.string.JukeTracks) + ")");
            c0087a.a.setVisibility(0);
            bif.a((Context) axw.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0087a.a);
            c0087a.f.setTag(awwVar);
            c0087a.f.setOnClickListener(this);
            return view;
        }

        /* JADX INFO: renamed from: axw$a$a, reason: collision with other inner class name */
        class C0087a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public TextView e;
            public ImageView f;

            C0087a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axw.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            final aww awwVar = (aww) view.getTag();
            arz arzVar = new arz(axw.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axw.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axw.this.a(awwVar)) {
                arrayList.add(axw.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axw.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axw.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(axw.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axw.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axw.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axw.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i == arrayList.indexOf(axw.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                        axc.a().a(awwVar.i, "user:favorite-album", axw.this, "");
                                                        axw.this.c(awwVar);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                axh axhVar = new axh();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("album", awwVar);
                                                axhVar.g(bundle);
                                                axw.this.a((axj) axhVar);
                                                return;
                                            }
                                            axc.a().a(awwVar.i, "catalog:artist", axw.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(awwVar.i, "user:favorite-album", axw.this);
                                        axw.this.b(awwVar);
                                        return;
                                    }
                                    axc.a().a(awwVar.i, "catalog:album", axw.this, "playlist", "", -1, -1);
                                    axw.this.d();
                                    return;
                                }
                                axc.a().a(awwVar.i, "catalog:album", axw.this, "add", "", -1, -1);
                                return;
                            }
                            axc.a().a(awwVar.i, "catalog:album", axw.this, "play_next", "", -1, -1);
                            return;
                        }
                        axc.a().a(awwVar.i, "catalog:album", axw.this, "play", "", -1, -1);
                        return;
                    }
                    Toast.makeText(axw.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }
    }

    class b implements aic.a<awx> {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (axw.this.aF.containsKey("next")) {
                axw.this.d();
                axc.a().a(axw.this.aF, "next", axw.this, "catalog:artist-search", "", axw.this.at * i2, i2);
            } else {
                axw.this.al();
            }
        }

        @Override // aic.a
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
                aVar2.e.setVisibility(8);
                aVar2.a.setVisibility(8);
                aVar2.f.setVisibility(8);
                aVar2.b.setVisibility(8);
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
}
