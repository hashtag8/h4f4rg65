package defpackage;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class fb {
    static final j a;

    static class j {
        static Field b;
        static boolean c = false;
        private static Field d;
        private static boolean e;
        private static Field f;
        private static boolean g;
        private static WeakHashMap<View, String> h;
        WeakHashMap<View, fe> a = null;

        j() {
        }

        public void a(View view, ei eiVar) {
            view.setAccessibilityDelegate(eiVar == null ? null : eiVar.a());
        }

        public boolean z(View view) {
            if (c) {
                return false;
            }
            if (b == null) {
                try {
                    b = View.class.getDeclaredField("mAccessibilityDelegate");
                    b.setAccessible(true);
                } catch (Throwable th) {
                    c = true;
                    return false;
                }
            }
            try {
                return b.get(view) != null;
            } catch (Throwable th2) {
                c = true;
                return false;
            }
        }

        public boolean b(View view) {
            return false;
        }

        public void c(View view) {
            view.postInvalidate();
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        long a() {
            return ValueAnimator.getFrameDelay();
        }

        public int d(View view) {
            return 0;
        }

        public void a(View view, int i) {
        }

        public int j(View view) {
            return 0;
        }

        public int k(View view) {
            return view.getPaddingLeft();
        }

        public int l(View view) {
            return view.getPaddingRight();
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean i(View view) {
            return true;
        }

        public int e(View view) {
            if (!e) {
                try {
                    d = View.class.getDeclaredField("mMinWidth");
                    d.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                }
                e = true;
            }
            if (d != null) {
                try {
                    return ((Integer) d.get(view)).intValue();
                } catch (Exception e3) {
                }
            }
            return 0;
        }

        public int f(View view) {
            if (!g) {
                try {
                    f = View.class.getDeclaredField("mMinHeight");
                    f.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                }
                g = true;
            }
            if (f != null) {
                try {
                    return ((Integer) f.get(view)).intValue();
                } catch (Exception e3) {
                }
            }
            return 0;
        }

        public fe A(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap<>();
            }
            fe feVar = this.a.get(view);
            if (feVar == null) {
                fe feVar2 = new fe(view);
                this.a.put(view, feVar2);
                return feVar2;
            }
            return feVar;
        }

        public String r(View view) {
            if (h == null) {
                return null;
            }
            return h.get(view);
        }

        public int m(View view) {
            return 0;
        }

        public void g(View view) {
        }

        public void a(View view, float f2) {
        }

        public float s(View view) {
            return 0.0f;
        }

        public float t(View view) {
            return 0.0f;
        }

        public boolean h(View view) {
            return false;
        }

        public void a(View view, ew ewVar) {
        }

        public fi a(View view, fi fiVar) {
            return fiVar;
        }

        public fi b(View view, fi fiVar) {
            return fiVar;
        }

        public boolean n(View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean u(View view) {
            if (view instanceof eq) {
                return ((eq) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ColorStateList w(View view) {
            if (view instanceof ez) {
                return ((ez) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof ez) {
                ((ez) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(View view, PorterDuff.Mode mode) {
            if (view instanceof ez) {
                ((ez) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PorterDuff.Mode x(View view) {
            if (view instanceof ez) {
                return ((ez) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void v(View view) {
            if (view instanceof eq) {
                ((eq) view).stopNestedScroll();
            }
        }

        public boolean p(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public float y(View view) {
            return t(view) + s(view);
        }

        public boolean q(View view) {
            return view.getWindowToken() != null;
        }

        public boolean a(View view) {
            return false;
        }

        public void a(View view, int i, int i2) {
        }

        public void b(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                B(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    B((View) parent);
                }
            }
        }

        public void c(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                B(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    B((View) parent);
                }
            }
        }

        private static void B(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public void a(View view, ey eyVar) {
        }

        public Display o(View view) {
            if (q(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
    }

    static class a extends j {
        a() {
        }

        @Override // fb.j
        public boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class b extends a {
        b() {
        }

        @Override // fb.j
        public boolean b(View view) {
            return view.hasTransientState();
        }

        @Override // fb.j
        public void c(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // fb.j
        public void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // fb.j
        public void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // fb.j
        public int d(View view) {
            return view.getImportantForAccessibility();
        }

        @Override // fb.j
        public void a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        @Override // fb.j
        public int e(View view) {
            return view.getMinimumWidth();
        }

        @Override // fb.j
        public int f(View view) {
            return view.getMinimumHeight();
        }

        @Override // fb.j
        public void g(View view) {
            view.requestFitSystemWindows();
        }

        @Override // fb.j
        public boolean h(View view) {
            return view.getFitsSystemWindows();
        }

        @Override // fb.j
        public boolean i(View view) {
            return view.hasOverlappingRendering();
        }

        @Override // fb.j
        public void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // fb.j
        public int j(View view) {
            return view.getLayoutDirection();
        }

        @Override // fb.j
        public int k(View view) {
            return view.getPaddingStart();
        }

        @Override // fb.j
        public int l(View view) {
            return view.getPaddingEnd();
        }

        @Override // fb.j
        public void a(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        @Override // fb.j
        public int m(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @Override // fb.j
        public boolean n(View view) {
            return view.isPaddingRelative();
        }

        @Override // fb.j
        public Display o(View view) {
            return view.getDisplay();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        @Override // fb.b, fb.j
        public void a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        @Override // fb.j
        public boolean p(View view) {
            return view.isLaidOut();
        }

        @Override // fb.j
        public boolean q(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        private static ThreadLocal<Rect> d;

        f() {
        }

        @Override // fb.j
        public String r(View view) {
            return view.getTransitionName();
        }

        @Override // fb.b, fb.j
        public void g(View view) {
            view.requestApplyInsets();
        }

        @Override // fb.j
        public void a(View view, float f) {
            view.setElevation(f);
        }

        @Override // fb.j
        public float s(View view) {
            return view.getElevation();
        }

        @Override // fb.j
        public float t(View view) {
            return view.getTranslationZ();
        }

        @Override // fb.j
        public void a(View view, final ew ewVar) {
            if (ewVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: fb.f.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) fi.a(ewVar.a(view2, fi.a(windowInsets)));
                    }
                });
            }
        }

        @Override // fb.j
        public boolean u(View view) {
            return view.isNestedScrollingEnabled();
        }

        @Override // fb.j
        public void v(View view) {
            view.stopNestedScroll();
        }

        @Override // fb.j
        public ColorStateList w(View view) {
            return view.getBackgroundTintList();
        }

        @Override // fb.j
        public void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        @Override // fb.j
        public void a(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        @Override // fb.j
        public PorterDuff.Mode x(View view) {
            return view.getBackgroundTintMode();
        }

        @Override // fb.j
        public fi a(View view, fi fiVar) {
            WindowInsets windowInsets = (WindowInsets) fi.a(fiVar);
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (windowInsetsOnApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
            }
            return fi.a(windowInsets);
        }

        @Override // fb.j
        public fi b(View view, fi fiVar) {
            WindowInsets windowInsets = (WindowInsets) fi.a(fiVar);
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (windowInsetsDispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
            }
            return fi.a(windowInsets);
        }

        @Override // fb.j
        public float y(View view) {
            return view.getZ();
        }

        @Override // fb.j
        public void b(View view, int i) {
            boolean z;
            Rect rectB = b();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.b(view, i);
            if (z && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectB);
            }
        }

        @Override // fb.j
        public void c(View view, int i) {
            boolean z;
            Rect rectB = b();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.c(view, i);
            if (z && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectB);
            }
        }

        private static Rect b() {
            if (d == null) {
                d = new ThreadLocal<>();
            }
            Rect rect = d.get();
            if (rect == null) {
                rect = new Rect();
                d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    static class g extends f {
        g() {
        }

        @Override // fb.j
        public void a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        @Override // fb.f, fb.j
        public void b(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // fb.f, fb.j
        public void c(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static class h extends g {
        h() {
        }

        @Override // fb.j
        public void a(View view, ey eyVar) {
            view.setPointerIcon((PointerIcon) (eyVar != null ? eyVar.a() : null));
        }
    }

    static class i extends h {
        i() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            a = new g();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new f();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new e();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new j();
        }
    }

    @Deprecated
    public static boolean a(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    @Deprecated
    public static int a(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static void b(View view, int i2) {
        view.setOverScrollMode(i2);
    }

    public static void a(View view, ei eiVar) {
        a.a(view, eiVar);
    }

    public static boolean b(View view) {
        return a.z(view);
    }

    public static boolean c(View view) {
        return a.b(view);
    }

    public static void d(View view) {
        a.c(view);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        a.a(view, runnable, j2);
    }

    public static int e(View view) {
        return a.d(view);
    }

    public static void c(View view, int i2) {
        a.a(view, i2);
    }

    public static int f(View view) {
        return a.j(view);
    }

    public static int g(View view) {
        return a.k(view);
    }

    public static int h(View view) {
        return a.l(view);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        a.a(view, i2, i3, i4, i5);
    }

    public static int i(View view) {
        return a.e(view);
    }

    public static int j(View view) {
        return a.f(view);
    }

    public static fe k(View view) {
        return a.A(view);
    }

    public static void a(View view, float f2) {
        a.a(view, f2);
    }

    public static String l(View view) {
        return a.r(view);
    }

    public static int m(View view) {
        return a.m(view);
    }

    public static void n(View view) {
        a.g(view);
    }

    public static boolean o(View view) {
        return a.h(view);
    }

    @Deprecated
    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, ew ewVar) {
        a.a(view, ewVar);
    }

    public static fi a(View view, fi fiVar) {
        return a.a(view, fiVar);
    }

    public static fi b(View view, fi fiVar) {
        return a.b(view, fiVar);
    }

    public static boolean p(View view) {
        return a.i(view);
    }

    public static boolean q(View view) {
        return a.n(view);
    }

    public static void a(View view, Drawable drawable) {
        a.a(view, drawable);
    }

    public static ColorStateList r(View view) {
        return a.w(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static PorterDuff.Mode s(View view) {
        return a.x(view);
    }

    public static void a(View view, PorterDuff.Mode mode) {
        a.a(view, mode);
    }

    public static boolean t(View view) {
        return a.u(view);
    }

    public static void u(View view) {
        a.v(view);
    }

    public static boolean v(View view) {
        return a.p(view);
    }

    public static float w(View view) {
        return a.y(view);
    }

    public static void d(View view, int i2) {
        a.c(view, i2);
    }

    public static void e(View view, int i2) {
        a.b(view, i2);
    }

    public static boolean x(View view) {
        return a.q(view);
    }

    public static boolean y(View view) {
        return a.a(view);
    }

    public static void a(View view, int i2, int i3) {
        a.a(view, i2, i3);
    }

    public static void a(View view, ey eyVar) {
        a.a(view, eyVar);
    }

    public static Display z(View view) {
        return a.o(view);
    }
}
