package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class bjd implements bji {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private List<String> h = null;

    public abstract String e();

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public String b() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String c() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public String d() {
        return this.b;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.d = str;
    }

    public void a(List<String> list) {
        this.h = list;
    }
}
