package defpackage;

/* JADX INFO: loaded from: classes.dex */
@yx
public class rj {
    private static final Object a = new Object();
    private static rj b;
    private final st c = new st();
    private final rg d = new rg();
    private final rk e = new rk();
    private final rc f = new rc();
    private final xg g = new xg();
    private final sq h = new sq();

    static {
        a(new rj());
    }

    protected rj() {
    }

    public static st a() {
        return b().c;
    }

    protected static void a(rj rjVar) {
        synchronized (a) {
            b = rjVar;
        }
    }

    private static rj b() {
        rj rjVar;
        synchronized (a) {
            rjVar = b;
        }
        return rjVar;
    }
}
