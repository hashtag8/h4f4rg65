package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class fe {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    fe(View view) {
        this.d = new WeakReference<>(view);
    }

    static class a implements ff {
        fe a;
        boolean b;

        a(fe feVar) {
            this.a = feVar;
        }

        @Override // defpackage.ff
        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ff ffVar = tag instanceof ff ? (ff) tag : null;
            if (ffVar != null) {
                ffVar.a(view);
            }
        }

        @Override // defpackage.ff
        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ff ffVar = tag instanceof ff ? (ff) tag : null;
                if (ffVar != null) {
                    ffVar.b(view);
                }
                this.b = true;
            }
        }

        @Override // defpackage.ff
        public void c(View view) {
            ff ffVar;
            Object tag = view.getTag(2113929216);
            if (!(tag instanceof ff)) {
                ffVar = null;
            } else {
                ffVar = (ff) tag;
            }
            if (ffVar != null) {
                ffVar.c(view);
            }
        }
    }

    public fe a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public fe a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public fe b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public fe a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public fe b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public fe a(ff ffVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, ffVar);
            } else {
                view.setTag(2113929216, ffVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final ff ffVar) {
        if (ffVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: fe.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ffVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ffVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ffVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public fe a(final fh fhVar) {
        final View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (fhVar != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: fe.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        fhVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
