package defpackage;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class bqv implements Serializable {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final bqv b = a(new byte[0]);
    final byte[] c;
    transient int d;
    transient String e;

    bqv(byte[] bArr) {
        this.c = bArr;
    }

    public static bqv a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new bqv((byte[]) bArr.clone());
    }

    public static bqv a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        bqv bqvVar = new bqv(str.getBytes(brk.a));
        bqvVar.e = str;
        return bqvVar;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, brk.a);
        this.e = str2;
        return str2;
    }

    public String b() {
        return bqr.a(this.c);
    }

    public bqv c() {
        return c("MD5");
    }

    private bqv c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static bqv b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrA = bqr.a(str);
        if (bArrA != null) {
            return new bqv(bArrA);
        }
        return null;
    }

    public String d() {
        char[] cArr = new char[this.c.length * 2];
        int i = 0;
        for (byte b2 : this.c) {
            int i2 = i + 1;
            cArr[i] = a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b2 & 15];
        }
        return new String(cArr);
    }

    public bqv e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.length) {
                byte b2 = this.c[i2];
                if (b2 < 65 || b2 > 90) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.c.clone();
                    bArr[i2] = (byte) (b2 + 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b3 = bArr[i3];
                        if (b3 >= 65 && b3 <= 90) {
                            bArr[i3] = (byte) (b3 + 32);
                        }
                    }
                    return new bqv(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public byte a(int i) {
        return this.c[i];
    }

    public int f() {
        return this.c.length;
    }

    public byte[] g() {
        return (byte[]) this.c.clone();
    }

    void a(bqs bqsVar) {
        bqsVar.b(this.c, 0, this.c.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i <= this.c.length - i3 && i2 <= bArr.length - i3 && brk.a(this.c, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof bqv) && ((bqv) obj).f() == this.c.length && ((bqv) obj).a(0, this.c, 0, this.c.length);
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.c);
        this.d = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.c.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(this.c.length), d());
        }
        return String.format("ByteString[size=%s md5=%s]", Integer.valueOf(this.c.length), c().d());
    }
}
