package defpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class bnv {
    private static final String[] b = new String[0];
    private static b c = b.a;
    public final URL a;
    private final String e;
    private e f;
    private boolean g;
    private String k;
    private int l;
    private HttpURLConnection d = null;
    private boolean h = true;
    private boolean i = false;
    private int j = 8192;

    public interface b {
        public static final b a = new b() { // from class: bnv.b.1
            @Override // bnv.b
            public HttpURLConnection a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // bnv.b
            public HttpURLConnection a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection a(URL url);

        HttpURLConnection a(URL url, Proxy proxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        return (str == null || str.length() <= 0) ? HTTP.UTF_8 : str;
    }

    private static StringBuilder a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    private static StringBuilder b(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (iIndexOf == -1) {
            sb.append('?');
        } else if (iIndexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static class c extends RuntimeException {
        protected c(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public static abstract class d<V> implements Callable<V> {
        protected abstract V b();

        protected abstract void c();

        protected d() {
        }

        @Override // java.util.concurrent.Callable
        public V call() throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        V vB = b();
                        try {
                            c();
                            return vB;
                        } catch (IOException e) {
                            throw new c(e);
                        }
                    } catch (IOException e2) {
                        throw new c(e2);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        try {
                            c();
                        } catch (IOException e3) {
                            if (!z) {
                                throw new c(e3);
                            }
                        }
                        throw th;
                    }
                } catch (c e4) {
                    throw e4;
                }
            } catch (Throwable th2) {
                th = th2;
                c();
                throw th;
            }
        }
    }

    public static abstract class a<V> extends d<V> {
        private final Closeable a;
        private final boolean b;

        protected a(Closeable closeable, boolean z) {
            this.a = closeable;
            this.b = z;
        }

        @Override // bnv.d
        protected void c() throws IOException {
            if (this.a instanceof Flushable) {
                ((Flushable) this.a).flush();
            }
            if (this.b) {
                try {
                    this.a.close();
                } catch (IOException e) {
                }
            } else {
                this.a.close();
            }
        }
    }

    public static class e extends BufferedOutputStream {
        private final CharsetEncoder a;

        public e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.a = Charset.forName(bnv.f(str)).newEncoder();
        }

        public e a(String str) throws IOException {
            ByteBuffer byteBufferEncode = this.a.encode(CharBuffer.wrap(str));
            super.write(byteBufferEncode.array(), 0, byteBufferEncode.limit());
            return this;
        }
    }

    public static String a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int iIndexOf = aSCIIString.indexOf(63);
                if (iIndexOf > 0 && iIndexOf + 1 < aSCIIString.length()) {
                    return aSCIIString.substring(0, iIndexOf + 1) + aSCIIString.substring(iIndexOf + 1).replace("+", "%2B");
                }
                return aSCIIString;
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new c(iOException);
            }
        } catch (IOException e3) {
            throw new c(e3);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String string = charSequence.toString();
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(string);
            a(string, sb);
            b(string, sb);
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            Map.Entry<?, ?> next = it.next();
            sb.append(next.getKey().toString());
            sb.append('=');
            Object value = next.getValue();
            if (value != null) {
                sb.append(value);
            }
            while (it.hasNext()) {
                sb.append('&');
                Map.Entry<?, ?> next2 = it.next();
                sb.append(next2.getKey().toString());
                sb.append('=');
                Object value2 = next2.getValue();
                if (value2 != null) {
                    sb.append(value2);
                }
            }
            return sb.toString();
        }
        return string;
    }

    public static bnv b(CharSequence charSequence) {
        return new bnv(charSequence, "GET");
    }

    public static bnv a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strA = a(charSequence, map);
        if (z) {
            strA = a((CharSequence) strA);
        }
        return b((CharSequence) strA);
    }

    public static bnv c(CharSequence charSequence) {
        return new bnv(charSequence, "POST");
    }

    public static bnv b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strA = a(charSequence, map);
        if (z) {
            strA = a((CharSequence) strA);
        }
        return c((CharSequence) strA);
    }

    public static bnv d(CharSequence charSequence) {
        return new bnv(charSequence, "PUT");
    }

    public static bnv e(CharSequence charSequence) {
        return new bnv(charSequence, "DELETE");
    }

    public bnv(CharSequence charSequence, String str) {
        try {
            this.a = new URL(charSequence.toString());
            this.e = str;
        } catch (MalformedURLException e2) {
            throw new c(e2);
        }
    }

    private Proxy q() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
    }

    private HttpURLConnection r() {
        HttpURLConnection httpURLConnectionA;
        try {
            if (this.k != null) {
                httpURLConnectionA = c.a(this.a, q());
            } else {
                httpURLConnectionA = c.a(this.a);
            }
            httpURLConnectionA.setRequestMethod(this.e);
            return httpURLConnectionA;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String toString() {
        return p() + ' ' + o();
    }

    public HttpURLConnection a() {
        if (this.d == null) {
            this.d = r();
        }
        return this.d;
    }

    public int b() {
        try {
            k();
            return a().getResponseCode();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public boolean c() {
        return 200 == b();
    }

    protected ByteArrayOutputStream d() {
        int iJ = j();
        return iJ > 0 ? new ByteArrayOutputStream(iJ) : new ByteArrayOutputStream();
    }

    public String a(String str) {
        ByteArrayOutputStream byteArrayOutputStreamD = d();
        try {
            a(f(), byteArrayOutputStreamD);
            return byteArrayOutputStreamD.toString(f(str));
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String e() {
        return a(h());
    }

    public BufferedInputStream f() {
        return new BufferedInputStream(g(), this.j);
    }

    public InputStream g() {
        InputStream inputStream;
        if (b() < 400) {
            try {
                inputStream = a().getInputStream();
            } catch (IOException e2) {
                throw new c(e2);
            }
        } else {
            inputStream = a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = a().getInputStream();
                } catch (IOException e3) {
                    throw new c(e3);
                }
            }
        }
        if (!this.i || !"gzip".equals(i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    public bnv a(int i) {
        a().setConnectTimeout(i);
        return this;
    }

    public bnv a(String str, String str2) {
        a().setRequestProperty(str, str2);
        return this;
    }

    public bnv a(Map.Entry<String, String> entry) {
        return a(entry.getKey(), entry.getValue());
    }

    public String b(String str) {
        l();
        return a().getHeaderField(str);
    }

    public int c(String str) {
        return a(str, -1);
    }

    public int a(String str, int i) {
        l();
        return a().getHeaderFieldInt(str, i);
    }

    public String b(String str, String str2) {
        return c(b(str), str2);
    }

    protected String c(String str, String str2) {
        int i;
        int i2;
        String strTrim;
        int length;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length2 = str.length();
        int iIndexOf = str.indexOf(59) + 1;
        if (iIndexOf == 0 || iIndexOf == length2) {
            return null;
        }
        int iIndexOf2 = str.indexOf(59, iIndexOf);
        if (iIndexOf2 == -1) {
            i = iIndexOf;
            i2 = length2;
        } else {
            i = iIndexOf;
            i2 = iIndexOf2;
        }
        while (i < i2) {
            int iIndexOf3 = str.indexOf(61, i);
            if (iIndexOf3 != -1 && iIndexOf3 < i2 && str2.equals(str.substring(i, iIndexOf3).trim()) && (length = (strTrim = str.substring(iIndexOf3 + 1, i2).trim()).length()) != 0) {
                if (length > 2 && '\"' == strTrim.charAt(0) && '\"' == strTrim.charAt(length - 1)) {
                    return strTrim.substring(1, length - 1);
                }
                return strTrim;
            }
            int i3 = i2 + 1;
            int iIndexOf4 = str.indexOf(59, i3);
            if (iIndexOf4 == -1) {
                iIndexOf4 = length2;
            }
            int i4 = iIndexOf4;
            i = i3;
            i2 = i4;
        }
        return null;
    }

    public String h() {
        return b("Content-Type", "charset");
    }

    public bnv a(boolean z) {
        a().setUseCaches(z);
        return this;
    }

    public String i() {
        return b(HTTP.CONTENT_ENCODING);
    }

    public bnv d(String str) {
        return d(str, null);
    }

    public bnv d(String str, String str2) {
        return (str2 == null || str2.length() <= 0) ? a("Content-Type", str) : a("Content-Type", str + HTTP.CHARSET_PARAM + str2);
    }

    public int j() {
        return c(HTTP.CONTENT_LEN);
    }

    protected bnv a(final InputStream inputStream, final OutputStream outputStream) {
        return new a<bnv>(inputStream, this.h) { // from class: bnv.1
            @Override // bnv.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public bnv b() throws IOException {
                byte[] bArr = new byte[bnv.this.j];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        return bnv.this;
                    }
                }
            }
        }.call();
    }

    protected bnv k() throws IOException {
        if (this.f != null) {
            if (this.g) {
                this.f.a("\r\n--00content0boundary00--\r\n");
            }
            if (this.h) {
                try {
                    this.f.close();
                } catch (IOException e2) {
                }
            } else {
                this.f.close();
            }
            this.f = null;
        }
        return this;
    }

    protected bnv l() {
        try {
            return k();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    protected bnv m() {
        if (this.f == null) {
            a().setDoOutput(true);
            this.f = new e(a().getOutputStream(), c(a().getRequestProperty("Content-Type"), "charset"), this.j);
        }
        return this;
    }

    protected bnv n() throws IOException {
        if (!this.g) {
            this.g = true;
            d("multipart/form-data; boundary=00content0boundary00").m();
            this.f.a("--00content0boundary00\r\n");
        } else {
            this.f.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    protected bnv a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"").append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"").append(str2);
        }
        sb.append('\"');
        f(MIME.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            f("Content-Type", str3);
        }
        return f("\r\n");
    }

    public bnv e(String str, String str2) {
        return b(str, (String) null, str2);
    }

    public bnv b(String str, String str2, String str3) {
        return a(str, str2, (String) null, str3);
    }

    public bnv a(String str, String str2, String str3, String str4) {
        try {
            n();
            a(str, str2, str3);
            this.f.a(str4);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public bnv a(String str, Number number) {
        return a(str, (String) null, number);
    }

    public bnv a(String str, String str2, Number number) {
        return b(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.bnv a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws java.lang.Throwable {
        /*
            r3 = this;
            r2 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r0.<init>(r7)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r1.<init>(r0)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            bnv r0 = r3.a(r4, r5, r6, r1)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L2b
            if (r1 == 0) goto L14
            r1.close()     // Catch: java.io.IOException -> L24
        L14:
            return r0
        L15:
            r0 = move-exception
            r1 = r2
        L17:
            bnv$c r2 = new bnv$c     // Catch: java.lang.Throwable -> L1d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1d
            throw r2     // Catch: java.lang.Throwable -> L1d
        L1d:
            r0 = move-exception
        L1e:
            if (r1 == 0) goto L23
            r1.close()     // Catch: java.io.IOException -> L26
        L23:
            throw r0
        L24:
            r1 = move-exception
            goto L14
        L26:
            r1 = move-exception
            goto L23
        L28:
            r0 = move-exception
            r1 = r2
            goto L1e
        L2b:
            r0 = move-exception
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bnv.a(java.lang.String, java.lang.String, java.lang.String, java.io.File):bnv");
    }

    public bnv a(String str, String str2, String str3, InputStream inputStream) {
        try {
            n();
            a(str, str2, str3);
            a(inputStream, this.f);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public bnv f(String str, String str2) {
        return f((CharSequence) str).f(": ").f((CharSequence) str2).f("\r\n");
    }

    public bnv f(CharSequence charSequence) {
        try {
            m();
            this.f.a(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public URL o() {
        return a().getURL();
    }

    public String p() {
        return a().getRequestMethod();
    }
}
