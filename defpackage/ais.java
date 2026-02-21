package defpackage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class ais extends aix {
    private CatalogDataInf a;
    private Drawable ah;
    private AdapterView.OnItemClickListener ai = new AdapterView.OnItemClickListener() { // from class: ais.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
            ais.this.ae.a(new Runnable() { // from class: ais.1.1
                @Override // java.lang.Runnable
                public void run() {
                    new aqg("Artists", 5, ais.this.h.c, i, ais.this.h.b(i)).execute(new String[0]);
                    ais.this.ae.U();
                }
            });
        }
    };
    private ajn aj = new ajn() { // from class: ais.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().a((MusicData) obj);
                ais.this.ae.U();
            }
        }
    };
    private TextView b;
    private DashboardScrubberListView g;
    private aij h;
    private afp<a> i;

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewA = super.a(layoutInflater, viewGroup, bundle);
        this.b = (TextView) viewA.findViewById(R.id.listview_tips);
        this.g = (DashboardScrubberListView) viewA.findViewById(R.id.listview);
        this.g.a();
        this.c = viewA.findViewById(R.id.listview_layout);
        this.i = new afp<>(new Handler(), new a());
        this.a = (CatalogDataInf) l().getParcelable("CatalogDataInf");
        this.ah = new BitmapDrawable(this.ae.getResources(), (Bitmap) l().getParcelable("BlurBackground"));
        ajo ajoVar = new ajo(this.ae, this.c);
        ajoVar.a(this.aj);
        this.g.setOnTouchListener(ajoVar);
        this.h = new aij(this.ae, this.a);
        this.g.setAdapter((ListAdapter) this.h);
        this.g.setOnItemClickListener(this.ai);
        c("");
        return viewA;
    }

    @Override // defpackage.aix, defpackage.ajj
    public ajv b() {
        return new ajv.a().k(R.drawable.search_close_button).a(this.ah).c(false).a("").c();
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void a(Cursor cursor) {
            ais.this.d(2);
            ais.this.ao();
            if (cursor.getCount() == 0) {
                ais.this.g.setVisibility(8);
                ais.this.b.setVisibility(0);
            } else {
                ais.this.b.setVisibility(8);
                ais.this.g.setVisibility(0);
            }
            ais.this.h.a(cursor);
            ais.this.h.notifyDataSetChanged();
        }
    }

    @Override // defpackage.aix
    public void b(String str) {
        ap().b(this.a.h, 0, 0);
    }

    @Override // defpackage.aix
    public void c() {
    }

    @Override // defpackage.aix
    public afq d() {
        return this.i;
    }
}
