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
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;

/* JADX INFO: loaded from: classes.dex */
public class aiu extends aiy<CatalogDataInf> {
    AdapterView.OnItemClickListener a;
    ajn b;

    public aiu(DashboardActivity dashboardActivity, aix aixVar, ListView listView) {
        super(dashboardActivity, aixVar, listView);
        this.a = new AdapterView.OnItemClickListener() { // from class: aiu.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final aiz aizVar = new aiz("Album");
                final Bundle bundle = new Bundle();
                bundle.putInt("parentType", 32);
                bundle.putParcelable("CatalogDataInf", (CatalogDataInf) adapterView.getItemAtPosition(i));
                agx.a().a(ahe.a(aiu.this.e.getChildAt(i - aiu.this.e.getFirstVisiblePosition()).findViewById(R.id.iv)), false, new agw() { // from class: aiu.2.1
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        bundle.putParcelable("BlurBackground", bitmap);
                        aizVar.g(bundle);
                        aiu.this.c.q().a(aizVar, (arc) null);
                    }
                });
            }
        };
        this.b = new ajn() { // from class: aiu.3
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (obj != null) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().e(afm.a((CatalogDataInf) obj, aiu.this.c));
                    aiu.this.c.U();
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
        ajiVar.d().setOnClickListener(new aqr(this.c) { // from class: aiu.1
            @Override // defpackage.aqr
            protected void a() {
            }

            @Override // defpackage.aqr
            protected void a(int i2) throws Throwable {
                new ajz().a(catalogDataInf, i2, aiu.this.c);
            }
        });
        ajiVar.b().setText(catalogDataInf.j);
        ajiVar.f().setText(catalogDataInf.o != 1 ? catalogDataInf.o + " " + this.c.getString(R.string.kDeviceLibrarySongs_Str) : catalogDataInf.o + " " + this.c.getString(R.string.kDeviceLibrarySong_Str));
        int color = Color.parseColor("#000000");
        Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
        ajiVar.a().setTag(catalogDataInf.a());
        new ahw().a(ajiVar.a(), catalogDataInf.h, R.drawable.empty_cover_art_small, ahw.a);
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
        return this.c.getString(R.string.LibNav_Album_Str);
    }

    @Override // defpackage.aiy
    protected aif.b d() {
        return aif.b.ALBUM;
    }
}
