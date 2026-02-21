package defpackage;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.harman.hkconnect.ui.slider.SlidingTabLayout;

/* JADX INFO: loaded from: classes.dex */
public class asu extends LinearLayout {
    private final int a;
    private final Paint b;
    private final int c;
    private final Paint d;
    private final int e;
    private final Paint f;
    private final float g;
    private int h;
    private float i;
    private SlidingTabLayout.c j;
    private final a k;

    public asu(Context context) {
        this(context, null);
    }

    asu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorForeground, typedValue, true);
        int i = typedValue.data;
        this.e = a(i, (byte) 38);
        this.k = new a();
        this.k.a(-13388315);
        this.k.b(a(i, (byte) 32));
        this.a = (int) (1.0f * f);
        this.b = new Paint();
        this.b.setColor(this.e);
        this.c = (int) (3.0f * f);
        this.d = new Paint();
        this.g = 0.5f;
        this.f = new Paint();
        this.f.setStrokeWidth((int) (f * 1.0f));
    }

    public void a(SlidingTabLayout.c cVar) {
        this.j = cVar;
        invalidate();
    }

    public void a(int... iArr) {
        this.j = null;
        this.k.a(iArr);
        invalidate();
    }

    public void b(int... iArr) {
        this.j = null;
        this.k.b(iArr);
        invalidate();
    }

    public void a(int i, float f) {
        this.h = i;
        this.i = f;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int i;
        int height = getHeight();
        int childCount = getChildCount();
        int iMin = (int) (Math.min(Math.max(0.0f, this.g), 1.0f) * height);
        SlidingTabLayout.c cVar = this.j != null ? this.j : this.k;
        if (childCount > 0) {
            View childAt = getChildAt(this.h);
            int left = childAt.getLeft();
            int right2 = childAt.getRight();
            int iA = cVar.a(this.h);
            if (this.i <= 0.0f || this.h >= getChildCount() - 1) {
                right = right2;
                i = left;
            } else {
                int iA2 = cVar.a(this.h + 1);
                if (iA != iA2) {
                    iA = a(iA2, iA, this.i);
                }
                View childAt2 = getChildAt(this.h + 1);
                int left2 = (int) ((left * (1.0f - this.i)) + (this.i * childAt2.getLeft()));
                right = (int) ((right2 * (1.0f - this.i)) + (childAt2.getRight() * this.i));
                i = left2;
            }
            this.d.setColor(iA);
            canvas.drawRect(i, height - this.c, right, height, this.d);
        }
        canvas.drawRect(0.0f, height - this.a, getWidth(), height, this.b);
        int i2 = (height - iMin) / 2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < childCount - 1) {
                View childAt3 = getChildAt(i4);
                this.f.setColor(cVar.b(i4));
                canvas.drawLine(childAt3.getRight(), i2, childAt3.getRight(), i2 + iMin, this.f);
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    private static int a(int i, byte b) {
        return Color.argb((int) b, Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((Color.red(i) * f) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f) + (Color.green(i2) * f2)), (int) ((f2 * Color.blue(i2)) + (Color.blue(i) * f)));
    }

    static class a implements SlidingTabLayout.c {
        private int[] a;
        private int[] b;

        private a() {
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingTabLayout.c
        public final int a(int i) {
            return this.a[i % this.a.length];
        }

        @Override // com.harman.hkconnect.ui.slider.SlidingTabLayout.c
        public final int b(int i) {
            return this.b[i % this.b.length];
        }

        void a(int... iArr) {
            this.a = iArr;
        }

        void b(int... iArr) {
            this.b = iArr;
        }
    }
}
