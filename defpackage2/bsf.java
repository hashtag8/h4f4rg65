package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class bsf<T> implements Serializable {
    private T a;

    public bsf() {
    }

    public bsf(T t) {
        this.a = t;
    }

    public T a() {
        return this.a;
    }

    public void a(T t) {
        this.a = t;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.a.equals(((bsf) obj).a);
        }
        return false;
    }

    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }

    public String toString() {
        return this.a == null ? "null" : this.a.toString();
    }
}
