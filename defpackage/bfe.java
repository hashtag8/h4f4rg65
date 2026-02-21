package defpackage;

import defpackage.bfa;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class bfe implements Cloneable {
    private static final List<bff> a = bfw.a(bff.HTTP_2, bff.SPDY_3, bff.HTTP_1_1);
    private static final List<bew> b = bfw.a(bew.a, bew.b, bew.c);
    private static SSLSocketFactory c;
    private int A;
    private final bfv d;
    private bey e;
    private Proxy f;
    private List<bff> g;
    private List<bew> h;
    private final List<bfc> i;
    private final List<bfc> j;
    private ProxySelector k;
    private CookieHandler l;
    private bfq m;
    private beo n;
    private SocketFactory o;
    private SSLSocketFactory p;
    private HostnameVerifier q;
    private ber r;
    private ben s;
    private bev t;
    private bfs u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    static {
        bfp.b = new bfp() { // from class: bfe.1
            @Override // defpackage.bfp
            public bgr a(beu beuVar, bge bgeVar) {
                return beuVar.a(bgeVar);
            }

            @Override // defpackage.bfp
            public boolean a(beu beuVar) {
                return beuVar.a();
            }

            @Override // defpackage.bfp
            public int b(beu beuVar) {
                return beuVar.n();
            }

            @Override // defpackage.bfp
            public void a(beu beuVar, bff bffVar) {
                beuVar.a(bffVar);
            }

            @Override // defpackage.bfp
            public void b(beu beuVar, bge bgeVar) {
                beuVar.a((Object) bgeVar);
            }

            @Override // defpackage.bfp
            public boolean c(beu beuVar) {
                return beuVar.f();
            }

            @Override // defpackage.bfp
            public void a(bfa.a aVar, String str) {
                aVar.a(str);
            }

            @Override // defpackage.bfp
            public bfq a(bfe bfeVar) {
                return bfeVar.g();
            }

            @Override // defpackage.bfp
            public void a(bev bevVar, beu beuVar) {
                bevVar.a(beuVar);
            }

            @Override // defpackage.bfp
            public bfv b(bfe bfeVar) {
                return bfeVar.q();
            }

            @Override // defpackage.bfp
            public bfs c(bfe bfeVar) {
                return bfeVar.u;
            }

            @Override // defpackage.bfp
            public void a(bfe bfeVar, beu beuVar, bge bgeVar, bfg bfgVar) throws bgm {
                beuVar.a(bfeVar, bgeVar, bfgVar);
            }

            @Override // defpackage.bfp
            public void a(bew bewVar, SSLSocket sSLSocket, boolean z) {
                bewVar.a(sSLSocket, z);
            }
        };
    }

    public bfe() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.v = true;
        this.w = true;
        this.x = true;
        this.d = new bfv();
        this.e = new bey();
    }

    private bfe(bfe bfeVar) {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.v = true;
        this.w = true;
        this.x = true;
        this.d = bfeVar.d;
        this.e = bfeVar.e;
        this.f = bfeVar.f;
        this.g = bfeVar.g;
        this.h = bfeVar.h;
        this.i.addAll(bfeVar.i);
        this.j.addAll(bfeVar.j);
        this.k = bfeVar.k;
        this.l = bfeVar.l;
        this.n = bfeVar.n;
        this.m = this.n != null ? this.n.a : bfeVar.m;
        this.o = bfeVar.o;
        this.p = bfeVar.p;
        this.q = bfeVar.q;
        this.r = bfeVar.r;
        this.s = bfeVar.s;
        this.t = bfeVar.t;
        this.u = bfeVar.u;
        this.v = bfeVar.v;
        this.w = bfeVar.w;
        this.x = bfeVar.x;
        this.y = bfeVar.y;
        this.z = bfeVar.z;
        this.A = bfeVar.A;
    }

    public void a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.y = (int) millis;
    }

    public int a() {
        return this.y;
    }

    public void b(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.z = (int) millis;
    }

    public int b() {
        return this.z;
    }

    public void c(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.A = (int) millis;
    }

    public int c() {
        return this.A;
    }

    public Proxy d() {
        return this.f;
    }

    public ProxySelector e() {
        return this.k;
    }

    public CookieHandler f() {
        return this.l;
    }

    bfq g() {
        return this.m;
    }

    public bfe a(beo beoVar) {
        this.n = beoVar;
        this.m = null;
        return this;
    }

    public SocketFactory h() {
        return this.o;
    }

    public SSLSocketFactory i() {
        return this.p;
    }

    public HostnameVerifier j() {
        return this.q;
    }

    public ber k() {
        return this.r;
    }

    public ben l() {
        return this.s;
    }

    public bev m() {
        return this.t;
    }

    public boolean n() {
        return this.v;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public boolean o() {
        return this.w;
    }

    public boolean p() {
        return this.x;
    }

    bfv q() {
        return this.d;
    }

    public bey r() {
        return this.e;
    }

    public List<bff> s() {
        return this.g;
    }

    public List<bew> t() {
        return this.h;
    }

    public List<bfc> u() {
        return this.i;
    }

    public List<bfc> v() {
        return this.j;
    }

    public beq a(bfg bfgVar) {
        return new beq(this, bfgVar);
    }

    bfe w() {
        bfe bfeVar = new bfe(this);
        if (bfeVar.k == null) {
            bfeVar.k = ProxySelector.getDefault();
        }
        if (bfeVar.l == null) {
            bfeVar.l = CookieHandler.getDefault();
        }
        if (bfeVar.o == null) {
            bfeVar.o = SocketFactory.getDefault();
        }
        if (bfeVar.p == null) {
            bfeVar.p = y();
        }
        if (bfeVar.q == null) {
            bfeVar.q = bhl.a;
        }
        if (bfeVar.r == null) {
            bfeVar.r = ber.a;
        }
        if (bfeVar.s == null) {
            bfeVar.s = bfy.a;
        }
        if (bfeVar.t == null) {
            bfeVar.t = bev.a();
        }
        if (bfeVar.g == null) {
            bfeVar.g = a;
        }
        if (bfeVar.h == null) {
            bfeVar.h = b;
        }
        if (bfeVar.u == null) {
            bfeVar.u = bfs.a;
        }
        return bfeVar;
    }

    private synchronized SSLSocketFactory y() {
        if (c == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                c = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        return c;
    }

    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public bfe clone() {
        return new bfe(this);
    }
}
