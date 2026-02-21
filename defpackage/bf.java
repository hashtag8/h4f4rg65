package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.support.v8.renderscript.Allocation;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import defpackage.be;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class bf extends be implements LayoutInflater.Factory2 {
    ArrayList<h> B;
    bg C;
    ArrayList<f> b;
    boolean c;
    public SparseArray<Fragment> f;
    ArrayList<av> g;
    ArrayList<Fragment> h;
    ArrayList<av> i;
    ArrayList<Integer> j;
    ArrayList<be.c> k;
    public bd m;
    bb n;
    Fragment o;
    Fragment p;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    ArrayList<av> w;
    ArrayList<Boolean> x;
    ArrayList<Fragment> y;
    public static boolean a = false;
    static Field q = null;
    static final Interpolator E = new DecelerateInterpolator(2.5f);
    static final Interpolator F = new DecelerateInterpolator(1.5f);
    static final Interpolator G = new AccelerateInterpolator(2.5f);
    static final Interpolator H = new AccelerateInterpolator(1.5f);
    int d = 0;
    final ArrayList<Fragment> e = new ArrayList<>();
    private final CopyOnWriteArrayList<ed<be.b, Boolean>> I = new CopyOnWriteArrayList<>();
    int l = 0;
    Bundle z = null;
    SparseArray<Parcelable> A = null;
    Runnable D = new Runnable() { // from class: bf.1
        @Override // java.lang.Runnable
        public void run() {
            bf.this.i();
        }
    };

    static class e {
        public static final int[] a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    interface f {
        boolean a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2);
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (cVar.a instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) cVar.a).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(cVar.b);
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
            return false;
        }
        if (!(animator instanceof AnimatorSet)) {
            return false;
        }
        ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
        for (int i = 0; i < childAnimations.size(); i++) {
            if (a(childAnimations.get(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && fb.p(view) && a(cVar);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new dy("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    @Override // defpackage.be
    public bj a() {
        return new av(this);
    }

    @Override // defpackage.be
    public boolean b() {
        boolean zI = i();
        E();
        return zI;
    }

    @Override // defpackage.be
    public void c() {
        a((f) new g(null, -1, 0), false);
    }

    @Override // defpackage.be
    public boolean d() {
        B();
        return a((String) null, -1, 0);
    }

    @Override // defpackage.be
    public void a(String str, int i) {
        a((f) new g(str, -1, i), false);
    }

    @Override // defpackage.be
    public boolean b(String str, int i) {
        B();
        return a(str, -1, i);
    }

    @Override // defpackage.be
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((f) new g(null, i, i2), false);
    }

    private boolean a(String str, int i, int i2) {
        be beVarT;
        i();
        c(true);
        if (this.p != null && i < 0 && str == null && (beVarT = this.p.t()) != null && beVarT.d()) {
            return true;
        }
        boolean zA = a(this.w, this.x, str, i, i2);
        if (zA) {
            this.c = true;
            try {
                b(this.w, this.x);
            } finally {
                D();
            }
        }
        j();
        G();
        return zA;
    }

    @Override // defpackage.be
    public int e() {
        if (this.g != null) {
            return this.g.size();
        }
        return 0;
    }

    @Override // defpackage.be
    public be.a a(int i) {
        return this.g.get(i);
    }

    @Override // defpackage.be
    public void a(be.c cVar) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        this.k.add(cVar);
    }

    @Override // defpackage.be
    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.n < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.n);
    }

    @Override // defpackage.be
    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = this.f.get(i);
        if (fragment == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    @Override // defpackage.be
    public List<Fragment> f() {
        List<Fragment> list;
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    @Override // defpackage.be
    public Fragment.SavedState a(Fragment fragment) {
        Bundle bundleO;
        if (fragment.n < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.k <= 0 || (bundleO = o(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleO);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Allocation.USAGE_SHARED);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.o != null) {
            dx.a(this.o, sb);
        } else {
            dx.a(this.m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // defpackage.be
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f != null && (size5 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragmentValueAt);
                if (fragmentValueAt != null) {
                    fragmentValueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment = this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.h != null && (size4 = this.h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment2 = this.h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.g != null && (size3 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                av avVar = this.g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(avVar.toString());
                avVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (av) this.i.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null && (size = this.b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (f) this.b.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(E);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    c a(Fragment fragment, int i, boolean z, int i2) {
        int iB;
        boolean z2;
        int iAb = fragment.ab();
        Animation animationA = fragment.a(i, z, iAb);
        if (animationA != null) {
            return new c(animationA);
        }
        Animator animatorB = fragment.b(i, z, iAb);
        if (animatorB != null) {
            return new c(animatorB);
        }
        if (iAb != 0) {
            boolean zEquals = "anim".equals(this.m.g().getResources().getResourceTypeName(iAb));
            if (!zEquals) {
                z2 = false;
            } else {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.m.g(), iAb);
                    if (animationLoadAnimation != null) {
                        return new c(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException e3) {
                    z2 = false;
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.m.g(), iAb);
                    if (animatorLoadAnimator != null) {
                        return new c(animatorLoadAnimator);
                    }
                } catch (RuntimeException e4) {
                    if (zEquals) {
                        throw e4;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), iAb);
                    if (animationLoadAnimation2 != null) {
                        return new c(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i != 0 && (iB = b(i, z)) >= 0) {
            switch (iB) {
                case 1:
                    return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return a(this.m.g(), 0.0f, 1.0f);
                case 6:
                    return a(this.m.g(), 1.0f, 0.0f);
                default:
                    if (i2 == 0 && this.m.d()) {
                        i2 = this.m.e();
                    }
                    return i2 == 0 ? null : null;
            }
        }
        return null;
    }

    public void b(Fragment fragment) {
        if (fragment.S) {
            if (this.c) {
                this.v = true;
            } else {
                fragment.S = false;
                a(fragment, this.l, 0, 0, false);
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a(view, cVar)) {
            if (cVar.b != null) {
                cVar.b.addListener(new d(view));
                return;
            }
            Animation.AnimationListener animationListenerA = a(cVar.a);
            view.setLayerType(2, null);
            cVar.a.setAnimationListener(new a(view, animationListenerA));
        }
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            return null;
        }
    }

    public boolean b(int i) {
        return this.l >= i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    void a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void a(final Fragment fragment, c cVar, int i) {
        final View view = fragment.Q;
        fragment.c(i);
        if (cVar.a != null) {
            Animation animation = cVar.a;
            fragment.a_(fragment.Q);
            animation.setAnimationListener(new b(a(animation)) { // from class: bf.2
                @Override // bf.b, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    super.onAnimationEnd(animation2);
                    if (fragment.ag() != null) {
                        fragment.a_(null);
                        bf.this.a(fragment, fragment.ai(), 0, 0, false);
                    }
                }
            });
            b(view, cVar);
            fragment.Q.startAnimation(animation);
            return;
        }
        Animator animator = cVar.b;
        fragment.a(cVar.b);
        final ViewGroup viewGroup = fragment.P;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: bf.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (fragment.ah() != null) {
                    fragment.a((Animator) null);
                    bf.this.a(fragment, fragment.ai(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.Q);
        b(fragment.Q, cVar);
        animator.start();
    }

    void c(Fragment fragment) {
        a(fragment, this.l, 0, 0, false);
    }

    void d(Fragment fragment) {
        if (fragment.v && !fragment.y) {
            fragment.Q = fragment.b(fragment.h(fragment.l), (ViewGroup) null, fragment.l);
            if (fragment.Q != null) {
                fragment.R = fragment.Q;
                fragment.Q.setSaveFromParentEnabled(false);
                if (fragment.I) {
                    fragment.Q.setVisibility(8);
                }
                fragment.a(fragment.Q, fragment.l);
                a(fragment, fragment.Q, fragment.l, false);
                return;
            }
            fragment.R = null;
        }
    }

    void e(final Fragment fragment) {
        if (fragment.Q != null) {
            c cVarA = a(fragment, fragment.ac(), !fragment.I, fragment.ad());
            if (cVarA != null && cVarA.b != null) {
                cVarA.b.setTarget(fragment.Q);
                if (fragment.I) {
                    if (fragment.ak()) {
                        fragment.k(false);
                    } else {
                        final ViewGroup viewGroup = fragment.P;
                        final View view = fragment.Q;
                        viewGroup.startViewTransition(view);
                        cVarA.b.addListener(new AnimatorListenerAdapter() { // from class: bf.4
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.Q != null) {
                                    fragment.Q.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    fragment.Q.setVisibility(0);
                }
                b(fragment.Q, cVarA);
                cVarA.b.start();
            } else {
                if (cVarA != null) {
                    b(fragment.Q, cVarA);
                    fragment.Q.startAnimation(cVarA.a);
                    cVarA.a.start();
                }
                fragment.Q.setVisibility((!fragment.I || fragment.ak()) ? 0 : 8);
                if (fragment.ak()) {
                    fragment.k(false);
                }
            }
        }
        if (fragment.t && fragment.M && fragment.N) {
            this.r = true;
        }
        fragment.Z = false;
        fragment.d(fragment.I);
    }

    void f(Fragment fragment) {
        if (fragment != null) {
            int iMin = this.l;
            if (fragment.u) {
                if (fragment.j()) {
                    iMin = Math.min(iMin, 1);
                } else {
                    iMin = Math.min(iMin, 0);
                }
            }
            a(fragment, iMin, fragment.ac(), fragment.ad(), false);
            if (fragment.Q != null) {
                Fragment fragmentQ = q(fragment);
                if (fragmentQ != null) {
                    View view = fragmentQ.Q;
                    ViewGroup viewGroup = fragment.P;
                    int iIndexOfChild = viewGroup.indexOfChild(view);
                    int iIndexOfChild2 = viewGroup.indexOfChild(fragment.Q);
                    if (iIndexOfChild2 < iIndexOfChild) {
                        viewGroup.removeViewAt(iIndexOfChild2);
                        viewGroup.addView(fragment.Q, iIndexOfChild);
                    }
                }
                if (fragment.Y && fragment.P != null) {
                    if (fragment.aa > 0.0f) {
                        fragment.Q.setAlpha(fragment.aa);
                    }
                    fragment.aa = 0.0f;
                    fragment.Y = false;
                    c cVarA = a(fragment, fragment.ac(), true, fragment.ad());
                    if (cVarA != null) {
                        b(fragment.Q, cVarA);
                        if (cVarA.a != null) {
                            fragment.Q.startAnimation(cVarA.a);
                        } else {
                            cVarA.b.setTarget(fragment.Q);
                            cVarA.b.start();
                        }
                    }
                }
            }
            if (fragment.Z) {
                e(fragment);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r7, boolean r8) {
        /*
            r6 = this;
            r3 = 0
            bd r0 = r6.m
            if (r0 != 0) goto Lf
            if (r7 == 0) goto Lf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No activity"
            r0.<init>(r1)
            throw r0
        Lf:
            if (r8 != 0) goto L16
            int r0 = r6.l
            if (r7 != r0) goto L16
        L15:
            return
        L16:
            r6.l = r7
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f
            if (r0 == 0) goto L15
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.e
            int r4 = r0.size()
            r2 = r3
            r1 = r3
        L24:
            if (r2 >= r4) goto L41
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.e
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            r6.f(r0)
            bn r5 = r0.U
            if (r5 == 0) goto L8f
            bn r0 = r0.U
            boolean r0 = r0.a()
            r0 = r0 | r1
        L3c:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L24
        L41:
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f
            int r4 = r0.size()
            r2 = r3
        L48:
            if (r2 >= r4) goto L73
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f
            java.lang.Object r0 = r0.valueAt(r2)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            if (r0 == 0) goto L8d
            boolean r5 = r0.u
            if (r5 != 0) goto L5c
            boolean r5 = r0.J
            if (r5 == 0) goto L8d
        L5c:
            boolean r5 = r0.Y
            if (r5 != 0) goto L8d
            r6.f(r0)
            bn r5 = r0.U
            if (r5 == 0) goto L8d
            bn r0 = r0.U
            boolean r0 = r0.a()
            r0 = r0 | r1
        L6e:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L48
        L73:
            if (r1 != 0) goto L78
            r6.h()
        L78:
            boolean r0 = r6.r
            if (r0 == 0) goto L15
            bd r0 = r6.m
            if (r0 == 0) goto L15
            int r0 = r6.l
            r1 = 5
            if (r0 != r1) goto L15
            bd r0 = r6.m
            r0.c()
            r6.r = r3
            goto L15
        L8d:
            r0 = r1
            goto L6e
        L8f:
            r0 = r1
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf.a(int, boolean):void");
    }

    void h() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    Fragment fragmentValueAt = this.f.valueAt(i2);
                    if (fragmentValueAt != null) {
                        b(fragmentValueAt);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void g(Fragment fragment) {
        if (fragment.n < 0) {
            int i = this.d;
            this.d = i + 1;
            fragment.a(i, this.o);
            if (this.f == null) {
                this.f = new SparseArray<>();
            }
            this.f.put(fragment.n, fragment);
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void h(Fragment fragment) {
        if (fragment.n >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f.put(fragment.n, null);
            this.m.a(fragment.o);
            fragment.F();
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        g(fragment);
        if (!fragment.J) {
            if (this.e.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            synchronized (this.e) {
                this.e.add(fragment);
            }
            fragment.t = true;
            fragment.u = false;
            if (fragment.Q == null) {
                fragment.Z = false;
            }
            if (fragment.M && fragment.N) {
                this.r = true;
            }
            if (z) {
                c(fragment);
            }
        }
    }

    public void i(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.z);
        }
        boolean z = !fragment.j();
        if (!fragment.J || z) {
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (fragment.M && fragment.N) {
                this.r = true;
            }
            fragment.t = false;
            fragment.u = true;
        }
    }

    public void j(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.I) {
            fragment.I = true;
            fragment.Z = fragment.Z ? false : true;
        }
    }

    public void k(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.I) {
            fragment.I = false;
            fragment.Z = fragment.Z ? false : true;
        }
    }

    public void l(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.J) {
            fragment.J = true;
            if (fragment.t) {
                if (a) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                synchronized (this.e) {
                    this.e.remove(fragment);
                }
                if (fragment.M && fragment.N) {
                    this.r = true;
                }
                fragment.t = false;
            }
        }
    }

    public void m(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.J) {
            fragment.J = false;
            if (!fragment.t) {
                if (this.e.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.e) {
                    this.e.add(fragment);
                }
                fragment.t = true;
                if (fragment.M && fragment.N) {
                    this.r = true;
                }
            }
        }
    }

    public Fragment c(int i) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null && fragment.F == i) {
                return fragment;
            }
        }
        if (this.f != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragmentValueAt = this.f.valueAt(size2);
                if (fragmentValueAt != null && fragmentValueAt.F == i) {
                    return fragmentValueAt;
                }
            }
        }
        return null;
    }

    @Override // defpackage.be
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                Fragment fragment = this.e.get(size);
                if (fragment != null && str.equals(fragment.H)) {
                    return fragment;
                }
            }
        }
        if (this.f != null && str != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragmentValueAt = this.f.valueAt(size2);
                if (fragmentValueAt != null && str.equals(fragmentValueAt.H)) {
                    return fragmentValueAt;
                }
            }
        }
        return null;
    }

    public Fragment b(String str) {
        Fragment fragmentA;
        if (this.f != null && str != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                Fragment fragmentValueAt = this.f.valueAt(size);
                if (fragmentValueAt != null && (fragmentA = fragmentValueAt.a(str)) != null) {
                    return fragmentA;
                }
            }
        }
        return null;
    }

    private void B() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    @Override // defpackage.be
    public boolean g() {
        return this.s;
    }

    public void a(f fVar, boolean z) {
        if (!z) {
            B();
        }
        synchronized (this) {
            if (this.t || this.m == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                this.b.add(fVar);
                C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        synchronized (this) {
            boolean z = (this.B == null || this.B.isEmpty()) ? false : true;
            boolean z2 = this.b != null && this.b.size() == 1;
            if (z || z2) {
                this.m.h().removeCallbacks(this.D);
                this.m.h().post(this.D);
            }
        }
    }

    public int a(av avVar) {
        int size;
        synchronized (this) {
            if (this.j == null || this.j.size() <= 0) {
                if (this.i == null) {
                    this.i = new ArrayList<>();
                }
                size = this.i.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + avVar);
                }
                this.i.add(avVar);
            } else {
                size = this.j.remove(this.j.size() - 1).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + avVar);
                }
                this.i.set(size, avVar);
            }
        }
        return size;
    }

    public void a(int i, av avVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + avVar);
                }
                this.i.set(i, avVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + avVar);
                }
                this.i.add(avVar);
            }
        }
    }

    public void d(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            B();
        }
        if (this.w == null) {
            this.w = new ArrayList<>();
            this.x = new ArrayList<>();
        }
        this.c = true;
        try {
            a((ArrayList<av>) null, (ArrayList<Boolean>) null);
        } finally {
            this.c = false;
        }
    }

    public void b(f fVar, boolean z) {
        if (!z || (this.m != null && !this.t)) {
            c(z);
            if (fVar.a(this.w, this.x)) {
                this.c = true;
                try {
                    b(this.w, this.x);
                } finally {
                    D();
                }
            }
            j();
            G();
        }
    }

    private void D() {
        this.c = false;
        this.x.clear();
        this.w.clear();
    }

    public boolean i() {
        c(true);
        boolean z = false;
        while (c(this.w, this.x)) {
            this.c = true;
            try {
                b(this.w, this.x);
                D();
                z = true;
            } catch (Throwable th) {
                D();
                throw th;
            }
        }
        j();
        G();
        return z;
    }

    private void a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        int i = 0;
        int size = this.B == null ? 0 : this.B.size();
        while (i < size) {
            h hVar = this.B.get(i);
            if (arrayList != null && !hVar.a && (iIndexOf2 = arrayList.indexOf(hVar.b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                hVar.e();
            } else if (hVar.c() || (arrayList != null && hVar.b.a(arrayList, 0, arrayList.size()))) {
                this.B.remove(i);
                i--;
                size--;
                if (arrayList != null && !hVar.a && (iIndexOf = arrayList.indexOf(hVar.b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    hVar.e();
                } else {
                    hVar.d();
                }
            }
            i++;
            size = size;
        }
    }

    private void b(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        int i2 = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i3 = 0;
            while (i2 < size) {
                if (arrayList.get(i2).u) {
                    i = i2;
                } else {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    int i4 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i4 < size && arrayList2.get(i4).booleanValue() && !arrayList.get(i4).u) {
                            i4++;
                        }
                    }
                    int i5 = i4;
                    a(arrayList, arrayList2, i2, i5);
                    i3 = i5;
                    i = i5 - 1;
                }
                i2 = i + 1;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
            }
        }
    }

    private void a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int iA;
        Fragment fragmentB;
        boolean z = arrayList.get(i).u;
        if (this.y == null) {
            this.y = new ArrayList<>();
        } else {
            this.y.clear();
        }
        this.y.addAll(this.e);
        int i3 = i;
        Fragment fragmentZ = z();
        boolean z2 = false;
        while (i3 < i2) {
            av avVar = arrayList.get(i3);
            if (!arrayList2.get(i3).booleanValue()) {
                fragmentB = avVar.a(this.y, fragmentZ);
            } else {
                fragmentB = avVar.b(this.y, fragmentZ);
            }
            i3++;
            fragmentZ = fragmentB;
            z2 = z2 || avVar.j;
        }
        this.y.clear();
        if (!z) {
            bk.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            dv<Fragment> dvVar = new dv<>();
            b(dvVar);
            iA = a(arrayList, arrayList2, i, i2, dvVar);
            a(dvVar);
        } else {
            iA = i2;
        }
        if (iA != i && z) {
            bk.a(this, arrayList, arrayList2, i, iA, true);
            a(this.l, true);
        }
        while (i < i2) {
            av avVar2 = arrayList.get(i);
            if (arrayList2.get(i).booleanValue() && avVar2.n >= 0) {
                d(avVar2.n);
                avVar2.n = -1;
            }
            avVar2.c();
            i++;
        }
        if (z2) {
            k();
        }
    }

    private void a(dv<Fragment> dvVar) {
        int size = dvVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentB = dvVar.b(i);
            if (!fragmentB.t) {
                View viewB = fragmentB.B();
                fragmentB.aa = viewB.getAlpha();
                viewB.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, dv<Fragment> dvVar) {
        int i3;
        int i4 = i2 - 1;
        int i5 = i2;
        while (i4 >= i) {
            av avVar = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (avVar.h() && !avVar.a(arrayList, i4 + 1, i2)) {
                if (this.B == null) {
                    this.B = new ArrayList<>();
                }
                h hVar = new h(avVar, zBooleanValue);
                this.B.add(hVar);
                avVar.a(hVar);
                if (zBooleanValue) {
                    avVar.g();
                } else {
                    avVar.b(false);
                }
                int i6 = i5 - 1;
                if (i4 != i6) {
                    arrayList.remove(i4);
                    arrayList.add(i6, avVar);
                }
                b(dvVar);
                i3 = i6;
            } else {
                i3 = i5;
            }
            i4--;
            i5 = i3;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(av avVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            avVar.b(z3);
        } else {
            avVar.g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(avVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            bk.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.Q != null && fragmentValueAt.Y && avVar.b(fragmentValueAt.G)) {
                    if (fragmentValueAt.aa > 0.0f) {
                        fragmentValueAt.Q.setAlpha(fragmentValueAt.aa);
                    }
                    if (z3) {
                        fragmentValueAt.aa = 0.0f;
                    } else {
                        fragmentValueAt.aa = -1.0f;
                        fragmentValueAt.Y = false;
                    }
                }
            }
        }
    }

    private Fragment q(Fragment fragment) {
        ViewGroup viewGroup = fragment.P;
        View view = fragment.Q;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int iIndexOf = this.e.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
            Fragment fragment2 = this.e.get(iIndexOf);
            if (fragment2.P == viewGroup && fragment2.Q != null) {
                return fragment2;
            }
        }
        return null;
    }

    private static void b(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            av avVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                avVar.a(-1);
                avVar.b(i == i2 + (-1));
            } else {
                avVar.a(1);
                avVar.g();
            }
            i++;
        }
    }

    private void b(dv<Fragment> dvVar) {
        if (this.l >= 1) {
            int iMin = Math.min(this.l, 4);
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = this.e.get(i);
                if (fragment.k < iMin) {
                    a(fragment, iMin, fragment.ab(), fragment.ac(), false);
                    if (fragment.Q != null && !fragment.I && fragment.Y) {
                        dvVar.add(fragment);
                    }
                }
            }
        }
    }

    private void E() {
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                this.B.remove(0).d();
            }
        }
    }

    private void F() {
        int size = this.f == null ? 0 : this.f.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentValueAt = this.f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.ag() != null) {
                    int iAi = fragmentValueAt.ai();
                    View viewAg = fragmentValueAt.ag();
                    fragmentValueAt.a_(null);
                    Animation animation = viewAg.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewAg.clearAnimation();
                    }
                    a(fragmentValueAt, iAi, 0, 0, false);
                } else if (fragmentValueAt.ah() != null) {
                    fragmentValueAt.ah().end();
                }
            }
        }
    }

    private boolean c(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.b == null || this.b.size() == 0) {
                return false;
            }
            int size = this.b.size();
            boolean zA = false;
            for (int i = 0; i < size; i++) {
                zA |= this.b.get(i).a(arrayList, arrayList2);
            }
            this.b.clear();
            this.m.h().removeCallbacks(this.D);
            return zA;
        }
    }

    void j() {
        if (this.v) {
            boolean zA = false;
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.U != null) {
                    zA |= fragmentValueAt.U.a();
                }
            }
            if (!zA) {
                this.v = false;
                h();
            }
        }
    }

    void k() {
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.size()) {
                    this.k.get(i2).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void b(av avVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(avVar);
    }

    boolean a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(true);
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.g.size() - 1;
                while (size2 >= 0) {
                    av avVar = this.g.get(size2);
                    if ((str != null && str.equals(avVar.i())) || (i >= 0 && i == avVar.n)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        av avVar2 = this.g.get(size2);
                        if ((str == null || !str.equals(avVar2.i())) && (i < 0 || i != avVar2.n)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.g.size() - 1) {
                return false;
            }
            for (int size3 = this.g.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    bg l() {
        a(this.C);
        return this.C;
    }

    private static void a(bg bgVar) {
        if (bgVar != null) {
            List<Fragment> listA = bgVar.a();
            if (listA != null) {
                Iterator<Fragment> it = listA.iterator();
                while (it.hasNext()) {
                    it.next().L = true;
                }
            }
            List<bg> listB = bgVar.b();
            if (listB != null) {
                Iterator<bg> it2 = listB.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
            }
        }
    }

    void m() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        bg bgVar;
        if (this.f != null) {
            int i = 0;
            arrayList = null;
            arrayList2 = null;
            while (i < this.f.size()) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                if (fragmentValueAt != null) {
                    if (fragmentValueAt.K) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(fragmentValueAt);
                        fragmentValueAt.r = fragmentValueAt.q != null ? fragmentValueAt.q.n : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragmentValueAt);
                        }
                    }
                    if (fragmentValueAt.C != null) {
                        fragmentValueAt.C.m();
                        bgVar = fragmentValueAt.C.C;
                    } else {
                        bgVar = fragmentValueAt.D;
                    }
                    if (arrayList == null && bgVar != null) {
                        arrayList = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList.add(null);
                        }
                    }
                    arrayList3 = arrayList;
                    if (arrayList3 != null) {
                        arrayList3.add(bgVar);
                    }
                } else {
                    arrayList3 = arrayList;
                }
                i++;
                arrayList2 = arrayList2;
                arrayList = arrayList3;
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        if (arrayList2 == null && arrayList == null) {
            this.C = null;
        } else {
            this.C = new bg(arrayList2, arrayList);
        }
    }

    void n(Fragment fragment) {
        if (fragment.R != null) {
            if (this.A == null) {
                this.A = new SparseArray<>();
            } else {
                this.A.clear();
            }
            fragment.R.saveHierarchyState(this.A);
            if (this.A.size() > 0) {
                fragment.m = this.A;
                this.A = null;
            }
        }
    }

    Bundle o(Fragment fragment) {
        Bundle bundle;
        if (this.z == null) {
            this.z = new Bundle();
        }
        fragment.n(this.z);
        d(fragment, this.z, false);
        if (this.z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.z;
            this.z = null;
        }
        if (fragment.Q != null) {
            n(fragment);
        }
        if (fragment.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.m);
        }
        if (!fragment.T) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.T);
        }
        return bundle;
    }

    public Parcelable n() {
        int[] iArr;
        int size;
        boolean z;
        BackStackState[] backStackStateArr = null;
        E();
        F();
        i();
        this.s = true;
        this.C = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        int i = 0;
        boolean z2 = false;
        while (i < size2) {
            Fragment fragmentValueAt = this.f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.n < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragmentValueAt + " has cleared index: " + fragmentValueAt.n));
                }
                FragmentState fragmentState = new FragmentState(fragmentValueAt);
                fragmentStateArr[i] = fragmentState;
                if (fragmentValueAt.k > 0 && fragmentState.k == null) {
                    fragmentState.k = o(fragmentValueAt);
                    if (fragmentValueAt.q != null) {
                        if (fragmentValueAt.q.n < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragmentValueAt + " has target not in fragment manager: " + fragmentValueAt.q));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        a(fragmentState.k, "android:target_state", fragmentValueAt.q);
                        if (fragmentValueAt.s != 0) {
                            fragmentState.k.putInt("android:target_req_state", fragmentValueAt.s);
                        }
                    }
                } else {
                    fragmentState.k = fragmentValueAt.l;
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + fragmentValueAt + ": " + fragmentState.k);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            if (!a) {
                return null;
            }
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.e.get(i2).n;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.e.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.e.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.g != null && (size = this.g.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.g.get(i3));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.g.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        if (this.p != null) {
            fragmentManagerState.d = this.p.n;
        }
        fragmentManagerState.e = this.d;
        m();
        return fragmentManagerState;
    }

    public void a(Parcelable parcelable, bg bgVar) {
        List<bg> list;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                if (bgVar != null) {
                    List<Fragment> listA = bgVar.a();
                    List<bg> listB = bgVar.b();
                    int size = listA != null ? listA.size() : 0;
                    for (int i = 0; i < size; i++) {
                        Fragment fragment = listA.get(i);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        int i2 = 0;
                        while (i2 < fragmentManagerState.a.length && fragmentManagerState.a[i2].b != fragment.n) {
                            i2++;
                        }
                        if (i2 == fragmentManagerState.a.length) {
                            a(new IllegalStateException("Could not find active fragment with index " + fragment.n));
                        }
                        FragmentState fragmentState = fragmentManagerState.a[i2];
                        fragmentState.l = fragment;
                        fragment.m = null;
                        fragment.z = 0;
                        fragment.w = false;
                        fragment.t = false;
                        fragment.q = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.m.g().getClassLoader());
                            fragment.m = fragmentState.k.getSparseParcelableArray("android:view_state");
                            fragment.l = fragmentState.k;
                        }
                    }
                    list = listB;
                } else {
                    list = null;
                }
                this.f = new SparseArray<>(fragmentManagerState.a.length);
                int i3 = 0;
                while (i3 < fragmentManagerState.a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i3];
                    if (fragmentState2 != null) {
                        Fragment fragmentA = fragmentState2.a(this.m, this.n, this.o, (list == null || i3 >= list.size()) ? null : list.get(i3));
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + fragmentA);
                        }
                        this.f.put(fragmentA.n, fragmentA);
                        fragmentState2.l = null;
                    }
                    i3++;
                }
                if (bgVar != null) {
                    List<Fragment> listA2 = bgVar.a();
                    int size2 = listA2 != null ? listA2.size() : 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        Fragment fragment2 = listA2.get(i4);
                        if (fragment2.r >= 0) {
                            fragment2.q = this.f.get(fragment2.r);
                            if (fragment2.q == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.r);
                            }
                        }
                    }
                }
                this.e.clear();
                if (fragmentManagerState.b != null) {
                    for (int i5 = 0; i5 < fragmentManagerState.b.length; i5++) {
                        Fragment fragment3 = this.f.get(fragmentManagerState.b[i5]);
                        if (fragment3 == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i5]));
                        }
                        fragment3.t = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + fragment3);
                        }
                        if (this.e.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.e) {
                            this.e.add(fragment3);
                        }
                    }
                }
                if (fragmentManagerState.c != null) {
                    this.g = new ArrayList<>(fragmentManagerState.c.length);
                    for (int i6 = 0; i6 < fragmentManagerState.c.length; i6++) {
                        av avVarA = fragmentManagerState.c[i6].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + avVarA.n + "): " + avVarA);
                            PrintWriter printWriter = new PrintWriter(new dy("FragmentManager"));
                            avVarA.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(avVarA);
                        if (avVarA.n >= 0) {
                            a(avVarA.n, avVarA);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.d >= 0) {
                    this.p = this.f.get(fragmentManagerState.d);
                }
                this.d = fragmentManagerState.e;
            }
        }
    }

    private void G() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    public void a(bd bdVar, bb bbVar, Fragment fragment) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = bdVar;
        this.n = bbVar;
        this.o = fragment;
    }

    public void o() {
        this.C = null;
        this.s = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.T();
            }
        }
    }

    public void p() {
        this.s = false;
        f(1);
    }

    public void q() {
        this.s = false;
        f(2);
    }

    public void r() {
        this.s = false;
        f(4);
    }

    public void s() {
        this.s = false;
        f(5);
    }

    public void t() {
        f(4);
    }

    public void u() {
        this.s = true;
        f(3);
    }

    public void v() {
        f(2);
    }

    public void w() {
        f(1);
    }

    public void x() {
        this.t = true;
        i();
        f(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    private void f(int i) {
        try {
            this.c = true;
            a(i, false);
            this.c = false;
            i();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.i(z);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.j(z);
            }
        }
    }

    public void a(Configuration configuration) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                Fragment fragment = this.e.get(i2);
                if (fragment != null) {
                    fragment.a(configuration);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void y() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                Fragment fragment = this.e.get(i2);
                if (fragment != null) {
                    fragment.U();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        ArrayList<Fragment> arrayList = null;
        int i = 0;
        boolean z = false;
        while (i < this.e.size()) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.b(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
            }
            i++;
            z = z;
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                Fragment fragment2 = this.h.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.G();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(Menu menu) {
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(MenuItem menuItem) {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                Fragment fragment = this.e.get(i2);
                if (fragment != null) {
                    fragment.d(menu);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void p(Fragment fragment) {
        if (fragment != null && (this.f.get(fragment.n) != fragment || (fragment.B != null && fragment.r() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.p = fragment;
    }

    public Fragment z() {
        return this.p;
    }

    void a(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).a(fragment, context, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.a(this, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).b(fragment, context, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.b(this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).a(fragment, bundle, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.a(this, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).b(fragment, bundle, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.b(this, fragment, bundle);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).c(fragment, bundle, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.c(this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).a(fragment, view, bundle, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.a(this, fragment, view, bundle);
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).b(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.a(this, fragment);
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).c(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.b(this, fragment);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).d(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.c(this, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).e(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.d(this, fragment);
            }
        }
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).d(fragment, bundle, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.d(this, fragment, bundle);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).f(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.e(this, fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).g(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.f(this, fragment);
            }
        }
    }

    void h(Fragment fragment, boolean z) {
        if (this.o != null) {
            be beVarR = this.o.r();
            if (beVarR instanceof bf) {
                ((bf) beVarR).h(fragment, true);
            }
        }
        for (ed<be.b, Boolean> edVar : this.I) {
            if (!z || edVar.b.booleanValue()) {
                edVar.a.g(this, fragment);
            }
        }
    }

    public static int e(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a);
        String string = attributeValue == null ? typedArrayObtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!Fragment.a(this.m.g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragmentC = resourceId != -1 ? c(resourceId) : null;
        if (fragmentC == null && string2 != null) {
            fragmentC = a(string2);
        }
        if (fragmentC == null && id != -1) {
            fragmentC = c(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + fragmentC);
        }
        if (fragmentC == null) {
            Fragment fragmentA = this.n.a(context, string, null);
            fragmentA.v = true;
            fragmentA.F = resourceId != 0 ? resourceId : id;
            fragmentA.G = id;
            fragmentA.H = string2;
            fragmentA.w = true;
            fragmentA.A = this;
            fragmentA.B = this.m;
            fragmentA.a(this.m.g(), attributeSet, fragmentA.l);
            a(fragmentA, true);
            fragment = fragmentA;
        } else {
            if (fragmentC.w) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
            }
            fragmentC.w = true;
            fragmentC.B = this.m;
            if (!fragmentC.L) {
                fragmentC.a(this.m.g(), attributeSet, fragmentC.l);
            }
            fragment = fragmentC;
        }
        if (this.l < 1 && fragment.v) {
            a(fragment, 1, 0, 0, false);
        } else {
            c(fragment);
        }
        if (fragment.Q == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.Q.setId(resourceId);
        }
        if (fragment.Q.getTag() == null) {
            fragment.Q.setTag(string2);
        }
        return fragment.Q;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public LayoutInflater.Factory2 A() {
        return this;
    }

    class g implements f {
        final String a;
        final int b;
        final int c;

        g(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // bf.f
        public boolean a(ArrayList<av> arrayList, ArrayList<Boolean> arrayList2) {
            be beVarT;
            if (bf.this.p == null || this.b >= 0 || this.a != null || (beVarT = bf.this.p.t()) == null || !beVarT.d()) {
                return bf.this.a(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    static class h implements Fragment.c {
        private final boolean a;
        private final av b;
        private int c;

        h(av avVar, boolean z) {
            this.a = z;
            this.b = avVar;
        }

        @Override // android.support.v4.app.Fragment.c
        public void a() {
            this.c--;
            if (this.c == 0) {
                this.b.b.C();
            }
        }

        @Override // android.support.v4.app.Fragment.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            bf bfVar = this.b.b;
            int size = bfVar.e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = bfVar.e.get(i);
                fragment.a((Fragment.c) null);
                if (z && fragment.aj()) {
                    fragment.P();
                }
            }
            this.b.b.a(this.b, this.a, z ? false : true, true);
        }

        public void e() {
            this.b.b.a(this.b, this.a, false, false);
        }
    }

    static class c {
        public final Animation a;
        public final Animator b;

        private c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        private b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }
    }

    static class a extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        @Override // bf.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (fb.x(this.a) || Build.VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() { // from class: bf.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a.setLayerType(0, null);
                    }
                });
            } else {
                this.a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }
}
