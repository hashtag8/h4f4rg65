package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class tt {
    private static volatile tj a;

    static {
        a(new us());
    }

    public static tj a() {
        return a;
    }

    public static void a(String str) {
        tu tuVarB = tu.b();
        if (tuVarB != null) {
            tuVarB.e(str);
        } else if (a(2)) {
            Log.w(uy.c.a(), str);
        }
        tj tjVar = a;
        if (tjVar != null) {
            tjVar.a(str);
        }
    }

    public static void a(String str, Object obj) {
        tu tuVarB = tu.b();
        if (tuVarB != null) {
            tuVarB.e(str, obj);
        } else if (a(3)) {
            Log.e(uy.c.a(), obj != null ? str + ":" + obj : str);
        }
        tj tjVar = a;
        if (tjVar != null) {
            tjVar.b(str);
        }
    }

    public static void a(tj tjVar) {
        a = tjVar;
    }

    public static boolean a(int i) {
        return a() != null && a().a() <= i;
    }
}
