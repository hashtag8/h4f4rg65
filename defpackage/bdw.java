package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import com.musicservice.tidal.DragSortListView;
import com.musicservice.tidal.TabPageIndicator;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
import defpackage.aic;
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdw extends bdn implements ajn, bdi.b {
    TextView ah;
    private View aj;
    private aic<bdg> ak;
    private AnimationListView al;
    private View ar;
    private View as;
    private RelativeLayout av;
    private TabPageIndicator aw;
    private RelativeLayout ax;
    private TextView ay;
    bdc e;
    ImageView f;
    TextView g;
    ScrollView h;
    TextView i;
    private final int at = 100;
    private int au = 0;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    TabPageIndicator.a ai = new TabPageIndicator.a() { // from class: bdw.4
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bdw.this.d(i);
        }
    };
    private DragSortListView.h az = new DragSortListView.h() { // from class: bdw.5
        @Override // com.musicservice.tidal.DragSortListView.h
        public void b_(int i, int i2) {
            if (i != i2) {
                List<bdg> listE = bdw.this.an.e();
                bdg bdgVar = listE.get(i);
                listE.remove(bdgVar);
                listE.add(i2, bdgVar);
                bdh.a().a(bdw.this.e.b, aho.d("tidal_session_auth_token").trim(), "" + i, i2, bdw.this);
                try {
                    bdw.this.ak.a(listE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bdw.this.ak.notifyDataSetChanged();
            }
        }
    };

    static /* synthetic */ int f(bdw bdwVar) {
        int i = bdwVar.au;
        bdwVar.au = i + 1;
        return i;
    }

    @Override // defpackage.bdn, defpackage.bdm, age.a
    public void a(int i, List<MusicData> list, JSONObject jSONObject) {
        this.ar.setVisibility(4);
        List<bdg> listE = this.an.e();
        if (listE.size() == 0) {
            this.ar.setVisibility(0);
        }
        if (this.au == 0) {
            this.ak.a(listE);
            this.ak.notifyDataSetChanged();
        } else if (i + 100 > listE.size()) {
            this.ak.b(listE.subList(i, listE.size()));
        } else {
            this.ak.b(listE.subList(i, i + 100));
        }
        this.as.setVisibility(0);
        mm.b();
        am();
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar = new bda();
            try {
                bdaVar.a = "" + jSONObject.getInt("id");
                bdaVar.e = jSONObject.getString("cover");
                bdaVar.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("artist");
                    bdaVar.c = jSONObject2.getString("name");
                    bdaVar.d = "" + jSONObject2.getInt("id");
                }
            } catch (JSONException e) {
                e.printStackTrace();
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            am();
            bdl bdlVar = new bdl();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", bdbVar);
            bundle2.putInt("current_screen", 0);
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
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                while (i < jSONArray.length()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject3.getString("description");
                    bdcVar.d = jSONObject3.getInt("duration");
                    bdcVar.a = jSONObject3.getString("title");
                    bdcVar.e = jSONObject3.getString("url");
                    bdcVar.b = jSONObject3.getString("uuid");
                    bdcVar.f = jSONObject3.getInt("numberOfTracks");
                    arrayList.add(bdcVar);
                    i++;
                }
                am();
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList, str, this);
                return;
            } catch (JSONException e3) {
                am();
                e3.printStackTrace();
                return;
            }
        }
        if (aVar == bdh.a.Radio) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                    bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject4.getInt("id");
                    bdgVar.d = jSONObject4.getString("title");
                    bdgVar.e = jSONObject4.getString("url");
                    bdgVar.f = jSONObject4.getInt("duration");
                    bdgVar.j = jSONObject4.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject4.getBoolean("streamReady");
                    bdgVar.l = jSONObject4.getString("streamStartDate");
                    if (jSONObject4.has("artist")) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("artist");
                        bdgVar.a = jSONObject5.getString("name");
                        bdgVar.b = "" + jSONObject5.getInt("id");
                    }
                    if (jSONObject4.has("album")) {
                        JSONObject jSONObject6 = jSONObject4.getJSONObject("album");
                        bdgVar.h = jSONObject6.getString("title");
                        bdgVar.g = "" + jSONObject6.getInt("id");
                        bdgVar.i = jSONObject6.getString("cover");
                    }
                    arrayList2.add(bdgVar);
                }
                new ArrayList();
                TidalRadio tidalRadio = new TidalRadio();
                tidalRadio.a(str);
                while (i < arrayList2.size()) {
                    TidalMusicDataLocal tidalMusicDataLocalA = bdh.a((bdg) arrayList2.get(i));
                    if (tidalMusicDataLocalA != null) {
                        tidalRadio.a(tidalMusicDataLocalA);
                    }
                    i++;
                }
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(tidalRadio);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.EditPlaylist) {
            String strOptString = jSONObject.optString("title");
            String strOptString2 = jSONObject.optString("description");
            this.e.a = strOptString;
            this.e.c = strOptString2;
            c(strOptString);
            this.g.setText(this.e.a);
            this.ah.setText(this.e.c);
            if (!this.e.c.isEmpty()) {
                this.i.setText(this.e.c);
            }
            am();
            return;
        }
        if (aVar == bdh.a.PreEditPlaylist) {
            String strOptString3 = jSONObject.optString("title");
            String strOptString4 = jSONObject.optString("description");
            this.e.a = strOptString3;
            this.e.c = strOptString4;
            c(strOptString3);
            this.g.setText(this.e.a);
            this.ah.setText(this.e.c);
            if (!this.e.c.isEmpty()) {
                this.i.setText(this.e.c);
            }
            bdh.a().a(this.e.b, aho.d("tidal_session_auth_token").trim(), strOptString3, strOptString4, this);
            am();
            return;
        }
        if (aVar == bdh.a.DeletePlaylist) {
            mm.b("DELETE", "playlist deleted");
            am();
            this.ae.onBackPressed();
        } else {
            if (aVar == bdh.a.CreatePlaylist) {
                am();
                return;
            }
            if (aVar == bdh.a.AddTrack) {
                am();
                c(l());
            } else if (aVar == bdh.a.EditPlaylistTracks) {
                mm.b("EDIT", "have reordered music tracks");
                am();
            } else if (aVar == bdh.a.ShowProgress) {
                d();
            }
        }
    }

    private void c(String str) {
        ((TypefaceTextView) ((Toolbar) p().findViewById(R.id.toolbar)).findViewById(R.id.toolbar_title)).setText(str);
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        am();
    }

    public void ao() {
        String str = "";
        List<bdg> listE = this.an.e();
        int i = 0;
        while (i < listE.size()) {
            String str2 = str + "" + listE.get(i).c;
            if (i != listE.size() - 1) {
                str2 = str2 + ",";
            }
            i++;
            str = str2;
        }
        bdh.a().a(this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), str, 0, 100);
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = layoutInflater.inflate(R.layout.tidal_track_list, (ViewGroup) null);
        this.as = this.aj.findViewById(R.id.drag_list_view_holder);
        this.al = (AnimationListView) this.aj.findViewById(R.id.public_list_view);
        this.al.setEmptyView(this.aj.findViewById(R.id.drag_list_view_empty));
        this.ar = this.aj.findViewById(R.id.drag_list_view_empty_text);
        this.h = (ScrollView) this.aj.findViewById(R.id.description_holder);
        this.i = (TextView) this.aj.findViewById(R.id.description);
        this.aw = (TabPageIndicator) this.aj.findViewById(R.id.indicator);
        this.aw.setTitles(new CharSequence[]{q().getString(R.string.TidalTracks), q().getString(R.string.TidalDescription)});
        this.aw.setOnTabReselectedListener(this.ai);
        View viewInflate = layoutInflater.inflate(R.layout.tidal_playlist_header, (ViewGroup) null);
        ((ImageView) viewInflate.findViewById(R.id.cover_play)).setOnClickListener(new View.OnClickListener() { // from class: bdw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(bdw.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else {
                    bdw.this.b(bdw.this.an.e());
                }
            }
        });
        this.ah = (TextView) viewInflate.findViewById(R.id.header_description);
        if (ahn.a() && this.ae.getResources().getInteger(R.integer.Tidal_portrait) == 0) {
            ((ScrollView) viewInflate.findViewById(R.id.header_description_holder)).setOnTouchListener(new View.OnTouchListener() { // from class: bdw.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
        this.f = (ImageView) viewInflate.findViewById(R.id.iv);
        this.g = (TextView) viewInflate.findViewById(R.id.cover_title);
        this.g.setSelected(true);
        this.g.requestFocus();
        this.g.setTypeface(bcw.b(this.ae));
        this.av = (RelativeLayout) viewInflate.findViewById(R.id.more_holder);
        this.al.addHeaderView(viewInflate);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: bdw.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bdp bdpVar = new bdp(bdw.this.ae, bdw.this.e.a);
                final ArrayList arrayList = new ArrayList();
                if (bdw.this.an.e().size() > 0) {
                    arrayList.add(bdw.this.q().getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(bdw.this.q().getString(R.string.TidalPlayNext));
                    arrayList.add(bdw.this.q().getString(R.string.TidalAddToQueue));
                    arrayList.add(bdw.this.q().getString(R.string.PlayTip_ClearAll_Str));
                }
                if (bdw.this.e.g != null && bdw.this.e.g.compareTo(bdw.this.q().getString(R.string.TidalMe)) == 0) {
                    arrayList.add(bdw.this.q().getString(R.string.TidalEdit));
                    arrayList.add(bdw.this.q().getString(R.string.TidalDelete));
                }
                if (!bdw.this.a(bdw.this.e)) {
                    arrayList.add(bdw.this.q().getString(R.string.TidalFavourite));
                } else {
                    arrayList.add(bdw.this.q().getString(R.string.TidalUnFavourite));
                }
                arrayList.add(bdw.this.q().getString(R.string.TidalAddToPlaylist));
                bdpVar.a(arrayList);
                bdpVar.a(bdw.this.e.a);
                bdpVar.a(new asi() { // from class: bdw.3.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        List<bdg> listE = bdw.this.an.e();
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalFavourite))) {
                            bdh.a().d(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdw.this.e.b, bdw.this);
                            bdw.this.b(bdw.this.e);
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalAddToPlaylist))) {
                            bdw.this.d();
                            listE.size();
                            mm.b("PLAYLIST", "size = " + listE.size() + " tracks=" + bdw.this.e.f);
                            bdw.this.ao();
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalPlayNext))) {
                            bdw.this.a(listE);
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalAddToQueue))) {
                            bdw.this.d(listE);
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalEdit))) {
                            bcw.a(bdw.this.ae, bdw.this.e.a, bdw.this.e.c, bdw.this.e.b, bdw.this);
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalDelete))) {
                            bdh.a().a(bdw.this.ae, bdw.this.e.b, aho.d("tidal_session_auth_token").trim(), bdw.this);
                            return;
                        }
                        if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.TidalUnFavourite))) {
                            bdh.a().d(bdw.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdw.this.e.b, bdw.this);
                            bdw.this.c(bdw.this.e);
                        } else if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                            bdw.this.c(listE);
                        } else if (((String) arrayList.get(i)).equals(bdw.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                            bdw.this.e(listE);
                        }
                    }
                });
                bdpVar.show();
            }
        };
        this.av.setOnClickListener(onClickListener);
        this.ay = (TextView) this.aj.findViewById(R.id.empty_cover_title);
        this.ax = (RelativeLayout) this.aj.findViewById(R.id.empty_more_holder);
        this.ax.setOnClickListener(onClickListener);
        this.ak = new aic<>(this.ae, new a(), 100, R.layout.tidal_track_item, R.layout.harman_list_loading);
        try {
            this.ak.a(this.an.e());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.al.setAdapter((ListAdapter) this.ak);
        return this.aj;
    }

    protected void d(int i) {
        this.aw.b(i);
        switch (i) {
            case 0:
                if (al()) {
                    this.as.setVisibility(4);
                } else {
                    this.as.setVisibility(0);
                }
                this.h.setVisibility(8);
                break;
            case 1:
                this.as.setVisibility(8);
                this.h.setVisibility(0);
                break;
        }
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.e.a).e(q().getColor(R.color.black)).c();
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        String str;
        super.c(bundle);
        d();
        this.e = (bdc) bundle.getSerializable("playlist");
        this.an = new bdj(bdh.a.PlaylistTracks, this.e.b);
        this.al.setVisibility(0);
        this.ar.setVisibility(4);
        if (ahn.a() && this.ae.getResources().getInteger(R.integer.Tidal_portrait) == 0) {
            this.aw.setVisibility(8);
        } else {
            this.aw.setVisibility(0);
        }
        b(q().getString(R.string.TidalPlaylists));
        this.g.setText(this.e.a);
        this.g.setTypeface(bcw.b(this.ae));
        this.ay.setText(this.e.a);
        this.ay.setTypeface(bcw.b(this.ae));
        if (!this.e.c.isEmpty()) {
            this.i.setText(this.e.c);
        }
        this.ah.setText(this.e.c);
        if (this.e.h != null && this.e.h.compareTo("null") != 0) {
            str = "http://resources.wimpmusic.com/images/" + this.e.h.replace("-", "/") + "/320x214.jpg";
        } else {
            str = "http://images.osl.wimpmusic.com/im/im?w=320&h=214&uuid=" + this.e.b;
        }
        if (ahn.a() && this.ae.getResources().getInteger(R.integer.Tidal_portrait) == 0) {
            bif.a((Context) this.ae).a(str).a(R.drawable.tidal_placeholder_150x150).a(bib.NO_STORE, new bib[0]).a(this.f);
        } else {
            bif.a((Context) this.ae).a(str).a(R.drawable.tidal_placeholder_150x150).a((bir) new bcs(this.e.h)).a(bib.NO_STORE, new bib[0]).a(this.f);
        }
        this.an.b();
        try {
            this.ak.a(this.an.e());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ak.notifyDataSetChanged();
        if (this.e.f != 0) {
            this.au = 0;
        }
        this.an.a(0, 100, this);
        this.al.setOnItemChosenListener(this);
        this.al.setOnScrollListener(new bcz(this.ae));
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.al.setLeftMargin((int) dimension);
        }
        this.aw.setCurrentItem(0);
        d(0);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else {
            a(this.an.e(), this.an, i - 1);
        }
    }

    @Override // defpackage.bdn
    public void c() {
        this.al.setAdapter((ListAdapter) this.ak);
    }

    class a implements aic.a<bdg> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (bdw.this.an.e().size() >= bdw.this.e.f) {
                bdw.this.ak.a();
            } else {
                bdw.f(bdw.this);
                bdw.this.an.a(bdw.this.au * i2, i2, bdw.this);
            }
        }

        @Override // aic.a
        public View a(final int i, View view, ViewGroup viewGroup, final bdg bdgVar) {
            C0120a c0120a = (C0120a) view.getTag();
            if (c0120a == null) {
                C0120a c0120a2 = new C0120a();
                c0120a2.a = (ImageView) view.findViewById(R.id.iv);
                c0120a2.b = (TextView) view.findViewById(R.id.text1);
                c0120a2.d = (TextView) view.findViewById(R.id.text2);
                c0120a2.c = (TextView) view.findViewById(R.id.track_time);
                c0120a2.e = (RelativeLayout) view.findViewById(R.id.more_holder);
                view.setTag(c0120a2);
                c0120a = c0120a2;
            }
            c0120a.b.setText(bdgVar.d);
            c0120a.b.setTypeface(bcw.a(bdw.this.ae));
            c0120a.d.setText(bdgVar.a);
            c0120a.d.setTypeface(bcw.b(bdw.this.ae));
            c0120a.c.setText(bcw.a(bdgVar.f));
            c0120a.c.setTypeface(bcw.b(bdw.this.ae));
            bif.a((Context) bdw.this.ae).a("http://resources.wimpmusic.com/images/" + bdgVar.i.replace("-", "/") + "/160x160.jpg").a(R.drawable.tidal_placeholder_150x150).b(ahn.a(bdw.this.ae, 60.0f), ahn.a(bdw.this.ae, 60.0f)).a("tidal").a(c0120a.a);
            int color = bdw.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bdw.this.q().getColor(R.color.tidal_text_disabled);
            }
            c0120a.b.setTextColor(color);
            c0120a.d.setTextColor(color);
            c0120a.c.setTextColor(color);
            c0120a.e.setOnClickListener(new View.OnClickListener() { // from class: bdw.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bdw.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bdw.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bdw.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bdw.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bdw.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (bdw.this.e.g != null && bdw.this.e.g.compareTo(bdw.this.q().getString(R.string.TidalMe)) == 0) {
                        arrayList.add(bdw.this.q().getString(R.string.TidalDelete));
                    }
                    if (!bdw.this.a(bdgVar)) {
                        arrayList.add(bdw.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bdw.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bdw.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bdw.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bdw.this.q().getString(R.string.TidalGoToArtist));
                    arrayList.add(bdw.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bdw.a.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            List<bdg> listE = bdw.this.an.e();
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdw.this);
                                bdw.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bdw.this.d();
                                bdh.a().a(bdw.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalPlayNext))) {
                                bdw.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalAddToQueue))) {
                                bdw.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bdw.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalGoToArtist))) {
                                bdw.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bdw.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalGoToAlbum))) {
                                bdw.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bdw.this, bdgVar.g, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bdw.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdw.this);
                                bdw.this.c(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.TidalDelete))) {
                                bdh.a().c(bdw.this.ae, bdw.this.e.b, aho.d("tidal_session_auth_token").trim(), "" + i, bdw.this);
                                listE.remove(i);
                                try {
                                    bdw.this.ak.a(listE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                bdw.this.ak.notifyDataSetChanged();
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bdw.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bdw.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bdw.this.d(tidalMusicDataLocalA);
                            }
                        }
                    });
                    bdpVar.show();
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: bdw$a$a, reason: collision with other inner class name */
        class C0120a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public RelativeLayout e;

            C0120a() {
            }
        }
    }
}
