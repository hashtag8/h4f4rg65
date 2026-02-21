package defpackage;

import com.bfrx.MediaController;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class adz extends aef implements Serializable {
    private CopyOnWriteArrayList<adx> c = new CopyOnWriteArrayList<>();
    public int a = 0;
    public int b = 0;
    private boolean d = false;

    public boolean a() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b() {
        if (!this.d) {
            this.d = true;
            mq.a();
            mq.c().schedule(new Runnable() { // from class: adz.1
                @Override // java.lang.Runnable
                public void run() {
                    adz.this.d = false;
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    public long c() {
        long jP = 0;
        Iterator<adx> it = this.c.iterator();
        while (true) {
            long j = jP;
            if (it.hasNext()) {
                jP = it.next().P() + j;
            } else {
                return j;
            }
        }
    }

    public byte d() {
        if (this.c.iterator().hasNext()) {
            if (h().u() == 0) {
                if (h().q() == 7 || h().q() == 12) {
                    return (byte) 5;
                }
                return h().q() != 8 ? (byte) 0 : (byte) 3;
            }
            if (h().u() == 2) {
                if (k().size() <= 3 && h().q() != 7) {
                    return h().q() == 8 ? (byte) 4 : (byte) 4;
                }
                return (byte) 2;
            }
            if (h().q() == 7 || h().q() == 12) {
                return k().size() == 1 ? (byte) 5 : (byte) 2;
            }
            if (h().q() == 8) {
                return k().size() != 1 ? (byte) 4 : (byte) 3;
            }
            return (byte) 1;
        }
        return (byte) 0;
    }

    public adx e() {
        int i;
        int i2 = 0;
        adx adxVar = null;
        if (d() == 2 || d() == 4) {
            return i();
        }
        for (adx adxVar2 : this.c) {
            int iA = a(adxVar2);
            if (iA > i2 || adxVar == null) {
                i = iA;
            } else {
                adxVar2 = adxVar;
                i = i2;
            }
            i2 = i;
            adxVar = adxVar2;
        }
        return adxVar;
    }

    public static int a(adx adxVar) {
        if (adxVar.y()) {
            if (adxVar.S() == 3) {
                return 15;
            }
            if (adxVar.S() == 2) {
                return 14;
            }
            if (adxVar.S() == 33) {
                return 13;
            }
            if (adxVar.S() == 34) {
                return 12;
            }
            if (adxVar.S() == 4) {
                return 11;
            }
            if (adxVar.S() == 16) {
                return 10;
            }
            return 9;
        }
        if (adxVar.S() == 33) {
            return 6;
        }
        if (adxVar.S() == 3) {
            return 5;
        }
        if (adxVar.S() == 2) {
            return 4;
        }
        if (adxVar.S() == 34) {
            return 3;
        }
        return (adxVar.S() == 4 || adxVar.S() == 16) ? 2 : 1;
    }

    public byte f() {
        adx adxVarE = e();
        if (adxVarE != null) {
            return adxVarE.S();
        }
        return (byte) 32;
    }

    public boolean g() {
        return f() == 32;
    }

    public boolean b(adx adxVar) {
        return this.c != null && this.c.contains(adxVar);
    }

    public adx h() {
        adx adxVar = null;
        for (adx adxVar2 : this.c) {
            if (adxVar != null && adxVar2.t() != 0) {
                adxVar2 = adxVar;
            }
            adxVar = adxVar2;
        }
        return adxVar;
    }

    public adx i() {
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            adx next = it.next();
            if (next.H() || next.I()) {
                return next;
            }
        }
        return this.c.get(0);
    }

    public synchronized void b(boolean z) {
        MediaController.IS_FIRST_STOP_FOR_LINK = true;
        for (adx adxVar : this.c) {
            adxVar.a(z);
            mm.b("setActive device bool=%b, device=%s", Boolean.valueOf(z), adxVar);
            if (z) {
                mm.b("addDevice %s", adxVar);
                mm.b("setDeviceSource FC for ", adxVar);
                adxVar.d((byte) 32);
            }
        }
    }

    public void j() {
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            new adx(it.next().R()).Q();
        }
    }

    public List<adx> k() {
        return Collections.unmodifiableList(new ArrayList(this.c));
    }

    public void c(adx adxVar) {
        int i = 0;
        synchronized (this.c) {
            if (this.c.contains(adxVar)) {
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 >= this.c.size()) {
                    d(adxVar);
                    if (u()) {
                        mm.b("addDevice %s", adxVar);
                        mm.c();
                        adxVar.a(true);
                    }
                    if (!this.c.isEmpty()) {
                        adxVar.f(this.c.get(0).T());
                    }
                    this.c.add(adxVar);
                    return;
                }
                if (adxVar.P() != this.c.get(i2).P()) {
                    i = i2 + 1;
                } else {
                    this.c.remove(i2);
                    this.c.add(i2, adxVar);
                    d(adxVar);
                    return;
                }
            }
        }
    }

    private void d(adx adxVar) {
        if (adxVar.B() > this.a) {
            this.a = adxVar.B();
        } else if (adxVar.B() < this.b) {
            this.b = adxVar.B();
        }
    }

    public String l() {
        Iterator<adx> it = this.c.iterator();
        if (it.hasNext()) {
            return it.next().w();
        }
        new ml().a("No devices in room " + this);
        return "";
    }

    public int m() {
        Iterator<adx> it = this.c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        int iE = e(it.next());
        if (iE <= 0 && !this.c.isEmpty() && this.c.get(0) != null) {
            return this.c.get(0).A();
        }
        return ain.s[iE];
    }

    public int n() {
        Iterator<adx> it = this.c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        int iE = e(it.next());
        if (iE <= 0 && !this.c.isEmpty() && this.c.get(0) != null) {
            return this.c.get(0).A();
        }
        return ain.t[iE];
    }

    private int e(adx adxVar) {
        int iV = adxVar.v();
        if (iV == 0 && adxVar.j() > 0) {
            iV = adxVar.j();
        }
        if (iV < 1 || iV >= ain.t.length) {
            for (int i = 0; i < ain.v.length; i++) {
                if (HarmanApplication.a().getString(ain.v[i]).equals(l())) {
                    adxVar.h(i);
                    adw.a().z(adxVar);
                    return i;
                }
            }
            return 0;
        }
        return iV;
    }

    public int o() {
        Iterator<adx> it = this.c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        int iE = e(it.next());
        if (iE <= 0 && !this.c.isEmpty() && this.c.get(0) != null) {
            return this.c.get(0).A();
        }
        return ain.u[iE];
    }

    public int p() {
        Iterator<adx> it = this.c.iterator();
        if (it.hasNext()) {
            return it.next().v();
        }
        return 0;
    }

    public int q() {
        return !this.c.iterator().hasNext() ? ain.y[0] : ain.y[this.c.get(0).p()];
    }

    public void c(boolean z) {
        for (adx adxVar : this.c) {
            if (z) {
                adxVar.h((byte) 1);
            } else {
                adxVar.h((byte) 0);
            }
        }
    }

    public boolean r() {
        if (d() == 1) {
            if (this.c.get(0).E()) {
                for (adx adxVar : this.c) {
                    if (adxVar.L() && (adxVar.U() == 0 || adxVar.U() == -1)) {
                        return false;
                    }
                }
                return true;
            }
            if (this.c.get(0).O()) {
                Iterator<adx> it = this.c.iterator();
                while (it.hasNext()) {
                    if (it.next().U() == 1) {
                        return true;
                    }
                }
                return false;
            }
        } else if (d() == 3 || d() == 4 || d() == 5 || d() == 2) {
            return h().U() == 1;
        }
        for (adx adxVar2 : this.c) {
            if (adxVar2.U() == 0 || adxVar2.U() == -1) {
                return false;
            }
        }
        return true;
    }

    public int s() {
        if (this.c.iterator().hasNext()) {
            return this.c.get(0).s();
        }
        return -1;
    }

    public int t() {
        adx next = null;
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (next.N() && next.t() == 0) {
                return next.B();
            }
            if (d() == 3 || d() == 4 || d() == 5 || d() == 2) {
                return h().B();
            }
        }
        if (next == null) {
            return 0;
        }
        return next.B();
    }

    public void a(int i) {
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().i(i);
        }
    }

    public void a(long j, int i) {
        for (adx adxVar : this.c) {
            if (!adxVar.N()) {
                adxVar.i(i);
            } else if (adxVar.P() == j) {
                adxVar.i(i);
            }
        }
    }

    public boolean u() {
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().y()) {
                return true;
            }
        }
        return false;
    }

    public void d(boolean z) {
        byte b;
        if (!z) {
            b = 0;
        } else {
            b = 1;
        }
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().f(b);
        }
    }

    public int v() {
        if (d() == 1) {
            return R.string.SpeakerSetupStereoSpeaker_Str;
        }
        if (d() == 2) {
            return R.string.kSpeakerSetupAdapt51Speaker_Str;
        }
        if (d() == 5) {
            return R.string.SpeakerSetupMonoSpeaker_Str;
        }
        if (d() == 3) {
            return R.string.kSpeakerSetupSound21Speaker_Str;
        }
        return d() == 4 ? R.string.kSpeakerSetupSound51Speaker_Str : R.string.SpeakerSetupMonoSpeaker_Str;
    }

    public String w() {
        if (d() == 1) {
            return HarmanApplication.a().getString(R.string.SpeakerSetupStereoSpeaker_Str);
        }
        if (d() == 2) {
            return HarmanApplication.a().getString(R.string.kSpeakerSetupAdapt51Speaker_Str);
        }
        if (d() == 5) {
            return HarmanApplication.a().getString(R.string.SpeakerSetupMonoSpeaker_Str);
        }
        if (d() == 3) {
            return HarmanApplication.a().getString(R.string.kSpeakerSetupSound21Speaker_Str);
        }
        if (d() == 4) {
            return HarmanApplication.a().getString(R.string.kSpeakerSetupSound51Speaker_Str);
        }
        return HarmanApplication.a().getString(R.string.SpeakerSetupMonoSpeaker_Str);
    }

    public int x() {
        if (this.c.isEmpty()) {
            return 0;
        }
        return this.c.get(0).r();
    }

    public void b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.c.size()) {
                this.c.get(i3).d(i);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean y() {
        if (this.c.isEmpty()) {
            return false;
        }
        return afc.a().a(this.c.get(0).R());
    }

    public int z() {
        return this.c.size();
    }

    public int A() {
        Iterator<adx> it = this.c.iterator();
        if (it.hasNext()) {
            return it.next().p();
        }
        return 0;
    }

    public int hashCode() {
        return new bry(31307, 79841).a(c()).b();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            return new brx().a(c(), ((adz) obj).c()).a();
        }
        return false;
    }

    public String toString() {
        return bsc.b(this, new ahp());
    }

    public boolean B() {
        Iterator<adx> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().O()) {
                return false;
            }
        }
        return true;
    }
}
