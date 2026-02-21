package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class bfv {
    private final Set<bfk> a = new LinkedHashSet();

    public synchronized void a(bfk bfkVar) {
        this.a.add(bfkVar);
    }

    public synchronized void b(bfk bfkVar) {
        this.a.remove(bfkVar);
    }

    public synchronized boolean c(bfk bfkVar) {
        return this.a.contains(bfkVar);
    }
}
