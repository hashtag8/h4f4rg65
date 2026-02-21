package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bgw {
    public static final bqv a = bqv.a(":status");
    public static final bqv b = bqv.a(":method");
    public static final bqv c = bqv.a(":path");
    public static final bqv d = bqv.a(":scheme");
    public static final bqv e = bqv.a(":authority");
    public static final bqv f = bqv.a(":host");
    public static final bqv g = bqv.a(":version");
    public final bqv h;
    public final bqv i;
    final int j;

    public bgw(String str, String str2) {
        this(bqv.a(str), bqv.a(str2));
    }

    public bgw(bqv bqvVar, String str) {
        this(bqvVar, bqv.a(str));
    }

    public bgw(bqv bqvVar, bqv bqvVar2) {
        this.h = bqvVar;
        this.i = bqvVar2;
        this.j = bqvVar.f() + 32 + bqvVar2.f();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bgw)) {
            return false;
        }
        bgw bgwVar = (bgw) obj;
        return this.h.equals(bgwVar.h) && this.i.equals(bgwVar.i);
    }

    public int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + this.i.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.h.a(), this.i.a());
    }
}
