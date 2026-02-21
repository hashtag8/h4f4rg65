package defpackage;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class bmq {
    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    public bmq(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = !Log.isLoggable(str2, 2);
    }

    public synchronized void a() {
        if (!this.c) {
            this.d = SystemClock.elapsedRealtime();
            this.e = 0L;
        }
    }

    public synchronized void b() {
        if (!this.c && this.e == 0) {
            this.e = SystemClock.elapsedRealtime() - this.d;
            c();
        }
    }

    private void c() {
        Log.v(this.b, this.a + ": " + this.e + "ms");
    }
}
