package com.harman.commom.music.player.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import defpackage.ady;
import defpackage.aff;
import defpackage.afw;
import defpackage.afx;
import defpackage.agb;
import defpackage.agc;
import defpackage.agf;
import defpackage.agg;
import defpackage.aho;
import defpackage.ahy;
import defpackage.ahz;
import defpackage.ain;
import defpackage.aof;
import defpackage.aqo;
import defpackage.ayf;
import defpackage.azd;
import defpackage.bif;
import defpackage.br;
import defpackage.mm;
import defpackage.mo;
import defpackage.mq;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"HandlerLeak"})
public class MusicService extends Service {
    public static Object a;
    public afx b;
    RemoteViews c;
    RemoteViews d;
    private PowerManager.WakeLock g;
    private int p;
    private int q;
    private AudioManager r;
    private boolean u;
    private final String f = "MusicService";
    private int h = -1;
    private boolean i = false;
    private int j = 4;
    private boolean k = false;
    private boolean l = false;
    private agg m = agg.a();
    private agf n = agf.a();
    private PlayList o = new PlayList();
    private float s = 1.0f;
    private final IBinder t = new a(this);
    private Handler v = new Handler() { // from class: com.harman.commom.music.player.service.MusicService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    MusicService.this.sendStickyBroadcast(new Intent("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED"));
                    break;
                case 1:
                    Intent intent = new Intent("com.harman.hkconnect.android.music.play.track.finish");
                    intent.putExtra("musicData", MusicService.this.c());
                    MusicService.this.sendBroadcast(intent);
                    MusicService.this.a(false);
                    break;
                case 2:
                    MusicService.this.g.acquire(30000L);
                    MusicService.this.g.release();
                    break;
                case 3:
                    if (MusicService.this.k()) {
                        MusicService.this.a(false);
                    } else {
                        MusicService.this.g();
                    }
                    break;
                case 4:
                    MusicService.this.s();
                    break;
                case 5:
                    MusicService.this.a(message);
                    break;
                case 7:
                    MusicService.this.c(0);
                    if (aff.b == 2003) {
                        MusicService.this.c().duration = MusicService.this.n();
                    }
                    PlayList.a = 0;
                    MusicService.this.a("com.harman.hkconnect.android.music.ui.metachanged");
                    ady adyVarB = aof.a().b();
                    aqo.f().a(adyVarB != null ? adyVarB.n() : 0, MusicService.this.c());
                    break;
                case 8:
                    mm.b("burning overnight3", new Object[0]);
                    MusicService.this.c(3);
                    PlayList.a++;
                    MusicService.this.a("com.harman.hkconnect.android.music.ui.metachanged");
                    MusicService.this.a((ahz) message.obj);
                    break;
                case 100:
                    MusicService.this.r();
                    break;
                case 101:
                    MusicService.this.q();
                    break;
                case HttpStatus.SC_CREATED /* 201 */:
                    MusicService.this.sendStickyBroadcast(new Intent("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED"));
                    break;
                case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
                    mm.b("Received broadcast ON_PLAY_ENDED", new Object[0]);
                    MusicService.this.sendBroadcast(new Intent("com.harman.hkconnect.android.music.onPlayEnded"));
                    break;
                case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
                    mm.b("Received broadcast MSG_ON_PLAY_ENDED_ALL_SPEAKER_LEFT_SESSION", new Object[0]);
                    if (MusicService.this.k()) {
                        MusicService.this.j();
                    }
                    break;
                case HttpStatus.SC_SEE_OTHER /* 303 */:
                    mm.b("Received broadcast MSG_NOTIFY_FORCE_STOPPED", new Object[0]);
                    MusicService.this.c(3);
                    break;
            }
        }
    };
    private BroadcastReceiver w = new BroadcastReceiver() { // from class: com.harman.commom.music.player.service.MusicService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("command");
            if ("next".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.next".equals(action)) {
                MusicService.this.a(true);
                return;
            }
            if ("previous".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.previous".equals(action)) {
                MusicService.this.l();
                return;
            }
            if ("".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.togglepause".equals(action)) {
                if (MusicService.this.k()) {
                    MusicService.this.h();
                    MusicService.this.k = false;
                    return;
                } else {
                    MusicService.this.i();
                    return;
                }
            }
            if ("pause".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.pause".equals(action)) {
                MusicService.this.h();
                MusicService.this.k = false;
                return;
            }
            if ("stop".equals(stringExtra)) {
                MusicService.this.h();
                MusicService.this.k = false;
                MusicService.this.a(0L);
                return;
            }
            if ("appwidgetupdate".equals(stringExtra)) {
                MusicService.this.m.a(MusicService.this, intent.getIntArrayExtra("appWidgetIds"));
                return;
            }
            if ("appwidgetupdate".equals(stringExtra)) {
                MusicService.this.n.a(MusicService.this, intent.getIntArrayExtra("appWidgetIds"));
                return;
            }
            if ("PLAY".equals(action)) {
                if (!MusicService.this.k()) {
                    MusicService.this.i();
                    return;
                }
                return;
            }
            if ("PAUSE".equals(action)) {
                if (MusicService.this.k()) {
                    MusicService.this.h();
                    return;
                }
                return;
            }
            if ("NEXT".equals(action)) {
                MusicService.this.a(true);
                return;
            }
            if ("PREV".equals(action)) {
                MusicService.this.l();
                return;
            }
            if ("STOPSERVICE".equals(action)) {
                MusicService.this.u = false;
                MusicService.this.c(true);
                MusicService.this.a();
            } else if ("NEXT_MIXRADIO".equals(action)) {
                ayf ayfVarA = ayf.a();
                MusicData musicDataC = MusicService.this.c();
                if ((musicDataC == null || !(musicDataC instanceof MixRadioAdvertData)) && MusicService.this.j != 2) {
                    ayfVarA.g = true;
                    ayf.a().a("" + musicDataC.songId, "skipnext", true);
                    ayfVarA.a(1, true, true);
                    MusicService.this.a(true);
                }
            }
        }
    };
    private AudioManager.OnAudioFocusChangeListener x = new AudioManager.OnAudioFocusChangeListener() { // from class: com.harman.commom.music.player.service.MusicService.3
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            MusicService.this.v.obtainMessage(5, i, 0).sendToTarget();
        }
    };
    private Handler y = new Handler() { // from class: com.harman.commom.music.player.service.MusicService.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!MusicService.this.k() && !MusicService.this.k && !MusicService.this.i && !MusicService.this.v.hasMessages(1)) {
                MusicService.this.stopSelf(MusicService.this.h);
            }
        }
    };
    Runnable e = new Runnable() { // from class: com.harman.commom.music.player.service.MusicService.7
        @Override // java.lang.Runnable
        public void run() {
            MusicService.this.d(3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ahz ahzVar) {
        mm.e("Showing toast for music service error %s", ahzVar);
        if (ahzVar.a == 1) {
            a(true);
        }
        ErrorInfo errorInfoA = new ErrorInfo.a().b(ahzVar.c != -1 ? getResources().getString(ahzVar.c) : ahzVar.b).a();
        if (ahzVar.a == 2) {
            new ahy.a(ain.J).a().a(errorInfoA, getResources().getString(R.string.PlaybackPaused_Str));
        } else {
            new ahy.a(this).a().a(errorInfoA);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        mm.b("Creating Service %s", this);
        this.r = (AudioManager) getSystemService("audio");
        this.r.registerMediaButtonEventReceiver(new ComponentName(getPackageName(), MediaButtonIntentReceiver.class.getName()));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.musicservicecommand");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.musicservicecommand.togglepause");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.musicservicecommand.pause");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.musicservicecommand.next");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.musicservicecommand.previous");
        intentFilter.addAction("PLAY");
        intentFilter.addAction("PAUSE");
        intentFilter.addAction("NEXT");
        intentFilter.addAction("PREV");
        intentFilter.addAction("STOPSERVICE");
        intentFilter.addAction("NEXT_MIXRADIO");
        registerReceiver(this.w, intentFilter);
        this.g = ((PowerManager) getSystemService("power")).newWakeLock(1, getClass().getName());
        this.g.setReferenceCounted(false);
        this.y.sendMessageDelayed(this.y.obtainMessage(), 60000L);
        this.q = aho.b("SETTING_SHUFFLE", 0);
        this.p = aho.b("SETTING_REPEAT", 2);
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("hk_music_service_channel_id", "HK Music Service", 0));
            startForeground(2, new br.b(this, "hk_music_service_channel_id").a("").b("").a());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a = "MusicService";
        if (aff.a) {
            mm.b("MusicService", "onBind come in");
        }
        this.y.removeCallbacksAndMessages(null);
        this.i = true;
        return this.t;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (aff.a) {
            mm.b("MusicService", "onRebind come in");
        }
        this.y.removeCallbacksAndMessages(null);
        this.i = true;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (aff.a) {
            mm.b("MusicService", "onUnbind come in");
        }
        this.i = false;
        if (!k() && !this.k) {
            if (this.v.hasMessages(1)) {
                this.y.sendMessageDelayed(this.y.obtainMessage(), 60000L);
            } else {
                stopSelf(this.h);
            }
        }
        return true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        mm.b("Destroying Service %s", this);
        this.r.abandonAudioFocus(this.x);
        stopForeground(true);
        c(true);
        Intent intent = new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
        intent.putExtra("android.media.extra.PACKAGE_NAME", getPackageName());
        sendBroadcast(intent);
        if (this.b != null) {
            this.b.g();
        }
        this.y.removeCallbacksAndMessages(null);
        this.v.removeCallbacksAndMessages(null);
        unregisterReceiver(this.w);
        this.g.release();
        super.onDestroy();
    }

    public void a() {
        MusicPlaylistManager.a().g();
        stopForeground(true);
    }

    public void b() {
        if (aff.a) {
            mm.b("MusicService", "gotoIdleState()");
        }
        c(4);
        a("com.harman.hkconnect.android.music.ui.metachanged");
        this.y.removeCallbacksAndMessages(null);
        this.y.sendMessageDelayed(this.y.obtainMessage(), 60000L);
    }

    public MusicData c() {
        if (this.o != null) {
            return this.o.e();
        }
        return null;
    }

    public long d() {
        if (this.b == null) {
            return 0L;
        }
        return this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        switch (message.arg1) {
            case -3:
                this.v.removeMessages(101);
                this.v.sendEmptyMessage(100);
                break;
            case ContentLengthStrategy.CHUNKED /* -2 */:
                if (k()) {
                    this.k = true;
                }
                if (this.b instanceof afw) {
                    h();
                }
                break;
            case ContentLengthStrategy.IDENTITY /* -1 */:
                if (k()) {
                    this.k = false;
                }
                if (this.b instanceof afw) {
                    h();
                }
                break;
            case 1:
                if (!k() && this.k) {
                    this.k = false;
                    this.s = 0.0f;
                    a(this.s);
                    i();
                } else {
                    this.v.removeMessages(100);
                    this.v.sendEmptyMessage(101);
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.s += 0.01f;
        if (this.s < 1.0f) {
            this.v.sendEmptyMessageDelayed(101, 10L);
        } else {
            this.s = 1.0f;
        }
        a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.s -= 0.05f;
        if (this.s > 0.2f) {
            this.v.sendEmptyMessageDelayed(100, 10L);
        } else {
            this.s = 0.2f;
        }
        a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!k()) {
            this.s = 0.0f;
            this.b.a(this.s);
            i();
            if (this.l) {
                this.v.sendEmptyMessageDelayed(4, 10L);
                return;
            }
            return;
        }
        this.s += 0.01f;
        if (this.s < 1.0f) {
            this.v.sendEmptyMessageDelayed(4, 10L);
        } else {
            this.s = 1.0f;
        }
        this.b.a(this.s);
    }

    public void a(PlayList playList) {
        synchronized (this) {
            if (playList != null) {
                if (playList.a() > 0) {
                    this.o = playList;
                }
            }
        }
    }

    public PlayList e() {
        return this.o;
    }

    public void f() {
        if (this.o != null) {
            this.o.b();
            this.o = new PlayList();
        }
    }

    private void a(MusicData musicData) {
        this.b = musicData.getMusicPlayer(this);
        this.b.a(this.v);
    }

    public void g() {
        if (this.b != null) {
            c(false);
        }
        MusicData musicDataE = this.o.e();
        if (musicDataE != null) {
            a(musicDataE);
            b(musicDataE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MusicData musicData) {
        if (this.b != null) {
            this.u = true;
            c(2);
            a("com.harman.hkconnect.android.music.ui.metachanged");
            this.b.a(musicData);
        }
    }

    public void h() {
        if (this.b != null) {
            if (k()) {
                this.b.c();
                b();
            }
            c(1);
            a("com.harman.hkconnect.android.music.ui.metachanged");
        }
    }

    public void i() {
        if (this.b != null) {
            if (aof.a().o() == null) {
                aof.a().m();
                mq.a("FC_THREAD").post(new Runnable() { // from class: com.harman.commom.music.player.service.MusicService.5
                    @Override // java.lang.Runnable
                    public void run() {
                        MusicService.this.b.b();
                        MusicService.this.c(2);
                        MusicService.this.a("com.harman.hkconnect.android.music.ui.metachanged");
                    }
                });
            } else {
                this.b.b();
                c(2);
                a("com.harman.hkconnect.android.music.ui.metachanged");
            }
        }
    }

    public void j() {
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.b != null && this.j != 3) {
            if (aof.a().b() != null) {
                aof.a().b().a(false);
            }
            this.b.a(z);
            c(3);
            a("com.harman.hkconnect.android.music.ui.metachanged");
        }
    }

    public boolean k() {
        return this.j == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        mm.b("MusicService PLAYSTATECHECK " + i, new Object[0]);
        this.j = i;
    }

    public void l() {
        synchronized (this) {
            if (this.o.a(this.p)) {
                g();
                this.l = false;
            } else {
                j();
            }
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            if (this.o.a(this.p, z)) {
                g();
                this.l = false;
            } else {
                mm.b("Stop playback, repeat mode= " + MusicPlaylistManager.a().d(), new Object[0]);
                j();
            }
        }
    }

    public long m() {
        if (this.b == null) {
            return 0L;
        }
        return this.b.e();
    }

    public long a(long j) {
        if (this.b == null) {
            return 0L;
        }
        long jA = this.b.a(j);
        c(2);
        a("com.harman.hkconnect.android.music.ui.metachanged");
        return jA;
    }

    public long n() {
        if (this.b == null) {
            return 0L;
        }
        return this.b.f();
    }

    public void a(int i) {
        synchronized (this) {
            this.p = i;
            aho.a("SETTING_REPEAT", i);
        }
    }

    public int o() {
        return this.p;
    }

    public void b(int i) {
        synchronized (this) {
            this.o.a(i == 1);
            this.q = i;
            aho.a("SETTING_SHUFFLE", i);
        }
    }

    public int p() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        b(str);
        mo.a.post(new Runnable() { // from class: com.harman.commom.music.player.service.MusicService.6
            @Override // java.lang.Runnable
            public void run() {
                MusicService.this.t();
            }
        });
    }

    private void b(String str) {
        Intent intent = new Intent(str);
        intent.putExtra("playing", k());
        sendStickyBroadcast(intent);
        Intent intent2 = new Intent("ServiceBroadcast");
        intent2.putExtra("PlayState", this.j);
        sendBroadcast(intent2);
        this.m.a(this, str);
        this.n.a(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        int i2;
        int i3;
        int i4;
        MusicData musicDataC = c();
        if (musicDataC != null && this.u) {
            this.c = new RemoteViews(getPackageName(), R.layout.small_music_notification);
            this.d = new RemoteViews(getPackageName(), R.layout.large_music_notification);
            if (!k()) {
                if (i == 2) {
                    i2 = 0;
                    i3 = 8;
                    i4 = R.drawable.play_icon;
                    mo.a.postDelayed(this.e, 15000L);
                } else {
                    i2 = 8;
                    i3 = 0;
                    i4 = R.drawable.play_icon;
                    mo.a.removeCallbacks(this.e);
                }
            } else {
                i2 = 8;
                i3 = 0;
                i4 = R.drawable.pause_icon;
                mo.a.removeCallbacks(this.e);
            }
            this.d.setViewVisibility(R.id.music_playback_play_Pause_candidate, i3);
            this.c.setViewVisibility(R.id.music_playback_play_Pause_candidate, i3);
            this.d.setViewVisibility(R.id.pro_bar, i2);
            this.c.setViewVisibility(R.id.pro_bar, i2);
            if (i4 != -1) {
                this.d.setImageViewResource(R.id.music_playback_play_Pause_candidate, i4);
                this.c.setImageViewResource(R.id.music_playback_play_Pause_candidate, i4);
            }
            if (musicDataC.songId < 0) {
                this.c.setTextViewText(R.id.notif_track_name, musicDataC.path);
                this.d.setTextViewText(R.id.current_music_name, musicDataC.path);
            } else {
                this.c.setTextViewText(R.id.notif_track_name, musicDataC.musicName);
                this.d.setTextViewText(R.id.current_music_name, musicDataC.musicName);
            }
            if (agc.d(musicDataC)) {
                this.c.setTextViewText(R.id.notif_artist_name, musicDataC.genre);
                this.d.setTextViewText(R.id.current_artist_name, musicDataC.genre);
            } else {
                this.c.setTextViewText(R.id.notif_artist_name, musicDataC.artist);
                this.d.setTextViewText(R.id.current_artist_name, musicDataC.artist);
            }
            this.c.setTextViewText(R.id.notif_album_name, musicDataC.album);
            this.d.setTextViewText(R.id.current_album_name, musicDataC.album);
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent("com.harman.android.music.HK_CONNECT").addFlags(268435456), 0);
            Intent intent = new Intent();
            intent.setAction("PLAY");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent, 134217728);
            Intent intent2 = new Intent();
            intent2.setAction("PAUSE");
            PendingIntent broadcast2 = PendingIntent.getBroadcast(this, 0, intent2, 134217728);
            Intent intent3 = new Intent();
            intent3.setAction("PREV");
            PendingIntent broadcast3 = PendingIntent.getBroadcast(this, 0, intent3, 134217728);
            Intent intent4 = new Intent();
            intent4.setAction("NEXT");
            PendingIntent broadcast4 = PendingIntent.getBroadcast(this, 0, intent4, 134217728);
            Intent intent5 = new Intent();
            intent5.setAction("NEXT_MIXRADIO");
            PendingIntent broadcast5 = PendingIntent.getBroadcast(this, 0, intent5, 134217728);
            Intent intent6 = new Intent();
            intent6.setAction("STOPSERVICE");
            PendingIntent broadcast6 = PendingIntent.getBroadcast(this, 0, intent6, 134217728);
            Intent intentAddFlags = new Intent("com.harman.android.music.HK_CONNECT").addFlags(268435456);
            intentAddFlags.putExtra("CHANGEVOLUME", true);
            PendingIntent activity2 = PendingIntent.getActivity(this, 0, intentAddFlags, 134217728);
            PendingIntent activity3 = PendingIntent.getActivity(this, 0, new Intent("com.harman.android.music.HK_BACKTOAPP").addFlags(268435456), 134217728);
            if (!k()) {
                this.d.setOnClickPendingIntent(R.id.music_playback_play_Pause_candidate, broadcast);
                this.c.setOnClickPendingIntent(R.id.music_playback_play_Pause_candidate, broadcast);
            } else {
                this.d.setOnClickPendingIntent(R.id.music_playback_play_Pause_candidate, broadcast2);
                this.c.setOnClickPendingIntent(R.id.music_playback_play_Pause_candidate, broadcast2);
            }
            a(false, agc.a(musicDataC), broadcast3);
            if (musicDataC != null && agc.b(musicDataC)) {
                if (musicDataC.type == 2) {
                    if (musicDataC instanceof MixRadioAdvertData) {
                        a(true, false, null);
                    } else {
                        a(true, ayf.a().c(), broadcast5);
                    }
                } else if (musicDataC.type == 7) {
                    azd azdVarA = azd.a();
                    azdVarA.d();
                    a(true, !azdVarA.h(), broadcast4);
                } else {
                    a(true, true, broadcast4);
                }
            } else {
                a(true, false, null);
            }
            this.d.setOnClickPendingIntent(R.id.background_album_art, activity3);
            this.d.setOnClickPendingIntent(R.id.close_service, broadcast6);
            this.d.setOnClickPendingIntent(R.id.music_playback_volume, activity2);
            this.c.setOnClickPendingIntent(R.id.smallRemoteView, activity3);
            this.c.setOnClickPendingIntent(R.id.close_service, broadcast6);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("hk_mini_player_channel_id", "HK Mini Player", 2);
                notificationChannel.enableVibration(false);
                notificationChannel.setLockscreenVisibility(1);
                ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
            }
            br.b bVar = new br.b(this, "hk_mini_player_channel_id");
            bVar.a(R.drawable.notification_icon);
            bVar.a(activity);
            bVar.a(System.currentTimeMillis() * 2);
            bVar.b(-1);
            bVar.a(false);
            bVar.b(this.d);
            bVar.a(this.c);
            bVar.c(1);
            Notification notificationA = bVar.a();
            if (!TextUtils.isEmpty(musicDataC.album_art) && musicDataC.album_art.toLowerCase().contains(HttpHost.DEFAULT_SCHEME_NAME) && musicDataC.type != 7) {
                bif.a((Context) this).a(musicDataC.album_art).a(R.dimen.smallMusicNotification_musicSongCover_size, R.dimen.smallMusicNotification_musicSongCover_size).e().b(R.drawable.empty_cover_art_small).a(this.c, R.id.music_song_cover, 1, notificationA);
                bif.a((Context) this).a(musicDataC.album_art).a(R.dimen.smallMusicNotification_musicSongCover_size, R.dimen.smallMusicNotification_musicSongCover_size).e().b(R.drawable.empty_cover_art_small).a(this.d, R.id.current_music_image, 1, notificationA);
            } else if (MusicPlaylistManager.a().s() != null) {
                Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), Long.valueOf(MusicPlaylistManager.a().s().album_id).longValue());
                bif.a((Context) this).a(uriWithAppendedId).a(R.dimen.smallMusicNotification_musicSongCover_size, R.dimen.smallMusicNotification_musicSongCover_size).e().b(R.drawable.empty_cover_art_small).a(this.c, R.id.music_song_cover, 1, notificationA);
                bif.a((Context) this).a(uriWithAppendedId).a(R.dimen.smallMusicNotification_musicSongCover_size, R.dimen.smallMusicNotification_musicSongCover_size).e().b(R.drawable.empty_cover_art_small).a(this.d, R.id.current_music_image, 1, notificationA);
            }
            startForeground(1, notificationA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        d(this.j);
    }

    private void a(boolean z, boolean z2, PendingIntent pendingIntent) {
        int i = R.id.music_playback_next;
        int i2 = z ? R.id.music_playback_next : R.id.music_playBackBackward;
        if (!z) {
            i = R.id.music_playback_prev;
        }
        if (z2) {
            this.d.setInt(i2, "setImageAlpha", 255);
            this.c.setInt(i, "setImageAlpha", 255);
            this.d.setOnClickPendingIntent(i2, pendingIntent);
            this.c.setOnClickPendingIntent(i, pendingIntent);
        } else {
            this.d.setInt(i2, "setImageAlpha", 76);
            this.c.setInt(i, "setImageAlpha", 76);
            this.d.setOnClickPendingIntent(i2, null);
            this.c.setOnClickPendingIntent(i, null);
        }
        this.d.setBoolean(i2, "setEnabled", z2);
        this.c.setBoolean(i, "setEnabled", z2);
    }

    public void b(boolean z) {
        this.u = z;
        if (!z) {
            stopForeground(true);
        }
    }

    private void a(float f) {
        if (this.b != null) {
            this.b.a(f);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        a();
        MusicPlaylistManager.a().b(HarmanApplication.a());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
        super.onTaskRemoved(intent);
        Process.killProcess(Process.myPid());
    }

    public static class a extends agb.a {
        MusicService a;

        a(MusicService musicService) {
            this.a = musicService;
        }

        @Override // defpackage.agb
        public boolean c() {
            if (this.a == null) {
                return false;
            }
            return this.a.k();
        }

        @Override // defpackage.agb
        public void f() {
            if (this.a != null) {
                this.a.j();
            }
        }

        @Override // defpackage.agb
        public void g() {
            if (this.a != null) {
                this.a.h();
            }
        }

        @Override // defpackage.agb
        public void h() {
            if (this.a != null) {
                this.a.g();
            }
        }

        @Override // defpackage.agb
        public void i() {
            if (this.a != null) {
                this.a.i();
            }
        }

        @Override // defpackage.agb
        public void j() {
            if (this.a != null) {
                this.a.l();
            }
        }

        @Override // defpackage.agb
        public void k() {
            if (this.a != null) {
                if (d() != null && d().isShouldReportStreaming()) {
                    d().reportStreamingEnd(l());
                }
                this.a.a(true);
            }
        }

        @Override // defpackage.agb
        public void a(long j) {
            if (this.a != null) {
                this.a.a(j);
            }
        }

        @Override // defpackage.agb
        public MusicData d() {
            if (this.a == null) {
                return null;
            }
            return this.a.c();
        }

        @Override // defpackage.agb
        public long l() {
            if (this.a == null) {
                return 0L;
            }
            return this.a.m();
        }

        @Override // defpackage.agb
        public void a(MusicData musicData) {
            if (this.a != null) {
                this.a.b(musicData);
            }
        }

        @Override // defpackage.agb
        public void a(PlayList playList) {
            if (this.a != null) {
                this.a.a(playList);
            }
        }

        @Override // defpackage.agb
        public void a(int i) {
            if (this.a != null) {
                this.a.a(i);
            }
        }

        @Override // defpackage.agb
        public int m() {
            if (this.a == null) {
                return 0;
            }
            return this.a.o();
        }

        @Override // defpackage.agb
        public void b(int i) {
            if (this.a != null) {
                this.a.b(i);
            }
        }

        @Override // defpackage.agb
        public int n() {
            if (this.a == null) {
                return 0;
            }
            return this.a.p();
        }

        @Override // defpackage.agb
        public PlayList a() {
            if (this.a == null) {
                return null;
            }
            return this.a.e();
        }

        @Override // defpackage.agb
        public void b() {
            if (this.a != null) {
                this.a.f();
            }
        }

        @Override // defpackage.agb
        public void o() {
            if (this.a != null) {
                this.a.a();
            }
        }

        @Override // defpackage.agb
        public long e() {
            return this.a.d();
        }

        @Override // defpackage.agb
        public void a(boolean z) {
            if (this.a != null) {
                this.a.b(z);
            }
        }

        @Override // defpackage.agb
        public int p() {
            if (this.a != null) {
                return this.a.j;
            }
            return 3;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.u = true;
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("command");
            if ("next".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.next".equals(action)) {
                a(true);
            } else if (!"previous".equals(stringExtra) && !"com.harman.hkconnect.android.music.ui.musicservicecommand.previous".equals(action)) {
                if ("play".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.play".equals(action)) {
                    if (k()) {
                        h();
                        this.k = false;
                    } else {
                        i();
                    }
                } else if ("".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.togglepause".equals(action)) {
                    if (k()) {
                        h();
                        this.k = false;
                    }
                } else if ("pause".equals(stringExtra) || "com.harman.hkconnect.android.music.ui.musicservicecommand.pause".equals(action)) {
                    h();
                    this.k = false;
                } else if ("stop".equals(stringExtra)) {
                    h();
                    this.k = false;
                    a(0L);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
