package defpackage;

import android.content.Context;
import android.content.res.Configuration;
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
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.age;
import defpackage.aih;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axt extends axk implements axd.a, axd.b {
    private View a;
    private AnimationGridView ak;
    private HashMap<String, String> an;
    private axe ao;
    private aih<awz> b;
    private ArrayList<awz> aj = new ArrayList<>();
    private final int al = 100;
    private int am = 1;
    private AdapterView.OnItemClickListener ap = new AdapterView.OnItemClickListener() { // from class: axt.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axs axsVar = new axs();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) axt.this.aj.get(i));
            axsVar.g(bundle);
            axt.this.a((axj) axsVar);
        }
    };
    private ajn aq = new ajn() { // from class: axt.6
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axt.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            axt.this.ao = new axe((awz) obj);
            axt.this.ao.a(0, 100, axt.this.ar);
        }
    };
    private age.a ar = new age.a() { // from class: axt.7
        @Override // age.a
        public void a(int i, List<MusicData> list, JSONObject jSONObject) {
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(list, axt.this.ao);
        }

        @Override // age.a
        public void a(ErrorInfo errorInfo) {
        }
    };

    static /* synthetic */ int g(axt axtVar) {
        int i = axtVar.am;
        axtVar.am = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, final String str2) {
        JSONArray jSONArray;
        if (str.compareTo("user:popular-public-playlists") == 0) {
            this.an = awp.a(jSONObject);
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("playlists");
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    awz awzVar = new awz();
                    awzVar.a = jSONObject2.optString("id");
                    awzVar.b = jSONObject2.optString("name");
                    awzVar.d = jSONObject2.optString("description");
                    awzVar.e = jSONObject2.optString("createdAt");
                    awzVar.f = jSONObject2.optString("lastModified");
                    awzVar.g = jSONObject2.optString("visibility");
                    awzVar.h = 0;
                    awzVar.c = awp.a(jSONObject2);
                    arrayList.add(awzVar);
                    axc.a().a(awzVar.c, "user:public-playlist", (axd.b) this, new abw().a(awzVar), "", 0, 100, false);
                }
                this.aj.clear();
                this.aj.addAll(this.aj.size(), (ArrayList) arrayList.clone());
                this.b.a(arrayList);
                mm.b("TIDAL", "" + this.b.getCount());
                this.b.notifyDataSetChanged();
                al();
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (str.compareTo("user:portal") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            axc.a().a(axc.a().e, "user:popular-public-playlists", (axd.b) this, "", "", -1, -1, false);
            return;
        }
        if (str.compareTo("user:public-playlist") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray3 = null;
            try {
                jSONArray3 = jSONObject.getJSONArray("entries");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONArray jSONArray4 = new JSONArray();
            final ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray3.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject.optString("id", "0");
                    axbVar.b = jSONObjectOptJSONObject.optString("name");
                    axbVar.c = jSONObjectOptJSONObject.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject.optInt("lengthInSeconds", 0);
                    axbVar.f = jSONObjectOptJSONObject.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject.optString("label");
                    axbVar.h = jSONObjectOptJSONObject.optString("releaseYear");
                    axbVar.i = awp.a(jSONObjectOptJSONObject);
                    arrayList2.add(axbVar);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("rel", "catalog:track");
                        jSONObject3.put("href", axbVar.i.get("catalog:track"));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    jSONArray4.put(jSONObject3);
                }
            }
            if (str2.compareTo("playlist") == 0) {
                axc.a().a(axc.a().e, "user:playlists", (axd.b) this, jSONArray4.toString(), "", -1, -1, true);
                return;
            }
            if (str2.compareTo("playnext") == 0 || str2.compareTo("play") == 0) {
                final ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    arrayList3.add(false);
                }
                for (final int i4 = 0; i4 < arrayList2.size(); i4++) {
                    final axb axbVar2 = (axb) arrayList2.get(i4);
                    axc.a().a(axbVar2.i, "catalog:track", new axd.b() { // from class: axt.1
                        @Override // axd.b
                        public void a(String str3, JSONObject jSONObject4, String str4) {
                            int i5 = 0;
                            axbVar2.a = jSONObject4.optString("id");
                            axbVar2.b = jSONObject4.optString("name");
                            axbVar2.c = jSONObject4.optString("artistName");
                            axbVar2.d = jSONObject4.optString("albumName");
                            axbVar2.e = jSONObject4.optInt("lengthInSeconds");
                            axbVar2.f = jSONObject4.optString("genre");
                            axbVar2.g = jSONObject4.optString("label");
                            axbVar2.h = jSONObject4.optString("releaseYear");
                            axbVar2.i = awp.a(jSONObject4);
                            arrayList2.set(i4, axbVar2);
                            arrayList3.set(i4, true);
                            mm.b("UPDATING TRACK", "" + i4 + " size=" + arrayList2.size());
                            if (!arrayList3.contains(false)) {
                                ArrayList arrayList4 = new ArrayList();
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= arrayList2.size()) {
                                        break;
                                    }
                                    arrayList4.add(awp.a((axb) arrayList2.get(i6)));
                                    i5 = i6 + 1;
                                }
                                if (str2.compareTo("play") == 0) {
                                    axt.this.a((List<MusicData>) arrayList4);
                                } else {
                                    axt.this.b((List<MusicData>) arrayList4);
                                }
                            }
                        }

                        @Override // axd.b
                        public void a(String str3, JSONArray jSONArray5) {
                        }

                        @Override // axd.b
                        public void a(String str3, String str4) {
                            int i5 = 0;
                            arrayList3.set(i4, true);
                            if (!arrayList3.contains(false)) {
                                ArrayList arrayList4 = new ArrayList();
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < arrayList2.size()) {
                                        arrayList4.add(awp.a((axb) arrayList2.get(i6)));
                                        i5 = i6 + 1;
                                    } else {
                                        axt.this.b((List<MusicData>) arrayList4);
                                        return;
                                    }
                                }
                            }
                        }
                    }, "", "", 0, 100);
                }
                return;
            }
            if (str2.compareTo("addqueue") == 0) {
                final ArrayList arrayList4 = new ArrayList();
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    arrayList4.add(false);
                }
                for (final int i6 = 0; i6 < arrayList2.size(); i6++) {
                    final axb axbVar3 = (axb) arrayList2.get(i6);
                    axc.a().a(axbVar3.i, "catalog:track", new axd.b() { // from class: axt.2
                        @Override // axd.b
                        public void a(String str3, JSONObject jSONObject4, String str4) {
                            int i7 = 0;
                            axbVar3.a = jSONObject4.optString("id");
                            axbVar3.b = jSONObject4.optString("name");
                            axbVar3.c = jSONObject4.optString("artistName");
                            axbVar3.d = jSONObject4.optString("albumName");
                            axbVar3.e = jSONObject4.optInt("lengthInSeconds");
                            axbVar3.f = jSONObject4.optString("genre");
                            axbVar3.g = jSONObject4.optString("label");
                            axbVar3.h = jSONObject4.optString("releaseYear");
                            arrayList2.set(i6, axbVar3);
                            arrayList4.set(i6, true);
                            mm.b("UPDATING TRACK", "" + i6 + " size=" + arrayList2.size());
                            if (!arrayList4.contains(false)) {
                                ArrayList arrayList5 = new ArrayList();
                                while (true) {
                                    int i8 = i7;
                                    if (i8 < arrayList2.size()) {
                                        arrayList5.add(awp.a((axb) arrayList2.get(i8)));
                                        i7 = i8 + 1;
                                    } else {
                                        axt.this.d(arrayList5);
                                        return;
                                    }
                                }
                            }
                        }

                        @Override // axd.b
                        public void a(String str3, JSONArray jSONArray5) {
                        }

                        @Override // axd.b
                        public void a(String str3, String str4) {
                            int i7 = 0;
                            arrayList4.set(i6, true);
                            if (!arrayList4.contains(false)) {
                                ArrayList arrayList5 = new ArrayList();
                                while (true) {
                                    int i8 = i7;
                                    if (i8 < arrayList2.size()) {
                                        arrayList5.add(awp.a((axb) arrayList2.get(i8)));
                                        i7 = i8 + 1;
                                    } else {
                                        axt.this.d(arrayList5);
                                        return;
                                    }
                                }
                            }
                        }
                    }, "", "", 0, 100);
                }
                return;
            }
            if (str2.compareTo("replacequeue") == 0) {
                final ArrayList arrayList5 = new ArrayList();
                for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                    arrayList5.add(false);
                }
                for (final int i8 = 0; i8 < arrayList2.size(); i8++) {
                    final axb axbVar4 = (axb) arrayList2.get(i8);
                    axc.a().a(axbVar4.i, "catalog:track", new axd.b() { // from class: axt.3
                        @Override // axd.b
                        public void a(String str3, JSONObject jSONObject4, String str4) {
                            int i9 = 0;
                            axbVar4.a = jSONObject4.optString("id");
                            axbVar4.b = jSONObject4.optString("name");
                            axbVar4.c = jSONObject4.optString("artistName");
                            axbVar4.d = jSONObject4.optString("albumName");
                            axbVar4.e = jSONObject4.optInt("lengthInSeconds");
                            axbVar4.f = jSONObject4.optString("genre");
                            axbVar4.g = jSONObject4.optString("label");
                            axbVar4.h = jSONObject4.optString("releaseYear");
                            arrayList2.set(i8, axbVar4);
                            arrayList5.set(i8, true);
                            mm.b("UPDATING TRACK", "" + i8 + " size=" + arrayList2.size());
                            if (!arrayList5.contains(false)) {
                                ArrayList arrayList6 = new ArrayList();
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < arrayList2.size()) {
                                        arrayList6.add(awp.a((axb) arrayList2.get(i10)));
                                        i9 = i10 + 1;
                                    } else {
                                        axt.this.e(arrayList6);
                                        return;
                                    }
                                }
                            }
                        }

                        @Override // axd.b
                        public void a(String str3, JSONArray jSONArray5) {
                        }

                        @Override // axd.b
                        public void a(String str3, String str4) {
                            int i9 = 0;
                            arrayList5.set(i8, true);
                            if (!arrayList5.contains(false)) {
                                ArrayList arrayList6 = new ArrayList();
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < arrayList2.size()) {
                                        arrayList6.add(awp.a((axb) arrayList2.get(i10)));
                                        i9 = i10 + 1;
                                    } else {
                                        axt.this.e(arrayList6);
                                        return;
                                    }
                                }
                            }
                        }
                    }, "", "", 0, 100);
                }
                return;
            }
            awz awzVar2 = (awz) new abw().a(str2, new adp<awz>() { // from class: axt.4
            }.b());
            awzVar2.h = arrayList2.size();
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < this.aj.size()) {
                    awz awzVar3 = this.aj.get(i10);
                    if (awzVar3.b.compareTo(awzVar2.b) == 0) {
                        awzVar3.h = awzVar2.h;
                    }
                    i9 = i10 + 1;
                } else {
                    try {
                        break;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            this.b.a(this.aj);
            this.b.notifyDataSetChanged();
            return;
        }
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList6 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject2 != null) {
                    awz awzVar4 = new awz();
                    awzVar4.a = jSONObjectOptJSONObject2.optString("id");
                    awzVar4.b = jSONObjectOptJSONObject2.optString("name");
                    awzVar4.d = jSONObjectOptJSONObject2.optString("description");
                    awzVar4.e = jSONObjectOptJSONObject2.optString("createdAt");
                    awzVar4.f = jSONObjectOptJSONObject2.optString("lastModified");
                    awzVar4.g = jSONObjectOptJSONObject2.optString("visibility");
                    awzVar4.c = awp.a(jSONObjectOptJSONObject2);
                    arrayList6.add(awzVar4);
                }
            }
            al();
            try {
                jSONArray = new JSONArray(str2);
            } catch (JSONException e5) {
                e5.printStackTrace();
                jSONArray = null;
            }
            awp.a(this.ae, this.ae.getString(R.string.JukePlaylists), (ArrayList<awz>) arrayList6, jSONArray, this);
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
            axc.a().a("user:portal", this, "", "", 0, 100);
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 100, true);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.juke_grid_animation, (ViewGroup) null);
        this.ak = (AnimationGridView) this.a.findViewById(R.id.group_gridview);
        this.b = new aih<>(this.ae, new a(), 100, R.layout.juke_gridview_item, R.layout.juke_list_loading_invisible);
        this.b.a(this.aj);
        this.ak.setNeedAddFooter(false);
        this.ak.setAdapter((ListAdapter) this.b);
        this.ak.setOnScrollListener(new awv(this.ae));
        return this.a;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.an = new HashMap<>();
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.ak.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.ak.setAdapter((ListAdapter) this.b);
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukePublicPlaylists).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        if (z()) {
            awp.a = 2;
        }
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        d();
        this.aj.clear();
        this.b.a(this.aj);
        this.b.notifyDataSetChanged();
        this.ak.setOnItemClickListener(this.ap);
        this.ak.setOnItemChosenListener(this.aq);
    }

    class a implements aih.a<awz> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (axt.this.an.containsKey("next")) {
                axc.a().a(axt.this.an, "next", axt.this, "", "", axt.this.am * i2, i2);
                axt.g(axt.this);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, final awz awzVar) {
            C0084a c0084a;
            C0084a c0084a2 = (C0084a) view.getTag();
            if (c0084a2 == null) {
                c0084a = new C0084a();
                c0084a.a = (ImageView) view.findViewById(R.id.iv);
                c0084a.b = (TextView) view.findViewById(R.id.tv);
                c0084a.c = (TextView) view.findViewById(R.id.tv_alt);
                c0084a.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                c0084a.e = (ImageView) view.findViewById(R.id.more_holder);
                c0084a.a.setVisibility(0);
                c0084a.d.setVisibility(0);
                view.setTag(c0084a);
            } else {
                c0084a = c0084a2;
            }
            c0084a.b.setText(awzVar.b);
            c0084a.c.setText("(" + awp.a(awzVar.e) + " - " + awzVar.h + " " + axt.this.ae.getString(R.string.JukeTracks) + ")");
            bif.a((Context) axt.this.ae).a(awzVar.c.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0084a.a);
            c0084a.e.setOnClickListener(new View.OnClickListener() { // from class: axt.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final awz awzVar2 = awzVar;
                    arz arzVar = new arz(axt.this.ae);
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(axt.this.ae.getString(R.string.JukePlayNow));
                    arrayList.add(axt.this.ae.getString(R.string.JukePlayNext));
                    arrayList.add(axt.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(axt.this.ae.getString(R.string.JukeReplaceQueue));
                    arrayList.add(axt.this.ae.getString(R.string.JukeAddPlaylist));
                    arzVar.a(arrayList);
                    arzVar.a(awzVar.b);
                    arzVar.a(new asi() { // from class: axt.a.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (!aof.a().l() || ain.j || i2 == arrayList.indexOf(axt.this.ae.getString(R.string.JukeAddPlaylist))) {
                                if (i2 != arrayList.indexOf(axt.this.ae.getString(R.string.JukePlayNow))) {
                                    if (i2 != arrayList.indexOf(axt.this.ae.getString(R.string.JukeAddPlaylist))) {
                                        if (i2 != arrayList.indexOf(axt.this.ae.getString(R.string.JukePlayNext))) {
                                            if (i2 != arrayList.indexOf(axt.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str))) {
                                                if (i2 == arrayList.indexOf(axt.this.ae.getString(R.string.JukeReplaceQueue))) {
                                                    axc.a().a(awzVar2.c, "user:public-playlist", axt.this, "replacequeue", "", 0, 100);
                                                    return;
                                                }
                                                return;
                                            }
                                            axc.a().a(awzVar2.c, "user:public-playlist", axt.this, "addqueue", "", 0, 100);
                                            return;
                                        }
                                        axc.a().a(awzVar2.c, "user:public-playlist", axt.this, "playnext", "", 0, 100);
                                        return;
                                    }
                                    axc.a().a(awzVar2.c, "user:public-playlist", axt.this, "playlist", "", 0, 100);
                                    axt.this.d();
                                    return;
                                }
                                axc.a().a(awzVar2.c, "user:public-playlist", axt.this, "play", "", 0, 100);
                                return;
                            }
                            Toast.makeText(axt.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                        }
                    });
                    arzVar.show();
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: axt$a$a, reason: collision with other inner class name */
        class C0084a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public ImageView e;

            C0084a() {
            }
        }
    }
}
