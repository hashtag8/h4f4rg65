package defpackage;

import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class bkp extends bko {
    private String a = null;
    private String b = null;
    private String c = "";
    private int d = -1;
    private bkr e = null;
    private Socket f = null;

    public bkp() {
        a("1.0");
    }

    public void j(String str) {
        this.a = str;
    }

    public String a() {
        return this.a != null ? this.a : a(0);
    }

    public boolean k(String str) {
        String strA = a();
        return strA != null && strA.equalsIgnoreCase(str);
    }

    public boolean p() {
        return k("HEAD");
    }

    public void b(String str, boolean z) {
        this.b = str;
        if (z) {
            this.b = bkm.c(this.b);
        }
    }

    public String q() {
        return this.b != null ? this.b : a(1);
    }

    public void l(String str) {
        this.c = str;
    }

    public String r() {
        return this.c;
    }

    public void c(int i) {
        this.d = i;
    }

    public int s() {
        return this.d;
    }

    public String t() {
        return d() ? a(2) : "HTTP/" + super.b();
    }

    public String u() {
        return a() + " " + q() + " " + t() + "\r\n";
    }

    public String v() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(u());
        stringBuffer.append(g());
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0139 A[Catch: IOException -> 0x0142, TryCatch #12 {IOException -> 0x0142, blocks: (B:55:0x0134, B:57:0x0139, B:59:0x013e), top: B:93:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013e A[Catch: IOException -> 0x0142, TRY_LEAVE, TryCatch #12 {IOException -> 0x0142, blocks: (B:55:0x0134, B:57:0x0139, B:59:0x013e), top: B:93:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.bkq a(java.lang.String r10, int r11, java.lang.String r12, java.lang.String r13, boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bkp.a(java.lang.String, int, java.lang.String, java.lang.String, boolean):bkq");
    }

    public bkq a(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, false);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(v());
        stringBuffer.append("\r\n");
        stringBuffer.append(i());
        return stringBuffer.toString();
    }
}
