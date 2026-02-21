package defpackage;

import android.os.Bundle;
import com.harman.commom.util.error.ErrorInfo;

/* JADX INFO: loaded from: classes.dex */
class agr extends lx {
    private final ErrorInfo b;

    public agr(String str, ErrorInfo errorInfo) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putParcelable("caused_by", errorInfo);
        this.b = new ErrorInfo.a().a(bundle).a();
    }

    public agr(String str, Exception exc) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        this.b = new ErrorInfo.a().a(bundle).a((Throwable) exc).a();
    }

    public ErrorInfo a() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.b.toString();
    }
}
