package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class bfm {
    private final List<bew> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public bfm(List<bew> list) {
        this.a = list;
    }

    public bew a(SSLSocket sSLSocket) throws UnknownServiceException {
        bew bewVar;
        int i = this.b;
        int size = this.a.size();
        int i2 = i;
        while (true) {
            if (i2 >= size) {
                bewVar = null;
                break;
            }
            bewVar = this.a.get(i2);
            if (!bewVar.a(sSLSocket)) {
                i2++;
            } else {
                this.b = i2 + 1;
                break;
            }
        }
        if (bewVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        bfp.b.a(bewVar, sSLSocket, this.d);
        return bewVar;
    }

    public boolean a(IOException iOException) {
        this.d = true;
        if ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return ((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) && this.c;
    }

    private boolean b(SSLSocket sSLSocket) {
        int i = this.b;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (!this.a.get(i2).a(sSLSocket)) {
                    i = i2 + 1;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
