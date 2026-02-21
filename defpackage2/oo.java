package defpackage;

import android.support.v8.renderscript.Allocation;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
final class oo implements Flushable {
    private final byte[] a;
    private final int b;
    private int c = 0;
    private final OutputStream d;

    private oo(OutputStream outputStream, byte[] bArr) {
        this.d = outputStream;
        this.a = bArr;
        this.b = bArr.length;
    }

    public static oo a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static oo a(OutputStream outputStream, int i) {
        return new oo(outputStream, new byte[i]);
    }

    public void a(int i, float f) throws IOException {
        g(i, 5);
        a(f);
    }

    public void a(int i, long j) throws IOException {
        g(i, 0);
        a(j);
    }

    public void a(int i, boolean z) throws IOException {
        g(i, 0);
        a(z);
    }

    public void a(int i, ol olVar) throws IOException {
        g(i, 2);
        a(olVar);
    }

    public void a(int i, int i2) throws IOException {
        g(i, 0);
        b(i2);
    }

    public void b(int i, int i2) throws IOException {
        g(i, 0);
        c(i2);
    }

    public void c(int i, int i2) throws IOException {
        g(i, 0);
        d(i2);
    }

    public void a(float f) throws IOException {
        m(Float.floatToRawIntBits(f));
    }

    public void a(long j) throws IOException {
        c(j);
    }

    public void a(int i) throws IOException {
        if (i >= 0) {
            k(i);
        } else {
            c(i);
        }
    }

    public void a(boolean z) throws IOException {
        i(z ? 1 : 0);
    }

    public void a(ol olVar) throws IOException {
        k(olVar.a());
        c(olVar);
    }

    public void b(int i) throws IOException {
        k(i);
    }

    public void c(int i) throws IOException {
        a(i);
    }

    public void d(int i) throws IOException {
        k(n(i));
    }

    public static int b(int i, float f) {
        return j(i) + b(f);
    }

    public static int b(int i, long j) {
        return j(i) + b(j);
    }

    public static int b(int i, boolean z) {
        return j(i) + b(z);
    }

    public static int b(int i, ol olVar) {
        return j(i) + b(olVar);
    }

    public static int d(int i, int i2) {
        return j(i) + f(i2);
    }

    public static int e(int i, int i2) {
        return j(i) + g(i2);
    }

    public static int f(int i, int i2) {
        return j(i) + h(i2);
    }

    public static int b(float f) {
        return 4;
    }

    public static int b(long j) {
        return d(j);
    }

    public static int e(int i) {
        if (i >= 0) {
            return l(i);
        }
        return 10;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int b(ol olVar) {
        return l(olVar.a()) + olVar.a();
    }

    public static int f(int i) {
        return l(i);
    }

    public static int g(int i) {
        return e(i);
    }

    public static int h(int i) {
        return l(n(i));
    }

    private void a() throws IOException {
        if (this.d == null) {
            throw new a();
        }
        this.d.write(this.a, 0, this.c);
        this.c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.d != null) {
            a();
        }
    }

    static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public void a(byte b) throws IOException {
        if (this.c == this.b) {
            a();
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
    }

    public void i(int i) throws IOException {
        a((byte) i);
    }

    public void c(ol olVar) throws IOException {
        a(olVar, 0, olVar.a());
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        if (this.b - this.c >= i2) {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
            return;
        }
        int i3 = this.b - this.c;
        System.arraycopy(bArr, i, this.a, this.c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.c = this.b;
        a();
        if (i5 <= this.b) {
            System.arraycopy(bArr, i4, this.a, 0, i5);
            this.c = i5;
        } else {
            this.d.write(bArr, i4, i5);
        }
    }

    public void a(ol olVar, int i, int i2) throws IOException {
        if (this.b - this.c >= i2) {
            olVar.a(this.a, i, this.c, i2);
            this.c += i2;
            return;
        }
        int i3 = this.b - this.c;
        olVar.a(this.a, i, this.c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.c = this.b;
        a();
        if (i5 <= this.b) {
            olVar.a(this.a, i4, 0, i5);
            this.c = i5;
            return;
        }
        InputStream inputStreamB = olVar.b();
        if (i4 != inputStreamB.skip(i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i5 > 0) {
            int iMin = Math.min(i5, this.b);
            int i6 = inputStreamB.read(this.a, 0, iMin);
            if (i6 != iMin) {
                throw new IllegalStateException("Read failed.");
            }
            this.d.write(this.a, 0, i6);
            i5 -= i6;
        }
    }

    public void g(int i, int i2) throws IOException {
        k(qg.a(i, i2));
    }

    public static int j(int i) {
        return l(qg.a(i, 0));
    }

    public void k(int i) throws IOException {
        while ((i & (-128)) != 0) {
            i((i & 127) | Allocation.USAGE_SHARED);
            i >>>= 7;
        }
        i(i);
    }

    public static int l(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public void c(long j) throws IOException {
        while (((-128) & j) != 0) {
            i((((int) j) & 127) | Allocation.USAGE_SHARED);
            j >>>= 7;
        }
        i((int) j);
    }

    public static int d(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public void m(int i) throws IOException {
        i(i & 255);
        i((i >> 8) & 255);
        i((i >> 16) & 255);
        i((i >> 24) & 255);
    }

    public static int n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
