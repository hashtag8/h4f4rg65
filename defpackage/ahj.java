package defpackage;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import com.harman.hkconnect.ui.custom.TypefaceTextView;

/* JADX INFO: loaded from: classes.dex */
public class ahj {
    private final ScaleAnimation a;
    private final AnimationSet b;
    private final ScaleAnimation c = new ScaleAnimation(1.0f, 0.85f, 1.0f, 0.85f, 1, 0.5f, 1, 0.5f);

    public ahj() {
        this.c.setDuration(1000L);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(1);
        this.c.setInterpolator(new CycleInterpolator(0.5f));
        this.a = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.a.setDuration(1000L);
        this.a.setRepeatCount(-1);
        this.a.setRepeatMode(1);
        this.a.setInterpolator(new CycleInterpolator(0.5f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(1);
        this.b = new AnimationSet(false);
        this.b.addAnimation(scaleAnimation);
        this.b.addAnimation(alphaAnimation);
        this.b.setStartOffset(650L);
        this.b.setDuration(350L);
    }

    public void a(View view, View view2, View view3, View view4, TypefaceTextView typefaceTextView, int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        view3.setBackground(shapeDrawable);
        typefaceTextView.setTypeface(ahu.b(view4.getContext()));
        typefaceTextView.setTextColor(i);
        if (view3.getAnimation() == null) {
            if (this.a.hasStarted()) {
                view.invalidate();
                view4.setAnimation(this.a);
                view4.invalidate();
                view3.setAnimation(this.b);
                view3.invalidate();
                view2.setAnimation(this.c);
                view2.invalidate();
                return;
            }
            view4.startAnimation(this.a);
            view3.startAnimation(this.b);
            view2.startAnimation(this.c);
        }
    }
}
