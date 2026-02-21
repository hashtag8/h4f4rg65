package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class bqz extends brj {
    private brj a;

    public bqz(brj brjVar) {
        if (brjVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = brjVar;
    }

    public final brj a() {
        return this.a;
    }

    public final bqz a(brj brjVar) {
        if (brjVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = brjVar;
        return this;
    }

    @Override // defpackage.brj
    public brj a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    @Override // defpackage.brj
    public long g_() {
        return this.a.g_();
    }

    @Override // defpackage.brj
    public boolean h_() {
        return this.a.h_();
    }

    @Override // defpackage.brj
    public long d() {
        return this.a.d();
    }

    @Override // defpackage.brj
    public brj a(long j) {
        return this.a.a(j);
    }

    @Override // defpackage.brj
    public brj i_() {
        return this.a.i_();
    }

    @Override // defpackage.brj
    public brj f() {
        return this.a.f();
    }

    @Override // defpackage.brj
    public void g() throws InterruptedIOException {
        this.a.g();
    }
}
