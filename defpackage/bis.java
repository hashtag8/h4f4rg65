package defpackage;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import defpackage.bhv;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class bis implements bhv {
    static volatile Object a;
    private static final Object b = new Object();
    private static final ThreadLocal<StringBuilder> c = new ThreadLocal<StringBuilder>() { // from class: bis.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private final Context d;

    public bis(Context context) {
        this.d = context.getApplicationContext();
    }

    protected HttpURLConnection a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    @Override // defpackage.bhv
    public bhv.a a(Uri uri, int i) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            a(this.d);
        }
        HttpURLConnection httpURLConnectionA = a(uri);
        httpURLConnectionA.setUseCaches(true);
        if (i != 0) {
            if (bic.c(i)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = c.get();
                sb.setLength(0);
                if (!bic.a(i)) {
                    sb.append("no-cache");
                }
                if (!bic.b(i)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionA.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionA.getResponseCode();
        if (responseCode >= 300) {
            httpURLConnectionA.disconnect();
            throw new bhv.b(responseCode + " " + httpURLConnectionA.getResponseMessage(), i, responseCode);
        }
        return new bhv.a(httpURLConnectionA.getInputStream(), bit.a(httpURLConnectionA.getHeaderField("X-Android-Response-Source")), httpURLConnectionA.getHeaderFieldInt(HTTP.CONTENT_LEN, -1));
    }

    private static void a(Context context) {
        if (a == null) {
            try {
                synchronized (b) {
                    if (a == null) {
                        a = a.a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    static class a {
        static Object a(Context context) {
            File fileB = bit.b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            if (installed == null) {
                return HttpResponseCache.install(fileB, bit.a(fileB));
            }
            return installed;
        }
    }
}
