package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zl<T> implements zm<T> {
    private final Object a = new Object();
    private T b = null;
    private boolean c = false;
    private boolean d = false;
    private final zn e = new zn();

    public void b(T t) {
        synchronized (this.a) {
            if (this.c) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.c = true;
            this.b = t;
            this.a.notifyAll();
            this.e.a();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.a) {
                if (!this.c) {
                    this.d = true;
                    this.c = true;
                    this.a.notifyAll();
                    this.e.a();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        T t;
        synchronized (this.a) {
            if (!this.c) {
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.a) {
            if (!this.c) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.a.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.c) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
            if (this.d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }
}
