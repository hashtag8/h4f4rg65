package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class akm implements akl {

    @acn(a = "id")
    private long a;

    @acn(a = "title")
    private String b;

    @acn(a = "duration")
    private int c;

    @acn(a = "artist")
    private akh d;

    @acn(a = "album")
    private akg e;

    @acn(a = "timestamp")
    private Long g;

    @acn(a = "readable")
    private boolean f = true;

    @acn(a = "alternative")
    private akm h = null;

    public long a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        return this.b;
    }

    public akh d() {
        return this.d;
    }

    public void a(akh akhVar) {
        this.d = akhVar;
    }

    public akg e() {
        return this.e;
    }

    public void a(akg akgVar) {
        this.e = akgVar;
    }

    public boolean f() {
        if (this.f) {
            return true;
        }
        akm akmVarH = h();
        return akmVarH != null && akmVarH.f();
    }

    public Long g() {
        return this.g;
    }

    public akm h() {
        return this.h;
    }
}
