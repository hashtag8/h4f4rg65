package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zn {
    private final Object a = new Object();
    private final List<Runnable> b = new ArrayList();
    private final List<Runnable> c = new ArrayList();
    private boolean d = false;

    private void a(Runnable runnable) {
        ze.a(runnable);
    }

    private void b(Runnable runnable) {
        st.a.post(runnable);
    }

    public void a() {
        synchronized (this.a) {
            if (this.d) {
                return;
            }
            Iterator<Runnable> it = this.b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Iterator<Runnable> it2 = this.c.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
            this.b.clear();
            this.c.clear();
            this.d = true;
        }
    }
}
