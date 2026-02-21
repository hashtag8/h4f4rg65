package defpackage;

import defpackage.bfi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class bgg implements bgr {
    private final bge a;
    private final bgc b;

    public bgg(bge bgeVar, bgc bgcVar) {
        this.a = bgeVar;
        this.b = bgcVar;
    }

    @Override // defpackage.bgr
    public brh a(bfg bfgVar, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(bfgVar.a(HTTP.TRANSFER_ENCODING))) {
            return this.b.h();
        }
        if (j != -1) {
            return this.b.a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // defpackage.bgr
    public void a() {
        this.b.d();
    }

    @Override // defpackage.bgr
    public void a(bgl bglVar) {
        this.b.a(bglVar);
    }

    @Override // defpackage.bgr
    public void a(bfg bfgVar) {
        this.a.b();
        this.b.a(bfgVar.e(), bgk.a(bfgVar, this.a.f().c().b().type(), this.a.f().l()));
    }

    @Override // defpackage.bgr
    public bfi.a b() {
        return this.b.g();
    }

    @Override // defpackage.bgr
    public void c() throws IOException {
        if (d()) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    @Override // defpackage.bgr
    public boolean d() {
        return ("close".equalsIgnoreCase(this.a.d().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(this.a.e().a(HTTP.CONN_DIRECTIVE)) || this.b.c()) ? false : true;
    }

    @Override // defpackage.bgr
    public bfj a(bfi bfiVar) {
        return new bgi(bfiVar.f(), brc.a(b(bfiVar)));
    }

    private bri b(bfi bfiVar) {
        if (!bge.a(bfiVar)) {
            return this.b.b(0L);
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(bfiVar.a(HTTP.TRANSFER_ENCODING))) {
            return this.b.a(this.a);
        }
        long jA = bgh.a(bfiVar);
        if (jA != -1) {
            return this.b.b(jA);
        }
        return this.b.i();
    }
}
