package defpackage;

import defpackage.qr;

/* JADX INFO: loaded from: classes.dex */
public abstract class qp implements qs {
    private qr.a a;
    private String b;
    private String c;
    private String d;
    private String e;

    public qp(qr.a aVar, String str, String str2, String str3, String str4) {
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    @Override // defpackage.qs
    public final qr.a a() {
        return this.a;
    }

    @Override // defpackage.qs
    public final String b() {
        return this.b;
    }

    @Override // defpackage.qs
    public final String c() {
        return this.c;
    }

    @Override // defpackage.qs
    public final String d() {
        return this.e;
    }
}
