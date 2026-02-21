package defpackage;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class bqg {
    private static final float t = (float) (Math.log(0.75d) / Math.log(0.9d));
    private static final float[] u = new float[101];
    private static float x;
    private static float y;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private Interpolator r;
    private boolean s;
    private float v;
    private final float w;

    static {
        float f;
        float f2;
        float f3 = 0.0f;
        int i = 0;
        while (i <= 100) {
            float f4 = i / 100.0f;
            float f5 = 1.0f;
            float f6 = f3;
            while (true) {
                f = ((f5 - f6) / 2.0f) + f6;
                f2 = 3.0f * f * (1.0f - f);
                float f7 = ((((1.0f - f) * 0.4f) + (0.6f * f)) * f2) + (f * f * f);
                if (Math.abs(f7 - f4) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f;
                } else {
                    f6 = f;
                }
            }
            u[i] = (f * f * f) + f2;
            i++;
            f3 = f6;
        }
        u[100] = 1.0f;
        x = 8.0f;
        y = 1.0f;
        y = 1.0f / a(1.0f);
    }

    public bqg(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public bqg(Context context, Interpolator interpolator, boolean z) {
        this.q = true;
        this.r = interpolator;
        this.w = context.getResources().getDisplayMetrics().density * 160.0f;
        this.v = b(ViewConfiguration.getScrollFriction());
        this.s = z;
    }

    private float b(float f) {
        return 386.0878f * this.w * f;
    }

    public final boolean a() {
        return this.q;
    }

    public final int b() {
        return this.j;
    }

    public final int c() {
        return this.d;
    }

    public boolean d() {
        float interpolation;
        if (this.q) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
        if (iCurrentAnimationTimeMillis < this.m) {
            switch (this.a) {
                case 0:
                    float f = iCurrentAnimationTimeMillis * this.n;
                    if (this.r == null) {
                        interpolation = a(f);
                    } else {
                        interpolation = this.r.getInterpolation(f);
                    }
                    this.j = this.b + Math.round(this.o * interpolation);
                    this.k = Math.round(interpolation * this.p) + this.c;
                    break;
                case 1:
                    float f2 = iCurrentAnimationTimeMillis / this.m;
                    int i = (int) (100.0f * f2);
                    float f3 = i / 100.0f;
                    float f4 = u[i];
                    float f5 = (((f2 - f3) / (((i + 1) / 100.0f) - f3)) * (u[i + 1] - f4)) + f4;
                    this.j = this.b + Math.round((this.d - this.b) * f5);
                    this.j = Math.min(this.j, this.g);
                    this.j = Math.max(this.j, this.f);
                    this.k = Math.round(f5 * (this.e - this.c)) + this.c;
                    this.k = Math.min(this.k, this.i);
                    this.k = Math.max(this.k, this.h);
                    if (this.j == this.d && this.k == this.e) {
                        this.q = true;
                    }
                    break;
            }
        } else {
            this.j = this.d;
            this.k = this.e;
            this.q = true;
        }
        return true;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.a = 0;
        this.q = false;
        this.m = i5;
        this.l = AnimationUtils.currentAnimationTimeMillis();
        this.b = i;
        this.c = i2;
        this.d = i + i3;
        this.e = i2 + i4;
        this.o = i3;
        this.p = i4;
        this.n = 1.0f / this.m;
    }

    static float a(float f) {
        float fExp;
        float f2 = x * f;
        if (f2 < 1.0f) {
            fExp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            fExp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return fExp * y;
    }

    public void e() {
        this.j = this.d;
        this.k = this.e;
        this.q = true;
    }
}
