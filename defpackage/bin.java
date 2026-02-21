package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class bin {
    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final bhp b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    bin(bhp bhpVar) {
        this.b = bhpVar;
        this.a.start();
        bit.a(this.a.getLooper());
        this.c = new a(this.a.getLooper(), this);
    }

    void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    void a(long j) {
        this.c.sendMessage(this.c.obtainMessage(4, Long.valueOf(j)));
    }

    void a() {
        this.c.sendEmptyMessage(0);
    }

    void b() {
        this.c.sendEmptyMessage(1);
    }

    void c() {
        this.d++;
    }

    void d() {
        this.e++;
    }

    void a(Long l) {
        this.l++;
        this.f += l.longValue();
        this.i = a(this.l, this.f);
    }

    void b(long j) {
        this.m++;
        this.g += j;
        this.j = a(this.m, this.g);
    }

    void c(long j) {
        this.n++;
        this.h += j;
        this.k = a(this.m, this.h);
    }

    bio e() {
        return new bio(this.b.b(), this.b.a(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i) {
        this.c.sendMessage(this.c.obtainMessage(i, bit.a(bitmap), 0));
    }

    private static long a(int i, long j) {
        return j / ((long) i);
    }

    static class a extends Handler {
        private final bin a;

        public a(Looper looper, bin binVar) {
            super(looper);
            this.a = binVar;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.a.c();
                    break;
                case 1:
                    this.a.d();
                    break;
                case 2:
                    this.a.b(message.arg1);
                    break;
                case 3:
                    this.a.c(message.arg1);
                    break;
                case 4:
                    this.a.a((Long) message.obj);
                    break;
                default:
                    bif.a.post(new Runnable() { // from class: bin.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    break;
            }
        }
    }
}
