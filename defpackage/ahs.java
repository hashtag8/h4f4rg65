package defpackage;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class ahs {
    private Context b;
    private a c = null;
    private Object d = new Object();
    private boolean e = true;
    private boolean f = true;
    private int g = 0;
    private int h = 0;
    final Handler a = new Handler();

    public interface a {
    }

    public ahs(Context context) {
        this.b = context;
    }

    public void a(int i, int i2) {
        if (i <= i2) {
            this.g = i;
            this.h = i2;
        }
    }

    public void a() {
        this.e = false;
        this.f = false;
    }

    public void b() {
        this.e = true;
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }
}
