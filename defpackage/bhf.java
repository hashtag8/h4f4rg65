package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class bhf {
    private int a;
    private int b;
    private int c;
    private final int[] d = new int[10];

    void a() {
        this.c = 0;
        this.b = 0;
        this.a = 0;
        Arrays.fill(this.d, 0);
    }

    bhf a(int i, int i2, int i3) {
        if (i < this.d.length) {
            int i4 = 1 << i;
            this.a |= i4;
            if ((i2 & 1) != 0) {
                this.b |= i4;
            } else {
                this.b &= i4 ^ (-1);
            }
            if ((i2 & 2) != 0) {
                this.c = i4 | this.c;
            } else {
                this.c = (i4 ^ (-1)) & this.c;
            }
            this.d[i] = i3;
        }
        return this;
    }

    boolean a(int i) {
        return ((1 << i) & this.a) != 0;
    }

    int b(int i) {
        return this.d[i];
    }

    int c(int i) {
        int i2 = g(i) ? 2 : 0;
        return f(i) ? i2 | 1 : i2;
    }

    int b() {
        return Integer.bitCount(this.a);
    }

    int c() {
        if ((2 & this.a) != 0) {
            return this.d[1];
        }
        return -1;
    }

    int d(int i) {
        return (32 & this.a) != 0 ? this.d[5] : i;
    }

    int e(int i) {
        return (128 & this.a) != 0 ? this.d[7] : i;
    }

    boolean f(int i) {
        return ((1 << i) & this.b) != 0;
    }

    boolean g(int i) {
        return ((1 << i) & this.c) != 0;
    }

    void a(bhf bhfVar) {
        for (int i = 0; i < 10; i++) {
            if (bhfVar.a(i)) {
                a(i, bhfVar.c(i), bhfVar.b(i));
            }
        }
    }
}
