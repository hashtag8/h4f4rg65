package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class bjm implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String c() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public boolean d() {
        String strB = b();
        return strB != null && strB.equalsIgnoreCase("in");
    }

    public boolean equals(Object obj) {
        return this.a.equals(obj.toString());
    }
}
