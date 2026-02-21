package defpackage;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class bez {
    private final String a;
    private final List<Certificate> b;
    private final List<Certificate> c;

    private bez(String str, List<Certificate> list, List<Certificate> list2) {
        this.a = str;
        this.b = list;
        this.c = list2;
    }

    public static bez a(SSLSession sSLSession) {
        Certificate[] peerCertificates;
        List listEmptyList;
        List listEmptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = bfw.a(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = bfw.a(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new bez(cipherSuite, listEmptyList, listEmptyList2);
    }

    public static bez a(String str, List<Certificate> list, List<Certificate> list2) {
        if (str == null) {
            throw new IllegalArgumentException("cipherSuite == null");
        }
        return new bez(str, bfw.a(list), bfw.a(list2));
    }

    public String a() {
        return this.a;
    }

    public List<Certificate> b() {
        return this.b;
    }

    public List<Certificate> c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bez)) {
            return false;
        }
        bez bezVar = (bez) obj;
        return this.a.equals(bezVar.a) && this.b.equals(bezVar.b) && this.c.equals(bezVar.c);
    }

    public int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
