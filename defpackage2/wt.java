package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class wt extends wq {
    private MessageDigest b;

    byte a(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ (((-16777216) & i) >> 24));
    }

    @Override // defpackage.wq
    public byte[] a(String str) {
        byte[] bArr;
        byte[] bArrA = a(str.split(" "));
        this.b = a();
        synchronized (this.a) {
            if (this.b == null) {
                bArr = new byte[0];
            } else {
                this.b.reset();
                this.b.update(bArrA);
                byte[] bArrDigest = this.b.digest();
                bArr = new byte[bArrDigest.length <= 4 ? bArrDigest.length : 4];
                System.arraycopy(bArrDigest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = a(ws.a(strArr[i]));
        }
        return bArr;
    }
}
