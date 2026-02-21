package com.harman.commom.lib.fc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.bfrx.Device;
import com.bfrx.MediaController;
import com.bfrx.MediaItem;
import com.harman.commom.util.error.ErrorInfo;
import defpackage.afc;
import defpackage.afd;
import defpackage.afy;
import defpackage.afz;
import defpackage.aga;
import defpackage.bsf;
import defpackage.mm;
import defpackage.mo;
import defpackage.mq;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class FcService extends Service {
    public static Object a;
    afy b;
    private final afd.a c = new afd.a() { // from class: com.harman.commom.lib.fc.FcService.2
        @Override // defpackage.afd
        public void a(final boolean z, afy afyVar, int i) {
            FcService.this.b = afyVar;
            FcService.this.a("initialize", true, 15000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MediaController.initialize(FcService.this.getApplicationContext(), z, FcService.this.getCacheDir().getAbsolutePath());
                        FcService.this.b();
                    } catch (RuntimeException e) {
                        FcService.this.a("initialize", e, false);
                    }
                }
            });
        }

        @Override // defpackage.afd
        public void a() {
            FcService.this.a("deinitialize", true, 15000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.12
                @Override // java.lang.Runnable
                public void run() {
                    MediaController.deinitialize();
                }
            });
        }

        @Override // defpackage.afd
        public boolean a(final int i) {
            mm.c("probeDevices group=%d", Integer.valueOf(i));
            return ((Boolean) FcService.this.a("probeDevices", false, false, 7000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.19
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.probeDevices(i));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public void b() {
            mm.c("pauseDeviceProbe", new Object[0]);
            FcService.this.a("pauseDeviceProbe", false, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.20
                @Override // java.lang.Runnable
                public void run() {
                    MediaController.pauseDeviceProbe();
                }
            });
        }

        @Override // defpackage.afd
        public void c() {
            FcService.this.a("volumeUp", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.21
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaController.volumeUp()) {
                        mm.e("Could not set volume up", new Object[0]);
                    }
                }
            });
        }

        @Override // defpackage.afd
        public void d() {
            FcService.this.a("volumeDown", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.22
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaController.volumeDown()) {
                        mm.e("Could not set volume down", new Object[0]);
                    }
                }
            });
        }

        @Override // defpackage.afd
        public void b(final int i) {
            FcService.this.a("setLossless", true, 30000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.23
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaController.setLossless(i)) {
                        mm.e("Could not set lossless " + i, new Object[0]);
                    }
                }
            });
        }

        @Override // defpackage.afd
        public void a(final long j, final int i) {
            FcService.this.a("setVolumeById", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.24
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaController.setVolumeById(j, i)) {
                        mm.e("Could not set volume %s for device %s", Integer.valueOf(i), Long.valueOf(j));
                    }
                }
            });
        }

        @Override // defpackage.afd
        public boolean a(final long j) {
            return ((Boolean) FcService.this.a("removeActiveDevice", true, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.25
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.removeActiveDevice(j));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public boolean b(final long j) {
            return ((Boolean) FcService.this.a("setActiveDevice", true, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.setActiveDevice(j));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public boolean c(final int i) {
            return ((Boolean) FcService.this.a("setActiveGroup", true, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.setActiveGroup(i));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public boolean c(final long j) {
            return ((Boolean) FcService.this.a("isDeviceIdActive", false, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.isDeviceIdActive(j));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public void d(final int i) {
            FcService.this.a("toggleGroup", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaController.toggleGroup(i)) {
                        mm.e("Could not toggle group %s", Integer.valueOf(i));
                    }
                }
            });
        }

        @Override // defpackage.afd
        public void e() {
            mm.b("Service stop", new Object[0]);
            FcService.this.a("stop", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.6
                @Override // java.lang.Runnable
                public void run() {
                    mm.b("Service stop running begin", new Object[0]);
                    MediaController.stop();
                    mm.b("Service stop running end", new Object[0]);
                }
            });
        }

        @Override // defpackage.afd
        public void f() {
            mm.b("Service pause", new Object[0]);
            FcService.this.a("pause", true, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.7
                @Override // java.lang.Runnable
                public void run() {
                    mm.b("Service pause running begin", new Object[0]);
                    MediaController.stop();
                    mm.b("Service pause running begin", new Object[0]);
                }
            });
        }

        @Override // defpackage.afd
        public void a(final MediaItem mediaItem, final boolean z) {
            mm.b("Service play isResume=" + z, new Object[0]);
            FcService.this.a("play", true, 30000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.8
                @Override // java.lang.Runnable
                public void run() {
                    mm.b("Service play running begin isResume=" + z, new Object[0]);
                    MediaController.play(mediaItem, z);
                    mm.b("Service play running end isResume=" + z, new Object[0]);
                }
            });
        }

        @Override // defpackage.afd
        public boolean a(final MediaItem mediaItem, final long j) {
            return ((Boolean) FcService.this.a("seek", true, false, 30000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.9
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.seek(mediaItem, j));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public int g() {
            return ((Integer) FcService.this.a("getFirstAvailableGroup", true, -1, 15000, (Callable<int>) new Callable<Integer>() { // from class: com.harman.commom.lib.fc.FcService.2.10
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(MediaController.getFirstAvailableGroup());
                }
            })).intValue();
        }

        @Override // defpackage.afd
        public boolean a(final Bundle bundle) {
            return ((Boolean) FcService.this.a("setDeviceSettings", true, false, 15000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.11
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.setDeviceSettings((Device) bundle.getSerializable("device")));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public void a(final afz afzVar) {
            FcService.this.a("setDeviceHandler", false, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.13
                @Override // java.lang.Runnable
                public void run() {
                    MediaController.setDeviceHandler(new MediaController.DeviceHandler() { // from class: com.harman.commom.lib.fc.FcService.2.13.1
                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDeviceDiscovered(Device device, boolean z) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("DEVICE", device);
                            try {
                                afzVar.a(bundle);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onRemoveDevice(long j) {
                            try {
                                afzVar.a(j);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDeviceError(long j, int i, String str) {
                            try {
                                afzVar.a(j, i, str);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onNetworkDisconnected() {
                            try {
                                afzVar.a();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDeviceRecover(long j, Object obj) {
                            try {
                                afzVar.a(j, obj.toString());
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDevicePlayStarted(long j) {
                            try {
                                afzVar.b(j);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onPrivateCommand(long j, byte[] bArr, byte[] bArr2) {
                            try {
                                afzVar.a(j, bArr, bArr2);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDeviceVolumeChange(long j, int i) {
                            try {
                                afzVar.a(j, i);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onFcError(int i) {
                            try {
                                afzVar.a(i);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onVersionError(long j, int i, String str) {
                            try {
                                afzVar.b(j, i, str);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.DeviceHandler
                        public void onDeviceRecover(long j, String str) {
                        }
                    });
                }
            });
        }

        @Override // defpackage.afd
        public void a(final aga agaVar) {
            FcService.this.a("setHandler", false, 4000, new Runnable() { // from class: com.harman.commom.lib.fc.FcService.2.14
                @Override // java.lang.Runnable
                public void run() {
                    MediaController.setHandler(new MediaController.PlayStateHandler() { // from class: com.harman.commom.lib.fc.FcService.2.14.1
                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onStopped() {
                            try {
                                agaVar.h();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onPlayEnded(boolean z) {
                            try {
                                agaVar.a(z);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onPlayStarted() {
                            try {
                                agaVar.a();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onPlayTime(long j) {
                            try {
                                agaVar.a(j);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onFinishedPlaying() {
                            try {
                                agaVar.b();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onSourceError(int i, String str) {
                            try {
                                agaVar.a(i, str);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void alert(String str, String str2) {
                            try {
                                agaVar.a(str, str2);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onMoveNext() {
                            try {
                                agaVar.c();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void useLocalDevice(boolean z) {
                            try {
                                agaVar.c(z);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void Play() {
                            try {
                                agaVar.d();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void Update() {
                            try {
                                agaVar.e();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void Stop() {
                            try {
                                agaVar.f();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void Unload() {
                            try {
                                agaVar.g();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public int LoadTrack(MediaItem mediaItem) {
                            try {
                                return agaVar.a(mediaItem);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                                return 0;
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public boolean IsLoaded(boolean z) {
                            try {
                                return agaVar.b(z);
                            } catch (RemoteException e) {
                                return false;
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onStartedPlaying(MediaItem mediaItem) {
                            try {
                                agaVar.b(mediaItem);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onSourcePlaying(MediaItem mediaItem) {
                            try {
                                agaVar.c(mediaItem);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onFinished() {
                            try {
                                agaVar.i();
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }

                        @Override // com.bfrx.MediaController.PlayStateHandler
                        public void onPlayMediaSource(long j, String str, long j2) {
                            try {
                                agaVar.a(j, str, j2);
                            } catch (RemoteException e) {
                                mm.b("Service communication error", e);
                            }
                        }
                    });
                }
            });
        }

        @Override // defpackage.afd
        public boolean a(final long j, final byte[] bArr) {
            return ((Boolean) FcService.this.a("sendPrivateCommand", false, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.15
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.sendPrivateCommand(j, bArr));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public boolean a(final int i, final long j, final long j2) {
            return ((Boolean) FcService.this.a("sendCommand", true, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.16
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.sendCommand(i, j, j2));
                }
            })).booleanValue();
        }

        @Override // defpackage.afd
        public MediaItem h() {
            return (MediaItem) FcService.this.a("getMedia", true, (Object) null, 4000, (Callable<Object>) new Callable<MediaItem>() { // from class: com.harman.commom.lib.fc.FcService.2.17
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public MediaItem call() {
                    return MediaController.getMedia();
                }
            });
        }

        @Override // defpackage.afd
        public boolean i() {
            return MediaController.isInitCalled();
        }

        @Override // defpackage.afd
        public boolean j() {
            return ((Boolean) FcService.this.a("probeDestinations", true, false, 4000, (Callable<boolean>) new Callable<Boolean>() { // from class: com.harman.commom.lib.fc.FcService.2.18
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(MediaController.probeDestinations());
                }
            })).booleanValue();
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        mm.b("Creating FcService at process " + Process.myPid(), new Object[0]);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.harman.commom.lib.fc.FcService.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                FcService.this.a("", th, false);
            }
        });
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        mm.b("Creating FcService at process " + Process.myPid(), new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a = "FcService";
        return this.c;
    }

    <T> T a(final String str, final boolean z, T t, final int i, final Callable<T> callable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final bsf bsfVar = new bsf(t);
        mq.b().a(new Runnable() { // from class: com.harman.commom.lib.fc.FcService.3
            @Override // java.lang.Runnable
            public void run() {
                final CountDownLatch countDownLatch2 = new CountDownLatch(1);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                Runnable runnable = new Runnable() { // from class: com.harman.commom.lib.fc.FcService.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            mm.d();
                            Object objCall = callable.call();
                            mm.c(str);
                            bsfVar.a(objCall);
                        } catch (Throwable th) {
                            mm.e("Error calling %s with exception %s", str, th);
                            if (atomicBoolean.compareAndSet(false, true)) {
                                FcService.this.a(str, th, false);
                            }
                        } finally {
                            countDownLatch2.countDown();
                        }
                    }
                };
                if (z) {
                    mq.b().a(runnable);
                } else {
                    mq.a("FC_THREAD" + str).post(runnable);
                }
                try {
                    if (!countDownLatch2.await(i, TimeUnit.MILLISECONDS) && atomicBoolean.compareAndSet(false, true)) {
                        FcService.this.a(str, null, true);
                    }
                } catch (InterruptedException e) {
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }
        return (T) bsfVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, int i, final Runnable runnable) {
        a(str, z, (Object) null, i, new Callable<Void>() { // from class: com.harman.commom.lib.fc.FcService.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        mm.e("Destroying FcService at process " + Process.myPid(), new Object[0]);
        a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Throwable th, boolean z) {
        if (this.b != null) {
            Bundle bundle = new Bundle();
            bundle.putString("commandName", str);
            bundle.putBoolean("isHang", z);
            final ErrorInfo errorInfoA = new ErrorInfo.a().a("FcLibrary crash on command: " + str + ", isHang: " + z).a(th).a(bundle).a();
            mo.a.post(new Runnable() { // from class: com.harman.commom.lib.fc.FcService.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FcService.this.b.a(errorInfoA);
                    } catch (RemoteException e) {
                        mm.e("Error handling crash", e);
                    }
                }
            });
        }
    }

    private void a() {
        afc.a().b();
        mm.e("FcService killing process " + Process.myPid(), new Object[0]);
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            mo.a.post(new Runnable() { // from class: com.harman.commom.lib.fc.FcService.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FcService.this.b.a();
                    } catch (RemoteException e) {
                        mm.e("Error handling initialized", e);
                    }
                }
            });
        }
    }
}
