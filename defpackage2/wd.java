package defpackage;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class wd extends abj {
    private Intent b;

    public wd() {
    }

    public wd(zo zoVar) {
        super(zoVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
