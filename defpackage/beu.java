package defpackage;

import defpackage.bgo;
import defpackage.bhh;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class beu {
    private final bev a;
    private final bfk b;
    private Socket c;
    private bgc e;
    private bhh f;
    private long h;
    private bez i;
    private int j;
    private Object k;
    private boolean d = false;
    private bff g = bff.HTTP_1_1;

    public beu(bev bevVar, bfk bfkVar) {
        this.a = bevVar;
        this.b = bfkVar;
    }

    void a(Object obj) {
        if (!k()) {
            synchronized (this.a) {
                if (this.k != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.k = obj;
            }
        }
    }

    boolean a() {
        boolean z;
        synchronized (this.a) {
            if (this.k == null) {
                z = false;
            } else {
                this.k = null;
                z = true;
            }
        }
        return z;
    }

    void a(int i, int i2, int i3, bfg bfgVar, List<bew> list, boolean z) throws bgm {
        bgo.a aVarA;
        if (this.d) {
            throw new IllegalStateException("already connected");
        }
        bgo bgoVar = new bgo(this, this.a);
        if (this.b.a.d() != null) {
            aVarA = bgoVar.a(i, i2, i3, bfgVar, this.b, list, z);
        } else {
            if (!list.contains(bew.c)) {
                throw new bgm(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
            }
            aVarA = bgoVar.a(i, i2, this.b);
        }
        this.c = aVarA.b;
        this.i = aVarA.d;
        this.g = aVarA.c == null ? bff.HTTP_1_1 : aVarA.c;
        try {
            if (this.g == bff.SPDY_3 || this.g == bff.HTTP_2) {
                this.c.setSoTimeout(0);
                this.f = new bhh.a(this.b.a.b, true, this.c).a(this.g).a();
                this.f.e();
            } else {
                this.e = new bgc(this.a, this, this.c);
            }
            this.d = true;
        } catch (IOException e) {
            throw new bgm(e);
        }
    }

    void a(bfe bfeVar, Object obj, bfg bfgVar) throws bgm {
        a(obj);
        if (!b()) {
            a(bfeVar.a(), bfeVar.b(), bfeVar.c(), bfgVar, this.b.a.h(), bfeVar.p());
            if (k()) {
                bfeVar.m().b(this);
            }
            bfeVar.q().b(c());
        }
        a(bfeVar.b(), bfeVar.c());
    }

    boolean b() {
        return this.d;
    }

    public bfk c() {
        return this.b;
    }

    public Socket d() {
        return this.c;
    }

    boolean e() {
        return (this.c.isClosed() || this.c.isInputShutdown() || this.c.isOutputShutdown()) ? false : true;
    }

    boolean f() {
        if (this.e != null) {
            return this.e.f();
        }
        return true;
    }

    void g() {
        if (this.f != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.h = System.nanoTime();
    }

    boolean h() {
        return this.f == null || this.f.b();
    }

    long i() {
        return this.f == null ? this.h : this.f.c();
    }

    public bez j() {
        return this.i;
    }

    bgr a(bge bgeVar) {
        return this.f != null ? new bgp(bgeVar, this.f) : new bgg(bgeVar, this.e);
    }

    boolean k() {
        return this.f != null;
    }

    public bff l() {
        return this.g;
    }

    void a(bff bffVar) {
        if (bffVar == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        this.g = bffVar;
    }

    void a(int i, int i2) throws bgm {
        if (!this.d) {
            throw new IllegalStateException("setTimeouts - not connected");
        }
        if (this.e != null) {
            try {
                this.c.setSoTimeout(i);
                this.e.a(i, i2);
            } catch (IOException e) {
                throw new bgm(e);
            }
        }
    }

    void m() {
        this.j++;
    }

    int n() {
        return this.j;
    }

    public String toString() {
        return "Connection{" + this.b.a.b + ":" + this.b.a.c + ", proxy=" + this.b.b + " hostAddress=" + this.b.c.getAddress().getHostAddress() + " cipherSuite=" + (this.i != null ? this.i.a() : "none") + " protocol=" + this.g + '}';
    }
}
