package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* JADX INFO: loaded from: classes.dex */
abstract class bad extends HttpEntityWrapper {
    private InputStream a;

    abstract InputStream a(InputStream inputStream);

    public bad(HttpEntity httpEntity) {
        super(httpEntity);
    }

    private InputStream a() throws IOException {
        InputStream content = this.wrappedEntity.getContent();
        try {
            return a(content);
        } catch (IOException e) {
            content.close();
            throw e;
        }
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() {
        if (!this.wrappedEntity.isStreaming()) {
            return a();
        }
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i = content.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    return;
                }
            }
        } finally {
            content.close();
        }
    }
}
