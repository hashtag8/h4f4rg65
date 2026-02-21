package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class aop {
    private Context a;
    private String b;
    private Drawable c;
    private Drawable d;
    private int e;
    private int f = 14;
    private int g;

    public aop(Context context) {
        this.a = context;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(int i) {
        a(this.a.getString(i));
    }

    public Drawable d() {
        return this.c;
    }

    public Drawable e() {
        return this.d;
    }

    public void d(int i) {
        this.d = this.a.getResources().getDrawable(i);
    }

    public int f() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }
}
