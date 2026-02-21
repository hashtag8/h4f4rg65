package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public final class fx {
    private static final b b;
    private EdgeEffect a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            b = new a();
        } else {
            b = new b();
        }
    }

    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static class a extends b {
        a() {
        }

        @Override // fx.b
        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    @Deprecated
    public fx(Context context) {
        this.a = new EdgeEffect(context);
    }

    @Deprecated
    public void a(int i, int i2) {
        this.a.setSize(i, i2);
    }

    @Deprecated
    public boolean a() {
        return this.a.isFinished();
    }

    @Deprecated
    public boolean a(float f) {
        this.a.onPull(f);
        return true;
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        b.a(edgeEffect, f, f2);
    }

    @Deprecated
    public boolean b() {
        this.a.onRelease();
        return this.a.isFinished();
    }

    @Deprecated
    public boolean a(int i) {
        this.a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean a(Canvas canvas) {
        return this.a.draw(canvas);
    }
}
