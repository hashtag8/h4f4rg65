package defpackage;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class bem {
    final Proxy a;
    final String b;
    final int c;
    final SocketFactory d;
    final SSLSocketFactory e;
    final HostnameVerifier f;
    final ber g;
    final ben h;
    final List<bff> i;
    final List<bew> j;
    final ProxySelector k;

    public bem(String str, int i, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ber berVar, ben benVar, Proxy proxy, List<bff> list, List<bew> list2, ProxySelector proxySelector) {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        }
        if (benVar == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.a = proxy;
        this.b = str;
        this.c = i;
        this.d = socketFactory;
        this.e = sSLSocketFactory;
        this.f = hostnameVerifier;
        this.g = berVar;
        this.h = benVar;
        this.i = bfw.a(list);
        this.j = bfw.a(list2);
        this.k = proxySelector;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public SocketFactory c() {
        return this.d;
    }

    public SSLSocketFactory d() {
        return this.e;
    }

    public HostnameVerifier e() {
        return this.f;
    }

    public ben f() {
        return this.h;
    }

    public List<bff> g() {
        return this.i;
    }

    public List<bew> h() {
        return this.j;
    }

    public Proxy i() {
        return this.a;
    }

    public ProxySelector j() {
        return this.k;
    }

    public ber k() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bem)) {
            return false;
        }
        bem bemVar = (bem) obj;
        return bfw.a(this.a, bemVar.a) && this.b.equals(bemVar.b) && this.c == bemVar.c && bfw.a(this.e, bemVar.e) && bfw.a(this.f, bemVar.f) && bfw.a(this.g, bemVar.g) && bfw.a(this.h, bemVar.h) && bfw.a(this.i, bemVar.i) && bfw.a(this.j, bemVar.j) && bfw.a(this.k, bemVar.k);
    }

    public int hashCode() {
        return (((((((((((this.f != null ? this.f.hashCode() : 0) + (((this.e != null ? this.e.hashCode() : 0) + (((((((this.a != null ? this.a.hashCode() : 0) + 527) * 31) + this.b.hashCode()) * 31) + this.c) * 31)) * 31)) * 31) + (this.g != null ? this.g.hashCode() : 0)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }
}
