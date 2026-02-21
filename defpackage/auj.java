package defpackage;

import defpackage.auh;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class auj extends FilterOutputStream {
    private static byte[] e = new byte[0];
    private final auh.a a;
    private final int b;
    private byte[] c;
    private int d;

    public auj(OutputStream outputStream, int i) {
        this(outputStream, i, true);
    }

    public auj(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.c = null;
        this.d = 0;
        this.b = i;
        if (z) {
            this.a = new auh.c(i, null);
        } else {
            this.a = new auh.b(i, null);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.c == null) {
            this.c = new byte[1024];
        }
        if (this.d >= this.c.length) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
        byte[] bArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
    }

    private void a() throws IOException {
        if (this.d > 0) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            a();
            a(bArr, i, i2, false);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IOException iOException = null;
        try {
            a();
            a(e, 0, 0, true);
        } catch (IOException e2) {
            iOException = e2;
        }
        try {
            if ((this.b & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException == null) {
                e = iOException;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private void a(byte[] bArr, int i, int i2, boolean z) throws IOException {
        this.a.a = a(this.a.a, this.a.a(i2));
        if (!this.a.a(bArr, i, i2, z)) {
            throw new aui("bad base-64");
        }
        this.out.write(this.a.a, 0, this.a.b);
    }

    private byte[] a(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i) {
            return new byte[i];
        }
        return bArr;
    }
}
