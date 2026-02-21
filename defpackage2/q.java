package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class q {
    static final Interpolator a = m.c;
    static final int[] j = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] k = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] l = {R.attr.state_enabled};
    static final int[] m = new int[0];
    u c;
    Drawable d;
    Drawable e;
    o f;
    Drawable g;
    float h;
    float i;
    final ae n;
    final v o;
    private float q;
    private ViewTreeObserver.OnPreDrawListener s;
    int b = 0;
    private final Rect r = new Rect();
    private final x p = new x();

    public interface c {
        void a();

        void b();
    }

    public q(ae aeVar, v vVar) {
        this.n = aeVar;
        this.o = vVar;
        this.p.a(j, a(new b()));
        this.p.a(k, a(new b()));
        this.p.a(l, a(new d()));
        this.p.a(m, a(new a()));
        this.q = this.n.getRotation();
    }

    public void a(ColorStateList colorStateList) {
        if (this.d != null) {
            cw.a(this.d, colorStateList);
        }
        if (this.f != null) {
            this.f.a(colorStateList);
        }
    }

    public void a(PorterDuff.Mode mode) {
        if (this.d != null) {
            cw.a(this.d, mode);
        }
    }

    public void a(int i) {
        if (this.e != null) {
            cw.a(this.e, b(i));
        }
    }

    public final void a(float f) {
        if (this.h != f) {
            this.h = f;
            a(f, this.i);
        }
    }

    public float a() {
        return this.h;
    }

    void a(float f, float f2) {
        if (this.c != null) {
            this.c.a(f, this.i + f);
            e();
        }
    }

    public void a(int[] iArr) {
        this.p.a(iArr);
    }

    public void b() {
        this.p.a();
    }

    public void a(final c cVar, final boolean z) {
        if (!k()) {
            this.n.animate().cancel();
            if (m()) {
                this.b = 1;
                this.n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(m.c).setListener(new AnimatorListenerAdapter() { // from class: q.1
                    private boolean d;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        q.this.n.a(0, z);
                        this.d = false;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.d = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        q.this.b = 0;
                        if (!this.d) {
                            q.this.n.a(z ? 8 : 4, z);
                            if (cVar != null) {
                                cVar.b();
                            }
                        }
                    }
                });
            } else {
                this.n.a(z ? 8 : 4, z);
                if (cVar != null) {
                    cVar.b();
                }
            }
        }
    }

    public void b(final c cVar, final boolean z) {
        if (!j()) {
            this.n.animate().cancel();
            if (m()) {
                this.b = 2;
                if (this.n.getVisibility() != 0) {
                    this.n.setAlpha(0.0f);
                    this.n.setScaleY(0.0f);
                    this.n.setScaleX(0.0f);
                }
                this.n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(m.d).setListener(new AnimatorListenerAdapter() { // from class: q.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        q.this.n.a(0, z);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        q.this.b = 0;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }
                });
                return;
            }
            this.n.a(0, z);
            this.n.setAlpha(1.0f);
            this.n.setScaleY(1.0f);
            this.n.setScaleX(1.0f);
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final Drawable c() {
        return this.g;
    }

    public void d() {
    }

    public final void e() {
        Rect rect = this.r;
        a(rect);
        b(rect);
        this.o.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void a(Rect rect) {
        this.c.getPadding(rect);
    }

    void b(Rect rect) {
    }

    public void f() {
        if (h()) {
            l();
            this.n.getViewTreeObserver().addOnPreDrawListener(this.s);
        }
    }

    public void g() {
        if (this.s != null) {
            this.n.getViewTreeObserver().removeOnPreDrawListener(this.s);
            this.s = null;
        }
    }

    boolean h() {
        return true;
    }

    void i() {
        float rotation = this.n.getRotation();
        if (this.q != rotation) {
            this.q = rotation;
            n();
        }
    }

    private void l() {
        if (this.s == null) {
            this.s = new ViewTreeObserver.OnPreDrawListener() { // from class: q.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    q.this.i();
                    return true;
                }
            };
        }
    }

    boolean j() {
        return this.n.getVisibility() != 0 ? this.b == 2 : this.b != 1;
    }

    boolean k() {
        return this.n.getVisibility() == 0 ? this.b == 1 : this.b != 2;
    }

    private ValueAnimator a(e eVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(eVar);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    abstract class e extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float c;
        private float d;

        protected abstract float a();

        private e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                this.c = q.this.c.a();
                this.d = a();
                this.a = true;
            }
            q.this.c.b(this.c + ((this.d - this.c) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q.this.c.b(this.d);
            this.a = false;
        }
    }

    class d extends e {
        d() {
            super();
        }

        @Override // q.e
        protected float a() {
            return q.this.h;
        }
    }

    class b extends e {
        b() {
            super();
        }

        @Override // q.e
        protected float a() {
            return q.this.h + q.this.i;
        }
    }

    class a extends e {
        a() {
            super();
        }

        @Override // q.e
        protected float a() {
            return 0.0f;
        }
    }

    private static ColorStateList b(int i) {
        return new ColorStateList(new int[][]{k, j, new int[0]}, new int[]{i, i, 0});
    }

    private boolean m() {
        return fb.v(this.n) && !this.n.isInEditMode();
    }

    private void n() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.q % 90.0f != 0.0f) {
                if (this.n.getLayerType() != 1) {
                    this.n.setLayerType(1, null);
                }
            } else if (this.n.getLayerType() != 0) {
                this.n.setLayerType(0, null);
            }
        }
        if (this.c != null) {
            this.c.a(-this.q);
        }
        if (this.f != null) {
            this.f.a(-this.q);
        }
    }
}
