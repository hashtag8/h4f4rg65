package defpackage;

import android.os.SystemClock;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class aec<T> implements Serializable {
    private T a;
    private T b;
    private Long c;
    private Long d;

    public aec(T t) {
        this.a = t;
    }

    public void a(T t) {
        this.a = t;
        this.c = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public void b(T t) {
        this.b = t;
        this.d = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public T a() {
        return b() ? this.b : this.a;
    }

    private boolean b() {
        if (this.d == null) {
            return false;
        }
        return this.c == null || this.d.longValue() - this.c.longValue() > 5000;
    }

    public String toString() {
        return String.valueOf(a());
    }
}
