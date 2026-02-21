package defpackage;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes.dex */
public final class bqw implements brh {
    private final bqt a;
    private final Deflater b;
    private boolean c;

    public bqw(brh brhVar, Deflater deflater) {
        this(brc.a(brhVar), deflater);
    }

    bqw(bqt bqtVar, Deflater deflater) {
        if (bqtVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = bqtVar;
        this.b = deflater;
    }

    @Override // defpackage.brh
    public void a_(bqs bqsVar, long j) {
        brk.a(bqsVar.b, 0L, j);
        while (j > 0) {
            brf brfVar = bqsVar.a;
            int iMin = (int) Math.min(j, brfVar.c - brfVar.b);
            this.b.setInput(brfVar.a, brfVar.b, iMin);
            a(false);
            bqsVar.b -= (long) iMin;
            brfVar.b += iMin;
            if (brfVar.b == brfVar.c) {
                bqsVar.a = brfVar.a();
                brg.a(brfVar);
            }
            j -= (long) iMin;
        }
    }

    @IgnoreJRERequirement
    private void a(boolean z) {
        brf brfVarE;
        bqs bqsVarC = this.a.c();
        while (true) {
            brfVarE = bqsVarC.e(1);
            int iDeflate = z ? this.b.deflate(brfVarE.a, brfVarE.c, 2048 - brfVarE.c, 2) : this.b.deflate(brfVarE.a, brfVarE.c, 2048 - brfVarE.c);
            if (iDeflate > 0) {
                brfVarE.c += iDeflate;
                bqsVarC.b += (long) iDeflate;
                this.a.v();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (brfVarE.b == brfVarE.c) {
            bqsVarC.a = brfVarE.a();
            brg.a(brfVarE);
        }
    }

    @Override // defpackage.brh, java.io.Flushable
    public void flush() {
        a(true);
        this.a.flush();
    }

    void b() {
        this.b.finish();
        a(false);
    }

    @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (!this.c) {
            Throwable th = null;
            try {
                b();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.end();
                th = th;
            } catch (Throwable th3) {
                th = th3;
                if (th != null) {
                    th = th;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.c = true;
            if (th != null) {
                brk.a(th);
            }
        }
    }

    @Override // defpackage.brh
    public brj a() {
        return this.a.a();
    }

    public String toString() {
        return "DeflaterSink(" + this.a + ")";
    }
}
