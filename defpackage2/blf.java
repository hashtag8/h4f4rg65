package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class blf {
    private final Application a;
    private a b;

    public static abstract class b {
        public void a(Activity activity, Bundle bundle) {
        }

        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void e(Activity activity) {
        }
    }

    public blf(Context context) {
        this.a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.b = new a(this.a);
        }
    }

    public boolean a(b bVar) {
        return this.b != null && this.b.a(bVar);
    }

    public void a() {
        if (this.b == null) {
            return;
        }
        this.b.a();
    }

    static class a {
        private final Set<Application.ActivityLifecycleCallbacks> a = new HashSet();
        private final Application b;

        a(Application application) {
            this.b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public void a() {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                this.b.unregisterActivityLifecycleCallbacks(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public boolean a(final b bVar) {
            if (this.b == null) {
                return false;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: blf.a.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    bVar.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    bVar.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    bVar.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    bVar.d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    bVar.e(activity);
                }
            };
            this.b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.a.add(activityLifecycleCallbacks);
            return true;
        }
    }
}
