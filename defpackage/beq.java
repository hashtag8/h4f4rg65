package defpackage;

import defpackage.bfc;
import defpackage.bfg;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class beq {
    volatile boolean a;
    bfg b;
    bge c;
    private final bfe d;
    private boolean e;

    beq(bfe bfeVar, bfg bfgVar) {
        this.d = bfeVar.w();
        this.b = bfgVar;
    }

    public bfi a() {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        try {
            this.d.r().a(this);
            bfi bfiVarA = a(false);
            if (bfiVarA == null) {
                throw new IOException("Canceled");
            }
            return bfiVarA;
        } finally {
            this.d.r().b(this);
        }
    }

    private bfi a(boolean z) {
        return new a(0, this.b, z).a(this.b);
    }

    class a implements bfc.a {
        private final int b;
        private final bfg c;
        private final boolean d;

        a(int i, bfg bfgVar, boolean z) {
            this.b = i;
            this.c = bfgVar;
            this.d = z;
        }

        @Override // bfc.a
        public bfi a(bfg bfgVar) {
            if (this.b >= beq.this.d.u().size()) {
                return beq.this.a(bfgVar, this.d);
            }
            return beq.this.d.u().get(this.b).a(beq.this.new a(this.b + 1, bfgVar, this.d));
        }
    }

    bfi a(bfg bfgVar, boolean z) throws IOException {
        bfg bfgVarA;
        bfi bfiVarE;
        bfg bfgVarK;
        bfh bfhVarF = bfgVar.f();
        if (bfhVarF != null) {
            bfg.a aVarG = bfgVar.g();
            bfd bfdVarA = bfhVarF.a();
            if (bfdVarA != null) {
                aVarG.a("Content-Type", bfdVarA.toString());
            }
            long jB = bfhVarF.b();
            if (jB != -1) {
                aVarG.a(HTTP.CONTENT_LEN, Long.toString(jB));
                aVarG.b(HTTP.TRANSFER_ENCODING);
            } else {
                aVarG.a(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
                aVarG.b(HTTP.CONTENT_LEN);
            }
            bfgVarA = aVarG.a();
        } else {
            bfgVarA = bfgVar;
        }
        this.c = new bge(this.d, bfgVarA, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.a) {
            try {
                this.c.a();
                this.c.j();
                bfiVarE = this.c.e();
                bfgVarK = this.c.k();
            } catch (bgj e) {
                throw e.getCause();
            } catch (bgm e2) {
                bge bgeVarA = this.c.a(e2);
                if (bgeVarA != null) {
                    this.c = bgeVarA;
                } else {
                    throw e2.a();
                }
            } catch (IOException e3) {
                bge bgeVarA2 = this.c.a(e3, (brh) null);
                if (bgeVarA2 != null) {
                    this.c = bgeVarA2;
                } else {
                    throw e3;
                }
            }
            if (bfgVarK == null) {
                if (!z) {
                    this.c.h();
                }
                return bfiVarE;
            }
            int i2 = i + 1;
            if (i2 > 20) {
                throw new ProtocolException("Too many follow-up requests: " + i2);
            }
            if (!this.c.b(bfgVarK.a())) {
                this.c.h();
            }
            this.c = new bge(this.d, bfgVarK, false, false, z, this.c.i(), null, null, bfiVarE);
            i = i2;
        }
        this.c.h();
        throw new IOException("Canceled");
    }
}
