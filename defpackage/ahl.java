package defpackage;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class ahl implements View.OnClickListener {
    private WeakReference<Fragment> a;
    private WeakReference<android.app.Fragment> b;

    public abstract void a(View view);

    public ahl(Fragment fragment) {
        this.a = new WeakReference<>(fragment);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        android.app.Fragment fragment;
        Fragment fragment2;
        Activity activity = null;
        if (this.a != null && (fragment2 = this.a.get()) != null) {
            activity = fragment2.p();
        }
        if (this.b != null && (fragment = this.b.get()) != null) {
            activity = fragment.getActivity();
        }
        if (activity == null || activity.isFinishing()) {
            mm.b("Fragment already detached, not executing action", new Object[0]);
        } else {
            a(view);
        }
    }
}
