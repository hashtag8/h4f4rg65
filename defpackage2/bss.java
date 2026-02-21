package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class bss extends FilterOutputStream {
    static final byte[] a;
    static final /* synthetic */ boolean b;
    private static final byte[] c;
    private static final Set<Byte> d;
    private final byte[] e;
    private final int f;
    private final byte[] g;
    private boolean h;
    private final byte[] i;
    private int j;
    private int k;
    private int l;
    private int m;

    static {
        b = !bss.class.desiredAssertionStatus();
        c = new byte[]{13, 10};
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        d = new HashSet();
        for (byte b2 : a) {
            d.add(Byte.valueOf(b2));
        }
        d.add((byte) 61);
    }

    public bss(OutputStream outputStream) {
        this(outputStream, 76, c);
    }

    public bss(OutputStream outputStream, int i, byte[] bArr) {
        super(outputStream);
        this.e = new byte[1];
        this.h = false;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        a(bArr);
        this.f = i;
        this.g = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.g, 0, bArr.length);
        this.i = new byte[2048];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        if (this.h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        this.e[0] = (byte) i;
        a(this.e, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        if (this.h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (bArr.length != 0) {
            a(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            a(bArr, i, i + i2);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        a();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.h) {
            this.h = true;
            b();
        }
    }

    private void a(byte[] bArr, int i, int i2) throws IOException {
        while (i < i2) {
            this.k = (this.k << 8) | (bArr[i] & 255);
            int i3 = this.l + 1;
            this.l = i3;
            if (i3 == 3) {
                this.l = 0;
                if (this.f > 0 && this.m >= this.f) {
                    this.m = 0;
                    if (this.i.length - this.j < this.g.length) {
                        a();
                    }
                    for (byte b2 : this.g) {
                        byte[] bArr2 = this.i;
                        int i4 = this.j;
                        this.j = i4 + 1;
                        bArr2[i4] = b2;
                    }
                }
                if (this.i.length - this.j < 4) {
                    a();
                }
                byte[] bArr3 = this.i;
                int i5 = this.j;
                this.j = i5 + 1;
                bArr3[i5] = a[(this.k >> 18) & 63];
                byte[] bArr4 = this.i;
                int i6 = this.j;
                this.j = i6 + 1;
                bArr4[i6] = a[(this.k >> 12) & 63];
                byte[] bArr5 = this.i;
                int i7 = this.j;
                this.j = i7 + 1;
                bArr5[i7] = a[(this.k >> 6) & 63];
                byte[] bArr6 = this.i;
                int i8 = this.j;
                this.j = i8 + 1;
                bArr6[i8] = a[this.k & 63];
                this.m += 4;
            }
            i++;
        }
    }

    private void a() throws IOException {
        if (this.j > 0) {
            this.out.write(this.i, 0, this.j);
            this.j = 0;
        }
    }

    private void b() throws IOException {
        if (this.l != 0) {
            c();
        }
        if (this.f > 0 && this.m > 0) {
            d();
        }
        a();
    }

    private void c() throws IOException {
        if (this.f > 0 && this.m >= this.f) {
            d();
        }
        if (this.i.length - this.j < 4) {
            a();
        }
        if (this.l == 1) {
            byte[] bArr = this.i;
            int i = this.j;
            this.j = i + 1;
            bArr[i] = a[(this.k >> 2) & 63];
            byte[] bArr2 = this.i;
            int i2 = this.j;
            this.j = i2 + 1;
            bArr2[i2] = a[(this.k << 4) & 63];
            byte[] bArr3 = this.i;
            int i3 = this.j;
            this.j = i3 + 1;
            bArr3[i3] = 61;
            byte[] bArr4 = this.i;
            int i4 = this.j;
            this.j = i4 + 1;
            bArr4[i4] = 61;
        } else {
            if (!b && this.l != 2) {
                throw new AssertionError();
            }
            byte[] bArr5 = this.i;
            int i5 = this.j;
            this.j = i5 + 1;
            bArr5[i5] = a[(this.k >> 10) & 63];
            byte[] bArr6 = this.i;
            int i6 = this.j;
            this.j = i6 + 1;
            bArr6[i6] = a[(this.k >> 4) & 63];
            byte[] bArr7 = this.i;
            int i7 = this.j;
            this.j = i7 + 1;
            bArr7[i7] = a[(this.k << 2) & 63];
            byte[] bArr8 = this.i;
            int i8 = this.j;
            this.j = i8 + 1;
            bArr8[i8] = 61;
        }
        this.m += 4;
    }

    private void d() throws IOException {
        this.m = 0;
        if (this.i.length - this.j < this.g.length) {
            a();
        }
        for (byte b2 : this.g) {
            byte[] bArr = this.i;
            int i = this.j;
            this.j = i + 1;
            bArr[i] = b2;
        }
    }

    private void a(byte[] bArr) {
        if (bArr.length > 2048) {
            throw new IllegalArgumentException("line separator length exceeds 2048");
        }
        for (byte b2 : bArr) {
            if (d.contains(Byte.valueOf(b2))) {
                throw new IllegalArgumentException("line separator must not contain base64 character '" + ((char) (b2 & 255)) + "'");
            }
        }
    }
}
