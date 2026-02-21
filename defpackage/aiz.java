package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.library.musicdata.PlayListData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import defpackage.aix;
import defpackage.ajv;
import defpackage.bif;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class aiz extends aix {
    private int a;
    private afp<a> ah;
    private LayoutInflater ai;
    private Cursor aj;
    private Drawable ak;
    private TextView al;
    private TextView am;
    private String an;
    private ImageView ao;
    private ImageView ap;
    private ajn aq = new ajn() { // from class: aiz.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj == null) {
                if (i == 0 && aiz.this.a == 32) {
                    aiz.this.b(false);
                    return;
                }
                return;
            }
            MusicPlaylistManager.a().a((MusicData) obj);
            aiz.this.ae.U();
        }
    };
    private AdapterView.OnItemClickListener ar = new AdapterView.OnItemClickListener() { // from class: aiz.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
            aiz.this.ae.a(new Runnable() { // from class: aiz.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aiz.this.a == 32 || aiz.this.a == 1) {
                        new aqg(aiz.this.an, 5, aiz.this.aj, i + (-1) < 0 ? 0 : i - 1).execute(new String[0]);
                    } else {
                        new aqg(aiz.this.an, 5, aiz.this.aj, i).execute(new String[0]);
                    }
                    aiz.this.ae.U();
                }
            });
        }
    };
    private CatalogDataInf b;
    private TextView g;
    private DashboardScrubberListView h;
    private aif<MusicData> i;

    public aiz() {
    }

    @SuppressLint({"ValidFragment"})
    public aiz(String str) {
        this.an = str;
    }

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewA = super.a(layoutInflater, viewGroup, bundle);
        this.ai = layoutInflater;
        this.g = (TextView) viewA.findViewById(R.id.listview_tips);
        this.h = (DashboardScrubberListView) viewA.findViewById(R.id.listview);
        this.c = viewA.findViewById(R.id.listview_layout);
        this.i = new aif<>(this.ae, new b(), R.layout.dashboard_listview_item);
        this.a = l().getInt("parentType");
        this.b = (CatalogDataInf) l().getParcelable("CatalogDataInf");
        if (this.a == 32) {
            this.h.a();
        } else {
            this.h.setFastScrollEnabled(true);
            this.h.setIndexScrollerListener(this);
        }
        if (this.a == 32 || this.a == 1) {
            a(this.h);
            this.ak = new BitmapDrawable(this.ae.getResources(), (Bitmap) l().getParcelable("BlurBackground"));
        }
        this.h.setAdapter((ListAdapter) this.i);
        ajo ajoVar = new ajo(this.ae, this.c);
        ajoVar.a(this.aq);
        this.h.setOnTouchListener(ajoVar);
        this.h.setOnItemClickListener(this.ar);
        this.ah = new afp<>(new Handler(), new a());
        c("");
        return viewA;
    }

    @Override // defpackage.aix
    public void b(String str) {
        an();
        switch (this.a) {
            case 1:
                ap().d(this.b.h, 0, 0);
                break;
            case 8:
                ap().b(this.b.h, 0, 0);
                break;
            case 16:
                ap().c(this.b.h, 0, 0);
                break;
            case 32:
                ap().a(this.b.h, 0, 0);
                break;
        }
    }

    @Override // defpackage.aix
    public void c() {
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    private void a(DashboardScrubberListView dashboardScrubberListView) {
        View viewInflate = this.ai.inflate(R.layout.dashboard_large_listview_item, (ViewGroup) null);
        this.ao = (ImageView) viewInflate.findViewById(R.id.iv);
        TextView textView = (TextView) viewInflate.findViewById(R.id.song);
        this.ap = (ImageView) viewInflate.findViewById(R.id.shuffle_button);
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_more);
        if ((this.a == 32 && (this.b instanceof AlbumData)) || (this.a == 1 && (this.b instanceof PlayListData))) {
            ((TextView) viewInflate.findViewById(R.id.artist)).setText(this.b.m);
            this.am = (TextView) viewInflate.findViewById(R.id.tracks_count);
            String str = a(R.string.kQobuz_Tracks_Str) + ": " + this.b.o;
            if (this.b.p != 0) {
                str = str + "  ·  " + this.b.p;
            }
            this.am.setText(str);
            this.al = (TextView) viewInflate.findViewById(R.id.duration);
        }
        ax();
        imageView.setImageResource(R.drawable.playlist_more);
        textView.setText(this.b.j);
        a(this.ao);
        imageView.setOnClickListener(new aqr(this.ae) { // from class: aiz.2
            @Override // defpackage.aqr
            protected void a() {
                imageView.setTag(aiz.this.aj);
            }

            @Override // defpackage.aqr
            protected void a(int i) {
            }
        });
        this.ap.setOnClickListener(new View.OnClickListener() { // from class: aiz.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aiz.this.ae.a(new Runnable() { // from class: aiz.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aiz.this.b(true);
                    }
                });
            }
        });
        dashboardScrubberListView.addHeaderView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.aj.moveToFirst();
        new aqg(6, this.aj, z ? new Random().nextInt(this.aj.getCount()) : 0).execute(new String[0]);
        this.ae.U();
    }

    private void a(ImageView imageView) {
        imageView.setTag(this.b.a());
        new ahw().a(imageView, ((this.b instanceof ArtistData) || (this.b instanceof PlayListData)) ? this.b.i : this.b.h, R.drawable.empty_cover_art_small, ahw.a);
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void a(Cursor cursor) {
            aiz.this.d(2);
            aiz.this.ao();
            aiz.this.aj = cursor;
            if (aiz.this.aj.getCount() == 0) {
                aiz.this.h.setVisibility(8);
                aiz.this.g.setVisibility(0);
            } else {
                aiz.this.g.setVisibility(8);
                aiz.this.h.setVisibility(0);
                if (aiz.this.a != 32 || !(aiz.this.b instanceof AlbumData)) {
                    if (aiz.this.a == 1 && (aiz.this.b instanceof PlayListData) && !aiz.this.aw() && !aiz.this.w()) {
                        aiz.this.al.setText(art.a(aiz.this.ay()));
                        aiz.this.al.invalidate();
                        aiz.this.b.o = aiz.this.aj.getCount();
                        aiz.this.am.setText(aiz.this.a(R.string.kQobuz_Tracks_Str) + ": " + aiz.this.b.o);
                        aiz.this.ax();
                    }
                } else {
                    aiz.this.al.setText(art.a(aiz.this.ay()));
                    aiz.this.al.invalidate();
                }
            }
            aiz.this.i.a(aiz.this.aj, aif.b.SONG);
            aiz.this.i.notifyDataSetChanged();
            aiz.this.i.a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        if (this.b.o < 2) {
            this.ap.setVisibility(8);
        } else {
            this.ap.setVisibility(0);
        }
    }

    @Override // defpackage.aix, defpackage.ajj
    public ajv b() {
        if (this.a != 16) {
            return new ajv.a().k(R.drawable.search_close_button).a(this.ak).c(false).a("").c();
        }
        return new ajv.a().d(false).a(this.b.j).a(q().getColor(R.color.black)).c(false).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ay() {
        this.aj.moveToPosition(0);
        long j = this.aj.getLong(this.aj.getColumnIndex("duration"));
        while (this.aj.moveToNext()) {
            j += this.aj.getLong(this.aj.getColumnIndex("duration"));
        }
        this.aj.moveToPosition(0);
        return j;
    }

    class b implements aif.a<MusicData> {
        b() {
        }

        @Override // aif.a
        public View a(int i, View view, ViewGroup viewGroup, MusicData musicData) {
            final aix.a aVar;
            int color;
            aix.a aVar2 = (aix.a) view.getTag();
            if (aVar2 == null) {
                aix.a aVar3 = new aix.a();
                aVar3.f = (TextView) view.findViewById(R.id.number);
                aVar3.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                aVar3.c = (TextView) view.findViewById(R.id.song);
                aVar3.d = (TextView) view.findViewById(R.id.album);
                aVar3.e = (ImageView) view.findViewById(R.id.iv_more);
                aVar3.b = (TextView) view.findViewById(R.id.song_duration);
                view.setTag(aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aiz.this.an != null && aiz.this.an.equals("Genres")) {
                view.findViewById(R.id.dashboard_item_border).setBackgroundColor(aiz.this.q().getColor(R.color.dashboard_divider_color));
                ((RelativeLayout.LayoutParams) view.findViewById(R.id.dashboard_item_border).getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            LocalMusicData localMusicData = new LocalMusicData(i, aiz.this.aj);
            aVar.e.setTag(localMusicData);
            aVar.e.setOnClickListener(new aqr(aiz.this.ae) { // from class: aiz.b.1
                @Override // defpackage.aqr
                protected void a() {
                }

                @Override // defpackage.aqr
                protected void a(int i2) {
                }
            });
            aVar.c.setText(localMusicData.musicName);
            aVar.e.setImageResource(R.drawable.playlist_more);
            int color2 = aiz.this.ae.getResources().getColor(R.color.white);
            if (aiz.this.a == 1 || aiz.this.a == 16) {
                aVar.d.setVisibility(0);
                aVar.d.setText(localMusicData.artist + " - " + localMusicData.album);
                aVar.a.setVisibility(0);
                new ahw().a(aVar.a, localMusicData.album_id, R.drawable.empty_cover_art_small, ahw.a);
                aVar.f.setVisibility(8);
                if (aiz.this.a == 1) {
                    aVar.c.setTextColor(aiz.this.ae.getResources().getColor(R.color.white));
                    aVar.d.setTextColor(aiz.this.ae.getResources().getColor(R.color.white_50));
                    aVar.b.setText(art.a(localMusicData.duration));
                    aVar.b.setTextColor(aiz.this.ae.getResources().getColor(R.color.white_50));
                    aVar.b.setVisibility(0);
                    color = color2;
                } else {
                    color = Color.parseColor("#000000");
                }
            } else {
                aVar.c.setTextColor(aiz.this.ae.getResources().getColor(R.color.white));
                aVar.d.setVisibility(8);
                aVar.f.setVisibility(0);
                aVar.f.setText(String.valueOf(i + 1));
                aVar.a.setVisibility(8);
                aVar.b.setText(art.a(localMusicData.duration));
                aVar.b.setTextColor(aiz.this.ae.getResources().getColor(R.color.white_50));
                aVar.b.setVisibility(0);
                Uri uri = Uri.parse("content://media/external/audio/media/" + localMusicData.songId + "/albumart");
                aVar.a.setStoredBitmap(null);
                bif.a((Context) aiz.this.ae).a(uri).a(R.drawable.empty_cover_art_small).a((bip) new ahr(new bip() { // from class: aiz.b.2
                    @Override // defpackage.bip
                    public void a(Bitmap bitmap, bif.d dVar) {
                        aVar.a.setStoredBitmap(bitmap);
                    }

                    @Override // defpackage.bip
                    public void a(Drawable drawable) {
                    }

                    @Override // defpackage.bip
                    public void b(Drawable drawable) {
                    }
                }));
                color = color2;
            }
            aVar.e.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)));
            return view;
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.ah;
    }
}
