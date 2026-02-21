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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alm extends ale {
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
    private View e;
    private TabPageIndicator f;
    private qn ar = new a();
    TabPageIndicator.a a = new TabPageIndicator.a() { // from class: alm.1
        @Override // com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.a
        public void a(int i) {
            alm.this.d(i);
        }
    };
    View.OnClickListener b = new ahl(this) { // from class: alm.2
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.genres_tv_layout /* 2131690173 */:
                    if (alm.this.al.getVisibility() == 0) {
                        alm.this.al.setVisibility(8);
                        alm.this.aq.setVisibility(0);
                        alm.this.ai.setImageResource(R.drawable.drop_down_list);
                    } else {
                        alm.this.al.setVisibility(0);
                        alm.this.aq.setVisibility(8);
                        alm.this.ai.setImageResource(R.drawable.drop_up_list);
                    }
                    break;
            }
        }
    };
    ajn c = new ajn() { // from class: alm.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                if (!ahh.e(alm.this.ae)) {
                    Toast.makeText(alm.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(alm.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else if (obj instanceof akk) {
                    als.a((akk) obj, alm.this.g, alm.this.as);
                } else if (obj instanceof akh) {
                    als.a((akh) obj, alm.this.g, alm.this.as);
                }
            }
        }
    };
    private als.a as = new als.a() { // from class: alm.4
        @Override // als.a
        public void a() {
        }

        @Override // als.a
        public void a(JSONObject jSONObject) {
            alm.this.a(jSONObject);
        }
    };
    AdapterView.OnItemClickListener d = new AdapterView.OnItemClickListener() { // from class: alm.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (adapterView.getId()) {
                case R.id.artists_listview /* 2131690178 */:
                    alm.this.a(adapterView, view, i, j);
                    break;
                case R.id.genres_listview /* 2131690181 */:
                    alm.this.b(adapterView, view, i, j);
                    break;
            }
        }
    };

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.fragment_deezer_radio_new, (ViewGroup) null);
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
        this.ao = this.e.findViewById(R.id.artists);
        this.ap = (AnimationListView) this.e.findViewById(R.id.artists_listview);
        this.aq = this.e.findViewById(R.id.data_layout);
        this.f.setTitles(new CharSequence[]{a(R.string.kDeezer_Themed_radio_channels_Str), a(R.string.kDeezer_Artist_radio_channels_Str)});
    }

    private void an() {
        this.f.setOnTabReselectedListener(this.a);
        this.aj.setOnClickListener(this.b);
        this.ak.setOnItemClickListener(this.d);
        this.an.setOnItemChosenListener(this.c);
        this.ap.setOnItemChosenListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        akh akhVar = (akh) adapterView.getItemAtPosition(i);
        DashboardActivity dashboardActivity = this.ae;
        alc alcVar = new alc();
        Bundle bundle = new Bundle();
        bundle.putSerializable("artist", akhVar);
        bundle.putString("title", a(R.string.kDeezerNav_RadioChannels_Str));
        alcVar.g(bundle);
        if (ahn.a()) {
            dashboardActivity.q().a(alcVar, new arc().c(R.id.menu_container));
        } else {
            dashboardActivity.q().a(alcVar, (arc) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdapterView<?> adapterView, View view, int i, long j) {
        a((aki) adapterView.getItemAtPosition(i));
        ((alx) adapterView.getAdapter()).a(i);
        this.al.setVisibility(8);
        this.aq.setVisibility(0);
        this.ai.setImageResource(R.drawable.drop_down_list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        switch (i) {
            case 0:
                this.am.setVisibility(0);
                this.ao.setVisibility(8);
                break;
            case 1:
                this.am.setVisibility(8);
                this.ao.setVisibility(0);
                break;
        }
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
            new aky(this.ae, this.g, this.ar).execute(new ql("genre"));
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
                alm.this.ak.setAdapter((ListAdapter) new alx(alm.this.ae, alg.a));
                if (alg.a != null && !alg.a.isEmpty()) {
                    alm.this.a(alg.a.get(0));
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
            alm.this.al();
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
        c();
        this.ah.setText(akiVar.b());
        final String str = "https://api.deezer.com/genre/" + akiVar.a() + "/radios?limit=2147483647&access_token=" + this.g.b();
        agv.a(true).a(str, new aum() { // from class: alm.6
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alm.this.a(jSONObject);
                mm.b(str, new Object[0]);
                mm.b(jSONObject, new Object[0]);
                alm.this.an.setAdapter((ListAdapter) new ama(alm.this.ae, new qv(akk.class).a(jSONObject.toString())));
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alm.this.a(i, jSONObject);
            }
        });
        final String str2 = "https://api.deezer.com/genre/" + akiVar.a() + "/artists?limit=2147483647&access_token=" + this.g.b();
        agv.a(true).a(str2, new aum() { // from class: alm.7
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alm.this.a(jSONObject);
                alm.this.d();
                mm.b(str2, new Object[0]);
                mm.b(jSONObject, new Object[0]);
                alv alvVar = new alv(alm.this.ae, new qv(akh.class).a(jSONObject.toString()));
                arp arpVar = new arp(alm.this.ap);
                alm.this.ap.setAdapter((ListAdapter) alvVar);
                arpVar.a();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alm.this.a(i, jSONObject);
            }
        });
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

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(-13487558).g(R.string.kDeezerNav_RadioChannels_Str).c();
    }
}
