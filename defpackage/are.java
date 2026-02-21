package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.harman.hkconnect.ui.HarmanApplication;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class are implements Application.ActivityLifecycleCallbacks {
    private WeakReference<Activity> a;

    public are(Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.a.get() == activity) {
            a(bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.a.get() == activity) {
            d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (this.a.get() == activity) {
            b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.a.get() == activity) {
            c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (this.a.get() == activity) {
            e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.a.get() == activity) {
            b(bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.a.get() == activity) {
            a();
            this.a.clear();
            HarmanApplication.a().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void a(Bundle bundle) {
    }

    public void d() {
    }

    public void b() {
    }

    public void c() {
    }

    public void e() {
    }

    public void b(Bundle bundle) {
    }

    public void a() {
    }
}
