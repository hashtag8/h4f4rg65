package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class th extends va {
    private static List<Runnable> b = new ArrayList();
    private boolean c;
    private boolean d;
    private Set<Object> e;
    private boolean f;
    private volatile boolean g;

    public th(uf ufVar) {
        super(ufVar);
        this.e = new HashSet();
    }

    public static th a(Context context) {
        return uf.a(context).k();
    }

    public static void d() {
        synchronized (th.class) {
            if (b != null) {
                Iterator<Runnable> it = b.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                b = null;
            }
        }
    }

    private ua n() {
        return i().l();
    }

    public tk a(String str) {
        tk tkVar;
        synchronized (this) {
            tkVar = new tk(i(), str, null);
            tkVar.E();
        }
        return tkVar;
    }

    public void a() {
        b();
        this.c = true;
    }

    public void a(boolean z) {
        this.f = z;
    }

    void b() {
        tj tjVarA;
        ua uaVarN = n();
        if (uaVarN.d()) {
            g().a(uaVarN.e());
        }
        if (uaVarN.h()) {
            a(uaVarN.i());
        }
        if (!uaVarN.d() || (tjVarA = tt.a()) == null) {
            return;
        }
        tjVarA.a(uaVarN.e());
    }

    public boolean c() {
        return this.c && !this.d;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    @Deprecated
    public tj g() {
        return tt.a();
    }

    public String h() {
        vq.c("getClientId can not be called from the main thread");
        return i().p().b();
    }
}
