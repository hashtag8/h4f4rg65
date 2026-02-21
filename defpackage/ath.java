package defpackage;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import com.harman.hkconnect.upgrade.FotaUpdateMasterActivity;
import defpackage.apx;
import defpackage.arw;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ath extends atm {
    private ask ae;
    private Activity af;
    private TextView ag;
    private arw aj;
    private arw ak;
    private arw al;
    private List<apx.b> b;
    private apx c;
    private aez d;
    private RecyclerView f;
    private ImageView g;
    private LinearLayout h;
    private HashMap<Long, adx> e = new HashMap<>();
    private boolean i = true;
    private Runnable ah = new Runnable() { // from class: ath.1
        @Override // java.lang.Runnable
        public void run() {
            ath.this.ag.setVisibility(4);
            mm.b("TEST_DEVICE_FOTA_CHANGE timeout Eexecu time= %s", Long.valueOf(System.currentTimeMillis()));
            ath.this.ao();
        }
    };
    private final a ai = new a(this);
    int a = 10000;

    enum b {
        SUCCESS,
        FAILE,
        COMPAREAGAIN
    }

    @Override // defpackage.atm, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.af = activity;
    }

    static class a extends Handler {
        private final WeakReference<ath> a;

        public a(ath athVar) {
            this.a = new WeakReference<>(athVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            ath athVar = this.a.get();
            if (athVar != null) {
                mm.b("Upgrade message %s", message);
                if (athVar.v()) {
                    adx adxVar = (adx) message.obj;
                    brw.a(adxVar, "No device sent for message %s", message);
                    apx.b bVarA = athVar.a(adxVar);
                    if (bVarA != null) {
                        switch (message.what) {
                            case 107:
                                mm.a((Object) ("test fota device.isMKII() = " + adxVar.O() + " deviceInfo.getState() = " + bVarA.c()));
                                if (adxVar.O()) {
                                    i = adxVar.h().g;
                                    if (bVarA.c() != apx.c.IN_PROGRESS) {
                                        bVarA.a(apx.c.IN_PROGRESS);
                                    }
                                } else {
                                    i = message.arg1;
                                }
                                mm.a((Object) ("2device.isMKII() = " + adxVar.O() + " deviceInfo.getState() = " + bVarA.c() + " progressValue = " + i));
                                athVar.a(bVarA, ((double) i) / 100.0d);
                                break;
                            case 113:
                                athVar.a(bVarA, athVar.a(message, "UP_GRADE_SCOKET_ERROR"));
                                break;
                            case 114:
                                athVar.a(bVarA, athVar.a(message, "UP_GRADE_CHECKSUM_FILE_ERROR"));
                                break;
                            case 115:
                                athVar.a(bVarA, athVar.a(message, "DOWNLOADING_NETWORK"));
                                break;
                            case 116:
                                mm.b("TEST_DEVICE_FOTA_CHANGE  executing FOTA_UPDATE_UNPLUG_AC_POWER_NOTICE", new Object[0]);
                                athVar.b(bVarA);
                                break;
                            case 119:
                                athVar.a(bVarA, athVar.a(message, "SPEAKER_WAS_REMOVE"));
                                break;
                            case 125:
                                athVar.a(bVarA, athVar.a(message, "UPGRAD_TIME_OUT"));
                                break;
                            case 134:
                                athVar.a(bVarA, athVar.a(message, "RECEIVE_SOCKET_ERROR"));
                                break;
                            case 170:
                                athVar.a(bVarA);
                                break;
                            case 171:
                                athVar.a(bVarA, athVar.a(message, "MSG_UI_UPGRADE_FAILED"));
                                break;
                            case 2001:
                                adxVar.a(this);
                                if (!afc.c(adxVar.R())) {
                                    adxVar.a(aek.h);
                                }
                                break;
                            case 3001:
                                athVar.a(bVarA, athVar.a(message, "MSG_ERROR"));
                                break;
                        }
                    }
                }
            }
        }
    }

    public ErrorInfo a(Message message, String str) {
        Bundle data = message.getData();
        Exception exc = null;
        if (data != null) {
            exc = (Exception) data.getSerializable("exception");
        }
        return new ErrorInfo.a().a((Throwable) exc).a(data).a(str).a(message.what).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public apx.b a(adx adxVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                new ml().a("No device " + adxVar + " in " + this.b);
                return null;
            }
            if (adxVar.P() != this.b.get(i2).a().P()) {
                i = i2 + 1;
            } else {
                return this.b.get(i2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    private void a(List<adx> list) {
        this.b = new ArrayList();
        for (adx adxVar : list) {
            if (adxVar.M() == null) {
                mm.b("No upgrade version for %s", adxVar);
            } else {
                this.b.add(new apx.b(new adx(adxVar.R(), adxVar.h())));
            }
        }
        this.c.a(this.b);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_updated_devices, (ViewGroup) null);
        this.f = (RecyclerView) viewInflate.findViewById(R.id._fragment_updateDevices_deviceList);
        this.ag = (TypefaceTextView) viewInflate.findViewById(R.id.fragment_device_update_msg);
        this.g = (ImageView) viewInflate.findViewById(R.id.slash_circle);
        this.h = (LinearLayout) viewInflate.findViewById(R.id.updating_warning_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(1);
        this.f.setLayoutManager(linearLayoutManager);
        this.c = new apx(p(), new apx.a() { // from class: ath.10
            @Override // apx.a
            public void a(apx.b bVar) {
                if (!ath.this.a(apx.c.IN_PROGRESS)) {
                    ath.this.c(bVar);
                }
            }
        });
        List<adx> list = (List) l().getSerializable(FotaUpdateMasterActivity.n);
        brw.a(list, "devices", new Object[0]);
        a(list);
        this.f.setAdapter(this.c);
        al();
        aq();
        return viewInflate;
    }

    private void al() {
        aof.a().c().b(this.d);
        this.d = new aez() { // from class: ath.11
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                mo.a.post(new Runnable() { // from class: ath.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mm.b("TEST_DEVICE_FOTA_CHANGE ", " Executing onDevicesChanged");
                        mo.a.removeCallbacks(ath.this.ah);
                        ath.this.ax();
                    }
                });
            }

            @Override // defpackage.aez, defpackage.aey
            public void b(adx adxVar) {
                apx.b bVarA;
                if (adxVar != null && (bVarA = ath.this.a(adxVar)) != null) {
                    mm.b("TEST_DEVICE_FOTA_CHANGE onDeviceRemove  ---mac = %s,state = %s", adxVar.d(), bVarA.c().name());
                    if (bVarA.c() == apx.c.IDLE) {
                        ath.this.ai.sendMessage(ath.this.ai.obtainMessage(119, adxVar));
                    }
                    if (bVarA.c() == apx.c.IN_PROGRESS) {
                        mm.b("TEST_DEVICE_FOTA_CHANGE onDeviceRemove  ---mac = %s,state = %s", adxVar.d(), bVarA.c().name());
                        if (!bVarA.a().O()) {
                            ath.this.ai.sendMessage(ath.this.ai.obtainMessage(119, adxVar));
                        } else if (bVarA.b() == 100) {
                            ath.this.ai.sendMessageDelayed(ath.this.ai.obtainMessage(170, adxVar), 10000L);
                        } else {
                            ath.this.ai.sendMessage(ath.this.ai.obtainMessage(116, adxVar));
                        }
                    }
                }
            }
        };
        aof.a().c().a(this.d);
        aof.a().a(new aez() { // from class: ath.12
            @Override // defpackage.aez, defpackage.aey
            public void a(adx adxVar) {
                mm.b("TEST_DEVICE_FOTA_CHANGE change devicefc mac = %s , progress = %s", adxVar.d(), Integer.valueOf(adxVar.h().g));
                Message messageObtainMessage = ath.this.ai.obtainMessage();
                messageObtainMessage.obj = adxVar;
                if (adxVar.h().g == 100) {
                    apx.b bVarA = ath.this.a(adxVar);
                    if (bVarA != null) {
                        bVarA.a(100);
                    }
                    messageObtainMessage.what = 170;
                } else if (adxVar.h().g == -1) {
                    adxVar.a((aea) null);
                    messageObtainMessage.what = 115;
                } else {
                    messageObtainMessage.what = 107;
                }
                ath.this.ai.sendMessage(messageObtainMessage);
                ath.this.i = false;
            }
        });
    }

    private void am() {
        if (this.ak == null) {
            this.ak = new arw.a(p()).b(a(R.string.kWifiManager_NoWifiConnection_Str)).a(a(R.string.kWifiManager_PleaseConnectPhone_Str)).a(a(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ath.13
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).d(false).b();
        }
        if (!this.ak.isShowing()) {
            new asc(this.ak).a(p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.ag.setVisibility(4);
        if (this.aj == null) {
            this.aj = new arw.a(p()).b(a(R.string.FotaThereWasProblemHappend_Str)).a(a(R.string.FotaUnplugACPower_Str)).a(a(R.string.FotaContinueBtn), new DialogInterface.OnClickListener() { // from class: ath.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    mm.b();
                    dialogInterface.dismiss();
                    ath.this.ao();
                }
            }).d(false).b();
        }
        if (!this.aj.isShowing()) {
            new asc(this.aj).a(p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        if (this.al == null) {
            this.al = new arw.a(p()).b(a(R.string.FotaTimeout_NoteUserRestartSystem)).a(a(R.string.FotaTimeout_noteUserContent, 5)).a(a(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ath.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    mm.b();
                    ath.this.ap();
                    dialogInterface.dismiss();
                    agu.b(ath.this.p());
                }
            }).d(false).b();
        }
        if (!this.al.isShowing()) {
            new asc(this.al).a(p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        List<apx.b> listA = a((asz) null, apx.c.WAITING);
        if (listA != null && listA.size() != 0) {
            for (apx.b bVar : listA) {
                adx adxVarA = bVar.a();
                mm.b("TEST_DEVICE_FOTA_CHANGE storeTheTimeoutSpeaker device = %s --->", adxVarA);
                if (adxVarA.O()) {
                    aho.a(String.valueOf(bVar.a().P()), ahv.a(bVar.a().h().b));
                } else {
                    aho.a(String.valueOf(bVar.a().P()), ahv.a(bVar.a().n()));
                }
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        Iterator<apx.b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a().C();
        }
        mo.a.removeCallbacks(this.ah);
        aof.a().c().b(this.d);
        mm.b("TEST_DEVICE_FOTA_CHANGE onDestroy --->", new Object[0]);
    }

    private void aq() {
        HashSet hashSet = new HashSet();
        for (apx.b bVar : this.b) {
            if (bVar.a().M() != null) {
                hashSet.add(bVar.a().M());
            }
        }
        if (az()) {
            a(hashSet);
        } else {
            b(aea.h);
        }
    }

    private b a(List<adx> list, apx.c cVar) {
        List<apx.b> listA = a((asz) null, cVar);
        if (listA.size() == 0) {
            return null;
        }
        for (adx adxVar : list) {
            for (apx.b bVar : listA) {
                mm.b("TEST_DEVICE_FOTA_CHANGE new speaker UUID = %s,version = %s , old speaker UUID = %s , targetversion = %s", Long.valueOf(adxVar.P()), ahv.a(adxVar.n()), bVar.a(), bVar.a().O() ? ahv.a(bVar.a().h().b) : bVar.a().M().c());
                if (adxVar.P() == bVar.a().P()) {
                    if (adxVar.N()) {
                        return b.SUCCESS;
                    }
                    if (ahv.a(bVar.a().h().b, adxVar.n())) {
                        aea aeaVar = new aea();
                        aeaVar.a = (byte) 0;
                        adxVar.a(aeaVar);
                        return b.SUCCESS;
                    }
                    if (adxVar.o() != null && ahv.a(bVar.a().h().b, adxVar.o())) {
                        aea aeaVar2 = new aea();
                        aeaVar2.a = (byte) 0;
                        adxVar.a(aeaVar2);
                        return b.SUCCESS;
                    }
                    adw.a().queryVersion(adxVar);
                    return b.COMPAREAGAIN;
                }
            }
        }
        return b.FAILE;
    }

    private void a(Set<asz> set) {
        for (final asz aszVar : set) {
            ahb ahbVar = new ahb(new aha() { // from class: ath.2
                @Override // defpackage.aha
                public void a() {
                    mo.a.a(new Runnable() { // from class: ath.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ath.this.c(aszVar);
                        }
                    });
                }

                @Override // defpackage.aha
                public void a(final ahz ahzVar) {
                    mo.a.a(new Runnable() { // from class: ath.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            List listA = ath.this.a(aszVar, (apx.c) null);
                            Iterator it = listA.iterator();
                            while (it.hasNext()) {
                                ((apx.b) it.next()).a(apx.c.FAILURE);
                            }
                            Iterator it2 = listA.iterator();
                            while (it2.hasNext()) {
                                ath.this.a((apx.b) it2.next(), new ErrorInfo.a().a("Download failed " + ahzVar).a());
                            }
                            if (ath.this.a(apx.c.FAILURE)) {
                                ath.this.an();
                            }
                        }
                    });
                }

                @Override // defpackage.aha
                public void a(int i, int i2) {
                    final int iCeil = (int) Math.ceil((i2 / i) * 100.0f);
                    mo.a.a(new Runnable() { // from class: ath.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            mm.b("Download progress %s", Integer.valueOf(iCeil));
                        }
                    });
                }

                @Override // defpackage.aha
                public void b() {
                    mo.a.a(new Runnable() { // from class: ath.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                }
            });
            if (aszVar != aea.h) {
                ahbVar.a(aszVar, p());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(asz aszVar) {
        if (a(aszVar)) {
            b(aszVar);
            return;
        }
        List<apx.b> listA = a(aszVar, (apx.c) null);
        Iterator<apx.b> it = listA.iterator();
        while (it.hasNext()) {
            it.next().a(apx.c.FAILURE);
        }
        Iterator<apx.b> it2 = listA.iterator();
        while (it2.hasNext()) {
            a(it2.next(), new ErrorInfo.a().a("Download failed, bin file mismatch").a((Serializable) aszVar.d()).a());
        }
        if (a(apx.c.FAILURE)) {
            an();
        }
    }

    public boolean a(asz aszVar) {
        File fileStreamPath;
        if (p() == null || (fileStreamPath = p().getFileStreamPath(aszVar.a())) == null || !aszVar.d().toLowerCase().equals(ahg.b(fileStreamPath).toLowerCase())) {
            return false;
        }
        aho.a(ain.C, aszVar.a());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(apx.b bVar, double d) {
        bVar.a((int) Math.ceil(100.0d * d));
        mm.a((Object) ("test fota deviceInfos = " + this.b + " deviceInfos.size() = " + this.b.size() + " deviceInfo = " + bVar + " deviceInfos.indexOf(deviceInfo) = " + this.b.indexOf(bVar)));
        this.c.c(this.b.indexOf(bVar));
        ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(apx.b bVar) {
        bVar.a(apx.c.WAITING);
        bVar.a().C();
        this.c.c();
        ar();
        aof.a().c().a(bVar.a());
        b(bVar.a().M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(apx.b bVar) {
        bVar.a(apx.c.WAITING);
        bVar.a().C();
        this.c.c();
        mo.a.removeCallbacks(this.ah);
        long millis = TimeUnit.MINUTES.toMillis(bVar.a().ai());
        mm.b("TEST_DEVICE_FOTA_CHANGE Restart timeout  = " + millis, new Object[0]);
        mo.a.postDelayed(this.ah, millis);
        ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(apx.b bVar, ErrorInfo errorInfo) {
        mm.c();
        mm.b("TEST_DEVICE_FOTA_CHANGE Update failed for %s %s", bVar, errorInfo);
        bVar.a(errorInfo);
        bVar.a(apx.c.FAILURE);
        bVar.a().C();
        this.c.c();
        b(bVar.a().M());
        if (a(apx.c.FAILURE)) {
            if (errorInfo.a() == 115) {
                am();
            } else {
                an();
            }
        }
        ar();
    }

    private void ar() {
        this.h.setVisibility(aB() ? 0 : 4);
    }

    private boolean as() {
        for (apx.b bVar : this.b) {
            if (bVar.c() == apx.c.IN_PROGRESS || bVar.c() == apx.c.IDLE) {
                return false;
            }
        }
        return true;
    }

    private boolean at() {
        Iterator<apx.b> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().c() != apx.c.SUCCESS) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(apx.c cVar) {
        Iterator<apx.b> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().c() == cVar) {
                return true;
            }
        }
        return false;
    }

    private void d(asz aszVar) {
        mm.b("TEST_DEVICE_FOTA_CHANGE time out remove time= %s", Long.valueOf(System.currentTimeMillis()));
        mo.a.removeCallbacks(this.ah);
        List<apx.b> listA = a((asz) null, apx.c.WAITING);
        if (listA.size() != 0) {
            mm.b("TEST_DEVICE_FOTA_CHANGE timeout start time= %s , expiredtime = %s ", Long.valueOf(System.currentTimeMillis()), Long.valueOf(listA.get(listA.size() - 1).a().ai()));
            long millis = TimeUnit.MINUTES.toMillis(a((asz) null, apx.c.WAITING).get(0).a().ai());
            mm.b("TEST_DEVICE_FOTA_CHANGE installTimeinMillis = " + millis, new Object[0]);
            mo.a.postDelayed(this.ah, millis);
        }
        mo.a.post(new Runnable() { // from class: ath.3
            @Override // java.lang.Runnable
            public void run() {
                ath.this.ax();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        ay();
        ar();
        if (as() && at()) {
            mo.a.removeCallbacks(this.ah);
            mo.a.postDelayed(new Runnable() { // from class: ath.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ath.this.p() != null) {
                        ath.this.p().finish();
                    }
                }
            }, 2000L);
        }
    }

    private void ay() {
        adx adxVarA;
        List<adx> listF = aof.a().f();
        mm.b("TEST_DEVICE_FOTA_CHANGE updateOnlineSpeakerStatus ---> 4 ---mac = %s", new Object[0]);
        for (apx.b bVar : this.b) {
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(bVar.c() == apx.c.WAITING && !aof.a().c().b(bVar.a()) && listF.contains(bVar.a()));
            objArr[1] = bVar.c();
            objArr[2] = Boolean.valueOf(!aof.a().c().b(bVar.a()));
            objArr[3] = Boolean.valueOf(listF.contains(bVar.a()));
            objArr[4] = bVar.a();
            mm.b("Setting success to %s (%s/%s/%s) for %s", objArr);
            if (bVar.c() == apx.c.WAITING && !aof.a().c().b(bVar.a()) && listF.contains(bVar.a())) {
                mm.b("TEST_DEVICE_FOTA_CHANGE watting to failure or success  ---mac = %s", bVar.a().d());
                b bVarA = a(listF, apx.c.WAITING);
                mm.b("TEST_DEVICE_FOTA_CHANGE updateOnlineSpeakerStatus  state =%s %s", bVarA);
                if (bVarA != null) {
                    if (bVarA == b.SUCCESS || !bVar.a().O()) {
                        bVar.a(apx.c.SUCCESS);
                    } else {
                        mm.b("TEST_DEVICE_FOTA_CHANGE ---------- state=%s Percent=%d", bVarA, Integer.valueOf(bVar.b()));
                        if (bVar.b() == 100 && bVarA == b.COMPAREAGAIN) {
                            bVar.a(new ErrorInfo.a().a("").a());
                            bVar.a(apx.c.FAILURE);
                        }
                    }
                    adx adxVar = this.e.get(Long.valueOf(bVar.a().P()));
                    if (adxVar != null && (adxVarA = aof.a().a(adxVar.P())) != null) {
                        adxVarA.a(adxVar);
                    }
                    mo.a.a(new Runnable() { // from class: ath.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ath.this.c.c();
                        }
                    });
                } else {
                    return;
                }
            } else if (bVar.c() == apx.c.FAILURE && !aof.a().c().b(bVar.a()) && listF.contains(bVar.a())) {
                mm.b("TEST_DEVICE_FOTA_CHANGE failure to retry or success  ---mac = %s", bVar.a().d());
                if (bVar.a().O() && bVar.a().h() != null && a(listF, apx.c.FAILURE) == b.SUCCESS) {
                    bVar.a(apx.c.SUCCESS);
                } else if (aof.a().b(listF.get(listF.indexOf(bVar.a()))) > 0) {
                    mo.a.removeCallbacks(this.ah);
                    bVar.a(apx.c.RETRY);
                }
                mo.a.a(new Runnable() { // from class: ath.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ath.this.c.c();
                    }
                });
            }
        }
    }

    public void b(asz aszVar) {
        List<apx.b> listA = a(aszVar, apx.c.IDLE);
        if (listA.isEmpty()) {
            d(aszVar);
            mq.c().schedule(new Runnable() { // from class: ath.7
                @Override // java.lang.Runnable
                public void run() {
                    ain.Y = false;
                }
            }, 30L, TimeUnit.SECONDS);
        } else {
            c(listA.get(0));
        }
        ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(apx.b bVar) {
        if (MusicPlaylistManager.a().v()) {
            mm.c("startUpdateDeviceOnebyOne, stop music", new Object[0]);
            aof.a().j();
        }
        bVar.a(apx.c.IN_PROGRESS);
        adx adxVarA = bVar.a();
        mm.b("Connecting to %s", bVar);
        adx adxVarA2 = aof.a().a(adxVarA.P());
        if (adxVarA2 != null) {
            if (adxVarA2.E()) {
                c(adxVarA2);
                adxVarA.a(this.ai, 6001);
            } else if (adxVarA2.N()) {
                adxVarA.a(this.ai, 6001);
            } else {
                b(adxVarA2);
            }
        }
    }

    private void b(final adx adxVar) {
        ain.Y = true;
        mq.a("TrigerFirmwareUpdate").a(new Runnable() { // from class: ath.8
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                ath.this.i = true;
                while (ath.this.i) {
                    try {
                        adw.a().E(adxVar);
                        Thread.sleep(1000L);
                        i++;
                        if (i == 3) {
                            ath.this.i = false;
                        }
                        mm.b("TEST_DEVICE_FOTA_CHANGE multiTrigerFirmwareUpdate count =%s, start = %s, device = ", Integer.valueOf(i), Boolean.valueOf(ath.this.i), adxVar);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void c(adx adxVar) {
        int i = 0;
        boolean z = true;
        while (z && i < 30) {
            if (adxVar.ab()) {
                if (adxVar.l() != -1) {
                    mm.b("Test store gen2 UUID = %s ,MASTER = %s , IconIndex= %s , RoomId = %s ,RoomName = %s , colorIndex= %s ,role=%s", Long.valueOf(adxVar.P()), Byte.valueOf(adxVar.k()), Byte.valueOf(adxVar.j()), Integer.valueOf(((int) adxVar.l()) % 65536), adxVar.m(), Integer.valueOf(ahk.a(ain.y.length)), Integer.valueOf(adxVar.R().getRole()));
                    this.e.put(Long.valueOf(adxVar.P()), adxVar.aa());
                }
                z = false;
            } else {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<apx.b> a(asz aszVar, apx.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (apx.b bVar : this.b) {
            if (cVar == null || bVar.c() == cVar) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private boolean az() {
        Iterator<apx.b> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().a().N()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        e().b(a(R.string.FotaUpdateSpeaker_Str));
        aA();
        this.ae = new ask(this.af, new asj() { // from class: ath.9
            @Override // defpackage.asj
            public void a(String str) {
                mm.b("TEST_DEVICE_FOTA_CHANGE Wifi changed to %s", str);
                List<apx.b> listA = ath.this.a((asz) null, apx.c.IN_PROGRESS);
                listA.addAll(ath.this.a((asz) null, apx.c.IDLE));
                if (listA.size() != 0) {
                    for (apx.b bVar : listA) {
                        mm.b("TEST_DEVICE_FOTA_onWifiChanged  deviceInfo %s", Long.valueOf(bVar.a().P()));
                        ath.this.a(bVar);
                    }
                }
            }
        });
        this.ae.a();
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
        this.ae.b();
    }

    private void aA() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.2f, 1.0f);
        objectAnimatorOfFloat.setDuration(700L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.start();
    }

    private boolean aB() {
        for (apx.b bVar : this.b) {
            if (bVar.c() == apx.c.IDLE || bVar.c() == apx.c.WAITING || bVar.c() == apx.c.IN_PROGRESS) {
                return true;
            }
        }
        return false;
    }
}
