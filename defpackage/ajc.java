package defpackage;

import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.harman.commom.music.library.musicdata.PlayListData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import defpackage.aix;

/* JADX INFO: loaded from: classes.dex */
public class ajc extends aix {
    protected afp<a> a;
    private ImageView ah;
    private afj aj;
    private View ak;
    private GridView h;
    private TextView i;
    private aif<CatalogDataInf> ai = null;
    protected final int b = 20;
    protected int g = 0;
    private ajn al = new ajn() { // from class: ajc.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().e(afm.a((PlayListData) obj, ajc.this.ae));
                ajc.this.ae.U();
            }
        }
    };
    private AdapterView.OnItemClickListener am = new AdapterView.OnItemClickListener() { // from class: ajc.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            final aiz aizVar = new aiz("Playlist");
            final Bundle bundle = new Bundle();
            bundle.putInt("parentType", 1);
            bundle.putParcelable("CatalogDataInf", (CatalogDataInf) adapterView.getItemAtPosition(i));
            agx.a().a(ahe.a(ajc.this.h.getChildAt(i - ajc.this.h.getFirstVisiblePosition()).findViewById(R.id.iv)), false, new agw() { // from class: ajc.2.1
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    bundle.putParcelable("BlurBackground", bitmap);
                    aizVar.g(bundle);
                    ajc.this.ae.q().a(aizVar, (arc) null);
                }
            });
        }
    };
    private int an = 0;

    static /* synthetic */ int e(ajc ajcVar) {
        int i = ajcVar.an;
        ajcVar.an = i + 1;
        return i;
    }

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = super.a(layoutInflater, viewGroup, bundle);
        this.aj = afj.a(2001);
        this.h = (GridView) this.ak.findViewById(R.id.gridview);
        this.i = (TextView) this.ak.findViewById(R.id.grid_tips);
        this.ah = (ImageView) this.ak.findViewById(R.id.grid_tips_icon);
        this.ai = new aif<>(this.ae, new b(), R.layout.dashboard_gridview_item);
        this.h.setAdapter((ListAdapter) this.ai);
        this.e = new ajo(this.ae, this.c);
        this.e.a(this.al);
        this.h.setOnTouchListener(this.e);
        this.h.setOnItemClickListener(this.am);
        this.a = new afp<>(new Handler(), new a());
        c(ahi.a() ? "" : "notGranted");
        return this.ak;
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void d(Cursor cursor) {
            ajc.this.d(1);
            ajc.this.ao();
            if (cursor.getCount() == 0) {
                ajc.this.h.setVisibility(8);
                ajc.this.i.setVisibility(0);
                ajc.this.ah.setVisibility(0);
            } else {
                ajc.this.i.setVisibility(8);
                ajc.this.ah.setVisibility(8);
                ajc.this.h.setVisibility(0);
            }
            ajc.this.ai.a(cursor, aif.b.PLAYLIST);
            ajc.this.ai.notifyDataSetChanged();
            ajc.this.an = 0;
            ajc.this.ai.a = false;
        }
    }

    @Override // defpackage.aix
    public void b(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            if (this.ak != null) {
                an();
                ap().e(0, (int) this.aj.d(), str);
            }
        }
    }

    @Override // defpackage.aix
    public void c() {
        if (this.ai != null) {
            this.ai.b();
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.a;
    }

    @Override // defpackage.ajj
    public void e() {
        ap().a(this.a, 1);
    }

    class b implements aif.a<CatalogDataInf> {
        private b() {
        }

        @Override // aif.a
        public View a(int i, View view, ViewGroup viewGroup, CatalogDataInf catalogDataInf) {
            aix.a aVar;
            mm.b("CLLOG CHECK PLAYLIST MASSIVE LAG " + i + " count: " + ajc.e(ajc.this), new Object[0]);
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
            new ahw().a(aVar.a, catalogDataInf.i, R.drawable.empty_cover_art_small, ahw.a, afh.a(catalogDataInf.j, 1));
            return view;
        }
    }
}
