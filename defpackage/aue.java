package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

/* JADX INFO: loaded from: classes.dex */
public class aue {
    private int a;
    private int b;
    private int c;
    private final DefaultHttpClient d;
    private final HttpContext e;
    private ExecutorService f;
    private final Map<Context, List<aur>> g;
    private final Map<String, String> h;
    private boolean i;

    public aue() {
        this(false, 80, 443);
    }

    public aue(boolean z, int i, int i2) {
        this(a(z, i, i2));
    }

    private static SchemeRegistry a(boolean z, int i, int i2) {
        SSLSocketFactory socketFactory;
        if (z) {
            Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (z) {
            socketFactory = aup.b();
        } else {
            socketFactory = SSLSocketFactory.getSocketFactory();
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme("https", socketFactory, i2));
        return schemeRegistry;
    }

    public aue(SchemeRegistry schemeRegistry) {
        this.a = 10;
        this.b = 10000;
        this.c = 10000;
        this.i = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.c);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f = a();
        this.g = Collections.synchronizedMap(new WeakHashMap());
        this.h = new HashMap();
        this.e = new SyncBasicHttpContext(new BasicHttpContext());
        this.d = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.d.addRequestInterceptor(new HttpRequestInterceptor() { // from class: aue.1
            @Override // org.apache.http.HttpRequestInterceptor
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
                for (String str : aue.this.h.keySet()) {
                    if (httpRequest.containsHeader(str)) {
                        Header firstHeader = httpRequest.getFirstHeader(str);
                        Log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", str, aue.this.h.get(str), firstHeader.getName(), firstHeader.getValue()));
                        httpRequest.removeHeader(firstHeader);
                    }
                    httpRequest.addHeader(str, (String) aue.this.h.get(str));
                }
            }
        });
        this.d.addResponseInterceptor(new HttpResponseInterceptor() { // from class: aue.2
            @Override // org.apache.http.HttpResponseInterceptor
            public void process(HttpResponse httpResponse, HttpContext httpContext) {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    HeaderElement[] elements = contentEncoding.getElements();
                    for (HeaderElement headerElement : elements) {
                        if (headerElement.getName().equalsIgnoreCase("gzip")) {
                            httpResponse.setEntity(new a(entity));
                            return;
                        }
                    }
                }
            }
        });
        this.d.addRequestInterceptor(new HttpRequestInterceptor() { // from class: aue.3
            @Override // org.apache.http.HttpRequestInterceptor
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                Credentials credentials;
                AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
                CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
                HttpHost httpHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                if (authState.getAuthScheme() == null && (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) != null) {
                    authState.setAuthScheme(new BasicScheme());
                    authState.setCredentials(credentials);
                }
            }
        }, 0);
        this.d.setHttpRequestRetryHandler(new auu(5, 1500));
    }

    public void a(ExecutorService executorService) {
        this.f = executorService;
    }

    protected ExecutorService a() {
        return Executors.newCachedThreadPool();
    }

    public void a(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.b = i;
        HttpParams params = this.d.getParams();
        ConnManagerParams.setTimeout(params, this.b);
        HttpConnectionParams.setConnectionTimeout(params, this.b);
    }

    public void b(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.c = i;
        HttpConnectionParams.setSoTimeout(this.d.getParams(), this.c);
    }

    public void a(String str, String str2) {
        this.h.put(str, str2);
    }

    public void a(boolean z) {
        for (List<aur> list : this.g.values()) {
            if (list != null) {
                Iterator<aur> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(z);
                }
            }
        }
        this.g.clear();
    }

    public aur a(String str, aut autVar) {
        return a(null, str, null, autVar);
    }

    public aur a(String str, aus ausVar, aut autVar) {
        return a(null, str, ausVar, autVar);
    }

    public aur a(Context context, String str, aus ausVar, aut autVar) {
        return b(this.d, this.e, new HttpGet(a(this.i, str, ausVar)), null, autVar, context);
    }

    public aur b(String str, aus ausVar, aut autVar) {
        return b(null, str, ausVar, autVar);
    }

    public aur b(Context context, String str, aus ausVar, aut autVar) {
        return a(context, str, a(ausVar, autVar), (String) null, autVar);
    }

    public aur a(Context context, String str, HttpEntity httpEntity, String str2, aut autVar) {
        return b(this.d, this.e, a(new HttpPost(URI.create(str).normalize()), httpEntity), str2, autVar, context);
    }

    public aur b(String str, aut autVar) {
        return c(null, str, null, autVar);
    }

    public aur c(Context context, String str, aus ausVar, aut autVar) {
        return b(context, str, a(ausVar, autVar), null, autVar);
    }

    public aur b(Context context, String str, HttpEntity httpEntity, String str2, aut autVar) {
        return b(this.d, this.e, a(new HttpPut(URI.create(str).normalize()), httpEntity), str2, autVar, context);
    }

    public aur a(Context context, String str, Header[] headerArr, aus ausVar, aut autVar) {
        HttpDelete httpDelete = new HttpDelete(a(this.i, str, ausVar));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return b(this.d, this.e, httpDelete, null, autVar, context);
    }

    protected auf a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, aut autVar, Context context) {
        return new auf(defaultHttpClient, httpContext, httpUriRequest, autVar);
    }

    protected aur b(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, aut autVar, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (autVar == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
        if (autVar.d()) {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        if (str != null) {
            if ((httpUriRequest instanceof HttpEntityEnclosingRequestBase) && ((HttpEntityEnclosingRequestBase) httpUriRequest).getEntity() != null) {
                Log.w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
            } else {
                httpUriRequest.setHeader("Content-Type", str);
            }
        }
        autVar.a(httpUriRequest.getAllHeaders());
        autVar.a(httpUriRequest.getURI());
        auf aufVarA = a(defaultHttpClient, httpContext, httpUriRequest, str, autVar, context);
        this.f.submit(aufVarA);
        aur aurVar = new aur(aufVarA);
        if (context != null) {
            List<aur> listSynchronizedList = this.g.get(context);
            synchronized (this.g) {
                if (listSynchronizedList == null) {
                    listSynchronizedList = Collections.synchronizedList(new LinkedList());
                    this.g.put(context, listSynchronizedList);
                }
            }
            if (autVar instanceof auq) {
                ((auq) autVar).a(httpUriRequest);
            }
            listSynchronizedList.add(aurVar);
            Iterator<aur> it = listSynchronizedList.iterator();
            while (it.hasNext()) {
                if (it.next().c()) {
                    it.remove();
                }
            }
        }
        return aurVar;
    }

    public static String a(boolean z, String str, aus ausVar) {
        if (str == null) {
            return null;
        }
        String strReplace = z ? str.replace(" ", "%20") : str;
        if (ausVar != null) {
            String strTrim = ausVar.b().trim();
            if (!strTrim.equals("") && !strTrim.equals("?")) {
                return (strReplace + (strReplace.contains("?") ? "&" : "?")) + strTrim;
            }
            return strReplace;
        }
        return strReplace;
    }

    public static boolean a(PushbackInputStream pushbackInputStream) throws IOException {
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int i = pushbackInputStream.read(bArr);
        pushbackInputStream.unread(bArr);
        return i == 2 && 35615 == (((bArr[1] << 8) & 65280) | (bArr[0] & 255));
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.w("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.w("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    private HttpEntity a(aus ausVar, aut autVar) {
        if (ausVar == null) {
            return null;
        }
        try {
            return ausVar.a(autVar);
        } catch (IOException e) {
            if (autVar != null) {
                autVar.b(0, null, null, e);
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public static void a(HttpEntity httpEntity) {
        Field field;
        if (httpEntity instanceof HttpEntityWrapper) {
            try {
                Field[] declaredFields = HttpEntityWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i];
                    if (field.getName().equals("wrappedEntity")) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (field != null) {
                    field.setAccessible(true);
                    HttpEntity httpEntity2 = (HttpEntity) field.get(httpEntity);
                    if (httpEntity2 != null) {
                        httpEntity2.consumeContent();
                    }
                }
            } catch (Throwable th) {
                Log.e("AsyncHttpClient", "wrappedEntity consume", th);
            }
        }
    }

    static class a extends HttpEntityWrapper {
        InputStream a;
        PushbackInputStream b;
        GZIPInputStream c;

        public a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public InputStream getContent() {
            this.a = this.wrappedEntity.getContent();
            this.b = new PushbackInputStream(this.a, 2);
            if (!aue.a(this.b)) {
                return this.b;
            }
            this.c = new GZIPInputStream(this.b);
            return this.c;
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public long getContentLength() {
            if (this.wrappedEntity == null) {
                return 0L;
            }
            return this.wrappedEntity.getContentLength();
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public void consumeContent() {
            aue.a(this.a);
            aue.a((InputStream) this.b);
            aue.a(this.c);
            super.consumeContent();
        }
    }
}
