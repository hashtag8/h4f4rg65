package defpackage;

import defpackage.wl;

/* JADX INFO: loaded from: classes.dex */
public class aan<T> {
    public final T a;
    public final wl.a b;
    public final abj c;
    public boolean d;

    public interface a {
        void a(abj abjVar);
    }

    public interface b<T> {
        void a(T t);
    }

    private aan(abj abjVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = abjVar;
    }

    private aan(T t, wl.a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    public static <T> aan<T> a(abj abjVar) {
        return new aan<>(abjVar);
    }

    public static <T> aan<T> a(T t, wl.a aVar) {
        return new aan<>(t, aVar);
    }

    public boolean a() {
        return this.c == null;
    }
}
