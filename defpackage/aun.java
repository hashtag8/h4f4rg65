package defpackage;

import android.support.v8.renderscript.Allocation;
import android.util.Log;
import defpackage.aus;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aun implements HttpEntity {
    private static final UnsupportedOperationException a = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final StringBuilder c = new StringBuilder(Allocation.USAGE_SHARED);
    private static final byte[] d = "true".getBytes();
    private static final byte[] e = "false".getBytes();
    private static final byte[] f = "null".getBytes();
    private static final byte[] g = a("name");
    private static final byte[] h = a("type");
    private static final byte[] i = a("contents");
    private static final byte[] j = a("_elapsed");
    private static final Header k = new BasicHeader("Content-Type", "application/json");
    private static final Header l = new BasicHeader(HTTP.CONTENT_ENCODING, "gzip");
    private final byte[] b = new byte[4096];
    private final Map<String, Object> m = new HashMap();
    private final Header n;
    private final aut o;

    public aun(aut autVar, boolean z) {
        this.o = autVar;
        this.n = z ? l : null;
    }

    public void a(String str, Object obj) {
        this.m.put(str, obj);
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.n;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return k;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw a;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.n != null) {
            outputStream = new GZIPOutputStream(outputStream, 4096);
        }
        outputStream.write(123);
        for (String str : this.m.keySet()) {
            Object obj = this.m.get(str);
            if (obj != null) {
                outputStream.write(a(str));
                outputStream.write(58);
                boolean z = obj instanceof aus.a;
                if (z || (obj instanceof aus.b)) {
                    outputStream.write(123);
                    if (z) {
                        a(outputStream, (aus.a) obj);
                    } else {
                        a(outputStream, (aus.b) obj);
                    }
                    outputStream.write(125);
                } else if (obj instanceof auo) {
                    outputStream.write(((auo) obj).a());
                } else if (obj instanceof JSONObject) {
                    outputStream.write(((JSONObject) obj).toString().getBytes());
                } else if (obj instanceof JSONArray) {
                    outputStream.write(((JSONArray) obj).toString().getBytes());
                } else if (obj instanceof Boolean) {
                    outputStream.write(((Boolean) obj).booleanValue() ? d : e);
                } else if (obj instanceof Long) {
                    outputStream.write((((Number) obj).longValue() + "").getBytes());
                } else if (obj instanceof Double) {
                    outputStream.write((((Number) obj).doubleValue() + "").getBytes());
                } else if (obj instanceof Float) {
                    outputStream.write((((Number) obj).floatValue() + "").getBytes());
                } else if (obj instanceof Integer) {
                    outputStream.write((((Number) obj).intValue() + "").getBytes());
                } else {
                    outputStream.write(a(obj.toString()));
                }
                outputStream.write(44);
            }
        }
        outputStream.write(j);
        outputStream.write(58);
        outputStream.write(((System.currentTimeMillis() - jCurrentTimeMillis) + "}").getBytes());
        Log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(r0 / 1000) + " seconds");
        outputStream.flush();
        aue.a(outputStream);
    }

    private void a(OutputStream outputStream, aus.b bVar) throws IOException {
        a(outputStream, bVar.b, bVar.c);
        auj aujVar = new auj(outputStream, 18);
        while (true) {
            int i2 = bVar.a.read(this.b);
            if (i2 == -1) {
                break;
            } else {
                aujVar.write(this.b, 0, i2);
            }
        }
        aue.a(aujVar);
        a(outputStream);
        if (bVar.d) {
            aue.a(bVar.a);
        }
    }

    private void a(OutputStream outputStream, aus.a aVar) throws IOException {
        a(outputStream, aVar.a.getName(), aVar.b);
        int length = (int) aVar.a.length();
        FileInputStream fileInputStream = new FileInputStream(aVar.a);
        auj aujVar = new auj(outputStream, 18);
        int i2 = 0;
        while (true) {
            int i3 = fileInputStream.read(this.b);
            if (i3 != -1) {
                aujVar.write(this.b, 0, i3);
                i2 += i3;
                this.o.b(i2, length);
            } else {
                aue.a(aujVar);
                a(outputStream);
                aue.a(fileInputStream);
                return;
            }
        }
    }

    private void a(OutputStream outputStream, String str, String str2) throws IOException {
        outputStream.write(g);
        outputStream.write(58);
        outputStream.write(a(str));
        outputStream.write(44);
        outputStream.write(h);
        outputStream.write(58);
        outputStream.write(a(str2));
        outputStream.write(44);
        outputStream.write(i);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void a(OutputStream outputStream) throws IOException {
        outputStream.write(34);
    }

    static byte[] a(String str) {
        if (str == null) {
            return f;
        }
        c.append('\"');
        int length = str.length();
        int i2 = -1;
        while (true) {
            int i3 = i2 + 1;
            if (i3 < length) {
                char cCharAt = str.charAt(i3);
                switch (cCharAt) {
                    case '\b':
                        c.append("\\b");
                        break;
                    case '\t':
                        c.append("\\t");
                        break;
                    case '\n':
                        c.append("\\n");
                        break;
                    case '\f':
                        c.append("\\f");
                        break;
                    case '\r':
                        c.append("\\r");
                        break;
                    case '\"':
                        c.append("\\\"");
                        break;
                    case '\\':
                        c.append("\\\\");
                        break;
                    default:
                        if ((cCharAt >= 0 && cCharAt <= 31) || ((cCharAt >= 127 && cCharAt <= 159) || (cCharAt >= 8192 && cCharAt <= 8447))) {
                            String hexString = Integer.toHexString(cCharAt);
                            c.append("\\u");
                            int length2 = 4 - hexString.length();
                            for (int i4 = 0; i4 < length2; i4++) {
                                c.append('0');
                            }
                            c.append(hexString.toUpperCase(Locale.US));
                        } else {
                            c.append(cCharAt);
                        }
                        break;
                }
                i2 = i3;
            } else {
                c.append('\"');
                try {
                    return c.toString().getBytes();
                } finally {
                    c.setLength(0);
                }
            }
        }
    }
}
