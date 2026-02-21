package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class lx extends Exception {
    public final ln a;
    private long b;

    public lx() {
        this.a = null;
    }

    public lx(ln lnVar) {
        this.a = lnVar;
    }

    public lx(Throwable th) {
        super(th);
        this.a = null;
    }

    void a(long j) {
        this.b = j;
    }
}
