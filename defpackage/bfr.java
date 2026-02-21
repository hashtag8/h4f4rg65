package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class bfr implements Runnable {
    protected final String a;

    protected abstract void a();

    public bfr(String str, Object... objArr) {
        this.a = String.format(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
