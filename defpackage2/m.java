package defpackage;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class m {
    static final Interpolator a = new LinearInterpolator();
    public static final Interpolator b = new fq();
    static final Interpolator c = new fp();
    static final Interpolator d = new fr();
    public static final Interpolator e = new DecelerateInterpolator();

    public static int a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }
}
