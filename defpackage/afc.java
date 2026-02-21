package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bfrx.Device;
import com.bfrx.MediaItem;
import com.harman.commom.lib.fc.FcService;
import defpackage.afd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class afc {
    private static afc g = new afc();
    private WifiManager c;
    private WifiManager.MulticastLock d;
    private afv f;
    private afz h;
    private c j;
    private afd k;
    private aga l;
    private adx m;
    private HashMap<Long, aes> e = new HashMap<>();
    private HandlerThread i = new HandlerThread("sendcommand");
    ServiceConnection a = new ServiceConnection() { // from class: afc.9
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mm.b("Bound service %s", componentName);
            afc.this.k = afd.a.a(iBinder);
            aof.a().s();
            if (afc.this.l != null) {
                afc.this.a(afc.this.l);
                if (aof.a().o() != null) {
                    afc.this.m = aof.a().o().q();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            mm.b("Service disconnected %s", componentName);
            afc.this.k = null;
        }
    };
    private long n = 0;
    private byte[] o = null;
    int b = 0;

    interface a<T> {
        T b(afd afdVar);
    }

    interface b {
        void a(afd afdVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        a((Object) null, new a<Void>() { // from class: afc.1
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(afd afdVar) {
                bVar.a(afdVar);
                return null;
            }

            public String toString() {
                return bVar.toString();
            }
        });
    }

    private <T> T a(T t, a<T> aVar) {
        afd afdVar = this.k;
        if (afdVar != null) {
            try {
                return aVar.b(afdVar);
            } catch (RemoteException e) {
                mm.e("FC communication error", e);
                return t;
            }
        }
        mm.b("Not running command %s because service is not initialized", aVar);
        return t;
    }

    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            super.handleMessage(message);
            final List list = (List) message.obj;
            afc.this.a(new b() { // from class: afc.c.1
                @Override // afc.b
                public void a(afd afdVar) {
                    switch (message.what) {
                        case 0:
                            afdVar.a(4, ((adx) list.get(0)).P(), ((adx) list.get(1)).P());
                            break;
                        case 1:
                            afdVar.a(5, ((adx) list.get(0)).P(), ((adx) list.get(1)).P());
                            break;
                    }
                }

                public String toString() {
                    return "handleMessage " + message;
                }
            });
        }
    }

    public void a(Context context) {
        context.unbindService(this.a);
        context.stopService(new Intent(context, (Class<?>) FcService.class));
    }

    public void b(Context context) {
        context.bindService(new Intent(context, (Class<?>) FcService.class), this.a, 1);
    }

    public void a(adx adxVar) {
        if (this.m != null && adxVar.d().equals(this.m.d())) {
            afu.a().d();
            this.m = null;
        }
    }

    private afc() {
        this.j = null;
        this.i.start();
        this.j = new c(this.i.getLooper());
    }

    public static afc a() {
        return g;
    }

    public void a(adx adxVar, adx adxVar2) {
        if (adxVar != null && adxVar2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adxVar);
            arrayList.add(adxVar2);
            Message message = new Message();
            message.obj = arrayList;
            message.what = 0;
            this.j.sendMessageDelayed(message, 40L);
        }
    }

    public void b(adx adxVar, adx adxVar2) {
        if (adxVar != null && adxVar2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adxVar);
            arrayList.add(adxVar2);
            Message message = new Message();
            message.obj = arrayList;
            message.what = 1;
            this.j.sendMessageDelayed(message, 40L);
        }
    }

    public void a(aes aesVar) {
        this.e.put(Long.valueOf(aesVar.b()), aesVar);
    }

    public void a(afv afvVar) {
        this.f = afvVar;
    }

    public void a(Context context, final afy afyVar, final int i) {
        ain.q = System.currentTimeMillis();
        this.c = (WifiManager) context.getSystemService("wifi");
        this.c.reconnect();
        this.d = this.c.createMulticastLock("fcplayermc");
        this.d.acquire();
        a(new b() { // from class: afc.19
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a(true, afyVar, i);
            }

            public String toString() {
                return "initialize";
            }
        });
        ain.q = System.currentTimeMillis() - ain.q;
    }

    public void b() {
        if (this.d != null && this.d.isHeld()) {
            this.d.release();
        }
        a(new b() { // from class: afc.20
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a();
            }

            public String toString() {
                return "deinitialize";
            }
        });
    }

    public boolean c() {
        return ((Boolean) a(false, (a<boolean>) new a<Boolean>() { // from class: afc.21
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.a(1));
            }

            public String toString() {
                return "probeDevices";
            }
        })).booleanValue();
    }

    public void a(final afz afzVar) {
        this.h = afzVar;
        a(new b() { // from class: afc.2
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a(afzVar);
            }

            public String toString() {
                return "startSearch";
            }
        });
    }

    public void a(final aga agaVar) {
        this.l = agaVar;
        a(new b() { // from class: afc.3
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a(agaVar);
            }

            public String toString() {
                return "setHandler";
            }
        });
    }

    public void a(final int i) {
        a(new b() { // from class: afc.4
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.b(i);
            }

            public String toString() {
                return "setLossless";
            }
        });
    }

    public void a(final long j, final int i) {
        a(new b() { // from class: afc.5
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a(j, i);
            }

            public String toString() {
                return "setVolume";
            }
        });
    }

    public boolean a(final long j) {
        return ((Boolean) a(false, (a<boolean>) new a<Boolean>() { // from class: afc.6
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.a(j));
            }

            public String toString() {
                return "removeActiveDevice";
            }
        })).booleanValue();
    }

    public boolean b(final long j) {
        return ((Boolean) a(false, (a<boolean>) new a<Boolean>() { // from class: afc.7
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.b(j));
            }

            public String toString() {
                return "setActiveDevice";
            }
        })).booleanValue();
    }

    public boolean a(final Device device) {
        return ((Boolean) a(false, (a<boolean>) new a<Boolean>() { // from class: afc.8
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.c(device.uniqueID));
            }

            public String toString() {
                return "isDeviceIdActive";
            }
        })).booleanValue();
    }

    public void d() {
        mm.b("Going to stop plaback, here are backtrace:", new Object[0]);
        mm.c();
        a(new b() { // from class: afc.10
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.e();
            }

            public String toString() {
                return "stop";
            }
        });
    }

    public void e() {
        d();
    }

    public boolean a(String str) {
        final MediaItem mediaItem = new MediaItem();
        mediaItem.setUrl(str);
        mediaItem.setTitle("unknow");
        if (ain.i) {
            a(3);
        } else {
            a(0);
        }
        mm.b("playStart " + str, new Object[0]);
        a(new b() { // from class: afc.11
            @Override // afc.b
            public void a(afd afdVar) {
                mm.b("playStart call service begin", new Object[0]);
                afdVar.a(mediaItem, false);
                mm.b("playStart call service end", new Object[0]);
            }

            public String toString() {
                return "playStart";
            }
        });
        return true;
    }

    public boolean b(String str) {
        final MediaItem mediaItem = new MediaItem();
        mediaItem.setUrl(str);
        mediaItem.setTitle("unknow");
        if (ain.i) {
            a(3);
        } else {
            a(0);
        }
        mm.b("playResume " + str, new Object[0]);
        a(new b() { // from class: afc.12
            @Override // afc.b
            public void a(afd afdVar) {
                mm.b("playResume call service begin", new Object[0]);
                afdVar.a(mediaItem, true);
                mm.b("playResume call service end", new Object[0]);
            }

            public String toString() {
                return "playResume";
            }
        });
        return true;
    }

    public boolean a(String str, final long j) {
        final MediaItem mediaItem = new MediaItem();
        mediaItem.setUrl(str);
        mediaItem.setTitle("unknow");
        return ((Boolean) a(false, (a<boolean>) new a<Boolean>() { // from class: afc.13
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.a(mediaItem, j));
            }

            public String toString() {
                return "seek";
            }
        })).booleanValue();
    }

    public int f() {
        return ((Integer) a(-1, (a<int>) new a<Integer>() { // from class: afc.14
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(afd afdVar) {
                return Integer.valueOf(afdVar.g());
            }

            public String toString() {
                return "getFirstAvailableGroup";
            }
        })).intValue();
    }

    public boolean g() {
        return ((Boolean) a(true, (a<boolean>) new a<Boolean>() { // from class: afc.15
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.j());
            }

            public String toString() {
                return "probeDestinations";
            }
        })).booleanValue();
    }

    public boolean b(adx adxVar) {
        int i = 0;
        Device deviceMarshall = adxVar.R().marshall();
        if (!TextUtils.isEmpty(adxVar.a())) {
            deviceMarshall.ssid = adxVar.a();
            deviceMarshall.key = adxVar.b();
        }
        boolean zD = d(deviceMarshall);
        while (!zD) {
            i++;
            if (i > 2) {
                break;
            }
            try {
                mm.b("Retrying setDeviceSettings %s", Integer.valueOf(i));
                Thread.sleep(i * 1111);
                if (!TextUtils.isEmpty(adxVar.a())) {
                    deviceMarshall.ssid = adxVar.a();
                    deviceMarshall.key = adxVar.b();
                }
                zD = d(deviceMarshall);
            } catch (InterruptedException e) {
            }
        }
        return zD;
    }

    private boolean d(final Device device) {
        return ((Boolean) a(true, (a<boolean>) new a<Boolean>() { // from class: afc.16
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("device", device);
                return Boolean.valueOf(afdVar.a(bundle));
            }

            public String toString() {
                return "setDeviceSettings";
            }
        })).booleanValue();
    }

    public void a(final Device device, final byte[] bArr) {
        a(new b() { // from class: afc.17
            @Override // afc.b
            public void a(afd afdVar) {
                afdVar.a(device.uniqueID, bArr);
            }

            public String toString() {
                return "sendCommand";
            }
        });
    }

    public boolean h() {
        return ((Boolean) a(true, (a<boolean>) new a<Boolean>() { // from class: afc.18
            @Override // afc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(afd afdVar) {
                return Boolean.valueOf(afdVar.i());
            }

            public String toString() {
                return "isInitialized";
            }
        })).booleanValue();
    }

    public void b(long j, int i) {
        mm.a((Object) ("volume bar touch   " + ain.E));
        if (this.h != null && !ain.E) {
            adx adxVarA = aof.a().a(j);
            mm.a((Object) ("fixvolume---onDeviceVolumeChange---before adapt---" + i));
            if (adxVarA != null) {
                int iB = b(adxVarA.R(), i);
                mm.a((Object) ("fixvolume---onDeviceVolumeChange----after adapt---" + iB));
                if (adxVarA != null) {
                    if (adxVarA.s() == 0) {
                        adxVarA.i(iB);
                    } else {
                        adz adzVarA = aof.a().a(adxVarA.s());
                        if (adzVarA != null) {
                            adzVarA.a(j, iB);
                        } else {
                            return;
                        }
                    }
                    aob.h().f();
                }
            }
        }
    }

    public static boolean b(Device device) {
        return device.getMkType() == 1 || device.getMkType() == 2 || device.getMkType() == 3;
    }

    public static boolean c(Device device) {
        return device.getMkType() == 4 || device.getMkType() == 5 || device.getMkType() == 6 || device.getMkType() == 7 || device.getMkType() == 12 || device.getMkType() == 8;
    }

    public static int a(Device device, int i) {
        return b(device) ? i : (int) Math.round((((double) i) / 47.0d) * 100.0d);
    }

    public static int b(Device device, int i) {
        return b(device) ? i : (int) Math.round((((double) i) / 100.0d) * 47.0d);
    }

    public void a(long j, byte[] bArr, byte[] bArr2) {
        mm.a("Processing command for device %s, title %s, content %s", Long.valueOf(j), mm.a(bArr), mm.a(bArr2));
        if (bArr2.length != 0) {
            this.o = bArr2;
            this.n = j;
            aes aesVar = this.e.get(Long.valueOf(j));
            if (aesVar != null) {
                aesVar.a(j, bArr2);
            }
        }
    }

    public void i() {
        this.f.a();
    }

    public void a(long j, int i, String str) {
        adx adxVarA;
        if (str.contains("Invalid Media")) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == 4) {
                this.b = 0;
                j();
            }
        }
        if (i == 9 && (adxVarA = aof.a().a(j)) != null && adxVarA.u() == 1) {
            mm.c("onDeviceError deactive for 2.0 room", new Object[0]);
            aof.a().a(adxVarA.s()).b(false);
        }
    }

    public void j() {
        if (this.f != null) {
            this.f.b();
        }
    }
}
