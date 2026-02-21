package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Genre;
import defpackage.ahy;
import in.srain.cube.views.GridViewWithHeaderAndFooter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ban extends bal {
    private bas b;
    private bbe c;
    private AdapterView.OnItemClickListener d = new AdapterView.OnItemClickListener() { // from class: ban.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Genre genre = (Genre) adapterView.getItemAtPosition(i);
            if (i == 0) {
                ban.this.d();
            } else if (genre.getParentId() == 0) {
                ban.this.a(genre);
            } else {
                ban.this.b(genre);
            }
        }
    };
    private agh<List<Genre>> e = new agh<List<Genre>>() { // from class: ban.2
        @Override // defpackage.agh
        public void a(Object obj, List<Genre> list) {
            if (!ban.this.aw()) {
                ArrayList arrayList = new ArrayList(list.size() + 1);
                arrayList.add(new Genre(ban.this.q().getString(R.string.kShoutCastTop25_Str)));
                arrayList.addAll(list);
                ban.this.b.a(arrayList);
                ban.this.c.a(false);
            }
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            if (!ban.this.aw()) {
                new ahy.a(ban.this.p()).a(R.string.kShoutCastNoStationsFound_Str).a().a(errorInfo);
                ban.this.c.a(ban.this.q().getString(R.string.kShoutCastNoStationsFound_Str), false);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.shoutcast_home_fragment_layout, (ViewGroup) null);
        GridViewWithHeaderAndFooter gridViewWithHeaderAndFooter = (GridViewWithHeaderAndFooter) viewInflate.findViewById(R.id.shoutcast_genre_listview);
        this.c = new bbe(viewInflate, gridViewWithHeaderAndFooter);
        this.c.a();
        arp arpVar = new arp(gridViewWithHeaderAndFooter);
        this.b = new bas(this.ae);
        gridViewWithHeaderAndFooter.setNumColumns(al());
        gridViewWithHeaderAndFooter.setAdapter((ListAdapter) this.b);
        arpVar.a();
        bax baxVar = new bax();
        baxVar.a((Fragment) this);
        baxVar.a((agh) this.e);
        baxVar.a();
        gridViewWithHeaderAndFooter.setOnItemClickListener(this.d);
        return viewInflate;
    }
}
