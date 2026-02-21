package defpackage;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class bew {
    final boolean d;
    final boolean e;
    private final String[] g;
    private final String[] h;
    private static final bet[] f = {bet.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, bet.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, bet.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, bet.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, bet.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, bet.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, bet.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, bet.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, bet.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, bet.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, bet.TLS_RSA_WITH_AES_128_GCM_SHA256, bet.TLS_RSA_WITH_AES_128_CBC_SHA, bet.TLS_RSA_WITH_AES_256_CBC_SHA, bet.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final bew a = new a(true).a(f).a(bfl.TLS_1_2, bfl.TLS_1_1, bfl.TLS_1_0).a(true).a();
    public static final bew b = new a(a).a(bfl.TLS_1_0).a(true).a();
    public static final bew c = new a(false).a();

    private bew(a aVar) {
        this.d = aVar.a;
        this.g = aVar.b;
        this.h = aVar.c;
        this.e = aVar.d;
    }

    public List<bet> a() {
        if (this.g == null) {
            return null;
        }
        bet[] betVarArr = new bet[this.g.length];
        for (int i = 0; i < this.g.length; i++) {
            betVarArr[i] = bet.a(this.g[i]);
        }
        return bfw.a(betVarArr);
    }

    public List<bfl> b() {
        bfl[] bflVarArr = new bfl[this.h.length];
        for (int i = 0; i < this.h.length; i++) {
            bflVarArr[i] = bfl.a(this.h[i]);
        }
        return bfw.a(bflVarArr);
    }

    public boolean c() {
        return this.e;
    }

    void a(SSLSocket sSLSocket, boolean z) {
        bew bewVarB = b(sSLSocket, z);
        sSLSocket.setEnabledProtocols(bewVarB.h);
        String[] strArr = bewVarB.g;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    private bew b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] enabledCipherSuites = null;
        if (this.g != null) {
            enabledCipherSuites = (String[]) bfw.a(String.class, this.g, sSLSocket.getEnabledCipherSuites());
        }
        if (z && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (enabledCipherSuites == null) {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            strArr = new String[enabledCipherSuites.length + 1];
            System.arraycopy(enabledCipherSuites, 0, strArr, 0, enabledCipherSuites.length);
            strArr[strArr.length - 1] = "TLS_FALLBACK_SCSV";
        } else {
            strArr = enabledCipherSuites;
        }
        return new a(this).a(strArr).b((String[]) bfw.a(String.class, this.h, sSLSocket.getEnabledProtocols())).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (!a(this.h, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.g == null) {
            return sSLSocket.getEnabledCipherSuites().length > 0;
        }
        return a(this.g, sSLSocket.getEnabledCipherSuites());
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (a(strArr2, str)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean a(T[] tArr, T t) {
        for (T t2 : tArr) {
            if (bfw.a(t, t2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bew)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        bew bewVar = (bew) obj;
        if (this.d == bewVar.d) {
            return !this.d || (Arrays.equals(this.g, bewVar.g) && Arrays.equals(this.h, bewVar.h) && this.e == bewVar.e);
        }
        return false;
    }

    public int hashCode() {
        if (!this.d) {
            return 17;
        }
        return (this.e ? 0 : 1) + ((((Arrays.hashCode(this.g) + 527) * 31) + Arrays.hashCode(this.h)) * 31);
    }

    public String toString() {
        if (this.d) {
            List<bet> listA = a();
            return "ConnectionSpec(cipherSuites=" + (listA == null ? "[use default]" : listA.toString()) + ", tlsVersions=" + b() + ", supportsTlsExtensions=" + this.e + ")";
        }
        return "ConnectionSpec()";
    }

    public static final class a {
        private boolean a;
        private String[] b;
        private String[] c;
        private boolean d;

        a(boolean z) {
            this.a = z;
        }

        public a(bew bewVar) {
            this.a = bewVar.d;
            this.b = bewVar.g;
            this.c = bewVar.h;
            this.d = bewVar.e;
        }

        public a a(bet... betVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[betVarArr.length];
            for (int i = 0; i < betVarArr.length; i++) {
                strArr[i] = betVarArr[i].aS;
            }
            this.b = strArr;
            return this;
        }

        public a a(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.b = null;
            } else {
                this.b = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(bfl... bflVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (bflVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[bflVarArr.length];
            for (int i = 0; i < bflVarArr.length; i++) {
                strArr[i] = bflVarArr[i].e;
            }
            this.c = strArr;
            return this;
        }

        public a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.c = null;
            } else {
                this.c = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(boolean z) {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public bew a() {
            return new bew(this);
        }
    }
}
