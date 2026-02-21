package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tm {
    Map<String, String> a;

    public Map<String, String> a() {
        return new HashMap(this.a);
    }

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            if (entry.getKey().startsWith("&")) {
                map.put(entry.getKey().substring(1), entry.getValue());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return aas.a((Map) map);
    }
}
