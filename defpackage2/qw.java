package defpackage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes.dex */
public class qw {
    private static HttpClient a = null;

    private static HttpClient a() {
        if (a == null) {
            a = new DefaultHttpClient();
            a.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
            a.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
        }
        return a;
    }

    public static String a(String str) {
        String string = "";
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientA = a();
        synchronized (httpClientA) {
            try {
                HttpResponse httpResponseExecute = httpClientA.execute(httpGet);
                if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                    string = EntityUtils.toString(httpResponseExecute.getEntity());
                }
                httpResponseExecute.getEntity().consumeContent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return string;
    }
}
