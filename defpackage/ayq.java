package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.axx;
import defpackage.ayf;
import defpackage.ayg;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayq extends ayi implements ayg.a, ayg.b, ayg.d {
    ArrayList<JSONObject> ah;
    private View ak;
    private LayoutInflater ao;
    private GridView ap;
    private Button aq;
    private HashSet<JSONObject> as;
    private JSONArray at;
    private HashSet<String> au;
    private Button ax;
    private RelativeLayout ay;
    private HashMap<String, JSONObject> az;
    public TextView i;
    private String al = "tracks";
    private String am = null;
    private ArrayList<JSONObject> an = null;
    int f = 0;
    int g = 0;
    int h = 0;
    private axx<JSONObject> ar = null;
    private int av = 0;
    private int aw = 0;
    int ai = 0;
    private ArrayList<a> aA = new ArrayList<>();
    private MenuItem.OnMenuItemClickListener aB = new MenuItem.OnMenuItemClickListener() { // from class: ayq.5
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ayp aypVar = new ayp();
            Bundle bundle = new Bundle();
            bundle.putInt("pos", 0);
            bundle.putBoolean("isTaste", true);
            aypVar.g(bundle);
            ayq.this.ae.q().a(aypVar, (arc) null);
            return true;
        }
    };

    @SuppressLint({"HandlerLeak"})
    Handler aj = new Handler() { // from class: ayq.6
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                String str = (String) message.obj;
                mm.b("ARTIST_POSITION", "about to request: " + str);
                ayf.a().a(ayf.a.SimilarArtists, ayq.this, str, 0, 20);
            }
        }
    };

    static class a {
        public String a;
        public int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public void a() {
            this.b++;
        }
    }

    @Override // defpackage.ayi, android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ap != null && this.ae != null) {
            this.ap.setNumColumns(this.ae.getResources().getInteger(R.integer.Mixradio_artists_columns));
        }
        at();
    }

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.fragment_nokia_taste_favourites, (ViewGroup) null);
        this.e = false;
        this.ao = layoutInflater;
        this.as = new HashSet<>();
        this.au = new HashSet<>();
        this.ah = new ArrayList<>();
        this.az = new HashMap<>();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ae.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.av = displayMetrics.widthPixels;
        this.aw = displayMetrics.heightPixels;
        this.ai = this.av / 3;
        this.as = new HashSet<>();
        this.au = new HashSet<>();
        this.i = (TextView) this.ak.findViewById(R.id.mixradio_artist_count);
        this.ak.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() { // from class: ayq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayq.this.ae.getFragmentManager().popBackStackImmediate();
            }
        });
        this.ak.findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() { // from class: ayq.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayp aypVar = new ayp();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("pos", 0);
                bundle2.putBoolean("isTaste", true);
                aypVar.g(bundle2);
                ayq.this.ae.q().a(aypVar, (arc) null);
            }
        });
        this.ay = (RelativeLayout) this.ak.findViewById(R.id.ftu_end);
        this.ay.setVisibility(8);
        this.aq = (Button) this.ak.findViewById(R.id.ftu_next_button);
        this.ap = (GridView) this.ak.findViewById(R.id.group_gridview);
        this.ap.setOnScrollListener(new ayb(this.ae));
        this.ap.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ayq.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final View viewFindViewById = view.findViewById(R.id.mixradio_overlay_heart);
                ImageView imageView = (ImageView) view.findViewById(R.id.mixradio_overlay);
                JSONObject jSONObject = ayq.this.ah.get(i);
                if (ayq.this.as.contains(jSONObject)) {
                    ayq.this.as.remove(jSONObject);
                    imageView.setVisibility(4);
                    viewFindViewById.setVisibility(4);
                    ayq ayqVar = ayq.this;
                    ayqVar.h--;
                    ayq.this.ao();
                    return;
                }
                imageView.setVisibility(0);
                viewFindViewById.setVisibility(0);
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(ayq.this.ae, R.anim.heart_fade);
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ayq.3.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewFindViewById.setVisibility(4);
                    }
                });
                viewFindViewById.startAnimation(animationLoadAnimation);
                Message message = new Message();
                try {
                    message.obj = jSONObject.getString("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                message.what = 11;
                ayq.this.aj.sendMessageDelayed(message, 1200L);
                ayq.this.h++;
                ayq.this.ao();
                try {
                    ayq.this.az.put(jSONObject.getString("id"), jSONObject);
                    mm.b("ARTIST_POSITION", "added " + jSONObject.getString("id") + " to position " + i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ayq.this.as.add(jSONObject);
            }
        });
        this.ax = (Button) this.ak.findViewById(R.id.taste_artist_next_button);
        this.ax.setOnClickListener(new View.OnClickListener() { // from class: ayq.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList(ayq.this.as);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    JSONObject jSONObject = (JSONObject) arrayList.get(i);
                    jSONArray.put(jSONObject);
                    if (!aho.b("mixradio_harman_ftu", false)) {
                        try {
                            ayf.a().a(jSONObject.getString("id"), (Boolean) true, (ayg.b) null);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                aho.d("mixradio_username");
                final String strD = aho.d("mixradio_userid");
                if (!aho.b("mixradio_ftu_" + strD, false)) {
                    ayq.this.ay.setVisibility(0);
                    ayq.this.ay.setOnClickListener(new View.OnClickListener() { // from class: ayq.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            aho.a("mixradio_ftu_" + strD, true);
                            ayq.this.ae.q().a(new ayo(), 0, (arc) null);
                        }
                    });
                    ayq.this.aq.setOnClickListener(new View.OnClickListener() { // from class: ayq.4.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            aho.a("mixradio_ftu_" + strD, true);
                            ayq.this.ae.q().a(new ayo(), 0, (arc) null);
                        }
                    });
                } else {
                    aho.a("mixradio_ftu_" + strD, true);
                    ayq.this.ae.q().a(new ayo(), 0, (arc) null);
                }
            }
        });
        return this.ak;
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(this.aB);
        aVar.i(R.drawable.hamberger_white_icon);
        aVar.c(true);
        aVar.k(R.drawable.mixradio_search);
        return aVar.a(q().getColor(R.color.nokia_pink)).g(R.string.MixRadioFTUTitleWhoInto).c();
    }

    public void an() {
        this.as = new HashSet<>();
        this.au = new HashSet<>();
        this.ah = new ArrayList<>();
        this.az = new HashMap<>();
    }

    public void ao() {
        this.i.setText(this.ae.getString(R.string.MixRadioArtistsSelected1, new Object[]{Integer.valueOf(this.h)}));
        if (this.h == 0) {
            this.ax.setEnabled(false);
            this.ax.setTextColor(q().getColor(R.color.nokia_small_text));
        } else {
            this.ax.setEnabled(true);
            this.ax.setTextColor(q().getColor(R.color.white));
        }
    }

    public void a(String str, String str2) {
        ayf.a().a(ayf.a.FetchArtist, this, str2);
    }

    @Override // defpackage.ayi
    boolean al() {
        return false;
    }

    private void ap() {
        an();
        this.ar = new axx<>(this.ae, new b(), 20, R.layout.nokia_gridview_item, R.layout.nokia_gridview_item_empty);
        this.ap.setAdapter((ListAdapter) this.ar);
        ao();
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        Bundle bundleL = l();
        try {
            mm.b("Genre ids", "genre_ids = " + bundleL.getString("genres", ""));
            if (bundleL.getString("genres", "").compareTo("") != 0) {
                this.at = new JSONArray(bundleL.getString("genres"));
                if (this.ah.size() == 0) {
                    c();
                    this.aA.clear();
                    for (int i = 0; i < this.at.length(); i++) {
                        this.aA.add(new a((String) this.at.get(i), 0));
                    }
                    a aVar = this.aA.get(0);
                    ayf.a().a(ayf.a.GenreArtists, this, aVar.a, 0, 20);
                    aVar.a();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.at = null;
        }
        ap();
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        ayd aydVar;
        try {
            aydVar = (ayd) bundle.getSerializable("artist");
        } catch (Exception e) {
            aydVar = null;
        }
        if (aydVar != null) {
            a(aydVar.a, aydVar.b);
        }
        super.c(bundle);
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (ayf.a().g() != null) {
            a(ayf.a().g().a, ayf.a().g().b);
            ayf.a().a((ayd) null);
        }
    }

    @Override // ayg.a
    public void a(boolean z) {
    }

    public void a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        mm.b("JSONOBJECT", jSONObject.toString());
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            mm.b("ITEMS", jSONArray.toString());
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getJSONObject(i).getString("id");
                    if (!this.au.contains(string)) {
                        arrayList.add(jSONArray.getJSONObject(i));
                        this.au.add(string);
                    }
                }
            } else {
                return;
            }
        } catch (Exception e) {
            mm.b("JSONGroup", e.toString());
        }
        mm.b("LOCALLIST1", "" + arrayList.size());
        Collections.shuffle(arrayList);
        this.ah.addAll(this.ah.size(), (ArrayList) arrayList.clone());
        mm.b("LOCALLIST", "" + arrayList.size());
        mm.b("MIXLIST", "" + this.ah.size());
        try {
            if (arrayList.size() != 0) {
                this.ar.b(arrayList);
                this.ar.notifyDataSetChanged();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d();
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        if (aVar == ayf.a.GenreArtists) {
            a(jSONObject);
            return;
        }
        if (aVar == ayf.a.SimilarArtists) {
            mm.b("SIMILAR", jSONObject.toString());
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                int iIndexOf = this.ah.indexOf(this.az.remove(str)) + 1;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (!this.au.contains(jSONObject2.getString("id"))) {
                        jSONObject2.put("similar_artist", true);
                        arrayList.add(jSONObject2);
                    }
                }
                int size = arrayList.size() < 3 ? arrayList.size() : 3;
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject3 = (JSONObject) arrayList.get(i2);
                    this.ah.add(iIndexOf, jSONObject3);
                    this.au.add(jSONObject3.getString("id"));
                }
            } catch (Exception e) {
                mm.b("JSONGroup", e.toString());
            }
            try {
                this.f = this.ap.getFirstVisiblePosition();
                View childAt = this.ap.getChildAt(0);
                this.g = childAt != null ? childAt.getTop() : 0;
                this.ar.a(this.ah);
                this.ar.notifyDataSetChanged();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            d();
            return;
        }
        if (aVar == ayf.a.FetchArtist) {
            mm.b("FETCH", jSONObject.toString());
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            if ((jSONArrayOptJSONArray != null) & (jSONArrayOptJSONArray.length() > 0)) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                if (jSONObjectOptJSONObject.has("thumbnails")) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject2.has("200x200") || jSONObjectOptJSONObject2.has("100x100")) {
                        jSONObjectOptJSONObject2.optString("200x200");
                    }
                }
                String strOptString = jSONObjectOptJSONObject.optString("id");
                if (!this.au.contains(strOptString)) {
                    try {
                        jSONObjectOptJSONObject.put("similar_artist", true);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.ah.add(0, jSONObjectOptJSONObject);
                    this.au.add(strOptString);
                    this.as.add(jSONObjectOptJSONObject);
                    this.h++;
                    ao();
                    this.az.put(strOptString, jSONObjectOptJSONObject);
                    mm.b("ARTIST_POSITION", "added " + strOptString + " to position 0");
                    ayf.a().a(ayf.a.SimilarArtists, this, strOptString, 0, 20);
                }
            }
            try {
                this.f = this.ap.getFirstVisiblePosition();
                View childAt2 = this.ap.getChildAt(0);
                this.g = childAt2 != null ? childAt2.getTop() : 0;
                this.ar.a(this.ah);
                this.ar.notifyDataSetChanged();
                this.ap.setSelection(this.f);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.ap.setAdapter((ListAdapter) this.ar);
            d();
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        if (bVar == ayf.b.Suceeded && musicData != null) {
            d();
            MusicPlaylistManager.a().b(musicData);
        }
    }

    class b implements axx.a<JSONObject> {
        private HashMap<String, SoftReference<Bitmap>> b = new HashMap<>();

        public b() {
        }

        @Override // axx.a
        public void a(int i, int i2) {
            a aVar = (a) ayq.this.aA.get((int) (((double) ayq.this.aA.size()) * Math.random()));
            aVar.a();
            ayf.a().a(ayf.a.GenreArtists, ayq.this, aVar.a, aVar.b * i2, i2);
        }

        @Override // axx.a
        public View a(int i, View view, ViewGroup viewGroup, JSONObject jSONObject) {
            c cVar = (c) view.getTag();
            if (cVar == null) {
                c cVar2 = ayq.this.new c();
                cVar2.a = (ImageView) view.findViewById(R.id.iv);
                cVar2.d = (TextView) view.findViewById(R.id.tv);
                cVar2.b = (ImageView) view.findViewById(R.id.mixradio_overlay);
                cVar2.c = (ImageView) view.findViewById(R.id.mixradio_overlay_heart);
                cVar2.d.setTypeface(ahu.a(ayq.this.ae));
                view.setTag(cVar2);
                cVar = cVar2;
            }
            bif.a((Context) ayq.this.ae).a(cVar.a);
            try {
                if (!jSONObject.has("name")) {
                    bif.a((Context) ayq.this.ae).a(cVar.a);
                    cVar.a.setImageResource(R.drawable.mixradio_missing_artist);
                } else {
                    mm.b("VIEW", jSONObject.getString("name"));
                    cVar.d.setText(jSONObject.getString("name"));
                    if (jSONObject.has("description")) {
                        jSONObject.getString("description");
                    }
                    if (jSONObject.has("similar_artist")) {
                        jSONObject.remove("similar_artist");
                        ayq.this.ah.set(i, jSONObject);
                        bif.a((Context) ayq.this.ae).a(cVar.a);
                        final String strReplace = ayg.a(ayg.c.ArtistImage, "" + jSONObject.getString("id")).replace("http://", "https://");
                        mm.b("MIXRADIO", strReplace);
                        new ahw().a(cVar.a, new ahq() { // from class: ayq.b.1
                            @Override // defpackage.ahq
                            public void a(View view2) {
                                bif.a((Context) ayq.this.ae).a(strReplace).b(R.drawable.mixradio_missing_artist).b(view2.getWidth(), view2.getHeight()).e().a((ImageView) view2);
                            }
                        });
                        Animation animationLoadAnimation = AnimationUtils.loadAnimation(ayq.this.ae, R.anim.album_fade_in);
                        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ayq.b.2
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                            }
                        });
                        cVar.a.startAnimation(animationLoadAnimation);
                    } else {
                        final String strReplace2 = ayg.a(ayg.c.ArtistImage, "" + jSONObject.getString("id")).replace("http://", "https://");
                        bif.a((Context) ayq.this.ae).a(cVar.a);
                        new ahw().a(cVar.a, new ahq() { // from class: ayq.b.3
                            @Override // defpackage.ahq
                            public void a(View view2) {
                                bif.a((Context) ayq.this.ae).a(strReplace2).b(R.drawable.mixradio_missing_artist).b(view2.getWidth(), view2.getHeight()).e().a((ImageView) view2);
                            }
                        });
                    }
                    if (ayq.this.as.contains(jSONObject)) {
                        cVar.b.setVisibility(0);
                        mm.b("OVERLAY", "setting the overlay pink for " + i);
                    } else {
                        cVar.b.setVisibility(4);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return view;
        }
    }

    class c {
        public ImageView a;
        public ImageView b;
        public ImageView c;
        public TextView d;

        c() {
        }
    }
}
