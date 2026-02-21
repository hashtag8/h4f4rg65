package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class bhz extends InputStream {
    private final InputStream a;
    private long b;
    private long c;
    private long d;
    private long e;

    public bhz(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public bhz(InputStream inputStream, int i) {
        this.e = -1L;
        this.a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.e = a(i);
    }

    public long a(int i) {
        long j = this.b + ((long) i);
        if (this.d < j) {
            b(j);
        }
        return this.b;
    }

    private void b(long j) {
        try {
            if (this.c < this.b && this.b <= this.d) {
                this.a.reset();
                this.a.mark((int) (j - this.c));
                a(this.c, this.b);
            } else {
                this.c = this.b;
                this.a.mark((int) (j - this.b));
            }
            this.d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.e);
    }

    public void a(long j) throws IOException {
        if (this.b > this.d || j < this.c) {
            throw new IOException("Cannot reset");
        }
        this.a.reset();
        a(this.c, j);
        this.b = j;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() != -1) {
                    jSkip = 1;
                } else {
                    return;
                }
            }
            j += jSkip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.a.read();
        if (i != -1) {
            this.b++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.a.read(bArr);
        if (i != -1) {
            this.b += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += (long) i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.a.skip(j);
        this.b += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }
}
