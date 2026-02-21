package defpackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class bkr {
    private Socket a;
    private InputStream b;
    private OutputStream c;

    public void finalize() {
        b();
    }

    public Socket a() {
        return this.a;
    }

    public boolean b() {
        try {
            if (this.b != null) {
                this.b.close();
            }
            if (this.c != null) {
                this.c.close();
            }
            a().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
