package defpackage;

import android.app.Fragment;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class as {
    static final e a;

    interface e {
        void a(Fragment fragment, boolean z);
    }

    static class d implements e {
        d() {
        }

        @Override // as.e
        public void a(Fragment fragment, boolean z) {
        }
    }

    static class a extends d {
        a() {
        }

        @Override // as.d, as.e
        public void a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }

        @Override // as.a, as.d, as.e
        public void a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new d();
        }
    }

    @Deprecated
    public static void a(Fragment fragment, boolean z) {
        fragment.setMenuVisibility(z);
    }

    public static void b(Fragment fragment, boolean z) {
        a.a(fragment, z);
    }
}
