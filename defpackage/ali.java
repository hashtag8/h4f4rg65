package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.ajv;
import defpackage.als;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ali extends ale {
    public static int b = 107;
    private AnimationGridView ah;
    private View ai;
    private View aj;
    private GridView e;
    private ImageView f;
    a a = null;
    private int ak = 15;
    private ArrayList<MusicData> al = new ArrayList<>();
    private List<akl> am = new ArrayList();
    private boolean an = false;
    private boolean ao = false;
    private List<akm> ap = null;
    private List<akm> aq = new ArrayList();
    alw c = null;
    private ajn ar = new ajn() { // from class: ali.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            akl aklVar = (akl) obj;
            if (aklVar != null) {
                if (!ahh.e(ali.this.ae)) {
                    Toast.makeText(ali.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
                    return;
                }
                if (aof.a().l()) {
                    Toast.makeText(ali.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                if (aklVar instanceof akj) {
                    als.a((akj) aklVar, ali.this.g, ali.this.as);
                } else if (aklVar instanceof akg) {
                    als.a((akg) aklVar, ali.this.g, ali.this.as);
                } else if (aklVar instanceof akm) {
                    als.b((akm) aklVar);
                }
            }
        }
    };
    private als.a as = new als.a() { // from class: ali.3
        @Override // als.a
        public void a() {
        }

        @Override // als.a
        public void a(JSONObject jSONObject) {
            ali.this.a(jSONObject);
        }
    };
    AdapterView.OnItemClickListener d = new AdapterView.OnItemClickListener() { // from class: ali.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            akl item = ali.this.a.getItem(i);
            if (ali.this.ao) {
                akm akmVar = (akm) item;
                ali.this.a(akmVar, ali.this.a(akmVar, als.c));
                return;
            }
            mm.b("onitemclick  " + i, new Object[0]);
            if (item != null) {
                if (item instanceof akj) {
                    all allVar = new all();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("playlist", (akj) item);
                    bundle.putString("title", ali.this.a(R.string.kDeezerNav_HearThis_Str));
                    allVar.g(bundle);
                    if (!ahn.a()) {
                        ali.this.ae.q().a(allVar, (arc) null);
                        return;
                    } else {
                        ali.this.ae.q().a(allVar, new arc().c(R.id.menu_container));
                        return;
                    }
                }
                if (item instanceof akg) {
                    ala alaVar = new ala();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("album", (akg) item);
                    bundle2.putString("title", ali.this.a(R.string.kDeezerNav_HearThis_Str));
                    alaVar.g(bundle2);
                    if (!ahn.a()) {
                        ali.this.ae.q().a(alaVar, (arc) null);
                        return;
                    } else {
                        ali.this.ae.q().a(alaVar, new arc().c(R.id.menu_container));
                        return;
                    }
                }
                if (item instanceof akm) {
                    als.b((akm) item);
                } else if (item instanceof akk) {
                    als.a((akk) item, ali.this.g, new als.a() { // from class: ali.4.1
                        @Override // als.a
                        public void a() {
                        }

                        @Override // als.a
                        public void a(JSONObject jSONObject) {
                        }
                    });
                }
            }
        }
    };

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_deezer_hear_this, (ViewGroup) null);
        View viewInflate2 = layoutInflater.inflate(R.layout.hear_this_header_layout, (ViewGroup) null);
        this.e = (GridView) viewInflate2.findViewById(R.id.gridview);
        this.c = new alw(this.ae, this.aq);
        this.e.setAdapter((ListAdapter) this.c);
        this.f = (ImageView) viewInflate2.findViewById(R.id.playpause);
        this.ai = viewInflate2.findViewById(R.id.playpause_layout);
        this.aj = viewInflate2.findViewById(R.id.flow_layout);
        this.ai.setOnClickListener(new View.OnClickListener() { // from class: ali.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ali.this.am();
            }
        });
        this.ah = (AnimationGridView) viewInflate.findViewById(R.id.listview);
        this.ah.a(viewInflate2);
        this.ah.setOnItemClickListener(this.d);
        this.ah.setOnItemChosenListener(this.ar);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        mm.b("playFlow", new Object[0]);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else if (aof.a().l()) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else {
            als.a(this.ap);
        }
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        if (als.c == null || als.c.isEmpty()) {
            an();
        }
        if (this.am == null) {
            this.am = new ArrayList();
        } else {
            this.am.clear();
        }
        c(q().getConfiguration());
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        c();
        agz agzVar = new agz(4, new Runnable() { // from class: ali.6
            @Override // java.lang.Runnable
            public void run() {
                ali.this.d();
                ali.this.a = ali.this.new a(ali.this.ae, ali.this.am);
                ali.this.ah.setAdapter((ListAdapter) ali.this.a);
            }
        }, mo.a);
        a(18, agzVar);
        b(agzVar);
        a(agzVar);
        c(agzVar);
        super.c(bundle);
    }

    private void a(int i, final agz agzVar) {
        String str = "https://api.deezer.com/user/me/flow?limit=" + i + "&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ali.7
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                ali.this.a(jSONObject);
                try {
                    mm.b(jSONObject, new Object[0]);
                    ali.this.ap = new qv(akm.class).a(jSONObject.toString());
                    if (ali.this.ap != null && !ali.this.ap.isEmpty()) {
                        ali.this.b(ali.this.q().getConfiguration());
                        ali.this.aj.setVisibility(0);
                    }
                    agzVar.a();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                ali.this.a(i2, jSONObject);
                agzVar.a();
            }
        });
    }

    private void a(final agz agzVar) {
        String str = "https://api.deezer.com/user/me/recommendations/playlists?limit=" + this.ak + "&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ali.8
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                ali.this.a(jSONObject);
                try {
                    mm.b(jSONObject, new Object[0]);
                    List listA = new qv(akj.class).a(jSONObject.toString());
                    if (ali.this.am != null && listA != null && !listA.isEmpty()) {
                        ali.this.am.addAll(listA);
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                agzVar.a();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                agzVar.a();
            }
        });
    }

    private void b(final agz agzVar) {
        String str = "https://api.deezer.com/user/me/recommendations/albums?limit=" + this.ak + "&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ali.9
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                ali.this.a(jSONObject);
                try {
                    mm.b(jSONObject, new Object[0]);
                    List listA = new qv(akg.class).a(jSONObject.toString());
                    if (ali.this.am != null && listA != null && !listA.isEmpty()) {
                        ali.this.am.addAll(listA);
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                agzVar.a();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                agzVar.a();
            }
        });
    }

    private void c(final agz agzVar) {
        String str = "https://api.deezer.com/user/me/recommendations/tracks?limit=" + this.ak + "&access_token=" + this.g.b();
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ali.10
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                ali.this.a(jSONObject);
                try {
                    mm.b(jSONObject, new Object[0]);
                    List listA = new qv(akm.class).a(jSONObject.toString());
                    if (ali.this.am != null && listA != null && !listA.isEmpty()) {
                        ali.this.am.addAll(listA);
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                agzVar.a();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                agzVar.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final akm akmVar, final boolean z) {
        arz arzVar = new arz(this.ae);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ae.getString(R.string.PlayTip_PlayNow_Str));
        arrayList.add(this.ae.getString(R.string.PlayTip_PlayNext_Str));
        arrayList.add(this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
        arrayList.add(this.ae.getString(R.string.PlayTip_ClearAll_Str));
        if (z) {
            arrayList.add(this.ae.getString(R.string.kDeezer_Delete_from_your_Deezer_library));
        } else {
            arrayList.add(this.ae.getString(R.string.kDeezer_Add_to_your_Deezer_library));
        }
        arzVar.a(arrayList);
        arzVar.a(this.ae.getString(R.string.PlayTip_Title_Str));
        arzVar.a(new asi() { // from class: ali.11
            @Override // defpackage.asi
            public void a(int i) {
                if (aof.a().l()) {
                    Toast.makeText(ali.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
                MusicData musicDataA = als.a(akmVar);
                switch (i) {
                    case 0:
                        MusicPlaylistManager.a().a(musicDataA);
                        break;
                    case 1:
                        MusicPlaylistManager.a().c(musicDataA);
                        break;
                    case 2:
                        MusicPlaylistManager.a().d(musicDataA);
                        break;
                    case 3:
                        MusicPlaylistManager.a().g();
                        MusicPlaylistManager.a().b(musicDataA);
                        break;
                    case 4:
                        if (z) {
                            ali.this.b(akmVar);
                        } else {
                            ali.this.a(akmVar);
                        }
                        break;
                }
            }
        });
        arzVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final akm akmVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("track_id", akmVar.a() + "");
        ausVar.a("access_token", aho.d("access_token"));
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/tracks", new Object[0]);
        a(true);
        aueVarA.b(this.ae, "https://api.deezer.com/user/me/tracks", ausVar, new aux() { // from class: ali.12
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                ali.this.d();
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                Toast.makeText(ali.this.ae, "add favourite fail", 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                ali.this.d();
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                if (als.c == null) {
                    als.c = new ArrayList();
                }
                als.c.add(akmVar);
                ali.this.ae.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final akm akmVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("track_id", akmVar.a() + "");
        ausVar.a("access_token", aho.d("access_token"));
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/tracks", new Object[0]);
        a(true);
        aueVarA.a(this.ae, "https://api.deezer.com/user/me/tracks", (Header[]) null, ausVar, new aux() { // from class: ali.13
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                ali.this.d();
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                Toast.makeText(ali.this.ae, "delete favourite fail", 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                ali.this.d();
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                if (als.c != null && !als.c.isEmpty()) {
                    als.c.remove(akmVar);
                }
                ali.this.ae.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(akm akmVar, List<akm> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (akm akmVar2 : list) {
            if (akmVar2 != null && akmVar2.a() == akmVar.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
        c(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Configuration configuration) {
        ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).height = b(this.ae) * 2;
        if (configuration.orientation == 2) {
            this.e.setNumColumns(9);
            if (this.ap != null && this.ap.size() >= 18 && this.c != null) {
                this.c.a(this.ap.subList(0, 18));
                return;
            }
            return;
        }
        if (configuration.orientation == 1) {
            this.e.setNumColumns(5);
            if (this.ap != null && this.ap.size() >= 10 && this.c != null) {
                this.c.a(this.ap.subList(0, 10));
            }
        }
    }

    private void c(Configuration configuration) {
        if (configuration.orientation == 2) {
            this.ah.setNumColumns(2);
        } else if (configuration.orientation == 1) {
            this.ah.setNumColumns(1);
        }
    }

    private int b(Context context) {
        int i = ahn.a(context).a;
        if (ahn.a()) {
            if (context.getResources().getConfiguration().orientation == 2) {
                return (int) (((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - ((int) q().getDimension(R.dimen.left_menu_width))) / 9.0f);
            }
            return (int) (((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - q().getDimensionPixelSize(R.dimen.left_menu_width)) / 5.0f);
        }
        return (int) ((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) / 5.0f);
    }

    private void an() {
        String str = "https://api.deezer.com/user/me/tracks?limit=2147483647&access_token=" + aho.d("access_token");
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: ali.5
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                ali.this.a(jSONObject);
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    als.c = new qv(akm.class).a(jSONObject.toString());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                als.c = null;
            }
        });
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(q().getString(R.string.kDeezerNav_HearThis_Str)).a(-13487558).c();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        c((Bundle) null);
        super.d(bundle);
    }

    public class a extends amf<akl> {
        public a(Context context, List<akl> list) {
            super(context, list);
        }

        @Override // defpackage.amf, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0016a c0016a;
            final String str;
            if (view == null) {
                view = this.d.inflate(R.layout.deezer_explore_hear_this_item, (ViewGroup) null);
                C0016a c0016a2 = new C0016a();
                c0016a2.c = (ImageView) view.findViewById(R.id.iv);
                c0016a2.g = (TextView) view.findViewById(R.id.hear_this_by);
                c0016a2.b = view.findViewById(R.id.hear_this_layout);
                c0016a2.a = (ImageView) view.findViewById(R.id.hear_this_more);
                c0016a2.e = (ImageView) view.findViewById(R.id.hear_this_play_pause);
                c0016a2.i = (TextView) view.findViewById(R.id.hear_this_time);
                c0016a2.f = (TextView) view.findViewById(R.id.hear_this_title);
                c0016a2.d = (TextView) view.findViewById(R.id.hear_this_type);
                c0016a2.h = (TextView) view.findViewById(R.id.hear_this_user);
                view.setTag(c0016a2);
                c0016a = c0016a2;
            } else {
                c0016a = (C0016a) view.getTag();
            }
            if (agu.a()) {
                c0016a.i.setGravity(3);
            }
            int iA = a(this.b);
            c0016a.c.setLayoutParams(new RelativeLayout.LayoutParams(iA, iA));
            akl item = getItem(i);
            if (item != null) {
                if (item instanceof akj) {
                    akj akjVar = (akj) item;
                    String str2 = akjVar.d() + "?size=550";
                    c0016a.d.setText(this.b.getString(R.string.kDeezer_PLAYLIST_Str));
                    c0016a.f.setText(akjVar.f());
                    c0016a.i.setText(als.a(akjVar.g(), this.b));
                    str = str2;
                } else if (item instanceof akg) {
                    akg akgVar = (akg) item;
                    String str3 = akgVar.e() + "?size=550";
                    c0016a.d.setText(this.b.getString(R.string.kDeezer_ALBUM_Str));
                    c0016a.f.setText(akgVar.c());
                    c0016a.h.setText(akgVar.f().b());
                    c0016a.i.setText(als.a(akgVar.g(), this.b));
                    str = str3;
                } else if (item instanceof akm) {
                    akm akmVar = (akm) item;
                    String str4 = akmVar.e().e() + "?size=550";
                    c0016a.d.setText(this.b.getString(R.string.kDeezer_TRACK_Str));
                    c0016a.f.setText(akmVar.b());
                    c0016a.h.setText(akmVar.d().b());
                    c0016a.i.setText(als.a(akmVar.g(), this.b));
                    str = str4;
                } else if (item instanceof akk) {
                    akk akkVar = (akk) item;
                    String str5 = akkVar.a() + "?size=550";
                    c0016a.d.setText(this.b.getString(R.string.kDeezer_RADIO_CHANNEL_Str));
                    c0016a.f.setText(akkVar.c());
                    c0016a.i.setText(als.a(akkVar.d(), this.b));
                    str = str5;
                } else {
                    str = null;
                }
                if (str != null) {
                    new ahw().a(c0016a.c, new ahq() { // from class: ali.a.1
                        @Override // defpackage.ahq
                        public void a(View view2) {
                            bif.a(a.this.b).a(str).b(view2.getWidth(), view2.getHeight()).e().a((ImageView) view2);
                        }
                    });
                }
            }
            c0016a.e.setVisibility(8);
            if (item instanceof akm) {
                c0016a.a.setVisibility(0);
                c0016a.a.setOnTouchListener(new View.OnTouchListener() { // from class: ali.a.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        ali.this.an = true;
                        ali.this.ao = true;
                        return false;
                    }
                });
            } else {
                c0016a.a.setVisibility(4);
            }
            view.setOnTouchListener(new View.OnTouchListener() { // from class: ali.a.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (!ali.this.an) {
                        ali.this.ao = false;
                    }
                    ali.this.an = false;
                    return false;
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: ali$a$a, reason: collision with other inner class name */
        public class C0016a {
            public ImageView a;
            public View b;
            public ImageView c;
            public TextView d;
            public ImageView e;
            public TextView f;
            public TextView g;
            public TextView h;
            public TextView i;

            public C0016a() {
            }
        }

        private int a(Context context) {
            int i = ahn.a(context).a;
            if (ahn.a()) {
                if (context.getResources().getConfiguration().orientation == 2) {
                    return (int) (((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - context.getResources().getDimensionPixelSize(R.dimen.left_menu_width)) / 2.0f);
                }
                return (i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - context.getResources().getDimensionPixelSize(R.dimen.left_menu_width);
            }
            return i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle);
        }
    }
}
