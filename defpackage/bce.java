package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public enum bce {
    LIVE("api.soundcloud.com", "soundcloud.com"),
    LIVEV2("api-v2.soundcloud.com", "soundcloud.com"),
    SANDBOX("api.sandbox-soundcloud.com", "sandbox-soundcloud.com");

    public final HttpHost d;
    public final HttpHost e;
    public final HttpHost f;
    public final HttpHost g;

    bce(String str, String str2) {
        this.d = new HttpHost(str, 80, HttpHost.DEFAULT_SCHEME_NAME);
        this.e = new HttpHost(str, 443, "https");
        this.f = new HttpHost(str2, 80, HttpHost.DEFAULT_SCHEME_NAME);
        this.g = new HttpHost(str2, 443, "https");
    }

    public HttpHost a(boolean z) {
        return z ? this.e : this.d;
    }

    public HttpHost b(boolean z) {
        return z ? this.g : this.f;
    }

    public URI c(boolean z) {
        return b(a(z));
    }

    public URI d(boolean z) {
        return b(b(z));
    }

    public boolean a(HttpHost httpHost) {
        return (HttpHost.DEFAULT_SCHEME_NAME.equals(httpHost.getSchemeName()) || "https".equals(httpHost.getSchemeName())) && this.d.getHostName().equals(httpHost.getHostName());
    }

    private static URI b(HttpHost httpHost) {
        try {
            return new URI(httpHost.getSchemeName(), httpHost.getHostName(), null, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException();
        }
    }
}
