package defpackage;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class atz {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private static List<Long> m = new ArrayList();
    private final Queue<String> b;
    private final String d;
    private final String e;
    private final aua g;
    private String h;
    private int j = -1;
    private int k = 0;
    private int l = 0;
    private final Context f = HarmanApplication.a();
    private final WifiManager c = (WifiManager) this.f.getSystemService("wifi");
    private aey i = new aez() { // from class: atz.1
        @Override // defpackage.aez, defpackage.aey
        public void a(final List<adx> list) {
            mq.a("FC_THREAD").a(new Runnable() { // from class: atz.1.1
                @Override // java.lang.Runnable
                public void run() {
                    atz.this.a((List<adx>) list);
                }
            });
        }
    };

    static /* synthetic */ int b(atz atzVar) {
        int i = atzVar.k;
        atzVar.k = i + 1;
        return i;
    }

    static /* synthetic */ int j(atz atzVar) {
        int i = atzVar.l;
        atzVar.l = i + 1;
        return i;
    }

    public atz(String str, String str2, Collection<String> collection, aua auaVar) {
        this.b = new LinkedList(collection);
        this.d = str;
        this.e = str2;
        this.g = auaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<adx> list) {
        String strB = ahx.a().b();
        if (ahx.a(strB, this.h)) {
            mm.b("Matching %s to %s, using %s", strB, this.h, list);
            if (list.size() > 0) {
                mm.b("5.1 system test", "lastSetupUUIDList = " + m);
                ArrayList arrayList = new ArrayList(1);
                for (adx adxVar : list) {
                    String strSubstring = strB.toLowerCase().substring(strB.length() - 3, strB.length());
                    String strE = adxVar.e();
                    boolean zEquals = strSubstring.equals(strE);
                    mm.b("5.1 system test", "currentlast3Ssid = " + strSubstring, "last3Mac = " + strE, "is the same =" + zEquals);
                    if (zEquals) {
                        a(adxVar);
                        arrayList.add(adxVar);
                        m.add(Long.valueOf(adxVar.P()));
                    }
                    if (arrayList.size() > 0) {
                        if (a(strB, arrayList)) {
                            f();
                            return true;
                        }
                        if (arrayList.size() > 1) {
                            new ml().a("More than one device setup on " + strB + ", this is not a device wifi?");
                        }
                    }
                }
            } else {
                mm.b("Not using devices from different SSID %s target %s, %s", strB, this.h, list);
            }
        }
        return false;
    }

    public void a() {
        if (!this.c.isWifiEnabled() && !ahh.a()) {
            this.c.setWifiEnabled(true);
        }
        mm.b("Setting up devices %s to point to %s and then reconnecting to %s, listener %s", this.b, this.d, this.d, this.i);
        aof.a().c().a(this.i);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        auc aucVar = new auc(this.d, this.e, new agh<Integer>() { // from class: atz.3
            @Override // defpackage.agh
            public void a(Object obj, Integer num) {
                mm.b("5.1 system test Reconnected to original wifi %s", obj);
                atz.this.e();
            }

            @Override // defpackage.agh
            public void a(Object obj, ErrorInfo errorInfo) {
                atz.b(atz.this);
                if (atz.this.k > 2) {
                    mm.b("Could not reconnect to original wifi %s, error %s", obj, errorInfo);
                    atz.this.d();
                    return;
                }
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atz.this.b();
                mm.b("Reconnecting original wifi %s, try times %d", obj, Integer.valueOf(atz.this.k));
            }
        });
        mm.b("Connecting home Wifi %s, pwd %s", this.d, this.e);
        aucVar.a();
    }

    private void c() {
        m.clear();
        mm.b("onComplete, remove listener %s", this.i);
        aof.a().c().b(this.i);
        this.k = 0;
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        mo.a.a(new Runnable() { // from class: atz.4
            @Override // java.lang.Runnable
            public void run() {
                atz.this.g.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        mo.a.a(new Runnable() { // from class: atz.5
            @Override // java.lang.Runnable
            public void run() {
                atz.this.g.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        mq.a("FC_THREAD").a(new Runnable() { // from class: atz.6
            @Override // java.lang.Runnable
            public void run() {
                atz.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.l = 0;
        if (this.j != -1) {
            a(this.j);
            this.j = -1;
        }
        this.h = this.b.poll();
        if (this.h == null) {
            c();
            return;
        }
        mo.a.a(new Runnable() { // from class: atz.7
            @Override // java.lang.Runnable
            public void run() {
                atz.this.g.a(atz.this.h);
            }
        });
        mm.b("Connecting to device's wifi %s", this.h);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        auc aucVar = new auc(this.h, null, new agh<Integer>() { // from class: atz.8
            @Override // defpackage.agh
            public void a(Object obj, Integer num) {
                mm.b("Connected to device %s, phone's current ip = %s, waiting for device search to find device", obj, atz.this.i());
                atz.this.j = num.intValue();
                atz.this.a(atz.this.h);
            }

            @Override // defpackage.agh
            public void a(Object obj, ErrorInfo errorInfo) {
                atz.j(atz.this);
                mm.b("Could not connect to device %s, error %s", obj, errorInfo);
                if (!errorInfo.b().contains("timeout")) {
                    if (atz.this.a(atz.this.h, errorInfo)) {
                        atz.this.f();
                    }
                } else if (3 > atz.this.l) {
                    atz.this.h();
                    mm.b("Reconnecting original wifi %s, try times %d", obj, Integer.valueOf(atz.this.l));
                }
            }
        });
        mm.b("Connecting to Wifi", this.h);
        aucVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        WifiManager wifiManager = (WifiManager) this.f.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        return ahd.a(connectionInfo.getIpAddress());
    }

    private void a(int i) {
        ((WifiManager) this.f.getSystemService("wifi")).removeNetwork(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        mm.b("Schedule timeout " + str, new Object[0]);
        mq.a("FC_THREAD").postDelayed(new Runnable() { // from class: atz.9
            @Override // java.lang.Runnable
            public void run() {
                if (atz.this.a(str, new ErrorInfo.a().a(R.string.speakerSetup_couldNotConnectToWifi, str).a("Timeout polling for device").a())) {
                    atz.this.f();
                }
            }
        }, TimeUnit.MILLISECONDS.convert(60L, a));
    }

    private void a(adx adxVar) {
        adxVar.R().ssid = this.d;
        adxVar.R().key = this.e;
        adxVar.a(this.d);
        adxVar.b(this.e);
        mm.b("Sending device settings deviceuuid \"%s\", ssid \"%s\", password %s", Long.valueOf(adxVar.P()), adxVar.R().ssid, bru.a('*', adxVar.R().key.length()));
        adw.a().z(adxVar);
    }

    private boolean a(final String str, final List<adx> list) {
        if (!ahx.a(this.h, str)) {
            mm.b("Already notified of error SSID %s, target %s", str, this.h);
            return false;
        }
        try {
            mo.a.a(new Runnable() { // from class: atz.10
                @Override // java.lang.Runnable
                public void run() {
                    atz.this.g.a(str, list);
                }
            });
            this.h = null;
        } catch (Throwable th) {
            a(str, new ErrorInfo.a().a(R.id.errorCode_onSuccessFailure).a((Serializable) str).a(th).a());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final String str, final ErrorInfo errorInfo) {
        mm.c();
        if (!ahx.a(this.h, str)) {
            return false;
        }
        mo.a.a(new Runnable() { // from class: atz.2
            @Override // java.lang.Runnable
            public void run() {
                atz.this.g.a(str, errorInfo);
            }
        });
        this.h = null;
        return true;
    }
}
