package defpackage;

/* JADX INFO: loaded from: classes.dex */
class ty {
    private final aah a;
    private long b;

    public ty(aah aahVar) {
        vq.a(aahVar);
        this.a = aahVar;
    }

    public ty(aah aahVar, long j) {
        vq.a(aahVar);
        this.a = aahVar;
        this.b = j;
    }

    public void a() {
        this.b = this.a.b();
    }

    public boolean a(long j) {
        return this.b == 0 || this.a.b() - this.b > j;
    }

    public void b() {
        this.b = 0L;
    }
}
