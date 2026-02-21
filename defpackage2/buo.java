package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class buo implements bup {
    private byte[] b;
    private int c;

    public buo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        }
        this.b = new byte[i];
    }

    private void a(int i) {
        byte[] bArr = new byte[Math.max(this.b.length << 1, i)];
        System.arraycopy(this.b, 0, bArr, 0, this.c);
        this.b = bArr;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 != 0) {
                int i3 = this.c + i2;
                if (i3 > this.b.length) {
                    a(i3);
                }
                System.arraycopy(bArr, i, this.b, this.c, i2);
                this.c = i3;
            }
        }
    }

    @Override // defpackage.bup
    public byte[] a() {
        byte[] bArr = new byte[this.c];
        if (this.c > 0) {
            System.arraycopy(this.b, 0, bArr, 0, this.c);
        }
        return bArr;
    }

    @Override // defpackage.bup
    public int b() {
        return this.c;
    }

    public byte[] c() {
        return this.b;
    }

    public String toString() {
        return new String(a());
    }
}
