package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ej;
import defpackage.ha;
import defpackage.id;
import defpackage.ie;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class io extends hq implements ej.a {
    private b A;
    d g;
    e h;
    a i;
    c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private View z;

    public io(Context context) {
        super(context, ha.g.abc_action_menu_layout, ha.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    @Override // defpackage.hq, defpackage.id
    public void a(Context context, hw hwVar) {
        super.a(context, hwVar);
        Resources resources = context.getResources();
        hg hgVarA = hg.a(context);
        if (!this.p) {
            this.o = hgVarA.b();
        }
        if (!this.v) {
            this.q = hgVarA.c();
        }
        if (!this.t) {
            this.s = hgVarA.a();
        }
        int measuredWidth = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = measuredWidth;
        this.x = (int) (56.0f * resources.getDisplayMetrics().density);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = hg.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void c(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
        } else {
            this.n = true;
            this.m = drawable;
        }
    }

    public Drawable c() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    @Override // defpackage.hq
    public ie a(ViewGroup viewGroup) {
        ie ieVar = this.f;
        ie ieVarA = super.a(viewGroup);
        if (ieVar != ieVarA) {
            ((ActionMenuView) ieVarA).setPresenter(this);
        }
        return ieVarA;
    }

    @Override // defpackage.hq
    public View a(hy hyVar, View view, ViewGroup viewGroup) {
        View actionView = hyVar.getActionView();
        if (actionView == null || hyVar.n()) {
            actionView = super.a(hyVar, view, viewGroup);
        }
        actionView.setVisibility(hyVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.hq
    public void a(hy hyVar, ie.a aVar) {
        aVar.a(hyVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // defpackage.hq
    public boolean a(int i, hy hyVar) {
        return hyVar.j();
    }

    @Override // defpackage.hq, defpackage.id
    public void b(boolean z) {
        boolean z2 = false;
        super.b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList<hy> arrayListK = this.c.k();
            int size = arrayListK.size();
            for (int i = 0; i < size; i++) {
                ej ejVarA = arrayListK.get(i).a();
                if (ejVarA != null) {
                    ejVarA.a(this);
                }
            }
        }
        ArrayList<hy> arrayListL = this.c != null ? this.c.l() : null;
        if (this.o && arrayListL != null) {
            int size2 = arrayListL.size();
            if (size2 == 1) {
                z2 = !arrayListL.get(0).isActionViewExpanded();
            } else {
                z2 = size2 > 0;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // defpackage.hq
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // defpackage.hq, defpackage.id
    public boolean a(ij ijVar) {
        boolean z;
        if (!ijVar.hasVisibleItems()) {
            return false;
        }
        ij ijVar2 = ijVar;
        while (ijVar2.s() != this.c) {
            ijVar2 = (ij) ijVar2.s();
        }
        View viewA = a(ijVar2.getItem());
        if (viewA == null) {
            return false;
        }
        this.l = ijVar.getItem().getItemId();
        int size = ijVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            MenuItem item = ijVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.i = new a(this.b, ijVar, viewA);
        this.i.a(z);
        this.i.a();
        super.a(ijVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ie.a) && ((ie.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.l().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((ij) null);
        return true;
    }

    public boolean e() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.d();
            return true;
        }
        return false;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.i == null) {
            return false;
        }
        this.i.d();
        return true;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || h();
    }

    @Override // defpackage.hq, defpackage.id
    public boolean b() {
        int size;
        ArrayList<hy> arrayList;
        int i;
        int measuredWidth;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        if (this.c != null) {
            ArrayList<hy> arrayListI = this.c.i();
            size = arrayListI.size();
            arrayList = arrayListI;
        } else {
            size = 0;
            arrayList = null;
        }
        int i8 = this.s;
        int i9 = this.r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i10 = 0;
        int i11 = 0;
        boolean z3 = false;
        int i12 = 0;
        while (i12 < size) {
            hy hyVar = arrayList.get(i12);
            if (hyVar.l()) {
                i10++;
            } else if (hyVar.k()) {
                i11++;
            } else {
                z3 = true;
            }
            i12++;
            i8 = (this.w && hyVar.isActionViewExpanded()) ? 0 : i8;
        }
        if (this.o && (z3 || i10 + i11 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = this.y;
        sparseBooleanArray.clear();
        int i14 = 0;
        if (!this.u) {
            i = 0;
        } else {
            i14 = i9 / this.x;
            i = ((i9 % this.x) / i14) + this.x;
        }
        int i15 = 0;
        int i16 = 0;
        int iA = i14;
        while (i15 < size) {
            hy hyVar2 = arrayList.get(i15);
            if (hyVar2.l()) {
                View viewA = a(hyVar2, this.z, viewGroup);
                if (this.z == null) {
                    this.z = viewA;
                }
                if (this.u) {
                    iA -= ActionMenuView.a(viewA, i, iA, iMakeMeasureSpec, 0);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                measuredWidth = viewA.getMeasuredWidth();
                int i17 = i9 - measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = hyVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hyVar2.d(true);
                i2 = i17;
                i3 = i13;
            } else if (hyVar2.k()) {
                int groupId2 = hyVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i9 > 0 && (!this.u || iA > 0);
                if (z5) {
                    View viewA2 = a(hyVar2, this.z, viewGroup);
                    if (this.z == null) {
                        this.z = viewA2;
                    }
                    if (this.u) {
                        int iA2 = ActionMenuView.a(viewA2, i, iA, iMakeMeasureSpec, 0);
                        int i18 = iA - iA2;
                        z2 = iA2 == 0 ? false : z5;
                        i7 = i18;
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        boolean z6 = z5;
                        i7 = iA;
                        z2 = z6;
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    if (this.u) {
                        z = z2 & (i9 >= 0);
                        i4 = i16;
                        i5 = i7;
                    } else {
                        z = z2 & (i9 + i16 > 0);
                        i4 = i16;
                        i5 = i7;
                    }
                } else {
                    z = z5;
                    i4 = i16;
                    i5 = iA;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i6 = i13;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i19 = i13;
                    for (int i20 = 0; i20 < i15; i20++) {
                        hy hyVar3 = arrayList.get(i20);
                        if (hyVar3.getGroupId() == groupId2) {
                            if (hyVar3.j()) {
                                i19++;
                            }
                            hyVar3.d(false);
                        }
                    }
                    i6 = i19;
                } else {
                    i6 = i13;
                }
                if (z) {
                    i6--;
                }
                hyVar2.d(z);
                measuredWidth = i4;
                i2 = i9;
                int i21 = i5;
                i3 = i6;
                iA = i21;
            } else {
                hyVar2.d(false);
                measuredWidth = i16;
                i2 = i9;
                i3 = i13;
            }
            i15++;
            i9 = i2;
            i13 = i3;
            i16 = measuredWidth;
        }
        return true;
    }

    @Override // defpackage.hq, defpackage.id
    public void a(hw hwVar, boolean z) {
        f();
        super.a(hwVar, z);
    }

    @Override // ej.a
    public void a(boolean z) {
        if (z) {
            super.a((ij) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    class d extends jb implements ActionMenuView.a {
        private final float[] b;

        public d(Context context) {
            super(context, null, ha.a.actionOverflowButtonStyle);
            this.b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ku.a(this, getContentDescription());
            setOnTouchListener(new jw(this) { // from class: io.d.1
                @Override // defpackage.jw
                public ih a() {
                    if (io.this.h == null) {
                        return null;
                    }
                    return io.this.h.b();
                }

                @Override // defpackage.jw
                public boolean b() {
                    io.this.d();
                    return true;
                }

                @Override // defpackage.jw
                public boolean c() {
                    if (io.this.j != null) {
                        return false;
                    }
                    io.this.e();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                io.this.d();
            }
            return true;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                cw.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    class e extends ic {
        public e(Context context, hw hwVar, View view, boolean z) {
            super(context, hwVar, view, z, ha.a.actionOverflowMenuStyle);
            a(8388613);
            a(io.this.k);
        }

        @Override // defpackage.ic
        protected void e() {
            if (io.this.c != null) {
                io.this.c.close();
            }
            io.this.h = null;
            super.e();
        }
    }

    class a extends ic {
        public a(Context context, ij ijVar, View view) {
            View view2;
            super(context, ijVar, view, false, ha.a.actionOverflowMenuStyle);
            if (!((hy) ijVar.getItem()).j()) {
                if (io.this.g == null) {
                    view2 = (View) io.this.f;
                } else {
                    view2 = io.this.g;
                }
                a(view2);
            }
            a(io.this.k);
        }

        @Override // defpackage.ic
        protected void e() {
            io.this.i = null;
            io.this.l = 0;
            super.e();
        }
    }

    class f implements id.a {
        f() {
        }

        @Override // id.a
        public boolean a(hw hwVar) {
            if (hwVar == null) {
                return false;
            }
            io.this.l = ((ij) hwVar).getItem().getItemId();
            id.a aVarA = io.this.a();
            return aVarA != null ? aVarA.a(hwVar) : false;
        }

        @Override // id.a
        public void a(hw hwVar, boolean z) {
            if (hwVar instanceof ij) {
                hwVar.p().a(false);
            }
            id.a aVarA = io.this.a();
            if (aVarA != null) {
                aVarA.a(hwVar, z);
            }
        }
    }

    class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (io.this.c != null) {
                io.this.c.f();
            }
            View view = (View) io.this.f;
            if (view != null && view.getWindowToken() != null && this.b.c()) {
                io.this.h = this.b;
            }
            io.this.j = null;
        }
    }

    class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public ih a() {
            if (io.this.i != null) {
                return io.this.i.b();
            }
            return null;
        }
    }
}
