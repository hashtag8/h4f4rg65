package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class uk extends ud {
    private final aax a;

    uk(uf ufVar) {
        super(ufVar);
        this.a = new aax();
    }

    @Override // defpackage.ud
    protected void a() {
        r().a().a(this.a);
        b();
    }

    public void b() {
        ua uaVarV = v();
        String strC = uaVarV.c();
        if (strC != null) {
            this.a.a(strC);
        }
        String strB = uaVarV.b();
        if (strB != null) {
            this.a.b(strB);
        }
    }

    public aax c() {
        D();
        return this.a;
    }
}
