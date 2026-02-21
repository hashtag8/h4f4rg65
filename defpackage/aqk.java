package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class aqk extends ex {
    private final FragmentManager a;
    private FragmentTransaction b;
    private ArrayList<Fragment.SavedState> c;
    private eh<Fragment> d;
    private Fragment e;
    private boolean f;

    public abstract Fragment a(int i);

    public aqk(FragmentManager fragmentManager) {
        this(fragmentManager, true);
    }

    public aqk(FragmentManager fragmentManager, boolean z) {
        this.b = null;
        this.c = new ArrayList<>();
        this.d = new eh<>();
        this.e = null;
        this.a = fragmentManager;
        this.f = z;
    }

    @Override // defpackage.ex
    public void a(ViewGroup viewGroup) {
    }

    @Override // defpackage.ex
    public Object a(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragmentA = this.d.a(i);
        if (fragmentA == null) {
            if (this.b == null) {
                this.b = this.a.beginTransaction();
            }
            Fragment fragmentA2 = a(i);
            if (this.f && this.c.size() > i && (savedState = this.c.get(i)) != null) {
                fragmentA2.setInitialSavedState(savedState);
            }
            if (fragmentA2 != this.e) {
                a(fragmentA2, false);
            }
            this.d.b(i, fragmentA2);
            this.b.add(viewGroup.getId(), fragmentA2);
            return fragmentA2;
        }
        return fragmentA;
    }

    @Override // defpackage.ex
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.b == null) {
            this.b = this.a.beginTransaction();
        }
        if (this.f) {
            while (this.c.size() <= i) {
                this.c.add(null);
            }
            this.c.set(i, this.a.saveFragmentInstanceState(fragment));
        }
        this.d.b(i);
        this.b.remove(fragment);
        viewGroup.removeView(fragment.getView());
    }

    @Override // defpackage.ex
    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.e) {
            if (this.e != null) {
                a(this.e, false);
            }
            if (fragment != null) {
                a(fragment, true);
            }
            this.e = fragment;
        }
    }

    @Override // defpackage.ex
    public void b(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.commitAllowingStateLoss();
            this.b = null;
            this.a.executePendingTransactions();
        }
    }

    @Override // defpackage.ex
    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // defpackage.ex
    public Parcelable a() {
        Bundle bundle = null;
        if (this.f && this.c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.c.size()];
            this.c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.d.b(); i++) {
            int iD = this.d.d(i);
            Fragment fragmentE = this.d.e(i);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            this.a.putFragment(bundle2, "f" + iD, fragmentE);
        }
        return bundle2;
    }

    @Override // defpackage.ex
    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            this.d.c();
            if (this.f) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("states");
                this.c.clear();
                if (parcelableArray != null) {
                    for (Parcelable parcelable2 : parcelableArray) {
                        this.c.add((Fragment.SavedState) parcelable2);
                    }
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.a.getFragment(bundle, str);
                    if (fragment != null) {
                        a(fragment, false);
                        this.d.b(i, fragment);
                    } else {
                        mm.d("FSPA", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        as.a(fragment, z);
        as.b(fragment, z);
    }

    @Override // defpackage.ex
    public void c() {
        eh<Fragment> ehVar = new eh<>(this.d.b());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.b()) {
                int iD = this.d.d(i2);
                Fragment fragmentE = this.d.e(i2);
                int iA = a(fragmentE);
                if (iA != -2) {
                    if (iA < 0) {
                        iA = iD;
                    }
                    ehVar.b(iA, fragmentE);
                }
                i = i2 + 1;
            } else {
                this.d = ehVar;
                super.c();
                return;
            }
        }
    }
}
