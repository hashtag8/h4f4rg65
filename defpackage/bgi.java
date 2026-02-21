package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bgi extends bfj {
    private final bfa a;
    private final bqu b;

    public bgi(bfa bfaVar, bqu bquVar) {
        this.a = bfaVar;
        this.b = bquVar;
    }

    @Override // defpackage.bfj
    public long a() {
        return bgh.a(this.a);
    }

    @Override // defpackage.bfj
    public bqu b() {
        return this.b;
    }
}
