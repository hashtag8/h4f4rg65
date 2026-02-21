package defpackage;

/* JADX INFO: loaded from: classes.dex */
class blm<Result> extends bmw<Void, Void, Result> {
    final bln<Result> a;

    public blm(bln<Result> blnVar) {
        this.a = blnVar;
    }

    @Override // defpackage.bmr
    protected void a() {
        super.a();
        bmq bmqVarA = a("onPreExecute");
        try {
            try {
                try {
                    boolean zB_ = this.a.b_();
                    bmqVarA.b();
                    if (!zB_) {
                        a(true);
                    }
                } catch (bnd e) {
                    throw e;
                }
            } catch (Exception e2) {
                blh.h().e("Fabric", "Failure onPreExecute()", e2);
                bmqVarA.b();
                a(true);
            }
        } catch (Throwable th) {
            bmqVarA.b();
            a(true);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bmr
    public Result a(Void... voidArr) {
        bmq bmqVarA = a("doInBackground");
        Result resultF = null;
        if (!e()) {
            resultF = this.a.f();
        }
        bmqVarA.b();
        return resultF;
    }

    @Override // defpackage.bmr
    protected void a(Result result) {
        this.a.a(result);
        this.a.h.a(result);
    }

    @Override // defpackage.bmr
    protected void b(Result result) {
        this.a.b(result);
        this.a.h.a(new bll(this.a.b() + " Initialization was cancelled"));
    }

    @Override // defpackage.bmw, defpackage.bmz
    public bmv b() {
        return bmv.HIGH;
    }

    private bmq a(String str) {
        bmq bmqVar = new bmq(this.a.b() + "." + str, "KitInitialization");
        bmqVar.a();
        return bmqVar;
    }
}
