package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import defpackage.bdh;
import defpackage.bdi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class bdu extends bdn implements bdi.b {
    protected View a;
    protected LayoutInflater ah;
    protected LinearLayout b;
    protected ControlInterceptTouchScrollView h;
    protected ajp i;
    private final int aj = 100;
    protected ArrayList<bdc> c = new ArrayList<>();
    protected ArrayList<bda> d = new ArrayList<>();
    protected ArrayList<bdg> e = new ArrayList<>();
    protected ArrayList<LinearLayout> f = new ArrayList<>();
    protected ArrayList<LinearLayout> g = new ArrayList<>();
    protected ajn ai = new ajn() { // from class: bdu.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            Object tag = view.getTag(R.id.view_tag_callback_item);
            if (tag != null) {
                if (tag instanceof bdg) {
                    bdu.this.a(bdu.this.e, bdu.this.e.indexOf(tag));
                    return;
                }
                if (tag instanceof bda) {
                    bdh.a().a(bdh.a.AlbumTracks, bdu.this, ((bda) tag).a, "", 0, 100);
                } else if (tag instanceof bdc) {
                    bdu.this.an = new bdj(bdh.a.PlaylistTracks, ((bdc) tag).b);
                    bdu.this.an.a(0, 100, bdu.this);
                }
            }
        }
    };

    abstract bdh.a ao();

    abstract bdh.a ap();

    abstract bdh.a aq();

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (LinearLayout) this.a.findViewById(R.id.track_list);
        int i = ahn.a() ? 6 : 4;
        this.g.clear();
        this.f.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.g.add((LinearLayout) this.a.findViewById(q().getIdentifier("layout_albums" + (i2 + 1), "id", p().getPackageName())));
            this.f.add((LinearLayout) this.a.findViewById(q().getIdentifier("layout_playlist" + (i2 + 1), "id", p().getPackageName())));
            a aVar = new a();
            aVar.b = (TextView) this.g.get(i2).findViewById(q().getIdentifier("tv_albums" + (i2 + 1), "id", p().getPackageName()));
            aVar.a = (TextView) this.g.get(i2).findViewById(q().getIdentifier("tv_albums" + (i2 + 1) + "a", "id", p().getPackageName()));
            aVar.c = (ImageView) this.g.get(i2).findViewById(q().getIdentifier("iv_albums" + (i2 + 1), "id", p().getPackageName()));
            this.g.get(i2).setTag(R.id.viewholder, aVar);
            a aVar2 = new a();
            aVar2.b = (TextView) this.f.get(i2).findViewById(q().getIdentifier("tv_playlist" + (i2 + 1), "id", p().getPackageName()));
            aVar2.a = (TextView) this.f.get(i2).findViewById(q().getIdentifier("tv_playlist" + (i2 + 1) + "a", "id", p().getPackageName()));
            aVar2.c = (ImageView) this.f.get(i2).findViewById(q().getIdentifier("iv_playlist" + (i2 + 1), "id", p().getPackageName()));
            this.f.get(i2).setTag(R.id.viewholder, aVar2);
        }
        this.h = (ControlInterceptTouchScrollView) this.a.findViewById(R.id.scroll_view);
        this.i = new ajp((DashboardActivity) p(), this.h);
        this.h.setOnTouchListener(this.i);
        this.i.a(this.ai);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.a;
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (this.h != null) {
            this.h.scrollTo(0, 0);
        }
    }

    @Override // defpackage.bdn, android.support.v4.app.Fragment
    public void i() {
        super.i();
        this.a = null;
        this.ah = null;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == ap()) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject2.getString("description");
                    bdcVar.d = jSONObject2.getInt("duration");
                    bdcVar.a = jSONObject2.getString("title");
                    bdcVar.e = jSONObject2.getString("url");
                    bdcVar.b = jSONObject2.getString("uuid");
                    bdcVar.f = jSONObject2.getInt("numberOfTracks");
                    bdcVar.h = jSONObject2.getString("image");
                    if (jSONObject2.has("creator")) {
                        int i3 = jSONObject2.getJSONObject("creator").getInt("id");
                        if (i3 == 0) {
                            bdcVar.g = "TIDAL";
                        } else if (("" + i3).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar.g = "me";
                        } else {
                            bdcVar.g = "" + i3;
                        }
                    }
                    this.c.add(bdcVar);
                }
                while (true) {
                    int i4 = i;
                    if (i4 >= this.f.size()) {
                        break;
                    }
                    LinearLayout linearLayout = this.f.get(i4);
                    final bdc bdcVar2 = this.c.get(i4);
                    a aVar2 = (a) linearLayout.getTag(R.id.viewholder);
                    ImageView imageView = aVar2.c;
                    TextView textView = aVar2.b;
                    TextView textView2 = aVar2.a;
                    mm.b("TIDAL", "loading http://images.osl.wimpmusic.com/im/im?w=300&h=225&uuid=" + bdcVar2.b);
                    bif.a((Context) this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&uuid=" + bdcVar2.b).a(R.drawable.tidal_placeholder_300x225).a(imageView);
                    linearLayout.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: bdu.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            bdw bdwVar = new bdw();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("playlist", bdcVar2);
                            bdwVar.g(bundle);
                            if (!ahn.a()) {
                                bdu.this.ae.q().a(bdwVar, (arc) null);
                            } else {
                                bdu.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
                            }
                        }
                    });
                    linearLayout.setOnTouchListener(this.i);
                    linearLayout.setTag(R.id.view_tag_callback_item, bdcVar2);
                    if (textView != null) {
                        textView.setText(bdcVar2.a);
                        textView.setTypeface(bcw.a(this.ae));
                    }
                    if (textView2 != null) {
                        textView2.setText(this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar2.f)}));
                        textView2.setTypeface(bcw.b(this.ae));
                    }
                    i = i4 + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (aVar == ao()) {
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i5);
                    bda bdaVar = new bda();
                    bdaVar.a = "" + jSONObject3.getInt("id");
                    bdaVar.e = jSONObject3.getString("cover");
                    bdaVar.b = jSONObject3.getString("title");
                    if (jSONObject3.has("artist")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("artist");
                        bdaVar.c = jSONObject4.getString("name");
                        bdaVar.d = "" + jSONObject4.getInt("id");
                    }
                    this.d.add(bdaVar);
                }
                while (true) {
                    int i6 = i;
                    if (i6 >= this.g.size()) {
                        break;
                    }
                    LinearLayout linearLayout2 = this.g.get(i6);
                    final bda bdaVar2 = this.d.get(i6);
                    a aVar3 = (a) linearLayout2.getTag(R.id.viewholder);
                    ImageView imageView2 = aVar3.c;
                    TextView textView3 = aVar3.b;
                    TextView textView4 = aVar3.a;
                    mm.b("TIDAL", "loading http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar2.a);
                    bif.a((Context) this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdaVar2.a).a(R.drawable.tidal_placeholder_300x300).a(imageView2);
                    linearLayout2.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: bdu.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            bdk bdkVar = new bdk();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("album", bdaVar2);
                            bundle.putInt("current_screen", 0);
                            bdkVar.g(bundle);
                            if (!ahn.a()) {
                                bdu.this.ae.q().a(bdkVar, (arc) null);
                            } else {
                                bdu.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
                            }
                        }
                    });
                    linearLayout2.setOnTouchListener(this.i);
                    linearLayout2.setTag(R.id.view_tag_callback_item, bdaVar2);
                    if (textView3 != null) {
                        textView3.setText(bdaVar2.b);
                        textView3.setTypeface(bcw.a(this.ae));
                    }
                    if (textView4 != null) {
                        textView4.setText(bdaVar2.c);
                        textView4.setTypeface(bcw.b(this.ae));
                    }
                    i = i6 + 1;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (aVar == aq()) {
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                this.e.clear();
                this.b.removeAllViews();
                while (true) {
                    int i7 = i;
                    if (i7 >= jSONArray3.length()) {
                        break;
                    }
                    JSONObject jSONObject5 = jSONArray3.getJSONObject(i7);
                    final bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject5.getInt("id");
                    bdgVar.d = jSONObject5.getString("title");
                    bdgVar.e = jSONObject5.getString("url");
                    bdgVar.f = jSONObject5.getInt("duration");
                    bdgVar.j = jSONObject5.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject5.getBoolean("streamReady");
                    bdgVar.l = jSONObject5.getString("streamStartDate");
                    if (jSONObject5.has("artist")) {
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("artist");
                        bdgVar.a = jSONObject6.getString("name");
                        bdgVar.b = "" + jSONObject6.getInt("id");
                    }
                    if (jSONObject5.has("album")) {
                        JSONObject jSONObject7 = jSONObject5.getJSONObject("album");
                        bdgVar.h = jSONObject7.getString("title");
                        bdgVar.g = "" + jSONObject7.getInt("id");
                        bdgVar.i = jSONObject7.getString("cover");
                    }
                    this.e.add(bdgVar);
                    View viewInflate = this.ah.inflate(R.layout.tidal_track_item, (ViewGroup) null);
                    if (viewInflate != null) {
                        viewInflate.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: bdu.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                bdu.this.a(bdu.this.e, bdu.this.e.indexOf(bdgVar));
                            }
                        });
                        viewInflate.setOnTouchListener(this.i);
                        viewInflate.setTag(R.id.view_tag_callback_item, bdgVar);
                    }
                    TextView textView5 = (TextView) viewInflate.findViewById(R.id.text1);
                    TextView textView6 = (TextView) viewInflate.findViewById(R.id.text2);
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.iv);
                    ((RelativeLayout) viewInflate.findViewById(R.id.more_holder)).setOnClickListener(new View.OnClickListener() { // from class: bdu.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            bdp bdpVar = new bdp(bdu.this.ae, bdgVar.d);
                            final ArrayList arrayList = new ArrayList();
                            if (bdgVar.j && bdgVar.k) {
                                arrayList.add(bdu.this.q().getString(R.string.PlayTip_PlayNow_Str));
                                arrayList.add(bdu.this.q().getString(R.string.TidalPlayNext));
                                arrayList.add(bdu.this.q().getString(R.string.TidalAddToQueue));
                                arrayList.add(bdu.this.q().getString(R.string.PlayTip_ClearAll_Str));
                            }
                            if (!bdu.this.a(bdgVar)) {
                                arrayList.add(bdu.this.q().getString(R.string.TidalFavourite));
                            } else {
                                arrayList.add(bdu.this.q().getString(R.string.TidalUnFavourite));
                            }
                            arrayList.add(bdu.this.q().getString(R.string.TidalAddToPlaylist));
                            arrayList.add(bdu.this.q().getString(R.string.TidalTrackRadio));
                            arrayList.add(bdu.this.q().getString(R.string.TidalGoToArtist));
                            arrayList.add(bdu.this.q().getString(R.string.TidalGoToAlbum));
                            bdpVar.a(arrayList);
                            bdpVar.a(bdgVar.d);
                            final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                            bdpVar.a(new asi() { // from class: bdu.5.1
                                @Override // defpackage.asi
                                public void a(int i8) {
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalFavourite))) {
                                        bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdu.this);
                                        bdu.this.b(bdgVar);
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalAddToPlaylist))) {
                                        bdu.this.d();
                                        bdh.a().a(bdu.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, 100);
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalPlayNext))) {
                                        bdu.this.b(tidalMusicDataLocalA);
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalAddToQueue))) {
                                        bdu.this.c(tidalMusicDataLocalA);
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalTrackRadio))) {
                                        bdh.a().a(bdh.a.Radio, bdu.this, bdgVar.c, "", 0, bdh.a);
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalGoToArtist))) {
                                        bdu.this.d();
                                        bdh.a().a(bdh.a.ArtistMetaData, bdu.this, bdgVar.b, "");
                                        return;
                                    }
                                    if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalGoToAlbum))) {
                                        bdu.this.d();
                                        bdh.a().a(bdh.a.AlbumMetaData, bdu.this, bdgVar.g, "");
                                    } else if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.TidalUnFavourite))) {
                                        bdh.a().b(bdu.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdu.this);
                                        bdu.this.c(bdgVar);
                                    } else if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                        bdu.this.a(tidalMusicDataLocalA);
                                    } else if (((String) arrayList.get(i8)).equals(bdu.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                        bdu.this.d(tidalMusicDataLocalA);
                                    }
                                }
                            });
                            bdpVar.show();
                        }
                    });
                    int color = (bdgVar.j && bdgVar.k) ? q().getColor(R.color.white) : q().getColor(R.color.tidal_text_disabled);
                    TextView textView7 = (TextView) viewInflate.findViewById(R.id.track_time);
                    textView5.setText(bdgVar.d);
                    textView5.setTypeface(bcw.a(this.ae));
                    textView6.setText(bdgVar.a);
                    textView6.setTypeface(bcw.b(this.ae));
                    textView7.setText("" + bcw.a(bdgVar.f));
                    textView7.setTypeface(bcw.b(this.ae));
                    textView5.setTextColor(color);
                    textView6.setTextColor(color);
                    textView7.setTextColor(color);
                    bif.a((Context) this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a(imageView3);
                    this.b.addView(viewInflate);
                    mm.b("TIDAL", "loading http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g);
                    i = i7 + 1;
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        } else if (aVar == bdh.a.AlbumTracks || aVar == bdh.a.ArtistTracks) {
            b(bcv.a(jSONObject));
        } else if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar3 = new bda();
            try {
                bdaVar3.a = "" + jSONObject.getInt("id");
                bdaVar3.e = jSONObject.getString("cover");
                bdaVar3.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject8 = jSONObject.getJSONObject("artist");
                    bdaVar3.c = jSONObject8.getString("name");
                    bdaVar3.d = "" + jSONObject8.getInt("id");
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (str.compareTo("play") == 0) {
                bcw.a(bdaVar3);
            } else {
                bdk bdkVar = new bdk();
                Bundle bundle = new Bundle();
                bundle.putSerializable("album", bdaVar3);
                bundle.putInt("current_screen", 0);
                bdkVar.g(bundle);
                if (ahn.a()) {
                    this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
                } else {
                    this.ae.q().a(bdkVar, (arc) null);
                }
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
            if (str.compareTo("play") == 0) {
                bcw.a(bdbVar);
            } else {
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
            }
        } else if (aVar == bdh.a.PlaylistMetaData) {
            bdc bdcVar3 = new bdc();
            try {
                bdcVar3.c = jSONObject.getString("description");
                bdcVar3.d = jSONObject.getInt("duration");
                bdcVar3.a = jSONObject.getString("title");
                bdcVar3.e = jSONObject.getString("url");
                bdcVar3.b = jSONObject.getString("uuid");
                bdcVar3.f = jSONObject.getInt("numberOfTracks");
                bdcVar3.h = jSONObject.getString("image");
                if (jSONObject.has("creator")) {
                    int i8 = jSONObject.getJSONObject("creator").getInt("id");
                    if (i8 == 0) {
                        bdcVar3.g = "TIDAL";
                    } else if (("" + i8).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                        bdcVar3.g = "me";
                    } else {
                        bdcVar3.g = "" + i8;
                    }
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            if (str.compareTo("play") == 0) {
                this.an = new bdj(bdh.a.PlaylistTracks, bdcVar3.b);
                this.an.a(0, 100, this);
            } else {
                bdw bdwVar = new bdw();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("playlist", bdcVar3);
                bdwVar.g(bundle3);
                if (ahn.a()) {
                    this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
                } else {
                    this.ae.q().a(bdwVar, (arc) null);
                }
            }
        } else if (aVar == bdh.a.UserPlaylists) {
            am();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray4 = jSONObject.getJSONArray("items");
                for (int i9 = 0; i9 < jSONArray4.length(); i9++) {
                    JSONObject jSONObject9 = jSONArray4.getJSONObject(i9);
                    bdc bdcVar4 = new bdc();
                    bdcVar4.c = jSONObject9.getString("description");
                    bdcVar4.d = jSONObject9.getInt("duration");
                    bdcVar4.a = jSONObject9.getString("title");
                    bdcVar4.e = jSONObject9.getString("url");
                    bdcVar4.b = jSONObject9.getString("uuid");
                    bdcVar4.f = jSONObject9.getInt("numberOfTracks");
                    arrayList.add(bdcVar4);
                }
                bcw.a(this.ae, "Playlist", (ArrayList<bdc>) arrayList, str, this);
            } catch (JSONException e7) {
                e7.printStackTrace();
            } catch (Exception e8) {
                new ml().a("Non-JSON exception while parsing JSON", e8);
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

    public class a {
        TextView a;
        TextView b;
        ImageView c;

        protected a() {
        }
    }
}
