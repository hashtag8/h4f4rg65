package defpackage;

import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class bkb extends Vector {
    public bka a(int i) {
        return (bka) get(i);
    }

    public bka a(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            bka bkaVarA = a(i);
            if (str.compareTo(bkaVarA.a()) == 0) {
                return bkaVarA;
            }
        }
        return null;
    }
}
