package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class abj extends Exception {
    public final zo a;
    private long b;

    public abj() {
        this.a = null;
    }

    public abj(Throwable th) {
        super(th);
        this.a = null;
    }

    public abj(zo zoVar) {
        this.a = zoVar;
    }

    void a(long j) {
        this.b = j;
    }
}
