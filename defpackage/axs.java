package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.age;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axs extends axk implements age.a, axd.b {
    private HashMap<String, String> aA;
    private axe aB;
    private int aC;
    private int aD;
    awz al;
    ImageView am;
    ImageView an;
    TextView ao;
    TextView ap;
    TextView aq;
    private View ar;
    private aic<axb> as;
    private AnimationListView at;
    private View au;
    private View av;
    private ImageView az;
    private final int aw = 50;
    private int ax = 1;
    final int a = 0;
    final int b = 1;
    final int aj = 2;
    int ak = 0;
    private int ay = 0;
    private final int aE = 50;
    private ajn aF = new ajn() { // from class: axs.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            int i2 = 0;
            List<axb> listF = axs.this.aB.f();
            if (i != 0) {
                axs.this.a(listF, axs.this.aB, i - 1);
                return;
            }
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axs.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i3 = i2;
                if (i3 < listF.size()) {
                    JukeMusicDataLocal jukeMusicDataLocalA = axs.this.a(listF.get(i3));
                    if (jukeMusicDataLocalA != null) {
                        arrayList.add(jukeMusicDataLocalA);
                    }
                    i2 = i3 + 1;
                } else {
                    axs.this.c(arrayList);
                    return;
                }
            }
        }
    };

    static /* synthetic */ int f(axs axsVar) {
        int i = axsVar.ax;
        axsVar.ax = i + 1;
        return i;
    }

    @Override // age.a
    public void a(int i, List<MusicData> list, JSONObject jSONObject) {
        this.av.setVisibility(4);
        List<axb> listF = this.aB.f();
        this.as.b(listF.subList(i, listF.size()));
        this.as.notifyDataSetChanged();
        if (listF.size() == 0) {
            this.av.setVisibility(0);
        }
        this.au.setVisibility(0);
        if (this.ah == 5) {
            if (jSONObject != null) {
                try {
                    this.aC = jSONObject.getInt("collectionLength");
                    this.aD = this.aC % 50 > 0 ? (this.aC / 50) + 1 : this.aC / 50;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.ay = 0;
        }
        while (i < listF.size()) {
            this.ay = listF.get(i).e + this.ay;
            i++;
        }
        this.ap.setText("" + listF.size() + this.ae.getResources().getString(R.string.JukeTracks) + " - " + awp.a(this.ay));
        mm.b("Juke", "get count=" + this.as.getCount());
        al();
    }

    @Override // age.a
    public void a(ErrorInfo errorInfo) {
        this.ax--;
        mm.b("onFailure " + errorInfo, new Object[0]);
        Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 0).show();
        al();
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        if (str.compareTo("catalog:track") == 0) {
            int i = Integer.parseInt(str2);
            List<axb> listF = this.aB.f();
            if (jSONObject != null) {
                axb axbVar = new axb();
                axbVar.a = jSONObject.optString("id");
                axbVar.b = jSONObject.optString("name");
                axbVar.c = jSONObject.optString("artistName");
                axbVar.d = jSONObject.optString("albumName");
                axbVar.e = jSONObject.optInt("lengthInSeconds");
                axbVar.f = jSONObject.optString("genre");
                axbVar.g = jSONObject.optString("label");
                axbVar.h = jSONObject.optString("releaseYear");
                axbVar.i = awp.a(jSONObject);
                this.ay += axbVar.e;
                if (axbVar.b.compareTo(listF.get(i).b) == 0) {
                    axbVar.i.putAll(listF.get(i).i);
                    listF.set(i, axbVar);
                }
            }
            try {
                this.as.a(listF);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject.optString("id");
                    awzVar.b = jSONObjectOptJSONObject.optString("name");
                    awzVar.d = jSONObjectOptJSONObject.optString("description");
                    awzVar.e = jSONObjectOptJSONObject.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject);
                    arrayList.add(awzVar);
                }
            }
            al();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("rel", "catalog:track");
                jSONObject2.put("href", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList, jSONArray, this);
            return;
        }
        if (str.compareTo("user:playlist-entry") == 0) {
            this.aB.b();
            try {
                this.as.a(this.aB.f());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.as.notifyDataSetChanged();
            this.aB.e();
            this.aB.a(0, 50, this);
            return;
        }
        if (str.compareTo("catalog:artist") == 0) {
            if (jSONObject != null) {
                awx awxVar = new awx();
                awxVar.a = jSONObject.optString("id");
                awxVar.b = jSONObject.optString("name");
                awxVar.g = awp.a(jSONObject);
                axj axiVar = new axi();
                Bundle bundle = new Bundle();
                bundle.putSerializable("artist", awxVar);
                axiVar.g(bundle);
                a(axiVar);
                return;
            }
            return;
        }
        if (str.compareTo("delete:playlist") == 0) {
            this.ae.getFragmentManager().popBackStackImmediate();
            return;
        }
        if (str.compareTo("edit:playlist") == 0) {
            this.ao.setText(str2);
            return;
        }
        if (str.compareTo("catalog:album") == 0) {
            al();
            if (jSONObject != null) {
                aww awwVar = new aww();
                awwVar.a = jSONObject.optString("id");
                awwVar.b = jSONObject.optString("name");
                awwVar.c = jSONObject.optString("artistName");
                awwVar.f = jSONObject.optInt("trackCount");
                awwVar.d = jSONObject.optString("lengthInSeconds");
                awwVar.e = jSONObject.optString("genre");
                awwVar.g = jSONObject.optString("label");
                awwVar.h = jSONObject.optString("releaseYear");
                jSONObject.optJSONArray("links");
                awwVar.i = awp.a(jSONObject);
                axj axhVar = new axh();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("album", awwVar);
                axhVar.g(bundle2);
                a(axhVar);
            }
        }
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
        if (str2.compareTo("no value") != 0) {
            al();
            Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
            mm.b("ERROR", "" + str + " " + str2);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ar = layoutInflater.inflate(R.layout.juke_playlist, (ViewGroup) null);
        this.at = (AnimationListView) this.ar.findViewById(R.id.tracks_list_view);
        this.au = this.ar.findViewById(R.id.tracks_list_view_holder);
        this.at.setEmptyView(this.ar.findViewById(R.id.tracks_list_view_empty));
        this.av = this.ar.findViewById(R.id.tracks_list_view_empty_text);
        View viewInflate = layoutInflater.inflate(R.layout.juke_discover_header, (ViewGroup) null);
        this.am = (ImageView) viewInflate.findViewById(R.id.iv);
        this.an = (ImageView) viewInflate.findViewById(R.id.album_background);
        this.ao = (TextView) viewInflate.findViewById(R.id.title);
        this.ap = (TextView) viewInflate.findViewById(R.id.subtitle);
        this.aq = (TextView) viewInflate.findViewById(R.id.details);
        this.az = (ImageView) viewInflate.findViewById(R.id.playlist_edit);
        this.at.addHeaderView(viewInflate);
        this.as = new aic<>(this.ae, new a(), 50, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        this.at.setAdapter((ListAdapter) this.as);
        this.aA = new HashMap<>();
        return this.ar;
    }

    @Override // defpackage.axk
    void c() {
        this.at.setAdapter((ListAdapter) this.as);
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        String strA = "";
        if (this.al != null) {
            if (!TextUtils.isEmpty(this.al.b)) {
                strA = this.al.b;
            } else if (this.al.c.containsKey("user:playlist")) {
                strA = a(R.string.JukeMyPlaylists);
            } else {
                strA = a(R.string.JukePublicPlaylists);
            }
        }
        return new ajv.a(super.b()).h(0).a(strA).c();
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
        this.al = (awz) bundle.getSerializable("playlist");
        if (this.al == null) {
            mm.b("Juke", "Playlist detail is null, make sure playlist instance is not null");
            return;
        }
        this.aB = new axe(this.al);
        bif.a((Context) this.ae).a(this.al.c.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(this.am);
        bif.a((Context) this.ae).a(this.al.c.get("catalog:image-256x256")).a((bir) new awn()).a(R.drawable.juke_placeholder_150x150).a(this.an);
        this.ao.setText(this.al.b);
        this.aq.setText(this.ae.getString(R.string.JukeCreated) + ": " + awp.a(this.al.e));
        this.aB.b();
        this.au.setVisibility(4);
        try {
            this.as.a(this.aB.f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.as.notifyDataSetChanged();
        this.aB.a(0, 50, this);
        this.at.setOnItemChosenListener(this.aF);
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.at.setLeftMargin((int) dimension);
        }
        this.az.setVisibility(8);
        if (this.al.c.containsKey("user:playlist")) {
            this.az.setVisibility(0);
            this.az.setOnClickListener(new View.OnClickListener() { // from class: axs.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    awp.a((Context) axs.this.ae, axs.this.al.c, axs.this.al, (axd.b) axs.this, true);
                }
            });
        }
    }

    class a implements aic.a<axb>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            if (axs.this.ah == 5 && i != axs.this.ax) {
                if (i - 1 >= axs.this.aD) {
                    axs.this.as.a();
                    return;
                }
                axs.this.d();
                axs.f(axs.this);
                axs.this.aB.a((i - 1) * i2, i2, axs.this);
            }
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, axb axbVar) {
            C0082a c0082a;
            C0082a c0082a2 = (C0082a) view.getTag();
            if (c0082a2 == null) {
                c0082a = new C0082a();
                c0082a.a = (ImageView) view.findViewById(R.id.iv);
                c0082a.c = (TextView) view.findViewById(R.id.text1);
                c0082a.d = (TextView) view.findViewById(R.id.text2);
                c0082a.e = (TextView) view.findViewById(R.id.track_time);
                c0082a.f = (LinearLayout) view.findViewById(R.id.more_holder);
                c0082a.b = (TextView) view.findViewById(R.id.chart_position);
                view.setTag(c0082a);
            } else {
                c0082a = c0082a2;
            }
            c0082a.d.setVisibility(0);
            c0082a.f.setVisibility(0);
            c0082a.b.setVisibility(8);
            c0082a.c.setText(axbVar.b);
            c0082a.d.setText(axbVar.c);
            c0082a.e.setVisibility(0);
            c0082a.e.setText("" + awp.a(axbVar.e));
            c0082a.a.setVisibility(0);
            bif.a((Context) axs.this.ae).a(axbVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0082a.a);
            c0082a.f.findViewById(R.id.more_icon).setTag(axbVar);
            c0082a.f.findViewById(R.id.more_icon).setOnClickListener(this);
            return view;
        }

        /* JADX INFO: renamed from: axs$a$a, reason: collision with other inner class name */
        class C0082a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            C0082a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axs.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axs.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axs.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axs.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axs.this.ae.getString(R.string.JukeReplaceQueue));
            if (axs.this.al.c.containsKey("user:playlist")) {
                arrayList.add(axs.this.ae.getString(R.string.JukeRemoveFromMyPlaylist));
            } else {
                arrayList.add(axs.this.ae.getString(R.string.JukeAddPlaylist));
            }
            if (!axs.this.b(axbVar)) {
                arrayList.add(axs.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axs.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axs.this.ae.getString(R.string.JukeGoArtist));
            arrayList.add(axs.this.ae.getString(R.string.JukeGoAlbum));
            arzVar.a(arrayList);
            arzVar.a(axs.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axs.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axs.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeRemoveFromMyPlaylist))) {
                                            if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeAddMyMusic))) {
                                                if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeGoArtist))) {
                                                    if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeGoAlbum))) {
                                                        if (i != arrayList.indexOf(axs.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                            if (i == arrayList.indexOf(axs.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                                axc.a().a(axbVar.i, "user:favorite-track", axs.this, "");
                                                                axs.this.d(axbVar);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        axs.this.d(awp.a(axbVar));
                                                        return;
                                                    }
                                                    axc.a().a(axbVar.i, "catalog:album", axs.this, "", "", -1, -1);
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:artist", axs.this, "", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "user:favorite-track", axs.this);
                                            axs.this.c(axbVar);
                                            return;
                                        }
                                        axs.this.d();
                                        axs.this.au.setVisibility(4);
                                        axc.a().c(axbVar.i, "user:playlist-entry", axs.this);
                                        return;
                                    }
                                    axs.this.d();
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axs.this, axbVar.i.get("catalog:track"), "", -1, -1, true);
                                    return;
                                }
                                a.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            a.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        a.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axs.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MusicData musicData) {
            axs.this.p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().b(musicData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(MusicData musicData) {
            MusicPlaylistManager.a().c(musicData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(MusicData musicData) {
            MusicPlaylistManager.a().d(musicData);
        }
    }
}
