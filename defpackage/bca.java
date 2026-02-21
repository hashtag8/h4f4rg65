package defpackage;

import com.musicservice.soundcloud.api.Stream;
import defpackage.bcb;
import defpackage.bci;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
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
public class bca implements bcb, Serializable {
    private static final bck d = new bck(null, null);
    private static final ThreadLocal<bcj> m = new ThreadLocal<bcj>() { // from class: bca.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bcj initialValue() {
            return new bcj();
        }
    };
    public final bce a = bce.LIVE;
    public final bce b = bce.LIVEV2;
    public boolean c;
    private bck e;
    private final String f;
    private final String g;
    private final URI h;
    private transient HttpClient i;
    private transient bcb.e j;
    private String k;
    private String l;

    public bca(String str, String str2, URI uri, bck bckVar) {
        this.f = str;
        this.g = str2;
        this.h = uri;
        this.e = bckVar == null ? d : bckVar;
    }

    public bck a(String str, String... strArr) {
        if (str == null) {
            throw new IllegalArgumentException("code is null");
        }
        this.e = a(a(bcj.a("/oauth2/token", new Object[0]).a("grant_type", "authorization_code", "client_id", this.f, "client_secret", this.g, "redirect_uri", this.h, "code", str), strArr));
        return this.e;
    }

    @Override // defpackage.bcb
    public bck a() {
        if (this.e == null || this.e.b == null) {
            throw new IllegalStateException("no refresh token available");
        }
        this.e = a(bcj.a("/oauth2/token", new Object[0]).a("grant_type", "refresh_token", "client_id", this.f, "client_secret", this.g, "refresh_token", this.e.b));
        return this.e;
    }

    @Override // defpackage.bcb
    public bck b() {
        if (this.e == null) {
            return null;
        }
        bck bckVarA = this.j == null ? null : this.j.a(this.e);
        this.e.a();
        if (bckVarA == null) {
            return null;
        }
        this.e = bckVarA;
        return this.e;
    }

    public URI a(String... strArr) {
        bcj bcjVarA = bcj.a(strArr.length == 0 ? "/connect" : strArr[0], new Object[0]).a("redirect_uri", this.h, "client_id", this.f, "response_type", "code");
        if (strArr.length > 1) {
            bcjVarA.a("scope", (Object) strArr[1]);
        }
        if (strArr.length > 2) {
            bcjVarA.a("display", (Object) strArr[2]);
        }
        if (strArr.length > 3) {
            bcjVarA.a("state", (Object) strArr[3]);
        }
        return a(bcjVarA, false, true);
    }

    public URI a(bcj bcjVar, boolean z, boolean z2) {
        return (z ? this.a.c(z2) : this.a.d(z2)).resolve(bcjVar.b());
    }

    public String c() {
        return "SoundCloud Java Wrapper (1.3.1)";
    }

    protected bck a(bcj bcjVar) throws JSONException, bcb.c, bcb.b, bcb.a {
        String message;
        HttpResponse httpResponseA = a(this.a.e, bcjVar.a(HttpPost.class));
        int statusCode = httpResponseA.getStatusLine().getStatusCode();
        try {
        } catch (IOException e) {
            message = e.getMessage();
        } catch (JSONException e2) {
            message = e2.getMessage();
        }
        if (statusCode == 200) {
            bck bckVar = new bck(bcg.b(httpResponseA));
            if (this.j != null) {
                this.j.b(bckVar);
            }
            return bckVar;
        }
        message = bcg.b(httpResponseA).getString("error");
        if (statusCode == 401) {
            throw new bcb.c(statusCode, message);
        }
        throw new bcb.a(httpResponseA, message);
    }

    protected HttpParams d() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        basicHttpParams.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
        basicHttpParams.setParameter("http.conn-manager.max-per-route", new ConnPerRoute() { // from class: bca.1
            @Override // org.apache.http.conn.params.ConnPerRoute
            public int getMaxForRoute(HttpRoute httpRoute) {
                return bca.this.a.a(httpRoute.getTargetHost()) ? 10 : 2;
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
            this.i = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParamsD, schemeRegistry), httpParamsD) { // from class: bca.2
                {
                    setKeepAliveStrategy(new ConnectionKeepAliveStrategy() { // from class: bca.2.1
                        @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
                        public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                            return 20000L;
                        }
                    });
                    getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, -1, "SoundCloud", "oauth"), bci.a.a);
                    getAuthSchemes().register("oauth", new bci.b(bca.this));
                    addResponseInterceptor(new HttpResponseInterceptor() { // from class: bca.2.2
                        @Override // org.apache.http.HttpResponseInterceptor
                        public void process(HttpResponse httpResponse, HttpContext httpContext) {
                            HttpEntity entity;
                            Header contentEncoding;
                            if (httpResponse != null && httpResponse.getEntity() != null && (contentEncoding = (entity = httpResponse.getEntity()).getContentEncoding()) != null) {
                                HeaderElement[] elements = contentEncoding.getElements();
                                for (HeaderElement headerElement : elements) {
                                    if (headerElement.getName().equalsIgnoreCase("gzip")) {
                                        httpResponse.setEntity(new bcf(entity));
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
                    basicHttpProcessorCreateHttpProcessor.addInterceptor(new bch());
                    return basicHttpProcessorCreateHttpProcessor;
                }

                @Override // org.apache.http.impl.client.AbstractHttpClient
                protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
                    return bca.this.a(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
                }
            };
        }
        return this.i;
    }

    public Stream a(String str, boolean z) throws bcb.d, bcb.b {
        HttpResponse httpResponseA = a((HttpHost) null, e(bcj.a(str, new Object[0]).a(HttpHead.class)));
        if (httpResponseA.getStatusLine().getStatusCode() == 302) {
            Header firstHeader = httpResponseA.getFirstHeader("Location");
            if (firstHeader != null && firstHeader.getValue() != null) {
                String value = firstHeader.getValue();
                HttpResponse httpResponseA2 = a((HttpHost) null, new HttpHead(value));
                if (httpResponseA2.getStatusLine().getStatusCode() == 200) {
                    Stream stream = new Stream(str, value, httpResponseA2);
                    bcj bcjVarA = bcj.a(str, new Object[0]);
                    if (z) {
                        bcjVarA.a("skip_logging", "1");
                    }
                    HttpResponse httpResponseA3 = a((HttpHost) null, e(bcj.a(str, new Object[0]).a(HttpGet.class)));
                    if (httpResponseA3.getStatusLine().getStatusCode() == 302) {
                        return stream.a(httpResponseA3.getFirstHeader("Location").getValue());
                    }
                    throw new bcb.d("Unexpected response code", httpResponseA3);
                }
                throw new bcb.d("Unexpected response code", httpResponseA2);
            }
            throw new bcb.d("Location header not set", httpResponseA);
        }
        throw new bcb.d("Unexpected response code", httpResponseA);
    }

    public HttpResponse b(bcj bcjVar) {
        return a(bcjVar, HttpGet.class);
    }

    @Override // defpackage.bcb
    public bck h() {
        return this.e;
    }

    public HttpResponse a(HttpUriRequest httpUriRequest) {
        return (httpUriRequest.getURI().toString().contains("/explore") || (httpUriRequest.getURI().toString().contains("/stream?") && !httpUriRequest.getURI().toString().contains("track")) || httpUriRequest.getURI().toString().contains("/search")) ? a(this.b.e, e(httpUriRequest)) : a(this.a.e, e(httpUriRequest));
    }

    public HttpResponse a(HttpHost httpHost, HttpUriRequest httpUriRequest) throws bcb.b {
        if (httpHost == null) {
            httpHost = b(httpUriRequest);
        }
        try {
            return g().execute(httpHost, httpUriRequest);
        } catch (ArrayIndexOutOfBoundsException e) {
            httpUriRequest.abort();
            throw new bcb.b(e);
        } catch (IllegalArgumentException e2) {
            httpUriRequest.abort();
            throw new bcb.b(e2);
        } catch (NullPointerException e3) {
            if (!httpUriRequest.isAborted() && httpUriRequest.getParams().isParameterFalse("npe-retried")) {
                httpUriRequest.getParams().setBooleanParameter("npe-retried", true);
                return a(httpHost, httpUriRequest);
            }
            httpUriRequest.abort();
            throw new bcb.b(e3);
        }
    }

    protected HttpResponse a(bcj bcjVar, Class<? extends HttpRequestBase> cls) {
        bcj bcjVar2 = m.get();
        if (bcjVar2 != null && !bcjVar2.e().isEmpty()) {
            for (NameValuePair nameValuePair : bcjVar2) {
                bcj bcjVar3 = new bcj(bcjVar);
                bcjVar3.a(nameValuePair.getName(), (Object) nameValuePair.getValue());
                bcjVar = bcjVar3;
            }
        }
        a(cls, bcjVar);
        return a(c(bcjVar).a(cls));
    }

    protected bcj c(bcj bcjVar) {
        if (bcjVar.c().contains("/explore")) {
            return bcjVar;
        }
        return ((bcjVar.c().contains("/stream?") && !bcjVar.c().contains("track")) || bcjVar.c().contains("/search") || bcjVar.e().containsKey("client_id")) ? bcjVar : new bcj(bcjVar).a("client_id", (Object) this.f);
    }

    protected void a(Class<? extends HttpRequestBase> cls, bcj bcjVar) {
        if (this.c) {
            System.err.println(cls.getSimpleName() + " " + bcjVar);
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

    static bcj a(bcj bcjVar, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(" ");
                }
            }
            bcjVar.a("scope", (Object) sb.toString());
        }
        return bcjVar;
    }

    public static Header a(bck bckVar) {
        return new BasicHeader("Authorization", "OAuth " + ((bckVar == null || !bckVar.c()) ? "invalidated" : bckVar.a));
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
}
