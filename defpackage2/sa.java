package defpackage;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sa extends SurfaceView implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {
    private static final Map<Integer, String> a = new HashMap();
    private int b;
    private int c;
    private SurfaceHolder d;
    private MediaPlayer e;
    private Uri f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private boolean m;
    private boolean n;
    private int o;
    private ry p;

    static {
        a.put(-1004, "MEDIA_ERROR_IO");
        a.put(-1007, "MEDIA_ERROR_MALFORMED");
        a.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        a.put(-110, "MEDIA_ERROR_TIMED_OUT");
        a.put(100, "MEDIA_ERROR_SERVER_DIED");
        a.put(1, "MEDIA_ERROR_UNKNOWN");
        a.put(1, "MEDIA_INFO_UNKNOWN");
        a.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        a.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        a.put(701, "MEDIA_INFO_BUFFERING_START");
        a.put(702, "MEDIA_INFO_BUFFERING_END");
        a.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        a.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        a.put(802, "MEDIA_INFO_METADATA_UPDATE");
        a.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        a.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public sa(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
        this.l = 1.0f;
        getHolder().addCallback(this);
        if (Build.VERSION.SDK_INT < 11) {
            getHolder().setType(3);
        }
    }

    private void a(boolean z) {
        su.d("AdVideoView release");
        if (this.e != null) {
            this.e.reset();
            this.e.release();
            this.e = null;
            this.b = 0;
            if (z) {
                this.c = 0;
            }
            i();
        }
    }

    private void b(float f) {
        if (this.e == null) {
            su.e("AdVideoView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                this.e.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        }
    }

    private void f() {
        su.d("AdVideoView init MediaPlayer");
        if (this.f == null || this.d == null) {
            return;
        }
        a(false);
        try {
            this.e = new MediaPlayer();
            this.e.setOnBufferingUpdateListener(this);
            this.e.setOnCompletionListener(this);
            this.e.setOnErrorListener(this);
            this.e.setOnInfoListener(this);
            this.e.setOnPreparedListener(this);
            this.e.setOnVideoSizeChangedListener(this);
            this.k = 0;
            this.e.setDataSource(getContext(), this.f);
            this.e.setDisplay(this.d);
            this.e.setAudioStreamType(3);
            this.e.setScreenOnWhilePlaying(true);
            this.e.prepareAsync();
            this.b = 1;
        } catch (IOException | IllegalArgumentException e) {
            su.c("Failed to initialize MediaPlayer at " + this.f, e);
            onError(this.e, 1, 0);
        }
    }

    private void g() {
        if (!j() || this.c == 3) {
            return;
        }
        su.d("AdVideoView nudging MediaPlayer");
        this.e.start();
        int currentPosition = this.e.getCurrentPosition();
        long jA = sy.g().a();
        while (j() && this.e.getCurrentPosition() == currentPosition && sy.g().a() - jA <= 250) {
        }
        this.e.pause();
    }

    private void h() {
        AudioManager audioManagerN = n();
        if (audioManagerN == null || this.n) {
            return;
        }
        if (audioManagerN.requestAudioFocus(this, 3, 2) == 1) {
            k();
        } else {
            su.e("AdVideoView audio focus request failed");
        }
    }

    private void i() {
        su.d("AdVideoView abandon audio focus");
        AudioManager audioManagerN = n();
        if (audioManagerN == null || !this.n) {
            return;
        }
        if (audioManagerN.abandonAudioFocus(this) == 1) {
            this.n = false;
        } else {
            su.e("AdVideoView abandon audio focus failed");
        }
    }

    private boolean j() {
        return (this.e == null || this.b == -1 || this.b == 0 || this.b == 1) ? false : true;
    }

    private void k() {
        su.d("AdVideoView audio focus gained");
        this.n = true;
        m();
    }

    private void l() {
        su.d("AdVideoView audio focus lost");
        this.n = false;
        m();
    }

    private void m() {
        if (this.m || !this.n) {
            b(0.0f);
        } else {
            b(this.l);
        }
    }

    private AudioManager n() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    public void a() {
        su.d("AdVideoView stop");
        if (this.e != null) {
            this.e.stop();
            this.e.release();
            this.e = null;
            this.b = 0;
            this.c = 0;
            i();
        }
    }

    public void a(float f) {
        this.l = f;
        m();
    }

    public void a(int i) {
        su.d("AdVideoView seek " + i);
        if (!j()) {
            this.o = i;
        } else {
            this.e.seekTo(i);
            this.o = 0;
        }
    }

    public void a(ry ryVar) {
        this.p = ryVar;
    }

    public void b() {
        su.d("AdVideoView play");
        if (j()) {
            this.e.start();
            this.b = 3;
            zf.a.post(new Runnable() { // from class: sa.6
                @Override // java.lang.Runnable
                public void run() {
                    if (sa.this.p != null) {
                        sa.this.p.b();
                    }
                }
            });
        }
        this.c = 3;
    }

    public void c() {
        su.d("AdVideoView pause");
        if (j() && this.e.isPlaying()) {
            this.e.pause();
            this.b = 4;
            zf.a.post(new Runnable() { // from class: sa.7
                @Override // java.lang.Runnable
                public void run() {
                    if (sa.this.p != null) {
                        sa.this.p.c();
                    }
                }
            });
        }
        this.c = 4;
    }

    public void d() {
        this.m = true;
        m();
    }

    public void e() {
        this.m = false;
        m();
    }

    public int getCurrentPosition() {
        if (j()) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i > 0) {
            k();
        } else if (i < 0) {
            l();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.k = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        su.d("AdVideoView completion");
        this.b = 5;
        this.c = 5;
        zf.a.post(new Runnable() { // from class: sa.2
            @Override // java.lang.Runnable
            public void run() {
                if (sa.this.p != null) {
                    sa.this.p.d();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = a.get(Integer.valueOf(i));
        final String str2 = a.get(Integer.valueOf(i2));
        su.e("AdVideoView MediaPlayer error: " + str + ":" + str2);
        this.b = -1;
        this.c = -1;
        zf.a.post(new Runnable() { // from class: sa.3
            @Override // java.lang.Runnable
            public void run() {
                if (sa.this.p != null) {
                    sa.this.p.a(str, str2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        su.d("AdVideoView MediaPlayer info: " + a.get(Integer.valueOf(i)) + ":" + a.get(Integer.valueOf(i2)));
        return true;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.g, i);
        int defaultSize2 = getDefaultSize(this.h, i2);
        if (this.g > 0 && this.h > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.g * defaultSize2 < this.h * size) {
                    defaultSize = (this.g * defaultSize2) / this.h;
                } else if (this.g * defaultSize2 > this.h * size) {
                    defaultSize2 = (this.h * size) / this.g;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.h * size) / this.g;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.g * defaultSize2) / this.h;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.g;
                int i5 = this.h;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.g * defaultSize2) / this.h;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.h * size) / this.g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(final MediaPlayer mediaPlayer) {
        su.d("AdVideoView prepared");
        this.b = 2;
        zf.a.post(new Runnable() { // from class: sa.1
            @Override // java.lang.Runnable
            public void run() {
                if (sa.this.p != null) {
                    sa.this.p.a(mediaPlayer);
                }
            }
        });
        this.g = mediaPlayer.getVideoWidth();
        this.h = mediaPlayer.getVideoHeight();
        if (this.o != 0) {
            a(this.o);
        }
        g();
        if (this.g != 0 && this.h != 0) {
            su.c("AdVideoView stream dimensions: " + this.g + " x " + this.h);
            getHolder().setFixedSize(this.g, this.h);
            if (this.i == this.g && this.j == this.h && this.c == 3) {
                b();
            }
        } else if (this.c == 3) {
            b();
        }
        h();
        m();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        su.d("AdVideoView size changed: " + i + " x " + i2);
        this.g = mediaPlayer.getVideoWidth();
        this.h = mediaPlayer.getVideoHeight();
        if (this.g == 0 || this.h == 0) {
            return;
        }
        getHolder().setFixedSize(this.g, this.h);
        requestLayout();
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f = uri;
        this.o = 0;
        f();
        requestLayout();
        invalidate();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        su.d("AdVideoView surface changed");
        this.i = i2;
        this.j = i3;
        boolean z = this.c == 3;
        boolean z2 = this.g == i2 && this.h == i3;
        if (this.e != null && z && z2) {
            if (this.o != 0) {
                a(this.o);
            }
            b();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        su.d("AdVideoView surface created");
        this.d = surfaceHolder;
        f();
        zf.a.post(new Runnable() { // from class: sa.4
            @Override // java.lang.Runnable
            public void run() {
                if (sa.this.p != null) {
                    sa.this.p.a();
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        su.d("AdVideoView surface destroyed");
        if (this.e != null && this.o == 0) {
            this.o = this.e.getCurrentPosition();
        }
        this.d = null;
        zf.a.post(new Runnable() { // from class: sa.5
            @Override // java.lang.Runnable
            public void run() {
                if (sa.this.p != null) {
                    sa.this.p.c();
                    sa.this.p.e();
                }
            }
        });
        a(true);
    }

    @Override // android.view.View
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
