package com.harman.hkconnect.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import com.bfrx.MediaController;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import defpackage.afc;
import defpackage.agx;
import defpackage.aia;
import defpackage.aqp;
import defpackage.blh;
import defpackage.mj;
import defpackage.mm;
import defpackage.mn;
import defpackage.mq;
import defpackage.mr;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class HarmanApplication extends mj {
    @Override // defpackage.mj, android.app.Application
    public void onCreate() {
        mn.a();
        MediaController.setIsBlackfireRunInSeperateProcess(true);
        mm.a(false);
        mm.b(true);
        mm.c("HK Connect version %s (%s), flavor %s, debug %s, logging %s", "4.3.1.8-prod-release", 53, "prod", false);
        Thread.setDefaultUncaughtExceptionHandler(new aia(Thread.getDefaultUncaughtExceptionHandler()));
        super.onCreate();
        d();
        if (b()) {
            mq.b().execute(new Runnable() { // from class: com.harman.hkconnect.ui.HarmanApplication.1
                @Override // java.lang.Runnable
                public void run() {
                    MusicPlaylistManager.a().a(HarmanApplication.this);
                    agx.a();
                }
            });
            c();
            mm.b("HarmanApplication starting service at process %s", Integer.valueOf(Process.myPid()));
            afc.a().b(a());
        }
        new aqp(this).a();
        a(getResources());
    }

    private void c() {
        blh.a(this, new mr());
    }

    private void d() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getResources());
    }

    private void a(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (configuration.locale.toString().equalsIgnoreCase("ar_AE")) {
            configuration.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }
}
