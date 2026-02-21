package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.soundcloud.api.Stream;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbt extends ajj implements ajn {
    public static bca ak;
    public static boolean f = false;
    protected AnimationListView ah;
    protected RelativeLayout ai;
    protected ImageView aj;
    bbj al = new bbj();
    protected HashMap<Integer, MusicData> am = new HashMap<>();
    ArrayList<bbp> an = new ArrayList<>();
    ArrayList<MusicData> ao = new ArrayList<>();
    boolean ap = false;
    protected int g;
    protected WindowManager h;
    protected AnimationGridView i;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.h = (WindowManager) this.ae.getSystemService("window");
        this.g = ahn.c(this.ae);
        this.ai = (RelativeLayout) this.ae.findViewById(R.id.parent);
    }

    public void a(JSONArray jSONArray) {
        try {
            for (int size = this.an.size(); size < jSONArray.length(); size++) {
                JSONObject jSONObject = jSONArray.getJSONObject(size);
                bbp bbpVar = null;
                if (jSONObject.has("type") && jSONObject.getString("type").startsWith("track")) {
                    bbpVar = new bbp(jSONObject, "Track");
                } else if (jSONObject.has("type") && jSONObject.getString("type").startsWith("playlist")) {
                    bbpVar = new bbp(jSONObject, "Playlist");
                } else if (jSONObject.has("kind") && jSONObject.getString("kind").startsWith("track")) {
                    bbpVar = new bbp(jSONObject, "Track");
                } else if (jSONObject.has("kind") && jSONObject.getString("kind").startsWith("playlist")) {
                    bbpVar = new bbp(jSONObject, "Playlist");
                }
                this.an.add(bbpVar);
                this.ao.add(bbpVar.r);
            }
            this.al.a();
        } catch (Exception e) {
        }
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        Stream stream = (Stream) obj;
        if (stream != null) {
            if (-1000 == stream.songId) {
                MusicPlaylistManager.a().d(this.ao);
            } else {
                MusicPlaylistManager.a().a(stream);
            }
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }
}
