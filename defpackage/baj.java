package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class baj implements Iterable<NameValuePair> {
    private List<NameValuePair> a;
    private Map<String, a> b;
    private HttpEntity c;
    private bak d;
    private String e;
    private c f;
    private String g;
    private long[] h;

    public interface c {
        void a(long j);
    }

    public baj() {
        this.a = new ArrayList();
    }

    public baj(String str) {
        this.a = new ArrayList();
        if (str == null) {
            throw new IllegalArgumentException("resource is null");
        }
        if (!str.startsWith("http:") && !str.startsWith("https:") && !str.startsWith("/")) {
            str = "/" + str;
        }
        if (str.contains("?")) {
            for (String str2 : str.substring(Math.min(str.length(), str.indexOf("?") + 1), str.length()).split("&")) {
                String[] strArrSplit = str2.split("=", 2);
                if (strArrSplit != null) {
                    try {
                        if (strArrSplit.length == 2) {
                            this.a.add(new BasicNameValuePair(URLDecoder.decode(strArrSplit[0], HTTP.UTF_8), URLDecoder.decode(strArrSplit[1], HTTP.UTF_8)));
                        } else if (strArrSplit.length == 1) {
                            this.a.add(new BasicNameValuePair(URLDecoder.decode(strArrSplit[0], HTTP.UTF_8), null));
                        }
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            }
            this.e = str.substring(0, str.indexOf("?"));
            return;
        }
        this.e = str;
    }

    public baj(baj bajVar) {
        this.a = new ArrayList();
        this.e = bajVar.e;
        this.d = bajVar.d;
        this.f = bajVar.f;
        this.a = new ArrayList(bajVar.a);
        this.g = bajVar.g;
        this.c = bajVar.c;
        if (bajVar.b != null) {
            this.b = new HashMap(bajVar.b);
        }
    }

    public static baj a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.ENGLISH, str, objArr);
        }
        return new baj(str);
    }

    public baj a(String str, Object obj) {
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                b(str, it.next());
            }
        } else if (obj instanceof Object[]) {
            for (Object obj2 : (Object[]) obj) {
                b(str, obj2);
            }
        } else {
            b(str, obj);
        }
        return this;
    }

    private void b(String str, Object obj) {
        this.a.add(new BasicNameValuePair(str, obj == null ? null : String.valueOf(obj)));
    }

    public baj a(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public baj a(Object... objArr) {
        if (objArr != null) {
            if (objArr.length % 2 != 0) {
                throw new IllegalArgumentException("need even number of arguments");
            }
            for (int i = 0; i < objArr.length; i += 2) {
                a(objArr[i].toString(), objArr[i + 1]);
            }
        }
        return this;
    }

    public String a() {
        return a(this.a, HTTP.UTF_8);
    }

    public String a(String str) {
        return this.a.isEmpty() ? str : str + "?" + a();
    }

    public String b() {
        return a(this.e);
    }

    public boolean c() {
        return (this.b == null || this.b.isEmpty()) ? false : true;
    }

    public Map<String, String> d() {
        HashMap map = new HashMap();
        for (NameValuePair nameValuePair : this.a) {
            map.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        return map;
    }

    public <T extends HttpRequestBase> T a(Class<T> cls) {
        try {
            T tNewInstance = cls.newInstance();
            if (tNewInstance instanceof HttpEntityEnclosingRequestBase) {
                HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = (HttpEntityEnclosingRequestBase) tNewInstance;
                Charset charsetForName = Charset.forName(HTTP.UTF_8);
                if (c()) {
                    MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, charsetForName);
                    if (this.b != null) {
                        for (Map.Entry<String, a> entry : this.b.entrySet()) {
                            multipartEntity.addPart(entry.getKey(), entry.getValue().a());
                        }
                    }
                    for (NameValuePair nameValuePair : this.a) {
                        multipartEntity.addPart(nameValuePair.getName(), new StringBody(nameValuePair.getValue(), HTTP.PLAIN_TEXT_TYPE, charsetForName));
                    }
                    httpEntityEnclosingRequestBase.setEntity(this.f == null ? multipartEntity : new bac(multipartEntity, this.f));
                    tNewInstance.setURI(URI.create(this.e));
                } else if (this.c != null) {
                    tNewInstance.setHeader(this.c.getContentType());
                    httpEntityEnclosingRequestBase.setEntity(this.c);
                    tNewInstance.setURI(URI.create(b()));
                } else {
                    if (!this.a.isEmpty()) {
                        tNewInstance.setHeader("Content-Type", "application/x-www-form-urlencoded");
                        httpEntityEnclosingRequestBase.setEntity(new StringEntity(a()));
                    }
                    tNewInstance.setURI(URI.create(this.e));
                }
            } else {
                if (this.h != null) {
                    tNewInstance.addHeader("Range", a(this.h));
                }
                if (this.g != null) {
                    tNewInstance.addHeader("If-None-Match", this.g);
                }
                tNewInstance.setURI(URI.create(b()));
            }
            if (this.d != null) {
                tNewInstance.addHeader(baa.a(this.d));
            }
            return tNewInstance;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static String a(long... jArr) {
        switch (jArr.length) {
            case 0:
                return "bytes=0-";
            case 1:
                if (jArr[0] < 0) {
                    throw new IllegalArgumentException("negative range");
                }
                return "bytes=" + jArr[0] + "-";
            case 2:
                if (jArr[0] < 0) {
                    throw new IllegalArgumentException("negative range");
                }
                if (jArr[0] > jArr[1]) {
                    throw new IllegalArgumentException(jArr[0] + ">" + jArr[1]);
                }
                return "bytes=" + jArr[0] + "-" + jArr[1];
            default:
                throw new IllegalArgumentException("invalid range specified");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<NameValuePair> iterator() {
        return this.a.iterator();
    }

    public String toString() {
        return "Request{mResource='" + this.e + "', params=" + this.a + ", files=" + this.b + ", entity=" + this.c + ", mToken=" + this.d + ", listener=" + this.f + '}';
    }

    static class b extends AbstractContentBody {
        private ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            super("application/octet-stream");
            this.a = byteBuffer;
        }

        public String getFilename() {
            return null;
        }

        @Override // defpackage.bsx
        public String getTransferEncoding() {
            return MIME.ENC_BINARY;
        }

        @Override // defpackage.bsx
        public String getCharset() {
            return null;
        }

        @Override // defpackage.bsx
        public long getContentLength() {
            return this.a.capacity();
        }

        @Override // defpackage.bul
        public void writeTo(OutputStream outputStream) throws IOException {
            if (this.a.hasArray()) {
                outputStream.write(this.a.array());
                return;
            }
            byte[] bArr = new byte[this.a.capacity()];
            this.a.get(bArr);
            outputStream.write(bArr);
        }
    }

    static class a {
        public final File a;
        public final ByteBuffer b;
        public final String c;

        public ContentBody a() {
            if (this.a != null) {
                return new FileBody(this.a) { // from class: baj.a.1
                    @Override // org.apache.http.entity.mime.content.FileBody, org.apache.http.entity.mime.content.ContentBody
                    public String getFilename() {
                        return a.this.c;
                    }
                };
            }
            if (this.b != null) {
                return new b(this.b) { // from class: baj.a.2
                    @Override // baj.b, org.apache.http.entity.mime.content.ContentBody
                    public String getFilename() {
                        return a.this.c;
                    }
                };
            }
            throw new IllegalStateException("no upload data");
        }
    }

    public static String a(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String strA = a(nameValuePair.getName(), str);
            String value = nameValuePair.getValue();
            String strA2 = value != null ? a(value, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strA);
            if (value != null) {
                sb.append("=");
                sb.append(strA2);
            }
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
