package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class eh<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public eh() {
        this(10);
    }

    public eh(int i) {
        this.b = false;
        if (i == 0) {
            this.c = dw.a;
            this.d = dw.c;
        } else {
            int iA = dw.a(i);
            this.c = new int[iA];
            this.d = new Object[iA];
        }
        this.e = 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public eh<E> clone() {
        try {
            eh<E> ehVar = (eh) super.clone();
            try {
                ehVar.c = (int[]) this.c.clone();
                ehVar.d = (Object[]) this.d.clone();
                return ehVar;
            } catch (CloneNotSupportedException e) {
                return ehVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e) {
        int iA = dw.a(this.c, this.e, i);
        return (iA < 0 || this.d[iA] == a) ? e : (E) this.d[iA];
    }

    public void b(int i) {
        int iA = dw.a(this.c, this.e, i);
        if (iA >= 0 && this.d[iA] != a) {
            this.d[iA] = a;
            this.b = true;
        }
    }

    public void c(int i) {
        b(i);
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public void b(int i, E e) {
        int iA = dw.a(this.c, this.e, i);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == a) {
            this.c[iA2] = i;
            this.d[iA2] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            d();
            iA2 = dw.a(this.c, this.e, i) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iA3 = dw.a(this.e + 1);
            int[] iArr = new int[iA3];
            Object[] objArr = new Object[iA3];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            System.arraycopy(this.c, iA2, this.c, iA2 + 1, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, iA2 + 1, this.e - iA2);
        }
        this.c[iA2] = i;
        this.d[iA2] = e;
        this.e++;
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public int d(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E e(int i) {
        if (this.b) {
            d();
        }
        return (E) this.d[i];
    }

    public int f(int i) {
        if (this.b) {
            d();
        }
        return dw.a(this.c, this.e, i);
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int i, E e) {
        if (this.e != 0 && i <= this.c[this.e - 1]) {
            b(i, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            d();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int iA = dw.a(i2 + 1);
            int[] iArr = new int[iA];
            Object[] objArr = new Object[iA];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(d(i));
            sb.append('=');
            E e = e(i);
            if (e != this) {
                sb.append(e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
