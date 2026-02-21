package defpackage;

import defpackage.nu;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class np implements ng {
    static final Set<nu.b> b = new HashSet<nu.b>() { // from class: np.1
        {
            add(nu.b.START);
            add(nu.b.RESUME);
            add(nu.b.PAUSE);
            add(nu.b.STOP);
        }
    };
    final int a;

    public np(int i) {
        this.a = i;
    }

    @Override // defpackage.ng
    public boolean a(nu nuVar) {
        return (b.contains(nuVar.c) && nuVar.a.g == null) && (Math.abs(nuVar.a.c.hashCode() % this.a) != 0);
    }
}
