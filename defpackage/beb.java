package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.tidal.TabPageIndicator;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
import defpackage.aic;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class beb extends bdn implements ajn, bdi.b {
    private aic<bdb> aA;
    private TabPageIndicator aF;
    private String aG;
    private boolean aH;
    private AnimationGridView ah;
    private AnimationGridView ai;
    private View aj;
    private View ak;
    private View al;
    private View ar;
    private View as;
    private View at;
    private View au;
    private View av;
    private aic<bdg> ax;
    private aic<bda> ay;
    private aic<bdc> az;
    private View f;
    private AnimationListView h;
    private AnimationGridView i;
    private HashMap<d, Integer> g = new HashMap<>();
    private final int aw = 20;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    private ArrayList<bdg> aB = new ArrayList<>();
    private ArrayList<bda> aC = new ArrayList<>();
    private ArrayList<bdc> aD = new ArrayList<>();
    private ArrayList<bdb> aE = new ArrayList<>();
    TabPageIndicator.a e = new TabPageIndicator.a() { // from class: beb.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            beb.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener aI = new AdapterView.OnItemClickListener() { // from class: beb.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdl bdlVar = new bdl();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Serializable) beb.this.aE.get(i));
            bundle.putInt("current_screen", 0);
            bdlVar.g(bundle);
            if (!ahn.a()) {
                beb.this.ae.q().a(bdlVar, (arc) null);
            } else {
                beb.this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aJ = new AdapterView.OnItemClickListener() { // from class: beb.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) beb.this.aC.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                beb.this.ae.q().a(bdkVar, (arc) null);
            } else {
                beb.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private ajn aK = new ajn() { // from class: beb.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            bcw.a((bda) obj);
        }
    };
    private ajn aL = new ajn() { // from class: beb.5
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            bcw.a((bdb) obj);
        }
    };
    private ajn aM = new ajn() { // from class: beb.6
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            beb.this.an = new bdj(bdh.a.PlaylistTracks, ((bdc) obj).b);
            beb.this.an.a(0, 100, beb.this);
        }
    };
    private AdapterView.OnItemClickListener aN = new AdapterView.OnItemClickListener() { // from class: beb.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdw bdwVar = new bdw();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) beb.this.aD.get(i));
            bdwVar.g(bundle);
            if (!ahn.a()) {
                beb.this.ae.q().a(bdwVar, (arc) null);
            } else {
                beb.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
            }
        }
    };

    enum d {
        ARTISTS,
        ALBUMS,
        PLAYLISTS,
        TRACKS
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.SearchTracks) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject2.getInt("id");
                    bdgVar.d = jSONObject2.getString("title");
                    bdgVar.e = jSONObject2.getString("url");
                    bdgVar.f = jSONObject2.getInt("duration");
                    bdgVar.j = jSONObject2.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject2.getBoolean("streamReady");
                    bdgVar.l = jSONObject2.getString("streamStartDate");
                    if (jSONObject2.has("artist")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("artist");
                        bdgVar.a = jSONObject3.getString("name");
                        bdgVar.b = "" + jSONObject3.getInt("id");
                    }
                    if (jSONObject2.has("album")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("album");
                        bdgVar.h = jSONObject4.getString("title");
                        bdgVar.g = "" + jSONObject4.getInt("id");
                        bdgVar.i = jSONObject4.getString("cover");
                    }
                    arrayList.add(bdgVar);
                    i++;
                }
                this.as.setVisibility(4);
                if (arrayList.size() == 0) {
                    this.as.setVisibility(0);
                }
                this.aB.addAll(this.aB.size(), (ArrayList) arrayList.clone());
                this.ax.b(arrayList);
                this.ax.notifyDataSetChanged();
                if (this.aj.getVisibility() == 4) {
                    this.aj.setVisibility(0);
                }
                this.aH = true;
                am();
                mm.b("TIDAL", "getcount=" + this.ax.getCount());
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (aVar == bdh.a.SearchAlbums) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                while (i < jSONArray2.length()) {
                    JSONObject jSONObject5 = jSONArray2.getJSONObject(i);
                    bda bdaVar = new bda();
                    bdaVar.a = "" + jSONObject5.getInt("id");
                    bdaVar.e = jSONObject5.getString("cover");
                    bdaVar.b = jSONObject5.getString("title");
                    bdaVar.f = jSONObject5.getInt("numberOfTracks");
                    if (jSONObject5.has("artist")) {
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("artist");
                        bdaVar.c = jSONObject6.getString("name");
                        bdaVar.d = "" + jSONObject6.getInt("id");
                    }
                    mm.b("ALBUM", "adding " + bdaVar.b);
                    arrayList2.add(bdaVar);
                    i++;
                }
                this.au.setVisibility(4);
                if (arrayList2.size() == 0) {
                    this.au.setVisibility(0);
                }
                this.aC.addAll(this.aC.size(), (ArrayList) arrayList2.clone());
                this.ay.b(arrayList2);
                mm.b("TIDAL", "Albums " + this.ay.getCount());
                this.ay.notifyDataSetChanged();
            } catch (JSONException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else if (aVar == bdh.a.SearchArtists) {
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject7 = jSONArray3.getJSONObject(i);
                    bdb bdbVar = new bdb();
                    bdbVar.a = "" + jSONObject7.getString("name");
                    bdbVar.b = "" + jSONObject7.getInt("id");
                    bdbVar.c = jSONObject7.getString("picture");
                    arrayList3.add(bdbVar);
                    i++;
                }
                this.at.setVisibility(4);
                if (arrayList3.size() == 0) {
                    this.at.setVisibility(0);
                }
                this.aE.addAll(this.aE.size(), (ArrayList) arrayList3.clone());
                this.aA.b(arrayList3);
                mm.b("TIDAL", "" + this.aA.getCount());
                this.aA.notifyDataSetChanged();
                if (this.ak.getVisibility() == 4) {
                    this.ak.setVisibility(0);
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } else if (aVar == bdh.a.SearchPlaylists) {
            ArrayList arrayList4 = new ArrayList();
            try {
                JSONArray jSONArray4 = jSONObject.getJSONArray("items");
                while (i < jSONArray4.length()) {
                    JSONObject jSONObject8 = jSONArray4.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject8.getString("description");
                    bdcVar.d = jSONObject8.getInt("duration");
                    bdcVar.a = jSONObject8.getString("title");
                    bdcVar.e = jSONObject8.getString("url");
                    bdcVar.b = jSONObject8.getString("uuid");
                    bdcVar.f = jSONObject8.getInt("numberOfTracks");
                    bdcVar.h = jSONObject8.getString("image");
                    if (jSONObject8.has("creator")) {
                        int i2 = jSONObject8.getJSONObject("creator").getInt("id");
                        if (i2 == 0) {
                            bdcVar.g = q().getString(R.string.SettingTidal_Str);
                        } else if (("" + i2).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar.g = q().getString(R.string.TidalMe);
                        } else {
                            bdcVar.g = "" + i2;
                        }
                    }
                    arrayList4.add(bdcVar);
                    i++;
                }
                this.av.setVisibility(4);
                if (arrayList4.size() == 0) {
                    this.av.setVisibility(0);
                }
                this.aD.addAll(this.aD.size(), (ArrayList) arrayList4.clone());
                this.az.b(arrayList4);
                mm.b("TIDAL", "" + this.az.getCount());
                this.az.notifyDataSetChanged();
            } catch (JSONException e8) {
                e8.printStackTrace();
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar2 = new bda();
            try {
                bdaVar2.a = "" + jSONObject.getInt("id");
                bdaVar2.e = jSONObject.getString("cover");
                bdaVar2.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject9 = jSONObject.getJSONObject("artist");
                    bdaVar2.c = jSONObject9.getString("name");
                    bdaVar2.d = "" + jSONObject9.getInt("id");
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            am();
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", bdaVar2);
            bdkVar.g(bundle);
            if (ahn.a()) {
                this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdkVar, (arc) null);
            }
        } else if (aVar == bdh.a.ArtistMetaData) {
            bdb bdbVar2 = new bdb();
            try {
                bdbVar2.a = "" + jSONObject.getString("name");
                bdbVar2.b = jSONObject.getString("id");
                bdbVar2.c = jSONObject.getString("picture");
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            am();
            bdl bdlVar = new bdl();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", bdbVar2);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdlVar, (arc) null);
            }
        } else if (aVar == bdh.a.UserPlaylists) {
            ArrayList arrayList5 = new ArrayList();
            try {
                JSONArray jSONArray5 = jSONObject.getJSONArray("items");
                while (i < jSONArray5.length()) {
                    JSONObject jSONObject10 = jSONArray5.getJSONObject(i);
                    bdc bdcVar2 = new bdc();
                    bdcVar2.c = jSONObject10.getString("description");
                    bdcVar2.d = jSONObject10.getInt("duration");
                    bdcVar2.a = jSONObject10.getString("title");
                    bdcVar2.e = jSONObject10.getString("url");
                    bdcVar2.b = jSONObject10.getString("uuid");
                    bdcVar2.f = jSONObject10.getInt("numberOfTracks");
                    arrayList5.add(bdcVar2);
                    i++;
                }
                am();
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList5, str, this);
            } catch (JSONException e12) {
                e12.printStackTrace();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        } else if (aVar == bdh.a.Radio) {
            ArrayList arrayList6 = new ArrayList();
            try {
                JSONArray jSONArray6 = jSONObject.getJSONArray("items");
                for (int i3 = 0; i3 < jSONArray6.length(); i3++) {
                    JSONObject jSONObject11 = jSONArray6.getJSONObject(i3);
                    bdg bdgVar2 = new bdg();
                    bdgVar2.c = "" + jSONObject11.getInt("id");
                    bdgVar2.d = jSONObject11.getString("title");
                    bdgVar2.e = jSONObject11.getString("url");
                    bdgVar2.f = jSONObject11.getInt("duration");
                    bdgVar2.j = jSONObject11.getBoolean("allowStreaming");
                    bdgVar2.k = jSONObject11.getBoolean("streamReady");
                    bdgVar2.l = jSONObject11.getString("streamStartDate");
                    if (jSONObject11.has("artist")) {
                        JSONObject jSONObject12 = jSONObject11.getJSONObject("artist");
                        bdgVar2.a = jSONObject12.getString("name");
                        bdgVar2.b = "" + jSONObject12.getInt("id");
                    }
                    if (jSONObject11.has("album")) {
                        JSONObject jSONObject13 = jSONObject11.getJSONObject("album");
                        bdgVar2.h = jSONObject13.getString("title");
                        bdgVar2.g = "" + jSONObject13.getInt("id");
                        bdgVar2.i = jSONObject13.getString("cover");
                    }
                    arrayList6.add(bdgVar2);
                }
                new ArrayList();
                TidalRadio tidalRadio = new TidalRadio();
                tidalRadio.a(str);
                for (int i4 = 0; i4 < arrayList6.size(); i4++) {
                    TidalMusicDataLocal tidalMusicDataLocalA = bdh.a((bdg) arrayList6.get(i4));
                    if (tidalMusicDataLocalA != null) {
                        tidalRadio.a(tidalMusicDataLocalA);
                    }
                }
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(tidalRadio);
            } catch (JSONException e14) {
                e14.printStackTrace();
            } catch (Exception e15) {
                e15.printStackTrace();
            }
        }
        am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        this.g.put(dVar, Integer.valueOf(this.g.get(dVar).intValue() + 1));
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g.put(d.ARTISTS, 1);
        this.g.put(d.ALBUMS, 1);
        this.g.put(d.PLAYLISTS, 1);
        this.g.put(d.TRACKS, 1);
        this.f = layoutInflater.inflate(R.layout.tidal_search_results, (ViewGroup) null);
        this.aF = (TabPageIndicator) this.f.findViewById(R.id.indicator);
        this.aF.setTitles(new CharSequence[]{q().getString(R.string.TidalArtists), q().getString(R.string.TidalAlbums), q().getString(R.string.TidalPlaylists), q().getString(R.string.TidalTracks)});
        this.aF.setOnTabReselectedListener(this.e);
        this.h = (AnimationListView) this.f.findViewById(R.id.tracks_list_view);
        this.aj = this.f.findViewById(R.id.tracks_list_view_holder);
        this.h.setEmptyView(this.f.findViewById(R.id.tracks_list_view_empty));
        this.as = this.f.findViewById(R.id.tracks_list_view_empty_text);
        this.as.setVisibility(4);
        this.i = (AnimationGridView) this.f.findViewById(R.id.artists_gridview);
        this.ak = this.f.findViewById(R.id.artists_gridview_holder);
        this.i.setEmptyView(this.f.findViewById(R.id.artists_gridview_empty));
        this.at = this.f.findViewById(R.id.artists_gridview_empty_text);
        this.at.setVisibility(4);
        this.ah = (AnimationGridView) this.f.findViewById(R.id.albums_gridview);
        this.al = this.f.findViewById(R.id.albums_gridview_holder);
        this.ah.setEmptyView(this.f.findViewById(R.id.albums_gridview_empty));
        this.au = this.f.findViewById(R.id.albums_gridview_empty_text);
        this.au.setVisibility(4);
        this.ai = (AnimationGridView) this.f.findViewById(R.id.playlist_gridview);
        this.ar = this.f.findViewById(R.id.playlist_gridview_holder);
        this.ai.setEmptyView(this.f.findViewById(R.id.playlist_gridview_empty));
        this.av = this.f.findViewById(R.id.playlist_gridview_empty_text);
        this.av.setVisibility(4);
        this.ax = new aic<>(this.ae, new e(), 20, R.layout.tidal_track_item, R.layout.harman_list_loading);
        this.ay = new aic<>(this.ae, new a(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        this.aA = new aic<>(this.ae, new b(), 20, R.layout.tidal_artist_gridview_item, R.layout.tidal_empty_gridview);
        this.az = new aic<>(this.ae, new c(), 20, R.layout.tidal_gridview_item, R.layout.tidal_empty_gridview);
        this.h.setAdapter((ListAdapter) this.ax);
        this.i.setAdapter((ListAdapter) this.aA);
        this.ah.setAdapter((ListAdapter) this.ay);
        this.ai.setAdapter((ListAdapter) this.az);
        b(q().getString(R.string.TidalSearchResults));
        return this.f;
    }

    protected void d(int i) {
        this.d = i;
        this.aF.b(i);
        this.aj.setVisibility(8);
        this.ak.setVisibility(8);
        this.ar.setVisibility(8);
        this.al.setVisibility(8);
        switch (i) {
            case 0:
                if (al()) {
                    this.ak.setVisibility(4);
                } else {
                    this.ak.setVisibility(0);
                }
                break;
            case 1:
                this.al.setVisibility(0);
                break;
            case 2:
                this.ar.setVisibility(0);
                break;
            case 3:
                if (!this.aH) {
                    this.aj.setVisibility(4);
                } else {
                    this.aj.setVisibility(0);
                }
                break;
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.aG = bundle.getString("search_term");
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.aF.setCurrentItem(this.d);
        d(this.d);
        ao();
        this.h.setOnItemChosenListener(this);
        this.h.setOnScrollListener(new bcz(this.ae));
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.h.setLeftMargin((int) dimension);
        }
        this.ah.setOnItemClickListener(this.aJ);
        this.ah.setOnScrollListener(new bcz(this.ae));
        this.ah.setOnItemChosenListener(this.aK);
        this.i.setOnItemClickListener(this.aI);
        this.i.setOnScrollListener(new bcz(this.ae));
        this.i.setOnItemChosenListener(this.aL);
        this.ai.setOnItemClickListener(this.aN);
        this.ai.setOnScrollListener(new bcz(this.ae));
        this.ai.setOnItemChosenListener(this.aM);
    }

    private void ao() {
        this.aH = false;
        for (d dVar : d.values()) {
            this.g.put(dVar, 1);
        }
        this.aB.clear();
        this.aC.clear();
        this.aE.clear();
        this.aD.clear();
        try {
            this.ax.a(this.aB);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.aA.a(this.aE);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.ay.a(this.aC);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            this.az.a(this.aD);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.ax.notifyDataSetChanged();
        this.aA.notifyDataSetChanged();
        this.ay.notifyDataSetChanged();
        this.az.notifyDataSetChanged();
        bdh.a().a(bdh.a.SearchAlbums, this, this.aG, "", 0, 20);
        bdh.a().a(bdh.a.SearchArtists, this, this.aG, "", 0, 20);
        bdh.a().a(bdh.a.SearchTracks, this, this.aG, "", 0, 20);
        bdh.a().a(bdh.a.SearchPlaylists, this, this.aG, "", 0, 20);
    }

    @Override // defpackage.bdn
    public void c() {
        this.h.setAdapter((ListAdapter) this.ax);
        this.i.setAdapter((ListAdapter) this.aA);
        this.ah.setAdapter((ListAdapter) this.ay);
        this.ai.setAdapter((ListAdapter) this.az);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        a(this.aB, i);
    }

    class e implements aic.a<bdg> {
        e() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.SearchTracks, beb.this, beb.this.aG, "", ((Integer) beb.this.g.get(d.TRACKS)).intValue() * i2, 20);
            beb.this.a(d.TRACKS);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final bdg bdgVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.text1);
                aVar2.d = (TextView) view.findViewById(R.id.text2);
                aVar2.c = (TextView) view.findViewById(R.id.track_time);
                aVar2.e = (RelativeLayout) view.findViewById(R.id.more_holder);
                aVar2.b.setTypeface(bcw.a(beb.this.ae));
                aVar2.d.setTypeface(bcw.b(beb.this.ae));
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdgVar.d);
            aVar.d.setText(bdgVar.a);
            aVar.c.setVisibility(4);
            aVar.c.setTypeface(bcw.b(beb.this.ae));
            bif.a((Context) beb.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            int color = beb.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = beb.this.q().getColor(R.color.tidal_text_disabled);
            }
            aVar.b.setTextColor(color);
            aVar.d.setTextColor(color);
            aVar.c.setTextColor(color);
            aVar.e.setOnClickListener(new View.OnClickListener() { // from class: beb.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(beb.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(beb.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(beb.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(beb.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(beb.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!beb.this.a(bdgVar)) {
                        arrayList.add(beb.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(beb.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(beb.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(beb.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(beb.this.q().getString(R.string.TidalGoToArtist));
                    arrayList.add(beb.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: beb.e.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, beb.this);
                                beb.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalAddToPlaylist))) {
                                beb.this.d();
                                bdh.a().a(beb.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalPlayNext))) {
                                beb.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalAddToQueue))) {
                                beb.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, beb.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalGoToArtist))) {
                                beb.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, beb.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalGoToAlbum))) {
                                beb.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, beb.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(beb.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, beb.this);
                                beb.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                beb.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(beb.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                beb.this.d(tidalMusicDataLocalA);
                            }
                        }
                    });
                    bdpVar.show();
                }
            });
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public RelativeLayout e;

            a() {
            }
        }
    }

    class a implements aic.a<bda> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.SearchAlbums, beb.this, beb.this.aG, "", ((Integer) beb.this.g.get(d.ALBUMS)).intValue() * i2, i2);
            beb.this.a(d.ALBUMS);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            C0125a c0125a = (C0125a) view.getTag();
            if (c0125a == null) {
                C0125a c0125a2 = new C0125a();
                c0125a2.a = (ImageView) view.findViewById(R.id.iv);
                c0125a2.b = (TextView) view.findViewById(R.id.tv);
                c0125a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0125a2);
                c0125a = c0125a2;
            }
            c0125a.b.setText(bdaVar.b);
            c0125a.b.setTypeface(bcw.a(beb.this.ae));
            c0125a.c.setText(bdaVar.c);
            c0125a.c.setTypeface(bcw.b(beb.this.ae));
            bif.a((Context) beb.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0125a.a);
            return view;
        }

        /* JADX INFO: renamed from: beb$a$a, reason: collision with other inner class name */
        class C0125a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0125a() {
            }
        }
    }

    class b implements aic.a<bdb> {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.SearchArtists, beb.this, beb.this.aG, "", ((Integer) beb.this.g.get(d.ARTISTS)).intValue() * i2, i2);
            beb.this.a(d.ARTISTS);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdb bdbVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdbVar.a);
            aVar.b.setTypeface(bcw.a(beb.this.ae));
            bif.a((Context) beb.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&artistid=" + bdbVar.b).a(R.drawable.tidal_placeholder_300x225).a("tidal").a(aVar.a);
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;

            a() {
            }
        }
    }

    class c implements aic.a<bdc> {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.SearchPlaylists, beb.this, beb.this.aG, "", ((Integer) beb.this.g.get(d.PLAYLISTS)).intValue() * i2, i2);
            beb.this.a(d.PLAYLISTS);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdc bdcVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                aVar2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdcVar.a);
            aVar.b.setTypeface(bcw.a(beb.this.ae));
            aVar.c.setText(beb.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar.f)}));
            aVar.c.setTypeface(bcw.b(beb.this.ae));
            bif.a((Context) beb.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&uuid=" + bdcVar.b).a(R.drawable.tidal_placeholder_300x225).a("tidal").a(aVar.a);
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
}
