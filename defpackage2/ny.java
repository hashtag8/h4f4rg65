package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import defpackage.bml;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class ny implements oh {
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private Context c;
    private oa d;
    private bml e;
    private bok f;
    private ob g;
    private bod h;
    private bmg i;
    private bnw j;
    private long k;

    public ny() {
        this(false);
    }

    public ny(boolean z) {
        this.a = new AtomicBoolean();
        this.k = 0L;
        this.b = new AtomicBoolean(z);
    }

    @Override // defpackage.oh
    public void a(Context context, oa oaVar, bml bmlVar, bok bokVar, ob obVar, bod bodVar, bmg bmgVar, bnw bnwVar) {
        this.c = context;
        this.d = oaVar;
        this.e = bmlVar;
        this.f = bokVar;
        this.g = obVar;
        this.h = bodVar;
        this.i = bmgVar;
        this.j = bnwVar;
        if (b()) {
            c();
        }
    }

    protected boolean a() {
        this.b.set(true);
        return this.a.get();
    }

    boolean b() {
        this.a.set(true);
        return this.b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void c() {
        synchronized (this.h) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long jA = this.i.a();
        long j = ((long) this.f.b) * 1000;
        blh.h().a("Beta", "Check for updates delay: " + j);
        blh.h().a("Beta", "Check for updates last check time: " + d());
        long jD = j + d();
        blh.h().a("Beta", "Check for updates current time: " + jA + ", next check time: " + jD);
        if (jA >= jD) {
            try {
                e();
                return;
            } finally {
                a(jA);
            }
        }
        blh.h().a("Beta", "Check for updates next check time was not passed");
    }

    private void e() throws Throwable {
        blh.h().a("Beta", "Performing update check");
        new oc(this.d, this.d.g(), this.f.a, this.j, new oe()).a(new bmc().a(this.c), this.e.h().get(bml.a.FONT_TOKEN), this.g);
    }

    void a(long j) {
        this.k = j;
    }

    long d() {
        return this.k;
    }
}
