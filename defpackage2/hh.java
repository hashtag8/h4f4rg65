package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class hh {
    private Object a;
    private boolean b;

    public interface a {
        void a(hh hhVar);

        boolean a(hh hhVar, Menu menu);

        boolean a(hh hhVar, MenuItem menuItem);

        boolean b(hh hhVar, Menu menu);
    }

    public abstract MenuInflater a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public abstract Menu b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public abstract View i();

    public void a(Object obj) {
        this.a = obj;
    }

    public Object j() {
        return this.a;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean k() {
        return this.b;
    }

    public boolean h() {
        return false;
    }
}
