package defpackage;

import android.app.Activity;
import android.os.Bundle;
import defpackage.blf;
import defpackage.nu;

/* JADX INFO: loaded from: classes.dex */
class mz extends blf.b {
    private final ns a;
    private final nd b;

    public mz(ns nsVar, nd ndVar) {
        this.a = nsVar;
        this.b = ndVar;
    }

    @Override // blf.b
    public void a(Activity activity, Bundle bundle) {
    }

    @Override // blf.b
    public void a(Activity activity) {
        this.a.a(activity, nu.b.START);
    }

    @Override // blf.b
    public void b(Activity activity) {
        this.a.a(activity, nu.b.RESUME);
        this.b.a();
    }

    @Override // blf.b
    public void c(Activity activity) {
        this.a.a(activity, nu.b.PAUSE);
        this.b.b();
    }

    @Override // blf.b
    public void d(Activity activity) {
        this.a.a(activity, nu.b.STOP);
    }

    @Override // blf.b
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // blf.b
    public void e(Activity activity) {
    }
}
