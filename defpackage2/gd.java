package defpackage;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class gd {
    OverScroller a;

    @Deprecated
    public static gd a(Context context) {
        return a(context, null);
    }

    @Deprecated
    public static gd a(Context context, Interpolator interpolator) {
        return new gd(context, interpolator);
    }

    gd(Context context, Interpolator interpolator) {
        this.a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public boolean a() {
        return this.a.isFinished();
    }

    @Deprecated
    public int b() {
        return this.a.getCurrX();
    }

    @Deprecated
    public int c() {
        return this.a.getCurrY();
    }

    @Deprecated
    public int d() {
        return this.a.getFinalX();
    }

    @Deprecated
    public int e() {
        return this.a.getFinalY();
    }

    @Deprecated
    public boolean f() {
        return this.a.computeScrollOffset();
    }

    @Deprecated
    public void a(int i, int i2, int i3, int i4, int i5) {
        this.a.startScroll(i, i2, i3, i4, i5);
    }

    @Deprecated
    public void g() {
        this.a.abortAnimation();
    }
}
