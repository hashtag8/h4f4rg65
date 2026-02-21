package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xt implements Iterable<xs> {
    private final List<xs> a = new LinkedList();

    private xs c(zp zpVar) {
        for (xs xsVar : sy.k()) {
            if (xsVar.a == zpVar) {
                return xsVar;
            }
        }
        return null;
    }

    public void a(xs xsVar) {
        this.a.add(xsVar);
    }

    public boolean a(zp zpVar) {
        xs xsVarC = c(zpVar);
        if (xsVarC == null) {
            return false;
        }
        xsVarC.b.a();
        return true;
    }

    public void b(xs xsVar) {
        this.a.remove(xsVar);
    }

    public boolean b(zp zpVar) {
        return c(zpVar) != null;
    }

    @Override // java.lang.Iterable
    public Iterator<xs> iterator() {
        return this.a.iterator();
    }
}
