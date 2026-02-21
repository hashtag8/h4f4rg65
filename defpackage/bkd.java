package defpackage;

import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class bkd extends Vector {
    public bkc a(int i) {
        return (bkc) get(i);
    }

    public bkc a(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            bkc bkcVarA = a(i);
            String strA = bkcVarA.a();
            if (strA != null && strA.endsWith(str)) {
                return bkcVarA;
            }
        }
        return null;
    }
}
