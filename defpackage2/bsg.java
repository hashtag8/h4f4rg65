package defpackage;

import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class bsg extends bsh {
    private final bsh[] a;

    public bsg(bsh... bshVarArr) {
        this.a = (bsh[]) bro.a(bshVarArr);
    }

    @Override // defpackage.bsh
    public int a(CharSequence charSequence, int i, Writer writer) {
        for (bsh bshVar : this.a) {
            int iA = bshVar.a(charSequence, i, writer);
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
