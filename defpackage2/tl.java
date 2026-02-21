package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tl {
    Map<String, String> a = new HashMap();

    public Map<String, String> a(String str) {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            map.put(str + entry.getKey(), entry.getValue());
        }
        return map;
    }

    public String toString() {
        return aas.a((Map) this.a);
    }
}
