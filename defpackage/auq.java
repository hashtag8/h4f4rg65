package defpackage;

import org.apache.http.client.methods.HttpUriRequest;

/* JADX INFO: loaded from: classes.dex */
public abstract class auq extends aul {
    private long c;
    private boolean d;

    public void a(HttpUriRequest httpUriRequest) {
        if (this.a.exists() && this.a.canWrite()) {
            this.c = this.a.length();
        }
        if (this.c > 0) {
            this.d = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.c + "-");
        }
    }
}
