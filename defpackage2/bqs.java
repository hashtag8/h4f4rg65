package defpackage;

import android.support.v8.renderscript.Allocation;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class bqs implements bqt, bqu, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    brf a;
    long b;

    public long b() {
        return this.b;
    }

    @Override // defpackage.bqt, defpackage.bqu
    public bqs c() {
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public bqs v() {
        return this;
    }

    @Override // defpackage.bqt
    public bqt e() {
        return this;
    }

    @Override // defpackage.bqu
    public boolean f() {
        return this.b == 0;
    }

    @Override // defpackage.bqu
    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // defpackage.bqu
    public InputStream g() {
        return new InputStream() { // from class: bqs.1
            @Override // java.io.InputStream
            public int read() {
                if (bqs.this.b > 0) {
                    return bqs.this.i() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return bqs.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(bqs.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return bqs.this + ".inputStream()";
            }
        };
    }

    public bqs a(bqs bqsVar, long j, long j2) {
        if (bqsVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        brk.a(this.b, j, j2);
        if (j2 != 0) {
            bqsVar.b += j2;
            brf brfVar = this.a;
            while (j >= brfVar.c - brfVar.b) {
                j -= (long) (brfVar.c - brfVar.b);
                brfVar = brfVar.f;
            }
            while (j2 > 0) {
                brf brfVar2 = new brf(brfVar);
                brfVar2.b = (int) (((long) brfVar2.b) + j);
                brfVar2.c = Math.min(brfVar2.b + ((int) j2), brfVar2.c);
                if (bqsVar.a == null) {
                    brfVar2.g = brfVar2;
                    brfVar2.f = brfVar2;
                    bqsVar.a = brfVar2;
                } else {
                    bqsVar.a.g.a(brfVar2);
                }
                j2 -= (long) (brfVar2.c - brfVar2.b);
                brfVar = brfVar.f;
                j = 0;
            }
        }
        return this;
    }

    public long h() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        brf brfVar = this.a.g;
        if (brfVar.c < 2048 && brfVar.e) {
            return j - ((long) (brfVar.c - brfVar.b));
        }
        return j;
    }

    @Override // defpackage.bqu
    public byte i() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        brf brfVar = this.a;
        int i = brfVar.b;
        int i2 = brfVar.c;
        int i3 = i + 1;
        byte b = brfVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = brfVar.a();
            brg.a(brfVar);
        } else {
            brfVar.b = i3;
        }
        return b;
    }

    public byte b(long j) {
        brk.a(this.b, j, 1L);
        brf brfVar = this.a;
        while (true) {
            int i = brfVar.c - brfVar.b;
            if (j < i) {
                return brfVar.a[brfVar.b + ((int) j)];
            }
            j -= (long) i;
            brfVar = brfVar.f;
        }
    }

    @Override // defpackage.bqu
    public short j() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        brf brfVar = this.a;
        int i = brfVar.b;
        int i2 = brfVar.c;
        if (i2 - i < 2) {
            return (short) (((i() & 255) << 8) | (i() & 255));
        }
        byte[] bArr = brfVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.a = brfVar.a();
            brg.a(brfVar);
        } else {
            brfVar.b = i4;
        }
        return (short) i5;
    }

    @Override // defpackage.bqu
    public int k() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        brf brfVar = this.a;
        int i = brfVar.b;
        int i2 = brfVar.c;
        if (i2 - i < 4) {
            return ((i() & 255) << 24) | ((i() & 255) << 16) | ((i() & 255) << 8) | (i() & 255);
        }
        byte[] bArr = brfVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b -= 4;
        if (i8 == i2) {
            this.a = brfVar.a();
            brg.a(brfVar);
            return i9;
        }
        brfVar.b = i8;
        return i9;
    }

    @Override // defpackage.bqu
    public short l() {
        return brk.a(j());
    }

    @Override // defpackage.bqu
    public int m() {
        return brk.a(k());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[EDGE_INSN: B:47:0x00cd->B:39:0x00cd BREAK  A[LOOP:0: B:7:0x001e->B:49:?], SYNTHETIC] */
    @Override // defpackage.bqu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long n() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bqs.n():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[EDGE_INSN: B:43:0x00b1->B:37:0x00b1 BREAK  A[LOOP:0: B:7:0x0016->B:45:?], SYNTHETIC] */
    @Override // defpackage.bqu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long o() {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bqs.o():long");
    }

    public bqv p() {
        return new bqv(s());
    }

    @Override // defpackage.bqu
    public bqv c(long j) {
        return new bqv(f(j));
    }

    public String q() {
        try {
            return a(this.b, brk.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) {
        return a(j, brk.a);
    }

    public String a(long j, Charset charset) {
        brk.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        brf brfVar = this.a;
        if (((long) brfVar.b) + j > brfVar.c) {
            return new String(f(j), charset);
        }
        String str = new String(brfVar.a, brfVar.b, (int) j, charset);
        brfVar.b = (int) (((long) brfVar.b) + j);
        this.b -= j;
        if (brfVar.b == brfVar.c) {
            this.a = brfVar.a();
            brg.a(brfVar);
            return str;
        }
        return str;
    }

    @Override // defpackage.bqu
    public String r() throws EOFException {
        long jA = a((byte) 10);
        if (jA == -1) {
            bqs bqsVar = new bqs();
            a(bqsVar, 0L, Math.min(32L, this.b));
            throw new EOFException("\\n not found: size=" + b() + " content=" + bqsVar.p().d() + "...");
        }
        return e(jA);
    }

    String e(long j) throws EOFException {
        if (j > 0 && b(j - 1) == 13) {
            String strD = d(j - 1);
            g(2L);
            return strD;
        }
        String strD2 = d(j);
        g(1L);
        return strD2;
    }

    public byte[] s() {
        try {
            return f(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.bqu
    public byte[] f(long j) throws EOFException {
        brk.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        brk.a(bArr.length, i, i2);
        brf brfVar = this.a;
        if (brfVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, brfVar.c - brfVar.b);
        System.arraycopy(brfVar.a, brfVar.b, bArr, i, iMin);
        brfVar.b += iMin;
        this.b -= (long) iMin;
        if (brfVar.b == brfVar.c) {
            this.a = brfVar.a();
            brg.a(brfVar);
            return iMin;
        }
        return iMin;
    }

    public void t() {
        try {
            g(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.bqu
    public void g(long j) throws EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, this.a.c - this.a.b);
            this.b -= (long) iMin;
            j -= (long) iMin;
            brf brfVar = this.a;
            brfVar.b = iMin + brfVar.b;
            if (this.a.b == this.a.c) {
                brf brfVar2 = this.a;
                this.a = brfVar2.a();
                brg.a(brfVar2);
            }
        }
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bqs b(bqv bqvVar) {
        if (bqvVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        bqvVar.a(this);
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bqs b(String str) {
        return a(str, 0, str.length());
    }

    public bqs a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                brf brfVarE = e(1);
                byte[] bArr = brfVarE.a;
                int i4 = brfVarE.c - i;
                int iMin = Math.min(i2, 2048 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) cCharAt;
                while (i3 < iMin) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) cCharAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - brfVarE.c;
                brfVarE.c += i5;
                this.b += (long) i5;
            } else if (cCharAt < 2048) {
                h((cCharAt >> 6) | 192);
                h((cCharAt & '?') | Allocation.USAGE_SHARED);
                i3 = i + 1;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                h((cCharAt >> '\f') | 224);
                h(((cCharAt >> 6) & 63) | Allocation.USAGE_SHARED);
                h((cCharAt & '?') | Allocation.USAGE_SHARED);
                i3 = i + 1;
            } else {
                char cCharAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    h(63);
                    i++;
                } else {
                    int i6 = ((cCharAt3 & 9215) | ((cCharAt & 10239) << 10)) + 65536;
                    h((i6 >> 18) | 240);
                    h(((i6 >> 12) & 63) | Allocation.USAGE_SHARED);
                    h(((i6 >> 6) & 63) | Allocation.USAGE_SHARED);
                    h((i6 & 63) | Allocation.USAGE_SHARED);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public bqs a(int i) {
        if (i < 128) {
            h(i);
        } else if (i < 2048) {
            h((i >> 6) | 192);
            h((i & 63) | Allocation.USAGE_SHARED);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            h((i >> 12) | 224);
            h(((i >> 6) & 63) | Allocation.USAGE_SHARED);
            h((i & 63) | Allocation.USAGE_SHARED);
        } else if (i <= 1114111) {
            h((i >> 18) | 240);
            h(((i >> 12) & 63) | Allocation.USAGE_SHARED);
            h(((i >> 6) & 63) | Allocation.USAGE_SHARED);
            h((i & 63) | Allocation.USAGE_SHARED);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bqs c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return b(bArr, 0, bArr.length);
    }

    public bqs b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        brk.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            brf brfVarE = e(1);
            int iMin = Math.min(i3 - i, 2048 - brfVarE.c);
            System.arraycopy(bArr, i, brfVarE.a, brfVarE.c, iMin);
            i += iMin;
            brfVarE.c = iMin + brfVarE.c;
        }
        this.b += (long) i2;
        return this;
    }

    @Override // defpackage.bqt
    public long a(bri briVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = briVar.a(this, 2048L);
            if (jA != -1) {
                j += jA;
            } else {
                return j;
            }
        }
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bqs h(int i) {
        brf brfVarE = e(1);
        byte[] bArr = brfVarE.a;
        int i2 = brfVarE.c;
        brfVarE.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public bqs g(int i) {
        brf brfVarE = e(2);
        byte[] bArr = brfVarE.a;
        int i2 = brfVarE.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        brfVarE.c = i3 + 1;
        this.b += 2;
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public bqs f(int i) {
        brf brfVarE = e(4);
        byte[] bArr = brfVarE.a;
        int i2 = brfVarE.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        brfVarE.c = i5 + 1;
        this.b += 4;
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public bqs k(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return h(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 < 100) {
            i = j2 < 10 ? 1 : 2;
        } else {
            i = j2 < 1000 ? 3 : 4;
        }
        if (z) {
            i++;
        }
        brf brfVarE = e(i);
        byte[] bArr = brfVarE.a;
        int i2 = brfVarE.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        brfVarE.c += i;
        this.b = ((long) i) + this.b;
        return this;
    }

    @Override // defpackage.bqt
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public bqs j(long j) {
        if (j == 0) {
            return h(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        brf brfVarE = e(iNumberOfTrailingZeros);
        byte[] bArr = brfVarE.a;
        int i = brfVarE.c;
        for (int i2 = (brfVarE.c + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        brfVarE.c += iNumberOfTrailingZeros;
        this.b = ((long) iNumberOfTrailingZeros) + this.b;
        return this;
    }

    brf e(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.a == null) {
            this.a = brg.a();
            brf brfVar = this.a;
            brf brfVar2 = this.a;
            brf brfVar3 = this.a;
            brfVar2.g = brfVar3;
            brfVar.f = brfVar3;
            return brfVar3;
        }
        brf brfVar4 = this.a.g;
        if (brfVar4.c + i > 2048 || !brfVar4.e) {
            return brfVar4.a(brg.a());
        }
        return brfVar4;
    }

    @Override // defpackage.brh
    public void a_(bqs bqsVar, long j) {
        if (bqsVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bqsVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        brk.a(bqsVar.b, 0L, j);
        while (j > 0) {
            if (j < bqsVar.a.c - bqsVar.a.b) {
                brf brfVar = this.a != null ? this.a.g : null;
                if (brfVar != null && brfVar.e) {
                    if ((((long) brfVar.c) + j) - ((long) (brfVar.d ? 0 : brfVar.b)) <= 2048) {
                        bqsVar.a.a(brfVar, (int) j);
                        bqsVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                bqsVar.a = bqsVar.a.a((int) j);
            }
            brf brfVar2 = bqsVar.a;
            long j2 = brfVar2.c - brfVar2.b;
            bqsVar.a = brfVar2.a();
            if (this.a == null) {
                this.a = brfVar2;
                brf brfVar3 = this.a;
                brf brfVar4 = this.a;
                brf brfVar5 = this.a;
                brfVar4.g = brfVar5;
                brfVar3.f = brfVar5;
            } else {
                this.a.g.a(brfVar2).b();
            }
            bqsVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // defpackage.bri
    public long a(bqs bqsVar, long j) {
        if (bqsVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.b == 0) {
            return -1L;
        }
        if (j > this.b) {
            j = this.b;
        }
        bqsVar.a_(this, j);
        return j;
    }

    @Override // defpackage.bqu
    public long a(byte b) {
        return a(b, 0L);
    }

    public long a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        brf brfVar = this.a;
        if (brfVar == null) {
            return -1L;
        }
        long j2 = 0;
        do {
            int i = brfVar.c - brfVar.b;
            if (j >= i) {
                j -= (long) i;
            } else {
                byte[] bArr = brfVar.a;
                long j3 = brfVar.c;
                for (long j4 = ((long) brfVar.b) + j; j4 < j3; j4++) {
                    if (bArr[(int) j4] == b) {
                        return (j2 + j4) - ((long) brfVar.b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            brfVar = brfVar.f;
        } while (brfVar != this.a);
        return -1L;
    }

    @Override // defpackage.brh, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // defpackage.brh
    public brj a() {
        return brj.b;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bqs)) {
            return false;
        }
        bqs bqsVar = (bqs) obj;
        if (this.b != bqsVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        brf brfVar = this.a;
        brf brfVar2 = bqsVar.a;
        int i = brfVar.b;
        int i2 = brfVar2.b;
        while (j < this.b) {
            long jMin = Math.min(brfVar.c - i, brfVar2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                byte b = brfVar.a[i];
                int i5 = i2 + 1;
                if (b != brfVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i5;
                i = i4;
            }
            if (i == brfVar.c) {
                brfVar = brfVar.f;
                i = brfVar.b;
            }
            if (i2 == brfVar2.c) {
                brfVar2 = brfVar2.f;
                i2 = brfVar2.b;
            }
            j += jMin;
        }
        return true;
    }

    public int hashCode() {
        brf brfVar = this.a;
        if (brfVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = brfVar.b;
            int i3 = brfVar.c;
            while (i2 < i3) {
                int i4 = brfVar.a[i2] + (i * 31);
                i2++;
                i = i4;
            }
            brfVar = brfVar.f;
        } while (brfVar != this.a);
        return i;
    }

    public String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().p().d());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
            for (brf brfVar = this.a.f; brfVar != this.a; brfVar = brfVar.f) {
                messageDigest.update(brfVar.a, brfVar.b, brfVar.c - brfVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), bqv.a(messageDigest.digest()).d());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public bqs clone() {
        bqs bqsVar = new bqs();
        if (this.b == 0) {
            return bqsVar;
        }
        bqsVar.a = new brf(this.a);
        brf brfVar = bqsVar.a;
        brf brfVar2 = bqsVar.a;
        brf brfVar3 = bqsVar.a;
        brfVar2.g = brfVar3;
        brfVar.f = brfVar3;
        for (brf brfVar4 = this.a.f; brfVar4 != this.a; brfVar4 = brfVar4.f) {
            bqsVar.a.g.a(new brf(brfVar4));
        }
        bqsVar.b = this.b;
        return bqsVar;
    }
}
