package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@yx
public class wn {
    private final Object a;
    private int b;
    private List<wm> c;

    public boolean a(wm wmVar) {
        boolean z;
        synchronized (this.a) {
            z = this.c.contains(wmVar);
        }
        return z;
    }

    public boolean b(wm wmVar) {
        boolean z;
        synchronized (this.a) {
            Iterator<wm> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                wm next = it.next();
                if (wmVar != next && next.b().equals(wmVar.b())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void c(wm wmVar) {
        synchronized (this.a) {
            if (this.c.size() >= 10) {
                su.a("Queue is full, current size = " + this.c.size());
                this.c.remove(0);
            }
            int i = this.b;
            this.b = i + 1;
            wmVar.a(i);
            this.c.add(wmVar);
        }
    }
}
