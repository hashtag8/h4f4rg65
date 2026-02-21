package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.musicservice.shoutcast.model.Station;
import defpackage.ahy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bap extends bal {
    private bau d;
    private bbf e;
    private Station f;
    private boolean g;
    private BroadcastReceiver h = new BroadcastReceiver() { // from class: bap.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("PlayState", 99);
            mm.b("Received an intent" + intExtra, new Object[0]);
            if (intent.getIntExtra("PlayState", 99) == 0) {
                bap.this.g = false;
            } else if (intExtra == 4 || intExtra == 3) {
                bap.this.g = false;
            }
        }
    };
    protected agh<List<Station>> b = new agh<List<Station>>() { // from class: bap.2
        @Override // defpackage.agh
        public void a(Object obj, List<Station> list) {
            bap.this.d.a(list);
            bap.this.e.a(list.size());
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            bap.this.e.a(0);
        }
    };
    ajn c = new ajn() { // from class: bap.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(bap.this.ae, bap.this.q().getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                return;
            }
            if (!bap.this.g) {
                if (obj == null) {
                    bap.this.ah.onClick(null);
                    return;
                }
                MusicPlaylistManager.a().h();
                if (aof.a().d().size() > 0) {
                    bap.this.ae.Y();
                    MusicPlaylistManager.a().a((Station) obj);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener i = new AdapterView.OnItemClickListener() { // from class: bap.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Station stationA = bap.this.d.getItem(i);
            bap bapVar = new bap();
            Bundle bundle = new Bundle();
            bundle.putParcelable("station", stationA);
            bapVar.g(bundle);
            bap.this.ae.q().c(bapVar, new arc().a(7));
        }
    };
    private View.OnClickListener ah = new View.OnClickListener() { // from class: bap.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aof.a().l()) {
                Toast.makeText(bap.this.ae, bap.this.q().getString(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                return;
            }
            if (!bap.this.g) {
                bap.this.g = true;
                bap.this.ae.a(new Runnable() { // from class: bap.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
                if (aof.a().d().size() > 0) {
                    bap.this.ae.Y();
                    MusicPlaylistManager.a().a(bap.this.f);
                    bap.this.g = true;
                }
            }
        }
    };
    private agh<String> ai = new agh<String>() { // from class: bap.6
        @Override // defpackage.agh
        public void a(Object obj, String str) {
            bap.this.f.path = str;
            MusicPlaylistManager.a().a(bap.this.f);
            bap.this.g = true;
        }

        @Override // defpackage.agh
        public void a(Object obj, ErrorInfo errorInfo) {
            new ahy.a(bap.this.p()).a(R.string.kShoutCastCantPlay).b(R.string.PlayErrorTip_Str).a().a(errorInfo);
            mm.b("CLLOG ANIMATION STOP IN ERROR", new Object[0]);
            bap.this.g = false;
            bap.this.ae.X();
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.shoutcast_station_fragment, (ViewGroup) null);
        AnimationGridView animationGridView = (AnimationGridView) viewInflate.findViewById(R.id.station_fragment_gridview);
        animationGridView.setNumColumns(al());
        this.f = (Station) l().get("station");
        arp arpVar = new arp(animationGridView);
        this.e = new bbf(layoutInflater, this.ae);
        animationGridView.a(this.e.a(this.f.musicName, this.f.genre, this.f.currenttrack, this.f.album_art.replace("200", "1000"), this.f.bitrate));
        this.d = new bau(this.ae);
        animationGridView.setAdapter((ListAdapter) this.d);
        arpVar.a();
        an();
        animationGridView.setOnItemClickListener(this.i);
        animationGridView.setOnItemChosenListener(this.c);
        this.e.a(this.ah);
        this.g = false;
        return viewInflate;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ServiceBroadcast");
        this.ae.registerReceiver(this.h, new IntentFilter(intentFilter));
    }

    @Override // android.support.v4.app.Fragment
    public void D() {
        this.ae.unregisterReceiver(this.h);
        super.D();
    }

    private void an() {
        try {
            bay bayVar = new bay(this.f.radioId);
            bayVar.a((Fragment) this);
            bayVar.a((agh) this.b);
            bayVar.a();
        } catch (Exception e) {
            e.printStackTrace();
            this.e.a(0);
        }
    }
}
