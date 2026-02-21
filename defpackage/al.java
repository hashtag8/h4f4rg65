package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class al implements Interpolator {
    private float[] a;
    private float[] b;

    public al(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public al(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.l);
        a(typedArrayA, xmlPullParser);
        typedArrayA.recycle();
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (cn.a(xmlPullParser, "pathData")) {
            String strA = cn.a(typedArray, xmlPullParser, "pathData", 4);
            Path pathA = cp.a(strA);
            if (pathA == null) {
                throw new InflateException("The path is null, which is created from " + strA);
            }
            a(pathA);
            return;
        }
        if (!cn.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!cn.a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fA = cn.a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fA2 = cn.a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zA = cn.a(xmlPullParser, "controlX2");
        if (zA != cn.a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (!zA) {
            a(fA, fA2);
        } else {
            a(fA, fA2, cn.a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), cn.a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        }
    }

    private void a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        a(path);
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.a = new float[iMin];
        this.b = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.a[i2] = fArr[0];
            this.b[i2] = fArr[1];
        }
        if (Math.abs(this.a[0]) > 1.0E-5d || Math.abs(this.b[0]) > 1.0E-5d || Math.abs(this.a[iMin - 1] - 1.0f) > 1.0E-5d || Math.abs(this.b[iMin - 1] - 1.0f) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[iMin - 1] + "," + this.b[iMin - 1]);
        }
        float f = 0.0f;
        int i3 = 0;
        while (i < iMin) {
            int i4 = i3 + 1;
            float f2 = this.a[i3];
            if (f2 < f) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
            }
            this.a[i] = f2;
            i++;
            f = f2;
            i3 = i4;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f < this.a[i3]) {
                i = i2;
            } else {
                int i4 = length;
                i = i3;
                i3 = i4;
            }
            i2 = i;
            length = i3;
        }
        float f2 = this.a[length] - this.a[i2];
        if (f2 == 0.0f) {
            return this.b[i2];
        }
        float f3 = (f - this.a[i2]) / f2;
        float f4 = this.b[i2];
        return (f3 * (this.b[length] - f4)) + f4;
    }
}
