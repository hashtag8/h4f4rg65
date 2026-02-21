package defpackage;

import java.util.ArrayList;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class bki extends bkl {
    private bkw a;

    public bki(bkw bkwVar) {
        super(bkwVar);
        this.a = bkwVar;
        c("EXT", "");
    }

    public void a(bjl bjlVar) {
        c(HttpStatus.SC_OK);
        u().b(b(bjlVar));
        b(t());
    }

    private bkc b(bjl bjlVar) {
        bkc bkcVar = new bkc("u:" + bjlVar.a() + "Response");
        bjq bjqVarC = bjlVar.c();
        if (bjqVarC != null) {
            bkcVar.b("xmlns:u", bjqVarC.a());
        }
        ArrayList<bjm> arrayListB = bjlVar.b();
        int size = arrayListB.size();
        for (int i = 0; i < size; i++) {
            bjm bjmVar = arrayListB.get(i);
            if (!bjmVar.d()) {
                bkc bkcVar2 = new bkc();
                bkcVar2.a(bjmVar.a());
                bkcVar2.b(bjmVar.c());
                bkcVar.b(bkcVar2);
            }
        }
        return bkcVar;
    }

    public bkw a() {
        return this.a;
    }
}
