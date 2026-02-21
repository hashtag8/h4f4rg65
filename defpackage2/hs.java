package defpackage;

/* JADX INFO: loaded from: classes.dex */
class hs<T> {
    final T b;

    hs(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.b = t;
    }
}
