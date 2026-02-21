package defpackage;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class btu implements btv {
    private static int[] m;
    public btw a;
    bty b;
    public btz d;
    private String f;
    private String g;
    private int[] o;
    private List<String> h = new ArrayList();
    private List<String> i = new ArrayList();
    private final int[] l = new int[3];
    private Vector<int[]> n = new Vector<>();
    private int p = -1;
    public btz c = new btz();
    private int j = -1;
    private int k = 0;

    public String a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }

    public List<String> c() {
        return this.h;
    }

    public List<String> d() {
        return this.i;
    }

    public final void e() throws btx {
        f();
        a(0);
    }

    public final void f() throws btx {
        btz btzVarA = a(21);
        a(3);
        btz btzVarA2 = a(21);
        this.f = btzVarA.f;
        this.g = btzVarA2.f;
        while (true) {
            switch (this.j == -1 ? k() : this.j) {
                case 4:
                    a(4);
                    g();
                    break;
                default:
                    this.l[1] = this.k;
                    return;
            }
        }
    }

    public final void g() throws btx {
        btz btzVarA = a(21);
        a(5);
        String strH = h();
        this.h.add(btzVarA.f);
        this.i.add(strH);
    }

    public final String h() throws btx {
        btz btzVarA;
        switch (this.j == -1 ? k() : this.j) {
            case 19:
                btzVarA = a(19);
                break;
            case 20:
                btzVarA = a(20);
                break;
            case 21:
                btzVarA = a(21);
                break;
            default:
                this.l[2] = this.k;
                a(-1);
                throw new btx();
        }
        return btzVarA.f;
    }

    static {
        j();
    }

    private static void j() {
        m = new int[]{2, 16, 3670016};
    }

    public btu(Reader reader) {
        this.b = new bty(reader, 1, 1);
        this.a = new btw(this.b);
        for (int i = 0; i < 3; i++) {
            this.l[i] = -1;
        }
    }

    private final btz a(int i) throws btx {
        btz btzVar = this.c;
        if (btzVar.g != null) {
            this.c = this.c.g;
        } else {
            btz btzVar2 = this.c;
            btz btzVarB = this.a.b();
            btzVar2.g = btzVarB;
            this.c = btzVarB;
        }
        this.j = -1;
        if (this.c.a == i) {
            this.k++;
            return this.c;
        }
        this.c = btzVar;
        this.p = i;
        throw i();
    }

    private final int k() {
        btz btzVar = this.c.g;
        this.d = btzVar;
        if (btzVar == null) {
            btz btzVar2 = this.c;
            btz btzVarB = this.a.b();
            btzVar2.g = btzVarB;
            int i = btzVarB.a;
            this.j = i;
            return i;
        }
        int i2 = this.d.a;
        this.j = i2;
        return i2;
    }

    public btx i() {
        int i = 0;
        this.n.removeAllElements();
        boolean[] zArr = new boolean[24];
        for (int i2 = 0; i2 < 24; i2++) {
            zArr[i2] = false;
        }
        if (this.p >= 0) {
            zArr[this.p] = true;
            this.p = -1;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.l[i3] == this.k) {
                for (int i4 = 0; i4 < 32; i4++) {
                    if ((m[i3] & (1 << i4)) != 0) {
                        zArr[i4] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 24; i5++) {
            if (zArr[i5]) {
                this.o = new int[1];
                this.o[0] = i5;
                this.n.addElement(this.o);
            }
        }
        int[][] iArr = new int[this.n.size()][];
        while (true) {
            int i6 = i;
            if (i6 < this.n.size()) {
                iArr[i6] = this.n.elementAt(i6);
                i = i6 + 1;
            } else {
                return new btx(this.c, iArr, e);
            }
        }
    }
}
