package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class ub extends ud {
    private final ul a;

    public ub(uf ufVar, ug ugVar) {
        super(ufVar);
        vq.a(ugVar);
        this.a = ugVar.j(ufVar);
    }

    public long a(uh uhVar) {
        D();
        vq.a(uhVar);
        m();
        long jA = this.a.a(uhVar, true);
        if (jA == 0) {
            this.a.a(uhVar);
        }
        return jA;
    }

    @Override // defpackage.ud
    protected void a() {
        this.a.E();
    }

    public void a(final String str, final Runnable runnable) {
        vq.a(str, (Object) "campaign param can't be empty");
        r().a(new Runnable() { // from class: ub.2
            @Override // java.lang.Runnable
            public void run() {
                ub.this.a.a(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void a(final tq tqVar) {
        vq.a(tqVar);
        D();
        b("Hit delivery requested", tqVar);
        r().a(new Runnable() { // from class: ub.3
            @Override // java.lang.Runnable
            public void run() {
                ub.this.a.a(tqVar);
            }
        });
    }

    public void a(final uw uwVar) {
        D();
        r().a(new Runnable() { // from class: ub.4
            @Override // java.lang.Runnable
            public void run() {
                ub.this.a.a(uwVar);
            }
        });
    }

    public void a(final boolean z) {
        a("Network connectivity status changed", Boolean.valueOf(z));
        r().a(new Runnable() { // from class: ub.1
            @Override // java.lang.Runnable
            public void run() {
                ub.this.a.a(z);
            }
        });
    }

    public void b() {
        this.a.b();
    }

    public void c() {
        D();
        Context contextO = o();
        if (!td.a(contextO) || !te.a(contextO)) {
            a((uw) null);
            return;
        }
        Intent intent = new Intent(contextO, (Class<?>) te.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        contextO.startService(intent);
    }

    public void d() {
        D();
        aau.d();
        this.a.f();
    }

    public void e() {
        b("Radio powered up");
        c();
    }

    void f() {
        m();
        this.a.e();
    }

    void g() {
        m();
        this.a.d();
    }
}
