package defpackage;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class bfo extends bqx {
    private boolean a;

    public bfo(brh brhVar) {
        super(brhVar);
    }

    @Override // defpackage.bqx, defpackage.brh
    public void a_(bqs bqsVar, long j) throws EOFException {
        if (this.a) {
            bqsVar.g(j);
            return;
        }
        try {
            super.a_(bqsVar, j);
        } catch (IOException e) {
            this.a = true;
            a(e);
        }
    }

    @Override // defpackage.bqx, defpackage.brh, java.io.Flushable
    public void flush() {
        if (!this.a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.a = true;
                a(e);
            }
        }
    }

    @Override // defpackage.bqx, defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.a) {
            try {
                super.close();
            } catch (IOException e) {
                this.a = true;
                a(e);
            }
        }
    }

    protected void a(IOException iOException) {
    }
}
