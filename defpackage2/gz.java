package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import defpackage.gi;
import defpackage.ha;
import defpackage.hh;
import defpackage.hw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class gz extends gi implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s;
    private static final Interpolator t;
    private static final Interpolator u;
    private boolean A;
    private boolean B;
    private boolean D;
    private boolean F;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    jq d;
    ActionBarContextView e;
    View f;
    kk g;
    a h;
    hh i;
    hh.a j;
    boolean l;
    boolean m;
    hn n;
    boolean o;
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;
    private ArrayList<gi.b> C = new ArrayList<>();
    private int E = 0;
    boolean k = true;
    private boolean G = true;
    final ff p = new fg() { // from class: gz.1
        @Override // defpackage.fg, defpackage.ff
        public void b(View view) {
            if (gz.this.k && gz.this.f != null) {
                gz.this.f.setTranslationY(0.0f);
                gz.this.c.setTranslationY(0.0f);
            }
            gz.this.c.setVisibility(8);
            gz.this.c.setTransitioning(false);
            gz.this.n = null;
            gz.this.i();
            if (gz.this.b != null) {
                fb.n(gz.this.b);
            }
        }
    };
    final ff q = new fg() { // from class: gz.2
        @Override // defpackage.fg, defpackage.ff
        public void b(View view) {
            gz.this.n = null;
            gz.this.c.requestLayout();
        }
    };
    final fh r = new fh() { // from class: gz.3
        @Override // defpackage.fh
        public void a(View view) {
            ((View) gz.this.c.getParent()).invalidate();
        }
    };

    static {
        s = !gz.class.desiredAssertionStatus();
        t = new AccelerateInterpolator();
        u = new DecelerateInterpolator();
    }

    public gz(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.f = decorView.findViewById(R.id.content);
        }
    }

    public gz(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(ha.f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(ha.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(ha.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(ha.f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = this.d.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.A = true;
        }
        hg hgVarA = hg.a(this.a);
        d(hgVarA.f() || z);
        n(hgVarA.d());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, ha.j.ActionBar, ha.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(ha.j.ActionBar_hideOnContentScroll, false)) {
            e(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(ha.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private jq b(View view) {
        if (view instanceof jq) {
            return (jq) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    @Override // defpackage.gi
    public void a(float f) {
        fb.a(this.c, f);
    }

    @Override // defpackage.gi
    public void a(Configuration configuration) {
        n(hg.a(this.a).d());
    }

    private void n(boolean z) {
        this.D = z;
        if (!this.D) {
            this.d.a((kk) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        }
        boolean z2 = j() == 2;
        if (this.g != null) {
            if (z2) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    fb.n(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        this.d.a(!this.D && z2);
        this.b.setHasNonEmbeddedTabs(!this.D && z2);
    }

    void i() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void a(int i) {
        this.E = i;
    }

    @Override // defpackage.gi
    public void g(boolean z) {
        this.H = z;
        if (!z && this.n != null) {
            this.n.c();
        }
    }

    @Override // defpackage.gi
    public void h(boolean z) {
        if (z != this.B) {
            this.B = z;
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                this.C.get(i).a(z);
            }
        }
    }

    @Override // defpackage.gi
    public void a(boolean z) {
        a(z ? 1 : 0, 1);
    }

    public void i(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // defpackage.gi
    public void b(boolean z) {
        a(z ? 8 : 0, 8);
    }

    @Override // defpackage.gi
    public void c(boolean z) {
        a(z ? 16 : 0, 16);
    }

    @Override // defpackage.gi
    public void d(boolean z) {
        this.d.b(z);
    }

    @Override // defpackage.gi
    public void a(CharSequence charSequence) {
        this.d.b(charSequence);
    }

    @Override // defpackage.gi
    public void b(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(int i, int i2) {
        int iO = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.c((iO & (i2 ^ (-1))) | (i & i2));
    }

    @Override // defpackage.gi
    public View a() {
        return this.d.q();
    }

    public int j() {
        return this.d.p();
    }

    @Override // defpackage.gi
    public int b() {
        return this.d.o();
    }

    @Override // defpackage.gi
    public hh a(hh.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar2 = new a(this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        m(true);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void j(boolean z) {
        this.k = z;
    }

    private void o() {
        if (!this.F) {
            this.F = true;
            if (this.b != null) {
                this.b.setShowingForActionMode(true);
            }
            o(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            this.m = false;
            o(true);
        }
    }

    private void p() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            o(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void l() {
        if (!this.m) {
            this.m = true;
            o(true);
        }
    }

    @Override // defpackage.gi
    public void e(boolean z) {
        if (z && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.b.setHideOnContentScrollEnabled(z);
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void o(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                k(z);
                return;
            }
            return;
        }
        if (this.G) {
            this.G = false;
            l(z);
        }
    }

    public void k(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r1[1];
            }
            this.c.setTranslationY(f);
            hn hnVar = new hn();
            fe feVarB = fb.k(this.c).b(0.0f);
            feVarB.a(this.r);
            hnVar.a(feVarB);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hnVar.a(fb.k(this.f).b(0.0f));
            }
            hnVar.a(u);
            hnVar.a(250L);
            hnVar.a(this.q);
            this.n = hnVar;
            hnVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            fb.n(this.b);
        }
    }

    public void l(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            hn hnVar = new hn();
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r2[1];
            }
            fe feVarB = fb.k(this.c).b(f);
            feVarB.a(this.r);
            hnVar.a(feVarB);
            if (this.k && this.f != null) {
                hnVar.a(fb.k(this.f).b(f));
            }
            hnVar.a(t);
            hnVar.a(250L);
            hnVar.a(this.p);
            this.n = hnVar;
            hnVar.a();
            return;
        }
        this.p.b(null);
    }

    public void m(boolean z) {
        fe feVarA;
        fe feVarA2;
        if (z) {
            o();
        } else {
            p();
        }
        if (q()) {
            if (z) {
                feVarA2 = this.d.a(4, 100L);
                feVarA = this.e.a(0, 200L);
            } else {
                feVarA = this.d.a(0, 200L);
                feVarA2 = this.e.a(8, 100L);
            }
            hn hnVar = new hn();
            hnVar.a(feVarA2, feVarA);
            hnVar.a();
            return;
        }
        if (z) {
            this.d.d(4);
            this.e.setVisibility(0);
        } else {
            this.d.d(0);
            this.e.setVisibility(8);
        }
    }

    private boolean q() {
        return fb.v(this.c);
    }

    @Override // defpackage.gi
    public Context c() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(ha.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.a, i);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void m() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void n() {
    }

    @Override // defpackage.gi
    public boolean g() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    public class a extends hh implements hw.a {
        private final Context b;
        private final hw c;
        private hh.a d;
        private WeakReference<View> e;

        public a(Context context, hh.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new hw(context).a(1);
            this.c.a(this);
        }

        @Override // defpackage.hh
        public MenuInflater a() {
            return new hm(this.b);
        }

        @Override // defpackage.hh
        public Menu b() {
            return this.c;
        }

        @Override // defpackage.hh
        public void c() {
            if (gz.this.h == this) {
                if (!gz.a(gz.this.l, gz.this.m, false)) {
                    gz.this.i = this;
                    gz.this.j = this.d;
                } else {
                    this.d.a(this);
                }
                this.d = null;
                gz.this.m(false);
                gz.this.e.b();
                gz.this.d.a().sendAccessibilityEvent(32);
                gz.this.b.setHideOnContentScrollEnabled(gz.this.o);
                gz.this.h = null;
            }
        }

        @Override // defpackage.hh
        public void d() {
            if (gz.this.h == this) {
                this.c.g();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.h();
                }
            }
        }

        public boolean e() {
            this.c.g();
            try {
                return this.d.a(this, this.c);
            } finally {
                this.c.h();
            }
        }

        @Override // defpackage.hh
        public void a(View view) {
            gz.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        @Override // defpackage.hh
        public void a(CharSequence charSequence) {
            gz.this.e.setSubtitle(charSequence);
        }

        @Override // defpackage.hh
        public void b(CharSequence charSequence) {
            gz.this.e.setTitle(charSequence);
        }

        @Override // defpackage.hh
        public void a(int i) {
            b(gz.this.a.getResources().getString(i));
        }

        @Override // defpackage.hh
        public void b(int i) {
            a((CharSequence) gz.this.a.getResources().getString(i));
        }

        @Override // defpackage.hh
        public CharSequence f() {
            return gz.this.e.getTitle();
        }

        @Override // defpackage.hh
        public CharSequence g() {
            return gz.this.e.getSubtitle();
        }

        @Override // defpackage.hh
        public void a(boolean z) {
            super.a(z);
            gz.this.e.setTitleOptional(z);
        }

        @Override // defpackage.hh
        public boolean h() {
            return gz.this.e.d();
        }

        @Override // defpackage.hh
        public View i() {
            if (this.e != null) {
                return this.e.get();
            }
            return null;
        }

        @Override // hw.a
        public boolean a(hw hwVar, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a(this, menuItem);
            }
            return false;
        }

        @Override // hw.a
        public void a(hw hwVar) {
            if (this.d != null) {
                d();
                gz.this.e.a();
            }
        }
    }

    @Override // defpackage.gi
    public void f(boolean z) {
        if (!this.A) {
            i(z);
        }
    }

    @Override // defpackage.gi
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuB;
        if (this.h == null || (menuB = this.h.b()) == null) {
            return false;
        }
        menuB.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuB.performShortcut(i, keyEvent, 0);
    }
}
