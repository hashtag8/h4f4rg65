package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.shoutcast.model.Station;
import defpackage.ahy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class baq extends bal {
    private String b;
    protected Station c;
    private bav f;
    private bbe g;
    private String h;
    protected ajn d = new ajn() { // from class: baq.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().h();
                if (aof.a().d().size() > 0) {
                    baq.this.ae.Y();
                    baq.this.c = (Station) obj;
                    MusicPlaylistManager.a().a(baq.this.c);
                }
            }
        }
    };
    private agh<String> i = new agh<String>() { // from class: baq.2
        @Override // defpackage.agh
        public void a(Object obj, String str) {
            baq.this.c.path = str;
            MusicPlaylistManager.a().a(baq.this.c);
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            new ahy.a(baq.this.p()).a(R.string.kShoutCastNoSuggestedStation_Str).b(R.string.PlayErrorTip_Str).a().a(errorInfo);
            mm.b("CLLOG ANIMATION STOP IN ERROR", new Object[0]);
            if (MusicPlaylistManager.a().s().equals(baq.this.c)) {
                baq.this.ae.X();
            }
        }
    };
    private agh<List<Station>> ah = new agh<List<Station>>() { // from class: baq.3
        @Override // defpackage.agh
        public void a(Object obj, List<Station> list) {
            mm.b("got results", Integer.valueOf(list.size()));
            baq.this.ap().a(list);
            baq.this.g.a(baq.this.an());
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            ahy ahyVarA = new ahy.a(baq.this.p()).a(R.string.kShoutCastNoStationsFound_Str).a();
            baq.this.g.a(baq.this.q().getString(R.string.kShoutCastNoStationsFound_Str), false);
            mm.b("ShoutcastListFragment", ahyVarA.b(errorInfo));
        }
    };
    protected AdapterView.OnItemClickListener e = new AdapterView.OnItemClickListener() { // from class: baq.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Station station = (Station) adapterView.getItemAtPosition(i);
            if (station != null) {
                baq.this.a(station);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.shoutcast_stationlist_fragment_layout, (ViewGroup) null);
        AnimationListView animationListView = (AnimationListView) viewInflate.findViewById(R.id.station_listview);
        this.g = new bbe(viewInflate, animationListView);
        this.g.a();
        arp arpVar = new arp(animationListView);
        this.f = new bav(this.ae);
        animationListView.setAdapter((ListAdapter) this.f);
        arpVar.a();
        this.b = l().getString("subgenre_name");
        this.h = l().getString("subgenre");
        this.f.a(this.b.equals(q().getString(R.string.kShoutCastTop25_Str)));
        bbc bbcVarAo = ao();
        bbcVarAo.a((Fragment) this);
        bbcVarAo.a((agh) this.ah);
        bbcVarAo.a();
        animationListView.setOnItemChosenListener(this.d);
        animationListView.setOnItemClickListener(this.e);
        return viewInflate;
    }

    protected boolean an() {
        return false;
    }

    protected bbc ao() {
        return new bba(this.b, am());
    }

    @Override // defpackage.bal, defpackage.ajj
    public ajv b() {
        return c().a(this.h).a(q().getColor(R.color.shoutcast_theme_color)).e(q().getColor(R.color.white)).c();
    }

    public bav ap() {
        return this.f;
    }
}
