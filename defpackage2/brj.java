package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class brj {
    public static final brj b = new brj() { // from class: brj.1
        @Override // defpackage.brj
        public brj a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // defpackage.brj
        public brj a(long j) {
            return this;
        }

        @Override // defpackage.brj
        public void g() {
        }
    };
    private boolean a;
    private long c;
    private long d;

    public brj a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long g_() {
        return this.d;
    }

    public boolean h_() {
        return this.a;
    }

    public long d() {
        if (this.a) {
            return this.c;
        }
        throw new IllegalStateException("No deadline");
    }

    public brj a(long j) {
        this.a = true;
        this.c = j;
        return this;
    }

    public brj i_() {
        this.d = 0L;
        return this;
    }

    public brj f() {
        this.a = false;
        return this;
    }

    public void g() throws InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.a && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
