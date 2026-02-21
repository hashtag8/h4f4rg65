package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sy {
    private static final Object a = new Object();
    private static sy b;
    private final so c = new so();
    private final rs d = new rs();
    private final rv e = new rv();
    private final yu f = new yu();
    private final zf g = new zf();
    private final zr h = new zr();
    private final zg i = zg.a(Build.VERSION.SDK_INT);
    private final za j = new za(this.g);
    private final aah k = new aai();
    private final xe l = new xe();
    private final yy m = new yy();
    private final wz n = new wz();
    private final wy o = new wy();
    private final xa p = new xa();
    private final sk q = new sk();
    private final xx r = new xx();
    private final xt s = new xt();

    static {
        a(new sy());
    }

    protected sy() {
    }

    public static rs a() {
        return l().d;
    }

    protected static void a(sy syVar) {
        synchronized (a) {
            b = syVar;
        }
    }

    public static rv b() {
        return l().e;
    }

    public static zf c() {
        return l().g;
    }

    public static zr d() {
        return l().h;
    }

    public static zg e() {
        return l().i;
    }

    public static za f() {
        return l().j;
    }

    public static aah g() {
        return l().k;
    }

    public static wy h() {
        return l().o;
    }

    public static xa i() {
        return l().p;
    }

    public static sk j() {
        return l().q;
    }

    public static xt k() {
        return l().s;
    }

    private static sy l() {
        sy syVar;
        synchronized (a) {
            syVar = b;
        }
        return syVar;
    }
}
