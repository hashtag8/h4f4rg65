package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class bkc {
    private bkc a;
    private String b;
    private String c;
    private bkb d;
    private bkd e;
    private Object f;

    public bkc() {
        this.a = null;
        this.b = new String();
        this.c = new String();
        this.d = new bkb();
        this.e = new bkd();
        this.f = null;
        a((Object) null);
        a((bkc) null);
    }

    public bkc(String str) {
        this();
        a(str);
    }

    public void a(bkc bkcVar) {
        this.a = bkcVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(String str, String str2) {
        this.b = str + ":" + str2;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d.size();
    }

    public bka a(int i) {
        return this.d.a(i);
    }

    public bka c(String str) {
        return this.d.a(str);
    }

    public void a(bka bkaVar) {
        this.d.add(bkaVar);
    }

    public void b(String str, String str2) {
        bka bkaVarC = c(str);
        if (bkaVarC != null) {
            bkaVarC.b(str2);
        } else {
            a(new bka(str, str2));
        }
    }

    public void c(String str, String str2) {
        b("xmlns:" + str, str2);
    }

    public int d() {
        return this.e.size();
    }

    public bkc b(int i) {
        return this.e.a(i);
    }

    public bkc d(String str) {
        return this.e.a(str);
    }

    public void b(bkc bkcVar) {
        bkcVar.a(this);
        this.e.add(bkcVar);
    }

    public boolean e() {
        return d() > 0;
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public String c(int i) {
        return a(i, "   ");
    }

    public String a(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public void a(PrintWriter printWriter) {
        int iC = c();
        for (int i = 0; i < iC; i++) {
            bka bkaVarA = a(i);
            printWriter.print(" " + bkaVarA.a() + "=\"" + bkg.a(bkaVarA.b()) + "\"");
        }
    }

    public void a(PrintWriter printWriter, int i, boolean z) {
        String strC = c(i);
        String strA = a();
        String strB = b();
        if (!e() || !z) {
            printWriter.print(strC + "<" + strA);
            a(printWriter);
            if (strB == null || strB.length() == 0) {
                printWriter.println("></" + strA + ">");
                return;
            } else {
                printWriter.println(">" + bkg.a(strB) + "</" + strA + ">");
                return;
            }
        }
        printWriter.print(strC + "<" + strA);
        a(printWriter);
        printWriter.println(">");
        int iD = d();
        for (int i2 = 0; i2 < iD; i2++) {
            b(i2).a(printWriter, i + 1, true);
        }
        printWriter.println(strC + "</" + strA + ">");
    }

    public String a(String str, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        a(printWriter, 0, z);
        printWriter.flush();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return byteArrayOutputStream.toString(str);
                }
            } catch (UnsupportedEncodingException e) {
            }
        }
        return byteArrayOutputStream.toString();
    }

    public String toString() {
        return a("utf-8", true);
    }
}
