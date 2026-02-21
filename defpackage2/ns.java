package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import defpackage.nd;
import defpackage.nu;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
class ns implements nd.a {
    final mx a;
    final blf b;
    final nd c;
    final na d;
    private final long e;

    public static ns a(bln blnVar, Context context, bml bmlVar, String str, String str2, long j) {
        nx nxVar = new nx(context, bmlVar, str, str2);
        my myVar = new my(context, new boc(blnVar));
        bnt bntVar = new bnt(blh.h());
        blf blfVar = new blf(context);
        ScheduledExecutorService scheduledExecutorServiceB = bmj.b("Answers Events Handler");
        return new ns(new mx(blnVar, context, myVar, nxVar, bntVar, scheduledExecutorServiceB, new ni(context)), blfVar, new nd(scheduledExecutorServiceB), na.a(context), j);
    }

    ns(mx mxVar, blf blfVar, nd ndVar, na naVar, long j) {
        this.a = mxVar;
        this.b = blfVar;
        this.c = ndVar;
        this.d = naVar;
        this.e = j;
    }

    public void b() {
        this.a.b();
        this.b.a(new mz(this, this.c));
        this.c.a(this);
        if (d()) {
            a(this.e);
            this.d.a();
        }
    }

    public void c() {
        this.b.a();
        this.a.a();
    }

    public void a(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        blh.h().a("Answers", "Logged crash");
        this.a.c(nu.a(str, str2));
    }

    public void a(long j) {
        blh.h().a("Answers", "Logged install");
        this.a.b(nu.a(j));
    }

    public void a(Activity activity, nu.b bVar) {
        blh.h().a("Answers", "Logged lifecycle event: " + bVar.name());
        this.a.a(nu.a(bVar, activity));
    }

    @Override // nd.a
    public void a() {
        blh.h().a("Answers", "Flush events when app is backgrounded");
        this.a.c();
    }

    public void a(bog bogVar, String str) {
        this.c.a(bogVar.j);
        this.a.a(bogVar, str);
    }

    boolean d() {
        return !this.d.b();
    }
}
