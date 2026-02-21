package com.harman.hkconnect.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.harman.hkconnect.R;
import defpackage.adw;
import defpackage.ady;
import defpackage.adz;
import defpackage.aof;
import defpackage.mq;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LockScreenService extends Service {
    public AudioManager a;
    private int b;
    private int c;
    private boolean d = false;
    private boolean e = false;
    private MediaPlayer f;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = (AudioManager) getSystemService("audio");
        this.a.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() { // from class: com.harman.hkconnect.service.LockScreenService.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                if (i == -2 || i == -1 || i == -3) {
                    LockScreenService.this.e = true;
                } else if (i == 1 || i == 2 || i == 3) {
                    LockScreenService.this.e = false;
                }
            }
        }, 2, 1);
        this.c = this.a.getStreamMaxVolume(3);
        this.f = MediaPlayer.create(this, R.raw.st);
        b();
    }

    public int a() {
        return this.a.getStreamVolume(3);
    }

    public void b() {
        this.b = a();
        try {
            c();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mq.b().execute(new Runnable() { // from class: com.harman.hkconnect.service.LockScreenService.2
            @Override // java.lang.Runnable
            public void run() {
                while (!LockScreenService.this.d) {
                    if (!LockScreenService.this.e) {
                        try {
                            Thread.sleep(20L);
                        } catch (InterruptedException e2) {
                        }
                        if (LockScreenService.this.b < LockScreenService.this.a()) {
                            LockScreenService.this.b = LockScreenService.this.a();
                            LockScreenService.this.d();
                            if (LockScreenService.this.b == LockScreenService.this.c) {
                                LockScreenService.this.a.setStreamVolume(3, LockScreenService.this.c - 1, 8);
                                LockScreenService.this.b = LockScreenService.this.c - 1;
                            }
                        }
                        if (LockScreenService.this.b > LockScreenService.this.a()) {
                            LockScreenService.this.b = LockScreenService.this.a();
                            LockScreenService.this.e();
                            if (LockScreenService.this.b == 0) {
                                LockScreenService.this.a.setStreamVolume(3, 1, 8);
                                LockScreenService.this.b = 1;
                            }
                        }
                    }
                }
            }
        });
    }

    private void c() {
        if (this.f != null) {
            this.f.start();
            this.f.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.harman.hkconnect.service.LockScreenService.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    try {
                        LockScreenService.this.f.start();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            List<adz> listF = adyVarB.f();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < listF.size()) {
                    int iT = listF.get(i2).t() + 1;
                    listF.get(i2).a(iT);
                    adw.a().a(listF.get(i2), iT);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            List<adz> listF = adyVarB.f();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < listF.size()) {
                    int iT = listF.get(i2).t() - 1;
                    listF.get(i2).a(iT);
                    adw.a().a(listF.get(i2), iT);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d = true;
        if (this.f != null) {
            this.f.stop();
            this.f.release();
        }
    }
}
