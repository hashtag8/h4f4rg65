package defpackage;

import defpackage.bfa;
import defpackage.bfc;
import defpackage.bfg;
import defpackage.bfi;
import defpackage.bga;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class bge {
    private static final bfj d = new bfj() { // from class: bge.1
        @Override // defpackage.bfj
        public long a() {
            return 0L;
        }

        @Override // defpackage.bfj
        public bqu b() {
            return new bqs();
        }
    };
    final bfe a;
    long b = -1;
    public final boolean c;
    private beu e;
    private bem f;
    private bgn g;
    private bfk h;
    private final bfi i;
    private bgr j;
    private boolean k;
    private final bfg l;
    private bfg m;
    private bfi n;
    private bfi o;
    private brh p;
    private bqt q;
    private final boolean r;
    private final boolean s;
    private bfz t;
    private bga u;

    public bge(bfe bfeVar, bfg bfgVar, boolean z, boolean z2, boolean z3, beu beuVar, bgn bgnVar, bgl bglVar, bfi bfiVar) {
        this.a = bfeVar;
        this.l = bfgVar;
        this.c = z;
        this.r = z2;
        this.s = z3;
        this.e = beuVar;
        this.g = bgnVar;
        this.p = bglVar;
        this.i = bfiVar;
        if (beuVar != null) {
            bfp.b.b(beuVar, this);
            this.h = beuVar.c();
        } else {
            this.h = null;
        }
    }

    public void a() throws bgj {
        if (this.u == null) {
            if (this.j != null) {
                throw new IllegalStateException();
            }
            bfg bfgVarA = a(this.l);
            bfq bfqVarA = bfp.b.a(this.a);
            bfi bfiVarA = bfqVarA != null ? bfqVarA.a(bfgVarA) : null;
            this.u = new bga.a(System.currentTimeMillis(), bfgVarA, bfiVarA).a();
            this.m = this.u.a;
            this.n = this.u.b;
            if (bfqVarA != null) {
                bfqVarA.a(this.u);
            }
            if (bfiVarA != null && this.n == null) {
                bfw.a(bfiVarA.g());
            }
            if (this.m != null) {
                if (this.e == null) {
                    l();
                }
                this.j = bfp.b.a(this.e, this);
                if (this.r && c() && this.p == null) {
                    long jA = bgh.a(bfgVarA);
                    if (!this.c) {
                        this.j.a(this.m);
                        this.p = this.j.a(this.m, jA);
                        return;
                    } else {
                        if (jA > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        }
                        if (jA != -1) {
                            this.j.a(this.m);
                            this.p = new bgl((int) jA);
                            return;
                        } else {
                            this.p = new bgl();
                            return;
                        }
                    }
                }
                return;
            }
            if (this.e != null) {
                bfp.b.a(this.a.m(), this.e);
                this.e = null;
            }
            if (this.n != null) {
                this.o = this.n.h().a(this.l).c(b(this.i)).b(b(this.n)).a();
            } else {
                this.o = new bfi.a().a(this.l).c(b(this.i)).a(bff.HTTP_1_1).a(HttpStatus.SC_GATEWAY_TIMEOUT).a("Unsatisfiable Request (only-if-cached)").a(d).a();
            }
            this.o = c(this.o);
        }
    }

    private static bfi b(bfi bfiVar) {
        return (bfiVar == null || bfiVar.g() == null) ? bfiVar : bfiVar.h().a((bfj) null).a();
    }

    private void l() throws bgj {
        if (this.e != null) {
            throw new IllegalStateException();
        }
        if (this.g == null) {
            this.f = a(this.a, this.m);
            try {
                this.g = bgn.a(this.f, this.m, this.a);
            } catch (IOException e) {
                throw new bgj(e);
            }
        }
        this.e = m();
        this.h = this.e.c();
    }

    private beu m() throws bgm {
        beu beuVarN = n();
        bfp.b.a(this.a, beuVarN, this, this.m);
        return beuVarN;
    }

    private beu n() throws bgm {
        bev bevVarM = this.a.m();
        while (true) {
            beu beuVarA = bevVarM.a(this.f);
            if (beuVarA != null) {
                if (!this.m.d().equals("GET") && !bfp.b.c(beuVarA)) {
                    bfw.a(beuVarA.d());
                } else {
                    return beuVarA;
                }
            } else {
                try {
                    return new beu(bevVarM, this.g.b());
                } catch (IOException e) {
                    throw new bgm(e);
                }
            }
        }
    }

    public void b() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.currentTimeMillis();
    }

    boolean c() {
        return bgf.c(this.l.d());
    }

    public bfg d() {
        return this.l;
    }

    public bfi e() {
        if (this.o == null) {
            throw new IllegalStateException();
        }
        return this.o;
    }

    public beu f() {
        return this.e;
    }

    public bge a(bgm bgmVar) {
        if (this.g != null && this.e != null) {
            a(this.g, bgmVar.a());
        }
        if ((this.g == null && this.e == null) || ((this.g != null && !this.g.a()) || !b(bgmVar))) {
            return null;
        }
        return new bge(this.a, this.l, this.c, this.r, this.s, i(), this.g, (bgl) this.p, this.i);
    }

    private boolean b(bgm bgmVar) {
        if (!this.a.p()) {
            return false;
        }
        IOException iOExceptionA = bgmVar.a();
        if ((iOExceptionA instanceof ProtocolException) || (iOExceptionA instanceof InterruptedIOException)) {
            return false;
        }
        return (((iOExceptionA instanceof SSLHandshakeException) && (iOExceptionA.getCause() instanceof CertificateException)) || (iOExceptionA instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public bge a(IOException iOException, brh brhVar) {
        if (this.g != null && this.e != null) {
            a(this.g, iOException);
        }
        boolean z = brhVar == null || (brhVar instanceof bgl);
        if ((this.g == null && this.e == null) || ((this.g != null && !this.g.a()) || !a(iOException) || !z)) {
            return null;
        }
        return new bge(this.a, this.l, this.c, this.r, this.s, i(), this.g, (bgl) brhVar, this.i);
    }

    private void a(bgn bgnVar, IOException iOException) {
        if (bfp.b.b(this.e) <= 0) {
            bgnVar.a(this.e.c(), iOException);
        }
    }

    private boolean a(IOException iOException) {
        return (!this.a.p() || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    public bfk g() {
        return this.h;
    }

    private void o() {
        bfq bfqVarA = bfp.b.a(this.a);
        if (bfqVarA != null) {
            if (!bga.a(this.o, this.m)) {
                if (bgf.a(this.m.d())) {
                    try {
                        bfqVarA.b(this.m);
                        return;
                    } catch (IOException e) {
                        return;
                    }
                }
                return;
            }
            this.t = bfqVarA.a(b(this.o));
        }
    }

    public void h() {
        if (this.j != null && this.e != null) {
            this.j.c();
        }
        this.e = null;
    }

    public beu i() {
        if (this.q != null) {
            bfw.a(this.q);
        } else if (this.p != null) {
            bfw.a(this.p);
        }
        if (this.o == null) {
            if (this.e != null) {
                bfw.a(this.e.d());
            }
            this.e = null;
            return null;
        }
        bfw.a(this.o.g());
        if (this.j != null && this.e != null && !this.j.d()) {
            bfw.a(this.e.d());
            this.e = null;
            return null;
        }
        if (this.e != null && !bfp.b.a(this.e)) {
            this.e = null;
        }
        beu beuVar = this.e;
        this.e = null;
        return beuVar;
    }

    private bfi c(bfi bfiVar) {
        if (this.k && "gzip".equalsIgnoreCase(this.o.a(HTTP.CONTENT_ENCODING)) && bfiVar.g() != null) {
            bra braVar = new bra(bfiVar.g().b());
            bfa bfaVarA = bfiVar.f().b().b(HTTP.CONTENT_ENCODING).b(HTTP.CONTENT_LEN).a();
            return bfiVar.h().a(bfaVarA).a(new bgi(bfaVarA, brc.a(braVar))).a();
        }
        return bfiVar;
    }

    public static boolean a(bfi bfiVar) {
        if (bfiVar.a().d().equals("HEAD")) {
            return false;
        }
        int iC = bfiVar.c();
        if ((iC >= 100 && iC < 200) || iC == 204 || iC == 304) {
            return bgh.a(bfiVar) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(bfiVar.a(HTTP.TRANSFER_ENCODING));
        }
        return true;
    }

    private bfg a(bfg bfgVar) {
        bfg.a aVarG = bfgVar.g();
        if (bfgVar.a(HTTP.TARGET_HOST) == null) {
            aVarG.a(HTTP.TARGET_HOST, a(bfgVar.a()));
        }
        if ((this.e == null || this.e.l() != bff.HTTP_1_0) && bfgVar.a(HTTP.CONN_DIRECTIVE) == null) {
            aVarG.a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (bfgVar.a("Accept-Encoding") == null) {
            this.k = true;
            aVarG.a("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandlerF = this.a.f();
        if (cookieHandlerF != null) {
            bgh.a(aVarG, cookieHandlerF.get(bfgVar.b(), bgh.a(aVarG.a().e(), (String) null)));
        }
        if (bfgVar.a(HTTP.USER_AGENT) == null) {
            aVarG.a(HTTP.USER_AGENT, bfx.a());
        }
        return aVarG.a();
    }

    public static String a(URL url) {
        return bfw.a(url) != bfw.a(url.getProtocol()) ? url.getHost() + ":" + url.getPort() : url.getHost();
    }

    public void j() throws IOException {
        bfi bfiVarP;
        if (this.o == null) {
            if (this.m == null && this.n == null) {
                throw new IllegalStateException("call sendRequest() first!");
            }
            if (this.m != null) {
                if (this.s) {
                    this.j.a(this.m);
                    bfiVarP = p();
                } else if (!this.r) {
                    bfiVarP = new a(0, this.m).a(this.m);
                } else {
                    if (this.q != null && this.q.c().b() > 0) {
                        this.q.e();
                    }
                    if (this.b == -1) {
                        if (bgh.a(this.m) == -1 && (this.p instanceof bgl)) {
                            this.m = this.m.g().a(HTTP.CONTENT_LEN, Long.toString(((bgl) this.p).b())).a();
                        }
                        this.j.a(this.m);
                    }
                    if (this.p != null) {
                        if (this.q != null) {
                            this.q.close();
                        } else {
                            this.p.close();
                        }
                        if (this.p instanceof bgl) {
                            this.j.a((bgl) this.p);
                        }
                    }
                    bfiVarP = p();
                }
                a(bfiVarP.f());
                if (this.n != null) {
                    if (a(this.n, bfiVarP)) {
                        this.o = this.n.h().a(this.l).c(b(this.i)).a(a(this.n.f(), bfiVarP.f())).b(b(this.n)).a(b(bfiVarP)).a();
                        bfiVarP.g().close();
                        h();
                        bfq bfqVarA = bfp.b.a(this.a);
                        bfqVarA.a();
                        bfqVarA.a(this.n, b(this.o));
                        this.o = c(this.o);
                        return;
                    }
                    bfw.a(this.n.g());
                }
                this.o = bfiVarP.h().a(this.l).c(b(this.i)).b(b(this.n)).a(b(bfiVarP)).a();
                if (a(this.o)) {
                    o();
                    this.o = c(a(this.t, this.o));
                }
            }
        }
    }

    class a implements bfc.a {
        private final int b;
        private final bfg c;
        private int d;

        a(int i, bfg bfgVar) {
            this.b = i;
            this.c = bfgVar;
        }

        public beu a() {
            return bge.this.e;
        }

        @Override // bfc.a
        public bfi a(bfg bfgVar) throws ProtocolException {
            this.d++;
            if (this.b > 0) {
                bfc bfcVar = bge.this.a.v().get(this.b - 1);
                bem bemVarA = a().c().a();
                if (!bfgVar.a().getHost().equals(bemVarA.a()) || bfw.a(bfgVar.a()) != bemVarA.b()) {
                    throw new IllegalStateException("network interceptor " + bfcVar + " must retain the same host and port");
                }
                if (this.d > 1) {
                    throw new IllegalStateException("network interceptor " + bfcVar + " must call proceed() exactly once");
                }
            }
            if (this.b >= bge.this.a.v().size()) {
                bge.this.j.a(bfgVar);
                bge.this.m = bfgVar;
                if (bge.this.c() && bfgVar.f() != null) {
                    bqt bqtVarA = brc.a(bge.this.j.a(bfgVar, bfgVar.f().b()));
                    bfgVar.f().a(bqtVarA);
                    bqtVarA.close();
                }
                bfi bfiVarP = bge.this.p();
                int iC = bfiVarP.c();
                if ((iC == 204 || iC == 205) && bfiVarP.g().a() > 0) {
                    throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + bfiVarP.g().a());
                }
                return bfiVarP;
            }
            a aVar = bge.this.new a(this.b + 1, bfgVar);
            bfc bfcVar2 = bge.this.a.v().get(this.b);
            bfi bfiVarA = bfcVar2.a(aVar);
            if (aVar.d != 1) {
                throw new IllegalStateException("network interceptor " + bfcVar2 + " must call proceed() exactly once");
            }
            return bfiVarA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bfi p() {
        this.j.a();
        bfi bfiVarA = this.j.b().a(this.m).a(this.e.j()).a(bgh.b, Long.toString(this.b)).a(bgh.c, Long.toString(System.currentTimeMillis())).a();
        if (!this.s) {
            bfiVarA = bfiVarA.h().a(this.j.a(bfiVarA)).a();
        }
        bfp.b.a(this.e, bfiVarA.b());
        return bfiVarA;
    }

    private bfi a(final bfz bfzVar, bfi bfiVar) {
        brh brhVarB;
        if (bfzVar != null && (brhVarB = bfzVar.b()) != null) {
            final bqu bquVarB = bfiVar.g().b();
            final bqt bqtVarA = brc.a(brhVarB);
            return bfiVar.h().a(new bgi(bfiVar.f(), brc.a(new bri() { // from class: bge.2
                boolean a;

                @Override // defpackage.bri
                public long a(bqs bqsVar, long j) throws IOException {
                    try {
                        long jA = bquVarB.a(bqsVar, j);
                        if (jA == -1) {
                            if (!this.a) {
                                this.a = true;
                                bqtVarA.close();
                            }
                            return -1L;
                        }
                        bqsVar.a(bqtVarA.c(), bqsVar.b() - jA, jA);
                        bqtVarA.v();
                        return jA;
                    } catch (IOException e) {
                        if (!this.a) {
                            this.a = true;
                            bfzVar.a();
                        }
                        throw e;
                    }
                }

                @Override // defpackage.bri
                public brj a() {
                    return bquVarB.a();
                }

                @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    if (!this.a && !bfw.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.a = true;
                        bfzVar.a();
                    }
                    bquVarB.close();
                }
            }))).a();
        }
        return bfiVar;
    }

    private static boolean a(bfi bfiVar, bfi bfiVar2) {
        Date dateB;
        if (bfiVar2.c() == 304) {
            return true;
        }
        Date dateB2 = bfiVar.f().b("Last-Modified");
        return (dateB2 == null || (dateB = bfiVar2.f().b("Last-Modified")) == null || dateB.getTime() >= dateB2.getTime()) ? false : true;
    }

    private static bfa a(bfa bfaVar, bfa bfaVar2) {
        bfa.a aVar = new bfa.a();
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = bfaVar.a(i);
            String strB = bfaVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (!bgh.a(strA) || bfaVar2.a(strA) == null)) {
                aVar.a(strA, strB);
            }
        }
        int iA2 = bfaVar2.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            String strA2 = bfaVar2.a(i2);
            if (!HTTP.CONTENT_LEN.equalsIgnoreCase(strA2) && bgh.a(strA2)) {
                aVar.a(strA2, bfaVar2.b(i2));
            }
        }
        return aVar.a();
    }

    public void a(bfa bfaVar) throws IOException {
        CookieHandler cookieHandlerF = this.a.f();
        if (cookieHandlerF != null) {
            cookieHandlerF.put(this.l.b(), bgh.a(bfaVar, (String) null));
        }
    }

    public bfg k() throws ProtocolException {
        Proxy proxyD;
        String strA;
        if (this.o == null) {
            throw new IllegalStateException();
        }
        if (g() != null) {
            proxyD = g().b();
        } else {
            proxyD = this.a.d();
        }
        switch (this.o.c()) {
            case HttpStatus.SC_TEMPORARY_REDIRECT /* 307 */:
            case 308:
                if (!this.l.d().equals("GET") && !this.l.d().equals("HEAD")) {
                    return null;
                }
            case HttpStatus.SC_MULTIPLE_CHOICES /* 300 */:
            case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
            case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
            case HttpStatus.SC_SEE_OTHER /* 303 */:
                if (this.a.o() && (strA = this.o.a("Location")) != null) {
                    URL url = new URL(this.l.a(), strA);
                    if (!url.getProtocol().equals("https") && !url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                        return null;
                    }
                    if (!url.getProtocol().equals(this.l.a().getProtocol()) && !this.a.n()) {
                        return null;
                    }
                    bfg.a aVarG = this.l.g();
                    if (bgf.c(this.l.d())) {
                        aVarG.a("GET", (bfh) null);
                        aVarG.b(HTTP.TRANSFER_ENCODING);
                        aVarG.b(HTTP.CONTENT_LEN);
                        aVarG.b("Content-Type");
                    }
                    if (!b(url)) {
                        aVarG.b("Authorization");
                    }
                    return aVarG.a(url).a();
                }
                return null;
            case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /* 407 */:
                if (proxyD.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                return bgh.a(this.a.l(), this.o, proxyD);
            default:
                return null;
        }
    }

    public boolean b(URL url) {
        URL urlA = this.l.a();
        return urlA.getHost().equals(url.getHost()) && bfw.a(urlA) == bfw.a(url) && urlA.getProtocol().equals(url.getProtocol());
    }

    private static bem a(bfe bfeVar, bfg bfgVar) throws bgj {
        HostnameVerifier hostnameVerifierJ;
        SSLSocketFactory sSLSocketFactoryI;
        ber berVarK = null;
        String host = bfgVar.a().getHost();
        if (host == null || host.length() == 0) {
            throw new bgj(new UnknownHostException(bfgVar.a().toString()));
        }
        if (bfgVar.i()) {
            sSLSocketFactoryI = bfeVar.i();
            hostnameVerifierJ = bfeVar.j();
            berVarK = bfeVar.k();
        } else {
            hostnameVerifierJ = null;
            sSLSocketFactoryI = null;
        }
        return new bem(host, bfw.a(bfgVar.a()), bfeVar.h(), sSLSocketFactoryI, hostnameVerifierJ, berVarK, bfeVar.l(), bfeVar.d(), bfeVar.s(), bfeVar.t(), bfeVar.e());
    }
}
