package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.ha;
import defpackage.id;

/* JADX INFO: loaded from: classes.dex */
final class ii extends ib implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, id {
    final kd a;
    View b;
    private final Context c;
    private final hw d;
    private final hv e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private PopupWindow.OnDismissListener l;
    private View m;
    private id.a n;
    private ViewTreeObserver o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean t;
    private final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ii.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ii.this.d() && !ii.this.a.g()) {
                View view = ii.this.b;
                if (view == null || !view.isShown()) {
                    ii.this.c();
                } else {
                    ii.this.a.a();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() { // from class: ii.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ii.this.o != null) {
                if (!ii.this.o.isAlive()) {
                    ii.this.o = view.getViewTreeObserver();
                }
                ii.this.o.removeGlobalOnLayoutListener(ii.this.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int s = 0;

    public ii(Context context, hw hwVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = hwVar;
        this.f = z;
        this.e = new hv(hwVar, LayoutInflater.from(context), this.f);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(ha.d.abc_config_prefDialogWidth));
        this.m = view;
        this.a = new kd(this.c, null, this.h, this.i);
        hwVar.a(this, context);
    }

    @Override // defpackage.ib
    public void a(boolean z) {
        this.e.a(z);
    }

    @Override // defpackage.ib
    public void a(int i) {
        this.s = i;
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.p || this.m == null) {
            return false;
        }
        this.b = this.m;
        this.a.a((PopupWindow.OnDismissListener) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.a.a(true);
        View view = this.b;
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this.j);
        }
        view.addOnAttachStateChangeListener(this.k);
        this.a.b(view);
        this.a.e(this.s);
        if (!this.q) {
            this.r = a(this.e, null, this.c, this.g);
            this.q = true;
        }
        this.a.g(this.r);
        this.a.h(2);
        this.a.a(g());
        this.a.a();
        ListView listViewE = this.a.e();
        listViewE.setOnKeyListener(this);
        if (this.t && this.d.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(ha.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.d.m());
            }
            frameLayout.setEnabled(false);
            listViewE.addHeaderView(frameLayout, null, false);
        }
        this.a.a((ListAdapter) this.e);
        this.a.a();
        return true;
    }

    @Override // defpackage.ih
    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // defpackage.ih
    public void c() {
        if (d()) {
            this.a.c();
        }
    }

    @Override // defpackage.ib
    public void a(hw hwVar) {
    }

    @Override // defpackage.ih
    public boolean d() {
        return !this.p && this.a.d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.p = true;
        this.d.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.j);
            this.o = null;
        }
        this.b.removeOnAttachStateChangeListener(this.k);
        if (this.l != null) {
            this.l.onDismiss();
        }
    }

    @Override // defpackage.id
    public void b(boolean z) {
        this.q = false;
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }

    @Override // defpackage.id
    public void a(id.a aVar) {
        this.n = aVar;
    }

    @Override // defpackage.id
    public boolean a(ij ijVar) {
        if (ijVar.hasVisibleItems()) {
            ic icVar = new ic(this.c, ijVar, this.b, this.f, this.h, this.i);
            icVar.a(this.n);
            icVar.a(ib.b(ijVar));
            icVar.a(this.s);
            icVar.a(this.l);
            this.l = null;
            this.d.a(false);
            if (icVar.a(this.a.j(), this.a.k())) {
                if (this.n != null) {
                    this.n.a(ijVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.id
    public void a(hw hwVar, boolean z) {
        if (hwVar == this.d) {
            c();
            if (this.n != null) {
                this.n.a(hwVar, z);
            }
        }
    }

    @Override // defpackage.id
    public boolean b() {
        return false;
    }

    @Override // defpackage.ib
    public void a(View view) {
        this.m = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    @Override // defpackage.ib
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // defpackage.ih
    public ListView e() {
        return this.a.e();
    }

    @Override // defpackage.ib
    public void b(int i) {
        this.a.c(i);
    }

    @Override // defpackage.ib
    public void c(int i) {
        this.a.d(i);
    }

    @Override // defpackage.ib
    public void c(boolean z) {
        this.t = z;
    }
}
