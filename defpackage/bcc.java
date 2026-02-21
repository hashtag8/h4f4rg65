package defpackage;

import defpackage.bcj;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes.dex */
class bcc implements HttpEntity {
    private HttpEntity a;
    private bcj.c b;

    public bcc(HttpEntity httpEntity, bcj.c cVar) {
        this.a = httpEntity;
        this.b = cVar;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
        this.a.consumeContent();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return this.a.getContent();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.a.getContentEncoding();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.a.getContentLength();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.a.getContentType();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.a.isChunked();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.a.isRepeatable();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.a.isStreaming();
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        this.a.writeTo(new a(outputStream, this.b));
    }

    static class a extends FilterOutputStream {
        private final bcj.c a;
        private long b;

        public a(OutputStream outputStream, bcj.c cVar) {
            super(outputStream);
            this.b = 0L;
            this.a = cVar;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
            this.b += (long) i2;
            if (this.a != null) {
                this.a.a(this.b);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
            this.b++;
            if (this.a != null) {
                this.a.a(this.b);
            }
        }
    }
}
