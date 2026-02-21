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
public class abo implements abq {
    protected final HttpClient a;

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

    public abo(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, aac<?> aacVar) {
        byte[] bArrO = aacVar.o();
        if (bArrO != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrO));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    static HttpUriRequest b(aac<?> aacVar, Map<String, String> map) {
        switch (aacVar.b()) {
            case ContentLengthStrategy.IDENTITY /* -1 */:
                byte[] bArrK = aacVar.k();
                if (bArrK == null) {
                    return new HttpGet(aacVar.d());
                }
                HttpPost httpPost = new HttpPost(aacVar.d());
                httpPost.addHeader("Content-Type", aacVar.j());
                httpPost.setEntity(new ByteArrayEntity(bArrK));
                return httpPost;
            case 0:
                return new HttpGet(aacVar.d());
            case 1:
                HttpPost httpPost2 = new HttpPost(aacVar.d());
                httpPost2.addHeader("Content-Type", aacVar.n());
                a(httpPost2, aacVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(aacVar.d());
                httpPut.addHeader("Content-Type", aacVar.n());
                a(httpPut, aacVar);
                return httpPut;
            case 3:
                return new HttpDelete(aacVar.d());
            case 4:
                return new HttpHead(aacVar.d());
            case 5:
                return new HttpOptions(aacVar.d());
            case 6:
                return new HttpTrace(aacVar.d());
            case 7:
                a aVar = new a(aacVar.d());
                aVar.addHeader("Content-Type", aacVar.n());
                a(aVar, aacVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    @Override // defpackage.abq
    public HttpResponse a(aac<?> aacVar, Map<String, String> map) {
        HttpUriRequest httpUriRequestB = b(aacVar, map);
        a(httpUriRequestB, map);
        a(httpUriRequestB, aacVar.a());
        a(httpUriRequestB);
        HttpParams params = httpUriRequestB.getParams();
        int iR = aacVar.r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iR);
        return this.a.execute(httpUriRequestB);
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }
}
