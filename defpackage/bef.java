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
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bef extends bdn implements ajn, bdi.b {
    private View ah;
    private View ai;
    private TabPageIndicator al;
    private View f;
    private aic<bdg> g;
    private AnimationListView i;
    private ArrayList<bdg> h = new ArrayList<>();
    private final int aj = 20;
    private int ak = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    TabPageIndicator.a e = new TabPageIndicator.a() { // from class: bef.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bef.this.d = i;
            bef.this.c(bef.this.l());
        }
    };

    static /* synthetic */ int b(bef befVar) {
        int i = befVar.ak;
        befVar.ak = i + 1;
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
                this.ah.setVisibility(4);
                if ((str.compareTo("new") == 0 && this.d == 0) || ((str.compareTo("recommended") == 0 && this.d == 1) || (str.compareTo("top") == 0 && this.d == 2))) {
                    this.h.addAll(this.h.size(), (ArrayList) arrayList.clone());
                    this.g.b(arrayList);
                    if (arrayList.size() == 0) {
                        this.ah.setVisibility(0);
                    }
                    this.g.notifyDataSetChanged();
                }
                this.ai.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumMetaData) {
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
            bundle2.putInt("current_screen", 0);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdlVar, (arc) null);
            }
        } else if (aVar == bdh.a.UserPlaylists) {
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
            } catch (JSONException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else if (aVar == bdh.a.Radio) {
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
        this.f = layoutInflater.inflate(R.layout.tidal_track_list, (ViewGroup) null);
        this.i = (AnimationListView) this.f.findViewById(R.id.list_view);
        this.ai = this.f.findViewById(R.id.list_view_holder);
        this.ai.setVisibility(0);
        this.i.setEmptyView(this.f.findViewById(R.id.list_view_empty));
        this.ah = this.f.findViewById(R.id.list_view_empty_text);
        this.al = (TabPageIndicator) this.f.findViewById(R.id.indicator);
        this.al.setTitles(new CharSequence[]{q().getString(R.string.TidalNew), q().getString(R.string.TidalRecommended), q().getString(R.string.TidalTop20)});
        this.al.setOnTabReselectedListener(this.e);
        this.g = new aic<>(this.ae, new a(), 20, R.layout.tidal_track_item, R.layout.tidal_list_loading_invisible);
        try {
            this.g.a(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.i.setAdapter((ListAdapter) this.g);
        return this.f;
    }

    @Override // defpackage.bdn, defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            try {
                b(q().getString(R.string.TidalWhatsNew));
            } catch (Exception e) {
            }
        }
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(q().getString(R.string.TidalWhatsNew)).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ak = 1;
        d();
        this.ai.setVisibility(4);
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = new Bundle(bundle);
        }
        this.al.b(this.d);
        if (this.d == 0) {
            bdh.a().a(bdh.a.WhatsNew, this, "new", "tracks", 0, 20);
        } else if (this.d == 2) {
            bdh.a().a(bdh.a.WhatsNew, this, "top", "tracks", 0, 20);
        } else {
            bdh.a().a(bdh.a.WhatsNew, this, "recommended", "tracks", 0, 20);
        }
        this.h.clear();
        try {
            this.g.a(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g.notifyDataSetChanged();
        this.i.setOnItemChosenListener(this);
        this.i.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.i.setAdapter((ListAdapter) this.g);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        a(this.h, i);
    }

    class a implements aic.a<bdg> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (bef.this.d == 0) {
                bef.this.d();
                bdh.a().a(bdh.a.WhatsNew, bef.this, "new", "tracks", bef.this.ak * i2, i2);
            } else if (bef.this.d != 2) {
                bef.this.d();
                bdh.a().a(bdh.a.WhatsNew, bef.this, "recommended", "tracks", bef.this.ak * i2, i2);
            }
            bef.b(bef.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final bdg bdgVar) {
            C0131a c0131a = (C0131a) view.getTag();
            if (c0131a == null) {
                C0131a c0131a2 = new C0131a();
                c0131a2.a = (ImageView) view.findViewById(R.id.iv);
                c0131a2.b = (TextView) view.findViewById(R.id.text1);
                c0131a2.d = (TextView) view.findViewById(R.id.text2);
                c0131a2.c = (TextView) view.findViewById(R.id.track_time);
                c0131a2.e = (RelativeLayout) view.findViewById(R.id.more_holder);
                view.setTag(c0131a2);
                c0131a = c0131a2;
            }
            c0131a.b.setText(bdgVar.d);
            c0131a.b.setTypeface(bcw.a(bef.this.ae));
            c0131a.d.setText(bdgVar.a);
            c0131a.d.setTypeface(bcw.b(bef.this.ae));
            c0131a.c.setText(bcw.a(bdgVar.f));
            c0131a.c.setTypeface(bcw.b(bef.this.ae));
            bif.a((Context) bef.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(c0131a.a);
            int color = bef.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bef.this.q().getColor(R.color.tidal_text_disabled);
            }
            c0131a.b.setTextColor(color);
            c0131a.d.setTextColor(color);
            c0131a.c.setTextColor(color);
            c0131a.e.setOnClickListener(new View.OnClickListener() { // from class: bef.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bef.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bef.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bef.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bef.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bef.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!bef.this.a(bdgVar)) {
                        arrayList.add(bef.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bef.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bef.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bef.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bef.this.q().getString(R.string.TidalGoToArtist));
                    arrayList.add(bef.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bef.a.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bef.this);
                                bef.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bef.this.d();
                                bdh.a().a(bef.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalPlayNext))) {
                                bef.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalAddToQueue))) {
                                bef.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bef.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalGoToArtist))) {
                                bef.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bef.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalGoToAlbum))) {
                                bef.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bef.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bef.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bef.this);
                                bef.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bef.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bef.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bef.this.d(tidalMusicDataLocalA);
                            }
                        }
                    });
                    bdpVar.show();
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: bef$a$a, reason: collision with other inner class name */
        class C0131a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public RelativeLayout e;

            C0131a() {
            }
        }
    }
}
