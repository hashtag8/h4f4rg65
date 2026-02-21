package defpackage;

/* JADX INFO: loaded from: classes.dex */
class qc {
    public final String a;
    public final String b;
    public final StackTraceElement[] c;
    public final qc d;

    public qc(Throwable th, qb qbVar) {
        this.a = th.getLocalizedMessage();
        this.b = th.getClass().getName();
        this.c = qbVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.d = cause != null ? new qc(cause, qbVar) : null;
    }
}
