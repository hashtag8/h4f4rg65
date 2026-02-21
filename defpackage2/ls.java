package defpackage;

import defpackage.lf;

/* JADX INFO: loaded from: classes.dex */
public class ls<T> {
    public final T a;
    public final lf.a b;
    public final lx c;
    public boolean d;

    public interface a {
        void a(lx lxVar);
    }

    public static <T> ls<T> a(T t, lf.a aVar) {
        return new ls<>(t, aVar);
    }

    public static <T> ls<T> a(lx lxVar) {
        return new ls<>(lxVar);
    }

    public boolean a() {
        return this.c == null;
    }

    private ls(T t, lf.a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    private ls(lx lxVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = lxVar;
    }
}
