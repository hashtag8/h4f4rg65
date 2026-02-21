package defpackage;

import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class bqa {
    private float a;
    private float b;
    private float c;
    private long d;
    private int e;
    private float f;
    private float g;
    private boolean h = true;
    private Interpolator i;

    public bqa(Interpolator interpolator) {
        this.i = interpolator;
    }

    public final boolean a() {
        return this.h;
    }

    public final float b() {
        return this.c;
    }

    public boolean c() {
        if (this.h) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.d);
        if (iCurrentAnimationTimeMillis < this.e) {
            this.c = (this.i.getInterpolation(iCurrentAnimationTimeMillis * this.f) * this.g) + this.a;
            return true;
        }
        this.c = this.b;
        this.h = true;
        return true;
    }

    public void a(float f, float f2, int i) {
        this.h = false;
        this.e = i;
        this.d = AnimationUtils.currentAnimationTimeMillis();
        this.a = f;
        this.b = f + f2;
        this.g = f2;
        this.f = 1.0f / this.e;
    }
}
