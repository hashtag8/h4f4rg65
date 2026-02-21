package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class agt {
    private static int c = 0;
    public static int a = 160;
    public static int b = HttpStatus.SC_OK;

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public static void a(ViewGroup viewGroup, int i, int i2, c cVar) {
        a(viewGroup, i, 1.3f, i2, 1000, 100, c, 0, cVar, -1);
    }

    public static void a(final ViewGroup viewGroup, final int i, float f, int i2, int i3, int i4, int i5, int i6, final c cVar, int i7) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i8 = 0;
        final int i9 = 0;
        while (i9 < i) {
            final ImageView imageView = new ImageView(viewGroup.getContext());
            Drawable drawable = viewGroup.getContext().getResources().getDrawable(i2);
            if (i7 != -1) {
                drawable.setColorFilter(Color.rgb(Color.red(i7), Color.green(i7), Color.blue(i7)), PorterDuff.Mode.MULTIPLY);
            }
            imageView.setBackground(drawable);
            viewGroup.addView(imageView, 0, layoutParams);
            viewGroup.setAnimationCacheEnabled(true);
            viewGroup.setDrawingCacheEnabled(true);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 0.0f, f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 0.0f, f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView, "alpha", 0.8f, 0.0f);
            objectAnimatorOfFloat3.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(i3);
            imageView.setAlpha(0.0f);
            if (i5 > c && i9 % i5 == 0) {
                i8 += i3 - i6;
            }
            animatorSet.setStartDelay((i9 * i4) + r8);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: agt.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewGroup.removeView(imageView);
                    if (cVar != null && i9 == i - 1) {
                        cVar.a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewGroup.removeView(imageView);
                    if (cVar != null && i9 == i - 1) {
                        cVar.a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
            animatorSet.start();
            i9++;
            i8 = i8;
        }
    }

    public static void a(final ViewGroup viewGroup, int i, final int i2, int i3, int i4, int i5, int i6, int i7, final b bVar) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i, i);
        for (final int i8 = 0; i8 < i2; i8++) {
            final View view = new View(viewGroup.getContext());
            view.setBackgroundResource(i4);
            viewGroup.addView(view, 0, layoutParams);
            viewGroup.setAnimationCacheEnabled(true);
            viewGroup.setDrawingCacheEnabled(true);
            AnimationSet animationSet = new AnimationSet(false);
            TranslateAnimation translateAnimation = new TranslateAnimation(i6, i7, 1.0f, 1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            translateAnimation.setInterpolator(new a());
            alphaAnimation.setInterpolator(new CycleInterpolator(0.5f));
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(i5);
            animationSet.setStartOffset((i8 * i3) + 0);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: agt.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.removeView(view);
                    if (bVar != null && i8 == i2 - 1) {
                        bVar.a();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) ((0.25d * Math.tan(((double) (2.0f * f)) - 0.9424778335276408d)) + 0.5d);
        }
    }

    public static void a(final View view, final View view2, final View view3, final TypefaceTextView typefaceTextView, int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        view.setBackground(shapeDrawable);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.85f, 1.0f, 0.85f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setInterpolator(new CycleInterpolator(0.5f));
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(1000L);
        scaleAnimation2.setInterpolator(new CycleInterpolator(0.5f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        final AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation3);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setStartOffset(650L);
        animationSet.setDuration(350L);
        typefaceTextView.setTextColor(i);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: agt.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view2.startAnimation(scaleAnimation2);
                view.startAnimation(animationSet);
                typefaceTextView.setTypeface(ahu.b(view3.getContext()));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                typefaceTextView.setTypeface(ahu.a(view3.getContext()));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                view2.startAnimation(scaleAnimation2);
                view.startAnimation(animationSet);
            }
        });
        view3.startAnimation(scaleAnimation);
    }

    public static void a(View view, int i, int i2, int i3, float f) {
        a(view, i, i2, i3, f, null);
    }

    public static void a(final View view, int i, int i2, int i3, float f, final c cVar) {
        Drawable drawable = view.getContext().getResources().getDrawable(i);
        if (i3 != -1) {
            drawable.setColorFilter(Color.rgb(Color.red(i3), Color.green(i3), Color.blue(i3)), PorterDuff.Mode.MULTIPLY);
        }
        view.setBackground(drawable);
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 0.0f, f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(i2);
        view.setVisibility(0);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: agt.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
                if (cVar != null) {
                    cVar.a();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
    }
}
