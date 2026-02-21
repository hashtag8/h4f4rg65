package defpackage;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ari<T extends View> {
    private final T a;
    private Queue<Runnable> b = new LinkedList();

    public ari(T t) {
        this.a = t;
        t.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ari.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                mm.b("size is %sx%s", Integer.valueOf(i - i3), Integer.valueOf(i2 - i4));
                if ((i3 - i != 0 || i4 - i2 != 0) && ari.this.b != null) {
                    Iterator it = ari.this.b.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    ari.this.a.removeOnLayoutChangeListener(this);
                    ari.this.b = null;
                }
            }
        });
    }

    public T a() {
        return this.a;
    }

    public void a(Runnable runnable) {
        if (this.b == null || this.a.getHeight() != 0 || this.a.getWidth() != 0) {
            runnable.run();
        } else {
            this.b.add(runnable);
        }
    }
}
