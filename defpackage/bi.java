package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class bi extends ex {
    private final be a;
    private bj b = null;
    private ArrayList<Fragment.SavedState> c = new ArrayList<>();
    private ArrayList<Fragment> d = new ArrayList<>();
    private Fragment e = null;

    public abstract Fragment a(int i);

    public bi(be beVar) {
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
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.d.size() <= i || (fragment = this.d.get(i)) == null) {
            if (this.b == null) {
                this.b = this.a.a();
            }
            Fragment fragmentA = a(i);
            if (this.c.size() > i && (savedState = this.c.get(i)) != null) {
                fragmentA.a(savedState);
            }
            while (this.d.size() <= i) {
                this.d.add(null);
            }
            fragmentA.e(false);
            fragmentA.f(false);
            this.d.set(i, fragmentA);
            this.b.a(viewGroup.getId(), fragmentA);
            return fragmentA;
        }
        return fragment;
    }

    @Override // defpackage.ex
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.b == null) {
            this.b = this.a.a();
        }
        while (this.c.size() <= i) {
            this.c.add(null);
        }
        this.c.set(i, fragment.v() ? this.a.a(fragment) : null);
        this.d.set(i, null);
        this.b.a(fragment);
    }

    @Override // defpackage.ex
    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.e) {
            if (this.e != null) {
                this.e.e(false);
                this.e.f(false);
            }
            if (fragment != null) {
                fragment.e(true);
                fragment.f(true);
            }
            this.e = fragment;
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
        Bundle bundle = null;
        if (this.c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.c.size()];
            this.c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.d.size(); i++) {
            Fragment fragment = this.d.get(i);
            if (fragment != null && fragment.v()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.a.a(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    @Override // defpackage.ex
    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.c.clear();
            this.d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentA = this.a.a(bundle, str);
                    if (fragmentA != null) {
                        while (this.d.size() <= i) {
                            this.d.add(null);
                        }
                        fragmentA.e(false);
                        this.d.set(i, fragmentA);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
