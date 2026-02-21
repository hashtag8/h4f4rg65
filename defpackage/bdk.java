package defpackage;

import android.content.Context;
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
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import com.musicservice.tidal.TabPageIndicator;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import defpackage.aih;
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.entity.ContentLengthStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdk extends bdn implements bdi.b {
    private RelativeLayout aA;
    private TabPageIndicator aB;
    AnimationGridView ah;
    View ai;
    View aj;
    View ak;
    private View ar;
    private aih<bdg> as;
    private AnimationListView au;
    private View av;
    private aih<bda> ay;
    ImageView e;
    TextView f;
    bda g;
    ScrollView h;
    TextView i;
    private ArrayList<bdg> at = new ArrayList<>();
    private final int aw = 50;
    private int ax = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    private ArrayList<bda> az = new ArrayList<>();
    TabPageIndicator.a al = new TabPageIndicator.a() { // from class: bdk.3
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bdk.this.d(i);
        }
    };
    private ajn aC = new ajn() { // from class: bdk.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(bdk.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                bdh.a().a(bdh.a.AlbumTracks, bdk.this, ((bda) obj).a, "play", 0, 50);
            }
        }
    };
    private ajn aD = new ajn() { // from class: bdk.5
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(bdk.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else if (i == 0) {
                bdk.this.b((List<bdg>) bdk.this.at);
            } else {
                bdk.this.a(bdk.this.at, i - 1);
            }
        }
    };
    private AdapterView.OnItemClickListener aE = new AdapterView.OnItemClickListener() { // from class: bdk.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdk.this.az.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdk.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdk.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int h(bdk bdkVar) {
        int i = bdkVar.ax;
        bdkVar.ax = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.AlbumTracks) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
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
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if ("play".compareTo(str) == 0) {
                b((List<bdg>) arrayList);
            } else {
                if (arrayList.size() == 0) {
                    this.ak.setVisibility(0);
                }
                this.at.addAll(this.at.size(), (ArrayList) arrayList.clone());
                this.as.b(arrayList);
                this.as.notifyDataSetChanged();
                ao();
                mm.b("TIDAL", "getcount=" + this.as.getCount());
                if (this.av.getVisibility() == 4) {
                    this.av.setVisibility(0);
                }
            }
        } else if (aVar == bdh.a.ArtistAlbums) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                while (i < jSONArray2.length()) {
                    JSONObject jSONObject5 = jSONArray2.getJSONObject(i);
                    bda bdaVar = new bda();
                    int i3 = jSONObject5.getInt("id");
                    if (!String.valueOf(i3).equals(this.g.a)) {
                        bdaVar.a = "" + i3;
                        bdaVar.e = jSONObject5.getString("cover");
                        bdaVar.b = jSONObject5.getString("title");
                        bdaVar.f = jSONObject5.getInt("numberOfTracks");
                        if (jSONObject5.has("artist")) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("artist");
                            bdaVar.c = jSONObject6.getString("name");
                            bdaVar.d = "" + jSONObject6.getInt("id");
                        }
                        arrayList2.add(bdaVar);
                    }
                    i++;
                }
                if (arrayList2.size() == 0) {
                    this.aj.setVisibility(0);
                }
                this.az.addAll(this.az.size(), (ArrayList) arrayList2.clone());
                this.ay.b(arrayList2);
                mm.b("TIDAL", "" + this.ay.getCount());
                this.ay.notifyDataSetChanged();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar2 = new bda();
            try {
                bdaVar2.a = "" + jSONObject.getInt("id");
                bdaVar2.e = jSONObject.getString("cover");
                bdaVar2.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject7 = jSONObject.getJSONObject("artist");
                    bdaVar2.c = jSONObject7.getString("name");
                    bdaVar2.d = "" + jSONObject7.getInt("id");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            am();
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", bdaVar2);
            bundle.putInt("current_screen", 0);
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
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            am();
            bdl bdlVar = new bdl();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", bdbVar);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdlVar, (arc) null);
            }
        } else if (aVar == bdh.a.UserPlaylists) {
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject8 = jSONArray3.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject8.getString("description");
                    bdcVar.d = jSONObject8.getInt("duration");
                    bdcVar.a = jSONObject8.getString("title");
                    bdcVar.e = jSONObject8.getString("url");
                    bdcVar.b = jSONObject8.getString("uuid");
                    bdcVar.f = jSONObject8.getInt("numberOfTracks");
                    arrayList3.add(bdcVar);
                    i++;
                }
                am();
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList3, str, this);
            } catch (JSONException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else if (aVar == bdh.a.Radio) {
            ArrayList arrayList4 = new ArrayList();
            try {
                JSONArray jSONArray4 = jSONObject.getJSONArray("items");
                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                    JSONObject jSONObject9 = jSONArray4.getJSONObject(i4);
                    bdg bdgVar2 = new bdg();
                    bdgVar2.c = "" + jSONObject9.getInt("id");
                    bdgVar2.d = jSONObject9.getString("title");
                    bdgVar2.e = jSONObject9.getString("url");
                    bdgVar2.f = jSONObject9.getInt("duration");
                    bdgVar2.j = jSONObject9.getBoolean("allowStreaming");
                    bdgVar2.k = jSONObject9.getBoolean("streamReady");
                    bdgVar2.l = jSONObject9.getString("streamStartDate");
                    if (jSONObject9.has("artist")) {
                        JSONObject jSONObject10 = jSONObject9.getJSONObject("artist");
                        bdgVar2.a = jSONObject10.getString("name");
                        bdgVar2.b = "" + jSONObject10.getInt("id");
                    }
                    if (jSONObject9.has("album")) {
                        JSONObject jSONObject11 = jSONObject9.getJSONObject("album");
                        bdgVar2.h = jSONObject11.getString("title");
                        bdgVar2.g = "" + jSONObject11.getInt("id");
                        bdgVar2.i = jSONObject11.getString("cover");
                    }
                    arrayList4.add(bdgVar2);
                }
                b((List<bdg>) arrayList4);
            } catch (JSONException e7) {
                e7.printStackTrace();
            } catch (Exception e8) {
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
        this.ar = layoutInflater.inflate(R.layout.tidal_track_list, (ViewGroup) null);
        this.au = (AnimationListView) this.ar.findViewById(R.id.list_view);
        this.au.setOffsetFooterFlag(true);
        this.av = this.ar.findViewById(R.id.list_view_holder);
        this.au.setEmptyView(this.ar.findViewById(R.id.list_view_empty));
        this.ak = this.ar.findViewById(R.id.list_view_empty_text);
        this.h = (ScrollView) this.ar.findViewById(R.id.description_holder);
        this.i = (TextView) this.ar.findViewById(R.id.description);
        this.aB = (TabPageIndicator) this.ar.findViewById(R.id.indicator);
        this.aB.setTitles(new CharSequence[]{q().getString(R.string.TidalTracks), q().getString(R.string.TidalOtherAlbums)});
        this.aB.setOnTabReselectedListener(this.al);
        View viewInflate = layoutInflater.inflate(R.layout.tidal_album_header, (ViewGroup) null);
        ((ImageView) viewInflate.findViewById(R.id.cover_play)).setOnClickListener(new View.OnClickListener() { // from class: bdk.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!aof.a().l() || ain.j) {
                    bdk.this.b((List<bdg>) bdk.this.at);
                } else {
                    Toast.makeText(bdk.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            }
        });
        this.e = (ImageView) viewInflate.findViewById(R.id.iv);
        if (ahn.a()) {
            int iB = ahn.a((Context) this.ae).b();
            int i = (int) (((double) iB) * 0.4d);
            int i2 = (int) (((double) iB) * 0.3d);
            int iA = ahn.a(p(), 20.0f);
            viewInflate.findViewById(R.id.cover_title).setPadding(ahn.a(p(), 40.0f), iA, iA, iA);
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.artwork_cover);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.f = (TextView) viewInflate.findViewById(R.id.cover_title);
        this.ah = (AnimationGridView) this.ar.findViewById(R.id.group_gridview);
        this.ah.setNeedAddFooter(false);
        this.ai = this.ar.findViewById(R.id.group_gridview_holder);
        this.ah.setEmptyView(this.ar.findViewById(R.id.group_gridview_empty));
        this.aj = this.ar.findViewById(R.id.group_gridview_empty_text);
        this.aA = (RelativeLayout) viewInflate.findViewById(R.id.more_holder);
        this.au.addHeaderView(viewInflate);
        this.aA.setOnClickListener(new View.OnClickListener() { // from class: bdk.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bdp bdpVar = new bdp(bdk.this.ae, bdk.this.g.b);
                final ArrayList arrayList = new ArrayList();
                arrayList.add(bdk.this.q().getString(R.string.PlayTip_PlayNow_Str));
                arrayList.add(bdk.this.q().getString(R.string.TidalPlayNext));
                arrayList.add(bdk.this.q().getString(R.string.TidalAddToQueue));
                arrayList.add(bdk.this.q().getString(R.string.PlayTip_ClearAll_Str));
                if (!bdk.this.a(bdk.this.g)) {
                    arrayList.add(bdk.this.q().getString(R.string.TidalFavourite));
                } else {
                    arrayList.add(bdk.this.q().getString(R.string.TidalUnFavourite));
                }
                arrayList.add(bdk.this.q().getString(R.string.TidalAddToPlaylist));
                arrayList.add(bdk.this.q().getString(R.string.TidalGoToArtist));
                bdpVar.a(arrayList);
                bdpVar.a(bdk.this.g.b);
                bdpVar.a(new asi() { // from class: bdk.2.1
                    @Override // defpackage.asi
                    public void a(int i3) {
                        if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalFavourite))) {
                            bdh.a().b(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdk.this.g.a, bdk.this);
                            bdk.this.b(bdk.this.g);
                            return;
                        }
                        if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalAddToPlaylist))) {
                            bdk.this.d();
                            String str = "";
                            for (int i4 = 0; i4 < bdk.this.at.size(); i4++) {
                                str = str + "" + ((bdg) bdk.this.at.get(i4)).c + ",";
                            }
                            bdh.a().a(bdk.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), str, 0, 100);
                            return;
                        }
                        if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalPlayNext))) {
                            bdk.this.a((List<bdg>) bdk.this.at);
                            return;
                        }
                        if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalAddToQueue))) {
                            bdk.this.d((List<bdg>) bdk.this.at);
                            return;
                        }
                        if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalGoToArtist))) {
                            bdk.this.d();
                            bdh.a().a(bdh.a.ArtistMetaData, bdk.this, bdk.this.g.d, "");
                        } else if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.TidalUnFavourite))) {
                            bdh.a().a(bdk.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdk.this.g.a, bdk.this);
                            bdk.this.c(bdk.this.g);
                        } else if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                            bdk.this.c((List<bdg>) bdk.this.at);
                        } else if (((String) arrayList.get(i3)).equals(bdk.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                            bdk.this.e(bdk.this.at);
                        }
                    }
                });
                bdpVar.show();
            }
        });
        this.as = new aih<>(this.ae, new b(), 50, R.layout.tidal_track_item, R.layout.harman_list_loading);
        this.ay = new aih<>(this.ae, new a(), 50, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        this.as.a(this.at);
        this.ay.a(this.az);
        this.au.setAdapter((ListAdapter) this.as);
        ao();
        this.ah.setAdapter((ListAdapter) this.ay);
        b(q().getString(R.string.TidalAlbums));
        return this.ar;
    }

    protected void d(int i) {
        this.ax = 1;
        this.d = i;
        this.aB.b(i);
        switch (i) {
            case ContentLengthStrategy.IDENTITY /* -1 */:
                this.av.setVisibility(8);
                this.h.setVisibility(0);
                this.ai.setVisibility(8);
                break;
            case 0:
                if (al()) {
                    this.av.setVisibility(4);
                } else {
                    this.av.setVisibility(0);
                }
                this.h.setVisibility(8);
                this.ai.setVisibility(8);
                break;
            case 1:
                this.av.setVisibility(8);
                this.h.setVisibility(8);
                this.ai.setVisibility(0);
                break;
        }
    }

    @Override // defpackage.bdn
    public void c() {
        this.au.setAdapter((ListAdapter) this.as);
        ao();
        this.ah.setAdapter((ListAdapter) this.ay);
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.g.b).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ak.setVisibility(4);
        this.aj.setVisibility(4);
        d();
        this.g = (bda) bundle.getSerializable("album");
        this.f.setText(this.g.b);
        this.f.setTypeface(bcw.b(this.ae));
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.aB.setCurrentItem(this.d);
        d(this.d);
        String str = "http://resources.wimpmusic.com/images/" + this.g.e.replace("-", "/") + "/320x320.jpg";
        mm.b("TIDAL", str + this.g.a);
        bif.a((Context) this.ae).a(str).a(R.drawable.tidal_placeholder_150x150).a((bir) new bcs(this.g.a)).a(bib.NO_STORE, new bib[0]).a(this.e);
        this.at.clear();
        this.as.a(this.at);
        this.as.notifyDataSetChanged();
        ao();
        this.az.clear();
        this.ay.a(this.az);
        this.ay.notifyDataSetChanged();
        bdh.a().a(bdh.a.AlbumTracks, this, this.g.a, "", 0, 50);
        bdh.a().a(bdh.a.ArtistAlbums, this, this.g.d, "ALBUMS", 0, 50);
        this.au.setOnItemChosenListener(this.aD);
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.au.setLeftMargin((int) dimension);
        }
        this.ah.setOnScrollListener(new bcz(this.ae));
        this.ah.setOnItemClickListener(this.aE);
        this.ah.setOnItemChosenListener(this.aC);
    }

    class b implements aih.a<bdg> {
        b() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.AlbumTracks, bdk.this, bdk.this.g.a, "", bdk.this.ax * i2, 50);
            bdk.h(bdk.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, final bdg bdgVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.text1);
                aVar2.b.setTypeface(bcw.a(bdk.this.ae));
                aVar2.d = (TextView) view.findViewById(R.id.text2);
                aVar2.d.setTypeface(bcw.b(bdk.this.ae));
                aVar2.c = (TextView) view.findViewById(R.id.track_time);
                aVar2.c.setTypeface(bcw.b(bdk.this.ae));
                aVar2.e = (TextView) view.findViewById(R.id.chart_position);
                aVar2.f = (RelativeLayout) view.findViewById(R.id.chart_position_holder);
                aVar2.g = (RelativeLayout) view.findViewById(R.id.more_holder);
                aVar2.a.setVisibility(8);
                aVar2.f.setVisibility(0);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.a.setStoredViewForBitmap(bdk.this.e);
            aVar.b.setText(bdgVar.d);
            int color = bdk.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bdk.this.q().getColor(R.color.tidal_text_disabled);
            }
            aVar.b.setTextColor(color);
            aVar.d.setTextColor(color);
            aVar.c.setTextColor(color);
            aVar.e.setTextColor(color);
            aVar.d.setText(bdgVar.a);
            aVar.c.setText(bcw.a(bdgVar.f));
            aVar.e.setText("" + (i + 1));
            aVar.g.setOnClickListener(new View.OnClickListener() { // from class: bdk.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bdk.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bdk.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bdk.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bdk.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bdk.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!bdk.this.a(bdgVar)) {
                        arrayList.add(bdk.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bdk.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bdk.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bdk.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bdk.this.q().getString(R.string.TidalGoToArtist));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bdk.b.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdk.this);
                                bdk.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bdk.this.d();
                                bdh.a().a(bdk.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalPlayNext))) {
                                bdk.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalAddToQueue))) {
                                bdk.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bdk.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalGoToArtist))) {
                                bdk.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bdk.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalGoToAlbum))) {
                                bdk.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bdk.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bdk.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdk.this);
                                bdk.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bdk.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bdk.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bdk.this.d(tidalMusicDataLocalA);
                            }
                        }
                    });
                    bdpVar.show();
                }
            });
            return view;
        }

        class a {
            public StoredBitmapImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public RelativeLayout f;
            public RelativeLayout g;

            a() {
            }
        }
    }

    class a implements aih.a<bda> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.ArtistAlbums, bdk.this, bdk.this.g.d, "ALBUMS", bdk.this.ax * i2, 50);
            bdk.h(bdk.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            String str = "http://resources.wimpmusic.com/images/" + bdaVar.e.replace("-", "/") + "/160x160.jpg";
            C0109a c0109a = (C0109a) view.getTag();
            if (c0109a == null) {
                C0109a c0109a2 = new C0109a();
                c0109a2.a = (ImageView) view.findViewById(R.id.iv);
                c0109a2.b = (TextView) view.findViewById(R.id.tv);
                c0109a2.b.setTypeface(bcw.a(bdk.this.ae));
                c0109a2.c = (TextView) view.findViewById(R.id.tv_alt);
                c0109a2.c.setTypeface(bcw.b(bdk.this.ae));
                view.setTag(c0109a2);
                c0109a = c0109a2;
            }
            c0109a.b.setText(bdaVar.b);
            c0109a.c.setText(bdaVar.c);
            bif.a((Context) bdk.this.ae).a(c0109a.a);
            bif.a((Context) bdk.this.ae).a(str).a(R.drawable.tidal_placeholder_150x150).f().a("tidal").a(c0109a.a);
            mm.b("PICASSO", bif.a((Context) bdk.this.ae).a().toString());
            return view;
        }

        /* JADX INFO: renamed from: bdk$a$a, reason: collision with other inner class name */
        class C0109a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0109a() {
            }
        }
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName() + "#" + System.identityHashCode(this);
    }

    private void ao() {
        if (this.as.getCount() == 1 && this.au != null) {
            this.au.setDividerHeight(0);
            this.au.setDivider(null);
        }
    }
}
