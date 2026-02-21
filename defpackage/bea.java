package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.aic;
import defpackage.ajv;
import defpackage.bdh;
import defpackage.bdi;
import defpackage.gj;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import org.apache.http.entity.ContentLengthStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bea extends bdn implements bdi.b {
    private View ai;
    private aic<bdf> aj;
    private ListView al;
    private ImageView av;
    private TextView aw;
    private LinearLayout ax;
    bdc g;
    ArrayList<bdf> h;
    TextView i;
    private ArrayList<bdf> ak = new ArrayList<>();
    private final int ar = 20;
    private int as = 1;
    final int a = 0;
    final int b = 1;
    final int c = 2;
    final int d = 3;
    final int e = 4;
    private long at = 0;
    int f = 0;
    private String au = null;
    private AdapterView.OnItemClickListener ay = new AdapterView.OnItemClickListener() { // from class: bea.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            String strEncode;
            if (i == bea.this.h.size()) {
                bea.this.ap();
                return;
            }
            bdf bdfVar = (bdf) bea.this.ak.get(i);
            bea.this.a(bdfVar.a, bdfVar.b, bdfVar.c, bdfVar.d);
            bea.this.c(bea.this.l());
            bea.this.ao();
            if (bdfVar.c == 0) {
                bdh.a().a(bdh.a.PlaylistMetaData, bea.this, bdfVar.d, "");
                return;
            }
            if (bdfVar.c == 2) {
                bdh.a().a(bdh.a.AlbumMetaData, bea.this, bdfVar.d, "");
                return;
            }
            if (bdfVar.c == 1) {
                bdh.a().a(bdh.a.ArtistMetaData, bea.this, bdfVar.d, "");
                return;
            }
            if (bdfVar.c == 3) {
                bdh.a().a(bdh.a.Tracks, bea.this, bdfVar.d, "");
                return;
            }
            if (bdfVar.c == 4) {
                beb bebVar = new beb();
                Bundle bundle = new Bundle();
                try {
                    strEncode = URLEncoder.encode(bdfVar.a, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    strEncode = null;
                }
                bundle.putString("search_term", strEncode);
                bundle.putInt("current_screen", 0);
                bebVar.g(bundle);
                if (!ahn.a()) {
                    bea.this.ae.q().a(bebVar, (arc) null);
                } else {
                    bea.this.ae.q().a(bebVar, new arc().c(R.id.menu_container));
                }
            }
        }
    };
    private MenuItem.OnMenuItemClickListener az = new MenuItem.OnMenuItemClickListener() { // from class: bea.3
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            bea.this.ae.l().a(bea.this.b());
            bea.this.ae.onBackPressed();
            return true;
        }
    };
    DialogInterface.OnClickListener ah = new DialogInterface.OnClickListener() { // from class: bea.4
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            switch (i) {
                case ContentLengthStrategy.IDENTITY /* -1 */:
                    bea.this.ak.clear();
                    aho.e("STORED_RECENT_SEARCH_HISTORY");
                    aho.e("tidal_search");
                    bea.this.c(bea.this.l());
                    bea.this.ae.l().b.clear();
                    bea.this.ae.l().a.clear();
                    bea.this.ae.l().a.notifyDataSetChanged();
                    break;
            }
        }
    };
    private ajs aA = new ajs() { // from class: bea.5
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            bea.this.h.clear();
            try {
                JSONArray jSONArray = new JSONArray(aho.d("STORED_RECENT_SEARCH_HISTORY"));
                if (jSONArray != null) {
                    for (int length = jSONArray.length() - 1; length >= 0; length--) {
                        String[] strArrSplit = ((String) jSONArray.get(length)).split(",");
                        for (int length2 = strArrSplit.length - 1; length2 >= 0; length2--) {
                            if (strArrSplit[length2] != null && !TextUtils.isEmpty(strArrSplit[length2])) {
                                bea.this.a(strArrSplit[length2], "", 4, "");
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (ajwVar != ajw.SEARCH_PRESSED) {
                bea.this.c(str);
                return;
            }
            bea.this.a(str, "", 4, "");
            bea.this.c(bea.this.l());
            beb bebVar = new beb();
            Bundle bundle = new Bundle();
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
            }
            bundle.putString("search_term", str);
            bundle.putInt("current_screen", 0);
            bebVar.g(bundle);
            if (!ahn.a()) {
                bea.this.ae.q().a(bebVar, (arc) null);
            } else {
                bea.this.ae.q().a(bebVar, new arc().c(R.id.menu_container));
            }
        }
    };

    static /* synthetic */ int m(bea beaVar) {
        int i = beaVar.as;
        beaVar.as = i + 1;
        return i;
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        if (aVar == bdh.a.Search) {
            long jOptLong = jSONObject.optLong("time_sent", 0L);
            if (jOptLong > this.at) {
                this.at = jOptLong;
                this.ak.clear();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("items");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        bdf bdfVar = new bdf();
                        if (jSONObject2.has("type")) {
                            String string = jSONObject2.getString("type");
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("item");
                            if (string.compareTo("PLAYLIST") == 0) {
                                bdfVar.c = 0;
                                bdfVar.d = jSONObject3.getString("uuid");
                                bdfVar.a = jSONObject3.getString("title");
                            } else if (string.compareTo("ARTIST") == 0) {
                                bdfVar.c = 1;
                                bdfVar.d = jSONObject3.getString("id");
                                bdfVar.a = jSONObject3.getString("name");
                            } else if (string.compareTo("ALBUM") == 0) {
                                bdfVar.c = 2;
                                bdfVar.d = jSONObject3.getString("id");
                                bdfVar.a = jSONObject3.getString("title");
                                if (jSONObject3.has("artist")) {
                                    bdfVar.b = jSONObject3.getJSONObject("artist").getString("name");
                                }
                            } else if (string.compareTo("TRACK") == 0) {
                                bdfVar.c = 3;
                                bdfVar.d = jSONObject3.getString("id");
                                bdfVar.a = jSONObject3.getString("title");
                                if (jSONObject3.has("artist")) {
                                    bdfVar.b = jSONObject3.getJSONObject("artist").getString("name");
                                }
                            }
                        }
                        this.ak.add(bdfVar);
                    }
                    this.al.setAdapter((ListAdapter) null);
                    this.i.setVisibility(8);
                    this.aj.a(this.ak);
                    this.aj.notifyDataSetChanged();
                    this.al.setAdapter((ListAdapter) this.aj);
                    mm.b("TIDAL", "getcount=" + this.aj.getCount());
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (aVar == bdh.a.PlaylistMetaData) {
            bdc bdcVar = new bdc();
            try {
                bdcVar.c = jSONObject.optString("description");
                bdcVar.d = jSONObject.optInt("duration");
                bdcVar.a = jSONObject.optString("title");
                bdcVar.e = jSONObject.optString("url");
                bdcVar.b = jSONObject.optString("uuid");
                bdcVar.f = jSONObject.optInt("numberOfTracks");
                bdcVar.h = jSONObject.optString("image");
                if (jSONObject.has("creator")) {
                    int iOptInt = jSONObject.getJSONObject("creator").optInt("id");
                    if (iOptInt == 0) {
                        bdcVar.g = "TIDAL";
                    } else if (("" + iOptInt).compareTo(aho.d("tidal_user_auth_token")) == 0) {
                        bdcVar.g = "me";
                    } else {
                        bdcVar.g = "" + iOptInt;
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            bdw bdwVar = new bdw();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", bdcVar);
            bdwVar.g(bundle);
            if (ahn.a()) {
                this.ae.q().a(bdwVar, new arc().c(R.id.menu_container));
                return;
            } else {
                this.ae.q().a(bdwVar, (arc) null);
                return;
            }
        }
        if (aVar == bdh.a.AlbumMetaData) {
            bda bdaVar = new bda();
            try {
                bdaVar.a = "" + jSONObject.getInt("id");
                bdaVar.e = jSONObject.getString("cover");
                bdaVar.b = jSONObject.getString("title");
                if (jSONObject.has("artist")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("artist");
                    bdaVar.c = jSONObject4.getString("name");
                    bdaVar.d = "" + jSONObject4.getInt("id");
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            bdk bdkVar = new bdk();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("album", bdaVar);
            bundle2.putInt("current_screen", 0);
            bdkVar.g(bundle2);
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
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            bdl bdlVar = new bdl();
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("artist", bdbVar);
            bundle3.putInt("current_screen", 0);
            bdlVar.g(bundle3);
            if (ahn.a()) {
                this.ae.q().a(bdlVar, new arc().c(R.id.menu_container));
                return;
            } else {
                this.ae.q().a(bdlVar, (arc) null);
                return;
            }
        }
        if (aVar == bdh.a.Tracks) {
            a(bcw.a(bdg.a(jSONObject)));
        }
    }

    @Override // bdi.b
    public void a(bdh.a aVar, JSONArray jSONArray) {
    }

    @Override // bdi.b
    public void a(bdh.a aVar, String str) {
        Toast.makeText(this.ae, R.string.TidalApiReturnError_Str, 1).show();
        am();
    }

    @Override // defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = layoutInflater.inflate(R.layout.tidal_search, (ViewGroup) null);
        this.al = (ListView) this.ai.findViewById(R.id.results_listview);
        this.i = (TextView) this.ai.findViewById(R.id.search_results_header);
        TypefaceTextView typefaceTextView = new TypefaceTextView(this.ae);
        typefaceTextView.setText("Clear History");
        typefaceTextView.setTextAppearance(this.ae, R.style.font_white_16);
        int iA = ahn.a(this.ae, 2.0f);
        typefaceTextView.setPadding(iA, iA, iA, iA);
        this.al.addFooterView(typefaceTextView);
        this.av = (ImageView) this.ai.findViewById(R.id.listview_tips_icon);
        this.aw = (TextView) this.ai.findViewById(R.id.search_no_results_found);
        this.ax = (LinearLayout) this.ai.findViewById(R.id.search_holder);
        this.aj = new aic<>(this.ae, new a(), 20, R.layout.tidal_search_result_item, R.layout.harman_list_loading);
        try {
            this.aj.a(this.ak);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.al.setAdapter((ListAdapter) this.aj);
        b(q().getString(R.string.TidalSearch));
        this.ai.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return this.ai;
    }

    public void a(String str, String str2, int i, String str3) {
        boolean z;
        abw abwVar = new abw();
        while (this.h != null && this.h.size() >= 10) {
            this.h.remove(this.h.size() - 1);
        }
        bdf bdfVar = new bdf();
        bdfVar.a = str;
        bdfVar.b = str2;
        bdfVar.d = str3;
        bdfVar.c = i;
        if (this.h != null) {
            z = true;
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (this.h.get(i2).a.compareTo(str) == 0 && this.h.get(i2).d.compareTo(str3) == 0) {
                    this.h.remove(i2);
                    this.h.add(0, bdfVar);
                    z = false;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            this.h.add(0, bdfVar);
            mm.b("RECENT_SEARCHES", "adding " + str);
        }
        aho.a("tidal_search", abwVar.a(this.h));
    }

    public void ao() {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                break;
            }
            linkedList.add(this.h.get(i2).a);
            i = i2 + 1;
        }
        if (linkedList != null) {
            aho.a("STORED_RECENT_SEARCH_HISTORY", new JSONArray((Collection) linkedList).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            c(l());
            return;
        }
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else if (!str.equals(this.au)) {
            try {
                this.au = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                this.au = str;
            }
            bdh.a().a(bdh.a.Search, this, this.au, "");
        }
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ak.clear();
        this.h = (ArrayList) new abw().a(aho.d("tidal_search"), new adp<ArrayList<bdf>>() { // from class: bea.1
        }.b());
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.ak = (ArrayList) this.h.clone();
        for (int i = 0; i < this.ak.size(); i++) {
            mm.b("RECENT", this.ak.get(i).a);
        }
        this.i.setVisibility(0);
        try {
            this.aj.a(this.ak);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.aj.notifyDataSetChanged();
        if (this.ak != null && this.ak.size() > 0) {
            this.al.setVisibility(0);
            this.ax.setVisibility(0);
            this.av.setVisibility(8);
            this.aw.setVisibility(8);
        } else {
            this.al.setVisibility(8);
            this.ax.setVisibility(8);
            this.av.setVisibility(0);
            this.aw.setVisibility(0);
        }
        this.al.setOnItemClickListener(this.ay);
    }

    @Override // defpackage.bdn
    public void c() {
        this.al.setAdapter((ListAdapter) this.aj);
    }

    @Override // defpackage.bdm, defpackage.ajj
    public ajv b() {
        return new ajv.a().d(true).n(-16777216).a(-16777216).m(q().getColor(R.color.white)).a(this.aA).e(true).c(true).k(R.drawable.search_close_button).a(this.az).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        new gj.a(this.ae).b(this.ae.getString(R.string.kClearSearchHistory_Str)).a(this.ae.getString(R.string.YES_Str), this.ah).b(this.ae.getString(R.string.NO_Str), this.ah).c();
    }

    class a implements aic.a<bdf> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            mm.b("MCurrPage", "mCurrPage = " + bea.this.as + " and size = " + i2);
            bdh.a().a(bdh.a.PlaylistTracks, bea.this, bea.this.g.b, "", bea.this.as * i2, i2);
            bea.m(bea.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, bdf bdfVar) {
            C0124a c0124a = (C0124a) view.getTag();
            if (c0124a == null) {
                C0124a c0124a2 = new C0124a();
                c0124a2.a = (ImageView) view.findViewById(R.id.iv);
                c0124a2.b = (TextView) view.findViewById(R.id.text1);
                c0124a2.c = (TextView) view.findViewById(R.id.text2);
                view.setTag(c0124a2);
                c0124a = c0124a2;
            }
            c0124a.b.setText(bdfVar.a);
            c0124a.c.setVisibility(0);
            if (bdfVar.c == 0) {
                c0124a.a.setImageResource(R.drawable.tidal_icon_playlists);
                c0124a.c.setVisibility(8);
            } else if (bdfVar.c == 2) {
                c0124a.a.setImageResource(R.drawable.tidal_icon_albums);
                c0124a.c.setText(bdfVar.b);
            } else if (bdfVar.c == 1) {
                c0124a.a.setImageResource(R.drawable.tidal_icon_artist);
                c0124a.c.setVisibility(8);
            } else if (bdfVar.c == 3) {
                c0124a.a.setImageResource(R.drawable.tidal_icon_tracks);
                c0124a.c.setText(bdfVar.b);
            } else if (bdfVar.c == 4) {
                c0124a.a.setImageResource(R.drawable.tidal_icon_search);
                c0124a.c.setVisibility(8);
            }
            return view;
        }

        /* JADX INFO: renamed from: bea$a$a, reason: collision with other inner class name */
        class C0124a {
            public ImageView a;
            public TextView b;
            public TextView c;

            C0124a() {
            }
        }
    }
}
