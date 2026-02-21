package defpackage;

import android.database.Cursor;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.ScrubberList.DashboardScrubberListView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import defpackage.aix;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ajg extends aix {
    private TextView a;
    private afp<a> ah;
    private Cursor ai;
    private long aj;
    private View ak;
    private ajn al = new ajn() { // from class: ajg.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (obj != null) {
                MusicPlaylistManager.a().a((MusicData) obj);
                ajg.this.ae.U();
            }
        }
    };
    private AdapterView.OnItemClickListener am = new AdapterView.OnItemClickListener() { // from class: ajg.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
            ajg.this.ae.a(new Runnable() { // from class: ajg.2.1
                @Override // java.lang.Runnable
                public void run() {
                    new aqg("Songs", 5, ajg.this.ai, i).execute(new String[0]);
                    ajg.this.ae.U();
                }
            });
        }
    };
    private View.OnClickListener an = new ahl(this) { // from class: ajg.3
        @Override // defpackage.ahl
        public void a(View view) {
            final MusicData musicData = (MusicData) view.getTag();
            arz arzVar = new arz(ajg.this.ae);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ajg.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(ajg.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(ajg.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(ajg.this.ae.getString(R.string.PlayTip_ClearAll_Str));
            arzVar.a(arrayList);
            arzVar.a(ajg.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: ajg.3.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                            MusicPlaylistManager.a().a(musicData);
                            break;
                        case 1:
                            MusicPlaylistManager.a().c(musicData);
                            break;
                        case 2:
                            MusicPlaylistManager.a().d(musicData);
                            break;
                        case 3:
                            MusicPlaylistManager.a().g();
                            MusicPlaylistManager.a().b(musicData);
                            break;
                    }
                }
            });
            arzVar.show();
        }
    };
    private ImageView b;
    private DashboardScrubberListView g;
    private afj h;
    private aif<MusicData> i;

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = super.a(layoutInflater, viewGroup, bundle);
        this.h = afj.a(2001);
        this.a = (TextView) this.ak.findViewById(R.id.listview_tips);
        this.b = (ImageView) this.ak.findViewById(R.id.listview_tips_icon);
        this.g = (DashboardScrubberListView) this.ak.findViewById(R.id.listview);
        this.c = this.ak.findViewById(R.id.listview_layout);
        this.aj = this.h.a();
        this.i = new aif<>(this.ae, new b(), R.layout.dashboard_listview_item);
        this.g.setAdapter((ListAdapter) this.i);
        this.g.setFastScrollEnabled(true);
        this.g.setIndexScrollerListener(this);
        this.e = new ajo(this.ae, this.c);
        this.e.a(this.al);
        this.g.setOnTouchListener(this.e);
        this.g.setOnItemClickListener(this.am);
        this.ah = new afp<>(new Handler(), new a());
        c(ahi.a() ? "" : "notGranted");
        return this.ak;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.aix
    public void b(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            if (this.ak != null) {
                an();
                this.h.a(0, (int) this.aj, str);
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
        if (this.ae != null) {
            this.h.a(this.ah, 4);
        }
    }

    class a extends afq {
        private a() {
        }

        @Override // defpackage.afq
        public void a(Cursor cursor) {
            ajg.this.d(2);
            ajg.this.ao();
            ajg.this.ai = cursor;
            if (ajg.this.ai.getCount() < 30) {
                ajg.this.g.b();
            } else {
                ajg.this.g.c();
            }
            if (ajg.this.ai.getCount() == 0) {
                ajg.this.g.setVisibility(8);
                ajg.this.a.setVisibility(0);
                ajg.this.b.setVisibility(0);
            } else {
                ajg.this.a.setVisibility(8);
                ajg.this.b.setVisibility(8);
                ajg.this.g.setVisibility(0);
            }
            ajg.this.i.a(ajg.this.ai, aif.b.SONG);
            ajg.this.i.notifyDataSetChanged();
            ajg.this.i.a = false;
        }
    }

    class b implements aif.a<MusicData> {
        b() {
        }

        @Override // aif.a
        public View a(int i, View view, ViewGroup viewGroup, MusicData musicData) {
            aix.a aVar;
            aix.a aVar2 = (aix.a) view.getTag();
            if (aVar2 == null) {
                aix.a aVar3 = new aix.a();
                aVar3.f = (TextView) view.findViewById(R.id.number);
                aVar3.a = (StoredBitmapImageView) view.findViewById(R.id.iv);
                aVar3.c = (TextView) view.findViewById(R.id.song);
                aVar3.d = (TextView) view.findViewById(R.id.album);
                aVar3.e = (ImageView) view.findViewById(R.id.iv_more);
                view.setTag(aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            view.findViewById(R.id.dashboard_item_border).setBackgroundColor(ajg.this.q().getColor(R.color.dashboard_divider_color));
            if (ajg.this.aj < 30) {
                ((RelativeLayout.LayoutParams) view.findViewById(R.id.dashboard_item_border).getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            aVar.e.setOnClickListener(ajg.this.an);
            aVar.e.setTag(musicData);
            aVar.c.setText(musicData.musicName);
            aVar.d.setVisibility(0);
            aVar.d.setText(musicData.artist + " - " + musicData.album);
            aVar.a.setTag(musicData.getBitmapUrl());
            afh.a(musicData.genre, 1);
            new ahw().a(aVar.a, musicData.album_id, R.drawable.empty_cover_art_small, ahw.a);
            aVar.f.setVisibility(8);
            aVar.e.setImageResource(R.drawable.playlist_more);
            int color = Color.parseColor("#000000");
            aVar.e.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)), PorterDuff.Mode.MULTIPLY);
            return view;
        }
    }

    @Override // defpackage.aix
    public afq d() {
        return this.ah;
    }
}
