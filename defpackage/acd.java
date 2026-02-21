package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class acd extends aca {
    private final Map<String, aca> a = new LinkedHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, aca acaVar) {
        if (acaVar == null) {
            acaVar = acc.a;
        }
        this.a.put(acq.a(str), acaVar);
    }

    public Set<Map.Entry<String, aca>> a() {
        return this.a.entrySet();
    }

    public aca a(String str) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        aca acaVar = this.a.get(str);
        return acaVar == null ? acc.a : acaVar;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof acd) && ((acd) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
