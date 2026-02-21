package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    private long a;
    private long b = Long.MIN_VALUE;
    private Object c = new Object();

    public zk(long j) {
        this.a = j;
    }

    public boolean a() {
        boolean z;
        synchronized (this.c) {
            long jB = sy.g().b();
            if (this.b + this.a > jB) {
                z = false;
            } else {
                this.b = jB;
                z = true;
            }
        }
        return z;
    }
}
