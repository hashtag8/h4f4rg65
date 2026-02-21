package defpackage;

/* JADX INFO: loaded from: classes.dex */
class no {
    long a;
    private bni b;

    public no(bni bniVar) {
        if (bniVar == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.b = bniVar;
    }

    public boolean a(long j) {
        return j - this.a >= 1000000 * this.b.a();
    }

    public void b(long j) {
        this.a = j;
        this.b = this.b.b();
    }

    public void a() {
        this.a = 0L;
        this.b = this.b.c();
    }
}
