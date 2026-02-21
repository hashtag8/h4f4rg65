package defpackage;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class nq extends bnk<nu> {
    private bog g;

    nq(Context context, nw nwVar, bmg bmgVar, bnl bnlVar) {
        super(context, nwVar, bmgVar, bnlVar, 100);
    }

    @Override // defpackage.bnk
    protected String a() {
        return "sa_" + UUID.randomUUID().toString() + "_" + this.c.a() + ".tap";
    }

    @Override // defpackage.bnk
    protected int b() {
        return this.g == null ? super.b() : this.g.e;
    }

    @Override // defpackage.bnk
    protected int c() {
        return this.g == null ? super.c() : this.g.c;
    }

    void a(bog bogVar) {
        this.g = bogVar;
    }
}
