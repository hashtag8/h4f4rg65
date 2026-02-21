package defpackage;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class btn implements bto {
    private static int[] l;
    public btp a;
    btr b;
    public bts d;
    private String f;
    private int[] n;
    private List<String> g = new ArrayList();
    private List<String> h = new ArrayList();
    private final int[] k = new int[3];
    private Vector<int[]> m = new Vector<>();
    private int o = -1;
    public bts c = new bts();
    private int i = -1;
    private int j = 0;

    public String a() {
        return this.f;
    }

    public List<String> b() {
        return this.g;
    }

    public List<String> c() {
        return this.h;
    }

    public final void d() throws btq {
        e();
        a(0);
    }

    public final void e() throws btq {
        this.f = a(20).f;
        while (true) {
            switch (this.i == -1 ? j() : this.i) {
                case 3:
                    a(3);
                    f();
                    break;
                default:
                    this.k[1] = this.j;
                    return;
            }
        }
    }

    public final void f() throws btq {
        bts btsVarA = a(20);
        a(4);
        String strG = g();
        this.g.add(btsVarA.f);
        this.h.add(strG);
    }

    public final String g() throws btq {
        bts btsVarA;
        switch (this.i == -1 ? j() : this.i) {
            case 18:
                btsVarA = a(18);
                break;
            case 19:
                btsVarA = a(19);
                break;
            case 20:
                btsVarA = a(20);
                break;
            default:
                this.k[2] = this.j;
                a(-1);
                throw new btq();
        }
        return btsVarA.f;
    }

    static {
        i();
    }

    private static void i() {
        l = new int[]{2, 8, 1835008};
    }

    public btn(Reader reader) {
        this.b = new btr(reader, 1, 1);
        this.a = new btp(this.b);
        for (int i = 0; i < 3; i++) {
            this.k[i] = -1;
        }
    }

    private final bts a(int i) throws btq {
        bts btsVar = this.c;
        if (btsVar.g != null) {
            this.c = this.c.g;
        } else {
            bts btsVar2 = this.c;
            bts btsVarB = this.a.b();
            btsVar2.g = btsVarB;
            this.c = btsVarB;
        }
        this.i = -1;
        if (this.c.a == i) {
            this.j++;
            return this.c;
        }
        this.c = btsVar;
        this.o = i;
        throw h();
    }

    private final int j() {
        bts btsVar = this.c.g;
        this.d = btsVar;
        if (btsVar == null) {
            bts btsVar2 = this.c;
            bts btsVarB = this.a.b();
            btsVar2.g = btsVarB;
            int i = btsVarB.a;
            this.i = i;
            return i;
        }
        int i2 = this.d.a;
        this.i = i2;
        return i2;
    }

    public btq h() {
        int i = 0;
        this.m.removeAllElements();
        boolean[] zArr = new boolean[23];
        for (int i2 = 0; i2 < 23; i2++) {
            zArr[i2] = false;
        }
        if (this.o >= 0) {
            zArr[this.o] = true;
            this.o = -1;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.k[i3] == this.j) {
                for (int i4 = 0; i4 < 32; i4++) {
                    if ((l[i3] & (1 << i4)) != 0) {
                        zArr[i4] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 23; i5++) {
            if (zArr[i5]) {
                this.n = new int[1];
                this.n[0] = i5;
                this.m.addElement(this.n);
            }
        }
        int[][] iArr = new int[this.m.size()][];
        while (true) {
            int i6 = i;
            if (i6 < this.m.size()) {
                iArr[i6] = this.m.elementAt(i6);
                i = i6 + 1;
            } else {
                return new btq(this.c, iArr, e);
            }
        }
    }
}
