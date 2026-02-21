package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class bls<T> implements blu<T> {
    private final blu<T> a;

    protected abstract T a(Context context);

    protected abstract void a(Context context, T t);

    public bls(blu<T> bluVar) {
        this.a = bluVar;
    }

    @Override // defpackage.blu
    public final synchronized T a(Context context, blv<T> blvVar) {
        T tA;
        tA = a(context);
        if (tA == null) {
            tA = this.a != null ? this.a.a(context, blvVar) : blvVar.b(context);
            b(context, tA);
        }
        return tA;
    }

    private void b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        a(context, t);
    }
}
