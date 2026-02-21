package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class adv {
    private final String[] a = new String[512];

    adv() {
    }

    public String a(char[] cArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        int i5 = ((i3 >>> 20) ^ (i3 >>> 12)) ^ i3;
        int length = (this.a.length - 1) & (i5 ^ ((i5 >>> 7) ^ (i5 >>> 4)));
        String str = this.a[length];
        if (str == null || str.length() != i2) {
            String str2 = new String(cArr, i, i2);
            this.a[length] = str2;
            return str2;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            if (str.charAt(i6) != cArr[i + i6]) {
                String str3 = new String(cArr, i, i2);
                this.a[length] = str3;
                return str3;
            }
        }
        return str;
    }
}
