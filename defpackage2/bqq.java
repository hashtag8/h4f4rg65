package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public class bqq extends brj {
    private static bqq a;
    private boolean c;
    private bqq d;
    private long e;

    public final void c() {
        if (this.c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jG_ = g_();
        boolean zH_ = h_();
        if (jG_ != 0 || zH_) {
            this.c = true;
            a(this, jG_, zH_);
        }
    }

    private static synchronized void a(bqq bqqVar, long j, boolean z) {
        if (a == null) {
            a = new bqq();
            new a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            bqqVar.e = Math.min(j, bqqVar.d() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            bqqVar.e = jNanoTime + j;
        } else if (z) {
            bqqVar.e = bqqVar.d();
        } else {
            throw new AssertionError();
        }
        long jB = bqqVar.b(jNanoTime);
        bqq bqqVar2 = a;
        while (bqqVar2.d != null && jB >= bqqVar2.d.b(jNanoTime)) {
            bqqVar2 = bqqVar2.d;
        }
        bqqVar.d = bqqVar2.d;
        bqqVar2.d = bqqVar;
        if (bqqVar2 == a) {
            bqq.class.notify();
        }
    }

    public final boolean f_() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        r0.d = r3.d;
        r3.d = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized boolean a(defpackage.bqq r3) {
        /*
            java.lang.Class<bqq> r1 = defpackage.bqq.class
            monitor-enter(r1)
            bqq r0 = defpackage.bqq.a     // Catch: java.lang.Throwable -> L1a
        L5:
            if (r0 == 0) goto L18
            bqq r2 = r0.d     // Catch: java.lang.Throwable -> L1a
            if (r2 != r3) goto L15
            bqq r2 = r3.d     // Catch: java.lang.Throwable -> L1a
            r0.d = r2     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            r3.d = r0     // Catch: java.lang.Throwable -> L1a
            r0 = 0
        L13:
            monitor-exit(r1)
            return r0
        L15:
            bqq r0 = r0.d     // Catch: java.lang.Throwable -> L1a
            goto L5
        L18:
            r0 = 1
            goto L13
        L1a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bqq.a(bqq):boolean");
    }

    private long b(long j) {
        return this.e - j;
    }

    protected void a() {
    }

    public final brh a(final brh brhVar) {
        return new brh() { // from class: bqq.1
            @Override // defpackage.brh
            public void a_(bqs bqsVar, long j) throws InterruptedIOException {
                bqq.this.c();
                try {
                    try {
                        brhVar.a_(bqsVar, j);
                        bqq.this.a(true);
                    } catch (IOException e) {
                        throw bqq.this.a(e);
                    }
                } catch (Throwable th) {
                    bqq.this.a(false);
                    throw th;
                }
            }

            @Override // defpackage.brh, java.io.Flushable
            public void flush() throws InterruptedIOException {
                bqq.this.c();
                try {
                    try {
                        brhVar.flush();
                        bqq.this.a(true);
                    } catch (IOException e) {
                        throw bqq.this.a(e);
                    }
                } catch (Throwable th) {
                    bqq.this.a(false);
                    throw th;
                }
            }

            @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws InterruptedIOException {
                bqq.this.c();
                try {
                    try {
                        brhVar.close();
                        bqq.this.a(true);
                    } catch (IOException e) {
                        throw bqq.this.a(e);
                    }
                } catch (Throwable th) {
                    bqq.this.a(false);
                    throw th;
                }
            }

            @Override // defpackage.brh
            public brj a() {
                return bqq.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + brhVar + ")";
            }
        };
    }

    public final bri a(final bri briVar) {
        return new bri() { // from class: bqq.2
            @Override // defpackage.bri
            public long a(bqs bqsVar, long j) throws InterruptedIOException {
                bqq.this.c();
                try {
                    try {
                        long jA = briVar.a(bqsVar, j);
                        bqq.this.a(true);
                        return jA;
                    } catch (IOException e) {
                        throw bqq.this.a(e);
                    }
                } catch (Throwable th) {
                    bqq.this.a(false);
                    throw th;
                }
            }

            @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws InterruptedIOException {
                try {
                    try {
                        briVar.close();
                        bqq.this.a(true);
                    } catch (IOException e) {
                        throw bqq.this.a(e);
                    }
                } catch (Throwable th) {
                    bqq.this.a(false);
                    throw th;
                }
            }

            @Override // defpackage.bri
            public brj a() {
                return bqq.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + briVar + ")";
            }
        };
    }

    final void a(boolean z) throws InterruptedIOException {
        if (f_() && z) {
            throw new InterruptedIOException("timeout");
        }
    }

    final IOException a(IOException iOException) {
        if (f_()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            interruptedIOException.initCause(iOException);
            return interruptedIOException;
        }
        return iOException;
    }

    static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    bqq bqqVarH = bqq.h();
                    if (bqqVarH != null) {
                        bqqVarH.a();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized bqq h() {
        bqq bqqVar = null;
        synchronized (bqq.class) {
            bqq bqqVar2 = a.d;
            if (bqqVar2 == null) {
                bqq.class.wait();
            } else {
                long jB = bqqVar2.b(System.nanoTime());
                if (jB > 0) {
                    long j = jB / 1000000;
                    bqq.class.wait(j, (int) (jB - (1000000 * j)));
                } else {
                    a.d = bqqVar2.d;
                    bqqVar2.d = null;
                    bqqVar = bqqVar2;
                }
            }
        }
        return bqqVar;
    }
}
