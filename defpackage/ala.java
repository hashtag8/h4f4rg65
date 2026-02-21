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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ala extends ale {
    private TextView aA;
    private ImageView aB;
    private amb aC;
    private int aD;
    private View ah;
    private View ai;
    private ImageView aj;
    private ImageView ak;
    private AnimationListView al;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private View ar;
    private View as;
    private View at;
    private TextView au;
    private Button av;
    private Button aw;
    private View ax;
    private View ay;
    private ImageView az;
    private qn am = new a();
    ArrayList<MusicData> a = new ArrayList<>();
    ahl b = new ahl(this) { // from class: ala.5
        @Override // defpackage.ahl
        public void a(View view) {
            if (!ahh.e(ala.this.ae)) {
                Toast.makeText(ala.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            } else if (aof.a().l()) {
                Toast.makeText(ala.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                als.a(ala.this.e);
            }
        }
    };
    private ajn aE = new ajn() { // from class: ala.6
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                if (!ahh.e(ala.this.ae)) {
                    Toast.makeText(ala.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(ala.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else {
                    if (!((akm) obj).f()) {
                        Toast.makeText(ala.this.ae, R.string.kDeezer_No_Available_Str, 1).show();
                        return;
                    }
                    ala.this.c();
                    als.a(ala.this.e, i - 1);
                    ala.this.d();
                }
            }
        }
    };
    akg c = null;
    private String aF = null;
    private boolean aG = false;
    arw d = null;
    List<akm> e = null;
    List<akm> f = null;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = layoutInflater.inflate(R.layout.fragment_deezer_album, (ViewGroup) null);
        this.ah = layoutInflater.inflate(R.layout.fragment_deezer_album_header, (ViewGroup) null);
        this.aj = (ImageView) this.ah.findViewById(R.id.album);
        this.al = (AnimationListView) this.ai.findViewById(R.id.trackList);
        this.aC = new amb(this.ae, this.e, this.aj);
        this.al.addHeaderView(this.ah);
        this.al.setAdapter((ListAdapter) this.aC);
        this.aA = (TextView) this.ah.findViewById(R.id.deezer_title);
        this.aB = (ImageView) this.ah.findViewById(R.id.deezer_back);
        this.aB.setOnClickListener(new ahl(this) { // from class: ala.1
            @Override // defpackage.ahl
            public void a(View view) {
                ala.this.ae.ag();
            }
        });
        this.aD = ahn.b(this.ae);
        this.ak = (ImageView) this.ah.findViewById(R.id.artist);
        ajo ajoVar = new ajo(this.ae, this.al);
        ajoVar.a(this.aE);
        this.al.setOnItemChosenListener(this.aE);
        this.al.setOnTouchListener(ajoVar);
        float dimension = this.ae.getResources().getDimension(R.dimen.left_menu_width);
        if (ahn.a()) {
            this.al.setLeftMargin((int) dimension);
        }
        this.an = (TextView) this.ah.findViewById(R.id.title);
        this.ap = (TextView) this.ah.findViewById(R.id.artist_name);
        this.ar = this.ah.findViewById(R.id.land_layout);
        this.ao = (TextView) this.ah.findViewById(R.id.title2);
        this.aq = (TextView) this.ah.findViewById(R.id.artist_name2);
        this.as = this.ah.findViewById(R.id.port_layout);
        this.av = (Button) this.ah.findViewById(R.id.play_radio);
        this.aw = (Button) this.ah.findViewById(R.id.play_radio2);
        this.au = (TextView) this.ah.findViewById(R.id.play_radio_text2);
        this.at = this.ah.findViewById(R.id.play_radio_layout);
        this.ay = this.ah.findViewById(R.id.shuffle_land);
        this.ax = this.ah.findViewById(R.id.shuffle_port);
        this.az = (ImageView) this.ah.findViewById(R.id.favourite);
        this.az.setOnClickListener(new ahl(this) { // from class: ala.3
            @Override // defpackage.ahl
            public void a(View view) {
                if (ala.this.aG) {
                    ala.this.b(ala.this.c);
                } else {
                    ala.this.a(ala.this.c);
                }
            }
        });
        this.az.setVisibility(0);
        this.av.setOnClickListener(this.b);
        this.aw.setOnClickListener(this.b);
        this.ax.setOnClickListener(this.b);
        this.ay.setOnClickListener(this.b);
        this.ak.setOnClickListener(new ahl(this) { // from class: ala.4
            @Override // defpackage.ahl
            public void a(View view) {
                if (ala.this.c != null && ala.this.c.f() != null) {
                    akh akhVarF = ala.this.c.f();
                    alc alcVar = new alc();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("artist", akhVarF);
                    bundle2.putString("title", ala.this.aF);
                    alcVar.g(bundle2);
                    if (!ahn.a()) {
                        ala.this.ae.q().a(alcVar, (arc) null);
                    } else {
                        ala.this.ae.q().a(alcVar, new arc().c(R.id.menu_container));
                    }
                }
            }
        });
        return this.ai;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        this.c = (akg) bundle.getSerializable("album");
        this.aF = bundle.getString("title");
        if (this.c != null && !TextUtils.isEmpty(this.c.c())) {
            this.an.setText(this.c.c());
            this.ao.setText(this.c.c());
            this.aA.setText(this.c.c());
        }
        if (this.c != null && this.c.f() != null && !TextUtils.isEmpty(this.c.f().b())) {
            this.ap.setText(this.c.f().b());
            this.aq.setText(this.c.f().b());
        }
        b(q().getConfiguration());
        this.az.setVisibility(0);
        am();
        c(this.c);
        new ahw().a(this.aj, new ahq() { // from class: ala.7
            @Override // defpackage.ahq
            public void a(View view) {
                bif.a((Context) ala.this.ae).a(ala.this.c.e() + "?size=800").a(R.drawable.empty_no_cover_art).b(view.getWidth(), view.getHeight()).e().a(ala.this.aj);
            }
        });
        new ahw().a(this.ak, new ahq() { // from class: ala.8
            @Override // defpackage.ahq
            public void a(View view) {
                bif.a((Context) ala.this.ae).a("https://api.deezer.com/artist/" + ala.this.c.f().a() + "/image?size=800").a(R.drawable.default_artist).b(view.getWidth(), view.getHeight()).e().a(ala.this.ak);
            }
        });
        super.c(bundle);
    }

    private void am() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/albums?limit=2147483647&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ala.9
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    ala.this.b(ala.this.a((List<akg>) new qv(akg.class).a(jSONObject.toString())));
                    ala.this.a(jSONObject);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                ala.this.a(i, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<akg> list) {
        if (list == null) {
            return false;
        }
        Iterator<akg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b() == this.c.b()) {
                mm.b(this.c.c() + "has been favourited", new Object[0]);
                return true;
            }
        }
        mm.b(this.c.c() + "has not been favourited", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.az.setImageResource(R.drawable.deezer_favourite_on);
        } else {
            this.az.setImageResource(R.drawable.deezer_favourite_off);
        }
        this.aG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(akg akgVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("album_id", akgVar.b() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/albums", new Object[0]);
        b(true);
        aueVarA.b(this.ae, "https://api.deezer.com/user/me/albums", ausVar, new aux() { // from class: ala.10
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                ala.this.b(false);
                Toast.makeText(ala.this.ae, R.string.UnableAddAlbumLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                ala.this.ae.sendStickyBroadcast(new Intent(alk.c));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(akg akgVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("album_id", akgVar.b() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/albums", new Object[0]);
        b(false);
        aueVarA.a(this.ae, "https://api.deezer.com/user/me/albums", (Header[]) null, ausVar, new aux() { // from class: ala.2
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                ala.this.b(true);
                Toast.makeText(ala.this.ae, R.string.UnableRemoveAlbumsLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                ala.this.ae.sendStickyBroadcast(new Intent(alk.c));
            }
        });
    }

    private void c(akg akgVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            new aky(this.ae, this.g, this.am).execute(new ql("album/" + akgVar.b() + "/tracks"));
        }
    }

    class a implements qn {
        private a() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                ala.this.e = new qv(akm.class).a(str);
                Iterator<akm> it = ala.this.e.iterator();
                while (it.hasNext()) {
                    it.next().a(ala.this.c);
                }
                ala.this.aC.a(ala.this.e);
                ala.this.al.setVisibility(0);
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
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        if (TextUtils.isEmpty(this.aF) && l() != null) {
            this.aF = l().getString("title");
        }
        return new ajv.a().a(-13487558).a(this.aF).c();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
    }

    private void b(Configuration configuration) {
        a(this.ah.findViewById(R.id.rl), R.style.DeezerAlbumCover);
        a(this.ah.findViewById(R.id.album_container), R.style.DeezerAlbumCoverContainer);
        if (configuration.orientation == 2) {
            a(this.ah.findViewById(R.id.album), R.style.DeezerAlbumCover);
            this.ar.setVisibility(0);
            this.as.setVisibility(8);
            this.at.setVisibility(8);
            this.aw.setVisibility(8);
            this.au.setVisibility(8);
            this.ay.setVisibility(0);
            this.ax.setVisibility(8);
            return;
        }
        if (configuration.orientation == 1) {
            this.aj.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.aD));
            this.ar.setVisibility(8);
            this.as.setVisibility(0);
            this.at.setVisibility(8);
            this.aw.setVisibility(8);
            this.au.setVisibility(8);
            this.ay.setVisibility(8);
            this.ax.setVisibility(0);
        }
    }

    private void a(View view, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.ae.obtainStyledAttributes(i, new int[]{android.R.attr.layout_width, android.R.attr.layout_height});
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(0, 0);
        int layoutDimension2 = typedArrayObtainStyledAttributes.getLayoutDimension(1, 0);
        view.getLayoutParams().width = layoutDimension;
        view.getLayoutParams().height = layoutDimension2;
    }
}
