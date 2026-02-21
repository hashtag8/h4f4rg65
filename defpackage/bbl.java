package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.soundcloud.SoundCloudLoginActivity;
import defpackage.arw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bbl extends bbt {
    protected static String b;
    public static bbl e;
    protected BaseAdapter a;
    private TextView aA;
    private bbj aq;
    private RelativeLayout ar;
    private ListView as;
    private Button at;
    private LayoutInflater av;
    private ArrayList<String> aw;
    private bck ax;
    private arw ay;
    private View az;
    protected be c;
    private static List<String> au = new ArrayList();
    public static boolean d = false;

    class a extends BaseAdapter {
        public a(Context context) {
            bbl.this.av = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return bbl.this.aw.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (bbl.d && i == 2) ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            bbl.this.aq.t.put("limit", "20");
            bbl.this.aq.t.put("offset", "0");
            int itemViewType = getItemViewType(i);
            final int i2 = (bbl.d || i <= 1) ? i : i + 1;
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                        view = bbl.this.av.inflate(R.layout.soundcloud_username_cell, (ViewGroup) null);
                        bbl.this.az = view;
                        b bVar = new b();
                        bVar.a = (TextView) view.findViewById(R.id.sc_username);
                        bbl.this.aA = bVar.a;
                        if (bbl.this.ax == null && (bbt.ak == null || bbt.ak.h() == null || bbt.ak.h().a == null)) {
                            view.setVisibility(8);
                        } else {
                            bVar.a.setText(bbl.b);
                        }
                        view.setTag(bVar);
                        break;
                    case 1:
                        view = bbl.this.av.inflate(R.layout.soundcloud_options_cell, (ViewGroup) null);
                        c cVar = new c();
                        cVar.a = (TextView) view.findViewById(R.id.sc_options_text);
                        cVar.a.setTypeface(ahu.a(bbl.this.ae));
                        cVar.b = (ImageView) view.findViewById(R.id.sc_options_button_image);
                        cVar.c = (ImageButton) view.findViewById(R.id.sc_options_button);
                        view.setTag(cVar);
                        cVar.a.setText((CharSequence) bbl.this.aw.get(i));
                        switch (i2) {
                            case 0:
                                cVar.b.setImageResource(R.drawable.sc_icon_explore);
                                break;
                            case 1:
                                cVar.b.setImageResource(R.drawable.sc_icon_search);
                                break;
                            case 3:
                                cVar.b.setImageResource(R.drawable.sc_icon_stream);
                                break;
                            case 4:
                                cVar.b.setImageResource(R.drawable.sc_icon_likes);
                                break;
                            case 5:
                                cVar.b.setImageResource(R.drawable.sc_icon_playlists);
                                break;
                        }
                        cVar.c.setOnClickListener(new View.OnClickListener() { // from class: bbl.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (ahh.e(bbl.this.ae)) {
                                    if (bbl.this.ax == null && ((i2 == 3 || i2 == 4 || i2 == 5) && (bbt.ak == null || bbt.ak.h() == null || bbt.ak.h().a == null))) {
                                        bbl.this.a(new Intent(bbl.this.ae, (Class<?>) SoundCloudLoginActivity.class), i2);
                                        return;
                                    }
                                    if (i2 == 3) {
                                        bby bbyVar = new bby();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbyVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 0) {
                                        bbk bbkVar = new bbk();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbkVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 4) {
                                        bbq bbqVar = new bbq();
                                        bbqVar.c((Bundle) null);
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbqVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 5) {
                                        bbu bbuVar = new bbu();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbuVar, (arc) null);
                                        return;
                                    } else {
                                        if (i2 == 1) {
                                            bbx bbxVar = new bbx();
                                            bbl.this.c();
                                            bbl.this.ae.q().a(bbxVar, (arc) null);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                bbl.this.aq.a(bbl.this.ae, bbl.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            }
                        });
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        bbl.this.az = view;
                        b bVar2 = (b) view.getTag();
                        if (bbl.this.ax == null && (bbt.ak == null || bbt.ak.h() == null || bbt.ak.h().a == null)) {
                            view.setVisibility(8);
                        } else {
                            bVar2.a.setText(bbl.b);
                        }
                        break;
                    case 1:
                        c cVar2 = (c) view.getTag();
                        cVar2.a.setText((CharSequence) bbl.this.aw.get(i));
                        switch (i2) {
                            case 0:
                                cVar2.b.setImageResource(R.drawable.sc_icon_explore);
                                break;
                            case 1:
                                cVar2.b.setImageResource(R.drawable.sc_icon_search);
                                break;
                            case 3:
                                cVar2.b.setImageResource(R.drawable.sc_icon_stream);
                                break;
                            case 4:
                                cVar2.b.setImageResource(R.drawable.sc_icon_likes);
                                break;
                            case 5:
                                cVar2.b.setImageResource(R.drawable.sc_icon_playlists);
                                break;
                        }
                        cVar2.c.setOnClickListener(new View.OnClickListener() { // from class: bbl.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (ahh.e(bbl.this.ae)) {
                                    if (bbl.this.ax == null && ((i2 == 3 || i2 == 4 || i2 == 5) && (bbt.ak == null || bbt.ak.h() == null || bbt.ak.h().a == null))) {
                                        bbl.this.a(new Intent(bbl.this.ae, (Class<?>) SoundCloudLoginActivity.class), i2);
                                        return;
                                    }
                                    if (i2 == 3) {
                                        bby bbyVar = new bby();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbyVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 0) {
                                        bbk bbkVar = new bbk();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbkVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 4) {
                                        bbq bbqVar = new bbq();
                                        bbqVar.c((Bundle) null);
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbqVar, (arc) null);
                                        return;
                                    }
                                    if (i2 == 5) {
                                        bbu bbuVar = new bbu();
                                        bbl.this.c();
                                        bbl.this.ae.q().a(bbuVar, (arc) null);
                                        return;
                                    } else {
                                        if (i2 == 1) {
                                            bbx bbxVar = new bbx();
                                            bbl.this.c();
                                            bbl.this.ae.q().a(bbxVar, (arc) null);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                bbl.this.aq.a(bbl.this.ae, bbl.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            }
                        });
                        break;
                }
            }
            return view;
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        e = null;
    }

    public void b(ajj ajjVar) {
        if (!(this.c.a(ajjVar.av()) == null)) {
            this.c.a().a(this.c.a(ajjVar.av())).d();
            this.c.b();
            this.c.c();
        }
    }

    public void c() {
        try {
            b((ajj) new bby());
            b((ajj) new bbk());
            b((ajj) new bbq());
            b((ajj) new bbu());
            b((ajj) new bbx());
            b((ajj) new bbr());
        } catch (Exception e2) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        if (i == 3) {
            DashboardActivity dashboardActivity = this.ae;
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                d();
                this.ae.q().a(new bby(), (arc) null);
                return;
            }
            DashboardActivity dashboardActivity2 = this.ae;
            if (i2 == 0) {
                this.aq.a(this.ae, q().getString(R.string.SoundCloudFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 4) {
            DashboardActivity dashboardActivity3 = this.ae;
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                d();
                this.ae.q().a(new bbq(), (arc) null);
                return;
            }
            DashboardActivity dashboardActivity4 = this.ae;
            if (i2 == 0) {
                this.aq.a(this.ae, q().getString(R.string.SoundCloudFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 5) {
            DashboardActivity dashboardActivity5 = this.ae;
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                d();
                this.ae.q().a(new bbu(), (arc) null);
                return;
            }
            DashboardActivity dashboardActivity6 = this.ae;
            if (i2 == 0) {
                this.aq.a(this.ae, q().getString(R.string.SoundCloudFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 10) {
            DashboardActivity dashboardActivity7 = this.ae;
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                d();
                return;
            }
            DashboardActivity dashboardActivity8 = this.ae;
            if (i2 == 0) {
                this.aq.a(this.ae, q().getString(R.string.SoundCloudFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
            }
        }
    }

    protected void d() {
        this.ax = bbt.ak.h();
        this.at.setText(q().getString(R.string.SoundCloudLogout_Str));
        b = am();
        this.aw.add(2, bbj.v);
        this.a.notifyDataSetChanged();
        if (this.az != null) {
            this.az.setVisibility(0);
            this.aA.setText(b);
        }
        d = true;
    }

    protected void a(boolean z) {
        this.at.setText(q().getString(R.string.SoundCloudLogin_Str));
        if (d) {
            this.aw.remove(2);
            this.a.notifyDataSetChanged();
        }
        if (this.az != null) {
            this.az.setVisibility(8);
        }
        if (z) {
            an();
        }
        d = false;
    }

    static class c {
        TextView a;
        ImageView b;
        ImageButton c;

        c() {
        }
    }

    static class b {
        TextView a;

        b() {
        }
    }

    public bck al() {
        SharedPreferences sharedPreferences = this.ae.getSharedPreferences("", 0);
        this.aq.getClass();
        return b(sharedPreferences.getString("HK_SoundCloud_Token_Tag", null));
    }

    public String am() {
        SharedPreferences sharedPreferences = this.ae.getSharedPreferences("", 0);
        this.aq.getClass();
        return sharedPreferences.getString("HK_SoundCloud_Username_Tag", "");
    }

    protected bck b(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("'");
        return new bck(strArrSplit[1], strArrSplit[3], strArrSplit[5]);
    }

    protected void an() {
        SharedPreferences.Editor editorEdit = this.ae.getSharedPreferences("", 0).edit();
        this.aq.getClass();
        editorEdit.putString("HK_SoundCloud_Token_Tag", null);
        editorEdit.commit();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.c = this.ae.f();
        c();
        this.a = new a(this.ae);
        this.ar = (RelativeLayout) LayoutInflater.from(this.ae).inflate(R.layout.soundcloud_home_layout, (ViewGroup) null);
        this.ar.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 20);
        this.aw.add(q().getString(R.string.SoundCloudExplore_Str));
        this.aw.add(q().getString(R.string.SoundCloudSearch_Str));
        this.aw.add(q().getString(R.string.SoundCloudStream_Str));
        this.aw.add(q().getString(R.string.SoundCloudLikes_Str));
        this.aw.add(q().getString(R.string.SoundCloudPlaylists_Str));
        this.at = (Button) this.ar.findViewById(R.id.sc_logout_button);
        this.at.setTypeface(ahu.a(this.ae));
        this.ax = al();
        if (this.ax != null) {
            bbt.ak = new bca("80d6d387aea9db3c540751ab3133876b", "24e38c33cd0a201c80d81cc342626797", bbj.b, this.ax);
            d();
        } else {
            bbt.ak = new bca("80d6d387aea9db3c540751ab3133876b", "24e38c33cd0a201c80d81cc342626797", bbj.b, null);
            a(false);
        }
        this.at.setOnClickListener(new View.OnClickListener() { // from class: bbl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bbl.d) {
                    if (bbl.this.ay == null) {
                        bbl.this.ay = new arw.a(bbl.this.ae).a(bbl.this.a(R.string.SoundCloudLogoutText_Str)).b(bbl.this.a(R.string.kDeezerSettingAccountLogout_Str)).a(bbl.this.a(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: bbl.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bbt.ak.b();
                                bbl.this.ax = null;
                                bbl.this.a(true);
                                dialogInterface.cancel();
                            }
                        }).b(bbl.this.a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: bbl.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bbl.this.ay.dismiss();
                            }
                        }).d(false).b();
                    }
                    if (!bbl.this.ay.isShowing() && !bbl.this.ae.isFinishing()) {
                        new asc(bbl.this.ay).a(bbl.this.p());
                        return;
                    }
                    return;
                }
                if (ahh.e(bbl.this.ae)) {
                    bbl.this.a(new Intent(bbl.this.ae, (Class<?>) SoundCloudLoginActivity.class), 10);
                }
            }
        });
        this.as = (ListView) this.ar.findViewById(R.id.soundcloud_songs_list_view);
        this.as.setAdapter((ListAdapter) this.a);
        return this.ar;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }
}
