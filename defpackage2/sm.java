package defpackage;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sm {
    private final String a;

    public String a() {
        return sy.c().b();
    }

    public boolean a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String strB = sy.j().b(intent);
        String strC = sy.j().c(intent);
        if (strB == null || strC == null) {
            return false;
        }
        if (!str.equals(sy.j().a(strB))) {
            su.e("Developer payload not match.");
            return false;
        }
        if (this.a == null || sn.a(this.a, strB, strC)) {
            return true;
        }
        su.e("Fail to verify signature.");
        return false;
    }
}
