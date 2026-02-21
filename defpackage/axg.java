package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axg extends axk implements axd.a, axd.b {
    private AnimationListView aj;
    private View ak;
    private aic<axb> al;
    private ArrayList<axb> am;
    private TextView an;
    private TextView ao;
    private ImageView ap;
    private final int a = 100;
    private int b = 0;
    private ajn aq = new ajn() { // from class: axg.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            JukeMusicDataLocal jukeMusicDataLocalA;
            if (obj != null && (jukeMusicDataLocalA = axg.this.a((axb) obj)) != null) {
                axg.this.a(jukeMusicDataLocalA);
            }
        }
    };

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeCharts).c();
    }

    @Override // defpackage.axk, defpackage.axj, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.am = new ArrayList<>();
        d();
        if (l() != null) {
            this.g = l().getBoolean("DISCOVER_PARENT", false);
        }
        return c(layoutInflater, viewGroup, bundle);
    }

    @Override // defpackage.axk
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.juke_genres_list_layout, (ViewGroup) null);
        View viewInflate = layoutInflater.inflate(R.layout.juke_info_header, (ViewGroup) null);
        this.an = (TextView) viewInflate.findViewById(R.id.textView1);
        this.ao = (TextView) viewInflate.findViewById(R.id.textView2);
        this.ap = (ImageView) viewInflate.findViewById(R.id.right_image);
        ((LinearLayout) viewInflate.findViewById(R.id.right_holder)).setOnClickListener(new ahl(this) { // from class: axg.2
            @Override // defpackage.ahl
            public void a(View view) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(axg.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                arz arzVar = new arz(axg.this.ae);
                final ArrayList arrayList = new ArrayList();
                arrayList.add(axg.this.ae.getString(R.string.JukeReplaceQueue));
                arrayList.add(axg.this.ae.getString(R.string.JukeAddAllToQueue));
                arzVar.a(arrayList);
                arzVar.a(axg.this.a(R.string.JukeCharts));
                arzVar.a(new asi() { // from class: axg.2.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= axg.this.am.size()) {
                                break;
                            }
                            arrayList2.add(awp.a((axb) axg.this.am.get(i3)));
                            i2 = i3 + 1;
                        }
                        Collections.shuffle(arrayList2);
                        if (i == arrayList.indexOf(axg.this.ae.getString(R.string.JukeReplaceQueue))) {
                            MusicPlaylistManager.a().g();
                            axg.this.c(arrayList2);
                        } else if (i == arrayList.indexOf(axg.this.ae.getString(R.string.JukeAddAllToQueue))) {
                            axg.this.d(arrayList2);
                        }
                    }
                });
                arzVar.show();
            }
        });
        this.aj = (AnimationListView) this.ak.findViewById(R.id.list_view);
        this.aj.addHeaderView(viewInflate);
        this.ak.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.am = new ArrayList<>();
        this.al = new aic<>(this.ae, new a(), 100, R.layout.juke_track_item, R.layout.harman_list_loading);
        try {
            this.al.a(this.am);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.aj.setAdapter((ListAdapter) this.al);
        this.aj.setOnScrollListener(new awv(this.ae));
        return this.ak;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        d();
        c(l());
    }

    @Override // defpackage.axk
    void c() {
        this.aj.setAdapter((ListAdapter) this.al);
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (this.aj != null && this.am.size() > 0) {
            this.aj.setSelection(0);
        }
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.ap.setVisibility(0);
        this.ao.setText(this.ae.getString(R.string.JukeShuffleAll));
        bif.a((Context) this.ae).a(R.drawable.juke_menu_shuffle).a(this.ap);
        this.aj.setOnItemChosenListener(this.aq);
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.aj.setLeftMargin((int) dimension);
        }
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        if (str.compareTo("catalog:track-charts") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray = null;
            try {
                jSONArray = jSONObject.getJSONArray("charts");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    axc.a().a(jSONObjectOptJSONObject.optJSONArray("links"));
                }
            }
            axc.a().a("catalog:track-chart", this, "", "", 0, 100);
            return;
        }
        if (str.compareTo("catalog:track-chart") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray2 = null;
            try {
                jSONArray2 = jSONObject.getJSONArray("tracks");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i3);
                if (jSONObjectOptJSONObject2 != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject2.optString("id");
                    axbVar.b = jSONObjectOptJSONObject2.optString("name");
                    axbVar.c = jSONObjectOptJSONObject2.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject2.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject2.optInt("lengthInSeconds");
                    axbVar.f = jSONObjectOptJSONObject2.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject2.optString("label");
                    axbVar.h = jSONObjectOptJSONObject2.optString("releaseYear");
                    jSONObjectOptJSONObject2.optJSONArray("links");
                    axbVar.i = awp.a(jSONObjectOptJSONObject2);
                    arrayList.add(axbVar);
                    i2 += axbVar.e;
                }
            }
            this.am.clear();
            if (this.al == null) {
                new axg();
            }
            try {
                this.al.a(arrayList);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.am.addAll(this.am.size(), arrayList);
            this.al.notifyDataSetChanged();
            al();
            this.an.setText("" + this.am.size() + " " + this.ae.getResources().getString(R.string.JukeTracks) + " - " + awp.a(i2));
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
                Bundle bundle = new Bundle();
                bundle.putSerializable("album", awwVar);
                axhVar.g(bundle);
                a(axhVar);
                return;
            }
            return;
        }
        if (str.compareTo("catalog:artist") == 0) {
            al();
            if (jSONObject != null) {
                awx awxVar = new awx();
                awxVar.a = jSONObject.optString("id");
                awxVar.b = jSONObject.optString("name");
                awxVar.g = awp.a(jSONObject);
                axj axiVar = new axi();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", awxVar);
                axiVar.g(bundle2);
                a(axiVar);
                return;
            }
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i4);
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
            }
            al();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("rel", "catalog:track");
                jSONObject2.put("href", str2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject2);
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList2, jSONArray3, this);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 100, true);
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
        mm.b("URLs", "" + z);
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 100, true);
            axc.a().a("catalog:track-charts", this, "", "", 0, 100);
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

    class a implements aic.a<axb>, View.OnClickListener {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            axg.this.b = i;
            int i3 = axg.this.b * i2;
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final axb axbVar) {
            C0072a c0072a = (C0072a) view.getTag();
            if (c0072a == null) {
                C0072a c0072a2 = new C0072a();
                c0072a2.a = (ImageView) view.findViewById(R.id.iv);
                c0072a2.c = (TextView) view.findViewById(R.id.text1);
                c0072a2.d = (TextView) view.findViewById(R.id.text2);
                c0072a2.e = (TextView) view.findViewById(R.id.track_time);
                c0072a2.f = (LinearLayout) view.findViewById(R.id.more_holder);
                c0072a2.b = (TextView) view.findViewById(R.id.chart_position);
                view.setTag(c0072a2);
                c0072a = c0072a2;
            }
            c0072a.d.setVisibility(0);
            c0072a.f.setVisibility(0);
            c0072a.b.setText("" + (i + 1));
            c0072a.c.setText(axbVar.b);
            c0072a.d.setText(axbVar.c);
            c0072a.e.setVisibility(0);
            c0072a.e.setText("" + awp.a(axbVar.e));
            new ahw().a(c0072a.a, new ahq() { // from class: axg.a.1
                @Override // defpackage.ahq
                public void a(View view2) {
                    bif.a((Context) axg.this.ae).a(axbVar.i.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                }
            });
            c0072a.f.setTag(axbVar);
            c0072a.f.setOnClickListener(this);
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axg.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            }
            final axb axbVar = (axb) view.getTag();
            final JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
            arz arzVar = new arz(axg.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(axg.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(axg.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(axg.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(axg.this.ae.getString(R.string.JukeReplaceQueue));
            arrayList.add(axg.this.ae.getString(R.string.JukeAddPlaylist));
            if (!axg.this.b(axbVar)) {
                arrayList.add(axg.this.ae.getString(R.string.JukeAddMyMusic));
            } else {
                arrayList.add(axg.this.ae.getString(R.string.JukeRemoveFromMyMusic));
            }
            arrayList.add(axg.this.ae.getString(R.string.JukeGoArtist));
            if (axbVar.i.containsKey("catalog:album") && axbVar.i.get("catalog:album") != null) {
                arrayList.add(axg.this.ae.getString(R.string.JukeGoAlbum));
            }
            arzVar.a(arrayList);
            arzVar.a(axg.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: axg.a.2
                @Override // defpackage.asi
                public void a(int i) {
                    if (i != arrayList.indexOf(axg.this.ae.getString(R.string.PlayTip_PlayNow_Str))) {
                        if (i != arrayList.indexOf(axg.this.ae.getString(R.string.PlayTip_PlayNext_Str))) {
                            if (i != arrayList.indexOf(axg.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                if (i != arrayList.indexOf(axg.this.ae.getString(R.string.JukeAddPlaylist))) {
                                    if (i != arrayList.indexOf(axg.this.ae.getString(R.string.JukeAddMyMusic))) {
                                        if (i != arrayList.indexOf(axg.this.ae.getString(R.string.JukeGoArtist))) {
                                            if (i != arrayList.indexOf(axg.this.ae.getString(R.string.JukeGoAlbum))) {
                                                if (i != arrayList.indexOf(axg.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                    if (i == arrayList.indexOf(axg.this.ae.getString(R.string.JukeRemoveFromMyMusic))) {
                                                        axc.a().a(axbVar.i, "user:favorite-track", axg.this, "");
                                                        axg.this.d(axbVar);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                axg.this.d(awp.a(axbVar));
                                                return;
                                            }
                                            axg.this.d();
                                            axc.a().a(axbVar.i, "catalog:album", axg.this, "", "", -1, -1);
                                            return;
                                        }
                                        axg.this.d();
                                        axc.a().a(axbVar.i, "catalog:artist", axg.this, "", "", -1, -1);
                                        return;
                                    }
                                    axc.a().a(axbVar.i, "user:favorite-track", axg.this);
                                    axg.this.c(axbVar);
                                    return;
                                }
                                axg.this.d();
                                axc.a().a(axc.a().e, "user:playlists", (axd.b) axg.this, axbVar.i.get("catalog:track"), "", -1, -1, true);
                                return;
                            }
                            a.this.c(jukeMusicDataLocalA);
                            return;
                        }
                        a.this.b(jukeMusicDataLocalA);
                        return;
                    }
                    a.this.a(jukeMusicDataLocalA);
                }
            });
            arzVar.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MusicData musicData) {
            axg.this.p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
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

        /* JADX INFO: renamed from: axg$a$a, reason: collision with other inner class name */
        class C0072a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;

            C0072a() {
            }
        }
    }
}
