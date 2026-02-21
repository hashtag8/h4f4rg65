package defpackage;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class bnx {
    public static final SSLSocketFactory a(bny bnyVar) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new bnz(new boa(bnyVar.a(), bnyVar.b()), bnyVar)}, null);
        return sSLContext.getSocketFactory();
    }
}
