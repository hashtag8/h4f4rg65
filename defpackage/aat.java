package defpackage;

import defpackage.aat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class aat<T extends aat> {
    protected final aaq a;
    private final aau b;
    private final List<aar> c;

    protected aat(aau aauVar, aah aahVar) {
        vq.a(aauVar);
        this.b = aauVar;
        this.c = new ArrayList();
        aaq aaqVar = new aaq(this, aahVar);
        aaqVar.k();
        this.a = aaqVar;
    }

    protected void a(aaq aaqVar) {
    }

    protected void b(aaq aaqVar) {
        Iterator<aar> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(this, aaqVar);
        }
    }

    public aaq j() {
        aaq aaqVarA = this.a.a();
        b(aaqVarA);
        return aaqVarA;
    }

    public aaq k() {
        return this.a;
    }

    public List<aaw> l() {
        return this.a.c();
    }

    protected aau m() {
        return this.b;
    }
}
