package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class brf {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    brf f;
    brf g;

    brf() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    brf(brf brfVar) {
        this(brfVar.a, brfVar.b, brfVar.c);
        brfVar.d = true;
    }

    brf(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public brf a() {
        brf brfVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return brfVar;
    }

    public brf a(brf brfVar) {
        brfVar.g = this;
        brfVar.f = this.f;
        this.f.g = brfVar;
        this.f = brfVar;
        return brfVar;
    }

    public brf a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        brf brfVar = new brf(this);
        brfVar.c = brfVar.b + i;
        this.b += i;
        this.g.a(brfVar);
        return brfVar;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.e) {
            int i = this.c - this.b;
            if (i <= (this.g.d ? 0 : this.g.b) + (2048 - this.g.c)) {
                a(this.g, i);
                a();
                brg.a(this);
            }
        }
    }

    public void a(brf brfVar, int i) {
        if (!brfVar.e) {
            throw new IllegalArgumentException();
        }
        if (brfVar.c + i > 2048) {
            if (brfVar.d) {
                throw new IllegalArgumentException();
            }
            if ((brfVar.c + i) - brfVar.b > 2048) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(brfVar.a, brfVar.b, brfVar.a, 0, brfVar.c - brfVar.b);
            brfVar.c -= brfVar.b;
            brfVar.b = 0;
        }
        System.arraycopy(this.a, this.b, brfVar.a, brfVar.c, i);
        brfVar.c += i;
        this.b += i;
    }
}
