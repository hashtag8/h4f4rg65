package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class xh implements aba {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public xh() {
        this(2500, 1, 1.0f);
    }

    public xh(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // defpackage.aba
    public int a() {
        return this.a;
    }

    @Override // defpackage.aba
    public void a(abj abjVar) throws abj {
        this.b++;
        this.a = (int) (this.a + (this.a * this.d));
        if (!c()) {
            throw abjVar;
        }
    }

    @Override // defpackage.aba
    public int b() {
        return this.b;
    }

    protected boolean c() {
        return this.b <= this.c;
    }
}
