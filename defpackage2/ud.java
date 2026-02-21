package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class ud extends uc {
    private boolean a;
    private boolean b;

    protected ud(uf ufVar) {
        super(ufVar);
    }

    public boolean C() {
        return this.a && !this.b;
    }

    protected void D() {
        if (!C()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public void E() {
        a();
        this.a = true;
    }

    protected abstract void a();
}
