package defpackage;

import defpackage.bfa;
import defpackage.bfi;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bgc {
    private final bev a;
    private final beu b;
    private final Socket c;
    private final bqu d;
    private final bqt e;
    private int f = 0;
    private int g = 0;

    public bgc(bev bevVar, beu beuVar, Socket socket) {
        this.a = bevVar;
        this.b = beuVar;
        this.c = socket;
        this.d = brc.a(brc.b(socket));
        this.e = brc.a(brc.a(socket));
    }

    public void a(int i, int i2) {
        if (i != 0) {
            this.d.a().a(i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.e.a().a(i2, TimeUnit.MILLISECONDS);
        }
    }

    public void a() {
        this.g = 1;
        if (this.f == 0) {
            this.g = 0;
            bfp.b.a(this.a, this.b);
        }
    }

    public void b() throws IOException {
        this.g = 2;
        if (this.f == 0) {
            this.f = 6;
            this.b.d().close();
        }
    }

    public boolean c() {
        return this.f == 6;
    }

    public void d() {
        this.e.flush();
    }

    public long e() {
        return this.d.c().b();
    }

    public boolean f() {
        try {
            int soTimeout = this.c.getSoTimeout();
            try {
                this.c.setSoTimeout(1);
                if (this.d.f()) {
                    return false;
                }
                this.c.setSoTimeout(soTimeout);
                return true;
            } finally {
                this.c.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException e2) {
            return true;
        } catch (IOException e3) {
            return false;
        }
    }

    public void a(bfa bfaVar, String str) {
        if (this.f != 0) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.e.b(str).b("\r\n");
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            this.e.b(bfaVar.a(i)).b(": ").b(bfaVar.b(i)).b("\r\n");
        }
        this.e.b("\r\n");
        this.f = 1;
    }

    public bfi.a g() throws IOException {
        bgq bgqVarA;
        bfi.a aVarA;
        if (this.f != 1 && this.f != 3) {
            throw new IllegalStateException("state: " + this.f);
        }
        do {
            try {
                bgqVarA = bgq.a(this.d.r());
                aVarA = new bfi.a().a(bgqVarA.a).a(bgqVarA.b).a(bgqVarA.c);
                bfa.a aVar = new bfa.a();
                a(aVar);
                aVar.a(bgh.d, bgqVarA.a.toString());
                aVarA.a(aVar.a());
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.b + " (recycle count=" + bfp.b.b(this.b) + ")");
                iOException.initCause(e2);
                throw iOException;
            }
        } while (bgqVarA.b == 100);
        this.f = 4;
        return aVarA;
    }

    public void a(bfa.a aVar) {
        while (true) {
            String strR = this.d.r();
            if (strR.length() != 0) {
                bfp.b.a(aVar, strR);
            } else {
                return;
            }
        }
    }

    public brh h() {
        if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 2;
        return new b();
    }

    public brh a(long j) {
        if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 2;
        return new d(j);
    }

    public void a(bgl bglVar) {
        if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 3;
        bglVar.a(this.e);
    }

    public bri b(long j) {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 5;
        return new e(j);
    }

    public bri a(bge bgeVar) {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 5;
        return new c(bgeVar);
    }

    public bri i() {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 5;
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bqz bqzVar) {
        brj brjVarA = bqzVar.a();
        bqzVar.a(brj.b);
        brjVarA.f();
        brjVarA.i_();
    }

    final class d implements brh {
        private final bqz b;
        private boolean c;
        private long d;

        private d(long j) {
            this.b = new bqz(bgc.this.e.a());
            this.d = j;
        }

        @Override // defpackage.brh
        public brj a() {
            return this.b;
        }

        @Override // defpackage.brh
        public void a_(bqs bqsVar, long j) throws ProtocolException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            bfw.a(bqsVar.b(), 0L, j);
            if (j <= this.d) {
                bgc.this.e.a_(bqsVar, j);
                this.d -= j;
                return;
            }
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }

        @Override // defpackage.brh, java.io.Flushable
        public void flush() {
            if (!this.c) {
                bgc.this.e.flush();
            }
        }

        @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (!this.c) {
                this.c = true;
                if (this.d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                bgc.this.a(this.b);
                bgc.this.f = 3;
            }
        }
    }

    final class b implements brh {
        private final bqz b;
        private boolean c;

        private b() {
            this.b = new bqz(bgc.this.e.a());
        }

        @Override // defpackage.brh
        public brj a() {
            return this.b;
        }

        @Override // defpackage.brh
        public void a_(bqs bqsVar, long j) {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (j != 0) {
                bgc.this.e.j(j);
                bgc.this.e.b("\r\n");
                bgc.this.e.a_(bqsVar, j);
                bgc.this.e.b("\r\n");
            }
        }

        @Override // defpackage.brh, java.io.Flushable
        public synchronized void flush() {
            if (!this.c) {
                bgc.this.e.flush();
            }
        }

        @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (!this.c) {
                this.c = true;
                bgc.this.e.b("0\r\n\r\n");
                bgc.this.a(this.b);
                bgc.this.f = 3;
            }
        }
    }

    abstract class a implements bri {
        protected final bqz a;
        protected boolean b;

        private a() {
            this.a = new bqz(bgc.this.d.a());
        }

        @Override // defpackage.bri
        public brj a() {
            return this.a;
        }

        protected final void a(boolean z) throws IOException {
            if (bgc.this.f != 5) {
                throw new IllegalStateException("state: " + bgc.this.f);
            }
            bgc.this.a(this.a);
            bgc.this.f = 0;
            if (!z || bgc.this.g != 1) {
                if (bgc.this.g == 2) {
                    bgc.this.f = 6;
                    bgc.this.b.d().close();
                    return;
                }
                return;
            }
            bgc.this.g = 0;
            bfp.b.a(bgc.this.a, bgc.this.b);
        }

        protected final void b() {
            bfw.a(bgc.this.b.d());
            bgc.this.f = 6;
        }
    }

    class e extends a {
        private long e;

        public e(long j) {
            super();
            this.e = j;
            if (this.e == 0) {
                a(true);
            }
        }

        @Override // defpackage.bri
        public long a(bqs bqsVar, long j) throws ProtocolException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.e == 0) {
                return -1L;
            }
            long jA = bgc.this.d.a(bqsVar, Math.min(this.e, j));
            if (jA == -1) {
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= jA;
            if (this.e == 0) {
                a(true);
            }
            return jA;
        }

        @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.b) {
                if (this.e != 0 && !bfw.a(this, 100, TimeUnit.MILLISECONDS)) {
                    b();
                }
                this.b = true;
            }
        }
    }

    class c extends a {
        private long e;
        private boolean f;
        private final bge g;

        c(bge bgeVar) {
            super();
            this.e = -1L;
            this.f = true;
            this.g = bgeVar;
        }

        @Override // defpackage.bri
        public long a(bqs bqsVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f) {
                return -1L;
            }
            if (this.e == 0 || this.e == -1) {
                c();
                if (!this.f) {
                    return -1L;
                }
            }
            long jA = bgc.this.d.a(bqsVar, Math.min(j, this.e));
            if (jA == -1) {
                b();
                throw new IOException("unexpected end of stream");
            }
            this.e -= jA;
            return jA;
        }

        private void c() throws IOException {
            if (this.e != -1) {
                bgc.this.d.r();
            }
            try {
                this.e = bgc.this.d.o();
                String strTrim = bgc.this.d.r().trim();
                if (this.e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + strTrim + "\"");
                }
                if (this.e == 0) {
                    this.f = false;
                    bfa.a aVar = new bfa.a();
                    bgc.this.a(aVar);
                    this.g.a(aVar.a());
                    a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.b) {
                if (this.f && !bfw.a(this, 100, TimeUnit.MILLISECONDS)) {
                    b();
                }
                this.b = true;
            }
        }
    }

    class f extends a {
        private boolean e;

        private f() {
            super();
        }

        @Override // defpackage.bri
        public long a(bqs bqsVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.e) {
                return -1L;
            }
            long jA = bgc.this.d.a(bqsVar, j);
            if (jA != -1) {
                return jA;
            }
            this.e = true;
            a(false);
            return -1L;
        }

        @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.b) {
                if (!this.e) {
                    b();
                }
                this.b = true;
            }
        }
    }
}
