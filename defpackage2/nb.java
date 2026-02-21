package defpackage;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class nb implements bno {
    private final nr a;
    private final no b;

    public static nb a(nr nrVar) {
        return new nb(nrVar, new no(new bni(new nn(new bng(1000L, 8), 0.1d), new bnf(5))));
    }

    nb(nr nrVar, no noVar) {
        this.a = nrVar;
        this.b = noVar;
    }

    @Override // defpackage.bno
    public boolean a(List<File> list) {
        long jNanoTime = System.nanoTime();
        if (!this.b.a(jNanoTime)) {
            return false;
        }
        if (this.a.a(list)) {
            this.b.a();
            return true;
        }
        this.b.b(jNanoTime);
        return false;
    }
}
