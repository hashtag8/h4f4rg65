package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bkq extends bko {
    private int a = 0;

    public bkq() {
        a("1.1");
        g("text/html; charset=\"utf-8\"");
        f("");
    }

    public bkq(bkq bkqVar) {
        a(bkqVar);
    }

    public void c(int i) {
        this.a = i;
    }

    public int p() {
        if (this.a != 0) {
            return this.a;
        }
        return new bks(c()).a();
    }

    public boolean q() {
        return bks.c(p());
    }

    public String r() {
        return "HTTP/" + b() + " " + p() + " " + bks.a(this.a) + "\r\n";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(r());
        stringBuffer.append(g());
        stringBuffer.append("\r\n");
        stringBuffer.append(i());
        return stringBuffer.toString();
    }

    public void s() {
        bkx.a("Http Response " + toString());
    }
}
