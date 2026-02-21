package defpackage;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@yx
public abstract class zc {
    private final Runnable a = new Runnable() { // from class: zc.1
        @Override // java.lang.Runnable
        public final void run() {
            zc.this.b = Thread.currentThread();
            zc.this.a();
        }
    };
    private volatile Thread b;

    public abstract void a();

    public final Future b() {
        return ze.a(this.a);
    }
}
