package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class qu<T> {
    private Class<T> a;

    public qu(Class<T> cls) {
        this.a = null;
        if (cls == null) {
            throw new IllegalArgumentException("Clazz can't be null.");
        }
        this.a = cls;
    }

    public T a(String str) {
        return (T) new abw().a((aca) new acf().a(str).l(), (Class) this.a);
    }
}
