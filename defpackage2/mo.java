package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class mo extends Handler {
    public static final mo a = new mo(Looper.getMainLooper());

    public mo(Looper looper) {
        super(looper);
    }

    public boolean a(Runnable runnable) {
        if (Looper.myLooper() != getLooper()) {
            return post(runnable);
        }
        runnable.run();
        return true;
    }
}
