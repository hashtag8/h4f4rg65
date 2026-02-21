package defpackage;

import android.content.ComponentName;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.harman.commom.music.player.service.MediaButtonIntentReceiver;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.MusicService;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import java.io.IOException;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class afw implements afx {
    private static a a;
    private static int b = 0;
    private AudioManager c;
    private Handler d;
    private MusicService e;
    private MusicData f;
    private AudioManager.OnAudioFocusChangeListener g = new AudioManager.OnAudioFocusChangeListener() { // from class: afw.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            mm.b("MusicPlayerForLocal", "mAudioFocusListener=" + i);
            afw.this.d.obtainMessage(5, i, 0).sendToTarget();
        }
    };

    static /* synthetic */ int d() {
        int i = b;
        b = i + 1;
        return i;
    }

    public static long a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return Long.parseLong(strExtractMetadata);
        } catch (Exception e) {
            mm.e("get duration failed, path=%s, err=%s", str, e.getLocalizedMessage());
            return 0L;
        }
    }

    public afw(MusicService musicService) {
        this.e = musicService;
        this.c = (AudioManager) this.e.getSystemService("audio");
        this.c.registerMediaButtonEventReceiver(new ComponentName(this.e.getPackageName(), MediaButtonIntentReceiver.class.getName()));
        this.e = musicService;
        if (a == null) {
            a = new a();
        }
    }

    class b implements Runnable {
        public MusicData a;

        b(MusicData musicData) {
            this.a = musicData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (afw.this.f == this.a) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                afw.this.d.sendEmptyMessageDelayed(HttpStatus.SC_CREATED, 20000L);
                agd playAbleUrl = this.a.getPlayAbleUrl();
                int iCurrentTimeMillis = (int) (((System.currentTimeMillis() - jCurrentTimeMillis) / 1000) / 1000);
                if (this.a == afw.this.f && iCurrentTimeMillis < 20) {
                    afw.this.d.removeMessages(HttpStatus.SC_CREATED);
                    afw.this.d.sendEmptyMessage(0);
                    if (playAbleUrl.a != null && playAbleUrl.a.length() != 0) {
                        try {
                            synchronized (afw.a) {
                                afw.a.a(playAbleUrl.a);
                                int unused = afw.b = 0;
                                if (afw.this.f != this.a) {
                                    afw.a.a();
                                } else {
                                    afw.a.c();
                                }
                            }
                            return;
                        } catch (Exception e) {
                            afw.this.a(true);
                            if (afw.d() < afw.this.e.e().a()) {
                                Message message = new Message();
                                message.what = 8;
                                ahz ahzVar = new ahz();
                                ahzVar.a = 1;
                                ahzVar.c = R.string.PlayErrorTip_Str;
                                ahzVar.d = new ErrorInfo.a().a((Throwable) e).a();
                                message.obj = ahzVar;
                                afw.this.d.sendMessageDelayed(message, 200L);
                                return;
                            }
                            return;
                        }
                    }
                    Message message2 = new Message();
                    message2.what = 8;
                    playAbleUrl.b.d = new ErrorInfo.a().a("No URL in " + playAbleUrl).a();
                    message2.obj = playAbleUrl.b;
                    afw.this.d.sendMessage(message2);
                }
            }
        }
    }

    @Override // defpackage.afx
    public void a(MusicData musicData) {
        this.f = musicData;
        if (this.f != null) {
            if (a == null) {
                a = new a();
                a.a(this.d);
            }
            mq.b().execute(new b(musicData));
        }
    }

    @Override // defpackage.afx
    public void b() {
        if (aff.a) {
            mm.b("MusicPlayerForLocal", "play()");
        }
        if (a != null && a.b()) {
            long jG = a.g();
            if (jG > 2000 && a.h() >= jG - 2000) {
                this.e.a(false);
            }
            a.c();
            this.d.sendEmptyMessage(7);
        }
    }

    @Override // defpackage.afx
    public void a(boolean z) {
        if (aff.a) {
            mm.b("MusicPlayerForLocal", "stop()");
        }
        if (a != null && a.b()) {
            a.d();
        }
        if (z) {
            this.e.b();
        } else {
            this.e.stopForeground(false);
        }
    }

    @Override // defpackage.afx
    public void c() {
        if (aff.a) {
            mm.b("MusicPlayerForLocal", "pause()");
        }
        synchronized (this) {
            this.d.removeMessages(4);
            a.f();
        }
    }

    @Override // defpackage.afx
    public long a(long j) {
        if (aff.a) {
            mm.b("MusicPlayerForLocal", "seek()");
        }
        if (this.e.c() == null) {
            return 0L;
        }
        if (a != null && a.b()) {
            if (j < 0) {
                j = 0;
            }
            if (j > a.g()) {
                j = a.g();
            }
            return a.a(j);
        }
        return -1L;
    }

    @Override // defpackage.afx
    public long e() {
        if (aff.a && this.e.c() == null) {
            return 0L;
        }
        if (a != null && a.b()) {
            return a.h() / 1000;
        }
        return -1L;
    }

    @Override // defpackage.afx
    public long f() {
        if (a != null) {
            return a.g();
        }
        return 0L;
    }

    @Override // defpackage.afx
    public void g() {
        a.e();
        a = null;
        this.c.abandonAudioFocus(this.g);
    }

    @Override // defpackage.afx
    public void a(float f) {
        if (a != null) {
            a.a(f);
        }
    }

    class a {
        private Handler g;
        private boolean h = false;
        MediaPlayer.OnPreparedListener a = new MediaPlayer.OnPreparedListener() { // from class: afw.a.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                a.this.g.sendEmptyMessage(7);
            }
        };
        MediaPlayer.OnBufferingUpdateListener b = new MediaPlayer.OnBufferingUpdateListener() { // from class: afw.a.2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            }
        };
        MediaPlayer.OnCompletionListener c = new MediaPlayer.OnCompletionListener() { // from class: afw.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.g.sendEmptyMessage(1);
                a.this.g.sendEmptyMessage(2);
            }
        };
        MediaPlayer.OnErrorListener d = new MediaPlayer.OnErrorListener() { // from class: afw.a.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                switch (i) {
                    case -1010:
                    case -1007:
                    case -1004:
                    case -110:
                    case 1:
                    case HttpStatus.SC_OK /* 200 */:
                        break;
                    case -19:
                    case 100:
                        a.this.h = false;
                        a.this.f.release();
                        a.this.f = new MediaPlayer();
                        a.this.f.setWakeMode(afw.this.e, 1);
                        a.this.g.sendMessageDelayed(a.this.g.obtainMessage(3), 2000L);
                        return true;
                    default:
                        mm.b("MultiPlayer", "Error: " + i + "," + i2);
                        break;
                }
                return false;
            }
        };
        private MediaPlayer f = new MediaPlayer();

        public a() {
            this.f.setWakeMode(afw.this.e, 1);
            this.f.setOnCompletionListener(this.c);
            this.f.setOnErrorListener(this.d);
            this.f.setOnBufferingUpdateListener(this.b);
            this.f.setOnPreparedListener(this.a);
        }

        public void a() {
            this.f.reset();
        }

        public void a(String str) throws IOException {
            this.h = false;
            this.f.reset();
            if (str.startsWith("content://")) {
                this.f.setDataSource(afw.this.e, Uri.parse(str));
            } else {
                this.f.setDataSource(str);
            }
            this.f.setAudioStreamType(3);
            this.f.prepare();
            this.h = true;
            mm.b();
        }

        public boolean b() {
            return this.h;
        }

        public void c() {
            if (afw.this.c.requestAudioFocus(afw.this.g, 3, 1) == 1) {
                this.f.start();
            }
        }

        public void d() {
            this.f.stop();
            this.h = false;
        }

        public void e() {
            this.f.release();
        }

        public void f() {
            this.f.pause();
        }

        public void a(Handler handler) {
            this.g = handler;
        }

        public long g() {
            return this.f.getDuration();
        }

        public long h() {
            return this.f.getCurrentPosition();
        }

        public long a(long j) {
            this.f.seekTo(((int) j) * 1000);
            return j;
        }

        public void a(float f) {
            this.f.setVolume(f, f);
        }
    }

    @Override // defpackage.afx
    public void a(Handler handler) {
        this.d = handler;
        a.a(this.d);
    }
}
