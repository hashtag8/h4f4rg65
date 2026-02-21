package defpackage;

import defpackage.bfg;
import defpackage.bfi;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class bga {
    public final bfg a;
    public final bfi b;

    private bga(bfg bfgVar, bfi bfiVar) {
        this.a = bfgVar;
        this.b = bfiVar;
    }

    public static boolean a(bfi bfiVar, bfg bfgVar) {
        switch (bfiVar.c()) {
            case HttpStatus.SC_OK /* 200 */:
            case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
            case HttpStatus.SC_NO_CONTENT /* 204 */:
            case HttpStatus.SC_MULTIPLE_CHOICES /* 300 */:
            case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
            case 308:
            case HttpStatus.SC_NOT_FOUND /* 404 */:
            case HttpStatus.SC_METHOD_NOT_ALLOWED /* 405 */:
            case HttpStatus.SC_GONE /* 410 */:
            case HttpStatus.SC_REQUEST_URI_TOO_LONG /* 414 */:
            case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                break;
            case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
            case HttpStatus.SC_TEMPORARY_REDIRECT /* 307 */:
                if (bfiVar.a("Expires") == null && bfiVar.l().c() == -1 && !bfiVar.l().e() && !bfiVar.l().d()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return (bfiVar.l().b() || bfgVar.h().b()) ? false : true;
    }

    public static class a {
        final long a;
        final bfg b;
        final bfi c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, bfg bfgVar, bfi bfiVar) {
            this.l = -1;
            this.a = j;
            this.b = bfgVar;
            this.c = bfiVar;
            if (bfiVar != null) {
                bfa bfaVarF = bfiVar.f();
                int iA = bfaVarF.a();
                for (int i = 0; i < iA; i++) {
                    String strA = bfaVarF.a(i);
                    String strB = bfaVarF.b(i);
                    if (HTTP.DATE_HEADER.equalsIgnoreCase(strA)) {
                        this.d = bgd.a(strB);
                        this.e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = bgd.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f = bgd.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = bgb.b(strB, -1);
                    } else if (bgh.b.equalsIgnoreCase(strA)) {
                        this.i = Long.parseLong(strB);
                    } else if (bgh.c.equalsIgnoreCase(strA)) {
                        this.j = Long.parseLong(strB);
                    }
                }
            }
        }

        public bga a() {
            bfg bfgVar = null;
            byte b = 0;
            byte b2 = 0;
            bga bgaVarB = b();
            if (bgaVarB.a != null && this.b.h().i()) {
                return new bga(bfgVar, b2 == true ? 1 : 0);
            }
            return bgaVarB;
        }

        private bga b() {
            long millis = 0;
            bfi bfiVar = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            byte b7 = 0;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            byte b11 = 0;
            byte b12 = 0;
            if (this.c == null) {
                return new bga(this.b, bfiVar);
            }
            if (this.b.i() && this.c.e() == null) {
                return new bga(this.b, b11 == true ? 1 : 0);
            }
            if (!bga.a(this.c, this.b)) {
                return new bga(this.b, b9 == true ? 1 : 0);
            }
            bep bepVarH = this.b.h();
            if (bepVarH.a() || a(this.b)) {
                return new bga(this.b, b2 == true ? 1 : 0);
            }
            long jD = d();
            long jC = c();
            if (bepVarH.c() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(bepVarH.c()));
            }
            long millis2 = bepVarH.h() != -1 ? TimeUnit.SECONDS.toMillis(bepVarH.h()) : 0L;
            bep bepVarL = this.c.l();
            if (!bepVarL.f() && bepVarH.g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(bepVarH.g());
            }
            if (!bepVarL.a() && jD + millis2 < millis + jC) {
                bfi.a aVarH = this.c.h();
                if (millis2 + jD >= jC) {
                    aVarH.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (jD > 86400000 && e()) {
                    aVarH.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new bga(b7 == true ? 1 : 0, aVarH.a());
            }
            bfg.a aVarG = this.b.g();
            if (this.k != null) {
                aVarG.a("If-None-Match", this.k);
            } else if (this.f != null) {
                aVarG.a("If-Modified-Since", this.g);
            } else if (this.d != null) {
                aVarG.a("If-Modified-Since", this.e);
            }
            bfg bfgVarA = aVarG.a();
            if (a(bfgVarA)) {
                return new bga(bfgVarA, this.c);
            }
            return new bga(bfgVarA, b4 == true ? 1 : 0);
        }

        private long c() {
            if (this.c.l().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                long time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            }
            if (this.f == null || this.c.a().a().getQuery() != null) {
                return 0L;
            }
            long time2 = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long d() {
            long jMax = this.d != null ? Math.max(0L, this.j - this.d.getTime()) : 0L;
            if (this.l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
            }
            return jMax + (this.j - this.i) + (this.a - this.j);
        }

        private boolean e() {
            return this.c.l().c() == -1 && this.h == null;
        }

        private static boolean a(bfg bfgVar) {
            return (bfgVar.a("If-Modified-Since") == null && bfgVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
