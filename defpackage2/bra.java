package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class bra implements bri {
    private final bqu b;
    private final Inflater c;
    private final brb d;
    private int a = 0;
    private final CRC32 e = new CRC32();

    public bra(bri briVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = brc.a(briVar);
        this.d = new brb(this.b, this.c);
    }

    @Override // defpackage.bri
    public long a(bqs bqsVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.a == 0) {
            b();
            this.a = 1;
        }
        if (this.a == 1) {
            long j2 = bqsVar.b;
            long jA = this.d.a(bqsVar, j);
            if (jA != -1) {
                a(bqsVar, j2, jA);
                return jA;
            }
            this.a = 2;
        }
        if (this.a == 2) {
            c();
            this.a = 3;
            if (!this.b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.b.a(10L);
        byte b = this.b.c().b(3L);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            a(this.b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.j());
        this.b.g(8L);
        if (((b >> 2) & 1) == 1) {
            this.b.a(2L);
            if (z) {
                a(this.b.c(), 0L, 2L);
            }
            short sL = this.b.c().l();
            this.b.a(sL);
            if (z) {
                a(this.b.c(), 0L, sL);
            }
            this.b.g(sL);
        }
        if (((b >> 3) & 1) == 1) {
            long jA = this.b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.c(), 0L, 1 + jA);
            }
            this.b.g(1 + jA);
        }
        if (((b >> 4) & 1) == 1) {
            long jA2 = this.b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.c(), 0L, 1 + jA2);
            }
            this.b.g(1 + jA2);
        }
        if (z) {
            a("FHCRC", this.b.l(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.b.m(), (int) this.e.getValue());
        a("ISIZE", this.b.m(), this.c.getTotalOut());
    }

    @Override // defpackage.bri
    public brj a() {
        return this.b.a();
    }

    @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    private void a(bqs bqsVar, long j, long j2) {
        brf brfVar = bqsVar.a;
        while (j >= brfVar.c - brfVar.b) {
            j -= (long) (brfVar.c - brfVar.b);
            brfVar = brfVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) brfVar.b) + j);
            int iMin = (int) Math.min(brfVar.c - i, j2);
            this.e.update(brfVar.a, i, iMin);
            j2 -= (long) iMin;
            brfVar = brfVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
