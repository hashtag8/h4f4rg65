package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ahk {
    public static int a(int i) {
        if (i <= 1) {
            return 0;
        }
        return (int) ((Math.random() * ((double) (i - 1))) + 1.0d);
    }

    public static int b(int i) {
        if (i == 1 || i == 0) {
            return 0;
        }
        return (int) (Math.random() * ((double) i));
    }

    public static int a() {
        int iD;
        byte[] bArr = new byte[2];
        do {
            bArr[0] = (byte) b(244);
            bArr[1] = (byte) b(244);
            iD = mk.d(bArr);
        } while (iD == 0);
        return iD;
    }
}
