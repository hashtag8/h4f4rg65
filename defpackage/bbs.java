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
public class bbs {
    TextView a;
    ImageView b;
    TextView c;
    ImageView d;
    Context e;
    bbp f;
    RelativeLayout h;
    Bitmap g = null;
    private bip i = new bip() { // from class: bbs.2
        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            bbs.this.g = bitmap;
            bbs.this.b.setImageBitmap(bitmap);
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
            bbs.this.b.setImageResource(R.drawable.empty_cover_art_small);
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    };

    public void a(Context context) {
        this.e = context;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.soundcloud_song_name);
        this.a.setTypeface(ahu.a(this.e));
        this.b = (ImageView) view.findViewById(R.id.iv);
        this.c = (TextView) view.findViewById(R.id.soundcloud_user);
        this.c.setTypeface(ahu.a(this.e));
        this.d = (ImageView) view.findViewById(R.id.soundcloud_more_options);
    }

    public void a(bbp bbpVar) {
        try {
            this.h = (RelativeLayout) ((DashboardActivity) this.e).findViewById(R.id.parent);
            this.f = bbpVar;
            this.c.setText(this.f.b);
            this.a.setText(this.f.i);
            this.b.setImageResource(R.drawable.empty_cover_art_small);
            bif.a(this.e).a(this.f.e).a(this.i);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: bbs.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    arz arzVar = new arz(bbs.this.e);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bbs.this.e.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(bbs.this.e.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(bbs.this.e.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(bbs.this.e.getString(R.string.PlayTip_ClearAll_Str));
                    arzVar.a(arrayList);
                    arzVar.a(bbs.this.e.getString(R.string.PlayTip_Title_Str));
                    arzVar.a(new asi() { // from class: bbs.1.1
                        @Override // defpackage.asi
                        public void a(int i) {
                            if (!aof.a().l() || ain.j) {
                                switch (i) {
                                    case 0:
                                        bbs.this.a(bbs.this.f.r);
                                        break;
                                    case 1:
                                        bbs.this.b(bbs.this.f.r);
                                        break;
                                    case 2:
                                        bbs.this.c(bbs.this.f.r);
                                        break;
                                    case 3:
                                        bbs.this.d(bbs.this.f.r);
                                        break;
                                }
                            }
                            Toast.makeText(bbs.this.e, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
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
