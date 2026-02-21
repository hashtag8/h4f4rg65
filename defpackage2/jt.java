package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.View;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
class jt extends kb {
    private boolean g;
    private boolean h;
    private boolean i;
    private fe j;
    private fz k;

    public jt(Context context, boolean z) {
        super(context, null, ha.a.dropDownListViewStyle);
        this.h = z;
        setCacheColorHint(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MotionEvent r9, int r10) {
        /*
            r8 = this;
            r2 = 1
            r1 = 0
            int r3 = r9.getActionMasked()
            switch(r3) {
                case 1: goto L2d;
                case 2: goto L6a;
                case 3: goto L2a;
                default: goto L9;
            }
        L9:
            r0 = r1
            r3 = r2
        Lb:
            if (r3 == 0) goto Lf
            if (r0 == 0) goto L12
        Lf:
            r8.d()
        L12:
            if (r3 == 0) goto L60
            fz r0 = r8.k
            if (r0 != 0) goto L1f
            fz r0 = new fz
            r0.<init>(r8)
            r8.k = r0
        L1f:
            fz r0 = r8.k
            r0.a(r2)
            fz r0 = r8.k
            r0.onTouch(r8, r9)
        L29:
            return r3
        L2a:
            r0 = r1
            r3 = r1
            goto Lb
        L2d:
            r0 = r1
        L2e:
            int r4 = r9.findPointerIndex(r10)
            if (r4 >= 0) goto L37
            r0 = r1
            r3 = r1
            goto Lb
        L37:
            float r5 = r9.getX(r4)
            int r5 = (int) r5
            float r4 = r9.getY(r4)
            int r4 = (int) r4
            int r6 = r8.pointToPosition(r5, r4)
            r7 = -1
            if (r6 != r7) goto L4b
            r3 = r0
            r0 = r2
            goto Lb
        L4b:
            int r0 = r8.getFirstVisiblePosition()
            int r0 = r6 - r0
            android.view.View r0 = r8.getChildAt(r0)
            float r5 = (float) r5
            float r4 = (float) r4
            r8.a(r0, r6, r5, r4)
            if (r3 != r2) goto L9
            r8.a(r0, r6)
            goto L9
        L60:
            fz r0 = r8.k
            if (r0 == 0) goto L29
            fz r0 = r8.k
            r0.a(r1)
            goto L29
        L6a:
            r0 = r2
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jt.a(android.view.MotionEvent, int):boolean");
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.g = z;
    }

    private void d() {
        this.i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.j != null) {
            this.j.b();
            this.j = null;
        }
    }

    private void a(View view, int i, float f, float f2) {
        View childAt;
        this.i = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1 && (childAt = getChildAt(this.f - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // defpackage.kb
    protected boolean a() {
        return this.i || super.a();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.h && this.g) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.h || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.h || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.h || super.hasFocus();
    }
}
