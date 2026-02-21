package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class lc {
    private static Handler a;
    private static Handler c;
    private static Object e = new Object();
    private Thread d;
    private boolean f = false;
    private Thread b = new Thread() { // from class: lc.1
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Looper.prepare();
                lc.a = new Handler() { // from class: lc.1.1
                    @Override // android.os.Handler
                    public void dispatchMessage(Message message) {
                        removeMessages(message.what);
                        super.dispatchMessage(message);
                    }
                };
                Looper.loop();
            } catch (Throwable th) {
                Log.e("", "halted due to an error", th);
            }
        }
    };

    public lc() {
        this.b.start();
        this.d = new Thread() { // from class: lc.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    lc.c = new Handler() { // from class: lc.2.1
                    };
                    lc.this.f = true;
                    synchronized (lc.e) {
                        lc.e.notify();
                    }
                    Looper.loop();
                } catch (Throwable th) {
                    Log.e("", "halted due to an error", th);
                }
            }
        };
        this.d.start();
        if (!this.f) {
            synchronized (e) {
                try {
                    e.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
