package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class ayh extends ajj {
    public View a;
    public LayoutInflater b;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (ahh.e(this.ae)) {
            return super.a(layoutInflater, viewGroup, bundle);
        }
        Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
        return super.a(layoutInflater, viewGroup, bundle);
    }

    public void a(MusicData musicData) {
        if (aof.a().l()) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        aff.b = 2004;
        if (!aw()) {
            p().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().b(musicData);
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }
}
