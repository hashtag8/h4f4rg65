package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.aif;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ajh extends aiy<MusicData> {
    AdapterView.OnItemClickListener a;
    ajn b;
    private View.OnClickListener g;

    public ajh(DashboardActivity dashboardActivity, aix aixVar, ListView listView) {
        super(dashboardActivity, aixVar, listView);
        this.g = new View.OnClickListener() { // from class: ajh.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final MusicData musicData = (MusicData) view.getTag();
                arz arzVar = new arz(ajh.this.c);
                ArrayList arrayList = new ArrayList();
                arrayList.add(ajh.this.c.getString(R.string.PlayTip_PlayNow_Str));
                arrayList.add(ajh.this.c.getString(R.string.PlayTip_PlayNext_Str));
                arrayList.add(ajh.this.c.getString(R.string.PlayTip_AddSongToQueue_Str));
                arrayList.add(ajh.this.c.getString(R.string.PlayTip_ClearAll_Str));
                arzVar.a(arrayList);
                arzVar.a(ajh.this.c.getString(R.string.PlayTip_Title_Str));
                arzVar.a(new asi() { // from class: ajh.1.1
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
                new asc(arzVar).a(ajh.this.c);
            }
        };
        this.a = new AdapterView.OnItemClickListener() { // from class: ajh.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                ajh.this.c.a(new Runnable() { // from class: ajh.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ajh.this.f != null) {
                            LocalMusicData localMusicData = new LocalMusicData(i, ajh.this.f, "Songs");
                            if (localMusicData.isLegal) {
                                MusicPlaylistManager.a().a(localMusicData);
                            }
                        }
                    }
                });
            }
        };
        this.b = new ajn() { // from class: ajh.3
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (obj != null) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().a((MusicData) obj);
                    ajh.this.c.U();
                }
            }
        };
    }

    @Override // aif.a
    public View a(int i, View view, ViewGroup viewGroup, MusicData musicData) {
        aji ajiVar;
        aji ajiVar2 = (aji) view.getTag();
        if (ajiVar2 == null) {
            aji ajiVar3 = new aji();
            ajiVar3.c((TextView) view.findViewById(R.id.number));
            ajiVar3.a((StoredBitmapImageView) view.findViewById(R.id.iv));
            ajiVar3.a((TextView) view.findViewById(R.id.song));
            ajiVar3.b((TextView) view.findViewById(R.id.album));
            ajiVar3.a((ImageView) view.findViewById(R.id.iv_more));
            view.setTag(ajiVar3);
            ajiVar = ajiVar3;
        } else {
            ajiVar = ajiVar2;
        }
        view.findViewById(R.id.dashboard_item_border).setBackgroundColor(this.c.getResources().getColor(R.color.dashboard_divider_color));
        ajiVar.d().setOnClickListener(this.g);
        ajiVar.d().setTag(musicData);
        ajiVar.b().setText(musicData.musicName);
        ajiVar.c().setVisibility(0);
        ajiVar.c().setText(musicData.artist + " - " + musicData.album);
        ajiVar.a().setTag(musicData.getBitmapUrl());
        afh.a(musicData.genre, 1);
        new ahw().a(ajiVar.a(), musicData.album_id, R.drawable.empty_cover_art_small, ahw.a);
        ajiVar.e().setVisibility(8);
        ajiVar.d().setImageResource(R.drawable.playlist_more);
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
        return this.c.getString(R.string.LibNav_Song_Str);
    }

    @Override // defpackage.aiy
    protected aif.b d() {
        return aif.b.SONG;
    }
}
