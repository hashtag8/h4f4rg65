package defpackage;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class adw {
    private static adw c = new adw();
    private Handler b;
    private final int a = HttpStatus.SC_MULTIPLE_CHOICES;
    private ConcurrentHashMap<Long, Runnable> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Runnable> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Runnable> f = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Runnable> g = new ConcurrentHashMap<>();

    public static adw a() {
        return c;
    }

    public void a(Handler handler) {
        this.b = handler;
    }

    public void queryVersion(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.e);
    }

    public void a(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.d);
    }

    public void queryPrivateDataVersion(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.c);
    }

    public void factoryRestore(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.f);
    }

    public void volumeRestore(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.j);
    }

    public void queryWifi(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.s);
    }

    public void b(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.X);
    }

    public void queryUniqueName(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.t);
    }

    public void queryCurrentSource(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.u);
    }

    public void queryPrivateDataAll(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.k);
    }

    public void b() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null && System.currentTimeMillis() - adyVarB.a() > 5000) {
            adyVarB.a(System.currentTimeMillis());
            for (adx adxVar : adyVarB.o()) {
                queryPrivateDataAll(adxVar);
                if (adxVar.O()) {
                    d(adxVar);
                    e(adxVar);
                    if (adxVar.S() == 33) {
                        a().r(adxVar);
                        a().s(adxVar);
                    }
                }
            }
        }
    }

    public void c() {
        for (adx adxVar : aof.a().f()) {
            queryPrivateDataAll(adxVar);
            mm.a((Object) ("fixlink " + adxVar.P()));
        }
    }

    public void c(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.l);
    }

    public void d(adx adxVar) {
        mm.b();
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.w);
    }

    public void a(ady adyVar) {
        if (adyVar != null) {
            Iterator<adx> it = adyVar.o().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    public void b(ady adyVar) {
        if (adyVar != null) {
            Iterator<adx> it = adyVar.o().iterator();
            while (it.hasNext()) {
                e(it.next());
            }
        }
    }

    public void e(adx adxVar) {
        mm.b();
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.Y);
    }

    public void f(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.Z);
    }

    public void g(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ao);
        mm.b("querySourceSetup Command -- Sending %s to %s", aek.ao, adxVar.R());
    }

    public void h(adx adxVar) {
        mm.c();
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.an);
        mm.b("p2pQuerySourceSetup Command -- Sending %s to %s", aek.an, adxVar.R());
    }

    public void a(adx adxVar, aep aepVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aepVar);
        mm.b("configueSourceSetup Command -- Sending %s to %s", aepVar, adxVar.R());
    }

    public void i(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ab);
    }

    public void c(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                i(adxVar);
            }
        }
    }

    public void j(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ac);
    }

    public void a(adx adxVar, int i) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        aei aeiVar = aek.ap;
        byte[] bArrA = aek.a(HttpStatus.SC_MULTIPLE_CHOICES);
        aeiVar.a(new byte[]{(byte) i, 7, 12, bArrA[2], bArrA[3]});
        adxVar.a(aek.ap);
    }

    public void d(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33 && adxVar.L()) {
                j(adxVar);
            }
        }
    }

    public void k(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ad);
    }

    public void e(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                k(adxVar);
            }
        }
    }

    public void l(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ae);
    }

    public void f(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                l(adxVar);
            }
        }
    }

    public void m(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.af);
    }

    public void g(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                m(adxVar);
            }
        }
    }

    public void n(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ah);
    }

    public void h(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                n(adxVar);
            }
        }
    }

    public void o(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ai);
    }

    public void i(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                o(adxVar);
            }
        }
    }

    public void p(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.aj);
    }

    public void j(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                p(adxVar);
            }
        }
    }

    public void q(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.ak);
    }

    public void k(ady adyVar) {
        for (adx adxVar : adyVar.o()) {
            if (adxVar.S() == 33) {
                q(adxVar);
            }
        }
    }

    public void r(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.am);
    }

    public void s(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.al);
    }

    public void a(adx adxVar, byte b) {
        aep aeiVar = new aei(new byte[]{5, 98}, new byte[]{b});
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVar);
        aei aeiVar2 = aek.aa;
        byte[] bArrA = aeiVar2.a();
        bArrA[0] = b;
        aeiVar2.a(bArrA);
        adxVar.a(aeiVar2);
    }

    public void t(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.i);
    }

    public void u(adx adxVar) {
        aei aeiVarB = aek.b(adxVar);
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVarB);
    }

    public void v(adx adxVar) {
        aei aeiVarA = aek.a(adxVar);
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVarA);
    }

    public void b(adx adxVar, int i) {
        aei aeiVar = new aei(new byte[]{7, 19}, new byte[]{(byte) i});
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVar);
    }

    public void b(adx adxVar, byte b) {
        mm.b();
        aei aeiVar = new aei(new byte[]{7, 45}, new byte[]{b});
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVar);
    }

    public void a(adx adxVar, byte b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            b(adxVar, b);
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c(adx adxVar, byte b) {
        mm.b();
        aei aeiVar = new aei(new byte[]{7, 23}, new byte[]{b});
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aeiVar);
    }

    public void w(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.y);
    }

    public void x(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.z);
    }

    public void y(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.J);
    }

    public void z(final adx adxVar) {
        mm.a((Object) "--------swapp setDeviceSetting--------label:");
        mm.b(adxVar.R().label);
        mm.a((Object) "--------swapp setDeviceSetting--------groupName:");
        mm.b(adxVar.R().groupName);
        mm.a((Object) "--------swapp setDeviceSetting-------------------");
        this.e.put(Long.valueOf(adxVar.P()), new Runnable() { // from class: adw.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zB = afc.a().b(adxVar);
                mm.a((Object) ("swapp setDeviceSetting--" + zB));
                if (zB) {
                    adxVar.d(false);
                }
            }
        });
        a(adxVar.P(), this.e);
    }

    public void c(final adx adxVar, final int i) {
        final long jP = adxVar.P();
        this.f.put(Long.valueOf(jP), new Runnable() { // from class: adw.2
            @Override // java.lang.Runnable
            public void run() {
                int iA = afc.a(adxVar.R(), i);
                if (!adxVar.N() && !adxVar.L()) {
                    if (adxVar.u() == 2) {
                        if (adxVar.R().getRole() != 1 && adxVar.R().getRole() != 3 && adxVar.R().getRole() != 5) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                mm.b("volume setting test", "volume to FC %d", Integer.valueOf(iA));
                afc.a().a(jP, iA);
                mm.b("volume setting test", "set master volume for device", Long.valueOf(jP), Integer.valueOf(iA));
            }
        });
        a(jP, this.f);
    }

    public void d(final adx adxVar, final int i) {
        final long jP = adxVar.P();
        this.f.put(Long.valueOf(jP), new Runnable() { // from class: adw.3
            @Override // java.lang.Runnable
            public void run() {
                afc.a().a(jP, afc.a(adxVar.R(), i));
            }
        });
        a(jP, this.f);
    }

    public void a(adz adzVar, int i) {
        Iterator<adx> it = adzVar.k().iterator();
        while (it.hasNext()) {
            c(it.next(), i);
        }
    }

    public synchronized void A(adx adxVar) {
        final long jP = adxVar.P();
        this.d.put(Long.valueOf(jP), new Runnable() { // from class: adw.4
            @Override // java.lang.Runnable
            public void run() {
                afc.a().a(jP);
            }
        });
        a(jP, this.d);
    }

    public synchronized void B(adx adxVar) {
        final long jP = adxVar.P();
        this.d.put(Long.valueOf(jP), new Runnable() { // from class: adw.5
            @Override // java.lang.Runnable
            public void run() {
                afc.a().b(jP);
            }
        });
        a(jP, this.d);
    }

    private void a(final long j, final ConcurrentHashMap<Long, Runnable> concurrentHashMap) {
        mq.a("FC_THREAD").a(new Runnable() { // from class: adw.6
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = (Runnable) concurrentHashMap.remove(Long.valueOf(j));
                if (runnable != null) {
                    runnable.run();
                } else {
                    mm.b("Subsequently changed %s task, no need to run next task for %s", Long.valueOf(j));
                }
            }
        });
    }

    public void a(int i) {
        if (this.b != null) {
            this.b.sendEmptyMessage(i);
        }
    }

    public void C(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.o);
        mm.b();
    }

    public void D(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.q);
        mm.b();
    }

    public void E(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.p);
        mm.b();
    }

    public void a(adx adxVar, String str) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.a(str));
        mm.b();
    }

    public void a(adx adxVar, int[] iArr) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(new aei(new byte[]{7, 30}, new byte[]{aht.a(iArr)}));
        mm.b();
    }

    public void F(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(new aei(new byte[]{7, 30}, new byte[]{0}));
        mm.b();
    }

    public void G(adx adxVar) {
        adxVar.a(this.b, 6003);
        adxVar.a(this.b);
        adxVar.a(aek.r);
        mm.b();
    }

    public void H(final adx adxVar) {
        long jP = adxVar.P();
        this.g.put(Long.valueOf(jP), new Runnable() { // from class: adw.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                adxVar.a(adw.this.b, 6003);
                adxVar.a(adw.this.b);
                adxVar.a(aek.D);
                mm.a((Object) ("setAsGroupHost  " + adxVar.w()));
            }
        });
        b(jP, this.g);
    }

    private void b(final long j, final ConcurrentHashMap<Long, Runnable> concurrentHashMap) {
        mq.a("setAsGroupHost").a(new Runnable() { // from class: adw.8
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = (Runnable) concurrentHashMap.remove(Long.valueOf(j));
                if (runnable != null) {
                    runnable.run();
                } else {
                    mm.b("Subsequently changed %s task, no need to run next task for %s", Long.valueOf(j));
                }
            }
        });
    }
}
