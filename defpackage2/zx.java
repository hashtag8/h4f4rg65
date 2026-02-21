package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zx extends aas<zx> {
    private Map<Integer, String> a = new HashMap(4);

    public Map<Integer, String> a() {
        return Collections.unmodifiableMap(this.a);
    }

    @Override // defpackage.aas
    public void a(zx zxVar) {
        zxVar.a.putAll(this.a);
    }

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.a.entrySet()) {
            map.put("dimension" + entry.getKey(), entry.getValue());
        }
        return a((Object) map);
    }
}
