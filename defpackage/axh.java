package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axh extends axk implements axd.b {
    private ImageView aj;
    private ImageView ak;
    private View al;
    private aic<axb> am;
    private AnimationListView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private TextView as;
    private aww b;
    private final int a = 20;
    private ArrayList<axb> an = new ArrayList<>();

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 20, true);
        }
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        int i = 0;
        if (str.compareTo("catalog:album") == 0 || str.compareTo("self") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            try {
                jSONArray = jSONObject.getJSONArray("tracks");
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
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
                    mm.b("TRACKS", jSONObjectOptJSONObject.optJSONArray("links").toString());
                    jSONObjectOptJSONObject.optJSONArray("links");
                    axbVar.i = awp.a(jSONObjectOptJSONObject);
                    arrayList.add(axbVar);
                    i2 += axbVar.e;
                }
            }
            this.an.addAll(this.an.size(), (ArrayList) arrayList.clone());
            this.am.b(arrayList);
            this.am.notifyDataSetChanged();
            mm.b("Juke", "getcount=" + this.am.getCount());
            this.ar.setText("" + this.an.size() + " " + q().getString(R.string.JukeTracks) + " " + awp.a(i2));
            return;
        }
        if (str.compareTo("play:track") == 0) {
            axb axbVar2 = this.an.get(Integer.parseInt(str2));
            try {
                jSONArray2 = jSONObject.getJSONArray("httpOptions");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            while (i < jSONArray2.length()) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    axbVar2.i.putAll(awp.a(jSONObjectOptJSONObject2));
                }
                i++;
            }
            MusicPlaylistManager.a().b(awp.a(axbVar2));
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject3 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject3.optString("id");
                    awzVar.b = jSONObjectOptJSONObject3.optString("name");
                    awzVar.d = jSONObjectOptJSONObject3.optString("description");
                    awzVar.e = jSONObjectOptJSONObject3.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject3.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject3.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject3);
                    arrayList2.add(awzVar);
                }
                i++;
            }
            al();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("rel", "catalog:track");
                jSONObject2.put("href", str2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject2);
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList2, jSONArray3, this);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 20, true);
            return;
        }
        if (str.compareTo("catalog:artist") == 0 && jSONObject != null) {
            awx awxVar = new awx();
            awxVar.a = jSONObject.optString("id");
            awxVar.b = jSONObject.optString("name");
            awxVar.g = awp.a(jSONObject);
            axj axiVar = new axi();
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", awxVar);
            axiVar.g(bundle);
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
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.al = layoutInflater.inflate(R.layout.juke_album, viewGroup, false);
        this.ao = (AnimationListView) this.al.findViewById(R.id.tracks_list_view);
        View viewInflate = layoutInflater.inflate(R.layout.juke_discover_header, (ViewGroup) null);
        this.aj = (ImageView) viewInflate.findViewById(R.id.iv);
        this.ak = (ImageView) viewInflate.findViewById(R.id.album_background);
        this.ap = (TextView) viewInflate.findViewById(R.id.title);
        this.aq = (TextView) viewInflate.findViewById(R.id.subtitle);
        this.ar = (TextView) viewInflate.findViewById(R.id.details);
        this.as = (TextView) viewInflate.findViewById(R.id.record_label);
        this.ao.addHeaderView(viewInflate);
        this.am = new aic<>(this.ae, new a(), 20, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        try {
            this.am.a(this.an);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ao.setAdapter((ListAdapter) this.am);
        return this.al;
    }

    @Override // defpackage.axk
    void c() {
        this.ao.setAdapter((ListAdapter) this.am);
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.b = (aww) bundle.getSerializable("album");
        this.ap.setText(this.b.b);
        this.aq.setText(this.b.c);
        this.as.setText(this.b.h + " - " + this.b.g);
        this.ap.setVisibility(0);
        this.aq.setVisibility(0);
        this.ar.setVisibility(0);
        this.as.setVisibility(0);
        bif.a((Context) this.ae).a(this.b.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(this.aj);
        bif.a((Context) this.ae).a(this.b.i.get("catalog:image-256x256")).a((bir) new awn()).a(R.drawable.juke_placeholder_150x150).a(this.ak);
        String str = "self";
        if (!this.b.i.containsKey("self")) {
            str = "catalog:album";
        }
        axc.a().a(this.b.i, str, this, "", "", 0, 20);
        this.an.clear();
        try {
            this.am.a(this.an);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.am.notifyDataSetChanged();
        this.ao.setOnItemChosenListener(new ajn() { // from class: axh.1
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                axh.this.d(i);
            }
        });
        this.ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: axh.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                axh.this.d(i);
            }
        });
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.ao.setLeftMargin((int) dimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.an.size()) {
                break;
            }
            JukeMusicDataLocal jukeMusicDataLocalA = a(this.an.get(i3));
            if (jukeMusicDataLocalA != null) {
                arrayList.add(jukeMusicDataLocalA);
            }
            i2 = i3 + 1;
        }
        if (i == 0) {
            c(arrayList);
        } else {
            a(arrayList, i - 1);
        }
    }

    class a implements aic.a<axb>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, axb axbVar) {
            C0073a c0073a = (C0073a) view.getTag();
            if (c0073a == null) {
                C0073a c0073a2 = new C0073a();
                c0073a2.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                c0073a2.c = (TextView) view.findViewById(R.id.text1);
                c0073a2.d = (TextView) view.findViewById(R.id.text2);
                c0073a2.e = (TextView) view.findViewById(R.id.track_time);
                c0073a2.f = (LinearLayout) view.findViewById(R.id.more_holder);
                c0073a2.b = (TextView) view.findViewById(R.id.chart_position);
                view.setTag(c0073a2);
                c0073a = c0073a2;
            }
            c0073a.d.setVisibility(0);
            c0073a.f.setVisibility(0);
            c0073a.b.setVisibility(8);
            c0073a.c.setText(axbVar.b);
            c0073a.d.setText(axbVar.c);
            c0073a.e.setVisibility(0);
            c0073a.e.setText("" + awp.a(axbVar.e));
            c0073a.a.setVisibility(8);
            c0073a.a.setStoredViewForBitmap(axh.this.aj);
            c0073a.f.setTag(axbVar);
            c0073a.f.setOnClickListener(this);
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axh.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axh.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axh.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axh.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axh.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axh.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axh.this.b(axbVar)) {
                arrayList.add(axh.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axh.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axh.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(axh.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axh.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_PlayNext_Str)) && i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                                if (i != arrayList.indexOf(axh.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                    if (i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeAddMyMusic))) {
                                            if (i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeGoArtist))) {
                                                if (i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeGoAlbum))) {
                                                    if (i != arrayList.indexOf(axh.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                        if (i == arrayList.indexOf(axh.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                            axc.a().a(axbVar.i, "user:favorite-track", axh.this, "");
                                                            axh.this.d(axbVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    axh.this.d(awp.a(axbVar));
                                                    return;
                                                }
                                                axc.a().a(axbVar.i, "catalog:album", axh.this, "", "", -1, -1);
                                                return;
                                            }
                                            axc.a().a(axbVar.i, "catalog:artist", axh.this, "", "", -1, -1);
                                            return;
                                        }
                                        axc.a().a(axbVar.i, "user:favorite-track", axh.this);
                                        axh.this.c(axbVar);
                                        return;
                                    }
                                    axc.a().a(axc.a().e, "user:playlists", (axd.b) axh.this, axbVar.i.get("catalog:track"), "", -1, -1, true);
                                    axh.this.d();
                                    return;
                                }
                                axh.this.c(jukeMusicDataLocalA);
                                return;
                            }
                            axh.this.b(jukeMusicDataLocalA);
                            return;
                        }
                        axh.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    Toast.makeText(axh.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }

        /* JADX INFO: renamed from: axh$a$a, reason: collision with other inner class name */
        class C0073a {
            public StoredBitmapImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            C0073a() {
            }
        }
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).a(this.b.b).c();
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName() + "#" + System.identityHashCode(this);
    }
}
