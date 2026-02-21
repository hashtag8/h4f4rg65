package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class bjp implements Serializable {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i = "-1";
    private String j = "";
    private boolean k = false;

    public bjp() {
    }

    public bjp(int i, String str, String str2, String str3, String str4) {
        this.d = i;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e = str4;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        return this.b + ":" + this.a;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public void a(String str) {
        this.f = str;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    public void b(String str) {
        this.g = str;
    }

    public String g() {
        return this.g;
    }

    public void c(String str) {
        this.h = str;
    }

    public String h() {
        return this.h;
    }

    public void d(String str) {
        this.i = str;
    }

    public String i() {
        return this.i;
    }

    public void e(String str) {
        this.j = str;
    }

    public String j() {
        return this.j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bjp) && c() == ((bjp) obj).c();
    }
}
