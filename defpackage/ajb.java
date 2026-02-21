package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.GenreData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;

/* JADX INFO: loaded from: classes.dex */
public class ajb extends aiy<CatalogDataInf> {
    AdapterView.OnItemClickListener a;
    ajn b;

    public ajb(DashboardActivity dashboardActivity, aix aixVar, ListView listView) {
        super(dashboardActivity, aixVar, listView);
        this.a = new AdapterView.OnItemClickListener() { // from class: ajb.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                aiz aizVar = new aiz("Genres");
                Bundle bundle = new Bundle();
                aix aixVar2 = ajb.this.d;
                bundle.putInt("parentType", 16);
                bundle.putParcelable("CatalogDataInf", (CatalogDataInf) adapterView.getItemAtPosition(i));
                aizVar.g(bundle);
                ajb.this.c.q().a(aizVar, (arc) null);
            }
        };
        this.b = new ajn() { // from class: ajb.3
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (obj != null) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().e(afm.a((GenreData) obj, ajb.this.c));
                    ajb.this.c.U();
                }
            }
        };
    }

    @Override // aif.a
    public View a(int i, View view, ViewGroup viewGroup, final CatalogDataInf catalogDataInf) {
        aji ajiVar;
        aji ajiVar2 = (aji) view.getTag();
        if (ajiVar2 == null) {
            ajiVar = new aji();
            ajiVar.a((StoredBitmapImageView) view.findViewById(R.id.iv));
            ajiVar.a((TextView) view.findViewById(R.id.song));
            ajiVar.b((TextView) view.findViewById(R.id.additional_information));
            ajiVar.a((ImageView) view.findViewById(R.id.iv_more));
            view.setTag(ajiVar);
        } else {
            ajiVar = ajiVar2;
        }
        ajiVar.d().setOnClickListener(new aqr(this.c) { // from class: ajb.1
            @Override // defpackage.aqr
            protected void a() {
            }

            @Override // defpackage.aqr
            protected void a(int i2) throws Throwable {
                new ajz().a(catalogDataInf, i2, ajb.this.c);
            }
        });
        ajiVar.b().setText(catalogDataInf.j);
        ajiVar.a().setTag(catalogDataInf.a());
        if (catalogDataInf.m == null) {
            ajiVar.c().setVisibility(8);
        } else {
            ajiVar.c().setVisibility(0);
            ajiVar.c().setText(catalogDataInf.m);
        }
        new ahw().a(ajiVar.a(), catalogDataInf.h, R.drawable.dashboard_default_genre, ahw.a, afh.a(catalogDataInf.j, 2));
        return view;
    }

    @Override // defpackage.aiy
    public AdapterView.OnItemClickListener a() {
        return this.a;
    }

    @Override // defpackage.aiy
    public ajn b() {
        return this.b;
    }

    @Override // defpackage.aiy
    public String c() {
        return this.c.getString(R.string.LibNav_Genre_Str);
    }

    @Override // defpackage.aiy
    protected aif.b d() {
        return aif.b.GENRE;
    }
}
