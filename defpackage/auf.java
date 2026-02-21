package defpackage;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public class auf implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final aut d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public auf(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, aut autVar) {
        this.a = abstractHttpClient;
        this.b = httpContext;
        this.c = httpUriRequest;
        this.d = autVar;
    }

    public void a(auf aufVar) {
    }

    public void b(auf aufVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!a()) {
            if (!this.i) {
                this.i = true;
                a(this);
            }
            if (!a()) {
                if (this.d != null) {
                    this.d.f();
                }
                if (!a()) {
                    try {
                        d();
                    } catch (IOException e) {
                        if (!a() && this.d != null) {
                            this.d.b(0, null, null, e);
                        } else {
                            Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", e);
                        }
                    }
                    if (!a()) {
                        if (this.d != null) {
                            this.d.g();
                        }
                        if (!a()) {
                            b(this);
                            this.h = true;
                        }
                    }
                }
            }
        }
    }

    private void c() throws IOException {
        if (!a()) {
            if (this.c.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            HttpResponse httpResponseExecute = this.a.execute(this.c, this.b);
            if (!a() && this.d != null) {
                this.d.a(this.d, httpResponseExecute);
                if (!a()) {
                    this.d.a(httpResponseExecute);
                    if (!a()) {
                        this.d.b(this.d, httpResponseExecute);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0009 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws java.io.IOException {
        /*
            r7 = this;
            r1 = 1
            r0 = 0
            org.apache.http.impl.client.AbstractHttpClient r2 = r7.a
            org.apache.http.client.HttpRequestRetryHandler r3 = r2.getHttpRequestRetryHandler()
            r2 = r1
        L9:
            if (r2 == 0) goto L75
            r7.c()     // Catch: java.net.UnknownHostException -> Lf java.lang.Exception -> L50 java.lang.NullPointerException -> L78 java.io.IOException -> La2
        Le:
            return
        Lf:
            r0 = move-exception
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Exception -> L50
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
            r4.<init>()     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = "UnknownHostException exception: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Exception -> L50
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L50
            r2.<init>(r0)     // Catch: java.lang.Exception -> L50
            int r0 = r7.e     // Catch: java.lang.Exception -> L50
            if (r0 <= 0) goto L76
            int r0 = r7.e     // Catch: java.lang.Exception -> L50
            int r0 = r0 + 1
            r7.e = r0     // Catch: java.lang.Exception -> L50
            org.apache.http.protocol.HttpContext r4 = r7.b     // Catch: java.lang.Exception -> L50
            boolean r0 = r3.retryRequest(r2, r0, r4)     // Catch: java.lang.Exception -> L50
            if (r0 == 0) goto L76
            r0 = r1
        L3f:
            r6 = r2
            r2 = r0
            r0 = r6
        L42:
            if (r2 == 0) goto L9
            aut r4 = r7.d     // Catch: java.lang.Exception -> L50
            if (r4 == 0) goto L9
            aut r4 = r7.d     // Catch: java.lang.Exception -> L50
            int r5 = r7.e     // Catch: java.lang.Exception -> L50
            r4.b(r5)     // Catch: java.lang.Exception -> L50
            goto L9
        L50:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = "AsyncHttpRequest"
            java.lang.String r2 = "Unhandled exception origin cause"
            android.util.Log.e(r0, r2, r1)
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unhandled exception: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
        L75:
            throw r0
        L76:
            r0 = 0
            goto L3f
        L78:
            r2 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Exception -> L50
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
            r4.<init>()     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = "NPE in HttpClient: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L50
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Exception -> L50
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch: java.lang.Exception -> L50
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L50
            r0.<init>(r2)     // Catch: java.lang.Exception -> L50
            int r2 = r7.e     // Catch: java.lang.Exception -> L50
            int r2 = r2 + 1
            r7.e = r2     // Catch: java.lang.Exception -> L50
            org.apache.http.protocol.HttpContext r4 = r7.b     // Catch: java.lang.Exception -> L50
            boolean r2 = r3.retryRequest(r0, r2, r4)     // Catch: java.lang.Exception -> L50
            goto L42
        La2:
            r0 = move-exception
            boolean r2 = r7.a()     // Catch: java.lang.Exception -> L50
            if (r2 != 0) goto Le
            int r2 = r7.e     // Catch: java.lang.Exception -> L50
            int r2 = r2 + 1
            r7.e = r2     // Catch: java.lang.Exception -> L50
            org.apache.http.protocol.HttpContext r4 = r7.b     // Catch: java.lang.Exception -> L50
            boolean r2 = r3.retryRequest(r0, r2, r4)     // Catch: java.lang.Exception -> L50
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.auf.d():void");
    }

    public boolean a() {
        if (this.f) {
            e();
        }
        return this.f;
    }

    private synchronized void e() {
        if (!this.h && this.f && !this.g) {
            this.g = true;
            if (this.d != null) {
                this.d.h();
            }
        }
    }

    public boolean b() {
        return a() || this.h;
    }

    public boolean a(boolean z) {
        this.f = true;
        this.c.abort();
        return a();
    }
}
