package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ang {
    private static DashboardActivity a;
    private static ProgressDialog b;

    public static void a(Context context, int i, MusicData musicData, List<MusicData> list, ProgressDialog progressDialog) {
        a = (DashboardActivity) context;
        b = progressDialog;
        switch (i) {
            case 0:
                if (aof.a().l()) {
                    Toast.makeText(a, a.getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                } else if (!musicData.isLegal) {
                    Toast.makeText(a, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                } else if (musicData.songId == -1000) {
                    a(list);
                } else {
                    a(musicData);
                }
                break;
            case 1:
                if (aof.a().l()) {
                    Toast.makeText(a, a.getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                } else if (!musicData.isLegal) {
                    Toast.makeText(a, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                } else if (musicData.songId == -1000) {
                    b(list);
                } else {
                    b(musicData);
                }
                break;
            case 2:
                if (aof.a().l()) {
                    Toast.makeText(a, a.getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                } else if (!musicData.isLegal) {
                    Toast.makeText(a, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                } else if (musicData.songId == -1000) {
                    c(list);
                } else {
                    c(musicData);
                }
                break;
            case 3:
                if (aof.a().l()) {
                    Toast.makeText(a, a.getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                } else if (!musicData.isLegal) {
                    Toast.makeText(a, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                } else if (musicData.songId == -1000) {
                    d(list);
                } else {
                    d(musicData);
                }
                break;
        }
    }

    private static void a(List<MusicData> list) {
        MusicPlaylistManager.a().e(list);
    }

    private static void b(List<MusicData> list) {
        MusicPlaylistManager.a().c(list);
    }

    private static void c(List<MusicData> list) {
        MusicPlaylistManager.a().d(list);
    }

    private static void d(List<MusicData> list) {
        MusicPlaylistManager.a().g();
        MusicPlaylistManager.a().b(list);
    }

    private static void a(MusicData musicData) {
        MusicPlaylistManager.a().a(musicData);
    }

    private static void b(MusicData musicData) {
        MusicPlaylistManager.a().c(musicData);
    }

    private static void c(MusicData musicData) {
        MusicPlaylistManager.a().d(musicData);
    }

    private static void d(MusicData musicData) {
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().b(musicData);
    }
}
