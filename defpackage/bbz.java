package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.bif;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class bbz {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    ImageView e;
    ImageView f;
    ImageView g;
    RelativeLayout h;
    Context i;
    bbp j;
    RelativeLayout m;
    bbj k = new bbj();
    Bitmap l = null;
    private bip n = new bip() { // from class: bbz.2
        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            bbz.this.l = bitmap;
            bbz.this.e.setImageBitmap(bitmap);
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
            bbz.this.e.setImageResource(R.drawable.empty_cover_art_small);
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    };

    public void a(Context context) {
        this.i = context;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.sc_track_user);
        this.a.setTypeface(ahu.a(this.i));
        this.b = (TextView) view.findViewById(R.id.sc_track_song_title);
        this.b.setTypeface(ahu.a(this.i));
        this.c = (TextView) view.findViewById(R.id.sc_track_duration);
        this.c.setTypeface(ahu.a(this.i));
        this.d = (TextView) view.findViewById(R.id.sc_track_playback_count);
        this.d.setTypeface(ahu.a(this.i));
        this.e = (ImageView) view.findViewById(R.id.iv);
        this.g = (ImageView) view.findViewById(R.id.sc_track_more_options);
        this.f = (ImageView) view.findViewById(R.id.sc_play_icon);
        this.h = (RelativeLayout) view.findViewById(R.id.sc_track_playsong_layout);
    }

    public void a(bbp bbpVar) {
        try {
            this.m = (RelativeLayout) ((DashboardActivity) this.i).findViewById(R.id.parent);
            this.j = bbpVar;
            this.a.setText(this.j.b);
            if (!this.j.f.equals("")) {
                this.d.setText(this.j.f);
                this.d.setVisibility(0);
                this.f.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.f.setVisibility(8);
            }
            this.c.setText(this.j.d);
            this.b.setText(this.j.i);
            this.e.setImageResource(R.drawable.empty_cover_art_small);
            bif.a(this.i).a(this.j.e).a(this.n);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: bbz.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    arz arzVar = new arz(bbz.this.i);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bbz.this.i.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(bbz.this.i.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(bbz.this.i.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(bbz.this.i.getString(R.string.PlayTip_ClearAll_Str));
                    arzVar.a(arrayList);
                    arzVar.a(bbz.this.i.getString(R.string.PlayTip_Title_Str));
                    arzVar.a(new asi() { // from class: bbz.1.1
                        @Override // defpackage.asi
                        public void a(int i) {
                            if (!aof.a().l() || ain.j) {
                                switch (i) {
                                    case 0:
                                        bbz.this.a(bbz.this.j.r);
                                        break;
                                    case 1:
                                        bbz.this.b(bbz.this.j.r);
                                        break;
                                    case 2:
                                        bbz.this.c(bbz.this.j.r);
                                        break;
                                    case 3:
                                        bbz.this.d(bbz.this.j.r);
                                        break;
                                }
                            }
                            Toast.makeText(bbz.this.i, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                        }
                    });
                    arzVar.show();
                }
            });
        } catch (Exception e) {
        }
    }

    private void a(MusicData musicData, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MusicData musicData) {
        a(musicData, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MusicData musicData) {
        a(musicData, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MusicData musicData) {
        a(musicData, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MusicData musicData) {
        a(musicData, 3);
    }
}
