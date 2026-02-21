package defpackage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class aje extends aix {
    private View a;
    private aif<?> ah;
    private aiy<?> ai;
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: aje.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            aje.this.ai.a().onItemClick(adapterView, view, i, j);
        }
    };
    private ajn ak = new ajn() { // from class: aje.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            aje.this.ai.b().a(view, i, obj);
        }
    };
    private DashboardScrubberListView b;
    private String g;
    private int h;
    private afl i;

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = super.a(layoutInflater, viewGroup, bundle);
        Bundle bundleL = l();
        this.g = bundleL.getString("DASHBOARD_SEARCH_QUERY");
        this.h = bundleL.getInt("DASHBOARD_SEARCH_SECTION_NUM");
        this.b = (DashboardScrubberListView) this.a.findViewById(R.id.listview);
        this.b.a();
        this.c = this.a.findViewById(R.id.listview_layout);
        d(2);
        ax();
        this.e = new ajo(this.ae, this.a);
        this.e.a(this.ak);
        this.b.setOnTouchListener(this.e);
        this.b.setOnItemClickListener(this.aj);
        b("");
        return this.a;
    }

    private void ax() {
        switch (this.h) {
            case 1:
                this.ai = new aiu(this.ae, this, this.b);
                this.ah = new aif<>(this.ae, this.ai, R.layout.dashboard_artist_album_search_item, aif.i, aif.j);
                break;
            case 2:
                this.ai = new ajh(this.ae, this, this.b);
                this.ah = new aif<>(this.ae, this.ai, R.layout.dashboard_song_search_item, aif.i, aif.j);
                break;
            case 3:
                this.ai = new ajd(this.ae, this, this.b);
                this.ah = new aif<>(this.ae, this.ai, R.layout.dashboard_artist_album_search_item, aif.i, aif.j);
                break;
            case 4:
                this.ai = new ajb(this.ae, this, this.b);
                this.ah = new aif<>(this.ae, this.ai, R.layout.dashboard_artist_album_search_item, aif.i, aif.j);
                break;
            default:
                this.ai = new aiw(this.ae, this, this.b);
                this.ah = new aif<>(this.ae, this.ai, R.layout.dashboard_artist_album_search_item, aif.i, aif.j);
                break;
        }
        this.b.setAdapter((ListAdapter) this.ah);
    }

    @Override // defpackage.aix
    public void b(String str) {
        ao();
        mq.b().a(new Runnable() { // from class: aje.3
            @Override // java.lang.Runnable
            public void run() {
                if (aje.this.a != null) {
                    Cursor cursor = afn.g().f().get(aje.this.h);
                    aje.this.i = new afl(cursor, aje.this.g);
                    mo.a.post(new Runnable() { // from class: aje.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aje.this.ai != null) {
                                aje.this.ai.a(aje.this.i);
                                aje.this.ah.a(aje.this.i, aje.this.ai.d());
                                aje.this.ah.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // defpackage.aix, defpackage.ajj
    public ajv b() {
        String strC = this.ai.c();
        if (this.g != null && !this.g.isEmpty()) {
            strC = strC + ": " + this.g;
        }
        return new ajv.a().c(false).d(false).a(q().getColor(R.color.black)).a(strC).c();
    }

    @Override // defpackage.aix
    public void c() {
        this.ah.b();
    }

    @Override // defpackage.aix
    public afq d() {
        return null;
    }
}
