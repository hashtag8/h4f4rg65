package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.bif;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class aij extends BaseAdapter {
    LayoutInflater a;
    DashboardActivity b;
    public Cursor c;
    int d;
    CatalogDataInf e;

    public aij(DashboardActivity dashboardActivity, CatalogDataInf catalogDataInf) {
        this.b = dashboardActivity;
        this.a = LayoutInflater.from(this.b);
        this.e = catalogDataInf;
    }

    public void a(Cursor cursor) {
        this.c = cursor;
        this.d = cursor.getColumnIndex("album");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.getCount();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocalMusicData getItem(int i) {
        return new LocalMusicData(i, this.c);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.a.inflate(R.layout.dashboard_artistlistview_item, (ViewGroup) null);
            view.setTag(new a());
        }
        final a aVar = (a) view.getTag();
        LocalMusicData item = getItem(i);
        int iE = e(i);
        View viewFindViewById = view.findViewById(R.id.view_header);
        Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), item.album_id);
        aVar.a = (StoredBitmapImageView) viewFindViewById.findViewById(R.id.iv);
        if (iE == 1) {
            viewFindViewById.setVisibility(0);
            aVar.b = (TextView) viewFindViewById.findViewById(R.id.song);
            aVar.b.setText(item.album);
            aVar.d = (TextView) viewFindViewById.findViewById(R.id.artist);
            aVar.d.setText(this.e.m);
            aVar.c = (ImageView) viewFindViewById.findViewById(R.id.iv_more);
            aVar.e = (TextView) viewFindViewById.findViewById(R.id.tracks_count);
            aVar.g = (ImageView) viewFindViewById.findViewById(R.id.shuffle_button);
            aVar.g.setOnClickListener(new View.OnClickListener() { // from class: aij.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aij.this.b.a(new Runnable() { // from class: aij.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aij.this.c.moveToPosition(i);
                            new aqg(6, aij.this.c, new Random().nextInt(aij.this.d(i)) + i, aij.this.c.getString(aij.this.d)).execute(new String[0]);
                            aij.this.b.U();
                        }
                    });
                }
            });
            int iD = d(i);
            String str = "Tracks: " + iD;
            if (iD < 2) {
                aVar.g.setVisibility(8);
            } else {
                aVar.g.setVisibility(0);
            }
            if (item.first_year != 0) {
                str = str + "  ·  " + item.first_year;
            }
            aVar.e.setText(str);
            aVar.f = (TextView) viewFindViewById.findViewById(R.id.duration);
            aVar.f.setText(art.a(c(i)));
            aVar.c.setOnClickListener(new aqr(this.b) { // from class: aij.2
                @Override // defpackage.aqr
                protected void a() {
                }

                @Override // defpackage.aqr
                protected void a(int i2) {
                    aij.this.a(i2, i);
                }
            });
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = view.findViewById(R.id.view_main);
        aVar.k = (TextView) viewFindViewById2.findViewById(R.id.song);
        aVar.k.setText(item.musicName);
        aVar.k.setTextColor(-1);
        aVar.h = (TextView) viewFindViewById2.findViewById(R.id.song_duration);
        aVar.h.setText(art.a(item.duration));
        aVar.h.setTextColor(this.b.getResources().getColor(R.color.white_50));
        aVar.h.setVisibility(0);
        aVar.i = (TextView) viewFindViewById2.findViewById(R.id.album);
        aVar.i.setVisibility(8);
        aVar.j = (TextView) viewFindViewById2.findViewById(R.id.number);
        aVar.j.setText(String.valueOf(iE));
        aVar.a.setStoredBitmap(null);
        bif.a((Context) this.b).a(uriWithAppendedId).a(R.drawable.empty_cover_art_small).a((bip) new ahr(new bip() { // from class: aij.3
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
        aVar.l = (ImageView) viewFindViewById2.findViewById(R.id.iv_more);
        aVar.l.setOnClickListener(new aqr(this.b) { // from class: aij.4
            @Override // defpackage.aqr
            protected void a() {
            }

            @Override // defpackage.aqr
            protected void a(int i2) {
            }
        });
        aVar.l.setTag(item);
        aVar.l.setImageResource(R.drawable.playlist_more);
        ((ImageView) viewFindViewById2.findViewById(R.id.iv)).setVisibility(8);
        new ahw().a(aVar.a, item.album_id, R.drawable.empty_cover_art_small, ahw.a);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (aof.a().d().size() > 0) {
            new aqg(i, this.c, i2, b(i2)).execute(new String[0]);
            this.b.U();
            return;
        }
        this.b.b((Runnable) null);
    }

    private long c(int i) {
        String string = this.c.getString(this.d);
        long j = this.c.getLong(this.c.getColumnIndex("duration"));
        while (this.c.moveToNext() && this.c.getString(this.d).equals(string)) {
            j += this.c.getLong(this.c.getColumnIndex("duration"));
        }
        this.c.moveToPosition(i);
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i) {
        String string = this.c.getString(this.d);
        int i2 = 1;
        while (this.c.moveToNext() && this.c.getString(this.d).equals(string)) {
            i2++;
        }
        this.c.moveToPosition(i);
        return i2;
    }

    private int e(int i) {
        String string = this.c.getString(this.d);
        int i2 = 1;
        while (this.c.moveToPrevious() && this.c.getString(this.d).equals(string)) {
            i2++;
        }
        this.c.moveToPosition(i);
        return i2;
    }

    public String b(int i) {
        int position = this.c.getPosition();
        this.c.moveToPosition(i);
        String string = this.c.getString(this.c.getColumnIndex("album"));
        this.c.moveToPosition(position);
        return string;
    }

    class a {
        public StoredBitmapImageView a;
        public TextView b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public ImageView g;
        public TextView h;
        public TextView i;
        public TextView j;
        public TextView k;
        public ImageView l;

        private a() {
        }
    }
}
