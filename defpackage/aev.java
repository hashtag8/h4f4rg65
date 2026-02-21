package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class aev implements aew {
    private afe a = new afe();
    private int b = 5;

    @Override // defpackage.aew
    public void a(aed aedVar) {
        try {
            if (!this.a.a()) {
                this.a.a(aedVar.z());
            }
        } catch (RuntimeException e) {
            mm.b("Retrying after first failure", e);
            try {
                Thread.sleep(1000L);
                int i = this.b;
                this.b = i - 1;
                if (i != 0) {
                    a(aedVar);
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // defpackage.aew
    public void a() {
        this.a.c();
    }

    public afe b() {
        return this.a;
    }
}
