package defpackage;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bfrx.Device;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.afz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class aex {
    private final Set<aey> b = Collections.synchronizedSet(new HashSet());
    private Map<Long, adx> d = Collections.emptyMap();
    private final ConcurrentHashMap<Long, adx> e = new ConcurrentHashMap<>();
    private int f = 3000;
    private boolean g = false;
    private ScheduledFuture<?> h = null;
    private Map<adx, Long> i = new HashMap();
    private TreeSet<Integer> j = new TreeSet<>();
    private afz.a k = new afz.a() { // from class: aex.1
        @Override // defpackage.afz
        public void a(Bundle bundle) {
            Device device = (Device) bundle.getSerializable("DEVICE");
            if (device.getMkType() == 7 || device.getMkType() == 8 || device.getMkType() == 12) {
                aex.this.j.add(Integer.valueOf(device.getMkRoomId()));
                if (device.getMkRoomId() == 0) {
                    adx adxVar = new adx(device);
                    mm.b("5.1 source", "on Device Discovered set main device to audio mode");
                    aoz.a(adxVar);
                }
            }
            if (device.getMkChannelType() == 2 && !aex.this.j.contains(Integer.valueOf(device.getMkRoomId()))) {
                aex.this.e.remove(device);
            } else {
                aex.this.a(device);
            }
            if (aho.a("KEY_SHOW_DEVICE_RESET")) {
                aex.this.a(device);
            }
            Object[] objArr = new Object[6];
            objArr[0] = device;
            objArr[1] = Integer.valueOf(Process.myPid());
            objArr[2] = Byte.valueOf(device.getMkChannelType());
            objArr[3] = ahx.a().b();
            objArr[4] = Boolean.valueOf(device.getMkMaster() != 1);
            objArr[5] = device.getMkRoomName();
            mm.b("Discovered device %s on process %s channel=%s wifi=%s isMaster=%s , getMkRoomName=%s", objArr);
        }

        @Override // defpackage.afz
        public void a(long j) {
            List<adx> listK;
            mm.b("Device removed %s on wifi %s", Long.valueOf(j), ahx.a().b());
            Iterator it = new ArrayList(aex.this.b).iterator();
            while (it.hasNext()) {
                ((aey) it.next()).b((adx) aex.this.e.get(Long.valueOf(j)));
            }
            aex.this.a(j);
            adx adxVarA = aof.a().a(j);
            if (adxVarA == null || ((!adxVarA.H() && !adxVarA.I()) || ain.Y)) {
                aex.this.e.remove(Long.valueOf(j));
            } else {
                aex.this.e.remove(Long.valueOf(j));
                aex.this.j.remove(Integer.valueOf(adxVarA.s()));
                adz adzVarA = aof.a().a(adxVarA);
                if (adzVarA != null && (listK = adzVarA.k()) != null && !listK.isEmpty()) {
                    for (adx adxVar : listK) {
                        if (adxVar != null) {
                            aex.this.e.remove(Long.valueOf(adxVar.P()));
                        }
                    }
                }
            }
            aof.a().p();
            mm.b("onRemoveDevice, mDevices %s, lastSendDevices %s", aex.this.e, aex.this.d);
            aex.this.a((Map<Long, adx>) aex.this.d, new HashMap(aex.this.e));
        }

        @Override // defpackage.afz
        public void a() {
            aex.this.h();
            mm.b("onNetworkDisconnected, mDevices %s, lastSendDevices %s", aex.this.e, aex.this.d);
            aex.this.a((Map<Long, adx>) aex.this.d, aex.this.e);
        }

        @Override // defpackage.afz
        public void a(long j, int i, String str) {
            mm.b("onDeviceError %s, error %s, message %s", Long.valueOf(j), Integer.valueOf(i), str);
            aex.this.a(j, i, str);
        }

        @Override // defpackage.afz
        public void a(long j, String str) {
            aex.this.a(j, str);
        }

        @Override // defpackage.afz
        public void b(long j) {
            aex.this.b(j);
        }

        @Override // defpackage.afz
        public void a(long j, byte[] bArr, byte[] bArr2) {
            afc.a().a(j, bArr, bArr2);
        }

        @Override // defpackage.afz
        public void a(long j, int i) {
            afc.a().b(j, i);
        }

        @Override // defpackage.afz
        public void a(int i) {
            adw.a().a(i);
        }

        @Override // defpackage.afz
        public void b(long j, int i, String str) {
        }
    };
    private final Context a = HarmanApplication.a();
    private final asl c = new asl(new ash() { // from class: aex.2
        @Override // defpackage.ash
        public void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
            if (!networkInfo.isConnected()) {
                mm.b("Clearing devices because of network change: ", aex.this.e);
                aex.this.e.clear();
                mm.b("clean devices 0", new Object[0]);
                mq.a("FC_THREAD").a(new Runnable() { // from class: aex.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aex.this.f();
                    }
                });
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        adx adxVar;
        adz adzVarA;
        ady adyVarO = aof.a().o();
        mm.b("alan test", "group" + adyVarO);
        if (adyVarO != null && adyVarO.m() == 32 && (adxVar = this.e.get(Long.valueOf(j))) != null && (adzVarA = aof.a().a(adxVar.s())) != null && adyVarO.f().contains(adzVarA) && adyVarO.f().size() == 1) {
            if (adzVarA.z() == 1 || (a(adzVarA) && adxVar.L())) {
                mm.c("FC streaming group no room, stop it", new Object[0]);
                afc.a().d();
            }
        }
    }

    private boolean a(adz adzVar) {
        return adzVar.d() == 2 || adzVar.d() == 4;
    }

    public void a() {
        afc.a().a(this.k);
    }

    public void a(final adx adxVar) {
        this.i.put(adxVar, Long.valueOf(SystemClock.elapsedRealtime()));
        mq.a("FC_THREAD").postDelayed(new Runnable() { // from class: aex.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap(aex.this.e);
                mm.b("Remove device %s", Long.valueOf(adxVar.P()));
                aex.this.e.remove(Long.valueOf(adxVar.P()));
                aex.this.i.remove(adxVar);
                aex.this.a(map, aex.this.e);
            }
        }, 30000L);
    }

    public void b() {
        a(this.d, this.e);
    }

    public boolean b(adx adxVar) {
        return this.i.containsKey(adxVar);
    }

    void a(Device device) {
        adx adxVar;
        boolean z;
        device.volumeLevel = afc.b(device, device.volumeLevel);
        Device deviceUnmarshall = device.unmarshall();
        mm.b(deviceUnmarshall.groupName);
        mm.b(deviceUnmarshall.label);
        adx adxVar2 = this.e.get(Long.valueOf(deviceUnmarshall.uniqueID));
        if (adxVar2 == null) {
            adx adxVar3 = new adx(deviceUnmarshall);
            this.e.put(Long.valueOf(deviceUnmarshall.uniqueID), adxVar3);
            adxVar = adxVar3;
            z = true;
        } else {
            boolean zA = adxVar2.a(deviceUnmarshall);
            if (zA || aof.a().o() == null) {
                c(adxVar2);
            }
            adxVar = adxVar2;
            z = zA;
        }
        mm.b("Device discovered changed=%b, device= %s", Boolean.valueOf(z), adxVar.toString());
        if (adxVar.O() && adxVar.h() == null) {
            if (!aho.a("KEY_ENTER_DEMO_MODE")) {
                adw.a().C(adxVar);
                mm.b("TEST_DEVICE_FOTA_CHANGE query fotastatus ---mac = %s", adxVar.d());
            } else {
                return;
            }
        }
        if (adxVar.T() == -1) {
            adw.a().queryPrivateDataAll(adxVar);
        }
        if (adxVar.H() || adxVar.I()) {
            adw.a().g(adxVar);
        }
        if (adxVar.O() && TextUtils.isEmpty(adxVar.ah())) {
            adw.a().w(adxVar);
        }
        if (adxVar.O() && TextUtils.isEmpty(adxVar.c())) {
            adw.a().x(adxVar);
        }
        if (adxVar.f() == 0 || adxVar.f() == 1) {
            adw.a().queryWifi(adxVar);
        }
        adw.a().b(adxVar);
        if (TextUtils.isEmpty(adxVar.d())) {
            adxVar.af();
        }
        if (!aim.b() && adxVar.O()) {
            if (adxVar.aj() != 1 || adxVar.al() <= 5) {
                mm.c("send google cast TOS command, status=%d, count=%d, uuid=%l", Byte.valueOf(adxVar.aj()), Integer.valueOf(adxVar.al()), Long.valueOf(adxVar.P()));
                adw.a().c(adxVar, (byte) 1);
            }
            if (adxVar.aj() == 1) {
                adxVar.k(adxVar.al() + 1);
            }
        }
        HashMap map = new HashMap(this.e);
        if (z) {
            a(this.d, map);
        }
        afc.a().a(adxVar);
    }

    private void c(adx adxVar) {
        boolean z;
        int iS;
        adz adzVarA;
        ady adyVarO = aof.a().o();
        if (adyVarO == null) {
            int iS2 = adxVar.s();
            adz adzVarA2 = aof.a().a(iS2);
            if (adzVarA2 != null && adzVarA2.u() && adzVarA2.f() == 32) {
                mm.b("deactive roomId=%d, goupId=%d, uuid=%l", Integer.valueOf(iS2), Integer.valueOf(adzVarA2.x()), Long.valueOf(adxVar.P()));
                adzVarA2.b(false);
                return;
            }
            return;
        }
        List<adx> listO = adyVarO.o();
        if (listO != null && !listO.isEmpty()) {
            mm.a((Object) ("getStreamingGroup = " + adyVarO));
            Iterator<adx> it = adyVarO.o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (adxVar.P() == it.next().P()) {
                    z = true;
                    break;
                }
            }
            if (!z && (adzVarA = aof.a().a((iS = adxVar.s()))) != null) {
                mm.b("SearchFc.UpdateDeviceSession Streaming Group iD=%d, goupId=%d, uuid=%l, isStreaming=%b", Integer.valueOf(adyVarO.d()), Integer.valueOf(adzVarA.x()), Long.valueOf(adxVar.P()), Boolean.valueOf(z));
                if (adyVarO.d() != adzVarA.x()) {
                    mm.b("deactive room Id=%d, goupId=%d, uuid=%l, isStreaming=%b", Integer.valueOf(iS), Integer.valueOf(adzVarA.x()), Long.valueOf(adxVar.P()), Boolean.valueOf(z));
                    adzVarA.b(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = 3000;
        this.e.clear();
        mm.b("clean devices 1", new Object[0]);
        g();
    }

    private void g() {
        if (this.h != null && this.h.cancel(false)) {
            this.f = 1500;
            j();
        }
        if (!this.d.isEmpty()) {
            a(this.d, this.e);
        }
    }

    public void a(aey aeyVar) {
        this.b.add(aeyVar);
        final HashMap map = new HashMap(this.e);
        mq.a("FC_THREAD").a(new Runnable() { // from class: aex.4
            @Override // java.lang.Runnable
            public void run() {
                if (aex.this.g) {
                    aex.this.a(map, aex.this.e);
                }
            }
        });
    }

    public void b(aey aeyVar) {
        this.b.remove(aeyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, String str) {
        afc.a().a(j, i, str);
        ahz ahzVar = new ahz();
        ahzVar.a = i;
        ahzVar.b = str;
        ahzVar.e = j;
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((aey) it.next()).a(ahzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator it = new ArrayList(this.e.values()).iterator();
        while (it.hasNext()) {
            ((adx) it.next()).C();
        }
        this.e.clear();
        mm.b("clean devices 2", new Object[0]);
        Iterator it2 = new ArrayList(this.b).iterator();
        while (it2.hasNext()) {
            ((aey) it2.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, Object obj) {
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((aey) it.next()).a(j, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((aey) it.next()).a(j);
        }
    }

    public synchronized void c() {
        this.a.registerReceiver(this.c, this.c.a());
        mq.a("FC_THREAD").post(new Runnable() { // from class: aex.5
            @Override // java.lang.Runnable
            public void run() {
                if (!aex.this.g) {
                    aex.this.g = true;
                    aex.this.i();
                } else {
                    mm.b("Already running probe", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (!afc.a().c()) {
            mm.b("Failed to start probe, retrying", new Object[0]);
            mq.a("FC_THREAD").postDelayed(new Runnable() { // from class: aex.6
                @Override // java.lang.Runnable
                public void run() {
                    aex.this.i();
                }
            }, 3000L);
        } else {
            mm.b("Probe started", new Object[0]);
            a(this.d, this.e);
            j();
        }
    }

    private void j() {
        mm.b((Object) ("Scheduling poll in " + this.f + "s current wifi -> " + ahx.a().b()));
        this.h = mq.c().schedule(new Runnable() { // from class: aex.7
            @Override // java.lang.Runnable
            public void run() {
                mq.a("FC_THREAD").post(new Runnable() { // from class: aex.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aex.this.k();
                    }
                });
            }
        }, this.f, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.g) {
            if (afc.a().c() && !this.e.isEmpty()) {
                this.f = Math.min((int) (((double) this.f) * 1.1d), 30000);
                this.f = Math.max(this.f, 3000);
            } else {
                this.f = 3000;
            }
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Map<Long, adx> map, final Map<Long, adx> map2) {
        mq.a("FC_THREAD").a(new Runnable() { // from class: aex.8
            @Override // java.lang.Runnable
            public void run() {
                aex.this.d = map2;
                mm.b("Notifying that devices have changed from %s devices to %s devices, running %s, before: %s, after: %s, listeners %s", Integer.valueOf(map.size()), Integer.valueOf(map2.size()), Boolean.valueOf(aex.this.g), map, map2, aex.this.b);
                final List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(map2.values()));
                mq.b().a(new Runnable() { // from class: aex.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = new ArrayList(aex.this.b).iterator();
                        while (it.hasNext()) {
                            ((aey) it.next()).a(listUnmodifiableList);
                        }
                    }
                });
            }
        });
    }

    public List<adx> d() {
        return Collections.unmodifiableList(new ArrayList(this.e.values()));
    }

    public Map<Long, adx> e() {
        return Collections.unmodifiableMap(new HashMap(this.e));
    }
}
