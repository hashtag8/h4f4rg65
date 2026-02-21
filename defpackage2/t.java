package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends ab<View> {
    protected final Rect a;
    final Rect b;
    private int c;
    private int d;

    protected abstract View b(List<View> list);

    public t() {
        this.a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.a
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewB;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (viewB = b(coordinatorLayout.c(view))) != null) {
            if (fb.o(viewB) && !fb.o(view)) {
                fb.a(view, true);
                if (fb.o(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec(b(viewB) + (size - viewB.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    @Override // defpackage.ab
    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewB = b(coordinatorLayout.c(view));
        if (viewB != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, viewB.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + viewB.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            fi lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && fb.o(coordinatorLayout) && !fb.o(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            el.a(c(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int iC = c(viewB);
            view.layout(rect2.left, rect2.top - iC, rect2.right, rect2.bottom - iC);
            this.c = rect2.top - viewB.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i);
        this.c = 0;
    }

    protected float a(View view) {
        return 1.0f;
    }

    protected final int c(View view) {
        if (this.d == 0) {
            return 0;
        }
        return df.a((int) (a(view) * this.d), 0, this.d);
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    protected int b(View view) {
        return view.getMeasuredHeight();
    }

    protected final int a() {
        return this.c;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int d() {
        return this.d;
    }
}
