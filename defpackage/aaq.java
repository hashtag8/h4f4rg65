package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class aaq {
    private final aat a;
    private final aah b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private final Map<Class<? extends aas>, aas> j;
    private final List<aaw> k;

    aaq(aaq aaqVar) {
        this.a = aaqVar.a;
        this.b = aaqVar.b;
        this.d = aaqVar.d;
        this.e = aaqVar.e;
        this.f = aaqVar.f;
        this.g = aaqVar.g;
        this.h = aaqVar.h;
        this.k = new ArrayList(aaqVar.k);
        this.j = new HashMap(aaqVar.j.size());
        for (Map.Entry<Class<? extends aas>, aas> entry : aaqVar.j.entrySet()) {
            aas aasVarC = c(entry.getKey());
            entry.getValue().a(aasVarC);
            this.j.put(entry.getKey(), aasVarC);
        }
    }

    aaq(aat aatVar, aah aahVar) {
        vq.a(aatVar);
        vq.a(aahVar);
        this.a = aatVar;
        this.b = aahVar;
        this.g = 1800000L;
        this.h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    private static <T extends aas> T c(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
        }
    }

    public aaq a() {
        return new aaq(this);
    }

    public <T extends aas> T a(Class<T> cls) {
        return (T) this.j.get(cls);
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(aas aasVar) {
        vq.a(aasVar);
        Class<?> cls = aasVar.getClass();
        if (cls.getSuperclass() != aas.class) {
            throw new IllegalArgumentException();
        }
        aasVar.a(b(cls));
    }

    public <T extends aas> T b(Class<T> cls) {
        T t = (T) this.j.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) c(cls);
        this.j.put(cls, t2);
        return t2;
    }

    public Collection<aas> b() {
        return this.j.values();
    }

    public List<aaw> c() {
        return this.k;
    }

    public long d() {
        return this.d;
    }

    public void e() {
        i().a(this);
    }

    public boolean f() {
        return this.c;
    }

    void g() {
        this.f = this.b.b();
        if (this.e != 0) {
            this.d = this.e;
        } else {
            this.d = this.b.a();
        }
        this.c = true;
    }

    aat h() {
        return this.a;
    }

    aau i() {
        return this.a.m();
    }

    boolean j() {
        return this.i;
    }

    void k() {
        this.i = true;
    }
}
