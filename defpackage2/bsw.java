package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class bsw extends FilterOutputStream {
    private bsv a;
    private boolean b;

    public bsw(OutputStream outputStream, boolean z) {
        super(outputStream);
        this.b = false;
        this.a = new bsv(1024, z);
        this.a.a(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.b) {
            try {
                this.a.a();
            } finally {
                this.b = true;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.a.b();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.b) {
            throw new IOException("QuotedPrintableOutputStream has been closed");
        }
        this.a.a(bArr, i, i2);
    }
}
