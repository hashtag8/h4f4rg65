package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class bgj extends Exception {
    public bgj(IOException iOException) {
        super(iOException);
    }

    @Override // java.lang.Throwable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
