package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.bfrx.Device;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DialogActivity;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.afy;
import defpackage.aqe;
import defpackage.arw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class aof {
    private static aof c;
    private Context d;
    private afa f;
    private aey i;
    private aod e = new aod(Collections.emptyMap());
    Set<Runnable> a = Collections.synchronizedSet(new HashSet());
    private final aex g = new aex();
    private final adx h = new adx(new Device());
    final Handler b = new a(this);

    public static synchronized aof a() {
        if (c == null) {
            c = new aof(HarmanApplication.a());
        }
        return c;
    }

    protected aof(Context context) {
        this.d = context.getApplicationContext();
    }

    public ady b() {
        return this.e.d();
    }

    public adz a(adx adxVar) {
        return this.e.a(adxVar);
    }

    public aex c() {
        return this.g;
    }

    public List<adz> d() {
        w();
        return this.e.b();
    }

    public List<ady> e() {
        w();
        return this.e.c();
    }

    public List<adx> f() {
        w();
        return this.e.a();
    }

    public boolean g() {
        Iterator<adx> it = this.e.a().iterator();
        while (it.hasNext()) {
            if (!it.next().N()) {
                return true;
            }
        }
        return false;
    }

    static class a extends Handler {
        private final WeakReference<aof> a;

        public a(aof aofVar) {
            this.a = new WeakReference<>(aofVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            aof aofVar = this.a.get();
            if (aofVar != null) {
                switch (message.what) {
                    case 1002:
                        aofVar.d(message);
                        break;
                    case 1004:
                        aofVar.a(message);
                        break;
                    case 1005:
                        aofVar.t();
                        break;
                    case 1103:
                        aofVar.b(message);
                        break;
                    case 1104:
                        aofVar.c(message);
                        break;
                    case 1105:
                        aofVar.c((adx) message.obj);
                        break;
                    case 1107:
                        aofVar.m(message);
                        break;
                    case 1110:
                        aofVar.i();
                        break;
                    case 1111:
                        aofVar.p(message);
                        break;
                    case 1112:
                        aofVar.q(message);
                        break;
                    case 1113:
                        mm.b("TEST_DEVICE_FOTA_CHANGE handle message", new Object[0]);
                        aofVar.f((adx) message.obj);
                        break;
                    case 1114:
                        aofVar.e(message);
                        break;
                    case 1115:
                        aofVar.l(message);
                        break;
                    case 1116:
                        aofVar.k(message);
                        break;
                    case 1117:
                        aofVar.j(message);
                        break;
                    case 1118:
                        aofVar.i(message);
                        break;
                    case 1119:
                        aofVar.h(message);
                        break;
                    case 1120:
                        aofVar.g(message);
                        break;
                    case 1121:
                        aofVar.f(message);
                        break;
                    case 1207:
                        aofVar.n(message);
                        break;
                    case 1208:
                        aofVar.o(message);
                        break;
                    case 3004:
                        aofVar.h();
                        break;
                    case 7001:
                        Toast.makeText(aofVar.d, R.string.AutoLoadMessage_Str, 0).show();
                        break;
                    case 7002:
                        long jLongValue = ((Long) message.obj).longValue();
                        Intent intent = new Intent("ACTION_RECOVERY");
                        intent.putExtra("deviceid", jLongValue);
                        aofVar.d.sendBroadcast(intent);
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        mm.b("spotify debug ===================handleRepeatAll", new Object[0]);
        a((adx) message.obj, true, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        mm.b("spotify debug ===================handleReStartCurrentTrack", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        mm.b("spotify debug ===================handleShuffleOff", new Object[0]);
        a((adx) message.obj, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Message message) {
        mm.b("spotify debug ===================handleShuffleButton", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        mm.b("spotify debug ===================handleShuffleOn", new Object[0]);
        a((adx) message.obj, false, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        mm.b("spotify debug ===================handleRepeatButton", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Message message) {
        mm.b("spotify debug ===================handleRepeatOff", new Object[0]);
        a((adx) message.obj, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        mm.b("spotify debug ===================handleRepeatCureentTrack", new Object[0]);
        a((adx) message.obj, true, 1);
    }

    private void a(adx adxVar, boolean z, int i) {
        if (z) {
            MusicPlaylistManager.a().c(adxVar.r(), i);
        } else {
            MusicPlaylistManager.a().b(adxVar.r(), i);
        }
    }

    protected void h() {
    }

    protected void a(Message message) {
        Intent intent = new Intent("ACTION_MK_DEVICE_REMOVED");
        adx adxVar = (adx) message.obj;
        intent.putExtra("uuid", adxVar.P());
        intent.putExtra("roomid", adxVar.s());
        this.d.sendBroadcast(intent);
    }

    protected void b(Message message) {
        HashMap map = (HashMap) message.obj;
        adx adxVar = (adx) map.get("DEVICE");
        int iIntValue = ((Integer) map.get("TYPE")).intValue();
        mm.b("MSG_PRIVATE_DATA_MSG----->" + iIntValue, new Object[0]);
        if ((iIntValue & 2) != 0 && o() != null && o().a(adxVar) && adxVar.S() != 32) {
            j();
        }
        if ((iIntValue & 4) != 0) {
        }
        if ((iIntValue & 8) != 0) {
        }
        if ((iIntValue & 16) != 0) {
            aob.h().g();
        }
        p();
    }

    void i() {
        HashSet hashSet;
        mm.b("MSG_GROUP_FEATURE", new Object[0]);
        synchronized (this.a) {
            hashSet = new HashSet(this.a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.d.sendBroadcast(new Intent("ACTION_ON_NETWORK_DISCONNECT"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final adx adxVar) {
        mq.a("FC_THREAD").a(new Runnable() { // from class: aof.2
            @Override // java.lang.Runnable
            public void run() {
                ady adyVarE = aof.this.e.e();
                if (adyVarE != null) {
                    adz adzVarA = aof.this.e.a(adxVar);
                    if (adzVarA == null) {
                        mm.b("Device %s not in a room", adxVar);
                        return;
                    }
                    HashSet hashSet = new HashSet(adyVarE.f());
                    if (adyVarE.c(adzVarA)) {
                        if (adyVarE.f().size() > 1) {
                            hashSet.remove(adzVarA);
                        } else {
                            mm.b("Ignoring add to stream request for streaming stand alone speaker", new Object[0]);
                        }
                    } else {
                        hashSet.add(adzVarA);
                    }
                    aof.this.a(adyVarE, hashSet);
                    return;
                }
                mm.b("Not currently streaming", new Object[0]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Message message) {
        adx adxVar = (adx) message.obj;
        ady adyVarE = this.e.e();
        if (adyVarE != null && adyVarE.a(adxVar)) {
            MusicPlaylistManager.a().m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Message message) {
        mm.b("spotify debug ===================handlePlay", new Object[0]);
        adx adxVar = (adx) message.obj;
        ady adyVarE = this.e.e();
        if (adyVarE != null && adyVarE.a(adxVar) && !MusicPlaylistManager.a().v() && MusicPlaylistManager.a().i() != null && !MusicPlaylistManager.a().i().d()) {
            MusicPlaylistManager.a().k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Message message) {
        mm.b("spotify debug ===================handlePause", new Object[0]);
        adx adxVar = (adx) message.obj;
        ady adyVarE = this.e.e();
        if (adyVarE != null && adyVarE.a(adxVar) && MusicPlaylistManager.a().v()) {
            MusicPlaylistManager.a().l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Message message) {
        mm.b("spotify debug ===================handlePlayNext", new Object[0]);
        adx adxVar = (adx) message.obj;
        ady adyVarE = this.e.e();
        if (adyVarE != null && adyVarE.a(adxVar)) {
            MusicPlaylistManager.a().r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Message message) {
        mm.b("spotify debug ===================handlePlayPrevious", new Object[0]);
        adx adxVar = (adx) message.obj;
        ady adyVarE = this.e.e();
        if (adyVarE != null && adyVarE.a(adxVar)) {
            MusicPlaylistManager.a().q();
        }
    }

    void c(Message message) {
        adx adxVar = (adx) message.obj;
        mm.b("Party mode request from %s", adxVar);
        d(adxVar);
    }

    private void d(adx adxVar) {
        adz adzVarA = this.e.a(adxVar);
        if (adzVarA == null) {
            mm.b("No room for device %s, cannot party mode with rooms %s", adxVar, this.e.b());
            return;
        }
        ady adyVarA = this.e.a(this.e.c(), adzVarA);
        if (adyVarA == null) {
            mm.b("No group for room %s, cannot party mode with rooms %s", adxVar, this.e.b());
            return;
        }
        Iterator<adz> it = this.e.b().iterator();
        while (it.hasNext()) {
            Iterator<adx> it2 = it.next().k().iterator();
            while (it2.hasNext()) {
                adw.a().t(it2.next());
            }
        }
        a(adyVarA, this.e.b());
    }

    void d(Message message) {
        ahz ahzVar = (ahz) message.obj;
        if (ahzVar.b != null) {
            if ((ahzVar.a < 0 || ahzVar.a > 5) && ahzVar.a != 10 && ahzVar.a != 11) {
                if (ahzVar.a == 9) {
                    mm.a((Object) ("swapp error code 9  device id = " + ahzVar.e));
                    e(a(ahzVar.e));
                } else if (ahzVar.b.contains("Invalid Media")) {
                    Toast.makeText(this.d, this.d.getResources().getString(R.string.PlayErrorTip_Str), 1).show();
                } else if (!agu.a(this.d)) {
                    Intent intent = new Intent(this.d, (Class<?>) DialogActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("error_type", ahzVar.a);
                    this.d.startActivity(intent);
                }
            }
        }
    }

    private void e(adx adxVar) {
        mm.b("Error code 9, waiting for update owner status %s", adxVar);
        if (adxVar != null) {
            final long jP = adxVar.P();
            adw.a().b();
            mo.a.postDelayed(new Runnable() { // from class: aof.3
                @Override // java.lang.Runnable
                public void run() {
                    adx adxVarA = aof.this.a(jP);
                    if (adxVarA != null) {
                        mm.e("Error code 9", "Error Device:: " + adxVarA);
                        ady adyVarB = aof.this.b(adxVarA.r());
                        mm.e("Error code 9", "Error Group:: " + adxVarA);
                        ady adyVarE = aof.this.e.e();
                        mm.e("Error code 9", "Streaming Group:: " + adyVarE);
                        adz adzVarA = aof.this.a(adxVarA.s());
                        if (adyVarE != null && adyVarE.a(adxVarA)) {
                            Object[] objArr = new Object[3];
                            objArr[0] = "Error Room for Channel 20 = %s  Streaming FC ROOM list=%d";
                            objArr[1] = adxVarA;
                            objArr[2] = Integer.valueOf(adyVarE.f() != null ? adyVarE.f().size() : -1);
                            mm.e("Error code 9", objArr);
                            if (adyVarE.f() != null && adyVarE.f().size() > 1 && adxVarA.L()) {
                                adzVarA.d(false);
                                adzVarA.b(false);
                                aof.this.d.sendBroadcast(new Intent("ACTION_MK_DEVICES_UPDATED"));
                                return;
                            }
                            mm.e("Error code 9", "Test 1");
                            if (adyVarE.equals(adyVarB)) {
                                mm.e("Error code 9", "Test 2");
                                aof.this.e.b((ady) null);
                                aof.this.d.sendBroadcast(new Intent("ACTION_MK_DEVICES_UPDATED"));
                                adyVarE.b(false);
                            }
                            mm.e("Error code 9", "Test 3");
                            HarmanApplication.a().sendBroadcast(new Intent("ACTION_ERROR_9"));
                        }
                    }
                }
            }, 1000L);
            adw.a().c(adxVar);
        }
    }

    public void a(final ady adyVar, final Collection<adz> collection) {
        mq.b().b(new Runnable() { // from class: aof.4
            @Override // java.lang.Runnable
            public void run() {
                aof.this.b(adyVar, (Collection<adz>) collection);
            }
        });
    }

    public void j() {
        MusicPlaylistManager.a().l();
        this.e.b(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(ady adyVar, Collection<adz> collection) {
        int iD = adyVar.d();
        int iA = iD == 0 ? ahk.a() : iD;
        mm.b("Linking rooms %s to %s", collection, Integer.valueOf(iA));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        adx adxVarQ = adyVar.q();
        for (adz adzVar : this.e.b()) {
            if (collection.contains(adzVar) && adzVar.x() != iA) {
                adzVar.b(iA);
                Iterator<adx> it = adzVar.k().iterator();
                while (it.hasNext()) {
                    adw.a().z(it.next());
                }
                if (adxVarQ != null && adxVarQ.S() != 32) {
                    Iterator<adx> it2 = adzVar.k().iterator();
                    while (it2.hasNext()) {
                        afc.a().a(adxVarQ, it2.next());
                    }
                } else if (brs.a(adyVar, this.e.e())) {
                    arrayList.add(adzVar);
                } else {
                    for (adx adxVar : adzVar.k()) {
                        if (adxVar.S() != 32) {
                            adw.a().y(adxVar);
                        } else {
                            arrayList2.add(adzVar);
                        }
                    }
                }
            }
        }
        for (adz adzVar2 : this.e.b()) {
            if (!collection.contains(adzVar2) && adzVar2.x() == iA) {
                adzVar2.b(ahk.a());
                Iterator<adx> it3 = adzVar2.k().iterator();
                while (it3.hasNext()) {
                    adw.a().z(it3.next());
                }
                if (adxVarQ != null && adxVarQ.S() != 32) {
                    Iterator<adx> it4 = adzVar2.k().iterator();
                    while (it4.hasNext()) {
                        afc.a().b(adxVarQ, it4.next());
                    }
                } else {
                    arrayList2.add(adzVar2);
                }
            }
        }
        if (adxVarQ != null && adxVarQ.S() != 32 && adyVar.c() > collection.size()) {
            Iterator<adz> it5 = collection.iterator();
            while (it5.hasNext()) {
                arrayList2.add(it5.next());
            }
        }
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            ((adz) it6.next()).b(true);
        }
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            ((adz) it7.next()).b(false);
        }
        p();
    }

    public adx a(long j) {
        return this.e.a(j);
    }

    public boolean k() {
        return this.e.b().size() > 0;
    }

    public boolean l() {
        ady adyVarD = this.e.d();
        return adyVarD != null && adyVarD.b();
    }

    public void m() {
        mq.a("FC_THREAD").a(new Runnable() { // from class: aof.5
            @Override // java.lang.Runnable
            public void run() {
                ady adyVarD = aof.this.e.d();
                if (adyVarD != null) {
                    adyVarD.p();
                    aof.this.e.b(adyVarD);
                    if (adyVarD != null) {
                        mm.b("Setting group to active %s", adyVarD);
                        adyVarD.b(true);
                    }
                    for (ady adyVar : aof.this.e.c()) {
                        if (brs.b(adyVar, adyVarD)) {
                            adyVar.b(false);
                        }
                    }
                }
            }
        });
    }

    public void a(final aqe.d dVar) {
        if (r()) {
            mo.a.post(new Runnable() { // from class: aof.6
                @Override // java.lang.Runnable
                public void run() {
                    new arw.a(ain.J).b(R.string.Warning_Str).a(R.string.kSameQueue_BreakIn_Str).a(ain.J.getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: aof.6.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            aof.this.b(dVar);
                        }
                    }).b(ain.J.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: aof.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).d(false).a(new DialogInterface.OnCancelListener() { // from class: aof.6.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    }).b().show();
                }
            });
        } else {
            b(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final aqe.d dVar) {
        mq.a("FC_THREAD").a(new Runnable() { // from class: aof.7
            @Override // java.lang.Runnable
            public void run() {
                ady adyVarD = aof.this.e.d();
                if (adyVarD != null) {
                    adyVarD.p();
                    aof.this.e.b(adyVarD);
                    if (adyVarD != null) {
                        mm.b("Setting group to active %s", adyVarD);
                        adyVarD.b(true);
                    }
                    for (ady adyVar : aof.this.e.c()) {
                        if (brs.b(adyVar, adyVarD)) {
                            adyVar.b(false);
                        }
                    }
                    if (dVar != null) {
                        dVar.a();
                    }
                }
            }
        });
    }

    public boolean n() {
        return brs.a(this.e.d(), this.e.e());
    }

    public adz a(int i) {
        w();
        for (adz adzVar : this.e.b()) {
            if (adzVar.s() == i) {
                return adzVar;
            }
        }
        return null;
    }

    public ady b(int i) {
        w();
        for (ady adyVar : this.e.c()) {
            if (adyVar.d() == i) {
                return adyVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.d.sendBroadcast(new Intent("ACTION_DEVICES_MANDATORY_UPGRADE"));
    }

    public ady o() {
        return this.e.e();
    }

    public void p() {
        mq.b().b(new Runnable() { // from class: aof.8
            @Override // java.lang.Runnable
            public void run() {
                if (!aof.this.q().isEmpty()) {
                    aof.this.u();
                }
                mm.b("Broadcasting %s %s", "ACTION_MK_DEVICES_UPDATED", aof.this.e);
                aof.this.d.sendBroadcast(new Intent("ACTION_MK_DEVICES_UPDATED"));
            }
        });
    }

    public List<adx> q() {
        w();
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : this.e.a()) {
            if (b(adxVar) > 0) {
                arrayList.add(adxVar);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int b(adx adxVar) {
        if (this.g.b(adxVar)) {
            mm.b("TEST_DEVICE_FOTA_CHANGE device is upgrading, deviceFc = %s", adxVar);
            return 0;
        }
        if (adxVar.E()) {
            return 1;
        }
        if (adxVar.O() && adxVar.h() != null) {
            if (adxVar.h().a == 1) {
                return 2;
            }
            return adxVar.h().a == 2 ? 3 : -1;
        }
        if (adxVar.N() && adxVar.M() != null) {
            return ahv.a(adxVar.M().c(), adxVar.n()) ? 4 : -1;
        }
        if (adxVar.h() == null) {
            mm.b("TEST_DEVICE_FOTA_CHANGE device getFotaModel is null , deviceFc = %s , isMKII = %s", adxVar, Boolean.valueOf(adxVar.O()));
            return 0;
        }
        if (adxVar.M() != null) {
            return 0;
        }
        mm.b("TEST_DEVICE_FOTA_CHANGE device getUpgradeVersion is null , deviceFc = %s , isMKII = %s", adxVar, Boolean.valueOf(adxVar.O()));
        return 0;
    }

    public aof() {
    }

    public void a(ady adyVar) {
        this.e.a(adyVar);
    }

    public void a(adz adzVar) {
        a(c(adzVar.x()));
    }

    public void b(adz adzVar) {
        a(adzVar);
        this.d.sendBroadcast(new Intent("ACTION_MK_DEVICES_UPDATED"));
    }

    public ady c(int i) {
        return this.e.a(i);
    }

    public boolean r() {
        ady adyVarB = b();
        return adyVarB != null && !brs.a(adyVarB, o()) && adyVarB.k() && adyVarB.m() == 32;
    }

    public void s() {
        mq.b().execute(new Runnable() { // from class: aof.9
            @Override // java.lang.Runnable
            public void run() {
                adw.a().a(aof.this.b);
                aof.this.f = new afa();
                aof.this.f.a(aof.this.g);
                aof.this.f.a(aof.this.b);
                new aoe().a(new afy.a() { // from class: aof.9.1
                    @Override // defpackage.afy
                    public void a() {
                        mm.b("FcLibrary successfully initialized", new Object[0]);
                        aof.this.g.c();
                        aof.this.p();
                    }

                    @Override // defpackage.afy
                    public void a(ErrorInfo errorInfo) {
                        mm.e(errorInfo.toString(), new Object[0]);
                        mr.a(6, "FcLibrary Crash", errorInfo.toString());
                    }
                });
                aof.this.g.a();
                aof.this.g.a(new aez() { // from class: aof.9.2
                    @Override // defpackage.aez, defpackage.aey
                    public void a(List<adx> list) {
                        aof.this.p();
                        aqo.f().a(list.size());
                        aof.this.v();
                    }

                    @Override // defpackage.aez, defpackage.aey
                    public void b(adx adxVar) {
                        aqo.f().a();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (g() && ain.o) {
            mm.b("has mkii the same" + g(), new Object[0]);
            return;
        }
        mm.b("has mkii different" + g(), new Object[0]);
        ain.o = g();
        this.d.sendBroadcast(new Intent("ACTION_MK_SPEAKER_CHANGED"));
    }

    private void w() {
        ady adyVarE = this.e.e();
        List<adz> listF = null;
        if (adyVarE != null) {
            listF = adyVarE.f();
        }
        this.e = new aod(this.g.e(), this.e);
        if (this.e.a(listF)) {
            HarmanApplication.a().sendBroadcast(new Intent("ACTION_ERROR_9"));
        }
        if (this.e.e() != null && listF != null && this.e.e().f().size() != listF.size()) {
            this.e.e().p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final adx adxVar) {
        mq.b().execute(new Runnable() { // from class: aof.1
            @Override // java.lang.Runnable
            public void run() {
                if (aof.this.i != null) {
                    mm.b("TEST_DEVICE_FOTA_CHANGE change devicefc mac = %s", adxVar.d());
                    aof.this.i.a(adxVar);
                }
            }
        });
    }

    public void a(aey aeyVar) {
        this.i = aeyVar;
    }
}
