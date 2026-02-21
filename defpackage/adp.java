package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class adp<T> {
    final Class<? super T> a;
    final Type b;
    final int c;

    protected adp() {
        this.b = a(getClass());
        this.a = (Class<? super T>) acr.e(this.b);
        this.c = this.b.hashCode();
    }

    adp(Type type) {
        this.b = acr.d((Type) acq.a(type));
        this.a = (Class<? super T>) acr.e(this.b);
        this.c = this.b.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return acr.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.a;
    }

    public final Type b() {
        return this.b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof adp) && acr.a(this.b, ((adp) obj).b);
    }

    public final String toString() {
        return acr.f(this.b);
    }

    public static adp<?> a(Type type) {
        return new adp<>(type);
    }

    public static <T> adp<T> b(Class<T> cls) {
        return new adp<>(cls);
    }
}
