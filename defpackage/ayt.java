package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.rdio.RdioDataTypes.RdioMusicData;

/* JADX INFO: loaded from: classes.dex */
public class ayt {
    private static ayt a;
    private static RdioMusicData d;
    private static boolean k = false;
    private DashboardActivity b;
    private RdioMusicData c;
    private Thread i;
    private RdioMusicData j;
    private boolean e = false;
    private azt f = azt.finish;
    private long g = 0;
    private long h = 0;
    private BroadcastReceiver l = new BroadcastReceiver() { // from class: ayt.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            long jT = MusicPlaylistManager.a().t();
            if (action.equals("com.harman.hkconnect.android.music.ui.metachanged")) {
                ayt.this.a(jT, intent.getBooleanExtra("playing", false));
            } else if (action.equals("com.harman.hkconnect.android.music.play.track.finish") && (MusicPlaylistManager.a().s() instanceof RdioMusicData)) {
                ayt.this.f = azt.finish;
                ayt.this.a("HK_Rdio_Analytics_Finish", ayt.this.c, jT);
            }
        }
    };

    public ayt(DashboardActivity dashboardActivity) {
        this.b = dashboardActivity;
    }

    public static ayt a(DashboardActivity dashboardActivity) {
        if (a == null) {
            a = new ayt(dashboardActivity);
        }
        return a;
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.metachanged");
        intentFilter.addAction("com.harman.hkconnect.android.music.play.track.finish");
        this.b.registerReceiver(this.l, new IntentFilter(intentFilter));
    }

    public void a(String str, RdioMusicData rdioMusicData, long j) {
        ayu ayuVarA = ayu.a();
        if (str != null && rdioMusicData != null) {
            b(str, rdioMusicData, j);
            if (str.equals("HK_Rdio_Analytics_Play")) {
                ayuVarA.a(rdioMusicData);
                ayw.c().a(ayw.c().a(rdioMusicData), ayu.a());
                return;
            }
            if (str.equals("HK_Rdio_Analytics_Pause")) {
                ayw.c().a(ayw.c().a(ayuVarA.b(), j), ayu.a());
                return;
            }
            if (str.equals("HK_Rdio_Analytics_Resume")) {
                ayw.c().a(ayw.c().b(ayuVarA.b(), j), ayu.a());
                return;
            }
            if (str.equals("HK_Rdio_Analytics_Skip")) {
                ayw.c().a(ayw.c().c(ayuVarA.b(), j), ayu.a());
            } else if (str.equals("HK_Rdio_Analytics_Timed")) {
                ayw.c().a(ayw.c().b(ayuVarA.b()), ayu.a());
            } else if (str.equals("HK_Rdio_Analytics_Finish")) {
                ayw.c().a(ayw.c().c(rdioMusicData), ayu.a());
            }
        }
    }

    public void b(final String str, final RdioMusicData rdioMusicData, final long j) {
        this.b.runOnUiThread(new Runnable() { // from class: ayt.1
            @Override // java.lang.Runnable
            public void run() {
                if (azc.b) {
                    azc.a(ayt.this.b, str.replace("HK_Rdio_Analytics_", "") + ": " + j + " " + rdioMusicData.e().musicName);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        MusicData musicDataS = MusicPlaylistManager.a().s();
        if ((musicDataS instanceof RdioMusicData) || (musicDataS == null && d != null)) {
            if (musicDataS != null) {
                d = (RdioMusicData) musicDataS;
                this.j = d;
            } else {
                d = null;
                this.j = null;
            }
            if (z && ((j == 0 || this.e) && this.f == azt.finish && this.j != null)) {
                this.f = azt.play;
                this.e = false;
                this.c = d;
                this.g = d.d();
                this.h = MusicPlaylistManager.a().t();
                if (!k) {
                    this.i = new Thread(new Runnable() { // from class: ayt.3
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean unused = ayt.k = true;
                            do {
                                ayt.this.h = MusicPlaylistManager.a().t();
                                if (ayt.this.h >= 30 && ayt.k) {
                                    boolean unused2 = ayt.k = false;
                                    ayt.this.a("HK_Rdio_Analytics_Timed", ayt.this.c, 30L);
                                }
                                try {
                                    Thread.sleep(500L);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } while (ayt.this.h <= ayt.this.g);
                            boolean unused3 = ayt.k = false;
                        }
                    });
                    this.i.start();
                }
                a("HK_Rdio_Analytics_Play", this.j, 0L);
                return;
            }
            if (this.f != azt.finish) {
                if (j > 0 && !z && (musicDataS == null || musicDataS != this.c)) {
                    this.e = true;
                    k = true;
                    this.f = azt.finish;
                    a("HK_Rdio_Analytics_Skip", this.c, j);
                    return;
                }
                if (j == 0 && !z && (this.f == azt.play || this.f == azt.pause)) {
                    this.f = azt.skip;
                    return;
                }
                if (j == 0 && !z && this.f == azt.skip) {
                    k = true;
                    this.f = azt.finish;
                    if (this.h < 0) {
                        a("HK_Rdio_Analytics_Skip", this.c, 0L);
                        return;
                    } else {
                        a("HK_Rdio_Analytics_Skip", this.c, this.h);
                        return;
                    }
                }
                if (j < 0 && !z && this.f == azt.play) {
                    this.f = azt.pause;
                    a("HK_Rdio_Analytics_Pause", this.c, 0L);
                    return;
                }
                if (j > 0 && !z && this.f == azt.play) {
                    this.f = azt.pause;
                    a("HK_Rdio_Analytics_Pause", this.c, j);
                } else if (j > 0 && z && this.f == azt.pause) {
                    this.f = azt.play;
                    a("HK_Rdio_Analytics_Resume", this.c, j);
                }
            }
        }
    }
}
