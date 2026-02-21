package defpackage;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bjh implements bji, Serializable {
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    protected String i;
    protected List<String> j = null;

    public String a() {
        return "HTTP/1.1 200 OK";
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public String h() {
        return this.i;
    }

    public void g(String str) {
        this.i = str;
    }

    public void h(String str) {
        this.a = str;
    }

    public String i() {
        if (!this.h.contains("::")) {
            return this.h;
        }
        return this.h.substring(0, this.h.indexOf("::"));
    }

    public void i(String str) {
        this.h = str;
    }

    public void a(List<String> list) {
        this.j = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a()).append("\r\n");
        stringBuffer.append("CACHE-CONTROL: " + b()).append("\r\n");
        stringBuffer.append("DATE: " + c()).append("\r\n");
        stringBuffer.append("LOCATION: " + d()).append("\r\n");
        stringBuffer.append("SERVER: " + e()).append("\r\n");
        stringBuffer.append("ST: " + f()).append("\r\n");
        stringBuffer.append("EXT: " + g()).append("\r\n");
        stringBuffer.append("USN: " + i()).append("\r\n");
        stringBuffer.append("CONTENT-LENGTH: " + h()).append("\r\n");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}
