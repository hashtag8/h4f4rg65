package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationViewPager;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;
import com.harman.hkconnect.ui.custom.ViewPagerPointLayout;
import com.musicservice.juke.model.JukeMusicDataLocal;
import com.musicservice.juke.model.JukeMusicRadio;
import defpackage.ajv;
import defpackage.axd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axn extends axk implements axd.a, axd.b {
    ArrayList<JukeMusicRadio> a;
    private View al;
    private AnimationViewPager am;
    private a an;
    private ViewPagerPointLayout ao;
    private LinearLayout ap;
    private LayoutInflater aq;
    private ajp ar;
    private final int aj = 100;
    private int ak = 0;
    int b = 0;
    private ajn as = new ajn() { // from class: axn.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            Object tag = view.getTag(R.id.view_tag_callback_item);
            if (tag == null) {
                tag = obj;
            }
            if (tag != null) {
                if (tag instanceof awz) {
                    axc.a().a(((awz) tag).c, "user:public-playlist", axn.this, "play", "", 0, 100);
                    return;
                }
                if (tag instanceof aww) {
                    axc.a().a(((aww) tag).i, "catalog:album", axn.this, "play", "", 0, 100);
                    return;
                }
                if (tag instanceof axb) {
                    JukeMusicDataLocal jukeMusicDataLocalA = axn.this.a((axb) tag);
                    if (jukeMusicDataLocalA != null) {
                        axn.this.a(jukeMusicDataLocalA);
                        return;
                    }
                    return;
                }
                if (tag instanceof JukeMusicRadio) {
                    axc.a().a(((JukeMusicRadio) tag).b, "catalog:radio", axn.this, "" + ((JukeMusicRadio) tag).a, "", -1, -1);
                }
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.al = layoutInflater.inflate(R.layout.juke_discover, (ViewGroup) null);
        this.aq = layoutInflater;
        this.ao = (ViewPagerPointLayout) this.al.findViewById(R.id.point_layout);
        this.am = (AnimationViewPager) this.al.findViewById(R.id.view_pager);
        this.am.setOnPageChangeListener(new ViewPager.f() { // from class: axn.1
            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                int iB = axn.this.am.getAdapter().b();
                if (i == 0) {
                    axn.this.am.a(iB - 2, false);
                } else if (i == iB - 1) {
                    axn.this.am.a(1, false);
                } else {
                    axn.this.ao.setSelectedPostion(i - 1);
                }
                mm.b("POINT", "set point layout to " + i);
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
            }
        });
        this.al.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ap = (LinearLayout) this.al.findViewById(R.id.discover_content);
        ao();
        return this.al;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        ControlInterceptTouchScrollView controlInterceptTouchScrollView = (ControlInterceptTouchScrollView) this.al.findViewById(R.id.juke_discover_scroll_view);
        this.ar = new ajp((DashboardActivity) p(), controlInterceptTouchScrollView);
        controlInterceptTouchScrollView.setOnTouchListener(this.ar);
        this.ar.a(this.as);
        this.am.a(controlInterceptTouchScrollView, true);
        this.am.setOnItemChosenListener(this.as);
    }

    @Override // defpackage.axk
    void c() {
        this.am.setAdapter(this.an);
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
    }

    public void ao() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
        } else {
            this.ap.removeAllViews();
            d();
        }
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeDiscover).c();
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (str.compareTo("catalog:promoted-albums") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONArray("collections").optJSONObject(1);
            if (jSONObjectOptJSONObject != null) {
                axc.a().a(jSONObjectOptJSONObject.optJSONArray("links"));
            }
            axc.a().a("catalog:promoted-album-collection", this, "", "", 0, 100);
            return;
        }
        if (str.compareTo("catalog:promoted-album-collection") == 0) {
            JSONArray jSONArray = null;
            try {
                jSONArray = jSONObject.getJSONArray("albums");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
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
            if (arrayList.size() > 8) {
                arrayList.subList(8, arrayList.size()).clear();
            }
            if (this.an == null) {
                this.an = new a(this.ae, arrayList);
                this.am.setAdapter(this.an);
                this.am.a(1, false);
            } else {
                this.an.a((List<aww>) arrayList);
            }
            this.an.c();
            if (this.b == 0) {
                this.ao.setSize(this.an.b() - 2);
                this.b = this.an.b();
                if (this.b == 1) {
                    this.ao.setVisibility(4);
                    return;
                }
                return;
            }
            this.ao.setSelectedPostion(this.am.getCurrentItem());
            return;
        }
        if (str.compareTo("user:portal") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            axc.a().a(axc.a().e, "user:popular-public-playlists", (axd.b) this, "", "", -1, -1, false);
            return;
        }
        if (str.compareTo("user:popular-public-playlists") == 0) {
            JSONArray jSONArray2 = null;
            try {
                jSONArray2 = jSONObject.getJSONArray("playlists");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject3 != null) {
                    awz awzVar = new awz();
                    awzVar.a = jSONObjectOptJSONObject3.optString("id");
                    awzVar.b = jSONObjectOptJSONObject3.optString("name");
                    awzVar.e = jSONObjectOptJSONObject3.optString("createdAt");
                    awzVar.f = jSONObjectOptJSONObject3.optString("lastModified");
                    awzVar.c = awp.a(jSONObjectOptJSONObject3);
                    arrayList2.add(awzVar);
                }
            }
            View childAt = null;
            for (int i3 = 0; i3 < this.ap.getChildCount(); i3++) {
                if (a(this.ae.getString(R.string.JukePopularPlaylists), this.ap.getChildAt(i3))) {
                    childAt = this.ap.getChildAt(i3);
                }
            }
            View viewInflate = childAt == null ? this.aq.inflate(R.layout.juke_discovery_item, (ViewGroup) null) : childAt;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 3) {
                    break;
                }
                final awz awzVar2 = (awz) arrayList2.get(i5);
                TextView textView = null;
                RelativeLayout relativeLayout = null;
                if (i5 == 0) {
                    ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.iv1);
                    textView = (TextView) viewInflate.findViewById(R.id.tv1);
                    relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.artist1);
                    imageView4 = imageView5;
                } else if (i5 == 1) {
                    ImageView imageView6 = (ImageView) viewInflate.findViewById(R.id.iv2);
                    textView = (TextView) viewInflate.findViewById(R.id.tv2);
                    relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.artist2);
                    imageView4 = imageView6;
                } else if (i5 != 2) {
                    imageView4 = null;
                } else {
                    ImageView imageView7 = (ImageView) viewInflate.findViewById(R.id.iv3);
                    textView = (TextView) viewInflate.findViewById(R.id.tv3);
                    relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.artist3);
                    imageView4 = imageView7;
                }
                if (relativeLayout != null) {
                    relativeLayout.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: axn.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            axs axsVar = new axs();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("playlist", awzVar2);
                            axsVar.g(bundle);
                            axn.this.a((axj) axsVar);
                        }
                    });
                    relativeLayout.setOnTouchListener(this.ar);
                    relativeLayout.setTag(R.id.view_tag_callback_item, awzVar2);
                }
                bif.a((Context) this.ae).a(awzVar2.c.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView4);
                textView.setText(awzVar2.b);
                i4 = i5 + 1;
            }
            ((TextView) viewInflate.findViewById(R.id.group_title)).setText(this.ae.getString(R.string.JukePopularPlaylists));
            ((TextView) viewInflate.findViewById(R.id.seeall_title)).setOnClickListener(new View.OnClickListener() { // from class: axn.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    axt axtVar = new axt();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("DISCOVER_PARENT", true);
                    axtVar.g(bundle);
                    axn.this.a((axj) axtVar);
                }
            });
            viewInflate.setTag(this.ae.getString(R.string.JukePopularPlaylists));
            if (viewInflate.getParent() == null) {
                this.ap.addView(viewInflate);
            }
            axc.a().a("catalog:track-charts", this, "", "", 0, 100);
            return;
        }
        if (str.compareTo("user:public-playlist") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray3 = null;
            try {
                jSONArray3 = jSONObject.getJSONArray("entries");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            JSONArray jSONArray4 = new JSONArray();
            final ArrayList arrayList3 = new ArrayList();
            for (int i6 = 0; i6 < jSONArray3.length(); i6++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArray3.optJSONObject(i6);
                if (jSONObjectOptJSONObject4 != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject4.optString("id", "0");
                    axbVar.b = jSONObjectOptJSONObject4.optString("name");
                    axbVar.c = jSONObjectOptJSONObject4.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject4.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject4.optInt("lengthInSeconds", 0);
                    axbVar.f = jSONObjectOptJSONObject4.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject4.optString("label");
                    axbVar.h = jSONObjectOptJSONObject4.optString("releaseYear");
                    axbVar.i = awp.a(jSONObjectOptJSONObject4);
                    arrayList3.add(axbVar);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("rel", "catalog:track");
                        jSONObject2.put("href", axbVar.i.get("catalog:track"));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    jSONArray4.put(jSONObject2);
                }
            }
            if (str2.compareTo("play") == 0) {
                final ArrayList arrayList4 = new ArrayList();
                for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                    arrayList4.add(false);
                }
                for (final int i8 = 0; i8 < arrayList3.size(); i8++) {
                    final axb axbVar2 = (axb) arrayList3.get(i8);
                    axc.a().a(axbVar2.i, "catalog:track", new axd.b() { // from class: axn.7
                        @Override // axd.b
                        public void a(String str3, JSONObject jSONObject3, String str4) {
                            int i9 = 0;
                            axbVar2.a = jSONObject3.optString("id");
                            axbVar2.b = jSONObject3.optString("name");
                            axbVar2.c = jSONObject3.optString("artistName");
                            axbVar2.d = jSONObject3.optString("albumName");
                            axbVar2.e = jSONObject3.optInt("lengthInSeconds");
                            axbVar2.f = jSONObject3.optString("genre");
                            axbVar2.g = jSONObject3.optString("label");
                            axbVar2.h = jSONObject3.optString("releaseYear");
                            arrayList3.set(i8, axbVar2);
                            arrayList4.set(i8, true);
                            mm.b("UPDATING TRACK", "" + i8 + " size=" + arrayList3.size());
                            if (!arrayList4.contains(false)) {
                                ArrayList arrayList5 = new ArrayList();
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < arrayList3.size()) {
                                        arrayList5.add(awp.a((axb) arrayList3.get(i10)));
                                        i9 = i10 + 1;
                                    } else {
                                        axn.this.c(arrayList5);
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
                            arrayList4.set(i8, true);
                            if (!arrayList4.contains(false)) {
                                ArrayList arrayList5 = new ArrayList();
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < arrayList3.size()) {
                                        arrayList5.add(awp.a((axb) arrayList3.get(i10)));
                                        i9 = i10 + 1;
                                    } else {
                                        axn.this.c(arrayList5);
                                        return;
                                    }
                                }
                            }
                        }
                    }, "", "", 0, 100);
                }
                return;
            }
            return;
        }
        if (str.compareTo("catalog:track-charts") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray5 = null;
            try {
                jSONArray5 = jSONObject.getJSONArray("charts");
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            for (int i9 = 0; i9 < jSONArray5.length(); i9++) {
                JSONObject jSONObjectOptJSONObject5 = jSONArray5.optJSONObject(i9);
                if (jSONObjectOptJSONObject5 != null) {
                    axc.a().a(jSONObjectOptJSONObject5.optJSONArray("links"));
                }
            }
            axc.a().a(axc.a().e, "catalog:track-chart", (axd.b) this, "", "", -1, -1, false);
            return;
        }
        if (str.compareTo("catalog:album-charts") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            JSONArray jSONArray6 = null;
            try {
                jSONArray6 = jSONObject.getJSONArray("charts");
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            for (int i10 = 0; i10 < jSONArray6.length(); i10++) {
                JSONObject jSONObjectOptJSONObject6 = jSONArray6.optJSONObject(i10);
                if (jSONObjectOptJSONObject6 != null) {
                    axc.a().a(jSONObjectOptJSONObject6.optJSONArray("links"));
                }
            }
            axc.a().a(axc.a().e, "catalog:album-chart", (axd.b) this, "", "", -1, -1, false);
            return;
        }
        if (str.compareTo("catalog:track-chart") == 0) {
            JSONArray jSONArray7 = null;
            try {
                jSONArray7 = jSONObject.getJSONArray("tracks");
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            ArrayList arrayList5 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray7.length(); i11++) {
                JSONObject jSONObjectOptJSONObject7 = jSONArray7.optJSONObject(i11);
                if (jSONObjectOptJSONObject7 != null) {
                    axb axbVar3 = new axb();
                    axbVar3.a = jSONObjectOptJSONObject7.optString("id");
                    axbVar3.b = jSONObjectOptJSONObject7.optString("name");
                    axbVar3.c = jSONObjectOptJSONObject7.optString("artistName");
                    axbVar3.d = jSONObjectOptJSONObject7.optString("albumName");
                    axbVar3.e = jSONObjectOptJSONObject7.optInt("lengthInSeconds");
                    axbVar3.f = jSONObjectOptJSONObject7.optString("genre");
                    axbVar3.g = jSONObjectOptJSONObject7.optString("label");
                    axbVar3.h = jSONObjectOptJSONObject7.optString("releaseYear");
                    jSONObjectOptJSONObject7.optJSONArray("links");
                    axbVar3.i = awp.a(jSONObjectOptJSONObject7);
                    arrayList5.add(axbVar3);
                }
            }
            View childAt2 = null;
            for (int i12 = 0; i12 < this.ap.getChildCount(); i12++) {
                if (a(this.ae.getString(R.string.JukePopularTracks), this.ap.getChildAt(i12))) {
                    childAt2 = this.ap.getChildAt(i12);
                }
            }
            View viewInflate2 = childAt2 == null ? this.aq.inflate(R.layout.juke_discovery_item, (ViewGroup) null) : childAt2;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 < 3) {
                    final axb axbVar4 = (axb) arrayList5.get(i14);
                    TextView textView2 = null;
                    RelativeLayout relativeLayout2 = null;
                    if (i14 == 0) {
                        ImageView imageView8 = (ImageView) viewInflate2.findViewById(R.id.iv1);
                        textView2 = (TextView) viewInflate2.findViewById(R.id.tv1);
                        relativeLayout2 = (RelativeLayout) viewInflate2.findViewById(R.id.artist1);
                        imageView3 = imageView8;
                    } else if (i14 == 1) {
                        ImageView imageView9 = (ImageView) viewInflate2.findViewById(R.id.iv2);
                        textView2 = (TextView) viewInflate2.findViewById(R.id.tv2);
                        relativeLayout2 = (RelativeLayout) viewInflate2.findViewById(R.id.artist2);
                        imageView3 = imageView9;
                    } else if (i14 != 2) {
                        imageView3 = null;
                    } else {
                        ImageView imageView10 = (ImageView) viewInflate2.findViewById(R.id.iv3);
                        textView2 = (TextView) viewInflate2.findViewById(R.id.tv3);
                        relativeLayout2 = (RelativeLayout) viewInflate2.findViewById(R.id.artist3);
                        imageView3 = imageView10;
                    }
                    if (relativeLayout2 != null) {
                        relativeLayout2.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: axn.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                JukeMusicDataLocal jukeMusicDataLocalA = axn.this.a(axbVar4);
                                if (jukeMusicDataLocalA != null) {
                                    axn.this.a(jukeMusicDataLocalA);
                                }
                            }
                        });
                        relativeLayout2.setOnTouchListener(this.ar);
                        relativeLayout2.setTag(R.id.view_tag_callback_item, axbVar4);
                    }
                    bif.a((Context) this.ae).a(axbVar4.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView3);
                    textView2.setText(axbVar4.b);
                    i13 = i14 + 1;
                } else {
                    ((TextView) viewInflate2.findViewById(R.id.group_title)).setText(this.ae.getString(R.string.JukePopularTracks));
                    ((TextView) viewInflate2.findViewById(R.id.seeall_title)).setOnClickListener(new View.OnClickListener() { // from class: axn.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            axl axlVar = new axl();
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("DISCOVER_PARENT", true);
                            axlVar.g(bundle);
                            axn.this.a((axj) axlVar);
                        }
                    });
                    viewInflate2.setTag(this.ae.getString(R.string.JukePopularTracks));
                    this.ap.addView(viewInflate2);
                    axc.a().a("catalog:album-charts", this, "", "", 0, 100);
                    return;
                }
            }
        } else if (str.compareTo("catalog:album-chart") == 0) {
            JSONArray jSONArray8 = null;
            try {
                jSONArray8 = jSONObject.getJSONArray("albums");
            } catch (JSONException e8) {
                e8.printStackTrace();
            }
            ArrayList arrayList6 = new ArrayList();
            for (int i15 = 0; i15 < jSONArray8.length(); i15++) {
                JSONObject jSONObjectOptJSONObject8 = jSONArray8.optJSONObject(i15);
                if (jSONObjectOptJSONObject8 != null) {
                    aww awwVar2 = new aww();
                    awwVar2.a = jSONObjectOptJSONObject8.optString("id");
                    awwVar2.b = jSONObjectOptJSONObject8.optString("name");
                    awwVar2.c = jSONObjectOptJSONObject8.optString("artistName");
                    awwVar2.f = jSONObjectOptJSONObject8.optInt("trackCount");
                    awwVar2.d = jSONObjectOptJSONObject8.optString("lengthInSeconds");
                    awwVar2.e = jSONObjectOptJSONObject8.optString("genre");
                    awwVar2.g = jSONObjectOptJSONObject8.optString("label");
                    awwVar2.h = jSONObjectOptJSONObject8.optString("releaseYear");
                    jSONObjectOptJSONObject8.optJSONArray("links");
                    awwVar2.i = awp.a(jSONObjectOptJSONObject8);
                    arrayList6.add(awwVar2);
                }
            }
            View childAt3 = null;
            for (int i16 = 0; i16 < this.ap.getChildCount(); i16++) {
                if (a(this.ae.getString(R.string.JukePopularAlbums), this.ap.getChildAt(i16))) {
                    childAt3 = this.ap.getChildAt(i16);
                }
            }
            View viewInflate3 = childAt3 == null ? this.aq.inflate(R.layout.juke_discovery_item, (ViewGroup) null) : childAt3;
            int i17 = 0;
            while (true) {
                int i18 = i17;
                if (i18 < 3) {
                    final aww awwVar3 = (aww) arrayList6.get(i18);
                    TextView textView3 = null;
                    RelativeLayout relativeLayout3 = null;
                    if (i18 == 0) {
                        ImageView imageView11 = (ImageView) viewInflate3.findViewById(R.id.iv1);
                        textView3 = (TextView) viewInflate3.findViewById(R.id.tv1);
                        relativeLayout3 = (RelativeLayout) viewInflate3.findViewById(R.id.artist1);
                        imageView2 = imageView11;
                    } else if (i18 == 1) {
                        ImageView imageView12 = (ImageView) viewInflate3.findViewById(R.id.iv2);
                        textView3 = (TextView) viewInflate3.findViewById(R.id.tv2);
                        relativeLayout3 = (RelativeLayout) viewInflate3.findViewById(R.id.artist2);
                        imageView2 = imageView12;
                    } else if (i18 != 2) {
                        imageView2 = null;
                    } else {
                        ImageView imageView13 = (ImageView) viewInflate3.findViewById(R.id.iv3);
                        textView3 = (TextView) viewInflate3.findViewById(R.id.tv3);
                        relativeLayout3 = (RelativeLayout) viewInflate3.findViewById(R.id.artist3);
                        imageView2 = imageView13;
                    }
                    if (relativeLayout3 != null) {
                        relativeLayout3.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: axn.10
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                axh axhVar = new axh();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("album", awwVar3);
                                axhVar.g(bundle);
                                axn.this.a((axj) axhVar);
                            }
                        });
                        relativeLayout3.setOnTouchListener(this.ar);
                        relativeLayout3.setTag(R.id.view_tag_callback_item, awwVar3);
                    }
                    bif.a((Context) this.ae).a(awwVar3.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView2);
                    textView3.setText(awwVar3.b);
                    i17 = i18 + 1;
                } else {
                    ((TextView) viewInflate3.findViewById(R.id.group_title)).setText(this.ae.getString(R.string.JukePopularAlbums));
                    ((TextView) viewInflate3.findViewById(R.id.seeall_title)).setOnClickListener(new View.OnClickListener() { // from class: axn.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            axl axlVar = new axl();
                            Bundle bundle = new Bundle();
                            bundle.putInt("tab", 1);
                            bundle.putBoolean("DISCOVER_PARENT", true);
                            axlVar.g(bundle);
                            axn.this.a((axj) axlVar);
                        }
                    });
                    viewInflate3.setTag(this.ae.getString(R.string.JukePopularAlbums));
                    this.ap.addView(viewInflate3);
                    axc.a().a("catalog:radios", this, "", "", 0, 100);
                    return;
                }
            }
        } else {
            if (str.compareTo("catalog:radios") == 0) {
                this.a = new ArrayList<>();
                try {
                    JSONArray jSONArray9 = jSONObject.getJSONArray("radios");
                    for (int i19 = 0; i19 < jSONArray9.length(); i19++) {
                        JSONObject jSONObject3 = jSONArray9.getJSONObject(i19);
                        JukeMusicRadio jukeMusicRadio = new JukeMusicRadio();
                        jukeMusicRadio.a = jSONObject3.getString("name");
                        jSONObject3.optJSONArray("links");
                        jukeMusicRadio.b = awp.a(jSONObject3);
                        this.a.add(jukeMusicRadio);
                    }
                    View childAt4 = null;
                    for (int i20 = 0; i20 < this.ap.getChildCount(); i20++) {
                        if (a(this.ae.getString(R.string.JukeRadios), this.ap.getChildAt(i20))) {
                            childAt4 = this.ap.getChildAt(i20);
                        }
                    }
                    View viewInflate4 = childAt4 == null ? this.aq.inflate(R.layout.juke_discovery_item, (ViewGroup) null) : childAt4;
                    for (int i21 = 0; i21 < 3; i21++) {
                        final JukeMusicRadio jukeMusicRadio2 = this.a.get(i21);
                        TextView textView4 = null;
                        RelativeLayout relativeLayout4 = null;
                        if (i21 == 0) {
                            ImageView imageView14 = (ImageView) viewInflate4.findViewById(R.id.iv1);
                            textView4 = (TextView) viewInflate4.findViewById(R.id.tv1);
                            relativeLayout4 = (RelativeLayout) viewInflate4.findViewById(R.id.artist1);
                            imageView = imageView14;
                        } else if (i21 == 1) {
                            ImageView imageView15 = (ImageView) viewInflate4.findViewById(R.id.iv2);
                            textView4 = (TextView) viewInflate4.findViewById(R.id.tv2);
                            relativeLayout4 = (RelativeLayout) viewInflate4.findViewById(R.id.artist2);
                            imageView = imageView15;
                        } else if (i21 != 2) {
                            imageView = null;
                        } else {
                            ImageView imageView16 = (ImageView) viewInflate4.findViewById(R.id.iv3);
                            textView4 = (TextView) viewInflate4.findViewById(R.id.tv3);
                            relativeLayout4 = (RelativeLayout) viewInflate4.findViewById(R.id.artist3);
                            imageView = imageView16;
                        }
                        if (relativeLayout4 != null) {
                            relativeLayout4.setOnTouchListener(this.ar);
                            relativeLayout4.setTag(R.id.view_tag_callback_item, jukeMusicRadio2);
                            relativeLayout4.setTag(R.id.view_tag_clicklistener, new View.OnClickListener() { // from class: axn.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    axc.a().a(jukeMusicRadio2.b, "catalog:radio", axn.this, "" + jukeMusicRadio2.a, "", -1, -1);
                                }
                            });
                        }
                        bif.a((Context) this.ae).a(jukeMusicRadio2.b.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView);
                        textView4.setText(jukeMusicRadio2.a);
                    }
                    ((TextView) viewInflate4.findViewById(R.id.group_title)).setText(this.ae.getString(R.string.JukeRadios));
                    ((TextView) viewInflate4.findViewById(R.id.seeall_title)).setOnClickListener(new View.OnClickListener() { // from class: axn.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            axu axuVar = new axu();
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("DISCOVER_PARENT", true);
                            axuVar.g(bundle);
                            axn.this.a((axj) axuVar);
                        }
                    });
                    viewInflate4.setTag(this.ae.getString(R.string.JukeRadios));
                    this.ap.addView(viewInflate4);
                    al();
                    return;
                } catch (JSONException e9) {
                    e9.printStackTrace();
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (str.compareTo("catalog:radio") == 0) {
                JukeMusicRadio jukeMusicRadio3 = null;
                int i22 = 0;
                while (i22 < this.a.size()) {
                    JukeMusicRadio jukeMusicRadio4 = (jukeMusicRadio3 == null && this.a.get(i22).a.compareTo(str2) == 0) ? this.a.get(i22) : jukeMusicRadio3;
                    i22++;
                    jukeMusicRadio3 = jukeMusicRadio4;
                }
                JSONArray jSONArray10 = null;
                try {
                    jSONArray10 = jSONObject.getJSONArray("tracks");
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
                for (int i23 = 0; i23 < jSONArray10.length(); i23++) {
                    JSONObject jSONObjectOptJSONObject9 = jSONArray10.optJSONObject(i23);
                    if (jSONObjectOptJSONObject9 != null) {
                        axb axbVar5 = new axb();
                        axbVar5.a = jSONObjectOptJSONObject9.optString("id");
                        axbVar5.b = jSONObjectOptJSONObject9.optString("name");
                        axbVar5.c = jSONObjectOptJSONObject9.optString("artistName");
                        axbVar5.d = jSONObjectOptJSONObject9.optString("albumName");
                        axbVar5.e = jSONObjectOptJSONObject9.optInt("lengthInSeconds");
                        axbVar5.f = jSONObjectOptJSONObject9.optString("genre");
                        axbVar5.g = jSONObjectOptJSONObject9.optString("label");
                        axbVar5.h = jSONObjectOptJSONObject9.optString("releaseYear");
                        jSONObjectOptJSONObject9.optJSONArray("links");
                        axbVar5.i = awp.a(jSONObjectOptJSONObject9);
                        JukeMusicDataLocal jukeMusicDataLocalA = a(axbVar5);
                        jukeMusicDataLocalA.type = 12;
                        if (jukeMusicDataLocalA != null) {
                            jukeMusicRadio3.a(jukeMusicDataLocalA);
                        }
                    }
                }
                p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
                MusicPlaylistManager.a().a(jukeMusicRadio3);
                return;
            }
            if (str.compareTo("catalog:album") == 0) {
                mm.b("CATALOG", jSONObject.toString());
                JSONArray jSONArray11 = null;
                try {
                    jSONArray11 = jSONObject.getJSONArray("tracks");
                } catch (JSONException e12) {
                    e12.printStackTrace();
                }
                JSONArray jSONArray12 = new JSONArray();
                ArrayList arrayList7 = new ArrayList();
                for (int i24 = 0; i24 < jSONArray11.length(); i24++) {
                    JSONObject jSONObjectOptJSONObject10 = jSONArray11.optJSONObject(i24);
                    if (jSONObjectOptJSONObject10 != null) {
                        axb axbVar6 = new axb();
                        axbVar6.a = jSONObjectOptJSONObject10.optString("id");
                        axbVar6.b = jSONObjectOptJSONObject10.optString("name");
                        axbVar6.c = jSONObjectOptJSONObject10.optString("artistName");
                        axbVar6.d = jSONObjectOptJSONObject10.optString("albumName");
                        axbVar6.e = jSONObjectOptJSONObject10.optInt("lengthInSeconds");
                        axbVar6.f = jSONObjectOptJSONObject10.optString("genre");
                        axbVar6.g = jSONObjectOptJSONObject10.optString("label");
                        axbVar6.h = jSONObjectOptJSONObject10.optString("releaseYear");
                        axbVar6.i = awp.a(jSONObjectOptJSONObject10);
                        arrayList7.add(awp.a(axbVar6));
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put("rel", "catalog:track");
                            jSONObject4.put("href", axbVar6.i.get("catalog:track"));
                        } catch (JSONException e13) {
                            e13.printStackTrace();
                        }
                        jSONArray12.put(jSONObject4);
                    }
                }
                if (str2.compareTo("play") == 0) {
                    c(arrayList7);
                    return;
                }
                return;
            }
            if (str.compareTo("user:home") == 0) {
                axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 100, true);
            }
        }
    }

    private boolean a(String str, View view) {
        return ((String) view.getTag()).equals(str);
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
        if (z) {
            axc.a().a("catalog:promoted-albums", this, "", "", 0, 100);
            axc.a().a(axc.a().e, "user:portal", (axd.b) this, "", "", -1, -1, false);
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", -1, -1, true);
        } else {
            al();
            Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
        }
    }

    class a extends ex implements AnimationViewPager.a {
        private List<View> b;
        private List<aww> c;

        public a(Context context, List<aww> list) {
            int size = list.size() + 2;
            this.c = new ArrayList();
            this.c.add(0, new aww());
            for (int i = 0; i < list.size(); i++) {
                this.c.add(i + 1, list.get(i));
            }
            this.c.add(0, list.get(list.size() - 1));
            this.c.remove(1);
            this.c.add(size - 1, list.get(0));
            this.b = new ArrayList(list.size());
            mm.b("MyViewPagerAdapter", "created new view pager adapter");
        }

        @Override // defpackage.ex
        public int b() {
            return this.c.size();
        }

        @Override // defpackage.ex
        public Object a(ViewGroup viewGroup, int i) {
            mm.b("View", "asked for " + i);
            View viewInflate = axn.this.aq.inflate(R.layout.juke_discover_header, (ViewGroup) null);
            final aww awwVar = this.c.get(i);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.album_background);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv);
            TextView textView = (TextView) viewInflate.findViewById(R.id.title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.subtitle);
            textView.setText(awwVar.b);
            textView2.setText(awwVar.c);
            bif.a((Context) axn.this.ae).a(awwVar.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView2);
            bif.a((Context) axn.this.ae).a(awwVar.i.get("catalog:image-256x256")).a(R.drawable.juke_placeholder_150x150).a(imageView);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: axn.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    axh axhVar = new axh();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("album", awwVar);
                    axhVar.g(bundle);
                    axn.this.a((axj) axhVar);
                }
            });
            while (this.b.size() <= i) {
                this.b.add(null);
            }
            this.b.set(i, viewInflate);
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // defpackage.ex
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // defpackage.ex
        public boolean a(View view, Object obj) {
            return view == obj;
        }

        @Override // defpackage.ex
        public Parcelable a() {
            return null;
        }

        @Override // defpackage.ex
        public void a(Parcelable parcelable, ClassLoader classLoader) {
        }

        @Override // com.harman.hkconnect.ui.custom.AnimationViewPager.a
        public View a(int i) {
            return this.b.get(i);
        }

        @Override // com.harman.hkconnect.ui.custom.AnimationViewPager.a
        public Object b(int i) {
            return this.c.get(i);
        }

        public void a(List<aww> list) {
            this.c = list;
        }
    }
}
