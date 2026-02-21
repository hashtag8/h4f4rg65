package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import defpackage.als;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alc extends ale {
    alu a;
    private ImageView aA;
    private View aB;
    private RelativeLayout aC;
    private int aD;
    private View ah;
    private View ai;
    private View aj;
    private AnimationListView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private Button aq;
    private Button ar;
    private ImageView as;
    private RelativeLayout at;
    private TextView au;
    private View av;
    private TabPageIndicator aw;
    private View ax;
    private ImageView ay;
    private TextView az;
    amb b;
    aik c;
    private AdapterView.OnItemClickListener aE = new AdapterView.OnItemClickListener() { // from class: alc.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object item = alc.this.c.getItem(i - 1);
            if (!ahh.e(alc.this.ae)) {
                Toast.makeText(alc.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                return;
            }
            if (aof.a().l()) {
                Toast.makeText(alc.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            if (item instanceof akm) {
                if (!((akm) item).f()) {
                    Toast.makeText(alc.this.ae, R.string.kDeezer_No_Available_Str, 1).show();
                    return;
                }
                if (als.a() || !MusicPlaylistManager.a().w()) {
                    alc.this.c();
                }
                als.b((akm) item);
                alc.this.d();
                return;
            }
            if (item instanceof akg) {
                akg akgVarI = (akg) item;
                if (!akgVarI.h() && akgVarI.i() == null) {
                    Toast.makeText(alc.this.ae, R.string.kDeezer_CountryNotAvailable_Str, 0).show();
                    return;
                }
                if (akgVarI.i() != null) {
                    akgVarI = akgVarI.i();
                }
                ala alaVar = new ala();
                Bundle bundle = new Bundle();
                bundle.putSerializable("album", akgVarI);
                bundle.putString("title", alc.this.aJ);
                alaVar.g(bundle);
                if (!ahn.a()) {
                    alc.this.ae.q().a(alaVar, (arc) null);
                } else {
                    alc.this.ae.q().a(alaVar, new arc().c(R.id.menu_container));
                }
            }
        }
    };
    private ajn aF = new ajn() { // from class: alc.10
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (!ahh.e(alc.this.ae)) {
                Toast.makeText(alc.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                return;
            }
            if (aof.a().l()) {
                Toast.makeText(alc.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            if (obj instanceof akm) {
                if (!((akm) obj).f()) {
                    Toast.makeText(alc.this.ae, R.string.kDeezer_No_Available_Str, 1).show();
                    return;
                }
                if (als.a() || !MusicPlaylistManager.a().w()) {
                    alc.this.c();
                }
                als.b((akm) obj);
                alc.this.d();
                return;
            }
            if (obj instanceof akg) {
                als.a((akg) obj, alc.this.g, (als.a) null);
            }
        }
    };
    TabPageIndicator.a d = new TabPageIndicator.a() { // from class: alc.11
        @Override // com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.a
        public void a(int i) {
            alc.this.d(i);
        }
    };
    private List<akm> aG = null;
    private List<akg> aH = null;
    akh e = null;
    private boolean aI = false;
    arw f = null;
    private String aJ = null;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = layoutInflater.inflate(R.layout.fragment_deezer_artist_new, (ViewGroup) null);
        this.ah = layoutInflater.inflate(R.layout.deezer_artists_header, (ViewGroup) null);
        this.aj = layoutInflater.inflate(R.layout.similar_artist_footer, (ViewGroup) null);
        this.ak = (AnimationListView) this.ai.findViewById(R.id.artist_content_list);
        this.ak.setOffsetFooterFlag(AnimationListView.a);
        this.ak.setExpectedClassType(akm.class);
        this.c = new aik(this.ae, R.layout.explore_album_sections);
        this.a = new alu(this.ae, a(this.aH), this.aJ);
        this.b = new amb(this.ae, this.aG);
        this.aD = ahn.a((Context) this.ae).a();
        if (ahn.a()) {
            this.aD -= this.ae.getResources().getDimensionPixelOffset(R.dimen.left_menu_width);
        }
        this.c.a(a(R.string.kDeezerArtistViewController_TopTracks_Str).toUpperCase(), this.b);
        this.c.a("", this.a);
        this.ak.addHeaderView(this.ah);
        this.ak.addFooterView(this.aj);
        this.ak.setAdapter((ListAdapter) this.c);
        this.aB = this.aj.findViewById(R.id.to_similar_artists);
        this.aB.setOnClickListener(new ahl(this) { // from class: alc.1
            @Override // defpackage.ahl
            public void a(View view) {
                DashboardActivity dashboardActivity = alc.this.ae;
                alb albVar = new alb();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", alc.this.e);
                bundle2.putString("title", alc.this.aJ);
                albVar.g(bundle2);
                if (ahn.a()) {
                    dashboardActivity.q().a(albVar, new arc().c(R.id.menu_container));
                } else {
                    dashboardActivity.q().a(albVar, (arc) null);
                }
            }
        });
        this.az = (TextView) this.ah.findViewById(R.id.deezer_title);
        this.aA = (ImageView) this.ah.findViewById(R.id.deezer_back);
        this.aA.setOnClickListener(new ahl(this) { // from class: alc.6
            @Override // defpackage.ahl
            public void a(View view) {
                alc.this.ae.ag();
            }
        });
        this.ay = (ImageView) this.ah.findViewById(R.id.favourite);
        this.ay.setOnClickListener(new ahl(this) { // from class: alc.7
            @Override // defpackage.ahl
            public void a(View view) {
                if (alc.this.aI) {
                    alc.this.c(alc.this.e);
                } else {
                    alc.this.b(alc.this.e);
                }
            }
        });
        this.ay.setVisibility(0);
        this.al = (TextView) this.ah.findViewById(R.id.title);
        this.am = (TextView) this.ah.findViewById(R.id.number);
        this.ap = (TextView) this.ah.findViewById(R.id.play_radio_text);
        this.aq = (Button) this.ah.findViewById(R.id.play_radio);
        this.an = (TextView) this.ah.findViewById(R.id.title2);
        this.ao = (TextView) this.ah.findViewById(R.id.number2);
        this.ar = (Button) this.ah.findViewById(R.id.play_radio2);
        this.ax = this.ah.findViewById(R.id.land_layout);
        this.as = (ImageView) this.ah.findViewById(R.id.imageview);
        this.at = (RelativeLayout) this.ah.findViewById(R.id.rl);
        ahl ahlVar = new ahl(this) { // from class: alc.8
            @Override // defpackage.ahl
            public void a(View view) {
                if (!ahh.e(alc.this.ae)) {
                    Toast.makeText(alc.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                }
                if (aof.a().l()) {
                    Toast.makeText(alc.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                alc.this.c();
                als.a aVar = new als.a() { // from class: alc.8.1
                    @Override // als.a
                    public void a() {
                        alc.this.d();
                    }

                    @Override // als.a
                    public void a(JSONObject jSONObject) {
                        alc.this.d();
                    }
                };
                switch (view.getId()) {
                    case R.id.play_radio2 /* 2131690032 */:
                        als.a(alc.this.e, alc.this.g, aVar);
                        break;
                    case R.id.play_radio /* 2131690034 */:
                        als.a(alc.this.e, alc.this.g, aVar);
                        break;
                }
            }
        };
        this.ah.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.au = (TextView) this.ah.findViewById(R.id.textview_title);
        this.aq.setOnClickListener(ahlVar);
        this.ar.setOnClickListener(ahlVar);
        this.aC = (RelativeLayout) this.ah.findViewById(R.id.discography_layout);
        this.av = this.ai.findViewById(R.id.artist_layout);
        this.aw = (TabPageIndicator) this.ai.findViewById(R.id.indicator);
        this.aw.setTitles(new CharSequence[]{this.ae.getString(R.string.kDeezer_Album_Str), this.ae.getString(R.string.kDeezerArtistViewController_SimilarArtists_Str)});
        this.aw.setOnTabReselectedListener(this.d);
        ajo ajoVar = new ajo(this.ae, this.ak);
        ajoVar.a(this.aF);
        this.ak.setOnTouchListener(ajoVar);
        this.ak.setOnItemChosenListener(this.aF);
        this.ak.setOnItemClickListener(this.aE);
        return this.ai;
    }

    protected void d(int i) {
        switch (i) {
            case 0:
                this.aC.setVisibility(0);
                this.av.setVisibility(8);
                break;
            case 1:
                this.aC.setVisibility(8);
                this.av.setVisibility(0);
                break;
        }
    }

    private void a(final akh akhVar) {
        if (akhVar != null) {
            if (!TextUtils.isEmpty(akhVar.b())) {
                this.al.setText(akhVar.b());
                this.an.setText(akhVar.b());
                this.au.setText(akhVar.b());
                this.az.setText(this.e.b());
            }
            new ahw().a(this.as, new ahq() { // from class: alc.12
                @Override // defpackage.ahq
                public void a(View view) {
                    bif.a((Context) alc.this.ae).a("https://api.deezer.com/artist/" + akhVar.a() + "/image?size=800").a(R.drawable.default_artist).b(view.getWidth(), view.getHeight()).e().a(alc.this.as);
                }
            });
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> a(List<akg> list) {
        if (list == null || this.aG.isEmpty()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (akg akgVar : list) {
            if (akgVar != null && !TextUtils.isEmpty(akgVar.a()) && !arrayList.contains(akgVar.a())) {
                arrayList.add(akgVar.a());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            arrayList2.add(str.toUpperCase());
            for (akg akgVar2 : list) {
                if (akgVar2 != null && !TextUtils.isEmpty(akgVar2.a()) && akgVar2.a().equalsIgnoreCase(str)) {
                    arrayList2.add(akgVar2);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        aue aueVarA = agv.a(true);
        final String str = "https://api.deezer.com/artist/" + this.e.a() + "/albums?access_token=" + this.g.b() + "&limit=2147483647";
        aueVarA.a(str, new aum() { // from class: alc.13
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alc.this.a(jSONObject);
                alc.this.d();
                mm.b(str, new Object[0]);
                mm.b(jSONObject, new Object[0]);
                alc.this.aH = new qv(akg.class).a(jSONObject.toString());
                if (alc.this.aH != null && !alc.this.aH.isEmpty()) {
                    for (akg akgVar : alc.this.aH) {
                        if (akgVar != null) {
                            akgVar.a(alc.this.e);
                        }
                    }
                }
                alc.this.a.a(alc.this.a((List<akg>) alc.this.aH));
                if (alc.this.aH == null || alc.this.aH.isEmpty()) {
                    alc.this.ao.setVisibility(8);
                } else {
                    alc.this.ao.setVisibility(0);
                    alc.this.am.setText(alc.this.aH.size() + " " + alc.this.ae.getString(R.string.kDeezerCoupleScrollView_Albums_Str));
                    alc.this.ao.setText(alc.this.aH.size() + " " + alc.this.ae.getString(R.string.kDeezerCoupleScrollView_Albums_Str));
                }
                alc.this.aB.setVisibility(0);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
            }
        });
    }

    private void an() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/artists?limit=2147483647&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: alc.2
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alc.this.a(jSONObject);
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    alc.this.b(alc.this.b((List<akh>) new qv(akh.class).a(jSONObject.toString())));
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alc.this.a(i, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(List<akh> list) {
        if (list == null) {
            return false;
        }
        Iterator<akh> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a() == this.e.a()) {
                mm.b(this.e.b() + "has been favourited", new Object[0]);
                return true;
            }
        }
        mm.b(this.e.b() + "has not been favourited", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.ay.setImageResource(R.drawable.deezer_favourite_on);
        } else {
            this.ay.setImageResource(R.drawable.deezer_favourite_off);
        }
        this.aI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(akh akhVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("artist_id", akhVar.a() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/artists", new Object[0]);
        b(true);
        aueVarA.b(this.ae, "https://api.deezer.com/user/me/artists", ausVar, new aux() { // from class: alc.3
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                alc.this.b(false);
                Toast.makeText(alc.this.ae, R.string.UnableAddAlbumLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                alc.this.ae.sendStickyBroadcast(new Intent(alk.d));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(akh akhVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("artist_id", akhVar.a() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/artists", new Object[0]);
        b(false);
        aueVarA.a(this.ae, "https://api.deezer.com/user/me/artists", (Header[]) null, ausVar, new aux() { // from class: alc.4
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                alc.this.b(true);
                Toast.makeText(alc.this.ae, R.string.UnableRemoveAlbumsLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                alc.this.ae.sendStickyBroadcast(new Intent(alk.d));
            }
        });
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        this.aw.setCurrentItem(0);
        d(0);
        this.e = (akh) bundle.getSerializable("artist");
        this.aJ = bundle.getString("title");
        b();
        a(this.e);
        b(q().getConfiguration());
        an();
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aue aueVarA = agv.a(true);
        final String str = "https://api.deezer.com/artist/" + this.e.a() + "/top?access_token=" + this.g.b();
        c();
        aueVarA.a(str, new aum() { // from class: alc.5
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alc.this.a(jSONObject);
                mm.b(str, new Object[0]);
                mm.b(jSONObject, new Object[0]);
                alc.this.aG = new qv(akm.class).a(jSONObject.toString());
                alc.this.b.a(alc.this.aG);
                alc.this.am();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
            }
        });
        super.c(bundle);
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        if (TextUtils.isEmpty(this.aJ) && l() != null) {
            this.aJ = l().getString("title");
        }
        return new ajv.a().a(-13487558).a(this.aJ).c();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
    }

    private void b(Configuration configuration) {
        a(this.ah.findViewById(R.id.rl), R.style.DeezerAlbumCover);
        a(this.ah.findViewById(R.id.artist_container), R.style.DeezerAlbumCoverContainer);
        int i = ahn.a((Context) this.ae).a;
        int i2 = ahn.a((Context) this.ae).b;
        if (configuration.orientation == 2) {
            a(this.ah.findViewById(R.id.imageview), R.style.DeezerAlbumCover);
            this.ax.setVisibility(0);
            this.ap.setVisibility(8);
            this.aq.setVisibility(8);
            this.al.setVisibility(4);
            this.am.setVisibility(4);
            return;
        }
        if (configuration.orientation == 1) {
            this.as.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.aD));
            this.ax.setVisibility(8);
            this.ap.setVisibility(0);
            this.aq.setVisibility(0);
            this.al.setVisibility(0);
            this.am.setVisibility(0);
        }
    }

    private void a(View view, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.ae.obtainStyledAttributes(i, new int[]{android.R.attr.layout_width, android.R.attr.layout_height});
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(0, 0);
        int layoutDimension2 = typedArrayObtainStyledAttributes.getLayoutDimension(1, 0);
        view.getLayoutParams().width = layoutDimension;
        view.getLayoutParams().height = layoutDimension2;
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName() + "#" + System.identityHashCode(this);
    }
}
