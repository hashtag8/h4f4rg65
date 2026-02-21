package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class arc {
    private Integer a;
    private int b;
    private Bundle c;
    private be d;
    private int e;
    private int f;
    private int g;
    private int h;

    public Integer a() {
        return this.a;
    }

    public arc a(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }

    public int b(int i) {
        return this.b == 0 ? i : this.b;
    }

    public arc c(int i) {
        this.b = i;
        return this;
    }

    public Bundle b() {
        return this.c;
    }

    public arc a(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public be a(be beVar) {
        return this.d == null ? beVar : this.d;
    }

    public arc b(be beVar) {
        this.d = beVar;
        return this;
    }

    public int c() {
        return this.e;
    }

    public arc d(int i) {
        this.e = i;
        return this;
    }

    public int d() {
        return this.f;
    }

    public arc e(int i) {
        this.f = i;
        return this;
    }

    public int e() {
        return this.g;
    }

    public arc f(int i) {
        this.g = i;
        return this;
    }

    public int f() {
        return this.h;
    }

    public arc g(int i) {
        this.h = i;
        return this;
    }
}
