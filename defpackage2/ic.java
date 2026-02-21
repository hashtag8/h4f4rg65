package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import defpackage.ha;
import defpackage.id;

/* JADX INFO: loaded from: classes.dex */
public class ic {
    private final Context a;
    private final hw b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private id.a i;
    private ib j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public ic(Context context, hw hwVar, View view, boolean z, int i) {
        this(context, hwVar, view, z, i, 0);
    }

    public ic(Context context, hw hwVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() { // from class: ic.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ic.this.e();
            }
        };
        this.a = context;
        this.b = hwVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.a(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ib b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private ib g() {
        ib iiVar;
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(ha.d.abc_cascading_menus_min_smallest_width)) {
            iiVar = new ht(this.a, this.f, this.d, this.e, this.c);
        } else {
            iiVar = new ii(this.a, this.b, this.f, this.d, this.e, this.c);
        }
        iiVar.a(this.b);
        iiVar.a(this.l);
        iiVar.a(this.f);
        iiVar.a(this.i);
        iiVar.a(this.h);
        iiVar.a(this.g);
        return iiVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        ib ibVarB = b();
        ibVarB.c(z2);
        if (z) {
            if ((el.a(this.g, fb.f(this.f)) & 7) == 5) {
                i += this.f.getWidth();
            }
            ibVarB.b(i);
            ibVarB.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            ibVarB.a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        ibVarB.a();
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }

    public void a(id.a aVar) {
        this.i = aVar;
        if (this.j != null) {
            this.j.a(aVar);
        }
    }
}
