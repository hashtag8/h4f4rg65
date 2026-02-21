package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import defpackage.als;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aln extends ale {
    private View ah;
    private AnimationListView ai;
    private AnimationListView aj;
    private AnimationListView ak;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private List<akm> aq;
    private List<akh> ar;
    private List<akg> as;
    private View c;
    private TabPageIndicator d;
    private View e;
    private View f;
    private String al = "tracks";
    private String am = null;
    private View.OnClickListener at = new ahl(this) { // from class: aln.1
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.back /* 2131690262 */:
                    aln.this.ao();
                    break;
            }
        }
    };
    private AdapterView.OnItemClickListener au = new AdapterView.OnItemClickListener() { // from class: aln.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (adapterView.getId()) {
                case R.id.artist_listview /* 2131690170 */:
                    aln.this.a(adapterView, view, i, j);
                    break;
                case R.id.albums_listview /* 2131690177 */:
                    aln.this.b(adapterView, view, i, j);
                    break;
            }
        }
    };
    TabPageIndicator.a a = new TabPageIndicator.a() { // from class: aln.6
        @Override // com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.a
        public void a(int i) {
            aln.this.d(i);
        }
    };
    private SearchView.OnCloseListener av = new SearchView.OnCloseListener() { // from class: aln.7
        @Override // android.widget.SearchView.OnCloseListener
        public boolean onClose() {
            mm.b("onClose()", new Object[0]);
            return false;
        }
    };
    SearchView.OnQueryTextListener b = new SearchView.OnQueryTextListener() { // from class: aln.8
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            mm.b("onQueryTextSubmit  " + str, new Object[0]);
            aln.this.b(str);
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            mm.b("onQueryTextChange  " + str, new Object[0]);
            return false;
        }
    };
    private MenuItem.OnMenuItemClickListener aw = new MenuItem.OnMenuItemClickListener() { // from class: aln.9
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            aln.this.ae.l().a(aln.this.b());
            aln.this.ae.onBackPressed();
            return true;
        }
    };
    private ajs ax = new ajs() { // from class: aln.10
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            aln.this.b(str);
        }
    };
    private ajn ay = new ajn() { // from class: aln.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                if (!ahh.e(aln.this.ae)) {
                    Toast.makeText(aln.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(aln.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                if (obj instanceof akm) {
                    als.b((akm) obj);
                } else if (obj instanceof akh) {
                    als.b((akh) obj, aln.this.g, aln.this.az);
                } else if (obj instanceof akg) {
                    als.a((akg) obj, aln.this.g, aln.this.az);
                }
            }
        }
    };
    private als.a az = new als.a() { // from class: aln.4
        @Override // als.a
        public void a() {
        }

        @Override // als.a
        public void a(JSONObject jSONObject) {
            aln.this.a(jSONObject);
        }
    };

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.fragment_deezer_search, (ViewGroup) null);
        am();
        an();
        return this.c;
    }

    private void am() {
        this.an = (TextView) this.c.findViewById(R.id.tracks_empty);
        this.ao = (TextView) this.c.findViewById(R.id.artist_empty);
        this.ap = (TextView) this.c.findViewById(R.id.albums_empty);
        this.d = (TabPageIndicator) this.c.findViewById(R.id.indicator);
        this.e = this.c.findViewById(R.id.tracks);
        this.f = this.c.findViewById(R.id.artist);
        this.ah = this.c.findViewById(R.id.albums);
        this.ai = (AnimationListView) this.c.findViewById(R.id.tracks_listview);
        this.aj = (AnimationListView) this.c.findViewById(R.id.artist_listview);
        this.ak = (AnimationListView) this.c.findViewById(R.id.albums_listview);
        this.d.setTitles(new CharSequence[]{a(R.string.kDeezerCoupleScrollView_Tracks_Str), a(R.string.kDeezerCoupleScrollView_Artists_Str), a(R.string.kDeezerCoupleScrollView_Albums_Str)});
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    private String a(String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if ("tracks".equals(str)) {
            return "https://api.deezer.com/search?q=" + str2 + "&access_token=" + this.g.b() + "&limit=2147483647";
        }
        if ("artist".equals(str)) {
            return "https://api.deezer.com/search/artist?q=" + str2 + "&access_token=" + this.g.b() + "&limit=2147483647";
        }
        if (!"albums".equals(str)) {
            return null;
        }
        return "https://api.deezer.com/search/album?q=" + str2 + "&access_token=" + this.g.b() + "&limit=2147483647";
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a().d(true).n(-13487558).a(-13487558).a(Html.fromHtml("<small>" + q().getString(R.string.kDeezerSearchPlacehold_Str) + "</small>")).m(q().getColor(R.color.white)).a(this.ax).c(true).k(R.drawable.search_close_button).a(true).a(this.aw).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!ahh.e(this.ae)) {
                Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                return;
            }
            if (!str.equals(this.am)) {
                this.am = str;
                aue aueVarA = agv.a(true);
                String strA = a("tracks", str);
                c();
                mm.b(strA, new Object[0]);
                aueVarA.a(strA, new aum() { // from class: aln.11
                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                        aln.this.a(jSONObject);
                        mm.b(jSONObject, new Object[0]);
                        aln.this.aq = new qv(akm.class).a(jSONObject.toString());
                        aln.this.ai.setAdapter((ListAdapter) new amb(aln.this.ae, aln.this.aq));
                        if (aln.this.aq == null || aln.this.aq.isEmpty()) {
                            aln.this.an.setVisibility(0);
                        } else {
                            aln.this.an.setVisibility(4);
                        }
                    }

                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        aln.this.a(i, jSONObject);
                    }
                });
                aue aueVarA2 = agv.a(true);
                String strA2 = a("artist", str);
                mm.b(strA2, new Object[0]);
                aueVarA2.a(strA2, new aum() { // from class: aln.12
                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                        aln.this.a(jSONObject);
                        mm.b(jSONObject, new Object[0]);
                        aln.this.ar = new qv(akh.class).a(jSONObject.toString());
                        alv alvVar = new alv(aln.this.ae, aln.this.ar);
                        arp arpVar = new arp(aln.this.aj);
                        aln.this.aj.setAdapter((ListAdapter) alvVar);
                        arpVar.a();
                        if (aln.this.ar == null || aln.this.ar.isEmpty()) {
                            aln.this.ao.setVisibility(0);
                        } else {
                            aln.this.ao.setVisibility(4);
                        }
                    }

                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    }
                });
                aue aueVarA3 = agv.a(true);
                String strA3 = a("albums", str);
                mm.b(strA3, new Object[0]);
                aueVarA3.a(strA3, new aum() { // from class: aln.2
                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                        aln.this.a(jSONObject);
                        mm.b(jSONObject, new Object[0]);
                        aln.this.as = new qv(akg.class).a(jSONObject.toString());
                        alt altVar = new alt(aln.this.ae, aln.this.as, aln.this.a(R.string.kDeezerNav_Search_Str), aln.this.g);
                        arp arpVar = new arp(aln.this.ak);
                        aln.this.ak.setAdapter((ListAdapter) altVar);
                        arpVar.a();
                        ahf.a((Activity) aln.this.ae);
                        aln.this.d();
                        if (aln.this.as == null || aln.this.as.isEmpty()) {
                            aln.this.ap.setVisibility(0);
                        } else {
                            aln.this.ap.setVisibility(4);
                        }
                    }

                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    }
                });
            }
        }
    }

    private void an() {
        this.ai.setOnItemChosenListener(this.ay);
        this.aj.setOnItemClickListener(this.au);
        this.ak.setOnItemClickListener(this.au);
        this.aj.setOnItemChosenListener(this.ay);
        this.ak.setOnItemChosenListener(this.ay);
        this.d.setOnTabReselectedListener(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        akh akhVar = (akh) adapterView.getItemAtPosition(i);
        DashboardActivity dashboardActivity = this.ae;
        alc alcVar = new alc();
        Bundle bundle = new Bundle();
        bundle.putSerializable("artist", akhVar);
        bundle.putString("title", a(R.string.kDeezerNav_Search_Str));
        alcVar.g(bundle);
        if (ahn.a()) {
            dashboardActivity.q().a(alcVar, new arc().c(R.id.menu_container));
        } else {
            dashboardActivity.q().a(alcVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdapterView<?> adapterView, View view, int i, long j) {
        akg akgVar = (akg) adapterView.getItemAtPosition(i);
        DashboardActivity dashboardActivity = this.ae;
        ala alaVar = new ala();
        Bundle bundle = new Bundle();
        bundle.putSerializable("album", akgVar);
        bundle.putString("title", a(R.string.kDeezerNav_Search_Str));
        alaVar.g(bundle);
        if (ahn.a()) {
            dashboardActivity.q().a(alaVar, new arc().c(R.id.menu_container));
        } else {
            dashboardActivity.q().a(alaVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            this.ah.setVisibility(8);
        } else if (i == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.ah.setVisibility(8);
        } else if (i == 2) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.ah.setVisibility(0);
        }
    }
}
