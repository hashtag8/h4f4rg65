package defpackage;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.bfrx.MediaItem;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.aga;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class afu implements afx {
    private static afu f = null;
    private MusicData b;
    private Handler c;
    private boolean d = false;
    private long e = 0;
    private afv g = new afv() { // from class: afu.1
        @Override // defpackage.afv
        public void a() {
            afu.this.c.sendEmptyMessage(1);
            afu.this.c.sendEmptyMessage(2);
        }

        @Override // defpackage.afv
        public void b() {
            mm.b("burning overnight9", new Object[0]);
            new Message().what = 8;
            afu.this.a(true);
            ahz ahzVar = new ahz();
            ahzVar.c = R.string.PlayErrorTip_Str;
            afu.this.a(ahzVar);
        }
    };
    private aga.a h = new aga.a() { // from class: afu.2
        private boolean b = false;

        @Override // defpackage.aga
        public void a(int i, String str) {
            new Message().what = 8;
            afu.a().a(true);
            ahz ahzVar = new ahz();
            ahzVar.c = R.string.PlayErrorTip_Str;
            ahzVar.d = new ErrorInfo.a().a("Invalid Media Item").a((Serializable) afu.this.b.path).a();
            afu.this.a(ahzVar);
            mm.b("burning overnight8", new Object[0]);
            mm.b("error--" + i + "  message--" + str, new Object[0]);
        }

        @Override // defpackage.aga
        public void a() {
            mm.b("onPlayStarted  ", new Object[0]);
            this.b = false;
            afu.this.c.sendEmptyMessage(7);
        }

        @Override // defpackage.aga
        public void a(boolean z) {
            mm.b("onPlayEnded  " + z, new Object[0]);
            afu.this.c.sendEmptyMessage(HttpStatus.SC_MOVED_PERMANENTLY);
        }

        @Override // defpackage.aga
        public void b() {
            if (afu.this.b.isShouldReportStreaming()) {
                afu.this.b.reportStreamingEnd(afu.this.b.duration / 1000);
            }
            afc.a().i();
            afu.this.e = 0L;
            mm.b("notifyPlayTime java play one track finish: " + afu.this.b.path, new Object[0]);
        }

        @Override // defpackage.aga
        public void a(long j) {
            afu.this.e = (j / 1000) / 1000;
            if (afu.this.b.duration > 0 && afu.this.e - (afu.this.b.duration / 1000) >= 30) {
                mm.b("Force stop it due to FC didn't notify play ended, mCurrentTime=%d, mMusicData.duration=%d", Long.valueOf(afu.this.e), Long.valueOf(afu.this.b.duration / 1000));
                this.b = true;
                afu.a().a(true);
            }
        }

        @Override // defpackage.aga
        public int a(MediaItem mediaItem) {
            return 0;
        }

        @Override // defpackage.aga
        public boolean b(boolean z) {
            return false;
        }

        @Override // defpackage.aga
        public void c() {
            afu.this.e = 0L;
        }

        @Override // defpackage.aga
        public void c(boolean z) {
        }

        @Override // defpackage.aga
        public void d() {
        }

        @Override // defpackage.aga
        public void e() {
        }

        @Override // defpackage.aga
        public void f() {
        }

        @Override // defpackage.aga
        public void g() {
        }

        @Override // defpackage.aga
        public void a(String str, String str2) {
        }

        @Override // defpackage.aga
        public void h() {
            mm.b("onStopped  ", new Object[0]);
            if (!this.b) {
                afu.this.c.sendEmptyMessage(HttpStatus.SC_MOVED_TEMPORARILY);
                return;
            }
            this.b = false;
            afu.this.c.sendEmptyMessage(HttpStatus.SC_SEE_OTHER);
            mq.a();
            mq.c().schedule(new Runnable() { // from class: afu.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        afu.this.h.b();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }, 1L, TimeUnit.SECONDS);
        }

        @Override // defpackage.aga
        public void b(MediaItem mediaItem) {
            if (this.b) {
                mm.b("onStartedPlaying  ignore this error callback", new Object[0]);
                return;
            }
            mm.b("onStartedPlaying  ", new Object[0]);
            mm.b("notifyPlayTime " + afu.this.b.path + " duration = " + String.format(Locale.ENGLISH, "%01d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(afu.this.b.duration)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(afu.this.b.duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(afu.this.b.duration)))), new Object[0]);
            afu.this.c.sendEmptyMessage(7);
        }

        @Override // defpackage.aga
        public void c(MediaItem mediaItem) {
            mm.b("onSourcePlaying  ", new Object[0]);
        }

        @Override // defpackage.aga
        public void i() {
            mm.b("onFinished  ", new Object[0]);
            afu.this.c.sendEmptyMessage(HttpStatus.SC_MOVED_PERMANENTLY);
        }

        @Override // defpackage.aga
        public void a(long j, String str, long j2) {
            mm.b("onPlayMediaSource  ", new Object[0]);
        }
    };
    final aey a = new aez() { // from class: afu.4
        @Override // defpackage.aez, defpackage.aey
        public void a(long j, Object obj) {
        }

        @Override // defpackage.aez, defpackage.aey
        public void a(long j) {
            adx adxVarA = aof.a().a(j);
            if (adxVarA == null || aof.a().o() == null || aof.a().o().o().contains(adxVarA)) {
            }
        }

        @Override // defpackage.aez, defpackage.aey
        public void b(adx adxVar) {
            if (adxVar != null && aof.a().o() != null && aof.a().o().o().contains(adxVar)) {
                afu.this.e = 0L;
            }
        }
    };

    public static afu a() {
        if (f == null) {
            f = new afu();
        }
        return f;
    }

    public afu() {
        afc.a().a(this.h);
        afc.a().a(this.g);
        aof.a().c().a(this.a);
    }

    private void h() {
        mm.b("app version : OS relase version=" + Build.VERSION.RELEASE + " , sdkVersion=" + Build.VERSION.SDK_INT, new Object[0]);
        mm.b("app version = " + asw.a().b() + " , phone's model = " + Build.MODEL, new Object[0]);
        ActivityManager activityManager = (ActivityManager) HarmanApplication.a().getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        mm.b("app version System remaining memory:" + ((memoryInfo.availMem / 1024) / 1024) + " MB", new Object[0]);
        mm.b("app version is the system is running in low memory = " + memoryInfo.lowMemory, new Object[0]);
        mm.b("app version when memory is low than " + ((memoryInfo.threshold / 1024) / 1024) + "MB is in low memory ", new Object[0]);
        mn.a();
        mm.b("burning overnight RepeatMode == " + j(), new Object[0]);
    }

    @Override // defpackage.afx
    public void a(MusicData musicData) {
        this.d = false;
        this.b = musicData;
        b();
    }

    @Override // defpackage.afx
    public void b() {
        mq.b().execute(new a(this.b, -1L));
    }

    class a implements Runnable {
        private final MusicData b;
        private int c = 0;
        private long d;

        a(MusicData musicData, long j) {
            this.b = musicData;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (afu.this.b != this.b) {
                mm.a((Object) "burning overnight don't want play this track1");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            final agd playAbleUrl = this.b.getPlayAbleUrl();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            mm.a(Long.valueOf(jCurrentTimeMillis2));
            if (this.b != afu.this.b) {
                mm.a((Object) "burning overnight don't want play this track");
                return;
            }
            if (jCurrentTimeMillis2 < 20000) {
                afu.this.c.sendEmptyMessage(0);
                if (playAbleUrl.a == null || playAbleUrl.a.length() == 0) {
                    mm.a((Object) "burning overnight no url");
                    playAbleUrl.b.b = "item URL is empty: " + playAbleUrl.a;
                    afu.this.a(playAbleUrl.b);
                    if (playAbleUrl.b.a != 2) {
                        MusicPlaylistManager.a().f();
                        return;
                    }
                    return;
                }
                mm.a((Object) ("burning overnight url = " + playAbleUrl.a));
                if (this.d != -1) {
                    mm.a((Object) ("burning overnight realSeek url = " + playAbleUrl.a + " title = " + this.b.getTitle()));
                    afu.this.a(playAbleUrl.a, this.d);
                    return;
                } else {
                    mm.a((Object) ("burning overnight realPlay url = " + playAbleUrl.a + " title = " + this.b.getTitle()));
                    if (afu.this.b.isShouldReportStreaming()) {
                        afu.this.b.reportStreamingStart();
                    }
                    afu.this.a(playAbleUrl.a, new aft() { // from class: afu.a.1
                    });
                    return;
                }
            }
            mm.a((Object) "burning overnight timeout");
            afu.this.i();
            afu.this.a(new ahz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j) {
        afc.a().a(str, j * 1000 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.c.sendEmptyMessage(HttpStatus.SC_CREATED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ahz ahzVar) {
        if (ahzVar.a == -1) {
            ahzVar.a = 1;
        }
        Message message = new Message();
        message.what = 8;
        message.obj = ahzVar;
        this.c.sendMessage(message);
        this.e = 0L;
    }

    private String j() {
        if (MusicPlaylistManager.a().d() == 2) {
            return "REPEAT_ALL";
        }
        if (MusicPlaylistManager.a().d() == 1) {
            return "REPEAT_CURRENT";
        }
        if (MusicPlaylistManager.a().d() == 0) {
            return "REPEAT_NONE";
        }
        if (MusicPlaylistManager.a().d() != 3) {
            return null;
        }
        return "REPEAT_SHUFFLE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void a(String str, aft aftVar) {
        mm.b("device num = %d, soungUrl=%s, mIsResume=%b", Integer.valueOf(aof.a().f().size()), str, Boolean.valueOf(this.d));
        if (str != null && !str.isEmpty()) {
            a(str.toLowerCase());
        }
        h();
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            adyVarB.b(true);
        }
        if (this.d) {
            afc.a().b(str);
        } else {
            afc.a().a(str);
        }
    }

    private void a(String str) {
        ady adyVarB = aof.a().b();
        if (adyVarB != null && adyVarB.n() <= 2) {
            if (b(str)) {
                if (!ain.i && !MusicPlaylistManager.a().v()) {
                    ain.i = true;
                    return;
                }
                return;
            }
            if (ain.i) {
                ain.i = false;
                return;
            }
            return;
        }
        if (b(str) && ain.i) {
            Message message = new Message();
            message.what = 8;
            ahz ahzVar = new ahz();
            ahzVar.c = R.string.kAutoSwitchLosslessTip_Str;
            message.obj = ahzVar;
            this.c.sendMessage(message);
        }
        if (ain.i) {
            ain.i = false;
        }
    }

    private boolean b(String str) {
        return str.endsWith(".wav") || str.endsWith(".flac") || str.endsWith(".alac");
    }

    @Override // defpackage.afx
    public void a(boolean z) {
        this.d = false;
        afc.a().d();
        this.e = 0L;
    }

    @Override // defpackage.afx
    public void c() {
        this.d = true;
        afc.a().e();
    }

    @Override // defpackage.afx
    public long a(long j) {
        this.e = j;
        mq.b().execute(new a(this.b, j));
        return 0L;
    }

    public void d() {
        if (this.b != null && MusicPlaylistManager.a().v()) {
            mq.a("FC_THREAD").a(new Runnable() { // from class: afu.3
                @Override // java.lang.Runnable
                public void run() {
                    ady adyVarO = aof.a().o();
                    for (ady adyVar : aof.a().e()) {
                        if (brs.b(adyVar, adyVarO)) {
                            adyVar.b(false);
                        }
                    }
                    if (adyVarO != null) {
                        mm.b("Setting group to active %s", adyVarO);
                        adyVarO.b(true);
                    }
                    afu.this.a(afu.this.e + 2);
                }
            });
        }
    }

    @Override // defpackage.afx
    public long e() {
        return this.e;
    }

    @Override // defpackage.afx
    public long f() {
        return 0L;
    }

    @Override // defpackage.afx
    public void g() {
        aof.a().c().b(this.a);
    }

    @Override // defpackage.afx
    public void a(float f2) {
    }

    @Override // defpackage.afx
    public void a(Handler handler) {
        this.c = handler;
    }
}
