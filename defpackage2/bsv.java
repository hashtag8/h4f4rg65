package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
final class bsv {
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private final byte[] b;
    private final byte[] c;
    private final boolean d;
    private int i = 0;
    private int h = 77;
    private OutputStream j = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;

    public bsv(int i, boolean z) {
        this.b = new byte[i];
        this.c = new byte[i * 3];
        this.d = z;
    }

    void a(OutputStream outputStream) {
        this.j = outputStream;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = 77;
    }

    void a(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 < i2 + i; i3++) {
            a(bArr[i3]);
        }
    }

    void a() throws IOException {
        c();
        b();
    }

    private void c() throws IOException {
        if (this.e) {
            b((byte) 32);
        } else if (this.f) {
            b((byte) 9);
        } else if (this.g) {
            b((byte) 13);
        }
        d();
    }

    private void d() {
        this.e = false;
        this.f = false;
        this.g = false;
    }

    private void a(byte b) throws IOException {
        if (b == 10) {
            if (this.d) {
                c();
                c(b);
                return;
            } else {
                if (this.g) {
                    if (this.e) {
                        c((byte) 32);
                    } else if (this.f) {
                        c((byte) 9);
                    }
                    f();
                    d();
                    return;
                }
                c();
                b(b);
                return;
            }
        }
        if (b == 13) {
            if (this.d) {
                c(b);
                return;
            } else {
                this.g = true;
                return;
            }
        }
        c();
        if (b == 32) {
            if (this.d) {
                c(b);
                return;
            } else {
                this.e = true;
                return;
            }
        }
        if (b == 9) {
            if (this.d) {
                c(b);
                return;
            } else {
                this.f = true;
                return;
            }
        }
        if (b < 32) {
            c(b);
            return;
        }
        if (b > 126) {
            c(b);
        } else if (b == 61) {
            c(b);
        } else {
            b(b);
        }
    }

    private void b(byte b) throws IOException {
        int i = this.h - 1;
        this.h = i;
        if (i <= 1) {
            e();
        }
        d(b);
    }

    private void c(byte b) throws IOException {
        int i = this.h - 1;
        this.h = i;
        if (i <= 3) {
            e();
        }
        int i2 = b & 255;
        d((byte) 61);
        this.h--;
        d(a[i2 >> 4]);
        this.h--;
        d(a[i2 % 16]);
    }

    private void d(byte b) throws IOException {
        byte[] bArr = this.c;
        int i = this.i;
        this.i = i + 1;
        bArr[i] = b;
        if (this.i >= this.c.length) {
            b();
        }
    }

    private void e() throws IOException {
        d((byte) 61);
        f();
    }

    private void f() throws IOException {
        d((byte) 13);
        d((byte) 10);
        this.h = 76;
    }

    void b() throws IOException {
        if (this.i < this.c.length) {
            this.j.write(this.c, 0, this.i);
        } else {
            this.j.write(this.c);
        }
        this.i = 0;
    }
}
