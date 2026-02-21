package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class bna implements bms<bnc>, bmz, bnc {
    private final List<bnc> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference<>(null);

    @Override // defpackage.bms
    public synchronized Collection<bnc> c() {
        return Collections.unmodifiableCollection(this.a);
    }

    @Override // defpackage.bms
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void c(bnc bncVar) {
        this.a.add(bncVar);
    }

    @Override // defpackage.bms
    public boolean d() {
        Iterator<bnc> it = c().iterator();
        while (it.hasNext()) {
            if (!it.next().f()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.bnc
    public synchronized void b(boolean z) {
        this.b.set(z);
    }

    @Override // defpackage.bnc
    public boolean f() {
        return this.b.get();
    }

    @Override // defpackage.bmz
    public bmv b() {
        return bmv.NORMAL;
    }

    @Override // defpackage.bnc
    public void a(Throwable th) {
        this.c.set(th);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return bmv.a(this, obj);
    }

    public static boolean a(Object obj) {
        try {
            return (((bms) obj) == null || ((bnc) obj) == null || ((bmz) obj) == null) ? false : true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
