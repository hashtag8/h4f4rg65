package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.yk;
import defpackage.zq;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
@yx
public class ru extends yk.a implements sd {
    static final int a = Color.argb(0, 0, 0, 0);
    AdOverlayInfoParcel b;
    rz c;
    zp d;
    c e;
    sb f;
    FrameLayout h;
    WebChromeClient.CustomViewCallback i;
    RelativeLayout l;
    private final Activity o;
    private boolean p;
    boolean g = false;
    boolean j = false;
    boolean k = false;
    boolean m = false;
    int n = 0;
    private boolean q = false;
    private boolean r = true;

    @yx
    static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    @yx
    static final class b extends RelativeLayout {
        zh a;

        public b(Context context, String str) {
            super(context);
            this.a = new zh(context, str);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.a.a(motionEvent);
            return false;
        }
    }

    @yx
    public static class c {
        public final int a;
        public final ViewGroup.LayoutParams b;
        public final ViewGroup c;
        public final Context d;

        public c(zp zpVar) throws a {
            this.b = zpVar.getLayoutParams();
            ViewParent parent = zpVar.getParent();
            this.d = zpVar.d();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new a("Could not get the parent of the WebView for an overlay.");
            }
            this.c = (ViewGroup) parent;
            this.a = this.c.indexOfChild(zpVar.getWebView());
            this.c.removeView(zpVar.getWebView());
            zpVar.a(true);
        }
    }

    public ru(Activity activity) {
        this.o = activity;
    }

    public void a() {
        this.n = 2;
        this.o.finish();
    }

    public void a(int i) {
        this.o.setRequestedOrientation(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.c != null) {
            this.c.a(i, i2, i3, i4);
        }
    }

    @Override // defpackage.yk
    public void a(Bundle bundle) {
        this.j = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.b = AdOverlayInfoParcel.a(this.o.getIntent());
            if (this.b == null) {
                throw new a("Could not get info for ad overlay.");
            }
            if (this.b.n.d > 7500000) {
                this.n = 3;
            }
            if (this.o.getIntent() != null) {
                this.r = this.o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.q != null) {
                this.k = this.b.q.b;
            } else {
                this.k = false;
            }
            if (bundle == null) {
                if (this.b.d != null && this.r) {
                    this.b.d.b();
                }
                if (this.b.l != 1 && this.b.c != null) {
                    this.b.c.a();
                }
            }
            this.l = new b(this.o, this.b.p);
            switch (this.b.l) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.e = new c(this.b.e);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                case 4:
                    if (this.j) {
                        this.n = 3;
                        this.o.finish();
                        return;
                    } else {
                        if (sy.a().a(this.o, this.b.b, this.b.j)) {
                            return;
                        }
                        this.n = 3;
                        this.o.finish();
                        return;
                    }
                default:
                    throw new a("Could not determine ad overlay type.");
            }
        } catch (a e) {
            su.e(e.getMessage());
            this.n = 3;
            this.o.finish();
        }
    }

    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.h = new FrameLayout(this.o);
        this.h.setBackgroundColor(-16777216);
        this.h.addView(view, -1, -1);
        this.o.setContentView(this.h);
        l();
        this.i = customViewCallback;
        this.g = true;
    }

    public void a(boolean z) {
        this.f = new sb(this.o, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f.a(z, this.b.h);
        this.l.addView(this.f, layoutParams);
    }

    public void a(boolean z, boolean z2) {
        if (this.f != null) {
            this.f.a(z, z2);
        }
    }

    public rz b() {
        return this.c;
    }

    protected void b(int i) {
        this.d.a(i);
    }

    public void b(int i, int i2, int i3, int i4) {
        if (this.c == null) {
            this.c = new rz(this.o, this.d);
            this.l.addView(this.c, 0, new ViewGroup.LayoutParams(-1, -1));
            this.c.a(i, i2, i3, i4);
            this.d.h().a(false);
        }
    }

    @Override // defpackage.yk
    public void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
    }

    protected void b(boolean z) throws a {
        if (!this.p) {
            this.o.requestWindowFeature(1);
        }
        Window window = this.o.getWindow();
        if (window == null) {
            throw new a("Invalid activity, no window available.");
        }
        if (!this.k || (this.b.q != null && this.b.q.c)) {
            window.setFlags(1024, 1024);
        }
        boolean zB = this.b.e.h().b();
        this.m = false;
        if (zB) {
            if (this.b.k == sy.e().a()) {
                this.m = this.o.getResources().getConfiguration().orientation == 1;
            } else if (this.b.k == sy.e().b()) {
                this.m = this.o.getResources().getConfiguration().orientation == 2;
            }
        }
        su.a("Delay onShow to next orientation change: " + this.m);
        a(this.b.k);
        if (sy.e().a(window)) {
            su.a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.k) {
            this.l.setBackgroundColor(a);
        } else {
            this.l.setBackgroundColor(-16777216);
        }
        this.o.setContentView(this.l);
        l();
        if (z) {
            this.d = sy.d().a(this.o, this.b.e.g(), true, zB, null, this.b.n);
            this.d.h().a(null, null, this.b.f, this.b.j, true, this.b.o, null, this.b.e.h().a(), null);
            this.d.h().a(new zq.a() { // from class: ru.1
                @Override // zq.a
                public void a(zp zpVar, boolean z2) {
                    zpVar.h().e();
                    zpVar.b();
                }
            });
            if (this.b.m != null) {
                this.d.loadUrl(this.b.m);
            } else {
                if (this.b.i == null) {
                    throw new a("No URL or HTML to display in ad overlay.");
                }
                this.d.loadDataWithBaseURL(this.b.g, this.b.i, "text/html", HTTP.UTF_8, null);
            }
            if (this.b.e != null) {
                this.b.e.b(this);
            }
        } else {
            this.d = this.b.e;
            this.d.setContext(this.o);
        }
        this.d.a(this);
        ViewParent parent = this.d.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.d.getWebView());
        }
        if (this.k) {
            this.d.setBackgroundColor(a);
        }
        this.l.addView(this.d.getWebView(), -1, -1);
        if (!z && !this.m) {
            p();
        }
        a(zB);
        if (this.d.i()) {
            a(zB, true);
        }
    }

    public void c() {
        if (this.b != null && this.g) {
            a(this.b.k);
        }
        if (this.h != null) {
            this.o.setContentView(this.l);
            l();
            this.h.removeAllViews();
            this.h = null;
        }
        if (this.i != null) {
            this.i.onCustomViewHidden();
            this.i = null;
        }
        this.g = false;
    }

    @Override // defpackage.sd
    public void d() {
        this.n = 1;
        this.o.finish();
    }

    @Override // defpackage.yk
    public void e() {
        this.n = 0;
    }

    @Override // defpackage.yk
    public void f() {
    }

    @Override // defpackage.yk
    public void g() {
    }

    @Override // defpackage.yk
    public void h() {
        if (this.b != null && this.b.l == 4) {
            if (this.j) {
                this.n = 3;
                this.o.finish();
            } else {
                this.j = true;
            }
        }
        if (this.d == null || this.d.m()) {
            su.e("The webview does not exit. Ignoring action.");
        } else {
            sy.e().b(this.d.getWebView());
        }
    }

    @Override // defpackage.yk
    public void i() {
        if (this.c != null) {
            this.c.g();
        }
        c();
        if (this.d != null && (!this.o.isFinishing() || this.e == null)) {
            sy.e().a(this.d.getWebView());
        }
        n();
    }

    @Override // defpackage.yk
    public void j() {
        n();
    }

    @Override // defpackage.yk
    public void k() {
        if (this.c != null) {
            this.c.l();
        }
        if (this.d != null) {
            this.l.removeView(this.d.getWebView());
        }
        n();
    }

    @Override // defpackage.yk
    public void l() {
        this.p = true;
    }

    public void m() {
        this.l.removeView(this.f);
        a(true);
    }

    protected void n() {
        if (!this.o.isFinishing() || this.q) {
            return;
        }
        this.q = true;
        if (this.o.isFinishing()) {
            if (this.d != null) {
                b(this.n);
                this.l.removeView(this.d.getWebView());
                if (this.e != null) {
                    this.d.setContext(this.e.d);
                    this.d.a(false);
                    this.e.c.addView(this.d.getWebView(), this.e.a, this.e.b);
                    this.e = null;
                }
            }
            if (this.b == null || this.b.d == null) {
                return;
            }
            this.b.d.a();
        }
    }

    public void o() {
        if (this.m) {
            this.m = false;
            p();
        }
    }

    protected void p() {
        this.d.b();
    }
}
