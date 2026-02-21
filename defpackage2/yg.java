package defpackage;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import defpackage.yf;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yg extends yh {
    DisplayMetrics a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    private final zp h;
    private final Context i;
    private final WindowManager j;
    private final wv k;
    private float l;
    private int m;

    public yg(zp zpVar, Context context, wv wvVar) {
        super(zpVar);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = zpVar;
        this.i = context;
        this.k = wvVar;
        this.j = (WindowManager) context.getSystemService("window");
    }

    private void g() {
        this.a = new DisplayMetrics();
        Display defaultDisplay = this.j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.a);
        this.l = this.a.density;
        this.m = defaultDisplay.getRotation();
    }

    private void h() {
        int[] iArr = new int[2];
        this.h.getLocationOnScreen(iArr);
        a(rj.a().b(this.i, iArr[0]), rj.a().b(this.i, iArr[1]));
    }

    private yf i() {
        return new yf.a().b(this.k.a()).a(this.k.b()).c(this.k.f()).d(this.k.c()).e(this.k.d()).a();
    }

    void a() {
        this.b = rj.a().b(this.a, this.a.widthPixels);
        this.c = rj.a().b(this.a, this.a.heightPixels);
        Activity activityC = this.h.c();
        if (activityC == null || activityC.getWindow() == null) {
            this.d = this.b;
            this.e = this.c;
        } else {
            int[] iArrA = sy.c().a(activityC);
            this.d = rj.a().b(this.a, iArrA[0]);
            this.e = rj.a().b(this.a, iArrA[1]);
        }
    }

    public void a(int i, int i2) {
        b(i, i2 - (this.i instanceof Activity ? sy.c().d((Activity) this.i)[0] : 0), this.f, this.g);
        this.h.h().a(i, i2);
    }

    void b() {
        if (this.h.g().e) {
            this.f = this.b;
            this.g = this.c;
        } else {
            this.h.measure(0, 0);
            this.f = rj.a().b(this.i, this.h.getMeasuredWidth());
            this.g = rj.a().b(this.i, this.h.getMeasuredHeight());
        }
    }

    public void c() {
        g();
        a();
        b();
        e();
        f();
        h();
        d();
    }

    void d() {
        if (su.a(2)) {
            su.c("Dispatching Ready Event.");
        }
        c(this.h.k().b);
    }

    void e() {
        a(this.b, this.c, this.d, this.e, this.l, this.m);
    }

    void f() {
        this.h.a("onDeviceFeaturesReceived", i().a());
    }
}
