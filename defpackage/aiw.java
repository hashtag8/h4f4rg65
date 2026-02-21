package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;

/* JADX INFO: loaded from: classes.dex */
public class aiw extends aiy<CatalogDataInf> {
    AdapterView.OnItemClickListener a;
    ajn b;

    public aiw(DashboardActivity dashboardActivity, aix aixVar, ListView listView) {
        super(dashboardActivity, aixVar, listView);
        this.a = new AdapterView.OnItemClickListener() { // from class: aiw.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long j) {
                final ais aisVar = new ais();
                final Bundle bundle = new Bundle();
                agx.a().a(ahe.a(aiw.this.e.getChildAt(i - aiw.this.e.getFirstVisiblePosition()).findViewById(R.id.iv)), false, new agw() { // from class: aiw.2.1
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        bundle.putParcelable("CatalogDataInf", (ArtistData) adapterView.getItemAtPosition(i));
                        bundle.putParcelable("BlurBackground", bitmap);
                        aisVar.g(bundle);
                        aiw.this.c.q().a(aisVar, (arc) null);
                    }
                });
            }
        };
        this.b = new ajn() { // from class: aiw.3
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (obj != null) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().e(afm.a((ArtistData) obj, aiw.this.c));
                    aiw.this.c.U();
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
            ajiVar.d((TextView) view.findViewById(R.id.additional_information));
            ajiVar.a((ImageView) view.findViewById(R.id.iv_more));
            view.setTag(ajiVar);
        } else {
            ajiVar = ajiVar2;
        }
        ajiVar.d().setOnClickListener(new aqr(this.c) { // from class: aiw.1
            @Override // defpackage.aqr
            protected void a() {
            }

            @Override // defpackage.aqr
            protected void a(int i2) throws Throwable {
                new ajz().a(catalogDataInf, i2, aiw.this.c);
            }
        });
        ajiVar.b().setText(catalogDataInf.j);
        if (catalogDataInf.j.equals("<unknown>")) {
            ajiVar.f().setVisibility(4);
        } else {
            String str = catalogDataInf.o != 1 ? catalogDataInf.o + " " + this.c.getString(R.string.kDeviceLibrarySongs_Str) : catalogDataInf.o + " " + this.c.getString(R.string.kDeviceLibrarySong_Str);
            String str2 = catalogDataInf.k != 1 ? catalogDataInf.k + " " + this.c.getString(R.string.kDeezer_Albums_Str) : catalogDataInf.k + " " + this.c.getString(R.string.kDeezer_Album_Str);
            ajiVar.f().setVisibility(0);
            ajiVar.f().setText(str2 + "  " + str);
        }
        int color = Color.parseColor("#000000");
        Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
        ajiVar.a().setTag(catalogDataInf.a());
        afh.a((String) null, 1);
        new ahw().a(ajiVar.a(), catalogDataInf.i, R.drawable.empty_cover_art_small, ahw.a);
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
        return this.c.getString(R.string.LibNav_Artist_Str);
    }

    @Override // defpackage.aiy
    protected aif.b d() {
        return aif.b.ARTIST;
    }
}
