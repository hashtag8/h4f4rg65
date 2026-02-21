package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class va extends aat<va> {
    private final uf b;
    private boolean c;

    public va(uf ufVar) {
        super(ufVar.h(), ufVar.d());
        this.b = ufVar;
    }

    @Override // defpackage.aat
    protected void a(aaq aaqVar) {
        aaa aaaVar = (aaa) aaqVar.b(aaa.class);
        if (TextUtils.isEmpty(aaaVar.b())) {
            aaaVar.b(this.b.p().b());
        }
        if (this.c && TextUtils.isEmpty(aaaVar.d())) {
            to toVarO = this.b.o();
            aaaVar.d(toVarO.c());
            aaaVar.a(toVarO.b());
        }
    }

    public void b(String str) {
        vq.a(str);
        c(str);
        l().add(new vb(this.b, str));
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(String str) {
        Uri uriA = vb.a(str);
        ListIterator<aaw> listIterator = l().listIterator();
        while (listIterator.hasNext()) {
            if (uriA.equals(listIterator.next().a())) {
                listIterator.remove();
            }
        }
    }

    uf i() {
        return this.b;
    }

    @Override // defpackage.aat
    public aaq j() {
        aaq aaqVarA = k().a();
        aaqVarA.a(this.b.q().c());
        aaqVarA.a(this.b.r().b());
        b(aaqVarA);
        return aaqVarA;
    }
}
