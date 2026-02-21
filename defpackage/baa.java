package defpackage;

import defpackage.bab;
import defpackage.bai;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.Arrays;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class baa implements bab, bab.d, Serializable {
    public final bae a = bae.LIVE;
    public boolean c;
    private bak e;
    private final String f;
    private final String g;
    private final URI h;
    private transient HttpClient i;
    private transient bab.d j;
    private String k;
    private String l;
    private bak m;
    private static final bak d = new bak(null, null, null);
    public static String b = "OAuth";
    private static final ThreadLocal<baj> n = new ThreadLocal<baj>() { // from class: baa.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public baj initialValue() {
            return new baj();
        }
    };

    public baa(String str, String str2, URI uri, bak bakVar) {
        this.f = str;
        this.g = str2;
        this.h = uri;
        this.e = bakVar == null ? d : bakVar;
    }

    public bak a(String str, String... strArr) {
        if (str == null) {
            throw new IllegalArgumentException("code is null");
        }
        this.e = a(a(baj.a("/oauth2/token", new Object[0]).a("grant_type", "authorization_code", "client_id", this.f, "client_secret", this.g, "redirect_uri", this.h, "code", str), strArr));
        return this.e;
    }

    @Override // defpackage.bab
    public bak a() {
        if (this.e == null || this.e.e() == null) {
            throw new IllegalStateException("no refresh token available");
        }
        this.e = a(baj.a("/oauth2/token", new Object[0]).a("grant_type", "refresh_token", "client_id", this.f, "client_secret", this.g, "refresh_token", this.e.e()));
        return this.e;
    }

    @Override // defpackage.bab
    public bak b() {
        if (this.e == null) {
            return null;
        }
        bak bakVarB = this.j == null ? null : this.j.b(this.e);
        this.e.a();
        if (bakVarB == null) {
            return null;
        }
        this.e = bakVarB;
        return this.e;
    }

    public URI a(String... strArr) {
        baj bajVarA = baj.a(strArr.length == 0 ? "/oauth2/authorize?mode=redirect" : strArr[0], new Object[0]).a("redirect_uri", this.h, "client_id", this.f, "response_type", "code");
        if (strArr.length > 1) {
            bajVarA.a("scope", (Object) strArr[1]);
        }
        if (strArr.length > 2) {
            bajVarA.a("display", (Object) strArr[2]);
        }
        if (strArr.length > 3) {
            bajVarA.a("state", (Object) strArr[3]);
        }
        return a(bajVarA, false, true);
    }

    public URI a(baj bajVar, boolean z, boolean z2) {
        return (z ? this.a.c(z2) : this.a.d(z2)).resolve(bajVar.b());
    }

    public String c() {
        return "SoundCloud Java Wrapper (1.3.1)";
    }

    protected bak a(baj bajVar) throws bab.c, JSONException, bab.a, bab.b {
        String message;
        HttpResponse httpResponseA = a(this.a.c, bajVar.a(HttpPost.class));
        int statusCode = httpResponseA.getStatusLine().getStatusCode();
        try {
        } catch (IOException e) {
            message = e.getMessage();
        } catch (JSONException e2) {
            message = e2.getMessage();
        }
        if (statusCode == 200) {
            bak bakVar = new bak(bag.b(httpResponseA));
            if (bakVar.c().equals("bearer")) {
                b = "Bearer";
            } else {
                b = "OAuth";
            }
            this.m = bakVar;
            if (this.j != null) {
                this.j.c(bakVar);
            }
            return bakVar;
        }
        message = bag.b(httpResponseA).getString("error");
        if (statusCode == 401) {
            throw new bab.c(statusCode, message);
        }
        throw new bab.a(httpResponseA, message);
    }

    protected HttpParams d() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        basicHttpParams.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
        basicHttpParams.setParameter("http.conn-manager.max-per-route", new ConnPerRoute() { // from class: baa.1
            @Override // org.apache.http.conn.params.ConnPerRoute
            public int getMaxForRoute(HttpRoute httpRoute) {
                return baa.this.a.a(httpRoute.getTargetHost()) ? 10 : 2;
            }
        });
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property != null) {
            int i = 80;
            try {
                i = Integer.parseInt(property2);
            } catch (NumberFormatException e) {
            }
            basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(property, i));
        }
        return basicHttpParams;
    }

    protected SocketFactory e() {
        return PlainSocketFactory.getSocketFactory();
    }

    protected SSLSocketFactory f() {
        return SSLSocketFactory.getSocketFactory();
    }

    public HttpClient g() {
        if (this.i == null) {
            HttpParams httpParamsD = d();
            HttpClientParams.setRedirecting(httpParamsD, false);
            HttpProtocolParams.setUserAgent(httpParamsD, c());
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, e(), 80));
            schemeRegistry.register(new Scheme("https", f(), 443));
            this.i = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParamsD, schemeRegistry), httpParamsD) { // from class: baa.2
                {
                    setKeepAliveStrategy(new ConnectionKeepAliveStrategy() { // from class: baa.2.1
                        @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
                        public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                            return 20000L;
                        }
                    });
                    getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, -1, "SoundCloud", "oauth"), bai.a.a);
                    getAuthSchemes().register("oauth", new bai.b(baa.this));
                    addResponseInterceptor(new HttpResponseInterceptor() { // from class: baa.2.2
                        @Override // org.apache.http.HttpResponseInterceptor
                        public void process(HttpResponse httpResponse, HttpContext httpContext) {
                            HttpEntity entity;
                            Header contentEncoding;
                            if (httpResponse != null && httpResponse.getEntity() != null && (contentEncoding = (entity = httpResponse.getEntity()).getContentEncoding()) != null) {
                                HeaderElement[] elements = contentEncoding.getElements();
                                for (HeaderElement headerElement : elements) {
                                    if (headerElement.getName().equalsIgnoreCase("gzip")) {
                                        httpResponse.setEntity(new baf(entity));
                                        return;
                                    }
                                }
                            }
                        }
                    });
                }

                @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
                protected HttpContext createHttpContext() {
                    HttpContext httpContextCreateHttpContext = super.createHttpContext();
                    httpContextCreateHttpContext.setAttribute("http.auth.scheme-pref", Arrays.asList("oauth", "digest", "basic"));
                    return httpContextCreateHttpContext;
                }

                @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
                protected BasicHttpProcessor createHttpProcessor() {
                    BasicHttpProcessor basicHttpProcessorCreateHttpProcessor = super.createHttpProcessor();
                    basicHttpProcessorCreateHttpProcessor.addInterceptor(new bah());
                    return basicHttpProcessorCreateHttpProcessor;
                }

                @Override // org.apache.http.impl.client.AbstractHttpClient
                protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
                    return baa.this.a(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
                }
            };
        }
        return this.i;
    }

    public HttpResponse b(baj bajVar) {
        return a(bajVar, HttpPost.class);
    }

    @Override // defpackage.bab
    public bak h() {
        return this.e;
    }

    public HttpResponse a(HttpUriRequest httpUriRequest) {
        return a(this.a.c, e(httpUriRequest));
    }

    public HttpResponse a(HttpHost httpHost, HttpUriRequest httpUriRequest) throws bab.b {
        if (httpHost == null) {
            httpHost = b(httpUriRequest);
        }
        try {
            return g().execute(httpHost, httpUriRequest);
        } catch (ArrayIndexOutOfBoundsException e) {
            httpUriRequest.abort();
            throw new bab.b(e);
        } catch (IllegalArgumentException e2) {
            httpUriRequest.abort();
            throw new bab.b(e2);
        } catch (NullPointerException e3) {
            if (!httpUriRequest.isAborted() && httpUriRequest.getParams().isParameterFalse("npe-retried")) {
                httpUriRequest.getParams().setBooleanParameter("npe-retried", true);
                return a(httpHost, httpUriRequest);
            }
            httpUriRequest.abort();
            throw new bab.b(e3);
        }
    }

    protected HttpResponse a(baj bajVar, Class<? extends HttpRequestBase> cls) {
        baj bajVar2 = n.get();
        if (bajVar2 != null && !bajVar2.d().isEmpty()) {
            for (NameValuePair nameValuePair : bajVar2) {
                baj bajVar3 = new baj(bajVar);
                bajVar3.a(nameValuePair.getName(), (Object) nameValuePair.getValue());
                bajVar = bajVar3;
            }
        }
        a(cls, bajVar);
        return a(c(bajVar).a(cls));
    }

    protected baj c(baj bajVar) {
        return bajVar.d().containsKey("client_id") ? bajVar : new baj(bajVar).a("client_id", (Object) this.f);
    }

    protected void a(Class<? extends HttpRequestBase> cls, baj bajVar) {
        if (this.c) {
            System.err.println(cls.getSimpleName() + " " + bajVar);
        }
    }

    protected HttpHost b(HttpUriRequest httpUriRequest) {
        URI uri = httpUriRequest.getURI();
        if (uri.isAbsolute()) {
            return new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        }
        return null;
    }

    public String i() {
        return this.k == null ? "application/json" : this.k;
    }

    public String j() {
        return this.l;
    }

    static baj a(baj bajVar, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(" ");
                }
            }
            bajVar.a("scope", (Object) sb.toString());
        }
        return bajVar;
    }

    public static Header a(bak bakVar) {
        return new BasicHeader("Authorization", b + " " + ((bakVar == null || !bakVar.b()) ? "invalidated" : bakVar.d()));
    }

    protected HttpUriRequest c(HttpUriRequest httpUriRequest) {
        if (!httpUriRequest.containsHeader("Authorization") && this.e != d) {
            httpUriRequest.addHeader(a(this.e));
        }
        return httpUriRequest;
    }

    protected HttpUriRequest d(HttpUriRequest httpUriRequest) {
        if (!httpUriRequest.containsHeader("Accept")) {
            httpUriRequest.addHeader("Accept", i());
        }
        return httpUriRequest;
    }

    protected HttpUriRequest e(HttpUriRequest httpUriRequest) {
        return d(c(f(httpUriRequest)));
    }

    protected HttpUriRequest f(HttpUriRequest httpUriRequest) {
        if (j() != null) {
            httpUriRequest.addHeader("Accept-Encoding", j());
        }
        return httpUriRequest;
    }

    protected RequestDirector a(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new DefaultRequestDirector(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
    }

    @Override // bab.d
    public bak b(bak bakVar) {
        return bakVar;
    }

    @Override // bab.d
    public void c(bak bakVar) {
    }
}
