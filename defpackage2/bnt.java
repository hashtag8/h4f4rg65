package defpackage;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class bnt implements bnw {
    private final blq a;
    private bny b;
    private SSLSocketFactory c;
    private boolean d;

    public bnt() {
        this(new blg());
    }

    public bnt(blq blqVar) {
        this.a = blqVar;
    }

    @Override // defpackage.bnw
    public void a(bny bnyVar) {
        if (this.b != bnyVar) {
            this.b = bnyVar;
            a();
        }
    }

    private synchronized void a() {
        this.d = false;
        this.c = null;
    }

    @Override // defpackage.bnw
    public bnv a(bnu bnuVar, String str, Map<String, String> map) {
        bnv bnvVarE;
        SSLSocketFactory sSLSocketFactoryB;
        switch (bnuVar) {
            case GET:
                bnvVarE = bnv.a((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case POST:
                bnvVarE = bnv.b((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case PUT:
                bnvVarE = bnv.d((CharSequence) str);
                break;
            case DELETE:
                bnvVarE = bnv.e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.b != null && (sSLSocketFactoryB = b()) != null) {
            ((HttpsURLConnection) bnvVarE.a()).setSSLSocketFactory(sSLSocketFactoryB);
        }
        return bnvVarE;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory b() {
        if (this.c == null && !this.d) {
            this.c = c();
        }
        return this.c;
    }

    private synchronized SSLSocketFactory c() {
        SSLSocketFactory sSLSocketFactoryA;
        this.d = true;
        try {
            sSLSocketFactoryA = bnx.a(this.b);
            this.a.a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.a.e("Fabric", "Exception while validating pinned certs", e);
            sSLSocketFactoryA = null;
        }
        return sSLSocketFactoryA;
    }
}
