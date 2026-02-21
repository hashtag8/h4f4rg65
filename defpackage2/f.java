package defpackage;

import defpackage.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    private final e c;
    private defpackage.a<Object, a> a = new defpackage.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<d.b> g = new ArrayList<>();
    private d.b b = d.b.INITIALIZED;

    public f(e eVar) {
        this.c = eVar;
    }

    public void a(d.b bVar) {
        this.b = bVar;
    }

    public void a(d.a aVar) {
        this.b = b(aVar);
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        e();
        this.e = false;
    }

    private boolean a() {
        if (this.a.a() == 0) {
            return true;
        }
        d.b bVar = this.a.d().getValue().a;
        d.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    private void b() {
        this.g.remove(this.g.size() - 1);
    }

    private void b(d.b bVar) {
        this.g.add(bVar);
    }

    static d.b b(d.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return d.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return d.b.STARTED;
            case ON_RESUME:
                return d.b.RESUMED;
            case ON_DESTROY:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private static d.a c(d.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return d.a.ON_DESTROY;
            case STARTED:
                return d.a.ON_STOP;
            case RESUMED:
                return d.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private static d.a d(d.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return d.a.ON_CREATE;
            case CREATED:
                return d.a.ON_START;
            case STARTED:
                return d.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void c() {
        b<Object, a>.d dVarC = this.a.c();
        while (dVarC.hasNext() && !this.f) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.a(next.getKey())) {
                b(aVar.a);
                aVar.a(this.c, d(aVar.a));
                b();
            }
        }
    }

    private void d() {
        Iterator<Map.Entry<Object, a>> itB = this.a.b();
        while (itB.hasNext() && !this.f) {
            Map.Entry<Object, a> next = itB.next();
            a value = next.getValue();
            while (value.a.compareTo(this.b) > 0 && !this.f && this.a.a(next.getKey())) {
                d.a aVarC = c(value.a);
                b(b(aVarC));
                value.a(this.c, aVarC);
                b();
            }
        }
    }

    private void e() {
        while (!a()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
                d();
            }
            Map.Entry<Object, a> entryE = this.a.e();
            if (!this.f && entryE != null && this.b.compareTo(entryE.getValue().a) > 0) {
                c();
            }
        }
        this.f = false;
    }

    static d.b a(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    static class a {
        d.b a;
        c b;

        void a(e eVar, d.a aVar) {
            d.b bVarB = f.b(aVar);
            this.a = f.a(this.a, bVarB);
            this.b.a(eVar, aVar);
            this.a = bVarB;
        }
    }
}
