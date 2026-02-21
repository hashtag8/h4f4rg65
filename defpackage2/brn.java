package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class brn {
    public static final Charset a = brl.f;
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final Charset d;

    public static byte[] a(char[] cArr) throws brm {
        int i = 0;
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new brm("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        while (i < length) {
            int iA = a(cArr[i], i) << 4;
            int i3 = i + 1;
            int iA2 = iA | a(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (iA2 & 255);
            i2++;
        }
        return bArr;
    }

    protected static int a(char c2, int i) throws brm {
        int iDigit = Character.digit(c2, 16);
        if (iDigit == -1) {
            throw new brm("Illegal hexadecimal character " + c2 + " at index " + i);
        }
        return iDigit;
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.d + "]";
    }
}
