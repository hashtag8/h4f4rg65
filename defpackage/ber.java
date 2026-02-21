package defpackage;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class ber {
    public static final ber a = new a().a();
    private final Map<String, Set<bqv>> b;

    private ber(a aVar) {
        this.b = bfw.a(aVar.a);
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Set<bqv> setA = a(str);
        if (setA != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (setA.contains(a((X509Certificate) list.get(i)))) {
                    return;
                }
            }
            StringBuilder sbAppend = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                sbAppend.append("\n    ").append(a((Certificate) x509Certificate)).append(": ").append(x509Certificate.getSubjectDN().getName());
            }
            sbAppend.append("\n  Pinned certificates for ").append(str).append(":");
            Iterator<bqv> it = setA.iterator();
            while (it.hasNext()) {
                sbAppend.append("\n    sha1/").append(it.next().b());
            }
            throw new SSLPeerUnverifiedException(sbAppend.toString());
        }
    }

    Set<bqv> a(String str) {
        Set<bqv> set = this.b.get(str);
        int iIndexOf = str.indexOf(46);
        Set<bqv> set2 = iIndexOf != str.lastIndexOf(46) ? this.b.get("*." + str.substring(iIndexOf + 1)) : null;
        if (set == null && set2 == null) {
            return null;
        }
        if (set == null || set2 == null) {
            return set == null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha1/" + a((X509Certificate) certificate).b();
    }

    private static bqv a(X509Certificate x509Certificate) {
        return bfw.a(bqv.a(x509Certificate.getPublicKey().getEncoded()));
    }

    public static final class a {
        private final Map<String, Set<bqv>> a = new LinkedHashMap();

        public ber a() {
            return new ber(this);
        }
    }
}
