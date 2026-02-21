package defpackage;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.GenreData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import defpackage.aix;

/* JADX INFO: loaded from: classes.dex */
public class aja extends aix {
    protected afp<a> a;
    private afj ah;
    private View ai;
    private GridView b;
    private TextView g;
    private ImageView h;
    private aif<CatalogDataInf> i = null;
    private ajn aj = new ajn() { // from class: aja.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().e(afm.a((GenreData) obj, aja.this.ae));
                aja.this.ae.U();
            }
        }
    };
    private AdapterView.OnItemClickListener ak = new AdapterView.OnItemClickListener() { // from class: aja.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            aiz aizVar = new aiz("Genres");
            Bundle bundle = new Bundle();
            bundle.putInt("parentType", 16);
            bundle.putParcelable("CatalogDataInf", (CatalogDataInf) adapterView.getItemAtPosition(i));
            aizVar.g(bundle);
            aja.this.ae.q().a(aizVar, (arc) null);
        }
    };

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = super.a(layoutInflater, viewGroup, bundle);
        this.ah = afj.a(2001);
        this.b = (GridView) this.ai.findViewById(R.id.gridview);
        this.g = (TextView) this.ai.findViewById(R.id.grid_tips);
        this.h = (ImageView) this.ai.findViewById(R.id.grid_tips_icon);
        this.c = this.ai.findViewById(R.id.listview_layout);
        this.i = new aif<>(this.ae, new b(), R.layout.dashboard_gridview_item);
        this.b.setAdapter((ListAdapter) this.i);
        this.e = new ajo(this.ae, this.c);
        this.e.a(this.aj);
        this.b.setOnTouchListener(this.e);
        this.b.setOnItemClickListener(this.ak);
        this.a = new afp<>(new Handler(), new a());
        c(ahi.a() ? "" : "notGranted");
        return this.ai;
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void e(Cursor cursor) {
            aja.this.d(1);
            aja.this.ao();
            if (cursor.getCount() == 0) {
                aja.this.b.setVisibility(8);
                aja.this.g.setVisibility(0);
                aja.this.h.setVisibility(0);
            } else {
                aja.this.g.setVisibility(8);
                aja.this.h.setVisibility(8);
                aja.this.b.setVisibility(0);
            }
            aja.this.i.a(cursor, aif.b.GENRE);
            aja.this.i.notifyDataSetChanged();
            aja.this.i.a = false;
        }
    }

    @Override // defpackage.aix
    public void b(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            if (this.ai != null) {
                an();
                ap().d(0, (int) this.ah.e(), str);
            }
        }
    }

    @Override // defpackage.aix
    public void c() {
        if (this.i != null) {
            this.i.b();
        }
    }

    @Override // defpackage.ajj
    public void e() {
        ap().a(this.a, 16);
    }

    class b implements aif.a<CatalogDataInf> {
        private b() {
        }

        @Override // aif.a
        public View a(int i, View view, ViewGroup viewGroup, CatalogDataInf catalogDataInf) {
            aix.a aVar;
            aix.a aVar2 = (aix.a) view.getTag();
            if (aVar2 == null) {
                aVar = new aix.a();
                aVar.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                aVar.c = (TextView) view.findViewById(R.id.tv);
                aVar.d = (TextView) view.findViewById(R.id.art);
                view.setTag(aVar);
            } else {
                aVar = aVar2;
            }
            aVar.c.setText(catalogDataInf.j);
            aVar.a.setTag(catalogDataInf.a());
            if (catalogDataInf.m == null) {
                aVar.d.setVisibility(8);
            } else {
                aVar.d.setVisibility(0);
                aVar.d.setText(catalogDataInf.m);
            }
            new ahw().a(aVar.a, catalogDataInf.h, R.drawable.dashboard_default_genre, ahw.a, afh.a(catalogDataInf.j, 2));
            return view;
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.a;
    }
}
