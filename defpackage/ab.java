package defpackage;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ab<V extends View> extends CoordinatorLayout.a<V> {
    private ac a;
    private int b;
    private int c;

    public ab() {
        this.b = 0;
        this.c = 0;
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.a
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new ac(v);
        }
        this.a.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c != 0) {
            this.a.b(this.c);
            this.c = 0;
            return true;
        }
        return true;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.a(v, i);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return this.a.a(i);
        }
        this.b = i;
        return false;
    }

    public int b() {
        if (this.a != null) {
            return this.a.b();
        }
        return 0;
    }
}
