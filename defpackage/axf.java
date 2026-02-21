package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axf extends axk implements ajn, axd.a, axd.b {
    private AnimationListView ak;
    private View al;
    private TextView am;
    private TextView an;
    private ImageView ao;
    private aic<aww> ap;
    private ArrayList<aww> aq;
    private final int b = 100;
    private int aj = 1;
    public boolean a = false;
    private AdapterView.OnItemClickListener ar = new AdapterView.OnItemClickListener() { // from class: axf.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != 0) {
                axh axhVar = new axh();
                Bundle bundle = new Bundle();
                bundle.putSerializable("album", (Serializable) axf.this.aq.get(i - 1));
                axhVar.g(bundle);
                axf.this.a((axj) axhVar);
            }
        }
    };
    private ajn as = new ajn() { // from class: axf.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axf.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                axc.a().a(((aww) obj).i, "catalog:album", axf.this, "play", "", 0, 100);
            }
        }
    };

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeCharts).c();
    }

    @Override // defpackage.axk, defpackage.axj, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(bundle);
        if (l() != null) {
            this.g = l().getBoolean("DISCOVER_PARENT", false);
        }
        this.aq = new ArrayList<>();
        d();
        return c(layoutInflater, viewGroup, bundle);
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (this.ak != null && this.aq.size() > 0) {
            this.ak.setSelection(0);
        }
    }

    @Override // defpackage.axk
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.al = layoutInflater.inflate(R.layout.juke_genres_list_layout, (ViewGroup) null);
        View viewInflate = layoutInflater.inflate(R.layout.juke_info_header, (ViewGroup) null);
        this.ak = (AnimationListView) this.al.findViewById(R.id.list_view);
        this.am = (TextView) viewInflate.findViewById(R.id.textView1);
        this.an = (TextView) viewInflate.findViewById(R.id.textView2);
        this.ao = (ImageView) viewInflate.findViewById(R.id.right_image);
        ((LinearLayout) viewInflate.findViewById(R.id.right_holder)).setOnClickListener(new AnonymousClass3(this));
        this.ak.addHeaderView(viewInflate);
        this.al.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aq = new ArrayList<>();
        d();
        this.ap = new aic<>(this.ae, new a(), 100, R.layout.juke_track_item, R.layout.juke_list_loading_invisible);
        try {
            this.ap.a(this.aq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ak.setAdapter((ListAdapter) this.ap);
        this.ak.setOnScrollListener(new awv(this.ae));
        return this.al;
    }

    /* JADX INFO: renamed from: axf$3, reason: invalid class name */
    class AnonymousClass3 extends ahl {
        AnonymousClass3(Fragment fragment) {
            super(fragment);
        }

        @Override // defpackage.ahl
        public void a(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axf.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            arz arzVar = new arz(axf.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axf.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axf.this.ae.getString(R.string.JukeAddAllToQueue));
            arzVar.a(arrayList);
            arzVar.a(axf.this.a(R.string.JukeCharts));
            arzVar.a(new asi() { // from class: axf.3.1
                @Override // defpackage.asi
                public void a(int i) {
                    if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeReplaceQueue))) {
                        if (i == arrayList.indexOf(axf.this.ae.getString(R.string.JukeAddAllToQueue))) {
                            ArrayList arrayList2 = (ArrayList) axf.this.aq.clone();
                            Collections.shuffle(arrayList2);
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                axc.a().a(((aww) arrayList2.get(i2)).i, "catalog:album", axf.this, "add", "", 0, 100);
                            }
                            return;
                        }
                        return;
                    }
                    MusicPlaylistManager.a().g();
                    axf.this.d();
                    ArrayList arrayList3 = (ArrayList) axf.this.aq.clone();
                    Collections.shuffle(arrayList3);
                    final ArrayList arrayList4 = new ArrayList();
                    for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                        arrayList4.add(false);
                    }
                    final ArrayList arrayList5 = new ArrayList();
                    for (final int i4 = 0; i4 < arrayList3.size(); i4++) {
                        axc.a().a(((aww) arrayList3.get(i4)).i, "catalog:album", new axd.b() { // from class: axf.3.1.1
                            @Override // axd.b
                            public void a(String str, JSONObject jSONObject, String str2) {
                                mm.b("CATALOG", jSONObject.toString());
                                JSONArray jSONArray = null;
                                try {
                                    jSONArray = jSONObject.getJSONArray("tracks");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                ArrayList arrayList6 = new ArrayList();
                                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i5);
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
                                        axbVar.i = awp.a(jSONObjectOptJSONObject);
                                        arrayList6.add(awp.a(axbVar));
                                        JSONObject jSONObject2 = new JSONObject();
                                        try {
                                            jSONObject2.put("rel", "catalog:track");
                                            jSONObject2.put("href", axbVar.i.get("catalog:track"));
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                        jSONArray2.put(jSONObject2);
                                    }
                                }
                                arrayList4.set(i4, true);
                                arrayList5.addAll(arrayList6);
                                if (!arrayList4.contains(false)) {
                                    axf.this.d(arrayList5);
                                    axf.this.al();
                                }
                            }

                            @Override // axd.b
                            public void a(String str, JSONArray jSONArray) {
                            }

                            @Override // axd.b
                            public void a(String str, String str2) {
                                arrayList4.set(i4, true);
                                if (!arrayList4.contains(false) && MusicPlaylistManager.a().w()) {
                                    axf.this.al();
                                    MusicPlaylistManager.a().e(0);
                                }
                            }
                        }, "shufflePlay", "", 0, 100);
                    }
                }
            });
            arzVar.show();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axk
    void c() {
        this.ak.setAdapter((ListAdapter) this.ap);
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.ao.setVisibility(0);
        this.an.setText(this.ae.getString(R.string.JukeShuffleAll));
        bif.a((Context) this.ae).a(R.drawable.juke_menu_shuffle).a(this.ao);
        this.ak.setOnItemClickListener(this.ar);
        this.ak.setOnItemChosenListener(this.as);
        ajo ajoVar = new ajo(this.ae, this.al);
        ajoVar.a(this);
        this.ak.setOnTouchListener(ajoVar);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        if (this.aq != null) {
            axc.a().a(this.aq.get(i > 0 ? i - 1 : 0).i, "catalog:album", this, "play", "", 0, 100);
        }
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        JSONArray jSONArray;
        if (str.compareTo("catalog:album-charts") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray2 = null;
            try {
                jSONArray2 = jSONObject.getJSONArray("charts");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    axc.a().a(jSONObjectOptJSONObject.optJSONArray("links"));
                }
            }
            axc.a().a("catalog:album-chart", this, "", "", 0, 100);
            return;
        }
        if (str.compareTo("catalog:album-chart") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray3 = null;
            try {
                jSONArray3 = jSONObject.getJSONArray("albums");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    aww awwVar = new aww();
                    awwVar.a = jSONObjectOptJSONObject2.optString("id");
                    awwVar.b = jSONObjectOptJSONObject2.optString("name");
                    awwVar.c = jSONObjectOptJSONObject2.optString("artistName");
                    awwVar.f = jSONObjectOptJSONObject2.optInt("trackCount");
                    awwVar.d = jSONObjectOptJSONObject2.optString("lengthInSeconds");
                    awwVar.e = jSONObjectOptJSONObject2.optString("genre");
                    awwVar.g = jSONObjectOptJSONObject2.optString("label");
                    awwVar.h = jSONObjectOptJSONObject2.optString("releaseYear");
                    jSONObjectOptJSONObject2.optJSONArray("links");
                    awwVar.i = awp.a(jSONObjectOptJSONObject2);
                    arrayList.add(awwVar);
                }
            }
            this.aq.clear();
            if (this.ap == null) {
                new axf();
            }
            try {
                this.ap.a(arrayList);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.aq.addAll(this.aq.size(), arrayList);
            this.ap.notifyDataSetChanged();
            al();
            this.a = true;
            this.am.setText("" + this.aq.size() + " " + this.ae.getString(R.string.JukeAlbums));
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 100, true);
            return;
        }
        if (str.compareTo("catalog:album") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray4 = null;
            try {
                jSONArray4 = jSONObject.getJSONArray("tracks");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            JSONArray jSONArray5 = new JSONArray();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray4.optJSONObject(i3);
                if (jSONObjectOptJSONObject3 != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject3.optString("id");
                    axbVar.b = jSONObjectOptJSONObject3.optString("name");
                    axbVar.c = jSONObjectOptJSONObject3.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject3.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject3.optInt("lengthInSeconds");
                    axbVar.f = jSONObjectOptJSONObject3.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject3.optString("label");
                    axbVar.h = jSONObjectOptJSONObject3.optString("releaseYear");
                    axbVar.i = awp.a(jSONObjectOptJSONObject3);
                    arrayList2.add(awp.a(axbVar));
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("rel", "catalog:track");
                        jSONObject2.put("href", axbVar.i.get("catalog:track"));
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    jSONArray5.put(jSONObject2);
                }
            }
            if (str2.compareTo("play") == 0) {
                a((List<MusicData>) arrayList2);
                return;
            }
            if (str2.compareTo("shufflePlay") == 0) {
                b((List<MusicData>) arrayList2);
                return;
            }
            if (str2.compareTo("playlist") == 0) {
                axc.a().a(axc.a().e, "user:playlists", (axd.b) this, jSONArray5.toString(), "", -1, -1, true);
                return;
            }
            if (str2.compareTo("add") == 0) {
                d(arrayList2);
                return;
            }
            if (str2.compareTo("playnext") == 0) {
                b((List<MusicData>) arrayList2);
                return;
            } else if (str2.compareTo("addqueue") == 0) {
                d(arrayList2);
                return;
            } else {
                if (str2.compareTo("replacequeue") == 0) {
                    e(arrayList2);
                    return;
                }
                return;
            }
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList3 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject4 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject4.optString("id");
                    awzVar.b = jSONObjectOptJSONObject4.optString("name");
                    awzVar.d = jSONObjectOptJSONObject4.optString("description");
                    awzVar.e = jSONObjectOptJSONObject4.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject4.optString("lastModified");
                    awzVar.g = jSONObjectOptJSONObject4.optString("visibility");
                    awzVar.c = awp.a(jSONObjectOptJSONObject4);
                    arrayList3.add(awzVar);
                }
            }
            al();
            try {
                jSONArray = new JSONArray(str2);
            } catch (JSONException e6) {
                e6.printStackTrace();
                jSONArray = null;
            }
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList3, jSONArray, this);
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

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        mm.b("connectionCompleted success=%b, statusCode=%d", Boolean.valueOf(z), Integer.valueOf(i));
        mm.c();
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 100, true);
            axc.a().a("catalog:album-charts", this, "", "", 0, 100);
        } else {
            al();
            Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        al();
    }

    class a implements aic.a<aww>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            axf.this.aj = i;
            int i3 = axf.this.aj * i2;
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final aww awwVar) {
            C0071a c0071a = (C0071a) view.getTag();
            if (c0071a == null) {
                C0071a c0071a2 = new C0071a();
                c0071a2.a = (ImageView) view.findViewById(R.id.iv);
                c0071a2.c = (TextView) view.findViewById(R.id.text1);
                c0071a2.d = (TextView) view.findViewById(R.id.text2);
                c0071a2.e = (TextView) view.findViewById(R.id.track_time);
                c0071a2.f = (LinearLayout) view.findViewById(R.id.more_holder);
                c0071a2.b = (TextView) view.findViewById(R.id.chart_position);
                c0071a2.d.setVisibility(0);
                c0071a2.f.setVisibility(0);
                c0071a2.e.setVisibility(4);
                view.setTag(c0071a2);
                c0071a = c0071a2;
            }
            c0071a.b.setText("" + (i + 1));
            c0071a.c.setText(awwVar.b);
            c0071a.d.setText(awwVar.c);
            new ahw().a(c0071a.a, new ahq() { // from class: axf.a.1
                @Override // defpackage.ahq
                public void a(View view2) {
                    bif.a((Context) axf.this.ae).a(awwVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                }
            });
            c0071a.f.setTag(awwVar);
            c0071a.f.setOnClickListener(this);
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final aww awwVar = (aww) view.getTag();
            arz arzVar = new arz(axf.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axf.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axf.this.ae.getString(R.string.JukePlayNext));
            arrayList.add(axf.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axf.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axf.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axf.this.a(awwVar)) {
                arrayList.add(axf.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axf.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axf.this.ae.getString(R.string.JukeGoArtist));
            arzVar.a(arrayList);
            arzVar.a(awwVar.b);
            arzVar.a(new asi() { // from class: axf.a.2
                @Override // defpackage.asi
                public void a(int i) {
                    if (!aof.a().l() || ain.j || (i != arrayList.indexOf(axf.this.ae.getString(R.string.PlayTip_PlayNow_Str)) && i != arrayList.indexOf(axf.this.ae.getString(R.string.JukePlayNext)) && i != arrayList.indexOf(axf.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str)) && i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeReplaceQueue)))) {
                        if (i != arrayList.indexOf(axf.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                            if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeAddPlaylist))) {
                                if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeAddMyMusic))) {
                                    if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeGoArtist))) {
                                        if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukePlayNext))) {
                                            if (i != arrayList.indexOf(axf.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                                if (i != arrayList.indexOf(axf.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                    if (i == arrayList.indexOf(axf.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                        axc.a().a(awwVar.i, "user:favorite-album", axf.this, "");
                                                        axf.this.c(awwVar);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                axc.a().a(awwVar.i, "catalog:album", axf.this, "replacequeue", "", 0, 100);
                                                return;
                                            }
                                            axc.a().a(awwVar.i, "catalog:album", axf.this, "addqueue", "", 0, 100);
                                            return;
                                        }
                                        axc.a().a(awwVar.i, "catalog:album", axf.this, "playnext", "", 0, 100);
                                        return;
                                    }
                                    axc.a().a(awwVar.i, "catalog:artist", axf.this, "", "", -1, -1);
                                    return;
                                }
                                axc.a().a(awwVar.i, "user:favorite-album", axf.this);
                                axf.this.b(awwVar);
                                return;
                            }
                            axf.this.d();
                            axc.a().a(awwVar.i, "catalog:album", axf.this, "playlist", "", 0, 100);
                            return;
                        }
                        axc.a().a(awwVar.i, "catalog:album", axf.this, "play", "", 0, 100);
                        return;
                    }
                    Toast.makeText(axf.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
            });
            arzVar.show();
        }

        /* JADX INFO: renamed from: axf$a$a, reason: collision with other inner class name */
        class C0071a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            C0071a() {
            }
        }
    }
}
