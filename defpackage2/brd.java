package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class brd implements bqt {
    public final bqs a;
    public final brh b;
    private boolean c;

    public brd(brh brhVar, bqs bqsVar) {
        if (brhVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = bqsVar;
        this.b = brhVar;
    }

    public brd(brh brhVar) {
        this(brhVar, new bqs());
    }

    @Override // defpackage.bqt, defpackage.bqu
    public bqs c() {
        return this.a;
    }

    @Override // defpackage.brh
    public void a_(bqs bqsVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(bqsVar, j);
        v();
    }

    @Override // defpackage.bqt
    public bqt b(bqv bqvVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bqvVar);
        return v();
    }

    @Override // defpackage.bqt
    public bqt b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return v();
    }

    @Override // defpackage.bqt
    public bqt c(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr);
        return v();
    }

    @Override // defpackage.bqt
    public long a(bri briVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = briVar.a(this.a, 2048L);
            if (jA != -1) {
                j += jA;
                v();
            } else {
                return j;
            }
        }
    }

    @Override // defpackage.bqt
    public bqt h(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(i);
        return v();
    }

    @Override // defpackage.bqt
    public bqt g(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.g(i);
        return v();
    }

    @Override // defpackage.bqt
    public bqt f(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.f(i);
        return v();
    }

    @Override // defpackage.bqt
    public bqt k(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.k(j);
        return v();
    }

    @Override // defpackage.bqt
    public bqt j(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j(j);
        return v();
    }

    @Override // defpackage.bqt
    public bqt v() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jH = this.a.h();
        if (jH > 0) {
            this.b.a_(this.a, jH);
        }
        return this;
    }

    @Override // defpackage.bqt
    public bqt e() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jB = this.a.b();
        if (jB > 0) {
            this.b.a_(this.a, jB);
        }
        return this;
    }

    @Override // defpackage.brh, java.io.Flushable
    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a_(this.a, this.a.b);
        }
        this.b.flush();
    }

    @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a_(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                brk.a(th);
            }
        }
    }

    @Override // defpackage.brh
    public brj a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
