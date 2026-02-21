package defpackage;

/* JADX INFO: loaded from: classes.dex */
class se implements Runnable {
    private rz a;
    private boolean b = false;

    se(rz rzVar) {
        this.a = rzVar;
    }

    public void a() {
        this.b = true;
        zf.a.removeCallbacks(this);
    }

    public void b() {
        zf.a.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b) {
            return;
        }
        this.a.m();
        b();
    }
}
