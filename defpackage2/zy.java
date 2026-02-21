package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zy extends aas<zy> {
    private Map<Integer, Double> a = new HashMap(4);

    public Map<Integer, Double> a() {
        return Collections.unmodifiableMap(this.a);
    }

    @Override // defpackage.aas
    public void a(zy zyVar) {
        zyVar.a.putAll(this.a);
    }

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.a.entrySet()) {
            map.put("metric" + entry.getKey(), entry.getValue());
        }
        return a((Object) map);
    }
}
