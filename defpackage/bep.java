package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bep {
    public static final bep a = new a().a().d();
    public static final bep b = new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).d();
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;

    private bep(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.c = str;
    }

    private bep(a aVar) {
        this.d = aVar.a;
        this.e = aVar.b;
        this.f = aVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public static bep a(bfa bfaVar) {
        boolean z;
        String str;
        boolean z2 = false;
        boolean z3 = false;
        int iB = -1;
        int iB2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iB3 = -1;
        int iB4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        int iA = bfaVar.a();
        int i = 0;
        String str2 = null;
        while (true) {
            z = z2;
            if (i >= iA) {
                break;
            }
            String strA = bfaVar.a(i);
            String strB = bfaVar.b(i);
            if (strA.equalsIgnoreCase("Cache-Control")) {
                if (str2 != null) {
                    z9 = false;
                } else {
                    str2 = strB;
                }
            } else if (!strA.equalsIgnoreCase("Pragma")) {
                z2 = z;
                i++;
            } else {
                z9 = false;
            }
            z2 = z;
            int i2 = 0;
            while (i2 < strB.length()) {
                int iA2 = bgb.a(strB, i2, "=,;");
                String strTrim = strB.substring(i2, iA2).trim();
                if (iA2 == strB.length() || strB.charAt(iA2) == ',' || strB.charAt(iA2) == ';') {
                    i2 = iA2 + 1;
                    str = null;
                } else {
                    int iA3 = bgb.a(strB, iA2 + 1);
                    if (iA3 < strB.length() && strB.charAt(iA3) == '\"') {
                        int i3 = iA3 + 1;
                        int iA4 = bgb.a(strB, i3, "\"");
                        String strSubstring = strB.substring(i3, iA4);
                        i2 = iA4 + 1;
                        str = strSubstring;
                    } else {
                        int iA5 = bgb.a(strB, iA3, ",;");
                        String strTrim2 = strB.substring(iA3, iA5).trim();
                        i2 = iA5;
                        str = strTrim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iB = bgb.b(str, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iB2 = bgb.b(str, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iB3 = bgb.b(str, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iB4 = bgb.b(str, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                }
            }
            i++;
        }
        return new bep(z, z3, iB, iB2, z4, z5, z6, iB3, iB4, z7, z8, !z9 ? null : str2);
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String strJ = j();
        this.c = strJ;
        return strJ;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;

        public a a() {
            this.a = true;
            return this;
        }

        public a b() {
            this.b = true;
            return this;
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public a c() {
            this.f = true;
            return this;
        }

        public bep d() {
            return new bep(this);
        }
    }
}
