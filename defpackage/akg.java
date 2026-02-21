package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class akg implements akl {

    @acn(a = "title")
    private String c;

    @acn(a = "cover")
    private String d;

    @acn(a = "artist")
    private akh e;

    @acn(a = "timestamp")
    private Long i;

    @acn(a = "listTrack")
    private List<akm> a = new ArrayList();

    @acn(a = "id")
    private long b = -1;

    @acn(a = "available")
    private boolean f = true;

    @acn(a = "alternative")
    private akg g = null;

    @acn(a = "record_type")
    private String h = null;

    public String a() {
        return this.h;
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d + "?size=big";
    }

    public String e() {
        return this.d + "?size=big";
    }

    public akh f() {
        return this.e;
    }

    public void a(akh akhVar) {
        this.e = akhVar;
    }

    public Long g() {
        return this.i;
    }

    public boolean h() {
        return this.f;
    }

    public akg i() {
        return this.g;
    }
}
