package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axq extends axk implements axd.b {
    private TabPageIndicator aB;
    private TextView aC;
    private TextView aD;
    private ImageView aE;
    private HashMap<String, String> aG;
    private HashMap<String, String> aH;
    private HashMap<String, String> aI;
    private View aj;
    private AnimationListView ak;
    private ListView al;
    private AnimationGridView am;
    private View an;
    private View ao;
    private View ap;
    private View aq;
    private View ar;
    private View as;
    private aic<axb> av;
    private aic<aww> aw;
    private aic<awx> ax;
    private final int at = 50;
    private int au = 1;
    public int a = 0;
    private ArrayList<axb> ay = new ArrayList<>();
    private ArrayList<aww> az = new ArrayList<>();
    private ArrayList<awx> aA = new ArrayList<>();
    private String aF = "";
    private boolean aJ = false;
    private boolean aK = false;
    private boolean aL = false;
    TabPageIndicator.a b = new TabPageIndicator.a() { // from class: axq.5
        @Override // com.musicservice.juke.TabPageIndicator.a
        public void a(int i) {
            axq.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener aM = new AdapterView.OnItemClickListener() { // from class: axq.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axi axiVar = new axi();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Serializable) axq.this.aA.get(i));
            axiVar.g(bundle);
            axq.this.a((axj) axiVar);
        }
    };
    private AdapterView.OnItemClickListener aN = new AdapterView.OnItemClickListener() { // from class: axq.8
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axh axhVar = new axh();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) axq.this.az.get(i));
            axhVar.g(bundle);
            axq.this.a((axj) axhVar);
        }
    };
    private ajn aO = new ajn() { // from class: axq.9
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                axc.a().a(((aww) obj).i, "catalog:album", axq.this, "play", "", -1, -1);
            }
        }
    };
    private int aP = 0;
    private int aQ = 0;
    private boolean aR = true;
    private AbsListView.OnScrollListener aS = new AbsListView.OnScrollListener() { // from class: axq.10
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                mm.b();
                axq.this.ap();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            axq.this.aP = i;
            axq.this.aQ = i2;
            if (axq.this.aR && i2 > 0) {
                axq.this.ap();
                axq.this.aR = false;
            }
        }
    };
    private int aT = 0;

    static /* synthetic */ int q(axq axqVar) {
        int i = axqVar.au;
        axqVar.au = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) throws JSONException {
        int iOptInt;
        int length;
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        int i = 0;
        if (str.compareTo("user:favorite-tracks") == 0) {
            this.aL = false;
            mm.b("FAVTRACKS", jSONObject.toString());
            try {
                jSONArray2 = jSONObject.getJSONArray("favoriteTracks");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.aH = awp.a(jSONObject);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i2);
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
                    axbVar.i = awp.a(jSONObjectOptJSONObject);
                    arrayList.add(axbVar);
                }
            }
            this.ay.addAll(this.ay.size(), (ArrayList) arrayList.clone());
            this.av.b(arrayList);
            mm.b("Juke", "getcount=" + this.av.getCount());
            ao();
            this.aq.setVisibility(4);
            if (this.an.getVisibility() == 4) {
                this.an.setVisibility(0);
            }
            if (this.an.getVisibility() == 0) {
                al();
            }
            if (arrayList.size() == 0) {
                this.aq.setVisibility(0);
                return;
            }
            return;
        }
        if (str.compareTo("user:favorite-albums") == 0) {
            mm.b("FAVALBUMS", jSONObject.toString());
            this.aK = false;
            try {
                jSONArray2 = jSONObject.getJSONArray("favoriteAlbums");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.aG = awp.a(jSONObject);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i3);
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
                    awwVar.i = awp.a(jSONObjectOptJSONObject2);
                    arrayList2.add(awwVar);
                }
            }
            this.az.addAll(this.az.size(), (ArrayList) arrayList2.clone());
            this.aw.b(arrayList2);
            mm.b("Juke", "Albums " + this.aw.getCount());
            this.as.setVisibility(4);
            if (this.ap.getVisibility() == 4) {
                this.ap.setVisibility(0);
            }
            if (this.ap.getVisibility() == 0) {
                al();
            }
            if (arrayList2.size() == 0) {
                this.as.setVisibility(0);
            }
            ao();
            return;
        }
        if (str.compareTo("user:favorite-artists") == 0) {
            this.aJ = false;
            mm.b("FAVARTISTS", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("favoriteArtists");
            } catch (JSONException e3) {
                e3.printStackTrace();
                jSONArray = null;
            }
            this.aI = awp.a(jSONObject);
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject3 != null) {
                    awx awxVar = new awx();
                    awxVar.a = jSONObjectOptJSONObject3.optString("id");
                    awxVar.b = jSONObjectOptJSONObject3.optString("name");
                    awxVar.g = awp.a(jSONObjectOptJSONObject3);
                    boolean z = false;
                    for (int i5 = 0; i5 < this.aA.size(); i5++) {
                        if (this.aA.get(i5).b.compareTo(awxVar.b) == 0) {
                            z = true;
                        }
                    }
                    if (!z) {
                        arrayList3.add(awxVar);
                    } else {
                        mm.b("ARTIST", "duplicate artist" + awxVar.b);
                    }
                }
            }
            this.aA.addAll(this.aA.size(), (ArrayList) arrayList3.clone());
            this.ax.b(arrayList3);
            mm.b("Juke", "" + this.ax.getCount());
            if (this.ao.getVisibility() == 4) {
                this.ao.setVisibility(0);
            }
            ao();
            this.ar.setVisibility(4);
            if (this.ao.getVisibility() == 4) {
                this.ao.setVisibility(0);
            }
            if (this.ao.getVisibility() == 0) {
                al();
            }
            if (arrayList3.size() == 0) {
                this.ar.setVisibility(0);
                return;
            }
            return;
        }
        if (str.compareTo("user:user") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            axc.a().a(awp.a(jSONObject), "user:favorite-tracks", (axd.b) this, "", "", -1, -1, true);
            axc.a().a(awp.a(jSONObject), "user:favorite-albums", (axd.b) this, "", "", -1, -1, true);
            axc.a().a(awp.a(jSONObject), "user:favorite-artists", (axd.b) this, "", "", -1, -1, true);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 50, true);
            return;
        }
        if (str.compareTo("user:favorite-tracks-by-artist") == 0) {
            this.aT--;
            mm.b("FAVTRACKSBYARTIST", jSONObject.toString());
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("favoriteTracks");
            if (jSONArrayOptJSONArray != null) {
                length = jSONArrayOptJSONArray.length();
                iOptInt = 0;
                for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i6);
                    if (jSONObjectOptJSONObject4 != null) {
                        iOptInt += jSONObjectOptJSONObject4.optInt("lengthInSeconds");
                    }
                }
            } else {
                iOptInt = 0;
                length = 0;
            }
            awx awxVar2 = (awx) new abw().a(str2, new adp<awx>() { // from class: axq.1
            }.b());
            mm.b("JUKEARTIST", "name " + awxVar2.b);
            mm.b("JUKEARTIST", "num of artists: " + this.aA.size());
            awxVar2.d = length;
            awxVar2.e = iOptInt;
            while (i < this.aA.size()) {
                awx awxVar3 = this.aA.get(i);
                if (awxVar3.b.compareTo(awxVar2.b) == 0) {
                    awxVar3.d = awxVar2.d;
                    awxVar3.e = awxVar2.e;
                    awxVar3.f = true;
                }
                i++;
            }
            try {
                this.ax.a(this.aA);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.ax.notifyDataSetChanged();
            return;
        }
        if (str.compareTo("user:favorite-albums-by-artist") == 0) {
            mm.b("FAVALBUMSBYARTIST", jSONObject.toString());
            this.aT--;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("favoriteAlbums");
            int length2 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
            awx awxVar4 = (awx) new abw().a(str2, new adp<awx>() { // from class: axq.3
            }.b());
            mm.b("JUKEARTIST", "name " + awxVar4.b);
            mm.b("JUKEARTIST", "num of artists: " + this.aA.size());
            awxVar4.c = length2;
            while (i < this.aA.size()) {
                awx awxVar5 = this.aA.get(i);
                if (awxVar5.b.compareTo(awxVar4.b) == 0) {
                    awxVar5.c = awxVar4.c;
                }
                i++;
            }
            try {
                this.ax.a(this.aA);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.ax.notifyDataSetChanged();
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList4 = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray3 == null) {
                jSONArrayOptJSONArray3 = new JSONArray();
            }
            while (i < jSONArrayOptJSONArray3.length()) {
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i);
                if (jSONObjectOptJSONObject5 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject5.optString("id");
                    awzVar.b = jSONObjectOptJSONObject5.optString("name");
                    awzVar.d = jSONObjectOptJSONObject5.optString("description");
                    awzVar.e = jSONObjectOptJSONObject5.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject5.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject5.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject5);
                    arrayList4.add(awzVar);
                }
                i++;
            }
            al();
            try {
                jSONArray2 = new JSONArray(str2);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList4, jSONArray2, this);
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
                if (str2.compareTo("view") == 0) {
                    axj axhVar = new axh();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("album", awwVar2);
                    axhVar.g(bundle);
                    a(axhVar);
                    return;
                }
            }
            try {
                jSONArray2 = jSONObject.getJSONArray("tracks");
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            JSONArray jSONArray3 = new JSONArray();
            ArrayList arrayList5 = new ArrayList();
            while (i < jSONArray2.length()) {
                JSONObject jSONObjectOptJSONObject6 = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject6 != null) {
                    axb axbVar2 = new axb();
                    axbVar2.a = jSONObjectOptJSONObject6.optString("id");
                    axbVar2.b = jSONObjectOptJSONObject6.optString("name");
                    axbVar2.c = jSONObjectOptJSONObject6.optString("artistName");
                    axbVar2.d = jSONObjectOptJSONObject6.optString("albumName");
                    axbVar2.e = jSONObjectOptJSONObject6.optInt("lengthInSeconds");
                    axbVar2.f = jSONObjectOptJSONObject6.optString("genre");
                    axbVar2.g = jSONObjectOptJSONObject6.optString("label");
                    axbVar2.h = jSONObjectOptJSONObject6.optString("releaseYear");
                    axbVar2.i = awp.a(jSONObjectOptJSONObject6);
                    JukeMusicDataLocal jukeMusicDataLocalA = a(axbVar2);
                    if (jukeMusicDataLocalA != null) {
                        arrayList5.add(jukeMusicDataLocalA);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("rel", "catalog:track");
                        jSONObject2.put("href", axbVar2.i.get("catalog:track"));
                    } catch (JSONException e8) {
                        e8.printStackTrace();
                    }
                    jSONArray3.put(jSONObject2);
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
            }
            if (str2.compareTo("add") == 0) {
                d(arrayList5);
                return;
            } else if (str2.compareTo("replace") == 0) {
                e(arrayList5);
                return;
            } else {
                if (str2.compareTo("playlist") == 0) {
                    axc.a().a(axc.a().e, "user:playlists", (axd.b) this, jSONArray3.toString(), "", -1, -1, true);
                    return;
                }
                return;
            }
        }
        if (str.compareTo("catalog:artist") == 0) {
            if (jSONObject != null) {
                awx awxVar6 = new awx();
                awxVar6.a = jSONObject.optString("id");
                awxVar6.b = jSONObject.optString("name");
                awxVar6.g = awp.a(jSONObject);
                axj axiVar = new axi();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", awxVar6);
                axiVar.g(bundle2);
                a(axiVar);
                return;
            }
            return;
        }
        if (str.compareTo("next") == 0) {
            a(str2, jSONObject, "");
            return;
        }
        if (str.compareTo("user:favorite-track") == 0) {
            d();
            c(l());
            this.aB.setCurrentItem(2);
            d(2);
            return;
        }
        if (str.compareTo("user:favorite-album") == 0) {
            d();
            c(l());
            this.aB.setCurrentItem(1);
            d(1);
        }
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
        this.aT--;
        if (str.equals("user:favorite-artists")) {
            this.aJ = false;
        } else if (str.equals("user:favorite-tracks")) {
            this.aL = false;
        } else if (str.equals("user:favorite-albums")) {
            this.aK = false;
        }
        if (str.compareTo("user:favorite-tracks-by-artist") != 0 && str.compareTo("user:favorite-albums-by-artist") != 0) {
            Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
            al();
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = layoutInflater.inflate(R.layout.juke_my_music, (ViewGroup) null);
        this.aB = (TabPageIndicator) this.aj.findViewById(R.id.indicator);
        this.aB.setTitles(new CharSequence[]{this.ae.getString(R.string.JukeArtists), this.ae.getString(R.string.JukeAlbums), this.ae.getString(R.string.JukeTracks)});
        this.aB.setOnTabReselectedListener(this.b);
        this.aC = (TextView) this.aj.findViewById(R.id.textView1);
        this.aD = (TextView) this.aj.findViewById(R.id.textView2);
        this.aE = (ImageView) this.aj.findViewById(R.id.right_image);
        ((LinearLayout) this.aj.findViewById(R.id.right_holder)).setOnClickListener(new AnonymousClass4());
        this.ak = (AnimationListView) this.aj.findViewById(R.id.tracks_list_view);
        this.an = this.aj.findViewById(R.id.tracks_list_view_holder);
        this.ak.setEmptyView(this.aj.findViewById(R.id.tracks_list_view_empty));
        this.aq = this.aj.findViewById(R.id.tracks_list_view_empty_text);
        this.al = (ListView) this.aj.findViewById(R.id.artists_listview);
        this.ao = this.aj.findViewById(R.id.artists_listview_holder);
        this.al.setEmptyView(this.aj.findViewById(R.id.artists_listview_empty));
        this.al.setOnScrollListener(this.aS);
        this.ar = this.aj.findViewById(R.id.artists_listview_empty_text);
        this.am = (AnimationGridView) this.aj.findViewById(R.id.albums_gridview);
        this.ap = this.aj.findViewById(R.id.albums_gridview_holder);
        this.am.setEmptyView(this.aj.findViewById(R.id.albums_gridview_empty));
        this.as = this.aj.findViewById(R.id.albums_gridview_empty_text);
        this.aq.setVisibility(4);
        this.ar.setVisibility(4);
        this.as.setVisibility(4);
        this.av = new aic<>(this.ae, new c(), 50, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        this.aw = new aic<>(this.ae, new a(), 50, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        this.ax = new aic<>(this.ae, new b(), 50, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        try {
            this.av.a(this.ay);
            this.aw.a(this.az);
            this.ax.a(this.aA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ak.setAdapter((ListAdapter) this.av);
        this.al.setAdapter((ListAdapter) this.ax);
        this.am.setAdapter((ListAdapter) this.aw);
        return this.aj;
    }

    /* JADX INFO: renamed from: axq$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            arz arzVar = new arz(axq.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axq.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axq.this.ae.getString(R.string.JukeAddAllToQueue));
            arzVar.a(arrayList);
            arzVar.a(axq.this.a(R.string.JukeMyMusic));
            arzVar.a(new asi() { // from class: axq.4.1
                @Override // defpackage.asi
                public void a(int i) {
                    int i2 = 0;
                    if (i == arrayList.indexOf(axq.this.ae.getString(R.string.JukeReplaceQueue))) {
                        MusicPlaylistManager.a().g();
                        if (axq.this.aF.compareTo(axq.this.a(R.string.JukeAlbums)) != 0) {
                            if (axq.this.aF.compareTo(axq.this.a(R.string.JukeTracks)) == 0) {
                                ArrayList arrayList2 = (ArrayList) axq.this.ay.clone();
                                Collections.shuffle(arrayList2);
                                while (i2 < arrayList2.size()) {
                                    axq.this.b(awp.a((axb) arrayList2.get(i2)));
                                    i2++;
                                }
                                return;
                            }
                            if (axq.this.aF.compareTo(axq.this.a(R.string.JukeArtists)) == 0) {
                                ArrayList arrayList3 = (ArrayList) axq.this.ay.clone();
                                Collections.shuffle(arrayList3);
                                while (i2 < arrayList3.size()) {
                                    axq.this.b(awp.a((axb) arrayList3.get(i2)));
                                    i2++;
                                }
                                return;
                            }
                            return;
                        }
                        axq.this.d();
                        ArrayList arrayList4 = axq.this.aF.compareTo(axq.this.ae.getString(R.string.JukeRecommended)) == 0 ? (ArrayList) axq.this.az.clone() : (ArrayList) axq.this.az.clone();
                        Collections.shuffle(arrayList4);
                        final ArrayList arrayList5 = new ArrayList();
                        int size = arrayList4.size() < 100 ? arrayList4.size() : 100;
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList5.add(false);
                        }
                        for (final int i4 = 0; i4 < size; i4++) {
                            axc.a().a(((aww) arrayList4.get(i4)).i, "catalog:album", new axd.b() { // from class: axq.4.1.1
                                @Override // axd.b
                                public void a(String str, JSONObject jSONObject, String str2) {
                                    mm.b("CATALOG", jSONObject.toString());
                                    JSONArray jSONArray = null;
                                    try {
                                        jSONArray = jSONObject.getJSONArray("tracks");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    ArrayList arrayList6 = new ArrayList();
                                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i5);
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
                                            axbVar.i = awp.a(jSONObjectOptJSONObject);
                                            arrayList6.add(awp.a(axbVar));
                                            JSONObject jSONObject2 = new JSONObject();
                                            try {
                                                jSONObject2.put("rel", "catalog:track");
                                                jSONObject2.put("href", axbVar.i.get("catalog:track"));
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                            jSONArray2.put(jSONObject2);
                                        }
                                    }
                                    arrayList5.set(i4, true);
                                    axq.this.d(arrayList6);
                                    if (!arrayList5.contains(false)) {
                                        axq.this.al();
                                        MusicPlaylistManager.a().e(0);
                                    }
                                }

                                @Override // axd.b
                                public void a(String str, JSONArray jSONArray) {
                                }

                                @Override // axd.b
                                public void a(String str, String str2) {
                                    arrayList5.set(i4, true);
                                    if (!arrayList5.contains(false) && MusicPlaylistManager.a().w()) {
                                        axq.this.al();
                                        MusicPlaylistManager.a().e(0);
                                    }
                                }
                            }, "shufflePlay", "", 0, 50);
                        }
                        return;
                    }
                    if (i == arrayList.indexOf(axq.this.ae.getString(R.string.JukeAddAllToQueue))) {
                        if (axq.this.aF.compareTo(axq.this.a(R.string.JukeAlbums)) != 0) {
                            if (axq.this.aF.compareTo(axq.this.a(R.string.JukeTracks)) == 0) {
                                ArrayList arrayList6 = (ArrayList) axq.this.ay.clone();
                                Collections.shuffle(arrayList6);
                                while (i2 < arrayList6.size()) {
                                    axq.this.c(awp.a((axb) arrayList6.get(i2)));
                                    i2++;
                                }
                                return;
                            }
                            if (axq.this.aF.compareTo(axq.this.a(R.string.JukeArtists)) == 0) {
                                ArrayList arrayList7 = (ArrayList) axq.this.ay.clone();
                                Collections.shuffle(arrayList7);
                                while (i2 < arrayList7.size()) {
                                    axq.this.c(awp.a((axb) arrayList7.get(i2)));
                                    i2++;
                                }
                                return;
                            }
                            return;
                        }
                        axq.this.d();
                        ArrayList arrayList8 = axq.this.aF.compareTo(axq.this.ae.getString(R.string.JukeRecommended)) == 0 ? (ArrayList) axq.this.az.clone() : (ArrayList) axq.this.az.clone();
                        Collections.shuffle(arrayList8);
                        final ArrayList arrayList9 = new ArrayList();
                        int size2 = arrayList8.size() < 100 ? arrayList8.size() : 100;
                        for (int i5 = 0; i5 < size2; i5++) {
                            arrayList9.add(false);
                        }
                        for (final int i6 = 0; i6 < size2; i6++) {
                            axc.a().a(((aww) arrayList8.get(i6)).i, "catalog:album", new axd.b() { // from class: axq.4.1.2
                                @Override // axd.b
                                public void a(String str, JSONObject jSONObject, String str2) {
                                    mm.b("CATALOG", jSONObject.toString());
                                    JSONArray jSONArray = null;
                                    try {
                                        jSONArray = jSONObject.getJSONArray("tracks");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    ArrayList arrayList10 = new ArrayList();
                                    for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i7);
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
                                            axbVar.i = awp.a(jSONObjectOptJSONObject);
                                            arrayList10.add(awp.a(axbVar));
                                            JSONObject jSONObject2 = new JSONObject();
                                            try {
                                                jSONObject2.put("rel", "catalog:track");
                                                jSONObject2.put("href", axbVar.i.get("catalog:track"));
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                            jSONArray2.put(jSONObject2);
                                        }
                                    }
                                    arrayList9.set(i6, true);
                                    axq.this.d(arrayList10);
                                    if (!arrayList9.contains(false)) {
                                        axq.this.al();
                                        MusicPlaylistManager.a().e(0);
                                    }
                                }

                                @Override // axd.b
                                public void a(String str, JSONArray jSONArray) {
                                }

                                @Override // axd.b
                                public void a(String str, String str2) {
                                    arrayList9.set(i6, true);
                                    if (!arrayList9.contains(false) && MusicPlaylistManager.a().w()) {
                                        axq.this.al();
                                        MusicPlaylistManager.a().e(0);
                                    }
                                }
                            }, "shufflePlay", "", 0, 50);
                        }
                    }
                }
            });
            arzVar.show();
        }
    }

    public void ao() {
        String str = "";
        if (this.aF.compareTo(a(R.string.JukeArtists)) == 0) {
            str = "" + this.aA.size();
        } else if (this.aF.compareTo(a(R.string.JukeAlbums)) == 0) {
            str = "" + this.az.size();
        } else if (this.aF.compareTo(a(R.string.JukeTracks)) == 0) {
            str = "" + this.ay.size();
        }
        this.aC.setText(str + " " + this.aF);
    }

    protected void d(int i) {
        this.au = 0;
        this.a = i;
        switch (i) {
            case 0:
                this.an.setVisibility(8);
                if (am()) {
                    this.ao.setVisibility(4);
                } else {
                    this.ao.setVisibility(0);
                }
                this.ap.setVisibility(8);
                this.aF = a(R.string.JukeArtists);
                break;
            case 1:
                this.an.setVisibility(8);
                this.ao.setVisibility(8);
                this.ap.setVisibility(0);
                this.aF = a(R.string.JukeAlbums);
                break;
            case 2:
                this.an.setVisibility(0);
                this.ao.setVisibility(8);
                this.ap.setVisibility(8);
                this.aF = a(R.string.JukeTracks);
                break;
        }
        ao();
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.am.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.ak.setAdapter((ListAdapter) this.av);
        this.al.setAdapter((ListAdapter) this.ax);
        this.am.setAdapter((ListAdapter) this.aw);
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeMyMusic).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        d();
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.a = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.h = (Bundle) bundle.clone();
        }
        this.aB.setCurrentItem(this.a);
        d(this.a);
        ao();
        this.ay.clear();
        this.az.clear();
        this.aA.clear();
        this.aq.setVisibility(4);
        this.ar.setVisibility(4);
        this.as.setVisibility(4);
        this.aR = true;
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
        this.aE.setVisibility(0);
        this.aD.setText(this.ae.getString(R.string.JukeShuffleAll));
        bif.a((Context) this.ae).a(R.drawable.juke_menu_shuffle).a(this.aE);
        this.ak.setOnItemChosenListener(new ajn() { // from class: axq.6
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                JukeMusicDataLocal jukeMusicDataLocalA = axq.this.a((axb) obj);
                if (jukeMusicDataLocalA != null) {
                    axq.this.a(jukeMusicDataLocalA);
                }
            }
        });
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.ak.setLeftMargin((int) dimension);
        }
        this.am.setOnItemClickListener(this.aN);
        this.am.setOnItemChosenListener(this.aO);
        this.al.setOnItemClickListener(this.aM);
    }

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 50, true);
        }
    }

    class c implements aic.a<axb>, View.OnClickListener {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (!axq.this.aL) {
                mm.b("MCurrPage", "mCurrPage = " + axq.this.au + " and size = " + i2);
                if (axq.this.aH.containsKey("next")) {
                    axq.this.d();
                    axc.a().a(axq.this.aH, "next", (axd.b) axq.this, "user:favorite-tracks", "", axq.this.au * i2, i2, true);
                }
                axq.q(axq.this);
            }
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
            bif.a((Context) axq.this.ae).a(axbVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(aVar.a);
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
                Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = axq.this.a(axbVar);
            arz arzVar = new arz(axq.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axq.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axq.this.ae.getString(R.string.JukeAddPlaylist));
            arrayList.add(axq.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            arrayList.add(axq.this.ae.getString(R.string.JukeGoArtist));
            if (axbVar.i.containsKey("catalog:album") && axbVar.i.get("catalog:album") != null) {
                arrayList.add(axq.this.ae.getString(R.string.JukeGoAlbum));
            }
            arzVar.a(arrayList);
            arzVar.a(axq.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axq.c.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                            if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i == arrayList.indexOf(axq.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        axq.this.d(jukeMusicDataLocalA);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:album", axq.this, "view", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "catalog:artist", axq.this, "", "", -1, -1);
                                            return;
                                        }
                                        axq.this.d();
                                        axc.a().a(axbVar.i, "user:favorite-track", axq.this, "");
                                        axq.this.d(axbVar);
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
                                    axq.this.d();
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axq.this, jSONArray.toString(), "", -1, -1, true);
                                    return;
                                }
                                axq.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            axq.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        axq.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }
    }

    class a implements aic.a<aww>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (!axq.this.aK && axq.this.aG.containsKey("next")) {
                axq.this.d();
                axc.a().a(axq.this.aG, "next", (axd.b) axq.this, "user:favorite-albums", "", axq.this.au * i2, i2, true);
                axq.this.aK = true;
            }
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, aww awwVar) {
            C0080a c0080a;
            C0080a c0080a2 = (C0080a) view.getTag();
            if (c0080a2 == null) {
                c0080a = new C0080a();
                c0080a.a = (ImageView) view.findViewById(R.id.iv);
                c0080a.b = (TextView) view.findViewById(R.id.tv);
                c0080a.c = (TextView) view.findViewById(R.id.tv_alt);
                c0080a.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                c0080a.e = (TextView) view.findViewById(R.id.tv_details);
                c0080a.f = (ImageView) view.findViewById(R.id.more_holder);
                view.setTag(c0080a);
            } else {
                c0080a = c0080a2;
            }
            c0080a.b.setText(awwVar.b);
            c0080a.c.setText(awwVar.c);
            c0080a.d.setVisibility(0);
            c0080a.e.setText("(" + awwVar.h + " - " + awwVar.f + " " + axq.this.ae.getString(R.string.JukeTracks) + ")");
            c0080a.a.setVisibility(0);
            bif.a((Context) axq.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0080a.a);
            c0080a.f.setTag(awwVar);
            c0080a.f.setOnClickListener(this);
            return view;
        }

        /* JADX INFO: renamed from: axq$a$a, reason: collision with other inner class name */
        class C0080a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public TextView e;
            public ImageView f;

            C0080a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            final aww awwVar = (aww) view.getTag();
            arz arzVar = new arz(axq.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axq.this.ae.getString(R.string.PlayTip_ClearAll_Str));
            arrayList.add(axq.this.ae.getString(R.string.JukeAddPlaylist));
            arrayList.add(axq.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            arrayList.add(axq.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(axq.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axq.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axq.this.ae.getString(R.string.PlayTip_ClearAll_Str))) {
                                        if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeAddPlaylist))) {
                                            if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                if (i != arrayList.indexOf(axq.this.ae.getString(R.string.JukeGoArtist))) {
                                                    if (i == arrayList.indexOf(axq.this.ae.getString(R.string.JukeGoAlbum))) {
                                                        axh axhVar = new axh();
                                                        Bundle bundle = new Bundle();
                                                        bundle.putSerializable("album", awwVar);
                                                        axhVar.g(bundle);
                                                        axq.this.a((axj) axhVar);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                axc.a().a(awwVar.i, "catalog:artist", axq.this, "", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(awwVar.i, "user:favorite-album", axq.this, "");
                                            axq.this.c(awwVar);
                                            axq.this.d();
                                            return;
                                        }
                                        axq.this.d();
                                        axc.a().a(awwVar.i, "catalog:album", axq.this, "playlist", "", -1, -1);
                                        return;
                                    }
                                    axc.a().a(awwVar.i, "catalog:album", axq.this, "replace", "", -1, -1);
                                    return;
                                }
                                axc.a().a(awwVar.i, "catalog:album", axq.this, "add", "", -1, -1);
                                return;
                            }
                            axc.a().a(awwVar.i, "catalog:album", axq.this, "play_next", "", -1, -1);
                            return;
                        }
                        axc.a().a(awwVar.i, "catalog:album", axq.this, "play", "", -1, -1);
                        return;
                    }
                    Toast.makeText(axq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }
    }

    class b implements aic.a<awx> {
        private int b = -1;

        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (!axq.this.aJ && axq.this.aI.containsKey("next")) {
                mm.b();
                if (this.b != i) {
                    this.b = i;
                    axq.this.d();
                    axc.a().a(axq.this.aI, "next", (axd.b) axq.this, "user:favorite-artists", "", axq.this.au * i2, i2, true);
                }
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
                aVar2.f.setVisibility(8);
                aVar2.b.setVisibility(8);
                aVar2.e.setVisibility(8);
                aVar2.a.setVisibility(8);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.c.setText(awxVar.b);
            aVar.d.setText("" + awxVar.c + " " + axq.this.ae.getString(R.string.JukeAlbums) + " - " + awxVar.d + " " + axq.this.ae.getString(R.string.JukeTracks) + " - " + awp.a(awxVar.e));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        int i = this.aP + this.aQ;
        int size = i > this.aA.size() ? this.aA.size() : i;
        for (int i2 = this.aP; i2 < size; i2++) {
            awx awxVar = this.aA.get(i2);
            if (!awxVar.f) {
                if (this.aT < 10) {
                    String strA = new abw().a(awxVar);
                    axc.a().a(awxVar.g, "user:favorite-tracks-by-artist", (axd.b) this, strA, "", 0, 50, true);
                    axc.a().a(awxVar.g, "user:favorite-albums-by-artist", (axd.b) this, strA, "", 0, 50, true);
                    this.aT += 2;
                } else {
                    this.af.postDelayed(new Runnable() { // from class: axq.2
                        @Override // java.lang.Runnable
                        public void run() {
                            axq.this.ap();
                        }
                    }, 2000L);
                    return;
                }
            }
        }
    }
}
