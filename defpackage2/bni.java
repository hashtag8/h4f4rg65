package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bni {
    private final int a;
    private final bne b;
    private final bnh c;

    public bni(bne bneVar, bnh bnhVar) {
        this(0, bneVar, bnhVar);
    }

    public bni(int i, bne bneVar, bnh bnhVar) {
        this.a = i;
        this.b = bneVar;
        this.c = bnhVar;
    }

    public long a() {
        return this.b.a(this.a);
    }

    public bni b() {
        return new bni(this.a + 1, this.b, this.c);
    }

    public bni c() {
        return new bni(this.b, this.c);
    }
}
