package defpackage;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.ha;
import defpackage.hw;
import defpackage.id;

/* JADX INFO: loaded from: classes.dex */
public class kt implements jq {
    Toolbar a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private io n;
    private int o;
    private int p;
    private Drawable q;

    public kt(Toolbar toolbar, boolean z) {
        this(toolbar, z, ha.h.abc_action_bar_up_description, ha.e.abc_ic_ab_back_material);
    }

    public kt(Toolbar toolbar, boolean z, int i, int i2) {
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        ks ksVarA = ks.a(toolbar.getContext(), null, ha.j.ActionBar, ha.a.actionBarStyle, 0);
        this.q = ksVarA.a(ha.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceC = ksVarA.c(ha.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceC)) {
                b(charSequenceC);
            }
            CharSequence charSequenceC2 = ksVarA.c(ha.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceC2)) {
                c(charSequenceC2);
            }
            Drawable drawableA = ksVarA.a(ha.j.ActionBar_logo);
            if (drawableA != null) {
                b(drawableA);
            }
            Drawable drawableA2 = ksVarA.a(ha.j.ActionBar_icon);
            if (drawableA2 != null) {
                a(drawableA2);
            }
            if (this.j == null && this.q != null) {
                c(this.q);
            }
            c(ksVarA.a(ha.j.ActionBar_displayOptions, 0));
            int iG = ksVarA.g(ha.j.ActionBar_customNavigationLayout, 0);
            if (iG != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(iG, (ViewGroup) this.a, false));
                c(this.e | 16);
            }
            int iF = ksVarA.f(ha.j.ActionBar_height, 0);
            if (iF > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iF;
                this.a.setLayoutParams(layoutParams);
            }
            int iD = ksVarA.d(ha.j.ActionBar_contentInsetStart, -1);
            int iD2 = ksVarA.d(ha.j.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.a.a(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iG2 = ksVarA.g(ha.j.ActionBar_titleTextStyle, 0);
            if (iG2 != 0) {
                this.a.a(this.a.getContext(), iG2);
            }
            int iG3 = ksVarA.g(ha.j.ActionBar_subtitleTextStyle, 0);
            if (iG3 != 0) {
                this.a.b(this.a.getContext(), iG3);
            }
            int iG4 = ksVarA.g(ha.j.ActionBar_popupTheme, 0);
            if (iG4 != 0) {
                this.a.setPopupTheme(iG4);
            }
        } else {
            this.e = s();
        }
        ksVarA.a();
        e(i);
        this.m = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View.OnClickListener() { // from class: kt.1
            final hp a;

            {
                this.a = new hp(kt.this.a.getContext(), 0, R.id.home, 0, 0, kt.this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kt.this.c != null && kt.this.d) {
                    kt.this.c.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    public void e(int i) {
        if (i != this.p) {
            this.p = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    private int s() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    @Override // defpackage.jq
    public ViewGroup a() {
        return this.a;
    }

    @Override // defpackage.jq
    public Context b() {
        return this.a.getContext();
    }

    @Override // defpackage.jq
    public boolean c() {
        return this.a.g();
    }

    @Override // defpackage.jq
    public void d() {
        this.a.h();
    }

    @Override // defpackage.jq
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override // defpackage.jq
    public void a(CharSequence charSequence) {
        if (!this.k) {
            e(charSequence);
        }
    }

    @Override // defpackage.jq
    public CharSequence e() {
        return this.a.getTitle();
    }

    @Override // defpackage.jq
    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override // defpackage.jq
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.jq
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.jq
    public void a(int i) {
        a(i != 0 ? hc.b(b(), i) : null);
    }

    @Override // defpackage.jq
    public void a(Drawable drawable) {
        this.h = drawable;
        t();
    }

    @Override // defpackage.jq
    public void b(int i) {
        b(i != 0 ? hc.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        t();
    }

    private void t() {
        Drawable drawable = null;
        if ((this.e & 2) != 0) {
            drawable = ((this.e & 1) == 0 || this.i == null) ? this.h : this.i;
        }
        this.a.setLogo(drawable);
    }

    @Override // defpackage.jq
    public boolean h() {
        return this.a.a();
    }

    @Override // defpackage.jq
    public boolean i() {
        return this.a.b();
    }

    @Override // defpackage.jq
    public boolean j() {
        return this.a.c();
    }

    @Override // defpackage.jq
    public boolean k() {
        return this.a.d();
    }

    @Override // defpackage.jq
    public boolean l() {
        return this.a.e();
    }

    @Override // defpackage.jq
    public void m() {
        this.d = true;
    }

    @Override // defpackage.jq
    public void a(Menu menu, id.a aVar) {
        if (this.n == null) {
            this.n = new io(this.a.getContext());
            this.n.a(ha.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.a.a((hw) menu, this.n);
    }

    @Override // defpackage.jq
    public void n() {
        this.a.f();
    }

    @Override // defpackage.jq
    public int o() {
        return this.e;
    }

    @Override // defpackage.jq
    public void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    v();
                }
                u();
            }
            if ((i2 & 3) != 0) {
                t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.g != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.g);
                } else {
                    this.a.removeView(this.g);
                }
            }
        }
    }

    @Override // defpackage.jq
    public void a(kk kkVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = kkVar;
        if (kkVar != null && this.o == 2) {
            this.a.addView(this.f, 0);
            Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.a = 8388691;
            kkVar.setAllowCollapse(true);
        }
    }

    @Override // defpackage.jq
    public void a(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // defpackage.jq
    public void b(boolean z) {
    }

    @Override // defpackage.jq
    public int p() {
        return this.o;
    }

    public void a(View view) {
        if (this.g != null && (this.e & 16) != 0) {
            this.a.removeView(this.g);
        }
        this.g = view;
        if (view != null && (this.e & 16) != 0) {
            this.a.addView(this.g);
        }
    }

    @Override // defpackage.jq
    public View q() {
        return this.g;
    }

    @Override // defpackage.jq
    public fe a(final int i, long j) {
        return fb.k(this.a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new fg() { // from class: kt.2
            private boolean c = false;

            @Override // defpackage.fg, defpackage.ff
            public void a(View view) {
                kt.this.a.setVisibility(0);
            }

            @Override // defpackage.fg, defpackage.ff
            public void b(View view) {
                if (!this.c) {
                    kt.this.a.setVisibility(i);
                }
            }

            @Override // defpackage.fg, defpackage.ff
            public void c(View view) {
                this.c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        u();
    }

    private void u() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.j != null ? this.j : this.q);
        } else {
            this.a.setNavigationIcon((Drawable) null);
        }
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        v();
    }

    public void f(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void v() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.m)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.m);
            }
        }
    }

    @Override // defpackage.jq
    public void d(int i) {
        this.a.setVisibility(i);
    }

    @Override // defpackage.jq
    public void a(id.a aVar, hw.a aVar2) {
        this.a.a(aVar, aVar2);
    }

    @Override // defpackage.jq
    public Menu r() {
        return this.a.getMenu();
    }
}
