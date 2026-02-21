package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public enum bae {
    LIVE("www.rdio.com", "www.rdio.com");

    public final HttpHost b;
    public final HttpHost c;
    public final HttpHost d;
    public final HttpHost e;

    bae(String str, String str2) {
        this.b = new HttpHost(str, -1, HttpHost.DEFAULT_SCHEME_NAME);
        this.c = new HttpHost(str, -1, "https");
        this.d = new HttpHost(str2, -1, HttpHost.DEFAULT_SCHEME_NAME);
        this.e = new HttpHost(str2, -1, "https");
    }

    public HttpHost a(boolean z) {
        return z ? this.c : this.b;
    }

    public HttpHost b(boolean z) {
        return z ? this.e : this.d;
    }

    public URI c(boolean z) {
        return b(a(z));
    }

    public URI d(boolean z) {
        return b(b(z));
    }

    public boolean a(HttpHost httpHost) {
        return (HttpHost.DEFAULT_SCHEME_NAME.equals(httpHost.getSchemeName()) || "https".equals(httpHost.getSchemeName())) && this.b.getHostName().equals(httpHost.getHostName());
    }

    private static URI b(HttpHost httpHost) {
        try {
            return new URI(httpHost.getSchemeName(), httpHost.getHostName(), null, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException();
        }
    }
}
