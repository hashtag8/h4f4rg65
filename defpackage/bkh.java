package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class bkh extends bkk {
    public void a(bjl bjlVar, ArrayList<bjm> arrayList) {
        bjq bjqVarC = bjlVar.c();
        a(bjqVarC);
        a(bku.a());
        bkc bkcVarW = w();
        x().b(a(bjqVarC, bjlVar, arrayList));
        b(bkcVarW);
        m("\"" + bjqVarC.a() + "#" + bjlVar.a() + "\"");
    }

    private bkc a(bjq bjqVar, bjl bjlVar, ArrayList<bjm> arrayList) {
        String strA = bjlVar.a();
        String strA2 = bjqVar.a();
        bkc bkcVar = new bkc();
        bkcVar.a("u", strA);
        bkcVar.c("u", strA2);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bjm bjmVar = arrayList.get(i);
            bkc bkcVar2 = new bkc();
            bkcVar2.a(bjmVar.a());
            bkcVar2.b(bjmVar.c());
            bkcVar.b(bkcVar2);
        }
        return bkcVar;
    }

    public bki a(String str, String str2) {
        return new bki(b(r(), s(), str, str2));
    }
}
