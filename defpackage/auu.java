package defpackage;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
class auu implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> a = new HashSet<>();
    private static final HashSet<Class<?>> b = new HashSet<>();
    private final int c;
    private final int d;

    static {
        a.add(NoHttpResponseException.class);
        a.add(UnknownHostException.class);
        a.add(SocketException.class);
        b.add(InterruptedIOException.class);
        b.add(SSLException.class);
    }

    public auu(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = true;
        Boolean bool = (Boolean) httpContext.getAttribute(ExecutionContext.HTTP_REQ_SENT);
        boolean z2 = bool != null && bool.booleanValue();
        if (i > this.c) {
            z = false;
        } else if (!a(a, iOException)) {
            if (a(b, iOException)) {
                z = false;
            } else if (!z2) {
            }
        }
        if (z && ((HttpUriRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST)) == null) {
            return false;
        }
        if (z) {
            SystemClock.sleep(this.d);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
