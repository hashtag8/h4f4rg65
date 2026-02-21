package defpackage;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class arb {
    public static int a = 12;
    public static int b = 6;
    public static int c = 12;
    public static int d = 6;
    public static int e = 6;
    public static int f = 4;
    public static int g = 6;
    public static int h = 4;
    public static int i = 4;
    public static int j = 6;
    public static int k = 4;
    public static int l = 6;
    public static int m = 6;
    public static int n = 6;
    public static int o = 6;
    public static int p = 6;
    public static int q = 6;
    private static arb r = new arb();

    public static boolean a(Set<adz> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        ady adyVar = new ady(-1);
        Iterator<adz> it = set.iterator();
        while (it.hasNext()) {
            adyVar.a(it.next());
        }
        return a(adyVar);
    }

    public static boolean a(ady adyVar) {
        if (adyVar == null) {
            return false;
        }
        switch (aog.a(adyVar.w())) {
            case "2.4GHz":
                if (b(adyVar)) {
                    if (adyVar.n() <= d) {
                    }
                    break;
                } else {
                    if (adyVar.n() <= f) {
                    }
                    break;
                }
                break;
            case "5GHz":
                if (b(adyVar)) {
                    if (adyVar.n() <= c) {
                    }
                    break;
                } else {
                    if (adyVar.n() <= e) {
                    }
                    break;
                }
                break;
        }
        return false;
    }

    private static boolean b(ady adyVar) {
        return adyVar.m() == 32;
    }
}
