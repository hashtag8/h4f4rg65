package defpackage;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
class bah implements HttpRequestInterceptor {
    bah() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        AuthState authState;
        AuthScheme authScheme;
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && (authState = (AuthState) httpContext.getAttribute("http.auth.target-scope")) != null && (authScheme = authState.getAuthScheme()) != null && !authScheme.isConnectionBased()) {
            try {
                httpRequest.setHeader(authScheme.authenticate(null, httpRequest));
            } catch (AuthenticationException e) {
            }
        }
    }
}
