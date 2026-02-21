package defpackage;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class bqh implements Interpolator {
    bqh() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((Math.sin((((double) f) * 3.141592653589793d) - 1.5707963267948966d) * 0.5d) + 0.5d);
    }
}
