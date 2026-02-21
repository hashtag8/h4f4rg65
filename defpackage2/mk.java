package defpackage;

import java.math.BigInteger;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class mk {
    public static short a(byte[] bArr) {
        return new BigInteger(bArr).shortValue();
    }

    public static String b(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static String c(byte[] bArr) {
        String strSubstring;
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String binaryString = Integer.toBinaryString(b);
            if (binaryString.length() > 8) {
                strSubstring = binaryString.substring(binaryString.length() - 8);
            } else {
                strSubstring = binaryString;
                for (int i = 0; i < 8 - binaryString.length(); i++) {
                    strSubstring = "0" + strSubstring;
                }
            }
            stringBuffer.append(new StringBuffer(strSubstring).reverse().toString());
        }
        return stringBuffer.toString();
    }

    public static int[] a(int i) {
        String binaryString = Integer.toBinaryString(i);
        int length = 32 - binaryString.length();
        int[] iArr = new int[4];
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("0");
        }
        sb.append(binaryString);
        String string = sb.toString();
        iArr[0] = Integer.valueOf(string.substring(0, 8), 2).intValue();
        iArr[1] = Integer.valueOf(string.substring(8, 16), 2).intValue();
        iArr[2] = Integer.valueOf(string.substring(16, 24), 2).intValue();
        iArr[3] = Integer.valueOf(string.substring(24), 2).intValue();
        return iArr;
    }

    public static int d(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i += (bArr[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public static long e(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < bArr.length; i++) {
            j += (long) ((bArr[i] & 255) << (i * 8));
        }
        return j;
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
    }

    public static byte[] c(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static long f(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return crc32.getValue();
    }
}
