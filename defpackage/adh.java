package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class adh extends adt {
    private static final Writer a = new Writer() { // from class: adh.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };
    private static final acg b = new acg("closed");
    private final List<aca> c;
    private String d;
    private aca e;

    public adh() {
        super(a);
        this.c = new ArrayList();
        this.e = acc.a;
    }

    public aca a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    private aca j() {
        return this.c.get(this.c.size() - 1);
    }

    private void a(aca acaVar) {
        if (this.d != null) {
            if (!acaVar.k() || i()) {
                ((acd) j()).a(this.d, acaVar);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = acaVar;
            return;
        }
        aca acaVarJ = j();
        if (acaVarJ instanceof aby) {
            ((aby) acaVarJ).a(acaVar);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.adt
    public adt b() {
        aby abyVar = new aby();
        a(abyVar);
        this.c.add(abyVar);
        return this;
    }

    @Override // defpackage.adt
    public adt c() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof aby) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.adt
    public adt d() {
        acd acdVar = new acd();
        a(acdVar);
        this.c.add(acdVar);
        return this;
    }

    @Override // defpackage.adt
    public adt e() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof acd) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.adt
    public adt a(String str) {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof acd) {
            this.d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.adt
    public adt b(String str) {
        if (str == null) {
            return f();
        }
        a(new acg(str));
        return this;
    }

    @Override // defpackage.adt
    public adt f() {
        a(acc.a);
        return this;
    }

    @Override // defpackage.adt
    public adt a(boolean z) {
        a(new acg(Boolean.valueOf(z)));
        return this;
    }

    @Override // defpackage.adt
    public adt a(long j) {
        a(new acg(Long.valueOf(j)));
        return this;
    }

    @Override // defpackage.adt
    public adt a(Number number) {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new acg(number));
        return this;
    }

    @Override // defpackage.adt, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }
}
