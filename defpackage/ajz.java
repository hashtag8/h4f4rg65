package defpackage;

import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.ui.DashboardActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ajz {
    public void a(CatalogDataInf catalogDataInf, int i, DashboardActivity dashboardActivity) throws Throwable {
        List<MusicData> listA = afm.a(catalogDataInf, dashboardActivity);
        switch (i) {
            case 1:
                MusicPlaylistManager.a().e(listA);
                break;
            case 2:
                MusicPlaylistManager.a().c(listA);
                break;
            case 3:
                MusicPlaylistManager.a().d(listA);
                break;
            case 4:
                MusicPlaylistManager.a().g();
                MusicPlaylistManager.a().e(listA);
                break;
        }
        dashboardActivity.U();
    }
}
