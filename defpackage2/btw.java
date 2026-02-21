package defpackage;

import java.io.IOException;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class btw implements btv {
    static int a;
    static final long[] c = {0, 0, -1, -1};
    static final int[] d = new int[0];
    public static final String[] f = {"", "\r", "\n", "/", ";", "=", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    public static final String[] g = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"};
    public static final int[] h = {-1, -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, 0, -1, -1, -1, -1};
    static final long[] i = {3670079};
    static final long[] j = {320};
    static final long[] k = {64};
    static final long[] l = {523904};
    protected bty m;
    StringBuffer n;
    int o;
    int p;
    protected char q;
    int t;
    int u;
    int v;
    int w;
    public PrintStream b = System.out;
    private final int[] x = new int[3];
    private final int[] y = new int[6];
    int r = 0;
    int s = 0;

    private final int a(int i2, int i3) {
        this.w = i3;
        this.v = i2;
        return i2 + 1;
    }

    private final int a(int i2, int i3, int i4) {
        this.w = i3;
        this.v = i2;
        try {
            this.q = this.m.c();
            return b(i4, i2 + 1);
        } catch (IOException e) {
            return i2 + 1;
        }
    }

    private final int d() {
        switch (this.q) {
            case '\n':
                return a(0, 2, 2);
            case '\r':
                return a(0, 1, 2);
            case '\"':
                return a(0, 16);
            case '(':
                return a(0, 7);
            case '/':
                return a(0, 3);
            case ';':
                return a(0, 4);
            case '=':
                return a(0, 5);
            default:
                return b(3, 0);
        }
    }

    private final void b(int i2) {
        if (this.x[i2] != this.u) {
            int[] iArr = this.y;
            int i3 = this.t;
            this.t = i3 + 1;
            iArr[i3] = i2;
            this.x[i2] = this.u;
        }
    }

    private final int b(int i2, int i3) {
        int i4 = 0;
        this.t = 3;
        int i5 = 1;
        this.y[0] = i2;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.u + 1;
            this.u = i7;
            if (i7 == Integer.MAX_VALUE) {
                h();
            }
            if (this.q < '@') {
                long j2 = 1 << this.q;
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if ((4294967808L & j2) != 0) {
                                i6 = 6;
                                b(0);
                            }
                            break;
                        case 1:
                            if ((287948901175001088L & j2) != 0) {
                                if (i6 > 20) {
                                    i6 = 20;
                                }
                                b(1);
                            }
                            break;
                        case 2:
                            if ((288068726467591679L & j2) != 0) {
                                if (i6 > 21) {
                                    i6 = 21;
                                }
                                b(2);
                            }
                            break;
                        case 3:
                            if ((288068726467591679L & j2) != 0) {
                                if (i6 > 21) {
                                    i6 = 21;
                                }
                                b(2);
                            } else if ((4294967808L & j2) != 0) {
                                if (i6 > 6) {
                                    i6 = 6;
                                }
                                b(0);
                            }
                            if ((287948901175001088L & j2) != 0) {
                                if (i6 > 20) {
                                    i6 = 20;
                                }
                                b(1);
                            }
                            break;
                    }
                } while (i5 != i4);
            } else if (this.q < 128) {
                long j3 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 2:
                        case 3:
                            if (((-939524098) & j3) != 0) {
                                i6 = 21;
                                b(2);
                            }
                            break;
                    }
                } while (i5 != i4);
            } else {
                int i8 = (this.q & 255) >> 6;
                long j4 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 2:
                        case 3:
                            if ((c[i8] & j4) != 0) {
                                if (i6 > 21) {
                                    i6 = 21;
                                }
                                b(2);
                            }
                            break;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.w = i6;
                this.v = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.t;
            this.t = i4;
            i4 = 3 - i4;
            if (i5 != i4) {
                try {
                    this.q = this.m.c();
                } catch (IOException e) {
                }
            }
            return i3;
        }
    }

    private final int e() {
        switch (this.q) {
            case '(':
                return a(0, 10);
            case ')':
                return a(0, 8);
            default:
                return c(0, 0);
        }
    }

    private final int c(int i2, int i3) {
        int i4 = 0;
        this.t = 3;
        int i5 = 1;
        this.y[0] = i2;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.u + 1;
            this.u = i7;
            if (i7 == Integer.MAX_VALUE) {
                h();
            }
            if (this.q < '@') {
                long j2 = 1 << this.q;
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if (i6 > 11) {
                                i6 = 11;
                            }
                            break;
                        case 1:
                            if (i6 > 9) {
                                i6 = 9;
                            }
                            break;
                    }
                } while (i5 != i4);
            } else if (this.q < 128) {
                long j3 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if (i6 > 11) {
                                i6 = 11;
                            }
                            if (this.q == '\\') {
                                int[] iArr = this.y;
                                int i8 = this.t;
                                this.t = i8 + 1;
                                iArr[i8] = 1;
                            }
                            break;
                        case 1:
                            if (i6 > 9) {
                                i6 = 9;
                            }
                            break;
                        case 2:
                            if (i6 > 11) {
                                i6 = 11;
                            }
                            break;
                    }
                } while (i5 != i4);
            } else {
                int i9 = (this.q & 255) >> 6;
                long j4 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if ((c[i9] & j4) != 0 && i6 > 11) {
                                i6 = 11;
                            }
                            break;
                        case 1:
                            if ((c[i9] & j4) != 0 && i6 > 9) {
                                i6 = 9;
                            }
                            break;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.w = i6;
                this.v = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.t;
            this.t = i4;
            i4 = 3 - i4;
            if (i5 != i4) {
                try {
                    this.q = this.m.c();
                } catch (IOException e) {
                }
            }
            return i3;
        }
    }

    private final int f() {
        switch (this.q) {
            case '\"':
                return a(0, 19);
            default:
                return d(0, 0);
        }
    }

    private final int d(int i2, int i3) {
        int i4 = 0;
        this.t = 3;
        int i5 = 1;
        this.y[0] = i2;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.u + 1;
            this.u = i7;
            if (i7 == Integer.MAX_VALUE) {
                h();
            }
            if (this.q < '@') {
                long j2 = 1 << this.q;
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                        case 2:
                            if (((-17179869185L) & j2) != 0) {
                                if (i6 > 18) {
                                    i6 = 18;
                                }
                                b(2);
                            }
                            break;
                        case 1:
                            if (i6 > 17) {
                                i6 = 17;
                            }
                            break;
                    }
                } while (i5 != i4);
            } else if (this.q < 128) {
                long j3 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if (((-268435457) & j3) != 0) {
                                if (i6 > 18) {
                                    i6 = 18;
                                }
                                b(2);
                            } else if (this.q == '\\') {
                                int[] iArr = this.y;
                                int i8 = this.t;
                                this.t = i8 + 1;
                                iArr[i8] = 1;
                            }
                            break;
                        case 1:
                            if (i6 > 17) {
                                i6 = 17;
                            }
                            break;
                        case 2:
                            if (((-268435457) & j3) != 0) {
                                if (i6 > 18) {
                                    i6 = 18;
                                }
                                b(2);
                            }
                            break;
                    }
                } while (i5 != i4);
            } else {
                int i9 = (this.q & 255) >> 6;
                long j4 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                        case 2:
                            if ((c[i9] & j4) != 0) {
                                if (i6 > 18) {
                                    i6 = 18;
                                }
                                b(2);
                            }
                            break;
                        case 1:
                            if ((c[i9] & j4) != 0 && i6 > 17) {
                                i6 = 17;
                            }
                            break;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.w = i6;
                this.v = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.t;
            this.t = i4;
            i4 = 3 - i4;
            if (i5 != i4) {
                try {
                    this.q = this.m.c();
                } catch (IOException e) {
                }
            }
            return i3;
        }
    }

    private final int g() {
        switch (this.q) {
            case '(':
                return a(0, 13);
            case ')':
                return a(0, 14);
            default:
                return e(0, 0);
        }
    }

    private final int e(int i2, int i3) {
        int i4 = 0;
        this.t = 3;
        int i5 = 1;
        this.y[0] = i2;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.u + 1;
            this.u = i7;
            if (i7 == Integer.MAX_VALUE) {
                h();
            }
            if (this.q < '@') {
                long j2 = 1 << this.q;
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if (i6 > 15) {
                                i6 = 15;
                            }
                            break;
                        case 1:
                            if (i6 > 12) {
                                i6 = 12;
                            }
                            break;
                    }
                } while (i5 != i4);
            } else if (this.q < 128) {
                long j3 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if (i6 > 15) {
                                i6 = 15;
                            }
                            if (this.q == '\\') {
                                int[] iArr = this.y;
                                int i8 = this.t;
                                this.t = i8 + 1;
                                iArr[i8] = 1;
                            }
                            break;
                        case 1:
                            if (i6 > 12) {
                                i6 = 12;
                            }
                            break;
                        case 2:
                            if (i6 > 15) {
                                i6 = 15;
                            }
                            break;
                    }
                } while (i5 != i4);
            } else {
                int i9 = (this.q & 255) >> 6;
                long j4 = 1 << (this.q & '?');
                do {
                    i5--;
                    switch (this.y[i5]) {
                        case 0:
                            if ((c[i9] & j4) != 0 && i6 > 15) {
                                i6 = 15;
                            }
                            break;
                        case 1:
                            if ((c[i9] & j4) != 0 && i6 > 12) {
                                i6 = 12;
                            }
                            break;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.w = i6;
                this.v = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.t;
            this.t = i4;
            i4 = 3 - i4;
            if (i5 != i4) {
                try {
                    this.q = this.m.c();
                } catch (IOException e) {
                }
            }
            return i3;
        }
    }

    public btw(bty btyVar) {
        this.m = btyVar;
    }

    private final void h() {
        this.u = -2147483647;
        int i2 = 3;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                this.x[i3] = Integer.MIN_VALUE;
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public void a(int i2) {
        if (i2 >= 4 || i2 < 0) {
            throw new bua("Error: Ignoring invalid lexical state : " + i2 + ". State unchanged.", 2);
        }
        this.r = i2;
    }

    protected btz a() {
        btz btzVarA = btz.a(this.w);
        btzVarA.a = this.w;
        String strH = f[this.w];
        if (strH == null) {
            strH = this.m.h();
        }
        btzVarA.f = strH;
        btzVarA.b = this.m.g();
        btzVarA.c = this.m.f();
        btzVarA.d = this.m.e();
        btzVarA.e = this.m.d();
        return btzVarA;
    }

    public btz b() {
        int iF;
        boolean z;
        btz btzVarA;
        String strH = null;
        int i2 = 0;
        btz btzVar = null;
        while (true) {
            try {
                this.q = this.m.b();
                this.n = null;
                this.o = 0;
                while (true) {
                    switch (this.r) {
                        case 0:
                            this.w = Integer.MAX_VALUE;
                            this.v = 0;
                            iF = d();
                            break;
                        case 1:
                            this.w = Integer.MAX_VALUE;
                            this.v = 0;
                            iF = e();
                            break;
                        case 2:
                            this.w = Integer.MAX_VALUE;
                            this.v = 0;
                            iF = g();
                            break;
                        case 3:
                            this.w = Integer.MAX_VALUE;
                            this.v = 0;
                            iF = f();
                            break;
                        default:
                            iF = i2;
                            break;
                    }
                    if (this.w != Integer.MAX_VALUE) {
                        if (this.v + 1 < iF) {
                            this.m.a((iF - this.v) - 1);
                        }
                        if ((i[this.w >> 6] & (1 << (this.w & 63))) != 0) {
                            btz btzVarA2 = a();
                            btzVarA2.h = btzVar;
                            a(btzVarA2);
                            if (h[this.w] != -1) {
                                this.r = h[this.w];
                                return btzVarA2;
                            }
                            return btzVarA2;
                        }
                        if ((j[this.w >> 6] & (1 << (this.w & 63))) != 0) {
                            if ((k[this.w >> 6] & (1 << (this.w & 63))) != 0) {
                                btzVarA = a();
                                if (btzVar != null) {
                                    btzVarA.h = btzVar;
                                    btzVar.g = btzVarA;
                                }
                            } else {
                                btzVarA = btzVar;
                            }
                            if (h[this.w] != -1) {
                                this.r = h[this.w];
                                btzVar = btzVarA;
                                i2 = iF;
                            } else {
                                btzVar = btzVarA;
                                i2 = iF;
                            }
                        } else {
                            c();
                            if (h[this.w] != -1) {
                                this.r = h[this.w];
                            }
                            this.w = Integer.MAX_VALUE;
                            try {
                                this.q = this.m.c();
                                i2 = 0;
                            } catch (IOException e) {
                                iF = 0;
                                int iE = this.m.e();
                                int iD = this.m.d();
                                try {
                                    this.m.c();
                                    this.m.a(1);
                                    z = false;
                                } catch (IOException e2) {
                                    String strH2 = iF <= 1 ? "" : this.m.h();
                                    if (this.q == '\n' || this.q == '\r') {
                                        iE++;
                                        z = true;
                                        strH = strH2;
                                        iD = 0;
                                    } else {
                                        iD++;
                                        z = true;
                                        strH = strH2;
                                    }
                                }
                                if (!z) {
                                    this.m.a(1);
                                    strH = iF <= 1 ? "" : this.m.h();
                                }
                                throw new bua(z, this.r, iE, iD, strH, this.q, 0);
                            }
                        }
                    }
                }
            } catch (IOException e3) {
                this.w = 0;
                btz btzVarA3 = a();
                btzVarA3.h = btzVar;
                return btzVarA3;
            }
        }
    }

    void c() {
        int i2 = this.o;
        int i3 = this.v + 1;
        this.p = i3;
        this.o = i2 + i3;
        switch (this.w) {
            case 9:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                this.n.deleteCharAt(this.n.length() - 2);
                break;
            case 10:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                a = 1;
                break;
            case 12:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                this.n.deleteCharAt(this.n.length() - 2);
                break;
            case 13:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                a++;
                break;
            case 14:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                a--;
                if (a == 0) {
                    a(1);
                }
                break;
            case 16:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                this.n.deleteCharAt(this.n.length() - 1);
                break;
            case 17:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                this.n.append(this.m.b(this.o));
                this.o = 0;
                this.n.deleteCharAt(this.n.length() - 2);
                break;
        }
    }

    void a(btz btzVar) {
        switch (this.w) {
            case 19:
                if (this.n == null) {
                    this.n = new StringBuffer();
                }
                StringBuffer stringBuffer = this.n;
                bty btyVar = this.m;
                int i2 = this.o;
                int i3 = this.v + 1;
                this.p = i3;
                stringBuffer.append(btyVar.b(i2 + i3));
                btzVar.f = this.n.substring(0, this.n.length() - 1);
                break;
        }
    }
}
