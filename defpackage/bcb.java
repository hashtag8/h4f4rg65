package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public interface bcb {

    public interface e {
        bck a(bck bckVar);

        void b(bck bckVar);
    }

    bck a();

    bck b();

    bck h();

    public static class c extends IOException {
        public c(int i, String str) {
            super("HTTP error:" + i + " (" + str + ")");
        }
    }

    public static class d extends a {
        public d(String str, HttpResponse httpResponse) {
            super(httpResponse, str);
        }

        public d(Throwable th, HttpResponse httpResponse) {
            super(th, httpResponse);
        }
    }

    public static class a extends IOException {
        public final HttpResponse a;

        public a(HttpResponse httpResponse, String str) {
            super(httpResponse.getStatusLine().getStatusCode() + ": [" + httpResponse.getStatusLine().getReasonPhrase() + "] " + (str == null ? "" : str));
            this.a = httpResponse;
        }

        public a(Throwable th, HttpResponse httpResponse) {
            super(th == null ? null : th.toString());
            initCause(th);
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
