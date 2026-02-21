package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bkn {
    private String a;
    private String b;

    public bkn(String str, String str2) {
        a(str);
        b(str2);
    }

    public bkn(String str) {
        int iIndexOf;
        a("");
        b("");
        if (str != null && (iIndexOf = str.indexOf(58)) >= 0) {
            String str2 = new String(str.getBytes(), 0, iIndexOf);
            String str3 = new String(str.getBytes(), iIndexOf + 1, (str.length() - iIndexOf) - 1);
            a(str2.trim());
            b(str3.trim());
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.a != null && this.a.length() > 0;
    }
}
