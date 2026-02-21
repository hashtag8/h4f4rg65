package defpackage;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.age;
import defpackage.ajv;
import defpackage.als;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alk extends ale {
    public static String b = "ACTION_CHANGE_TRACK";
    public static String c = "ACTION_CHANGE_ALBUM";
    public static String d = "ACTION_CHANGE_ARTIST";
    public static String e = "ACTION_CHANGE_PLAYLIST";
    private qn aA;
    private qn aB;
    private qn aC;
    private qn aD;
    private View ah;
    private View aj;
    private View ak;
    private View al;
    private View am;
    private AnimationListView an;
    private AnimationListView ao;
    private AnimationListView ap;
    private AnimationListView aq;
    private AnimationListView ar;
    private TextView as;
    private List<akj> at;
    private List<akg> au;
    private List<akh> av;
    private List<akm> aw;
    private View ax;
    private ProgressDialog az;
    private TabPageIndicator ai = null;
    ajn a = new ajn() { // from class: alk.10
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                if (!ahh.e(alk.this.ae)) {
                    Toast.makeText(alk.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(alk.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                if (obj instanceof akg) {
                    als.a((akg) obj, alk.this.g, alk.this.ay);
                    return;
                }
                if (obj instanceof akh) {
                    als.b((akh) obj, alk.this.g, alk.this.ay);
                } else if (obj instanceof akj) {
                    als.a((akj) obj, alk.this.g, alk.this.ay);
                } else if (obj instanceof akm) {
                    als.b((akm) obj);
                }
            }
        }
    };
    private als.a ay = new als.a() { // from class: alk.11
        @Override // als.a
        public void a() {
        }

        @Override // als.a
        public void a(JSONObject jSONObject) {
            alk.this.a(jSONObject);
        }
    };
    private AdapterView.OnItemLongClickListener aE = new AdapterView.OnItemLongClickListener() { // from class: alk.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            akg akgVar = (akg) adapterView.getItemAtPosition(i);
            String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/albums";
            aus ausVar = new aus();
            ausVar.a("album_id", akgVar.b());
            ausVar.a("access_token", alk.this.g.b());
            aue aueVarA = agv.a(true);
            alk.this.c();
            mm.b(str, new Object[0]);
            aueVarA.a(alk.this.ae, str, (Header[]) null, ausVar, new aum() { // from class: alk.2.1
                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                    alk.this.a(jSONObject);
                    mm.b("onSuccess() statusCode = " + i2 + ", response = " + jSONObject.toString(), new Object[0]);
                    alk.this.d();
                }

                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    alk.this.d();
                    alk.this.a(i2, jSONObject);
                }
            });
            return true;
        }
    };
    BroadcastReceiver f = new BroadcastReceiver() { // from class: alk.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            mm.b("收到改变my lib改变的广播  " + action, new Object[0]);
            if (alk.b.equals(action)) {
                alk.this.m(false);
                return;
            }
            if (alk.c.equals(action)) {
                alk.this.c(false);
            } else if (alk.d.equals(action)) {
                alk.this.l(false);
            } else if (alk.e.equals(action)) {
                alk.this.b(false);
            }
        }
    };
    private View.OnClickListener aF = new View.OnClickListener() { // from class: alk.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof akj) {
                final akj akjVar = (akj) tag;
                als.a(alk.this.ae, new asi() { // from class: alk.4.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        alk.this.a(akjVar, alk.this.g, i);
                    }
                });
            }
        }
    };

    public alk() {
        this.aA = new c();
        this.aB = new a();
        this.aC = new b();
        this.aD = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            this.aj.setVisibility(0);
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
            this.am.setVisibility(8);
            if (this.at == null || this.at.isEmpty()) {
                b(true);
                return;
            }
            return;
        }
        if (i == 1) {
            this.aj.setVisibility(8);
            this.ak.setVisibility(0);
            this.al.setVisibility(8);
            this.am.setVisibility(8);
            if (this.au == null || this.au.isEmpty()) {
                c(true);
                return;
            }
            return;
        }
        if (i == 2) {
            this.aj.setVisibility(8);
            this.ak.setVisibility(8);
            this.al.setVisibility(0);
            this.am.setVisibility(8);
            if (this.av == null || this.av.isEmpty()) {
                l(true);
                return;
            }
            return;
        }
        if (i == 3) {
            this.aj.setVisibility(8);
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
            this.am.setVisibility(0);
            if (this.aw == null || this.aw.isEmpty()) {
                m(true);
            }
        }
    }

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ah = layoutInflater.inflate(R.layout.fragment_deezer_my_library, (ViewGroup) null);
        this.ai = (TabPageIndicator) this.ah.findViewById(R.id.indicator);
        this.ai.setTitles(new CharSequence[]{a(R.string.kDeezerNav_Playlists_Str), a(R.string.kDeezerNav_Albums_Str), a(R.string.kDeezerCoupleScrollView_Artists_Str), a(R.string.kDeezerCoupleScrollView_My_MP3s)});
        this.ai.setOnTabReselectedListener(new TabPageIndicator.a() { // from class: alk.1
            @Override // com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.a
            public void a(int i) {
                alk.this.d(i);
            }
        });
        this.ax = this.ah.findViewById(R.id.mp3s_empty);
        this.aj = this.ah.findViewById(R.id.playlist);
        this.ak = this.ah.findViewById(R.id.albums);
        this.an = (AnimationListView) this.ah.findViewById(R.id.playlist_listview);
        this.ap = (AnimationListView) this.ah.findViewById(R.id.friend_playlist_listview);
        this.ao = (AnimationListView) this.ah.findViewById(R.id.albums_listview);
        this.as = (TextView) this.ah.findViewById(R.id.playlist_tv);
        this.al = this.ah.findViewById(R.id.artists);
        this.aq = (AnimationListView) this.ah.findViewById(R.id.artists_listview);
        this.am = this.ah.findViewById(R.id.mp3s);
        this.ar = (AnimationListView) this.ah.findViewById(R.id.mp3s_listview);
        this.ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alk.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                akg akgVar = (akg) adapterView.getItemAtPosition(i);
                DashboardActivity dashboardActivity = alk.this.ae;
                ala alaVar = new ala();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("album", akgVar);
                bundle2.putString("title", alk.this.a(R.string.kDeezerNav_MyLibrary_Str));
                alaVar.g(bundle2);
                if (ahn.a()) {
                    dashboardActivity.q().a(alaVar, new arc().c(R.id.menu_container));
                } else {
                    dashboardActivity.q().a(alaVar, (arc) null);
                }
            }
        });
        this.an.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alk.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object itemAtPosition = adapterView.getItemAtPosition(i);
                if (itemAtPosition instanceof akj) {
                    DashboardActivity dashboardActivity = alk.this.ae;
                    all allVar = new all();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("playlist", (akj) itemAtPosition);
                    bundle2.putString("title", alk.this.a(R.string.kDeezerNav_MyLibrary_Str));
                    mm.b("deezer test click location is = ", Integer.valueOf(i));
                    if (i == 1) {
                        mm.b("alan test", "set boolean for isLovedTracks");
                        bundle2.putBoolean("isLovedTracks", true);
                        bundle2.putBoolean("isLovedTracksFirstLoad", true);
                    }
                    allVar.g(bundle2);
                    if (ahn.a()) {
                        dashboardActivity.q().a(allVar, new arc().c(R.id.menu_container));
                    } else {
                        dashboardActivity.q().a(allVar, (arc) null);
                    }
                }
            }
        });
        this.ap.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alk.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                akj akjVar = (akj) adapterView.getItemAtPosition(i);
                DashboardActivity dashboardActivity = alk.this.ae;
                all allVar = new all();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("playlist", akjVar);
                bundle2.putString("title", alk.this.a(R.string.kDeezerNav_MyLibrary_Str));
                allVar.g(bundle2);
                if (ahn.a()) {
                    dashboardActivity.q().a(allVar, new arc().c(R.id.menu_container));
                } else {
                    dashboardActivity.q().a(allVar, (arc) null);
                }
            }
        });
        this.aq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alk.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                akh akhVar = (akh) adapterView.getItemAtPosition(i);
                DashboardActivity dashboardActivity = alk.this.ae;
                alc alcVar = new alc();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", akhVar);
                bundle2.putString("title", alk.this.a(R.string.kDeezerNav_MyLibrary_Str));
                alcVar.g(bundle2);
                if (ahn.a()) {
                    dashboardActivity.q().a(alcVar, new arc().c(R.id.menu_container));
                } else {
                    dashboardActivity.q().a(alcVar, (arc) null);
                }
            }
        });
        this.ao.setOnItemChosenListener(this.a);
        this.an.setOnItemChosenListener(this.a);
        this.aq.setOnItemChosenListener(this.a);
        this.ar.setOnItemChosenListener(this.a);
        return this.ah;
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        a(z);
        String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/playlists?limit=2147483647&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: alk.12
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                akj akjVar;
                try {
                    alk.this.d();
                    alk.this.at = new qv(akj.class).a(jSONObject.toString().replaceAll("creator", "user"));
                    if (alk.this.at == null) {
                        mm.c("listPlaylist is null, response=" + jSONObject.toString(), new Object[0]);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    String strD = aho.d("user_name");
                    for (akj akjVar2 : alk.this.at) {
                        if (strD.equals(akjVar2.b().c())) {
                            arrayList.add(akjVar2);
                        } else {
                            arrayList2.add(akjVar2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            akjVar = null;
                            break;
                        }
                        akjVar = (akj) it.next();
                        if (akjVar.a()) {
                            arrayList3.add(akjVar);
                            break;
                        }
                    }
                    arrayList.remove(akjVar);
                    arrayList3.addAll(arrayList);
                    if (arrayList3 != null && !arrayList3.isEmpty()) {
                        alz alzVar = new alz(arrayList3, arrayList2, alk.this.ae, alk.this.aF);
                        arp arpVar = new arp(alk.this.an);
                        alk.this.an.setAdapter((ListAdapter) alzVar);
                        arpVar.a();
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alk.this.a(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            new aky(this.ae, this.g, this.aB, z).execute(new ql("user/" + aho.d("user_id") + "/albums?limit=2147483647"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            new aky(this.ae, this.g, this.aC, z).execute(new ql("user/" + aho.d("user_id") + "/artists?limit=2147483647"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z) {
        if (z) {
            am();
        }
        String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/personal_songs?limit=2147483647&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: alk.13
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alk.this.a(jSONObject);
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    alk.this.aw = new qv(akm.class).a(jSONObject.toString());
                    alk.this.ar.setAdapter((ListAdapter) new amb(alk.this.ae, alk.this.aw));
                    if (alk.this.aw == null || alk.this.aw.isEmpty()) {
                        alk.this.ax.setVisibility(0);
                    } else {
                        alk.this.ax.setVisibility(8);
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
                alk.this.an();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alk.this.an();
                alk.this.a(i, jSONObject);
            }
        });
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        int i = bundle.getInt("index");
        if (this.at != null) {
            this.at.clear();
        }
        if (this.au != null) {
            this.au.clear();
        }
        if (this.av != null) {
            this.av.clear();
        }
        if (this.aw != null) {
            this.aw.clear();
        }
        d(i);
        this.ai.setCurrentItem(i);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    public void am() {
        if (this.az == null) {
            this.az = new ProgressDialog(this.ae);
            this.az.setCancelable(false);
            this.az.setMessage(this.ae.getString(R.string.kAndroid_Loading));
        }
        if (!this.az.isShowing()) {
            this.az.show();
        }
    }

    public void an() {
        if (this.az != null && this.az.isShowing()) {
            this.az.dismiss();
            this.az = null;
        }
    }

    class c extends akz {
        private c() {
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(String str, Object obj) {
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(qm qmVar, Object obj) {
            alk.this.al();
        }
    }

    class a extends akz {
        private a() {
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(String str, Object obj) {
            try {
                alk.this.au = new qv(akg.class).a(str.toString());
                alt altVar = new alt(alk.this.ae, alk.this.au, alk.this.a(R.string.kDeezerNav_MyLibrary_Str), alk.this.g);
                arp arpVar = new arp(alk.this.ao);
                alk.this.ao.setAdapter((ListAdapter) altVar);
                arpVar.a();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(qm qmVar, Object obj) {
            alk.this.al();
        }
    }

    class b extends akz {
        private b() {
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(String str, Object obj) {
            try {
                alk.this.av = new qv(akh.class).a(str.toString());
                alv alvVar = new alv(alk.this.ae, alk.this.av);
                arp arpVar = new arp(alk.this.aq);
                alk.this.aq.setAdapter((ListAdapter) alvVar);
                arpVar.a();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(qm qmVar, Object obj) {
            alk.this.al();
        }
    }

    class d extends akz {
        private d() {
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(String str, Object obj) {
            try {
                super.a(str, obj);
                alk.this.aw = new qv(akm.class).a(str.toString());
                amb ambVar = new amb(alk.this.ae, alk.this.aw);
                arp arpVar = new arp(alk.this.ar);
                ambVar.a(true);
                alk.this.ar.setAdapter((ListAdapter) ambVar);
                arpVar.a();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.akz
        public void a(Exception exc, Object obj) {
            super.a(exc, obj);
            Toast.makeText(alk.this.ae, R.string.kDeezer_RequestServer_Failed_Str, 0).show();
        }

        @Override // defpackage.akz, defpackage.qn
        public void a(qm qmVar, Object obj) {
            alk.this.al();
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        IntentFilter intentFilter = new IntentFilter(b);
        intentFilter.addAction(c);
        intentFilter.addAction(d);
        intentFilter.addAction(e);
        this.ae.registerReceiver(this.f, intentFilter);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.ae.unregisterReceiver(this.f);
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(-13487558).g(R.string.kDeezerNav_MyLibrary_Str).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(akj akjVar, qi qiVar, final int i) {
        new amh(akjVar.e(), qiVar).a(0, akjVar.c() != null ? Math.min(Integer.MAX_VALUE, Integer.parseInt(akjVar.c())) : Integer.MAX_VALUE, new age.a() { // from class: alk.5
            @Override // age.a
            public void a(int i2, final List<MusicData> list, JSONObject jSONObject) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: alk.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        als.b(list, i);
                    }
                });
            }

            @Override // age.a
            public void a(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    try {
                        alk.this.a(new JSONObject(errorInfo.b()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }
}
