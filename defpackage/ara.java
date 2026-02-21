package defpackage;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes.dex */
public class ara {
    private final Context a;
    private final View b;
    private Runnable c;

    public ara(Context context, View view, Runnable runnable) {
        this.a = context;
        this.b = view;
        this.c = runnable;
    }

    public void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -ahn.a(this.a, 10.0f));
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ara.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ara.this.c != null) {
                    ara.this.c.run();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new CycleInterpolator(0.5f));
        this.b.startAnimation(translateAnimation);
    }

    public void b() {
        this.c = null;
        this.b.clearAnimation();
    }
}
