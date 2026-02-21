package defpackage;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xs extends zc {
    final zp a;
    final xu b;
    private final String c;

    xs(zp zpVar, String str) {
        this.a = zpVar;
        this.b = new xu(zpVar);
        this.c = str;
        sy.k().a(this);
    }

    @Override // defpackage.zc
    public void a() {
        try {
            this.b.a(this.c);
        } finally {
            zf.a.post(new Runnable() { // from class: xs.1
                @Override // java.lang.Runnable
                public void run() {
                    sy.k().b(xs.this);
                }
            });
        }
    }
}
