package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class we extends ByteArrayOutputStream {
    private final abm a;

    public we(abm abmVar, int i) {
        this.a = abmVar;
        this.buf = this.a.a(Math.max(i, 256));
    }

    private void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] bArrA = this.a.a((this.count + i) * 2);
        System.arraycopy(this.buf, 0, bArrA, 0, this.count);
        this.a.a(this.buf);
        this.buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.a.a(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
