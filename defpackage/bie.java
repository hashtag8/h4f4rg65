package defpackage;

import android.content.Context;
import android.net.Uri;
import defpackage.bep;
import defpackage.bfg;
import defpackage.bhv;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class bie implements bhv {
    private final bfe a;

    private static bfe a() {
        bfe bfeVar = new bfe();
        bfeVar.a(15000L, TimeUnit.MILLISECONDS);
        bfeVar.b(20000L, TimeUnit.MILLISECONDS);
        bfeVar.c(20000L, TimeUnit.MILLISECONDS);
        return bfeVar;
    }

    public bie(Context context) {
        this(bit.b(context));
    }

    public bie(File file) {
        this(file, bit.a(file));
    }

    public bie(File file, long j) {
        this(a());
        try {
            this.a.a(new beo(file, j));
        } catch (IOException e) {
        }
    }

    public bie(bfe bfeVar) {
        this.a = bfeVar;
    }

    @Override // defpackage.bhv
    public bhv.a a(Uri uri, int i) throws bhv.b {
        bep bepVarD = null;
        if (i != 0) {
            if (bic.c(i)) {
                bepVarD = bep.b;
            } else {
                bep.a aVar = new bep.a();
                if (!bic.a(i)) {
                    aVar.a();
                }
                if (!bic.b(i)) {
                    aVar.b();
                }
                bepVarD = aVar.d();
            }
        }
        bfg.a aVarA = new bfg.a().a(uri.toString());
        if (bepVarD != null) {
            aVarA.a(bepVarD);
        }
        bfi bfiVarA = this.a.a(aVarA.a()).a();
        int iC = bfiVarA.c();
        if (iC >= 300) {
            bfiVarA.g().close();
            throw new bhv.b(iC + " " + bfiVarA.d(), i, iC);
        }
        boolean z = bfiVarA.j() != null;
        bfj bfjVarG = bfiVarA.g();
        return new bhv.a(bfjVarG.c(), z, bfjVarG.a());
    }
}
