package defpackage;

import android.content.Context;
import defpackage.nu;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class nf implements nt {
    final nv a;
    bno b;
    private final bln j;
    private final bnw k;
    private final Context l;
    private final nq m;
    private final ScheduledExecutorService n;
    private final ni p;
    private final AtomicReference<ScheduledFuture<?>> o = new AtomicReference<>();
    bmc c = new bmc();
    ng d = new nl();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    boolean h = false;
    boolean i = false;

    public nf(bln blnVar, Context context, ScheduledExecutorService scheduledExecutorService, nq nqVar, bnw bnwVar, nv nvVar, ni niVar) {
        this.j = blnVar;
        this.l = context;
        this.n = scheduledExecutorService;
        this.m = nqVar;
        this.k = bnwVar;
        this.a = nvVar;
        this.p = niVar;
    }

    @Override // defpackage.nt
    public void a(bog bogVar, String str) {
        this.b = nb.a(new nr(this.j, str, bogVar.a, this.k, this.c.a(this.l)));
        this.m.a(bogVar);
        this.h = bogVar.f;
        this.i = bogVar.g;
        blh.h().a("Answers", "Firebase analytics forwarding " + (this.h ? "enabled" : "disabled"));
        blh.h().a("Answers", "Firebase analytics including purchase events " + (this.i ? "enabled" : "disabled"));
        this.e = bogVar.h;
        blh.h().a("Answers", "Custom event tracking " + (this.e ? "enabled" : "disabled"));
        this.f = bogVar.i;
        blh.h().a("Answers", "Predefined event tracking " + (this.f ? "enabled" : "disabled"));
        if (bogVar.k > 1) {
            blh.h().a("Answers", "Event sampling enabled");
            this.d = new np(bogVar.k);
        }
        this.g = bogVar.b;
        a(0L, this.g);
    }

    @Override // defpackage.nt
    public void a(nu.a aVar) {
        nu nuVarA = aVar.a(this.a);
        if (!this.e && nu.b.CUSTOM.equals(nuVarA.c)) {
            blh.h().a("Answers", "Custom events tracking disabled - skipping event: " + nuVarA);
            return;
        }
        if (!this.f && nu.b.PREDEFINED.equals(nuVarA.c)) {
            blh.h().a("Answers", "Predefined events tracking disabled - skipping event: " + nuVarA);
            return;
        }
        if (this.d.a(nuVarA)) {
            blh.h().a("Answers", "Skipping filtered event: " + nuVarA);
            return;
        }
        try {
            this.m.a(nuVarA);
        } catch (IOException e) {
            blh.h().e("Answers", "Failed to write event: " + nuVarA, e);
        }
        e();
        boolean z = nu.b.CUSTOM.equals(nuVarA.c) || nu.b.PREDEFINED.equals(nuVarA.c);
        boolean zEquals = "purchase".equals(nuVarA.g);
        if (this.h && z) {
            if (!zEquals || this.i) {
                try {
                    this.p.a(nuVarA);
                } catch (Exception e2) {
                    blh.h().e("Answers", "Failed to map event to Firebase: " + nuVarA, e2);
                }
            }
        }
    }

    public void e() {
        if (this.g != -1) {
            a(this.g, this.g);
        }
    }

    @Override // defpackage.nt
    public void a() {
        int size;
        Exception e;
        if (this.b == null) {
            bme.a(this.l, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        bme.a(this.l, "Sending all files");
        List<File> listE = this.m.e();
        int i = 0;
        while (listE.size() > 0) {
            try {
                bme.a(this.l, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(listE.size())));
                boolean zA = this.b.a(listE);
                if (zA) {
                    size = listE.size() + i;
                    try {
                        this.m.a(listE);
                        i = size;
                    } catch (Exception e2) {
                        e = e2;
                        bme.a(this.l, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
                        i = size;
                    }
                }
                if (!zA) {
                    break;
                } else {
                    listE = this.m.e();
                }
            } catch (Exception e3) {
                size = i;
                e = e3;
            }
        }
        if (i == 0) {
            this.m.g();
        }
    }

    @Override // defpackage.bnn
    public void d() {
        if (this.o.get() != null) {
            bme.a(this.l, "Cancelling time-based rollover because no events are currently being generated.");
            this.o.get().cancel(false);
            this.o.set(null);
        }
    }

    @Override // defpackage.nt
    public void b() {
        this.m.f();
    }

    @Override // defpackage.bnn
    public boolean c() {
        try {
            return this.m.d();
        } catch (IOException e) {
            bme.a(this.l, "Failed to roll file over.", e);
            return false;
        }
    }

    void a(long j, long j2) {
        if (this.o.get() == null) {
            bnr bnrVar = new bnr(this.l, this);
            bme.a(this.l, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.o.set(this.n.scheduleAtFixedRate(bnrVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                bme.a(this.l, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
