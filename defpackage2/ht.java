package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.ha;
import defpackage.id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ht extends ib implements View.OnKeyListener, PopupWindow.OnDismissListener, id {
    final Handler a;
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private View p;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean w;
    private id.a x;
    private ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;
    private final List<hw> j = new LinkedList();
    final List<a> b = new ArrayList();
    private final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ht.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ht.this.d() && ht.this.b.size() > 0 && !ht.this.b.get(0).a.g()) {
                View view = ht.this.c;
                if (view == null || !view.isShown()) {
                    ht.this.c();
                    return;
                }
                Iterator<a> it = ht.this.b.iterator();
                while (it.hasNext()) {
                    it.next().a.a();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: ht.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ht.this.y != null) {
                if (!ht.this.y.isAlive()) {
                    ht.this.y = view.getViewTreeObserver();
                }
                ht.this.y.removeGlobalOnLayoutListener(ht.this.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final kc m = new kc() { // from class: ht.3
        @Override // defpackage.kc
        public void a(hw hwVar, MenuItem menuItem) {
            ht.this.a.removeCallbacksAndMessages(hwVar);
        }

        @Override // defpackage.kc
        public void b(final hw hwVar, final MenuItem menuItem) {
            int i;
            ht.this.a.removeCallbacksAndMessages(null);
            int i2 = 0;
            int size = ht.this.b.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                } else {
                    if (hwVar == ht.this.b.get(i2).b) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i != -1) {
                int i3 = i + 1;
                final a aVar = i3 < ht.this.b.size() ? ht.this.b.get(i3) : null;
                ht.this.a.postAtTime(new Runnable() { // from class: ht.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            ht.this.d = true;
                            aVar.b.a(false);
                            ht.this.d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hwVar.a(menuItem, 4);
                        }
                    }
                }, hwVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int n = 0;
    private int o = 0;
    private boolean v = false;
    private int q = i();

    public ht(Context context, View view, int i, int i2, boolean z) {
        this.e = context;
        this.p = view;
        this.g = i;
        this.h = i2;
        this.i = z;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(ha.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    @Override // defpackage.ib
    public void a(boolean z) {
        this.v = z;
    }

    private kd h() {
        kd kdVar = new kd(this.e, null, this.g, this.h);
        kdVar.a(this.m);
        kdVar.a((AdapterView.OnItemClickListener) this);
        kdVar.a((PopupWindow.OnDismissListener) this);
        kdVar.b(this.p);
        kdVar.e(this.o);
        kdVar.a(true);
        kdVar.h(2);
        return kdVar;
    }

    @Override // defpackage.ih
    public void a() {
        if (!d()) {
            Iterator<hw> it = this.j.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.j.clear();
            this.c = this.p;
            if (this.c != null) {
                boolean z = this.y == null;
                this.y = this.c.getViewTreeObserver();
                if (z) {
                    this.y.addOnGlobalLayoutListener(this.k);
                }
                this.c.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    @Override // defpackage.ih
    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    private int i() {
        return fb.f(this.p) == 1 ? 0 : 1;
    }

    private int d(int i) {
        ListView listViewA = this.b.get(this.b.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        if (this.q == 1) {
            return (listViewA.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // defpackage.ib
    public void a(hw hwVar) {
        hwVar.a(this, this.e);
        if (d()) {
            c(hwVar);
        } else {
            this.j.add(hwVar);
        }
    }

    private void c(hw hwVar) {
        View viewA;
        a aVar;
        int i;
        int i2;
        int width;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.e);
        hv hvVar = new hv(hwVar, layoutInflaterFrom, this.i);
        if (!d() && this.v) {
            hvVar.a(true);
        } else if (d()) {
            hvVar.a(ib.b(hwVar));
        }
        int iA = a(hvVar, null, this.e, this.f);
        kd kdVarH = h();
        kdVarH.a((ListAdapter) hvVar);
        kdVarH.g(iA);
        kdVarH.e(this.o);
        if (this.b.size() > 0) {
            a aVar2 = this.b.get(this.b.size() - 1);
            viewA = a(aVar2, hwVar);
            aVar = aVar2;
        } else {
            viewA = null;
            aVar = null;
        }
        if (viewA != null) {
            kdVarH.c(false);
            kdVarH.a((Object) null);
            int iD = d(iA);
            boolean z = iD == 1;
            this.q = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                kdVarH.b(viewA);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (z) {
                    width = i + iA;
                } else {
                    width = i - viewA.getWidth();
                }
            } else if (z) {
                width = viewA.getWidth() + i;
            } else {
                width = i - iA;
            }
            kdVarH.c(width);
            kdVarH.b(true);
            kdVarH.d(i2);
        } else {
            if (this.r) {
                kdVarH.c(this.t);
            }
            if (this.s) {
                kdVarH.d(this.u);
            }
            kdVarH.a(g());
        }
        this.b.add(new a(kdVarH, hwVar, this.q));
        kdVarH.a();
        ListView listViewE = kdVarH.e();
        listViewE.setOnKeyListener(this);
        if (aVar == null && this.w && hwVar.m() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(ha.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(hwVar.m());
            listViewE.addHeaderView(frameLayout, null, false);
            kdVarH.a();
        }
    }

    private MenuItem a(hw hwVar, hw hwVar2) {
        int size = hwVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hwVar.getItem(i);
            if (item.hasSubMenu() && hwVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, hw hwVar) {
        hv hvVar;
        int headersCount;
        int i;
        int i2 = 0;
        MenuItem menuItemA = a(aVar.b, hwVar);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = aVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            hvVar = (hv) headerViewListAdapter.getWrappedAdapter();
        } else {
            hvVar = (hv) adapter;
            headersCount = 0;
        }
        int count = hvVar.getCount();
        while (true) {
            if (i2 >= count) {
                i = -1;
                break;
            }
            if (menuItemA == hvVar.getItem(i2)) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i == -1) {
            return null;
        }
        int firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= listViewA.getChildCount()) {
            return null;
        }
        return listViewA.getChildAt(firstVisiblePosition);
    }

    @Override // defpackage.ih
    public boolean d() {
        return this.b.size() > 0 && this.b.get(0).a.d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (!aVar.a.d()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.b.a(false);
        }
    }

    @Override // defpackage.id
    public void b(boolean z) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // defpackage.id
    public void a(id.a aVar) {
        this.x = aVar;
    }

    @Override // defpackage.id
    public boolean a(ij ijVar) {
        for (a aVar : this.b) {
            if (ijVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (ijVar.hasVisibleItems()) {
            a((hw) ijVar);
            if (this.x != null) {
                this.x.a(ijVar);
            }
            return true;
        }
        return false;
    }

    private int d(hw hwVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (hwVar == this.b.get(i).b) {
                return i;
            }
        }
        return -1;
    }

    @Override // defpackage.id
    public void a(hw hwVar, boolean z) {
        int iD = d(hwVar);
        if (iD >= 0) {
            int i = iD + 1;
            if (i < this.b.size()) {
                this.b.get(i).b.a(false);
            }
            a aVarRemove = this.b.remove(iD);
            aVarRemove.b.b(this);
            if (this.d) {
                aVarRemove.a.b((Object) null);
                aVarRemove.a.b(0);
            }
            aVarRemove.a.c();
            int size = this.b.size();
            if (size > 0) {
                this.q = this.b.get(size - 1).c;
            } else {
                this.q = i();
            }
            if (size == 0) {
                c();
                if (this.x != null) {
                    this.x.a(hwVar, true);
                }
                if (this.y != null) {
                    if (this.y.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.k);
                    }
                    this.y = null;
                }
                this.c.removeOnAttachStateChangeListener(this.l);
                this.z.onDismiss();
                return;
            }
            if (z) {
                this.b.get(0).b.a(false);
            }
        }
    }

    @Override // defpackage.id
    public boolean b() {
        return false;
    }

    @Override // defpackage.ib
    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = el.a(i, fb.f(this.p));
        }
    }

    @Override // defpackage.ib
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = el.a(this.n, fb.f(this.p));
        }
    }

    @Override // defpackage.ib
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // defpackage.ih
    public ListView e() {
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.get(this.b.size() - 1).a();
    }

    @Override // defpackage.ib
    public void b(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // defpackage.ib
    public void c(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // defpackage.ib
    public void c(boolean z) {
        this.w = z;
    }

    @Override // defpackage.ib
    protected boolean f() {
        return false;
    }

    static class a {
        public final kd a;
        public final hw b;
        public final int c;

        public a(kd kdVar, hw hwVar, int i) {
            this.a = kdVar;
            this.b = hwVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }
}
