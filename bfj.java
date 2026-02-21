package defpackage;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class bfj implements Closeable {
    public abstract long a();

    public abstract bqu b();

    public final InputStream c() {
        return b().g();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b().close();
    }
}
