package defpackage;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import defpackage.be;
import defpackage.bf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class av extends bj implements be.a, bf.f {
    static final boolean a;
    final bf b;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public String l;
    boolean m;
    public int o;
    public CharSequence p;
    public int q;
    public CharSequence r;
    public ArrayList<String> s;
    public ArrayList<String> t;
    ArrayList<Runnable> v;
    public ArrayList<a> c = new ArrayList<>();
    boolean k = true;
    public int n = -1;
    public boolean u = false;

    static {
        a = Build.VERSION.SDK_INT >= 21;
    }

    public static final class a {
        public int a;
        public Fragment b;
        public int c;
        public int d;
        public int e;
        public int f;

        public a() {
        }

        a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Allocation.USAGE_SHARED);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.n >= 0) {
            sb.append(" #");
            sb.append(this.n);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.n);
            printWriter.print(" mCommitted=");
            printWriter.println(this.m);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.o != 0 || this.p != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.p);
            }
            if (this.q != 0 || this.r != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.r);
            }
        }
        if (!this.c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                a aVar = this.c.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (aVar.c != 0 || aVar.d != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public av(bf bfVar) {
        this.b = bfVar;
    }

    @Override // be.a
    public int a() {
        return this.n;
    }

    public void a(a aVar) {
        this.c.add(aVar);
        aVar.c = this.d;
        aVar.d = this.e;
        aVar.e = this.f;
        aVar.f = this.g;
    }

    @Override // defpackage.bj
    public bj a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // defpackage.bj
    public bj a(int i, Fragment fragment) {
        a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // defpackage.bj
    public bj a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.A = this.b;
        if (str != null) {
            if (fragment.H != null && !str.equals(fragment.H)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.H + " now " + str);
            }
            fragment.H = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.F != 0 && fragment.F != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.F + " now " + i);
            }
            fragment.F = i;
            fragment.G = i;
        }
        a(new a(i2, fragment));
    }

    @Override // defpackage.bj
    public bj b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    @Override // defpackage.bj
    public bj a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    @Override // defpackage.bj
    public bj b(Fragment fragment) {
        a(new a(4, fragment));
        return this;
    }

    @Override // defpackage.bj
    public bj c(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    @Override // defpackage.bj
    public bj d(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    @Override // defpackage.bj
    public bj e(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    @Override // defpackage.bj
    public bj a(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        return this;
    }

    @Override // defpackage.bj
    public bj a(String str) {
        if (!this.k) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.j = true;
        this.l = str;
        return this;
    }

    public bj b() {
        if (this.j) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.k = false;
        return this;
    }

    public void a(int i) {
        if (this.j) {
            if (bf.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.c.get(i2);
                if (aVar.b != null) {
                    aVar.b.z += i;
                    if (bf.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.z);
                    }
                }
            }
        }
    }

    public void c() {
        if (this.v != null) {
            int size = this.v.size();
            for (int i = 0; i < size; i++) {
                this.v.get(i).run();
            }
            this.v = null;
        }
    }

    @Override // defpackage.bj
    public int d() {
        return a(false);
    }

    @Override // defpackage.bj
    public int e() {
        return a(true);
    }

    @Override // defpackage.bj
    public void f() {
        b();
        this.b.b((bf.f) this, true);
    }

    int a(boolean z) {
        if (this.m) {
            throw new IllegalStateException("commit already called");
        }
        if (bf.a) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new dy("FragmentManager"));
            a("  ", (FileDescriptor) null, printWriter, (String[]) null);
            printWriter.close();
        }
        this.m = true;
        if (this.j) {
            this.n = this.b.a(this);
        } else {
            this.n = -1;
        }
        this.b.a(this, z);
        return this.n;
    }

    @Override // bf.f
    public boolean a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2) {
        if (bf.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.j) {
            this.b.b(this);
            return true;
        }
        return true;
    }

    boolean b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.c.get(i2);
            int i3 = aVar.b != null ? aVar.b.G : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<av> arrayList, int i, int i2) {
        int i3;
        if (i2 == i) {
            return false;
        }
        int size = this.c.size();
        int i4 = -1;
        int i5 = 0;
        while (i5 < size) {
            a aVar = this.c.get(i5);
            int i6 = aVar.b != null ? aVar.b.G : 0;
            if (i6 == 0 || i6 == i4) {
                i3 = i4;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    av avVar = arrayList.get(i7);
                    int size2 = avVar.c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        a aVar2 = avVar.c.get(i8);
                        if ((aVar2.b != null ? aVar2.b.G : 0) == i6) {
                            return true;
                        }
                    }
                }
                i3 = i6;
            }
            i5++;
            i4 = i3;
        }
        return false;
    }

    void g() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.c.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.b(this.h, this.i);
            }
            switch (aVar.a) {
                case 1:
                    fragment.b(aVar.c);
                    this.b.a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.b(aVar.d);
                    this.b.i(fragment);
                    break;
                case 4:
                    fragment.b(aVar.d);
                    this.b.j(fragment);
                    break;
                case 5:
                    fragment.b(aVar.c);
                    this.b.k(fragment);
                    break;
                case 6:
                    fragment.b(aVar.d);
                    this.b.l(fragment);
                    break;
                case 7:
                    fragment.b(aVar.c);
                    this.b.m(fragment);
                    break;
                case 8:
                    this.b.p(fragment);
                    break;
                case 9:
                    this.b.p(null);
                    break;
            }
            if (!this.u && aVar.a != 1 && fragment != null) {
                this.b.f(fragment);
            }
        }
        if (!this.u) {
            this.b.a(this.b.l, true);
        }
    }

    void b(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            a aVar = this.c.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.b(bf.e(this.h), this.i);
            }
            switch (aVar.a) {
                case 1:
                    fragment.b(aVar.f);
                    this.b.i(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.b(aVar.e);
                    this.b.a(fragment, false);
                    break;
                case 4:
                    fragment.b(aVar.e);
                    this.b.k(fragment);
                    break;
                case 5:
                    fragment.b(aVar.f);
                    this.b.j(fragment);
                    break;
                case 6:
                    fragment.b(aVar.e);
                    this.b.m(fragment);
                    break;
                case 7:
                    fragment.b(aVar.f);
                    this.b.l(fragment);
                    break;
                case 8:
                    this.b.p(null);
                    break;
                case 9:
                    this.b.p(fragment);
                    break;
            }
            if (!this.u && aVar.a != 3 && fragment != null) {
                this.b.f(fragment);
            }
        }
        if (!this.u && z) {
            this.b.a(this.b.l, true);
        }
    }

    Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                a aVar = this.c.get(i2);
                switch (aVar.a) {
                    case 1:
                    case 7:
                        arrayList.add(aVar.b);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.b;
                        int i3 = fragment2.G;
                        boolean z2 = false;
                        int size = arrayList.size() - 1;
                        Fragment fragment3 = fragment;
                        int i4 = i2;
                        while (size >= 0) {
                            Fragment fragment4 = arrayList.get(size);
                            if (fragment4.G != i3) {
                                z = z2;
                            } else if (fragment4 == fragment2) {
                                z = true;
                            } else {
                                if (fragment4 == fragment3) {
                                    this.c.add(i4, new a(9, fragment4));
                                    i4++;
                                    fragment3 = null;
                                }
                                a aVar2 = new a(3, fragment4);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.c.add(i4, aVar2);
                                arrayList.remove(fragment4);
                                i4++;
                                z = z2;
                            }
                            size--;
                            z2 = z;
                        }
                        if (z2) {
                            this.c.remove(i4);
                            i4--;
                        } else {
                            aVar.a = 1;
                            arrayList.add(fragment2);
                        }
                        i2 = i4;
                        fragment = fragment3;
                        break;
                    case 3:
                    case 6:
                        arrayList.remove(aVar.b);
                        if (aVar.b == fragment) {
                            this.c.add(i2, new a(9, aVar.b));
                            i2++;
                            fragment = null;
                        }
                        break;
                    case 8:
                        this.c.add(i2, new a(9, fragment));
                        i2++;
                        fragment = aVar.b;
                        break;
                }
                i = i2 + 1;
            } else {
                return fragment;
            }
        }
    }

    Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                a aVar = this.c.get(i2);
                switch (aVar.a) {
                    case 1:
                    case 7:
                        arrayList.remove(aVar.b);
                        break;
                    case 3:
                    case 6:
                        arrayList.add(aVar.b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.b;
                        break;
                }
                i = i2 + 1;
            } else {
                return fragment;
            }
        }
    }

    boolean h() {
        for (int i = 0; i < this.c.size(); i++) {
            if (b(this.c.get(i))) {
                return true;
            }
        }
        return false;
    }

    void a(Fragment.c cVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                a aVar = this.c.get(i2);
                if (b(aVar)) {
                    aVar.b.a(cVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static boolean b(a aVar) {
        Fragment fragment = aVar.b;
        return (fragment == null || !fragment.t || fragment.Q == null || fragment.J || fragment.I || !fragment.aj()) ? false : true;
    }

    @Override // be.a
    public String i() {
        return this.l;
    }
}
