package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class aek extends aeg {
    public static byte a = 0;
    public static aei b = new aei(new byte[]{1, 1});
    public static aei c = new aei(new byte[]{1, 3});
    public static aei d = new aei(new byte[]{4, 10}, new byte[]{1});
    public static aei e = new aei(new byte[]{6, 1});
    public static aei f = new aei(new byte[]{15, 1});
    public static aei g = new aei(new byte[]{-1, 1});
    public static aei h = new aei(new byte[]{5, 6});
    public static aei i = new aei(new byte[]{4, 9});
    public static aei j = new aei(new byte[]{4, 6});
    public static aei k = new aei(new byte[]{7, 1}, new byte[]{-1, 7, 0, 0});
    public static aei l = new aei(new byte[]{7, 14});
    public static aei m = new aei(new byte[]{4, 8}, new byte[]{2, 0, 9, 1});
    public static aei n = new aei(new byte[]{5, 11});
    public static aei o = new aei(new byte[]{5, 32});
    public static aei p = new aei(new byte[]{5, 34});
    public static aei q = new aei(new byte[]{5, 36});
    public static aei r = new aei(new byte[]{7, 31});
    public static aei s = new aei(new byte[]{7, 4});
    public static aei t = new aei(new byte[]{7, 6});
    public static aei u = new aei(new byte[]{7, 6});
    public static aei v = new aei(new byte[]{7, 9});
    public static aei w = new aei(new byte[]{7, 12});
    public static aei x = new aei(new byte[]{7, 19});
    public static aei y = new aei(new byte[]{7, 21});
    public static aei z = new aei(new byte[]{6, 1});
    public static aei A = new aei(new byte[]{4, 11});
    public static aei B = new aei(new byte[]{7, 11});
    public static aei C = new aei(new byte[]{7, 4});
    public static aei D = new aei(new byte[]{7, 25}, new byte[]{1});
    public static aei E = new aei(new byte[]{7, 25}, new byte[]{0});
    public static aei F = new aei(new byte[]{4, 4}, new byte[]{3, 0});
    public static aei G = new aei(new byte[]{4, 4}, new byte[]{3, 1});
    public static aei H = new aei(new byte[]{4, 4}, new byte[]{3, 2});
    public static aei I = new aei(new byte[]{4, 4}, new byte[]{3, 3});
    public static aei J = new aei(new byte[]{4, 4}, new byte[]{3, 32});
    public static aei K = new aei(new byte[]{4, 4}, new byte[]{3, 4});
    public static aei L = new aei(new byte[]{4, 4}, new byte[]{3, 5});
    public static aei M = new aei(new byte[]{4, 4}, new byte[]{3, 6});
    public static aei N = new aei(new byte[]{4, 4}, new byte[]{3, 7});
    public static aei O = new aei(new byte[]{4, 4}, new byte[]{3, 16});
    public static aei P = new aei(new byte[]{4, 4}, new byte[]{3, 25});
    public static aei Q = new aei(new byte[]{4, 4}, new byte[]{3, 32});
    public static aei R = new aei(new byte[]{4, 10}, new byte[]{2});
    public static aei S = new aei(new byte[]{4, 10}, new byte[]{3});
    public static aei T = new aei(new byte[]{2, 5});
    public static aei U = new aei(new byte[]{2, 7});
    public static aei V = new aei(new byte[]{2, 8});
    public static aei W = new aei(new byte[]{7, 14});
    public static aei X = new aei(new byte[]{7, 17});
    public static aei Y = new aei(new byte[]{7, 26});
    public static aei Z = new aei(new byte[]{5, 96}, new byte[]{65, 72, 5, 96});
    public static aei aa = new aei(new byte[]{5, 98}, new byte[]{0, 65, 72, 5, 96});
    public static aei ab = new aei(new byte[]{4, 8}, new byte[]{2, 0, 9, 0});
    public static aei ac = new aei(new byte[]{4, 8}, new byte[]{2, 0, 9, 1});
    public static aei ad = new aei(new byte[]{4, 8}, new byte[]{2, 0, 4, 0});
    public static aei ae = new aei(new byte[]{4, 8}, new byte[]{2, 0, 3, 0});
    public static aei af = new aei(new byte[]{4, 8}, new byte[]{2, 0, 37, 0});
    public static aei ag = new aei(new byte[]{4, 8}, new byte[]{2, 0, 38, 2});
    public static aei ah = new aei(new byte[]{4, 8}, new byte[]{2, 0, 38, 3});
    public static aei ai = new aei(new byte[]{4, 8}, new byte[]{2, 0, 38, 1});
    public static aei aj = new aei(new byte[]{4, 8}, new byte[]{2, 0, 39, 2});
    public static aei ak = new aei(new byte[]{4, 8}, new byte[]{2, 0, 39, 1});
    public static aei al = new aei(new byte[]{7, 33});
    public static aei am = new aei(new byte[]{7, 28});
    public static aei an = new aei(new byte[]{7, 39}, new byte[]{0, 0, 0, 0, 0, 0, 1});
    public static aei ao = new aei(new byte[]{7, 39}, new byte[]{0, 0, 0, 0, 0, 0, 0});
    public static aei ap = new aei(new byte[]{7, 48});

    public static aei a(String str) {
        return new aei(new byte[]{7, 24}, new byte[]{aht.a(str), 1});
    }

    public static aei a(adx adxVar) {
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[8];
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        if (adxVar.D() != -1) {
            stringBuffer.append(1);
            bArr[0] = adxVar.D();
            i2 = 1;
        } else {
            stringBuffer.append(0);
            i2 = 0;
        }
        byte[] bArrC = mk.c(Integer.valueOf(stringBuffer.reverse().toString(), 2).intValue());
        byte[] bArr2 = new byte[i2 + 4];
        bArr2[0] = bArrC[0];
        bArr2[1] = bArrC[1];
        System.arraycopy(bArr, 0, bArr2, 4, i2);
        return new aei(new byte[]{7, 3}, bArr2);
    }

    public static aei b(adx adxVar) {
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[12];
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        stringBuffer.append(0);
        if (adxVar.U() != -1) {
            stringBuffer.append(1);
            bArr[0] = adxVar.U();
            i2 = 1;
        } else {
            stringBuffer.append(0);
            i2 = 0;
        }
        stringBuffer.append(0);
        stringBuffer.append(0);
        byte[] bArrC = mk.c(Integer.valueOf(stringBuffer.reverse().toString(), 2).intValue());
        byte[] bArr2 = new byte[i2 + 4];
        bArr2[0] = bArrC[0];
        bArr2[1] = bArrC[1];
        System.arraycopy(bArr, 0, bArr2, 4, i2);
        return new aei(new byte[]{7, 3}, bArr2);
    }

    public static byte[] a(int i2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.asIntBuffer().put(i2);
        byteBufferAllocate.array();
        return byteBufferAllocate.array();
    }
}
