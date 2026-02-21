package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
abstract class ut {
    private static volatile Handler b;
    private final uf a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    ut(uf ufVar) {
        vq.a(ufVar);
        this.a = ufVar;
        this.c = new Runnable() { // from class: ut.1
            @Override // java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    ut.this.a.h().a(this);
                    return;
                }
                boolean zC = ut.this.c();
                ut.this.d = 0L;
                if (!zC || ut.this.e) {
                    return;
                }
                ut.this.a();
            }
        };
    }

    private Handler e() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (ut.class) {
            if (b == null) {
                b = new Handler(this.a.b().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public void a(long j) {
        d();
        if (j >= 0) {
            this.d = this.a.d().a();
            if (e().postDelayed(this.c, j)) {
                return;
            }
            this.a.f().e("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public long b() {
        if (this.d == 0) {
            return 0L;
        }
        return Math.abs(this.a.d().a() - this.d);
    }

    public void b(long j) {
        if (c()) {
            if (j < 0) {
                d();
                return;
            }
            long jAbs = j - Math.abs(this.a.d().a() - this.d);
            long j2 = jAbs >= 0 ? jAbs : 0L;
            e().removeCallbacks(this.c);
            if (e().postDelayed(this.c, j2)) {
                return;
            }
            this.a.f().e("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }

    public boolean c() {
        return this.d != 0;
    }

    public void d() {
        this.d = 0L;
        e().removeCallbacks(this.c);
    }
}
