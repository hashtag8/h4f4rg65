package defpackage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yc extends yh {
    static final Set<String> a = new HashSet(Arrays.asList("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"));
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Object j;
    private final zp k;
    private final Activity l;
    private AdSizeParcel m;
    private ImageView n;
    private LinearLayout o;
    private yi p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public yc(zp zpVar, yi yiVar) {
        super(zpVar, "resize");
        this.b = "top-right";
        this.c = true;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.j = new Object();
        this.k = zpVar;
        this.l = zpVar.c();
        this.p = yiVar;
    }

    private void b(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.i = sy.c().a(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.f = sy.c().a(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.g = sy.c().a(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.h = sy.c().a(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.c = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    private int[] d() {
        if (!c()) {
            return null;
        }
        if (this.c) {
            return new int[]{this.d + this.g, this.e + this.h};
        }
        int[] iArrB = sy.c().b(this.l);
        int[] iArrD = sy.c().d(this.l);
        int i = iArrB[0];
        int i2 = this.d + this.g;
        int i3 = this.e + this.h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.i + i2 > i) {
            i2 = i - this.i;
        }
        if (i3 < iArrD[0]) {
            i3 = iArrD[0];
        } else if (this.f + i3 > iArrD[1]) {
            i3 = iArrD[1] - this.f;
        }
        return new int[]{i2, i3};
    }

    void a(int i, int i2) {
        if (this.p != null) {
            this.p.a(i, i2, this.i, this.f);
        }
    }

    public void a(Map<String, String> map) {
        RelativeLayout.LayoutParams layoutParams;
        synchronized (this.j) {
            if (this.l == null) {
                b("Not an activity context. Cannot resize.");
                return;
            }
            if (this.k.g() == null) {
                b("Webview is not yet available, size is not set.");
                return;
            }
            if (this.k.g().e) {
                b("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.k.l()) {
                b("Cannot resize an expanded banner.");
                return;
            }
            b(map);
            if (!a()) {
                b("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.l.getWindow();
            if (window == null || window.getDecorView() == null) {
                b("Activity context is not ready, cannot get window or decor view.");
                return;
            }
            int[] iArrD = d();
            if (iArrD == null) {
                b("Resize location out of screen or close button is not visible.");
                return;
            }
            int iA = rj.a().a(this.l, this.i);
            int iA2 = rj.a().a(this.l, this.f);
            ViewParent parent = this.k.getWebView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                b("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            ((ViewGroup) parent).removeView(this.k.getWebView());
            if (this.q == null) {
                this.s = (ViewGroup) parent;
                Bitmap bitmapA = sy.c().a(this.k.getWebView());
                this.n = new ImageView(this.l);
                this.n.setImageBitmap(bitmapA);
                this.m = this.k.g();
                this.s.addView(this.n);
            } else {
                this.q.dismiss();
            }
            this.r = new RelativeLayout(this.l);
            this.r.setBackgroundColor(0);
            this.r.setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
            this.q = sy.c().a((View) this.r, iA, iA2, false);
            this.q.setOutsideTouchable(true);
            this.q.setTouchable(true);
            this.q.setClippingEnabled(!this.c);
            this.r.addView(this.k.getWebView(), -1, -1);
            this.o = new LinearLayout(this.l);
            layoutParams = new RelativeLayout.LayoutParams(rj.a().a(this.l, 50), rj.a().a(this.l, 50));
            switch (this.b) {
                case "top-left":
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case "top-center":
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case "center":
                    layoutParams.addRule(13);
                    break;
                case "bottom-left":
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case "bottom-center":
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case "bottom-right":
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            this.o.setOnClickListener(new View.OnClickListener() { // from class: yc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    yc.this.a(true);
                }
            });
            this.o.setContentDescription("Close button");
            this.r.addView(this.o, layoutParams);
            try {
                this.q.showAtLocation(window.getDecorView(), 0, rj.a().a(this.l, iArrD[0]), rj.a().a(this.l, iArrD[1]));
                a(iArrD[0], iArrD[1]);
                this.k.a(new AdSizeParcel(this.l, new qz(this.i, this.f)));
                b(iArrD[0], iArrD[1]);
                d("resized");
            } catch (RuntimeException e) {
                b("Cannot show popup window: " + e.getMessage());
                this.r.removeView(this.k.getWebView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getWebView());
                    this.k.a(this.m);
                }
            }
        }
    }

    public void a(boolean z) {
        synchronized (this.j) {
            if (this.q != null) {
                this.q.dismiss();
                this.r.removeView(this.k.getWebView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getWebView());
                    this.k.a(this.m);
                }
                if (z) {
                    d("default");
                    if (this.p != null) {
                        this.p.a();
                    }
                }
                this.q = null;
                this.r = null;
                this.s = null;
                this.o = null;
            }
        }
    }

    boolean a() {
        return this.i > -1 && this.f > -1;
    }

    void b(int i, int i2) {
        a(i, i2 - sy.c().d(this.l)[0], this.i, this.f);
    }

    public boolean b() {
        boolean z;
        synchronized (this.j) {
            z = this.q != null;
        }
        return z;
    }

    public void c(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    boolean c() {
        int i;
        int i2;
        int[] iArrB = sy.c().b(this.l);
        int[] iArrD = sy.c().d(this.l);
        int i3 = iArrB[0];
        int i4 = iArrB[1];
        if (this.i < 50 || this.i > i3) {
            su.e("Width is too small or too large.");
            return false;
        }
        if (this.f < 50 || this.f > i4) {
            su.e("Height is too small or too large.");
            return false;
        }
        if (this.f == i4 && this.i == i3) {
            su.e("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.c) {
            switch (this.b) {
                case "top-left":
                    i = this.g + this.d;
                    i2 = this.e + this.h;
                    break;
                case "top-center":
                    i = ((this.d + this.g) + (this.i / 2)) - 25;
                    i2 = this.e + this.h;
                    break;
                case "center":
                    i = ((this.d + this.g) + (this.i / 2)) - 25;
                    i2 = ((this.e + this.h) + (this.f / 2)) - 25;
                    break;
                case "bottom-left":
                    i = this.g + this.d;
                    i2 = ((this.e + this.h) + this.f) - 50;
                    break;
                case "bottom-center":
                    i = ((this.d + this.g) + (this.i / 2)) - 25;
                    i2 = ((this.e + this.h) + this.f) - 50;
                    break;
                case "bottom-right":
                    i = ((this.d + this.g) + this.i) - 50;
                    i2 = ((this.e + this.h) + this.f) - 50;
                    break;
                default:
                    i = ((this.d + this.g) + this.i) - 50;
                    i2 = this.e + this.h;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < iArrD[0] || i2 + 50 > iArrD[1]) {
                return false;
            }
        }
        return true;
    }
}
