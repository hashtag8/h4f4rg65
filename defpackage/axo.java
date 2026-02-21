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
public class axo extends axk implements axd.b {
    private View aA;
    private View aB;
    private View aC;
    private View aD;
    private TextView aG;
    private TextView aH;
    private ImageView aI;
    private TabPageIndicator aJ;
    private HashMap<String, String> aK;
    private HashMap<String, String> aL;
    private HashMap<String, String> aM;
    View aj;
    String ak;
    private View ao;
    private aic<aww> ap;
    private aic<aww> aq;
    private aic<axb> ar;
    private AnimationGridView av;
    private AnimationGridView aw;
    private AnimationListView ax;
    private View ay;
    private View az;
    awy b;
    private ArrayList<aww> as = new ArrayList<>();
    private ArrayList<aww> at = new ArrayList<>();
    private ArrayList<axb> au = new ArrayList<>();
    private final int aE = 50;
    private int aF = 0;
    int a = 0;
    boolean al = false;
    HashMap<String, String> am = new HashMap<>();
    TabPageIndicator.a an = new TabPageIndicator.a() { // from class: axo.2
        @Override // com.musicservice.juke.TabPageIndicator.a
        public void a(int i) {
            axo.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener aN = new AdapterView.OnItemClickListener() { // from class: axo.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axh axhVar = new axh();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) axo.this.as.get(i));
            axhVar.g(bundle);
            axo.this.a((axj) axhVar);
        }
    };
    private AdapterView.OnItemClickListener aO = new AdapterView.OnItemClickListener() { // from class: axo.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axh axhVar = new axh();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) axo.this.at.get(i));
            axhVar.g(bundle);
            axo.this.a((axj) axhVar);
        }
    };
    private ajn aP = new ajn() { // from class: axo.5
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                axc.a().a(((aww) obj).i, "catalog:album", axo.this, "play", "", -1, -1);
            }
        }
    };
    private ajn aQ = new ajn() { // from class: axo.6
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            JukeMusicDataLocal jukeMusicDataLocalA = axo.this.a((axb) obj);
            if (jukeMusicDataLocalA != null) {
                axo.this.a(jukeMusicDataLocalA);
            }
        }
    };

    static /* synthetic */ int r(axo axoVar) {
        int i = axoVar.aF;
        axoVar.aF = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray = null;
        int i = 0;
        if (str.compareTo("catalog:genre") == 0) {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("collections");
            if (jSONArrayOptJSONArray2 != null) {
                this.am = new HashMap<>();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("links")) != null) {
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i3);
                            if (jSONObjectOptJSONObject2 != null) {
                                this.am.put(jSONObjectOptJSONObject2.optString("rel"), jSONObjectOptJSONObject2.optString("href"));
                            }
                        }
                    }
                }
                axc.a().a(this.am, "catalog:recommended-albums-by-genre", this, "", "", 0, 50);
                return;
            }
            return;
        }
        if (str.compareTo("catalog:recommended-albums-by-genre") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("albums");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.aM = awp.a(jSONObject);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject3 != null) {
                    aww awwVar = new aww();
                    awwVar.a = jSONObjectOptJSONObject3.optString("id");
                    awwVar.b = jSONObjectOptJSONObject3.optString("name");
                    awwVar.c = jSONObjectOptJSONObject3.optString("artistName");
                    awwVar.f = jSONObjectOptJSONObject3.optInt("trackCount");
                    awwVar.d = jSONObjectOptJSONObject3.optString("lengthInSeconds");
                    awwVar.e = jSONObjectOptJSONObject3.optString("genre");
                    awwVar.g = jSONObjectOptJSONObject3.optString("label");
                    awwVar.h = jSONObjectOptJSONObject3.optString("releaseYear");
                    awwVar.i = awp.a(jSONObjectOptJSONObject3);
                    arrayList.add(awwVar);
                }
            }
            this.aC.setVisibility(4);
            if (arrayList.size() == 0) {
                this.aC.setVisibility(0);
            }
            this.at.addAll(this.at.size(), (ArrayList) arrayList.clone());
            this.aq.b(arrayList);
            mm.b("Juke", "Albums " + this.aq.getCount());
            this.az.setVisibility(0);
            if (this.al) {
                al();
            }
            ao();
            if (this.as.size() == 0) {
                axc.a().a(this.am, "catalog:popular-albums-by-genre", this, "", "", 0, 50);
                return;
            }
            return;
        }
        if (str.compareTo("catalog:popular-albums-by-genre") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            this.aK = awp.a(jSONObject);
            try {
                jSONArray = jSONObject.getJSONArray("albums");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(i5);
                if (jSONObjectOptJSONObject4 != null) {
                    aww awwVar2 = new aww();
                    awwVar2.a = jSONObjectOptJSONObject4.optString("id");
                    awwVar2.b = jSONObjectOptJSONObject4.optString("name");
                    awwVar2.c = jSONObjectOptJSONObject4.optString("artistName");
                    awwVar2.f = jSONObjectOptJSONObject4.optInt("trackCount");
                    awwVar2.d = jSONObjectOptJSONObject4.optString("lengthInSeconds");
                    awwVar2.e = jSONObjectOptJSONObject4.optString("genre");
                    awwVar2.g = jSONObjectOptJSONObject4.optString("label");
                    awwVar2.h = jSONObjectOptJSONObject4.optString("releaseYear");
                    jSONObjectOptJSONObject4.optJSONArray("links");
                    awwVar2.i = awp.a(jSONObjectOptJSONObject4);
                    arrayList2.add(awwVar2);
                }
            }
            this.aB.setVisibility(4);
            if (arrayList2.size() == 0) {
                this.aB.setVisibility(0);
            }
            this.as.addAll(this.as.size(), (ArrayList) arrayList2.clone());
            this.ap.b(arrayList2);
            mm.b("Juke", "Albums " + this.ap.getCount());
            ao();
            if (this.al) {
                al();
            }
            if (this.au.size() == 0) {
                axc.a().a(this.am, "catalog:popular-tracks-by-genre", this, "", "", 0, 50);
                return;
            }
            return;
        }
        if (str.compareTo("catalog:popular-tracks-by-genre") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            this.aL = awp.a(jSONObject);
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(i6);
                if (jSONObjectOptJSONObject5 != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject5.optString("id");
                    axbVar.b = jSONObjectOptJSONObject5.optString("name");
                    axbVar.c = jSONObjectOptJSONObject5.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject5.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject5.optInt("lengthInSeconds");
                    axbVar.f = jSONObjectOptJSONObject5.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject5.optString("label");
                    axbVar.h = jSONObjectOptJSONObject5.optString("releaseYear");
                    jSONObjectOptJSONObject5.optJSONArray("links");
                    axbVar.i = awp.a(jSONObjectOptJSONObject5);
                    arrayList3.add(axbVar);
                }
            }
            this.aD.setVisibility(4);
            if (arrayList3.size() == 0) {
                this.aD.setVisibility(0);
            }
            this.au.addAll(this.au.size(), (ArrayList) arrayList3.clone());
            this.ar.b(arrayList3);
            this.aA.setVisibility(0);
            mm.b("Juke", "getcount=" + this.ar.getCount());
            al();
            ao();
            this.al = true;
            return;
        }
        if (str.compareTo("catalog:album") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            if (jSONObject != null) {
                aww awwVar3 = new aww();
                awwVar3.a = jSONObject.optString("id");
                awwVar3.b = jSONObject.optString("name");
                awwVar3.c = jSONObject.optString("artistName");
                awwVar3.f = jSONObject.optInt("trackCount");
                awwVar3.d = jSONObject.optString("lengthInSeconds");
                awwVar3.e = jSONObject.optString("genre");
                awwVar3.g = jSONObject.optString("label");
                awwVar3.h = jSONObject.optString("releaseYear");
                awwVar3.i = awp.a(jSONObject);
                if (str2.compareTo("view") == 0) {
                    axj axhVar = new axh();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("album", awwVar3);
                    axhVar.g(bundle);
                    a(axhVar);
                    return;
                }
            }
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList4 = new ArrayList();
            while (i < jSONArray.length()) {
                JSONObject jSONObjectOptJSONObject6 = jSONArray.optJSONObject(i);
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
                        arrayList4.add(jukeMusicDataLocalA);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("rel", "catalog:track");
                        jSONObject2.put("href", axbVar2.i.get("catalog:track"));
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    jSONArray2.put(jSONObject2);
                }
                i++;
            }
            if (str2.compareTo("play") == 0) {
                a((List<MusicData>) arrayList4);
                return;
            }
            if (str2.compareTo("play_next") == 0) {
                b((List<MusicData>) arrayList4);
                return;
            }
            if (str2.compareTo("add") == 0) {
                d(arrayList4);
                return;
            } else if (str2.compareTo("replace") == 0) {
                e(arrayList4);
                return;
            } else {
                if (str2.compareTo("playlist") == 0) {
                    axc.a().a(axc.a().e, "user:playlists", (axd.b) this, jSONArray2.toString(), "", -1, -1, true);
                    return;
                }
                return;
            }
        }
        if (str.compareTo("next") == 0) {
            a(str2, jSONObject, "");
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList5 = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray3 == null) {
                jSONArrayOptJSONArray3 = new JSONArray();
            }
            while (i < jSONArrayOptJSONArray3.length()) {
                JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i);
                if (jSONObjectOptJSONObject7 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject7.optString("id");
                    awzVar.b = jSONObjectOptJSONObject7.optString("name");
                    awzVar.d = jSONObjectOptJSONObject7.optString("description");
                    awzVar.e = jSONObjectOptJSONObject7.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject7.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject7.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject7);
                    arrayList5.add(awzVar);
                }
                i++;
            }
            al();
            try {
                jSONArray = new JSONArray(str2);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList5, jSONArray, this);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 50, true);
            return;
        }
        if (str.compareTo("catalog:artist") == 0 && jSONObject != null) {
            awx awxVar = new awx();
            awxVar.a = jSONObject.optString("id");
            awxVar.b = jSONObject.optString("name");
            awxVar.g = awp.a(jSONObject);
            axj axiVar = new axi();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", awxVar);
            axiVar.g(bundle2);
            a(axiVar);
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
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.av.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
            this.aw.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.av.setAdapter((ListAdapter) this.ap);
        this.aw.setAdapter((ListAdapter) this.aq);
        this.ax.setAdapter((ListAdapter) this.ar);
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ao = layoutInflater.inflate(R.layout.juke_genre_detail, (ViewGroup) null);
        this.aj = this.ao.findViewById(R.id.loadingPanel);
        this.av = (AnimationGridView) this.ao.findViewById(R.id.album_gridview);
        this.ay = this.ao.findViewById(R.id.album_gridview_holder);
        this.av.setEmptyView(this.ao.findViewById(R.id.album_gridview_empty));
        this.aB = this.ao.findViewById(R.id.album_gridview_empty_text);
        this.aw = (AnimationGridView) this.ao.findViewById(R.id.recommended_gridview);
        this.az = this.ao.findViewById(R.id.recommended_gridview_holder);
        this.aw.setEmptyView(this.ao.findViewById(R.id.recommended_gridview_empty));
        this.aC = this.ao.findViewById(R.id.recommended_gridview_empty_text);
        this.ax = (AnimationListView) this.ao.findViewById(R.id.tracks_listview);
        this.aA = this.ao.findViewById(R.id.tracks_listview_holder);
        this.ax.setEmptyView(this.ao.findViewById(R.id.tracks_listview_empty));
        this.aD = this.ao.findViewById(R.id.tracks_listview_empty_text);
        this.aB.setVisibility(4);
        this.aC.setVisibility(4);
        this.aD.setVisibility(4);
        this.aG = (TextView) this.ao.findViewById(R.id.textView1);
        this.aH = (TextView) this.ao.findViewById(R.id.textView2);
        this.aI = (ImageView) this.ao.findViewById(R.id.right_image);
        ((LinearLayout) this.ao.findViewById(R.id.right_holder)).setOnClickListener(new AnonymousClass1());
        this.aJ = (TabPageIndicator) this.ao.findViewById(R.id.indicator);
        this.aJ.setTitles(new CharSequence[]{this.ae.getString(R.string.JukeRecommended), this.ae.getString(R.string.JukeAlbums), this.ae.getString(R.string.JukeTracks)});
        this.aJ.setOnTabReselectedListener(this.an);
        this.ap = new aic<>(this.ae, new a(), 50, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        try {
            this.ap.a(this.as);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.av.setAdapter((ListAdapter) this.ap);
        this.aq = new aic<>(this.ae, new b(), 50, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        try {
            this.aq.a(this.at);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.aw.setAdapter((ListAdapter) this.aq);
        this.ar = new aic<>(this.ae, new c(), 50, R.layout.juke_track_item, R.layout.juke_gridview_item_empty);
        try {
            this.ar.a(this.au);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.ax.setAdapter((ListAdapter) this.ar);
        return this.ao;
    }

    /* JADX INFO: renamed from: axo$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            arz arzVar = new arz(axo.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axo.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axo.this.ae.getString(R.string.JukeAddAllToQueue));
            arzVar.a(arrayList);
            arzVar.a(axo.this.b.a);
            arzVar.a(new asi() { // from class: axo.1.1
                @Override // defpackage.asi
                public void a(int i) {
                    int i2 = 0;
                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue))) {
                        if (i == arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddAllToQueue))) {
                            if (axo.this.ak.compareTo(axo.this.ae.getString(R.string.JukeTracks)) == 0) {
                                ArrayList arrayList2 = new ArrayList();
                                while (i2 < axo.this.au.size()) {
                                    arrayList2.add(awp.a((axb) axo.this.au.get(i2)));
                                    i2++;
                                }
                                Collections.shuffle(arrayList2);
                                axo.this.d(arrayList2);
                                return;
                            }
                            axo.this.d();
                            ArrayList arrayList3 = axo.this.ak.compareTo(axo.this.ae.getString(R.string.JukeRecommended)) == 0 ? (ArrayList) axo.this.at.clone() : (ArrayList) axo.this.as.clone();
                            Collections.shuffle(arrayList3);
                            final ArrayList arrayList4 = new ArrayList();
                            int size = arrayList3.size() < 100 ? arrayList3.size() : 100;
                            for (int i3 = 0; i3 < size; i3++) {
                                arrayList4.add(false);
                            }
                            for (final int i4 = 0; i4 < size; i4++) {
                                axc.a().a(((aww) arrayList3.get(i4)).i, "catalog:album", new axd.b() { // from class: axo.1.1.2
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
                                        ArrayList arrayList5 = new ArrayList();
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
                                                arrayList5.add(awp.a(axbVar));
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
                                        arrayList4.set(i4, true);
                                        axo.this.d(arrayList5);
                                        if (!arrayList4.contains(false)) {
                                            axo.this.al();
                                        }
                                    }

                                    @Override // axd.b
                                    public void a(String str, JSONArray jSONArray) {
                                    }

                                    @Override // axd.b
                                    public void a(String str, String str2) {
                                        arrayList4.set(i4, true);
                                        if (!arrayList4.contains(false) && MusicPlaylistManager.a().w()) {
                                            axo.this.al();
                                            MusicPlaylistManager.a().e(0);
                                        }
                                    }
                                }, "shufflePlay", "", 0, 50);
                            }
                            return;
                        }
                        return;
                    }
                    MusicPlaylistManager.a().g();
                    if (axo.this.ak.compareTo(axo.this.ae.getString(R.string.JukeTracks)) == 0) {
                        ArrayList arrayList5 = new ArrayList();
                        while (i2 < axo.this.au.size()) {
                            arrayList5.add(awp.a((axb) axo.this.au.get(i2)));
                            i2++;
                        }
                        Collections.shuffle(arrayList5);
                        axo.this.c(arrayList5);
                        return;
                    }
                    axo.this.d();
                    ArrayList arrayList6 = axo.this.ak.compareTo(axo.this.ae.getString(R.string.JukeRecommended)) == 0 ? (ArrayList) axo.this.at.clone() : (ArrayList) axo.this.as.clone();
                    Collections.shuffle(arrayList6);
                    final ArrayList arrayList7 = new ArrayList();
                    int size2 = arrayList6.size() < 100 ? arrayList6.size() : 100;
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList7.add(false);
                    }
                    for (final int i6 = 0; i6 < size2; i6++) {
                        axc.a().a(((aww) arrayList6.get(i6)).i, "catalog:album", new axd.b() { // from class: axo.1.1.1
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
                                ArrayList arrayList8 = new ArrayList();
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
                                        arrayList8.add(awp.a(axbVar));
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
                                arrayList7.set(i6, true);
                                axo.this.d(arrayList8);
                                if (!arrayList7.contains(false)) {
                                    axo.this.al();
                                    MusicPlaylistManager.a().e(0);
                                }
                            }

                            @Override // axd.b
                            public void a(String str, JSONArray jSONArray) {
                            }

                            @Override // axd.b
                            public void a(String str, String str2) {
                                arrayList7.set(i6, true);
                                if (!arrayList7.contains(false) && MusicPlaylistManager.a().w()) {
                                    axo.this.al();
                                    MusicPlaylistManager.a().e(0);
                                }
                            }
                        }, "shufflePlay", "", 0, 50);
                    }
                }
            });
            arzVar.show();
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.aK = new HashMap<>();
        this.aL = new HashMap<>();
        this.aM = new HashMap<>();
    }

    public void ao() {
        String str = "";
        if (this.ak.compareTo(this.ae.getString(R.string.JukeRecommended)) == 0) {
            str = "" + this.at.size() + " " + this.ae.getString(R.string.JukeAlbums);
        } else if (this.ak.compareTo(this.ae.getString(R.string.JukeAlbums)) == 0) {
            str = "" + this.as.size() + " " + this.ae.getString(R.string.JukeAlbums);
        } else if (this.ak.compareTo(this.ae.getString(R.string.JukeTracks)) == 0) {
            str = "" + this.au.size() + " " + this.ae.getString(R.string.JukeTracks);
        }
        this.aG.setText(str);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).a(this.b.a).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.aF = 0;
        this.b = (awy) bundle.getSerializable("genre");
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.a = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.h = (Bundle) bundle.clone();
        }
        this.aJ.setCurrentItem(this.a);
        d(this.a);
        if (!this.al) {
            d();
            axc.a().a(this.b.b, "catalog:genre", this, "", "", 0, 50);
            this.as.clear();
            try {
                this.ap.a(this.as);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ap.notifyDataSetChanged();
            this.at.clear();
            try {
                this.aq.a(this.at);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.aq.notifyDataSetChanged();
            this.au.clear();
            try {
                this.ar.a(this.au);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.ar.notifyDataSetChanged();
        }
        this.av.setOnItemClickListener(this.aN);
        this.av.setOnScrollListener(new awv(this.ae));
        this.av.setOnItemChosenListener(this.aP);
        this.aw.setOnItemClickListener(this.aO);
        this.aw.setOnScrollListener(new awv(this.ae));
        this.aw.setOnItemChosenListener(this.aP);
        this.ax.setOnItemChosenListener(this.aQ);
        this.ax.setOnScrollListener(new awv(this.ae));
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.ax.setLeftMargin((int) dimension);
        }
        this.aI.setVisibility(0);
        this.aH.setText(R.string.JukeShuffleAll);
        bif.a((Context) this.ae).a(R.drawable.juke_menu_shuffle).a(this.aI);
    }

    protected void d(int i) {
        this.a = i;
        switch (i) {
            case 0:
                if (am()) {
                    this.az.setVisibility(4);
                } else {
                    this.az.setVisibility(0);
                }
                this.ay.setVisibility(8);
                this.aA.setVisibility(8);
                this.ak = this.ae.getString(R.string.JukeRecommended);
                break;
            case 1:
                this.az.setVisibility(8);
                if (am()) {
                    this.ay.setVisibility(4);
                } else {
                    this.ay.setVisibility(0);
                }
                this.aA.setVisibility(8);
                this.ak = this.ae.getString(R.string.JukeAlbums);
                break;
            case 2:
                this.az.setVisibility(8);
                this.ay.setVisibility(8);
                if (am()) {
                    this.aA.setVisibility(4);
                } else {
                    this.aA.setVisibility(0);
                }
                this.ak = this.ae.getString(R.string.JukeTracks);
                break;
        }
        ao();
    }

    class c implements aic.a<axb>, View.OnClickListener {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            mm.b("MCurrPage", "mCurrPage = " + axo.this.aF + " and size = " + i2);
            if (axo.this.aL.containsKey("next")) {
                axo.this.d();
                axc.a().a(axo.this.aL, "next", axo.this, "catalog:popular-tracks-by-genre", "", axo.this.aF * i2, i2);
            }
            axo.r(axo.this);
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
            aVar.b.setVisibility(8);
            aVar.c.setText(axbVar.b);
            aVar.d.setText(axbVar.c);
            aVar.e.setVisibility(0);
            aVar.e.setText("" + awp.a(axbVar.e));
            bif.a((Context) axo.this.ae).a(axbVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(aVar.a);
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
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axo.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axo.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axo.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axo.this.b(axbVar)) {
                arrayList.add(axo.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axo.this.ae.getString(R.string.JukeGoArtist));
            if (axbVar.i.containsKey("catalog:album") && axbVar.i.get("catalog:album") != null) {
                arrayList.add(axo.this.ae.getString(R.string.JukeGoAlbum));
            }
            arzVar.a(arrayList);
            arzVar.a(axo.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axo.c.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(axbVar.i, "user:favorite-track", axo.this, "");
                                                            axo.this.d(axbVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axo.this.d(jukeMusicDataLocalA);
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:album", axo.this, "view", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "catalog:artist", axo.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(axbVar.i, "user:favorite-track", axo.this);
                                        axo.this.c(axbVar);
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
                                    axo.this.d();
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axo.this, jSONArray.toString(), "", -1, -1, true);
                                    return;
                                }
                                axo.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            axo.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        axo.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
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
            if (axo.this.aK.containsKey("next")) {
                axo.this.d();
                axc.a().a(axo.this.aK, "next", axo.this, "catalog:popular-albums-by-genre", "", axo.this.aF * i2, i2);
            }
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, aww awwVar) {
            C0077a c0077a;
            C0077a c0077a2 = (C0077a) view.getTag();
            if (c0077a2 == null) {
                c0077a = new C0077a();
                c0077a.a = (ImageView) view.findViewById(R.id.iv);
                c0077a.b = (TextView) view.findViewById(R.id.tv);
                c0077a.c = (TextView) view.findViewById(R.id.tv_alt);
                c0077a.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                c0077a.e = (TextView) view.findViewById(R.id.tv_details);
                c0077a.f = (ImageView) view.findViewById(R.id.more_holder);
                view.setTag(c0077a);
            } else {
                c0077a = c0077a2;
            }
            c0077a.b.setText(awwVar.b);
            c0077a.c.setText(awwVar.c);
            c0077a.d.setVisibility(0);
            c0077a.e.setText("(" + awwVar.h + " - " + awwVar.f + " " + axo.this.ae.getString(R.string.JukeTracks) + ")");
            c0077a.a.setVisibility(0);
            bif.a((Context) axo.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0077a.a);
            c0077a.f.setTag(awwVar);
            c0077a.f.setOnClickListener(this);
            return view;
        }

        /* JADX INFO: renamed from: axo$a$a, reason: collision with other inner class name */
        class C0077a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public TextView e;
            public ImageView f;

            C0077a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final aww awwVar = (aww) view.getTag();
            arz arzVar = new arz(axo.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axo.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axo.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axo.this.a(awwVar)) {
                arrayList.add(axo.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axo.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(axo.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axo.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(awwVar.i, "user:favorite-album", axo.this, "");
                                                            axo.this.c(awwVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axc.a().a(awwVar.i, "catalog:album", axo.this, "replace", "", -1, -1);
                                                    return;
                                                }
                                                axh axhVar = new axh();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("album", awwVar);
                                                axhVar.g(bundle);
                                                axo.this.a((axj) axhVar);
                                                return;
                                            }
                                            axc.a().a(awwVar.i, "catalog:artist", axo.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(awwVar.i, "user:favorite-album", axo.this);
                                        axo.this.b(awwVar);
                                        return;
                                    }
                                    axc.a().a(awwVar.i, "catalog:album", axo.this, "playlist", "", -1, -1);
                                    axo.this.d();
                                    return;
                                }
                                axc.a().a(awwVar.i, "catalog:album", axo.this, "add", "", -1, -1);
                                return;
                            }
                            axc.a().a(awwVar.i, "catalog:album", axo.this, "play_next", "", -1, -1);
                            return;
                        }
                        axc.a().a(awwVar.i, "catalog:album", axo.this, "play", "", -1, -1);
                        return;
                    }
                    Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }
    }

    class b implements aic.a<aww>, View.OnClickListener {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (axo.this.aM.containsKey("next")) {
                axo.this.d();
                axc.a().a(axo.this.aM, "next", axo.this, "catalog:recommended-albums-by-genre", "", axo.this.aF * i2, i2);
            }
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, aww awwVar) {
            a aVar;
            a aVar2 = (a) view.getTag();
            if (aVar2 == null) {
                aVar = new a();
                aVar.a = (ImageView) view.findViewById(R.id.iv);
                aVar.b = (TextView) view.findViewById(R.id.tv);
                aVar.c = (TextView) view.findViewById(R.id.tv_alt);
                aVar.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                aVar.e = (TextView) view.findViewById(R.id.tv_details);
                aVar.f = (ImageView) view.findViewById(R.id.more_holder);
                view.setTag(aVar);
            } else {
                aVar = aVar2;
            }
            aVar.b.setText(awwVar.b);
            aVar.c.setText(awwVar.c);
            aVar.d.setVisibility(0);
            aVar.e.setText("(" + awwVar.h + " - " + awwVar.f + " " + axo.this.ae.getString(R.string.JukeTracks) + ")");
            aVar.a.setVisibility(0);
            bif.a((Context) axo.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(aVar.a);
            aVar.f.setTag(awwVar);
            aVar.f.setOnClickListener(this);
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public TextView e;
            public ImageView f;

            a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final aww awwVar = (aww) view.getTag();
            arz arzVar = new arz(axo.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axo.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axo.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axo.this.a(awwVar)) {
                arrayList.add(axo.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axo.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(axo.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axo.b.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axo.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axo.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(awwVar.i, "user:favorite-album", axo.this, "");
                                                            axo.this.c(awwVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axc.a().a(awwVar.i, "catalog:album", axo.this, "replace", "", -1, -1);
                                                    return;
                                                }
                                                axh axhVar = new axh();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("album", awwVar);
                                                axhVar.g(bundle);
                                                axo.this.a((axj) axhVar);
                                                return;
                                            }
                                            axc.a().a(awwVar.i, "catalog:artist", axo.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(awwVar.i, "user:favorite-album", axo.this);
                                        axo.this.b(awwVar);
                                        return;
                                    }
                                    axo.this.d();
                                    axc.a().a(awwVar.i, "catalog:album", axo.this, "playlist", "", -1, -1);
                                    return;
                                }
                                axc.a().a(awwVar.i, "catalog:album", axo.this, "add", "", -1, -1);
                                return;
                            }
                            axc.a().a(awwVar.i, "catalog:album", axo.this, "play_next", "", -1, -1);
                            return;
                        }
                        axc.a().a(awwVar.i, "catalog:album", axo.this, "play", "", -1, -1);
                        return;
                    }
                    Toast.makeText(axo.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }
    }
}
