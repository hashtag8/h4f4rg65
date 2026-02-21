package defpackage;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class bh extends ex {
    private final be a;
    private bj b = null;
    private Fragment c = null;

    public abstract Fragment a(int i);

    public bh(be beVar) {
        this.a = beVar;
    }

    @Override // defpackage.ex
    public void a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Override // defpackage.ex
    public Object a(ViewGroup viewGroup, int i) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        long jB = b(i);
        Fragment fragmentA = this.a.a(a(viewGroup.getId(), jB));
        if (fragmentA != null) {
            this.b.e(fragmentA);
        } else {
            fragmentA = a(i);
            this.b.a(viewGroup.getId(), fragmentA, a(viewGroup.getId(), jB));
        }
        if (fragmentA != this.c) {
            fragmentA.e(false);
            fragmentA.f(false);
        }
        return fragmentA;
    }

    @Override // defpackage.ex
    public void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        this.b.d((Fragment) obj);
    }

    @Override // defpackage.ex
    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.c) {
            if (this.c != null) {
                this.c.e(false);
                this.c.f(false);
            }
            if (fragment != null) {
                fragment.e(true);
                fragment.f(true);
            }
            this.c = fragment;
        }
    }

    @Override // defpackage.ex
    public void b(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
    }

    @Override // defpackage.ex
    public boolean a(View view, Object obj) {
        return ((Fragment) obj).B() == view;
    }

    @Override // defpackage.ex
    public Parcelable a() {
        return null;
    }

    @Override // defpackage.ex
    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long b(int i) {
        return i;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
