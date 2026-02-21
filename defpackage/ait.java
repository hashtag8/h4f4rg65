package defpackage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import defpackage.aix;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ait extends aix {
    protected afp<a> a;
    private afj ah;
    private View ai;
    private TextView b;
    private ImageView g;
    private DashboardScrubberListView h;
    private aif<CatalogDataInf> i = null;
    private ajn aj = new ajn() { // from class: ait.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().e(afm.a((CatalogDataInf) obj, ait.this.ae));
                ait.this.ae.U();
            }
        }
    };
    private AdapterView.OnItemClickListener ak = new AdapterView.OnItemClickListener() { // from class: ait.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            final aiz aizVar = new aiz("Album");
            final Bundle bundle = new Bundle();
            bundle.putInt("parentType", 32);
            bundle.putParcelable("CatalogDataInf", (CatalogDataInf) adapterView.getItemAtPosition(i));
            agx.a().a(ahe.a(ait.this.h.getChildAt(i - ait.this.h.getFirstVisiblePosition()).findViewById(R.id.iv)), false, new agw() { // from class: ait.2.1
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    bundle.putParcelable("BlurBackground", bitmap);
                    aizVar.g(bundle);
                    ait.this.ae.q().a(aizVar, (arc) null);
                }
            });
        }
    };

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = super.a(layoutInflater, viewGroup, bundle);
        this.ah = afj.a(2001);
        this.b = (TextView) this.ai.findViewById(R.id.listview_tips);
        this.g = (ImageView) this.ai.findViewById(R.id.listview_tips_icon);
        this.h = (DashboardScrubberListView) this.ai.findViewById(R.id.listview);
        this.c = this.ai.findViewById(R.id.listview_layout);
        this.i = new aif<>(this.ae, new b(), R.layout.dashboard_artist_album_list_item);
        this.h.setAdapter((ListAdapter) this.i);
        this.h.setFastScrollEnabled(true);
        this.h.setIndexScrollerListener(this);
        this.e = new ajo(this.ae, this.c);
        this.e.a(this.aj);
        this.h.setOnTouchListener(this.e);
        this.h.setOnItemClickListener(this.ak);
        this.a = new afp<>(new Handler(), new a());
        c(ahi.a() ? "" : "notGranted");
        return this.ai;
    }

    @Override // defpackage.aix
    public void b(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            if (this.ai != null) {
                an();
                ap().c(0, (int) this.ah.b(), str);
            }
        }
    }

    @Override // defpackage.aix
    public void c() {
        if (this.i != null) {
            this.i.b();
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.a;
    }

    @Override // defpackage.ajj
    public void e() {
        ap().a(this.a, 32);
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void b(Cursor cursor) {
            ait.this.d(2);
            ait.this.ao();
            if (cursor.getCount() == 0) {
                ait.this.h.setVisibility(8);
                ait.this.b.setVisibility(0);
                ait.this.g.setVisibility(0);
            } else {
                ait.this.b.setVisibility(8);
                ait.this.g.setVisibility(8);
                ait.this.h.setVisibility(0);
            }
            ait.this.i.a(cursor, aif.b.ALBUM);
            ait.this.i.notifyDataSetChanged();
        }
    }

    class b implements aif.a<CatalogDataInf> {
        b() {
        }

        @Override // aif.a
        public View a(final int i, View view, ViewGroup viewGroup, CatalogDataInf catalogDataInf) {
            aix.a aVar;
            aix.a aVar2 = (aix.a) view.getTag();
            if (aVar2 == null) {
                aVar = new aix.a();
                aVar.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                aVar.c = (TextView) view.findViewById(R.id.song);
                aVar.e = (ImageView) view.findViewById(R.id.iv_more);
                aVar.g = (TextView) view.findViewById(R.id.additional_information);
                view.setTag(aVar);
            } else {
                aVar = aVar2;
            }
            aVar.e.setOnClickListener(new aqr(ait.this.ae) { // from class: ait.b.1
                @Override // defpackage.aqr
                protected void a() {
                }

                @Override // defpackage.aqr
                protected void a(int i2) throws Throwable {
                    ait.this.a(i2, i);
                }
            });
            aVar.c.setText(catalogDataInf.j);
            aVar.g.setText(catalogDataInf.m + " - " + (catalogDataInf.o != 1 ? catalogDataInf.o + " " + ait.this.ae.getString(R.string.kDeviceLibrarySongs_Str) : catalogDataInf.o + " " + ait.this.ae.getString(R.string.kDeviceLibrarySong_Str)));
            int color = Color.parseColor("#000000");
            aVar.e.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)), PorterDuff.Mode.MULTIPLY);
            aVar.a.setTag(catalogDataInf.a());
            afh.a((String) null, 1);
            new ahw().a(aVar.a, catalogDataInf.h, R.drawable.empty_cover_art_small, ahw.a);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) throws Throwable {
        List<MusicData> listA = afm.a((CatalogDataInf) this.i.getItem(i2), this.ae);
        switch (i) {
            case 1:
                MusicPlaylistManager.a().a(listA);
                break;
            case 2:
                MusicPlaylistManager.a().c(listA);
                break;
            case 3:
                MusicPlaylistManager.a().d(listA);
                break;
            case 4:
                MusicPlaylistManager.a().g();
                MusicPlaylistManager.a().e(listA);
                break;
        }
        this.ae.U();
    }
}
