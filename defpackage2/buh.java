package defpackage;

import android.support.v8.renderscript.Allocation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class buh implements Iterable<bun> {
    private List<bun> a = new LinkedList();
    private Map<String, List<bun>> b = new HashMap();

    public buh() {
    }

    public buh(buh buhVar) {
        Iterator<bun> it = buhVar.a.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(bun bunVar) {
        List<bun> linkedList = this.b.get(bunVar.getName().toLowerCase());
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.b.put(bunVar.getName().toLowerCase(), linkedList);
        }
        linkedList.add(bunVar);
        this.a.add(bunVar);
    }

    public List<bun> a() {
        return Collections.unmodifiableList(this.a);
    }

    public bun a(String str) {
        List<bun> list = this.b.get(str.toLowerCase());
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.lang.Iterable
    public Iterator<bun> iterator() {
        return Collections.unmodifiableList(this.a).iterator();
    }

    public void b(bun bunVar) {
        List<bun> list = this.b.get(bunVar.getName().toLowerCase());
        if (list == null || list.isEmpty()) {
            a(bunVar);
            return;
        }
        list.clear();
        list.add(bunVar);
        Iterator<bun> it = this.a.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(bunVar.getName())) {
                it.remove();
                if (i2 == -1) {
                    i2 = i;
                }
            }
            i++;
        }
        this.a.add(i2, bunVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Allocation.USAGE_SHARED);
        Iterator<bun> it = this.a.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
