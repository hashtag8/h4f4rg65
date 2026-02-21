package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bsq {
    private int a = 0;
    private int b = 10;
    private long c;
    private long d;
    private long e;

    public void a() {
        if (this.a == 2) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (this.a != 0) {
            throw new IllegalStateException("Stopwatch already started. ");
        }
        this.c = System.nanoTime();
        this.d = System.currentTimeMillis();
        this.a = 1;
    }

    public long b() {
        return c() / 1000000;
    }

    public long c() {
        if (this.a == 2 || this.a == 3) {
            return this.e - this.c;
        }
        if (this.a == 0) {
            return 0L;
        }
        if (this.a == 1) {
            return System.nanoTime() - this.c;
        }
        throw new RuntimeException("Illegal running state has occured. ");
    }

    public String toString() {
        return bsp.a(b());
    }
}
