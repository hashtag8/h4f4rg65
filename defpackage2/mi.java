package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class mi implements Serializable {
    protected int a;
    protected int b;
    protected int c;
    protected String d;

    public void a(String str) {
        this.d = str;
    }

    public void b(int i) {
        this.a = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.c = i;
    }
}
