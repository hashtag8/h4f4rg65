package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public interface bab {

    public interface d {
        bak b(bak bakVar);

        void c(bak bakVar);
    }

    bak a();

    bak b();

    bak h();

    public static class c extends IOException {
        public c(int i, String str) {
            super("HTTP error:" + i + " (" + str + ")");
        }
    }

    public static class a extends IOException {
        public final HttpResponse a;

        public a(HttpResponse httpResponse, String str) {
            super(httpResponse.getStatusLine().getStatusCode() + ": [" + httpResponse.getStatusLine().getReasonPhrase() + "] " + (str == null ? "" : str));
            this.a = httpResponse;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return super.getMessage() + " " + (this.a != null ? this.a.getStatusLine() : "");
        }
    }

    public static class b extends IOException {
        b(Throwable th) {
            super(th == null ? null : th.toString());
            initCause(th);
        }
    }
}
