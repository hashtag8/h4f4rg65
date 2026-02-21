package defpackage;

import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class bgl implements brh {
    private boolean a;
    private final int b;
    private final bqs c;

    public bgl(int i) {
        this.c = new bqs();
        this.b = i;
    }

    public bgl() {
        this(-1);
    }

    @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws ProtocolException {
        if (!this.a) {
            this.a = true;
            if (this.c.b() < this.b) {
                throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.b());
            }
        }
    }

    @Override // defpackage.brh
    public void a_(bqs bqsVar, long j) throws ProtocolException {
        if (this.a) {
            throw new IllegalStateException("closed");
        }
        bfw.a(bqsVar.b(), 0L, j);
        if (this.b != -1 && this.c.b() > ((long) this.b) - j) {
            throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
        }
        this.c.a_(bqsVar, j);
    }

    @Override // defpackage.brh, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.brh
    public brj a() {
        return brj.b;
    }

    public long b() {
        return this.c.b();
    }

    public void a(brh brhVar) {
        bqs bqsVar = new bqs();
        this.c.a(bqsVar, 0L, this.c.b());
        brhVar.a_(bqsVar, bqsVar.b());
    }
}
