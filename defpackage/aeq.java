package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class aeq {
    protected Handler a;
    protected aed b;

    public abstract void a(aep aepVar);

    public abstract void b();

    public aeq(aed aedVar) {
        this.b = aedVar;
    }

    public aeq(Handler handler, aed aedVar) {
        this.a = handler;
        this.b = aedVar;
    }
}
