package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import net.simonvt.menudrawer.MenuDrawer;

/* JADX INFO: loaded from: classes.dex */
public class bpx extends FrameLayout {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public bpx(Context context) {
        super(context);
        this.b = true;
        this.d = true;
        if (MenuDrawer.q) {
            setLayerType(2, null);
        }
    }

    void a(boolean z) {
        this.b = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (MenuDrawer.q && this.b) {
            post(new Runnable() { // from class: bpx.1
                @Override // java.lang.Runnable
                public void run() {
                    bpx.this.a = true;
                    bpx.this.invalidate();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.a && MenuDrawer.q) {
            post(new Runnable() { // from class: bpx.2
                @Override // java.lang.Runnable
                public void run() {
                    if (bpx.this.c) {
                        if (bpx.this.getLayerType() != 2 || bpx.this.d) {
                            bpx.this.d = false;
                            bpx.this.setLayerType(2, null);
                            bpx.this.buildLayer();
                            bpx.this.setLayerType(0, null);
                        }
                    }
                }
            });
            this.a = false;
        }
    }
}
