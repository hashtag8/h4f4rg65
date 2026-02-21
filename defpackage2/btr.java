package defpackage;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class btr {
    int a;
    int b;
    int c;
    public int d;
    protected int[] e;
    protected int[] f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected Reader k;
    protected char[] l;
    protected int m;
    protected int n;
    protected int o;

    protected void a(boolean z) {
        char[] cArr = new char[this.a + 2048];
        int[] iArr = new int[this.a + 2048];
        int[] iArr2 = new int[this.a + 2048];
        try {
            if (z) {
                System.arraycopy(this.l, this.c, cArr, 0, this.a - this.c);
                System.arraycopy(this.l, 0, cArr, this.a - this.c, this.d);
                this.l = cArr;
                System.arraycopy(this.e, this.c, iArr, 0, this.a - this.c);
                System.arraycopy(this.e, 0, iArr, this.a - this.c, this.d);
                this.e = iArr;
                System.arraycopy(this.f, this.c, iArr2, 0, this.a - this.c);
                System.arraycopy(this.f, 0, iArr2, this.a - this.c, this.d);
                this.f = iArr2;
                int i = this.d + (this.a - this.c);
                this.d = i;
                this.m = i;
            } else {
                System.arraycopy(this.l, this.c, cArr, 0, this.a - this.c);
                this.l = cArr;
                System.arraycopy(this.e, this.c, iArr, 0, this.a - this.c);
                this.e = iArr;
                System.arraycopy(this.f, this.c, iArr2, 0, this.a - this.c);
                this.f = iArr2;
                int i2 = this.d - this.c;
                this.d = i2;
                this.m = i2;
            }
            this.a += 2048;
            this.b = this.a;
            this.c = 0;
        } catch (Throwable th) {
            throw new Error(th.getMessage());
        }
    }

    protected void a() throws IOException {
        if (this.m == this.b) {
            if (this.b == this.a) {
                if (this.c > 2048) {
                    this.m = 0;
                    this.d = 0;
                    this.b = this.c;
                } else if (this.c < 0) {
                    this.m = 0;
                    this.d = 0;
                } else {
                    a(false);
                }
            } else if (this.b > this.c) {
                this.b = this.a;
            } else if (this.c - this.b < 2048) {
                a(true);
            } else {
                this.b = this.c;
            }
        }
        try {
            int i = this.k.read(this.l, this.m, this.b - this.m);
            if (i == -1) {
                this.k.close();
                throw new IOException();
            }
            this.m = i + this.m;
        } catch (IOException e) {
            this.d--;
            a(0);
            if (this.c == -1) {
                this.c = this.d;
            }
            throw e;
        }
    }

    public char b() throws IOException {
        this.c = -1;
        char c = c();
        this.c = this.d;
        return c;
    }

    protected void a(char c) {
        this.g++;
        if (this.j) {
            this.j = false;
            int i = this.h;
            this.g = 1;
            this.h = i + 1;
        } else if (this.i) {
            this.i = false;
            if (c == '\n') {
                this.j = true;
            } else {
                int i2 = this.h;
                this.g = 1;
                this.h = i2 + 1;
            }
        }
        switch (c) {
            case '\t':
                this.g--;
                this.g += this.o - (this.g % this.o);
                break;
            case '\n':
                this.j = true;
                break;
            case '\r':
                this.i = true;
                break;
        }
        this.e[this.d] = this.h;
        this.f[this.d] = this.g;
    }

    public char c() throws IOException {
        if (this.n > 0) {
            this.n--;
            int i = this.d + 1;
            this.d = i;
            if (i == this.a) {
                this.d = 0;
            }
            return this.l[this.d];
        }
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 >= this.m) {
            a();
        }
        char c = this.l[this.d];
        a(c);
        return c;
    }

    public int d() {
        return this.f[this.d];
    }

    public int e() {
        return this.e[this.d];
    }

    public int f() {
        return this.f[this.c];
    }

    public int g() {
        return this.e[this.c];
    }

    public void a(int i) {
        this.n += i;
        int i2 = this.d - i;
        this.d = i2;
        if (i2 < 0) {
            this.d += this.a;
        }
    }

    public btr(Reader reader, int i, int i2, int i3) {
        this.d = -1;
        this.g = 0;
        this.h = 1;
        this.i = false;
        this.j = false;
        this.m = 0;
        this.n = 0;
        this.o = 8;
        this.k = reader;
        this.h = i;
        this.g = i2 - 1;
        this.a = i3;
        this.b = i3;
        this.l = new char[i3];
        this.e = new int[i3];
        this.f = new int[i3];
    }

    public btr(Reader reader, int i, int i2) {
        this(reader, i, i2, 4096);
    }

    public String h() {
        return this.d >= this.c ? new String(this.l, this.c, (this.d - this.c) + 1) : new String(this.l, this.c, this.a - this.c) + new String(this.l, 0, this.d + 1);
    }

    public char[] b(int i) {
        char[] cArr = new char[i];
        if (this.d + 1 >= i) {
            System.arraycopy(this.l, (this.d - i) + 1, cArr, 0, i);
        } else {
            System.arraycopy(this.l, this.a - ((i - this.d) - 1), cArr, 0, (i - this.d) - 1);
            System.arraycopy(this.l, 0, cArr, (i - this.d) - 1, this.d + 1);
        }
        return cArr;
    }
}
