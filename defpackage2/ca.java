package defpackage;

import android.os.Build;
import android.os.Bundle;
import defpackage.cc;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ca extends cc.a {
    public static final cc.a.InterfaceC0136a a;
    private static final a h;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;
    private final Set<String> g;

    interface a {
    }

    @Override // cc.a
    public String a() {
        return this.b;
    }

    @Override // cc.a
    public CharSequence b() {
        return this.c;
    }

    @Override // cc.a
    public CharSequence[] c() {
        return this.d;
    }

    @Override // cc.a
    public Set<String> d() {
        return this.g;
    }

    @Override // cc.a
    public boolean e() {
        return this.e;
    }

    @Override // cc.a
    public Bundle f() {
        return this.f;
    }

    static class c implements a {
        c() {
        }
    }

    static class d implements a {
        d() {
        }
    }

    static class b implements a {
        b() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            h = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            h = new d();
        } else {
            h = new c();
        }
        a = new cc.a.InterfaceC0136a() { // from class: ca.1
        };
    }
}
