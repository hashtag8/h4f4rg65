package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import defpackage.k;
import defpackage.n;
import defpackage.w;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<B extends n<B>> {
    static final Handler a;
    private static final boolean d;
    final f b;
    final w.a c;
    private final ViewGroup e;
    private final c f;
    private List<a<B>> g;
    private final AccessibilityManager h;

    public interface c {
        void a(int i, int i2);

        void b(int i, int i2);
    }

    interface d {
        void a(View view);

        void b(View view);
    }

    interface e {
        void a(View view, int i, int i2, int i3, int i4);
    }

    public static abstract class a<B> {
        public void a(B b, int i) {
        }

        public void a(B b) {
        }
    }

    static {
        d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: n.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((n) message.obj).b();
                        break;
                    case 1:
                        ((n) message.obj).b(message.arg1);
                        break;
                }
                return true;
            }
        });
    }

    void a(int i) {
        w.a().a(this.c, i);
    }

    public boolean a() {
        return w.a().e(this.c);
    }

    final void b() {
        if (this.b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                b bVar = new b();
                bVar.a(0.1f);
                bVar.b(0.6f);
                bVar.a(0);
                bVar.a(new SwipeDismissBehavior.a() { // from class: n.5
                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public void a(View view) {
                        view.setVisibility(8);
                        n.this.a(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                w.a().d(n.this.c);
                                break;
                            case 1:
                            case 2:
                                w.a().c(n.this.c);
                                break;
                        }
                    }
                });
                dVar.a(bVar);
                dVar.g = 80;
            }
            this.e.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new d() { // from class: n.6
            @Override // n.d
            public void a(View view) {
            }

            @Override // n.d
            public void b(View view) {
                if (n.this.a()) {
                    n.a.post(new Runnable() { // from class: n.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.c(3);
                        }
                    });
                }
            }
        });
        if (fb.v(this.b)) {
            if (e()) {
                c();
                return;
            } else {
                d();
                return;
            }
        }
        this.b.setOnLayoutChangeListener(new e() { // from class: n.7
            @Override // n.e
            public void a(View view, int i, int i2, int i3, int i4) {
                n.this.b.setOnLayoutChangeListener(null);
                if (n.this.e()) {
                    n.this.c();
                } else {
                    n.this.d();
                }
            }
        });
    }

    void c() {
        if (Build.VERSION.SDK_INT >= 12) {
            final int height = this.b.getHeight();
            if (d) {
                fb.d(this.b, height);
            } else {
                this.b.setTranslationY(height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(height, 0);
            valueAnimator.setInterpolator(m.b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: n.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    n.this.f.a(70, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    n.this.d();
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: n.9
                private int c;

                {
                    this.c = height;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (n.d) {
                        fb.d(n.this.b, iIntValue - this.c);
                    } else {
                        n.this.b.setTranslationY(iIntValue);
                    }
                    this.c = iIntValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), k.a.design_snackbar_in);
        animationLoadAnimation.setInterpolator(m.b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: n.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                n.this.d();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.b.startAnimation(animationLoadAnimation);
    }

    private void d(final int i) {
        if (Build.VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(0, this.b.getHeight());
            valueAnimator.setInterpolator(m.b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: n.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    n.this.f.b(0, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    n.this.c(i);
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: n.3
                private int b = 0;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (n.d) {
                        fb.d(n.this.b, iIntValue - this.b);
                    } else {
                        n.this.b.setTranslationY(iIntValue);
                    }
                    this.b = iIntValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), k.a.design_snackbar_out);
        animationLoadAnimation.setInterpolator(m.b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: n.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                n.this.c(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.b.startAnimation(animationLoadAnimation);
    }

    final void b(int i) {
        if (e() && this.b.getVisibility() == 0) {
            d(i);
        } else {
            c(i);
        }
    }

    void d() {
        w.a().b(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                this.g.get(size).a(this);
            }
        }
    }

    void c(int i) {
        w.a().a(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                this.g.get(size).a(this, i);
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.b.setVisibility(8);
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    boolean e() {
        return !this.h.isEnabled();
    }

    public static class f extends FrameLayout {
        private e a;
        private d b;

        protected f(Context context) {
            this(context, null);
        }

        protected f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.i.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(k.i.SnackbarLayout_elevation)) {
                fb.a(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(k.i.SnackbarLayout_elevation, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            setClickable(true);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.a != null) {
                this.a.a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.b != null) {
                this.b.a(this);
            }
            fb.n(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.b != null) {
                this.b.b(this);
            }
        }

        void setOnLayoutChangeListener(e eVar) {
            this.a = eVar;
        }

        void setOnAttachStateChangeListener(d dVar) {
            this.b = dVar;
        }
    }

    final class b extends SwipeDismissBehavior<f> {
        b() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean a(View view) {
            return view instanceof f;
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.a
        public boolean a(CoordinatorLayout coordinatorLayout, f fVar, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.a(fVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        w.a().c(n.this.c);
                    }
                    break;
                case 1:
                case 3:
                    w.a().d(n.this.c);
                    break;
            }
            return super.a(coordinatorLayout, fVar, motionEvent);
        }
    }
}
