package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class blt<T> extends bls<T> {
    private T a;

    public blt() {
        this(null);
    }

    public blt(blu<T> bluVar) {
        super(bluVar);
    }

    @Override // defpackage.bls
    protected T a(Context context) {
        return this.a;
    }

    @Override // defpackage.bls
    protected void a(Context context, T t) {
        this.a = t;
    }
}
