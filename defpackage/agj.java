package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class agj<T> implements agm {
    private agl a;
    private Set<T> b = Collections.synchronizedSet(new HashSet());

    public boolean a(T t) {
        brw.a(t, "listener", new Object[0]);
        return this.b.add(t);
    }

    protected List<T> a() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    protected void a(final agk agkVar) {
        for (final T t : a()) {
            agl aglVar = t instanceof agm ? (agl) brs.a((Object[]) new agl[]{((agm) t).b(), this.a}) : this.a;
            if (aglVar == null) {
                agkVar.a(t);
            } else {
                aglVar.a(new Runnable() { // from class: agj.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        agkVar.a(t);
                    }
                });
            }
        }
    }

    @Override // defpackage.agm
    public agl b() {
        return this.a;
    }
}
