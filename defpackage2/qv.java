package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class qv<T> {
    private Class<T> a;

    public qv(Class<T> cls) {
        this.a = null;
        if (cls == null) {
            throw new IllegalArgumentException("Clazz can't be null.");
        }
        this.a = cls;
    }

    public List<T> a(String str) {
        if (str == null || str.toLowerCase().contains("{\"error\":{")) {
            return null;
        }
        abw abwVar = new abw();
        aby abyVarM = new acf().a(str).l().a("data").m();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < abyVarM.a(); i++) {
            arrayList.add(abwVar.a(abyVarM.a(i), (Class) this.a));
        }
        return arrayList;
    }
}
