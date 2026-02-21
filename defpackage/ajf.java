package defpackage;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import defpackage.aif;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ajf extends aix implements ajm {
    public static int a = 3;
    public static int b = 3;
    public static int g = 5;
    public static int h = 3;
    public static int i = 3;
    private View ah;
    private View ai;
    private DashboardScrubberListView aj;
    private ImageView ak;
    private TextView al;
    private ArrayList<Cursor> am;
    private ArrayList<Cursor> an;
    private TextView ao;
    private aiw au;
    private aiu av;
    private ajh aw;
    private ajd ax;
    private ajb ay;
    private aie az;
    private aif<CatalogDataInf> ap = null;
    private aif<CatalogDataInf> aq = null;
    private aif<MusicData> ar = null;
    private aif<CatalogDataInf> as = null;
    private aif<CatalogDataInf> at = null;
    private ajn aA = new ajn() { // from class: ajf.2
        @Override // defpackage.ajn
        public void a(View view, int i2, Object obj) {
            int itemViewType = ajf.this.az.getItemViewType(i2);
            int iA = ajf.this.az.a(i2);
            switch (itemViewType) {
                case 1:
                    ajf.this.au.b.a(view, iA, obj);
                    break;
                case 2:
                    ajf.this.av.b.a(view, iA, obj);
                    break;
                case 3:
                    ajf.this.aw.b.a(view, iA, obj);
                    break;
                case 4:
                    ajf.this.ax.b.a(view, iA, obj);
                    break;
                case 5:
                    ajf.this.ay.b.a(view, iA, obj);
                    break;
            }
        }
    };
    private AdapterView.OnItemClickListener aB = new AdapterView.OnItemClickListener() { // from class: ajf.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int itemViewType = ajf.this.az.getItemViewType(i2);
            int iA = ajf.this.az.a(i2);
            switch (itemViewType) {
                case 1:
                    ajf.this.au.a.onItemClick(adapterView, view, i2, j);
                    break;
                case 2:
                    ajf.this.av.a.onItemClick(adapterView, view, i2, j);
                    break;
                case 3:
                    ajf.this.aw.a.onItemClick(adapterView, view, iA, j);
                    break;
                case 4:
                    ajf.this.ax.a.onItemClick(adapterView, view, i2, j);
                    break;
                case 5:
                    ajf.this.ay.a.onItemClick(adapterView, view, i2, j);
                    break;
            }
        }
    };
    private ajs aC = new ajs() { // from class: ajf.4
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            ajf.this.ae.C().b(str);
        }
    };
    private MenuItem.OnMenuItemClickListener aD = new MenuItem.OnMenuItemClickListener() { // from class: ajf.5
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ajf.this.ae.C().aq();
            ajf.this.ae.onBackPressed();
            return true;
        }
    };

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ah = super.a(layoutInflater, viewGroup, bundle);
        this.ai = this.ah.findViewById(R.id.capture_touch_focus_view);
        this.ai.setOnTouchListener(new View.OnTouchListener() { // from class: ajf.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ajf.this.ai.requestFocus();
                ahf.a((Activity) ajf.this.ae);
                return false;
            }
        });
        this.am = afn.g().f();
        this.az = new aie(this.ae, R.layout.dashboard_search_header, R.id.separated_list_header, this);
        this.ao = (TextView) this.ah.findViewById(R.id.listview_tips);
        this.ak = (ImageView) this.ah.findViewById(R.id.search_empty_state);
        this.ak.setVisibility(8);
        this.al = (TextView) this.ah.findViewById(R.id.search_no_results_found);
        this.al.setVisibility(8);
        this.aj = (DashboardScrubberListView) this.ah.findViewById(R.id.listview);
        this.aj.a();
        this.c = this.ah.findViewById(R.id.listview_layout);
        ax();
        this.e = new ajo(this.ae, this.ah);
        this.e.a(this.aA);
        this.aj.setOnTouchListener(this.e);
        this.aj.setOnItemClickListener(this.aB);
        az();
        return this.ah;
    }

    private void ax() {
        this.au = new aiw(this.ae, this, this.aj);
        this.av = new aiu(this.ae, this, this.aj);
        this.aw = new ajh(this.ae, this, this.aj);
        this.ax = new ajd(this.ae, this, this.aj);
        this.ay = new ajb(this.ae, this, this.aj);
        this.aq = new aif<>(this.ae, this.au, R.layout.dashboard_artist_album_search_item, a, aif.j);
        this.ap = new aif<>(this.ae, this.av, R.layout.dashboard_artist_album_search_item, b, aif.j);
        this.ar = new aif<>(this.ae, this.aw, R.layout.dashboard_song_search_item, g, aif.j);
        this.as = new aif<>(this.ae, this.ax, R.layout.dashboard_artist_album_search_item, h, aif.j);
        this.at = new aif<>(this.ae, this.ay, R.layout.dashboard_artist_album_search_item, i, aif.j);
        this.az.a(a(R.string.LibNav_Artist_Str), this.aq);
        this.az.a(a(R.string.LibNav_Album_Str), this.ap);
        this.az.a(a(R.string.LibNav_Song_Str), this.ar);
        this.az.a(a(R.string.LibNav_Playlist_Str), this.as);
        this.az.a(a(R.string.LibNav_Genre_Str), this.at);
        this.aj.setAdapter((ListAdapter) this.az);
        this.aj.setFastScrollEnabled(false);
    }

    @Override // defpackage.aix, defpackage.ajj
    public ajv b() {
        if (this.d != null) {
            return new ajv.a().d(true).n(q().getColor(R.color.black)).a(this.aC).m(q().getColor(R.color.white)).e(true).c(this.d).c(true).k(R.drawable.search_close_button).a(true).a(this.aD).c();
        }
        return new ajv.a().d(true).n(q().getColor(R.color.black)).a(this.aC).m(q().getColor(R.color.white)).e(true).c(true).k(R.drawable.search_close_button).b(this.ae.l().d()).a(true).a(this.aD).c();
    }

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public void i() {
        super.i();
        this.d = "";
    }

    @Override // defpackage.aix
    public void b(final String str) {
        ao();
        d(2);
        if (str.isEmpty()) {
            this.d = str;
            az();
        } else {
            mq.b().a(new Runnable() { // from class: ajf.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!str.equals(ajf.this.d)) {
                        ajf.this.d = str;
                        if (ajf.this.ah != null) {
                            if (ajf.this.an == null) {
                                ajf.this.an = new ArrayList();
                            }
                            ajf.this.an.clear();
                            Iterator it = ajf.this.am.iterator();
                            while (it.hasNext()) {
                                ajf.this.an.add(new afl((Cursor) it.next(), str));
                            }
                            mo.a.post(new Runnable() { // from class: ajf.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (ajf.this.aC()) {
                                        ajf.this.aA();
                                        return;
                                    }
                                    ajf.this.aB();
                                    if (ajf.this.an.size() >= 4) {
                                        ajf.this.aq.a((Cursor) ajf.this.an.get(0), aif.b.ARTIST);
                                        ajf.this.ap.a((Cursor) ajf.this.an.get(1), aif.b.ALBUM);
                                        ajf.this.aw.a((Cursor) ajf.this.an.get(2));
                                        ajf.this.ar.a((Cursor) ajf.this.an.get(2), aif.b.SONG);
                                        ajf.this.as.a((Cursor) ajf.this.an.get(3), aif.b.PLAYLIST);
                                        ajf.this.at.a((Cursor) ajf.this.an.get(4), aif.b.GENRE);
                                        ajf.this.az.notifyDataSetChanged();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    private boolean ay() {
        return this.aj == null || this.ak == null || this.al == null;
    }

    private void az() {
        if (!ay()) {
            this.aj.setVisibility(8);
            this.ak.setVisibility(0);
            this.al.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        if (!ay()) {
            this.aj.setVisibility(8);
            this.ak.setVisibility(0);
            this.al.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        if (!ay()) {
            this.aj.setVisibility(0);
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aC() {
        Iterator<Cursor> it = this.an.iterator();
        while (it.hasNext()) {
            if (it.next().getCount() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.aix
    public void c() {
    }

    @Override // defpackage.aix
    public afq d() {
        return null;
    }

    @Override // defpackage.ajm
    public void e(int i2) {
        String str;
        int i3;
        int i4 = ain.Q;
        switch (i2) {
            case 0:
                str = "ARTISTS";
                i3 = ain.Q;
                break;
            case 1:
                str = "ALBUMS";
                i3 = ain.R;
                break;
            case 2:
                str = "SONGS";
                i3 = ain.S;
                break;
            case 3:
                str = "PLAYLISTS";
                i3 = ain.T;
                break;
            case 4:
                str = "GENRES";
                i3 = ain.U;
                break;
            default:
                str = "ARTISTS";
                i3 = ain.Q;
                break;
        }
        mm.b("CLLOG HEADERCLICKED " + str, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putString("DASHBOARD_SEARCH_QUERY", this.d);
        bundle.putInt("DASHBOARD_SEARCH_SECTION_NUM", i3);
        aje ajeVar = new aje();
        ajeVar.g(bundle);
        this.ae.q().a(ajeVar, (arc) null);
    }
}
