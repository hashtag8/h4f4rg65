package defpackage;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ajv {
    private String A;
    private CharSequence B;
    private Drawable C;
    private int a;
    private int b;
    private int d;
    private String e;
    private int g;
    private awj m;
    private boolean n;
    private MenuItem.OnMenuItemClickListener p;
    private int r;
    private int s;
    private ajs w;
    private ajr x;
    private ajt y;
    private String z;
    private int c = 0;
    private boolean f = true;
    private int h = -1;
    private int i = R.drawable.search;
    private int j = -1;
    private boolean k = false;
    private boolean l = false;
    private int o = R.drawable.dashboard_navigation_leftpanel_icon;
    private boolean q = false;
    private int t = R.color.bg;
    private boolean u = false;
    private SpannableStringBuilder v = null;
    private boolean D = false;

    public ajt a() {
        return this.y;
    }

    protected ajv() {
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        return this.D;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return this.u;
    }

    public int i() {
        return this.g;
    }

    public String j() {
        return this.A;
    }

    public CharSequence k() {
        return this.B;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public int n() {
        return this.t;
    }

    public boolean o() {
        return this.k;
    }

    public MenuItem.OnMenuItemClickListener p() {
        return this.p;
    }

    public int q() {
        return this.c;
    }

    public boolean r() {
        return this.q;
    }

    public int s() {
        return this.o;
    }

    public SpannableStringBuilder t() {
        return this.v;
    }

    public int u() {
        return this.r;
    }

    public int v() {
        return this.s;
    }

    public boolean w() {
        return this.l;
    }

    public awj x() {
        return this.m;
    }

    public boolean y() {
        return this.n;
    }

    public Drawable z() {
        return this.C;
    }

    public ajs A() {
        return this.w;
    }

    public ajr B() {
        return this.x;
    }

    public String C() {
        return this.z;
    }

    public String toString() {
        return bsc.b(this, new ahp());
    }

    public static class a {
        ajv a;

        public a() {
            this.a = new ajv();
        }

        public a(ajv ajvVar) {
            this.a = ajvVar;
        }

        public a a(boolean z) {
            this.a.D = z;
            return this;
        }

        public a a(int i) {
            this.a.a = i;
            return this;
        }

        public a b(int i) {
            this.a.b = i;
            return this;
        }

        public a c(int i) {
            this.a.c = i;
            return this;
        }

        public a d(int i) {
            return a(HarmanApplication.a().getResources().getColor(i));
        }

        public a e(int i) {
            this.a.g = i;
            return this;
        }

        public a f(int i) {
            this.a.h = i;
            return this;
        }

        public a g(int i) {
            return a(HarmanApplication.a().getString(i));
        }

        public a a(String str) {
            this.a.e = str;
            return this;
        }

        public a b(boolean z) {
            this.a.f = z;
            return this;
        }

        public a h(int i) {
            this.a.d = i;
            return this;
        }

        public a i(int i) {
            this.a.o = i;
            return this;
        }

        public a j(int i) {
            this.a.t = i;
            return this;
        }

        public a c(boolean z) {
            this.a.k = z;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.a.B = charSequence;
            return this;
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.a.v = spannableStringBuilder;
            return this;
        }

        public a k(int i) {
            this.a.i = i;
            return this;
        }

        public a l(int i) {
            this.a.j = i;
            return this;
        }

        public a a(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.a.p = onMenuItemClickListener;
            return this;
        }

        public a m(int i) {
            this.a.r = i;
            return this;
        }

        public a d(boolean z) {
            this.a.q = z;
            return this;
        }

        public a n(int i) {
            this.a.s = i;
            return this;
        }

        public a a(ajs ajsVar) {
            this.a.w = ajsVar;
            return this;
        }

        public a a(ajr ajrVar) {
            this.a.x = ajrVar;
            return this;
        }

        public a a(ajt ajtVar) {
            this.a.y = ajtVar;
            return this;
        }

        public a e(boolean z) {
            this.a.l = z;
            return this;
        }

        public a f(boolean z) {
            this.a.n = z;
            return this;
        }

        public a b(String str) {
            this.a.z = str;
            return this;
        }

        public a c(String str) {
            this.a.A = str;
            return this;
        }

        public a a(Drawable drawable) {
            this.a.C = drawable;
            return this;
        }

        public a a() {
            this.a.u = true;
            return this;
        }

        public a b() {
            this.a.u = false;
            return this;
        }

        public ajv c() {
            if (this.a.e != null && this.a.d != 0) {
                throw new RuntimeException("title " + this.a.e + " and logo " + this.a.d + "twoLayerTitleText" + ((Object) this.a.v) + " are mutually exclusive");
            }
            return this.a;
        }
    }
}
