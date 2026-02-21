package defpackage;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class adg extends adq {
    private static final Reader a = new Reader() { // from class: adg.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };
    private static final Object b = new Object();
    private final List<Object> c;

    public adg(aca acaVar) {
        super(a);
        this.c = new ArrayList();
        this.c.add(acaVar);
    }

    @Override // defpackage.adq
    public void a() {
        a(ads.BEGIN_ARRAY);
        this.c.add(((aby) q()).iterator());
    }

    @Override // defpackage.adq
    public void b() {
        a(ads.END_ARRAY);
        r();
        r();
    }

    @Override // defpackage.adq
    public void c() {
        a(ads.BEGIN_OBJECT);
        this.c.add(((acd) q()).a().iterator());
    }

    @Override // defpackage.adq
    public void d() {
        a(ads.END_OBJECT);
        r();
        r();
    }

    @Override // defpackage.adq
    public boolean e() {
        ads adsVarF = f();
        return (adsVarF == ads.END_OBJECT || adsVarF == ads.END_ARRAY) ? false : true;
    }

    @Override // defpackage.adq
    public ads f() {
        if (this.c.isEmpty()) {
            return ads.END_DOCUMENT;
        }
        Object objQ = q();
        if (objQ instanceof Iterator) {
            boolean z = this.c.get(this.c.size() - 2) instanceof acd;
            Iterator it = (Iterator) objQ;
            if (!it.hasNext()) {
                return z ? ads.END_OBJECT : ads.END_ARRAY;
            }
            if (z) {
                return ads.NAME;
            }
            this.c.add(it.next());
            return f();
        }
        if (objQ instanceof acd) {
            return ads.BEGIN_OBJECT;
        }
        if (objQ instanceof aby) {
            return ads.BEGIN_ARRAY;
        }
        if (objQ instanceof acg) {
            acg acgVar = (acg) objQ;
            if (acgVar.q()) {
                return ads.STRING;
            }
            if (acgVar.a()) {
                return ads.BOOLEAN;
            }
            if (acgVar.p()) {
                return ads.NUMBER;
            }
            throw new AssertionError();
        }
        if (objQ instanceof acc) {
            return ads.NULL;
        }
        if (objQ == b) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    private Object q() {
        return this.c.get(this.c.size() - 1);
    }

    private Object r() {
        return this.c.remove(this.c.size() - 1);
    }

    private void a(ads adsVar) {
        if (f() != adsVar) {
            throw new IllegalStateException("Expected " + adsVar + " but was " + f());
        }
    }

    @Override // defpackage.adq
    public String g() {
        a(ads.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // defpackage.adq
    public String h() {
        ads adsVarF = f();
        if (adsVarF != ads.STRING && adsVarF != ads.NUMBER) {
            throw new IllegalStateException("Expected " + ads.STRING + " but was " + adsVarF);
        }
        return ((acg) r()).c();
    }

    @Override // defpackage.adq
    public boolean i() {
        a(ads.BOOLEAN);
        return ((acg) r()).g();
    }

    @Override // defpackage.adq
    public void j() {
        a(ads.NULL);
        r();
    }

    @Override // defpackage.adq
    public double k() {
        ads adsVarF = f();
        if (adsVarF != ads.NUMBER && adsVarF != ads.STRING) {
            throw new IllegalStateException("Expected " + ads.NUMBER + " but was " + adsVarF);
        }
        double d = ((acg) q()).d();
        if (!p() && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
        }
        r();
        return d;
    }

    @Override // defpackage.adq
    public long l() {
        ads adsVarF = f();
        if (adsVarF != ads.NUMBER && adsVarF != ads.STRING) {
            throw new IllegalStateException("Expected " + ads.NUMBER + " but was " + adsVarF);
        }
        long jE = ((acg) q()).e();
        r();
        return jE;
    }

    @Override // defpackage.adq
    public int m() {
        ads adsVarF = f();
        if (adsVarF != ads.NUMBER && adsVarF != ads.STRING) {
            throw new IllegalStateException("Expected " + ads.NUMBER + " but was " + adsVarF);
        }
        int iF = ((acg) q()).f();
        r();
        return iF;
    }

    @Override // defpackage.adq, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.clear();
        this.c.add(b);
    }

    @Override // defpackage.adq
    public void n() {
        if (f() == ads.NAME) {
            g();
        } else {
            r();
        }
    }

    @Override // defpackage.adq
    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() {
        a(ads.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        this.c.add(new acg((String) entry.getKey()));
    }
}
