package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aay extends aas<aay> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public String a() {
        return this.a;
    }

    @Override // defpackage.aas
    public void a(aay aayVar) {
        if (!TextUtils.isEmpty(this.a)) {
            aayVar.a(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            aayVar.b(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            aayVar.c(this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            aayVar.d(this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            aayVar.e(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            aayVar.f(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            aayVar.g(this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            aayVar.h(this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            aayVar.i(this.i);
        }
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        aayVar.j(this.j);
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

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String h() {
        return this.h;
    }

    public void h(String str) {
        this.h = str;
    }

    public String i() {
        return this.i;
    }

    public void i(String str) {
        this.i = str;
    }

    public String j() {
        return this.j;
    }

    public void j(String str) {
        this.j = str;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("name", this.a);
        map.put("source", this.b);
        map.put("medium", this.c);
        map.put("keyword", this.d);
        map.put("content", this.e);
        map.put("id", this.f);
        map.put("adNetworkId", this.g);
        map.put("gclid", this.h);
        map.put("dclid", this.i);
        map.put("aclid", this.j);
        return a((Object) map);
    }
}
