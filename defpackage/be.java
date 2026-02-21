package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class be {

    public interface a {
        int a();

        String i();
    }

    public interface c {
        void a();
    }

    public abstract Fragment.SavedState a(Fragment fragment);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract a a(int i);

    public abstract bj a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(c cVar);

    public abstract void a(String str, int i);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract boolean b(String str, int i);

    public abstract void c();

    public abstract boolean d();

    public abstract int e();

    public abstract List<Fragment> f();

    public abstract boolean g();

    public static abstract class b {
        public void a(be beVar, Fragment fragment, Context context) {
        }

        public void b(be beVar, Fragment fragment, Context context) {
        }

        public void a(be beVar, Fragment fragment, Bundle bundle) {
        }

        public void b(be beVar, Fragment fragment, Bundle bundle) {
        }

        public void c(be beVar, Fragment fragment, Bundle bundle) {
        }

        public void a(be beVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void a(be beVar, Fragment fragment) {
        }

        public void b(be beVar, Fragment fragment) {
        }

        public void c(be beVar, Fragment fragment) {
        }

        public void d(be beVar, Fragment fragment) {
        }

        public void d(be beVar, Fragment fragment, Bundle bundle) {
        }

        public void e(be beVar, Fragment fragment) {
        }

        public void f(be beVar, Fragment fragment) {
        }

        public void g(be beVar, Fragment fragment) {
        }
    }
}
