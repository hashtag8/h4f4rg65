package defpackage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
final class ol {
    public static final ol a = new ol(new byte[0]);
    private final byte[] b;
    private volatile int c = 0;

    private ol(byte[] bArr) {
        this.b = bArr;
    }

    public int a() {
        return this.b.length;
    }

    public static ol a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ol(bArr2);
    }

    public static ol a(String str) {
        try {
            return new ol(str.getBytes(HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ol)) {
            return false;
        }
        ol olVar = (ol) obj;
        int length = this.b.length;
        if (length != olVar.b.length) {
            return false;
        }
        byte[] bArr = this.b;
        byte[] bArr2 = olVar.b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.b;
            int length = this.b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public InputStream b() {
        return new ByteArrayInputStream(this.b);
    }
}
