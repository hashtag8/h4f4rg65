package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class us implements tj {
    private int a = 2;
    private boolean b;

    us() {
    }

    @Override // defpackage.tj
    public int a() {
        return this.a;
    }

    @Override // defpackage.tj
    public void a(int i) {
        this.a = i;
        if (this.b) {
            return;
        }
        Log.i(uy.c.a(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + uy.c.a() + " DEBUG");
        this.b = true;
    }

    @Override // defpackage.tj
    public void a(String str) {
    }

    @Override // defpackage.tj
    public void b(String str) {
    }
}
