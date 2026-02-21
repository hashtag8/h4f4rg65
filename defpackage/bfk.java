package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class bfk {
    final bem a;
    final Proxy b;
    final InetSocketAddress c;

    public bfk(bem bemVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bemVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = bemVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public bem a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        return this.a.e != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bfk)) {
            return false;
        }
        bfk bfkVar = (bfk) obj;
        return this.a.equals(bfkVar.a) && this.b.equals(bfkVar.b) && this.c.equals(bfkVar.c);
    }

    public int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
