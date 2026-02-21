package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class bre implements bqu {
    public final bqs a;
    public final bri b;
    private boolean c;

    public bre(bri briVar, bqs bqsVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = bqsVar;
        this.b = briVar;
    }

    public bre(bri briVar) {
        this(briVar, new bqs());
    }

    @Override // defpackage.bqu
    public bqs c() {
        return this.a;
    }

    @Override // defpackage.bri
    public long a(bqs bqsVar, long j) {
        if (bqsVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b == 0 && this.b.a(this.a, 2048L) == -1) {
            return -1L;
        }
        return this.a.a(bqsVar, Math.min(j, this.a.b));
    }

    @Override // defpackage.bqu
    public boolean f() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.f() && this.b.a(this.a, 2048L) == -1;
    }

    @Override // defpackage.bqu
    public void a(long j) throws EOFException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.a.b < j) {
            if (this.b.a(this.a, 2048L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.bqu
    public byte i() throws EOFException {
        a(1L);
        return this.a.i();
    }

    @Override // defpackage.bqu
    public bqv c(long j) throws EOFException {
        a(j);
        return this.a.c(j);
    }

    @Override // defpackage.bqu
    public byte[] f(long j) throws EOFException {
        a(j);
        return this.a.f(j);
    }

    @Override // defpackage.bqu
    public String r() throws EOFException {
        long jA = a((byte) 10);
        if (jA == -1) {
            bqs bqsVar = new bqs();
            this.a.a(bqsVar, 0L, Math.min(32L, this.a.b()));
            throw new EOFException("\\n not found: size=" + this.a.b() + " content=" + bqsVar.p().d() + "...");
        }
        return this.a.e(jA);
    }

    @Override // defpackage.bqu
    public short j() throws EOFException {
        a(2L);
        return this.a.j();
    }

    @Override // defpackage.bqu
    public short l() throws EOFException {
        a(2L);
        return this.a.l();
    }

    @Override // defpackage.bqu
    public int k() throws EOFException {
        a(4L);
        return this.a.k();
    }

    @Override // defpackage.bqu
    public int m() throws EOFException {
        a(4L);
        return this.a.m();
    }

    @Override // defpackage.bqu
    public long n() throws EOFException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte b = this.a.b(i);
            if ((b < 48 || b > 57) && (i != 0 || b != 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b)));
                }
                return this.a.n();
            }
        }
        return this.a.n();
    }

    @Override // defpackage.bqu
    public long o() throws EOFException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte b = this.a.b(i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b)));
                }
                return this.a.o();
            }
        }
        return this.a.o();
    }

    @Override // defpackage.bqu
    public void g(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.a(this.a, 2048L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.a.b());
            this.a.g(jMin);
            j -= jMin;
        }
    }

    @Override // defpackage.bqu
    public long a(byte b) {
        return a(b, 0L);
    }

    public long a(byte b, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.a.b) {
            if (this.b.a(this.a, 2048L) == -1) {
                return -1L;
            }
        }
        do {
            long jA = this.a.a(b, j);
            if (jA != -1) {
                return jA;
            }
            j = this.a.b;
        } while (this.b.a(this.a, 2048L) != -1);
        return -1L;
    }

    @Override // defpackage.bqu
    public InputStream g() {
        return new InputStream() { // from class: bre.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (bre.this.c) {
                    throw new IOException("closed");
                }
                if (bre.this.a.b == 0 && bre.this.b.a(bre.this.a, 2048L) == -1) {
                    return -1;
                }
                return bre.this.a.i() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (bre.this.c) {
                    throw new IOException("closed");
                }
                brk.a(bArr.length, i, i2);
                if (bre.this.a.b == 0 && bre.this.b.a(bre.this.a, 2048L) == -1) {
                    return -1;
                }
                return bre.this.a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (bre.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(bre.this.a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                bre.this.close();
            }

            public String toString() {
                return bre.this + ".inputStream()";
            }
        };
    }

    @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.t();
        }
    }

    @Override // defpackage.bri
    public brj a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
