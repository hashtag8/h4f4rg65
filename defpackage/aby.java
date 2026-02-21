package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class aby extends aca implements Iterable<aca> {
    private final List<aca> a = new ArrayList();

    public void a(aca acaVar) {
        if (acaVar == null) {
            acaVar = acc.a;
        }
        this.a.add(acaVar);
    }

    public int a() {
        return this.a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<aca> iterator() {
        return this.a.iterator();
    }

    public aca a(int i) {
        return this.a.get(i);
    }

    @Override // defpackage.aca
    public Number b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.aca
    public String c() {
        if (this.a.size() == 1) {
            return this.a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.aca
    public double d() {
        if (this.a.size() == 1) {
            return this.a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.aca
    public long e() {
        if (this.a.size() == 1) {
            return this.a.get(0).e();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.aca
    public int f() {
        if (this.a.size() == 1) {
            return this.a.get(0).f();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.aca
    public boolean g() {
        if (this.a.size() == 1) {
            return this.a.get(0).g();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof aby) && ((aby) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
