package defpackage;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class beg extends Animation {
    public static final boolean a;
    private static final WeakHashMap<View, beg> b;
    private final WeakReference<View> c;
    private boolean e;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float n;
    private float o;
    private final Camera d = new Camera();
    private float f = 1.0f;
    private float l = 1.0f;
    private float m = 1.0f;
    private final RectF p = new RectF();
    private final RectF q = new RectF();
    private final Matrix r = new Matrix();

    static {
        a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        b = new WeakHashMap<>();
    }

    public static beg a(View view) {
        beg begVar = b.get(view);
        if (begVar == null || begVar != view.getAnimation()) {
            beg begVar2 = new beg(view);
            b.put(view, begVar2);
            return begVar2;
        }
        return begVar;
    }

    private beg(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.c = new WeakReference<>(view);
    }

    public void a(float f) {
        if (this.o != f) {
            a();
            this.o = f;
            b();
        }
    }

    private void a() {
        View view = this.c.get();
        if (view != null) {
            a(this.p, view);
        }
    }

    private void b() {
        View view = this.c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.q;
            a(rectF, view);
            rectF.union(this.p);
            ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.r;
        matrix.reset();
        a(matrix, view);
        this.r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    private void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.e;
        float f = z ? this.g : width / 2.0f;
        float f2 = z ? this.h : height / 2.0f;
        float f3 = this.i;
        float f4 = this.j;
        float f5 = this.k;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.l;
        float f7 = this.m;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.n, this.o);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        View view = this.c.get();
        if (view != null) {
            transformation.setAlpha(this.f);
            a(transformation.getMatrix(), view);
        }
    }
}
