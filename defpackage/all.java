package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.age;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class all extends ale implements ajn {
    public static boolean a;
    public static boolean b;
    private AnimationListView ah;
    private amb ai;
    private int aj;
    private amh ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private Button ar;
    private Button as;
    private View at;
    private View au;
    private ImageView av;
    private ImageView aw;
    private RelativeLayout ax;
    private View e;
    private View f;
    private boolean ay = false;
    Handler c = new Handler() { // from class: all.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (all.this.d.a()) {
                        all.this.ai.a(true);
                    }
                    all.this.ai.a(all.this.ak.e());
                    all.this.d();
                    break;
            }
        }
    };
    akj d = null;
    private String az = null;
    private age.a aA = new age.a() { // from class: all.6
        @Override // age.a
        public void a(int i, List<MusicData> list, JSONObject jSONObject) {
            all.this.c.sendEmptyMessage(1);
            all.this.a(jSONObject);
            all.this.d();
        }

        @Override // age.a
        public void a(ErrorInfo errorInfo) {
            Toast.makeText(all.this.ae, R.string.kDeezer_ConnectToDeezzer_Failed_Str, 0).show();
            mm.b("onFailure " + errorInfo, new Object[0]);
            all.this.d();
        }
    };

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.fragment_deezer_playlist_new, (ViewGroup) null);
        a(layoutInflater);
        this.ah = (AnimationListView) this.e.findViewById(R.id.playlist_listview);
        this.ah.addHeaderView(this.f);
        this.ah.setOffsetFooterFlag(AnimationListView.a);
        this.ah.setOnItemChosenListener(this);
        this.aj = ahn.b(this.ae);
        this.az = l().getString("title");
        this.d = (akj) l().getSerializable("playlist");
        a = l().getBoolean("isLovedTracks");
        b = l().getBoolean("isLovedTracksFirstLoad");
        this.ak = new amh(this.d.e(), this.g);
        an();
        c();
        int i = 100;
        if (this.d.c() != null) {
            i = Integer.parseInt(this.d.c());
        }
        this.ak.a(0, i, this.aA);
        this.ai = new amb(this.ae, this.ak.e());
        this.ah.setAdapter((ListAdapter) this.ai);
        return this.e;
    }

    private void a(LayoutInflater layoutInflater) {
        this.f = layoutInflater.inflate(R.layout.item_0_layout, (ViewGroup) null);
        this.al = (TextView) this.f.findViewById(R.id.deezer_title);
        this.am = (TextView) this.f.findViewById(R.id.title);
        this.an = (TextView) this.f.findViewById(R.id.username);
        this.ar = (Button) this.f.findViewById(R.id.play_radio);
        this.ao = (TextView) this.f.findViewById(R.id.title2);
        this.ap = (TextView) this.f.findViewById(R.id.username2);
        this.as = (Button) this.f.findViewById(R.id.play_radio2);
        this.aq = (TextView) this.f.findViewById(R.id.play_radio_text);
        this.at = this.f.findViewById(R.id.land_layout);
        this.au = this.f.findViewById(R.id.shaded_area_layout);
        this.av = (ImageView) this.f.findViewById(R.id.imageview);
        this.aw = (ImageView) this.f.findViewById(R.id.favourite);
        this.ax = (RelativeLayout) this.f.findViewById(R.id.rl);
        this.ar.setOnClickListener(new View.OnClickListener() { // from class: all.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                all.this.am();
            }
        });
        this.as.setOnClickListener(new View.OnClickListener() { // from class: all.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                all.this.am();
            }
        });
        this.aw.setOnClickListener(new View.OnClickListener() { // from class: all.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (all.this.ay) {
                    all.this.a(all.this.d);
                } else {
                    all.this.b(all.this.d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.aw.setImageResource(R.drawable.deezer_favourite_on);
        } else {
            this.aw.setImageResource(R.drawable.deezer_favourite_off);
        }
        this.ay = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        if (aof.a().l()) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (akm akmVar : this.ak.e()) {
            if (akmVar.f()) {
                arrayList.add(akmVar);
            }
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(this.ae, R.string.kDeezer_No_Available_Str, 1).show();
        } else {
            als.a(arrayList);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        try {
            Object item = ((ListView) view).getAdapter().getItem(i);
            if (item != null) {
                if (!ahh.e(this.ae)) {
                    Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                } else if (!((akm) item).f()) {
                    Toast.makeText(this.ae, R.string.kDeezer_No_Available_Str, 1).show();
                } else {
                    als.a(this.ak.e(), i - 1, this.ak);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(Configuration configuration) {
        int dimensionPixelSize;
        int iMin = 0;
        a(this.av, R.style.DeezerAlbumCover);
        a(this.f.findViewById(R.id.playlist_container), R.style.DeezerAlbumCoverContainer);
        int i = ahn.a((Context) this.ae).a;
        int i2 = ahn.a((Context) this.ae).b;
        if (ahn.a()) {
            dimensionPixelSize = this.ae.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight) + this.ae.getResources().getDimensionPixelSize(R.dimen.left_menu_width);
        } else {
            dimensionPixelSize = this.ae.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight);
        }
        if (configuration.orientation == 2) {
            a(this.ax, R.style.DeezerAlbumCover);
            this.at.setVisibility(0);
            this.am.setVisibility(4);
            this.an.setVisibility(4);
            this.au.setVisibility(8);
            this.aq.setVisibility(8);
            this.ar.setVisibility(8);
        } else if (configuration.orientation == 1) {
            this.ax.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.aj));
            this.at.setVisibility(4);
            this.am.setVisibility(0);
            this.an.setVisibility(0);
            this.au.setVisibility(0);
            this.aq.setVisibility(0);
            this.ar.setVisibility(0);
            iMin = Math.min(i, i2) + ahn.d(this.ae);
        }
        int i3 = iMin - dimensionPixelSize;
        this.ax.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    private void an() {
        if (this.d != null) {
            if (!TextUtils.isEmpty(this.d.f())) {
                this.am.setText(this.d.f());
                this.ao.setText(this.d.f());
                this.al.setText(this.d.f());
            }
            if (!TextUtils.isEmpty(this.d.d())) {
                bif.a((Context) this.ae).a(this.d.d() + "?size=800").a(R.drawable.empty_no_cover_art).a(this.av);
            }
            if (this.d.b() != null && !TextUtils.isEmpty(this.d.b().c())) {
                this.an.setText(this.ae.getString(R.string.kDeezer_by_Str) + " " + this.d.b().c());
                this.ap.setText(this.ae.getString(R.string.kDeezer_by_Str) + " " + this.d.b().c());
            } else if (!ahh.e(this.ae)) {
                Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            } else {
                aue aueVarA = agv.a(true);
                String str = "https://api.deezer.com/playlist/" + this.d.e() + "?access_token=" + this.g.b();
                mm.b(str, new Object[0]);
                aueVarA.a(str, new aum() { // from class: all.5
                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                        mm.b(jSONObject.toString(), new Object[0]);
                        try {
                            akj akjVar = (akj) new qu(akj.class).a(jSONObject.toString().replaceAll("creator", "user"));
                            if (!TextUtils.isEmpty(akjVar.b().c())) {
                                all.this.an.setText(all.this.ae.getString(R.string.kDeezer_by_Str) + " " + akjVar.b().c());
                                all.this.ap.setText(all.this.ae.getString(R.string.kDeezer_by_Str) + " " + akjVar.b().c());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // defpackage.aum
                    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    }
                });
            }
            ao();
        }
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        b(q().getConfiguration());
        super.c(bundle);
    }

    private void a(View view, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.ae.obtainStyledAttributes(i, new int[]{android.R.attr.layout_width, android.R.attr.layout_height});
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(0, 0);
        int layoutDimension2 = typedArrayObtainStyledAttributes.getLayoutDimension(1, 0);
        view.getLayoutParams().width = layoutDimension;
        view.getLayoutParams().height = layoutDimension2;
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        if (TextUtils.isEmpty(this.az) && l() != null) {
            this.az = l().getString("title");
        }
        return new ajv.a().a(-13487558).a(this.az).c();
    }

    private void ao() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        String str = "https://api.deezer.com/user/" + aho.d("user_id") + "/playlists?limit=2147483647&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: all.7
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    all.this.b(all.this.a((List<akj>) new qv(akj.class).a(jSONObject.toString())));
                    all.this.a(jSONObject);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                all.this.a(i, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<akj> list) {
        if (list == null) {
            return false;
        }
        Iterator<akj> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().e() == this.d.e()) {
                mm.b(this.d.f() + "has been favourited", new Object[0]);
                return true;
            }
        }
        mm.b(this.d.f() + "has not been favourited", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(akj akjVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("playlist_id", akjVar.e() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/playlists", new Object[0]);
        b(false);
        aueVarA.a(this.ae, "https://api.deezer.com/user/me/playlists", (Header[]) null, ausVar, new aux() { // from class: all.8
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                all.this.b(true);
                Toast.makeText(all.this.ae, R.string.UnableRemoveAlbumsLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                all.this.ae.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(akj akjVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("playlist_id", akjVar.e() + "");
        ausVar.a("access_token", this.g.b());
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/playlists", new Object[0]);
        b(true);
        aueVarA.b(this.ae, "https://api.deezer.com/user/me/playlists", ausVar, new aux() { // from class: all.9
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                Toast.makeText(all.this.ae, R.string.UnableAddAlbumLibrary, 0).show();
                all.this.b(false);
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                all.this.ae.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }
}
