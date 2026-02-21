package defpackage;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@bmu(a = {ox.class})
public class ot extends bln<Void> {
    private final long a;
    private final ConcurrentHashMap<String, String> b;
    private ou c;
    private ou d;
    private ov k;
    private os l;
    private String m;
    private String n;
    private String o;
    private float p;
    private boolean q;
    private final pq r;
    private bnw s;
    private or t;
    private ox u;

    public ot() {
        this(1.0f, null, null, false);
    }

    ot(float f, ov ovVar, pq pqVar, boolean z) {
        this(f, ovVar, pqVar, z, bmj.a("Crashlytics Exception Handler"));
    }

    ot(float f, ov ovVar, pq pqVar, boolean z, ExecutorService executorService) {
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = f;
        this.k = ovVar == null ? new b() : ovVar;
        this.r = pqVar;
        this.q = z;
        this.t = new or(executorService);
        this.b = new ConcurrentHashMap<>();
        this.a = System.currentTimeMillis();
    }

    @Override // defpackage.bln
    protected boolean b_() {
        return a(super.r());
    }

    boolean a(Context context) {
        String strA;
        if (!this.q && (strA = new bmc().a(context)) != null) {
            String strM = bme.m(context);
            if (!a(strM, bme.a(context, "com.crashlytics.RequireBuildId", true))) {
                throw new bnd("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            }
            try {
                blh.h().c("CrashlyticsCore", "Initializing Crashlytics " + a());
                boc bocVar = new boc(this);
                this.d = new ou("crash_marker", bocVar);
                this.c = new ou("initialization_marker", bocVar);
                pr prVarA = pr.a(new boe(r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                oy oyVar = this.r != null ? new oy(this.r) : null;
                this.s = new bnt(blh.h());
                this.s.a(oyVar);
                bml bmlVarQ = q();
                oi oiVarA = oi.a(context, bmlVarQ, strA, strM);
                pj pjVar = new pj(context, oiVarA.d);
                oj ojVarA = pc.a(this);
                nh nhVarA = nc.a(context);
                blh.h().a("CrashlyticsCore", "Installer package name is: " + oiVarA.c);
                this.l = new os(this, this.t, this.s, bmlVarQ, prVarA, bocVar, oiVarA, pjVar, ojVarA, nhVarA);
                boolean zM = m();
                x();
                this.l.a(Thread.getDefaultUncaughtExceptionHandler(), new bmk().b(context));
                if (zM && bme.n(context)) {
                    blh.h().a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    w();
                    return false;
                }
                blh.h().a("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Exception e) {
                blh.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.l = null;
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bln
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void f() {
        k();
        this.l.e();
        try {
            this.l.k();
            boy boyVarB = bov.a().b();
            if (boyVarB == null) {
                blh.h().d("CrashlyticsCore", "Received null settings, skipping report submission!");
            } else {
                this.l.a(boyVarB);
                if (boyVarB.d.c) {
                    ow owVarN = n();
                    if (owVarN != null && !this.l.a(owVarN)) {
                        blh.h().a("CrashlyticsCore", "Could not finalize previous NDK sessions.");
                    }
                    if (!this.l.a(boyVarB.b)) {
                        blh.h().a("CrashlyticsCore", "Could not finalize previous sessions.");
                    }
                    this.l.a(this.p, boyVarB);
                } else {
                    blh.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                }
            }
        } catch (Exception e) {
            blh.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            l();
        }
        return null;
    }

    @Override // defpackage.bln
    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    @Override // defpackage.bln
    public String a() {
        return "2.6.1.23";
    }

    public static ot e() {
        return (ot) blh.a(ot.class);
    }

    public void a(String str) {
        b(3, "CrashlyticsCore", str);
    }

    private void b(int i, String str, String str2) {
        if (!this.q && b("prior to logging messages.")) {
            this.l.a(System.currentTimeMillis() - this.a, c(i, str, str2));
        }
    }

    public void a(int i, String str, String str2) {
        b(i, str, str2);
        blh.h().a(i, "" + str, "" + str2, true);
    }

    Map<String, String> g() {
        return Collections.unmodifiableMap(this.b);
    }

    String h() {
        if (q().a()) {
            return this.m;
        }
        return null;
    }

    String i() {
        if (q().a()) {
            return this.n;
        }
        return null;
    }

    String j() {
        if (q().a()) {
            return this.o;
        }
        return null;
    }

    private void w() {
        bmx<Void> bmxVar = new bmx<Void>() { // from class: ot.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                return ot.this.f();
            }

            @Override // defpackage.bna, defpackage.bmz
            public bmv b() {
                return bmv.IMMEDIATE;
            }
        };
        Iterator<bnc> it = v().iterator();
        while (it.hasNext()) {
            bmxVar.c(it.next());
        }
        Future futureSubmit = s().f().submit(bmxVar);
        blh.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            blh.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            blh.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            blh.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    void k() {
        this.t.a(new Callable<Void>() { // from class: ot.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                ot.this.c.a();
                blh.h().a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    void l() {
        this.t.b(new Callable<Boolean>() { // from class: ot.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                try {
                    boolean zC = ot.this.c.c();
                    blh.h().a("CrashlyticsCore", "Initialization marker file removed: " + zC);
                    return Boolean.valueOf(zC);
                } catch (Exception e) {
                    blh.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    boolean m() {
        return this.c.b();
    }

    ow n() {
        if (this.u != null) {
            return this.u.a();
        }
        return null;
    }

    private void x() {
        if (Boolean.TRUE.equals((Boolean) this.t.a(new a(this.d)))) {
            try {
                this.k.a();
            } catch (Exception e) {
                blh.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void o() {
        this.d.a();
    }

    private static String c(int i, String str, String str2) {
        return bme.a(i) + "/" + str + " " + str2;
    }

    private static boolean b(String str) {
        ot otVarE = e();
        if (otVarE != null && otVarE.l != null) {
            return true;
        }
        blh.h().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    static final class a implements Callable<Boolean> {
        private final ou a;

        public a(ou ouVar) {
            this.a = ouVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            if (!this.a.b()) {
                return Boolean.FALSE;
            }
            blh.h().a("CrashlyticsCore", "Found previous crash marker.");
            this.a.c();
            return Boolean.TRUE;
        }
    }

    static final class b implements ov {
        private b() {
        }

        @Override // defpackage.ov
        public void a() {
        }
    }

    static boolean a(String str, boolean z) {
        if (!z) {
            blh.h().a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        }
        if (!bme.d(str)) {
            return true;
        }
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".     |  | ");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".   \\ |  | /");
        Log.e("CrashlyticsCore", ".    \\    /");
        Log.e("CrashlyticsCore", ".     \\  /");
        Log.e("CrashlyticsCore", ".      \\/");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".      /\\");
        Log.e("CrashlyticsCore", ".     /  \\");
        Log.e("CrashlyticsCore", ".    /    \\");
        Log.e("CrashlyticsCore", ".   / |  | \\");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".");
        return false;
    }
}
