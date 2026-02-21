package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ks {
    private final Context a;
    private final TypedArray b;
    private TypedValue c;

    public static ks a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ks(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ks a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ks(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static ks a(Context context, int i, int[] iArr) {
        return new ks(context, context.obtainStyledAttributes(i, iArr));
    }

    private ks(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public Drawable a(int i) {
        int resourceId;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) ? this.b.getDrawable(i) : hc.b(this.a, resourceId);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return ix.a().a(this.a, resourceId, true);
    }

    public Typeface a(int i, int i2, TextView textView) {
        int resourceId = this.b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return cm.a(this.a, resourceId, this.c, i2, textView);
    }

    public CharSequence c(int i) {
        return this.b.getText(i);
    }

    public String d(int i) {
        return this.b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0 || (colorStateListA = hc.a(this.a, resourceId)) == null) ? this.b.getColorStateList(i) : colorStateListA;
    }

    public int c(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int d(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.b.hasValue(i);
    }

    public void a() {
        this.b.recycle();
    }
}
