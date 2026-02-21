package defpackage;

import android.app.Application;
import android.content.Context;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
public class uf {
    private static uf a;
    private final Context b;
    private final Context c;
    private final aah d;
    private final ur e;
    private final tu f;
    private final aau g;
    private final ub h;
    private final uv i;
    private final ua j;
    private final tx k;
    private final th l;
    private final un m;
    private final to n;
    private final uk o;
    private final uu p;

    protected uf(ug ugVar) {
        Context contextA = ugVar.a();
        vq.a(contextA, "Application context can't be null");
        vq.b(contextA instanceof Application, "getApplicationContext didn't return the application");
        Context contextB = ugVar.b();
        vq.a(contextB);
        this.b = contextA;
        this.c = contextB;
        this.d = ugVar.h(this);
        this.e = ugVar.g(this);
        tu tuVarF = ugVar.f(this);
        tuVarF.E();
        this.f = tuVarF;
        if (e().a()) {
            f().d("Google Analytics " + ue.a + " is starting up.");
        } else {
            f().d("Google Analytics " + ue.a + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        tx txVarQ = ugVar.q(this);
        txVarQ.E();
        this.k = txVarQ;
        ua uaVarE = ugVar.e(this);
        uaVarE.E();
        this.j = uaVarE;
        ub ubVarL = ugVar.l(this);
        un unVarD = ugVar.d(this);
        to toVarC = ugVar.c(this);
        uk ukVarB = ugVar.b(this);
        uu uuVarA = ugVar.a(this);
        aau aauVarA = ugVar.a(contextA);
        aauVarA.a(a());
        this.g = aauVarA;
        th thVarI = ugVar.i(this);
        unVarD.E();
        this.m = unVarD;
        toVarC.E();
        this.n = toVarC;
        ukVarB.E();
        this.o = ukVarB;
        uuVarA.E();
        this.p = uuVarA;
        uv uvVarP = ugVar.p(this);
        uvVarP.E();
        this.i = uvVarP;
        ubVarL.E();
        this.h = ubVarL;
        if (e().a()) {
            f().b("Device AnalyticsService version", ue.a);
        }
        thVarI.a();
        this.l = thVarI;
        ubVarL.b();
    }

    public static uf a(Context context) {
        vq.a(context);
        if (a == null) {
            synchronized (uf.class) {
                if (a == null) {
                    aah aahVarC = aai.c();
                    long jB = aahVarC.b();
                    uf ufVar = new uf(new ug(context.getApplicationContext()));
                    a = ufVar;
                    th.d();
                    long jB2 = aahVarC.b() - jB;
                    long jLongValue = uy.Q.a().longValue();
                    if (jB2 > jLongValue) {
                        ufVar.f().c("Slow initialization (ms)", Long.valueOf(jB2), Long.valueOf(jLongValue));
                    }
                }
            }
        }
        return a;
    }

    private void a(ud udVar) {
        vq.a(udVar, "Analytics service not created/initialized");
        vq.b(udVar.C(), "Analytics service not initialized");
    }

    protected Thread.UncaughtExceptionHandler a() {
        return new Thread.UncaughtExceptionHandler() { // from class: uf.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                tu tuVarG = uf.this.g();
                if (tuVarG != null) {
                    tuVarG.e("Job execution failed", th);
                }
            }
        };
    }

    public Context b() {
        return this.b;
    }

    public Context c() {
        return this.c;
    }

    public aah d() {
        return this.d;
    }

    public ur e() {
        return this.e;
    }

    public tu f() {
        a(this.f);
        return this.f;
    }

    public tu g() {
        return this.f;
    }

    public aau h() {
        vq.a(this.g);
        return this.g;
    }

    public ub i() {
        a(this.h);
        return this.h;
    }

    public uv j() {
        a(this.i);
        return this.i;
    }

    public th k() {
        vq.a(this.l);
        vq.b(this.l.c(), "Analytics instance not initialized");
        return this.l;
    }

    public ua l() {
        a(this.j);
        return this.j;
    }

    public tx m() {
        a(this.k);
        return this.k;
    }

    public tx n() {
        if (this.k == null || !this.k.C()) {
            return null;
        }
        return this.k;
    }

    public to o() {
        a(this.n);
        return this.n;
    }

    public un p() {
        a(this.m);
        return this.m;
    }

    public uk q() {
        a(this.o);
        return this.o;
    }

    public uu r() {
        return this.p;
    }

    public void s() {
        aau.d();
    }
}
