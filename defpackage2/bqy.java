package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class bqy implements bri {
    private final bri a;

    public bqy(bri briVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = briVar;
    }

    @Override // defpackage.bri
    public long a(bqs bqsVar, long j) {
        return this.a.a(bqsVar, j);
    }

    @Override // defpackage.bri
    public brj a() {
        return this.a.a();
    }

    @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
