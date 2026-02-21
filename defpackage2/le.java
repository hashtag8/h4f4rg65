package defpackage;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class le extends lx {
    private Intent b;

    public le() {
    }

    public le(ln lnVar) {
        super(lnVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
