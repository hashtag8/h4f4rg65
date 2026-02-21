package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes.dex */
public class bcf extends bcd {
    @Override // defpackage.bcd, org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public /* bridge */ /* synthetic */ InputStream getContent() {
        return super.getContent();
    }

    @Override // defpackage.bcd, org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public bcf(HttpEntity httpEntity) {
        super(httpEntity);
    }

    @Override // defpackage.bcd
    InputStream a(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }
}
