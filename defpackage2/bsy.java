package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class bsy implements btl {
    private static final Pattern a = Pattern.compile("^([\\x21-\\x39\\x3b-\\x7e]+):");
    private static final bte b = new bte();
    private final String c;
    private final String d;
    private final bup e;

    protected bsy(String str, String str2, bup bupVar) {
        this.c = str;
        this.d = str2;
        this.e = bupVar;
    }

    @Override // defpackage.bun
    public String getName() {
        return this.c;
    }

    @Override // defpackage.bun
    public bup getRaw() {
        return this.e;
    }

    @Override // defpackage.bun
    public String getBody() {
        return this.d;
    }

    public String toString() {
        return this.c + ": " + this.d;
    }
}
