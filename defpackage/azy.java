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
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class azy {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    ImageView e;
    ImageView f;
    Context g;
    azm h;
    RelativeLayout j;
    Bitmap i = null;
    private bip k = new bip() { // from class: azy.2
        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            azy.this.i = bitmap;
            azy.this.d.setImageBitmap(bitmap);
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
            azy.this.d.setImageResource(R.drawable.empty_cover_art_small);
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    };

    public void a(Context context) {
        this.g = context;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.rdio_track_artist);
        this.a.setTypeface(ahu.a(this.g));
        this.b = (TextView) view.findViewById(R.id.rdio_track_song_title);
        this.b.setTypeface(ahu.a(this.g));
        this.c = (TextView) view.findViewById(R.id.rdio_track_duration);
        this.c.setTypeface(ahu.a(this.g));
        this.d = (ImageView) view.findViewById(R.id.iv);
        this.e = (ImageView) view.findViewById(R.id.rdio_track_more_options);
        this.f = (ImageView) view.findViewById(R.id.rdio_track_more_options2);
    }

    public void a(azm azmVar) {
        try {
            this.h = azmVar;
            this.j = (RelativeLayout) ((DashboardActivity) this.g).findViewById(R.id.parent);
            this.a.setText(this.h.c());
            long jD = this.h.d();
            this.c.setText(String.format("%d:%02d", Long.valueOf(TimeUnit.SECONDS.toMinutes(jD)), Long.valueOf(TimeUnit.SECONDS.toSeconds(jD) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(jD)))));
            this.b.setText(this.h.b());
            this.d.setImageResource(R.drawable.empty_cover_art_small);
            bif.a(this.g).a(this.h.a()).a(this.k);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: azy.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    arz arzVar = new arz(azy.this.g);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(azy.this.g.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(azy.this.g.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(azy.this.g.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(azy.this.g.getString(R.string.PlayTip_ClearAll_Str));
                    arzVar.a(arrayList);
                    arzVar.a(azy.this.g.getString(R.string.PlayTip_Title_Str));
                    arzVar.a(new asi() { // from class: azy.1.1
                        @Override // defpackage.asi
                        public void a(int i) {
                            if (!aof.a().l() || ain.j) {
                                switch (i) {
                                    case 0:
                                        azy.this.a(azy.this.h.e());
                                        break;
                                    case 1:
                                        azy.this.b(azy.this.h.e());
                                        break;
                                    case 2:
                                        azy.this.c(azy.this.h.e());
                                        break;
                                    case 3:
                                        azy.this.d(azy.this.h.e());
                                        break;
                                }
                            }
                            Toast.makeText(azy.this.g, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                        }
                    });
                    arzVar.show();
                }
            };
            this.e.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
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
                MusicPlaylistManager.a().h();
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
