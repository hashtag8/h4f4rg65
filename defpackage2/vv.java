package defpackage;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class vv {
    private final long a;
    private final int b;
    private final eg<String, Long> c;

    public vv() {
        this.a = 60000L;
        this.b = 10;
        this.c = new eg<>(10);
    }

    public vv(int i, long j) {
        this.a = j;
        this.b = i;
        this.c = new eg<>();
    }

    private void a(long j, long j2) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (j2 - this.c.c(size).longValue() > j) {
                this.c.d(size);
            }
        }
    }

    public Long a(String str) {
        Long lPut;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.a;
        synchronized (this) {
            while (this.c.size() >= this.b) {
                a(j, jElapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.b + " is not enough. Current durationThreshold is: " + j);
            }
            lPut = this.c.put(str, Long.valueOf(jElapsedRealtime));
        }
        return lPut;
    }

    public boolean b(String str) {
        boolean z;
        synchronized (this) {
            z = this.c.remove(str) != null;
        }
        return z;
    }
}
