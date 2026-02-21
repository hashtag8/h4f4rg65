package defpackage;

import android.content.Context;
import defpackage.nu;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
class mx implements bnm {
    final ScheduledExecutorService a;
    nt b = new ne();
    private final bln c;
    private final Context d;
    private final my e;
    private final nx f;
    private final bnw g;
    private final ni h;

    public mx(bln blnVar, Context context, my myVar, nx nxVar, bnw bnwVar, ScheduledExecutorService scheduledExecutorService, ni niVar) {
        this.c = blnVar;
        this.d = context;
        this.e = myVar;
        this.f = nxVar;
        this.g = bnwVar;
        this.a = scheduledExecutorService;
        this.h = niVar;
    }

    public void a(nu.a aVar) {
        a(aVar, false, false);
    }

    public void b(nu.a aVar) {
        a(aVar, false, true);
    }

    public void c(nu.a aVar) {
        a(aVar, true, false);
    }

    public void a(final bog bogVar, final String str) {
        b(new Runnable() { // from class: mx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mx.this.b.a(bogVar, str);
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void a() {
        b(new Runnable() { // from class: mx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nt ntVar = mx.this.b;
                    mx.this.b = new ne();
                    ntVar.b();
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to disable events", e);
                }
            }
        });
    }

    @Override // defpackage.bnm
    public void a(String str) {
        b(new Runnable() { // from class: mx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mx.this.b.a();
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to send events files", e);
                }
            }
        });
    }

    public void b() {
        b(new Runnable() { // from class: mx.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nv nvVarA = mx.this.f.a();
                    nq nqVarA = mx.this.e.a();
                    nqVarA.a((bnm) mx.this);
                    mx.this.b = new nf(mx.this.c, mx.this.d, mx.this.a, nqVarA, mx.this.g, nvVarA, mx.this.h);
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to enable events", e);
                }
            }
        });
    }

    public void c() {
        b(new Runnable() { // from class: mx.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mx.this.b.c();
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to flush events", e);
                }
            }
        });
    }

    void a(final nu.a aVar, boolean z, final boolean z2) {
        Runnable runnable = new Runnable() { // from class: mx.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mx.this.b.a(aVar);
                    if (z2) {
                        mx.this.b.c();
                    }
                } catch (Exception e) {
                    blh.h().e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            a(runnable);
        } else {
            b(runnable);
        }
    }

    private void a(Runnable runnable) {
        try {
            this.a.submit(runnable).get();
        } catch (Exception e) {
            blh.h().e("Answers", "Failed to run events task", e);
        }
    }

    private void b(Runnable runnable) {
        try {
            this.a.submit(runnable);
        } catch (Exception e) {
            blh.h().e("Answers", "Failed to submit events task", e);
        }
    }
}
