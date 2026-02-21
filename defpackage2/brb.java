package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class brb implements bri {
    private final bqu a;
    private final Inflater b;
    private int c;
    private boolean d;

    public brb(bri briVar, Inflater inflater) {
        this(brc.a(briVar), inflater);
    }

    brb(bqu bquVar, Inflater inflater) {
        if (bquVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = bquVar;
        this.b = inflater;
    }

    @Override // defpackage.bri
    public long a(bqs bqsVar, long j) throws IOException {
        boolean zB;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                brf brfVarE = bqsVar.e(1);
                int iInflate = this.b.inflate(brfVarE.a, brfVarE.c, 2048 - brfVarE.c);
                if (iInflate > 0) {
                    brfVarE.c += iInflate;
                    bqsVar.b += (long) iInflate;
                    return iInflate;
                }
                if (this.b.finished() || this.b.needsDictionary()) {
                    c();
                    if (brfVarE.b == brfVarE.c) {
                        bqsVar.a = brfVarE.a();
                        brg.a(brfVarE);
                    }
                    return -1L;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    public boolean b() {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.a.f()) {
            return true;
        }
        brf brfVar = this.a.c().a;
        this.c = brfVar.c - brfVar.b;
        this.b.setInput(brfVar.a, brfVar.b, this.c);
        return false;
    }

    private void c() {
        if (this.c != 0) {
            int remaining = this.c - this.b.getRemaining();
            this.c -= remaining;
            this.a.g(remaining);
        }
    }

    @Override // defpackage.bri
    public brj a() {
        return this.a.a();
    }

    @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }
}
