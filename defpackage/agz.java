package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class agz {
    private int a;
    private Runnable b;
    private Handler c;

    public agz(int i, Runnable runnable, Handler handler) {
        this.a = i;
        this.b = runnable;
        this.c = handler;
        if (this.a == 0) {
            if (this.c != null) {
                this.c.post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void a() {
        this.a--;
        if (this.a == 0) {
            if (this.c != null) {
                this.c.post(this.b);
            } else {
                this.b.run();
            }
        }
    }
}
