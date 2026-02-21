package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class bhi {
    static final /* synthetic */ boolean d;
    long b;
    final a c;
    private final int e;
    private final bhh f;
    private final List<bgw> g;
    private List<bgw> h;
    private final b i;
    long a = 0;
    private final c j = new c();
    private final c k = new c();
    private bgt l = null;

    static {
        d = !bhi.class.desiredAssertionStatus();
    }

    bhi(int i, bhh bhhVar, boolean z, boolean z2, List<bgw> list) {
        if (bhhVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.e = i;
        this.f = bhhVar;
        this.b = bhhVar.f.e(65536);
        this.i = new b(bhhVar.e.e(65536));
        this.c = new a();
        this.i.g = z2;
        this.c.e = z;
        this.g = list;
    }

    public int a() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean b() {
        /*
            r2 = this;
            r0 = 0
            monitor-enter(r2)
            bgt r1 = r2.l     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L8
        L6:
            monitor-exit(r2)
            return r0
        L8:
            bhi$b r1 = r2.i     // Catch: java.lang.Throwable -> L2e
            boolean r1 = bhi.b.a(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L18
            bhi$b r1 = r2.i     // Catch: java.lang.Throwable -> L2e
            boolean r1 = bhi.b.b(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L2c
        L18:
            bhi$a r1 = r2.c     // Catch: java.lang.Throwable -> L2e
            boolean r1 = bhi.a.a(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L28
            bhi$a r1 = r2.c     // Catch: java.lang.Throwable -> L2e
            boolean r1 = bhi.a.b(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L2c
        L28:
            java.util.List<bgw> r1 = r2.h     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L6
        L2c:
            r0 = 1
            goto L6
        L2e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bhi.b():boolean");
    }

    public boolean c() {
        return this.f.b == ((this.e & 1) == 1);
    }

    public synchronized List<bgw> d() {
        this.j.c();
        while (this.h == null && this.l == null) {
            try {
                k();
            } catch (Throwable th) {
                this.j.b();
                throw th;
            }
        }
        this.j.b();
        if (this.h == null) {
            throw new IOException("stream was reset: " + this.l);
        }
        return this.h;
    }

    public brj e() {
        return this.j;
    }

    public bri f() {
        return this.i;
    }

    public brh g() {
        synchronized (this) {
            if (this.h == null && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.c;
    }

    public void a(bgt bgtVar) {
        if (d(bgtVar)) {
            this.f.b(this.e, bgtVar);
        }
    }

    public void b(bgt bgtVar) {
        if (d(bgtVar)) {
            this.f.a(this.e, bgtVar);
        }
    }

    private boolean d(bgt bgtVar) {
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.i.g && this.c.e) {
                return false;
            }
            this.l = bgtVar;
            notifyAll();
            this.f.b(this.e);
            return true;
        }
    }

    void a(List<bgw> list, bgx bgxVar) {
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        bgt bgtVar = null;
        boolean zB = true;
        synchronized (this) {
            if (this.h == null) {
                if (bgxVar.c()) {
                    bgtVar = bgt.PROTOCOL_ERROR;
                } else {
                    this.h = list;
                    zB = b();
                    notifyAll();
                }
            } else if (bgxVar.d()) {
                bgtVar = bgt.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.h);
                arrayList.addAll(list);
                this.h = arrayList;
            }
        }
        if (bgtVar != null) {
            b(bgtVar);
        } else if (!zB) {
            this.f.b(this.e);
        }
    }

    void a(bqu bquVar, int i) {
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.i.a(bquVar, i);
    }

    void h() {
        boolean zB;
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.i.g = true;
            zB = b();
            notifyAll();
        }
        if (!zB) {
            this.f.b(this.e);
        }
    }

    synchronized void c(bgt bgtVar) {
        if (this.l == null) {
            this.l = bgtVar;
            notifyAll();
        }
    }

    final class b implements bri {
        static final /* synthetic */ boolean a;
        private final bqs c;
        private final bqs d;
        private final long e;
        private boolean f;
        private boolean g;

        static {
            a = !bhi.class.desiredAssertionStatus();
        }

        private b(long j) {
            this.c = new bqs();
            this.d = new bqs();
            this.e = j;
        }

        @Override // defpackage.bri
        public long a(bqs bqsVar, long j) {
            long jA;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (bhi.this) {
                b();
                c();
                if (this.d.b() == 0) {
                    jA = -1;
                } else {
                    jA = this.d.a(bqsVar, Math.min(j, this.d.b()));
                    bhi.this.a += jA;
                    if (bhi.this.a >= bhi.this.f.e.e(65536) / 2) {
                        bhi.this.f.a(bhi.this.e, bhi.this.a);
                        bhi.this.a = 0L;
                    }
                    synchronized (bhi.this.f) {
                        bhi.this.f.c += jA;
                        if (bhi.this.f.c >= bhi.this.f.e.e(65536) / 2) {
                            bhi.this.f.a(0, bhi.this.f.c);
                            bhi.this.f.c = 0L;
                        }
                    }
                }
            }
            return jA;
        }

        private void b() throws InterruptedIOException {
            bhi.this.j.c();
            while (this.d.b() == 0 && !this.g && !this.f && bhi.this.l == null) {
                try {
                    bhi.this.k();
                } finally {
                    bhi.this.j.b();
                }
            }
        }

        void a(bqu bquVar, long j) throws EOFException {
            boolean z;
            boolean z2;
            if (!a && Thread.holdsLock(bhi.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (bhi.this) {
                    z = this.g;
                    z2 = this.d.b() + j > this.e;
                }
                if (z2) {
                    bquVar.g(j);
                    bhi.this.b(bgt.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bquVar.g(j);
                    return;
                }
                long jA = bquVar.a(this.c, j);
                if (jA == -1) {
                    throw new EOFException();
                }
                j -= jA;
                synchronized (bhi.this) {
                    boolean z3 = this.d.b() == 0;
                    this.d.a(this.c);
                    if (z3) {
                        bhi.this.notifyAll();
                    }
                }
            }
        }

        @Override // defpackage.bri
        public brj a() {
            return bhi.this.j;
        }

        @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (bhi.this) {
                this.f = true;
                this.d.t();
                bhi.this.notifyAll();
            }
            bhi.this.i();
        }

        private void c() throws IOException {
            if (!this.f) {
                if (bhi.this.l != null) {
                    throw new IOException("stream was reset: " + bhi.this.l);
                }
                return;
            }
            throw new IOException("stream closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean z;
        boolean zB;
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.i.g && this.i.f && (this.c.e || this.c.d);
            zB = b();
        }
        if (z) {
            a(bgt.CANCEL);
        } else if (!zB) {
            this.f.b(this.e);
        }
    }

    final class a implements brh {
        static final /* synthetic */ boolean a;
        private final bqs c = new bqs();
        private boolean d;
        private boolean e;

        static {
            a = !bhi.class.desiredAssertionStatus();
        }

        a() {
        }

        @Override // defpackage.brh
        public void a_(bqs bqsVar, long j) throws InterruptedIOException {
            if (!a && Thread.holdsLock(bhi.this)) {
                throw new AssertionError();
            }
            this.c.a_(bqsVar, j);
            while (this.c.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws InterruptedIOException {
            long jMin;
            synchronized (bhi.this) {
                bhi.this.k.c();
                while (bhi.this.b <= 0 && !this.e && !this.d && bhi.this.l == null) {
                    try {
                        bhi.this.k();
                    } finally {
                    }
                }
                bhi.this.k.b();
                bhi.this.j();
                jMin = Math.min(bhi.this.b, this.c.b());
                bhi.this.b -= jMin;
            }
            bhi.this.k.c();
            try {
                bhi.this.f.a(bhi.this.e, z && jMin == this.c.b(), this.c, jMin);
            } finally {
            }
        }

        @Override // defpackage.brh, java.io.Flushable
        public void flush() throws InterruptedIOException {
            if (!a && Thread.holdsLock(bhi.this)) {
                throw new AssertionError();
            }
            synchronized (bhi.this) {
                bhi.this.j();
            }
            while (this.c.b() > 0) {
                a(false);
                bhi.this.f.d();
            }
        }

        @Override // defpackage.brh
        public brj a() {
            return bhi.this.k;
        }

        @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws InterruptedIOException {
            if (!a && Thread.holdsLock(bhi.this)) {
                throw new AssertionError();
            }
            synchronized (bhi.this) {
                if (!this.d) {
                    if (!bhi.this.c.e) {
                        if (this.c.b() > 0) {
                            while (this.c.b() > 0) {
                                a(true);
                            }
                        } else {
                            bhi.this.f.a(bhi.this.e, true, (bqs) null, 0L);
                        }
                    }
                    synchronized (bhi.this) {
                        this.d = true;
                    }
                    bhi.this.f.d();
                    bhi.this.i();
                }
            }
        }
    }

    void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws IOException {
        if (!this.c.d) {
            if (this.c.e) {
                throw new IOException("stream finished");
            }
            if (this.l != null) {
                throw new IOException("stream was reset: " + this.l);
            }
            return;
        }
        throw new IOException("stream closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    class c extends bqq {
        c() {
        }

        @Override // defpackage.bqq
        protected void a() {
            bhi.this.b(bgt.CANCEL);
        }

        public void b() throws InterruptedIOException {
            if (f_()) {
                throw new InterruptedIOException("timeout");
            }
        }
    }
}
