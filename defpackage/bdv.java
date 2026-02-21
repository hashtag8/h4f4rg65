package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdv extends bdn implements bdi.b {
    private aic<bdb> aA;
    private TabPageIndicator aF;
    private ArrayList<bdc> aG;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private AnimationListView ah;
    private View ai;
    private View aj;
    private View ak;
    private View al;
    private View ar;
    private View as;
    private View at;
    private View au;
    private aic<bdg> ax;
    private aic<bda> ay;
    private aic<bdc> az;
    private View f;
    private AnimationListView g;
    private AnimationGridView h;
    private AnimationGridView i;
    private final int av = HttpStatus.SC_OK;
    private int aw = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    int d = 0;
    private ArrayList<bdg> aB = new ArrayList<>();
    private ArrayList<bda> aC = new ArrayList<>();
    private ArrayList<bdc> aD = new ArrayList<>();
    private ArrayList<bdb> aE = new ArrayList<>();
    private JSONArray aH = null;
    TabPageIndicator.a e = new TabPageIndicator.a() { // from class: bdv.1
        @Override // com.musicservice.tidal.TabPageIndicator.a
        public void a(int i) {
            bdv.this.d();
            switch (i) {
                case 0:
                    if (!bdv.this.aI) {
                        bdh.a().a(bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), "", 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
                    } else {
                        bdv.this.am();
                    }
                    break;
                case 1:
                    if (!bdv.this.aJ) {
                        bdh.a().a(bdh.a.FavouriteArtists, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                    } else {
                        bdv.this.am();
                    }
                    break;
                case 2:
                    if (!bdv.this.aK) {
                        bdh.a().a(bdh.a.FavouriteAlbums, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                    } else {
                        bdv.this.am();
                    }
                    break;
                case 3:
                    if (!bdv.this.aL) {
                        bdh.a().a(bdh.a.FavouriteTracks, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                    } else {
                        bdv.this.am();
                    }
                    break;
                default:
                    bdv.this.am();
                    break;
            }
            bdv.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener aM = new AdapterView.OnItemClickListener() { // from class: bdv.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", (Serializable) bdv.this.aC.get(i));
            bundle.putInt("current_screen", 0);
            bdkVar.g(bundle);
            if (!ahn.a()) {
                bdv.this.ae.q().a(bdkVar, (arc) null);
            } else {
                bdv.this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aN = new AdapterView.OnItemClickListener() { // from class: bdv.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdw bdwVar = new bdw();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) bdv.this.aD.get(i));
            bdwVar.g(bundle);
            if (!ahn.a()) {
                bdv.this.ae.q().a(bdwVar, (arc) null);
            } else {
                bdv.this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private AdapterView.OnItemClickListener aO = new AdapterView.OnItemClickListener() { // from class: bdv.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            bdl bdlVar = new bdl();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Serializable) bdv.this.aE.get(i));
            bundle.putInt("current_screen", 0);
            bdlVar.g(bundle);
            if (!ahn.a()) {
                bdv.this.ae.q().a(bdlVar, (arc) null);
            } else {
                bdv.this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private ajn aP = new ajn() { // from class: bdv.5
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            switch (view.getId()) {
                case R.id.tracks_list_view /* 2131690451 */:
                    bdv.this.d((bdg) obj);
                    break;
                case R.id.albums_gridview /* 2131690458 */:
                    bdv.this.d((bda) bdv.this.aC.get(i));
                    break;
                case R.id.playlist_view /* 2131691121 */:
                    bdv.this.e(i);
                    break;
                case R.id.artists_gridview /* 2131691125 */:
                    bdv.this.d((bdb) obj);
                    break;
            }
        }
    };

    static /* synthetic */ int o(bdv bdvVar) {
        int i = bdvVar.aw;
        bdvVar.aw = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        boolean z;
        int i = 0;
        if (aVar == bdh.a.FavouriteTracks) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArrayA = a(jSONObject.getJSONArray("items"));
                while (i < jSONArrayA.length()) {
                    JSONObject jSONObject3 = jSONArrayA.getJSONObject(i).getJSONObject("item");
                    bdg bdgVar = new bdg();
                    bdgVar.c = "" + jSONObject3.getInt("id");
                    bdgVar.d = jSONObject3.getString("title");
                    bdgVar.e = jSONObject3.getString("url");
                    bdgVar.f = jSONObject3.getInt("duration");
                    bdgVar.j = jSONObject3.getBoolean("allowStreaming");
                    bdgVar.k = jSONObject3.getBoolean("streamReady");
                    bdgVar.l = jSONObject3.getString("streamStartDate");
                    if (jSONObject3.has("artist")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("artist");
                        bdgVar.a = jSONObject4.getString("name");
                        bdgVar.b = "" + jSONObject4.getInt("id");
                    }
                    if (jSONObject3.has("album")) {
                        JSONObject jSONObject5 = jSONObject3.getJSONObject("album");
                        bdgVar.h = jSONObject5.getString("title");
                        bdgVar.g = "" + jSONObject5.getInt("id");
                        bdgVar.i = jSONObject5.getString("cover");
                    }
                    arrayList.add(bdgVar);
                    b(bdgVar);
                    i++;
                }
                this.aB.addAll(this.aB.size(), (ArrayList) arrayList.clone());
                this.ax.b(arrayList);
                this.ax.notifyDataSetChanged();
                this.ar.setVisibility(4);
                mm.b("TIDAL", "getcount=" + this.ax.getCount());
                if (this.ai.getVisibility() == 4) {
                    this.ai.setVisibility(0);
                }
                if (arrayList.size() == 0) {
                    this.ar.setVisibility(0);
                }
                this.aL = true;
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.ArtistTracks) {
            this.aB = bcv.a(jSONObject);
            b(this.aB);
            am();
            return;
        }
        if (aVar == bdh.a.FavouriteAlbums) {
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArrayA2 = a(jSONObject.getJSONArray("items"));
                while (i < jSONArrayA2.length()) {
                    JSONObject jSONObject6 = jSONArrayA2.getJSONObject(i).getJSONObject("item");
                    bda bdaVar = new bda();
                    bdaVar.a = "" + jSONObject6.getInt("id");
                    bdaVar.e = jSONObject6.getString("cover");
                    bdaVar.b = jSONObject6.getString("title");
                    bdaVar.f = jSONObject6.getInt("numberOfTracks");
                    if (jSONObject6.has("artist")) {
                        JSONObject jSONObject7 = jSONObject6.getJSONObject("artist");
                        bdaVar.c = jSONObject7.getString("name");
                        bdaVar.d = "" + jSONObject7.getInt("id");
                    }
                    mm.b("ALBUM", "adding " + bdaVar.b);
                    arrayList2.add(bdaVar);
                    b(bdaVar);
                    i++;
                }
                this.aC.addAll(this.aC.size(), (ArrayList) arrayList2.clone());
                this.ay.b(arrayList2);
                mm.b("TIDAL", "Albums " + this.ay.getCount());
                this.ay.notifyDataSetChanged();
                this.at.setVisibility(4);
                if (this.ak.getVisibility() == 4) {
                    this.ak.setVisibility(0);
                }
                if (arrayList2.size() == 0) {
                    this.at.setVisibility(0);
                }
                this.aK = true;
            } catch (JSONException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.FavouriteArtists) {
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONArray jSONArrayA3 = a(jSONObject.getJSONArray("items"));
                while (i < jSONArrayA3.length()) {
                    JSONObject jSONObject8 = jSONArrayA3.getJSONObject(i).getJSONObject("item");
                    bdb bdbVar = new bdb();
                    bdbVar.a = "" + jSONObject8.getString("name");
                    bdbVar.b = "" + jSONObject8.getInt("id");
                    bdbVar.c = jSONObject8.getString("picture");
                    arrayList3.add(bdbVar);
                    b(bdbVar);
                    i++;
                }
                this.aE.addAll(this.aE.size(), (ArrayList) arrayList3.clone());
                this.aA.b(arrayList3);
                mm.b("TIDAL", "" + this.aA.getCount());
                this.aA.notifyDataSetChanged();
                this.as.setVisibility(4);
                if (this.aj.getVisibility() == 4) {
                    this.aj.setVisibility(0);
                }
                if (arrayList3.size() == 0) {
                    this.as.setVisibility(0);
                }
                this.aJ = true;
            } catch (JSONException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.FavouritePlaylists) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getJSONObject(i2).getJSONObject("item").getString("uuid");
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.aH.length()) {
                            z = false;
                            break;
                        } else {
                            if (string.equals(this.aH.getJSONObject(i3).getString("uuid"))) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                }
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    this.aH.put(jSONArray2.getJSONObject(i4));
                }
                ArrayList arrayList4 = new ArrayList();
                this.aH = a(this.aH);
                for (int i5 = 0; i5 < this.aH.length(); i5++) {
                    if (this.aH.getJSONObject(i5).optJSONObject("item") == null) {
                        jSONObject2 = this.aH.getJSONObject(i5);
                    } else {
                        jSONObject2 = this.aH.getJSONObject(i5).getJSONObject("item");
                    }
                    bdc bdcVar = new bdc();
                    bdcVar.c = jSONObject2.getString("description");
                    bdcVar.d = jSONObject2.getInt("duration");
                    bdcVar.a = jSONObject2.getString("title");
                    bdcVar.e = jSONObject2.getString("url");
                    bdcVar.b = jSONObject2.getString("uuid");
                    bdcVar.f = jSONObject2.getInt("numberOfTracks");
                    bdcVar.h = jSONObject2.getString("image");
                    if (jSONObject2.has("creator")) {
                        int i6 = jSONObject2.getJSONObject("creator").getInt("id");
                        if (i6 == 0) {
                            bdcVar.g = q().getString(R.string.SettingTidal_Str);
                        } else if (("" + i6).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar.g = q().getString(R.string.TidalMe);
                        } else {
                            bdcVar.g = "" + i6;
                        }
                    }
                    arrayList4.add(bdcVar);
                    b(bdcVar);
                }
                if (arrayList4.size() > 0) {
                    boolean z2 = false;
                    while (i < this.aD.size()) {
                        boolean z3 = this.aD.get(i).b.compareTo(((bdc) arrayList4.get(0)).b) == 0 ? true : z2;
                        i++;
                        z2 = z3;
                    }
                    if (!z2) {
                        mm.b("PLAYLISTS", "playlist does not contain " + ((bdc) arrayList4.get(0)).a + " but has size " + this.aD.size());
                        this.aD.addAll(this.aD.size(), (ArrayList) arrayList4.clone());
                        this.az.b(arrayList4);
                        mm.b("TIDAL", "" + this.az.getCount());
                        this.az.notifyDataSetChanged();
                    } else {
                        mm.b("PLAYLISTS", "playlist does contain " + ((bdc) arrayList4.get(0)).a + " but has size " + this.aD.size());
                    }
                }
                this.au.setVisibility(4);
                if (this.al.getVisibility() == 4) {
                    this.al.setVisibility(0);
                }
                if (this.aD.size() == 0) {
                    this.au.setVisibility(0);
                }
                this.aI = true;
            } catch (JSONException e7) {
                e7.printStackTrace();
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            am();
            return;
        }
        if (aVar == bdh.a.AlbumMetaData) {
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
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
            bdk bdkVar = new bdk();
            Bundle bundle = new Bundle();
            bundle.putSerializable("album", bdaVar2);
            bdkVar.g(bundle);
            if (ahn.a()) {
                this.ae.q().a(bdkVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdkVar, (arc) null);
            }
            am();
            return;
        }
        if (aVar == bdh.a.ArtistMetaData) {
            bdb bdbVar2 = new bdb();
            try {
                bdbVar2.a = "" + jSONObject.getString("name");
                bdbVar2.b = jSONObject.getString("id");
                bdbVar2.c = jSONObject.getString("picture");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            bdl bdlVar = new bdl();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("artist", bdbVar2);
            bdlVar.g(bundle2);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
            } else {
                this.ae.q().a(bdlVar, (arc) null);
            }
            am();
            return;
        }
        if (aVar == bdh.a.UserPlaylists) {
            this.aG = new ArrayList<>();
            try {
                this.aH = jSONObject.getJSONArray("items");
                this.aH = a(this.aH);
                while (i < this.aH.length()) {
                    JSONObject jSONObject10 = this.aH.getJSONObject(i);
                    bdc bdcVar2 = new bdc();
                    bdcVar2.c = jSONObject10.getString("description");
                    bdcVar2.d = jSONObject10.getInt("duration");
                    bdcVar2.a = jSONObject10.getString("title");
                    bdcVar2.e = jSONObject10.getString("url");
                    bdcVar2.b = jSONObject10.getString("uuid");
                    bdcVar2.f = jSONObject10.getInt("numberOfTracks");
                    bdcVar2.h = jSONObject10.getString("image");
                    if (jSONObject10.has("creator")) {
                        int i7 = jSONObject10.getJSONObject("creator").getInt("id");
                        if (i7 == 0) {
                            bdcVar2.g = q().getString(R.string.SettingTidal_Str);
                        } else if (("" + i7).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                            bdcVar2.g = q().getString(R.string.TidalMe);
                        } else {
                            bdcVar2.g = "" + i7;
                        }
                    } else {
                        bdcVar2.g = "";
                    }
                    this.aG.add(bdcVar2);
                    i++;
                }
                if (str.compareTo("") == 0) {
                    bdh.a().a(bdh.a.FavouritePlaylists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
                    return;
                } else {
                    bcw.a(this.ae, a(R.string.TidalPlaylists), this.aG, str, this);
                    am();
                    return;
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
                return;
            } catch (Exception e12) {
                e12.printStackTrace();
                return;
            }
        }
        if (aVar == bdh.a.Radio) {
            ArrayList arrayList5 = new ArrayList();
            try {
                JSONArray jSONArrayA4 = a(jSONObject.getJSONArray("items"));
                for (int i8 = 0; i8 < jSONArrayA4.length(); i8++) {
                    JSONObject jSONObject11 = jSONArrayA4.getJSONObject(i8);
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
                    arrayList5.add(bdgVar2);
                }
                new ArrayList();
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
                return;
            } catch (JSONException e13) {
                e13.printStackTrace();
                return;
            } catch (Exception e14) {
                e14.printStackTrace();
                return;
            }
        }
        if (aVar == bdh.a.AddFavouriteTrack) {
            this.aB.clear();
            try {
                this.ax.a(this.aB);
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            this.ax.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteTracks, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.RemoveFavouriteTrack) {
            this.ai.setVisibility(4);
            this.aB.clear();
            try {
                this.ax.a(this.aB);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.ax.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteTracks, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.AddFavouriteArtist) {
            this.aE.clear();
            try {
                this.aA.a(this.aE);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            this.aA.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteArtists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.RemoveFavouriteArtist) {
            this.aE.clear();
            try {
                this.aA.a(this.aE);
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            this.aA.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteArtists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.AddFavouriteAlbum) {
            this.aC.clear();
            try {
                this.ay.a(this.aC);
            } catch (Exception e19) {
                e19.printStackTrace();
            }
            this.ay.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteAlbums, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.RemoveFavouriteAlbum) {
            this.aC.clear();
            try {
                this.ay.a(this.aC);
            } catch (Exception e20) {
                e20.printStackTrace();
            }
            this.ay.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouriteAlbums, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.AddFavouritePlaylist) {
            this.aD.clear();
            try {
                this.az.a(this.aD);
            } catch (Exception e21) {
                e21.printStackTrace();
            }
            this.az.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouritePlaylists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.RemoveFavouritePlaylist) {
            this.aD.clear();
            try {
                this.az.a(this.aD);
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            this.az.notifyDataSetChanged();
            d();
            bdh.a().a(bdh.a.FavouritePlaylists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
            return;
        }
        if (aVar == bdh.a.AddTrack) {
            this.aD.clear();
            try {
                this.az.a(this.aD);
            } catch (Exception e23) {
                e23.printStackTrace();
            }
            this.az.notifyDataSetChanged();
            d();
            bdh.a().a(this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), "", 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        if (aVar == bdh.a.ShowProgress) {
            this.aD.clear();
            try {
                this.az.a(this.aD);
            } catch (Exception e24) {
                e24.printStackTrace();
            }
            this.az.notifyDataSetChanged();
            d();
            bdh.a().a(this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), "", 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        if (aVar == bdh.a.AlbumTracks) {
            ArrayList arrayList6 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                mm.b("TEST_DRAG_ALBUM, item size = %s", Integer.valueOf(jSONArray3.length()));
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject14 = jSONArray3.getJSONObject(i);
                    bdg bdgVar3 = new bdg();
                    bdgVar3.c = "" + jSONObject14.getInt("id");
                    bdgVar3.d = jSONObject14.getString("title");
                    bdgVar3.e = jSONObject14.getString("url");
                    bdgVar3.f = jSONObject14.getInt("duration");
                    bdgVar3.j = jSONObject14.getBoolean("allowStreaming");
                    bdgVar3.k = jSONObject14.getBoolean("streamReady");
                    bdgVar3.l = jSONObject14.getString("streamStartDate");
                    if (jSONObject14.has("artist")) {
                        JSONObject jSONObject15 = jSONObject14.getJSONObject("artist");
                        bdgVar3.a = jSONObject15.getString("name");
                        bdgVar3.b = "" + jSONObject15.getInt("id");
                    }
                    if (jSONObject14.has("album")) {
                        JSONObject jSONObject16 = jSONObject14.getJSONObject("album");
                        bdgVar3.h = jSONObject16.getString("title");
                        bdgVar3.g = "" + jSONObject16.getInt("id");
                        bdgVar3.i = jSONObject16.getString("cover");
                    }
                    arrayList6.add(bdgVar3);
                    mm.b("TEST_DRAG_ALBUM", "track_thing=" + bdgVar3.toString());
                    i++;
                }
                b((List<bdg>) arrayList6);
                am();
            } catch (JSONException e25) {
                e25.printStackTrace();
            }
        }
    }

    private JSONArray a(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, Collections.reverseOrder(new bct()));
            return new JSONArray((Collection) arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONArray;
        }
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        mm.b("ERROR", str);
        Toast.makeText(this.ae, R.string.TidalApiReturnError_Str, 1).show();
        am();
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(R.layout.tidal_my_music, (ViewGroup) null);
        this.aF = (TabPageIndicator) this.f.findViewById(R.id.indicator);
        this.aF.setTitles(new CharSequence[]{q().getString(R.string.TidalPlaylists), q().getString(R.string.TidalArtists), q().getString(R.string.TidalAlbums), q().getString(R.string.TidalTracks)});
        this.aF.setOnTabReselectedListener(this.e);
        this.g = (AnimationListView) this.f.findViewById(R.id.tracks_list_view);
        this.ai = this.f.findViewById(R.id.tracks_list_view_holder);
        this.g.setEmptyView(this.f.findViewById(R.id.tracks_list_view_empty));
        this.ar = this.f.findViewById(R.id.tracks_text_empty);
        this.h = (AnimationGridView) this.f.findViewById(R.id.artists_gridview);
        this.aj = this.f.findViewById(R.id.artists_gridview_holder);
        this.h.setEmptyView(this.f.findViewById(R.id.artists_gridview_empty));
        this.as = this.f.findViewById(R.id.artists_text_empty);
        this.i = (AnimationGridView) this.f.findViewById(R.id.albums_gridview);
        this.ak = this.f.findViewById(R.id.albums_gridview_holder);
        this.i.setEmptyView(this.f.findViewById(R.id.albums_gridview_empty));
        this.at = this.f.findViewById(R.id.albums_text_empty);
        this.ah = (AnimationListView) this.f.findViewById(R.id.playlist_view);
        this.al = this.f.findViewById(R.id.playlist_view_holder);
        this.ah.setEmptyView(this.f.findViewById(R.id.playlist_view_empty));
        this.au = this.f.findViewById(R.id.playlists_text_empty);
        this.ah.setDivider(new ColorDrawable(q().getColor(R.color.tidal_light_grey)));
        this.ax = new aic<>(this.ae, new d(), HttpStatus.SC_OK, R.layout.tidal_track_item, R.layout.harman_list_loading);
        this.ay = new aic<>(this.ae, new a(), HttpStatus.SC_OK, R.layout.tidal_album_gridview_item, R.layout.tidal_empty_gridview);
        this.aA = new aic<>(this.ae, new b(), HttpStatus.SC_OK, R.layout.tidal_artist_gridview_item, R.layout.tidal_empty_gridview);
        this.az = new aic<>(this.ae, new c(), HttpStatus.SC_OK, R.layout.tidal_playlist_item, R.layout.tidal_list_loading_invisible);
        try {
            this.ax.a(this.aB);
            this.ay.a(this.aC);
            this.aA.a(this.aE);
            this.az.a(this.aD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arp arpVar = new arp(this.h);
        arp arpVar2 = new arp(this.i);
        arp arpVar3 = new arp(this.ah);
        this.g.setAdapter((ListAdapter) this.ax);
        this.h.setAdapter((ListAdapter) this.aA);
        this.i.setAdapter((ListAdapter) this.ay);
        this.ah.setAdapter((ListAdapter) this.az);
        arpVar.a();
        arpVar2.a();
        arpVar3.a();
        b(q().getString(R.string.TidalMyMusic));
        return this.f;
    }

    @Override // defpackage.bdn, defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            try {
                if (!al()) {
                    c(l());
                }
            } catch (Exception e) {
                mm.b("ERROR", e.toString());
            }
        }
    }

    protected void d(int i) {
        this.aw = 1;
        this.d = i;
        this.aF.b(i);
        switch (i) {
            case 0:
                this.ai.setVisibility(8);
                this.aj.setVisibility(8);
                this.ak.setVisibility(8);
                if (al()) {
                    this.al.setVisibility(4);
                } else {
                    this.al.setVisibility(0);
                }
                break;
            case 1:
                this.ai.setVisibility(8);
                this.al.setVisibility(8);
                this.ak.setVisibility(8);
                if (al()) {
                    this.aj.setVisibility(4);
                    this.at.setVisibility(4);
                } else {
                    this.aj.setVisibility(0);
                    this.at.setVisibility(0);
                }
                break;
            case 2:
                this.ai.setVisibility(8);
                this.aj.setVisibility(8);
                this.al.setVisibility(8);
                if (al()) {
                    this.ak.setVisibility(4);
                } else {
                    this.ak.setVisibility(0);
                }
                break;
            case 3:
                this.aj.setVisibility(8);
                this.al.setVisibility(8);
                this.ak.setVisibility(8);
                if (al()) {
                    this.ai.setVisibility(4);
                } else {
                    this.ai.setVisibility(0);
                }
                break;
        }
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        this.aI = false;
        this.aJ = false;
        this.aK = false;
        this.aL = false;
        b(q().getString(R.string.TidalMyMusic));
        this.aB.clear();
        try {
            this.ax.a(this.aB);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.aC.clear();
        try {
            this.ay.a(this.aC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.aD.clear();
        try {
            this.az.a(this.aD);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.aE.clear();
        try {
            this.aA.a(this.aE);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (bundle != null && bundle.getInt("current_screen", -1) != -1) {
            this.d = bundle.getInt("current_screen");
            bundle.putInt("current_screen", -1);
            this.ao = (Bundle) bundle.clone();
        }
        this.aF.setCurrentItem(this.d);
        d(this.d);
        switch (this.d) {
            case 0:
                bdh.a().a(this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), "", 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
                break;
            case 1:
                bdh.a().a(bdh.a.FavouriteArtists, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                break;
            case 2:
                bdh.a().a(bdh.a.FavouriteAlbums, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                break;
            case 3:
                bdh.a().a(bdh.a.FavouriteTracks, this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), 0, HttpStatus.SC_OK);
                break;
            default:
                am();
                break;
        }
        this.g.setOnItemChosenListener(this.aP);
        this.g.setOnScrollListener(new bcz(this.ae));
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.g.setLeftMargin((int) dimension);
        }
        this.h.setOnItemChosenListener(this.aP);
        this.h.setOnItemClickListener(this.aO);
        this.h.setOnScrollListener(new bcz(this.ae));
        this.i.setOnItemChosenListener(this.aP);
        this.i.setOnItemClickListener(this.aM);
        this.i.setOnScrollListener(new bcz(this.ae));
        this.ah.setOnItemChosenListener(this.aP);
        this.ah.setOnItemClickListener(this.aN);
        this.ah.setOnScrollListener(new bcz(this.ae));
    }

    @Override // defpackage.bdn
    public void c() {
        this.g.setAdapter((ListAdapter) this.ax);
        this.h.setAdapter((ListAdapter) this.aA);
        this.i.setAdapter((ListAdapter) this.ay);
        this.ah.setAdapter((ListAdapter) this.az);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.an = new bdj(bdh.a.PlaylistTracks, this.aD.get(i).b);
        this.an.a(0, 100, this);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bdg bdgVar) {
        TidalMusicDataLocal tidalMusicDataLocalA = bdh.a(bdgVar);
        if (tidalMusicDataLocalA != null) {
            a(tidalMusicDataLocalA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bda bdaVar) {
        bdh.a().a(bdh.a.AlbumTracks, this, bdaVar.a, "", 0, HttpStatus.SC_OK);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bdb bdbVar) {
        bdh.a().a(bdh.a.ArtistTracks, this, bdbVar.b, "", 0, HttpStatus.SC_OK);
        d();
    }

    class d implements aic.a<bdg> {
        d() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.FavouriteTracks, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdv.this.aw * i2, HttpStatus.SC_OK);
            bdv.o(bdv.this);
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
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdgVar.d);
            aVar.b.setTypeface(bcw.a(bdv.this.ae));
            aVar.d.setText(bdgVar.a);
            aVar.d.setTypeface(bcw.b(bdv.this.ae));
            aVar.c.setText(bcw.a(bdgVar.f));
            aVar.c.setTypeface(bcw.b(bdv.this.ae));
            bif.a((Context) bdv.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&albumid=" + bdgVar.g).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            int color = bdv.this.q().getColor(R.color.white);
            if (!bdgVar.j || !bdgVar.k) {
                color = bdv.this.q().getColor(R.color.tidal_text_disabled);
            }
            aVar.b.setTextColor(color);
            aVar.d.setTextColor(color);
            aVar.c.setTextColor(color);
            aVar.e.setOnClickListener(new View.OnClickListener() { // from class: bdv.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    bdp bdpVar = new bdp(bdv.this.ae, bdgVar.d);
                    final ArrayList arrayList = new ArrayList();
                    if (bdgVar.j && bdgVar.k) {
                        arrayList.add(bdv.this.q().getString(R.string.PlayTip_PlayNow_Str));
                        arrayList.add(bdv.this.q().getString(R.string.TidalPlayNext));
                        arrayList.add(bdv.this.q().getString(R.string.TidalAddToQueue));
                        arrayList.add(bdv.this.q().getString(R.string.PlayTip_ClearAll_Str));
                    }
                    if (!bdv.this.a(bdgVar)) {
                        arrayList.add(bdv.this.q().getString(R.string.TidalFavourite));
                    } else {
                        arrayList.add(bdv.this.q().getString(R.string.TidalUnFavourite));
                    }
                    arrayList.add(bdv.this.q().getString(R.string.TidalAddToPlaylist));
                    arrayList.add(bdv.this.q().getString(R.string.TidalTrackRadio));
                    arrayList.add(bdv.this.q().getString(R.string.TidalGoToArtist));
                    arrayList.add(bdv.this.q().getString(R.string.TidalGoToAlbum));
                    bdpVar.a(arrayList);
                    bdpVar.a(bdgVar.d);
                    final TidalMusicDataLocal tidalMusicDataLocalA = bcw.a(bdgVar);
                    bdpVar.a(new asi() { // from class: bdv.d.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalFavourite))) {
                                bdh.a().c(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdv.this);
                                bdv.this.b(bdgVar);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalAddToPlaylist))) {
                                bdv.this.d();
                                bdh.a().a(bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, 0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalPlayNext))) {
                                bdv.this.b(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalAddToQueue))) {
                                bdv.this.c(tidalMusicDataLocalA);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalTrackRadio))) {
                                bdh.a().a(bdh.a.Radio, bdv.this, bdgVar.c, "", 0, bdh.a);
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalGoToArtist))) {
                                bdv.this.d();
                                bdh.a().a(bdh.a.ArtistMetaData, bdv.this, bdgVar.b, "");
                                return;
                            }
                            if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalGoToAlbum))) {
                                bdv.this.d();
                                bdh.a().a(bdh.a.AlbumMetaData, bdv.this, bdgVar.g, "");
                            } else if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.TidalUnFavourite))) {
                                bdh.a().b(bdv.this.ae, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdgVar.c, bdv.this);
                                bdv.this.c(bdgVar);
                            } else if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.PlayTip_PlayNow_Str))) {
                                bdv.this.a(tidalMusicDataLocalA);
                            } else if (((String) arrayList.get(i2)).equals(bdv.this.q().getString(R.string.PlayTip_ClearAll_Str))) {
                                bdv.this.d(tidalMusicDataLocalA);
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
            bdh.a().a(bdh.a.FavouriteAlbums, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdv.this.aw * i2, HttpStatus.SC_OK);
            bdv.o(bdv.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bda bdaVar) {
            C0117a c0117a = (C0117a) view.getTag();
            if (c0117a == null) {
                C0117a c0117a2 = new C0117a();
                c0117a2.a = (ImageView) view.findViewById(R.id.iv);
                c0117a2.b = (TextView) view.findViewById(R.id.tv);
                c0117a2.c = (TextView) view.findViewById(R.id.tv_alt);
                view.setTag(c0117a2);
                c0117a = c0117a2;
            }
            c0117a.b.setText(bdaVar.b);
            c0117a.b.setTypeface(bcw.a(bdv.this.ae));
            c0117a.c.setText(bdaVar.c);
            c0117a.c.setTypeface(bcw.b(bdv.this.ae));
            bif.a((Context) bdv.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=300&albumid=" + bdaVar.a).a(R.drawable.tidal_placeholder_300x300).a("tidal").a(c0117a.a);
            return view;
        }

        /* JADX INFO: renamed from: bdv$a$a, reason: collision with other inner class name */
        class C0117a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0117a() {
            }
        }
    }

    class b implements aic.a<bdb> {
        b() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            bdh.a().a(bdh.a.FavouriteArtists, bdv.this, aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), bdv.this.aw * i2, HttpStatus.SC_OK);
            bdv.o(bdv.this);
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
            aVar.b.setTypeface(bcw.a(bdv.this.ae));
            bif.a((Context) bdv.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=300&h=225&artistid=" + bdbVar.b).a(R.drawable.tidal_placeholder_300x225).a("tidal").a(aVar.a);
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
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdc bdcVar) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (ImageView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.text1);
                aVar2.c = (TextView) view.findViewById(R.id.text2);
                aVar2.d = (TextView) view.findViewById(R.id.text3);
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.b.setText(bdcVar.a);
            aVar.b.setTypeface(bcw.a(bdv.this.ae));
            aVar.c.setText(bdv.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(bdcVar.f)}));
            aVar.c.setTypeface(bcw.b(bdv.this.ae));
            aVar.d.setText(bdv.this.ae.getString(R.string.TidalCreateBy, new Object[]{" " + bdcVar.g}));
            aVar.d.setTypeface(bcw.b(bdv.this.ae));
            if (bdcVar.f == 0) {
                bif.a((Context) bdv.this.ae).a(R.drawable.tidal_placeholder_150x150).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            } else {
                bif.a((Context) bdv.this.ae).a("http://images.osl.wimpmusic.com/im/im?w=150&h=150&uuid=" + bdcVar.b).a(R.drawable.tidal_placeholder_150x150).a("tidal").a(aVar.a);
            }
            return view;
        }

        class a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;

            a() {
            }
        }
    }
}
