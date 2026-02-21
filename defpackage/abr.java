package defpackage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: loaded from: classes.dex */
public class abr implements abq {
    private final a a;
    private final SSLSocketFactory b;

    public interface a {
        String a(String str);
    }

    public abr() {
        this(null);
    }

    public abr(a aVar) {
        this(aVar, null);
    }

    public abr(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.a = aVar;
        this.b = sSLSocketFactory;
    }

    private HttpURLConnection a(URL url, aac<?> aacVar) {
        HttpURLConnection httpURLConnectionA = a(url);
        int iR = aacVar.r();
        httpURLConnectionA.setConnectTimeout(iR);
        httpURLConnectionA.setReadTimeout(iR);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.b != null) {
            ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(this.b);
        }
        return httpURLConnectionA;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void a(HttpURLConnection httpURLConnection, aac<?> aacVar) throws ProtocolException {
        switch (aacVar.b()) {
            case ContentLengthStrategy.IDENTITY /* -1 */:
                byte[] bArrK = aacVar.k();
                if (bArrK != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", aacVar.j());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrK);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, aacVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, aacVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, aacVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, aac<?> aacVar) {
        byte[] bArrO = aacVar.o();
        if (bArrO != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", aacVar.n());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrO);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // defpackage.abq
    public HttpResponse a(aac<?> aacVar, Map<String, String> map) throws IOException {
        String strA;
        String strD = aacVar.d();
        HashMap map2 = new HashMap();
        map2.putAll(aacVar.a());
        map2.putAll(map);
        if (this.a != null) {
            strA = this.a.a(strD);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strD);
            }
        } else {
            strA = strD;
        }
        HttpURLConnection httpURLConnectionA = a(new URL(strA), aacVar);
        for (String str : map2.keySet()) {
            httpURLConnectionA.addRequestProperty(str, (String) map2.get(str));
        }
        a(httpURLConnectionA, aacVar);
        ProtocolVersion protocolVersion = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (httpURLConnectionA.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, httpURLConnectionA.getResponseCode(), httpURLConnectionA.getResponseMessage()));
        basicHttpResponse.setEntity(a(httpURLConnectionA));
        for (Map.Entry<String, List<String>> entry : httpURLConnectionA.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }
}
