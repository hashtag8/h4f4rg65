package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class bqx implements brh {
    private final brh a;

    public bqx(brh brhVar) {
        if (brhVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = brhVar;
    }

    @Override // defpackage.brh
    public void a_(bqs bqsVar, long j) {
        this.a.a_(bqsVar, j);
    }

    @Override // defpackage.brh, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // defpackage.brh
    public brj a() {
        return this.a.a();
    }

    @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
