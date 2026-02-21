package defpackage;

import defpackage.bfg;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class bgo {
    private final beu a;
    private final bev b;

    public bgo(beu beuVar, bev bevVar) {
        this.a = beuVar;
        this.b = bevVar;
    }

    public a a(int i, int i2, bfk bfkVar) {
        return new a(bfkVar, b(i2, i, bfkVar));
    }

    public a a(int i, int i2, int i3, bfg bfgVar, bfk bfkVar, List<bew> list, boolean z) {
        IOException iOException;
        SSLSocket sSLSocket;
        boolean z2;
        String strB;
        bem bemVarA = bfkVar.a();
        bfm bfmVar = new bfm(list);
        bgm bgmVar = null;
        do {
            bgm bgmVar2 = bgmVar;
            Socket socketB = b(i2, i, bfkVar);
            if (bfkVar.d()) {
                a(i2, i3, bfgVar, bfkVar, socketB);
            }
            try {
                SSLSocket sSLSocket2 = (SSLSocket) bemVarA.d().createSocket(socketB, bemVarA.a(), bemVarA.b(), true);
                try {
                    bew bewVarA = bfmVar.a(sSLSocket2);
                    bfu bfuVarA = bfu.a();
                    bff bffVarA = null;
                    try {
                        if (bewVarA.c()) {
                            bfuVarA.a(sSLSocket2, bemVarA.a(), bemVarA.g());
                        }
                        sSLSocket2.startHandshake();
                        bez bezVarA = bez.a(sSLSocket2.getSession());
                        if (bewVarA.c() && (strB = bfuVarA.b(sSLSocket2)) != null) {
                            bffVarA = bff.a(strB);
                        }
                        bfuVarA.a(sSLSocket2);
                        if (!bemVarA.e().verify(bemVarA.a(), sSLSocket2.getSession())) {
                            X509Certificate x509Certificate = (X509Certificate) sSLSocket2.getSession().getPeerCertificates()[0];
                            throw new SSLPeerUnverifiedException("Hostname " + bemVarA.a() + " not verified:\n    certificate: " + ber.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + bhl.a(x509Certificate));
                        }
                        bemVarA.k().a(bemVarA.a(), bezVarA.b());
                        return new a(bfkVar, sSLSocket2, bffVarA, bezVarA);
                    } catch (Throwable th) {
                        bfuVarA.a(sSLSocket2);
                        throw th;
                    }
                } catch (IOException e) {
                    iOException = e;
                    sSLSocket = sSLSocket2;
                    z2 = z && bfmVar.a(iOException);
                    bfw.a((Socket) sSLSocket);
                    bfw.a(socketB);
                    if (bgmVar2 == null) {
                        bgmVar = new bgm(iOException);
                    } else {
                        bgmVar2.a(iOException);
                        bgmVar = bgmVar2;
                    }
                }
            } catch (IOException e2) {
                iOException = e2;
                sSLSocket = null;
            }
        } while (z2);
        throw bgmVar;
    }

    private Socket b(int i, int i2, bfk bfkVar) throws bgm {
        Socket socketCreateSocket;
        bfu bfuVarA = bfu.a();
        try {
            Proxy proxyB = bfkVar.b();
            bem bemVarA = bfkVar.a();
            if (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) {
                socketCreateSocket = bemVarA.c().createSocket();
            } else {
                socketCreateSocket = new Socket(proxyB);
            }
            socketCreateSocket.setSoTimeout(i);
            bfuVarA.a(socketCreateSocket, bfkVar.c(), i2);
            return socketCreateSocket;
        } catch (IOException e) {
            throw new bgm(e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:104)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void a(int r11, int r12, defpackage.bfg r13, defpackage.bfk r14, java.net.Socket r15) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bgo.a(int, int, bfg, bfk, java.net.Socket):void");
    }

    private bfg a(bfg bfgVar) {
        String host = bfgVar.a().getHost();
        int iA = bfw.a(bfgVar.a());
        bfg.a aVarA = new bfg.a().a(new URL("https", host, iA, "/")).a(HTTP.TARGET_HOST, iA == bfw.a("https") ? host : host + ":" + iA).a("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        String strA = bfgVar.a(HTTP.USER_AGENT);
        if (strA != null) {
            aVarA.a(HTTP.USER_AGENT, strA);
        }
        String strA2 = bfgVar.a("Proxy-Authorization");
        if (strA2 != null) {
            aVarA.a("Proxy-Authorization", strA2);
        }
        return aVarA.a();
    }

    public static class a {
        public final bfk a;
        public final Socket b;
        public final bff c;
        public final bez d;

        public a(bfk bfkVar, Socket socket) {
            this.a = bfkVar;
            this.b = socket;
            this.c = null;
            this.d = null;
        }

        public a(bfk bfkVar, SSLSocket sSLSocket, bff bffVar, bez bezVar) {
            this.a = bfkVar;
            this.b = sSLSocket;
            this.c = bffVar;
            this.d = bezVar;
        }
    }
}
