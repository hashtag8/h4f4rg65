package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ur {
    private final uf a;
    private Boolean b;
    private String c;
    private Set<Integer> d;

    protected ur(uf ufVar) {
        vq.a(ufVar);
        this.a = ufVar;
    }

    public String A() {
        return "google_analytics_v4.db";
    }

    public String B() {
        return "google_analytics2_v4.db";
    }

    public long C() {
        return 86400000L;
    }

    public int D() {
        return uy.E.a().intValue();
    }

    public int E() {
        return uy.F.a().intValue();
    }

    public long F() {
        return uy.G.a().longValue();
    }

    public long G() {
        return uy.P.a().longValue();
    }

    public boolean a() {
        return vl.a;
    }

    public boolean b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    Context contextB = this.a.b();
                    ApplicationInfo applicationInfo = contextB.getApplicationInfo();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        ActivityManager activityManager = (ActivityManager) contextB.getSystemService("activity");
                        if (activityManager != null) {
                            int iMyPid = Process.myPid();
                            Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (iMyPid == next.pid) {
                                    this.b = Boolean.valueOf(str != null && str.equals(next.processName));
                                }
                            }
                        }
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        this.a.f().f("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public boolean c() {
        return uy.b.a().booleanValue();
    }

    public int d() {
        return uy.u.a().intValue();
    }

    public int e() {
        return uy.y.a().intValue();
    }

    public int f() {
        return uy.z.a().intValue();
    }

    public int g() {
        return uy.A.a().intValue();
    }

    public long h() {
        return uy.j.a().longValue();
    }

    public long i() {
        return uy.i.a().longValue();
    }

    public long j() {
        return uy.m.a().longValue();
    }

    public long k() {
        return uy.n.a().longValue();
    }

    public int l() {
        return uy.o.a().intValue();
    }

    public int m() {
        return uy.p.a().intValue();
    }

    public long n() {
        return uy.C.a().intValue();
    }

    public String o() {
        return uy.r.a();
    }

    public String p() {
        return uy.q.a();
    }

    public String q() {
        return uy.s.a();
    }

    public String r() {
        return uy.t.a();
    }

    public um s() {
        return um.a(uy.v.a());
    }

    public uo t() {
        return uo.a(uy.w.a());
    }

    public Set<Integer> u() {
        String strA = uy.B.a();
        if (this.d == null || this.c == null || !this.c.equals(strA)) {
            String[] strArrSplit = TextUtils.split(strA, ",");
            HashSet hashSet = new HashSet();
            for (String str : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                }
            }
            this.c = strA;
            this.d = hashSet;
        }
        return this.d;
    }

    public long v() {
        return uy.K.a().longValue();
    }

    public long w() {
        return uy.L.a().longValue();
    }

    public long x() {
        return uy.O.a().longValue();
    }

    public int y() {
        return uy.f.a().intValue();
    }

    public int z() {
        return uy.h.a().intValue();
    }
}
