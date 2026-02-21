package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.ui.HarmanApplication;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class auz {
    protected int a;
    protected Activity b;

    public abstract void a(JSONObject jSONObject);

    public abstract boolean a();

    public abstract void b();

    public void d() {
        MusicPlaylistManager.a().a(MusicData.getTypeFromHCConstantValue(this.a));
        Intent intent = new Intent("com.harman.hkconnect.ui.queueShouldClearOnLogOutAction");
        intent.putExtra("Service", this.a);
        HarmanApplication.a().sendBroadcast(intent);
    }
}
