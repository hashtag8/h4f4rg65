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
import com.harman.commom.music.library.musicdata.ArtistData;
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
public class aiv extends aix {
    private afj ai;
    private View aj;
    protected afp<a> b;
    private TextView g;
    private ImageView h;
    private DashboardScrubberListView i;
    protected final int a = 1001;
    private aif<CatalogDataInf> ah = null;
    private ajn ak = new ajn() { // from class: aiv.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().e(afm.a((ArtistData) obj, aiv.this.ae));
                aiv.this.ae.U();
            }
        }
    };
    private AdapterView.OnItemClickListener al = new AdapterView.OnItemClickListener() { // from class: aiv.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long j) {
            final ais aisVar = new ais();
            final Bundle bundle = new Bundle();
            agx.a().a(ahe.a(aiv.this.i.getChildAt(i - aiv.this.i.getFirstVisiblePosition()).findViewById(R.id.iv)), false, new agw() { // from class: aiv.2.1
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    bundle.putParcelable("CatalogDataInf", (ArtistData) adapterView.getItemAtPosition(i));
                    bundle.putParcelable("BlurBackground", bitmap);
                    aisVar.g(bundle);
                    aiv.this.ae.q().a(aisVar, (arc) null);
                }
            });
        }
    };

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = super.a(layoutInflater, viewGroup, bundle);
        this.ai = afj.a(2001);
        this.g = (TextView) this.aj.findViewById(R.id.listview_tips);
        this.h = (ImageView) this.aj.findViewById(R.id.listview_tips_icon);
        this.i = (DashboardScrubberListView) this.aj.findViewById(R.id.listview);
        this.c = this.aj.findViewById(R.id.listview_layout);
        this.ah = new aif<>(this.ae, new b(), R.layout.dashboard_artist_album_list_item);
        this.i.setAdapter((ListAdapter) this.ah);
        this.i.setFastScrollEnabled(true);
        this.i.setIndexScrollerListener(this);
        this.e = new ajo(this.ae, this.c);
        this.e.a(this.ak);
        this.i.setOnTouchListener(this.e);
        this.i.setOnItemClickListener(this.al);
        this.b = new afp<>(new Handler(), new a());
        if (!ahi.a()) {
            a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1001);
        } else {
            c("");
        }
        return this.aj;
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        super.a(i, strArr, iArr);
        if (i == 1001 && strArr != null && iArr != null) {
            int i2 = 0;
            while (true) {
                if (i2 < strArr.length) {
                    if (!"android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i2]) || iArr[i2] != 0) {
                        i2++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            c(z ? "" : "notGranted");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) throws Throwable {
        List<MusicData> listA = afm.a((CatalogDataInf) this.ah.getItem(i2), this.ae);
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

    @Override // defpackage.aix
    public void b(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            if (this.aj != null) {
                an();
                ap().b(0, (int) this.ai.c(), str);
                ap().c(0, (int) this.ai.b(), str);
                ap().a(0, (int) this.ai.a(), str);
                ap().e(0, (int) this.ai.d(), str);
                ap().d(0, (int) this.ai.e(), str);
            }
        }
    }

    @Override // defpackage.aix
    public void c() {
        if (this.ah != null) {
            this.ah.b();
        }
    }

    @Override // defpackage.ajj
    public void e() {
        ap().a(this.b, 8);
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void c(Cursor cursor) {
            aiv.this.d(2);
            aiv.this.ao();
            if (cursor.getCount() == 0) {
                aiv.this.i.setVisibility(8);
                aiv.this.g.setVisibility(0);
                aiv.this.h.setVisibility(0);
            } else {
                aiv.this.g.setVisibility(8);
                aiv.this.h.setVisibility(8);
                aiv.this.i.setVisibility(0);
            }
            aiv.this.ah.a(cursor, aif.b.ARTIST);
            aiv.this.ah.notifyDataSetChanged();
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
            aVar.e.setOnClickListener(new aqr(aiv.this.ae) { // from class: aiv.b.1
                @Override // defpackage.aqr
                protected void a() {
                }

                @Override // defpackage.aqr
                protected void a(int i2) throws Throwable {
                    aiv.this.a(i2, i);
                }
            });
            aVar.c.setText(catalogDataInf.j);
            if (catalogDataInf.j != null) {
                if (catalogDataInf.j.equals("<unknown>")) {
                    aVar.g.setVisibility(4);
                } else {
                    String str = catalogDataInf.o != 1 ? catalogDataInf.o + " " + aiv.this.ae.getString(R.string.kDeviceLibrarySongs_Str) : catalogDataInf.o + " " + aiv.this.ae.getString(R.string.kDeviceLibrarySong_Str);
                    String str2 = catalogDataInf.k != 1 ? catalogDataInf.k + " " + aiv.this.ae.getString(R.string.kDeezer_Albums_Str) : catalogDataInf.k + " " + aiv.this.ae.getString(R.string.kDeezer_Album_Str);
                    aVar.g.setVisibility(0);
                    aVar.g.setText(str2 + "  " + str);
                }
            }
            int color = Color.parseColor("#000000");
            aVar.e.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)), PorterDuff.Mode.MULTIPLY);
            aVar.a.setTag(catalogDataInf.a());
            afh.a((String) null, 1);
            new ahw().a(aVar.a, catalogDataInf.i, R.drawable.empty_cover_art_small, ahw.a);
            return view;
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.b;
    }
}
