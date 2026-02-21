package defpackage;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class aob {
    private static aob a;
    private b d;
    private ady f;
    private Map<Integer, WeakReference<a>> b = new HashMap();
    private Map<Integer, Integer> c = new HashMap();
    private boolean e = false;

    public interface a {
        void a(adz adzVar);
    }

    public interface b {
        void a(boolean z);
    }

    public void a(ady adyVar) {
        this.f = adyVar;
    }

    public ady a() {
        return this.f;
    }

    public void a(int i) {
        mm.e("VolumeBarMgr Clearing Listener for Group ID:: " + i, new Object[0]);
        this.b.remove(Integer.valueOf(i));
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(int i, a aVar) {
        i();
        mm.e("Volumebarmgr Adding Listener for.... %d ", Integer.valueOf(i));
        this.b.put(Integer.valueOf(i), new WeakReference<>(aVar));
    }

    private void i() {
        Iterator<Map.Entry<Integer, WeakReference<a>>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, WeakReference<a>> next = it.next();
            if (next.getValue().get() == null) {
                mm.e("VolumeBarMgr Clearing Listeners for Key = %d ", next.getKey());
                it.remove();
            }
        }
    }

    public void b() {
        this.c.clear();
        i();
        this.d = null;
    }

    public void a(int i, boolean z) {
        boolean z2 = true;
        for (adz adzVar : k()) {
            int iJ = adx.j(adzVar.t() + i);
            boolean z3 = i == 0 && adzVar.r();
            z2 = z2 && z3;
            if (z) {
                adzVar.a(iJ);
                adzVar.c(z3);
                adw.a().a(adzVar, iJ);
            }
            a(adzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(adz adzVar) {
        mm.e("VolumeBarMgr Size of Volume Listeners:: %d", Integer.valueOf(this.b.size()));
        for (Integer num : this.b.keySet()) {
            a aVar = this.b.get(num).get();
            if (aVar != null) {
                mm.e("VolumeBarMgr Notifying Listener::: %d ", num);
                aVar.a(adzVar);
            }
        }
        if (this.d != null) {
            this.d.a(true);
        }
    }

    public void a(int i, int i2) {
        if (i == -1) {
            b(i2);
            return;
        }
        adz adzVarA = aof.a().a(i);
        adzVarA.a(i2);
        if (i2 <= 0) {
            adzVarA.c(true);
            b(i, true);
            System.out.println("mute");
        } else {
            adzVarA.c(false);
            b(i, false);
            System.out.println("unmute");
        }
        adw.a().a(adzVarA, i2);
        a(adzVarA);
    }

    private void b(int i) {
        Integer num;
        final float fIntValue;
        if (this.c.isEmpty()) {
            j();
        }
        if (!this.c.isEmpty() && (num = this.c.get(-1)) != null) {
            if (i != num.intValue() || i == 0) {
                final boolean z = i < num.intValue();
                if (z) {
                    fIntValue = (float) ((((double) (num.intValue() - i)) * 1.0d) / ((double) num.intValue()));
                } else {
                    fIntValue = (float) ((((double) (i - num.intValue())) * 1.0d) / ((double) (47 - num.intValue())));
                }
                if (fIntValue == 0.0f && i == 0) {
                    for (adz adzVar : k()) {
                        adzVar.a(0);
                        adw.a().a(adzVar, 0);
                        adzVar.c(false);
                        a(adzVar);
                    }
                    return;
                }
                mq.b().b(new Runnable() { // from class: aob.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        for (final adz adzVar2 : aob.this.k()) {
                            float fIntValue2 = ((Integer) aob.this.c.get(Integer.valueOf(adzVar2.s()))).intValue();
                            if (z) {
                                i2 = (int) (((double) (fIntValue2 - (fIntValue * fIntValue2))) + 0.5d);
                            } else {
                                i2 = (int) (((double) (fIntValue2 + ((47.0f - fIntValue2) * fIntValue))) + 0.5d);
                            }
                            if (adzVar2.t() != i2) {
                                adzVar2.a(i2);
                                adw.a().a(adzVar2, i2);
                                adzVar2.c(i2 <= 0);
                                mo.a.a(new Runnable() { // from class: aob.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aob.this.a(adzVar2);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
    }

    private void b(boolean z) {
        if (this.d != null) {
            this.d.a(z);
        }
    }

    public void c() {
        j();
        b(false);
    }

    public void b(int i, boolean z) {
        if (i == -1) {
            a(z);
        } else {
            a(i, z, true);
        }
        b(true);
    }

    public void a(final int i, final boolean z, final boolean z2) {
        mq.a("FC_THREAD").a(new Runnable() { // from class: aob.2
            @Override // java.lang.Runnable
            public void run() {
                final adz adzVarA = aof.a().a(i);
                if (adzVarA != null) {
                    if ((adzVarA.d() == 2 || adzVarA.d() == 4) && z2 && adzVarA != null) {
                        adx adxVarH = adzVarA.h();
                        mm.b("volume setting test setMute for master =%d isMute=%b", Long.valueOf(adxVarH.P()), Boolean.valueOf(z));
                        adxVarH.h(z ? (byte) 1 : (byte) 0);
                        adw.a().u(adxVarH);
                    }
                    if (z2 && adzVarA != null) {
                        adzVarA.c(z);
                        for (adx adxVar : adzVarA.k()) {
                            mm.b("volume setting test setMute for slave =%d isMute=%b", Long.valueOf(adxVar.P()), Boolean.valueOf(z));
                            adw.a().u(adxVar);
                        }
                    }
                }
                mo.a.a(new Runnable() { // from class: aob.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aob.this.a(adzVarA);
                    }
                });
            }
        });
    }

    public void a(boolean z) {
        this.e = true;
        Iterator<adz> it = k().iterator();
        while (it.hasNext()) {
            a(it.next().s(), z, true);
        }
        this.e = false;
    }

    public void d() {
        a(ain.I, true);
        b(true);
    }

    public void e() {
        a(ain.I * (-1), true);
        b(true);
    }

    private void j() {
        this.c.clear();
        int iT = 0;
        List<adz> listK = k();
        Iterator<adz> it = listK.iterator();
        while (true) {
            int i = iT;
            if (it.hasNext()) {
                adz next = it.next();
                this.c.put(Integer.valueOf(next.s()), Integer.valueOf(next.t()));
                iT = next.t() + i;
            } else {
                this.c.put(-1, Integer.valueOf(i / listK.size()));
                return;
            }
        }
    }

    public void f() {
        Iterator<adz> it = k().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void g() {
        if (!this.e) {
            for (adz adzVar : k()) {
                if (adzVar != null) {
                    a(adzVar.s(), adzVar.r(), false);
                }
            }
        }
    }

    public static aob h() {
        if (a == null) {
            a = new aob();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<adz> k() {
        ady adyVarB = this.f == null ? aof.a().b() : this.f;
        if (adyVarB != null) {
            return adyVarB.f();
        }
        return Collections.emptyList();
    }
}
