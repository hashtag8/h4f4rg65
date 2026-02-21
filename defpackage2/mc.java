package defpackage;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes.dex */
public class mc implements me {
    protected final HttpClient a;

    public mc(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // defpackage.me
    public HttpResponse a(lq<?> lqVar, Map<String, String> map) {
        HttpUriRequest httpUriRequestB = b(lqVar, map);
        a(httpUriRequestB, map);
        a(httpUriRequestB, lqVar.i());
        a(httpUriRequestB);
        HttpParams params = httpUriRequestB.getParams();
        int iT = lqVar.t();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iT);
        return this.a.execute(httpUriRequestB);
    }

    static HttpUriRequest b(lq<?> lqVar, Map<String, String> map) {
        switch (lqVar.a()) {
            case ContentLengthStrategy.IDENTITY /* -1 */:
                byte[] bArrM = lqVar.m();
                if (bArrM != null) {
                    HttpPost httpPost = new HttpPost(lqVar.d());
                    httpPost.addHeader("Content-Type", lqVar.l());
                    httpPost.setEntity(new ByteArrayEntity(bArrM));
                    return httpPost;
                }
                return new HttpGet(lqVar.d());
            case 0:
                return new HttpGet(lqVar.d());
            case 1:
                HttpPost httpPost2 = new HttpPost(lqVar.d());
                httpPost2.addHeader("Content-Type", lqVar.p());
                a(httpPost2, lqVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(lqVar.d());
                httpPut.addHeader("Content-Type", lqVar.p());
                a(httpPut, lqVar);
                return httpPut;
            case 3:
                return new HttpDelete(lqVar.d());
            case 4:
                return new HttpHead(lqVar.d());
            case 5:
                return new HttpOptions(lqVar.d());
            case 6:
                return new HttpTrace(lqVar.d());
            case 7:
                a aVar = new a(lqVar.d());
                aVar.addHeader("Content-Type", lqVar.p());
                a(aVar, lqVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, lq<?> lqVar) {
        byte[] bArrQ = lqVar.q();
        if (bArrQ != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrQ));
        }
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }

    public static final class a extends HttpEntityEnclosingRequestBase {
        public a() {
        }

        public a(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }
}
