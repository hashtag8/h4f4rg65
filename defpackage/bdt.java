package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.tidal.TabPageIndicator;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
import defpackage.aic;
import defpackage.bdh;
import defpackage.bdi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdt extends bdn implements ajn, bdi.b {
    private TabPageIndicator aj;
    private bdd ak;
    private View e;
    private aic<bdg> f;
    private AnimationListView h;
    private View i;
    private ArrayList<bdg> g = new ArrayList<>();
    private final int ah = 20;
    private int ai = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;

    static /* synthetic */ int c(bdt bdtVar) {
        int i = bdtVar.ai;
        bdtVar.ai = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.GenreTracks) {
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
                this.g.addAll(this.g.size(), (ArrayList) arrayList.clone());
                this.f.b(arrayList);
                this.f.notifyDataSetChanged();
                this.i.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar = new bda();
            try {
                bdaVar.a = "" + jSONObject.getInt("id");
                bdaVar.e = jSONObject.getString("cover");
                bdaVar.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject("artist");
                    bdaVar.c = jSONObject5.getString("name");
                    bdaVar.d = "" + jSONObject5.getInt("id");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            am();
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", bdaVar);
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (ahn.a()) {
                this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
                return;
            } else {
                this.ae.q().a(bdkVar, (arc) null);
                return;
            }
        }
        if (aVar == bdh.a.ArtistMetaData) {
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
            bundle2.putInt("current_screen", 0);
            bundle2.putSerializable("artist", bdbVar);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
                return;
            } else {
                this.ae.q().a(bdlVar, (arc) null);
                return;
            }
        }
        if (aVar == bdh.a.UserPlaylists) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                while (i < jSONArray2.length()) {
                    JSONObject jSONObject6 = jSONArray2.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject6.getString("description");
                    bdcVar.d = jSONObject6.getInt("duration");
                    bdcVar.a = jSONObject6.getString("title");
                    bdcVar.e = jSONObject6.getString("url");
                    bdcVar.b = jSONObject6.getString("uuid");
                    bdcVar.f = jSONObject6.getInt("numberOfTracks");
                    arrayList2.add(bdcVar);
                    i++;
                }
                am();
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList2, str, this);
                return;
            } catch (JSONException e5) {
                e5.printStackTrace();
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        if (aVar == bdh.a.Radio) {
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject jSONObject7 = jSONArray3.getJSONObject(i2);
                    bdg bdgVar2 = new bdg();
                    bdgVar2.c = "" + jSONObject7.getInt("id");
                    bdgVar2.d = jSONObject7.getString("title");
                    bdgVar2.e = jSONObject7.getString("url");
                    bdgVar2.f = jSONObject7.getInt("duration");
                    bdgVar2.j = jSONObject7.getBoolean("allowStreaming");
                    bdgVar2.k = jSONObject7.getBoolean("streamReady");
                    bdgVar2.l = jSONObject7.getString("streamStartDate");
                    if (jSONObject7.has("artist")) {
                        JSONObject jSONObject8 = jSONObject7.getJSONObject("artist");
                        bdgVar2.a = jSONObject8.getString("name");
                        bdgVar2.b = "" + jSONObject8.getInt("id");
                    }
                    if (jSONObject7.has("album")) {
                        JSONObject jSONObject9 = jSONObject7.getJSONObject("album");
                        bdgVar2.h = jSONObject9.getString("title");
                        bdgVar2.g = "" + jSONObject9.getInt("id");
                        bdgVar2.i = jSONObject9.getString("cover");
                    }
                    arrayList3.add(bdgVar2);
                }
                new ArrayList();
                TidalRadio tidalRadio = new TidalRadio();
                tidalRadio.a(str);
                while (i < arrayList3.size()) {
                    TidalMusicDataLocal tidalMusicDataLocalA = bdh.a((bdg) arrayList3.get(i));
                    if (tidalMusicDataLocalA != null) {
                        tidalRadio.a(tidalMusicDataLocalA);
                    }
                    i++;
                }
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(tidalRadio);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.tidal_track_list, (ViewGroup) null);
        this.h = (AnimationListView) this.e.findViewById(R.id.list_view);
        this.i = this.e.findViewById(R.id.list_view_holder);
        this.i.setVisibility(0);
        this.h.setEmptyView(this.e.findViewById(R.id.list_view_empty));
        this.aj = (TabPageIndicator) this.e.findViewById(R.id.indicator);
        this.aj.setVisibility(8);
        this.f = new aic<>(this.ae, new a(), 20, R.layout.tidal_track_item, R.layout.tidal_list_loading_invisible);
        this.f.a(this.g);
        this.h.setAdapter((ListAdapter) this.f);
        b(q().getString(R.string.TidalGenres));
        return this.e;
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ai = 1;
        this.ak = (bdd) bundle.getSerializable("genre");
        if (this.ak != null) {
            b(this.ak.a);
        }
        this.i.setVisibility(4);
        bdh.a().a(bdh.a.GenreTracks, this, this.ak.c, "tracks", 0, 20);
        this.g.clear();
        this.f.a(this.g);
        this.f.notifyDataSetChanged();
        this.h.setOnItemChosenListener(this);
        this.h.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.h.setAdapter((ListAdapter) this.f);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        a(this.g, i);
    }

    class a implements aic.a<bdg> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdt.this.d();
            bdh.a().a(bdh.a.GenreTracks, bdt.this, bdt.this.ak.c, "tracks", bdt.this.ai * i2, i2);
            bdt.c(bdt.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final bdg bdgVar) {
            C0116a c0116a = (C0116a) view.getTag();
            if (c0116a == null) {
                C0116a c0116a2 = new C0116a();
                c0116a2.a = (ImageView) view.findViewById(R.id.iv);
                c0116a2.b = (TextView) view.findViewById(R.id.text1);
                c0116a2.d = (TextView) view.findViewById(R.id.text2);
                c0116a2.c = (TextView) view.findViewById(R.id.track_time);
                c0116a2.e = (RelativeLayout) view.findViewById(R.id.more_holder);
                view.setTag(c0116a2);
                c0116a = c0116a2;
            }
            c0116a.b.setText(bdgVar.d);
            c0116a.b.setTypeface(bcw.a(bdt.this.ae));
            c0116a.d.setText(bdgVar.a);
            c0116a.d.setTypeface(bcw.b(bdt.this.ae));
            c0116a.c.setText(bcw.a(bdgVar.f));
            c0116a.c.setTypeface(bcw.b(bdt.this.ae));
            bif.a((Context) bdt.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0116a.a);
            int color = bdt.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bdt.this.q().getColor(R.color.tidal_text_disabled);
            }
            c0116a.b.setTextColor(color);
            c0116a.d.setTextColor(color);
            c0116a.c.setTextColor(color);
            c0116a.e.setOnClickListener(new View.OnClickListener() { // from class: bdt.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bdt.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bdt.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bdt.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bdt.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bdt.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!bdt.this.a(bdgVar)) {
                        arrayList.add(bdt.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bdt.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bdt.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bdt.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bdt.this.q().getString(R.string.TidalGoToArtist));
                    arrayList.add(bdt.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bdt.a.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdt.this);
                                bdt.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bdt.this.d();
                                bdh.a().a(bdt.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalPlayNext))) {
                                bdt.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalAddToQueue))) {
                                bdt.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bdt.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalGoToArtist))) {
                                bdt.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bdt.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalGoToAlbum))) {
                                bdt.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bdt.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bdt.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdt.this);
                                bdt.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bdt.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bdt.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bdt.this.d(tidalMusicDataLocalA);
                            }
                        }
                    });
                    bdpVar.show();
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: bdt$a$a, reason: collision with other inner class name */
        class C0116a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public RelativeLayout e;

            C0116a() {
            }
        }
    }
}
