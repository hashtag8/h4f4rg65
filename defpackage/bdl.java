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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.tidal.TabPageIndicator;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
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
public class bdl extends bdn implements bdi.b {
    private View aA;
    private View aB;
    private View aC;
    private View aD;
    private aic<bda> aG;
    private aic<bda> aH;
    private aic<bda> aI;
    private TabPageIndicator aM;
    private RelativeLayout aN;
    private View ak;
    private aic<bdg> al;
    private AnimationListView as;
    private AnimationGridView at;
    private AnimationGridView au;
    private AnimationGridView av;
    private View aw;
    private View ax;
    private View ay;
    private View az;
    bdb e;
    ImageView f;
    TextView g;
    ScrollView h;
    TextView i;
    private List<bdg> ar = new ArrayList();
    private final int aE = 20;
    private int aF = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    private ArrayList<bda> aJ = new ArrayList<>();
    private ArrayList<bda> aK = new ArrayList<>();
    private ArrayList<bda> aL = new ArrayList<>();
    TabPageIndicator.a ah = new TabPageIndicator.a() { // from class: bdl.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bdl.this.d(i);
        }
    };
    ajn ai = new ajn() { // from class: bdl.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            switch (view.getId()) {
                case R.id.list_view /* 2131689889 */:
                    bdl.this.e(i);
                    break;
                case R.id.albums_gridview /* 2131690458 */:
                    bdl.this.d((bda) bdl.this.aJ.get(i));
                    break;
                case R.id.singles_gridview /* 2131691039 */:
                    bdl.this.d((bda) bdl.this.aK.get(i));
                    break;
                case R.id.other_gridview /* 2131691043 */:
                    bdl.this.d((bda) bdl.this.aL.get(i));
                    break;
            }
        }
    };
    View.OnClickListener aj = new View.OnClickListener() { // from class: bdl.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bdp bdpVar = new bdp(bdl.this.ae, bdl.this.e.a);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(bdl.this.q().getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(bdl.this.q().getString(R.string.TidalPlayNext));
            arrayList.add(bdl.this.q().getString(R.string.TidalAddToQueue));
            arrayList.add(bdl.this.q().getString(R.string.PlayTip_ClearAll_Str));
            if (!bdl.this.a(bdl.this.e)) {
                arrayList.add(bdl.this.q().getString(R.string.TidalFavourite));
            } else {
                arrayList.add(bdl.this.q().getString(R.string.TidalUnFavourite));
            }
            bdpVar.a(arrayList);
            bdpVar.a(bdl.this.e.a);
            bdpVar.a(new asi() { // from class: bdl.3.1
                @Override // defpackage.asi
                public void a(int i) {
                    List<bdg> listE = bdl.this.an.e();
                    if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                        bdl.this.c(listE);
                        return;
                    }
                    if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.TidalPlayNext))) {
                        bdl.this.a(listE);
                        return;
                    }
                    if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.TidalAddToQueue))) {
                        bdl.this.d(listE);
                        return;
                    }
                    if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                        bdl.this.e(listE);
                        return;
                    }
                    if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.TidalFavourite))) {
                        bdh.a().e(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdl.this.e.b, bdl.this);
                        bdl.this.b(bdl.this.e);
                    } else if (((String) arrayList.get(i)).equals(bdl.this.q().getString(R.string.TidalUnFavourite))) {
                        bdh.a().e(bdl.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdl.this.e.b, bdl.this);
                        bdl.this.c(bdl.this.e);
                    }
                }
            });
            bdpVar.show();
        }
    };
    private AdapterView.OnItemClickListener aO = new AdapterView.OnItemClickListener() { // from class: bdl.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdl.this.aJ.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdl.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdl.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aP = new AdapterView.OnItemClickListener() { // from class: bdl.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdl.this.aK.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdl.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdl.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aQ = new AdapterView.OnItemClickListener() { // from class: bdl.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdl.this.aL.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdl.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdl.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int m(bdl bdlVar) {
        int i = bdlVar.aF;
        bdlVar.aF = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.ArtistAlbums) {
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
                if (arrayList.size() == 0) {
                    this.aC.setVisibility(0);
                }
                this.aJ.addAll(this.aJ.size(), (ArrayList) arrayList.clone());
                this.aG.b(arrayList);
                mm.b("TIDAL", "" + this.aG.getCount());
                this.aG.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (aVar == bdh.a.ArtistOtherAlbums) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                while (i < jSONArray2.length()) {
                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i);
                    bda bdaVar2 = new bda();
                    bdaVar2.a = "" + jSONObject4.getInt("id");
                    bdaVar2.e = jSONObject4.getString("cover");
                    bdaVar2.b = jSONObject4.getString("title");
                    bdaVar2.f = jSONObject4.getInt("numberOfTracks");
                    if (jSONObject4.has("artist")) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("artist");
                        bdaVar2.c = jSONObject5.getString("name");
                        bdaVar2.d = "" + jSONObject5.getInt("id");
                    }
                    arrayList2.add(bdaVar2);
                    i++;
                }
                if (arrayList2.size() == 0) {
                    this.aB.setVisibility(0);
                }
                this.aL.addAll(this.aL.size(), (ArrayList) arrayList2.clone());
                this.aI.b(arrayList2);
                mm.b("TIDAL", "" + this.aI.getCount());
                this.aI.notifyDataSetChanged();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (aVar == bdh.a.ArtistSinglesAlbums) {
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject6 = jSONArray3.getJSONObject(i);
                    bda bdaVar3 = new bda();
                    bdaVar3.a = "" + jSONObject6.getInt("id");
                    bdaVar3.e = jSONObject6.getString("cover");
                    bdaVar3.b = jSONObject6.getString("title");
                    bdaVar3.f = jSONObject6.getInt("numberOfTracks");
                    if (jSONObject6.has("artist")) {
                        JSONObject jSONObject7 = jSONObject6.getJSONObject("artist");
                        bdaVar3.c = jSONObject7.getString("name");
                        bdaVar3.d = "" + jSONObject7.getInt("id");
                    }
                    arrayList3.add(bdaVar3);
                    i++;
                }
                if (arrayList3.size() == 0) {
                    this.aD.setVisibility(0);
                }
                this.aK.addAll(this.aK.size(), (ArrayList) arrayList3.clone());
                this.aH.b(arrayList3);
                mm.b("TIDAL", "" + this.aH.getCount());
                this.aH.notifyDataSetChanged();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar4 = new bda();
            try {
                bdaVar4.a = "" + jSONObject.getInt("id");
                bdaVar4.e = jSONObject.getString("cover");
                bdaVar4.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject8 = jSONObject.getJSONObject("artist");
                    bdaVar4.c = jSONObject8.getString("name");
                    bdaVar4.d = "" + jSONObject8.getInt("id");
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            am();
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", bdaVar4);
            bdkVar.g(bundle);
            if (ahn.a()) {
                this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdkVar, (arc) null);
            }
        } else if (aVar == bdh.a.ArtistMetaData) {
            bdb bdbVar = new bdb();
            try {
                bdbVar.a = "" + jSONObject.getString("name");
                bdbVar.b = jSONObject.getString("id");
                bdbVar.c = jSONObject.getString("picture");
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            am();
            bdl bdlVar = new bdl();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", bdbVar);
            bundle2.putInt("current_screen", 0);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdlVar, (arc) null);
            }
        } else if (aVar == bdh.a.UserPlaylists) {
            ArrayList arrayList4 = new ArrayList();
            try {
                JSONArray jSONArray4 = jSONObject.getJSONArray("items");
                while (i < jSONArray4.length()) {
                    JSONObject jSONObject9 = jSONArray4.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject9.getString("description");
                    bdcVar.d = jSONObject9.getInt("duration");
                    bdcVar.a = jSONObject9.getString("title");
                    bdcVar.e = jSONObject9.getString("url");
                    bdcVar.b = jSONObject9.getString("uuid");
                    bdcVar.f = jSONObject9.getInt("numberOfTracks");
                    arrayList4.add(bdcVar);
                    i++;
                }
                am();
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList4, str, this);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        } else if (aVar == bdh.a.Radio) {
            ArrayList arrayList5 = new ArrayList();
            try {
                JSONArray jSONArray5 = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray5.length(); i2++) {
                    JSONObject jSONObject10 = jSONArray5.getJSONObject(i2);
                    bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject10.getInt("id");
                    bdgVar.d = jSONObject10.getString("title");
                    bdgVar.e = jSONObject10.getString("url");
                    bdgVar.f = jSONObject10.getInt("duration");
                    bdgVar.j = jSONObject10.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject10.getBoolean("streamReady");
                    bdgVar.l = jSONObject10.getString("streamStartDate");
                    if (jSONObject10.has("artist")) {
                        JSONObject jSONObject11 = jSONObject10.getJSONObject("artist");
                        bdgVar.a = jSONObject11.getString("name");
                        bdgVar.b = "" + jSONObject11.getInt("id");
                    }
                    if (jSONObject10.has("album")) {
                        JSONObject jSONObject12 = jSONObject10.getJSONObject("album");
                        bdgVar.h = jSONObject12.getString("title");
                        bdgVar.g = "" + jSONObject12.getInt("id");
                        bdgVar.i = jSONObject12.getString("cover");
                    }
                    arrayList5.add(bdgVar);
                }
                TidalRadio tidalRadio = new TidalRadio();
                tidalRadio.a(str);
                while (i < arrayList5.size()) {
                    TidalMusicDataLocal tidalMusicDataLocalA = bdh.a((bdg) arrayList5.get(i));
                    if (tidalMusicDataLocalA != null) {
                        tidalRadio.a(tidalMusicDataLocalA);
                    }
                    i++;
                }
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(tidalRadio);
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumTracks) {
            ArrayList arrayList6 = new ArrayList();
            try {
                JSONArray jSONArray6 = jSONObject.getJSONArray("items");
                mm.b("TEST_DRAG_ALBUM, item size = %s", Integer.valueOf(jSONArray6.length()));
                for (int i3 = 0; i3 < jSONArray6.length(); i3++) {
                    JSONObject jSONObject13 = jSONArray6.getJSONObject(i3);
                    bdg bdgVar2 = new bdg();
                    bdgVar2.c = "" + jSONObject13.getInt("id");
                    bdgVar2.d = jSONObject13.getString("title");
                    bdgVar2.e = jSONObject13.getString("url");
                    bdgVar2.f = jSONObject13.getInt("duration");
                    bdgVar2.j = jSONObject13.getBoolean("allowStreaming");
                    bdgVar2.k = jSONObject13.getBoolean("streamReady");
                    bdgVar2.l = jSONObject13.getString("streamStartDate");
                    if (jSONObject13.has("artist")) {
                        JSONObject jSONObject14 = jSONObject13.getJSONObject("artist");
                        bdgVar2.a = jSONObject14.getString("name");
                        bdgVar2.b = "" + jSONObject14.getInt("id");
                    }
                    if (jSONObject13.has("album")) {
                        JSONObject jSONObject15 = jSONObject13.getJSONObject("album");
                        bdgVar2.h = jSONObject15.getString("title");
                        bdgVar2.g = "" + jSONObject15.getInt("id");
                        bdgVar2.i = jSONObject15.getString("cover");
                    }
                    arrayList6.add(bdgVar2);
                    mm.b("TEST_DRAG_ALBUM", "track_thing=" + bdgVar2.toString());
                }
                b((List<bdg>) arrayList6);
            } catch (JSONException e8) {
                e8.printStackTrace();
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
        this.ak = layoutInflater.inflate(R.layout.tidal_artist_track_list, (ViewGroup) null);
        this.as = (AnimationListView) this.ak.findViewById(R.id.list_view);
        this.aw = this.ak.findViewById(R.id.list_view_holder);
        this.as.setEmptyView(this.ak.findViewById(R.id.list_view_empty));
        this.aA = this.ak.findViewById(R.id.list_view_empty_text);
        this.h = (ScrollView) this.ak.findViewById(R.id.description_holder);
        this.i = (TextView) this.ak.findViewById(R.id.description);
        this.aM = (TabPageIndicator) this.ak.findViewById(R.id.indicator);
        this.aM.setTitles(new CharSequence[]{q().getString(R.string.TidalTracks), q().getString(R.string.TidalAlbums), q().getString(R.string.TidalEPsAndSingles), q().getString(R.string.TidalOtherAlbums)});
        this.aM.setOnTabReselectedListener(this.ah);
        View viewInflate = layoutInflater.inflate(R.layout.tidal_track_list_header, (ViewGroup) null);
        this.f = (ImageView) viewInflate.findViewById(R.id.iv);
        this.g = (TextView) viewInflate.findViewById(R.id.cover_title);
        this.at = (AnimationGridView) this.ak.findViewById(R.id.other_gridview);
        this.at.setNeedAddFooter(false);
        this.ax = this.ak.findViewById(R.id.other_gridview_holder);
        this.at.setEmptyView(this.ak.findViewById(R.id.other_gridview_empty));
        this.aB = this.ak.findViewById(R.id.other_gridview_empty_text);
        this.au = (AnimationGridView) this.ak.findViewById(R.id.albums_gridview);
        this.au.setNeedAddFooter(false);
        this.ay = this.ak.findViewById(R.id.albums_gridview_holder);
        this.au.setEmptyView(this.ak.findViewById(R.id.albums_gridview_empty));
        this.aC = this.ak.findViewById(R.id.albums_gridview_empty_text);
        this.av = (AnimationGridView) this.ak.findViewById(R.id.singles_gridview);
        this.av.setNeedAddFooter(false);
        this.az = this.ak.findViewById(R.id.singles_gridview_holder);
        this.av.setEmptyView(this.ak.findViewById(R.id.singles_gridview_empty));
        this.aD = this.ak.findViewById(R.id.singles_gridview_empty_text);
        this.aN = (RelativeLayout) viewInflate.findViewById(R.id.more_holder);
        this.as.addHeaderView(viewInflate);
        this.aN.setOnClickListener(this.aj);
        this.al = new aic<>(this.ae, new d(), 100, R.layout.tidal_track_item, R.layout.harman_list_loading);
        this.aG = new aic<>(this.ae, new a(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        this.aI = new aic<>(this.ae, new b(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        this.aH = new aic<>(this.ae, new c(), 20, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        try {
            this.al.a(this.ar);
            this.aG.a(this.aJ);
            this.aI.a(this.aL);
            this.aH.a(this.aK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.as.setAdapter((ListAdapter) this.al);
        this.at.setAdapter((ListAdapter) this.aI);
        this.au.setAdapter((ListAdapter) this.aG);
        this.av.setAdapter((ListAdapter) this.aH);
        b(q().getString(R.string.TidalArtists));
        return this.ak;
    }

    protected void d(int i) {
        this.aF = 1;
        this.aM.b(i);
        this.d = i;
        switch (i) {
            case 0:
                if (al()) {
                    this.aw.setVisibility(4);
                } else {
                    this.aw.setVisibility(0);
                }
                this.h.setVisibility(8);
                this.ax.setVisibility(8);
                this.az.setVisibility(8);
                this.ay.setVisibility(8);
                break;
            case 1:
                this.aw.setVisibility(8);
                this.h.setVisibility(8);
                this.ax.setVisibility(8);
                this.az.setVisibility(8);
                this.ay.setVisibility(0);
                break;
            case 2:
                this.aw.setVisibility(8);
                this.h.setVisibility(8);
                this.ax.setVisibility(8);
                this.az.setVisibility(0);
                this.ay.setVisibility(8);
                break;
            case 3:
                this.aw.setVisibility(8);
                this.h.setVisibility(8);
                this.ax.setVisibility(0);
                this.az.setVisibility(8);
                this.ay.setVisibility(8);
                break;
            case 4:
                this.aw.setVisibility(8);
                this.h.setVisibility(0);
                this.ax.setVisibility(8);
                this.az.setVisibility(8);
                this.ay.setVisibility(8);
                break;
        }
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
    }

    @Override // defpackage.bdn
    public void c() {
        this.as.setAdapter((ListAdapter) this.al);
        this.at.setAdapter((ListAdapter) this.aI);
        this.au.setAdapter((ListAdapter) this.aG);
        this.av.setAdapter((ListAdapter) this.aH);
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.e.a).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.e = (bdb) bundle.getSerializable("artist");
        this.g.setText(this.e.a);
        this.g.setTypeface(bcw.b(this.ae));
        this.aA.setVisibility(4);
        this.aB.setVisibility(4);
        this.aC.setVisibility(4);
        this.aD.setVisibility(4);
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.aM.setCurrentItem(this.d);
        d(this.d);
        mm.b("TIDAL", "http://images.osl.wimpmusic.com/im/im?w=320&h=214&artistid=" + this.e.b);
        if (!ahn.a() || this.ae.getResources().getInteger(R.integer.Tidal_portrait) != 0) {
            bif.a((Context) this.ae).a("http://images.osl.wimpmusic.com/im/im?w=320&h=214&artistid=" + this.e.b).a(R.drawable.tidal_placeholder_150x150).a(bib.NO_STORE, new bib[0]).a(this.f);
        } else {
            bif.a((Context) this.ae).a("http://images.osl.wimpmusic.com/im/im?w=320&h=214&artistid=" + this.e.b).a(R.drawable.tidal_placeholder_150x150).a((bir) new bcs(this.e.b)).a(bib.NO_STORE, new bib[0]).a(this.f);
        }
        this.ar.clear();
        this.al.a(this.ar);
        this.al.notifyDataSetChanged();
        this.aJ.clear();
        this.aG.a(this.aJ);
        this.aG.notifyDataSetChanged();
        this.aL.clear();
        this.aI.a(this.aL);
        this.aI.notifyDataSetChanged();
        this.aK.clear();
        this.aH.a(this.aK);
        this.aH.notifyDataSetChanged();
        this.an = new bdj(bdh.a.ArtistTracks, this.e.b);
        this.an.a(0, 100, this);
        bdh.a().a(bdh.a.ArtistAlbums, this, this.e.b, "ALBUMS", 0, 20);
        bdh.a().a(bdh.a.ArtistSinglesAlbums, this, this.e.b, "EPSANDSINGLES", 0, 20);
        bdh.a().a(bdh.a.ArtistOtherAlbums, this, this.e.b, "COMPILATIONS", 0, 20);
        this.as.setOnItemChosenListener(this.ai);
        this.as.setOnScrollListener(new bcz(this.ae));
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.as.setLeftMargin((int) dimension);
        }
        this.au.setOnItemChosenListener(this.ai);
        this.au.setOnItemClickListener(this.aO);
        this.au.setOnScrollListener(new bcz(this.ae));
        this.av.setOnItemChosenListener(this.ai);
        this.av.setOnItemClickListener(this.aP);
        this.av.setOnScrollListener(new bcz(this.ae));
        this.at.setOnItemChosenListener(this.ai);
        this.at.setOnItemClickListener(this.aQ);
        this.at.setOnScrollListener(new bcz(this.ae));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else if (i == 0) {
            b(this.ar);
        } else {
            a(this.ar, i - 1);
        }
    }

    @Override // defpackage.bdn, defpackage.bdm, age.a
    public void a(int i, List<MusicData> list, JSONObject jSONObject) {
        this.ar = this.an.e();
        if (this.ar.size() == 0 && this.d == 0) {
            this.aA.setVisibility(0);
        }
        if (this.aF == 1) {
            this.al.a(this.ar);
            this.al.notifyDataSetChanged();
        } else {
            List<bdg> listSubList = this.ar.subList(i, i + 20);
            if (listSubList.size() < 20) {
                this.al.a();
            }
            this.al.b(listSubList);
        }
        if (this.d == 0) {
            this.aw.setVisibility(0);
        }
        am();
    }

    class d implements aic.a<bdg> {
        d() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdl.this.an.a(bdl.this.aF * i2, i2, bdl.this);
            bdl.m(bdl.this);
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
                aVar2.e = (ImageView) view.findViewById(R.id.img2);
                aVar2.f = (TextView) view.findViewById(R.id.chart_position);
                aVar2.g = (RelativeLayout) view.findViewById(R.id.chart_position_holder);
                aVar2.h = (RelativeLayout) view.findViewById(R.id.more_holder);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdgVar.d);
            aVar.b.setTypeface(bcw.a(bdl.this.ae));
            aVar.d.setText(bdgVar.a);
            aVar.d.setTypeface(bcw.b(bdl.this.ae));
            aVar.c.setText(bcw.a(bdgVar.f));
            aVar.c.setTypeface(bcw.b(bdl.this.ae));
            bif.a((Context) bdl.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            aVar.a.setVisibility(0);
            aVar.g.setVisibility(8);
            aVar.f.setText("" + (i + 1));
            int color = bdl.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bdl.this.q().getColor(R.color.tidal_text_disabled);
            }
            aVar.b.setTextColor(color);
            aVar.d.setTextColor(color);
            aVar.c.setTextColor(color);
            aVar.f.setTextColor(color);
            aVar.h.setOnClickListener(new View.OnClickListener() { // from class: bdl.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bdl.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bdl.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bdl.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bdl.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bdl.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!bdl.this.a(bdgVar)) {
                        arrayList.add(bdl.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bdl.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bdl.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bdl.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bdl.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bdl.d.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdl.this);
                                bdl.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bdl.this.d();
                                bdh.a().a(bdl.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalPlayNext))) {
                                bdl.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalAddToQueue))) {
                                bdl.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bdl.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalGoToArtist))) {
                                bdl.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bdl.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalGoToAlbum))) {
                                bdl.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bdl.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bdl.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdl.this);
                                bdl.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bdl.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bdl.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bdl.this.d(tidalMusicDataLocalA);
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
            public ImageView e;
            public TextView f;
            public RelativeLayout g;
            public RelativeLayout h;

            a() {
            }
        }
    }

    class a implements aic.a<bda> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.ArtistAlbums, bdl.this, bdl.this.e.b, "ALBUMS", bdl.this.aF * i2, 20);
            bdl.m(bdl.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            C0111a c0111a = (C0111a) view.getTag();
            if (c0111a == null) {
                C0111a c0111a2 = new C0111a();
                c0111a2.a = (ImageView) view.findViewById(R.id.iv);
                c0111a2.b = (TextView) view.findViewById(R.id.tv);
                c0111a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0111a2);
                c0111a = c0111a2;
            }
            c0111a.b.setText(bdaVar.b);
            c0111a.b.setTypeface(bcw.a(bdl.this.ae));
            c0111a.c.setText(bdaVar.c);
            c0111a.c.setTypeface(bcw.b(bdl.this.ae));
            bif.a((Context) bdl.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=300&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0111a.a);
            return view;
        }

        /* JADX INFO: renamed from: bdl$a$a, reason: collision with other inner class name */
        class C0111a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0111a() {
            }
        }
    }

    class b implements aic.a<bda> {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.ArtistOtherAlbums, bdl.this, bdl.this.e.b, "COMPILATIONS", bdl.this.aF * i2, 20);
            bdl.m(bdl.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                aVar2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdaVar.b);
            aVar.b.setTypeface(bcw.a(bdl.this.ae));
            aVar.c.setText(bdaVar.c);
            aVar.c.setTypeface(bcw.b(bdl.this.ae));
            bif.a((Context) bdl.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=300&albumid=" + bdaVar.a).a("tidal").a(aVar.a);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bda bdaVar) {
        bdh.a().a(bdh.a.AlbumTracks, this, bdaVar.a, "", 0, 20);
        d();
    }

    class c implements aic.a<bda> {
        c() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.ArtistSinglesAlbums, bdl.this, bdl.this.e.b, "EPSANDSINGLES", bdl.this.aF * i2, 20);
            bdl.m(bdl.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.tv);
                aVar2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdaVar.b);
            aVar.b.setTypeface(bcw.a(bdl.this.ae));
            aVar.c.setText(bdaVar.c);
            aVar.c.setTypeface(bcw.b(bdl.this.ae));
            bif.a((Context) bdl.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=300&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
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
