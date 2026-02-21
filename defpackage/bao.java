package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.shoutcast.model.Station;
import defpackage.ahy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bao extends baq {
    private bbe f;
    private bav g;
    private View h;
    private TextView i;
    private agh<List<Station>> ah = new agh<List<Station>>() { // from class: bao.2
        @Override // defpackage.agh
        public void a(Object obj, List<Station> list) {
            mm.b("got results", Integer.valueOf(list.size()));
            bao.this.g.a(list);
            bao.this.f.a(bao.this.an());
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            ahy ahyVarA = new ahy.a(bao.this.p()).a(R.string.kShoutCastNoStationsFound_Str).a();
            bao.this.f.a(bao.this.q().getString(R.string.kShoutCastNoStationsFound_Str), false);
            mm.b("ShoutcastSearchFragment", ahyVarA.b(errorInfo));
        }
    };
    protected AdapterView.OnItemClickListener b = new AdapterView.OnItemClickListener() { // from class: bao.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Station station = (Station) adapterView.getItemAtPosition(i);
            if (station != null) {
                bao.this.a(station);
            }
        }
    };
    private MenuItem.OnMenuItemClickListener ai = new MenuItem.OnMenuItemClickListener() { // from class: bao.4
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            bao.this.ae.l().a(bao.this.b());
            return true;
        }
    };
    private MenuItem.OnMenuItemClickListener aj = new MenuItem.OnMenuItemClickListener() { // from class: bao.5
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            bao.this.ae.l().a(bao.this.b());
            bao.this.ae.onBackPressed();
            return true;
        }
    };
    private ajs ak = new ajs() { // from class: bao.6
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            bao.this.h.setVisibility(8);
            bao.this.i.setVisibility(8);
            bbb bbbVar = new bbb(str);
            bbbVar.a((Fragment) bao.this);
            bbbVar.a(bao.this.ah);
            bbbVar.a();
        }
    };

    @Override // defpackage.baq, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.shoutcast_search_fragment, (ViewGroup) null);
        AnimationListView animationListView = (AnimationListView) viewInflate.findViewById(R.id.station_listview);
        this.f = new bbe(viewInflate, animationListView);
        arp arpVar = new arp(animationListView);
        this.g = new bav(this.ae);
        animationListView.setAdapter((ListAdapter) this.g);
        arpVar.a();
        animationListView.setOnItemChosenListener(this.d);
        animationListView.setOnItemClickListener(this.b);
        this.h = viewInflate.findViewById(R.id.shoutcast_searchFragment_searchIcon);
        this.i = (TextView) viewInflate.findViewById(R.id.search_no_results_found);
        View viewFindViewById = viewInflate.findViewById(R.id.shoutcast_searchFragment_itemContainer);
        viewFindViewById.setClickable(true);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: bao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bao.this.ae.l().c();
            }
        });
        return viewInflate;
    }

    @Override // defpackage.baq
    protected boolean an() {
        return true;
    }

    @Override // defpackage.baq, defpackage.bal, defpackage.ajj
    public ajv b() {
        return c().d(true).n(q().getColor(R.color.shoutcast_theme_color)).m(q().getColor(R.color.white)).a(this.ak).c(true).k(R.drawable.search_close_button).a(true).a(this.aj).c();
    }
}
