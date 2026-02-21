package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class abb extends aas<abb> {
    private final List<tl> a = new ArrayList();
    private final List<tn> b = new ArrayList();
    private final Map<String, List<tl>> c = new HashMap();
    private tm d;

    public tm a() {
        return this.d;
    }

    @Override // defpackage.aas
    public void a(abb abbVar) {
        abbVar.a.addAll(this.a);
        abbVar.b.addAll(this.b);
        for (Map.Entry<String, List<tl>> entry : this.c.entrySet()) {
            String key = entry.getKey();
            Iterator<tl> it = entry.getValue().iterator();
            while (it.hasNext()) {
                abbVar.a(it.next(), key);
            }
        }
        if (this.d != null) {
            abbVar.d = this.d;
        }
    }

    public void a(tl tlVar, String str) {
        if (tlVar == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (!this.c.containsKey(str)) {
            this.c.put(str, new ArrayList());
        }
        this.c.get(str).add(tlVar);
    }

    public List<tl> b() {
        return Collections.unmodifiableList(this.a);
    }

    public Map<String, List<tl>> c() {
        return this.c;
    }

    public List<tn> d() {
        return Collections.unmodifiableList(this.b);
    }

    public String toString() {
        HashMap map = new HashMap();
        if (!this.a.isEmpty()) {
            map.put("products", this.a);
        }
        if (!this.b.isEmpty()) {
            map.put("promotions", this.b);
        }
        if (!this.c.isEmpty()) {
            map.put("impressions", this.c);
        }
        map.put("productAction", this.d);
        return a((Object) map);
    }
}
