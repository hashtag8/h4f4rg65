package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class tw extends ud {
    private static final byte[] c = "\n".getBytes();
    private final String a;
    private final ty b;

    class a {
        private int b;
        private ByteArrayOutputStream c = new ByteArrayOutputStream();

        public a() {
        }

        public int a() {
            return this.b;
        }

        public boolean a(tq tqVar) {
            vq.a(tqVar);
            if (this.b + 1 > tw.this.q().m()) {
                return false;
            }
            String strA = tw.this.a(tqVar, false);
            if (strA == null) {
                tw.this.p().a(tqVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = strA.getBytes();
            int length = bytes.length;
            if (length > tw.this.q().e()) {
                tw.this.p().a(tqVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.c.size() > 0) {
                length++;
            }
            if (length + this.c.size() > tw.this.q().g()) {
                return false;
            }
            try {
                if (this.c.size() > 0) {
                    this.c.write(tw.c);
                }
                this.c.write(bytes);
                this.b++;
                return true;
            } catch (IOException e) {
                tw.this.e("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public byte[] b() {
            return this.c.toByteArray();
        }
    }

    tw(uf ufVar) {
        super(ufVar);
        this.a = a("GoogleAnalytics", ue.a, Build.VERSION.RELEASE, tz.a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.b = new ty(ufVar.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(java.net.URL r6, byte[] r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            defpackage.vq.a(r6)
            defpackage.vq.a(r7)
            java.lang.String r0 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.b(r0, r2, r6)
            boolean r0 = r5.B()
            if (r0 == 0) goto L21
            java.lang.String r0 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.a(r0, r2)
        L21:
            java.net.HttpURLConnection r2 = r5.a(r6)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L7e
            r0 = 1
            r2.setDoOutput(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r7.length     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.connect()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r1.write(r7)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.a(r2)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L49
            ub r3 = r5.t()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3.g()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
        L49:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.b(r3, r4)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L5d
        L57:
            if (r2 == 0) goto L5c
            r2.disconnect()
        L5c:
            return r0
        L5d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L57
        L64:
            r0 = move-exception
            r2 = r1
        L66:
            java.lang.String r3 = "Network POST connection error"
            r5.d(r3, r0)     // Catch: java.lang.Throwable -> L92
            r0 = 0
            if (r1 == 0) goto L71
            r1.close()     // Catch: java.io.IOException -> L77
        L71:
            if (r2 == 0) goto L5c
            r2.disconnect()
            goto L5c
        L77:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L71
        L7e:
            r0 = move-exception
            r2 = r1
        L80:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L8b
        L85:
            if (r2 == 0) goto L8a
            r2.disconnect()
        L8a:
            throw r0
        L8b:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L85
        L92:
            r0 = move-exception
            goto L80
        L94:
            r0 = move-exception
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tw.a(java.net.URL, byte[]):int");
    }

    private static String a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private URL a(tq tqVar, String str) {
        try {
            return new URL(tqVar.f() ? q().o() + q().q() + "?" + str : q().p() + q().q() + "?" + str);
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, HTTP.UTF_8));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, HTTP.UTF_8));
    }

    private void a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private boolean a(tq tqVar) {
        vq.a(tqVar);
        String strA = a(tqVar, !tqVar.f());
        if (strA == null) {
            p().a(tqVar, "Error formatting hit for upload");
            return true;
        }
        if (strA.length() <= q().d()) {
            URL urlA = a(tqVar, strA);
            if (urlA != null) {
                return b(urlA) == 200;
            }
            f("Failed to build collect GET endpoint url");
            return false;
        }
        String strA2 = a(tqVar, false);
        if (strA2 == null) {
            p().a(tqVar, "Error formatting hit for POST upload");
            return true;
        }
        byte[] bytes = strA2.getBytes();
        if (bytes.length > q().f()) {
            p().a(tqVar, "Hit payload exceeds size limit");
            return true;
        }
        URL urlB = b(tqVar);
        if (urlB != null) {
            return a(urlB, bytes) == 200;
        }
        f("Failed to build collect POST endpoint url");
        return false;
    }

    private static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private int b(URL url) {
        int responseCode;
        vq.a(url);
        b("GET request", url);
        HttpURLConnection httpURLConnectionA = null;
        try {
            try {
                httpURLConnectionA = a(url);
                httpURLConnectionA.connect();
                a(httpURLConnectionA);
                responseCode = httpURLConnectionA.getResponseCode();
                if (responseCode == 200) {
                    t().g();
                }
                b("GET status", Integer.valueOf(responseCode));
            } catch (IOException e) {
                d("Network GET connection error", e);
                responseCode = 0;
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
            }
            return responseCode;
        } finally {
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(java.net.URL r9, byte[] r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tw.b(java.net.URL, byte[]):int");
    }

    private URL b(tq tqVar) {
        try {
            return new URL(tqVar.f() ? q().o() + q().q() : q().p() + q().q());
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String c(tq tqVar) {
        return String.valueOf(tqVar.c());
    }

    private URL d() {
        try {
            return new URL(q().o() + q().r());
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String a(tq tqVar, boolean z) {
        vq.a(tqVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : tqVar.b().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    a(sb, key, entry.getValue());
                }
            }
            a(sb, "ht", String.valueOf(tqVar.d()));
            a(sb, "qt", String.valueOf(n().a() - tqVar.d()));
            if (q().a()) {
                a(sb, "_gmsv", ue.a);
            }
            if (z) {
                long jG = tqVar.g();
                a(sb, "z", jG != 0 ? String.valueOf(jG) : c(tqVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e("Failed to encode name or value", e);
            return null;
        }
    }

    HttpURLConnection a(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(q().D());
        httpURLConnection.setReadTimeout(q().E());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, this.a);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> a(List<tq> list) {
        boolean z;
        boolean z2 = true;
        m();
        D();
        vq.a(list);
        if (q().u().isEmpty() || !this.b.a(q().n() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = q().s() != um.NONE;
            if (q().t() != uo.GZIP) {
                z2 = false;
            }
        }
        return z ? a(list, z2) : b(list);
    }

    List<Long> a(List<tq> list, boolean z) {
        vq.b(!list.isEmpty());
        a("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        a aVar = new a();
        ArrayList arrayList = new ArrayList();
        for (tq tqVar : list) {
            if (!aVar.a(tqVar)) {
                break;
            }
            arrayList.add(Long.valueOf(tqVar.c()));
        }
        if (aVar.a() == 0) {
            return arrayList;
        }
        URL urlD = d();
        if (urlD == null) {
            f("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int iB = z ? b(urlD, aVar.b()) : a(urlD, aVar.b());
        if (200 == iB) {
            a("Batched upload completed. Hits batched", Integer.valueOf(aVar.a()));
            return arrayList;
        }
        a("Network error uploading hits. status code", Integer.valueOf(iB));
        if (q().u().contains(Integer.valueOf(iB))) {
            e("Server instructed the client to stop batching");
            this.b.a();
        }
        return Collections.emptyList();
    }

    @Override // defpackage.ud
    protected void a() {
        a("Network initialized. User agent", this.a);
    }

    List<Long> b(List<tq> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (tq tqVar : list) {
            if (!a(tqVar)) {
                break;
            }
            arrayList.add(Long.valueOf(tqVar.c()));
            if (arrayList.size() >= q().l()) {
                break;
            }
        }
        return arrayList;
    }

    public boolean b() {
        NetworkInfo activeNetworkInfo;
        m();
        D();
        try {
            activeNetworkInfo = ((ConnectivityManager) o().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        b("No network connectivity");
        return false;
    }
}
