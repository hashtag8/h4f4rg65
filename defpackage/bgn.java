package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class bgn {
    private final bem a;
    private final URI b;
    private final bfs c;
    private final bfe d;
    private final bfv e;
    private Proxy f;
    private InetSocketAddress g;
    private int i;
    private int k;
    private List<Proxy> h = Collections.emptyList();
    private List<InetSocketAddress> j = Collections.emptyList();
    private final List<bfk> l = new ArrayList();

    private bgn(bem bemVar, URI uri, bfe bfeVar) {
        this.a = bemVar;
        this.b = uri;
        this.d = bfeVar;
        this.e = bfp.b.b(bfeVar);
        this.c = bfp.b.c(bfeVar);
        a(uri, bemVar.i());
    }

    public static bgn a(bem bemVar, bfg bfgVar, bfe bfeVar) {
        return new bgn(bemVar, bfgVar.b(), bfeVar);
    }

    public boolean a() {
        return e() || c() || g();
    }

    public bfk b() {
        if (!e()) {
            if (!c()) {
                if (!g()) {
                    throw new NoSuchElementException();
                }
                return h();
            }
            this.f = d();
        }
        this.g = f();
        bfk bfkVar = new bfk(this.a, this.f, this.g);
        if (this.e.c(bfkVar)) {
            this.l.add(bfkVar);
            return b();
        }
        return bfkVar;
    }

    public void a(bfk bfkVar, IOException iOException) {
        if (bfkVar.b().type() != Proxy.Type.DIRECT && this.a.j() != null) {
            this.a.j().connectFailed(this.b, bfkVar.b().address(), iOException);
        }
        this.e.a(bfkVar);
    }

    private void a(URI uri, Proxy proxy) {
        if (proxy != null) {
            this.h = Collections.singletonList(proxy);
        } else {
            this.h = new ArrayList();
            List<Proxy> listSelect = this.d.e().select(uri);
            if (listSelect != null) {
                this.h.addAll(listSelect);
            }
            this.h.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.h.add(Proxy.NO_PROXY);
        }
        this.i = 0;
    }

    private boolean c() {
        return this.i < this.h.size();
    }

    private Proxy d() throws SocketException {
        if (!c()) {
            throw new SocketException("No route to " + this.a.a() + "; exhausted proxy configurations: " + this.h);
        }
        List<Proxy> list = this.h;
        int i = this.i;
        this.i = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) throws SocketException {
        String strA;
        int iA;
        this.j = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strA = this.a.a();
            iA = bfw.a(this.b);
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            String strA2 = a(inetSocketAddress);
            int port = inetSocketAddress.getPort();
            strA = strA2;
            iA = port;
        }
        if (iA < 1 || iA > 65535) {
            throw new SocketException("No route to " + strA + ":" + iA + "; port is out of range");
        }
        InetAddress[] inetAddressArrA = this.c.a(strA);
        for (InetAddress inetAddress : inetAddressArrA) {
            this.j.add(new InetSocketAddress(inetAddress, iA));
        }
        this.k = 0;
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean e() {
        return this.k < this.j.size();
    }

    private InetSocketAddress f() throws SocketException {
        if (!e()) {
            throw new SocketException("No route to " + this.a.a() + "; exhausted inet socket addresses: " + this.j);
        }
        List<InetSocketAddress> list = this.j;
        int i = this.k;
        this.k = i + 1;
        return list.get(i);
    }

    private boolean g() {
        return !this.l.isEmpty();
    }

    private bfk h() {
        return this.l.remove(0);
    }
}
