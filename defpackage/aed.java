package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class aed extends aef {
    public aet d;
    public aeh e;

    protected abstract void b(Handler handler, int i);

    public abstract String z();

    public void a(Handler handler, int i) {
        b(handler, i);
        if (this.d != null) {
            this.d.a(this);
        }
    }

    public void C() {
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
    }
}
