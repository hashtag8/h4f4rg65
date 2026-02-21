package defpackage;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class bqd implements Interpolator {
    private static final bqh a = new bqh();

    bqd() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f < 0.33333334f) {
            return a.getInterpolation(f * 3.0f);
        }
        if (f <= 0.6666667f) {
            return 1.0f;
        }
        return 1.0f - a.getInterpolation(((f + 0.33333334f) - 1.0f) * 3.0f);
    }
}
