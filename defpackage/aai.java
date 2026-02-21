package defpackage;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class aai implements aah {
    private static aai a;

    public static synchronized aah c() {
        if (a == null) {
            a = new aai();
        }
        return a;
    }

    @Override // defpackage.aah
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // defpackage.aah
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}
