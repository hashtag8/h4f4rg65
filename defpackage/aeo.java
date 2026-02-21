package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class aeo implements aer {
    private final aev a;
    private aes b;
    private a d;
    private Handler e;
    private adx g;
    private boolean f = true;
    private HandlerThread c = new HandlerThread("ReceiveCommandHandlerThread");

    public aeo(aes aesVar, Handler handler, adx adxVar, aev aevVar) {
        this.a = aevVar;
        this.e = handler;
        this.b = aesVar;
        this.c.start();
        this.d = new a(this.c.getLooper());
        this.d.sendEmptyMessage(0);
        this.g = adxVar;
    }

    @Override // defpackage.aer
    public void a(byte[] bArr) throws Exception {
        this.a.b().a(bArr);
    }

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                mm.a((Object) ("---socket---receive handler -----start--- " + Thread.currentThread().getId()));
                byte[] bArrB = aeo.this.a.b().b();
                mm.a("---socket---receive handler -------- ", bArrB);
                if (aeo.this.b != null) {
                    aeo.this.b.a(-1L, bArrB);
                }
                aeo.this.d.sendEmptyMessage(0);
                mm.a((Object) ("---socket---receive handler ------end-- " + Thread.currentThread().getId()));
            } catch (IOException e) {
                e.printStackTrace();
                mm.a((Object) ("---socket---receive handler ------error-- " + Thread.currentThread().getId()));
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (aeo.this.f) {
                    aeo.this.e.sendMessage(aeo.this.e.obtainMessage(134, aeo.this.g));
                }
            }
        }
    }

    @Override // defpackage.aer
    public void a() {
        this.f = false;
        if (this.c != null) {
            this.c.quit();
        }
        if (this.d != null) {
            this.d.getLooper().quit();
        }
        if (this.b != null) {
            this.b = null;
        }
    }
}
