package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Genre;
import defpackage.ahy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bam extends bal {
    private bat b;
    private bbe c;
    private AdapterView.OnItemClickListener d = new AdapterView.OnItemClickListener() { // from class: bam.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Genre genre = (Genre) adapterView.getItemAtPosition(i);
            if (genre.getParentId() == 0) {
                bam.this.a(genre);
            } else {
                bam.this.b(genre);
            }
        }
    };
    private agh<List<Genre>> e = new agh<List<Genre>>() { // from class: bam.2
        @Override // defpackage.agh
        public void a(Object obj, List<Genre> list) {
            bam.this.b.a(list);
            bam.this.c.a(false);
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            ahy ahyVarA = new ahy.a(bam.this.p()).a(R.string.kShoutCastNoStationsFound_Str).a();
            bam.this.c.a(bam.this.q().getString(R.string.kShoutCastNoStationsFound_Str), false);
            mm.b("ShoutcastGenreFragment", ahyVarA.b(errorInfo));
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.shoutcast_genre_fragment_layout, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.subgenre_listview);
        this.c = new bbe(viewInflate, listView);
        this.c.a();
        arp arpVar = new arp(listView);
        this.b = new bat(this.ae);
        listView.setAdapter((ListAdapter) this.b);
        arpVar.a();
        baz bazVar = new baz(l().getString("genre_id"));
        bazVar.a((Fragment) this);
        bazVar.a((agh) this.e);
        bazVar.a();
        listView.setOnItemClickListener(this.d);
        return viewInflate;
    }

    @Override // defpackage.bal, defpackage.ajj
    public ajv b() {
        return c().a(l().getString("genre_name")).c();
    }
}
