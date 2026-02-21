package defpackage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import com.musicservice.rdio.RdioDataTypes.RdioStationMusicData;
import defpackage.ajv;
import defpackage.azb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class azs extends ajj implements ajn, azb.a {
    public static boolean ak = false;
    public static ayw al;
    public static baa ap;
    protected RelativeLayout ah;
    protected azk aj;
    arz aq;
    protected int d;
    protected WindowManager e;
    protected RdioMusicData f;
    protected List<MusicData> g;
    protected AnimationGridView h;
    protected AnimationListView i;
    protected boolean ai = false;
    azc am = new azc();
    public Map<String, String> an = new HashMap();
    boolean ao = false;
    private int a = -1;
    private MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: azs.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            azs.this.ae.q().a(new azw(), (arc) null);
            return true;
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        al = ayw.c();
        azc.d = q().getInteger(R.integer.rdio_pagination_amount);
        this.e = (WindowManager) this.ae.getSystemService("window");
        this.d = ahn.c(this.ae);
        this.ah = (RelativeLayout) this.ae.findViewById(R.id.parent);
    }

    public void a(boolean z, String str) {
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else {
            a((azi) obj);
        }
    }

    public void a(azi aziVar) {
        if (aziVar != null) {
            if (aziVar instanceof azm) {
                this.f = ((azm) aziVar).e();
                this.f.type = 6;
                this.ai = false;
            } else if (aziVar instanceof azk) {
                this.g = new ArrayList();
                this.aj = (azk) aziVar;
                this.ai = true;
            } else {
                this.ai = false;
            }
            if (this.ai) {
                if (this.aq == null || !this.aq.isShowing()) {
                    this.aq = new arz(this.ae);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.ae.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(this.ae.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(this.ae.getString(R.string.PlayTip_ClearAll_Str));
                    this.aq.a(arrayList);
                    this.aq.a(this.ae.getString(R.string.PlayTip_Title_Str));
                    this.aq.a(new asi() { // from class: azs.1
                        @Override // defpackage.asi
                        public void a(int i) {
                            azs.this.a = i;
                            azs.this.b(azs.this.aj.b());
                        }
                    });
                    this.aq.show();
                    return;
                }
                return;
            }
            if (this.f != null) {
                MusicPlaylistManager.a().a(this.f);
                return;
            }
            return;
        }
        this.ai = false;
    }

    protected void b(String str) {
        Map<String, String> mapB = al.b(str, 0, 5);
        azc.e = true;
        al.a(mapB, this);
    }

    protected void ap() {
        a(azd.a().c());
    }

    protected void a(RdioStationMusicData rdioStationMusicData) {
        switch (this.a) {
            case 0:
                MusicPlaylistManager.a().a(rdioStationMusicData);
                break;
            case 1:
                MusicPlaylistManager.a().c(rdioStationMusicData);
                break;
            case 2:
                MusicPlaylistManager.a().d(rdioStationMusicData);
                break;
            case 3:
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().b(rdioStationMusicData);
                break;
        }
        this.a = -1;
    }

    @Override // defpackage.ajj
    public ajv b() {
        return aq().h(R.drawable.rdio_sidebar_logo).c(this.ae.getResources().getColor(R.color.white)).i(R.drawable.hamberger_white_icon).c(true).a(this.b).c();
    }

    protected ajv.a aq() {
        return new ajv.a().d(R.color.rdio_theme_colour);
    }

    protected void a(List<?> list, AdapterView<?> adapterView, TextView textView) {
        if (list == null || list.isEmpty()) {
            textView.setText(this.ae.getResources().getString(R.string.RdioNoResults_Str));
            adapterView.setEmptyView(textView);
        } else {
            textView.setText("");
        }
    }
}
