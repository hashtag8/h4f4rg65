package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ajk extends Fragment {
    private Bundle a = null;
    private Set<a> b = new CopyOnWriteArraySet();

    public interface a {
        void a(ajk ajkVar);

        void a(ajk ajkVar, boolean z);
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        d(false);
    }

    @Override // android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            c(au());
        }
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void E() {
        super.E();
        try {
            d(true);
        } catch (Throwable th) {
            new ml().a("Could no clean up", th);
        }
    }

    public void c(Bundle bundle) {
        this.a = bundle;
    }

    public Bundle au() {
        return this.a != null ? this.a : l();
    }

    public String av() {
        return getClass().getName();
    }

    @Override // android.support.v4.app.Fragment
    public void f() {
        super.f();
        b();
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void b() {
        View currentFocus = p().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) p().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public boolean aw() {
        ba baVarP = p();
        return baVarP == null || baVarP.isFinishing() || w() || x();
    }

    protected void a(Runnable runnable) {
        ba baVarP = p();
        if (baVarP != null) {
            baVarP.runOnUiThread(runnable);
        } else {
            mm.b("Activity has already finished, not running %s", runnable);
        }
    }

    public void a(a aVar) {
        brw.a(aVar, "listener", new Object[0]);
        this.b.add(aVar);
    }

    public void b(a aVar) {
        this.b.remove(aVar);
    }
}
