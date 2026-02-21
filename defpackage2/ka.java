package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import defpackage.ha;
import java.lang.reflect.Method;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes.dex */
public class ka implements ih {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    jt c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException e4) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ka(Context context) {
        this(context, null, ha.a.listPopupWindowStyle);
    }

    public ka(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ka(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha.j.ListPopupWindow, i, i2);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ha.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ha.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.g = new jd(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (this.j != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public View i() {
        return this.z;
    }

    public void b(View view) {
        this.z = view;
    }

    public int j() {
        return this.m;
    }

    public void c(int i) {
        this.m = i;
    }

    public int k() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void e(int i) {
        this.t = i;
    }

    public int l() {
        return this.l;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i;
        } else {
            f(i);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    @Override // defpackage.ih
    public void a() {
        int width;
        int width2;
        int i;
        boolean z = false;
        int iF = f();
        boolean zN = n();
        gb.a(this.g, this.o);
        if (this.g.isShowing()) {
            if (fb.x(i())) {
                if (this.l == -1) {
                    width2 = -1;
                } else if (this.l == -2) {
                    width2 = i().getWidth();
                } else {
                    width2 = this.l;
                }
                if (this.k == -1) {
                    if (!zN) {
                        iF = -1;
                    }
                    if (zN) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                        i = iF;
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                        i = iF;
                    }
                } else {
                    i = this.k == -2 ? iF : this.k;
                }
                PopupWindow popupWindow = this.g;
                if (!this.v && !this.u) {
                    z = true;
                }
                popupWindow.setOutsideTouchable(z);
                PopupWindow popupWindow2 = this.g;
                View viewI = i();
                int i2 = this.m;
                int i3 = this.n;
                if (width2 < 0) {
                    width2 = -1;
                }
                popupWindow2.update(viewI, i2, i3, width2, i >= 0 ? i : -1);
                return;
            }
            return;
        }
        if (this.l == -1) {
            width = -1;
        } else if (this.l == -2) {
            width = i().getWidth();
        } else {
            width = this.l;
        }
        if (this.k == -1) {
            iF = -1;
        } else if (this.k != -2) {
            iF = this.k;
        }
        this.g.setWidth(width);
        this.g.setHeight(iF);
        c(true);
        this.g.setOutsideTouchable((this.v || this.u) ? false : true);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
            gb.a(this.g, this.r);
        }
        if (h != null) {
            try {
                h.invoke(this.g, this.I);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        gb.a(this.g, i(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            m();
        }
        if (!this.J) {
            this.f.post(this.F);
        }
    }

    @Override // defpackage.ih
    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public void i(int i) {
        jt jtVar = this.c;
        if (d() && jtVar != null) {
            jtVar.setListSelectionHidden(false);
            jtVar.setSelection(i);
            if (jtVar.getChoiceMode() != 0) {
                jtVar.setItemChecked(i, true);
            }
        }
    }

    public void m() {
        jt jtVar = this.c;
        if (jtVar != null) {
            jtVar.setListSelectionHidden(true);
            jtVar.requestLayout();
        }
    }

    @Override // defpackage.ih
    public boolean d() {
        return this.g.isShowing();
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }

    @Override // defpackage.ih
    public ListView e() {
        return this.c;
    }

    jt a(Context context, boolean z) {
        return new jt(context, z);
    }

    private int f() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int measuredHeight2;
        int i2;
        int i3;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() { // from class: ka.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewI = ka.this.i();
                    if (viewI != null && viewI.getWindowToken() != null) {
                        ka.this.a();
                    }
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: ka.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i4, long j) {
                    jt jtVar;
                    if (i4 != -1 && (jtVar = ka.this.c) != null) {
                        jtVar.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            jt jtVar = this.c;
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(jtVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(jtVar, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i3 = this.l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i3, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight2 = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = jtVar;
                measuredHeight2 = 0;
            }
            this.g.setContentView(view);
            measuredHeight = measuredHeight2;
        } else {
            View view3 = this.w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            int i4 = this.H.top + this.H.bottom;
            if (this.p) {
                i = i4;
            } else {
                this.n = -this.H.top;
                i = i4;
            }
        } else {
            this.H.setEmpty();
            i = 0;
        }
        int iA = a(i(), this.n, this.g.getInputMethodMode() == 2);
        if (this.u || this.k == -1) {
            return iA + i;
        }
        switch (this.l) {
            case ContentLengthStrategy.CHUNKED /* -2 */:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case ContentLengthStrategy.IDENTITY /* -1 */:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
                break;
        }
        int iA2 = this.c.a(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iA2 > 0) {
            measuredHeight += this.c.getPaddingTop() + this.c.getPaddingBottom() + i;
        }
        return iA2 + measuredHeight;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ka.this.d()) {
                ka.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ka.this.c();
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ka.this.m();
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ka.this.c != null && fb.x(ka.this.c) && ka.this.c.getCount() > ka.this.c.getChildCount() && ka.this.c.getChildCount() <= ka.this.d) {
                ka.this.g.setInputMethodMode(2);
                ka.this.a();
            }
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ka.this.g != null && ka.this.g.isShowing() && x >= 0 && x < ka.this.g.getWidth() && y >= 0 && y < ka.this.g.getHeight()) {
                ka.this.f.postDelayed(ka.this.e, 250L);
                return false;
            }
            if (action == 1) {
                ka.this.f.removeCallbacks(ka.this.e);
                return false;
            }
            return false;
        }
    }

    class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ka.this.n() && ka.this.g.getContentView() != null) {
                ka.this.f.removeCallbacks(ka.this.e);
                ka.this.e.run();
            }
        }
    }

    private void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }
}
