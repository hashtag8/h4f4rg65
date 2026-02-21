package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import net.simonvt.menudrawer.MenuDrawer;

/* JADX INFO: loaded from: classes.dex */
public class bql extends MenuDrawer {
    public bql(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Context context, AttributeSet attributeSet, int i) {
        super.a(context, attributeSet, i);
        super.addView(this.C, -1, new ViewGroup.LayoutParams(-1, -1));
        super.addView(this.D, -1, new ViewGroup.LayoutParams(-1, -1));
        this.U = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.simonvt.menudrawer.MenuDrawer
    public void b(int i) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        switch (getPosition()) {
            case LEFT:
                this.C.layout(0, 0, this.E, i6);
                this.D.layout(this.E, 0, i5, i6);
                break;
            case RIGHT:
                this.C.layout(i5 - this.E, 0, i5, i6);
                this.D.layout(0, 0, i5 - this.E, i6);
                break;
            case TOP:
                this.C.layout(0, 0, i5, this.E);
                this.D.layout(0, this.E, i5, i6);
                break;
            case BOTTOM:
                this.C.layout(0, i6 - this.E, i5, i6);
                this.D.layout(0, 0, i5, i6 - this.E);
                break;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("Must measure with an exact size");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        switch (getPosition()) {
            case LEFT:
            case RIGHT:
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                int i3 = this.E;
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                this.D.measure(View.MeasureSpec.makeMeasureSpec(size - i3, 1073741824), iMakeMeasureSpec);
                this.C.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                break;
            case TOP:
            case BOTTOM:
                int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                int i4 = this.E;
                int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                this.D.measure(iMakeMeasureSpec3, View.MeasureSpec.makeMeasureSpec(size2 - i4, 1073741824));
                this.C.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                break;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void a(boolean z) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void b(boolean z) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public boolean a() {
        return true;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setMenuSize(int i) {
        this.E = i;
        requestLayout();
        invalidate();
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setOffsetMenuEnabled(boolean z) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public boolean getOffsetMenuEnabled() {
        return false;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setHardwareLayerEnabled(boolean z) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public int getTouchMode() {
        return 0;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setTouchMode(int i) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setTouchBezelSize(int i) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public int getTouchBezelSize() {
        return 0;
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setSlideDrawable(int i) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setSlideDrawable(Drawable drawable) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setupUpIndicator(Activity activity) {
    }

    @Override // net.simonvt.menudrawer.MenuDrawer
    public void setDrawerIndicatorEnabled(boolean z) {
    }
}
