package defpackage;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public class auw extends aue {
    public auw() {
        super(false, 80, 443);
    }

    public auw(boolean z, int i, int i2) {
        super(z, i, i2);
    }

    @Override // defpackage.aue
    protected aur b(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, aut autVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        autVar.a(true);
        a(defaultHttpClient, httpContext, httpUriRequest, str, autVar, context).run();
        return new aur(null);
    }
}
