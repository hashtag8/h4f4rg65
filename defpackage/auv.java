package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class auv implements HttpEntity {
    private static final byte[] a = "\r\n".getBytes();
    private static final byte[] b = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String d;
    private final byte[] e;
    private final byte[] f;
    private boolean g;
    private final List<a> h = new ArrayList();
    private final ByteArrayOutputStream i = new ByteArrayOutputStream();
    private final aut j;
    private int k;
    private int l;

    public auv(aut autVar) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        this.d = sb.toString();
        this.e = ("--" + this.d + "\r\n").getBytes();
        this.f = ("--" + this.d + "--\r\n").getBytes();
        this.j = autVar;
    }

    public void a(String str, String str2, String str3) {
        try {
            this.i.write(this.e);
            this.i.write(c(str));
            this.i.write(b(str3));
            this.i.write(a);
            this.i.write(str2.getBytes());
            this.i.write(a);
        } catch (IOException e) {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", e);
        }
    }

    public void b(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = HTTP.UTF_8;
        }
        a(str, str2, "text/plain; charset=" + str3);
    }

    public void a(String str, File file, String str2, String str3) {
        this.h.add(new a(str, file, a(str2), str3));
    }

    public void a(String str, String str2, InputStream inputStream, String str3) throws IOException {
        this.i.write(this.e);
        this.i.write(a(str, str2));
        this.i.write(b(str3));
        this.i.write(b);
        this.i.write(a);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                this.i.write(bArr, 0, i);
            } else {
                this.i.write(a);
                this.i.flush();
                aue.a(this.i);
                return;
            }
        }
    }

    private String a(String str) {
        return str == null ? "application/octet-stream" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(String str) {
        return ("Content-Type: " + a(str) + "\r\n").getBytes();
    }

    private byte[] c(String str) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(String str, String str2) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.k += i;
        this.j.b(this.k, this.l);
    }

    class a {
        public File a;
        public byte[] b;

        public a(String str, File file, String str2, String str3) {
            this.b = a(str, TextUtils.isEmpty(str3) ? file.getName() : str3, str2);
            this.a = file;
        }

        private byte[] a(String str, String str2, String str3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(auv.this.e);
                byteArrayOutputStream.write(auv.this.a(str, str2));
                byteArrayOutputStream.write(auv.this.b(str3));
                byteArrayOutputStream.write(auv.b);
                byteArrayOutputStream.write(auv.a);
            } catch (IOException e) {
                Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", e);
            }
            return byteArrayOutputStream.toByteArray();
        }

        public long a() {
            return this.a.length() + ((long) auv.a.length) + ((long) this.b.length);
        }

        public void a(OutputStream outputStream) throws IOException {
            outputStream.write(this.b);
            auv.this.a(this.b.length);
            FileInputStream fileInputStream = new FileInputStream(this.a);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    outputStream.write(auv.a);
                    auv.this.a(auv.a.length);
                    outputStream.flush();
                    aue.a(fileInputStream);
                    return;
                }
                outputStream.write(bArr, 0, i);
                auv.this.a(i);
            }
        }
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        long size = this.i.size();
        Iterator<a> it = this.h.iterator();
        while (true) {
            long j = size;
            if (it.hasNext()) {
                long jA = it.next().a();
                if (jA < 0) {
                    return -1L;
                }
                size = jA + j;
            } else {
                return ((long) this.f.length) + j;
            }
        }
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.d);
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    public void a(boolean z) {
        this.g = z;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.g;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.k = 0;
        this.l = (int) getContentLength();
        this.i.writeTo(outputStream);
        a(this.i.size());
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(outputStream);
        }
        outputStream.write(this.f);
        a(this.f.length);
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }
}
