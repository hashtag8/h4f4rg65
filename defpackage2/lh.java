package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class lh implements lu {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public lh() {
        this(2500, 0, 1.0f);
    }

    public lh(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // defpackage.lu
    public int a() {
        return this.a;
    }

    @Override // defpackage.lu
    public int b() {
        return this.b;
    }

    @Override // defpackage.lu
    public void a(lx lxVar) throws lx {
        this.b++;
        this.a = (int) (this.a + (this.a * this.d));
        if (!c()) {
            throw lxVar;
        }
    }

    protected boolean c() {
        return this.b <= this.c;
    }
}
