package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.azu;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class azx {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    ImageView e;
    ImageView f;
    Context g;
    azm h;
    RelativeLayout i;

    public void a(Context context) {
        this.g = context;
    }

    public void a(View view, boolean z) {
        if (!z) {
            this.a = (TextView) view.findViewById(R.id.rdio_simple_artist_label);
            this.a.setTypeface(ahu.a(this.g));
            this.b = (TextView) view.findViewById(R.id.rdio_simple_title_label);
            this.b.setTypeface(ahu.a(this.g));
            this.c = (TextView) view.findViewById(R.id.rdio_simple_duration_label);
            this.c.setTypeface(ahu.a(this.g));
            this.d = (TextView) view.findViewById(R.id.rdio_simple_order_label);
            this.d.setTypeface(ahu.a(this.g));
            this.e = (ImageView) view.findViewById(R.id.rdio_track_more_options);
        } else {
            this.b = (TextView) view.findViewById(R.id.rdio_simple_album_title_label);
            this.b.setTypeface(ahu.a(this.g));
            this.c = (TextView) view.findViewById(R.id.rdio_simple_album_duration_label);
            this.c.setTypeface(ahu.a(this.g));
            this.d = (TextView) view.findViewById(R.id.rdio_simple_album_order_label);
            this.d.setTypeface(ahu.a(this.g));
            this.e = (ImageView) view.findViewById(R.id.rdio_track_album_more_options);
        }
        this.f = (ImageView) view.findViewById(R.id.iv);
    }

    public void a(azm azmVar, int i, azu.b bVar) {
        try {
            this.h = azmVar;
            this.i = (RelativeLayout) ((DashboardActivity) this.g).findViewById(R.id.parent);
            long jD = this.h.d();
            String str = String.format("%d:%02d", Long.valueOf(TimeUnit.SECONDS.toMinutes(jD)), Long.valueOf(TimeUnit.SECONDS.toSeconds(jD) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(jD))));
            if (bVar == azu.b.EListTypePlaylists) {
                if (this.h.c() == null || this.h.c().isEmpty()) {
                    this.a.setVisibility(4);
                } else {
                    this.a.setText(this.h.c());
                    this.a.setVisibility(0);
                }
            }
            this.c.setText(str);
            this.b.setText(this.h.b());
            this.d.setText("" + (i + 1));
            this.f.setWillNotCacheDrawing(false);
            new ahw().a(this.f, this.h.a());
            this.e.setOnClickListener(new View.OnClickListener() { // from class: azx.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    arz arzVar = new arz(azx.this.g);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(azx.this.g.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(azx.this.g.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(azx.this.g.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(azx.this.g.getString(R.string.PlayTip_ClearAll_Str));
                    arzVar.a(arrayList);
                    arzVar.a(azx.this.g.getString(R.string.PlayTip_Title_Str));
                    arzVar.a(new asi() { // from class: azx.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            if (!aof.a().l() || ain.j) {
                                switch (i2) {
                                    case 0:
                                        azx.this.a(azx.this.h.e());
                                        break;
                                    case 1:
                                        azx.this.b(azx.this.h.e());
                                        break;
                                    case 2:
                                        azx.this.c(azx.this.h.e());
                                        break;
                                    case 3:
                                        azx.this.d(azx.this.h.e());
                                        break;
                                }
                            }
                            Toast.makeText(azx.this.g, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
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
