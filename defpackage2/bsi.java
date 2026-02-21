package defpackage;

import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class bsi extends bsh {
    public abstract boolean a(int i, Writer writer);

    @Override // defpackage.bsh
    public final int a(CharSequence charSequence, int i, Writer writer) {
        return a(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }
}
