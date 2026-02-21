package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bng implements bne {
    private final long a;
    private final int b;

    public bng(long j, int i) {
        this.a = j;
        this.b = i;
    }

    @Override // defpackage.bne
    public long a(int i) {
        return (long) (this.a * Math.pow(this.b, i));
    }
}
