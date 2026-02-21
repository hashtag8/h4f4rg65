package defpackage;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class arl {
    public static void a(View view, int i, int i2) {
        a(view, i, i2, HttpStatus.SC_MULTIPLE_CHOICES);
    }

    public static void a(View view, int i, int i2, int i3) {
        a(view, i, i2, i3, 0);
    }

    public static void a(final View view, int i, int i2, int i3, int i4) {
        if (i == -1) {
            i = -1;
        }
        if (i2 == -1) {
            i2 = -1;
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(Color.rgb(Color.red(i), Color.green(i), Color.blue(i))), Integer.valueOf(Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2))));
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: arl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setColorFilter(((Integer) valueAnimator.getAnimatedValue()).intValue(), PorterDuff.Mode.MULTIPLY);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        valueAnimatorOfObject.setStartDelay(i4);
        valueAnimatorOfObject.setDuration(i3);
        valueAnimatorOfObject.start();
    }
}
