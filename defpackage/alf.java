package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import defpackage.als;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alf extends ale {
    private TextView ah;
    private ImageView ai;
    private View aj;
    private ListView ak;
    private View al;
    private View am;
    private AnimationListView an;
    private View ao;
    private AnimationListView ap;
    private View aq;
    private AnimationListView ar;
    private View as;
    private AnimationListView at;
    private View au;
    private String aw;
    private View e;
    private TabPageIndicator f;
    private qn av = new a();
    TabPageIndicator.a a = new TabPageIndicator.a() { // from class: alf.1
        @Override // com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.a
        public void a(int i) {
            alf.this.d(i);
        }
    };
    View.OnClickListener b = new ahl(this) { // from class: alf.2
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.genres_tv_layout /* 2131690173 */:
                    if (alf.this.al.getVisibility() == 0) {
                        alf.this.al.setVisibility(8);
                        alf.this.au.setVisibility(0);
                        alf.this.ai.setImageResource(R.drawable.drop_down_list);
                    } else {
                        alf.this.al.setVisibility(0);
                        alf.this.au.setVisibility(8);
                        alf.this.ai.setImageResource(R.drawable.drop_up_list);
                    }
                    break;
            }
        }
    };
    ajn c = new ajn() { // from class: alf.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                if (obj instanceof akg) {
                    als.a((akg) obj, alf.this.g, (als.a) null);
                    return;
                }
                if (obj instanceof akh) {
                    als.b((akh) obj, alf.this.g, null);
                } else if (obj instanceof akj) {
                    als.a((akj) obj, alf.this.g, (als.a) null);
                } else if (obj instanceof akm) {
                    alf.this.a((akm) obj);
                }
            }
        }
    };
    AdapterView.OnItemClickListener d = new AdapterView.OnItemClickListener() { // from class: alf.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (adapterView.getId()) {
                case R.id.tracks_listview /* 2131689758 */:
                    alf.this.a((akm) adapterView.getItemAtPosition(i));
                    break;
                case R.id.albums_listview /* 2131690177 */:
                    alf.this.a(adapterView, view, i, j);
                    break;
                case R.id.artists_listview /* 2131690178 */:
                    alf.this.b(adapterView, view, i, j);
                    break;
                case R.id.playlist_listview /* 2131690180 */:
                    alf.this.c(adapterView, view, i, j);
                    break;
                case R.id.genres_listview /* 2131690181 */:
                    alf.this.d(adapterView, view, i, j);
                    break;
            }
        }
    };

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.fragment_deezer_charts, (ViewGroup) null);
        am();
        an();
        return this.e;
    }

    private void am() {
        this.f = (TabPageIndicator) this.e.findViewById(R.id.indicator);
        this.ah = (TextView) this.e.findViewById(R.id.genres_tv);
        this.ai = (ImageView) this.e.findViewById(R.id.genres_imageview);
        this.aj = this.e.findViewById(R.id.genres_tv_layout);
        this.ak = (ListView) this.e.findViewById(R.id.genres_listview);
        this.al = this.e.findViewById(R.id.genres);
        this.am = this.e.findViewById(R.id.tracks);
        this.an = (AnimationListView) this.e.findViewById(R.id.tracks_listview);
        this.ao = this.e.findViewById(R.id.albums);
        this.ap = (AnimationListView) this.e.findViewById(R.id.albums_listview);
        this.aq = this.e.findViewById(R.id.artists);
        this.ar = (AnimationListView) this.e.findViewById(R.id.artists_listview);
        this.as = this.e.findViewById(R.id.playlist);
        this.at = (AnimationListView) this.e.findViewById(R.id.playlist_listview);
        this.au = this.e.findViewById(R.id.data_layout);
        this.f.setTitles(new CharSequence[]{a(R.string.kDeezerCoupleScrollView_Tracks_Str), a(R.string.kDeezerCoupleScrollView_Albums_Str), a(R.string.kDeezerCoupleScrollView_Artists_Str), a(R.string.kDeezerCoupleScrollView_Playlists)});
        this.aw = a(R.string.kDeezerNav_Charts_Str);
    }

    private void an() {
        this.f.setOnTabReselectedListener(this.a);
        this.aj.setOnClickListener(this.b);
        this.ak.setOnItemClickListener(this.d);
        this.an.setOnItemClickListener(this.d);
        this.ap.setOnItemClickListener(this.d);
        this.ar.setOnItemClickListener(this.d);
        this.at.setOnItemClickListener(this.d);
        this.an.setOnItemChosenListener(this.c);
        this.ap.setOnItemChosenListener(this.c);
        this.ar.setOnItemChosenListener(this.c);
        this.at.setOnItemChosenListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(akm akmVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        if (aof.a().l()) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else if (!akmVar.f()) {
            Toast.makeText(this.ae, R.string.kDeezer_No_Available_Str, 1).show();
        } else {
            als.b(akmVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        akg akgVar = (akg) adapterView.getItemAtPosition(i);
        ala alaVar = new ala();
        Bundle bundle = new Bundle();
        bundle.putSerializable("album", akgVar);
        bundle.putString("title", a(R.string.kDeezerNav_Charts_Str));
        alaVar.g(bundle);
        if (ahn.a()) {
            this.ae.q().a(alaVar, new arc().c(R.id.menu_container));
        } else {
            this.ae.q().a(alaVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdapterView<?> adapterView, View view, int i, long j) {
        akh akhVar = (akh) adapterView.getItemAtPosition(i);
        alc alcVar = new alc();
        Bundle bundle = new Bundle();
        bundle.putSerializable("artist", akhVar);
        bundle.putString("title", a(R.string.kDeezerNav_Charts_Str));
        alcVar.g(bundle);
        if (ahn.a()) {
            this.ae.q().a(alcVar, new arc().c(R.id.menu_container));
        } else {
            this.ae.q().a(alcVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdapterView<?> adapterView, View view, int i, long j) {
        akj akjVar = (akj) adapterView.getItemAtPosition(i);
        DashboardActivity dashboardActivity = this.ae;
        all allVar = new all();
        Bundle bundle = new Bundle();
        bundle.putSerializable("playlist", akjVar);
        bundle.putString("title", a(R.string.kDeezerNav_Charts_Str));
        allVar.g(bundle);
        if (ahn.a()) {
            dashboardActivity.q().a(allVar, new arc().c(R.id.menu_container));
        } else {
            dashboardActivity.q().a(allVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdapterView<?> adapterView, View view, int i, long j) {
        a((aki) adapterView.getItemAtPosition(i));
        ((alx) adapterView.getAdapter()).a(i);
        this.al.setVisibility(8);
        this.au.setVisibility(0);
        this.ai.setImageResource(R.drawable.drop_down_list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        switch (i) {
            case 0:
                this.am.setVisibility(0);
                this.ao.setVisibility(8);
                this.aq.setVisibility(8);
                this.as.setVisibility(8);
                break;
            case 1:
                this.am.setVisibility(8);
                this.ao.setVisibility(0);
                this.aq.setVisibility(8);
                this.as.setVisibility(8);
                break;
            case 2:
                this.am.setVisibility(8);
                this.ao.setVisibility(8);
                this.aq.setVisibility(0);
                this.as.setVisibility(8);
                break;
            case 3:
                this.am.setVisibility(8);
                this.ao.setVisibility(8);
                this.aq.setVisibility(8);
                this.as.setVisibility(0);
                break;
        }
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        if (alg.a == null) {
            ao();
        } else {
            this.ak.setAdapter((ListAdapter) new alx(this.ae, alg.a));
            if (alg.a != null && !alg.a.isEmpty()) {
                a(alg.a.get(0));
            }
        }
        super.c(bundle);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    private void ao() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            new aky(this.ae, this.g, this.av).execute(new ql("genre"));
        }
    }

    class a implements qn {
        private a() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                alg.a = new qv(aki.class).a(str);
                alf.this.ak.setAdapter((ListAdapter) new alx(alf.this.ae, alg.a));
                if (alg.a != null && !alg.a.isEmpty()) {
                    alf.this.a(alg.a.get(0));
                }
            } catch (IllegalStateException e) {
            }
        }

        @Override // defpackage.qn
        public void a(IOException iOException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(MalformedURLException malformedURLException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qm qmVar, Object obj) {
            alf.this.al();
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aki akiVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        this.ah.setText(akiVar.b());
        aue aueVarA = agv.a(true);
        String str = "https://api.deezer.com/editorial/" + akiVar.a() + "/charts?access_token=" + this.g.b() + "&limit=300";
        mm.b(str, new Object[0]);
        c();
        aueVarA.a(str, new aum() { // from class: alf.5
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alf.this.a(jSONObject);
                alf.this.d();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("tracks");
                    JSONObject jSONObject3 = jSONObject.getJSONObject("albums");
                    JSONObject jSONObject4 = jSONObject.getJSONObject("artists");
                    JSONObject jSONObject5 = jSONObject.getJSONObject("playlists");
                    alf.this.an.setAdapter((ListAdapter) new amc(alf.this.ae, new qv(akm.class).a(jSONObject2.toString())));
                    alt altVar = new alt(alf.this.ae, new qv(akg.class).a(jSONObject3.toString()), alf.this.aw, alf.this.g);
                    arp arpVar = new arp(alf.this.ap);
                    alf.this.ap.setAdapter((ListAdapter) altVar);
                    arpVar.a();
                    alv alvVar = new alv(alf.this.ae, new qv(akh.class).a(jSONObject4.toString()));
                    arp arpVar2 = new arp(alf.this.ar);
                    alf.this.ar.setAdapter((ListAdapter) alvVar);
                    arpVar2.a();
                    aly alyVar = new aly(alf.this.ae, new qv(akj.class).a(jSONObject5.toString()), alf.this.g);
                    arp arpVar3 = new arp(alf.this.at);
                    alf.this.at.setAdapter((ListAdapter) alyVar);
                    arpVar3.a();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alf.this.d();
                alf.this.a(i, jSONObject);
            }
        });
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(-13487558).a(q().getString(R.string.kDeezerNav_Charts_Str)).c();
    }
}
