package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.ha;
import defpackage.hh;
import defpackage.hw;
import defpackage.id;
import defpackage.jv;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class gs extends gn implements LayoutInflater.Factory2, hw.a {
    private static final boolean t;
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d[] E;
    private d F;
    private boolean G;
    private final Runnable H;
    private boolean I;
    private Rect J;
    private Rect K;
    private gu L;
    hh m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    fe q;
    boolean r;
    int s;
    private jp u;
    private a v;
    private e w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    static {
        t = Build.VERSION.SDK_INT < 21;
    }

    gs(Context context, Window window, gl glVar) {
        super(context, window, glVar);
        this.q = null;
        this.H = new Runnable() { // from class: gs.1
            @Override // java.lang.Runnable
            public void run() {
                if ((gs.this.s & 1) != 0) {
                    gs.this.f(0);
                }
                if ((gs.this.s & 4096) != 0) {
                    gs.this.f(108);
                }
                gs.this.r = false;
                gs.this.s = 0;
            }
        };
    }

    @Override // defpackage.gm
    public void a(Bundle bundle) {
        if ((this.c instanceof Activity) && bo.b((Activity) this.c) != null) {
            gi giVarM = m();
            if (giVarM == null) {
                this.I = true;
            } else {
                giVarM.f(true);
            }
        }
    }

    @Override // defpackage.gm
    public void b(Bundle bundle) {
        w();
    }

    @Override // defpackage.gn
    public void l() {
        w();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new gz((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new gz((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.f(this.I);
            }
        }
    }

    @Override // defpackage.gm
    public void a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            gi giVarA = a();
            if (giVarA instanceof gz) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (giVarA != null) {
                giVarA.h();
            }
            if (toolbar != null) {
                gw gwVar = new gw(toolbar, ((Activity) this.c).getTitle(), this.d);
                this.f = gwVar;
                this.b.setCallback(gwVar.i());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            f();
        }
    }

    @Override // defpackage.gm
    public <T extends View> T a(int i) {
        w();
        return (T) this.b.findViewById(i);
    }

    @Override // defpackage.gm
    public void a(Configuration configuration) {
        gi giVarA;
        if (this.h && this.x && (giVarA = a()) != null) {
            giVarA.a(configuration);
        }
        ix.a().a(this.a);
        i();
    }

    @Override // defpackage.gn, defpackage.gm
    public void d() {
        gi giVarA = a();
        if (giVarA != null) {
            giVarA.g(false);
        }
    }

    @Override // defpackage.gm
    public void e() {
        gi giVarA = a();
        if (giVarA != null) {
            giVarA.g(true);
        }
    }

    @Override // defpackage.gm
    public void a(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    @Override // defpackage.gm
    public void b(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    @Override // defpackage.gm
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override // defpackage.gm
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ((ViewGroup) this.y.findViewById(R.id.content)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override // defpackage.gn, defpackage.gm
    public void g() {
        if (this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }
        super.g();
        if (this.f != null) {
            this.f.h();
        }
    }

    private void w() {
        if (!this.x) {
            this.y = x();
            CharSequence charSequenceR = r();
            if (!TextUtils.isEmpty(charSequenceR)) {
                b(charSequenceR);
            }
            y();
            a(this.y);
            this.x = true;
            d dVarA = a(0, false);
            if (p()) {
                return;
            }
            if (dVarA == null || dVarA.j == null) {
                d(108);
            }
        }
    }

    private ViewGroup x() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Context hjVar;
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(ha.j.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ha.j.AppCompatTheme_windowNoTitle, false)) {
            c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(ha.j.AppCompatTheme_windowActionBar, false)) {
            c(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ha.j.AppCompatTheme_windowActionBarOverlay, false)) {
            c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ha.j.AppCompatTheme_windowActionModeOverlay, false)) {
            c(10);
        }
        this.k = typedArrayObtainStyledAttributes.getBoolean(ha.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
        if (!this.l) {
            if (this.k) {
                ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(ha.g.abc_dialog_title_material, (ViewGroup) null);
                this.i = false;
                this.h = false;
                viewGroup2 = viewGroup3;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(ha.a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    hjVar = new hj(this.a, typedValue.resourceId);
                } else {
                    hjVar = this.a;
                }
                ViewGroup viewGroup4 = (ViewGroup) LayoutInflater.from(hjVar).inflate(ha.g.abc_screen_toolbar, (ViewGroup) null);
                this.u = (jp) viewGroup4.findViewById(ha.f.decor_content_parent);
                this.u.setWindowCallback(q());
                if (this.i) {
                    this.u.a(109);
                }
                if (this.B) {
                    this.u.a(2);
                }
                if (this.C) {
                    this.u.a(5);
                }
                viewGroup2 = viewGroup4;
            } else {
                viewGroup2 = null;
            }
        } else {
            if (this.j) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(ha.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(ha.g.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                fb.a(viewGroup, new ew() { // from class: gs.2
                    @Override // defpackage.ew
                    public fi a(View view, fi fiVar) {
                        int iB = fiVar.b();
                        int iG = gs.this.g(iB);
                        if (iB != iG) {
                            fiVar = fiVar.a(fiVar.a(), iG, fiVar.c(), fiVar.d());
                        }
                        return fb.a(view, fiVar);
                    }
                });
                viewGroup2 = viewGroup;
            } else {
                ((jv) viewGroup).setOnFitSystemWindowsListener(new jv.a() { // from class: gs.3
                    @Override // jv.a
                    public void a(Rect rect) {
                        rect.top = gs.this.g(rect.top);
                    }
                });
                viewGroup2 = viewGroup;
            }
        }
        if (viewGroup2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }
        if (this.u == null) {
            this.z = (TextView) viewGroup2.findViewById(ha.f.title);
        }
        la.b(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(ha.f.action_bar_activity_content);
        ViewGroup viewGroup5 = (ViewGroup) this.b.findViewById(R.id.content);
        if (viewGroup5 != null) {
            while (viewGroup5.getChildCount() > 0) {
                View childAt = viewGroup5.getChildAt(0);
                viewGroup5.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup5.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup5 instanceof FrameLayout) {
                ((FrameLayout) viewGroup5).setForeground(null);
            }
        }
        this.b.setContentView(viewGroup2);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: gs.4
            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void b() {
                gs.this.v();
            }
        });
        return viewGroup2;
    }

    void a(ViewGroup viewGroup) {
    }

    private void y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.y.findViewById(R.id.content);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(ha.j.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(ha.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(ha.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // defpackage.gm
    public boolean c(int i) {
        int iH = h(i);
        if (this.l && iH == 108) {
            return false;
        }
        if (this.h && iH == 1) {
            this.h = false;
        }
        switch (iH) {
            case 1:
                z();
                this.l = true;
                return true;
            case 2:
                z();
                this.B = true;
                return true;
            case 5:
                z();
                this.C = true;
                return true;
            case 10:
                z();
                this.j = true;
                return true;
            case 108:
                z();
                this.h = true;
                return true;
            case 109:
                z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(iH);
        }
    }

    @Override // defpackage.gn
    void b(CharSequence charSequence) {
        if (this.u != null) {
            this.u.setWindowTitle(charSequence);
        } else if (m() != null) {
            m().b(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    @Override // defpackage.gn
    void a(int i, Menu menu) {
        if (i == 108) {
            gi giVarA = a();
            if (giVarA != null) {
                giVarA.h(false);
                return;
            }
            return;
        }
        if (i == 0) {
            d dVarA = a(i, true);
            if (dVarA.o) {
                a(dVarA, false);
            }
        }
    }

    @Override // defpackage.gn
    boolean b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        gi giVarA = a();
        if (giVarA == null) {
            return true;
        }
        giVarA.h(true);
        return true;
    }

    @Override // hw.a
    public boolean a(hw hwVar, MenuItem menuItem) {
        d dVarA;
        Window.Callback callbackQ = q();
        if (callbackQ == null || p() || (dVarA = a((Menu) hwVar.p())) == null) {
            return false;
        }
        return callbackQ.onMenuItemSelected(dVarA.a, menuItem);
    }

    @Override // hw.a
    public void a(hw hwVar) {
        a(hwVar, true);
    }

    public hh b(hh.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.m != null) {
            this.m.c();
        }
        b bVar = new b(aVar);
        gi giVarA = a();
        if (giVarA != null) {
            this.m = giVarA.a(bVar);
            if (this.m != null && this.e != null) {
                this.e.a(this.m);
            }
        }
        if (this.m == null) {
            this.m = a(bVar);
        }
        return this.m;
    }

    @Override // defpackage.gm
    public void f() {
        gi giVarA = a();
        if (giVarA == null || !giVarA.f()) {
            d(0);
        }
    }

    @Override // defpackage.gn
    hh a(hh.a aVar) {
        hh hhVarA;
        Context hjVar;
        t();
        if (this.m != null) {
            this.m.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (this.e == null || p()) {
            hhVarA = null;
        } else {
            try {
                hhVarA = this.e.a(aVar);
            } catch (AbstractMethodError e2) {
                hhVarA = null;
            }
        }
        if (hhVarA != null) {
            this.m = hhVarA;
        } else {
            if (this.n == null) {
                if (this.k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.a.getTheme();
                    theme.resolveAttribute(ha.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        hjVar = new hj(this.a, 0);
                        hjVar.getTheme().setTo(themeNewTheme);
                    } else {
                        hjVar = this.a;
                    }
                    this.n = new ActionBarContextView(hjVar);
                    this.o = new PopupWindow(hjVar, (AttributeSet) null, ha.a.actionModePopupWindowStyle);
                    gb.a(this.o, 2);
                    this.o.setContentView(this.n);
                    this.o.setWidth(-1);
                    hjVar.getTheme().resolveAttribute(ha.a.actionBarSize, typedValue, true);
                    this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, hjVar.getResources().getDisplayMetrics()));
                    this.o.setHeight(-2);
                    this.p = new Runnable() { // from class: gs.5
                        @Override // java.lang.Runnable
                        public void run() {
                            gs.this.o.showAtLocation(gs.this.n, 55, 0, 0);
                            gs.this.t();
                            if (gs.this.s()) {
                                gs.this.n.setAlpha(0.0f);
                                gs.this.q = fb.k(gs.this.n).a(1.0f);
                                gs.this.q.a(new fg() { // from class: gs.5.1
                                    @Override // defpackage.fg, defpackage.ff
                                    public void a(View view) {
                                        gs.this.n.setVisibility(0);
                                    }

                                    @Override // defpackage.fg, defpackage.ff
                                    public void b(View view) {
                                        gs.this.n.setAlpha(1.0f);
                                        gs.this.q.a((ff) null);
                                        gs.this.q = null;
                                    }
                                });
                                return;
                            }
                            gs.this.n.setAlpha(1.0f);
                            gs.this.n.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.y.findViewById(ha.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
                        this.n = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.n != null) {
                t();
                this.n.c();
                hk hkVar = new hk(this.n.getContext(), this.n, aVar, this.o == null);
                if (aVar.a(hkVar, hkVar.b())) {
                    hkVar.d();
                    this.n.a(hkVar);
                    this.m = hkVar;
                    if (s()) {
                        this.n.setAlpha(0.0f);
                        this.q = fb.k(this.n).a(1.0f);
                        this.q.a(new fg() { // from class: gs.6
                            @Override // defpackage.fg, defpackage.ff
                            public void a(View view) {
                                gs.this.n.setVisibility(0);
                                gs.this.n.sendAccessibilityEvent(32);
                                if (gs.this.n.getParent() instanceof View) {
                                    fb.n((View) gs.this.n.getParent());
                                }
                            }

                            @Override // defpackage.fg, defpackage.ff
                            public void b(View view) {
                                gs.this.n.setAlpha(1.0f);
                                gs.this.q.a((ff) null);
                                gs.this.q = null;
                            }
                        });
                    } else {
                        this.n.setAlpha(1.0f);
                        this.n.setVisibility(0);
                        this.n.sendAccessibilityEvent(32);
                        if (this.n.getParent() instanceof View) {
                            fb.n((View) this.n.getParent());
                        }
                    }
                    if (this.o != null) {
                        this.b.getDecorView().post(this.p);
                    }
                } else {
                    this.m = null;
                }
            }
        }
        if (this.m != null && this.e != null) {
            this.e.a(this.m);
        }
        return this.m;
    }

    final boolean s() {
        return this.x && this.y != null && fb.v(this.y);
    }

    void t() {
        if (this.q != null) {
            this.q.b();
        }
    }

    boolean u() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        gi giVarA = a();
        return giVarA != null && giVarA.g();
    }

    @Override // defpackage.gn
    boolean a(int i, KeyEvent keyEvent) {
        gi giVarA = a();
        if (giVarA != null && giVarA.a(i, keyEvent)) {
            return true;
        }
        if (this.F != null && a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.F == null) {
                return true;
            }
            this.F.n = true;
            return true;
        }
        if (this.F == null) {
            d dVarA = a(0, true);
            b(dVarA, keyEvent);
            boolean zA = a(dVarA, keyEvent.getKeyCode(), keyEvent, 1);
            dVarA.m = false;
            if (zA) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.gn
    boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    boolean b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.G;
                this.G = false;
                d dVarA = a(0, false);
                if (dVarA != null && dVarA.o) {
                    if (z) {
                        return true;
                    }
                    a(dVarA, true);
                    return true;
                }
                if (u()) {
                    return true;
                }
                break;
            case 82:
                e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean c(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                this.G = (keyEvent.getFlags() & Allocation.USAGE_SHARED) != 0;
                break;
            case 82:
                d(0, keyEvent);
                return true;
        }
        if (Build.VERSION.SDK_INT < 11) {
            a(i, keyEvent);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zA;
        if (this.L == null) {
            this.L = new gu();
        }
        if (t) {
            if (attributeSet instanceof XmlPullParser) {
                zA = ((XmlPullParser) attributeSet).getDepth() > 1;
            } else {
                zA = a((ViewParent) view);
            }
            z = zA;
        } else {
            z = false;
        }
        return this.L.a(view, str, context, attributeSet, z, t, true, kx.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.b.getDecorView();
        for (ViewParent parent = viewParent; parent != null; parent = parent.getParent()) {
            if (parent == decorView || !(parent instanceof View) || fb.x((View) parent)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.gm
    public void h() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
        if (layoutInflaterFrom.getFactory() == null) {
            em.b(layoutInflaterFrom, this);
        } else if (!(layoutInflaterFrom.getFactory2() instanceof gs)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewA = a(view, str, context, attributeSet);
        return viewA != null ? viewA : b(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView;
        if (!(this.c instanceof LayoutInflater.Factory) || (viewOnCreateView = ((LayoutInflater.Factory) this.c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return viewOnCreateView;
    }

    private void a(d dVar, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!dVar.o && !p()) {
            if (dVar.a == 0) {
                Context context = this.a;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback callbackQ = q();
            if (callbackQ != null && !callbackQ.onMenuOpened(dVar.a, dVar.j)) {
                a(dVar, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
            if (windowManager != null && b(dVar, keyEvent)) {
                if (dVar.g == null || dVar.q) {
                    if (dVar.g == null) {
                        if (!a(dVar) || dVar.g == null) {
                            return;
                        }
                    } else if (dVar.q && dVar.g.getChildCount() > 0) {
                        dVar.g.removeAllViews();
                    }
                    if (c(dVar) && dVar.a()) {
                        ViewGroup.LayoutParams layoutParams2 = dVar.h.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                        dVar.g.setBackgroundResource(dVar.b);
                        ViewParent parent = dVar.h.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(dVar.h);
                        }
                        dVar.g.addView(dVar.h, layoutParams3);
                        if (!dVar.h.hasFocus()) {
                            dVar.h.requestFocus();
                        }
                        i = -2;
                    } else {
                        return;
                    }
                } else if (dVar.i == null || (layoutParams = dVar.i.getLayoutParams()) == null || layoutParams.width != -1) {
                    i = -2;
                }
                dVar.n = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, dVar.d, dVar.e, 1002, 8519680, -3);
                layoutParams4.gravity = dVar.c;
                layoutParams4.windowAnimations = dVar.f;
                windowManager.addView(dVar.g, layoutParams4);
                dVar.o = true;
            }
        }
    }

    private boolean a(d dVar) {
        dVar.a(n());
        dVar.g = new c(dVar.l);
        dVar.c = 81;
        return true;
    }

    private void a(hw hwVar, boolean z) {
        if (this.u != null && this.u.e() && (!ViewConfiguration.get(this.a).hasPermanentMenuKey() || this.u.g())) {
            Window.Callback callbackQ = q();
            if (!this.u.f() || !z) {
                if (callbackQ != null && !p()) {
                    if (this.r && (this.s & 1) != 0) {
                        this.b.getDecorView().removeCallbacks(this.H);
                        this.H.run();
                    }
                    d dVarA = a(0, true);
                    if (dVarA.j != null && !dVarA.r && callbackQ.onPreparePanel(0, dVarA.i, dVarA.j)) {
                        callbackQ.onMenuOpened(108, dVarA.j);
                        this.u.h();
                        return;
                    }
                    return;
                }
                return;
            }
            this.u.i();
            if (!p()) {
                callbackQ.onPanelClosed(108, a(0, true).j);
                return;
            }
            return;
        }
        d dVarA2 = a(0, true);
        dVarA2.q = true;
        a(dVarA2, false);
        a(dVarA2, (KeyEvent) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(gs.d r7) {
        /*
            r6 = this;
            r5 = 1
            android.content.Context r1 = r6.a
            int r0 = r7.a
            if (r0 == 0) goto Ld
            int r0 = r7.a
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 != r2) goto L71
        Ld:
            jp r0 = r6.u
            if (r0 == 0) goto L71
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r1.getTheme()
            int r0 = ha.a.actionBarTheme
            r3.resolveAttribute(r0, r2, r5)
            r0 = 0
            int r4 = r2.resourceId
            if (r4 == 0) goto L6b
            android.content.res.Resources r0 = r1.getResources()
            android.content.res.Resources$Theme r0 = r0.newTheme()
            r0.setTo(r3)
            int r4 = r2.resourceId
            r0.applyStyle(r4, r5)
            int r4 = ha.a.actionBarWidgetTheme
            r0.resolveAttribute(r4, r2, r5)
        L39:
            int r4 = r2.resourceId
            if (r4 == 0) goto L4f
            if (r0 != 0) goto L4a
            android.content.res.Resources r0 = r1.getResources()
            android.content.res.Resources$Theme r0 = r0.newTheme()
            r0.setTo(r3)
        L4a:
            int r2 = r2.resourceId
            r0.applyStyle(r2, r5)
        L4f:
            r2 = r0
            if (r2 == 0) goto L71
            hj r0 = new hj
            r3 = 0
            r0.<init>(r1, r3)
            android.content.res.Resources$Theme r1 = r0.getTheme()
            r1.setTo(r2)
        L5f:
            hw r1 = new hw
            r1.<init>(r0)
            r1.a(r6)
            r7.a(r1)
            return r5
        L6b:
            int r4 = ha.a.actionBarWidgetTheme
            r3.resolveAttribute(r4, r2, r5)
            goto L39
        L71:
            r0 = r1
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gs.b(gs$d):boolean");
    }

    private boolean c(d dVar) {
        if (dVar.i != null) {
            dVar.h = dVar.i;
            return true;
        }
        if (dVar.j == null) {
            return false;
        }
        if (this.w == null) {
            this.w = new e();
        }
        dVar.h = (View) dVar.a(this.w);
        return dVar.h != null;
    }

    private boolean b(d dVar, KeyEvent keyEvent) {
        if (p()) {
            return false;
        }
        if (dVar.m) {
            return true;
        }
        if (this.F != null && this.F != dVar) {
            a(this.F, false);
        }
        Window.Callback callbackQ = q();
        if (callbackQ != null) {
            dVar.i = callbackQ.onCreatePanelView(dVar.a);
        }
        boolean z = dVar.a == 0 || dVar.a == 108;
        if (z && this.u != null) {
            this.u.j();
        }
        if (dVar.i == null && (!z || !(m() instanceof gw))) {
            if (dVar.j == null || dVar.r) {
                if (dVar.j == null && (!b(dVar) || dVar.j == null)) {
                    return false;
                }
                if (z && this.u != null) {
                    if (this.v == null) {
                        this.v = new a();
                    }
                    this.u.a(dVar.j, this.v);
                }
                dVar.j.g();
                if (!callbackQ.onCreatePanelMenu(dVar.a, dVar.j)) {
                    dVar.a((hw) null);
                    if (!z || this.u == null) {
                        return false;
                    }
                    this.u.a(null, this.v);
                    return false;
                }
                dVar.r = false;
            }
            dVar.j.g();
            if (dVar.s != null) {
                dVar.j.b(dVar.s);
                dVar.s = null;
            }
            if (!callbackQ.onPreparePanel(0, dVar.i, dVar.j)) {
                if (z && this.u != null) {
                    this.u.a(null, this.v);
                }
                dVar.j.h();
                return false;
            }
            dVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            dVar.j.setQwertyMode(dVar.p);
            dVar.j.h();
        }
        dVar.m = true;
        dVar.n = false;
        this.F = dVar;
        return true;
    }

    void b(hw hwVar) {
        if (!this.D) {
            this.D = true;
            this.u.k();
            Window.Callback callbackQ = q();
            if (callbackQ != null && !p()) {
                callbackQ.onPanelClosed(108, hwVar);
            }
            this.D = false;
        }
    }

    void e(int i) {
        a(a(i, true), true);
    }

    void a(d dVar, boolean z) {
        if (z && dVar.a == 0 && this.u != null && this.u.f()) {
            b(dVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (windowManager != null && dVar.o && dVar.g != null) {
            windowManager.removeView(dVar.g);
            if (z) {
                a(dVar.a, dVar, (Menu) null);
            }
        }
        dVar.m = false;
        dVar.n = false;
        dVar.o = false;
        dVar.h = null;
        dVar.q = true;
        if (this.F == dVar) {
            this.F = null;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            d dVarA = a(i, true);
            if (!dVarA.o) {
                return b(dVarA, keyEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            r2 = 1
            r1 = 0
            hh r0 = r4.m
            if (r0 == 0) goto L8
            r0 = r1
        L7:
            return r0
        L8:
            gs$d r3 = r4.a(r5, r2)
            if (r5 != 0) goto L5a
            jp r0 = r4.u
            if (r0 == 0) goto L5a
            jp r0 = r4.u
            boolean r0 = r0.e()
            if (r0 == 0) goto L5a
            android.content.Context r0 = r4.a
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            boolean r0 = r0.hasPermanentMenuKey()
            if (r0 != 0) goto L5a
            jp r0 = r4.u
            boolean r0 = r0.f()
            if (r0 != 0) goto L53
            boolean r0 = r4.p()
            if (r0 != 0) goto L85
            boolean r0 = r4.b(r3, r6)
            if (r0 == 0) goto L85
            jp r0 = r4.u
            boolean r2 = r0.h()
        L40:
            if (r2 == 0) goto L51
            android.content.Context r0 = r4.a
            java.lang.String r3 = "audio"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            if (r0 == 0) goto L7d
            r0.playSoundEffect(r1)
        L51:
            r0 = r2
            goto L7
        L53:
            jp r0 = r4.u
            boolean r2 = r0.i()
            goto L40
        L5a:
            boolean r0 = r3.o
            if (r0 != 0) goto L62
            boolean r0 = r3.n
            if (r0 == 0) goto L69
        L62:
            boolean r0 = r3.o
            r4.a(r3, r2)
            r2 = r0
            goto L40
        L69:
            boolean r0 = r3.m
            if (r0 == 0) goto L85
            boolean r0 = r3.r
            if (r0 == 0) goto L87
            r3.m = r1
            boolean r0 = r4.b(r3, r6)
        L77:
            if (r0 == 0) goto L85
            r4.a(r3, r6)
            goto L40
        L7d:
            java.lang.String r0 = "AppCompatDelegate"
            java.lang.String r1 = "Couldn't get audio manager"
            android.util.Log.w(r0, r1)
            goto L51
        L85:
            r2 = r1
            goto L40
        L87:
            r0 = r2
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gs.e(int, android.view.KeyEvent):boolean");
    }

    void a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.E.length) {
                dVar = this.E[i];
            }
            if (dVar != null) {
                menu = dVar.j;
            }
        }
        if ((dVar == null || dVar.o) && !p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    d a(Menu menu) {
        d[] dVarArr = this.E;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.j == menu) {
                return dVar;
            }
        }
        return null;
    }

    protected d a(int i, boolean z) {
        d[] dVarArr = this.E;
        if (dVarArr == null || dVarArr.length <= i) {
            d[] dVarArr2 = new d[i + 1];
            if (dVarArr != null) {
                System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            }
            this.E = dVarArr2;
            dVarArr = dVarArr2;
        }
        d dVar = dVarArr[i];
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(i);
        dVarArr[i] = dVar2;
        return dVar2;
    }

    private boolean a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (!keyEvent.isSystem()) {
            if ((dVar.m || b(dVar, keyEvent)) && dVar.j != null) {
                zPerformShortcut = dVar.j.performShortcut(i, keyEvent, i2);
            }
            if (zPerformShortcut && (i2 & 1) == 0 && this.u == null) {
                a(dVar, true);
            }
        }
        return zPerformShortcut;
    }

    private void d(int i) {
        this.s |= 1 << i;
        if (!this.r) {
            fb.a(this.b.getDecorView(), this.H);
            this.r = true;
        }
    }

    void f(int i) {
        d dVarA;
        d dVarA2 = a(i, true);
        if (dVarA2.j != null) {
            Bundle bundle = new Bundle();
            dVarA2.j.a(bundle);
            if (bundle.size() > 0) {
                dVarA2.s = bundle;
            }
            dVarA2.j.g();
            dVarA2.j.clear();
        }
        dVarA2.r = true;
        dVarA2.q = true;
        if ((i == 108 || i == 0) && this.u != null && (dVarA = a(0, false)) != null) {
            dVarA.m = false;
            b(dVarA, (KeyEvent) null);
        }
    }

    int g(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            if (this.n.isShown()) {
                if (this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }
                Rect rect = this.J;
                Rect rect2 = this.K;
                rect.set(0, i, 0, 0);
                la.a(this.y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(ha.c.abc_input_method_navigation_guard));
                        this.y.addView(this.A, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.A.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                z = this.A != null;
                if (!this.j && z) {
                    i = 0;
                }
                boolean z4 = z3;
                z2 = z;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z = false;
                z2 = false;
            }
            if (z) {
                this.n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.A != null) {
            this.A.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void z() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return i;
    }

    void v() {
        if (this.u != null) {
            this.u.k();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.o = null;
        }
        t();
        d dVarA = a(0, false);
        if (dVarA != null && dVarA.j != null) {
            dVarA.j.close();
        }
    }

    class b implements hh.a {
        private hh.a b;

        public b(hh.a aVar) {
            this.b = aVar;
        }

        @Override // hh.a
        public boolean a(hh hhVar, Menu menu) {
            return this.b.a(hhVar, menu);
        }

        @Override // hh.a
        public boolean b(hh hhVar, Menu menu) {
            return this.b.b(hhVar, menu);
        }

        @Override // hh.a
        public boolean a(hh hhVar, MenuItem menuItem) {
            return this.b.a(hhVar, menuItem);
        }

        @Override // hh.a
        public void a(hh hhVar) {
            this.b.a(hhVar);
            if (gs.this.o != null) {
                gs.this.b.getDecorView().removeCallbacks(gs.this.p);
            }
            if (gs.this.n != null) {
                gs.this.t();
                gs.this.q = fb.k(gs.this.n).a(0.0f);
                gs.this.q.a(new fg() { // from class: gs.b.1
                    @Override // defpackage.fg, defpackage.ff
                    public void b(View view) {
                        gs.this.n.setVisibility(8);
                        if (gs.this.o != null) {
                            gs.this.o.dismiss();
                        } else if (gs.this.n.getParent() instanceof View) {
                            fb.n((View) gs.this.n.getParent());
                        }
                        gs.this.n.removeAllViews();
                        gs.this.q.a((ff) null);
                        gs.this.q = null;
                    }
                });
            }
            if (gs.this.e != null) {
                gs.this.e.b(gs.this.m);
            }
            gs.this.m = null;
        }
    }

    final class e implements id.a {
        e() {
        }

        @Override // id.a
        public void a(hw hwVar, boolean z) {
            hw hwVarP = hwVar.p();
            boolean z2 = hwVarP != hwVar;
            gs gsVar = gs.this;
            if (z2) {
                hwVar = hwVarP;
            }
            d dVarA = gsVar.a((Menu) hwVar);
            if (dVarA != null) {
                if (z2) {
                    gs.this.a(dVarA.a, dVarA, hwVarP);
                    gs.this.a(dVarA, true);
                } else {
                    gs.this.a(dVarA, z);
                }
            }
        }

        @Override // id.a
        public boolean a(hw hwVar) {
            Window.Callback callbackQ;
            if (hwVar == null && gs.this.h && (callbackQ = gs.this.q()) != null && !gs.this.p()) {
                callbackQ.onMenuOpened(108, hwVar);
                return true;
            }
            return true;
        }
    }

    final class a implements id.a {
        a() {
        }

        @Override // id.a
        public boolean a(hw hwVar) {
            Window.Callback callbackQ = gs.this.q();
            if (callbackQ != null) {
                callbackQ.onMenuOpened(108, hwVar);
                return true;
            }
            return true;
        }

        @Override // id.a
        public void a(hw hwVar, boolean z) {
            gs.this.b(hwVar);
        }
    }

    public static final class d {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        hw j;
        hu k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        d(int i) {
            this.a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(ha.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(ha.a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(ha.i.Theme_AppCompat_CompactMenu, true);
            }
            hj hjVar = new hj(context, 0);
            hjVar.getTheme().setTo(themeNewTheme);
            this.l = hjVar;
            TypedArray typedArrayObtainStyledAttributes = hjVar.obtainStyledAttributes(ha.j.AppCompatTheme);
            this.b = typedArrayObtainStyledAttributes.getResourceId(ha.j.AppCompatTheme_panelBackground, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(ha.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(hw hwVar) {
            if (hwVar != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = hwVar;
                if (hwVar == null || this.k == null) {
                    return;
                }
                hwVar.a(this.k);
            }
        }

        ie a(id.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new hu(this.l, ha.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }
    }

    class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return gs.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            gs.this.e(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(hc.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }
}
