package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class aqj {
    private final WeakReference<ajk> a;
    private final WeakReference<be> b;
    private final String c;
    private final int d;
    private final int e;
    private final int f;
    private final boolean g;

    public aqj(ajk ajkVar, be beVar, String str, int i, int i2, int i3, boolean z) {
        this.a = new WeakReference<>(ajkVar);
        this.b = new WeakReference<>(beVar);
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = z;
    }

    public ajk a() {
        return this.a.get();
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.g;
    }

    public boolean f() {
        ajk ajkVar = this.a.get();
        return (ajkVar == null || ajkVar.w()) ? false : true;
    }

    public String toString() {
        ahp ahpVar = new ahp();
        ahpVar.a(false);
        bsc bscVar = new bsc(this, ahpVar);
        ajk ajkVar = this.a.get();
        if (ajkVar != null) {
            bscVar.a("fragment", ajkVar.k());
        }
        return bscVar.a("backstackTag", this.c).a("backstackId", this.d).toString();
    }

    public int g() {
        return this.f;
    }

    public be h() {
        return this.b.get();
    }
}
