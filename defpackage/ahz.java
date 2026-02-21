package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ahz {
    public String b;
    public long e;
    public int a = -1;
    public int c = -1;
    public Object d = new Exception("HError built here");

    public String toString() {
        bsc bscVar = new bsc(this, new ahp());
        if (this.a != 0) {
            bscVar.a("id", this.a);
        }
        bscVar.a("msg", this.b);
        if (this.c != -1) {
            bscVar.a("rid", this.c);
        }
        if (this.e != 0) {
            bscVar.a("id", this.e);
        }
        if (this.d instanceof Throwable) {
            bscVar.a("object", bse.a((Throwable) this.d));
        } else {
            bscVar.a("object", this.d);
        }
        return bscVar.h();
    }
}
