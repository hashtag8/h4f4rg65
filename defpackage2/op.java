package defpackage;

/* JADX INFO: loaded from: classes.dex */
class op implements pb {
    private final pd a;
    private final pn b;

    public op(pd pdVar, pn pnVar) {
        this.a = pdVar;
        this.b = pnVar;
    }

    @Override // defpackage.pb
    public boolean a(pa paVar) throws Throwable {
        switch (paVar.b.g()) {
            case JAVA:
                this.a.a(paVar);
                break;
            case NATIVE:
                this.b.a(paVar);
                break;
        }
        return true;
    }
}
